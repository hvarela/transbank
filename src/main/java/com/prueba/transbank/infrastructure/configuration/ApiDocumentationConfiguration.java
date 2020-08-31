package com.prueba.transbank.infrastructure.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;

/**
 * Setup Springfox plugin to generate Swagger style API documentation.
 *
 * @see Configuration
 * @see EnableSwagger2
 */
@Configuration
@EnableSwagger2
public class ApiDocumentationConfiguration {

    /**
     * Defines basic information about your API (as the path mapping
     * and the API info).
     *
     * @return Docket
     *
     * @see ApiInfo
     * @see Docket
     */
    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .build()
                .pathMapping("/")
                .apiInfo(metadata());

    }



    /**
     * Generates metadata that represents the general information
     * about the API or service being constructed.
     * This method generates the information you can see in
     * <app_endpoint>/private/info
     * @return ApiInfo
     */
    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Test Transbank")
                .description("Restaurant REST API template")
                .version("1.0")
                .contact(new Contact("Hector varela",  "","hector.varela@gmail.com"))
                .build();
    }
}
