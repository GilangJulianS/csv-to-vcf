
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gilang
 */
public class MainClass {
    
    public static void main(String[] args) throws Exception{
        String input = args[0];
        String output = args[1];
        
        BufferedReader r = new BufferedReader(new FileReader(input));
        BufferedWriter w = new BufferedWriter(new FileWriter(output));
        
        String line;
        while((line = r.readLine()) != null){
            String[] data = line.split(",");
            String name = data[0];
            String[] names = name.split(" ");
            String phone = data[1];
            String[] nums = phone.split(";");
            w.write("BEGIN:VCARD\nVERSION:2.1\nN:");
            for(int i=1; i<names.length; i++){
                if(i > 1) w.write(" ");
                w.write(names[i]);
            }
            w.write(";" + names[0] + ";;;\n");
            w.write("FN:" + name + "\n");
            for(int i=0; i<nums.length; i++){
                String num = nums[i];
                if(!num.startsWith("+") || !num.startsWith("0")) num = "0" + num;
                w.write("TEL;CELL:" + num + "\n");
            }
            w.write("END:VCARD\n");
        }
    }
}
