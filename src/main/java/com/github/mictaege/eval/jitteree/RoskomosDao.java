package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.OnlyIf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.github.mictaege.eval.jitteree.BearerType.SOJUS;
import static com.github.mictaege.eval.jitteree.BearerType.WOSTOK;
import static com.github.mictaege.eval.jitteree.Flavour.ROSKOSMOS;
import static java.util.Arrays.asList;

@Stateless
@OnlyIf(ROSKOSMOS)
public class RoskomosDao implements DaoIF {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Bearer> findBearers() {
        return em.createQuery("SELECT object(o) FROM Bearer o WHERE o.type IN :types", Bearer.class)
                .setParameter("types", asList(WOSTOK, SOJUS))
                .getResultList();
    }

}
