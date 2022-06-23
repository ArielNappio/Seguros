package ar.edu.unlam.pb2.eva03;

public class Auto extends Bien {

	private String marca;
	private String modelo;
	private Integer anio;
	private Double sUMA_ASEGURADA;

	// "Ford", "Fiesta", 2010, SUMA_ASEGURADA
	public Auto(String marca, String modelo, Integer anio, Double sUMA_ASEGURADA) {
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
		this.sUMA_ASEGURADA = sUMA_ASEGURADA;

	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Double getsUMA_ASEGURADA() {
		return sUMA_ASEGURADA;
	}

	public void setsUMA_ASEGURADA(Double sUMA_ASEGURADA) {
		this.sUMA_ASEGURADA = sUMA_ASEGURADA;
	}

}
