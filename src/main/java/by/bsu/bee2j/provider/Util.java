package by.bsu.bee2j.provider;



import java.util.ArrayList;

/**
 * Created by user on 05.05.2016.
 */
public class Util {
    static public byte[] bytes(ArrayList<Byte> data) {
        byte[] bytes = new byte[data.size()];
        for (int i = 0; i < data.size(); i++)
            bytes[i] = data.get(i);

        return bytes;
    }

}
