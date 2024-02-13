package org.example.model;

public class Tree {
    private Integer id;
    private String name;
    private Integer parentId;

    public Tree() {
    }

    public Tree(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Tree(Integer id, Integer parentId, String name) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
