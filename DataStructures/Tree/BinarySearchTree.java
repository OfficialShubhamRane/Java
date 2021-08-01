public class BinarySearchTree {

    TreeNode root;

    public boolean insert( int data ){

        if( root.data < data ){
            if(root.left == null){
                root.left = new TreeNode(data);
                return true;
            }else{
                return insert(data);
            }
        }else if ( root.data > data ){
            if(root.right == null){
                root.right = new TreeNode(data);
                return true;
            }else{
                return insert(data);
            }
        }
        return true;
    }

    // public boolean contains( int data ){
        // return true;
    // }

    public static void main(String[] args) {
        BinarySearchTree obj = new BinarySearchTree();
        obj.insert(50);
        obj.insert(10);
        obj.insert(45);
        obj.insert(70);
        obj.insert(90);
        obj.insert(5);
        obj.insert(75);
    }
}
