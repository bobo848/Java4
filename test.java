package experiment5;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static StringBuffer ReadTxt(String path) {
        StringBuffer s = new StringBuffer();
        // ��ȡ�ļ����� (������)
        try {
            FileInputStream out = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(out);
            char[] chars = new char[9999999];
            int ch = 0;
            int i = 0;
            while ((ch = isr.read()) != -1) {
                chars[i] = (char) ch;
                i++;
            }
            for (int j = 0; j < i; j++) {
                s.append(chars[j]);
                if ((j + 1) % 7 == 0 && (j + 1) % 2 == 0) {
                    s.append("��" + "\n");
                }
                if ((j + 1) % 7 == 0 && (j + 1) % 2 != 0) {
                    s.append("��");
                }
            }
        } catch (Exception e) {
            System.out.println("1");
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner;
        // ��ȡ�ļ����� (������)
        try {
            StringBuffer s = ReadTxt("D:\\eclipse\\experiment5\\src\\experiment5\\1.txt");
            a:
            while (true) {
                System.out.println("���빦�ܱ��:" + "\n" + "1:��ѯ��ʫ�е��ֻ��"+" \n"+ "2:�˳�����"+"\n");
                Scanner o = new Scanner(System.in);
                int m = o.nextInt();
                switch (m) {
                    case 1:
                        System.out.println("��������Ҫ��ѯ���ֻ��");
                        Scanner scanner1 = new Scanner(System.in);
                        String s1 = scanner1.nextLine();
                        Pattern pattern = Pattern.compile(s1);
                        Matcher matcher = pattern.matcher(s);
                        if (matcher.find()) {
                            int num = 1;
                            while (matcher.find()) {
                                num++;
                            }
                            System.out.println("����Ϊ" + num);
                        } else {
                            System.out.println("�ı���û�и��ַ�");
                        }
                        break;
                    case 2:
                        break a;
                    default:
                        System.out.println("������ı����������������");
                }
            }

            students student = new students();
            while (true) {
                try {
                    System.out.println("����");
                    scanner = new Scanner(System.in);
                    String S = scanner.nextLine();
                    if (S.matches("[0-9a-zA-Z]"))
                        throw new AException();
                    else
                        student.setName(S);
                    break;
                } catch (AException e) {
                    System.out.println("�������������������������");
                }
            }
            System.out.println("�༶");
            student.setTeam(scanner.next());
            while (true) {
                try {
                    System.out.println("ѧ��");
                    scanner = new Scanner(System.in);
                    String S = scanner.next();
                    if (S.matches("[^0-9]"))
                        throw new AException();
                    else
                        student.setNumber(S);
                    break;
                } catch (AException e) {
                    System.out.println("�������ѧ����������������");
                }
            }
            System.out.println(student);
            s.append(student);
            File file = new File("D:\\eclipse\\experiment5\\src\\experiment5\\2.txt");
            if (!file.exists())
                file.createNewFile();
            FileOutputStream p = new FileOutputStream(file);
            p.write(s.toString().getBytes("utf-8"));
            p.close();
        } catch (Exception e) {
            System.out.println("1");
        }
    }
}




