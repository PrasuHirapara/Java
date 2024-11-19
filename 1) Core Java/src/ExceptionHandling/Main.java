package ExceptionHandling;

public class Main {
    public static void main(String[] args) {
        try{
            Exception mainException = new Exception("Exception", new Throwable("Cause of exception"));
            Exception suppressedException = new Exception("Suppressed Exception");
            suppressedException.addSuppressed(mainException);

            throw mainException;
        }catch (Exception e){
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
//            e.printStackTrace();  // Stack trace

            // Retrieve and display suppressed exceptions
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed: " + t);
            }
        }

        try {
            throw new CustomException("Custom exception");
        }catch (Exception e){
            System.out.println("Message: " + e.getMessage());
        }finally {
            System.out.println("Will execute always");
        }
    }
}
