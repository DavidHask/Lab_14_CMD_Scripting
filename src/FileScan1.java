public class FileScan1 {
    public static void main(String[] args) {

        if (args.length == 0) {
           FileInspector.main(null);
        } else {
            ReadFiles.main(args);
        }

    }
}