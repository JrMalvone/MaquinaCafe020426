package maqcafe;

public class ModuloPagamento {
    
    public boolean processarPagamento(double valor, int opcaoPagamento) {
        String tipo = (opcaoPagamento == 1) ? "PIX" : "Cartao";
        
        System.out.println("\n[Sistema PagBank] Conectando...");
        System.out.println("[Sistema PagBank] Validando " + tipo + " no valor de R$ " + valor + "...");
        
        // Simulação de aprovação (na vida real, seria uma chamada de API)
        if (valor > 0) {
            System.out.println("[Sistema PagBank] Transacao Aprovada!");
            return true;
        } else {
            System.out.println("[Sistema PagBank] Transacao Recusada.");
            return false;
        }
    }
}