public class DynamicArray {
    int _capacity;
    int _length;
    int[] _arr;

    public DynamicArray(){
        _capacity = 2;
        _length = 0;
        _arr = new int[2];
    }

    // Insert n in the last position of the array
    public void pushback(int n){
        if (_length == _capacity) {
            this.resize();
        }
        // insert
        _arr[_length] = n;
        _length++;
    }

    public void resize() {
        // Create new array of double capacity
        _capacity = 2 * _capacity;
        int[] newArr = new int[_capacity];

        // Copy elements to newArr
        for (int i = 0; i < _length; i++){
            newArr[i] = _arr[i];
        }
        _arr = newArr;
    }

    // Remove the last element in the array
    public void popback() {
        if(_length > 0){
            _length--;
        }
    }

    // Get value at i-th index
    public int get(int i) {
        if (i < _length) {
            return _arr[i];
        }
        // here we would throw an out of bounds exception
        return -1;
    }

    // Insert n at i-th index
    public void insert(int i, int n){
        if (i < _length){
            _arr[i] = n;
            return;
        }
        return;
        // Here we would throw out of bounds exception
    }

    public void print() {
        for (int i = 0; i < _length; i++){
            System.out.println(_arr[i]);
        }
    }
}
