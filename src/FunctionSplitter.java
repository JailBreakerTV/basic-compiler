
import java.util.ArrayList;
import java.util.List;

public class FunctionSplitter {
    public static List<String[]> splitToList(String[] multicommand) {
        List<String[]> result = new ArrayList<>();
        List<String> function = new ArrayList<>();
        function.add("start");
        int depth = 1;
        //i = 1 damit start??
        for (int i = 1; i < multicommand.length; i++) {
            final String value = multicommand[i];
            if (value.equals("if")) {
                depth = depth + 2;
            }
            function.add(value);
            if (value.equals("end")) {
                depth--;
            }
            if (depth == 0) {
                result.add(function.toArray(new String[0]));
                function = new ArrayList<>();
                function.add("start");
                i++;//wieder start ueberspringen
                depth = 1;
            }
        }
        return result;
    }
}