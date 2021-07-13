package com.bluebank.backend.bluebankbackend.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bluebank.backend.bluebankbackend.web.controller"))
                .build()
                .apiInfo(apiEndPointInfo());
    }

    private ApiInfo apiEndPointInfo() {
        return new ApiInfoBuilder().title("BlueBank Backend")
                .description("Api para la creación de cuentas de ahorro, y realizar transacciones en ellas como abono y retiro")
                .version("1.0.0")
                .build();
    }

    /*
    http://localhost:8090/luismarket/api/swagger-ui.html
    Consultar esta url para revisar DOC.
     */
}