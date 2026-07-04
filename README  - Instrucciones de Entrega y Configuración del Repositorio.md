
# **☁️ Sistema de Asignación de Recursos Cloud (SARC)**

### **📝 Instrucciones de Entrega y Configuración del Repositorio**

Antes de comenzar a codificar, debes preparar tu entorno de trabajo para garantizar que la entrega se realice en tu repositorio personal. Sigue estos pasos estrictamente:  

**Paso 1: Crear el repositorio personal**  
Ingresa a tu cuenta de GitHub y crea un nuevo repositorio **público**. El repositorio debe llamarse exactamente: Sistema-Asignacion-Recursos-Cloud. *No lo inicialices con un README, .gitignore ni licencia.*  

**Paso 2: Clonar el proyecto base de la cátedra**  
Abre tu terminal y clona el repositorio con la estructura inicial del parcial:

Bash  
git clone https://github.com/moreirard/Sistema-Asignacion-Recursos-Cloud.git  
cd Sistema-Asignacion-Recursos-Cloud

**Paso 3: Desvincular el repositorio de la cátedra y apuntar al tuyo**  
Para asegurar que tus push vayan a tu cuenta y no al repositorio original, debes cambiar la URL del origen remoto (origin):

Bash  
git remote set-url origin https://github.com/TU\_USUARIO\_DE\_GITHUB/Sistema-Asignacion-Recursos-Cloud.git

*(Reemplaza TU\_USUARIO\_DE\_GITHUB por tu nombre de usuario real en GitHub).*  

**Paso 4: Verificar la configuración del remoto (⚠️ MUY IMPORTANTE)**  
Verifica que el cambio se haya realizado correctamente ejecutando:

Bash  
git remote \-v

**Salida esperada:**  
origin \[https://github.com/TU\_USUARIO\_DE\_GITHUB/Sistema-Asignacion-Recursos-Cloud.git\](https://github.com/TU\_USUARIO\_DE\_GITHUB/Sistema-Asignacion-Recursos-Cloud.git) (fetch)  
origin \[https://github.com/TU\_USUARIO\_DE\_GITHUB/Sistema-Asignacion-Recursos-Cloud.git\](https://github.com/TU\_USUARIO\_DE\_GITHUB/Sistema-Asignacion-Recursos-Cloud.git) (push)  
*Si en la salida sigue apareciendo moreirard, repite el Paso 3\. No debes realizar ningún push hasta que la URL apunte a tu usuario.*  

**Paso 5: Subir el código base a tu repositorio**  
Realiza el primer envío para sincronizar la estructura base con tu repositorio personal:

Bash  
git push \-u origin main

*(Nota: Si la rama principal se llama master, usa git push \-u origin master).*  
A partir de este momento, puedes comenzar el desarrollo guiado por pruebas y realizar tus commits y push de manera habitual.
