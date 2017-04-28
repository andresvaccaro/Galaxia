package ar.com.galaxia.utils;

public class Recta {

	private PuntoCatesiano vectorDirector;
	private PuntoCatesiano puntoDePaso;
	
	public Recta(PuntoCatesiano puntoDePaso1, PuntoCatesiano puntoDePaso2) {
		super();
		this.vectorDirector = puntoDePaso1.menos(puntoDePaso2);
		this.puntoDePaso = puntoDePaso1;
	}
	
	public Boolean elPuntoPerteneceALaRecta(PuntoCatesiano punto){		
		if(vectorDirector.getX().equals(0D)){
			if(vectorDirector.getY().equals(0D)){
				return (this.puntoDePaso.equals(punto));
			}else{
				return (this.puntoDePaso.getX().equals(punto.getX()));
			}
		}else{
			if(vectorDirector.getY().equals(0D)){								
				return (this.puntoDePaso.getY().equals(punto.getY()));
			}
		}
		Double lamda= (punto.getX()-this.puntoDePaso.getX())/this.vectorDirector.getX();		
		return punto.getY().equals((lamda*this.vectorDirector.getY())+this.puntoDePaso.getY());
	}
	
	
}
