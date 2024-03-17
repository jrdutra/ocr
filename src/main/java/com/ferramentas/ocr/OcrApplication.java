package com.ferramentas.ocr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import net.sourceforge.tess4j.util.LoadLibs;

@SpringBootApplication
public class OcrApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OcrApplication.class, args);
	}
	
	@Component
    public static class TessInitializer {

        @Autowired
        private ResourceLoader resourceLoader;

    }

}
