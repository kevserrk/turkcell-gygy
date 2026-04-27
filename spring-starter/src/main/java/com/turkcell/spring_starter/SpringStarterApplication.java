package com.turkcell.spring_starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //annotation => bulunduğu class'a , fonksiyona, değişkene özellik kazandıran yapıdır. bu class'ın üzrine @SpringBootApplication yazıldığında bu class bir spring boot uygulaması görevi görür.
public class SpringStarterApplication {

	//entrypoint
	public static void main(String[] args) {
		SpringApplication.run(SpringStarterApplication.class, args);
	}

}
