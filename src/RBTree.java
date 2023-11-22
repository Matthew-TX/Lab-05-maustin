public class RBTree {
    Node nil = new Node();
    String inOrderString = "";
    Node root = new Node();
    String red = "red";
    String black = "black";

    public RBTree() {
        nil.setKey(null);
        nil.setColor(black);
        root.setKey(null);
        root.setColor(black);

    }

    public void insert(int zKey){
        Node z = new Node();
        z.setKey(zKey);
        Node y = nil;
        Node x = root;
        while(x.getKey()!= null){
            y = x;
            if(z.getKey() < x.getKey()){
                x = x.getLeftChild();
            }
            else{
                x = x.getRightChild();
            }
        }
        z.setParent(y);
        if (y == nil){
            root = z;
        }
        else if (z.getKey() < y.getKey()){
            y.setLeftChild(z);
        }
        else{
            y.setRightChild(z);
        }
        z.setLeftChild(nil);
        z.setRightChild(nil);
        z.setColor(red);
        insertFixUp(z);
    }

    public void insertFixUp(Node z){
        while (z.getParent().getColor().equals(red)){
            if(z.getParent() == z.getParent().getParent().getLeftChild()){
                Node y = z.getParent().getParent().getRightChild();
                if ( y.getColor().equals(red)){
                    z.getParent().setColor(black);
                    y.setColor(black);
                    z.getParent().getParent().setColor(red);
                    z = z.getParent().getParent();
                }
                else{
                    if ( z == z.getParent().getRightChild()){
                        z = z.getParent();
                        leftRotate(z);
                    }
                    z.getParent().setColor(black);
                    z.getParent().getParent().setColor(red);
                    rightRotate(z.getParent().getParent());
                }
            }
            else{
                Node y = z.getParent().getParent().getLeftChild();
                if ( y.getColor().equals(red)){
                    z.getParent().setColor(black);
                    y.setColor(black);
                    z.getParent().getParent().setColor(red);
                    z = z.getParent().getParent();
                }
                else{
                    if (z == z.getParent().getLeftChild()){
                        z = z.getParent();
                        rightRotate(z);
                    }
                    z.getParent().setColor(black);
                    z.getParent().getParent().setColor(red);
                    leftRotate(z.getParent().getParent());
                }
            }
        }
        root.setColor(black);
    }

    public void leftRotate(Node x){
        Node y = x.getRightChild();
        x.setRightChild(y.getLeftChild());
        if (y.getLeftChild() != nil){
            y.getLeftChild().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == nil){
            root = y;
        }
        else if (x == x.getParent().getLeftChild()){
            x.getParent().setLeftChild(y);
        }
        else {
            x.getParent().setRightChild(y);
        }
        y.setLeftChild(x);
        x.setParent(y);
    }

    public void rightRotate(Node x){
        Node y = x.getLeftChild();
        x.setLeftChild(y.getRightChild());
        if (y.getRightChild() != nil){
            y.getRightChild().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == nil){
            root = y;
        }
        else if (x == x.getParent().getRightChild()){
            x.getParent().setRightChild(y);
        }
        else {
            x.getParent().setLeftChild(y);
        }
        y.setRightChild(x);
        x.setParent(y);
    }

    public Boolean find(int value){
        Node current = root;
        boolean found = false;
        boolean search = true;
        while (search){
            if(root.getKey() == null){
                search = false;
            }
           else if ( value < current.getKey()){
                if (current.getLeftChild().getKey() != null){
                    current = current.getLeftChild();
                }
                else {
                    search = false;
                }
            }
            else if (value > current.getKey()){
                if (current.getRightChild().getKey() != null){
                    current = current.getRightChild();
                }
                else {
                    search = false;
                }
            }
            else{
                found = true;
                search = false;
            }
        }
        return found;
    }

    public String InOrderString(Node n) {
        if (n!= null) {
            if (n.getLeftChild()!= null) {
                this.InOrderString(n.getLeftChild());
            }

            if (n.getKey() != null) {
                inOrderString += "(" + n.getKey()  + "," + n.getColor() + ")" + " , ";
            }

            if (n.getRightChild()!= null) {
                this.InOrderString(n.getRightChild());
            }
            n = root;
            return inOrderString;
        } else {
            return null;
        }

    }

    public String displayInOrder() {
        inOrderString = "(Value,Color) : ";
        String displayInOrder = this.InOrderString(root);
        inOrderString = "";
        return displayInOrder;
    }

}
