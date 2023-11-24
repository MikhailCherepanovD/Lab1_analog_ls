package org.example;
import java.io.File;
import java.util.Arrays;


public class Main {
    static String GetListFiles( File dir,String flag){
        String ans="";
        if(!flag.equals("")&&!flag.equals("-a")&&!flag.equals("-R")) {
            ans = "Указанный флаг не существует или не риализован.";
            return ans;
        }
        boolean flag_a   =  flag.equals("-a")? true:false;
        boolean flag_R   =  flag.equals("-R")? true:false;
        if(dir.exists()&& !dir.isDirectory()){
            ans=dir.getName();
            return ans;
        }

        if (dir.exists()) {
            String[] files = dir.list();
            if (files != null) {
                // Сортируем массив
                Arrays.sort(files);
            }

            ans+= dir.getName();
            ans+=":\n";
            for (String file : files) {
                if (flag_a == false && file.charAt(0) != '.' || flag_a == true) {
                    ans += file;
                    ans += "  ";
                }
            }
            ans+="\n";
            if(flag_R) {
                for (String file : files) {
                    File curr_file = new File(dir, file);
                    if (curr_file.isDirectory()&&curr_file.list().length!=0) {
                        ans+=GetListFiles(curr_file,flag);
                       // ans+="\n";
                    }
                }
            }
            ans = ans.substring(0,ans.length()-1);
            return ans;
        }
        ans="Указанной директории не существует.";
        return ans;
    }
    public static void main(String[] args) {
        // Получаем путь к директории из аргументов командной строки
        String dir_path = (args.length > 0) ? args[0] : ".";
        String flag = (args.length >1) ? args[1] : "";
        if(dir_path.charAt(0)=='-'){
            flag=dir_path;
            dir_path=".";
        }
        // Создаем объект File для представления указанной директории
        File dir = new File(dir_path);
        System.out.println(GetListFiles(dir,flag));
    }
}
