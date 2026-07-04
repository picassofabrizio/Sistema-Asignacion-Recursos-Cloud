package ar.edu.unahur.obj2.cloud;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.cloud.SistemasPerifericos.ISistemasPerifericos;

public class Cluster implements ICluster {

    private List<ISistemasPerifericos> sistemasInteresados = new ArrayList<>();

    private String identificador;

    private Integer vCPUs;

    public Cluster(String identificador, List<ISistemasPerifericos> sistemasInteresados) {
        this.identificador = identificador;
        this.vCPUs = 0;
        this.sistemasInteresados = sistemasInteresados;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public Integer getvCPUs() {
        return vCPUs;
    }

    public void cambiarIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void asignarCapacidadDevCPUs(Integer capacidad) {
        vCPUs -= capacidad;
        this.notificarSistemasInteresados();
    }

    public void liberarCapacidadDevCPUs(Integer capacidad) {
        vCPUs += capacidad;
        this.notificarSistemasInteresados();
    }

    public void registrarSistemaInteresado(ISistemasPerifericos sistema) {
        sistemasInteresados.add(sistema);
    }

    public void eliminarSistemaInteresado(ISistemasPerifericos sistema) {
        sistemasInteresados.remove(sistema);
    }

    public void notificarSistemasInteresados() {
        for (ISistemasPerifericos sistema : sistemasInteresados) {
            sistema.update(vCPUs);
        }
    }


}
