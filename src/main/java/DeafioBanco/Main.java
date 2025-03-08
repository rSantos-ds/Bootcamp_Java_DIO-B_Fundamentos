package DeafioBanco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        try{
            while (escolha != 7){
                System.out.println("\n==== Bem vindo ao banco ===");
                System.out.println("1 - Cadastrar nova conta");
                System.out.println("2 - Listar contas");
                System.out.println("3 - Depositar");
                System.out.println("4 - Sacar");
                System.out.println("5 - Transferir");
                System.out.println("6 - Consultar extrato");
                System.out.println("7 - Sair");

                System.out.print("Digite a opção desejada:");
                escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha){
                    case 1:
                        CadastrarConta(scanner, banco);
                        break;
                    case 2:
                        listarContas(banco);
                        break;
                    case 3:
                        operacao(scanner, 1, banco);
                        break;
                    case 4:
                        operacao(scanner, 2, banco);
                        break;
                    case 5:
                        if (banco.listaContas.size() >= 2){
                            operacao(scanner, 3, banco);
                        } else {
                            System.out.println("\nHá apenas uma conta cadastrada, não é possivel transferir");
                        }
                    case 6:
                        consultarExtrato(scanner, banco);
                        break;
                    case 7:
                        System.out.println("Encenrrando...");
                        scanner.close();
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Opção inválida");
        }
    }

    //    Função para cadastrar contas
    static void CadastrarConta(Scanner scanner, Banco banco){
        int tipoConta = 0;
        Cliente cliente = new Cliente();

        System.out.println("\n === Cadastro de Conta ===");
        System.out.print("Informe o nome do cliente:");
        cliente.setNome(scanner.nextLine());
        System.out.print("Informe a idade do cliente:");
        cliente.setIdade(scanner.nextInt());

        while ((tipoConta != 1) && (tipoConta != 2)) {
            System.out.print("Informe o tipo da conta (1 - Corrente | 2 - Poupança):");
            tipoConta = scanner.nextInt();
            scanner.nextLine();

            switch (tipoConta){
                case 1:
                    banco.listaContas.addLast(new ContaCorrente("Corrente",cliente));
                    System.out.println("Numero da conta cadastrada:"+ banco.listaContas.getLast().numero);
                    break;
                case 2:
                    banco.listaContas.addLast(new ContaPoupanca("Poupança",cliente));
                    System.out.println("Numero da conta cadastrada:"+ banco.listaContas.getLast().numero);
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente");
            }
        }
    }

    //    Função para listarContas
    static void listarContas(Banco banco){
        System.out.println("=== Contas ===");
        banco.listaContas.stream()
                .forEach(System.out::println);
    }

    //    Função para depositar, sacar ou transferir
    static void operacao(Scanner scanner, int operacao, Banco banco){
        int numeroConta;
        double valor;

        if (banco.listaContas.size() > 0){
            System.out.print("\nInforme o numero da conta:");
            numeroConta = scanner.nextInt() - 1;

            if (banco.listaContas.size()>= numeroConta){
                System.out.print("Informe o valor:");
                valor = scanner.nextDouble();

                switch (operacao){
                    case 1:
                        banco.listaContas.get(numeroConta).depositar(valor);
                        break;
                    case 2:
                        banco.listaContas.get(numeroConta).sacar(valor);
                        break;
                    case 3:
                        int contaDestino;
                        System.out.print("Informe o numero da conta destino:");
                        contaDestino = scanner.nextInt()-1;

                        if (banco.listaContas.size()>= contaDestino){
                            banco.listaContas.get(numeroConta).transferir(valor, banco.listaContas.get(contaDestino));
                        }else{
                            System.out.print("\nNumero de conta destino não cadastrado no banco.");
                        }
                }
            }
            else {
                System.out.print("\nNumero de conta não cadastrado no banco.");
            }
        }
        else {
            System.out.println("\nNão há contas cadastradas");
        }
    }

//    Função para mostrar extrato

    static void consultarExtrato(Scanner scanner, Banco banco){
        if (banco.listaContas.size() > 0) {
            int numeroConta;
            System.out.print("Informe o número da conta:");
            numeroConta = scanner.nextInt() - 1;

            if (banco.listaContas.size() >= numeroConta) {
                System.out.println(banco.listaContas.get(numeroConta));
            } else {
                System.out.println("\nNumero de conta não cadastrado no banco.");
            }
        } else {
            System.out.println("Não há contas cadastradas");
        }
    }

}
