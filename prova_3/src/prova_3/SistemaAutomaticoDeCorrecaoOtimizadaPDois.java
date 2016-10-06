package prova_3;

import aluno.Aluno;
import atividades.Atividade;
import avaliacoes.Avaliacao;

import java.util.ArrayList;

public class SistemaAutomaticoDeCorrecaoOtimizadaPDois implements SistemaAutomaticoDeCorrecaoOtimizadaPDoisIf {

	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Atividade> atividades = new ArrayList<Atividade>();
	private ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	private Aluno aluno;
	private Atividade atividade;
	private Avaliacao avaliacao;
	private final double MINITESTE = 0.1;
	
	@Override
	public void cadastraAluno(String nome, String matricula, boolean repetente) throws Exception {
		alunos.add(aluno = new Aluno(nome, matricula, repetente));
	}

	@Override
	public String consultaAluno(String matricula) throws Exception {
		for(Aluno a : alunos) {
			if(a.getMatricula().equals(matricula)) {
				if(a.isRepetente()) {
					return a.getNome() + " (R) - " + a.getMatricula();
				}
				return a.getNome() + " - " + a.getMatricula();
			}
		}
		return null;
	}

	@Override
	public void cadastraAtividade(String tituloAtividade, String tipo) throws Exception {
		atividades.add(atividade = new Atividade(tituloAtividade, tipo));
	}

	@Override
	public String consultaAtividade(String tituloAtividade) throws Exception {
		for(Atividade a : atividades) {
			if(a.getTitulo().equalsIgnoreCase(tituloAtividade)) {
				return a.getTipo();
			}
		}
		return null;
	}

	@Override
	public void adicionaAvaliacao(String matricula, String atividade, int nota, String[] comentarios) throws Exception {
		avaliacoes.add(avaliacao = new Avaliacao(matricula, atividade, nota, comentarios));
	}

	@Override
	public String getComentarios(String matricula, String tituloAtividade) throws Exception {
		String tipoAtividade = null;
		String comentarios = null;
		tipoAtividade = pesquisaTipoAtividade(tituloAtividade);
		for(Avaliacao a : avaliacoes) {
			if(a.getMatricula().equalsIgnoreCase(matricula)) {
				if(tipoAtividade.equalsIgnoreCase("minilaboratorio")) {
					if(a.getComentarios().length == 1) {
						return a.getComentarios()[0];
					} else if(a.getComentarios().length > 2) {
						return a.getComentarios()[0]+ ", " + a.getComentarios()[1];
					}
				}
			}
				
			if(tipoAtividade.equalsIgnoreCase("laboratorio")) {
				return a.getComentarios().toString();
			}
		}
		return null;
	}

	@Override
	public void trocarTipoAtividade(String tituloAtividade, String tipo) throws Exception {
		Atividade a = pesquisaAtividade(tituloAtividade);
		a.setTipo(tipo);
	}

	@Override
	public int getNotaFinal(String matricula, String tituloAtividade) throws Exception {
		for(Avaliacao a : avaliacoes) {
			
		}
		return 0;
	}

	@Override
	public int getNotaFinal(String matricula) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void importaAtividades(String filename) throws Exception {
		// TODO Auto-generated method stub

	}
	
	private Atividade pesquisaAtividade(String titulo) {
		for(Atividade a : atividades) {
			if(a.getTitulo().equals(titulo)) {
				return a;
			}
		}
		return null;
	}
	
	private String pesquisaTipoAtividade(String titulo) {
		for(Atividade a : atividades) {
			if(a.getTitulo().equalsIgnoreCase(titulo)) {
				return a.getTipo();
			}
		}
		return null;
	}

}
