package com.ferramentas.ocr.enums;

public enum FormatoImagem {
	BMP(".bmp"),
    GIF(".gif"),
    JPEG(".jpg"),
    JPG(".jpg"),
    PNG(".png"),
    TIFF(".tiff");

    private final String extensao;

    FormatoImagem(String extensao) {
        this.extensao = extensao;
    }

    public String getExtensao() {
        return extensao;
    }
}
