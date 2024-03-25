package queues;

import exceptions.PilhaVaziaException;

public interface IQueue {    
    public int size();    
    public boolean isEmpty();
    public Object top() throws PilhaVaziaException;
    public void push(Object o);
    public Object pop() throws PilhaVaziaException;
}