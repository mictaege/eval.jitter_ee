package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.OnlyIf;
import org.junit.Test;

import static com.github.mictaege.eval.jitteree.BearerType.ARIANE5;
import static com.github.mictaege.eval.jitteree.BearerType.ATLAS;
import static com.github.mictaege.eval.jitteree.BearerType.WOSTOK;
import static com.github.mictaege.eval.jitteree.Flavour.ESA;
import static com.github.mictaege.eval.jitteree.Flavour.NASA;
import static com.github.mictaege.eval.jitteree.Flavour.ROSKOSMOS;
import static com.github.mictaege.eval.jitteree.SpaceShipType.HERMES;
import static com.github.mictaege.eval.jitteree.SpaceShipType.MERCURY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BearerTest {

    @Test
    @OnlyIf(ESA)
    public void shouldConstructEsaBearer() {
        final Bearer bearer = new Bearer(ARIANE5, "Ariane5", 1996, HERMES, "Ariane5.jpg");

        assertThat(bearer.getType(), is(ARIANE5));
        assertThat(bearer.getName(), is("Ariane5"));
        assertThat(bearer.getConstructionYear(), is(1996));
        assertThat(bearer.getSpaceShipType(), is(HERMES));
        assertThat(bearer.getSpaceShip(), is(HERMES.getName()));
        assertThat(bearer.getImg(), is("Ariane5.jpg"));
    }

    @Test
    @OnlyIf(NASA)
    public void shouldConstructNasaBearer() {
        final Bearer bearer = new Bearer(ATLAS, "Atlas", MERCURY, "Atlas.jpg");

        assertThat(bearer.getType(), is(ATLAS));
        assertThat(bearer.getName(), is("Atlas"));
        assertThat(bearer.getSpaceShipType(), is(MERCURY));
        assertThat(bearer.getSpaceShip(), is(MERCURY.getName()));
        assertThat(bearer.getImg(), is("Atlas.jpg"));
    }

    @Test
    @OnlyIf(ROSKOSMOS)
    public void shouldConstructRoskomosBearer() {
        final Bearer bearer = new Bearer(WOSTOK, "Wostok", SpaceShipType.WOSTOK, "Wostok.jpg");

        assertThat(bearer.getType(), is(WOSTOK));
        assertThat(bearer.getName(), is("Wostok"));
        assertThat(bearer.getSpaceShipType(), is(SpaceShipType.WOSTOK));
        assertThat(bearer.getSpaceShip(), is(SpaceShipType.WOSTOK.getName()));
        assertThat(bearer.getImg(), is("Wostok.jpg"));
    }

}