package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.info;

import fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews.ObservableViewMvc;

/**
 * Created by kharos on 23/07/2017
 */

public interface InfoViewMvc extends ObservableViewMvc<InfoViewMvc.InfoViewMvcListener>{

    public interface InfoViewMvcListener {
        void onDismissClicked();
    }
}
