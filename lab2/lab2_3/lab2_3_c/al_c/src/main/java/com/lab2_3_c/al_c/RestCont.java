package com.lab2_3_c.al_c;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCont {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public AlCApplication greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new AlCApplication(counter.incrementAndGet(), String.format(template, name));
	}
}
