import java.util.ArrayList;
import java.util.List;

public class Stack {
    List<Integer> _stack;

    public Stack(){
        _stack = new ArrayList<>();
    }

    public void push(int n){
        _stack.add(n);
    }

    public void pop(){
        _stack.remove(_stack.size() - 1);
    }

    public int size() {
        return _stack.size();
    }
}
