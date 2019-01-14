import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class BSTTest {

    private void init(BST b) {
        b.add(5);
        b.add(10);
        b.add(27);
        b.add(54);
        b.add(24);
        b.add(4);
        b.add(6);
        b.add(0);
        b.add(-1);
        b.add(100);
    }

    @Test
    public void testAdd() {
        BST b = new BST();
        init(b);

        assertEquals(5, b.root.element);
    }

    @Test
    public void testDelete() {
        BST b = new BST();
        init(b);

        b.delete(5);
        assertEquals(6, b.root.element);

        b.delete(6);
        assertEquals(10, b.root.element);
    }

    @Test
    public void testDelete2() {
        BST b = new BST();
        b.add(10);
        b.delete(10);
        assertEquals(null, b.root);
    }

    @Test
    public void testSearch() {
        BST b = new BST();
        init(b);
        assertTrue(b.search(5));
        assertTrue(b.search(100));
        assertFalse(b.search(101));
    }

    @Test
    public void testInorder() {
        BST b = new BST();
        init(b);
        assertEquals(new LinkedList<>(Arrays.asList(-1, 0, 4, 5, 6, 10, 24, 27, 54, 100)), b.inorder());
    }

    @Test
    public void testPostorder() {
        BST b = new BST();
        init(b);
        assertEquals(new LinkedList<>(Arrays.asList(-1, 0, 4, 6, 24, 100, 54, 27, 10, 5)), b.postorder());
    }

    @Test
    public void testPreorder() {
        BST b = new BST();
        init(b);
        assertEquals(new LinkedList<>(Arrays.asList(5, 4, 0, -1, 10, 6, 27, 24, 54, 100)), b.preorder());
    }

    @Test
    public void testBFS() {
        BST b = new BST();
        init(b);
        assertEquals(new LinkedList<>(Arrays.asList(5, 4, 10, 0, 6, 27, -1, 24, 54, 100)), b.BFS());
    }

    @Test
    public void testDelete3() {
        BST b = new BST();
        b.add(5);
        b.add(-1);
        b.add(8);
        b.add(6);
        b.add(7);

        b.delete(5);
        assertEquals(6, b.root.element);

        assertEquals(b.root.right.left.element, 7);
    }
}