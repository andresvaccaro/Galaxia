package ar.com.galaxia.model;

import java.util.List;

import ar.com.galaxia.model.interfaces.IAgrupacionPlanetaria;
import ar.com.galaxia.utils.PuntoCatesiano;
import ar.com.galaxia.utils.Recta;
import ar.com.galaxia.utils.Triangulo;

public class AgrupacionTriple implements IAgrupacionPlanetaria {

	
	 public Boolean estanAlineadosConRespectoAlSol(List<Planeta> planetas) {
		Boolean estanAlineadosConElSol = Boolean.TRUE;				
		if(planetas!=null && !planetas.isEmpty() && planetas.size()>1){
			Recta recta = new Recta(planetas.get(0).getPosicion(),planetas.get(1).getPosicion());
			for (int i = 0; i < planetas.size(); i++) {
				if(!recta.elPuntoPerteneceALaRecta(planetas.get(i).getPosicion())){
					estanAlineadosConElSol = Boolean.FALSE;
				}
			}
			if(!recta.elPuntoPerteneceALaRecta(posicionDelSol)){
				estanAlineadosConElSol = Boolean.FALSE;
			}
		}
		return estanAlineadosConElSol;
	}

	 public Boolean estanAlineadosSinElSol(List<Planeta> planetas) {
			Boolean estanAlineadosSinElSol = Boolean.TRUE;				
			if(planetas!=null && !planetas.isEmpty() && planetas.size()>1){
				Recta recta = new Recta(planetas.get(0).getPosicion(),planetas.get(1).getPosicion());
				for (int i = 0; i < planetas.size(); i++) {
					if(!recta.elPuntoPerteneceALaRecta(planetas.get(i).getPosicion())){
						estanAlineadosSinElSol = Boolean.FALSE;
					}
				}
				if(recta.elPuntoPerteneceALaRecta(posicionDelSol)){
					estanAlineadosSinElSol = Boolean.FALSE;
				}
			}
			return estanAlineadosSinElSol;
		}
	public Double obtenerPerimetro(List<Planeta> planetas) {
		Double perimetro= 0D;
		if(!estanAlineados(planetas.get(0).getPosicion(), planetas.get(1).getPosicion(), planetas.get(2).getPosicion())){			
			Triangulo triangulo= new Triangulo(planetas.get(0).getPosicion(), planetas.get(1).getPosicion(), planetas.get(2).getPosicion());
			perimetro=triangulo.calcularPerimetro();
		}		
		return perimetro;
	}

	private Boolean estanAlineados(PuntoCatesiano posicion1,
			PuntoCatesiano posicion2, PuntoCatesiano posicion3) {
		Recta recta= new Recta(posicion1, posicion2);		
		return recta.elPuntoPerteneceALaRecta(posicion3);
	}

	public Boolean planetasContienenAlSol(List<Planeta> planetas) {
		Triangulo triangulo= new Triangulo(planetas.get(0).getPosicion(), planetas.get(1).getPosicion(), planetas.get(2).getPosicion());
		return triangulo.elPuntoPerteneceAlTriangulo(new PuntoCatesiano(0D,0D));
	}

	
	
}
