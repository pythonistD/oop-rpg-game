package cheboksarov.gameEntities.TextGameView.message;

import cheboksarov.gameEntities.TextGameView.Directions;
import cheboksarov.gameEntities.TextGameView.action.Action;
import cheboksarov.gameEntities.TextGameView.action.ActionWithContext;

public class TextFieldMessage extends Message {

    public TextFieldMessage(String title, ActionWithContext action) {
        super(title, action);
    }

    @Override
    public String getMsg() {
        return formatMsg(getTitle(), null, null);
    }

    @Override
    public void selectAction(String id) {

    }

    @Override
    public Directions applyAction(String input) {
        if(getAction()==null){
            throw new NullPointerException("Action is null");
        }
        return getAction().doAction(input);
    }
}
