package DeafioBanco;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(String tipo, Cliente cliente) {
        super(tipo, cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato conta poupança ===");
        super.imprimirInfoComuns();
    }
}
