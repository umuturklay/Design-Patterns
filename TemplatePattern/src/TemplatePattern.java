import java.util.Scanner;

abstract class Bread{
   abstract public void mix_Ingredients();
   abstract void hook1();
   abstract public void knead();
   abstract void hook2();
   abstract public void bake();

   final public void makeBread(){
       mix_Ingredients();
       hook1();
       knead();
       hook2();
       bake();
   }
}
class WhiteLoaf extends Bread{
    public WhiteLoaf(){}

    public void mix_Ingredients(){
        System.out.println("WHITE LOAF BREAD RECIPE");
        System.out.println("Mix 500g strong white flour, 2 tsp salt and a 7g sachet of fast-action yeast in a large bowl.");
        System.out.println("Make a well in the centre, then add 3 tbsp olive oil and 300ml water, and mix well.");
    }
    void hook1(){
        System.out.println("hook1 on whiteloaf");
    }
    public void knead(){
        System.out.println("Tip the white loaf dough onto a lightly floured work surface and knead for around 10 mins.");
    }

    void hook2(){
        giveShape();
    }
    public void giveShape(){
        System.out.println("Knock back the white loaf dough (punch the air out and pull the dough in on itself) then gently mould the dough into a ball.");
    }

    public void bake(){
        System.out.println("Bake for 25-30 mins until golden brown and the white loaf sounds hollow when tapped underneath.");
    }
}

class NutsSeeds extends Bread{
    public NutsSeeds(){}

    public void mix_Ingredients(){
        System.out.println("NUTS-SEEDS BREAD RECIPE");
        System.out.println("Mix together some almond flour, coconut flour, baking soda, and salt.");
        System.out.println("Add eggs, olive oil, apple cider vinegar, and honey.");
    }

    void hook1(){
        add_nuts();
    }

    public void add_nuts(){
        System.out.println("Add in the flax seeds, chia seeds and large amount of nuts of your choice.");
    }
    public void knead(){
        System.out.println("Tip the mixed dough onto a lightly floured work surface and knead for around 10 mins.");
    }

    void hook2(){
        seedsOnTop();
    }
    public void seedsOnTop(){
        System.out.println("Top your bread with a generous amount of extra seeds such as sunflower seeds. ");
    }

    public void bake(){
        System.out.println("Transfer the dough to a loaf pan, using a spatula to make sure itâ€™s evenly spread across the pan.");
        System.out.println("Bake your bread for about 38-41 minutes or until a toothpick comes out clean.");
    }
}

public class TemplatePattern {
    public static void main(String [] args){
        Bread wl = new WhiteLoaf();
        Bread ns = new NutsSeeds();
        Scanner scan = new Scanner(System.in);

        wl.makeBread();
        ns.makeBread();



    }
}
