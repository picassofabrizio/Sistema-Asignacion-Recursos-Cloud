
# **☁️ Sistema de Asignación de Recursos Cloud (SARC)**

Un proveedor de infraestructura en la nube necesita implementar un sistema centralizado que permita administrar y registrar las operaciones de asignación de capacidad de procesamiento sobre sus clústeres de servidores. Además, el sistema deberá evolucionar para que otros componentes periféricos de monitoreo y telemetría puedan reaccionar automáticamente cuando ocurran variaciones en la disponibilidad de un clúster.

#### **👨‍🏫 Primera Parte.**

**📋 Requerimientos.**  
**🖥️ Clúster de Cómputo.**  
De cada clúster en la red de centros de datos se conoce:

* Identificador del Clúster.  
* Unidades de Cómputo Disponibles (en vCPUs).

Un clúster debe permitir:

* Consultar su capacidad de vCPUs actual.  
* Asignar capacidad (reducir vCPUs disponibles).  
* Liberar capacidad (incrementar vCPUs disponibles).

**⚙️ Operaciones de Infraestructura.**  
El sistema debe soportar inicialmente las operaciones de **Asignación** y **Liberación**. Cada operación encapsula toda la información necesaria para ejecutarse, conociendo el clúster específico sobre el que actúa y la cantidad de recursos (vCPUs) involucrados.  
**📋 Planificador de Despliegues.**  
La plataforma cuenta con un componente responsable de administrar los cambios de capacidad. Este componente debe permitir:

* Ejecutar una operación de forma inmediata.  
* Registrar operaciones pendientes y agruparlas en un "Plan de Despliegue" (lote).  
* Ejecutar todas las operaciones contenidas en un plan de despliegue.  
* Vaciar el listado de operaciones pendientes de un plan luego de ejecutarlas.

**¿Qué pasa si queremos deshacer una operación?**

* ¿Es posible revertir una operación de asignación o liberación ya ejecutada?  
* ¿De quién es la responsabilidad de saber revertir el impacto de la operación en el clúster y cómo se implementa para una operación individual o para un plan de despliegue completo?

**⚠️ Robustez y Control de Errores.**  
El sistema debe garantizar la consistencia de los datos mediante el manejo de dos situaciones anómalas:

1. **Valores Inválidos:** Si se intenta instanciar una operación con un valor menor o igual a **0 vCPUs**, el sistema debe lanzar un error que denote un uso indebido de la lógica. Dado que el código cliente no debería generar estas llamadas si está bien programado, **el compilador no debe obligar a capturar esta falla explícitamente**.  
2. **Límite de *Overprovisioning*:** Se admite un sobre-compromiso de recursos (*overprovisioning*) en el clúster de hasta **\-200 vCPUs**. Si una asignación intenta forzar al clúster por debajo de este límite absoluto, se debe lanzar un error de regla de negocio. Al ser una situación operativa anómala pero esperable, **el diseño debe obligar en tiempo de compilación** a que quien invoque la operación se haga cargo de manejar la situación.

**🔄 Transaccionalidad.**

* Si al ejecutar un **Plan de Despliegue** que contiene múltiples operaciones, una de ellas falla por superar el límite de *overprovisioning*, el plan debe interrumpirse. Inmediatamente, el sistema debe revertir de forma automática únicamente las operaciones de ese mismo plan que ya se habían ejecutado con éxito, devolviendo al clúster al estado exacto que tenía antes de iniciar el lote.

**⚙️ Restricciones de Diseño (Primera Parte).**

* El planificador no debe conocer cómo se implementa internamente cada operación.  
* El sistema debe permitir tratar de manera uniforme tanto a una operación individual como a un plan de despliegue (que contiene múltiples operaciones), de modo que el planificador pueda ejecutarlas usando la misma interfaz.  
* Debe ser posible incorporar nuevos tipos de operaciones sin modificar el código del planificador.  
* Evitar soluciones basadas en condicionales (if / switch) para distinguir tipos de operaciones.  
* Las operaciones deben encapsularse de forma tal que puedan encolarse y cada una sea capaz de deshacer su propia transformación sobre el clúster.

#### **👨‍🏫 Segunda Parte.**

La plataforma desea incorporar sistemas periféricos de observabilidad que reaccionen automáticamente a las variaciones de capacidad.  
**📢 Mecanismo de Suscripción**  
Cada vez que un clúster reciba una asignación o liberación exitosa, los sistemas interesados deben ser informados automáticamente. El clúster debe permitir:

* Registrar sistemas interesados de forma dinámica.  
* Eliminar sistemas interesados.  
* Avisar a todos los inscriptos cuando ocurra un movimiento de recursos.

**🔍 Registro de Auditoría (CloudTrail)** Registra en un log unificado todas las alteraciones exitosas realizadas sobre los clústeres de cómputo.  
**📱 Notificaciones al SRE (Site Reliability Engineer)** Informa al responsable técnico cada vez que ocurre una variación de capacidad en su clúster asignado (ej: *"Se han liberado 50 vCPUs en el clúster US-EAST-1"*).  
**🚨 Alarma de Saturación Crítica** Detecta cuándo un clúster queda por debajo de su nivel óptimo de disponibilidad (cero vCPUs) tras una operación exitosa y advierte al equipo que el clúster está operando en la zona de *overprovisioning*.  
**⚙️ Restricciones de Diseño (Segunda Parte)**

* El clúster no debe conocer los detalles de las clases concretas de los sistemas periféricos (Auditoría, SRE, etc.).  
* Debe ser posible incorporar nuevos sistemas interesados sin modificar el código estructural del Clúster.  
* Un mismo cambio de capacidad puede disparar múltiples reacciones concurrentes en diferentes sistemas.  
* Evitar el uso de condicionales (if / switch / instanceof) en el clúster para identificar o filtrar a quién se le está avisando.

#### **⏱️ Condiciones de Evaluación.**

* **Tiempo máximo de resolución:** 2 horas y 30 minutos reloj.  
* **Metodología:** Desarrollo Guiado por Pruebas (TDD) y refactors sucesivos.  
* **Métrica de éxito:** Se exige alcanzar una cobertura de código (Code Coverage) de al menos un **75%**, demostrando mediante tests el correcto funcionamiento del modelo, las estructuras arquitectónicas implícitas y el comportamiento transaccional ante las fallas descritas.