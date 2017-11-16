package com.github.mictaege.eval.jitteree;

import com.vaadin.cdi.UIScoped;
import com.vaadin.server.ClassResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;

import javax.annotation.PostConstruct;

@UIScoped
public class BearerImgView {

    private Panel panel;

    @PostConstruct
    public void init() {
        panel = new Panel();
        panel.setContent(null);
        panel.setSizeUndefined();
    }

    public void updateImg(final Bearer bearer) {
        if (bearer == null) {
            final Image img = new Image("", new ClassResource("Default.png"));
            img.setWidth("100%");
            img.setHeight("100%");
            panel.setContent(img);
        } else {
            final Image img = new Image("", new ClassResource(bearer.getImg()));
            img.setWidth("100%");
            img.setHeight("100%");
            panel.setContent(img);
        }
        panel.setWidth("100%");
        panel.setHeight("100%");
    }

    public Component getComponent() {
        return panel;
    }
}
