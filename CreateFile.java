import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

class CreateFile {

    public void createNewFile(String [] data) {
        String newFilePath = Paths.get("").toAbsolutePath().toString(   ) + "\\" + data[0] + ".txt";
        StringBuilder sb = new StringBuilder();
        for (String str : data) {
            sb.append(str + " ");
        }
        try(FileWriter fw = new FileWriter(newFilePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print(sb.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Что-то пошло не так!");
        }
    }
}
