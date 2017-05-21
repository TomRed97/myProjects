package model;

/**
 * This class contains memory, that is simply char array with
 * fixed size. It has count, which points to offset in data block.
 * <p>
 * Created by TOM RED on 11.04.2017.
 */
public class DataBlock {
    private char block[];

    private static final int SIZE = 512;

    private boolean isFree;

    //offset in data block
    private int count = 0;

    private static final String RED_MESSAGE = (char) 27 + "[31m";

    public DataBlock() {
        this.block = new char[SIZE];
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public boolean put(char character) {
        if (count != SIZE) {
            block[count] = character;
            count++;
            return true;
        } else {
            System.out.println(RED_MESSAGE + "The data block is full !");
            return false;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.count; i++) {
            s += this.block[i];
        }
        return s;
    }
}
