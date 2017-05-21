/**
 * Created by ST on 25.04.2017.
 */

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Inode {
    private  final int DATA_BLOCK_SIZE_IN_BYTES = 512;
    private Map<String, String> dataBlocks = new HashMap<>();

    Inode() {

    }

    public void dataBlockCreator(String fileData) {

        if ((fileData.length() * 2) <= DATA_BLOCK_SIZE_IN_BYTES) {
            dataBlocks.put("simpleDataBlock", fileData);
        } else {
            String blocksOfData = "";
            for (int i = 0; i < ((fileData.length() * 2) / DATA_BLOCK_SIZE_IN_BYTES); i++) {
                for (int j = 256 * i; j < (256 * (i + 1)); j++) {
                    blocksOfData += fileData.charAt(j);
                }
                dataBlocks.put("dataBlock" + i, blocksOfData);
                blocksOfData = "";

                if (i == ((fileData.length() * 2) / DATA_BLOCK_SIZE_IN_BYTES) - 1) {
                    if (((fileData.length() * 2) % 512) != 0)
                        for (int j = 256 * (i + 1); j < fileData.length(); j++) {
                            blocksOfData += fileData.charAt(j);
                        }
                    dataBlocks.put("dataBlock" + (i + 1), blocksOfData);
                    blocksOfData = "";
                }

            }
        }
        System.out.println("Data successfuly stored in data Blocks which size are 512 bytes");
    }

    public void viewDataBlocks(){
        for (String name: dataBlocks.keySet()){

            String key =name;
            String value = dataBlocks.get(name);
            System.out.println(key + " --> " + value);
            System.out.println(value.length());
        }
    }





}
