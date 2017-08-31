package traversalAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * User: 杨永生
 * Date: 18:43 2017/8/29
 * Email: kevin@hiibook.com
 */
class Node<E extends Comparable<E>> {
    Node<E> left;
    Node<E> right;
    E value;
    Node() {
        left = null;
        right = null;
        value = null;
    }
    Node(E value) {
        this.value = value;
        left = null;
        right = null;
    }
    //先序遍历算法   遍历顺序：访问根节点，遍历左子树，遍历右子树。代码如下
    void PreOrderPrint() {
        System.out.print(value.toString() + " ");//先访问根节点
        if (left != null)
            left.PreOrderPrint();//再遍历左子树
        if (right != null)
            right.PreOrderPrint();//再遍历右子树
    }

    //中序遍历算法   遍历顺序：访问遍历左子树，根节点，遍历右子树。代码如下
    void InOrderPrint() {
        if (left != null)
            left.InOrderPrint();//先遍历左子树
        System.out.print(value.toString() + " ");//再访问根节点
        if (right != null)
            right.InOrderPrint();//再遍历右子树
    }

    //后序遍历算法   遍历顺序：访问遍历右子树，遍历左子树,根节点，代码如下
    void PostOrderPrint() {
        if (left != null)
            left.PostOrderPrint();//访问遍历右子树
        if (right != null)
            right.PostOrderPrint();//再遍历右子树
        System.out.print(value.toString() + " ");//再访问根节点
    }

    //层次遍历算法 :这里的实现方式类似于两个簸箕（queue1 和 queue2)(队列)之间互相倒，知道谁都没有后继节点位置，即两个簸箕都为空，此处是两个队列都为空
    void LevelOrderPrint() {
        if (this == null)
            throw new IllegalArgumentException("null node !");
        Queue<Node<E>> queue1 = new LinkedList<Node<E>>();
        Queue<Node<E>> queue2 = new LinkedList<Node<E>>();
        queue1.add(this);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (queue2.isEmpty()) {
                while (!queue1.isEmpty()) {
                    Node<E> currentNode = queue1.poll();
                    System.out.print(currentNode.value.toString() + " ");
                    if (currentNode.left != null) {
                        queue2.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue2.add(currentNode.right);
                    }
                }
            } else {
                while (!queue2.isEmpty()) {
                    Node<E> currentNode = queue2.poll();
                    System.out.print(currentNode.value.toString() + " ");
                    if (currentNode.left != null) {
                        queue1.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue1.add(currentNode.right);
                    }
                }
            }
            System.out.println();
        }
    }

    //S型层序遍历:就是把上面使用的queue换为stack(堆栈)，注意左右子节点添加顺序，就可以了
    public void S_LevelOrderPrint() {
        Stack<Node<E>> stack1 = new Stack<Node<E>>();
        Stack<Node<E>> stack2 = new Stack<Node<E>>();
        stack1.add(this);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                while (!stack2.isEmpty()) {
                    Node<E> currentNode = stack2.pop();
                    System.out.print(currentNode.value + " ");
                    if (currentNode.left != null)
                        stack1.push(currentNode.left);
                    if (currentNode.right != null)
                        stack1.push(currentNode.right);
                }
            } else {
                while (!stack1.isEmpty()) {
                    Node<E> currentNode = stack1.pop();
                    System.out.print(currentNode.value + " ");
                    if (currentNode.right != null)
                        stack2.add(currentNode.right);
                    if (currentNode.left != null)
                        stack2.add(currentNode.left);
                }
            }
            System.out.println();
        }
    }
}

//建立一个树: 左节点比跟节点小,右节点比跟节点大
class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    public Node<E> getRoot() {
        return root;
    }
    //构造方法:初始化
    BinarySearchTree() {
        root = null;
    }
    //添加节点:实例化
    public void InsertNode(E value) {
        if (root == null) {
            root = new Node<E>(value);
            return;
        }
        //当前节点
        Node<E> currentNode = root;
        //构造二叉树(Binary Tree)
        while (true) {
            if (value.compareTo(currentNode.value) > 0) {//比跟节点大,放右边
                if (currentNode.right == null) {
                    currentNode.right = new Node<E>(value);
                    break;
                }
                currentNode = currentNode.right;
            } else {    //比跟节点小,放左边
                if (currentNode.left == null) {
                    currentNode.left = new Node<E>(value);
                    break;
                }
                currentNode = currentNode.left;
            }
        }
    }
}

//打印测试
class LevelPrintOfBinaryTree<E extends Comparable<E>> {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        {
            tree.InsertNode(4);
            tree.InsertNode(2);
            tree.InsertNode(1);
            tree.InsertNode(3);
            tree.InsertNode(6);
            tree.InsertNode(5);
            tree.InsertNode(7);
            tree.InsertNode(8);
        }
        System.out.print("PreOrderPrint: ");
        tree.getRoot().PreOrderPrint();
        System.out.print("\nInOrderPrint: ");
        tree.getRoot().InOrderPrint();
        System.out.print("\nPostOrderPrint: ");
        tree.getRoot().PostOrderPrint();
        System.out.println("\nLevelOrderPrint: ");
        tree.getRoot().LevelOrderPrint();
        System.out.println("\nS_LevelOrderPrint: ");
        tree.getRoot().S_LevelOrderPrint();
    }
}