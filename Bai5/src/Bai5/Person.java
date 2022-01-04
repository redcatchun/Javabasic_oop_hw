package Bai5;

/**
 * Class nguoi thue phong
 */
public class Person {
    private String name;
    private int age;
    private long idCard;
    private int room;// so phong dang thue

    public Person(String name, int age, long idCard) {
        this.name = name;
        this.age = age;
        this.idCard = idCard;
        this.room = -1;// mac dinh khong thue = -1
    }

    public Person(long idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", idCard=" + idCard +
                '}';
    }
}
