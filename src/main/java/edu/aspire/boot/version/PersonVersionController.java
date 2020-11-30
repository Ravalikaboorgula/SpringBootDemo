package edu.aspire.boot.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController
{
	@GetMapping("/v1")
	public Person personV1()
	{
		return new  Person("Veeksha");
	}
	
	@GetMapping("/v2")
	public Person2 personV2()
	{
		return  new Person2(new  Name("Veeksha" ,"boorgula"));
		
		
	}
	

	@GetMapping(value="/person/param",params="version=1")
	public Person paramV1()
	{
		return new  Person("Veeksha");
	}
	
	@GetMapping(value="/person/param",params="version=2")
	public Person2 paramV2()
	{
		return  new Person2(new  Name("Veeksha" ,"boorgula"));
		
		
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=1")
	public Person headerV1()
	{
		return new  Person("Veeksha");
	}
	
	@GetMapping(value="/person/header",headers="X-API-VERSION=2")
	public Person2 headerV2()
	{
		return  new Person2(new  Name("Veeksha" ,"boorgula"));
		
		
	}
	

	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v1+json")
	public Person producesV1()
	{
		return new  Person("Veeksha");
	}
	
	@GetMapping(value="/person/produces",produces="application/vnd.company.app-v2+json")
	public Person2 producesV2()
	{
		return  new Person2(new  Name("Veeksha" ,"boorgula"));
		
		
	}

}
