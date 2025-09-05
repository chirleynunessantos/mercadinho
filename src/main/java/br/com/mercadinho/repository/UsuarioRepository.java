package br.com.mercadinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.mercadinho.model.usuario.Usuarios;

public interface UsuarioRepository  extends JpaRepository<Usuarios, String> {

		UserDetails findByLogin(String login);
}
