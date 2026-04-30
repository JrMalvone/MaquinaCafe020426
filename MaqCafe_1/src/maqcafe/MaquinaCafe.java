package maqcafe;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MaquinaCafe {
    private List<Cafe> menu;
    private ModuloPagamento gateway;
    private Scanner scanner;

    public MaquinaCafe() {
        this.gateway = new ModuloPagamento();
        this.scanner = new Scanner(System.in);
        this.menu = new ArrayList<>();

        // Inicializando todos os sabores do seu diagrama BPMN
        menu.add(new Cafe("Cafe Expresso", 3.00, 10));
        menu.add(new Cafe("Cafe Pingado", 3.50, 10));
        menu.add(new Cafe("Cafe Capuccino", 4.50, 10));
        menu.add(new Cafe("Cafe Americano", 2.50, 10));
        menu.add(new Cafe("Cafe Achocolatado", 5.00, 10));
        menu.add(new Cafe("Cafe Leite Cremoso", 4.00, 10));
    }

    public void iniciarAtendimento() {
        System.out.println("========== MAQUINA DE CAFE - PAINEL ==========");
        for (int i = 0; i < menu.size(); i++) {
            Cafe c = menu.get(i);
            System.out.printf("%d - %s (R$ %.2f) [%s]\n", 
                (i + 1), c.getNome(), c.getPreco(), 
                c.temEstoque() ? "Disponivel" : "Esgotado");
        }
        
        System.out.print("=> Escolha sua bebida: ");
        int escolha = scanner.nextInt();

        if (escolha < 1 || escolha > menu.size()) {
            System.out.println("[Erro] Opcao invalida.");
            return;
        }

        Cafe bebidaEscolhida = menu.get(escolha - 1);

        if (!bebidaEscolhida.temEstoque()) {
            System.out.println("\n[Aviso] " + bebidaEscolhida.getNome() + " esgotado. Escolha outro.");
            return;
        }

        realizarCobranca(bebidaEscolhida);
    }

    private void realizarCobranca(Cafe bebida) {
        System.out.println("\n--- PAGAMENTO ---");
        System.out.println("1 - PIX");
        System.out.println("2 - Cartao");
        System.out.print("=> Selecione a forma: ");
        int opcaoPag = scanner.nextInt();

        if (gateway.processarPagamento(bebida.getPreco(), opcaoPag)) {
            dispensarBebida(bebida);
        } else {
            System.out.println("\n[Falha] Pagamento recusado pelo PagBank.");
        }
    }

    private void dispensarBebida(Cafe bebida) {
        bebida.consumirCapsula();
        System.out.println("\n--------------------------------");
        System.out.println("Preparando seu " + bebida.getNome() + "...");
        System.out.println("Finalizando processo...");
        System.out.println("=> PRONTO! Retire seu copo.");
        System.out.println("--------------------------------\n");
    }
}