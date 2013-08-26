package lv.ctco.fun;

import java.util.*;

public class Main {

    static List<Student> students = new ArrayList<Student>(Arrays.asList(new Student[]{
    new Student(1, "Karina"),
    new Student(2, "Vadi"),
    new Student(3, "Oleg"),
    new Student(4, "Alexey")}));

    static List<Integer> ints = Arrays.asList(5,9,4,3,1);

    static List<Student> students3 = new ArrayList<Student>(Arrays.asList(new Student[]{
            new Student(1, "Karina"),
            new Student(2, "Vadi"),
            new Student(3, "Karina"),
            new Student(4, "Oleg"),
            new Student(5, "Vadi"),
            new Student(6, "Alexey")}));

    public  static void main (String[] args) {

//        sort(students);
//        for (Student student: students)
//            System.out.println(student);
        List<Student> result = sort(students, new Function2<Student, Student, Boolean>() {
            @Override
            public Boolean exec(Student par1, Student par2) {return par1.getName().compareTo(par2.getName()) > 0; }
        });

        for (Student student : result) {
            System.out.println(student);
        }

        List<Integer> result2 = sort(ints, new Function2<Integer, Integer, Boolean>() {
            @Override
            public Boolean exec(Integer par1, Integer par2) {      return par1.compareTo(par2) > 0;
            }
        });

        for (Integer i : result2) {
            System.out.println(i);
        }

//        Map<String, List<Student>> studentMap = groupBy(students3);
//        System.out.println(studentMap);
        Map<String, List<Student>> result3 = groupBy(students3, new Function<Student, String>() {
            @Override
            public String exec(Student par) {
                return par.getName();
            }
        });

        System.out.println(result3);

    }

    public static <P> List<P> sort(List<P> list, Function2<P, P, Boolean> function2) {
        List<P> result = new ArrayList<P>(list);
        P tmp;
        boolean flag = true;

        while (flag) {
            flag = false;
            for (int i=0; i<result.size()-1; i++) {
                if (function2.exec(result.get(i), result.get(i+1))) {
                    tmp = result.get(i);
                    result.set(i, result.get(i + 1));
                    result.set(i + 1, tmp);
                    flag = true;
                }
            }
        }
        return result;
    }

//    public static List<Student> sort(List<Student> list) {
//        List<Student> result = new ArrayList<Student>(list);
//        Student tmp;
//        boolean flag = true;
//
//        while (flag) {
//            flag = false;
//            for (int i=0; i<result.size()-1; i++) {
//                if (result.get(i).getName().compareTo(result.get(i+1).getName()) > 0) {
//                    tmp = result.get(i);
//                    result.set(i, result.get(i + 1));
//                    result.set(i + 1, tmp);
//                    flag = true;
//                }
//            }
//        }
//        return result;
//    }

    public static <P, R> Map<R, List<P>> groupBy(List<P> list, Function<P, R> function3) {
        List<P> result = new ArrayList<P>(list);
        Map<R, List<P>> map = new HashMap<R, List<P>>();
        for (int i=0; i<result.size()-1; i++) {
            R key = function3.exec(result.get(i));
            if (map.get(key) == null) {
                map.put(key, new ArrayList<P>());
            }
            map.get(key).add(result.get(i));
        }
        return map;
    }

//    public static Map<String, List<Student>> groupBy(List<Student> list) {
//        List<Student> result = new ArrayList<Student>(list);
//        Map<String, List<Student>> map = new HashMap<String, List<Student>>();
//        for (int i=0; i<result.size()-1; i++) {
//            String key = result.get(i).getName();
//            if (map.get(key) == null) {
//                map.put(key, new ArrayList<Student>());
//            }
//            map.get(key).add(result.get(i));
//        }
//        return map;
//    }

}

