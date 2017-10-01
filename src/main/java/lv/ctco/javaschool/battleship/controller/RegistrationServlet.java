package lv.ctco.javaschool.battleship.controller;

import lv.ctco.javaschool.battleship.model.Game;
import lv.ctco.javaschool.battleship.model.Player;
import lv.ctco.javaschool.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(RegistrationServlet.class.getName());

    @Inject
    private PlayerManager playerManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        Player player = new Player();
        player.setName(username);
        Game game = playerManager.registerPlayer(player);
        logger.log(Level.FINE, "Registered user {0} for {1}", new Object[]{player, game});
        response.sendRedirect("wait-opponent-registration");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
}
