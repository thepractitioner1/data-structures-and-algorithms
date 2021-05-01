package com.company.misan;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {

    //Implementation of Hash Table using Linked list ahd chaining collision prevention algorithm

    private LinkedList<Entry>[] entries = new LinkedList[5];


    public void put(int key, String value) {
        var entry = new Entry(key, value);
        var index = hashFunction(key);

        if (entries[index] == null) {
            var bucket = new LinkedList<Entry>();
            bucket.add(entry);
            entries[index] = bucket;
        } else {
            var bucket = entries[index];
            var tempEntry = checkIfEntryExists(key);

            if (tempEntry == null) bucket.add(entry);
            else tempEntry.value = entry.value;

        }

    }

    public String get(int searchKey) {
        var entry = checkIfEntryExists(searchKey);
        if (entry == null) return null;
        else return entry.value;
    }

    public void remove(int searchKey) {
        if (entries.length == 0) throw new IllegalStateException("Element with Key value pair does not exist");

        var index = hashFunction(searchKey);
        var bucket = entries[index];
        if (checkIfEntryExists(searchKey) != null) {
            bucket.remove(checkIfEntryExists(searchKey));
            return;
        }
        throw new IllegalStateException("Element with key value pair does not exist");
    }

    private Entry checkIfEntryExists(int searchKey) {
        var index = hashFunction(searchKey);
        var bucket = entries[index];

        if (bucket != null) {
            for (Entry values : bucket) {
                if (values.key == searchKey) return values;
            }
        }
        return null;
    }


    private int hashFunction(int number) {
        return number % entries.length;
    }


    private class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "entries=" + Arrays.toString(entries) +
                '}';
    }
}
