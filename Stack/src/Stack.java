import java.util.Random;

public class Stack {
    static final int MAX = 100;
    int top;
    int a[] ;
    int SIZE;
    Stack( int size){
        a = new int[size];
        top = -1;
        SIZE = size;
    }

    Stack(){
        a = new int[MAX];
        top = -1;
        SIZE = MAX;
    }

    boolean isEmpty()
    {
        return (top < 0);
    }

    boolean isFull() {
        return top >= (SIZE - 1) ;
    }


    boolean push(int x)
    {
        if (top >= (SIZE - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    int pop()
    {
        int indexOfPop  = -1;
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int maxFrequent = 0 ;
            int ans = -1;
            for(int i = 0; i< SIZE  ; i++){
                int current_freq = 1;
                for(int j =  i + 1 ; i < SIZE ; i++){
                    if(a[j] == a[i])
                    {
                        current_freq ++;
                    }

                    if(maxFrequent < current_freq){
                        maxFrequent = current_freq;
                        ans = a[i];
                    }

                }

            }


            for(int i = 0 ; i < SIZE ; i++){
                if(a[i] == ans){
                    indexOfPop = i;
                }
            }

        }
        int pop_el = a[indexOfPop];
        System.out.println(pop_el);
        a[indexOfPop] = new Random().nextInt(10);
        return pop_el;
    }

    int peek()
    {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = a[top];
            return x;
        }
    }
}

// Driver code
class Main {
    public static void main(String args[])
    {
        Stack s = new Stack();
        s.push(1);
        s.push(1);
        s.push(2);
        s.push(2);
        s.push(1);
        s.pop();
        s.pop();
        s.pop();
    }
}
