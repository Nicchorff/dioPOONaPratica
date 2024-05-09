public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldoInicial() {
        return saldo;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        // Aqui é incrementado o saldo da conta com o valor do depósito:
        this.saldo += valor;
        // É impresso uma mensagem indicando que o depósito foi feito:
        System.out.println("Deposito feito.");
    }

    // Método para realizar saque da conta:
    public void sacar(double valor) {
        // Verificamos se o valor do saque é maior que o saldo disponível na conta:
        if (valor > saldo) {
            // Se for, imprime uma mensagem informando que o saque não pode ser realizado por saldo insuficiente:
            System.out.println("Saldo insuficiente. Saque não realizado.");
        } else {
            // Caso contrário, realiza o saque subtraindo o valor do saldo da conta:
            this.saldo -= valor;
            // Imprime uma mensagem indicando que o saque foi feito:
            System.out.println("Saque feito.");
        }
    }
}

