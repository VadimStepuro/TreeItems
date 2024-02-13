package org.example.controller;

import org.example.model.TreeNode;
import org.example.service.TreeElementService;

import java.util.List;

public class TreeElementController {
    private TreeElementService service = new TreeElementService();

    public void printSructure(){
        List<TreeNode> treeHeads = service.getTreeStructure();
        service.printTree(treeHeads);
    }

    public List<TreeNode> getTreeStructure(){
        return service.getTreeStructure();
    }
}
