package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.OnlyIf;
import org.junit.Test;

import static com.github.mictaege.eval.jitteree.Flavour.ESA;
import static com.github.mictaege.eval.jitteree.Flavour.NASA;
import static com.github.mictaege.eval.jitteree.Flavour.ROSKOSMOS;
import static com.github.mictaege.eval.jitteree.SpaceShipType.GEMINI;
import static com.github.mictaege.eval.jitteree.SpaceShipType.HERMES;
import static com.github.mictaege.eval.jitteree.SpaceShipType.MERCURY;
import static com.github.mictaege.eval.jitteree.SpaceShipType.SOJUS;
import static com.github.mictaege.eval.jitteree.SpaceShipType.WOSTOK;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpaceShipTypeTest {

    @Test
    @OnlyIf(ESA)
    public void shouldDefineHermes() {
        assertThat(HERMES.getName(), is("Hermes"));
    }

    @Test
    @OnlyIf(NASA)
    public void shouldDefineMercury() {
        assertThat(MERCURY.getName(), is("Mercury"));
    }

    @Test
    @OnlyIf(NASA)
    public void shouldDefineGemini() {
        assertThat(GEMINI.getName(), is("Gemini"));
    }

    @Test
    @OnlyIf(ROSKOSMOS)
    public void shouldDefineWostok() {
        assertThat(WOSTOK.getName(), is("Wostok"));
    }

    @Test
    @OnlyIf(ROSKOSMOS)
    public void shouldDefineSojus() {
        assertThat(SOJUS.getName(), is("Sojus"));
    }

}