package ar.com.galaxia.rest.model;

import java.util.ArrayList;
import java.util.List;

import ar.com.galaxia.enumerados.CondicionClimaticaEnum;

public class InformeClima {
	
	private int cantidadDiasLluviosos;
	private int cantidadDiasAleatorios;
	private int cantidadDiasSequia;
	private int cantidadDiasOptimos;
	private List<Integer> diasConMasLluvias;
					
	
	public InformeClima() {
		super();
		cantidadDiasLluviosos=0;
		cantidadDiasAleatorios=0;
		cantidadDiasSequia=0;
		cantidadDiasOptimos=0;
		this.diasConMasLluvias = new ArrayList<Integer>();
	}
	public int getCantidadDiasLluviosos() {
		return cantidadDiasLluviosos;
	}
	public void setCantidadDiasLluviosos(int cantidadDiasLluviosos) {
		this.cantidadDiasLluviosos = cantidadDiasLluviosos;
	}
	public int getCantidadDiasAleatorios() {
		return cantidadDiasAleatorios;
	}
	public void setCantidadDiasAleatorios(int cantidadDiasAleatorios) {
		this.cantidadDiasAleatorios = cantidadDiasAleatorios;
	}
	public int getCantidadDiasSequia() {
		return cantidadDiasSequia;
	}
	public void setCantidadDiasSequia(int cantidadDiasSequia) {
		this.cantidadDiasSequia = cantidadDiasSequia;
	}
	public int getCantidadDiasOptimos() {
		return cantidadDiasOptimos;
	}
	public void setCantidadDiasOptimos(int cantidadDiasOptimos) {
		this.cantidadDiasOptimos = cantidadDiasOptimos;
	}
	
	
	
	public List<Integer> getDiasConMasLluvias() {
		return diasConMasLluvias;
	}
	public void setDiasConMasLluvias(List<Integer> diasConMasLluvias) {
		this.diasConMasLluvias = diasConMasLluvias;
	}
	public void incrementar(CondicionClimaticaEnum condicionDelDia,Integer numeroDeDia) {
		
		if(condicionDelDia.equals(CondicionClimaticaEnum.ALEATORIA)) {
			this.cantidadDiasAleatorios++;
		}
		
		if(condicionDelDia.equals(CondicionClimaticaEnum.SEQUIA)) {
			this.cantidadDiasSequia++;
		}
		
		if(condicionDelDia.equals(CondicionClimaticaEnum.LLUVIA)) {
			this.cantidadDiasLluviosos++;
		}
		
		if(condicionDelDia.equals(CondicionClimaticaEnum.OPTIMA)) {
			this.cantidadDiasOptimos++;
		}
		
		if(condicionDelDia.equals(CondicionClimaticaEnum.LLUVIAMAXIMA)) {
			this.diasConMasLluvias.add(numeroDeDia);
		}
			
		
		
	}
	
	

}
