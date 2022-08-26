import java.util.NoSuchElementException;

public class DeliveryQueue {

  private static final int INITIAL_CAPACITY = 20;
  private Delivery[] heap;
  private int size;

  public DeliveryQueue() {
    heap = new Delivery[INITIAL_CAPACITY];
    size = 0;
  }

  public void offerDelivery(Delivery deliver) {
    if (size == heap.length) {
      Delivery tmp[] = heap;
      this.heap = new Delivery[tmp.length * 2];

      for (int i = 0; i < tmp.length; i++) {
        this.heap[i] = tmp[i];
      }
      heap[size] = deliver;
      this.percolateUp(size);
      size++;
    } else {
      heap[size] = deliver;
      this.percolateUp(size);
      size++;
    }
  }

  public Delivery pollBestDelivery() {

    Delivery removed;
    if (this.isEmpty())
      throw new NoSuchElementException("Warning: Empty Heap!");
    else {
      removed = peek();
      heap[0] = heap[--this.size];
      int oldSize = this.getSize();
      for (int i = 0; i < oldSize; i++) {
        if (heap[i].equals(removed)) {
          heap[i] = null;
          size--;
        }
      }

      int index = 0;
      Delivery[] tmp = new Delivery[heap.length];
      for (int i = 0; i < heap.length; i++) {
        if (heap[i] != null) {
          tmp[index] = heap[i];
          heap[i] = null;
          index++;
        }
      }

      heap = tmp;
      this.heapify();
      return removed;
    }
  }

  public int getSize() {
    return this.size;
  }

  public Delivery peek() {
    if (this.isEmpty())
      throw new NoSuchElementException("Warning:Empty Heap!");
    else
      return this.heap[0];
  }

  private void percolateUp(int index) {
    while (index > 0) {
      int parentIndex = (index - 1) / 2;
      if (heap[index].compareTo(heap[parentIndex]) >= 0)
        return;
      else {
        Delivery tmp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = tmp;
        index = parentIndex;
        // percolateUp(index);
      }
    }
  }

  @Override
  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    for (int i = 0; i < size; i++)
      string += "\n" + heap[i].toString();
    string += " ]\n";
    return string;
  }

  private void percolateDown(int index) {

    int childIndex = 2 * index + 1;
    Delivery value = heap[index];

    while (childIndex < this.size) {
      // Find the min among the node and all the node's children
      Delivery minValue = value;
      int minIndex = -1;
      for (int i = 0; i < 2 && i + childIndex < this.size; i++) {
        if (heap[i + childIndex].compareTo(minValue) < 0) {
          minValue = heap[i + childIndex];
          minIndex = i + childIndex;
        }
      }

      if (minValue == value) {
        return;
      } else {
        Delivery tmp = heap[index];
        heap[index] = heap[minIndex];
        heap[minIndex] = tmp;
        index = minIndex;
        childIndex = 2 * index + 1;
        // percolateDown(index);
      }
    }
  }

  private void heapify() {
    for (int i = this.size / 2 - 1; i >= 0; i--)
      this.percolateDown(i);
  }

  public boolean isEmpty() {
    if (this.size == 0)
      return true;
    else
      return false;
  }

}
