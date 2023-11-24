package org.example;
import java.io.File;
import java.util.Arrays;
public class Main {
    static String GetListFiles( File dir,String flag){
        String ans="";
        if(!flag.equals("")&&!flag.equals("-a")) {
            ans = "Указанный флаг не существует или не риализован.";
            return ans;
        }
        boolean flag_a   =  flag.equals("-a")? true:false;
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
            for (String file : files) {
                if (flag_a == false && file.charAt(0) != '.' || flag_a == true) {
                    ans += file;
                    ans += "  ";
                }
            }
            return ans;
        }
        ans="Указанной директории не существует.";
        return ans;
    }
    public static void main(String[] args) {
        // Получаем путь к директории из аргументов командной строки
        String dir_path = (args.length > 0) ? args[0] : ".";
        String flag = (args.length ==2) ? args[1] : "";
        if(dir_path.charAt(0)=='-'){
            flag=dir_path;
            dir_path=".";
        }
        // Создаем объект File для представления указанной директории
        File dir = new File(dir_path);
        System.out.println(GetListFiles(dir,flag));
    }
}