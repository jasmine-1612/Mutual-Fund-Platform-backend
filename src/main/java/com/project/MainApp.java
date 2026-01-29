package com.project;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class MainApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApp.class, args);
        System.out.println("Hello World Spring Boot app started");
    }
    
    @Bean
	public Docket swaggerConfiguration()
	{
		ParameterBuilder aParameterBuilder=new ParameterBuilder();
		
		aParameterBuilder.name("Authorization")
		.modelRef(new ModelRef("string"))
		.parameterType("header")
		.defaultValue("Basic i38kdks8x")
		.required(false)
		.build();
		
		java.util.List<Parameter> allParameters=new ArrayList();
		
		allParameters.add(aParameterBuilder.build());
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**")) 
				.apis(RequestHandlerSelectors.basePackage("com.project"))
				.build()
				.globalOperationParameters(allParameters)
				.apiInfo(apiDetails());
	}
	private ApiInfo apiDetails()
	{
		
		return new ApiInfo("Mutual Fund REST API",
				"crud opertions customer",
				"1.0",
				"Free APIs",
				new springfox.documentation.service.Contact("Ayush", "ayushvarma.com", "ayushvarma04@gmail.com"),
				"API license",
				"http://www.ayushvarma.com",
				Collections.emptyList()
				
				);
	}
  

}
