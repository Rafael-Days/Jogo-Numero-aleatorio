package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int numeroR;
    static int n1;
    static int n2;
    static int numero;

    public static void main(String[] args) {

        System.out.println("----------");
        System.out.println("BEM VINDO!");

        primeiroNumero(); // pede o primeiro número, e depois o segundo número, para o computador gerar 1 valor aleatório entre eles

        randomNumero(); // gera o valor aleatório entre n1 e n2
    }

    public static void primeiroNumero() {
        Scanner scanner = new Scanner(System.in);

        boolean valorValidoN1 = false;
        while (!valorValidoN1) { // aceita apenas numeros
            System.out.print("Digite um número!");
            try {
                if (scanner.hasNextInt()) {
                    n1 = scanner.nextInt();
                    valorValidoN1 = true;
                } else {
                    System.out.println("Entrada inválida! Tente novamente.");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                scanner.next(); // Limpa a entrada inválida
            }
        }

        segundoNumero();
    }

    public static void segundoNumero() {
        Scanner scanner = new Scanner(System.in);

        boolean valorValidoN2 = false;
        while (!valorValidoN2) { // aceita apenas numeros
            System.out.print("Digite o segundo número, onde ele é maior que o primeiro!");
            try {
                if (scanner.hasNextInt()) {
                    n2 = scanner.nextInt();
                    valorValidoN2 = true;

                    if (n2 <= n1) { // verifica se n1 é maior que n2
                        System.out.println("Numero menor ou igual que: " + n1 + " Digite um número maior!");
                        System.out.println("-----------------------------------------------------");
                        System.out.println();
                    }
                } else {
                    System.out.println("Entrada inválida! Tente novamente.");
                    scanner.next();
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                scanner.next(); // Limpa a entrada inválida
            }
        }
    }

    public static void randomNumero() {
        Random random = new Random();

        numeroR = random.nextInt((n2 - n1) + 1) + n1; // numero aleatorio de n1 até n2

        repeticao();
    }

    public static void repeticao() {
        Scanner scanner = new Scanner(System.in);

        int tentativas = 0;

        //System.out.println(n1 + "-" + n2 + " ->Numero Aleatorio:" + numeroR); // TESTE

        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("Advinhe o número de " + n1 + " até " + n2 + " em até 5 tentativas!");

        for (tentativas = 1; tentativas <= 5; tentativas++) {
            boolean valorValido = false;
            while (!valorValido) { // aceita apenas numeros
                System.out.print("Por favor, insira um número inteiro: ");
                try {
                    if (scanner.hasNextInt()) { // verifica se a próxima entrada é um inteiro
                        numero = scanner.nextInt(); // Le o número inteiro
                        valorValido = true; // sai do loop se o valor é válido
                    } else {
                        System.out.println("Entrada inválida! Tente novamente.");
                        scanner.next();
                    }
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro: " + e.getMessage());
                    scanner.next(); // Limpa a entrada inválida
                }
            }

            if (numero == numeroR) {
                System.out.println();
                System.out.println("Parabéns, você acertou o número aleatório, em " + tentativas + " tentativas!");
                System.out.println("-------------------------------");
                System.exit(0); // finaliza o código
            } else {
                encerrarJogo();
                System.out.println("Tentativas usadas: " + tentativas + " Tente novamente!");
            }
        }

        scanner.close();
    }

    public static void dica() {
        System.out.println();
        System.out.println("---DICA!---");
        if (numero < numeroR) {
            System.out.println("O número que você digitou: " + numero + ", é menor que o número aleatório");
//            System.out.println();
//            System.out.println("Tentativas usadas: " + tentativas + " Tente novamente!");
        } else
            System.out.println("O número que você digitou: " + numero + ", é maior que o número aleatório");
//            System.out.println();
//            System.out.println("Tentativas usadas: " + tentativas + " Tente novamente!");
    }

    public static void encerrarJogo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("VOCE ERROU! deseja sair do jogo? Digite sim para sair ou nao para continuar:");
        String resp = scanner.nextLine();
        switch (resp) {
            case "sim", "Sim", "SIM":
                System.exit(0);
                break;
            case "nao", "Nao", "NAO", "não", "Não":
                dica();
                break;
        }
    }

}
