package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.OnlyIf;

import static com.github.mictaege.eval.jitteree.Flavour.ESA;
import static com.github.mictaege.eval.jitteree.Flavour.NASA;
import static com.github.mictaege.eval.jitteree.Flavour.ROSKOSMOS;

public enum BearerType {

    @OnlyIf(ESA)
    ARIANE5,

    @OnlyIf(NASA)
    ATLAS,
    @OnlyIf(NASA)
    TITAN,

    @OnlyIf(ROSKOSMOS)
    WOSTOK,
    @OnlyIf(ROSKOSMOS)
    SOJUS;

}