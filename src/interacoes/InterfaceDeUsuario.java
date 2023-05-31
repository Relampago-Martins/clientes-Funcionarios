package interacoes;

import java.util.Scanner;
import java.util.ArrayList;
import base_entidades.Produto;
import entidades.Notebook;
import entidades.Impressora;
import entidades.TotalizadorDeVendas;


public class InterfaceDeUsuario {
	Scanner leitor = new Scanner(System.in);
    ArrayList<Produto> produtos = new ArrayList<>();
    ArrayList<Produto> vendidos = new ArrayList<>();

    public void menuPrincipal(){
        boolean continuar=true;

        double preco;
        String marca;
        double tamanhoTela;
        int memoriaRam, ppm;


        while(continuar){
            switch(this.getOption()){
                case 1:
                    System.out.println("Cadastrar Notebook");
                    System.out.print("Marca do notebook: ");
                    marca = this.leitor.nextLine();
                    System.out.print("Preço do notebook: ");
                    preco = this.leitor.nextDouble();
                    System.out.print("Tamanho da tela do notebook: ");
                    tamanhoTela = this.leitor.nextDouble();
                    System.out.print("Memória RAM do notebook: ");
                    memoriaRam = this.leitor.nextInt();
                    this.leitor.nextLine();

                    this.produtos.add(new Notebook(marca, preco, tamanhoTela, memoriaRam));
                    break;
                case 2:
                    System.out.println("Cadastrar Impressora");
                    System.out.print("Marca da impressora: ");
                    marca = this.leitor.nextLine();
                    System.out.print("Preço da impressora: ");
                    preco = this.leitor.nextDouble();
                    System.out.print("PPM da impressora: ");
                    ppm = this.leitor.nextInt();
                    this.leitor.nextLine();

                    this.produtos.add(new Impressora(marca, preco, ppm));
                    break;
                case 3:
                    System.out.println("Listar todos os produtos cadastrados");
                    for (Produto produto : this.produtos) {
                        System.out.printf("  %s\n", produto);
                    }
                    break;
                case 4:
                    System.out.println("Listar os produtos com preço até <valor>");
                    System.out.print("Valor: ");
                    preco = this.leitor.nextDouble();

                    for (Produto produto: this.produtos){
                        if (produto.precoFinal() <= preco){
                            System.out.printf("  %s - R$%.2f\n", produto, produto.precoFinal());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Vender produto");
                    System.out.print("Nome do produto: ");
                    String nome = this.leitor.nextLine();
                    System.out.print("Marca do produto: ");
                    marca = this.leitor.nextLine();

                    for(Produto produto: this.produtos){
                        if (produto.getMarca().equals(marca) && produto.getTipo().equals(nome)){
                            if (produto.vender()){
                                this.vendidos.add(produto);
                                System.out.printf("  %s vendido por R$%.2f\n", produto, produto.precoFinal());
                            } else {
                                System.out.println("  Produto não disponível");
                                this.produtos.remove(produto);
                            }
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Consultar total de vendas");
                    TotalizadorDeVendas totalizador = new TotalizadorDeVendas();
                    System.out.printf("  Total de vendas: R$%.2f\n", totalizador.verificaOTotal(this.vendidos));
                    break;
                default:
                    continuar = false;
                    break;
            }
        }
    }

    public int getOption(){
        System.out.println("Menu:\n"+
        "  (1) Cadastrar Notebook\n"+
        "  (2) Cadastrar Impressora\n"+
        "  (3) Listar todos os produtos cadastrados\n"+
        "  (4) Listar os produtos com preço até <valor>\n"+
        "  (5) Vender produto\n"+
        "  (6) Consultar total de vendas\n"+
        "  (Outros) Encerrar programa"
        );
        int optionNum = this.leitor.nextInt();
        this.leitor.nextLine();

        return optionNum;
    }
}
