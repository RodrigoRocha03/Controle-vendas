package com.example.controlevendas.configs;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket ClienteControlApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.controlevendas"))
				.paths(PathSelectors.ant("/api/**")).build().apiInfo(metaInfo());
		// /controle-pedido
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo("Controle de vendas API REST", "API REST Controle de Vendas.", "1.0",
				"Terms of Service", new Contact("Rodrigo Rocha", "(11)99927-0396", "rodriguinhorocha03@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());

		return apiInfo;
	}

}