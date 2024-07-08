package cheboksarov.gameEntities.TextGameView.message;

import cheboksarov.gameEntities.TextGameView.Directions;
import cheboksarov.gameEntities.TextGameView.action.Action;

public abstract class Message {
    private String title;
    private Action action;
    protected final static String DELIMITER = "_".repeat(30);

    public Message(String title, Action action){
        this.title = title;
        this.action = action;
    }
    public Message(String title){
        this.title = title;
    }

    public abstract String getMsg();
    public abstract void selectAction(String id);
    public abstract Directions applyAction(String input);

    public String formatMsg(String titleMsg, String bodyMsg, String navMsg){
        String msg="";
        if(bodyMsg!=null && navMsg!=null){
            msg = titleMsg + "\n" + DELIMITER + "\n"+ bodyMsg+ "\n" + DELIMITER+ "\n" + navMsg+ "\n";
        } else if (navMsg==null && bodyMsg!=null) {
            msg = titleMsg+ "\n" + DELIMITER + "\n"+ bodyMsg+ "\n";
        } else if (bodyMsg==null  && navMsg!=null) {
            msg = titleMsg+ "\n" + DELIMITER+ "\n" + navMsg+ "\n";
        } else if (bodyMsg==null   && navMsg==null) {
            msg = titleMsg+ "\n" + DELIMITER+ "\n";
        }
        return msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
