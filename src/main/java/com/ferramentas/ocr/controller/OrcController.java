package com.ferramentas.ocr.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ferramentas.ocr.model.dto.ImagemBase64Dto;
import com.ferramentas.ocr.model.dto.ResultadoOcrDto;
import com.ferramentas.ocr.service.OcrService;

@RestController
public class OrcController {
	
	@Autowired
	private OcrService ocrService;
	
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
    	HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        String responseBody = "{\"status\":\"ok\"}";

        return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
    }
    
    @PostMapping("/executar-ocr")
    public ResponseEntity<ResultadoOcrDto> executarOcr(@RequestBody ImagemBase64Dto imagemDto) {
    	ResultadoOcrDto resultadoOcrDto = ocrService.executarOcr(imagemDto);
    	
    	HttpHeaders headers = new HttpHeaders();
    	
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        return new ResponseEntity<>(resultadoOcrDto, headers, HttpStatus.OK);
    }

}
