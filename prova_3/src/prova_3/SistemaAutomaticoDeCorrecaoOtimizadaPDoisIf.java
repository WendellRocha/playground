package prova_3;

public interface SistemaAutomaticoDeCorrecaoOtimizadaPDoisIf {

	void cadastraAluno(String nome, String matricula, boolean repetente) throws Exception;
	String consultaAluno(String matricula) throws Exception;

	void cadastraAtividade(String tituloAtividade, String tipo) throws Exception;
	String consultaAtividade(String tituloAtividade) throws Exception;
	
	void adicionaAvaliacao(String matricula, String atividade, int nota, String[] comentarios) throws Exception;
	
	String getComentarios(String matricula, String tituloAtividade) throws Exception;
	
	void trocarTipoAtividade(String tituloAtividade, String tipo) throws Exception;

	int getNotaFinal(String matricula, String tituloAtividade) throws Exception;
	int getNotaFinal(String matricula) throws Exception;
	
	void importaAtividades(String filename) throws Exception;
}