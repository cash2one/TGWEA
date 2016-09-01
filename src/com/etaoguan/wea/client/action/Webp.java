package com.etaoguan.wea.client.action;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Webp {
	public static void main(String[] args) {
        BufferedReader br = null;
        try {
        	String exec="cmd /c D: && cd D:\\webp\\bin && cwebp -q 80 ../convert/1.png -o ../convert/1.webp";
//        	String exec="cmd /k start calc";
//        	String exec="net user";
            Process p = Runtime.getRuntime().exec(exec);
            br = new BufferedReader(new InputStreamReader(p.getInputStream(),"gbk"));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
