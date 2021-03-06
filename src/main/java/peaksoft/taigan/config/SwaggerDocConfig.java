//package peaksoft.taigan.config;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import peaksoft.taigan.api.OrderApi;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerDocConfig {
//
////    private static final String ALL_CHILD = ".*";
////
////    private ApiInfo metadata() {
////        return new ApiInfoBuilder().title("Swagger Demo").description("API reference guide for developers")
////                .termsOfServiceUrl("https://www.javacodegeeks.com/").contact(new Contact("", "", "mary.zheng@jcg.org"))
////                .version("1.0").build();
////    }
////
////    @Bean
////    public Docket itemApi() {
////        return new Docket(DocumentationType.SWAGGER_2).groupName("Item API").apiInfo(metadata()).select()
////                .paths(regex(OrderApi.ROOT_PATH + ALL_CHILD)).build();
////
////    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
////                .select()
////                .apis(RequestHandlerSelectors.any())
////                .paths(PathSelectors.any())
////                .build()
////                .apiInfo(apiInfo());
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(regex("/.*"))
//                .build().apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "My Project's REST API",
//                "This is a description of your API.",
//                "version-1",
//                "API TOS",
//                "me@wherever.com",
//                "API License",
//                "API License URL");
//    }
//
//}
