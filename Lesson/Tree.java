package 学习;

import java.util.Stack;

public class Tree {
    public  static class TreeNode{
        int Value;
        TreeNode left;
        TreeNode right;
    }
    //非递归的前序遍历
    public static void NodePreOrder(TreeNode head){
        TreeNode cur=head;
        Stack<TreeNode>Mystack=new Stack<>();
        Mystack.push(head);
        while(!Mystack.isEmpty()){
            Mystack.push(cur.right);
            Mystack.push(cur.left);
            cur=Mystack.pop();//弹出
            System.out.print(cur.Value);   //这里可以换成其他函数，即是这里为对当前的点处理
        }
    }
    //非递归的中序遍历
    public  static void MediumOrder(TreeNode head){
        Stack<TreeNode>MyStack=new Stack<>();
        while(!MyStack.isEmpty()||head!=null){
            if(head!=null){
                MyStack.push(head);
                head=head.left;
            }
            else{
                head=MyStack.pop();
                System.out.print(head.Value);
                head=head.right;
            }
        }
    }
    //非递归的后序遍历
    public static void NodePostOrder(TreeNode head){
        TreeNode cur=head;
        Stack<TreeNode>pre=new Stack<TreeNode>();
        Stack<TreeNode>ans=new Stack<TreeNode>();
        pre.push(head);
        while(!pre.empty()){
            pre.push(head.left);
            pre.push(head.right);
            cur=pre.pop();
            ans.push(cur);
        }
        //离开此段的ans栈已然是后序遍历
    }
    public static void NodeRecursion_Traversal(TreeNode head){
        if(head==null){
            return;
        };
        //此处为前序遍历
        NodeRecursion_Traversal(head.left);
        //此处为中序遍历
        NodeRecursion_Traversal(head.right);
        //此处为后序遍历
    }
    public static class ReturnType_BLT{
        boolean isBanlanceTree;
        int height;
        public ReturnType_BLT(int H,boolean is){
            this.height=H;
            this.isBanlanceTree=is;
        }
    }
    public  static ReturnType_BLT isBanlanceTree(TreeNode root){
        if(root==null){
            return new ReturnType_BLT(0,true);
        }
        ReturnType_BLT LeftData=isBanlanceTree(root.left);
        ReturnType_BLT rightData=isBanlanceTree(root.right);
        boolean isBLT=false;
        int Height=Math.max(LeftData.height, rightData.height)+1;
        if(LeftData.isBanlanceTree&& rightData.isBanlanceTree&&(Math.abs(LeftData.height- rightData.height))<2){
            isBLT=true;
        }
        return new ReturnType_BLT(Height,isBLT);
    }

    public static int preValue=Integer.MIN_VALUE;
    public static boolean isBST(TreeNode root){
        if(root==null){
            return false;
        }
        boolean isbst=isBST(root.left);
        if(!isbst){
            return false;
        }
        if(root.Value<=preValue){
            return false;
        }
        else{
            preValue=root.Value;
        }
            return isBST(root.right);
    }

}
