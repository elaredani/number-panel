/*
 * Copyright 2017 Daniel Garcia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.danielgm.vaadin.numberpanel;

import java.text.DecimalFormat;

import me.danielgm.vaadin.numberpanel.client.NumberPanelState;

/**
 * 
 * @author Daniel Garcia
 *
 */
@SuppressWarnings("serial")
public class NumberPanel extends com.vaadin.ui.AbstractComponent {
	
	private DecimalFormat format = new DecimalFormat("#,##0.##");
	private String prefix;
	private String suffix;
	private Number value;

    public NumberPanel() {

    }
    
    public void setValue(Number value) {
    	this.value = value;
    	renderValue(value);
    }
    
    /**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
		if(value != null) renderValue(value);
	}
	
	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
		if(value != null) renderValue(value);
	}
    
    public void setFormat(DecimalFormat format) {
    	if(format == null) throw new NullPointerException("Setting a null format is not allowed");
    	this.format = format;
    	if(value != null) renderValue(value);
    }
    
    private void renderValue(Number value) {
    	if(value == null) {
    		getState().prefix = null;
    		getState().integerPart = null;
    		getState().fractionalPart = null;
    		getState().suffix = null;
    	} else {
    		String formattedValue = format.format(value);
    		getState().prefix = prefix;
    		getState().suffix = suffix;
    		char decimalSeparator = format.getDecimalFormatSymbols().getDecimalSeparator();
    		int index = formattedValue.indexOf(decimalSeparator);
    		if(index == -1) {
    			getState().integerPart = formattedValue;
    			getState().fractionalPart = null;
    		} else {
    			getState().integerPart = formattedValue.substring(0, index);
    			getState().fractionalPart = formattedValue.substring(index);
    		}
    	}
    }

    @Override
    protected NumberPanelState getState() {
        return (NumberPanelState) super.getState();
    }
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Sizes
	
  	public void setPreffixSize(String size) {
  		getState().prefixSize = size;
  	}
  	
  	public void setSuffixSize(String size) {
  		getState().suffixSize = size;
  	}
  	
  	public void setIntegerPartSize(String size) {
  		getState().integerPartSize = size;
  	}
  	
  	public void setFractionalPartSize(String size) {
  		getState().fractionalPartSize = size;
  	}
    
}
