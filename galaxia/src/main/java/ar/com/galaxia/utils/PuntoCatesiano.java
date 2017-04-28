package ar.com.galaxia.utils;

public class PuntoCatesiano {
	private Double x;
	private Double y;

	public PuntoCatesiano(Double x, Double y) {
		this.x = x;
		this.y = y;
	}
	
	public PuntoCatesiano() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Double getLongitud(){
		Double longitudSinRedondear=Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2));		 
		return Math.rint(longitudSinRedondear*1000)/1000;
	}
	
	public Double getAnguloEnGrados(){
		Double anguloEnGradosSinRedondear=Math.toDegrees(this.getAnguloEnRadianes());
		return Math.rint(anguloEnGradosSinRedondear*1000)/1000;
	}
	
	public Double getAnguloEnRadianes(){
		if(getLongitud()>0){
			Double anguloSinRedondear=Math.acos(this.x/getLongitud());
			return 	 anguloSinRedondear;
		}else {
			return 0D;
		}
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	
	public PuntoCatesiano menos(PuntoCatesiano punto) {	
		return new PuntoCatesiano(this.x-punto.getX(),this.y-punto.getY());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PuntoCatesiano other = (PuntoCatesiano) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

	public void cargarAnguloYLongitud(Double angulo, Double distanciaAlSol) {		
		this.x= Math.rint(distanciaAlSol* Math.cos(Math.toRadians(angulo))*1000)/1000;
		this.y= Math.rint(distanciaAlSol* Math.sin(Math.toRadians(angulo))*1000)/1000;		
	}

	public Double obtenerDistanciaCon(PuntoCatesiano punto) {
		return Math.sqrt( Math.pow( (this.x - punto.getX()), 2 ) + Math.pow( (this.y - punto.getY()), 2 ) );
	}
	
	
	
	
}
