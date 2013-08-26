package lv.ctco.fun;

/**
 * Created with IntelliJ IDEA.
 * User: atayeva
 * Date: 8/26/13
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Student {

    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
