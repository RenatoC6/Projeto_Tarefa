import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorTarefa {

    private List<Tarefa> tarefas;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public GerenciadorTarefa() {
        this.tarefas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
    }


    public void cadastrarTarefa(){

        System.out.print("Digite o titulo da tarefa: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o descrição da tarefa: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o data limite da tarefa: (dd/MM/yy");
        String dataLimiteString = scanner.nextLine();
        LocalDate dataLimite = LocalDate.parse(dataLimiteString,formatter);

        Tarefa tarefa = new Tarefa(titulo, descricao,dataLimite,StatusTarefa.PENDENTE);
        tarefas.add(tarefa);
    }

    public void FiltrarTarefas(){


    }

    public void ListarTarefasOrdenadas(){
        tarefas.sort((tarefa1, tarefa2) -> tarefa1.getDataLimite().compareTo(tarefa2.getDataLimite()));
        System.out.println("Tarefas: ");
        tarefas.forEach(System.out::println);

    }
}
