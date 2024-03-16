package com.ferramentas.ocr.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ferramentas.ocr.model.contantes.Arquivo;
import com.ferramentas.ocr.model.contantes.ParametrosTesseract;
import com.ferramentas.ocr.model.dto.ImagemBase64Dto;
import com.ferramentas.ocr.model.dto.ResultadoOcrDto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Base64;
import java.io.FileOutputStream;

import java.io.File;
import java.io.IOException;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Service
public class OcrService {
	
	private static final Logger log = LogManager.getLogger(OcrService.class);
	
	@Value("${tesseract.data.path}")
    private String tesseractDataPath;
	
	@Value("${ocr.log.error.processocr}")
	private String logErroOcr;
	
	@Value("${ocr.log.error.processimg}")
	private String logErroImg;
	
	public ResultadoOcrDto executarOcr(ImagemBase64Dto imagemDto) {        
		log.info("Iniciando função de OCR...");
		
		ResultadoOcrDto resultadoOcrDto = new ResultadoOcrDto();
		
		String base64Image = imagemDto.getImagemBase64();	
		byte[] imageBytes = Base64.getDecoder().decode(base64Image);
        
		Tesseract tess4j = new Tesseract();
        
		tess4j.setDatapath(tesseractDataPath);
		tess4j.setLanguage(ParametrosTesseract.IDIOMA);
		
		File file = null;
		
        try {
        	file = File.createTempFile(Arquivo.NOME_IMAGEM_TEMP, imagemDto.getFormatoImagem().getExtensao());
        	
            FileOutputStream fos = new FileOutputStream(file);
            
            fos.write(imageBytes);
            fos.close();
            
            resultadoOcrDto.setSucesso(Boolean.TRUE);
            resultadoOcrDto.setTexto(tess4j.doOCR(file));
            
            return resultadoOcrDto;
        } catch (TesseractException e) {
        	log.error(logErroOcr);
        	log.error(e.getMessage());
        	
        	resultadoOcrDto.setSucesso(Boolean.FALSE);
            resultadoOcrDto.setTexto(logErroOcr);
            
        	return resultadoOcrDto;
        }catch (IOException e) {
        	log.error(logErroImg);
        	log.error(e.getMessage());
        	
        	resultadoOcrDto.setSucesso(Boolean.FALSE);
            resultadoOcrDto.setTexto(logErroImg);
            
        	return resultadoOcrDto;
        }
    }
}
