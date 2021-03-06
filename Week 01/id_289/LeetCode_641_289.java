package com.chief;

/**
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * <p>
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 * <p>
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_641_289 {

    class MyCircularDeque {
        int[] myqueue;
        int front;
        int rear;
        int size;
        int capacity;

        public MyCircularDeque(int k) {
            this.myqueue = new int[k];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
            this.capacity = k;
        }

        public boolean insertFront(int value) {
            if (rear == front && size == capacity) {
                return false;
            } else {
                front = (front + capacity - 1) % capacity;
                myqueue[front] = value;
                size++;
                return true;
            }
        }

        public boolean insertLast(int value) {
            if (rear == front && size == capacity) {
                return false;
            } else {
                myqueue[rear] = value;
                rear = (rear + 1 + capacity) % capacity;
                size++;
                return true;
            }

        }

        public boolean deleteFront() {
            if (rear == front && size == 0) {
                return false;
            } else {
                front = (front + 1) % capacity;
                size--;
                return true;
            }

        }

        public boolean deleteLast() {
            if (rear == front && size == 0) {
                return false;
            } else {
                rear = (rear - 1 + capacity) % capacity;
                size--;
                return true;
            }

        }

        public int getFront() {
            if ((rear == front) && size == 0) {
                return -1;
            } else {
                return myqueue[front];
            }
        }

        public int getRear() {
            if ((rear == front) && size == 0) {
                return -1;
            } else {
                return myqueue[(rear - 1 + capacity) % capacity];
            }

        }

        public boolean isEmpty() {
            return (rear == front) && size == 0;
        }

        public boolean isFull() {
            return rear == front && size == capacity;

        }
    }


}
