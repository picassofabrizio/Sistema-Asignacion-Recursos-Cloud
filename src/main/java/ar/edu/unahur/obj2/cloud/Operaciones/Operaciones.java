package ar.edu.unahur.obj2.cloud.Operaciones;

import ar.edu.unahur.obj2.cloud.Cluster;
import ar.edu.unahur.obj2.cloud.ICluster;

//COMPOSITE
public abstract class Operaciones implements ICluster {

    protected Cluster cluster;

    public Cluster getCluster() {
        return cluster;
    }

    public void undoCluster(Integer capacidad) {
    }

    public void ejecutarCluster(Integer capacidad) {
    }
    
    @Override
    public Integer getvCPUs() {
        return cluster.getvCPUs();
    }

    @Override
    public String getIdentificador() {
        return cluster.getIdentificador();
    }
}
