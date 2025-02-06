package es.habccode.java.io.map.model;
import java.time.LocalDate;
import java.time.Period;
/**
 * @author habccode
 * @version 1.0.0
 */
import java.util.Objects;

public class Empleado {
    private String identificador;
    private String nombre;
    private String puesto;
    private double salario;
    private String fechaDeNacimiento;


    /**
     * Constructor vacio
     */
    public Empleado(){}

    /**
     * 
     * @param identificador
     */
    public Empleado( String identificador){
        this.identificador = identificador;
    }


    public Empleado(String identificador, String nombre, String puesto, double salario,String fechaDeNacimiento){
        this.identificador = identificador;
        this.nombre= nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaDeNacimiento = fechaDeNacimiento;

    }

    public double getSalario() {
        return this.salario;
    }


    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFechaDeNacimiento() {
        return this.fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getEdad (String fechaNacimiento){
        LocalDate fechaActual = LocalDate.now();
        String[] arrayFecha = fechaNacimiento.split("/");
        LocalDate nacimiento = LocalDate.of(Integer.parseInt(arrayFecha[0]), 
        Integer.parseInt(arrayFecha[1]), Integer.parseInt(arrayFecha[2]));
        Period periodo = Period.between(nacimiento, fechaActual);
        return periodo.getYears();
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return getIdentificador() + "," + getNombre() + "," + getPuesto() + "," + getSalario() + "," +getFechaDeNacimiento();
    }


    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true; 
        if (!(o instanceof Empleado)) {
            return false;
        }
        Empleado empleado = (Empleado) o;
        return Objects.equals(identificador, empleado.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }


}
