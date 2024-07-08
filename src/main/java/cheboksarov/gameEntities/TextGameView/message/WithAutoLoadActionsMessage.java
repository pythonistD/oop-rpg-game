package cheboksarov.gameEntities.TextGameView.message;

import cheboksarov.gameEntities.TextGameView.action.Action;

import java.util.List;
import java.util.function.Supplier;

public class WithAutoLoadActionsMessage extends BtnMessage{
    private Supplier<List<Action>> actionsProducer;
    public WithAutoLoadActionsMessage(String title, Supplier<List<Action>> actionsProducer) {
        super(title);
        this.actionsProducer = actionsProducer;
    }

    public WithAutoLoadActionsMessage(String title, List<Action> body, List<Action> nav) {
        super(title, body, nav);
    }

    @Override
    public String getMsg() {
        setBody(actionsProducer.get());
        return super.getMsg();
    }
}
