package com.ferramentas.ocr.model.dto;

import java.io.Serializable;

import com.ferramentas.ocr.enums.FormatoImagem;

public class ImagemBase64Dto implements Serializable {
	
	private static final long serialVersionUID = 7564791019872823104L;
	
	private FormatoImagem formatoImagem;
	
	private String imagemBase64;

	public String getImagemBase64() {
		return imagemBase64;
	}

	public void setImagemBase64(String imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}

	public FormatoImagem getFormatoImagem() {
		return formatoImagem;
	}

	public void setFormatoImagem(FormatoImagem formatoImagem) {
		this.formatoImagem = formatoImagem;
	}

}
