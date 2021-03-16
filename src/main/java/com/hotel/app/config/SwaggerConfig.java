package com.hotel.app.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
	// @formatter:off

        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("Hotel Management REST API")
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.ant("/api/**"))
            .paths(Predicates.not(PathSelectors.regex("/api/user-info")))
            .build()
            .apiInfo(apiInfo())
            .securityContexts(Arrays.asList(securityContext()))
            .securitySchemes(Arrays.asList(basicAuthScheme()));

	// @formatter:on
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Hotel Management REST API",
            "RESTFul interface over Hotel Management data",
            "1.0",
            null,
            null,
            null, null, Collections.emptyList());
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(Arrays.asList(basicAuthReference()))
            .forPaths(PathSelectors.ant("/api/**"))
            .build();
    }

    private SecurityScheme basicAuthScheme() {
        return new BasicAuth("basicAuth");
    }

    private SecurityReference basicAuthReference() {
        return SecurityReference.builder()
            .reference("basicAuth")
            .scopes(new AuthorizationScope[0])
            .build();
    }
}