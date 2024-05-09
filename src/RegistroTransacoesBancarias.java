
import java.util.*;

public class RegistroTransacoesBancarias {

    private int NUMERO_DA_TRANSACAO = 1;

    private double saldo;
    private int transações;
    private Set<String> transacoesFeitas;

    public RegistroTransacoesBancarias(double saldo, int transações) {
        this.saldo = saldo;
        this.transações = transações;
        this.transacoesFeitas = new LinkedHashSet<>();
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getTransações() {
        return transações;
    }

    public void setTransações(int transações) {
        this.transações = transações;
    }

    public Set<String> getTransacoesFeitas() {
        return transacoesFeitas;
    }

    public void setTransacoesFeitas(Set<String> transacoesFeitas) {
        this.transacoesFeitas = transacoesFeitas;
    }

    public double depositar(double valor) {
        transacoesFeitas.add(this.NUMERO_DA_TRANSACAO +". "+"Deposito de " + valor );
        this.NUMERO_DA_TRANSACAO++;
        return this.saldo += valor;
    }

    public double sacar(double valor) {
        transacoesFeitas.add(this.NUMERO_DA_TRANSACAO +". " + "Saque de " + valor );
        this.NUMERO_DA_TRANSACAO++;
        return this.saldo -= valor;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        int quantidadeTransacoes = scanner.nextInt();

        RegistroTransacoesBancarias rg = new RegistroTransacoesBancarias(saldo, quantidadeTransacoes);

        for (int i = 0; i < quantidadeTransacoes; i++)
        {
            String selecionarTipoTransacao = scanner.next();
            if (Objects.equals(selecionarTipoTransacao, "D") || Objects.equals(selecionarTipoTransacao, "d")) {
                double valor = scanner.nextDouble();
                rg.depositar(valor);
            } else if (Objects.equals(selecionarTipoTransacao, "S") || Objects.equals(selecionarTipoTransacao, "s")) {
                double valor = scanner.nextDouble();
                rg.sacar(valor);
            } else {
                // Se o tipo de transação não for reconhecido, exibe uma mensagem de erro
                System.out.println("Opção inválida. Utilize D para depósito ou S para saque.");
                i--;
            }
        }


        System.out.println("Saldo: " + rg.getSaldo());
        System.out.println("Transacao:");
        for(var transacoes : rg.getTransacoesFeitas()){
            if(!rg.getTransacoesFeitas().isEmpty()){
                System.out.println(transacoes);
            }
        }

    }
}
