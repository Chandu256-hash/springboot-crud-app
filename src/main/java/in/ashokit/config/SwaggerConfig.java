// package in.ashokit.config;


// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// //import springfox.documentation.builders.PathSelectors;
// //import springfox.documentation.builders.RequestHandlerSelectors;
// //import springfox.documentation.spi.DocumentationType;
// //import springfox.documentation.spring.web.plugins.Docket;
// //import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @Configuration
// public class SwaggerConfig
// {
//    @Bean
//    public Docket apiDoc(){

//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("in.ashokit.rest"))
//                .paths(PathSelectors.any())
//                .build();
//    }

// }


// package in.ashokit.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Info;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()
//                 .info(new Info()
//                         .title("CRUD API Documentation")
//                         .version("1.0")
//                         .description("API documentation for CRUD operations"));
//     }
// }
