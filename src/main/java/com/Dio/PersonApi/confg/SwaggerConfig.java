package com.Dio.PersonApi.Swagger;

import com.Dio.PersonApi.confg.ResponseMessageBuild;
import io.swagger.annotations.Contact;
import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Reporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import javax.lang.model.SourceVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean

    public Doclet PersonApi() {
        return new Doclet(DocumentationType.SWAGGER_2) {
            @Override
            public void init(Locale locale, Reporter reporter) {

            }

            @Override
            public String getName() {
                return null;
            }

            @Override
            public Set<? extends Option> getSupportedOptions() {
                return null;
            }

            @Override
            public SourceVersion getSupportedSourceVersion() {
                return null;
            }

            @Override
            public boolean run(DocletEnvironment environment) {
                return false;
            }
        }

                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, responseMessageForGET());
        }

            private ApiInfo metaInfo() {
                return new ApiInfoBuilder()
                    .title("Person API REST")
                    .description("API REST for register persons")
                    .version("1.0")
                    .contact(new Contact("Belisnalva","https://github.com/BelisnalvaCosta/"))
                    .build();
            }

            private List<ResponseMessage> responseMessageForGET() {
                return new ArrayList<ResponseMessage>() {
                    private static final long serialVersionUID = 1L;

                    {
                        add(new ResponseMessageBuild()
                                .code(500)
                                .message("500 message")
                                .responseModel(new ModelRef("Error"))
                                .build());
                        add(new ResponseMessageBuilder()
                                .code(403)
                                .message("Forbidden not being able to do this action!")
                                .build());
                    }
                };
            }
    }
}
