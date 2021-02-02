package by.gsu.epamlab.exceptions;

import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

public class ServletMethodeException extends GeneralException {
    private final static int ERROR_CODE = SC_BAD_REQUEST;

    public ServletMethodeException() {
        super(ERROR_CODE);
    }

    public ServletMethodeException(String message) {
        super(message, ERROR_CODE);
    }

    public ServletMethodeException(String message, Throwable cause) {
        super(message, cause, ERROR_CODE);
    }

    public ServletMethodeException(Throwable cause) {
        super(cause, ERROR_CODE);
    }

    public ServletMethodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, ERROR_CODE);
    }

}
