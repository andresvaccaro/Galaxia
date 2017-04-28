package ar.com.galaxia.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.com.galaxia.constants.DistanciaAlSolConstant;
import ar.com.galaxia.constants.VelocidadAngularConstant;
import ar.com.galaxia.enumerados.CondicionClimaticaEnum;
import ar.com.galaxia.enumerados.SentidoEnum;
import ar.com.galaxia.model.interfaces.IAgrupacionPlanetaria;
import ar.com.galaxia.utils.PuntoCatesiano;
import ar.com.galaxia.utils.Recta;

public class Galaxia {

	private List<Planeta> planetas;	
	private IAgrupacionPlanetaria agrupacionPlanetaria;

	private final Map<Integer, IAgrupacionPlanetaria> mapaAgrupacionesPlanetarias = crearMapa();

	private static Map<Integer, IAgrupacionPlanetaria> crearMapa() {
		Map<Integer, IAgrupacionPlanetaria> result = new HashMap<Integer, IAgrupacionPlanetaria>();
		result.put(3, new AgrupacionTriple());
		return Collections.unmodifiableMap(result);
	}

	private int numeroDeDia;
	private Double maximoPerimetro;

	public Galaxia(List<Planeta> planetas) {
		this.planetas = planetas;		
		inicializarGalaxia();
	}
	
	public void inicializarGalaxia(){
		this.numeroDeDia = 1;
		agrupacionPlanetaria = obtenerAgrupacionPlanetaria(this.planetas.size());
		this.maximoPerimetro= Math.rint(obtenerPerimetroMaximo()*1)/1;
	}

	public Galaxia(){
		this.planetas= new ArrayList<Planeta>();
		Planeta ferengi = new Planeta(0D,VelocidadAngularConstant.VELOCIDAD_FERENGI,SentidoEnum.HORARIO,DistanciaAlSolConstant.DISTANCIA_FERENGI);
		Planeta betasoide = new Planeta(0D,VelocidadAngularConstant.VELOCIDAD_BETASOIDE,SentidoEnum.HORARIO,DistanciaAlSolConstant.DISTANCIA_BETASOIDE);
		Planeta vulcano = new Planeta(0D,VelocidadAngularConstant.VELOCIDAD_VULCANO,SentidoEnum.ANTIHORARIO,DistanciaAlSolConstant.DISTANCIA_VULCANO);
		planetas.add(ferengi);
		planetas.add(betasoide);
		planetas.add(vulcano);
		inicializarGalaxia();
	}

	private IAgrupacionPlanetaria obtenerAgrupacionPlanetaria(
			int cantidadPlanetas) {
		return this.mapaAgrupacionesPlanetarias.get(cantidadPlanetas);

	}

	public CondicionClimaticaEnum obtenerCondicionClimaticaActual() {
		CondicionClimaticaEnum condicionClimatica = CondicionClimaticaEnum.ALEATORIA;
		if (this.agrupacionPlanetaria
				.estanAlineadosConRespectoAlSol(this.planetas)) {
			condicionClimatica = CondicionClimaticaEnum.SEQUIA;
		} else {
			if (this.agrupacionPlanetaria.estanAlineadosSinElSol(this.planetas)) {
				condicionClimatica = CondicionClimaticaEnum.OPTIMA;
			} else {
				if (this.agrupacionPlanetaria
						.planetasContienenAlSol(this.planetas)) {				
					if ((Math.rint(this.agrupacionPlanetaria
							.obtenerPerimetro(planetas) * 1) / 1) == maximoPerimetro) {
						condicionClimatica = CondicionClimaticaEnum.LLUVIAMAXIMA;
					} else {
						condicionClimatica = CondicionClimaticaEnum.LLUVIA;
					}
				}
			}

		}

		return condicionClimatica;
	}

	public void avanzarDia() {
		this.numeroDeDia++;
		for (Planeta planeta : planetas) {
			planeta.avanzarPosicion();
		}
	}

	public Double obtenerPerimetroMaximo() {
		Double perimetroMaximo = 0D;
		for (int i = 0; i < 360; i++) {

			Double perimetroDia = this.agrupacionPlanetaria
					.obtenerPerimetro(this.planetas);
			if (perimetroDia > perimetroMaximo && this.agrupacionPlanetaria.planetasContienenAlSol(planetas)) {				
				perimetroMaximo = perimetroDia;
			}
			this.avanzarDia();
		}
		this.reestablecerPosicionesIniciales();
		return perimetroMaximo;
	}

	private void reestablecerPosicionesIniciales() {
		for (Planeta planeta : planetas) {
//			planeta.reestablecerPosicionInicial();
			planeta.getPosicion().cargarAnguloYLongitud(0D, planeta.getDistanciaAlSol());
		}		
	}

	public Boolean elSolEstaContenidoEnElPerimetro() {
		return this.agrupacionPlanetaria.planetasContienenAlSol(this.planetas);
	}

	public CondicionClimaticaEnum calcularCondicionClimaticaDia(int dia) {
		for (int i = 0; i < dia; i++) {
			avanzarDia();
		}
		return obtenerCondicionClimaticaActual();
	}

}
