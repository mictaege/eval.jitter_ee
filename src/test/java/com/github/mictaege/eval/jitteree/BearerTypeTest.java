package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.OnlyIf;
import org.junit.Test;

import static com.github.mictaege.eval.jitteree.BearerType.ARIANE5;
import static com.github.mictaege.eval.jitteree.BearerType.ATLAS;
import static com.github.mictaege.eval.jitteree.BearerType.SOJUS;
import static com.github.mictaege.eval.jitteree.BearerType.TITAN;
import static com.github.mictaege.eval.jitteree.BearerType.WOSTOK;
import static com.github.mictaege.eval.jitteree.Flavour.ESA;
import static com.github.mictaege.eval.jitteree.Flavour.NASA;
import static com.github.mictaege.eval.jitteree.Flavour.ROSKOSMOS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BearerTypeTest {

    @Test
    @OnlyIf(ESA)
    public void shouldDefineAriane5() {
        assertThat(ARIANE5.name(), is("ARIANE5"));
    }

    @Test
    @OnlyIf(NASA)
    public void shouldDefineAtlas() {
        assertThat(ATLAS.name(), is("ATLAS"));
    }

    @Test
    @OnlyIf(NASA)
    public void shouldDefineTitan() {
        assertThat(TITAN.name(), is("TITAN"));
    }

    @Test
    @OnlyIf(ROSKOSMOS)
    public void shouldDefineWostok() {
        assertThat(WOSTOK.name(), is("WOSTOK"));
    }

    @Test
    @OnlyIf(ROSKOSMOS)
    public void shouldDefineSojus() {
        assertThat(SOJUS.name(), is("SOJUS"));
    }

}