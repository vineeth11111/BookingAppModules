package com.luv2code.runner;

import java.util.Map;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//@Component
@ConfigurationProperties(prefix="my.app")
@Order(1)
public class ReadingMapDataFromPropertiesRunner implements CommandLineRunner {

	Map<String,String> edata;
	
	
	public Map<String, String> getEdata() {
		return edata;
	}


	public void setEdata(Map<String, String> edata) {
		this.edata = edata;
	}


	@Override
	public void run(String... args) throws Exception {
	Set<String> keySet = edata.keySet();
     for(String key:keySet)
    	 System.out.println(edata.get(key));
	}

}
