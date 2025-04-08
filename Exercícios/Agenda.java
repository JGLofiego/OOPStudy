import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Escreva uma descrição da classe Agenda aqui.
 * 
 * @author (João Gabriel Lofiego) 
 * @version (11/06/2023)
 */
public class Agenda
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private ArrayList<LocalDate> datas;
    public static final LocalDate reveillonI = LocalDate.of(2000, 12, 30);
    public static final LocalDate reveillonF = LocalDate.of(2000, 1, 1);
    public static final LocalDate carnavalI = LocalDate.of(2000, 2, 15);
    public static final LocalDate carnavalF = LocalDate.of(2000, 2, 22);
    public static ArrayList<LocalDate> feriadoA = new ArrayList<LocalDate>();
    public static ArrayList<LocalDate> feriadoB = new ArrayList<LocalDate>();


    /**
     * Construtor para objetos da classe Agenda
     */
    public Agenda(){
       this.datas = new ArrayList<LocalDate>();
    }

    public boolean adicionarData(LocalDate date){

        if(this.datas.contains(date)){
            return false;
        }

        return this.datas.add(date);
    }

    public boolean adicionarData(int d, int m, int a){   
        LocalDate date = LocalDate.of(a, m, d);
        return this.adicionarData(date);
    }

    public boolean adicionarFeriadoA(int a, int m, int d){
        LocalDate date = LocalDate.of(a, m, d);

        if(feriadoA.contains(date)){
            return false;
        }

        return feriadoA.add(date);
    }

    public boolean adicionarFeriadoB(int a, int m, int d){
        LocalDate date = LocalDate.of(a, m, d);

        if(feriadoB.contains(date)){
            return false;
        }

        return feriadoB.add(date);
    }

    public int calculaIndice(LocalDate inicio, LocalDate fim){
        if((inicio.isAfter(reveillonI) && inicio.isBefore(reveillonF)) || (inicio.isBefore(reveillonI) && fim.isAfter(reveillonF))){
            return 1;
        } else if((inicio.isAfter(carnavalI) && inicio.isBefore(carnavalF)) || (inicio.isBefore(carnavalI) && fim.isAfter(carnavalF))){
            return 2;
        }

        for(LocalDate feriado : feriadoA){
            if(feriado.isAfter(inicio) && feriado.isBefore(fim)){
                return 3;
            }
        }

        for(LocalDate feriado : feriadoB){
            if(feriado.isAfter(inicio) && feriado.isBefore(fim)){
                return 4;
            }
        }

        return 0;
    }

    public ArrayList<LocalDate> getDatas(){
        return this.datas;
    }

    

   
}
