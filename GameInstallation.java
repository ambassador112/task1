import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameInstallation {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        File gamesFolder = new File("C:\\Новая папка");
        if (!gamesFolder.exists()) {
            gamesFolder.mkdirs();
        }

        List<String> directoriesToCreate = new ArrayList<>();
        directoriesToCreate.add("src");
        directoriesToCreate.add("src/test");
        directoriesToCreate.add("src/main");
        directoriesToCreate.add("res");
        directoriesToCreate.add("res/drawables");
        directoriesToCreate.add("res/vectors");
        directoriesToCreate.add("res/icons");
        directoriesToCreate.add("savegames");
        directoriesToCreate.add("temp");
        
        for (String directory : directoriesToCreate) {
            createDirectory(gamesFolder.getAbsolutePath() + File.separator + directory, log);
        }

        File tempTxt = new File("C:\\Новая папка\\temp\\temp.txt");
        try {
            tempTxt.createNewFile();
            log.append(createFileMessage(tempTxt));
            writeLogToFile(log.toString(), tempTxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDirectory(String path, StringBuilder log) {
        File directory = new File(path);
        if (directory.mkdirs()) {
            log.append("Папка создана: ").append(directory.getAbsolutePath()).append("\n");
        } else {
            log.append("Ошибка в создании папки: ").append(directory.getAbsolutePath()).append("\n");
        }
    }

    private static String createFileMessage(File file) {
        if (file.exists()) {
            return "Файл создан: " + file.getAbsolutePath() + "\n";
        } else {
            return "Ошибка в создание файла: " + file.getAbsolutePath() + "\n";
        }
    }

    private static void writeLogToFile(String log, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
