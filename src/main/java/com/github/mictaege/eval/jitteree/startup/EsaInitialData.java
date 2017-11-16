package com.github.mictaege.eval.jitteree.startup;

import com.github.mictaege.eval.jitteree.Bearer;
import com.github.mictaege.jitter.api.OnlyIf;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.github.mictaege.eval.jitteree.BearerType.ARIANE5;
import static com.github.mictaege.eval.jitteree.Flavour.ESA;
import static com.github.mictaege.eval.jitteree.SpaceShipType.HERMES;

@OnlyIf(ESA)
@Singleton
@Startup
public class EsaInitialData {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        em.persist(new Bearer(ARIANE5, "Ariane5",
                1996, HERMES, "Ariane5.jpg"));
    }

}
