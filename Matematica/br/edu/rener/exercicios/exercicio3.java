package br.edu.rener.exercicios;

import java.util.Scanner;

public class exercicio3 {
	
	public static void main(String...args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite dois números para multiplicar");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int multiplica = num1*num2;
		System.out.printf("O resultado de multiplicação é: %s",multiplica);
	}

}
