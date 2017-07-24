package fm.kirtsim.kharos.daggertutorial.screen.example.mvcviews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Set;

import fm.kirtsim.kharos.daggertutorial.R;
import fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews.BaseViewMvc;

/**
 * Created by kharos on 23/07/2017
 */

public class ExampleViewMvcImpl extends BaseViewMvc<ExampleViewMvc.ExampleViewMvcListener>
        implements ExampleViewMvc {

    private final Button buttonShowDialog;

    public ExampleViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.layout_example, container, false));
        buttonShowDialog = findViewById(R.id.show_dialog_btn);
        setShowDialogBtnListener();
    }

    private void setShowDialogBtnListener() {
        buttonShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Set<ExampleViewMvcListener> listeners = getListeners();
                for (ExampleViewMvcListener listener : listeners) {
                    listener.onShowDialogClicked();
                }
            }
        });
    }
}
