/*
 * Copyright 2008 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package me.danielgm.vaadin.numberpanel.client;

import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

import me.danielgm.vaadin.numberpanel.NumberPanel;

/**
 * 
 * @author Daniel Garcia
 *
 */
@SuppressWarnings("serial")
@Connect(NumberPanel.class)
public class NumberPanelConnector extends AbstractComponentConnector {

    @Override
    public NumberPanelWidget getWidget() {
        return (NumberPanelWidget) super.getWidget();
    }

    @Override
    public NumberPanelState getState() {
        return (NumberPanelState) super.getState();
    }
    
    // State changes
    
    @OnStateChange({"prefix", "integerPart", "fractionalPart", "suffix"})
    private void updateValue() {
    	getWidget().load(getState().prefix, getState().integerPart, getState().fractionalPart, getState().suffix);
    }
    
    @OnStateChange("prefixSize")
    private void updatePrefixSize() {
    	getWidget().setPrefixSize(getState().prefixSize);
    }
    
    @OnStateChange("integerPartSize")
    private void updateIntegerPartSize() {
    	getWidget().setIntegerPartSize(getState().integerPartSize);
    }
    
    @OnStateChange("fractionalPartSize")
    private void updateFractionalPartSize() {
    	getWidget().setFractionalPartSize(getState().fractionalPartSize);
    }
    
    @OnStateChange("suffixSize")
    private void updateSuffixSize() {
    	getWidget().setSuffixSize(getState().suffixSize);
    }
    
}
