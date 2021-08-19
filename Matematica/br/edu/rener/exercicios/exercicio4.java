package br.edu.rener.exercicios;

import java.util.Scanner;

public class exercicio4 {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
				System.out.println("Digite 3 números para fazer a média aritmética");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int soma = num1+num2+num3;
		System.out.printf("A média aritmética é %s",soma/3);
	}

}
