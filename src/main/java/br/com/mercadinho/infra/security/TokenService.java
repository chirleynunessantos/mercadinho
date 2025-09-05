package br.com.mercadinho.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.mercadinho.model.usuario.Usuarios;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;
	public String geradorToken(Usuarios usuario) {

		try {
			Algorithm algoritimo = Algorithm.HMAC256(secret);
			
			String token = JWT.create()
					.withIssuer("auth-api")
					.withSubject(usuario.getLogin())
					.withExpiresAt(tempoExpiracao())
					.sign(algoritimo);
			return token;
			
		}catch(JWTCreationException e) {
			throw new RuntimeException("Erro ao gerar o token "+ e);

		}		
	}
	
	public String buscaLogin(String token) {
		try {
			
			Algorithm algoritimo = Algorithm.HMAC256(secret);
			
			return JWT.require(algoritimo)
					.withIssuer("auth-api")
					.build()
					.verify(token.trim())
					.getSubject();
			
			
		} catch (JWTVerificationException e) {
			return "";
		}
	}
	
	private Instant  tempoExpiracao() {
		return LocalDateTime.now().plusHours(2)
				.toInstant(ZoneOffset.of("-03:00"));
				
	}
	
}
