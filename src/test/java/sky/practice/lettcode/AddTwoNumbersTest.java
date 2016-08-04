package sky.practice.lettcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * $explain$
 *
 * @author fei
 */
public class AddTwoNumbersTest {

//    输入: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    输出: 7 -> 0 -> 8
    @Test
    public void testAddTwoNumbers() throws Exception {
        AddTwoNumbers2.ListNode node1 = new AddTwoNumbers2.ListNode(2);
        node1.addAndPointNext(new AddTwoNumbers2.ListNode(4)).addAndPointNext(new AddTwoNumbers2.ListNode(3));

        AddTwoNumbers2.ListNode node2 = new AddTwoNumbers2.ListNode(5);
        node2.addAndPointNext(new AddTwoNumbers2.ListNode(6)).addAndPointNext(new AddTwoNumbers2.ListNode(4));

        AddTwoNumbers2.ListNode node = AddTwoNumbers2.addTwoNumbers(node1, node2);
        assertEquals(node.toString(),"708");
    }

    @Test
    public void testAddTwoNumbers2() throws Exception {
        AddTwoNumbers2.ListNode node1 = new AddTwoNumbers2.ListNode(1);

        AddTwoNumbers2.ListNode node2 = new AddTwoNumbers2.ListNode(9);
        node1.addAndPointNext(new AddTwoNumbers2.ListNode(9));

        AddTwoNumbers2.ListNode node = AddTwoNumbers2.addTwoNumbers(node1, node2);
        assertEquals(node.toString(),"001");
    }
}