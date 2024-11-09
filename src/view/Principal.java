package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ArquivosController;
import controller.IArquivosController;

/*
 * 2) Fazer uma aplicação em Java que tenha uma classe de controle que contenha um método que receba um 
String com um caminho de diretório, faça as validações, e liste apenas os arquivos contidos, em ordem de 
tamanho (em MB). Para obter o tamanho do arquivo, pegar o double length() do File, que retorna o tamanho do 
arquivo em bytes.  
* Lembrando 1 MB = ((bytes / 1024) / 1024)
* 
 */
public class Principal {

	public static void main(String[] args) {

		IArquivosController cont=new ArquivosController();
	
		String caminho=JOptionPane.showInputDialog(null,"Digite o caminho do diretório: ","Listar arquivos e tamanho",JOptionPane.INFORMATION_MESSAGE);
		
		try {
			cont.listaFiles(caminho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
