package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.prompt;

import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.BaseDialog;

/**
 * Created by kharos on 23/07/2017
 */

public class PromptDialog extends BaseDialog implements PromptViewMvc.PromptViewMvcListener {

    public static final String ARGUMENT_TITLE = "arg_title";
    public static final String ARGUMENT_MESSAGE = "arg_message";
    public static final String ARGUMENT_POSITIVE_BTN_CAPTION = "arg_pos_btn_caption";
    public static final String ARGUMENT_NEGATIVE_BTN_CAPTION = "arg_neg_btn_caption";

    @Override
    public void onPositiveButtonClicked() {

    }

    @Override
    public void onNegativeButtonClicked() {

    }
}
