
import java.util.LinkedList;

public class HashTable{
    private LinkedList<Entry>[] table;
    private int size;
    private int table_size;

    private static class Entry{
        String key;
        int value;

        public Entry(String key, int value){
            this.key = key;
            this.value = value;
        }
    }
    public HashTable(int size){
        this.table_size = size;
        this.table = new LinkedList[table_size];
        for (int i = 0; i < table_size; i++){
            table[i] = new LinkedList<>();
        }
        this.size = 0;
    }

    private int hash(String key){
        return Math.abs(key.hashCode() % table_size);
    }

    public void put(String key, int value){
        int index = hash(key);
        LinkedList<Entry> list = table[index];
        for (Entry entry : list){
            if (entry.key.equals(index)){
                entry.value = value;
                return;
            }
        }
        list.add(new Entry(key, value));
        size++;
    }

    public Integer get(String key){
        int index = hash(key);
        LinkedList<Entry> list = table[index];
        for (Entry entry : list){
            if (entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }

    public void remove(String key){
        int index = hash(key);
        LinkedList<Entry> list = table[index];
        for (Entry entry : list){
            if (entry.key.equals(key)){
                list.remove(entry);
                size--;
                return;
            }
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.put("banana", 3);
        hashTable.put("pear", 2);
        hashTable.put("orange", 7);
        hashTable.put("apple", 5);

        System.out.println("Пустая таблица? - " + hashTable.isEmpty());
        System.out.println("Длина талицы: " + hashTable.size());
        
        System.out.println("banana: " + hashTable.get("banana"));
        System.out.println("orange: " + hashTable.get("orange"));

        hashTable.remove("banana");
        System.out.println("banana: " + hashTable.get("banana"));

        System.out.println("Длина талицы: " + hashTable.size());
        
    }
}
