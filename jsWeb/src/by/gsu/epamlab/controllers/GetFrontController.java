package by.gsu.epamlab.controllers;

import by.gsu.epamlab.exceptions.ServletMethodeException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

@WebServlet(MAIN_URL)
public class GetFrontController extends FrontController {
    @Override
    public void init(ServletConfig sc) throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processedRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processError(request, response, new ServletMethodeException(ERR_POST + request.getRequestURI()));
    }
}