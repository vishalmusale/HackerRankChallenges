	public void insert(int val) {
        if(root == null){
            root = new Node(val);
        }
        else
            Insertion(root, val);
    }

    public void Insertion(Node root, int val){
        if(root.val > val){                 //  Root_Value > New_Value
            if(root.left != null)           //  Checks if Left Node is empty or not.
                Insertion(root.left, val);  //  Recursive Call to Left Child Node
            else{
                root.left = new Node(val);  //  Creates new Node and Adds Value in it.
            }
        }
        else if(root.val < val){            //  Root_Value < New_Value
            if(root.right != null)          //  Checks if Right Node is empty or not.
                Insertion(root.right, val); //  Recursive Call to Right Child Node
            else{
                root.right = new Node(val); //  Creates new Node and Adds Value in it.
            }
        }
        else if(root.val == val){           //  Root_Value = New_Value
            if(root.mid != null)            //  Checks if Middle Node is empty or not.
                Insertion(root.mid, val);   //  Recursive Call to Middle Child Node
            else{
                root.mid = new Node(val);   //  Creates new Node and Adds Value in it.
            }
        }
    }