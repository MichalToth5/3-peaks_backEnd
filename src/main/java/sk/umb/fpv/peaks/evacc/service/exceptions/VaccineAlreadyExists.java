package sk.umb.fpv.peaks.evacc.service.exceptions;

public class VaccineAlreadyExists extends RuntimeException{

    public VaccineAlreadyExists(String message) {
        super(message);
    }

    public VaccineAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public VaccineAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected VaccineAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
