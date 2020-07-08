package com.itcr.datos.cooktimeserver.data_structures;

/**
 * LinkedList where each Node contains a reference to the next
 * @param <T> Data type on Nodes
 */
public class SinglyList<T> extends LinkedList<T> {

    /**
     * Deletes all the contents of the list by setting its head to null
     */
    @Override
    public void clear() {
        this.head = null;
        length = 0;
    }

    /**
     * Gets the first element of the list
     * @return first element of the list
     */
    @Override
    public SinglyNode<T> getHead() {
        return (SinglyNode<T>) head;
    }

    /**
     * Gets the node on the index position. Used on CircularList
     * @param index where Node is located
     * @return node on index
     */
    @Override
    public SinglyNode<T> get(int index) {
        if (index >= getLength() || index < 0) {
            System.out.println("Index out of range");
            return null;
        } else {
            SinglyNode<T> currentNode = (SinglyNode<T>) this.head;
            for (int i = 0; i < index; i++) {
                currentNode = (SinglyNode<T>) currentNode.getNext();
            }
            return currentNode;
        }
    }

    /**
     * Returns index where the data is located
     * @param data info stored on list
     * @return index where data is located
     */
    public int getIndexByData(T data) {
        SinglyNode<T> currentNode = (SinglyNode<T>) this.head;
        int index = 0;
        for (int i = 0; currentNode != null; i++) {
            if (currentNode.getData() == data) {
                index = i;
                break;
            } else if (currentNode.getNext() == null) {
                System.out.println("Not found");
                index = 404;
                break;
            } else {
                currentNode = (SinglyNode<T>) currentNode.getNext();
            }
        }
        return index;
    }

    /**
     * Return the node which has the next reference that points to null
     * @return Last node on list
     */
    @Override
    public SinglyNode<T> getLast() {
        SinglyNode<T> lastNode = (SinglyNode<T>) this.head;
        while (lastNode.getNext() != null) {
            lastNode = (SinglyNode<T>) lastNode.getNext();
        }
        return lastNode;
    }

    /**
     * Adds a node to the end of the list using getLast() method
     * @param data info to be added on List
     */
    @Override
    public void add(T data) {
        // Create a new node with given data
        SinglyNode<T> newNode = new SinglyNode<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            // Else traverse till the last node and insert the newNode there
            SinglyNode<T> lastNode = getLast();
            // Insert the newNode at last node
            lastNode.setNext(newNode);
        }
        length++;
    }

    /**
     * Adds the node wherever the index says it has to be added by setting the next references of the previous an next
     * nodes that will be surrounding it
     * @param data info to be added on List
     * @param index where the Node will be added
     */
    @Override
    public void add(T data, int index) {
        SinglyNode<T> newNode = new SinglyNode<>(data);
        if (index >= getLength()) {
            System.out.println("Index out of range");
            return;
        } else if (this.head == null) {
            this.head = newNode;
        } else {
            SinglyNode<T> nodeNext = get(index);
            newNode.setNext(nodeNext);
            if (index > 0) {
                SinglyNode<T> nodePrevious = get(--index);
                nodePrevious.setNext(newNode);
            } else {
                this.head = newNode;
            }
        }
        length++;
    }

    /**
     * Removes the node on index, connecting the next reference of the previous to its next
     * @param index where Node to be removed is located
     */
    @Override
    public void remove(int index) {
        if (index >= getLength()) {
            System.out.println("Index out of range");
        } else if (index == 0) {
            this.head = (this.head).getNext();
            length--;
        } else if (get(index).getNext() == null) {
            get(--index).setNext(null);
            length--;
        } else {
            SinglyNode<T> nodeIndex = get(index);
            SinglyNode<T> nodePrevious = get(--index);
            nodePrevious.setNext(nodeIndex.getNext());
            length--;
        }
    }

    /**
     *Swaps the values in the positions specified
     * @param pos1 position of one of the nodes
     * @param pos2 another position for one of the nodes
     */
    public void swap(int pos1, int pos2){
        if (pos1 >= this.length || pos2 >= this.length){
            throw new IllegalArgumentException("The index is out of range");
        }
        SinglyNode<T> tmp = new SinglyNode<T>(this.get(pos1).getData());
        this.get(pos1).setData(this.get(pos2).getData());
        this.get(pos2).setData(tmp.getData());

    }

    /**
     * Method for splitting the list between two values
     * @param pos1 position where the split starts
     * @param pos2 position where the split ends
     * @return returns the new list 
     */
    public SinglyList<T> split(int pos1, int pos2){
        SinglyList<T> result = new SinglyList<>();
        if (pos1 >= this.length || pos2 >= this.length){
            throw new IllegalArgumentException("The index is out of range");
        }
        if (pos1 > pos2){
            throw new IllegalArgumentException("Error with the indexes");
        }
        while (pos1 != pos2){
            result.add(this.get(pos1).getData());
            pos1++;
        }
        result.add(this.get(pos2).getData());
        return result;

    }

}

