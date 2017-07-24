package fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews;

/**
 * Created by kharos on 23/07/2017
 */

public interface ObservableViewMvc<ListenerType> extends ViewMvc {

    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);
}
