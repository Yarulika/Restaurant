package com.sda.restaurant;

import com.sda.restaurant.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

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
