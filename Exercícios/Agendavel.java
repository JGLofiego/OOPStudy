import java.time.LocalDate;

public interface Agendavel {

    boolean estaDisponivel(LocalDate dataInicio, LocalDate dataFim);
    float valorTotal(LocalDate data);
    float valorTotal(LocalDate dataInicio, LocalDate dataFim);

}
