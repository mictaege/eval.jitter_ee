package com.github.mictaege.eval.jitteree;

import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.inject.Inject;
import java.util.ResourceBundle;

import static com.vaadin.icons.VaadinIcons.ROCKET;
import static java.util.ResourceBundle.getBundle;

@CDIUI("")
public class TowerControlApp extends UI {

    public static final ResourceBundle RES = getBundle(TowerControlApp.class.getName());

    @Inject
    private TowerControlList list;
    @Inject
    private TowerControlForm form;
    @Inject
    private BearerImgView img;

    @Override
    protected void init(final VaadinRequest request) {
        final HorizontalSplitPanel pane = new HorizontalSplitPanel();
        list.addSelectionListener(form);
        pane.setFirstComponent(list.getComponent());

        final VerticalLayout details = new VerticalLayout();
        details.addComponent(form.getComponent());

        final Button btn = new Button(RES.getString("launch"), ROCKET);
        btn.addClickListener(e -> img.updateImg(form.getModel()));
        details.addComponent(btn);

        details.addComponent(img.getComponent());

        pane.setSecondComponent(details);
        setContent(pane);
    }

}
