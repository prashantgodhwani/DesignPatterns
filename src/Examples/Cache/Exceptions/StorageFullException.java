package Examples.Cache.Exceptions;

public class StorageFullException extends RuntimeException{

    public StorageFullException(String exception){
        super(exception);
    }
}
