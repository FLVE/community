package life.codedw.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @Author wangjiefang
 * @Date 2:24 2020/5/5
 * @Description
 **/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment){
        //设置显示的环境
        Profiles profiles = Profiles.of("dev");
        //获取项目的环境,判断是否处于自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("codedw")
                //.enable(flag)    是否启用swagger
                .select()
                /**
                 * basePacking：指定要扫描的包
                 * any：全部扫描
                 * none：不扫描
                 * withClassAnnotation：扫描类注解
                 * withMethodAnnotation：方法注解
                 */
                .apis(RequestHandlerSelectors.basePackage("life.codedw.community.controller"))
                /**
                 * 过滤什么路径
                 */
                //.paths(PathSelectors.none())
                .build();
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact(
                "codedw",
                "https://codedw.life/",
                "jiefang.wang@outlook.com");

        return new ApiInfo(
                "Swagger文档",
                "描述",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
}
