public class RBTree {
    node nil = new node();
    String inOrderString = "";
    node root = new node();
    String red = "red";
    String black = "black";

    public RBTree() {
        nil.setKey(null);
        nil.setColor(black);
        root.setKey(null);
        root.setColor(black);

    }

    public void insert(int zKey){
        node z = new node();
        z.setKey(zKey);
        node y = nil;
        node x = root;
        while(x.getKey()!= null){
            y = x;
            if(z.getKey() < x.getKey()){
                x = x.getLeft();
            }
            else{
                x = x.getRight();
            }
        }
        z.setParent(y);
        if (y == nil){
            root = z;
        }
        else if (z.getKey() < y.getKey()){
            y.setLeft(z);
        }
        else{
            y.setRight(z);
        }
        z.setLeft(nil);
        z.setRight(nil);
        z.setColor(red);
        insertFixUp(z);
    }

    public void insertFixUp(node z){
        while (z.getParent().getColor().equals(red)){
            if(z.getParent() == z.getParent().getParent().getLeft()){
                node y = z.getParent().getParent().getRight();
                if ( y.getColor().equals(red)){
                    z.getParent().setColor(black);
                    y.setColor(black);
                    z.getParent().getParent().setColor(red);
                    z = z.getParent().getParent();
                }
                else{
                    if ( z == z.getParent().getRight()){
                        z = z.getParent();
                        leftRotate(z);
                    }
                    z.getParent().setColor(black);
                    z.getParent().getParent().setColor(red);
                    rightRotate(z.getParent().getParent());
                }
            }
            else{
                node y = z.getParent().getParent().getLeft();
                if ( y.getColor().equals(red)){
                    z.getParent().setColor(black);
                    y.setColor(black);
                    z.getParent().getParent().setColor(red);
                    z = z.getParent().getParent();
                }
                else{
                    if (z == z.getParent().getLeft()){
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

    public void leftRotate(node x){
        node y = x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft() != nil){
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == nil){
            root = y;
        }
        else if (x == x.getParent().getLeft()){
            x.getParent().setLeft(y);
        }
        else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    public void rightRotate(node x){
        node y = x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight() != nil){
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == nil){
            root = y;
        }
        else if (x == x.getParent().getRight()){
            x.getParent().setRight(y);
        }
        else {
            x.getParent().setLeft(y);
        }
        y.setRight(x);
        x.setParent(y);
    }

    public Boolean find(int value){
        node current = root;
        boolean found = false;
        boolean search = true;
        while (search){
            if(root.getKey() == null){
                search = false;
            }
           else if ( value < current.getKey()){
                if (current.getLeft().getKey() != null){
                    current = current.getLeft();
                }
                else {
                    search = false;
                }
            }
            else if (value > current.getKey()){
                if (current.getRight().getKey() != null){
                    current = current.getRight();
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

    public node returnFind(Integer value){
        node current = root;
        boolean found = false;
        boolean search = true;
        while (search){
            if(root.getKey() == null){
                search = false;
            }
            else if ( value < current.getKey()){
                if (current.getLeft().getKey() != null){
                    current = current.getLeft();
                }
                else {
                    search = false;
                }
            }
            else if (value > current.getKey()){
                if (current.getRight().getKey() != null){
                    current = current.getRight();
                }
                else {
                    search = false;
                }
            }
            else{
                search = false;
                return current;
            }
        }
        return null;
    }

    public String InOrderString(node n) {
        if (n!= null) {
            if (n.getLeft()!= null) {
                this.InOrderString(n.getLeft());
            }

            if (n.getKey() != null) {
                inOrderString += "(" + n.getKey()  + "," + n.getColor() + ") ";
            }

            if (n.getRight()!= null) {
                this.InOrderString(n.getRight());
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

    public void transplant(node u, node v){
        if(u.getParent() == null){
            root = v;

        }
        else if (u == u.getParent().getLeft()){
            u.getParent().setLeft(v);
        }
        else{
            u.getParent().setRight(v);
        }

        v.setParent(u.getParent());
    }

    public node minimum(node x){
        while(x.getLeft() != nil){
            x = x.getLeft();
        }
        return x;
    }

    public void delete(Integer value){
    if(find(value)){
        node z = returnFind(value);
        node y = z;
        String yOriginalColor = black;
        node x = new node();

        if (z.getLeft() == nil){
            x = z.getRight();
            transplant(z,z.getRight());
        }
        else if (z.getRight() == nil){
            x = z.getLeft();
            transplant(z,z.getLeft());
        }
        else{
            y = minimum(z.getRight());
            yOriginalColor = y.getColor();
            x = y.getRight();
            if(y.getParent() == z){
                x.setParent(y);
            }
            else{
                transplant(y,y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }
            transplant(z,y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
            y.setColor(z.getColor());
        }
        if(yOriginalColor.equals(black)){
        deleteFixUp(x);
        }
    }
}

    public void deleteFixUp(node x){
    while(x != root && x.getColor().equals(black)){
        if(x == x.getParent().getLeft()){
            node w = x.getParent().getRight();
            if(w.getColor().equals(red)){
                w.setColor(black);
                x.getParent().setColor(red);
                leftRotate(x.getParent());
                w = x.getParent().getRight();
            }
            if(w.getLeft().getColor().equals(black) && w.getRight().getColor().equals(black)){
                w.setColor(red);
                x = x.getParent();
            }
            else{
                if(w.getRight().getColor().equals(black)){
                    w.getLeft().setColor(black);
                    w.setColor(red);
                    rightRotate(w);
                    w = x.getParent().getRight();
                }
                w.setColor(x.getParent().getColor());
                x.getParent().setColor(black);
                w.getRight().setColor(black);
                leftRotate(x.getParent());
                x = root;
            }
        }
        else {
            if(x == x.getParent().getRight()){
                node w = x.getParent().getLeft();
                if(w.getColor().equals(red)){
                    w.setColor(black);
                    x.getParent().setColor(red);
                    rightRotate(x.getParent());
                    w = x.getParent().getLeft();
                }
                if(w.getRight().getColor().equals(black) && w.getLeft().getColor().equals(black)){
                    w.setColor(red);
                    x = x.getParent();
                }
                else{
                    if(w.getLeft().getColor().equals(black)){
                        w.getLeft().setColor(black);
                        w.setColor(red);
                        leftRotate(w);
                        w = x.getParent().getLeft();
                    }
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor(black);
                    w.getLeft().setColor(black);
                    rightRotate(x.getParent());
                    x = root;
                }
            }
        }

    }
    x.setColor(black);
}


}
