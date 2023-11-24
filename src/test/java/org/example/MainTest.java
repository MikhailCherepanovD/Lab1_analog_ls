package org.example;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
public class MainTest {

    @Test
    public void testGetListFiles1() {
        Main main = new Main();
        String cur_dir = System.getProperty("user.dir");
        File new_dir = new File(cur_dir, "new_dir");
        String result="";
        try {
            FileUtils.deleteDirectory(new_dir);
        } catch (IOException e) {}
        if (!new_dir.exists()) {
            new_dir.mkdir();
            File s_dir1 = new File(new_dir, "d1");
            File s_dir2 = new File(new_dir, "d2");
            File s_dir3 = new File(new_dir, ".h1");
            File s_dir4 = new File(new_dir, ".h2");
            s_dir1.mkdir();
            s_dir2.mkdir();
            s_dir3.mkdir();
            s_dir4.mkdir();
            result = main.GetListFiles(new_dir,"");
            System.out.println(result);
            try {
                FileUtils.deleteDirectory(new_dir);
            } catch (IOException e) {
            }
        }

        String str="new_dir:\n" +
                "d1  d2  ";
        assertEquals(str, result);
    }

    @Test
    public void testGetListFiles2() {
        Main main = new Main();
        String result="";
        String cur_dir = System.getProperty("user.dir");
        File new_dir = new File(cur_dir, "new_dir");
        try {
            FileUtils.deleteDirectory(new_dir);
        } catch (IOException e) {}
        result = main.GetListFiles(new_dir,"");
        String str="Указанной директории не существует.";
        assertEquals(str, result);
    }

    @Test
    public void testGetListFiles3() {
        Main main = new Main();
        String result="";
        String cur_dir = System.getProperty("user.dir");
        File new_dir = new File(cur_dir, "new_dir");
        try {
            FileUtils.deleteDirectory(new_dir);
        } catch (IOException e) {}

        if (!new_dir.exists()) {
            new_dir.mkdir();
            result = main.GetListFiles(new_dir,"");
            System.out.println(new_dir);
            try {
                FileUtils.deleteDirectory(new_dir);
            } catch (IOException e) {}
        }
        String str="new_dir:\n";
        assertEquals(str, result);
    }
    @Test
    public void testGetListFiles4() {
        Main main = new Main();
        String cur_dir = System.getProperty("user.dir");
        File new_dir = new File(cur_dir, "new_dir");
        String result="";
        try {
            FileUtils.deleteDirectory(new_dir);
        } catch (IOException e) {}
        if (!new_dir.exists()) {
            new_dir.mkdir();
            File s_dir1 = new File(new_dir, "d1");
            File s_dir2 = new File(new_dir, "d2");
            File s_dir3 = new File(new_dir, ".h1");
            File s_dir4 = new File(new_dir, ".h2");
            s_dir1.mkdir();
            s_dir2.mkdir();
            s_dir3.mkdir();
            s_dir4.mkdir();
            result = main.GetListFiles(new_dir,"-a");
            System.out.println(result);
            try {
                FileUtils.deleteDirectory(new_dir);
            } catch (IOException e) {}
        }

        String str="new_dir:\n" +
                ".h1  .h2  d1  d2  ";
        assertEquals(str, result);
    }
    @Test
    public void testGetListFiles5() {
        Main main = new Main();
        String result="";
        String cur_dir = System.getProperty("user.dir");
        File new_dir = new File(cur_dir, "new_dir");
        try {
            FileUtils.deleteDirectory(new_dir);
        } catch (IOException e) {}

        if (!new_dir.exists()) {
            new_dir.mkdir();
            result = main.GetListFiles(new_dir,"-p");
            System.out.println(new_dir);
            try {
                FileUtils.deleteDirectory(new_dir);
            } catch (IOException e) {}
        }
        String str="Указанный флаг не существует или не риализован.";
        assertEquals(str, result);
    }
@Test
    public void testGetListFiles6() {
        Main main = new Main();
        String cur_dir = System.getProperty("user.dir");
        File new_dir = new File(cur_dir, "new_dir");
        String result="";
        try {
            FileUtils.deleteDirectory(new_dir);
        } catch (IOException e) {}
        if (!new_dir.exists()) {
            new_dir.mkdir();
            File s_dir1 = new File(new_dir, "d1");
            File s_dir2 = new File(new_dir, "d2");
            s_dir1.mkdir();
            s_dir2.mkdir();
            File s_dir3 = new File(s_dir1, "d1_1");
            File s_dir4 = new File(s_dir1, "d1_2");
            s_dir3.mkdir();
            s_dir4.mkdir();
            File s_dir5= new File(s_dir2, "d2_1");
            result = main.GetListFiles(new_dir,"-R");
            System.out.println(result);
            try {
                FileUtils.deleteDirectory(new_dir);
            } catch (IOException e) {
            }
        }

        String str="new_dir:\n" +
                "d1  d2  \n" +
                "d1:\n" +
                "d1_1  d1_2 ";
        assertEquals(str, result);
    }
}



