package de.synyx.softwarecraftsmanship.toiletpaper.model;

public class Toiletpaper {

    public Toiletpaper(Integer layerCount, Integer leaves) {
        this.layerCount = layerCount;
        this.leaves = leaves;
    }

    private Integer layerCount;
    private Integer leaves;

    public Integer getLayerCount() {
        return layerCount;
    }

    public Integer getLeaves() {
        return leaves;
    }
}
