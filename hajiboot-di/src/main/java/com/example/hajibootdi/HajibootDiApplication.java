package com.example.hajibootdi;

import com.example.hajibootdi.Argument;
import com.example.hajibootdi.ArgumentResolver;
import com.example.hajibootdi.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HajibootDiApplication implements CommandLineRunner {
	@Autowired
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;

	@Override
	public void run(String...strings) throws Exception {
    System.out.print("Enter 2 numbers like 'a b' : ");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result = " + result);
	}
	public static void main(String[] args) {
		SpringApplication.run(HajibootDiApplication.class, args);
	}
}
