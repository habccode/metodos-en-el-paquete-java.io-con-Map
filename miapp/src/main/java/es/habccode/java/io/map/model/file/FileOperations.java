package es.habccode.java.io.map.model.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
/**
 * @author habccocde;
 * @version 1.0.0
 */
import es.habccode.java.io.map.model.Empleado;
import es.habccode.java.io.map.model.IOperations;

public class FileOperations extends BasicOperations implements IOperations {
    File file;
    String nombreFichero = "empleado.txt";
    
    /**
     * Constructor de la clase FileOperations
     */
    public FileOperations(){
        try {
            URL resourse = getClass().getClassLoader().getResource(this.nombreFichero);
            this.file = new File(resourse.toURI());
            if (!file.exists() || file.isFile()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Funcion que aniade un empleado al fichero
     * @param empleado empleado a aniadir
     * @return true/false;
     */
    @Override
    public boolean create(Empleado empleado) {
        if (empleado == null) {
            return false;
        }
        Set<Empleado> empleados = read(file);
        if (empleados.contains(empleado)) {
            return false;
        }
        return create(empleados.toString(), file);
    }

    /**
     * Funcion que busca un empleado por el identificador en un fichero
     * @param identificador identificador del empleado a buscar
     * @return empleado buscado
     */
    @Override
    public Empleado read(String identificador) {
        if (identificador == null || identificador.isEmpty()) {
            return null;
        }
        Empleado empleado = new Empleado(identificador);
        return read(empleado);
    }

    /**
     * Funcion que busca un empleado en un fichero
     * @param empleado empleado a buscar
     * @return empleado buscado
     */
    @Override
    public Empleado read(Empleado empleado) {
        if (empleado == null) {
            return empleado;
        }
        Set<Empleado> empleados = read(file);
        for (Empleado empleadoBuscar : empleados) {
            if (empleadoBuscar.equals(empleado)) {
                return empleadoBuscar;
            }
        }
        return empleado;
    }

    @Override
    public boolean update(Empleado empleado) {
        if (empleado == null) {
            return false;
        }
        Set<Empleado> empleados = read(file);
        for (Empleado empleadoActualizar : empleados) {
            if (empleadoActualizar.equals(empleado)) {
                empleadoActualizar = empleado;
            }
        }
                return false;
    }

    @Override
    public boolean delete(String identificador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Set<Empleado> empleadosPorPuesto(String puesto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'empleadosPorPuesto'");
    }

    @Override
    public Set<Empleado> empleadoPorSupuesto(String puesto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'empleadoPorSupuesto'");
    }

    @Override
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'empleadosPorEdad'");
    }

}