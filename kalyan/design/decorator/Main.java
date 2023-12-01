package kalyan.design.decorator;

public class Main {
    public static void main(String[] args){
        System.out.println(new TofuTopping(new PaneerTopping(new VeggieDelightPizza())).cost());
        System.out.println(new MargarittaPizza().cost());
    }
}
