// Brandon Tsang
// March 29, 2019
// ICS4U1-05 | Mr. Radulovic

public interface Sorter {
    /**
     * This method sets the current list that is used in this class.  The original list should never be changed.
     * @param list - a reference to the list of elements to be sorted.
     */
    public void setList(int[] list);

    /**
     * This methods sorts the list in increasing order.
     * @param type - parameter to be used to choose an internal sorting method.
     * If type = 1 use sorting method 1
     * If type = 2 use sorting method 2
     * etc....
     */
    public void sort(int type);

    /**
     * This method prints out the current state of the list
     * @return a String representing the list, either sorted or not depending on whether sort() was previously called.
     * The format of the String is: num1, num2, num3, ...
     */
    public String toString();
}
