package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;

public class PolizaCombinadoFamiliar extends Poliza implements SegurosDeVida, SegurosGenerales {

	private HashMap<Persona, TipoDeBeneficiario> beneficiarios;
	private Vivienda viv;

	public PolizaCombinadoFamiliar(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima);
		this.beneficiarios = new HashMap<Persona, TipoDeBeneficiario>();
	}

	@Override
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario tipo) {
		this.beneficiarios.put(persona, tipo);
	}

	@Override
	public int obtenerCantidadDeBeneficiarios() {
		return this.beneficiarios.size();
	}

	@Override
	public void agregarBienAsegurado(Bien bien) {
		this.viv = (Vivienda) bien;

	}

}
