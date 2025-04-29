package org.jokeoa.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> {

    private Node root;
    private int size;

    public BST() {
        this.size = 0;
    }

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public static class Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public void put(K key, V val) {
        Node newNode = new Node(key, val);

        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                current.val = val; // Update value if key matches
                return;
            }
        }

        int cmp = key.compareTo(parent.key);
        if (cmp < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        size++;
    }

    public V get(K key) {
        Node current = root;

        while (current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current.val;
            }
        }

        return null;
    }

    public void delete(K key) {
        Node current = root;
        Node parent = null;

        while (current != null && !current.key.equals(key)) {
            parent = current;
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (current == null) {
            return; // Key not found
        }

        // no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // has one child
        else if (current.left == null || current.right == null) {
            Node child = (current.left != null) ? current.left : current.right;

            if (current == root) {
                root = child;
            } else if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // has two children
        else {
            Node successorParent = current;
            Node successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.key = successor.key;
            current.val = successor.val;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }
        size--;
    }
    public int size(){
        return size;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<>() {
            private final Stack<Node> stack = new Stack<>();
            private Node current = root;

            {

                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Entry<K, V> next() {
                current = stack.pop();
                Entry<K, V> entry = new Entry<>(current.key, current.val);

                // Move to the right subtree
                if (current.right != null) {
                    Node temp = current.right;
                    while (temp != null) {
                        stack.push(temp);
                        temp = temp.left;
                    }
                }

                return entry;
            }
        };
    }
}