import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Test {

  public static void main(String[] args) {
   //List<Apple> inventory = List.of(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));
    List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));
    //Comparator<Apple> aw=( a1,  a2)->-a1.getWeight().compareTo(a2.getWeight());
    Function<Apple,Integer> function=apple -> apple.getWeight();
    Comparator<Apple> aw=Comparator.comparing(function);
   // Comparator<Apple> aw=Comparator.comparing(Apple::getWeight);
    Comparator<Apple> aw1=Comparator.comparingInt(Apple::getWeight);
   // Comparator<Apple> ac=( a1,  a2)->a1.getColor().compareTo(a2.getColor());
    Comparator<Apple> ac= Comparator.comparing(Apple::getColor);
    Comparator<Apple> ac2= ac.reversed();
    Comparator<Apple> ac1= Comparator.comparing(Apple::getColor,(c1,c2)->-1*c1.compareTo(c2));

    inventory.sort(aw);
    System.out.println(inventory);
    inventory.sort(aw1);
    System.out.println(inventory);

    inventory.sort(ac);
    System.out.println(inventory);
    //ImmutableCollections

    inventory.sort(ac1);
    System.out.println(inventory);
    inventory.sort(ac2);
    System.out.println(inventory);
  }

}
class Apple {
  private int weight = 0;
  private String color = "";

  public Apple(int weight, String color){
    this.weight = weight;
    this.color = color;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String toString() {
    return "Apple{" +
            "color='" + color + '\'' +
            ", weight=" + weight +
            '}';
  }
}
