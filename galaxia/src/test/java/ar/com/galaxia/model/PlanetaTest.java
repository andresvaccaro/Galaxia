package ar.com.galaxia.model;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.galaxia.enumerados.SentidoEnum;

public class PlanetaTest {

	@Test
	public void ferengiSeMueveUnDiaYAumentaSuAnguloUnGradoTest() {
		Double anguloInicial = 90D;
		Double velocidadAngular = 1D;
		Double distanciaAlSol=500D;
		Planeta planetaFerengi= new Planeta(anguloInicial,velocidadAngular,SentidoEnum.HORARIO,distanciaAlSol);
		int cantidadDeDiasAEvaluarPosicion = 1;
		Double gradosPosicionFinal = 91D; 
		assertEquals(planetaFerengi.obtenerAnguloDentroDeDias(cantidadDeDiasAEvaluarPosicion), gradosPosicionFinal,0.00001);
	}
	
	@Test
	public void ferengiSeMueve500DiasYAumentaSuAngulo140GradosaTest() {
		Double anguloInicial = 0D;
		Double velocidadAngular = 1D;
		Double distanciaAlSol=500D;
		Planeta planetaFerengi= new Planeta(anguloInicial,velocidadAngular,SentidoEnum.HORARIO,distanciaAlSol);
		int cantidadDeDiasAEvaluarPosicion = 500;
		int gradosPosicionFinal = 140; 
		assertEquals(planetaFerengi.obtenerAnguloDentroDeDias(cantidadDeDiasAEvaluarPosicion), gradosPosicionFinal,0.00001);
	}	
	
	@Test
	public void betaSoideSeMueve1DiaYAumentaSuAngulo3GradosTest() {
		Double anguloInicial = 0D;
		Double velocidadAngular = 3D;
		Double distanciaAlSol=2000D;
		Planeta planetaFerengi= new Planeta(anguloInicial,velocidadAngular,SentidoEnum.HORARIO,distanciaAlSol);
		int cantidadDeDiasAEvaluarPosicion = 1;
		int gradosPosicionFinal = 3; 
		assertEquals(planetaFerengi.obtenerAnguloDentroDeDias(cantidadDeDiasAEvaluarPosicion), gradosPosicionFinal,0.00001);
	}
	
	
	@Test
	public void betaSoideSeMueve361DiasYAumentaSuAngulo3GradosTest() {
		Double anguloInicial = 0D;
		Double velocidadAngular = 3D;
		Double distanciaAlSol=2000D;
		Planeta planetaFerengi= new Planeta(anguloInicial,velocidadAngular,SentidoEnum.HORARIO,distanciaAlSol);
		int cantidadDeDiasAEvaluarPosicion = 361;
		int gradosPosicionFinal = 3; 
		assertEquals(planetaFerengi.obtenerAnguloDentroDeDias(cantidadDeDiasAEvaluarPosicion), gradosPosicionFinal,0.00001);
	}

	@Test
	public void vulcanoSeMueve1DiasYDecrementaSuAngulo5GradosTest() {
		Double anguloInicial = 0D;
		Double velocidadAngular = 5D;
		Double distanciaAlSol=1000D;
		Planeta planetaFerengi= new Planeta(anguloInicial,velocidadAngular,SentidoEnum.ANTIHORARIO,distanciaAlSol);
		int cantidadDeDiasAEvaluarPosicion = 1;
		int gradosPosicionFinal = 355; 
		assertEquals(planetaFerengi.obtenerAnguloDentroDeDias(cantidadDeDiasAEvaluarPosicion), gradosPosicionFinal,0.00001);
	}

	@Test
	public void estanTodosLosPlanetasAlineadosTest() {
		Double anguloInicialVulcano = 0D;
		Double velocidadAngularVulcano = 5D;
		Double distanciaAlSolVulcano=1000D;
		Planeta planetaVulcano= new Planeta(anguloInicialVulcano,velocidadAngularVulcano,SentidoEnum.ANTIHORARIO,distanciaAlSolVulcano);
				
		Double anguloInicialFerengi = 0D;
		Double velocidadAngularFerengi = 1D;
		Double distanciaAlSolFerengi=500D;
		Planeta planetaFerengi= new Planeta(anguloInicialFerengi,velocidadAngularFerengi,SentidoEnum.HORARIO,distanciaAlSolFerengi);
		
		assertTrue(planetaVulcano.estaAlineadoCon(planetaFerengi));
		
		Double anguloInicialBetasoide = 0D;
		Double velocidadAngularBetasoide = 3D;
		Double distanciaAlSolBetasoide=2000D;
		Planeta planetaBetasoide= new Planeta(anguloInicialBetasoide,velocidadAngularBetasoide,SentidoEnum.HORARIO,distanciaAlSolBetasoide);
		
		assertTrue(planetaFerengi.estaAlineadoCon(planetaBetasoide));		
	}
	

}
