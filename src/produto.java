
package programação1;


public class produto {
       private String nome;
       private String unidade;
       private int quantidade;
       private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
     public void setAdicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void setDiminuirQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }
    
    public void setReajustePreco(double preco){
        this.preco += preco;
    }

   
    @Override
    public String toString() {
        return  "NOME: " + nome + "\n"
                + "PREÇO: " + preco + "\n"
                + "UNIDADE: " + unidade + "\n"
                + "QUANTIDADE: " + quantidade;
    }
 
     
}
