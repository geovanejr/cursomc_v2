package br.com.geovanejunior.cursomc.service.exceptions;

public class AutorizationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AutorizationException(String msg) {
        super(msg);
    }

    public AutorizationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
