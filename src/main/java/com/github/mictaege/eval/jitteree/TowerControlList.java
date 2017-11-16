package com.github.mictaege.eval.jitteree;

import com.vaadin.cdi.UIScoped;
import com.vaadin.event.selection.SelectionListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

@UIScoped
public class TowerControlList {

    public static final ResourceBundle RES = getBundle(TowerControlList.class.getName());

    @Inject
    private DaoIF dao;

    private Grid<Bearer> grid;

    @PostConstruct
    public void init() {
        grid = new Grid<>();
        grid.setItems(dao.findBearers());
        grid.addColumn(Bearer::getName).setCaption(RES.getString("name"));
        grid.addColumn(Bearer::getSpaceShip).setCaption(RES.getString("spaceShip"));
        grid.setWidth("100%");
        grid.setHeight("100%");
    }

    public Component getComponent(){
        return grid;
    }

    public void addSelectionListener(final SelectionListener<Bearer> listener) {
        grid.addSelectionListener(listener);
    }

}
