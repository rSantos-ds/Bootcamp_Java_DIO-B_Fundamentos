package DeafioBanco;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected String tipo;
    protected Cliente cliente;

    //    Métodos
    public void sacar(double valor){
        if (saldo >= valor){
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para sacar");
        }
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino){
        if (this.saldo >= valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("\nTransferência realizada");
        }else{
            System.out.println("Saldo insuficiente para transferir");
        }
    }

    protected void imprimirInfoComuns(){
        System.out.println(String.format("Cliente:%s",this.cliente.getNome()));
        System.out.println(String.format("Agencia:%d", this.agencia));
        System.out.println(String.format("Numero da conta:%d", this.numero));
        System.out.println(String.format("Saldo da conta:%.2f", this.saldo));
    }

    //    Construtores
    public Conta(String tipo, Cliente cliente){
        agencia = AGENCIA_PADRAO;
        numero = SEQUENCIAL ++;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    //    Getters e Setters
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    //    ToString
    @Override
    public String toString() {
        System.out.println("\n ==============");
        return "\nConta número: " + numero +
                "\nagencia: " + agencia +
                "\nsaldo: " + saldo +
                "\ncliente: " + cliente.getNome() +
                "\nTipo da conta: " + tipo;
    }
}
