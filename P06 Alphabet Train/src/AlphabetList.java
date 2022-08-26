
public class AlphabetList implements SortedListADT<Cart> {

  private static final Cart MIN_CART = new Cart("A"); // The smallest cart that can be added to this
                                                      // sorted list
  private static final Cart MAX_CART = new Cart("Z"); // The largest cart that can be added to this
                                                      // sorted list
  private LinkedCart head; // head of this doubly linked list
  private LinkedCart tail; // tail of this doubly linked list
  private int size; // size of this list
  private int capacity; // maximum number of carts which can be stored in this list

  AlphabetList() // Creates an empty doubly linked list of carts with a capacity equals to 26
  {
    this.capacity = 26;
    this.size = 0;
    this.head = null;
    this.tail = null;

  }

  AlphabetList(int capacity) // Creates an empty doubly linked list of carts with a given capacity
  {
    this.head = null;
    this.tail = null;
    if (capacity <= 0) {
      throw new java.lang.IllegalArgumentException(
          "The capacity of this list must be a non zero a positive integer");
    } else {
      this.capacity = capacity;
      this.size = 0;
    }
  }

  public boolean isEmpty() {
    if (this.size == 0 && this.head == null && this.tail == null) {
      return true;
    }
    return false;

  }

  public int size() {
    return this.size;
  }

  public int capacity() {
    return this.capacity;
  }

  public void add(Cart newCart) {

    LinkedCart temp = head;

    if (!(newCart.toString().matches("^[A-Z]*$") && newCart.toString().length() == 1)) {
      throw new IllegalArgumentException(
          "Can only add carts carrying one upper case alphabetic letter in the range A..Z.");
    } else if (size == capacity) {
      throw new IllegalStateException("This list is full. Cannot add another cart.");
    } else {

      while (temp != null) {
        if (temp.toString().equals(newCart.toString())) {
          throw new IllegalArgumentException("Cannot duplicate letters or carts in this list.");
        }
        temp = temp.getNext();
      }

      temp = head;

      if (head.getCart().toString().compareTo(newCart.toString()) > 0) {
        LinkedCart lc = new LinkedCart(newCart);
        lc.setNext(head);
        head.setPrevious(lc);
        head = lc;
        size++;

      } else if (tail.getCart().toString().compareTo(newCart.toString()) < 0) {
        LinkedCart lc = new LinkedCart(newCart);
        tail.setNext(lc);
        lc.setPrevious(tail);
        tail = lc;
        size++;
      } else {
        temp = head;
        while (temp != null) {
          if (temp.getCart().toString().compareTo(newCart.toString()) > 0) {
            temp = temp.getPrevious(); // B
            LinkedCart temp3 = temp.getNext();// D
            LinkedCart temp2 = new LinkedCart(newCart); // C
            temp.setNext(temp2); // B C
            temp2.setPrevious(temp);
            temp2.setNext(temp3);
            temp3.setPrevious(temp2);
            size++;
            break;
          }
          temp = temp.getNext();
        }
      }
    }
  }


  @Override
  public void clear() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public Cart get(int index) {

    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid index.");
    }

    LinkedCart temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    return temp.getCart();
  }

  @Override
  public int indexOf(Cart findObject) {

    LinkedCart temp = head;
    int index = 0;
    while (temp != null) {
      if (temp.getCart().toString().equals(findObject.toString())) {
        return index;
      }
      index++;
      temp = temp.getNext();
    }
    return -1;
  }

  @Override
  public Cart remove(int index) {

    LinkedCart temp = head;

    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Invalid index.");
    } else if (index == 0) {
      LinkedCart rem = head;
      head = head.getNext();
      head.setPrevious(null);
      size--;
      return rem.getCart();
    } else if (index == size - 1) {
      for (int i = 0; i < size - 2; i++) {
        temp = temp.getNext();
      }
      LinkedCart rem = temp.getNext();
      temp.setNext(null);
      tail = temp;
      size--;
      return rem.getCart();
    } else {
      temp = head;
      for (int i = 0; i < index - 1; i++) {
        temp = temp.getNext();
      }
      Cart rem = temp.getNext().getCart();
      LinkedCart tempNew = temp.getNext().getNext();
      temp.setNext(tempNew);
      tempNew.setPrevious(temp);
      size--;

      return rem;
    }
  }

  public String readForward() {
    LinkedCart temp = head;
    String s = "";

    while (temp != null) {
      s = s + temp.getCart().toString();
      temp = temp.getNext();
    }
    return s;
  }

  public String readBackward() {
    LinkedCart temp = tail;
    String s = "";

    while (temp != null) {
      s = s + temp.getCart().toString();
      temp = temp.getPrevious();
    }
    return s;
  }

  public String toString() {
    String string = "This list contains " + size + " cart(s)";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    LinkedCart currentCart = head;
    while (currentCart != null) {
      string += currentCart.getCart().toString() + " ";
      currentCart = currentCart.getNext();
    }
    string += "]";
    return string;
  }
}
