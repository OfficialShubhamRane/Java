public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode( int data){
        this.data = data;
    }

    public void insert(int value){
        if(data > value){
             if(left == null){
                left = new TreeNode(value);
             }else{
                left.insert(value);
             }
        }else{
            if(right == null){
                right = new TreeNode(value);
            }else{
                right.insert(value);
            }
        }
    }

    public void inorderTraversal(){
        if(left != null){
           left.inorderTraversal();  
        }
        System.out.println(data);
        if(right != null){
            right.inorderTraversal();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.insert(10);
        root.insert(55);
        root.insert(5);
        root.insert(35);

        root.inorderTraversal();
    }
}
