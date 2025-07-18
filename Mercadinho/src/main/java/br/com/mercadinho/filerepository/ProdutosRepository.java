package br.com.mercadinho.filerepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.mercadinho.model.Produtos;

@Service
public class ProdutosRepository {
	
	
	public void deleteProduto(File arquivo,String codigoProduto) {
	
		try {
			File arquivoTemp = new File("C:\\Users\\PICHAU\\git\\repository\\Mercadinho\\arquivos\\arquivoTemporario.txt");
			boolean criou = arquivoTemp.createNewFile();
			
			BufferedReader br = new BufferedReader(new FileReader(arquivo));
			BufferedWriter temporario = new BufferedWriter(new FileWriter(arquivoTemp));
			
			String line ="";
			while((line = br.readLine())!=null) {
				String[] partesStrings = line.split(",");
				if(!partesStrings[4].equals(codigoProduto)) {
					temporario.write(line);
					temporario.newLine();
				}
			}
			 br.close();
			 temporario.close();
			 
            Files.delete(arquivo.toPath());
            Files.move(arquivoTemp.toPath(), arquivo.toPath());

           
			temporario.newLine();
			temporario.flush();
		} catch (IOException e) {

			
			e.printStackTrace();
		}
		
		
		}

	public 	List<Produtos> listarTodosProdutos(File arquivo) throws IOException {
		List<String> produtosString = new ArrayList<String>();
		List<Produtos> listaProdutos= new ArrayList<Produtos>();
		FileReader fr = new  FileReader(arquivo);
		BufferedReader br = new BufferedReader(fr);
		String line;
		
		while ((line = br.readLine())!=null) {
			 String[] partesStrings = line.split(",");
			 String nome = partesStrings[0];
			 String descrição = partesStrings[1];
			 double preco = Double.parseDouble(partesStrings[2]);
			 int quantidadEstoque =  Integer.parseInt( partesStrings[3]);
			 String codigoProduto =  partesStrings[4];
			 double peso = Double.parseDouble( partesStrings[5]);
			 Produtos produtos = new Produtos(nome,descrição,preco,quantidadEstoque,codigoProduto,peso);
			 listaProdutos.add(produtos);
		
			
		}
		
		fr.close();
		
		return listaProdutos;
	}

	public void salvarProduto(File arquivo, String produtos) {
	
		try (FileWriter fw = new FileWriter(arquivo, true)) {
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(produtos);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void alterarProduto(File file, String produto,String codigoProduto) {
		
		try {
			File arquivoTemp = new File("C:\\Users\\PICHAU\\git\\repository\\Mercadinho\\arquivos\\arquivoTemporario.txt");

			BufferedReader br = new BufferedReader(new FileReader(file));
			BufferedWriter temporario = new BufferedWriter(new FileWriter(arquivoTemp));

			String line = "";
			while((line = br.readLine())!= null) {
				String[] partes = line.split(",");
				if(!partes[4].equals(codigoProduto)) {
					temporario.write(line);
					temporario.newLine();
				}
			}
			
			temporario.write(produto);
			temporario.newLine();
			 br.close();
			 temporario.close();
			 
            Files.delete(file.toPath());
            Files.move(arquivoTemp.toPath(), file.toPath());

           
			temporario.newLine();
			temporario.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
