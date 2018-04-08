package org.yifeng.spring.boot.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

@RestController
public class MyController {

	private class ResourceA {
		
		@JsonProperty("name")
		private final String name = "Resource A";
	}

	private class ResourceB {
		
		@JsonProperty("name")
		private final String name = "Resource B";
	}

	private final ResourceA resourceA = new ResourceA();
	private final ResourceB resourceB = new ResourceB();
	
	@GetMapping("/a")
	public ResourceA getResourceA() {
		return resourceA;
	}
	
	@GetMapping("/b")
	public ResourceB getResourceB() {
		return resourceB;
	}
}
