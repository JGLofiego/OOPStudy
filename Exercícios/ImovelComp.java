
/**
 * Escreva uma descrição da classe ImovelComp aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ImovelComp extends Imovel
{
    private String id;
    private Condominio condominio;

    public ImovelComp(long iptu, String street, int number, long cep,
    String state, String city, String type, String util, String id){

        super(iptu, street, number, cep, type, util);
        this.condominio = new Condominio(street, number, cep, state, city);
        this.id = id;

    }

    @Override
    public float calculaAluguelBase() {
        float size = this.getCondominio().getItens().size();

        if (size == 0){
            size = 0.1f;
        }

        return this.getIptu() * size;
    }

    @Override
    public String toString(){
        return super.toString() + "\nComplemento: " + this.id;
    }

    public Condominio getCondominio(){
        return this.condominio;
    }

    public String getId(){
        return this.id;
    }

    public void setCondominio(Condominio condominio){
        this.condominio = condominio;
    }

    public void setId(String id){
        this.id = id;
    }

    
}
