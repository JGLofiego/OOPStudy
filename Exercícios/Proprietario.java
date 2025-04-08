import java.util.ArrayList;
/**
 * Escreva uma descrição da classe Proprietario aqui.
 * 
 * @author (João Gabriel Lofiego) 
 * @version (19/04/2023)
 */
public class Proprietario {
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String name;
    private long cpf;
    private long rg;
    private Endereco address;
    private ArrayList<Imovel> properties;

    /**
     * Construtor para objetos da classe Proprietario
     */
    public Proprietario(String name, long cpf, long rg, String street, int number, long cep, String state, String city){
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.address = new Endereco(street, number, cep, state, city);
        this.properties = new ArrayList<Imovel>();
    }

    public Proprietario(String name, long cpf, long rg, String street, int number, long cep){
        this(name, cpf, rg, street, number, cep, "BA", "Salvador");
    }

    //Métodos get
    public String getName(){
        return this.name;
    }

    public long getCpf(){
        return this.cpf;
    }

    public long getRg(){
        return this.rg;
    }

    public Endereco getAddress(){
        return this.address;
    }

    public int getNumProperties(){
        return this.properties.size();
    }

    //Métodos set
    public void setName(String name){
        this.name = name;
    }

    public void setCpf(long cpf){
        this.cpf = cpf;
    }

    public void setRg(long rg){
        this.rg = rg;
    }

    public void updateAdress(String street, int number, long cep, String state, String city){
        this.address.updateAdress(street, number, cep, state, city);
    }

    public void updateAdress(String street, int number, long cep){
        this.address.updateAdress(street, number, cep);
    }

    public boolean addProperty(Imovel property){
        if( this.address.isEqual(property.getAddress())){
            return false;
        }

        boolean result = this.properties.add(property);

        return result;
    }

    public void listProperties(String type){
        if(this.properties.isEmpty()){
            System.out.println("Lista vazia");
            return;
        }
        System.out.println("Lista do tipo " + type + "\n");
        for(int i = 0; i < this.properties.size(); i++){
            if(this.properties.get(i).getType().equalsIgnoreCase(type)){
                System.out.println(this.properties.get(i).toString());
            }
        }
    }

    public void listProperties(){
        if(this.properties.isEmpty()){
            System.out.println("Lista vazia");
            return;
        }
        System.out.println("Lista Completa" + "\n");
        for(int i = 0; i < this.properties.size(); i++){
            System.out.println(this.properties.get(i).toString());
        }
    }
}
