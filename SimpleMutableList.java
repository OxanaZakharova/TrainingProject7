public interface SimpleMutableList<E> {

    int numberOfEntries();
    void listEntries();
    void  addEntry(E entry);
    void save();
    void load();
    boolean contains(E entry);

}
