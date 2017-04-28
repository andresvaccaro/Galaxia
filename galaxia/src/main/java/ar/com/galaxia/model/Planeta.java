package ar.com.galaxia.model;

import ar.com.galaxia.enumerados.SentidoEnum;
import ar.com.galaxia.utils.PuntoCatesiano;

public class Planeta {
	
	public PuntoCatesiano posicion;
	public PuntoCatesiano posicionInicial;
	public SentidoEnum sentidoDesplazamiento;
	public Double velocidadAngular;
	public Double distanciaAlSol;
	
	public Planeta(Double angulo,Double velocidadAngula ,SentidoEnum sentido,Double distanciaAlSol) {
		super();
		this.posicion = new PuntoCatesiano();
		this.posicion.cargarAnguloYLongitud(angulo,distanciaAlSol);
		this.posicionInicial = new PuntoCatesiano();
		this.posicionInicial.cargarAnguloYLongitud(angulo,distanciaAlSol);
		this.sentidoDesplazamiento = sentido;
		this.velocidadAngular = velocidadAngula;
		this.distanciaAlSol= distanciaAlSol;
	}


	public int obtenerVueltasEnDias(int dias) {
		return (int) ((velocidadAngular*dias)/360);
	}
	
	public Double obtenerAnguloDentroDeDias(int dias) {
		Double anguloFinal = 0D;		
		anguloFinal = (double) dias * velocidadAngular;
		int vueltas = obtenerVueltasEnDias(dias);
		if(this.sentidoDesplazamiento.equals(SentidoEnum.ANTIHORARIO)){
			anguloFinal= posicion.getAnguloEnGrados() - (anguloFinal-vueltas*360);
		}else{
			anguloFinal= posicion.getAnguloEnGrados() + (anguloFinal-vueltas*360);
		}
		if(anguloFinal<0){
			anguloFinal=anguloFinal+360;
		}
		return anguloFinal;
	}


	public Boolean estaAlineadoCon(Planeta planeta) {
		return this.posicion.getAnguloEnGrados().equals(planeta.getPosicion().getAnguloEnGrados());
	}

	public void avanzarPosicion(){
		this.posicion.cargarAnguloYLongitud(obtenerAnguloDentroDeDias(1), distanciaAlSol);
	}
	

	public PuntoCatesiano getPosicion() {
		return posicion;
	}


	public void setPosicion(PuntoCatesiano posicion) {
		this.posicion = posicion;
	}


	public Double getDistanciaAlSol() {
		return distanciaAlSol;
	}


	public PuntoCatesiano getPosicionInicial() {
		return posicionInicial;
	}


	public void setPosicionInicial(PuntoCatesiano posicionInicial) {
		this.posicionInicial = posicionInicial;
	}


	public void reestablecerPosicionInicial() {
		this.posicion.setX(this.posicionInicial.getX());
		this.posicion.setY(this.posicionInicial.getY());
		this.posicion.cargarAnguloYLongitud(this.posicionInicial.getAnguloEnGrados(), distanciaAlSol);
		
	}
	
	
	
}
