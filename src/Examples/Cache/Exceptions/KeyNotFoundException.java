package Examples.Cache.Exceptions;

public class KeyNotFoundException extends RuntimeException{
    public KeyNotFoundException(String s) {
        super(s);
    }
}
