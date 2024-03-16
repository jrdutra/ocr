package com.ferramentas.ocr.model.dto;

import java.io.Serializable;

public class ResultadoOcrDto implements Serializable {
	
	private static final long serialVersionUID = 701612169568539165L;

	private Boolean sucesso;
	
	private String texto;

	public Boolean getSucesso() {
		return sucesso;
	}

	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	

}
