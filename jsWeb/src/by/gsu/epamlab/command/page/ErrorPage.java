package by.gsu.epamlab.command.page;

import by.gsu.epamlab.exceptions.GeneralException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorPage extends AbstractPage {
    private final GeneralException exception;

    public ErrorPage(GeneralException exception) {
        this.exception = exception;
    }

    @Override
    public void finishRequest(HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
        response.sendError(exception.getErrorCode(), exception.getMessage());
    }
}