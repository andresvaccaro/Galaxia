package ar.com.galaxia.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectaTest {

	
	/*Pruebo rectas verticales*/
	@Test
	public void elPunto0_0NoPerteneceAlaRectaFormadaPor1_1Y1_2test() {
		PuntoCatesiano punto1 = new PuntoCatesiano(1D, 1D);
		PuntoCatesiano punto2 = new PuntoCatesiano(1D, 2D);
		PuntoCatesiano punto3 = new PuntoCatesiano(0D, 0D);
		
		Recta recta = new Recta(punto1,punto2);
		assertFalse(recta.elPuntoPerteneceALaRecta(punto3));
		
	}
	
	

	@Test
	public void elPunto1_0PerteneceAlaRectaFormadaPor1_1Y1_2test() {
		PuntoCatesiano punto1 = new PuntoCatesiano(1D, 1D);
		PuntoCatesiano punto2 = new PuntoCatesiano(1D, 2D);
		PuntoCatesiano punto3 = new PuntoCatesiano(1D, 0D);
		
		Recta recta = new Recta(punto1,punto2);
		assertTrue(recta.elPuntoPerteneceALaRecta(punto3));
		
	}
	
	/*Pruebo rectas horizontales*/
	
	@Test
	public void elPunto0_0NoPerteneceAlaRectaFormadaPor0_1Y1_1test() {
		PuntoCatesiano punto1 = new PuntoCatesiano(0D, 1D);
		PuntoCatesiano punto2 = new PuntoCatesiano(1D, 1D);
		PuntoCatesiano punto3 = new PuntoCatesiano(0D, 0D);
		
		Recta recta = new Recta(punto1,punto2);
		assertFalse(recta.elPuntoPerteneceALaRecta(punto3));
		
	}
	
	@Test
	public void elPunto2_1PerteneceAlaRectaFormadaPor0_1Y1_1test() {
		PuntoCatesiano punto1 = new PuntoCatesiano(0D, 1D);
		PuntoCatesiano punto2 = new PuntoCatesiano(1D, 1D);
		PuntoCatesiano punto3 = new PuntoCatesiano(2D, 1D);
		
		Recta recta = new Recta(punto1,punto2);
		assertTrue(recta.elPuntoPerteneceALaRecta(punto3));
		
	}

	
	/*Pruebo rectas con pendiente*/
	@Test
	public void elPunto0_0PerteneceAlaRectaFormadaPor1_1Y2_2test() {
		PuntoCatesiano punto1 = new PuntoCatesiano(1D, 1D);
		PuntoCatesiano punto2 = new PuntoCatesiano(2D, 2D);
		PuntoCatesiano punto3 = new PuntoCatesiano(0D, 0D);
		
		Recta recta = new Recta(punto1,punto2);
		assertTrue(recta.elPuntoPerteneceALaRecta(punto3));
		
	}
	
	@Test
	public void elPunto1_0NoPerteneceAlaRectaFormadaPor1_1Y2_2test() {
		PuntoCatesiano punto1 = new PuntoCatesiano(1D, 1D);
		PuntoCatesiano punto2 = new PuntoCatesiano(2D, 2D);
		PuntoCatesiano punto3 = new PuntoCatesiano(1D, 0D);
		
		Recta recta = new Recta(punto1,punto2);
		assertFalse(recta.elPuntoPerteneceALaRecta(punto3));
		
	}
}
