package Generics;

//GENERIC CLASS
public class Pair<K,V>{

    public K key;
    public V value;

    public Pair(K key, V value){
        this.key=key;
        this.value=value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    static void main() {
        Pair<String,Integer>pair=new Pair<>("Prashant",25);
        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
    }
}


