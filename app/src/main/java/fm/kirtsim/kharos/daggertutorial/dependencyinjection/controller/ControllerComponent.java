package fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller;

import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.info.InfoDialog;
import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.prompt.PromptDialog;

/**
 * Created by kharos on 23/07/2017
 */

public interface ControllerComponent {



    public void inject(InfoDialog infoDialog);

    public void inject(PromptDialog promptDialog);
}
