package ContaBanco;

import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);

        int numero;
        String agencia;
        String nomeCliente;
        double saldo;

        System.out.print("Informe o número da conta: ");
        numero = entrada.nextInt();
        entrada.nextLine();

        System.out.print("Informe a agência (padrão: xxx-x): ");
        agencia = entrada.nextLine();

        System.out.print("Informe o nome do cliente: ");
        nomeCliente = entrada.nextLine();

        System.out.print("Informe o saldo da conta: ");
        saldo = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ",conta " +
                numero + " e seu saldo " + saldo + " já está disponivel para saque");

        entrada.close();
    }
}
