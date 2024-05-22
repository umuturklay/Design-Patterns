import java.util.ArrayList;

abstract class SchoolBell {
    public SchoolBell(int time) {
        this.time = time;
    }
    //Register the Observers
    public void Attach (Classroom room) {
        classes.add(room);
    }
    //Unregister from the list of Observers.
    public void Detach (Classroom room) {
        for (int i = 0; i< classes.size(); i++) {
            if (classes.get(i).getName() == room.getName()) {
                classes.remove(i);
                return;
            }
        }
    }
    //Notify the Observers.
    public void Notify() {
        // set argument to something that helps
        // tell the Observers what happened
        for (int i = 0; i < classes.size(); i++) {
            if(classes.get(i).get_bell().getTime() == 20 || classes.get(i).get_bell().getTime() == 50 )
                classes.get(i).Update(this);
        }
    }
    protected int time;// Internal Subject state

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    protected ArrayList<Classroom> classes = new ArrayList<Classroom>();
}

class bell extends SchoolBell{
    public bell (int time){
        super(time);
    }
    public int getTime(){return time;}
    public void setTime(int value){
        time = value;
        Notify();
    }
}

interface Observers {
    void Update(SchoolBell schoolBell);
}

class Classroom implements Observers {
    private Counter _counter = new Counter();
    private SchoolBell _bell;// Internal Observer state
    private int _time;
    private String _className;

    public Classroom (String name) {
        _className = name;
    }
    // Constructor

    public void Update(SchoolBell bell) {
        _bell = bell;				 // Reference to Subject
        _time = _bell.getTime();
        System.out.println("Notified " + _className );
        _counter.increaseCounter();
        System.out.println(_counter.getUpdateCounter());
    }
    public SchoolBell get_bell() {
        return _bell;
    }
    public void set_bell(SchoolBell bell) {
        _bell = bell;
    }
    public String getName() { return _className; }
}

class Counter {
    private static int updateCounter;

    public void increaseCounter(){
        updateCounter++;
    }

    public int getUpdateCounter(){ return updateCounter;}
}

class Principle{

}
public class ObserverPattern {
    public static void main(String[] args) {
        Classroom s = new Classroom("classA");
        Classroom b = new Classroom("classB");

        bell bell = new bell(10);
        s.set_bell(bell);
        b.set_bell(bell);
        bell.Attach(s);
        bell.Attach(b);


        bell.setTime(31);
        bell.Detach(s);
        bell.setTime(20);

    }


}
