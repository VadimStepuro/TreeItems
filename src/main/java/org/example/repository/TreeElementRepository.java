package org.example.repository;

import org.example.model.Tree;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class TreeElementRepository {
    private List<Tree> trees = List.of(
            new Tree(0, "Parent 1"),
            new Tree(1, "Parent 2"),
            new Tree(2, 1, "Child 2.1"),
            new Tree(3, 0, "Child 1.1"),
            new Tree(4, 3, "Child 1.1.1"),
            new Tree(5, 0, "Child 1.2"),
            new Tree(6, 4, "Child 1.1.1.1"),
            new Tree(7, 2, "Child 2.1.1"));

    public List<Tree> getAll(){
        return trees;
    }

    public Tree findById(Integer id){
        if(id == null)
            throw new NullPointerException("Id can't be null");

        for(int i = 0; i < trees.size(); i++){

            if(Objects.equals(trees.get(i).getId(), id))
                return trees.get(i);
        }

        throw new NoSuchElementException("No such tree element");
    }

    public Tree findByParentId(Integer id){
        for(int i = 0; i < trees.size(); i++){

            if(Objects.equals(trees.get(i).getParentId(), id))
                return trees.get(i);
        }

        throw new NoSuchElementException("No such tree element");
    }

    public void removeElementById(Integer id){
        if(id == null)
            throw new NullPointerException("Id can't be null");

        for(int i = 0; i < trees.size(); i++){

            if(Objects.equals(trees.get(i).getId(), id)){
                trees.remove(i);
                return;
            }
        }

        throw new NoSuchElementException("No such tree element");
    }
}
