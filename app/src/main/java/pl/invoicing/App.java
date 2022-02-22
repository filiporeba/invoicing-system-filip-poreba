package pl.invoicing;

public class App {

  public String getGreeting() {
    return "Hellon World!";
  }

  public static void main(String[] args) {
    System.out.println(new App().getGreeting());
  }
}
