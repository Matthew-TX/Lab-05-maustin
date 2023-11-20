public class RBTree {
    Node nil = null;
    Node root = null;
    /*
    RB-INSERT.T; ´/
1 y D T:nil
2 x D T:root
3 while x ¤ T:nil
4 y D x
5 if z:key < x:key
6 x D x:left
7 else x D x:right
8 ´:p D y
9 if y = = T:nil
10 T:root D ´
11 elseif ´:key < y:key
12 y:left D ´
13 else y:right D ´
14 ´:left D T:nil
15 ´:right D T:nil
16 ´:color D RED
17 RB-INSERT-FIXUP.T; ´/
     */
    public void Insert(Integer zKey){
        Node z = new Node();
        z.setKey(zKey);
        Node y = nil;
        Node x = root;
        while(x!=nil){
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
        z.setColor("red");
    }

    public void InsertFixUp (Node z){

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

}
