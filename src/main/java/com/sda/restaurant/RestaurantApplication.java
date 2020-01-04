package com.sda.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration + @EnableAutoConfiguration + @ComponentScan
@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);

//        Person annPerson = new Person(
//                "Anna", "Yar",
//                "a@y.com", "Espoo",
//                "annuser", "root");
//        System.out.println(annPerson.toString());
	}

}
