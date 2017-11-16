package com.github.mictaege.eval.jitteree;

import com.github.mictaege.jitter.api.OnlyIf;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static com.github.mictaege.eval.jitteree.Flavour.ESA;
import static com.github.mictaege.eval.jitteree.Flavour.NASA;
import static com.github.mictaege.eval.jitteree.Flavour.ROSKOSMOS;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Bearer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Enumerated(STRING)
    private BearerType type;
    private String name;
    @OnlyIf(ESA)
    private int constructionYear;
    @Enumerated(STRING)
    private SpaceShipType spaceShipType;
    private String img;

    public Bearer() {
        super();
    }

    @OnlyIf(ESA)
    public Bearer(final BearerType type, final String name,
                  final int constructionYear, final SpaceShipType spaceShipType, final String img) {
        super();
        this.type = type;
        this.name = name;
        this.constructionYear = constructionYear;
        this.spaceShipType = spaceShipType;
        this.img = img;
    }

    @OnlyIf({NASA, ROSKOSMOS})
    public Bearer(final BearerType type, final String name,
                  final SpaceShipType spaceShipType, final String img) {
        super();
        this.type = type;
        this.name = name;
        this.spaceShipType = spaceShipType;
        this.img = img;
    }

    public long getId() {
        return id;
    }

    public BearerType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @OnlyIf(ESA)
    public int getConstructionYear() {
        return constructionYear;
    }

    public SpaceShipType getSpaceShipType() {
        return spaceShipType;
    }

    public String getSpaceShip() {
        return spaceShipType.getName();
    }

    public String getImg() {
        return img;
    }

}