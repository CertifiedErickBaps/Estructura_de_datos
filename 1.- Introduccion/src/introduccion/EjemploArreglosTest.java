package introduccion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EjemploArregloTest {

    @Test
    void testIndiceArreglo() {
        String[] a = new String[] {
                "Buttercup",
                "Primrose",
                "Katniss",
                "Gale",
                "Peeta"
        };
        // String x = a[100]; // Produce un error de ejecución.
        assertEquals(2, EjemploArreglos.indiceArreglo(a, "Katniss"));
        assertEquals(-1, EjemploArreglos.indiceArreglo(a, "Katnip"));
        assertEquals(4, EjemploArreglos.indiceArreglo(a, "Peeta"));
    }
}
