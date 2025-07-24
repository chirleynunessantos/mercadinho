package br.com.mercadinho.fileservice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.mercadinho.model.Cliente;

@Service
public class ClienteFileService {
	@Autowired
	br.com.mercadinho.controller.filerepository.ClienteFileRepository repository;
	File file = new File("C:\\Users\\PICHAU\\git\\repository\\Mercadinho\\arquivos\\clientes.txt");

	public void salvarCliente(@RequestBody Cliente cliente) {
		
		String clienteString = 
					cliente.getNomeCompleto()+","+
					cliente.getCpfCnpj()+","+
					cliente.getEmail()+","+
					cliente.getTelefone(); 
		
		if(file.exists()){				
			
			repository.salvarCliente(file,clienteString);
		}else {
			try {
				file.createNewFile();
				repository.salvarCliente(file, clienteString);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void alterarCliente(Cliente cliente) {
		String clienteString = 
				cliente.getNomeCompleto()+","+
				cliente.getCpfCnpj()+","+
				cliente.getEmail()+","+
				cliente.getTelefone(); 
		repository.alterarCliente(file,clienteString,cliente.getCpfCnpj());
	}

	public void deleteCliente(String cpf) {
		repository.deleteCliente(file,cpf);

	}

	public List<Cliente> listarCliente() {
		return 	repository.deleteCliente(file);
	}

	public Cliente buscarCliente(String cpf) {
		return repository.buscarCliente(file,cpf);

	}
}
