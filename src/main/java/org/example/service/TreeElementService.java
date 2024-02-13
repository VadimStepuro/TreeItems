package org.example.service;

import org.example.model.TreeNode;
import org.example.model.Tree;
import org.example.repository.TreeNodeRepository;
import org.example.repository.TreeElementRepository;

import java.util.List;
import java.util.Objects;

public class TreeElementService {
    private TreeElementRepository treeElementRepository = new TreeElementRepository();
    private TreeNodeRepository treeRepository = new TreeNodeRepository();

    public List<TreeNode> getTreeStructure(){
        List<Tree> trees = treeElementRepository.getAll();
        List<TreeNode> treeHeads = treeRepository.getTreeNodes();

        for (Tree element: trees) {
            if(element.getParentId() == null){

                treeHeads.add(new TreeNode(element.getId(), element.getName()));
            }
        }

        for(TreeNode node : treeHeads){
            findChildNodes(node);
        }

        return treeHeads;
    }

    private void findChildNodes(TreeNode parent){
        List<Tree> trees = treeElementRepository.getAll();

        for (Tree child: trees) {

            if(Objects.equals(child.getParentId(), parent.getId())){
                TreeNode newChild = new TreeNode(child.getId(), child.getName());
                parent.getChilds().add(newChild);
                findChildNodes(newChild);
            }
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
