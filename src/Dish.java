import java.util.*; // for conciseness
import java.util.stream.Collectors;

public record Dish(String name, boolean vegetarian, int calories, Dish.Type type) {

  public static List<Dish> getMenu() {
    return
            List.of(new Dish("pork", false, 800, Type.MEAT),
                    new Dish("beef", false, 700, Type.MEAT),
                    new Dish("chicken", false, 400, Type.MEAT),
                    new Dish("french fries", true, 530, Type.OTHER),
                    new Dish("rice", true, 350, Type.OTHER),
                    new Dish("season fruit", true, 120, Type.OTHER),
                    new Dish("pizza", true, 550, Type.OTHER),
                    new Dish("prawns", false, 400, Type.FISH),
                    new Dish("salmon", false, 450, Type.FISH));
  }

  @Override
  public String toString() {
    return name;
  }

  public enum Type {MEAT, FISH, OTHER}

  public static void question10() {
    List<Dish> menu = Dish.getMenu();
    System.out.println("10:");
    List <Dish> menu2 = menu
            .stream()
            .filter(s -> s.type.equals(Type.MEAT))
            .limit(2)
            .collect(Collectors.toList());
    System.out.println(menu2);
  }

  public static void question11a() {
    List<Dish> menu = Dish.getMenu();
    System.out.println("11a:");
    long total_count = menu
            .stream()
            .filter(s -> s.type.equals(Type.MEAT))
            .mapToLong(p -> 1L)
            .sum();
    System.out.println(total_count);

  }

  public static void question11b() {
    List<Dish> menu = Dish.getMenu();
    System.out.println("11b:");
    long total_count = menu
            .stream()
            .filter(s -> s.type.equals(Type.MEAT))
            .map(p -> 1L)
            .reduce(0L, Long::sum);
    System.out.println(total_count);

  }

    public static void main(String[] args) {


    question10();
    question11a();
    question11b();



  }

}