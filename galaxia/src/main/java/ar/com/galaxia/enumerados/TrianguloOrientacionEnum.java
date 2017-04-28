package ar.com.galaxia.enumerados;

public enum TrianguloOrientacionEnum {
	
	POSITIVA(0L, "Positiva"),
	NEGATIVA(1L, "Negativa"), ALINEADOS(1L, "Alineados");
					
	private Long id;
	private String descripcion;
	
	TrianguloOrientacionEnum(Long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

