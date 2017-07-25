package fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller;

import dagger.Subcomponent;
import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.info.InfoDialog;
import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.prompt.PromptDialog;
import fm.kirtsim.kharos.daggertutorial.screen.example.activities.ExampleActivity;

/**
 * Created by kharos on 23/07/2017
 */

@Subcomponent(modules = {ControllerModule.class, ViewMvcModule.class})
public interface ControllerComponent {

    public void inject(ExampleActivity exampleActivity);

    public void inject(InfoDialog infoDialog);

    public void inject(PromptDialog promptDialog);
}
