package net.mikelythgoe.apiversioningwithsegment;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void configureApiVersioning(ApiVersionConfigurer configurer) {

        configurer
                .addSupportedVersions("1.0", "2.0", "10.0") // Add Supported Versions defines what versions can be supplied
                .usePathSegment(1) // the name of the query parameter that supplies the version

                .setDefaultVersion("2.0"); // Default version does not seem to work for segments,

    }
}
