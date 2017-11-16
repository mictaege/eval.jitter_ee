package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.OnlyIf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.github.mictaege.eval.jitteree.BearerType.ATLAS;
import static com.github.mictaege.eval.jitteree.BearerType.TITAN;
import static com.github.mictaege.eval.jitteree.Flavour.NASA;
import static java.util.Arrays.asList;

@Stateless
@OnlyIf(NASA)
public class NasaDao implements DaoIF {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Bearer> findBearers() {
        return em.createQuery("SELECT object(o) FROM Bearer o WHERE o.type IN :types", Bearer.class)
                .setParameter("types", asList(ATLAS, TITAN))
                .getResultList();
    }

}
