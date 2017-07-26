package fm.kirtsim.kharos.daggertutorial.screen.example.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import javax.inject.Inject;

import fm.kirtsim.kharos.daggertutorial.R;
import fm.kirtsim.kharos.daggertutorial.screen.common.activities.BaseActivity;
import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.DialogsFactory;
import fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.DialogsManager;
import fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews.ViewMvcFactory;
import fm.kirtsim.kharos.daggertutorial.screen.example.mvcviews.ExampleViewMvc;
import fm.kirtsim.kharos.daggertutorial.screen.example.mvcviews.ExampleViewMvcImpl;

/**
 * Created by kharos on 25/07/2017
 */

public class ExampleActivity extends BaseActivity implements ExampleViewMvc.ExampleViewMvcListener {

    @Inject DialogsManager dialogsManager;
    @Inject DialogsFactory dialogsFactory;
    @Inject ViewMvcFactory viewMvcFactory;

    private ExampleViewMvc viewMvc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getControllerComponent().inject(this);
        super.onCreate(savedInstanceState);

        viewMvc = new ExampleViewMvcImpl(getLayoutInflater(), null);
        viewMvc.registerListener(this);
        setContentView(viewMvc.getRootView());
    }


    @Override
    public void onShowDialogClicked() {
        DialogFragment dialog = dialogsFactory.newInfoDialog(
                getString(R.string.dialog_title_xml),
                getString(R.string.dialog_message),
                getString(R.string.dialog_button_caption)
        );
        dialogsManager.showRetainedDialogWithId(dialog, null);
    }
}
