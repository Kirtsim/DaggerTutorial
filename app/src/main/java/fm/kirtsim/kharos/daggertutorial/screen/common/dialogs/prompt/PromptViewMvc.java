package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.prompt;

import fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews.ObservableViewMvc;

/**
 * Created by kharos on 23/07/2017
 */

public interface PromptViewMvc extends ObservableViewMvc<PromptViewMvc.PromptViewMvcListener> {

    public interface PromptViewMvcListener {
        void onPositiveButtonClicked();
        void onNegativeButtonClicked();
    }
}
