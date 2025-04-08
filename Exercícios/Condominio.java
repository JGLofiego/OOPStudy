import java.util.ArrayList;

/**
 * Escreva uma descrição da classe Condominio aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Condominio
{
    private Endereco endereco;
    private ArrayList<String> itens;

    
    public Condominio(String street, int number, long cep, String state, String city){
        this.endereco = new Endereco(street, number, cep, state, city);
        this.itens = new ArrayList<String>();
    }

    public boolean addItem(String item){
        return this.itens.add(item);
    }

    public ArrayList<String> getItens(){
        return this.itens;
    }

    public Endereco getEndereco(){
        return this.endereco;
    }

    public void setItens(ArrayList<String> lista){
        this.itens = lista;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
}
