package ar.com.galaxia.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.com.galaxia.constants.DistanciaAlSolConstant;
import ar.com.galaxia.constants.VelocidadAngularConstant;
import ar.com.galaxia.enumerados.CondicionClimaticaEnum;
import ar.com.galaxia.enumerados.SentidoEnum;
import ar.com.galaxia.utils.PuntoCatesiano;

public class GalaxiaTest {

	private Planeta ferengi = new Planeta(0D,VelocidadAngularConstant.VELOCIDAD_FERENGI,SentidoEnum.HORARIO,DistanciaAlSolConstant.DISTANCIA_FERENGI);
	private Planeta betasoide = new Planeta(0D,VelocidadAngularConstant.VELOCIDAD_BETASOIDE,SentidoEnum.HORARIO,DistanciaAlSolConstant.DISTANCIA_BETASOIDE);
	private Planeta vulcano = new Planeta(0D,VelocidadAngularConstant.VELOCIDAD_VULCANO,SentidoEnum.ANTIHORARIO,DistanciaAlSolConstant.DISTANCIA_VULCANO);
	private Galaxia galaxia;
	
	
	@Test
	public void losPlanetasEstanAlineadosConRespectoAlSolYElDiaEsSecotest() {
		List<Planeta> planetas= new ArrayList<Planeta>();
		planetas.add(this.ferengi);
		planetas.add(this.betasoide);
		planetas.add(this.vulcano);
		this.galaxia = new Galaxia(planetas);
		assertEquals(galaxia.obtenerCondicionClimaticaActual(), CondicionClimaticaEnum.SEQUIA);		
	}
	
	@Test
	public void pasaUnDiaDesdeLaCracionDelPlanetaYElClimaEsAleatoriotest() {
		List<Planeta> planetas= new ArrayList<Planeta>();
		planetas.add(this.ferengi);
		planetas.add(this.betasoide);
		planetas.add(this.vulcano);
		this.galaxia = new Galaxia(planetas);
		this.galaxia.avanzarDia();		
		assertEquals(galaxia.obtenerCondicionClimaticaActual(), CondicionClimaticaEnum.ALEATORIA);		
	}
	
	
	@Test
	public void elPerimetroMaximoEs4608test() {
		List<Planeta> planetas= new ArrayList<Planeta>();
		planetas.add(this.ferengi);
		planetas.add(this.betasoide);
		planetas.add(this.vulcano);
		this.galaxia = new Galaxia(planetas);	
		assertEquals(galaxia.obtenerPerimetroMaximo(), 6239,1);		
	}
	
	

	@Test
	public void conLosPlanetasEnLaPosicion_1_0__NEG1_NEG1__1_NEG1ElSolEstaIncluidoTest() {
		List<Planeta> planetas= new ArrayList<Planeta>();		
		planetas.add(this.ferengi);
		planetas.add(this.betasoide);
		planetas.add(this.vulcano);
		this.galaxia = new Galaxia(planetas);
		PuntoCatesiano punto1=new PuntoCatesiano(0D, 2D);
		PuntoCatesiano punto2=new PuntoCatesiano(-2D, 0D);
		PuntoCatesiano punto3=new PuntoCatesiano(2D, 0D);		
		this.ferengi.setPosicion(punto1);
		this.betasoide.setPosicion(punto2);
		this.vulcano.setPosicion(punto3);
		assertTrue(galaxia.elSolEstaContenidoEnElPerimetro());		
	}
	
	@Test
	public void conLosPlanetasFormanUnTrianguloYContienenAlSolYEsPeriodoDeLluviaTest() {
		List<Planeta> planetas= new ArrayList<Planeta>();		
		planetas.add(this.ferengi);
		planetas.add(this.betasoide);
		planetas.add(this.vulcano);
		this.galaxia = new Galaxia(planetas);		
		this.ferengi.getPosicion().cargarAnguloYLongitud(90D, this.ferengi.getDistanciaAlSol());
		this.betasoide.getPosicion().cargarAnguloYLongitud(190D, this.betasoide.getDistanciaAlSol());
		this.vulcano.getPosicion().cargarAnguloYLongitud(280D, this.vulcano.getDistanciaAlSol());
		assertEquals(galaxia.obtenerCondicionClimaticaActual(), CondicionClimaticaEnum.LLUVIA);		
	}

	@Test
	public void losPlanetasEstanEnElPerimetroMaximoYContienenAlSoleEntoncesElClimaTieneLLuviaIntensaTest() {
		List<Planeta> planetas= new ArrayList<Planeta>();		
		planetas.add(this.ferengi);
		planetas.add(this.betasoide);
		planetas.add(this.vulcano);
		this.galaxia = new Galaxia(planetas);
		this.ferengi.setPosicion(new PuntoCatesiano(60.961D,496.27D));
		this.betasoide.setPosicion(new PuntoCatesiano(-1997.259D,-104.67D));
		this.vulcano.setPosicion(new PuntoCatesiano(996.195D,-87.156D));
		assertEquals(galaxia.obtenerCondicionClimaticaActual(), CondicionClimaticaEnum.LLUVIAMAXIMA);		
	}
	
	@Test
	public void losPlanetasEstanAlineadosPeroNoConRespectoAlSolEntoncesCondicionOptimaTest() {
		List<Planeta> planetas= new ArrayList<Planeta>();				
		planetas.add(this.ferengi);
		planetas.add(this.betasoide);
		planetas.add(this.vulcano);
		this.galaxia = new Galaxia(planetas);
		this.ferengi.setPosicion(new PuntoCatesiano(100D,489.8979485566356D));
		this.betasoide.setPosicion(new PuntoCatesiano(100D,1997.498435543818D));
		this.vulcano.setPosicion(new PuntoCatesiano(100D,994.98743710662D));
		assertEquals(galaxia.obtenerCondicionClimaticaActual(), CondicionClimaticaEnum.OPTIMA);		
	}
	
	
	@Test
	public void aLos10DiasLaCondicionClimaticaSeraAleatoriaTest() {
		List<Planeta> planetas= new ArrayList<Planeta>();				
		planetas.add(this.ferengi);
		planetas.add(this.betasoide);
		planetas.add(this.vulcano);
		this.galaxia = new Galaxia(planetas);		
		assertEquals(galaxia.calcularCondicionClimaticaDia(10), CondicionClimaticaEnum.ALEATORIA);		
	}
}
