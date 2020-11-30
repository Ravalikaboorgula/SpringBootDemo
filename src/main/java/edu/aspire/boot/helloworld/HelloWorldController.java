package edu.aspire.boot.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import edu.aspire.boot.helloworld.HelloWorldBean;

@RestController
public class HelloWorldController 

{
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping(path="hello")
	public String helloworld()
	{
		return "hello world";
	}
	

	@GetMapping(path="hello-bean")
	public HelloWorldBean helloworldbean()
	{
		return new HelloWorldBean("hello world");
	}
	
	@GetMapping(path="hello/{name}")
	public HelloWorldBean helloworldbean(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("hello world, %s",name));
	}
	
	@GetMapping(path="hello/internationalised")
	public String helloworldint()
	{
		
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
	
	
	
	

}
