package ar.edu.unlam.pb2.eva03;

public class Vivienda extends Bien {

	private String calle;
	private String partido;
	private String provincia;
	private String localidad;

	// "Florencio Varela 1800", "San Justo", "La Matanza", "Buenos Aires"
	public Vivienda(String calle, String localidad, String partido, String provincia) {

		this.calle = calle;
		this.localidad = localidad;
		this.partido = partido;
		this.provincia = provincia;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

}
