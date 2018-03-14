package com.gtu.EngBook;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan
public class EngBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(EngBookApplication.class, args);
	}

	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){
		return hemf.getSessionFactory();
	}

}