package lv.ctco.javaschool.battleship.controller;

import lv.ctco.javaschool.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
@WebServlet(name = "WaitOpponentRegistrationServlet", urlPatterns = "/wait-opponent-registration")
public class WaitOpponentRegistrationServlet extends HttpServlet {
    @Inject
    private PlayerManager playerManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (playerManager.getGame().isComplete()) {
            response.sendRedirect("placement.jsp");
        } else {
            request.getRequestDispatcher("/WEB-INF/wait-opponent-registration.jsp").include(request, response);
        }
    }
}
