package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.OnlyIf;

import static com.github.mictaege.eval.jitteree.Flavour.ESA;
import static com.github.mictaege.eval.jitteree.Flavour.NASA;
import static com.github.mictaege.eval.jitteree.Flavour.ROSKOSMOS;

public enum SpaceShipType {

    @OnlyIf(ESA)
    HERMES("Hermes"),

    @OnlyIf(NASA)
    MERCURY("Mercury"),
    @OnlyIf(NASA)
    GEMINI("Gemini"),

    @OnlyIf(ROSKOSMOS)
    WOSTOK("Wostok"),
    @OnlyIf(ROSKOSMOS)
    SOJUS("Sojus");

    private String name;

    SpaceShipType(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
