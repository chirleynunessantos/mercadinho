package br.com.mercadinho.infra.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.mercadinho.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FiltroDeSeguranca extends OncePerRequestFilter {
	
	@Autowired
	TokenService tokenService;
	@Autowired
	UsuarioRepository repository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		var token = this.recuperarToken(request);

		if (token!=null) {
			var login = tokenService.buscaLogin(token);
			UserDetails usuario = repository.findByLogin(login);
			var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
		}else {
			filterChain.doFilter(request, response);
		}
	}

	private String recuperarToken(HttpServletRequest request) {

		var authHeader = request.getHeader("Authorization");
		if (authHeader == null)
			return null;
		return authHeader.replace("Bearer", "").trim();
	}

}
