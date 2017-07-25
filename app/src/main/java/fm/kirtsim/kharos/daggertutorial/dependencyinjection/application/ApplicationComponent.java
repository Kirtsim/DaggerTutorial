package fm.kirtsim.kharos.daggertutorial.dependencyinjection.application;

import dagger.Component;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ControllerComponent;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ControllerModule;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.controller.ViewMvcModule;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.service.ServiceComponent;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.service.ServiceModule;

/**
 * Created by kharos on 23/07/2017
 */

@ApplicationScope
@Component(modules = {ApplicationModule.class, SettingsModule.class})
public interface ApplicationComponent {

    ControllerComponent newControllerComponent(ControllerModule controllerModule,
                                               ViewMvcModule viewMvcModule);

    ServiceComponent newServiceComponent(ServiceModule serviceModule);
}
