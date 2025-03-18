import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

     GerenciadorTarefa gerenciador = new GerenciadorTarefa();

     while (true) {
            System.out.println("==========================================");
            System.out.println("1. Cadastrar tarefa");
            System.out.println("2. Filtrar tarefas por Status");
            System.out.println("3. Listar tarefas Ordenas por data");
            System.out.println("4. Sair");
            System.out.print("Digite a opção desejada: ");
            System.out.println("==========================================");
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            sc.nextLine(); // Consumir o caractere de newline
            switch (opcao) {
                case 1:
                    gerenciador.cadastrarTarefa();
                    break;
                case 2:
                    gerenciador.FiltrarTarefas();
                    break;
                case 3:
                    gerenciador.ListarTarefasOrdenadas();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }


    }
}