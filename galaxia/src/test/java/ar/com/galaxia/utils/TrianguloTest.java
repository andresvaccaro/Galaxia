package ar.com.galaxia.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.com.galaxia.enumerados.TrianguloOrientacionEnum;

public class TrianguloTest {

	@Test
	public void elTriangulo0_1__NEG1_0__1_0TieneOrientacionPositivaTest() {
		PuntoCatesiano punto1=new PuntoCatesiano(0D, 1D);
		PuntoCatesiano punto2=new PuntoCatesiano(-1D, 0D);
		PuntoCatesiano punto3=new PuntoCatesiano(1D, 0D);
		Triangulo triangulo = new Triangulo(punto1,punto2,punto3);
		assertEquals(triangulo.calcularOrientacion(), TrianguloOrientacionEnum.POSITIVA);
	}
	
	
	@Test
	public void elTriangulo0_NEG1__NEG1_0__1_0TieneOrientacionNegativaTest() {
		PuntoCatesiano punto1=new PuntoCatesiano(0D, -1D);
		PuntoCatesiano punto2=new PuntoCatesiano(-1D, 0D);
		PuntoCatesiano punto3=new PuntoCatesiano(1D, 0D);
		Triangulo triangulo = new Triangulo(punto1,punto2,punto3);
		assertEquals(triangulo.calcularOrientacion(), TrianguloOrientacionEnum.NEGATIVA);
	}
	
	
	@Test
	public void elPunto0_1EstaEnElTrianguloTriangulo0_2__NEG2_0__2_0Test() {
		PuntoCatesiano punto1=new PuntoCatesiano(0D, 2D);
		PuntoCatesiano punto2=new PuntoCatesiano(-2D, 0D);
		PuntoCatesiano punto3=new PuntoCatesiano(2D, 0D);
		PuntoCatesiano punto4=new PuntoCatesiano(0D, 1D);
		Triangulo triangulo = new Triangulo(punto1,punto2,punto3);
		assertTrue(triangulo.elPuntoPerteneceAlTriangulo(punto4));
	}

	@Test
	public void elPunto0_NEG1EstaEnElTrianguloTriangulo0_2__NEG2_0__2_0Test() {
		PuntoCatesiano punto1=new PuntoCatesiano(0D, 2D);
		PuntoCatesiano punto2=new PuntoCatesiano(-2D, 0D);
		PuntoCatesiano punto3=new PuntoCatesiano(2D, 0D);
		PuntoCatesiano punto4=new PuntoCatesiano(0D, -1D);
		Triangulo triangulo = new Triangulo(punto1,punto2,punto3);
		assertFalse(triangulo.elPuntoPerteneceAlTriangulo(punto4));
	}
	
	@Test
	public void elPerimetroDelTrianguloEsTest() {
		PuntoCatesiano punto1=new PuntoCatesiano(0D, 1D);
		PuntoCatesiano punto2=new PuntoCatesiano(-1D, 0D);
		PuntoCatesiano punto3=new PuntoCatesiano(1D, 0D);		
		Triangulo triangulo = new Triangulo(punto1,punto2,punto3);
		assertEquals(triangulo.calcularPerimetro(),Math.sqrt(2)+Math.sqrt(2)+2,0.0001);
	}
	
	@Test
	public void elPerimetroDelTrianguloEs6000Test() {						
		//6239.952689836777
		PuntoCatesiano punto1=new PuntoCatesiano(-500D, -0.009D);
		PuntoCatesiano punto2=new PuntoCatesiano(-2000D, 0D);
		PuntoCatesiano punto3=new PuntoCatesiano(1000D, 0D);		
		Triangulo triangulo = new Triangulo(punto1,punto2,punto3);
		assertEquals(triangulo.calcularPerimetro(),6000.000000054D,0.0001);
	}
	
	
}
