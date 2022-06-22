package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * @author leon
 * @date 2022-01-19 22:03:25
 */
public class Solution297 {

    //序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
    //
    //请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
    //
    //提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 分割符
     */
    private static final String SEP = ",";
    /**
     * 空节点标识 符号
     */
    private static final String NULL = "#";

    /**
     * Encodes a tree to a single string.
     *
     * @param root root
     * @return String
     */
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(sb, root);
        return sb.toString();
    }

    private static void traverse(StringBuilder sb, TreeNode root) {
        if (null == root) {
            sb.append(NULL).append(SEP);
            return;
        }
        //前序遍历框架
        sb.append(root.val).append(SEP);
        //左右节点
        traverse(sb, root.left);
        traverse(sb, root.right);
    }

    /**
     * Decodes your encoded data to tree.¬
     *
     * @param data data
     * @return TreeNode
     */
    public static TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        String[] split = data.split(SEP);
        for (String s : split) {
            list.addLast(s);
        }
        return deserialize(list);
    }

    private static TreeNode deserialize(LinkedList<String> list) {
        if (null == list) {
            return null;
        }
        String first = list.removeFirst();
        if (NULL.equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }


    public static String postSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerialize(sb, root);
        return sb.toString();
    }

    private static void postSerialize(StringBuilder sb, TreeNode root) {
        if (null == root) {
            sb.append(NULL).append(SEP);
            return;
        }
        postSerialize(sb, root.left);
        postSerialize(sb, root.right);
        //后续遍历
        sb.append(root.val).append(SEP);
    }

    public static TreeNode postDeserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        String[] split = data.split(SEP);
        for (String s : split) {
            list.addLast(s);
        }
        return postDeserialize(list);
    }

    private static TreeNode postDeserialize(LinkedList<String> list) {
        if (null == list) {
            return null;
        }
        String last = list.removeLast();
        if (NULL.equals(last)) {
            return null;
        }
        //后序遍历 顺序 左->右->根节点 最后一个为根节点 从后往前  顺序应该为 根节点->右->左
        TreeNode root = new TreeNode(Integer.parseInt(last));
        root.right = postDeserialize(list);
        root.left = postDeserialize(list);
        return root;
    }

    public static String levelSerialize(TreeNode root) {
        if (null == root) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            //层级遍历位置
            if (null == poll) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(poll.val).append(SEP);
            list.offer(poll.left);
            list.offer(poll.right);
        }
        return sb.toString();
    }

    public static TreeNode levelDeserialize(String data) {
        if (null == data || "".equals(data)) {
            return null;
        }
        String[] split = data.split(SEP);
        //层级遍历 第一个节点即为根节点
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));

        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        for (int i = 1; i < split.length; ) {
            //list存放的都是root1节点
            TreeNode parent = list.poll();
            //获取到左节点
            String left = split[i++];
            if (!NULL.equals(left)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                list.offer(parent.left);
            } else {
                parent.left = null;
            }
            //右节点
            String right = split[i++];
            if (!NULL.equals(right)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                list.offer(parent.right);
            } else {
                parent.right = null;
            }

        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        TreeNode four = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        seven.right = new TreeNode(9);
        right.left = four;
        right.right = seven;

        String serialize = levelSerialize(root);
        System.out.println("serialize: " + serialize);
        TreeNode deserialize = levelDeserialize(serialize);
        System.out.println("deserialize: " + deserialize);
    }
}
