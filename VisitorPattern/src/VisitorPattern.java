
import java.util.ArrayList;

// Element  (Element)
interface Element {
    public void Accept(Visitor visitor);
}
//
//"Visitor"
interface Visitor {
    public void Visit(KingTutankhamun element);
    public void Visit(BodyWorlds element);
    public void Visit(Titanic element);
}

//ConcreteElement  (Employee)
abstract class Exhibition implements Element {
    private String name;

    private int noOfVisitors;
    private boolean continueApprove;
    // Constructor
    public Exhibition(String name) {
        this.name = name;
        }

    public String getName() {return name;};
    public void setname(String value) {name = value;};

    public int getNoOfVisitors() {
        return noOfVisitors;
    }

    public void setNoOfVisitors(int noOfVisitors) {
        this.noOfVisitors = noOfVisitors;
    }

    public boolean isContinueApprove() {
        return continueApprove;
    }

    public void setContinueApprove(boolean continueApprove) {
        this.continueApprove = continueApprove;
    }

}

class KingTutankhamun extends Exhibition {
    public KingTutankhamun(String name) {
        super (name);
    }
    public void Accept(Visitor visitor) {visitor.Visit(this);}
}

class BodyWorlds extends Exhibition {
    public BodyWorlds(String name) {
        super (name);    }
    public void Accept(Visitor visitor) {visitor.Visit(this);}

}

class Titanic extends Exhibition {
    public Titanic(String name) {
        super (name);
    }
    public void Accept(Visitor visitor) {visitor.Visit(this);}
}




// ObjectStructure  (Employees)
class Exhibitions {
    public void Add(Exhibition exhibition){ exhibitions.add(exhibition);}
    public void Remove(Exhibition exhibition) {
        for (int i = 0; i< exhibitions.size(); i++) {
            if (exhibitions.get(i).getName() == exhibition.getName()) {
                exhibitions.remove(i);
                return;
            }
        }
    }
    public void Accept(Visitor visitor) {
        // elements accept the visitor
        for (Exhibition e: exhibitions) {
            e.Accept(visitor);		}
    }
    private ArrayList<Exhibition> exhibitions = new ArrayList<Exhibition>();
};


// "ConcreteVisitor 1"
class CountVisitor implements  Visitor {
    public void Visit(KingTutankhamun element){
        int randomNo = (int) ((Math.random() * (150-1)) + 1);
        element.setNoOfVisitors(randomNo);
        System.out.print(element.getName() + "'s number of visitors : ");
        System.out.printf("\n"+ element.getNoOfVisitors() + "\n");
    }
    public void Visit(BodyWorlds element){
        int randomNo = (int) ((Math.random() * (100-1)) + 1);
        element.setNoOfVisitors(randomNo);
        System.out.print(element.getName() + "'s number of visitors : ");
        System.out.printf("\n"+ element.getNoOfVisitors() + " \n");
    }
    public void Visit(Titanic element){
        int randomNo = (int) ((Math.random() * (350-1)) + 1);
        element.setNoOfVisitors(randomNo);
        System.out.print(element.getName() + "'s number of visitors : ");
        System.out.printf("\n"+ element.getNoOfVisitors() + "\n");
    }
}
// "ConcreteVisitor 2"
class ApproveVisitor implements Visitor {
    public void Visit(KingTutankhamun element) {
        if (element.getNoOfVisitors() > 100) {
            element.setContinueApprove(true);
            System.out.print(element.getName() + " approved\n" );
        } else {
            element.setContinueApprove(false);
            System.out.print(element.getName() + " not approved\n");
        }
    }

    public void Visit(BodyWorlds element) {
        if (element.getNoOfVisitors() > 75) {
            element.setContinueApprove(true);
            System.out.print(element.getName() + " approved\n");
        } else {
            element.setContinueApprove(false);
            System.out.print(element.getName() + " not approved\n");
        }
    }

    public void Visit(Titanic element) {
        if (element.getNoOfVisitors() > 250) {
            element.setContinueApprove(true);
            System.out.print(element.getName() + " approved\n");
        } else {
            element.setContinueApprove(false);
            System.out.print(element.getName() + " not approved\n");
        }
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        // Setup employee collection
        Exhibitions e = new Exhibitions();
        e.Add(new KingTutankhamun("Tutankhamun"));
        e.Add(new BodyWorlds("Bodyworlds"));
        e.Add(new Titanic("Titanic"));

        // Employees are 'visited'
        e.Accept(new CountVisitor());
        e.Accept(new ApproveVisitor());
    }
}
