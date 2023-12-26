POM
PASO 1.- Se creo la siguiente aplicación para lo cual se agregaron las dependencias requeridas en el archivo pom. En este caso la biblioteca de hystrix que es la implementación de circuit breaker, hystrix dashboard para visualizar el y en el caso de esta dependencia actuator proporcionan información sobre el estado y las métricas de la aplicación en ejecución.
PASO 2: Properties: en este archivo se configura el puerto en la cual va a correr la aplicación spring boot.
MAIN
PASO 3: 
@EnableCircuitBreaker: Esta anotación habilita el soporte para circuit breakers en la aplicación. Así mismo esto Indica que la aplicación utilizará circuit breakers para manejar la tolerancia a fallos. En este caso, Spring Cloud proporciona el soporte para circuit breakers a través de Hystrix.
@EnableHystrixDashboard: El Hystrix Dashboard proporciona una interfaz gráfica que muestra información sobre el estado de los circuitos Hystrix en ejecución. Permite monitorear y visualizar métricas relacionadas con la tolerancia a fallos.
CLASE REST CONTROLLER:
En este punto se tiene la clase rest controller. Dentro de esta clase se han definido 3 métodos. El primer método es hello(), el segundo helloYT() y un tercer método fallBackHello().
Para los dos primeros métodos se está utilizando la anotación de @HystrixCommand, el cual indica que este método será gestionado por Hystrix para la tolerancia a fallos.
fallbackMethod = "fallBackHello" especifica el nombre del método de fallback que se ejecutará si ocurre un error en el método principal.
commandKey y groupKey son identificadores únicos para el comando Hystrix, utilizados en el monitoreo y la configuración.
commandProperties:  establece propiedades específicas del comando, como el umbral de solicitudes y el porcentaje de errores que activarán el circuit breaker, así como el tiempo de espera (sleepWindowInMilliseconds) antes de intentar la transición a "semiabierto".
PRIMER METODO: Este metodo hello(), dentro de este metodo se tiene un condicional if, el cual utiliza una clase llamada RandomUtils.nextBoolean() que lo que hace es generar aleatoriamente valores booleanos, es decir true o false. Es decir que si esta condición es verdadera se lanza la excepción y entra al metodo fallBackHello ().
Cerrado (Closed): Permite que las llamadas se realicen normalmente.
Abierto (Open): Bloquea las llamadas al recurso debido a un número alto de fallos recientes.
Medio Cerrado (Half-Open): Permite realizar una prueba para ver si el recurso ha vuelto a la normalidad después de un período de tiempo.


![image](https://github.com/LizetPV/demoHystrix/assets/122371050/8e172611-5010-411f-8f34-8379b4c01bdb)

