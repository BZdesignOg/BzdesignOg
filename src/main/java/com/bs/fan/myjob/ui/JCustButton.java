package com.bs.fan.myjob.ui;

import javax.swing.*;

public class JCustButton extends JButton {
    private boolean isListening=false;

    public boolean isListening() {
        return isListening;
    }

    public void setListening(boolean listening) {
        isListening = listening;
    }

    public JCustButton(String title){
        super(title);
    }
}
