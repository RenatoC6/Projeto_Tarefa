



public interface GerenciadorDeTarefas {
    void InserirTarefaLista(Tarefa tarefa);
    void alterarStatusTarefa(String titulo, StatusTarefa novoStatus);
    void listarTarefasOrdenadas();
    void listarTarefasPorStatus(StatusTarefa Status);
    boolean buscarTarefaPorTitulo(String titulo);

}
