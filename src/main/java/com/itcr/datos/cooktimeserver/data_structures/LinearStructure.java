package com.itcr.datos.cooktimeserver.data_structures;

/**
 * Superclass made to add length to Lists and Stack
 */
public abstract class LinearStructure {

    protected int length;

    /**
     * Returns the length of the structure. Used on every structure.
     * @return length
     */
    public int getLength() {
        return length;
    }
}
