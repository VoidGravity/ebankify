//package org.example.demo9;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class Demo9Application {
//
//	public static void main(String[] args) {
//		SpringApplication.run(Demo9Application.class, args);
//	}
//
//}
////


// Demo9Application.java
package org.example.demo9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.example.demo9.model")
@EnableJpaRepositories("org.example.demo9.repository")
public class Demo9Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo9Application.class, args);
	}
}