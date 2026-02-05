import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc;
        String name;
        Integer age;

        HashMap<Integer, List<User>> users = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя " + (i + 1));
            sc = new Scanner(System.in);
            name = sc.nextLine();

            System.out.println("Введите возраст пользователя " + (i + 1));
            sc = new Scanner(System.in);
            age = sc.nextInt();

            if (!users.containsKey(age)) {
                users.put(age, new ArrayList<>());
            }
            users.get(age).add(new User(name, age));
        }

        System.out.println("Введите требуемый возраст");
        sc = new Scanner(System.in);
        age = sc.nextInt();

        if (users.containsKey(age)) {
            Collections.sort(users.get(age), new Comparator<User>() {
                public int compare(User u1, User u2) {
                    return u1.getName().compareTo(u2.getName());
                }
            });
            for (int i = 0; i < users.get(age).size(); i++) {
                System.out.println(users.get(age).get(i).toString());
            }
        } else {
            System.out.println("Пользователь с возрастом " + age + " не найден");
        }
    }
}
class User{
    private String name;

    private Integer age;

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String toString(){
        return name + ", возраст " + age + " лет";
    }
}
