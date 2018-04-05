package mx.itesm.cem.examen2;

public class EjemploEnumSet {

	enum Estacion {
		PRIMAVERA, VERANO, OTOÑO, INVIERNO
	}
	enum Sexo {
		FEMENINO, MASCULINO
	}
	public static void main(String[] args) {
		Estacion t = Estacion.INVIERNO;
		System.out.println(t);
		System.out.println(t.ordinal());
		for(Estacion e: Estacion.values()) {
			System.out.println(e + " " + e.ordinal());
		}
	}
}
