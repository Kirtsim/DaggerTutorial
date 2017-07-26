package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs;

import android.os.Bundle;

import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.info.InfoDialog;
import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.prompt.PromptDialog;

/**
 * Created by kharos on 23/07/2017
 */

public class DialogsFactory {

    public InfoDialog newInfoDialog(String title, String message, String buttonCaption) {
        Bundle args = new Bundle(3);
        args.putString(InfoDialog.ARGUMENT_TITLE, title);
        args.putString(InfoDialog.ARGUMENT_MESSAGE, message);
        args.putString(InfoDialog.ARGUMENT_BTN_CAPTION, buttonCaption);

        InfoDialog dialog = new InfoDialog();
        dialog.setArguments(args);
        return dialog;
    }

    public PromptDialog newPromptDialog(String title, String message,
                                        String positiveButtonCaption,
                                        String negativeButtonCaption) {
        Bundle args = new Bundle(4);
        args.putString(PromptDialog.ARGUMENT_TITLE, title);
        args.putString(PromptDialog.ARGUMENT_MESSAGE, message);
        args.putString(PromptDialog.ARGUMENT_POSITIVE_BTN_CAPTION, positiveButtonCaption);
        args.putString(PromptDialog.ARGUMENT_NEGATIVE_BTN_CAPTION, negativeButtonCaption);

        PromptDialog dialog = new PromptDialog();
        dialog.setArguments(args);
        return dialog;
    }
}
