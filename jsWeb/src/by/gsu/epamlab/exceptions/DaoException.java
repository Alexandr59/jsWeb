package by.gsu.epamlab.exceptions;

import java.sql.SQLException;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

public class DaoException extends GeneralException {
    private final static int ERROR_CODE = SC_INTERNAL_SERVER_ERROR;

    public DaoException() {
        super(ERROR_CODE);
    }

    public DaoException(String message) {
        super(message, ERROR_CODE);
    }

    public DaoException(Exception exception) {
        super(exception, ERROR_CODE);
    }

    public DaoException(String ex, SQLException e) {
        super(ex, e, ERROR_CODE);
    }

    public String toString() {
        return getMessage();
    }
}