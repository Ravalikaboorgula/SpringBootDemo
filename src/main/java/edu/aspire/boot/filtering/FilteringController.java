package edu.aspire.boot.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	
	


	//returns single bean
	@GetMapping("/filtering")
	public MappingJacksonValue retrievesomeBean()
	{
		SomeBean someBean =new SomeBean("sony","shiva","veeksha") ;
		MappingJacksonValue mapping=new MappingJacksonValue(someBean);
		
		//SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter().filterOutAllExcept("field1","field2");
		
		//filter  only field3
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	


	//returns a list of beans
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfsomeBeans()
	{
		List<SomeBean> list= Arrays.asList(new SomeBean("value1","value2","value3")
				,new SomeBean("value12","value22","value32")
				,new SomeBean("value13","value23","value33"));
		
        MappingJacksonValue mapping=new MappingJacksonValue(list);
		
		//SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter().filterOutAllExcept("field1","field2");
		
		//filter  only field3
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);
		
		return mapping;
		
	}
}
