package net.mikelythgoe.apiversioningwithsegment;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    public void configureApiVersioning(ApiVersionConfigurer configurer) {

        configurer
                .addSupportedVersions("1.0", "2.0", "10.0") // Add Supported Versions defines what versions can be supplied
                .setDefaultVersion("2.0")
                // It makes no sense to have a default index value for a segment - the segment should always be there
                // but spring allows it to be set
                .usePathSegment(1); // the index of the url path (0 being the first segment)

    }
}
