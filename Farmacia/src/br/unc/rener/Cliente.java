package br.unc.rener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa {
	
	public static final String ARQUIVO = "C:/DesenvolvimentoSoft/uncDesenvolvimento/Farmacia/database/Cliente.csv";
	private String telefone;
	
	public Cliente () {}
	
	public Cliente (String nome,String cpf,String rg,String endereco, String telefone) {
		super(nome,cpf,rg,endereco);
		this.telefone=telefone;
		
	}
	
	public void setTelefone(String f) {
		this.telefone = f;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	public void salvar() {
		File f = new File (this.ARQUIVO);
		try {		
		FileOutputStream fos = new FileOutputStream(f,true);
		fos.write(this.toString().getBytes());
		System.out.println("O objeto cliente foi salvo!");
		fos.close();
	}
		catch (FileNotFoundException fnf) {
			System.out.println("Caminho n�o encontrado");
		}catch (IOException e) {
			System.out.println("Erro de grava��o");
		}
	}
	public static List<Cliente> lerTodos () {
		File f = new File (ARQUIVO);
		FileInputStream fis;
		
		List<Cliente> lstClientes = new ArrayList<Cliente>();
		
		try {
		fis = new FileInputStream(f);
		Scanner scan = new Scanner (fis);
		while (scan.hasNext()) 
		{
			
		String linha = scan.nextLine();
		String arr[] = linha.split(";");
		Cliente cliente = new Cliente(arr[0],arr[1],arr[2],arr[3],arr[4]);
		lstClientes.add(cliente);

			
			}
			scan.close();
			fis.close();
		}
		catch (FileNotFoundException fnf) {
			System.out.println("Caminho n�o encontrado");
		}catch (IOException e) {
			System.out.println("Erro de grava��o");
		}
		return lstClientes;
	}
	@Override
	public String toString() {
		return super.toString() + ";" + this.telefone +"\n";
	}		
}