package br.com.mercadinho.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "usuarios")
@Entity(name = "usuarios")
@EqualsAndHashCode(of="id")
public class Usuarios implements UserDetails {

		@Id
		private String id;
		
		private String nomeCompleto;
		
		private String login;
		
		private String senha;

		private String cargo;
		
		private UsuariosRole role;
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			
			if(this.role==UsuariosRole.ADMIN) 
				return List.of(
								new SimpleGrantedAuthority("ROLE_ADMIN,"),
								new SimpleGrantedAuthority("ROLE_USER,"));
			else return List.of(
					new SimpleGrantedAuthority("ROLE_USER,"));
		}

		@Override
		public String getPassword() {
				return senha;
		}

		@Override
		public String getUsername() {
				return login;
		}
		
	
		
		
		


}
