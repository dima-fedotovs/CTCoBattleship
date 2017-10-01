package lv.ctco.javaschool.battleship.model;


import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class GameManager {
    private static final Logger logger = Logger.getLogger(GameManager.class.getName());
    private Game incompleteGame;

    public synchronized Game registerPlayer(Player player) {
        Game result;
        if (incompleteGame == null) {
            logger.log(Level.FINER, "No incomplete game found. Creating it for user {0}", player);
            incompleteGame = new Game();
            incompleteGame.setPlayer1(player);
            result = incompleteGame;
        } else {
            logger.log(Level.FINER, "Incomplete game found. Completing it with user {0}", player);
            incompleteGame.setPlayer2(player);
            result = incompleteGame;
            incompleteGame = null;
        }
        logger.log(Level.FINEST, "Game {0}", result);
        return result;
    }
}
