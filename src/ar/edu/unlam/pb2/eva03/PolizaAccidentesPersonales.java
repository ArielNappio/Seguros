package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;

public class PolizaAccidentesPersonales extends Poliza implements SegurosDeVida {

	private TipoDeBeneficiario tipo;
	private HashMap<Persona, TipoDeBeneficiario> beneficiarios;
	private Integer contador;

	public PolizaAccidentesPersonales(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima);
		this.beneficiarios = new HashMap<>();

	}

	@Override
	public void agregarBeneficiario(Persona persona, TipoDeBeneficiario tipo) {
		this.beneficiarios.put(persona, tipo);

	}

	@Override
	public int obtenerCantidadDeBeneficiarios() {
		return this.beneficiarios.size();
	}

}
