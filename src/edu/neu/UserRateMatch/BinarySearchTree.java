package edu.neu.UserRateMatch;
class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // 插入新值到BST中
    void insert(String value) {
        root = insertRec(root, value);
    }

    // 递归方法插入新值
    private Node insertRec(Node root, String value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value.compareTo(root.value) < 0)
            root.left = insertRec(root.left, value);
        else if (value.compareTo(root.value) > 0)
            root.right = insertRec(root.right, value);

        return root;
    }

    // 在BST中搜索值
    boolean search(String value) {
        return searchRec(root, value);
    }

    // 递归方法搜索值
    private boolean searchRec(Node root, String value) {
        if (root == null)
            return false;
        if (root.value.equals(value))
            return true;

        return value.compareTo(root.value) < 0 ? searchRec(root.left, value) : searchRec(root.right, value);
    }
}
