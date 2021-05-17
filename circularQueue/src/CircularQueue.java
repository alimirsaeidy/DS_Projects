import java.util.*;


public class CircularQueue {
    // Declaring the class variables.
    private int size, front, rear;

    // Declaring array list of integer type.
    private ArrayList<String> queue = new ArrayList<String>();

    // Constructor

    CircularQueue()
    {
        this.size = 100;
        this.front = this.rear = -1;
    }
    CircularQueue(int size)
    {
        this.size = size;
        this.front = this.rear = -1;
    }

    // Method to insert a new element in the queue.
    public void enQueue(String data)
    {

        // Condition if queue is full.
        if((front == 0 && rear == size - 1) ||
                (rear == (front - 1) % (size - 1)))
        {
            System.out.print("Queue is Full");
        }

        // condition for empty queue.
        else if(front == -1)
        {
            front = 0;
            rear = 0;
            queue.add(rear, data);
        }

        else if(rear == size - 1 && front != 0)
        {
            rear = 0;
            queue.set(rear, data);
        }

        else
        {
            rear = (rear + 1);

            // Adding a new element if
            if(front <= rear)
            {
                queue.add(rear, data);
            }

            // Else updating old value
            else
            {
                queue.set(rear, data);
            }
        }
    }

    public String deQueue()
    {
        String temp;

        // Condition for empty queue.
        if(front == -1)
        {
            System.out.print("Queue is Empty");

            // Return -1 in case of empty queue
            return "empty ";
        }

        temp = queue.get(front);

        // Condition for only one element
        if(front == rear)
        {
            front = -1;
            rear = -1;
        }

        else if(front == size - 1)
        {
            front = 0;
        }
        else
        {
            front = front + 1;
        }

        // Returns the dequeued element
        return temp;
    }

    public boolean isFull(){
        return  (front == 0 && rear == size - 1) ||
                (rear == (front - 1) % (size - 1));
    }

    public boolean isEmpty(){
        return front == -1 ;
    }


    // Method to display the elements of queue
    public void displayQueue()
    {

        // Condition for empty queue.
        if(front == -1)
        {
            System.out.print("Queue is Empty");
            return;
        }

        // If rear has not crossed the max size
        // or queue rear is still greater then
        // front.
        System.out.print("Elements in the " +
                "circular queue are: ");

        if(rear >= front)
        {

            // Loop to print elements from
            // front to rear.
            for(int i = front; i <= rear; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }

        // If rear crossed the max index and
        // indexing has started in loop
        else
        {

            // Loop for printing elements from
            // front to max size or last index
            for(int i = front; i < size; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }

            // Loop for printing elements from
            // 0th index till rear position
            for(int i = 0; i <= rear; i++)
            {
                System.out.print(queue.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        CircularQueue q = new CircularQueue(6);
        String process = "P0 3,P1 2,P2 1";
        String[] x = process.split(",");
        String[] processID = new String[x.length];
        int[] processN = new int[x.length];

        Map<String,Integer> y = new HashMap<>();
        for(int i = 0 ; i< x.length ; i++){
            y.put(x[i].substring(0,2) , Integer.parseInt(x[i].substring(3)));
            processID[i] = (x[i].substring(0,2));
            processN[i] = Integer.parseInt(x[i].substring(3));
        }

        int iterate = 0;
        for (String s : processID)
            iterate += y.get(s);



        String[] enqueueElements = new String[iterate];


        int elements = 0;

            while(true) {

                if(elements > 5)
                    break;

                if (processN[0] > 0) {
                    enqueueElements[elements] = processID[0];
                    processN[0] = (processN[0] -1 );
                    elements++;
                }
                if (processN[1] > 0) {
                    enqueueElements[elements] = processID[1];
                    processN[1] = (processN[1] -1 );
                    elements++;
                }
                if (processN[2] > 0) {
                    enqueueElements[elements] = processID[2];
                    processN[2] = (processN[2] -1 );
                    elements++;
                }


            }

            for(String el : enqueueElements)
                q.enQueue(el);

            q.displayQueue();


    }
}



