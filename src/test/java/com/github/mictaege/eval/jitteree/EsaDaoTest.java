package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.OnlyIf;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import static com.github.mictaege.eval.jitteree.BearerType.ARIANE5;
import static com.github.mictaege.eval.jitteree.Flavour.ESA;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@OnlyIf(ESA)
public class EsaDaoTest {

    @Mock
    private EntityManager em;
    @Mock
    private TypedQuery<Bearer> query;

    @InjectMocks
    private EsaDao dao;

    @Before
    public void context() {
        initMocks(this);
        when(em.createQuery(anyString(), eq(Bearer.class))).thenReturn(query);
        when(query.setParameter(anyString(), any())).thenReturn(query);
    }

    @Test
    public void shouldProvideBearers() {
        dao.findBearers();

        verify(em).createQuery(eq("SELECT object(o) FROM Bearer o WHERE o.type = :type"), eq(Bearer.class));
        verify(query).setParameter("type", ARIANE5);
        verify(query).getResultList();
    }

}