package atividades;

public class Atividade {
	
	private String titulo, tipo;
	
	public Atividade(String titulo, String tipo) throws Exception {
		if(titulo == null || titulo.trim().isEmpty()) {
			throw new Exception("O titulo nao pode ser nulo ou vazio");
		}
		
		if(tipo == null || tipo.trim().isEmpty()) {
			throw new Exception("O tipo nao pode ser nulo ou vazio");
		}
		
		this.titulo = titulo;
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Atividade) {
			Atividade other = (Atividade) obj;
			if(other.getTipo().equalsIgnoreCase(tipo)) {
				if(other.getTitulo().equalsIgnoreCase(titulo)) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}

	
	
}
