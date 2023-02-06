package com.loiane;

import com.loiane.model.Aluno;
import com.loiane.model.Course;
import com.loiane.repository.AlunoRepository;
import com.loiane.repository.CourseRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);

	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("Front-end");

			courseRepository.save(c);
		};
	}
	CommandLineRunner initDatabase(AlunoRepository alunoRepository) {
		return args -> {
			alunoRepository.deleteAll();

			Aluno a = new Aluno();
			a.setNome("Angular com Spring");
			a.setCpf("5555");

			alunoRepository.save(a);
		};
	}
}
