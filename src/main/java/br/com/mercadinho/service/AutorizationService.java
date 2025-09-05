package br.com.mercadinho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.mercadinho.repository.UsuarioRepository;
//sempre que um usuario precisar logar esta classe vai ser chamada automaticamente
//Para o spring saber que essa classe deve ser chamada automaticamente devemos implementar UserDetailsService
// 
@Service
public class AutorizationService implements UserDetailsService { 
	
	@Autowired
	UsuarioRepository repository;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repository.findByLogin(username); // para o spring consutar esse usuario por login
	}

}
