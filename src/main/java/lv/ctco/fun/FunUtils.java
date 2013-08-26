package lv.ctco.fun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunUtils {
    public static <P, R> List<R> map(List<P> list, Function<P, R> function) {
        List<R> ids = new ArrayList<R>();
        for (P item : list) {
            ids.add(function.exec(item));
        }
        return ids;
    }

    public static <P> List<P> filter(List<P> students, Function<P, Boolean> comparator) {
        List<P> result = new ArrayList<P>();
        for (P student : students) {
            if(comparator.exec(student)){
                result.add(student);
            }
        }
        return result;
    }

//    public static <P, R> List<R> sort(List<P> students, Function<P, R> function) {
//        List<R> result = new ArrayList<R>();
//        for (P student: students) {
//
//            result.add(function.exec(student));
//        }
//        return result;
//    }
}

