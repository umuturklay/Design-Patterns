import java.util.ArrayList;

abstract class SchoolBell {
    public SchoolBell() {

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

interface Observers {
    void Update(SchoolBell schoolBell);
}

class Classroom implements Observers {
    private SchoolBell _bell;// Internal Observer state
    private int _time;
    private String _className;

    private Classroom (SchoolBell bell) {
        _bell = bell;
    }
    // Constructor

    public void Update(SchoolBell bell) {
        _bell = bell;				 // Reference to Subject
        _time = _bell.getTime();
        System.out.println("Notified " + _className );
    }

    public SchoolBell get_bell() {
        return _bell;
    }
    public void set_bell(SchoolBell bell) {
        _bell = bell;
    }

    public String getName() { return _className; }
}





















public class ObserverPattern {
}
