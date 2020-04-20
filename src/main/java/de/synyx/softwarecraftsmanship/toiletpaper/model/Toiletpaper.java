package de.synyx.softwarecraftsmanship.toiletpaper.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Toiletpaper {

    @Id
    private Long id;

    private Integer layerCount;
    private Integer leaves;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLayerCount() {
        return layerCount;
    }

    public void setLayerCount(Integer layerCount) {
        this.layerCount = layerCount;
    }

    public Integer getLeaves() {
        return leaves;
    }

    public void setLeaves(Integer leaves) {
        this.leaves = leaves;
    }
}
