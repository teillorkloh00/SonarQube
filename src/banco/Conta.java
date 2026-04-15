package banco;

import java.util.ArrayList;
import java.util.Scanner;

// Classe base
abstract class Conta {
    protected String titular;
    protected double saldo;

    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado!");
        } else {
            System.out.println("Valor inválido!");
        }
    }

    public abstract void sacar(double valor);

    public void exibirSaldo() {
        System.out.println("Titular: " + titular + " | Saldo: R$ " + saldo);
    }

    public String getTitular() {
        return titular;
    }
}
