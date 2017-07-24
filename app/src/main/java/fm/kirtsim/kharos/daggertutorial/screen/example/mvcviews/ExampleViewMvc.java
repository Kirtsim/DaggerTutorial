package fm.kirtsim.kharos.daggertutorial.screen.example.mvcviews;

import fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews.ObservableViewMvc;

/**
 * Created by kharos on 23/07/2017
 */

public interface ExampleViewMvc extends ObservableViewMvc<ExampleViewMvc.ExampleViewMvcListener> {

    public interface ExampleViewMvcListener {
        void onShowDialogClicked();
    }
}
