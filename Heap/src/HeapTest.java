import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void checkPeekPoll() throws Exception {
        Heap h = new Heap();
        h.add(0);
        h.add(1);
        h.add(3);
        h.add(2);
        h.add(4);
        h.add(5);
        h.add(6);
        h.add(7);
        h.add(8);
        h.add(9);
        h.add(10);
        h.add(11);

        assertEquals(h.peek(), 0);
        assertEquals(h.poll(), 0);

        assertEquals(h.peek(), 1);
        assertEquals(h.poll(), 1);

        assertEquals(h.peek(), 2);
        assertEquals(h.poll(), 2);

        assertEquals(h.peek(), 3);
        assertEquals(h.poll(), 3);
    }

    @Test
    public void checkListConstructor() throws Exception {
        int[] l = new int[4];
        l[0] = 3;
        l[1] = 1;
        l[2] = 2;
        l[3]=-2;
        Heap h = new Heap(l);
        assertEquals(h.peek(), -2);
        assertEquals(h.poll(), -2);

        assertEquals(h.peek(), 1);
        assertEquals(h.poll(), 1);

        assertEquals(h.peek(), 2);
        assertEquals(h.poll(), 2);

        assertEquals(h.peek(), 3);
        assertEquals(h.poll(), 3);
    }

    @Test
    public void checkSorting() throws Exception {
        List l1 = new List();
        l1.addLast(0);
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);
        l1.addLast(6);
        l1.addLast(7);
        l1.addLast(8);
        l1.addLast(9);
        l1.addLast(10);
        l1.addLast(11);
        l1.sort();

        Heap h = new Heap();
        h.add(0);
        h.add(1);
        h.add(3);
        h.add(2);
        h.add(4);
        h.add(5);
        h.add(6);
        h.add(7);
        h.add(8);
        h.add(9);
        h.add(10);
        h.add(11);
        assertEquals(h.toList().toString(), l1.toString());
    }

    @Test(expected = Exception.class)
    public void checkPeekException() throws Exception {
        Heap h = new Heap();
        h.peek();
    }

    @Test(expected = Exception.class)
    public void checkPollException() throws Exception {
        Heap h = new Heap();
        h.poll();
    }
}