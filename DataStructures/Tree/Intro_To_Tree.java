class Tree_Node{
    Integer data;
    Tree_Node left;
    Tree_Node right;

    public Tree_Node(Integer data){
        this.data = data;
    }

    public boolean contains(int value) {

        if(value == data){
            return true;
        }else if(value < data){
            if(left == null){
                return false;
            }else{
                return left.contains(value);
            }
           
        }else if(value > data){
            if(right == null){
                return false;
            }else {
                return right.contains(value);
            }
        }
        return false;
    }

    public void insert(int value) {
        
        if( value < data ){ 
            if( left == null){
                left = new Tree_Node(value);
            }else{
                left.insert(value);
            }
        }
        else if( value > data){
            if( right == null){
                right = new Tree_Node(value);
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
        
        if(right!=null){
            right.inorderTraversal();
        }

    }
}

class Intro_To_Tree{

    public static void main(String[] args) {
  
        Tree_Node obj = new Tree_Node(100);
        obj.insert(10);
        obj.insert(20);
        obj.insert(30);
        obj.insert(40);
        obj.insert(50);
        obj.contains(30);
        obj.inorderTraversal();
        
    }

}