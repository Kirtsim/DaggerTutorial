package fm.kirtsim.kharos.daggertutorial.screen.common.dialogs.prompt;

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

public class PromptViewMvcImpl extends BaseViewMvc<PromptViewMvc.PromptViewMvcListener>
        implements PromptViewMvc {

    private TextView dialogTitle;
    private TextView dialogMessage;
    private Button positiveButton;
    private Button negativeButton;

    public PromptViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.layout_info_prompt_dialog, container, false));
        initViews();
        setButtonListeners();

    }

    private void initViews() {
        dialogTitle = findViewById(R.id.txt_title);
        dialogMessage = findViewById(R.id.txt_message);
        positiveButton = findViewById(R.id.btn_positive);
        negativeButton = findViewById(R.id.btn_negative);
    }

    private void setButtonListeners() {
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Set<PromptViewMvcListener> listeners = getListeners();
                for (PromptViewMvcListener listener : listeners) {
                    listener.onPositiveButtonClicked();
                }
            }
        });

        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Set<PromptViewMvcListener> listeners = getListeners();
                for (PromptViewMvcListener listener : listeners) {
                    listener.onNegativeButtonClicked();
                }
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
    public void setNegativeButtonCaption(String caption) {
        negativeButton.setText(caption);
    }

    @Override
    public void setPositiveButtonCaption(String caption) {
        positiveButton.setText(caption);
    }
}
