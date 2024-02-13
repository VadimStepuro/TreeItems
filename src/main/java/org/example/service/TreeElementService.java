package org.example.service;

import org.example.model.TreeNode;
import org.example.model.Tree;
import org.example.repository.TreeNodeRepository;
import org.example.repository.TreeElementRepository;

import java.util.*;

public class TreeElementService {
    private final TreeElementRepository treeElementRepository = new TreeElementRepository();
    private final TreeNodeRepository treeRepository = new TreeNodeRepository();
    private final Map<Integer, List<TreeNode>> treeNodeHashMap = new HashMap<>();

    public List<TreeNode> getTreeStructure(){
        List<Tree> trees = treeElementRepository.getAll();

        for (Tree element: trees) {
            TreeNode newNode = new TreeNode(element.getId(), element.getName());
            if(treeNodeHashMap.containsKey(element.getParentId())){
                treeNodeHashMap.get(element.getParentId()).add(newNode);
            }
            else{
                List<TreeNode> newList = new ArrayList<>();
                newList.add(newNode);
                treeNodeHashMap.put(element.getParentId(), newList);
            }
        }

        List<TreeNode> treeHeads = treeNodeHashMap.get(null);
        treeRepository.setTreeNodes(treeHeads);

        for(TreeNode node : treeHeads){
            findChildNodes(node);
        }

        return treeHeads;
    }

    private void findChildNodes(TreeNode parent){
        List<TreeNode> children = treeNodeHashMap.get(parent.getId());

        if(children == null)
            return;

        parent.setChilds(children);

        for (TreeNode child: children) {
            findChildNodes(child);
        }
    }

    public void printTree(List<TreeNode> nodes){
        StringBuilder prefix = new StringBuilder("-");

        for(TreeNode node : nodes){
            printNode(node, prefix);
        }
    }

    private void printNode(TreeNode node, StringBuilder prefix){
        System.out.println(prefix + node.getName());

        for(TreeNode subNode : node.getChilds()){
            printNode(subNode, prefix.append("-"));

            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
