import org.junit.Assert;

public class RBTest {
    @org.junit.Test
    public void RBtoString(){

    }
    @org.junit.Test
    public void Insert(){
        RBTree tree = new RBTree();
        String expected = "(Value,Color) : ";
        Assert.assertEquals(expected, tree.displayInOrder());

        tree.insert(10);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(9);
        tree.insert(11);
        tree.insert(7);
        tree.insert(1);
        tree.insert(0);

        expected = "(Value,Color) : (0,red) , (1,black) , (2,red) , (4,black) , (5,black) , (7,red) , (9,red) , (10,black) , (11,red) , ";
        Assert.assertEquals(expected, tree.displayInOrder());
    }
    @org.junit.Test
    public void Find(){

    }
    @org.junit.Test
    public void Delete(){

    }
}
