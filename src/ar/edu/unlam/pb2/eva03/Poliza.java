package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Objects;

public class Poliza {
	private Integer NumeroDePoliza;
	private Persona Asegurado;
	private Double sumaAsegurada;
	private Double Prima;
	private Boolean Robado;

	public Poliza(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima) {
		super();
		this.NumeroDePoliza = numeroDePoliza;
		Asegurado = asegurado;
		this.sumaAsegurada = sumaAsegurada;
		Prima = prima;
		this.Robado = false;
	}

	public boolean tuvoAlgunAccidente() {
	return	this.Robado = true;
	}

	public Double getPremio() {
		return Prima + (Prima * 0.2);

	}

	public Integer getNumeroDePoliza() {
		return NumeroDePoliza;
	}

	public void setNumeroDePoliza(Integer numeroDePoliza) {
		NumeroDePoliza = numeroDePoliza;
	}

	public Persona getAsegurado() {
		return Asegurado;
	}

	public void setAsegurado(Persona asegurado) {
		Asegurado = asegurado;
	}

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public Double getPrima() {
		return Prima;
	}

	public void setPrima(Double prima) {
		Prima = prima;
	}

	@Override
	public int hashCode() {
		return Objects.hash(NumeroDePoliza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Poliza other = (Poliza) obj;
		return Objects.equals(NumeroDePoliza, other.NumeroDePoliza);
	}

	public Boolean fueRobado() {
		return Robado;
	}

	public void setRobado(Boolean robado) {
		Robado = robado;
	}

}
