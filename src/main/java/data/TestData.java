package data;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    private static ThreadLocal<Map<String, Map<String,String>>> testData = new ThreadLocal<>();

    public static void SetOrderData(Map<String,Map<String,String>> data)
    {
        testData.set(data);
    }
    public static Map<String, Map<String,String>> GetOrderData()
    {
        return testData.get();
    }

}
