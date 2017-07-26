package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.info;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

import fm.kirtsim.kharos.daggertutorial.R;
import fm.kirtsim.kharos.daggertutorial.screen.common.mvcviews.BaseViewMvc;

/**
 * Created by kharos on 23/07/2017
 */

public class InfoViewMvcImpl extends BaseViewMvc<InfoViewMvc.InfoViewMvcListener>
        implements InfoViewMvc {

    private TextView dialogTitle;
    private TextView dialogMessage;
    private Button confirmButton;

    public InfoViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.layout_info_prompt_dialog, container, false));
        dialogTitle = findViewById(R.id.txt_title);
        dialogMessage = findViewById(R.id.txt_message);
        confirmButton = findViewById(R.id.btn_positive);
        setConfirmButtonClickListener();
        findViewById(R.id.btn_negative).setVisibility(View.GONE);
    }

    private void setConfirmButtonClickListener() {
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Set<InfoViewMvcListener> listeners = getListeners();
                for (InfoViewMvcListener listener : listeners)
                    listener.onDismissClicked();
            }
        });
    }

    @Override
    public void setTitle(String title) {
        dialogTitle.setText(title);
    }

    @Override
    public void setMessage(String message) {
        dialogMessage.setText(message);
    }

    @Override
    public void setDismissButtonCaption(String caption) {
        confirmButton.setText(caption);
    }
}
