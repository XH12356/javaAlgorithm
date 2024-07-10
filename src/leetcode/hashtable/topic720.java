package leetcode.hashtable;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.HashSet;

public class topic720 {
    public static void main(String[] args) {
        String[] words = new String[]{"a","banana","app","appl","ap","apply","apple"};
        System.out.println(new Solution720().longestWord(words));
    }
}

/**
 * TrieTree
 */
class Solution720 {
    public String longestWord(String[] words) {
//        //数组转list转set
//        HashSet<String> sets = new HashSet<>(Arrays.asList(words));
        for(String s : words){
            insert(s);
        }
        String res = "";
        for(String s : words){
            if(res.length() > s.length()){
                continue;
            }
            if(res.length() == s.length() && res.compareTo(s) < 0){
                continue;
            }
            if(contain(s)){
                res = s;
            }
        }
        return res;

    }
    class TreeNode{
        boolean end;
        TreeNode[] tns = new TreeNode[26];
    }
    TreeNode root = new TreeNode();

    public void insert(String s){
        TreeNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - 'a';
            if(p.tns[tmp] == null){//没有下一项，创建
                p.tns[tmp] = new TreeNode();
            }
            p = p.tns[tmp];
        }
        p.end = true;
    }
    public boolean contain(String s){
        TreeNode p = root;
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - 'a';
            if(p.tns[tmp] == null || !p.tns[tmp].end){//没有该位置的字母，或没有以该字母结尾的单词
                return false;
            }
            p = p.tns[tmp];

        }
        return p.end;

    }

}
/*
class Trie {
    class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) p.tns[u] = new TrieNode();
            p = p.tns[u];
        }
        p.end = true;
    }

    public boolean search(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return p.end;
    }

    public boolean startsWith(String s) {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (p.tns[u] == null) return false;
            p = p.tns[u];
        }
        return true;
    }
}
*/
