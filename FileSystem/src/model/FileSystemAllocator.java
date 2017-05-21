package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class allocates empty memory (data block)
 * <p>
 * Created by TOM RED on 17.04.2017.
 */
public class FileSystemAllocator {

    private static final int COUNT = 1024;

    private List<DataBlock> blocks;

    public FileSystemAllocator() {
        this.blocks = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            this.blocks.add(new DataBlock());
            this.blocks.get(i).setFree(true);
        }
    }

    /**
     * determines and gives free data block if it exists
     *
     * @return free data block
     */
    public DataBlock getFreeDataBlock() {
        Iterator<DataBlock> iterator = this.blocks.iterator();
        while (iterator.hasNext()) {
            DataBlock dataBlock = iterator.next();
            if (dataBlock.isFree()) {
                dataBlock.setFree(false);
                return dataBlock;
            }
        }

        return null;
    }
}
