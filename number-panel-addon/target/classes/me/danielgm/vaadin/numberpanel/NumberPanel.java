package me.danielgm.vaadin.numberpanel;

import me.danielgm.vaadin.numberpanel.client.NumberPanelClientRpc;
import me.danielgm.vaadin.numberpanel.client.NumberPanelServerRpc;
import me.danielgm.vaadin.numberpanel.client.NumberPanelState;

import com.vaadin.shared.MouseEventDetails;

// This is the server-side UI component that provides public API 
// for NumberPanel
public class NumberPanel extends com.vaadin.ui.AbstractComponent {

    private int clickCount = 0;

    public NumberPanel() {

        // To receive events from the client, we register ServerRpc
        NumberPanelServerRpc rpc = this::handleClick;
        registerRpc(rpc);
    }

    // We must override getState() to cast the state to NumberPanelState
    @Override
    protected NumberPanelState getState() {
        return (NumberPanelState) super.getState();
    }
    
    private void handleClick(MouseEventDetails mouseDetails){
        // Send nag message every 5:th click with ClientRpc
        if (++clickCount % 5 == 0) {
            getRpcProxy(NumberPanelClientRpc.class)
                    .alert("Ok, that's enough!");
        }
        
        // Update shared state. This state update is automatically 
        // sent to the client. 
        getState().text = "You have clicked " + clickCount + " times";
    }
}
