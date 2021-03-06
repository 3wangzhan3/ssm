package com.offcn.ssm.pojo;

public class BreadCrumd {
    private Integer id;
    private Integer parentId;
    private String name;
    private Integer typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public BreadCrumd(Integer id, Integer parentId, String name, Integer typeId) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.typeId = typeId;
    }

    public BreadCrumd() {
    }
}
