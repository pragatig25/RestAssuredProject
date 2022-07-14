package com.simplilearn;

import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {


	
	
		
		public static RequestSpecification httpRequest;
		public static Response response;
		
		public Logger logger;
		
		@BeforeClass
		public void setUp() {
			logger = Logger.getLogger("LogDemo");
			PropertyConfigurator.configure("log4j.properties");
			((Category) logger).setLevel(Level.DEBUG);
		}

	}

