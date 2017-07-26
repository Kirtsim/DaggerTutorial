package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.DialogFragment;

import fm.kirtsim.kharos.daggertutorial.MyApplication;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ControllerComponent;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ControllerModule;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ViewMvcModule;
import fm.kirtsim.kharos.daggertutorial.screen.common.activities.BaseActivity;

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
        return ((MyApplication)getActivity().getApplication()).getApplicationComponent().
                newControllerComponent(new ControllerModule(getActivity()), new ViewMvcModule());
    }

    @Nullable
    protected String getDialogId() {
        Bundle arguments = getArguments();
        if (arguments == null)
            return null;
        return arguments.getString(DialogsManager.ARGUMENT_DIALOG_ID);
    }
}
