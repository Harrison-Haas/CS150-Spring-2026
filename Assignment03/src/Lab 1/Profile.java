public class Profile {
    
    private String name;
    private int age;
    private String major;

    public Profile(String name){
        this(name, 0, "");
    }

    public Profile(String name, int age){
        this(name, age, "");
    }

    public Profile(String name, int age, String major){
        this.name = name;
        this.age = age;
        this.major = major;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

}
