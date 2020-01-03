package com.bs.fan.myjob.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class AbstractFrameController implements ApplicationContextAware {

    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }

    public abstract void prepareAndOpenFrame();
    protected void registerButtonAction(JButton button, ActionListener listener){
        button.addActionListener(listener);
    }
    protected void registerMenuItemAction(JMenuItem menuItem,ActionListener listener){
        menuItem.addActionListener(listener);
    }
}
