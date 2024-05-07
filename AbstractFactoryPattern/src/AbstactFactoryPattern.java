import java.util.ArrayList;

//Most general 'abstract product' class
interface Furniture{
    String getName();
    double getPrice();
}

//'Abstract class A' class
abstract class Chair implements Furniture{
    String name;
    double price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

//Concrete product A1
class ArtModernCompanyChair extends Chair{
    ArtModernCompanyChair(double price){
        name = "Modern Africa";
        this.price = price;
        System.out.println("Art Modern Company chair created");
    }
}

//Concrete product A2
class HistoryFurnitureChair extends Chair{
    HistoryFurnitureChair(double price){
        name = "Antique-1";
        this.price = price;
        System.out.println("History Furniture chair created");
    }
}


//'Abstract class B' class
abstract class CoffeeTable implements Furniture{
    String name;
    double price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

//Concrete product B1
class ArtModernCompanyCoffeeTable extends CoffeeTable{
    ArtModernCompanyCoffeeTable(double price){
        name = "Marble Cloud";
        this.price = price;
        System.out.println("Art Modern Company coffeeTable  created");
    }
}

//Concrete product B2
class HistoryFurnitureCoffeeTable extends CoffeeTable{
    HistoryFurnitureCoffeeTable(double price){
        name =  "Valedictorian Table";
        this.price = price;
        System.out.println("History Furniture coffeeTable  created");
    }
}

//Abstract factory
interface FurnitureFactory{
    Chair createChair();
    CoffeeTable createCoffeeTable();
}

// ConcreteFactory1
class ArtModernCompanyChairFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ArtModernCompanyChair(12345);
    }

    @Override
    public CoffeeTable createCoffeeTable(){
        return new ArtModernCompanyCoffeeTable(234567);
    }
}


//ConcreteFactory2
class HistoryFurnitureFactory implements FurnitureFactory{
    @Override
    public Chair createChair(){
        return new HistoryFurnitureChair(21312312);
    }
    @Override
    public CoffeeTable createCoffeeTable(){
        return new HistoryFurnitureCoffeeTable(739203);
    }
}

//Client
class BuildBundle {
    public void createBundle(FurnitureFactory factory){
        bundle = new ArrayList<Furniture>();
        bundle.add(factory.createChair());
        bundle.add(factory.createCoffeeTable());
    }
    void displayBundle(){
        System.out.println("Inside the bundle: ");
        for(Furniture f : bundle){
            System.out.println(f.getName() + " " + f.getPrice());
        }
    }
    ArrayList<Furniture> bundle;

}




class AbstractFactoryPattern {
    public static void main(String[] args) {
        FurnitureFactory artModernCompany = new ArtModernCompanyChairFactory();
        FurnitureFactory historyFurniture = new HistoryFurnitureFactory();

        System.out.println("Bundle 1: ");
        BuildBundle bundle1 = new BuildBundle();
        bundle1.createBundle(artModernCompany);
        bundle1.displayBundle();

        System.out.println("Bundle 2: ");
        BuildBundle bundle2 = new BuildBundle();
        bundle2.createBundle(historyFurniture);
        bundle2.displayBundle();

    }



}
