public class TestSimpleAdressBook{

    private static SimpleMutableList<Contact> list = new SimpleAdressBook();

    
    private static void testAdd(String name, String email, String phone){
        int numEntries = list.numberOfEntries();
        Contact c = new Contact(name, email, phone);
        System.out.println("Test: adding " + c);
        list.addEntry(c);
        System.out.println("* Adding " + c);
        int newNum = list.numberOfEntries();
        assert newNum==numEntries+1 : "number of entries should increase by one after add!";
        System.out.println("* Number of entries was increased by one");
        assert list.contains(c) : "list doesn't contain the new entry!";
        System.out.println("* list.contains(c) returns true");
        System.out.println("* Test with " + c + " passed.");
    }

    public static void main(String[] args){
        testAdd("Arnold Llloyd", "a@test.com", "12345");
        testAdd("Bernard Blake", "b@test.com", "234354");
        testAdd("Cecil B. Demented", "c@test.com", "234234");
    }
}
