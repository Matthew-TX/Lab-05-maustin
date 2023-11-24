import org.junit.Assert;

public class RBTest {
    @org.junit.Test
    public void RBtoString(){
        RBTree tree = new RBTree();

        //Test Empty Tree
        String expected = "(Value,Color) : ";
        Assert.assertEquals(expected, tree.displayInOrder());

        //Test Occupied Tree
        tree.insert(10);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(9);
        tree.insert(11);
        tree.insert(7);
        tree.insert(1);
        tree.insert(0);

        expected = "(Value,Color) : (0,red) (1,black) (2,red) (4,black) (5,black) (7,red) (9,red) (10,black) (11,red) ";
        Assert.assertEquals(expected, tree.displayInOrder());
    }

    @org.junit.Test
    public void Insert(){
        RBTree tree = new RBTree();

        //Test Empty Tree
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

        //Test Occupied Tree
        expected = "(Value,Color) : (0,red) (1,black) (2,red) (4,black) (5,black) (7,red) (9,red) (10,black) (11,red) ";
        Assert.assertEquals(expected, tree.displayInOrder());
    }

    @org.junit.Test
    public void Find(){
        RBTree tree = new RBTree();
        boolean t = true;
        boolean f = false;

        //Find in an empty tree
        Assert.assertEquals(f, tree.find(10));

        //Find the root
        tree.insert(10);
        Assert.assertEquals(t, tree.find(10));

        //Find after inserting a few more elements
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(9);
        tree.insert(11);
        tree.insert(7);
        tree.insert(1);
        tree.insert(0);
        tree.find(11);
        Assert.assertEquals(t, tree.find(7));

        //Find Negative
        tree.insert(-10);
        tree.find(-10);
        Assert.assertEquals(t, tree.find(-10));
    }
    @org.junit.Test
    public void Delete(){
        RBTree tree = new RBTree();
        boolean t = true;
        boolean f = false;

        //Find after inserting a few more elements
        tree.insert(10);
        tree.insert(2);
        tree.insert(4);
        tree.insert(5);
        tree.insert(9);
        tree.insert(11);
        tree.insert(7);
        tree.insert(1);
        tree.insert(0);

        Assert.assertEquals(t, tree.find(9));
        tree.delete(9);
        Assert.assertEquals(f, tree.find(9));
    }
}
