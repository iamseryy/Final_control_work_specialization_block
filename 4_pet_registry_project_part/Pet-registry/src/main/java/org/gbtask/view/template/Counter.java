package org.gbtask.view.template;

import org.gbtask.exception.CloseCounterException;

import java.io.Closeable;

public class Counter implements AutoCloseable {
    private static int counter = 0;
    private boolean isOpen;

    public Counter(){
        this.isOpen = true;
    }

    public Counter(int count){
        this.counter = count;
        this.isOpen = true;
    }

    public int add() throws CloseCounterException{
        if(!isOpen){
            throw new CloseCounterException("The counter is closed");
        }
        return ++this.counter;
    }

    @Override
    public void close() {
        this.isOpen = false;
    }

    @Override
    public String toString() {
        return "" + this.counter;
    }
}
