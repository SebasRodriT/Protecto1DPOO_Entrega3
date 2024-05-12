package uniandes.dpoo.galeria.modelo.empleado;

import java.util.ArrayList;

public abstract class Empleado {
    protected String rol;
    protected String nombre;
    protected int identificacion;
    protected int edad;
    protected static ArrayList<Empleado> empleados = new ArrayList<>();

    public Empleado(String rol, String nombre, int identificacion, int edad) {
        this.rol = rol;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        
        agregarEmpleado(this);
        
    }

    public String getRol() {
        return rol;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public int getEdad() {
        return edad;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public Empleado buscarEmpleadoNombre(String nombreBuscado) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return empleado;
            }
        }
        return null;    }

    public Empleado buscarEmpleadoPorId(int identificacionBuscada) {
        for (Empleado empleado : empleados) {
            if (empleado.getIdentificacion() == identificacionBuscada) {
                return empleado;
            }
        }
        return null; 
    }
}
