package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.prompt;

import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.BaseDialogEvent;

/**
 * Created by kharos on 23/07/2017
 */

public class PromptDialogDismissedEvent extends BaseDialogEvent {

    public static final int BUTTON_NONE = 0;
    public static final int BUTTON_POSITIVE = 1;
    public static final int BUTTON_NEGATIVE = 2;

    private int buttonClicked;

    public PromptDialogDismissedEvent(String id, int btnClicked) {
        super(id);
        if (btnClicked < BUTTON_NONE || btnClicked > BUTTON_NEGATIVE)
            throw new IllegalArgumentException("illegal button index");
        buttonClicked = btnClicked;
    }

    public int getClickedButtonIndex() {
        return buttonClicked;
    }
}
