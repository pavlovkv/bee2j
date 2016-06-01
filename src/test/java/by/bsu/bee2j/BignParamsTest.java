package by.bsu.bee2j;

/**
 * Created by user on 14.05.2016.
 */

import junit.framework.TestCase;

import java.util.Arrays;

public class BignParamsTest extends TestCase {
    public void testBignParams()
    {
        int[] levels = {128,192,256};
        int i = 0;
        for(int level:levels)
        {
            i++;
            BignParams params = new BignParams(level);
            //генерируем долговременные параметры эллиптической кривой
            assertEquals(Bee2Library.INSTANCE.bignStdParams(params,"1.2.112.0.2.0.34.101.45.3."+i),0);
            // проверяем долговременные параметры эллиптической кривой
            assertEquals(Bee2Library.INSTANCE.bignValParams(params),0);
        }
    }
}
