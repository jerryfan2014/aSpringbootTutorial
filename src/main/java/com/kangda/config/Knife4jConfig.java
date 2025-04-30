//package com.kangda.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class Knife4jConfig {
//    @Bean(value = "defaultApi2")
//    public Docket defaultApi2() {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                // 分组名称
//                .groupName("1.0版本")
//                .select()
//                // 这里指定Controller扫描包路径
//                .apis(RequestHandlerSelectors.basePackage("com.kangda.controller"))  // controller包路径
//                .paths(PathSelectors.any())
//                .build();
//        return docket;
//    }
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                //.title("swagger-bootstrap-ui-demo RESTful APIs")
//                .description("# knife4j RESTful APIs")
//                .termsOfServiceUrl("http://www.kangda.com/")
////                .contact("tom@qq.com")
//                .version("1.0")
//                .build();
//    }
//}
