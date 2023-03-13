package com.sabanciuniv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FinartzCaseStudyApplication  {

	// @Autowired HavalimaniRepository rep;

	// @Override
	// public void run(String... args) throws Exception {
	// 	if (rep.count() == 0) {
	// 		Havalimani liman1 = new Havalimani();

	// 		rep.save(liman1);
	// 	}
	// }

	public static void main(String[] args) {
		SpringApplication.run(FinartzCaseStudyApplication.class, args);
	}

	

}
