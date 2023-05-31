package entidades;

import java.util.ArrayList;
import base_entidades.Produto;

public class TotalizadorDeVendas {
    
    public double verificaOTotal(ArrayList<Produto> vendidos){
        double total=0;
        for (Produto produto: vendidos){
            total = produto.precoFinal();
        }
        return total;
    }

}
