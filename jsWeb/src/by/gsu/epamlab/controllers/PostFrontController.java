package by.gsu.epamlab.controllers;

import by.gsu.epamlab.exceptions.InitException;
import by.gsu.epamlab.exceptions.ServletMethodeException;
import by.gsu.epamlab.model.factories.UserFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

import static by.gsu.epamlab.controllers.ConstantsJsp.*;

@WebServlet(urlPatterns = {LOGIN_URL, REGISTRATION_URL, LOGOUT_URL, OPERATIONS_URL, ADD_URL},
        initParams = {
                @WebInitParam(name = KEY_PROPS_NAME, value = PROPERTIES_VALUE_RESOURCES_CONFS)
        })
public class PostFrontController extends FrontController {
    @Override
    public void init(ServletConfig sc) throws ServletException {
        super.init(sc);
        try {
            String propsName = sc.getInitParameter(ConstantsJsp.KEY_PROPS_NAME);
            ResourceBundle rb = ResourceBundle.getBundle(propsName);
            UserFactory.init(rb);
        } catch (InitException e) {
            writeToLog(this.getClass(), e);
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processError(request, response, new ServletMethodeException(ERR_GET + request.getRequestURI()));
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processedRequest(request, response);
    }
}