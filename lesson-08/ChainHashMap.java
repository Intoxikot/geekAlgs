
public class ChainHashMap<Key, Value> {
	
    private int LIMIT;
    private int size;
    private Object[] st;
	
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.next = next;
            this.value = value;
        }
		
		@Override public String toString() { return key.toString() + " : " + value.toString() + " ";}
    }

	public ChainHashMap() {
		LIMIT = 10; // Ограничитель для хеш-кода - количество уникальных значений
		size = 0;
		st = new Object[LIMIT];
	}

    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
		
        int i = getHash(key);
        Node n = (Node) st[i]; // преобразует адресную ячейку в объект
        while (n != null) {
            if (key.equals(n.key)) // поиск совпадений по ключу в цепочке 
				return n.value;
            n = n.next;
        }
        return null; // совпадений не найдено - ключ отсутствует
    }
	
    public void put(Key key, Value value) {
        if (key == null)
            throw new IllegalArgumentException("key is null");
		
        int i = getHash(key);
        Node n = (Node) st[i];
        while (n != null) {
            if (key.equals(n.key)) { // если найдено совпадение по ключу, значение перезаписывается
                n.value = value;
                return;
            }
            n = n.next;
        }
        st[i] = new Node(key, value, (Node) st[i]); // иначе мы добавляем новый узел по полученному хешу
        size++;
    }
	
	public int size()					{ return size; }
	public boolean contains(Key key) 	{ return get(key) != null; }
    public boolean isEmpty()		 	{ return size == 0; }
	private int getHash(Key key)	 	{ return (key.hashCode() & 0x7fffffff) % LIMIT; } 
	
	@Override public String toString() {
		StringBuffer out = new StringBuffer();

		out.append(this.getClass().getName() + ": { " + '\n');
		for (int i = 0; i < LIMIT; i++) { // перебирать мап - не самая лучшая идея, но иногда надо
			Node n = (Node) st[i];
            while (n != null) { // помимо ячеек массива, необходимо перебрать и каждый список в ячейке
                String hash = "(hash#" + getHash(n.key) + ")"; // смотрим хеш
                out.append('\t' + n.toString() + hash + '\n');
                n = n.next;
            }
		}
		out.append("}");
		return out.toString();
	}
}