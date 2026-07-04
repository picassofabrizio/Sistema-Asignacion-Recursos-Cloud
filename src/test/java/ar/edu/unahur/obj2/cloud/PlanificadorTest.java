package ar.edu.unahur.obj2.cloud;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cloud.Operaciones.Operaciones;
import ar.edu.unahur.obj2.cloud.Operaciones.OperacionesDeAsignacion;
import ar.edu.unahur.obj2.cloud.Operaciones.OperacionesDeLiberacion;

public class PlanificadorTest {
    @Test
    public void planificador() {
        ArrayList sistemasInteresados = new ArrayList<>();
        Set<Operaciones> operaciones = new HashSet<>();
        Planificador planificador = new Planificador(operaciones);
        OperacionesDeAsignacion operacionesDeAsignacion = new OperacionesDeAsignacion(new Cluster("Cluster1", sistemasInteresados));
        planificador.ejecutarOperacion(operacionesDeAsignacion, 10);
        assert(planificador.getPlanDeDespliegue().size() == 0);
    }
    @Test
    public void planificador2() {
        ArrayList sistemasInteresados = new ArrayList<>();
        Set<Operaciones> operaciones = new HashSet<>();
        Planificador planificador = new Planificador(operaciones);
        OperacionesDeAsignacion operacionesDeAsignacion = new OperacionesDeAsignacion(new Cluster("Cluster1", sistemasInteresados));
        planificador.ejecutarOperacion(operacionesDeAsignacion, 10);
        planificador.deshacerUltimaOperacion(10);
        assert(planificador.getPlanDeDespliegue().size() == 0);
    }
   
    @Test
    public void planificador4() {
        ArrayList sistemasInteresados = new ArrayList<>();
        Set<Operaciones> operaciones = new HashSet<>();
        Planificador planificador = new Planificador(operaciones);
        OperacionesDeAsignacion operacionesDeAsignacion = new OperacionesDeAsignacion(new Cluster("Cluster1", sistemasInteresados));
        planificador.ejecutarOperacion(operacionesDeAsignacion, 10);
        planificador.deshacerUltimaOperacion(10);
        planificador.deshacerUltimaOperacion(10);
        planificador.deshacerUltimaOperacion(10);
        assert(planificador.getPlanDeDespliegue().size() == 0);
    }

    @Test
    public void planificador5(){
        Cluster cluster = new Cluster("Cluster1", new ArrayList<>());
        ArrayList sistemasInteresados = new ArrayList<>();
        Set<Operaciones> operaciones = new HashSet<>();
        Planificador planificador = new Planificador(operaciones);
        OperacionesDeLiberacion operacionesDeLiberacion = new OperacionesDeLiberacion(new Cluster("Cluster1", sistemasInteresados));
        OperacionesDeAsignacion operacionesDeAsignacion = new OperacionesDeAsignacion(new Cluster("Cluster1", sistemasInteresados));
        planificador.agregarOperacionPendiente(operacionesDeLiberacion);
        planificador.agregarOperacionPendiente(operacionesDeAsignacion);
        planificador.ejecutarPlanDeDespliegue(10);
        assert(planificador.getPlanDeDespliegue().size() == 0);
    }

}
