import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Outline {

  public static List<String> getList() {
    return List.of("hi", "bat", "ear", "hello", "iguana",
            "beaver", "winterland", "elephant", "eye", "qi");
  }

  public static Integer[] getIntegerArray() {
    return new Integer[] { 1, 3, 8 };
  }


  // Loop through the words and print each one on a separate line,
  // with two spaces in front of each word.
  public static void question1() {
    List<String> words = getList();
    System.out.println("1: ");
    getList()
            .stream()
            .forEach(s -> System.out.println("  " + s));
  }

  // Repeat this problem but without two spaces in front of each word.
  // This should be trivial if you use the same approach as the previous
  // question; the point here is to make use of a method reference.
  public static void question2() {
    List<String> words = getList();
    System.out.println("2: ");
    getList()
            .stream()
            .forEach(System.out::println);
  }

  // For each of the following lambda expressions (see Question 5 in Worksheet 2),
  // produce the list that contains the elements of the original list
  // that satisfy the predicate defined by the lambda expression
  // (use the filter stream operation):
  //  - s -> s.length() < 4 (strings with no more than 3 characters),
  //  -  s -> s.contains("b") (strings containing "b"),
  // s -> (s.length() % 2) == 0 (strings of even length).

  public static void question3() {
    List<String> words = getList();
    System.out.println("3:");
    List<String> nL1 = getList()
            .stream()
            .filter(s -> s.length() < 4)
            .collect(Collectors.toList());
    System.out.println(nL1);

    List<String> nL2 = getList()
            .stream()
            .filter(s -> s.contains("b"))
            .collect(Collectors.toList());
    System.out.println(nL2);

    List<String> nL3 = getList()
            .stream()
            .filter(s -> (s.length() % 2) == 0)
            .collect(Collectors.toList());
    System.out.println(nL3);
  }


  // For each of the following lambda expressions (see Question 7 in Worksheet 2),
  // produce the list that contains the results of applying the function
  // defined by the lambda expression to each element of the original list
  // (use the map stream operation):
  // - s -> s + "!",
  //  s -> s.replace("i", "eye"),
  //  s -> s.toUpperCase().

  public static void question4() {
    List<String> words = getList();
    System.out.println("4:");
    List<String> nL1 = getList()
            .stream()
            .map(s -> s + "!")
            .collect(Collectors.toList());
    System.out.println(nL1);

    List<String> nL2 = getList()
            .stream()
            .map(s -> s.replace("i", "eye"))
            .collect(Collectors.toList());
    System.out.println(nL2);

    List<String> nL3 = getList()
            .stream()
            .map(s -> s.toUpperCase())
            .collect(Collectors.toList());
    System.out.println(nL3);
  }


  // (*) Turn the strings in the list into uppercase, keep only the
  // ones that are shorter than four characters, and, of what is remaining,
  // keep only the ones that contain "e", and print the first result.
  // Repeat the process, except checking for a "q" instead of an "e".

  public static void question5() {
    List<String> words = getList();
    System.out.println("5a:");
    Optional<String> nL1 = getList()
            .stream()
            .filter(s->s.length() < 4)
            .filter(s -> s.contains("e"))
            .map(s -> s.toUpperCase())
            .findFirst();
    System.out.println(nL1.get());

    System.out.println("5b:");
    Optional<String> nL2 = getList()
            .stream()
            .filter(s->s.length() < 4)
            .filter(s -> s.contains("q"))
            .map(s -> s.toUpperCase())
            .findFirst();
    System.out.println(nL2.get());

  }


  // (** ) The above example uses lazy evaluation, but it is not easy to see
  // that it is doing so. Create a variation of the above example that shows
  // that it is doing lazy evaluation. The simplest way is to track which
  // entries are turned into upper case.

  public static void question6() {
    List<String> words = getList();
    System.out.println("6:");
    // YOUR CODE
  }

  // (*) Produce a single String that is the result of concatenating the
  // uppercase versions of all the Strings.
  // For example, the result should be "HIHELLO...".
  // Hint: use a map operation that turns the words into upper case,
  // followed by a reduce operation that concatenates them.

  public static void question7() {
    List<String> words = getList();
    System.out.println("7:");
    String returnString = getList()
            .stream()
            .map(s -> s.toUpperCase())
            .reduce("", (s,e) -> s + e);
    System.out.println(returnString);
  }


  // (*) Produce a single String that is the result of concatenating the
  // uppercase versions of all the Strings.
  // For example, the result should be "HIHELLO...".
  // Use a single reduce operation, without using map.

  public static void question8() {
    List<String> words = getList();
    System.out.println("8:");
    String returnString = getList()
            .stream()
            .reduce("", (s,e) -> s.toUpperCase() + e.toUpperCase());
    System.out.println(returnString);
  }

  // (*) Produce a String that is all the words concatenated together, but
  // with commas in between. For example, the result should be "hi,hello,...".
  // Note that there is no comma at the beginning, before "hi", and also no comma
  // at the end, after the last word.

  public static void question9() {
    List<String> words = getList();
    System.out.println("9:");
    String returnString = getList()
            .stream()
            .collect(Collectors.joining(","));
    System.out.println(returnString);
  }

  public static void question12() {
    List<Integer> nums = Arrays.asList(getIntegerArray());
    System.out.println("12:");
    List <Integer> nums2 = nums
            .stream()
            .map(s -> s*s)
            .collect(Collectors.toList());
    System.out.println(nums2);
  }

  public static void question13() {
    List<Integer> nums = Arrays.asList(getIntegerArray());
    List<Integer> nums2 = Arrays.asList(getIntegerArray());
    System.out.println("13:");
    List <List<Integer>>  out = nums
            .stream()
            .flatMap(a -> nums2
                    .stream()
                    .flatMap(b -> Stream.of(Arrays.asList(a, b))))
            .collect(Collectors.toList());

    System.out.println(out);;
  }

  public static void question14() {
    List<Integer> nums = Arrays.asList(getIntegerArray());
    List<Integer> nums2 = Arrays.asList(getIntegerArray());
    System.out.println("14:");
    List <List<Integer>>  out = nums
            .stream()
            .flatMap(a -> nums2
                    .stream()
                    .flatMap(b -> Stream.of(Arrays.asList(a, b))))
            .collect(Collectors.toList());
  }




  // CONTINUE WITH THE REST OF THE QUESTIONS

  public static void main(String... args) { // varargs alternative to String[]
    question1();
    question2();
    question3();
    question4();
    question5();
    question7();
    question8();
    question9();
    question12();
    question13();
    question14();

  }
}