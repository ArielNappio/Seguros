package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;

public class CompaniaDeSeguro {

	private String nombre;

	private HashSet<Poliza> polizas;

	public CompaniaDeSeguro(String nombre) {
		this.nombre = nombre;
		this.polizas = new HashSet<Poliza>();

	}

	public Boolean existeONo(int i) throws PolizaInexistente {
		boolean retorno = false;
		for (Poliza I : polizas) {
			if (I.getNumeroDePoliza().equals(i)) {
				retorno = true;
			}
		}
		throw new PolizaInexistente();

	}

	public void denunciarSiniestro(int nro) {
		for (Poliza I : polizas) {
			if (I.fueRobado() == false && I.getNumeroDePoliza().equals(nro)) {
				I.setRobado(true);
			}
		}
	}

	public Poliza getPoliza(Integer nroPoliza) {
		Poliza aux = null;
		for (Poliza I : polizas) {
			if (I.getNumeroDePoliza().equals(nroPoliza)) {
				aux = I;
			}
		}
		return aux;

	}

	public Integer obtenerLaCantidadDePolizasEmitidas() {
		return this.polizas.size();
	}

	public void agregarPoliza(Poliza polizas) {
		this.polizas.add(polizas);
	}

}
