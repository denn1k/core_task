package core_test;

public class NoSuchSerialException extends Exception{
    NoSuchSerialException() {
        super();
    }

 NoSuchSerialException (String message,int stasusCode)   {
     super(message);
     this.statusCode = statusCode;
 }

    private int statusCode;
}

