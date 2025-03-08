package DeafioBanco;

public class ContaCorrente extends Conta {

    public ContaCorrente(String tipo, Cliente cliente) {
        super(tipo, cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato conta corrente ===");
        super.imprimirInfoComuns();
    }

}
