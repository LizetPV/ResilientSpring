## Implementación de Circuit Breaker con Spring Cloud y Hystrix

### **Paso 1: Configuración del archivo POM**
Se creó la aplicación implementando un circuit breaker utilizando Hystrix. Se agregaron las dependencias necesarias en el archivo pom.xml, incluyendo la biblioteca de Hystrix para la implementación del circuit breaker y Hystrix Dashboard para la visualización.

### **Paso 2: Configuración de Propiedades**
En el archivo de propiedades, se configuró el puerto en el cual la aplicación Spring Boot se ejecutará.

### **Paso 3: Habilitar Circuit Breaker con Anotaciones**
En el código principal, se habilitó el soporte para circuit breakers mediante la anotación @EnableCircuitBreaker. Además, se utilizó @EnableHystrixDashboard para visualizar información sobre los circuitos en ejecución.

### **Clase REST Controller y Métodos Anotados**
Se definió un REST Controller con tres métodos: hello(), helloYT(), y fallBackHello(). Los dos primeros métodos utilizan la anotación @HystrixCommand para gestionar la tolerancia a fallos. El tercer método actúa como fallback en caso de error en los métodos principales.

### **Descripción del Primer Método**
En el método hello(), se implementó un condicional que utiliza la clase RandomUtils.nextBoolean() para generar valores booleanos aleatorios. Si la condición es verdadera, se lanza una excepción y se ejecuta el método fallBackHello().

### **Estados del Circuit Breaker**
- **Cerrado (Closed):** Permite que las llamadas se realicen normalmente.
- **Abierto (Open):** Bloquea las llamadas al recurso debido a un número alto de fallos recientes.
- **Medio Cerrado (Half-Open):** Permite realizar una prueba para ver si el recurso ha vuelto a la normalidad después de un período de tiempo.
Estos pasos y anotaciones permiten la implementación efectiva de un circuit breaker para mejorar la tolerancia a fallos en la aplicación.


![image](https://github.com/LizetPV/demoHystrix/assets/122371050/8e172611-5010-411f-8f34-8379b4c01bdb)

## **Conclusión**

En la implementación del Circuit Breaker con Spring Cloud y Hystrix, se logró fortalecer la resiliencia de la aplicación ante posibles fallos y mejorar la experiencia del usuario al manejar de manera eficiente situaciones adversas. Los pasos detallados, desde la configuración del POM hasta la anotación de clases y métodos, proporcionaron una base sólida para la gestión de errores.

La combinación de la anotación `@HystrixCommand` y la visualización a través de `Hystrix Dashboard` facilitó el monitoreo y la comprensión del comportamiento de los circuitos en ejecución. Los estados del circuit breaker, como Cerrado, Abierto y Medio Cerrado, permitieron una adaptación dinámica a las condiciones del sistema.

Este proyecto no solo demostró la implementación técnica de un circuit breaker, sino también la importancia de diseñar sistemas robustos que puedan enfrentar desafíos en entornos reales. La aplicación resultante está mejor preparada para mantener la disponibilidad y el rendimiento incluso en situaciones adversas.

A medida que avanzamos, la adopción de prácticas como estas contribuirá a la creación de aplicaciones más resilientes y confiables, garantizando una experiencia fluida para los usuarios finales.

*Este proyecto fue desarrollado por [Yesenia Peche] - [Lizet.peche@gmail.com] - [26/12/2023]*
