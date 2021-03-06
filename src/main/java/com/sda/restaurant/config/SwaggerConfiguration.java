package com.sda.restaurant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Value("${swagger.title}")
    private String title;
    @Value("${swagger.description}")
    private String description;
    @Value("${swagger.version}")
    private String version;

    @Bean //Docket: customizes Swagger; Could be a few instances of Docket e.g. for different groups
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .paths(PathSelectors.ant("/restaurant/*"))
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.sda.restaurant"))
                // .apis(Predicates.not(RequestHandlerSelectors.basePackage("com.sda.restaurant")))
                // .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiDetails());
    }

//    @Bean
//    public Docket orderValidationApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("order")
//                .apiInfo(apiInfo())
//                .select()
//                .paths(PathSelectors.ant("/restaurant/orders/**"))
//                .build();
//    }

    private ApiInfo apiDetails() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();
    }
}
