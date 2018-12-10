import Objects.Furniture;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

class Recipient {
    private static ArrayList<Furniture> furnitureArrayList = new ArrayList<Furniture>();
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1050);
            while (true) {
                furnitureArrayList.clear();
                DatagramPacket pack =
                        new DatagramPacket(new byte[1024], 1024);
                ds.receive(pack);
                System.out.println(new String(pack.getData()));
                new ThreadParse(furnitureArrayList, new String(pack.getData()));

//                for (Furniture f: furnitureArrayList){
//                    System.out.println(f.getAll());
//                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


