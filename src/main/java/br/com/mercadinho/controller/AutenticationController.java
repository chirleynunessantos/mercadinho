package br.com.mercadinho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadinho.infra.security.TokenService;
import br.com.mercadinho.model.usuario.AutenticacaoDTO;
import br.com.mercadinho.model.usuario.LoginResponseDTO;
import br.com.mercadinho.model.usuario.RegistroDTO;
import br.com.mercadinho.model.usuario.Usuarios;
import br.com.mercadinho.repository.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AutenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private TokenService tokenService;
	@GetMapping("/login")
	public ResponseEntity login(@RequestBody @Validated AutenticacaoDTO autenticacao) {
	

		var usernamePassword = new UsernamePasswordAuthenticationToken(autenticacao.login(), autenticacao.senha());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.geradorToken((Usuarios) auth.getPrincipal());
		
		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/registrar")
	public ResponseEntity registrar(@RequestBody @Validated RegistroDTO registro) {
		UserDetails  u = this.repository.findByLogin(registro.login());
		boolean existe = this.repository.findByLogin(registro.login())!=null;
 		if(existe) 
 			return ResponseEntity.badRequest().build();

		String senhaCriptografada = new BCryptPasswordEncoder().encode(registro.senha());
		
		Usuarios novoUsuario = new Usuarios(
				registro.nomeCompleto(),
				registro.login(),
				senhaCriptografada,
				registro.cargo(), 
				registro.role());

		this.repository.save(novoUsuario);
		
		return ResponseEntity.ok().build();
	}
	
}
