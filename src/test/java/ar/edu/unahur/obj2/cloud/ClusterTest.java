package ar.edu.unahur.obj2.cloud;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cloud.SistemasPerifericos.SistemasInteresados;

public class ClusterTest {
    @Test
    public void clustervCPUs() {
        ArrayList sistemasInteresados = new ArrayList<>();

        Cluster cluster = new Cluster("Cluster1", sistemasInteresados);

        cluster.asignarCapacidadDevCPUs(10);
        assertTrue(cluster.getvCPUs() == -10);
    }

    @Test
    public void clustervCPUsLiberar() {
        ArrayList sistemasInteresados = new ArrayList<>();

        Cluster cluster = new Cluster("Cluster1", sistemasInteresados);

        cluster.liberarCapacidadDevCPUs(10);
        assertTrue(cluster.getvCPUs() == 10);
    }

    @Test
    public void clustervCPUsNotificar() {
        ArrayList sistemasInteresados = new ArrayList<>();
        SistemasInteresados sistema1 = new SistemasInteresados();
        sistemasInteresados.add(sistema1);

        Cluster cluster = new Cluster("Cluster1", sistemasInteresados);

        cluster.asignarCapacidadDevCPUs(10);
        assertTrue(cluster.getvCPUs() == -10);
    }

    @Test
    public void clustervCPUsAsignar() {
        ArrayList sistemasInteresados = new ArrayList<>();

        Cluster cluster = new Cluster("Cluster1", sistemasInteresados);

        cluster.asignarCapacidadDevCPUs(10);
        assertTrue(cluster.getvCPUs() == -10);
    }

    @Test
    public void clustervCPUsLiberarNotificar() {
        ArrayList sistemasInteresados = new ArrayList<>();
        SistemasInteresados sistema1 = new SistemasInteresados();
        sistemasInteresados.add(sistema1);

        Cluster cluster = new Cluster("Cluster1", sistemasInteresados);

        cluster.liberarCapacidadDevCPUs(10);
        assertTrue(cluster.getvCPUs() == 10);
    }

    @Test
    public void clusterGetters() {
        ArrayList sistemasInteresados = new ArrayList<>();

        Cluster cluster = new Cluster("Cluster1", sistemasInteresados);

        assertTrue(cluster.getIdentificador().equals("Cluster1"));
        assertTrue(cluster.getvCPUs() == 0);
    }

    @Test
    public void clusterSetters() {
        ArrayList sistemasInteresados = new ArrayList<>();

        Cluster cluster = new Cluster("Cluster1", sistemasInteresados);

        cluster.cambiarIdentificador("Cluster2");
        assertTrue(cluster.getIdentificador().equals("Cluster2"));
    }

    @Test
    public void clusterRegistrarEliminarSistemasInteresados() {
        ArrayList sistemasInteresados = new ArrayList<>();
        SistemasInteresados sistema1 = new SistemasInteresados();
        sistemasInteresados.add(sistema1);

        Cluster cluster = new Cluster("Cluster1", sistemasInteresados);

        SistemasInteresados sistema2 = new SistemasInteresados();
        cluster.registrarSistemaInteresado(sistema2);
        assertTrue(cluster.getvCPUs() == 0);

        cluster.eliminarSistemaInteresado(sistema1);
        assertTrue(cluster.getvCPUs() == 0);
    }

}
