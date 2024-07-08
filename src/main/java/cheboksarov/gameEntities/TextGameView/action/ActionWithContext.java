package cheboksarov.gameEntities.TextGameView.action;

import cheboksarov.gameEntities.TextGameView.Directions;
import cheboksarov.gameEntities.TextGameView.ViewModel;
import cheboksarov.gameEntities.dto.Bundle;

import java.util.function.Consumer;

public class ActionWithContext extends Action {
    private Consumer<Bundle<String, ViewModel>> func;
    private ViewModel context;

    public ActionWithContext(Directions direction, Consumer<Bundle<String, ViewModel>> func, ViewModel context) {
        super(direction);
        this.func = func;
        this.context = context;
    }
    public ActionWithContext(String id, String title,Directions direction, Consumer<Bundle<String, ViewModel>> func, ViewModel context) {
        super(id, title, direction);
        this.func = func;
        this.context = context;
    }

    @Override
    public Directions doAction(String input) {
        Bundle<String, ViewModel> bundle = new Bundle<>(input, context);
        func.accept(bundle);
        return getDirection();
    }
}
