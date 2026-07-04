package ar.edu.unahur.obj2.cloud;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import ar.edu.unahur.obj2.cloud.Exepciones.Overprovisioning;
import ar.edu.unahur.obj2.cloud.Operaciones.Operaciones;
//COMMAND
public class Planificador {

    private Stack<Operaciones> operacionesEjecutadas = new Stack<>();

    private Set<Operaciones> planDeDespliegue = new HashSet<>();

    public void deshacerUltimaOperacion(Integer capacidad) {
        if (!operacionesEjecutadas.isEmpty()) {
            Operaciones operacion = operacionesEjecutadas.pop();
            operacion.undoCluster(capacidad);
        }
        else {
            System.out.println("No hay operaciones para deshacer.");
        }
    }

    public void ejecutarOperacion(Operaciones operacion, Integer capacidad) {
        if (capacidad - operacion.getvCPUs() == -200) {
            throw new Overprovisioning("Se ha pasado el limite de sobre-compromiso de recursos en el cluster actual.");
        }
        else {
            operacion.ejecutarCluster(capacidad);
            operacionesEjecutadas.push(operacion);
        }
    }

    public Planificador(Set<Operaciones> planDeDespliegue) {
        this.planDeDespliegue = planDeDespliegue;
    }

    public Set<Operaciones> getPlanDeDespliegue() {
        return planDeDespliegue;
    }

    public void agregarOperacionPendiente(Operaciones operacion) {
        planDeDespliegue.add(operacion);
    }

    public void ejecutarPlanDeDespliegue(Integer capacidad) {
        for (Operaciones operacion : planDeDespliegue) {
            operacion.ejecutarCluster(capacidad);
            operacionesEjecutadas.push(operacion);
        }
        planDeDespliegue.clear();
    }
}
