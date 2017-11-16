package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.OnlyIf;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.github.mictaege.eval.jitteree.BearerType.ARIANE5;
import static com.github.mictaege.eval.jitteree.Flavour.ESA;

@Stateless
@OnlyIf(ESA)
public class EsaDao implements DaoIF {

    @PersistenceContext
    private EntityManager em;

    public List<Bearer> findBearers() {
        return em.createQuery("SELECT object(o) FROM Bearer o WHERE o.type = :type", Bearer.class)
                .setParameter("type", ARIANE5)
                .getResultList();
    }

}
