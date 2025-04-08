import java.time.LocalDate;

/**
 * Escreva uma descrição da classe Imovel aqui.
 * 
 * @author (João Gabriel Lofiego) 
 * @version (11/06/2023)
 */
public abstract class Imovel implements Agendavel{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private long iptu;
    private String type;
    private String util;
    private Endereco address;
    private Agenda agenda;

    /**
     * Construtor para objetos da classe Imovel
     */
    public Imovel(long iptu, String street, int number, long cep, String state, String city, String type, String util){
        // inicializa variáveis de instância
        this.iptu = iptu;
        this.type = type;
        this.util = util;
        this.address = new Endereco(street, number, cep, state, city);
        this.agenda = new Agenda();
    }

    //Construtor caso não tenha estado e cidade
    public Imovel(long iptu, String street, int number, long cep, String type, String util){
        this(iptu, street, number, cep, "BA", "Salvador", type, util);
    }

    //Métodos get

    public long getIptu(){
        return this.iptu;
    }

    public String getType(){
        return this.type;
    }

    public String getUtil(){
        return this.util;
    }

    public Endereco getAddress(){
        return this.address;
    }

    public Agenda getAgenda(){
        return this.agenda;
    }

    // Métodos sets

    public void setIptu(long iptu){
        this.iptu = iptu;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setUtil(String util){
        this.util = util;
    }

    public void updateAdress(String street, int number, long cep, String state, String city){
        this.address.updateAdress(street, number, cep, state, city);
    }

    public void updateAdress(String street, int number, long cep){
        this.address.updateAdress(street, number, cep);
    }

    public abstract float calculaAluguelBase();

    @Override
    public boolean estaDisponivel(LocalDate inicio, LocalDate fim){
        for(LocalDate date : this.agenda.getDatas()){
            if(date.isAfter(inicio) && date.isBefore(fim)){
                return false;
            }
        }
        return true;
    }

    @Override
    public float valorTotal(LocalDate inicio, LocalDate fim){
        long qtdDias = fim.toEpochDay() - inicio.toEpochDay();
        
        return qtdDias * this.calculaAluguelBase();
    }

    @Override
    public float valorTotal(LocalDate data){
        return this.calculaAluguelBase();
    }

    public String toString(){
        String str = "\n===========================";
            str += "\nIPTU: " + this.iptu;
            str += "\nTipo: " + this.type;
            str += "\nUtilidade: " + this.util;
            str += "\n" + this.address.toString();
        return str;
    }
}
