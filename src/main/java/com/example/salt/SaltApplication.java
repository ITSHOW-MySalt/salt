package com.example.salt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.example.salt.dao")
@SpringBootApplication
public class SaltApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaltApplication.class, args);
	}
}
