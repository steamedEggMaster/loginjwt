package com.example.loginjwt.config;

import com.example.loginjwt.swagger.LoginRequest;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import java.util.Arrays;
import java.util.Map;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName : com.example.loginjwt.config
 * @FileName : SwaggerConfig
 * @Author : noglass_gongdae
 * @Date : 2024-07-18
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .components(new Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")
                ))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
            .title("JWT API 명세서")
            .description("요청을 보내보며 응답 header, body를 확인할 수 있습니다.")
            .version("1.0.0");
    }

    @Bean
    public OpenApiCustomizer loginEndpointCustomizer() {
        return openApi -> {
            Paths paths = openApi.getPaths();
            if (paths == null) {
                paths = new Paths();
                openApi.setPaths(paths);
            }
            paths.addPathItem("/login", new PathItem()
                .post(new Operation()
                    .summary("User Login")
                    .description("Authenticate user and return JWT token")
                    .addTagsItem("Authentication")
                    .requestBody(new RequestBody()
                        .content(new Content()
                            .addMediaType("application/x-www-form-urlencoded", new MediaType()
                                .schema(new Schema<LoginRequest>()
                                    .type("object")
                                    .addProperty("username", new Schema<>().type("string"))
                                    .addProperty("password", new Schema<>().type("string"))
                                    .required(Arrays.asList("username", "password"))))))
                    .responses(new ApiResponses()
                        .addApiResponse("200", new ApiResponse().description("Successful login"))
                        .addApiResponse("401", new ApiResponse().description("Unauthorized"))
                        .addApiResponse("403", new ApiResponse().description("Forbidden")))));
        };
    }
}