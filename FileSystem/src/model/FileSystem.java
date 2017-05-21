package model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * FileSystem class is responsible for creating and deleting files, writing in them,
 * it contains table of inodes.
 * <p>
 * Created by TOM RED on 11.04.2017.
 */
public class FileSystem {

    private Map<String, Inode> inodesTable;

    private FileSystemAllocator fileSystemAllocator;

    private static FileSystem fileSystem;

    private static final String RED_MESSAGE = (char) 27 + "[31;1m";
    private static final String GREEN_MESSAGE = (char) 27 + "[32m";
    private static final String BLUE_MESSAGE = (char) 27 + "[34m";
    private static final String WHITE_MESSAGE = (char) 27 + "[37m";

    private static final String FILE_NOT_EXIST_MESSAGE = "File with that name doesn't exist !";

    private static final String FULL_MEMORY_MESSAGE = "The memory is full !";

    private FileSystem() {
        this.inodesTable = new HashMap<>();
        this.fileSystemAllocator = new FileSystemAllocator();
    }

    public static FileSystem getFileSystem() {
        if (fileSystem == null) {
            fileSystem = new FileSystem();
        }

        return fileSystem;
    }

    /**
     * creates file with that name and allocates data block for it.
     *
     * @param fileName
     * @return boolean if file was created or not
     */
    public boolean createFile(String fileName) {
        if (!inodesTable.containsKey(fileName)) {

            DataBlock dataBlock = this.fileSystemAllocator.getFreeDataBlock();

            if (dataBlock != null) {

                LocalDateTime now = LocalDateTime.now();
                String userInfo = System.getenv("USERNAME");

                Inode inode = new Inode(userInfo, now);
                inode.addDataBlock(dataBlock);
                inodesTable.put(fileName, inode);
                System.out.println(GREEN_MESSAGE + "File was created successfully !");

            } else {
                System.out.println(RED_MESSAGE + FULL_MEMORY_MESSAGE);
                return false;
            }

            return true;

        } else {
            System.out.println(RED_MESSAGE + "File with that name already exists !");
            return false;
        }
    }

    /**
     * writes in file with that name, if that file doesn't exist or memory
     * is full, it shows corresponding messages.
     * When current data block is full, it gets from allocator another empty data block.
     *
     * @param fileName
     * @param line
     * @return boolean if data was written or not.
     */
    public boolean write(String fileName, String line) {
        Inode inode = this.inodesTable.get(fileName);

        if (inode != null) {
            DataBlock dataBlock;
            for (int i = 0; i < line.length(); i++) {
                char character = line.charAt(i);
                dataBlock = inode.getCurrentDataBlock();
                Boolean isWrited = dataBlock.put(character);

                if (!isWrited) {
                    DataBlock freeDataBlock = this.fileSystemAllocator.getFreeDataBlock();
                    if (freeDataBlock != null) {
                        inode.addDataBlock(freeDataBlock);
                        freeDataBlock.put(character);
                    } else {
                        System.out.println(RED_MESSAGE + FULL_MEMORY_MESSAGE);
                        return false;
                    }
                }
            }

            LocalDateTime now = LocalDateTime.now();
            inode.setLastModified(now);
            return true;

        } else {
            System.out.println(RED_MESSAGE + FILE_NOT_EXIST_MESSAGE);
            return false;
        }
    }

    public void clear() {

    }

    /**
     * shows content of file
     *
     * @param fileName
     */
    public void openFile(String fileName) {
        Inode inode = inodesTable.get(fileName);

        if (inode != null) {
            Iterator iterator = inode.getUsedBlocks().iterator();

            while (iterator.hasNext()) {

                System.out.println(WHITE_MESSAGE + (DataBlock) (iterator.next()));
            }

        } else {
            System.out.println(RED_MESSAGE + FILE_NOT_EXIST_MESSAGE);
        }
    }

    /**
     * shows file information: data of creation, last modification, name, size
     *
     * @param fileName
     */
    public void getFileInfo(String fileName) {
        Inode inode = inodesTable.get(fileName);

        if (inode != null) {
            System.out.println(BLUE_MESSAGE + fileName + "\n" + inode);
        } else {
            System.out.println(RED_MESSAGE + FILE_NOT_EXIST_MESSAGE);
        }
    }

    /**
     * deletes file with that name
     *
     * @param fileName
     */
    public void deleteFile(String fileName) {
        Inode inode = inodesTable.get(fileName);

        if (inode != null) {
            Iterator iterator = inode.getUsedBlocks().iterator();
            while (iterator.hasNext()) {
                DataBlock dataBlock = (DataBlock) iterator.next();
                dataBlock.setFree(true);
                dataBlock.setCount(0);
            }
            System.out.println(GREEN_MESSAGE + "This file was deleted successfully!");
        } else {
            System.out.println(RED_MESSAGE + FILE_NOT_EXIST_MESSAGE);
        }
    }
}
