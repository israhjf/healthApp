package israel.healthapp.dao;

public class DataAccessException extends Exception{
    DataAccessException(String message){
        super(message);
    }
    DataAccessException(){
        super();
    }
}
