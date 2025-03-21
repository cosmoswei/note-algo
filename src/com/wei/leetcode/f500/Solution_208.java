package com.wei.leetcode.f500;

import java.util.HashMap;
import java.util.Map;

public class Solution_208 {

    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("Trie");

        trie.search("null");
        trie.startsWith("a");
    }
}

class Node {
    Node[] son = new Node[26];
    boolean end;
}

class Trie {

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            System.out.println(c);
            c -= 'a';
            System.out.println(c);
            if (cur.son[c] == null) {
                cur.son[c] = new Node();
            }
            cur = cur.son[c];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return find(word) == 2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    private int find(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            ch -= 'a';
            if (cur.son[ch] == null) {
                return 0;
            }
            cur = cur.son[ch];
        }
        return cur.end ? 2 : 1;
    }
}

class Trie2 {
    static class Node2 {
        Map<Character, Node2> children = new HashMap<>();
        boolean isEnd = false;
    }

    private final Node2 root;

    public Trie2() {
        root = new Node2();
    }

    public void insert(String word) {
        Node2 cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node2());
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Node2 cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node2 cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}