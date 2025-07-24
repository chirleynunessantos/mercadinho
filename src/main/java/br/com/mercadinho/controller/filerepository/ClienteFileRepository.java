package br.com.mercadinho.controller.filerepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.mercadinho.model.Cliente;

@Service
public class ClienteFileRepository {

	public void salvarCliente(File file, String cliente) {


		try (FileWriter fw = new FileWriter(file, true)) {
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(cliente);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void alterarCliente(File file, String clienteString,String cpf) {
		File temp =  new File("C:\\Users\\PICHAU\\git\\repository\\Mercadinho\\arquivos\\temporario.txt");
		try {			
			BufferedReader br =  new BufferedReader(new FileReader(file));
			BufferedWriter temporario =  new BufferedWriter(new FileWriter(temp));

			String line;
			while((line= br.readLine())!=null) {
				String[] partes = line.split(",");
				if(!partes[1].equals(cpf)) {
					temporario.write(line);
					temporario.newLine();
				}else {
					temporario.write(clienteString);
					temporario.newLine();
				}
				
			}
			br.close();
			temporario.close();
			file.delete();
			temp.renameTo(file);
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	public void deleteCliente(File file, String cpf) {
		String line = "";
		File temp =  new File("C:\\Users\\PICHAU\\git\\repository\\Mercadinho\\arquivos\\temporario.txt");


		try(BufferedWriter temporario =  new BufferedWriter(new FileWriter(temp))) {					

			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line= br.readLine())!=null) {
				String[] partes = line.split(",");
				if(!partes[1].equals(cpf)) {
					temporario.write(line);
					temporario.newLine();
				}
			
		}
			br.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
			file.delete();
			temp.renameTo(file);
		
	}	


	public Cliente buscarCliente(File file, String cpf) {
		Cliente cliente = null;
		String line ="";
		try(BufferedReader br =  new BufferedReader(new FileReader(file))){
			while(( line = br.readLine())!=null) {
				String[] partes = line.split(",");
				if(partes[1].equals(cpf)) {					
					cliente = new Cliente(partes[0],partes[1],partes[2],partes[3]);
				}
				
			}			
			
		}catch (IOException e) {
			e.printStackTrace();
		}	
		return cliente;
	}

	public List<Cliente> deleteCliente(File file) {
		List<Cliente> listaclientes = new ArrayList<Cliente>();
		String line ="";
		try(BufferedReader br =  new BufferedReader(new FileReader(file))){
			while(( line = br.readLine())!=null) {
				String[] partes = line.split(",");							
					Cliente cliente = new Cliente(partes[0],partes[1],partes[2],partes[3]);
					listaclientes.add(cliente);
				
			}			
			
		}catch (IOException e) {
			e.printStackTrace();
		}	
		return listaclientes;
	}
}
