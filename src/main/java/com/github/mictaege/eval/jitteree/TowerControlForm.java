package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.Fork;
import com.github.mictaege.jitter.api.OnlyIf;
import com.vaadin.cdi.UIScoped;
import com.vaadin.data.Binder;
import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.event.selection.SelectionListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import java.util.ResourceBundle;

import static com.github.mictaege.eval.jitteree.Flavour.ESA;
import static com.github.mictaege.eval.jitteree.Flavour.NASA;
import static com.github.mictaege.eval.jitteree.Flavour.ROSKOSMOS;
import static com.vaadin.shared.ui.ContentMode.HTML;
import static java.util.ResourceBundle.getBundle;

@UIScoped
public class TowerControlForm implements SelectionListener<Bearer> {

    public static final ResourceBundle RES = getBundle(TowerControlForm.class.getName());

    private VerticalLayout layout;
    private Binder<Bearer> binder;
    private Bearer model;

    @PostConstruct
    @Fork(ifActive = ESA, to = "initEsa")
    @Fork(ifActive = NASA, to = "initDefault")
    @Fork(ifActive = ROSKOSMOS, to = "initDefault")
    public void init() {
        throw new IllegalStateException("Not implemented!");
    }

    @OnlyIf(ESA)
    private void initEsa() {
        layout = new VerticalLayout();

        final Label title = new Label("<b>" + RES.getString("title") + "</b>", HTML);
        layout.addComponent(title);

        binder = new Binder<>();

        final TextField bearerField = new TextField(RES.getString("bearer"));
        bearerField.setReadOnly(true);
        layout.addComponent(bearerField);
        binder.forField(bearerField)
                .bind(Bearer::getName, Bearer::setName);

        final TextField constructionYearField = new TextField(RES.getString("constructionYear"));
        constructionYearField.setReadOnly(true);
        layout.addComponent(constructionYearField);
        binder.forField(constructionYearField)
                .withConverter(Integer::valueOf, String::valueOf)
                .bind(Bearer::getConstructionYear, (bearer, s) -> {});

        final TextField spaceShipField = new TextField(RES.getString("ship"));
        spaceShipField.setReadOnly(true);
        layout.addComponent(spaceShipField);
        binder.forField(spaceShipField)
                .bind(Bearer::getSpaceShip, (bearer, s) -> {});
    }

    @OnlyIf({NASA, ROSKOSMOS})
    private void initDefault() {
        layout = new VerticalLayout();

        final Label title = new Label("<b>" + RES.getString("title") + "</b>", HTML);
        layout.addComponent(title);

        binder = new Binder<>();

        final TextField bearerField = new TextField(RES.getString("bearer"));
        bearerField.setReadOnly(true);
        layout.addComponent(bearerField);
        binder.forField(bearerField)
                .bind(Bearer::getName, Bearer::setName);

        final TextField spaceShipField = new TextField(RES.getString("ship"));
        spaceShipField.setReadOnly(true);
        layout.addComponent(spaceShipField);
        binder.forField(spaceShipField)
                .bind(Bearer::getSpaceShip, (bearer, s) -> {});
    }

    @Override
    public void selectionChange(final SelectionEvent<Bearer> event) {
        this.model = event.getFirstSelectedItem().orElse(null);
        binder.readBean(model);
    }

    public Component getComponent() {
        return layout;
    }

    public Bearer getModel() {
        return model;
    }

}