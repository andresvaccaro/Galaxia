package ar.com.galaxia.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class PuntoCatesianoTest {

	@Test
	public void laLongitudDelPunto0_2Es2() {
		PuntoCatesiano punto = new PuntoCatesiano(0D, 2D);
		assertEquals(punto.getLongitud(), 2D,0.0001);
	}
	
	@Test
	public void laLongitudDelPunto4_3Es5() {
		PuntoCatesiano punto = new PuntoCatesiano(4D, 3D);
		assertEquals(punto.getLongitud(), 5D,0.0001);
	}
	
	@Test
	public void elAnguloEnGradosDe0_1es90() {
		PuntoCatesiano punto = new PuntoCatesiano(0D, 1D);
		assertEquals(punto.getAnguloEnGrados(), 90D,0.0001);
	}
	
	
	@Test
	public void elAnguloEnRadianesDe0_1es90() {
		PuntoCatesiano punto = new PuntoCatesiano(0D, 1D);
		assertEquals(punto.getAnguloEnRadianes(), Math.PI/2,0.0001);
	}
	

}
