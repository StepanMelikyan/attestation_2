import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class App {
    private static ArrayList<Toy> arrayOftoy = new ArrayList<>();

    public static void main(String[] args) throws Exception {


        Toy bear = new Toy(101, "MISHA", 5, 40);
        Toy bird = new Toy(202, "PTICHKA", 4, 35);
        Toy dog = new Toy(302, "SOBAKA", 3, 25);

        arrayOftoy.add(bear);
        arrayOftoy.add(bird);
        arrayOftoy.add(dog);
        menu();
    }


    public static void printarray() {
        for (Toy toy : arrayOftoy) {
            System.out.println(toy._name + "," + toy._Quantity);
        }
    }
    

    public static void menu(){
        Scanner choise = new Scanner(System.in);
        System.out.println("\n" + "Выберите нужный пунк:");
        String ln1 = "1. Добавить игрушку";
        String ln2 = "2. Изменить вес игрушки";
        String ln3 = "3. Начать розыгрыш";
        String ln4 = "4. Завершить работу";
        System.out.println(ln1 + "\n" + ln2 + "\n" + ln3 + "\n" + ln4);
        int intchoise = choise.nextInt();
        
        if (intchoise == 1){
            addtoy();
            menu();
        }
        if (intchoise == 2){
            changeweight();
            menu();
        }
        if (intchoise == 3){
            priz();
            menu();
        }
        if (intchoise == 4){
            System.out.println("Работа программы завершена");
        }
    }


    public static void addtoy(){
        Scanner inname = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String nname = inname.nextLine().toUpperCase();

        Scanner inq = new Scanner(System.in);
        System.out.print("Введите колличество игрушек: ");
        int qq = inq.nextInt();

        Scanner inW = new Scanner(System.in);
        System.out.print("Введите вес игрушки: ");
        int ww = inW.nextInt();

        Toy newtoy = new Toy(maxid(), nname, qq, ww);
        System.out.println("Игрушка успешно добавлена!" + "\n" );
        arrayOftoy.add(newtoy);
    }


    public static int maxid() {
        ArrayList maxID = new ArrayList();
        for (Toy toy : arrayOftoy) {
            maxID.add(toy._ID);
            
        }
        int x = (int) maxID.get(maxID.size()-1);
        return x;
    }


    public static void changeweight() {
        Scanner inn = new Scanner(System.in);
        System.out.print("Введите имя игрушки: " + "\n" );
        String nname = inn.nextLine().toUpperCase();

        boolean indicator1 = false;
        for (Toy toy : arrayOftoy) {
            if (toy._name.equals(nname)) {
                Scanner newweight = new Scanner(System.in);
                System.out.print("Введите новый вес игрушки: " + "\n");
                int nw = newweight.nextInt();
                toy._weight = nw;
                System.out.println("Вес игрушки изменен" + "\n" );
                indicator1 = true;
                break;
            }
        }
        if (indicator1 == false){
            System.out.println("Введено неправильное имя!" + "\n");
            changeweight();
        }
    }      

        
    public static void priz(){
        for (int i = 0; i < arrayOftoy.size(); i ++) {
            if (arrayOftoy.get(i)._Quantity == 0){
                arrayOftoy.remove(i);
                i --;
            }
        }
        int w = 0;
        for (Toy toy : arrayOftoy) {
            w = w + toy._weight;
        }
        ArrayList win = new ArrayList<>();
        
        if (w == 0){
            System.out.println("Розыгрыш невозможен, игрушек не осталось" + "\n");
            return;
        }   
        Random randomChoise = new Random();
        int weight = randomChoise.nextInt(w);
        int quntity = 0;
        

        for (Toy toy : arrayOftoy) {
            quntity = quntity + toy._Quantity;
        }
        System.out.println("Общее количество игрушек = " + quntity + "\n");

        
        int ww = 0;
        for (Toy toy : arrayOftoy) {
            ww = ww + toy._weight;
            if (ww > weight){
                System.out.println("!!!Вы выиграли игрушку " + toy._name + "\n");
                win.add(toy._name);
                toy._Quantity = toy._Quantity - 1;
                break;
            }
        }
    }
}

