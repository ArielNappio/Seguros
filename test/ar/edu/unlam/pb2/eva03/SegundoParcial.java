package ar.edu.unlam.pb2.eva03;

import static org.junit.Assert.*;

import org.junit.Test;

public class SegundoParcial {

	@Test
	public void queSePuedaEmitirUnaPolizaDeAutos() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000_000.0, PRIMA = 5000.0, PREMIO = 6000.0;

		Persona asegurado = new Persona("Camila", 45987345, 24);
		Auto auto = new Auto("Ford", "Fiesta", 2010, SUMA_ASEGURADA);
		SegurosGenerales poliza = new PolizaDeAuto(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);

		poliza.agregarBienAsegurado(auto);

		assertEquals(NUMERO_DE_POLIZA, ((Poliza) poliza).getNumeroDePoliza());
		assertEquals(auto, ((PolizaDeAuto) poliza).getAuto());
		assertEquals(asegurado, ((Poliza) poliza).getAsegurado());
		assertEquals(PREMIO, ((Poliza) poliza).getPremio());
	}

	@Test
	public void queSePuedaEmitirUnaPolizaDeVida() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;

		Persona asegurado = new Persona("Camila", 45987345, 24);
		Persona hijo = new Persona("Arturo", 65456231, 2);
		Persona conyuge = new Persona("Arturito", 654562301, 2);

		SegurosDeVida poliza = new PolizaAccidentesPersonales(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA);
		poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);

		assertEquals(2, (poliza).obtenerCantidadDeBeneficiarios());
		assertEquals(asegurado, ((Poliza) poliza).getAsegurado());
		assertEquals(PREMIO, ((Poliza) poliza).getPremio());

	}

	@Test
	public void queSePuedaEmitirUnaPolizaDeCombinadoFamiliar() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 20000000.0, PRIMA = 50000.0, PREMIO = 60000.0;

		Vivienda casa = new Vivienda("Florencio Varela 1800", "San Justo", "La Matanza", "Buenos Aires");
		Persona asegurado = new Persona("Camila", 45987345, 24);
		Persona hijo = new Persona("Arturo", 654562310, 2);
		Persona hija = new Persona("Maia", 65445231, 4);
		Persona conyuge = new Persona("Arturo", 654562311, 2);

		PolizaCombinadoFamiliar poliza = new PolizaCombinadoFamiliar(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA,
				PRIMA);
		poliza.agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		poliza.agregarBeneficiario(hija, TipoDeBeneficiario.HIJA);
		poliza.agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
		poliza.agregarBienAsegurado(casa);

		assertEquals(3, poliza.obtenerCantidadDeBeneficiarios());
		assertEquals(asegurado, poliza.getAsegurado());
		assertEquals(PREMIO, poliza.getPremio());
	}

	@Test
	public void queSePuedanAdministrarDistintosTiposDePolizas() {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");

		libra.agregarPoliza(new PolizaDeAuto(1, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(2, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(3, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(4, new Persona("Victor", 652354, 24), 2000000.0, 5000.0));

		assertEquals((Integer) 4, libra.obtenerLaCantidadDePolizasEmitidas());

	}

	@Test
	public void queSePuedaDenunciarElRoboDeUnAuto() {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");

		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0));

		libra.denunciarSiniestro(1);

		assertTrue(libra.getPoliza(1).fueRobado());

	}

	@Test
	public void queSePuedaDenunciarUnSiniestroParaUnaPolizaDeVida() {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");

		libra.agregarPoliza(
				new PolizaAccidentesPersonales(numeroDePoliza, new Persona("Pedro", 455647345, 24), 2000000.0, 5000.0));

		libra.denunciarSiniestro(1);

		assertTrue(libra.getPoliza(1).tuvoAlgunAccidente());

	}

	@Test(expected = PolizaInexistente.class)
	public void verificarQueNoSePuedaDenunciarUnSiniestroParaUnaPolizaQueNoExista() throws PolizaInexistente {
		Integer numeroDePoliza = 1;
		CompaniaDeSeguro libra = new CompaniaDeSeguro("Libra");
		Boolean retorno = true;

		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza++, new Persona("Camila", 45987345, 24), 2000000.0, 5000.0));
		libra.agregarPoliza(new PolizaDeAuto(numeroDePoliza++, new Persona("Juan", 2745123, 24), 1500000.0, 4000.0));
		libra.agregarPoliza(new PolizaAccidentesPersonales(numeroDePoliza++, new Persona("Pedro", 455647345, 24),
				2000000.0, 5000.0));
		libra.agregarPoliza(
				new PolizaCombinadoFamiliar(numeroDePoliza++, new Persona("Natalia", 45987345, 24), 2000000.0, 5000.0));

		// libra.denunciarSiniestro(5);
		retorno = libra.existeONo(6);

		assertEquals(false, retorno);
	}

}
