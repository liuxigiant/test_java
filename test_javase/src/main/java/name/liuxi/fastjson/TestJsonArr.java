package name.liuxi.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestJsonArr {
    public static void main(String[] args) {
        String str = "";
        JSONObject object = JSON.parseObject(str);
        JSONArray arr = object.getJSONArray("result");
        for (int i = 0; i < arr.size(); i++){
            JSONObject o = arr.getJSONObject(i);
            // appCode appName ip department
            System.out.println(String.format("[%s][%s][%s][%s]", o.getString("department"), o.getString("appName"), o.getString("appCode"), o.getString("ip")));
        }
    }
}
