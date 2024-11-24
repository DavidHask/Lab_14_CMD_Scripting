public class FileScan {
    public static void main(String[] args) {

        if (args.length == 0) {
           FileInspector.main(null);
        } else {
            ReadFiles.main(args);
        }

    }
}