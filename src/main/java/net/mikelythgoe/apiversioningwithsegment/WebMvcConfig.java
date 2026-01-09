package net.mikelythgoe.apiversioningwithsegment;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final String DEFAULT_VERSION = "2.0";
    private static final String[] SUPPORTED_VERSIONS = {"1.0", "2.0", "3.5", "9"};
    private static final int PATH_SEGMENT = 1;

    public void configureApiVersioning(ApiVersionConfigurer configurer) {

        configurer
                .addSupportedVersions(SUPPORTED_VERSIONS) // Add Supported Versions defines what versions can be supplied
                .setDefaultVersion(DEFAULT_VERSION) // The default version does not seem to work for segments, maybe it will
                .usePathSegment(PATH_SEGMENT); // the name of the query parameter that supplies the version

    }
}
