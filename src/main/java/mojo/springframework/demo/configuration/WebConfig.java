package mojo.springframework.demo.configuration;

import mojo.springframework.demo.converters.StringToIndexCommandConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author john
 * @since 15/02/2024
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIndexCommandConverter());
    }
}
