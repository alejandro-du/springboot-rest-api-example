package com.example;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

@RestController
@RequestMapping("/api/v1")
public class ExampleService {

	private static Faker faker = new Faker();

	@GetMapping("/funnyNames")
	public List<String> funnyNames(@RequestParam(required = false) Integer count) {
		return IntStream.range(0, count == null ? 10 : count)
				.mapToObj(i -> faker.funnyName().name())
				.toList();
	}

	@GetMapping("/people")
	public List<Person> people(@RequestParam(required = false) Integer count) {
		return IntStream.range(0, count == null ? 10 : count)
				.mapToObj(i -> faker.beer())
				.map(beer -> new Person(
						faker.name().firstName(),
						faker.name().lastName(),
						new Beer(
								beer.name(),
								beer.style(),
								beer.yeast(),
								beer.hop(),
								beer.malt())))
				.toList();
	}

}
