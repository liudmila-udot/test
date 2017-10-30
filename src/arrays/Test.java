package arrays;

import java.sql.SQLException;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class Test {
    // Нету throws: исключения не объявлены
    public static void main(String[] args) {
        doThrow(new SQLException());
    }

    static void doThrow(Exception e) {
        Test.<RuntimeException> doThrow0(e);
    }

    @SuppressWarnings("unchecked")
    static <E extends Exception> void doThrow0(Exception e) throws E {
        throw (E) e;
    }
}
