package ar.com.galaxia.model.interfaces;

import java.util.List;

import ar.com.galaxia.model.Planeta;
import ar.com.galaxia.utils.PuntoCatesiano;

public interface IAgrupacionPlanetaria {
	static final PuntoCatesiano posicionDelSol= new PuntoCatesiano(0D, 0D);
	Boolean estanAlineadosConRespectoAlSol(List<Planeta> planetas);
	Double obtenerPerimetro(List<Planeta> planetas);
	Boolean planetasContienenAlSol(List<Planeta> planetas);
	Boolean estanAlineadosSinElSol(List<Planeta> planetas);

}
