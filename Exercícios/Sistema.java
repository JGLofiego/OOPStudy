import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Escreva uma descrição da classe Sistema aqui.
 * 
 * @author (João Gabriel Lofiego) 
 * @version (um número da versão ou uma data)
 */
public class Sistema
{
    private static ArrayList<Proprietario> proprietarios = new ArrayList<Proprietario>();
    private static ArrayList<Imovel> imoveis = new ArrayList<Imovel>();

    public static void cadastrar(){
        Scanner scan = new Scanner(System.in);
        String response = "";

        while(!response.equals("n")){
            System.out.println("Cadastrar proprietário ou imóvel (p | i):");
            response = scan.nextLine();
            
            while(!response.equals("p") && !response.equals("i")){
                System.out.println("\nValor inválido, digite novamente (p | i):");
                response = scan.nextLine();
            }

            if(response.equals("p")){
                try{
                    adicionarProprietario(readProprietario(scan));
                } catch(UsuarioExistenteException err){
                    System.out.println("\n" + err.getMessage());
                    continue;
                }
            } else if(response.equals("i")){
                adicionarImovel(readImovel(scan));
            } 

            System.out.println("Cadastrar mais? (s | n) :");
            response = scan.nextLine();
        }
    }

    public static Proprietario readProprietario(Scanner scan){
        System.out.println("Digite os dados do proprietário:");

        System.out.println("\nNome: ");
        String nome = scan.nextLine();

        System.out.println("\nCPF: ");
        long cpf = Long.valueOf(scan.nextLine());

        System.out.println("\nRG: ");
        long rg = Long.valueOf(scan.nextLine());

        System.out.println("\nRua: ");
        String street = scan.nextLine();

        System.out.println("\nNúmero: ");
        int nmr = Integer.valueOf(scan.nextLine());

        System.out.println("\nCEP: ");
        long cep = Long.valueOf(scan.nextLine());

        System.out.println("\nEstado: ");
        String state = scan.nextLine();

        System.out.println("\nCidade: ");
        String city = scan.nextLine();

        Proprietario p;

        if(state.equals("") && city.equals("")){
            p = new Proprietario(nome, cpf, rg, street, nmr, cep);
        } else {
            p = new Proprietario(nome, cpf, rg, street, nmr, cep, state, city);
        }
        return p;
    }

    public static Imovel readImovel(Scanner scan){
        System.out.println("Digite os dados do proprietário:");

        System.out.println("\nIPTU: ");
        long iptu = Long.valueOf(scan.nextLine());

        System.out.println("\nRua: ");
        String street = scan.nextLine();

        System.out.println("\nNúmero: ");
        int nmr = Integer.valueOf(scan.nextLine());

        System.out.println("\nCEP: ");
        long cep = Long.valueOf(scan.nextLine());

        System.out.println("\nEstado: ");
        String state = scan.nextLine();

        System.out.println("\nCidade: ");
        String city = scan.nextLine();

        System.out.println("\nTipo de imovél(Casa, Apartamento e etc...): ");
        String type = scan.nextLine();

        System.out.println("\nUtilização(de praia, de verão e etc...): ");
        String util = scan.nextLine();

        System.out.println("\nAutônomo ou Compartilhado (a/c)): ");
        String qualClasse = scan.nextLine();

        while (!qualClasse.equals("a") && !qualClasse.equals("c")){
            System.out.println("\nERRO, digite novamente (a/c): ");
            qualClasse = scan.nextLine();
        }

        Imovel p;

        if(qualClasse.equals("a")){
            System.out.println("\nAréa utilizada: ");
            float areaU = Float.valueOf(scan.nextLine());

            System.out.println("\nAréa Construida: ");
            float areaC = Float.valueOf(scan.nextLine());

            p = new ImovelAuto(iptu, street, nmr, cep, state, city, type, util, areaU, areaC);
        } else {
            System.out.println("\nIdentificação: (Apto, Unidade ou etc...): ");
            String id = scan.nextLine();

            p = new ImovelComp(iptu, street, nmr, cep, state, city, type, util, id);
        }

        
        return p;
    }

    public static float aluguelComIndice(Imovel im, int ind){
        float valor = im.calculaAluguelBase();
        float indiceSazon = 1.0f;

        if(ind > 4){
            ind = 4;
        } else if(ind < 0){
            ind = 0;
        }

        if(im instanceof ImovelComp){
            ImovelComp aux = (ImovelComp)im;
            if(aux.getCondominio().getItens().size() == 0){
                valor = valor * 0.9f;
            }
        }

        if (ind > 0){
            indiceSazon += (0.25f - (0.05f * ind));
        }

        return valor * indiceSazon;
    }

    public static float aluguelComIndice(Imovel im, LocalDate inicio, LocalDate fim){
        int ind = im.getAgenda().calculaIndice(inicio, fim);
        float valor = aluguelComIndice(im, ind);
        long qtdDias = fim.toEpochDay() - inicio.toEpochDay();

        return valor * qtdDias;
    }

    public static boolean adicionarProprietario(Proprietario p) throws UsuarioExistenteException{
        boolean result = checkProprietario(p);

        if(result){
            return proprietarios.add(p);
        } else {
            return false;
        }

    }
    
    public static boolean adicionarImovel(Imovel im){
        return imoveis.add(im);
    }

    //retorna true caso proprietario pode ser adicionado
    public static boolean checkProprietario(Proprietario prop) throws UsuarioExistenteException{
        for(Proprietario p : proprietarios){
            boolean result = p.equals(prop);
            if(result){
                throw new UsuarioExistenteException("Usuário já está cadastrado!");
            }
        }
        return true;
    }
}
