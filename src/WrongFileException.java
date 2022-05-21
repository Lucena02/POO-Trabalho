package POOTrabalho.src;

public class WrongFileException extends Exception{

    public WrongFileException(){
        super();
    }

    public WrongFileException(String message){
        super(message);
    }
}
