package by.gsu.epamlab.exceptions;

public abstract class GeneralException extends Exception {
    private final int ERROR_CODE;

    public GeneralException(int errorCode) {
        this.ERROR_CODE = errorCode;
    }

    public GeneralException(String message, int errorCode) {
        super(message);
        this.ERROR_CODE = errorCode;
    }

    public GeneralException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.ERROR_CODE = errorCode;
    }

    public GeneralException(Throwable cause, int errorCode) {
        super(cause);
        this.ERROR_CODE = errorCode;
    }

    public GeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.ERROR_CODE = errorCode;
    }

    public int getErrorCode() {
        return ERROR_CODE;
    }
}
