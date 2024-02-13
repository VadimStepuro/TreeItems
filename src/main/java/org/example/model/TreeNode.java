package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private Integer id;
    private String name;
    private List<TreeNode> childs;

    public TreeNode() {
        childs = new ArrayList<>();
    }

    public TreeNode(Integer id, String name) {
        this.id = id;
        this.name = name;
        childs = new ArrayList<>();
    }

    public TreeNode(Integer id, String name, List<TreeNode> childs) {
        this.id = id;
        this.name = name;
        this.childs = childs;
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

    public List<TreeNode> getChilds() {
        return childs;
    }

    public void setChilds(List<TreeNode> childs) {
        this.childs = childs;
    }
}
