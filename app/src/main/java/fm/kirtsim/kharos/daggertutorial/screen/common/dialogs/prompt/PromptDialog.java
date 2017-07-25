package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.prompt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.BaseDialog;

/**
 * Created by kharos on 23/07/2017
 */

public class PromptDialog extends BaseDialog implements PromptViewMvc.PromptViewMvcListener {

    public static final String ARGUMENT_TITLE = "arg_title";
    public static final String ARGUMENT_MESSAGE = "arg_message";
    public static final String ARGUMENT_POSITIVE_BTN_CAPTION = "arg_pos_btn_caption";
    public static final String ARGUMENT_NEGATIVE_BTN_CAPTION = "arg_neg_btn_caption";

    @Inject EventBus eventBus;
    private PromptViewMvc promptView;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        getControllerComponent().inject(this);

        initViewMvc();
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        dialogBuilder.setView(promptView.getRootView());
        return dialogBuilder.create();
    }

    private void initViewMvc() {
        promptView = new PromptViewMvcImpl(getActivity().getLayoutInflater(), null);
        Bundle arguments = getArguments();
        if (arguments != null) {
            promptView.setTitle(arguments.getString(ARGUMENT_TITLE));
            promptView.setMessage(arguments.getString(ARGUMENT_MESSAGE));
            promptView.setPositiveButtonCaption(arguments.getString(ARGUMENT_POSITIVE_BTN_CAPTION));
            promptView.setNegativeButtonCaption(arguments.getString(ARGUMENT_NEGATIVE_BTN_CAPTION));
        }
        promptView.registerListener(this);
    }

    @Override
    public void onPositiveButtonClicked() {
        dismiss();
        eventBus.post(new PromptDialogDismissedEvent(getDialogId(),
                PromptDialogDismissedEvent.BUTTON_POSITIVE));
    }

    @Override
    public void onNegativeButtonClicked() {
        dismiss();
        eventBus.post(new PromptDialogDismissedEvent(getDialogId(),
                PromptDialogDismissedEvent.BUTTON_NEGATIVE));
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        dismiss();
        eventBus.post(new PromptDialogDismissedEvent(getDialogId(),
                PromptDialogDismissedEvent.BUTTON_NONE));
    }
}
