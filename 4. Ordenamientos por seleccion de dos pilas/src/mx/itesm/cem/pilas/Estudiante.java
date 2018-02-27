package mx.itesm.cem.pilas;

public class Estudiante extends Object implements Comparable<Estudiante> {

    private String matricula;
    private String nombre;

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public Estudiante(String matricula, String nombre) {
        this.matricula = matricula;
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return matricula.compareTo(otro.matricula);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Estudiante(" + matricula + ", " + nombre + ")";
    }
}