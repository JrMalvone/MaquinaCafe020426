package maqcafe;

public class Cafe implements Bebida {
    private String nome;
    private double preco;
    private int estoqueCapsulas;

    public Cafe(String nome, double preco, int estoqueInicial) {
        this.nome = nome;
        this.preco = preco;
        this.estoqueCapsulas = estoqueInicial;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public double getPreco() { return preco; }

    public boolean temEstoque() {
        return estoqueCapsulas > 0;
    }

    public void consumirCapsula() {
        if (estoqueCapsulas > 0) {
            estoqueCapsulas--;
        }
    }
}