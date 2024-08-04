public class HashMap {
    int _size;
    int _capacity;
    Pair[] _map;

    public HashMap() {
        _size = 0;
        _capacity = 2;
        _map = new Pair[2];
    }

    public int hash(String key){
        int index = 0;
        for (int i = 0; i < key.length(); i++){
            index+= (int) key.charAt(i);
        }
        return index % this._capacity;
    }

    public String get(String key) {
        int index = hash(key);
        while (_map[index] != null){
            if (_map[index].key.equals(key)){
                return _map[index].val;
            }
            index++;
            index = index % this._capacity;
        }
        return null;
    }

    public void put(String key, String val){
        int index = hash(key);

        while (true){
            if(_map[index] == null){
                _map[index] = new Pair(key, val);
                _size++;
                if (_size >= _capacity/2) {
                    this.rehash();
                }
                return;
            } else if (_map[index].key == key){
                _map[index].val = val;
                return;
            }
            index++;
            index = index / _capacity;
        }
    }

    public void remove(String key){
        if (get(key) == null) {
            return;
        }

        int index = hash(key);
        while (true) {
            if (_map[index].key.equals(key)){
                _map[index] = null;
                _size--;
                return;
            }
            index++;
            index = index % _capacity;
        }
    }

    public void rehash() {
        _capacity = 2 * _capacity;
        Pair[] newMap = new Pair[_capacity];

        Pair[] oldMap = _map;
        _map = newMap;
        _size = 0;
        for (Pair p : oldMap){
            if(p != null){
                this.put(p.key, p.val);
            }
        }
    }

    public void print(){
        for (Pair p : _map){
            if (p != null) {
                System.out.println(p.key + " " + p.val);
            }
        }
    }
}
