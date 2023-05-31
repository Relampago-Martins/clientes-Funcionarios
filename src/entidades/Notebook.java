package entidades;

import base_entidades.Produto;

public class Notebook extends Produto {
    private double tamanhoTela;
    private int memoriaRam;

    public Notebook(String marca, double preco, double tamanhoTela, int memoriaRam) {
        super(preco, marca);
        this.tamanhoTela = tamanhoTela;
        this.memoriaRam = memoriaRam;
    }

    @Override
    public double precoFinal(){
        return this.getPrecoDeCusto() * 1.2;
    }

    @Override
    public String toString(){
        return String.format("Notebook com %d GB de RAM e tela de %.1f polegadas", this.memoriaRam, this.tamanhoTela);
    }

    @Override
    public String getTipo(){
        return "Notebook";
    }

    public double getTamanhoTela() {
        return this.tamanhoTela;
    }

    public void setTamanhoTela(double tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }

    public int getMemoriaRam() {
        return this.memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }
}
