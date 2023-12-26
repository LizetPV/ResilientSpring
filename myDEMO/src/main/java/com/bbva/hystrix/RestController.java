package com.bbva.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    @HystrixCommand(
            fallbackMethod = "fallBackHello",
            commandKey = "hello",
            groupKey = "hello",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"), //propiedad  numero minimo de solicitudes
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") // Tiempo de espera antes de intentar la transición a "semiabierto"
            }
    )
    @GetMapping("/hello")
    public String hello() {

        if (RandomUtils.nextBoolean()) {//clase y metodo que genera aleatoriamente valores booleanos
            throw new RuntimeException("Failed!");
        }
        return "Hello World";
    }


    @HystrixCommand(
            fallbackMethod = "fallBackHello",
            commandKey = "helloYT",
            groupKey = "helloYT",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") // Tiempo de espera antes de intentar la transición a "semiabierto"
            }
    )
    @GetMapping("/helloYT")
    public String helloYT() {

        if (RandomUtils.nextBoolean()) {
            throw new RuntimeException("Failed!");
        }
        return "Hello World Youtube";
    }


    public String fallBackHello() {
        return "Fall Back Hello initiated";
    }


}
