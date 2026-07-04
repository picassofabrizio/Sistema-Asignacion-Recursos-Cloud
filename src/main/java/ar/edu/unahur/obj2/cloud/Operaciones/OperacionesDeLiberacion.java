package ar.edu.unahur.obj2.cloud.Operaciones;

import ar.edu.unahur.obj2.cloud.Cluster;

public class OperacionesDeLiberacion extends Operaciones {
     private Cluster cluster;

    public OperacionesDeLiberacion(Cluster cluster) {
        this.cluster = cluster;
    }

    public void undoCluster(Integer capacidad) {
        cluster.liberarCapacidadDevCPUs(capacidad);
    }
}
