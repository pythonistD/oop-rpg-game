package cheboksarov.gameEntities.TextGameView.message;

import cheboksarov.gameEntities.TextGameView.Directions;
import cheboksarov.gameEntities.TextGameView.action.Action;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BtnMessage extends Message{
    private List<Action> body;
    private List<Action> nav;


    public BtnMessage(String title) {
        super(title);
    }
    public BtnMessage(String title, List<Action> body, List<Action> nav)  {
        super(title);
        this.body = body;
        this.nav = nav;
    }

    @Override
    public String getMsg() {
        String bodyMsg = null;
        String navMsg = null;
        if(body != null){
            bodyMsg = body.stream()
                    .map(Action::toString)
                    .collect(Collectors.joining("\n"));
        }
        if(nav != null){
            navMsg = nav.stream()
                    .map(Action::toString)
                    .collect(Collectors.joining("\n"));
        }
        return formatMsg(getTitle(), bodyMsg, navMsg);

        //return getTitle()+"\n"+DELIMITER+"\n"+bodyMsg+DELIMITER+"\n"+navMsg;
    }

    @Override
    public void selectAction(String id) {
        Action action = findActionOrReturnNull(id, body);
        if(action==null){
            action = findActionOrReturnNull(id, nav);
        }
        if(action==null){
            throw new RuntimeException("No action with such id");
        }
        setAction(action);
    }

    private Action findActionOrReturnNull(String id, List<Action> actions){
        if(actions==null){
            return null;
        }
        Optional<Action> action = actions.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
        return action.orElse(null);
    }

    @Override
    public Directions applyAction(String input) {
        Action action = getAction();
        if(action==null){
            throw new RuntimeException("No action with such id");
        }
        return action.doAction(input);
    }

    public List<Action> getBody() {
        return body;
    }

    public void setBody(List<Action> body) {
        this.body = body;
    }

    public List<Action> getNav() {
        return nav;
    }

    public void setNav(List<Action> nav) {
        this.nav = nav;
    }
}
