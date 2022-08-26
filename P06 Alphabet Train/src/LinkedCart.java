
public class LinkedCart {

  private final Cart CART; // data field of this linked Cart
  private LinkedCart previous; // reference to the previous linked cart in
  // a list of carts
  private LinkedCart next; // reference to the next linked cart in a list of carts

  public LinkedCart(Cart cart) {
    this.CART = cart;
    previous = null;
    next = null;

  }

  public LinkedCart(Cart cart, LinkedCart previous, LinkedCart next) {
    this.CART = cart;
    this.previous = previous;
    this.next = next;
  }

  public Cart getCart() {
    return this.CART;
  }

  public LinkedCart getPrevious() {
    return this.previous;
  }
  
  public LinkedCart getNext() {
    return this.next;
  }


  public void setNext(LinkedCart next) {
    this.next = next;
  }

  public void setPrevious(LinkedCart previous) {
    this.previous = previous;
  }


}
