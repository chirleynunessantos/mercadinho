package br.com.mercadinho.model.usuario;

public record RegistroDTO(String nomeCompleto,String login, String senha, String cargo, UsuariosRole role) {

}
