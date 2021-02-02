package by.gsu.epamlab.command.page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.gsu.epamlab.controllers.ConstantsJsp.PAGE_INDEX_HTML;

public abstract class AbstractPage {
    private final String path;

    public AbstractPage() {
        this.path = PAGE_INDEX_HTML;
    }

    public AbstractPage(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public abstract void finishRequest(HttpServletRequest request,
                                       HttpServletResponse response) throws ServletException, IOException;
}