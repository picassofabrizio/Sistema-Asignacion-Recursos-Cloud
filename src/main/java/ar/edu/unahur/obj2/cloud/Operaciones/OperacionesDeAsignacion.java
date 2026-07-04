package ar.edu.unahur.obj2.cloud.Operaciones;

import ar.edu.unahur.obj2.cloud.Cluster;

public class OperacionesDeAsignacion extends Operaciones {

    public OperacionesDeAsignacion(Cluster cluster) {
        this.cluster = cluster;
    }

    public void ejecutarCluster(Integer capacidad) {
        cluster.asignarCapacidadDevCPUs(capacidad);
    }
}
