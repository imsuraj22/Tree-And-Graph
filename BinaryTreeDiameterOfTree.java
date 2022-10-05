public class BinaryTreeDiameterOfTree {
    static class Node{
        int data;
        Node left;
        Node right;
    
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    
    static class BinaryTree{
        static int index=-1;
        public static Node buildTree(int nodes[]){
            index++;
            if(nodes[index]==-1){
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }

        
    } 
    //--------------HEIGHT OF TREE---------------
    public static int heightOfTree(Node root){
        if(root==null){
            return 0;
        }
        int lHeight=heightOfTree(root.left);
        int rHeight=heightOfTree(root.right);

        int myHeight=Math.max(lHeight, rHeight) +1;
        return myHeight;
    }

    //---------------DIAMETER OF TREE-----------

    public static int diameter(Node root){
        if(root==null){
            return 0;
        }

        int diam1=diameter(root.left);
        int diam2=diameter(root.right);
        int diam3=heightOfTree(root.left) + heightOfTree(root.right) +1;

        return Math.max(diam3, Math.max(diam1, diam2));
    }

    //-------------- APPROACH 2 ---------------------

    static class TreeInfo{
        int height;
        int diam;

        TreeInfo(int height, int diam){
            this.height=height;
            this.diam=diam;
        }
    }

    public static TreeInfo diameter2(Node root){
        if(root==null){
            return new TreeInfo(0, 0);
        }
        TreeInfo left=diameter2(root.left);
        TreeInfo right=diameter2(root.right);

        int myHeight=Math.max(left.height, right.height)+1;

        int diam1=left.diam;
        int diam2=right.diam;
        int diam3=left.height+right.height+1;

        int mydiam=Math.max(diam3, Math.max(diam1, diam2));

        TreeInfo myInfo=new TreeInfo(myHeight, mydiam);
        return myInfo;
    }
    
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        System.out.println(heightOfTree(root));
        System.out.println("Using Approach 1 "+diameter(root));
        System.out.println("Using Approach 2 "+diameter2(root).diam);
    }
}
