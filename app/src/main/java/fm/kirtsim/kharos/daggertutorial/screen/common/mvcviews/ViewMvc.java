package fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews;

import android.os.Bundle;
import android.view.View;

/**
 * Created by kharos on 23/07/2017
 */

public interface ViewMvc {

    View getRootView();

    Bundle getViewState();

    void getViewState(Bundle bundle);
}
