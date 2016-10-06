package avaliacoes;

import java.util.Arrays;

public class Avaliacao {
	private String matricula, titulo;
	private int nota;
	private String[] comentarios;
	
	public Avaliacao(String matricula, String titulo, int nota, String[] comentarios) throws Exception {
		if(matricula == null || matricula.trim().isEmpty()) {
			throw new Exception("A matricula nao pode ser nula ou vazia");
		}
		
		if(titulo == null || titulo.trim().isEmpty()) {
			throw new Exception("O titulo nao pode ser nulo ou vazio");
		}
		
		if(nota < 0) {
			throw new Exception("A nota nao pode ser negativa");
		}
		if(comentarios.length == 0) {
			throw new Exception("Sem comentarios? O bixin do aluno :(");
		}
		
		this.matricula = matricula;
		this.titulo = titulo;
		this.nota = nota;
		this.comentarios = comentarios;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String[] getComentarios() {
		return comentarios;
	}

	public void setComentarios(String[] comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(comentarios);
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + nota;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Avaliacao) {
			Avaliacao other = (Avaliacao) obj;
			if(other.getMatricula().equalsIgnoreCase(matricula)) {
				if(other.getTitulo().equalsIgnoreCase(titulo)) {
					if(other.getNota() == nota) {
						return true;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	
}
