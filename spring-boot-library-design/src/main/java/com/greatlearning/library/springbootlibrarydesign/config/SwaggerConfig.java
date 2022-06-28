package com.greatlearning.library.springbootlibrarydesign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket libraryApi() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("Library-API").select().apis(
				RequestHandlerSelectors.basePackage("com.greatlearning.library.springbootlibrarydesign.controller"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Library API")
				.description("Library API referance for developers")
				.termsOfServiceUrl("http://mylibrary.com")
				.contact(new Contact("Library API", "http://mylibrary.com", "mylibrary@gmail.com"))
				.license("Library Licence")
				.licenseUrl("http://mylibrary.com")
				.version("1.0")
				.build();
	}

}
