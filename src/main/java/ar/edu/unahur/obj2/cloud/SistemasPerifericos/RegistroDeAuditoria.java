package ar.edu.unahur.obj2.cloud.SistemasPerifericos;

public class RegistroDeAuditoria implements ISistemasPerifericos {
    @Override
    public void update(Integer capacidad) {
        System.out.println("Registro de auditoría: La capacidad del cluster ha cambiado a: " + capacidad);
    }

}
