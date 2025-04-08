/**
 * Escreva uma descrição da classe ImovelAuto aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ImovelAuto extends Imovel
{
    private float areaU;
    private float areaC;

    
    public ImovelAuto(long iptu, String street, int number, long cep,
    String state, String city, String type, String util, float areaU, float areaC){

        super(iptu, street, number, cep, type, util);
        this.areaU = areaU;
        this.areaC = areaC;
    }

    @Override
    public float calculaAluguelBase(){
        return this.areaC * 15;
    }

    @Override
    public String toString(){
        return super.toString() + "\nArea Utilizada: " + this.areaU + "\nArea Construida: " + this.areaC;
    }

    public float getAreaU(){
        return this.areaU;
    }

    public float getAreaC(){
        return this.areaC;
    }

    public void setAreaU(float areaU){
        this.areaU = areaU;
    }

    public void setAreaC(float areaC){
        this.areaC = areaC;
    }
    
}
