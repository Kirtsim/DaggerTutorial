package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs;

import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.v4.app.DialogFragment;

import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ControllerComponent;

/**
 * Created by kharos on 23/07/2017
 */

public abstract class BaseDialog extends DialogFragment {

    private boolean isControllerComponentUsed = false;

    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (isControllerComponentUsed)
            throw new IllegalStateException("must not use ControllerComponent more than once");
        isControllerComponentUsed = true;
        // TODO: return the component
        return null;
    }

    protected String getDialogId() {
        Bundle arguments = getArguments();
        if (arguments == null)
            return null;
        return arguments.getString(DialogsManager.ARGUMENT_DIALOG_ID);
    }
}
