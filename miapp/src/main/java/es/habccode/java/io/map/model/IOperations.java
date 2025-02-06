package es.habccode.java.io.map.model;

import java.util.Set;

public interface IOperations {
    public boolean create(Empleado empleado);
    public boolean read(String identificador);
    public Empleado read(Empleado empleado);
    public boolean update(Empleado empleado);
    public boolean delete(String indetificador);
    public Set<Empleado> empleadoPorSupuesto(String puesto);
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin);

    
} 
