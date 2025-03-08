package DesafioComponenteIphone;

import DesafioComponenteIphone.interfaces.NavegadorInternet;
import DesafioComponenteIphone.interfaces.ReprodutorMusica;
import DesafioComponenteIphone.interfaces.Telefone;

public class Iphone implements ReprodutorMusica, Telefone, NavegadorInternet {

    @Override

//    Métodos interface Reprodutor musica
    public void tocar() {
        System.out.println("\nTocando musica! solta o som dj");
    }

    @Override
    public void pausar() {
        System.out.println("\nMusica pausada! a festa acabou");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("\nClaro, tocando a musica: "+ musica);
    }

//    Métodos interface telefone

    @Override
    public void ligar(String numero) {
        System.out.println("\nLigando para o numero: "+ numero + "...");
    }

    @Override
    public void atender() {
        System.out.println("\nAtendendo a ligação...");
    }

    @Override
    public void iniciarCorreiroVoz() {
        System.out.println("\nAcessando correio de voz...");
    }

//    Métodos interface NavegadorInternet

    @Override
    public void exibirPagina(String url) {
        System.out.println("\nAcessando internet...");
        System.out.println("Exibindo a pagina: " + url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("\nNova aba aberta");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("\nPágina atualizada!");
    }
}
