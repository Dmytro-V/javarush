package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root = new Entry<>("0");

    public CustomTree() {
    }



    static class Entry<T> implements Serializable{
        public String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }


        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }


    public String getParent(String s) {
        List<Entry<String>> tree = getLeaves();
        for (Entry<String> leaf : tree) {
            if (leaf.elementName.equals(s)) {
                return leaf.parent.elementName;
            }
        }
        return null;
    }

    private List<Entry<String>> getLeaves() {
        ArrayList<Entry<String>> leaves = new ArrayList<>();
        leaves.add(root);

        int i = 0;
        Entry<String> leaf;
        do {
            leaf = leaves.get(i);
            if (leaf.leftChild != null) {
                leaves.add(leaf.leftChild);
            }
            if (leaf.rightChild != null) {
                leaves.add(leaf.rightChild);
            }
            i++;

        } while (i < leaves.size());

        return leaves;
    }

    @Override
    public boolean add(String s) {
        List<Entry<String>> tree = getLeaves();

        Entry<String> newLeaf = new Entry<>(s);

        for (Entry<String> leaf : tree) {
            if (leaf.availableToAddLeftChildren) {
                leaf.leftChild = newLeaf;
                leaf.availableToAddLeftChildren = false;
                newLeaf.parent = leaf;
                return true;
            } else if (leaf.availableToAddRightChildren) {
                leaf.rightChild = newLeaf;
                leaf.availableToAddRightChildren = false;
                newLeaf.parent = leaf;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        String leafForRemove = (String)o;
        List<Entry<String>> tree = getLeaves();
        for (Entry<String> leaf : tree) {
            if (leaf.elementName.equals(leafForRemove)) {
                if (leaf == leaf.parent.leftChild) {
                    leaf.parent.leftChild = null;
                } else if (leaf == leaf.parent.rightChild) {
                    leaf.parent.rightChild = null;
                }
            }
        }

        tree = getLeaves();

        if (!tree.stream()
                .anyMatch(leaf -> leaf.isAvailableToAddChildren())){

            for (Entry<String> leaf : tree) {
                if (leaf.leftChild == null) {
                    leaf.availableToAddLeftChildren = true;
                }
                if (leaf.rightChild == null) {
                    leaf.availableToAddRightChildren = true;
                }
            }
        }

        return true;
    }

    @Override
    public int size() {
        List<Entry<String>> tree = getLeaves();
        return tree.size() - 1;
    }


    //------unsupported Operation---------------------------------------------------------
    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

}
