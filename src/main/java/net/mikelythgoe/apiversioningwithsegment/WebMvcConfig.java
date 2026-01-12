package net.mikelythgoe.apiversioningwithsegment;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private static final int PATH_SEGMENT = 1;
    private static final String[] SUPPORTED_VERSIONS = {"1.0", "2.0", "3.5", "9"};
    private static final String DEFAULT_VERSION = "2.0";

    public void configureApiVersioning(ApiVersionConfigurer configurer) {

        // Add Supported Versions defines what versions can be supplied.
        // Adding a Default version allows the API to respond with a default version if none is specified.
        // BUT - this does not work for segments.
        // The usePathSegment method specifies the name of the path segment that supplies the version.
        configurer
                .addSupportedVersions(SUPPORTED_VERSIONS)
                .setDefaultVersion(DEFAULT_VERSION)
                .usePathSegment(PATH_SEGMENT); // the name of the query parameter that supplies the
                                               // version

    }
}
