class Tree_Node_1{
    Integer data;
    Tree_Node_1 left, right;

    public Tree_Node_1(Integer data){
        this.data = data;
    }

    public void insert(Integer value){
        if(value < data){
            if(left == null){
                left = new Tree_Node_1(value);
            }else{
                left.insert(value);
            }
        }else if(value > data){
            if( right == null){
                right = new Tree_Node_1(value);
            }else{
                right.insert(value);
            }
        }
    }

    public void inorderTraverse(){
        if( left != null){
            left.inorderTraverse();
        }
        System.out.println(data);
        if( right != null){
            right.inorderTraverse();
        }
    }
}

public class Tree_practice {

    public static void main(String[] args) {
        
        Tree_Node_1 root = new Tree_Node_1(50);
        root.insert(10);
        root.insert(55);
        root.insert(5);
        root.insert(35);

        root.inorderTraverse();

    }
    
}
