package ar.com.galaxia.enumerados;

public enum CondicionClimaticaEnum {
	SEQUIA("Sequia",1L), 
	LLUVIA("Lluvia",2L),
	OPTIMA("Optima",3L),
	ALEATORIA("Aleatoria",4L),
	LLUVIAMAXIMA("Lluvia maxima",5L);
	
	private String descripcion;
	private Long id;
	
	private CondicionClimaticaEnum(String descripcion, Long id){
		this.descripcion = descripcion;
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}

