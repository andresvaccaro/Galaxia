package ar.com.galaxia.utils;

import ar.com.galaxia.enumerados.TrianguloOrientacionEnum;

public class Triangulo {

	private PuntoCatesiano vertice1;
	private PuntoCatesiano vertice2;
	private PuntoCatesiano vertice3;

	public Triangulo(PuntoCatesiano vertice1, PuntoCatesiano vertice2,
			PuntoCatesiano vertice3) {
		super();
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
		this.vertice3 = vertice3;
	}

	public TrianguloOrientacionEnum calcularOrientacion() {		
		Recta recta = new Recta(this.vertice1, this.vertice2);
		if(recta.elPuntoPerteneceALaRecta(this.vertice3)){
			return TrianguloOrientacionEnum.ALINEADOS;
		}
		Double result=(this.vertice1.getX()-this.vertice3.getX())*(this.vertice2.getY()- this.vertice3.getY()) - (this.vertice1.getY()- this.vertice3.getY())*(this.vertice2.getX()- this.vertice3.getX());		
		if (result>=0D ){
			return TrianguloOrientacionEnum.POSITIVA;
		} else {
			return TrianguloOrientacionEnum.NEGATIVA;
		}

	}

	public Boolean elPuntoPerteneceAlTriangulo(PuntoCatesiano punto) {
		Boolean pertenece = Boolean.FALSE;
		
		Triangulo triangulo2 = new Triangulo(this.vertice1, this.vertice2,
				punto);
		Triangulo triangulo3 = new Triangulo(this.vertice2, this.vertice3,
				punto);
		Triangulo triangulo4 = new Triangulo(this.vertice3, this.vertice1,
				punto);
		if (this.calcularOrientacion().equals(TrianguloOrientacionEnum.POSITIVA) &&
				(triangulo2.calcularOrientacion().equals(TrianguloOrientacionEnum.POSITIVA)||triangulo2.calcularOrientacion().equals(TrianguloOrientacionEnum.ALINEADOS))&& 
				(triangulo3.calcularOrientacion().equals(TrianguloOrientacionEnum.POSITIVA)||triangulo3.calcularOrientacion().equals(TrianguloOrientacionEnum.ALINEADOS)) &&
				(triangulo4.calcularOrientacion().equals(TrianguloOrientacionEnum.POSITIVA)||triangulo4.calcularOrientacion().equals(TrianguloOrientacionEnum.ALINEADOS)) ){
			pertenece= Boolean.TRUE;
		}else if(this.calcularOrientacion().equals(TrianguloOrientacionEnum.NEGATIVA) &&
				(triangulo2.calcularOrientacion().equals(TrianguloOrientacionEnum.NEGATIVA) ||triangulo2.calcularOrientacion().equals(TrianguloOrientacionEnum.ALINEADOS))&& 
				(triangulo3.calcularOrientacion().equals(TrianguloOrientacionEnum.NEGATIVA)||triangulo3.calcularOrientacion().equals(TrianguloOrientacionEnum.ALINEADOS)) &&
				(triangulo4.calcularOrientacion().equals(TrianguloOrientacionEnum.NEGATIVA)||triangulo4.calcularOrientacion().equals(TrianguloOrientacionEnum.ALINEADOS)) ){
			pertenece= Boolean.TRUE;
		}
		return pertenece;
	}

	public Double calcularPerimetro() {
		Double perimetro=0D;
		perimetro=obtenerDistanciaEntre(this.vertice1,this.vertice2)+obtenerDistanciaEntre(this.vertice1,this.vertice3)+obtenerDistanciaEntre(this.vertice2,this.vertice3);
		return perimetro;
	}
	
	private Double obtenerDistanciaEntre(PuntoCatesiano punto1,
			PuntoCatesiano punto2) {
		return punto1.obtenerDistanciaCon(punto2);
	}

	

}
