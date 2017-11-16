package com.github.mictaege.eval.jitteree.startup;

import com.github.mictaege.eval.jitteree.Bearer;
import com.github.mictaege.jitter.api.OnlyIf;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.github.mictaege.eval.jitteree.BearerType.ATLAS;
import static com.github.mictaege.eval.jitteree.BearerType.TITAN;
import static com.github.mictaege.eval.jitteree.Flavour.NASA;
import static com.github.mictaege.eval.jitteree.SpaceShipType.GEMINI;
import static com.github.mictaege.eval.jitteree.SpaceShipType.MERCURY;

@OnlyIf(NASA)
@Singleton
@Startup
public class NasaInitialData {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        em.persist(new Bearer(ATLAS, "Atlas", MERCURY, "Atlas.jpg"));
        em.persist(new Bearer(TITAN, "Titan", GEMINI, "Titan.jpg"));
    }

}
