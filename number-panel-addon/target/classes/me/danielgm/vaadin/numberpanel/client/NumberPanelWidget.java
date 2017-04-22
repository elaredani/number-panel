package me.danielgm.vaadin.numberpanel.client;

import com.google.gwt.user.client.ui.Label;

// Extend any GWT Widget
public class NumberPanelWidget extends Label {

    public NumberPanelWidget() {

        // CSS class-name should not be v- prefixed
        setStyleName("number-panel");

        // State is set to widget in NumberPanelConnector
    }

}