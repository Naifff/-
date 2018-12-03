public class Parser {
    private String done;

    public Parser() {
    }

    public String setDone(String done) {

        try {
            if (Integer.valueOf(done.trim()) <= Integer.MAX_VALUE) {
                return "int";
            }
        } catch (Exception e) {
            try {
                if (Double.parseDouble(done) <= Double.MAX_VALUE) {
                    return "double";
                }
            } catch (NumberFormatException e1) {
                if (done.contains("+") | done.contains("/") | done.contains("-") | done.contains("*")) {
                    return "formula";
                }
            }

        }


        return "peremennaya";
    }

    public String parsVar(String done) {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] c = abc.toCharArray();
        int i = 0;
        for (i = 0; i < c.length; i++) {
            if (done.contains(String.valueOf(c[i]))) {
                break;
            }
        }
        String[] arr = done.split(String.valueOf(c[i]));
        return (String) ((i) + ";" + (int) (Integer.valueOf(arr[1]) - 1));

    }
}
