package entidades;

import base_entidades.Produto;

public class Impressora extends Produto {
    private int ppm; // páginas por minuto

    public Impressora(String marca, double preco, int ppm) {
        super(preco, marca);
        this.ppm = ppm;
    }

    @Override
    public double precoFinal(){
        double taxa=1.2;
        if (this.ppm >= 20){
            taxa = 1.3;
        }
        return this.getPrecoDeCusto() * taxa;
    }

    @Override
    public String toString(){
        return String.format("Impressora com %d ppm", this.ppm);
    }

    @Override
    public String getTipo(){
        return "Impressora";
    }

    public int getPpm() {
        return this.ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }
}
