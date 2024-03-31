import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstallation {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        File gamesFolder = new File("C:\\Новая папка");
        if (!gamesFolder.exists()) {
            gamesFolder.mkdirs();
        }

        File srcFolder = new File(gamesFolder, "src");
        srcFolder.mkdirs();
        log.append(createFolderMessage(srcFolder));

        File testFolder = new File(srcFolder, "test");
        testFolder.mkdirs();
        log.append(createFolderMessage(testFolder));

        File mainFolder = new File(srcFolder, "main");
        mainFolder.mkdirs();
        log.append(createFolderMessage(mainFolder));

        File mainJava = new File(mainFolder, "Main.java");
        try {
            mainJava.createNewFile();
            log.append(createFileMessage(mainJava));
        } catch (IOException e) {
            e.printStackTrace();
        }

        File utilsJava = new File(mainFolder, "Utils.java");
        try {
            utilsJava.createNewFile();
            log.append(createFileMessage(utilsJava));
        } catch (IOException e) {
            e.printStackTrace();
        }

        File resFolder = new File(gamesFolder, "res");
        resFolder.mkdirs();
        log.append(createFolderMessage(resFolder));

        File drawablesFolder = new File(resFolder, "drawables");
        drawablesFolder.mkdirs();
        log.append(createFolderMessage(drawablesFolder));

        File vectorsFolder = new File(resFolder, "vectors");
        vectorsFolder.mkdirs();
        log.append(createFolderMessage(vectorsFolder));

        File iconsFolder = new File(resFolder, "icons");
        iconsFolder.mkdirs();
        log.append(createFolderMessage(iconsFolder));

        File saveGamesFolder = new File(gamesFolder, "savegames");
        saveGamesFolder.mkdirs();
        log.append(createFolderMessage(saveGamesFolder));

        File tempFolder = new File(gamesFolder, "temp");
        tempFolder.mkdirs();
        log.append(createFolderMessage(tempFolder));

        File tempTxt = new File(tempFolder, "temp.txt");
        try {
            tempTxt.createNewFile();
            log.append(createFileMessage(tempTxt));
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeLogToFile(log.toString(), tempTxt);
    }

    private static String createFolderMessage(File folder) {
        if (folder.exists()) {
            return "Папка создана: " + folder.getAbsolutePath() + "\n";
        } else {
            return "Ошибка в создании папки: " + folder.getAbsolutePath() + "\n";
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