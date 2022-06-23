package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;

public class PolizaDeAuto extends Poliza implements SegurosGenerales {

	private Auto Auto;

	public PolizaDeAuto(Integer nUMERO_DE_POLIZA, Persona asegurado, Double sUMA_ASEGURADA, Double pRIMA) {
		super(nUMERO_DE_POLIZA, asegurado, sUMA_ASEGURADA, pRIMA);

	}

	public Auto getAuto() {
		return Auto;
	}

	public void setAuto(Auto auto) {
		Auto = auto;
	}

	@Override
	public void agregarBienAsegurado(Bien bien) {
		this.Auto = (Auto) bien;
		
	}



	

}
