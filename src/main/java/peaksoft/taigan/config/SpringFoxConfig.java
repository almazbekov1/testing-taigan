//package peaksoft.taigan.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.Collections;
//
//@EnableSwagger2WebMvc
//@Import(SpringDataRestConfiguration.class)
//public class SpringFoxConfig {
//
////    @Bean
////    public Docket api() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .groupName("Rest")
////                .select()
////                .apis(RequestHandlerSelectors.basePackage("peaksoft.taigan"))
////                .paths(PathSelectors.any())
////                .build()
////                .apiInfo(apiInfo());
////    }
//
////    @Bean
////    public Docket api() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .select()
////                .apis(RequestHandlerSelectors.any())
////                .paths(PathSelectors.any())
////                .build()
////                .apiInfo(apiInfo());
////    }
////    private ApiInfo apiInfo() {
////        return new ApiInfo(
////                "Online Store",
////                "Here you can buy tech products",
////                "1.0",
////                "1.0",
////                "1.0",
////                "1.0",
////                "1.0");
////    }
//}