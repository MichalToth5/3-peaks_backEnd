package sk.umb.fpv.peaks.evacc.service.exceptions;

public class PatientAlreadyExists extends RuntimeException{

    public PatientAlreadyExists(String message) {
        super(message);
    }

    public PatientAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected PatientAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
