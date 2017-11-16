package com.github.mictaege.eval.jitteree.startup;

import com.github.mictaege.eval.jitteree.Bearer;
import com.github.mictaege.eval.jitteree.SpaceShipType;
import com.github.mictaege.jitter.api.OnlyIf;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.github.mictaege.eval.jitteree.BearerType.SOJUS;
import static com.github.mictaege.eval.jitteree.BearerType.WOSTOK;
import static com.github.mictaege.eval.jitteree.Flavour.ROSKOSMOS;

@OnlyIf(ROSKOSMOS)
@Singleton
@Startup
public class RoskosmosInitialData {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        em.persist(new Bearer(WOSTOK, "Wostok", SpaceShipType.WOSTOK, "Wostok.jpg"));
        em.persist(new Bearer(SOJUS, "Sojus", SpaceShipType.SOJUS, "Sojus.jpg"));
    }

}
