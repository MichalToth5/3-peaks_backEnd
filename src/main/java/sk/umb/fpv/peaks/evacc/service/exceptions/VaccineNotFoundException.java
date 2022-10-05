package sk.umb.fpv.peaks.evacc.service.exceptions;

public class VaccineNotFoundException extends RuntimeException{

    public VaccineNotFoundException(String message) {
        super(message);
    }

    public VaccineNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VaccineNotFoundException(Throwable cause) {
        super(cause);
    }

    protected VaccineNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
