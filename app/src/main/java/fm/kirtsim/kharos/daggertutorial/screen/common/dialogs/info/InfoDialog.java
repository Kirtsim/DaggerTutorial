package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.info;

import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.BaseDialog;

/**
 * Created by kharos on 23/07/2017
 */

public class InfoDialog extends BaseDialog implements InfoViewMvc.InfoViewMvcListener {

    public static final String ARGUMENT_TITLE = "arg_title";
    public static final String ARGUMENT_MESSAGE = "arg_message";
    public static final String ARGUMENT_BTN_CAPTION = "arg_btn_caption";

    @Override
    public void onDismissClicked() {

    }
}
