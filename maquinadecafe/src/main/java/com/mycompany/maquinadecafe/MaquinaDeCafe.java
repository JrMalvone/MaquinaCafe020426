
package com.mycompany.maquinadecafe;

import java.util.HashMap;
import java.util.Map;


    public class MaquinaDeCafe implements IStatus, IPagamentos{
        
    private int sabor;
    private int quantidade;
    private double valor;
    private int pagamento;
    
     public MaquinaDeCafe(int sabor) {
        this.sabor = sabor;
    }
         @Override
    public String luz() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String avisarsabor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
    public boolean pagarcartao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean pagarpix() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void saldoindisponivel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

    public int getSabor() {
        return sabor;
    }

    public void setSabor(int sabor) {
        this.sabor = sabor;
    
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.quantidade = 30;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }
    private Map<Integer, Sabores> menuSabores;

    public MaquinaDeCafe() {
      
    }
        // Implementação do IStatus
    public String obterCorLuz(int doses) {
        if (doses > 20) {
            return "🟢 VERDE (Completa)";
        } else if (doses > 10) {
            return "🟡 AMARELA (Média)";
        } else {
            return "🔴 VERMELHA (Baixa)";
        }
    }

        public void exibirStatusMaquina() {
            System.out.println("\n=== STATUS DA MÁQUINA DE CAFÉ ===");
            for (Map.Entry<Integer, Sabores> entry : menuSabores.entrySet()) {
            Sabores sabor = entry.getValue();
            System.out.printf("[%d] %-15s | %02d doses | Luz: %s%n", 
                entry.getKey(), sabor.getNome(), sabor.getDoses(), obterCorLuz(sabor.getDoses()));
        }
            System.out.println("=================================");
    }

    // Implementação do IPagamentos
    public boolean processarPagamento(String metodo) {
        String pag = metodo.toLowerCase();
        if (pag.equals("credito") || pag.equals("debito") || pag.equals("pix")) {
            System.out.println("✅ Pagamento via " + pag.toUpperCase() + " aprovado!");
            return true;
        }
        System.out.println("❌ Método de pagamento inválido. Use: credito, debito ou pix.");
        return false;
    }

    // Método principal de operação da máquina
    public void pedirCafe(int opcaoSabor, String metodoPagamento) {
        System.out.println("\n-> Iniciando pedido...");
        Sabores saborEscolhido = menuSabores.get(opcaoSabor);

        // Verifica se o sabor existe
        if (saborEscolhido == null) {
            System.out.println("❌ Opção de café inválida!");
            return;
        }

        // Verifica se tem dose (Luz Vermelha zerada)
        if (saborEscolhido.getDoses() == 0) {
            System.out.println("❌ Desculpe, o sabor " + saborEscolhido.getNome() + " está esgotado (Luz Vermelha).");
            return;
        }

        // Processa o pagamento e serve o café
        if (processarPagamento(metodoPagamento)) {
            saborEscolhido.servirDose();
            System.out.println("☕ Preparando o seu " + saborEscolhido.getNome() + "... Pronto! Retire seu copo.");
        } else {
            System.out.println("❌ Falha na transação. Pedido cancelado.");
        }
    }

    // Método Main para testar o código
    public static void main(String[] args) {
        MaquinaDeCafe minhaMaquina = new MaquinaDeCafe();

        // Mostra o status inicial (Tudo verde com 30 doses)
        minhaMaquina.exibirStatusMaquina();

        // Simulando um pedido normal
        minhaMaquina.pedirCafe(2, "pix"); // Pede um Capuccino no PIX
        minhaMaquina.pedirCafe(1, "credito"); // Pede um Expresso no Crédito
        
        // Simulando tentativa com pagamento errado
        minhaMaquina.pedirCafe(3, "dinheiro"); // Vai falhar o pagamento

        // Simulando várias compras do mesmo sabor para forçar a luz a mudar para Amarela e depois Vermelha
        System.out.println("\n-> Simulando compra de 15 Expressos no débito...");
        for (int i = 0; i < 15; i++) {
            minhaMaquina.pedirCafe(1, "debito"); 
        }

        // Mostra o status final para você ver as luzes mudando
        minhaMaquina.exibirStatusMaquina();
    }
}
    

