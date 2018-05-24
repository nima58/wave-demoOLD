package com.example.wavedemo.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket waveApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(Predicates.not(requestHandler -> {
                    // exclude all methods being OPTIONS, HEAD or PATCH
                    final Set<RequestMethod> methods = requestHandler.getRequestMapping().getMethodsCondition().getMethods();
                    return !Collections.disjoint(methods, Arrays.asList(RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.PATCH));
                }))
                .paths(regex("/wave/v.*"))
                .build();
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot REST API")
                .description("\"Spring Boot REST API for Online Store\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Homer Simpson", "localhost:8080/about/", "homer@simpson.com"))
                .build();
    }
   // @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
