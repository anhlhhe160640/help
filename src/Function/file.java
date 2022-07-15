package Function;

public class file {
    
    // read data from file
    public static String readFile(String fileName) {
        StringBuilder contentBuilder = new StringBuilder();
        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(fileName))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    // write data to file
    public static void writeFile(String fileName, String content) {
        try (java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.FileWriter(fileName))) {
            bw.write(content);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}
