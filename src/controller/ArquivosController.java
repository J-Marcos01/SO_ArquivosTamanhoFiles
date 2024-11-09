package controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;


/*
 * 2) Fazer uma aplicação em Java que tenha uma classe de controle que contenha um método que receba um 
String com um caminho de diretório, faça as validações, e liste apenas os arquivos contidos, em ordem de 
tamanho (em MB). Para obter o tamanho do arquivo, pegar o double length() do File, que retorna o tamanho do 
arquivo em bytes.  
* Lembrando 1 MB = ((bytes / 1024) / 1024)
* 
 */
public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}

	@Override
	public void listaFiles(String caminho) throws IOException {
		
		caminho=valida(caminho);
		if(caminho.contains("Inválido")) {
			while(caminho.contains("Inválido")) {
				JOptionPane.showInputDialog(null,"Diretório informado inválido","Erro",JOptionPane.ERROR_MESSAGE);
				caminho=JOptionPane.showInputDialog(null,"Digite o caminho do diretório","Listar arquivos e tamanho",JOptionPane.INFORMATION_MESSAGE);
				caminho=valida(caminho);
			}
		}
		File path=new File(caminho);
	    listaFiles(path);		
		
	}

	private void listaFiles(File path) {
		File[]vetFile=path.listFiles();
		System.out.printf("%-90s %-30s%n","File","Tamanho");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------");
		vetFile=organiza(vetFile);
		for(File f:vetFile) {
			if(f.isFile()) {
				double tamanho=f.length();
				tamanho=(tamanho/(1024*1024));
				System.out.printf("%-90s %-30s%n","Nome: "+f.getName(),"Tamanho:  " + String.format("%.2f MB", tamanho));	
			}
			
		}
		
		
	}

	private File[] organiza(File[] vetFile) {
		File []aux=vetFile;
		int tamanho=aux.length;
		for(int i=0;i<tamanho-1;i++) {
			for(int j=i+1;j<tamanho;j++) {
				if(aux[i].isFile()&&aux[j].isFile()) {
					if(aux[i].length()>aux[j].length()) {
						File fileAux=aux[i];
						aux[i]=aux[j];
						aux[j]=fileAux;
					}
				}
			}
		}
		
		return aux ;
	}

	private String valida(String caminho) {
		File path=new File(caminho);
		if(path.exists()&&path.isDirectory()) {
			return caminho;
		}
		return "Diretório Inválido";
	}

}
