package cheboksarov.gameEntities.TextGameView.action;

import cheboksarov.gameEntities.TextGameView.Directions;

public class ButtonActions extends Action {

    public ButtonActions(String id, String text, Directions direction) {
        super(id, text, direction);
    }


    @Override
    public Directions doAction(String input) {
        return getDirection();
    }
}
