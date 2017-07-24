package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs;

/**
 * Created by kharos on 23/07/2017
 */

public abstract class BaseDialogEvent {

    private String id;

    public BaseDialogEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
