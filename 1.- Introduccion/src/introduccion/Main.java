package introduccion;

public class Main {

    public static void main(String[] args) {
        String[] a = new String[] {
                "Buttercup",
                "Primrose",
                "Katniss",
                "Gale",
                "Peeta"
        };
        int i = EjemploArreglos.indiceArreglo(a, "Katniss");
        System.out.println(i);
        i = EjemploArreglos.indiceArreglo(a, "Katnip");
        System.out.println(i);
    }

}
