package com.salimkhani.Modules;

public class Property <T>
{
    private T _type;
    public Property(T value)
    {
        _type = value;
    }
    public T get()
    {
        return _type;
    }
    public void set(T value)
    {
        _type = value;
    }
}
