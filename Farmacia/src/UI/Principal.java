package UI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.unc.rener.Cliente;
import br.unc.rener.Funcionario;
import br.unc.rener.dao.ClienteDao;
import br.unc.rener.utils.EntidadeGenerica;

public class Principal {
	
	public static void main(String array[]) {
		montaTelaPrincipal();
	}
	
	private static void montaTelaPrincipal() {
		System.out.println(" SISTEMA FARMACIA\n\n");
		System.out.println(" 1. Cadastros");
		System.out.println(" 2. Estoque");
		System.out.println(" 3. Relatorios");
		System.out.println(" 4. Ajuda");
		System.out.println(" 5. Sair\n\n");
		System.out.printf(" Digite uma das opções acima: ");
		
		Scanner s = new Scanner (System.in);
		Integer op = s.nextInt();
		irTela(op);
	}
	
	private static void irTela (Integer op) {
		
		if (op == 1) {
			irMenuCadastro();
		} else if (op == 3) {
			irMenuRelatorio();
		}
	}
	
	private static void irMenuCadastro () {
		
		System.out.println(" CADASTROS\n\n");
		System.out.println(" 1. Cliente");
		System.out.println(" 2. Funcionario");
		System.out.println(" 3. Farmaceutico");
		System.out.println(" 4. Produtos");
		System.out.println(" 5. Voltar\n\n");
		System.out.printf(" Digite uma das opções acima: ");
		Scanner scan = new Scanner (System.in);
		Integer op = scan.nextInt();
		
		if(op==5) {
			montaTelaPrincipal();
		}
		else if(op==1) {
			irCadastroCliente();
		}
		else if (op==2) {
			irCadastroFuncionario();
		}
	}

	private static void irMenuRelatorio () {
		
		System.out.println(" RELATORIOS\n\n");
		System.out.println(" 1. Cliente");
		System.out.println(" 2. Funcionario");
		System.out.println(" 3. Farmaceutico");
		System.out.println(" 4. Produtos");
		System.out.println(" 5. Voltar\n\n");
		System.out.printf(" Digite uma das opções acima: ");
		
		Scanner s = new Scanner (System.in);
		Integer op = s.nextInt();
		
		if(op==1) {
			relatorioCliente();
		}
		else if(op==2) {
			relatorioFuncionario();
		}
	}

	private static void irCadastroCliente() {
			
		Scanner scan = new Scanner (System.in);
		Cliente c = new Cliente();
		
		System.out.println("CADASTRO CLIENTE\n\n");
		System.out.printf("Digite o Nome:  \n");
		c.setNome(scan.nextLine());
		System.out.printf("Digite o CPF:  \n");
		c.setCpf(scan.nextLine());
		System.out.printf("Digite o RG:  \n");
		c.setRg(scan.nextLine());
		System.out.printf("Digite o Endereço:  \n");
		c.setEndereco(scan.nextLine());
		
	//	EntidadeGenerica entidade = new EntidadeGenerica();
	//	entidade.salvarEntidade(c, Cliente.ARQUIVO_SERIAL);
		
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.inserir(c);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		montaTelaPrincipal(); 
	}
	
	private static void irCadastroFuncionario() {

		Scanner scan = new Scanner (System.in);
		Funcionario f = new Funcionario();
		
		System.out.println("CADASTRO FUNCIONARIO\n\n");
		System.out.printf("Digite o Nome:  \n");
		f.setNome(scan.nextLine());
		System.out.printf("Digite o CPF:  \n");
		f.setCpf(scan.nextLine());
		System.out.printf("Digite o RG:  \n");
		f.setRg(scan.nextLine());
		System.out.printf("Digite o Endereço:  \n");
		f.setEndereco(scan.nextLine());
		System.out.printf("Digite o pis:  \n");
		f.setPis(scan.nextLine());
		System.out.printf("Digite o pasep:  \n");
		f.setPasep(scan.nextLine());
		System.out.printf("Digite o numero da Carteira de Trabalho:  \n");
		f.setCarteiraTrabalho(scan.nextLine());
		System.out.printf("Digite o salário:  \n");
		f.setSalario(scan.nextDouble());
		
	//	EntidadeGenerica entidade = new EntidadeGenerica();
	//	entidade.salvarEntidade(f, Funcionario.ARQUIVO_SERIALIZACAO);
		
	//	ClienteDao clienteDao = new ClienteDao();
	//	clienteDao.inserir(c);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		montaTelaPrincipal(); 
	}
	
	private static void relatorioCliente() {
		System.out.println("IMPRIMINDO CLIENTE \n\n\n");
		EntidadeGenerica e = new EntidadeGenerica();
		e.imprimirLista(Cliente.ARQUIVO_SERIAL);
		System.out.println("\n\n Digite uma op 1 : Menu - 2 : Relatorios");
		Scanner s = new Scanner(System.in);
		Integer op = s.nextInt();
		if (op == 1) {
			montaTelaPrincipal();
		}else	if (op == 2) {
			irMenuRelatorio();
		}
	}
	
	private static void relatorioFuncionario() {
		System.out.println("IMPRIMINDO FUNCIONARIO \n\n\n");
		EntidadeGenerica e = new EntidadeGenerica();
		e.imprimirLista(Funcionario.ARQUIVO_SERIALIZACAO);
		System.out.println("\n\n Digite uma op 1 : Menu - 2 : Relatorios");
		Scanner s = new Scanner(System.in);
		Integer op = s.nextInt();
		if (op == 1) {
			montaTelaPrincipal();
		}else	if (op == 2) {
			irMenuRelatorio();
		}
	}
	
	private static List<Cliente> lerLista(){
		try {
			File arquivo = new File(Cliente.ARQUIVO_SERIAL);
			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Cliente> lst = (List<Cliente>) ois.readObject();
			return lst;
		} catch (FileNotFoundException e) {
			return criarListaVazia();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<Cliente> criarListaVazia() {
		try {
			File arquivo = new File(Cliente.ARQUIVO_SERIAL);
			FileOutputStream fos  = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			List<Cliente> lst = new ArrayList<Cliente>();
			oos.writeObject(lst);
			System.out.printf("lista vazia persistida");
			return lerLista();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	private static List<Funcionario> lerListaFuncionario(){
		try {
			File arquivo = new File(Funcionario.ARQUIVO_SERIALIZACAO);
			FileInputStream fis = new FileInputStream(arquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Funcionario> lst = (List<Funcionario>) ois.readObject();
			return lst;
		} catch (FileNotFoundException e) {
			return criarListaVaziaFuncionario();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static List<Funcionario> criarListaVaziaFuncionario() {
		try {
			File arquivo = new File(Funcionario.ARQUIVO_SERIALIZACAO);
			FileOutputStream fos  = new FileOutputStream(arquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			List<Funcionario> lst = new ArrayList<Funcionario>();
			oos.writeObject(lst);
			System.out.printf("lista vazia persistida");
			return lerListaFuncionario();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
