package de.synyx.softwarecraftsmanship.toiletpaper.model;

import de.synyx.softwarecraftsmanship.toiletpaper.service.Condition;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Toiletpaper {
    public Toiletpaper() {
    }

    public Toiletpaper(Integer layerCount, Integer leaves, String brand, Condition condition) {
        this.layerCount = layerCount;
        this.leaves = leaves;
        this.brand = brand;
        this.condition = condition;
    }

    @Id
    private Long id;

    private Integer layerCount;
    private Integer leaves;
    private String brand;
    private Condition condition;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
