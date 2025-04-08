
/**
 * Escreva uma descrição da classe Enderecos aqui.
 * 
 * @author (João Gabriel Lofiego) 
 * @version (19/04/23)
 */
public class Endereco{
    public enum States{
        AC, AL, AP, AM, BA, CE, ES, GO, MA, MT, MS, MG, PA , PB, PR, PE, PI, RJ, RN, RS, RO, RR, SC, SP, SE, TO, DF
    }
    private String street;
    private int number;
    private long cep;
    private String state;
    private String city;

    
    public Endereco(String street, int number, long cep, String state, String city){
        this.street = street;
        this.number = number;
        this.cep = cep;
        this.city = city;
        this.state = "ERRO";

        for(States s : States.values()){
            if(state.equalsIgnoreCase(s.toString())){
                this.state = s.toString();
            }
        }
    }

    //Métodos Get

    public String getStreet(){
        return this.street;
    }

    public int getNumber(){
        return this.number;
    }

    public long getCep(){
        return this.cep;
    }

    public String getState(){
        return this.state;
    }

    public String getCity(){
        return this.city;
    }

    //Métodos Set

    public void setStreet(String street){
        this.street = street;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public void setCep(long cep){
        this.cep = cep;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void updateAdress(String street, int number, long cep, String state, String city){
        this.street = street;
        this.number = number;
        this.cep = cep;
        this.state = state;
        this.city = city;
    }

    public void updateAdress(String street, int number, long cep){
        this.street = street;
        this.number = number;
        this.cep = cep;
    }

    public boolean isEqual(Endereco address){
        if(this.cep != address.cep){
            return false;
        }

        if(this.city != address.city){
            return false;
        }

        if(this.number != address.number){
            return false;
        }

        if(this.state != address.state){
            return false;
        }

        if(this.street != address.street){
            return false;
        }

        return true;
    }

    public String toString(){
        String str = "CEP: " + this.cep;
            str += "\nRua: " + this.street;
            str += "\nNúmero: " + this.number;
            str += "\nEstado: " + this.state;
            str += "\nCidade: " + this.city;
        return str;
    }
}
