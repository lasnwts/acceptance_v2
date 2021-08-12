package ru.uralsib.acceptance;

import com.google.common.base.Predicates;
import io.opentracing.util.GlobalTracer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.uralsib.acceptance.model.Customers_init;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AcceptanceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AcceptanceApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(Predicates.or(
                        PathSelectors.ant("/api/v1/*"),
                        PathSelectors.ant("/api/v1/id/*"),
                        PathSelectors.ant("/api/v1/get_id/*"),
                        PathSelectors.ant("/api/v1/salary/*"),
                        PathSelectors.ant("/api/v1/del/*"),
                        PathSelectors.ant("/api/service/**")
                ))
                .apis(RequestHandlerSelectors.basePackage("ru.uralsib"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Alexander Lyapustin", "../", "LyapustinAS@spb.uralsib.ru");
        return new ApiInfoBuilder()
                .title("Spring boot 2 Api Title 07/08/2021")
                .description("Example Api Definition by @alexander")
                .version("0.0.1")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }

    @Override
    public void run(String... args) throws Exception {
       Customers_init customers_init = new Customers_init();
    }


}
