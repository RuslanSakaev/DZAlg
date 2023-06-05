import java.util.LinkedList;

public class HashMapCustom<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private LinkedList<Node<K, V>>[] table;
    private int size;

    public HashMapCustom() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    public V put(K key, V value) {
        if (key == null) {
            // Обработка случая, когда ключ равен null
            return putForNullKey(value);
        }

        int hashCode = key.hashCode();
        int index = hashCode % table.length;

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        LinkedList<Node<K, V>> bucket = table[index];
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                V oldValue = node.value;
                node.value = value; // Если ключ уже существует, обновляем значение
                return oldValue;
            }
        }

        bucket.add(new Node<>(key, value));
        size++;

        // Проверка загрузки и расширение таблицы при необходимости
        if ((double) size / table.length >= DEFAULT_LOAD_FACTOR) {
            resizeTable();
        }

        return null;
    }

    public V get(K key) {
        if (key == null) {
            // Обработка случая, когда ключ равен null
            return getForNullKey();
        }

        int hashCode = key.hashCode();
        int index = hashCode % table.length;

        LinkedList<Node<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }

        return null;
    }

    public V remove(K key) {
        if (key == null) {
            // Обработка случая, когда ключ равен null
            return removeForNullKey();
        }

        int hashCode = key.hashCode();
        int index = hashCode % table.length;

        LinkedList<Node<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    V removedValue = node.value;
                    bucket.remove(node);
                    size--;
                    return removedValue;
                }
            }
        }

        return null;
    }

    public V replace(K key, V newValue) {
        if (key == null) {
            // Обработка случая, когда ключ равен null
            return replaceForNullKey(newValue);
        }

        int hashCode = key.hashCode();
        int index = hashCode % table.length;

        LinkedList<Node<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    V oldValue = node.value;
                    node.value = newValue;
                    return oldValue;
                }
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            // Обработка случая, когда ключ равен null
            return containsKeyForNullKey();
        }

        int hashCode = key.hashCode();
        int index = hashCode % table.length;

        LinkedList<Node<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsValue(V value) {
        for (LinkedList<Node<K, V>> bucket : table) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    if (node.value.equals(value)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private V putForNullKey(V value) {
        int index = 0;

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        LinkedList<Node<K, V>> bucket = table[index];
        for (Node<K, V> node : bucket) {
            if (node.key == null) {
                V oldValue = node.value;
                node.value = value; // Если ключ уже существует, обновляем значение
                return oldValue;
            }
        }

        bucket.add(new Node<>(null, value));
        size++;

        // Проверка загрузки и расширение таблицы при необходимости
        if ((double) size / table.length >= DEFAULT_LOAD_FACTOR) {
            resizeTable();
        }

        return null;
    }

    private V getForNullKey() {
        int index = 0;

        LinkedList<Node<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key == null) {
                    return node.value;
                }
            }
        }

        return null;
    }

    private V removeForNullKey() {
        int index = 0;

        LinkedList<Node<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key == null) {
                    V removedValue = node.value;
                    bucket.remove(node);
                    size--;
                    return removedValue;
                }
            }
        }

        return null;
    }

    private V replaceForNullKey(V newValue) {
        int index = 0;

        LinkedList<Node<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key == null) {
                    V oldValue = node.value;
                    node.value = newValue;
                    return oldValue;
                }
            }
        }

        return null;
    }

    private boolean containsKeyForNullKey() {
        int index = 0;

        LinkedList<Node<K, V>> bucket = table[index];
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key == null) {
                    return true;
                }
            }
        }

        return false;
    }

    private void resizeTable() {
        int newCapacity = table.length * 2;
        LinkedList<Node<K, V>>[] newTable = new LinkedList[newCapacity];

        for (LinkedList<Node<K, V>> bucket : table) {
            if (bucket != null) {
                for (Node<K, V> node : bucket) {
                    int index = node.key == null ? 0 : node.key.hashCode() % newCapacity;

                    if (newTable[index] == null) {
                        newTable[index] = new LinkedList<>();
                    }

                    newTable[index].add(node);
                }
            }
        }

        table = newTable;
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
