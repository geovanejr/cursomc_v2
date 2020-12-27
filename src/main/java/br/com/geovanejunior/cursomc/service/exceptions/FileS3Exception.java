package br.com.geovanejunior.cursomc.service.exceptions;

public class FileS3Exception extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FileS3Exception(String msg) {
        super(msg);
    }

    public FileS3Exception(String msg, Throwable cause) {
        super(msg, cause);
    }
}
