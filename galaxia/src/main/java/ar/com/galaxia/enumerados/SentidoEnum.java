package ar.com.galaxia.enumerados;

public enum SentidoEnum {
	HORARIO("Sentido horario",1L), 
	ANTIHORARIO("Sentido Antiorario",2L);
	
	private String descripcion;
	private Long id;
	
	private SentidoEnum(String descripcion, Long id){
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
