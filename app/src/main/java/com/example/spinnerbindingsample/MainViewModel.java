package com.example.spinnerbindingsample;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class MainViewModel extends BaseObservable {
    private final String[] values;
    private final View.OnClickListener onClickListener;

    private String selectedText;
    private int selectedPosition;

    public MainViewModel(String[] values) {
        this.values = values;
        this.onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedPosition(0);
            }
        };
    }

    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    @Bindable
    public String getSelectedText() {
        return selectedText;
    }

    @Bindable
    public int getSelectedPosition() {
        return selectedPosition;
    }

    public void setSelectedText(String selectedText) {
        this.selectedText = selectedText;
        notifyPropertyChanged(BR.selectedText);
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyPropertyChanged(BR.selectedPosition);
        setSelectedText(this.values[selectedPosition]);
    }
}