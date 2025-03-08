package DesafioComponenteIphone;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Iphone iphone = new Iphone();

        int escolha = 0;

        while(escolha != 4){
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1 - Reprodutor de musica");
            System.out.println("2 - Telefone");
            System.out.println("3 - Navegador de internet");
            System.out.println("4 - Desligar");
            System.out.print("Informe a função desejada:");

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                case 1:
                    ReprodutorMusica(scanner, iphone);
                    break;
                case 2:
                    Telefone(scanner, iphone);
                    break;
                case 3:
                    NavegadorInternet(scanner, iphone);
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Desligando...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        }
    }

    //    Função Reprodutor de Musica
    public static void ReprodutorMusica(Scanner scanner, Iphone iphone){
        int escolha = 0;

        while (escolha != 4){
            System.out.println("\n==== MENU MUSICA ====");
            System.out.println("1 - Tocar musica");
            System.out.println("2 - Pausar musica");
            System.out.println("3 - Escolher musica");
            System.out.println("4 - Voltar ao menu principal");
            System.out.print("Escolha a opção desejada:");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                case 1:
                    iphone.tocar();
                    break;
                case 2:
                    iphone.pausar();
                    break;
                case 3:
                    System.out.print("\nInforme a musica desejada: ");
                    String musica = scanner.nextLine();
                    iphone.selecionarMusica(musica);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\nOpção inválida, digite novamente");
            }
        }
    }

    //    Função Telefone
    public static void Telefone(Scanner scanner, Iphone iphone){
        int escolha = 0;

        while (escolha != 4){
            System.out.println("\n==== MENU TELEFONE ====");
            System.out.println("1 - Ligar");
            System.out.println("2 - Atender ligação");
            System.out.println("3 - Iniciar correio de voz");
            System.out.println("4 - Voltar ao menu principal");
            System.out.print("Escolha a opção desejada:");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                case 1:
                    System.out.print("\nInforme o número que deseja ligar: ");
                    String numero = scanner.nextLine();
                    iphone.ligar(numero);
                    break;
                case 2:
                    iphone.atender();
                    break;
                case 3:
                    iphone.iniciarCorreiroVoz();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\nOpção inválida, digite novamente");
            }
        }
    }

    //    Função Navegador Internet
    public static void NavegadorInternet(Scanner scanner, Iphone iphone){
        int escolha = 0;

        while (escolha != 4){
            System.out.println("\n==== MENU NAVEGADOR ====");
            System.out.println("1 - Exibir página");
            System.out.println("2 - Adicionar nova aba");
            System.out.println("3 - Atualizar pagina");
            System.out.println("4 - Voltar ao menu principal");
            System.out.print("Escolha a opção desejada:");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                case 1:
                    System.out.print("\nInforme a URL da página: ");
                    String url = scanner.nextLine();
                    iphone.exibirPagina(url);
                    break;
                case 2:
                    iphone.adicionarNovaAba();
                    break;
                case 3:
                    iphone.atualizarPagina();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("\nOpção inválida, digite novamente");
            }
        }
    }

}
