package fm.kirtsim.kharos.daggertutorial.common.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

import fm.kirtsim.kharos.daggertutorial.MyApplication;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.service.ServiceComponent;
import fm.kirtsim.kharos.daggertutorial.dependencyinjection.service.ServiceModule;

/**
 * Created by kharos on 23/07/2017
 */

public class BaseService extends Service {

    private ServiceComponent serviceComponent;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @UiThread
    protected ServiceComponent getServiceComponent() {
        if (serviceComponent == null) {
            serviceComponent = ((MyApplication) getApplication()).getApplicationComponent()
                                .newServiceComponent(new ServiceModule(this));
        }
        return serviceComponent;
    }
}
