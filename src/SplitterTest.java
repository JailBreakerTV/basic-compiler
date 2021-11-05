
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class SplitterTest {
    public static void main(String[] args) {
        String resourceName = "inputs.in";
        try {
            final InputStream in = Interpreter.class.getClassLoader().getResourceAsStream(resourceName);
            if (in != null) {
                final InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
                final BufferedReader bufferedReader = new BufferedReader(reader);
                final String first = bufferedReader.readLine();
                final Integer line = asInteger(first);
                final StringBuilder builder = new StringBuilder();
                if (line != null) {
                    for (int i = 0; i < line; i++) {
                        String nextLine = bufferedReader.readLine();
                        builder.append(nextLine).append(" ");
                    }
                }
                List<String[]> a = splitToList(builder.toString().split(" "));
                System.out.println(splitToList(builder.toString().split(" ")).size());
                int commandnumber = 1;
                for (String[] x : a) {
                    System.out.println("BEGIN COMMAND " + commandnumber++);
                    for (String f : x) {
                        System.out.print(f + " ");
                    }
                    System.out.println("\n");
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static Integer asInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}