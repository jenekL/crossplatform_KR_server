import Objects.Bed;
import Objects.Furniture;
import Objects.Sofa;

import java.util.ArrayList;

public class ThreadParse implements Runnable{
    private final Thread t;
    private ArrayList<Furniture> furnitureArrayList;
    private String data;

    public ThreadParse(ArrayList<Furniture> furnitureArrayList, String data) {
        this.data = data;
        this.furnitureArrayList = furnitureArrayList;
        t = new Thread(this, "Parse thread");
        t.start();
    }

    private synchronized void parse(String line){
        try {
            String[] furnitureData = line.split(";");
                Checker.checkString(furnitureData[0]);
                Checker.checkString(furnitureData[1]);
                Checker.checkString(furnitureData[4]);

                if (furnitureData[0].equals("Bed")) {
                    furnitureArrayList.add(new Bed(Integer.parseInt(furnitureData[2]), furnitureData[1],
                            Integer.parseInt(furnitureData[3]), furnitureData[4]));
                } else if (furnitureData[0].equals("Sofa")) {
                    furnitureArrayList.add(new Sofa(Integer.parseInt(furnitureData[2]), furnitureData[1],
                            Integer.parseInt(furnitureData[3]), furnitureData[4]));
                }
                System.out.println(furnitureArrayList.get(furnitureArrayList.size() - 1).toString());
           // System.out.println(furnitureArrayList.size());
        } catch(Exception e){
           e.printStackTrace();
        }
    }

    @Override
    public void run() {
        parse(data);
    }

}
