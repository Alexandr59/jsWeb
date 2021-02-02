package by.gsu.epamlab.command.page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonPage extends AbstractPage{
    private final String json;

    public JsonPage(String json) {
        this.json = json;
    }

    @Override
    public void finishRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(json);
    }
}
