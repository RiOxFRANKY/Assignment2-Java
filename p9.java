interface Explore{
    public void explore();
}

abstract class PlanetExplorer implements Explore{
    protected final String name;

    public PlanetExplorer(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

class MarsExplorer extends PlanetExplorer{

    public MarsExplorer(String name){
        super(name);
    }

    @Override
    public void explore(){
        System.out.println(this.name + " is Exploring Mars");
    }
}

class VenusExplorer extends PlanetExplorer{

    public VenusExplorer(String name){
        super(name);
    }

    @Override
    public void explore(){
        System.out.println(this.name + " is Exploring Venus");
    }
}

class SaturnExplorer extends PlanetExplorer{

    public SaturnExplorer(String name){
        super(name);
    }

    @Override
    public void explore(){
        System.out.println(this.name + " is Exploring Saturn");
    }
}




public class p9 {
    public static void main(String[] args) {
        MarsExplorer a = new MarsExplorer("Alex");
        VenusExplorer b = new VenusExplorer("Steve");
        SaturnExplorer c = new SaturnExplorer("Ryan");
        System.out.println(a.getName());
        a.explore();
        System.out.println(b.getName());
        b.explore();
        System.out.println(c.getName());
        c.explore();
    }
}
