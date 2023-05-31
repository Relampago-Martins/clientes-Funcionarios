package base_entidades;

public abstract class Produto{
    private double precoDeCusto;
    private String marca;
    private int estoque;

    public Produto(double precoDeCusto, String marca) {
        this(precoDeCusto, marca, 5);
    }
    
    public Produto(double precoDeCusto, String marca, int estoque) {
        this.precoDeCusto = precoDeCusto;
        this.marca = marca;
        this.estoque = estoque;
    }

    public double getPrecoDeCusto() {
        return this.precoDeCusto;
    }

    public void setPrecoDeCusto(double preco) {
        this.precoDeCusto = preco;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public abstract double precoFinal();

    public abstract String toString();
    
    public abstract String getTipo();

    public int getEstoque() {
        return this.estoque;
    }
    public boolean vender() {
        if (this.estoque > 0) {
            --this.estoque;
            return true;
        }
        return false;
    }


}