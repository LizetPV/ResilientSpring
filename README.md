Implementación de Circuit Breaker con Spring Cloud y Hystrix

Paso 1: Configuración del archivo POM
Se creó la aplicación implementando un circuit breaker utilizando Hystrix. Se agregaron las dependencias necesarias en el archivo pom.xml, incluyendo la biblioteca de Hystrix para la implementación del circuit breaker y Hystrix Dashboard para la visualización.

Paso 2: Configuración de Propiedades
En el archivo de propiedades, se configuró el puerto en el cual la aplicación Spring Boot se ejecutará.

Paso 3: Habilitar Circuit Breaker con Anotaciones
En el código principal, se habilitó el soporte para circuit breakers mediante la anotación @EnableCircuitBreaker. Además, se utilizó @EnableHystrixDashboard para visualizar información sobre los circuitos en ejecución.

Clase REST Controller y Métodos Anotados
Se definió un REST Controller con tres métodos: hello(), helloYT(), y fallBackHello(). Los dos primeros métodos utilizan la anotación @HystrixCommand para gestionar la tolerancia a fallos. El tercer método actúa como fallback en caso de error en los métodos principales.

Descripción del Primer Método
En el método hello(), se implementó un condicional que utiliza la clase RandomUtils.nextBoolean() para generar valores booleanos aleatorios. Si la condición es verdadera, se lanza una excepción y se ejecuta el método fallBackHello().

Estados del Circuit Breaker
Cerrado (Closed): Permite que las llamadas se realicen normalmente.
Abierto (Open): Bloquea las llamadas al recurso debido a un número alto de fallos recientes.
Medio Cerrado (Half-Open): Permite realizar una prueba para ver si el recurso ha vuelto a la normalidad después de un período de tiempo.
Estos pasos y anotaciones permiten la implementación efectiva de un circuit breaker para mejorar la tolerancia a fallos en la aplicación.

Creado por Yesenia Peche


![image](https://github.com/LizetPV/demoHystrix/assets/122371050/8e172611-5010-411f-8f34-8379b4c01bdb)

