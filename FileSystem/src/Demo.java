import model.FileSystem;

/**
 * Created by TOM RED on 17.04.2017.
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {

        //Creating file and writing in it
        FileSystem fileSystem = FileSystem.getFileSystem();
        fileSystem.createFile("first");
        Thread.sleep(2000);
        fileSystem.write("first", "Hello world");
        fileSystem.getFileInfo("first");
        fileSystem.openFile("first");

        //Creating file with the same name
        fileSystem.createFile("first");

        //Creating second file and writing in it, information should be allocated in 2 data blocks
        fileSystem.createFile("second");
        Thread.sleep(4000);
        fileSystem.write("second", "Discover Australia’s most beautiful city, from the iconic Sydney Opera" +
                " House and sparkling blue Sydney Harbour to fabulous beaches, delicious food " +
                "and blockbuster shows. Climb the Sydney Harbour Bridge, cruise the harbour, " +
                "explore national parks, and meet incredible wildlife. You’ll be amazed with the" +
                " many wonderful things to do and see throughout the year. An exciting events calendar " +
                "includes spectacular Vivid Sydney and the world-famous New Year’s Eve fireworks. Visit " +
                "zoos and aquariums, picnic in harbourside parks, go whale watching, and relax on Bondi " +
                "Beach.");
        fileSystem.getFileInfo("second");
        fileSystem.openFile("second");

        Thread.sleep(4000);

        fileSystem.write("first", "\nProgramming is my love.");
        fileSystem.getFileInfo("first");
        fileSystem.openFile("first");

        fileSystem.write("second", "It's very warm today.");
        fileSystem.getFileInfo("second");
        fileSystem.openFile("second");

        //Deleting file that doesn't exist
        fileSystem.deleteFile("third");

        //Writing in file that doesn't exist
        fileSystem.write("third", "hello");

    }

}
