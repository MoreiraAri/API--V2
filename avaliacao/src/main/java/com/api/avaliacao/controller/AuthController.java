// src/main/java/com/api/avaliacao/controller/AuthController.java
package com.api.avaliacao.controller;

import com.api.avaliacao.model.User;
import com.api.avaliacao.service.AuthService;
import com.api.avaliacao.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação", description = "Endpoints para login, registro e validação de tokens JWT")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @Operation(summary = "Realiza o login do usuário e emite um token JWT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Login bem-sucedido, retorna o token JWT"),
        @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    })
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        try {
            String token = authService.authenticateUserAndGenerateToken(username, password);
            return ResponseEntity.ok(token);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Ocorreu um erro interno ao tentar logar.");
        }
    }

    @Operation(summary = "Valida um token JWT (útil para debug e verificação externa)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Token válido"),
        @ApiResponse(responseCode = "401", description = "Token inválido ou expirado")
    })
    @PostMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam String token) {
        if (jwtService.validateToken(token)) {
            return ResponseEntity.ok("Token válido! Username: " + jwtService.getUsernameFromToken(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido ou expirado.");
        }
    }

    @Operation(summary = "Registra um novo usuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro na requisição")
    })
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam(defaultValue = "USER") String role
    ) {
        try {
            User user = authService.registerUser(username, password, role);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado: " + user.getUsername());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao registrar o usuário.");
        }
    }
}
