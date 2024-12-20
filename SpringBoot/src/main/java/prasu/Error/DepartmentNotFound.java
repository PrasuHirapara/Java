package prasu.Error;

public class DepartmentNotFound extends Exception {

    public DepartmentNotFound(String message) {
        super(message);
    }

    public DepartmentNotFound() {
        super();
    }

    public DepartmentNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFound(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
