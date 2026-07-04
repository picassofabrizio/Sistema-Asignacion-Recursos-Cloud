package ar.edu.unahur.obj2.cloud;
public class Cluster implements ICluster {
   private String identificador;

   private Integer vCPUs;

   public Cluster(String identificador) {
    this.identificador = identificador;
    this.vCPUs = 0;
   }

   @Override
   public String getIdentificador() {
    return identificador;
   }

   @Override
   public Integer getvCPUs() {
    return vCPUs;
   }

   
   public void asignarCapacidadDevCPUs(Integer capacidad){
    vCPUs -= capacidad;
   }

   public void liberarCapacidadDevCPUs(Integer capacidad){
    vCPUs += capacidad;
   }



   

}
