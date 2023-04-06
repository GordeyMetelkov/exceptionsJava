import java.util.Scanner;

class Input {

    Scanner in = new Scanner(System.in, "Cp866");

    public String[] inputData() {
        System.out.println("Введите свои данные через пробел в формате:\n" + 
            "Фамилия Имя Отчество дата рождения " + 
            "номер телефона пол\nНапример, Иванов Иван Иванович 01.01.2001 80291112233 m");
        return in.nextLine().split(" ");
    }
}
