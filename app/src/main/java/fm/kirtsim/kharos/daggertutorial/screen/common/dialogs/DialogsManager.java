package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by kharos on 23/07/2017
 */

public class DialogsManager {

    public static final String ARGUMENT_DIALOG_ID = "dialog_id";

    private static final String DIALOG_FRAGMENT_TAG = "dialog_fragment_tag";

    private FragmentManager fragmentManager;
    private DialogFragment currentlyShownDialog;

    public DialogsManager(FragmentManager fragManager) {
        fragmentManager = fragManager;
        Fragment lastShownFragment = fragmentManager.findFragmentByTag(DIALOG_FRAGMENT_TAG);

        if (lastShownFragment != null
                && DialogFragment.class.isAssignableFrom(lastShownFragment.getClass())) {
            currentlyShownDialog = (DialogFragment) lastShownFragment;
        }
    }

    @Nullable
    public DialogFragment getCurrentlyShownDialog() {
        return currentlyShownDialog;
    }

    @Nullable
    public String getCurrentlyShownDialogId() {
        if (currentlyShownDialog != null) {
            final Bundle arguments = currentlyShownDialog.getArguments();
            if (arguments != null)
                return arguments.getString(ARGUMENT_DIALOG_ID);
        }
        return null;
    }

    public boolean isDialogCurrentlyShown(String id) {
        if (currentlyShownDialog != null) {
            final String currentId = getCurrentlyShownDialogId();
            return currentId != null && currentId.equals(id);
        }
        return false;
    }

    public void dismissCurrentlyShownDialog() {
        if (currentlyShownDialog != null) {
            currentlyShownDialog.dismissAllowingStateLoss();
            currentlyShownDialog = null;
        }
    }

    public void showRetainedDialogWithId(DialogFragment dialog, String id) {
        dismissCurrentlyShownDialog();
        dialog.setRetainInstance(true);
        setId(dialog, id);
        showDialog(dialog);
    }

    private void setId(DialogFragment dialog, String id) {
        final Bundle args = dialog.getArguments();
        Bundle arguments = args == null ? new Bundle(1) : args;
        arguments.putString(ARGUMENT_DIALOG_ID, id);
    }

    private void showDialog(DialogFragment dialog) {
        dialog.show(fragmentManager, DIALOG_FRAGMENT_TAG);
        currentlyShownDialog = dialog;
    }
}
