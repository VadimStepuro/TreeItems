package org.example.repository;

import org.example.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeRepository {
    List<TreeNode> treeNodes = new ArrayList<>();

    public List<TreeNode> getTreeNodes(){
        return treeNodes;
    }

    public List<TreeNode> setTreeNodes(List<TreeNode> nodes){
        treeNodes = nodes;
        return treeNodes;
    }
 }
