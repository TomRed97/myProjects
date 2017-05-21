package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Inode class is for storing information about file
 * (creating date, last modification date, size, and pointers to used data blocks)
 * <p>
 * Created by TOM RED on 11.04.2017.
 */
public class Inode {

    private List<DataBlock> usedBlocks;

    private String userInfo;

    private LocalDateTime created;

    private LocalDateTime lastModified;

    private int size;

    private int currentDataBlock = 0;

    public Inode(String userInfo, LocalDateTime created) {
        this.userInfo = userInfo;
        this.created = created;
        this.lastModified = created;
        this.usedBlocks = new ArrayList<>();
    }

    public List<DataBlock> getUsedBlocks() {
        return usedBlocks;
    }

    public void setUsedBlocks(List<DataBlock> usedBlocks) {
        this.usedBlocks = usedBlocks;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public void addDataBlock(DataBlock dataBlock) {
        this.usedBlocks.add(dataBlock);
        this.currentDataBlock++;
    }

    /**
     * gives current used data block
     *
     * @return current data block
     */
    public DataBlock getCurrentDataBlock() {
        return this.usedBlocks.get(this.currentDataBlock - 1);
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        calculateSize();

        return "created by user : '" + this.userInfo + '\'' +
                "\ncreated in : " + dtf.format(this.created) +
                "\nlast modified in : " + dtf.format(this.lastModified) +
                "\nsize is : " + this.size + "*2 Bytes - " + this.size * 2 + " Bytes";

    }

    /**
     * calculates size of all used data blocks
     */
    public void calculateSize() {
        Iterator iterator = this.usedBlocks.iterator();
        int sum = 0;

        while (iterator.hasNext()) {
            sum += ((DataBlock) iterator.next()).getCount();
        }

        setSize(sum);
    }
}
