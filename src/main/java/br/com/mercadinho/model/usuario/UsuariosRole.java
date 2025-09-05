package br.com.mercadinho.model.usuario;

public enum UsuariosRole {

	ADMIN("admin"),
	USER("User");
	
	private String role;
	
	UsuariosRole(String role){
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
