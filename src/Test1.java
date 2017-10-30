import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public class Test1 {

    private static final String IP_REGEXP = "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.)){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
    private static final Pattern ROUTE_PATTERN =
        Pattern.compile("^(" + IP_REGEXP + "|default" + ")[\\s]+(" + IP_REGEXP + "|\\*" +
            ")[\\s]+(" + IP_REGEXP + ")[\\s]+(\\S+)[\\s]+(\\S+)[\\s]+(\\S+)[\\s]+(\\S+)[\\s]+(\\S+)\\r*$");

    public static String hello(String name) {
        System.out.println(System.currentTimeMillis() + " > hello " + name);
        return "Hello " + name;
    }
    public static String planet(String name) {
        System.out.println(System.currentTimeMillis() + " > planet " + name);
        return "Planet: " + name;
    }
    public static String echo(String name) {
        System.out.println(System.currentTimeMillis() + " > echo " + name);
        return name;
    }

    public static void main(String[] args) {
        int x=33333333;

        //System.out.println(x+=1.0f);
        System.out.println((x+1.0f));

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> planet("Earth"));
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> echo("Where is my echo?"));
    }

}
