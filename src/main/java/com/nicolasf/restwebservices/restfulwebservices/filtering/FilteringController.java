package com.nicolasf.restwebservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.converter.json.MappingJacksonValue;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    //DYNAMIC FILTERING
    //Used to filter some fields of the response of the particular request
    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        //Dynamic filtering
        //Filter out all fields except value2 and value3
        //Using SimpleBeanPropertyFilter and FilterProvider from jackson library
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2", "value3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"),
                new SomeBean("value7", "value8", "value9"),
                new SomeBean("value10", "value11", "value12"),
                new SomeBean("value13", "value14", "value15")
        );
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }
}
