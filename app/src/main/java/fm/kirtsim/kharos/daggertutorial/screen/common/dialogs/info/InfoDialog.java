package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.info;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;

import org.greenrobot.eventbus.EventBus;


import javax.inject.Inject;

import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.BaseDialog;

/**
 * Created by kharos on 23/07/2017
 */

public class InfoDialog extends BaseDialog implements InfoViewMvc.InfoViewMvcListener {

    public static final String ARGUMENT_TITLE = "arg_title";
    public static final String ARGUMENT_MESSAGE = "arg_message";
    public static final String ARGUMENT_BTN_CAPTION = "arg_btn_caption";

    @Inject
    EventBus eventBus;
    private InfoViewMvc infoView;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        getControllerComponent().inject(this);
        setCancelable(true);

        initViewMvc();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        dialogBuilder.setView(infoView.getRootView());
        return dialogBuilder.create();
    }

    private void initViewMvc() {
        infoView = new InfoViewMvcImpl(LayoutInflater.from(getActivity()), null);
        infoView.registerListener(this);

        final Bundle arguments = getArguments();
        if (arguments != null) {
            infoView.setTitle(arguments.getString(ARGUMENT_TITLE));
            infoView.setMessage(arguments.getString(ARGUMENT_MESSAGE));
            infoView.setDismissButtonCaption(arguments.getString(ARGUMENT_BTN_CAPTION));
        }
    }

    @Override
    public void onDismissClicked() {
        this.dismiss();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        eventBus.post(new InfoDialogDismissedEvent(getDialogId()));
    }
}
