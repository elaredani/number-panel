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
package me.danielgm.vaadin.numberpanel.client;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * @author Daniel Garcia
 *
 */
public class NumberPanelWidget extends Widget {
	
	private DivElement panel = Document.get().createDivElement();
	private Element prefixPanel;
	private Element integerPartPanel;
	private Element fractionalPartPanel;
	private Element suffixPartPanel;
	private String prefixSize;
	private String integerPartSize;
	private String fractionalPartSize;
	private String suffixSize;

    public NumberPanelWidget() {
    	setElement(panel);
        style();
    }
    
    private void style() {
    	setStyleName("number-panel");
    }
    
    public void load(String prefix, String integerPart, String fractionalPart, String suffix) {
    	clearElements();
    	if(prefix != null) {
    		panel.appendChild(prefixPanel = createSpan(prefix, prefixSize, "number-panel-p"));
    	}
    	if(integerPart != null) {
    		panel.appendChild(integerPartPanel = createSpan(integerPart, integerPartSize, "number-panel-i"));
    	}
    	if(fractionalPart != null) {
    		panel.appendChild(fractionalPartPanel = createSpan(fractionalPart, fractionalPartSize, "number-panel-f"));
    	}
    	if(suffix != null) {
    		panel.appendChild(suffixPartPanel = createSpan(suffix, suffixSize, "number-panel-s"));
    	}
    }
    
	public void setPrefixSize(String prefixSize) {
		this.prefixSize = prefixSize;
		resize(prefixPanel, prefixSize);
	}

	public void setIntegerPartSize(String integerPartSize) {
		this.integerPartSize = integerPartSize;
		resize(integerPartPanel, integerPartSize);
	}
	
	public void setFractionalPartSize(String fractionalPartSize) {
		this.fractionalPartSize = fractionalPartSize;
		resize(fractionalPartPanel, fractionalPartSize);
	}
	
	public void setSuffixSize(String suffixSize) {
		this.suffixSize = suffixSize;
		resize(suffixPartPanel, suffixSize);
	}
    
    private void clearElements() {
    	panel.removeAllChildren();
    	prefixPanel = null;
    	integerPartPanel = null;
    	fractionalPartPanel = null;
    	suffixPartPanel = null;
    }
    
    private Element createSpan(String text, String size, String style) {
    	SpanElement span = Document.get().createSpanElement();
    	span.setInnerText(text);
    	span.addClassName(style);
    	resize(span, size);
    	return span;
    }
    
    private void resize(Element element, String size) {
    	if(element != null) {
	    	if(size == null) {
	    		element.getStyle().clearFontSize();
	    	} else {
	    		element.getStyle().setProperty("fontSize", size);
	    	}
    	}
    }

}