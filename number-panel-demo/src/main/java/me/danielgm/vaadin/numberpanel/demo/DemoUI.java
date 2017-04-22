package me.danielgm.vaadin.numberpanel.demo;

import me.danielgm.vaadin.numberpanel.NumberPanel;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@Title("NumberPanel Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        // Initialize our new UI component
        final NumberPanel number = new NumberPanel();
        number.setValue(1542.872);
        number.setIntegerPartSize("50px");
        number.setFractionalPartSize("30px");
        number.setSuffixSize("30px");
        number.setSuffix("$");
    

        // Show it in the middle of the screen
        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("demoContentLayout");
        layout.setSizeFull();
        layout.setMargin(false);
        layout.setSpacing(false);
        layout.addComponent(number);
        layout.setComponentAlignment(number, Alignment.MIDDLE_CENTER);
        setContent(layout);
    }
}
