package banco;

import java.util.ArrayList;
import java.util.Scanner;


public class BancoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Criar Conta Corrente");
            System.out.println("2 - Criar Conta Poupança");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Listar Contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do titular: ");
                    String nomeCC = sc.nextLine();
                    System.out.print("Limite: ");
                    double limite = sc.nextDouble();
                    contas.add(new ContaCorrente(nomeCC, limite));
                    System.out.println("Conta Corrente criada!");
                    break;

                case 2:
                    System.out.print("Nome do titular: ");
                    String nomeCP = sc.nextLine();
                    contas.add(new ContaPoupanca(nomeCP));
                    System.out.println("Conta Poupança criada!");
                    break;

                case 3:
                    System.out.print("Nome do titular: ");
                    String nomeDep = sc.nextLine();
                    Conta contaDep = buscarConta(contas, nomeDep);
                    if (contaDep != null) {
                        System.out.print("Valor: ");
                        double valor = sc.nextDouble();
                        contaDep.depositar(valor);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 4:
                    System.out.print("Nome do titular: ");
                    String nomeSac = sc.nextLine();
                    Conta contaSac = buscarConta(contas, nomeSac);
                    if (contaSac != null) {
                        System.out.print("Valor: ");
                        double valor = sc.nextDouble();
                        contaSac.sacar(valor);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;

                case 5:
                    for (Conta c : contas) {
                        c.exibirSaldo();
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    public static Conta buscarConta(ArrayList<Conta> contas, String titular) {
        for (Conta c : contas) {
            if (c.getTitular().equalsIgnoreCase(titular)) {
                return c;
            }
        }
        return null;
    }
}

