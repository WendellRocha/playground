package aluno;

public class Aluno {

	private String nome;
	private String matricula;
	private boolean repetente;
	
	public Aluno(String nome, String matricula, boolean repetente) throws Exception {
		if(nome == null || nome.trim().isEmpty()) {
			throw new Exception("Nome nulo ou vazio");
		}
		
		if(matricula == null || matricula.trim().isEmpty()) {
			throw new Exception("Matricula nula ou vazia");
		}
		
		this.nome = nome;
		this.matricula = matricula;
		this.repetente = repetente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isRepetente() {
		return repetente;
	}

	public void setRepetente(boolean repetente) {
		this.repetente = repetente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (repetente ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Aluno) {
			Aluno other = (Aluno) obj;
			if(other.getNome().equalsIgnoreCase(nome)) {
				if(other.getMatricula().equalsIgnoreCase(matricula)) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	
	
}
