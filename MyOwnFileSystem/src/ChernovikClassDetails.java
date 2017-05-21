/**
 * Created by ST on 29.04.2017.
 */
public class ChernovikClassDetails {
    /*Scanner scan=new Scanner(System.in);
        String filedata;
        System.out.print("Please insert File data --> ");
        filedata = scan.nextLine();
        Inode node=new Inode();
        node.dataBlockCreator(filedata);
        node.viewDataBlocks();*/


        /*Scanner scan = new Scanner(System.in);
        String filedata;
        System.out.print("Please insert File data --> ");
        filedata = scan.nextLine();

        Map<String, String> dataBlock = new HashMap<>();
        String blocksOfData = "";
        for (int i = 0; i < ((filedata.length() * 2) / 512); i++) {
            for (int j = 256 * i; j < (256 * (i + 1)); j++) {
                blocksOfData += filedata.charAt(j);
            }
            dataBlock.put("dataBlock" + i, blocksOfData);
            blocksOfData = "";
        }
        for (String name : dataBlock.keySet()) {

            String key = name;
            String value = dataBlock.get(name);
            System.out.println(key + " --> " + value);
            System.out.println(value.length());
        }*/
}
