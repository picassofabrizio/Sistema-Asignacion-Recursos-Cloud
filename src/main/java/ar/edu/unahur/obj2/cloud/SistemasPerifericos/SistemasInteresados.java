package ar.edu.unahur.obj2.cloud.SistemasPerifericos;

public class SistemasInteresados implements ISistemasPerifericos {
    @Override
    public void update(Integer capacidad) {
        System.out.println("La capacidad del cluster ha cambiado a: " + capacidad);
    }

}
