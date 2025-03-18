import java.time.DateTimeException;
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


    public void cadastrarTarefa() {

        String titulo;

        while(true) {
            System.out.print("Digite o titulo da tarefa: ");
            titulo = scanner.nextLine();
            if (titulo.length() < 10) {
                System.out.println("*** Informe um titulo com mais de 10 caracters **");
            } else break;
        }

        System.out.print("Digite o descrição da tarefa: ");
        String descricao = scanner.nextLine();

        LocalDate dataHoje = LocalDate.now();

        while (true) {
            System.out.print("Digite o data (dd/MM/yy) limite da tarefa: ");
            String dataLimiteTexto = scanner.nextLine();

            try {
                LocalDate dataLimite = LocalDate.parse(dataLimiteTexto, formatter);

                if (dataLimite.isBefore(dataHoje)) {
                    System.out.println("*** Data Invalida. A Data não pode ser menor que hoje **");
                } else {

                    Tarefa tarefa = new Tarefa(titulo, descricao, dataLimite, StatusTarefa.PENDENTE);
                    tarefas.add(tarefa);

                    System.out.println("*** Tarefa cadastrada com sucesso !!! **");
                    break;
                }

            } catch (DateTimeException e) {
                System.out.println("*** Formato da data invalido (dd/MM/yy) **");
            }


        }
    }

    public void FiltrarTarefas(){


    }

    public void ListarTarefasOrdenadas(){
        tarefas.sort((tarefa1, tarefa2) -> tarefa1.getDataLimite().compareTo(tarefa2.getDataLimite()));
        System.out.println("Tarefas: ");
        tarefas.forEach(System.out::println);

    }
}
