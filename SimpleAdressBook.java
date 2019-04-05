import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleAdressBook  implements SimpleMutableList<Contact>{
    private static final String LOG_FILE =
            System.getProperty("user.home") + System.getProperty("file.separator") + "IdeaProjects"+
                    System.getProperty("file.separator") + "Labb2"+
                    System.getProperty("file.separator") +
                    ".address_book.log";


    private static final String ADDRESS_FILE =
            System.getProperty("user.home") +System.getProperty("file.separator") + "IdeaProjects"+
                    System.getProperty("file.separator") + "Labb2"+
                    System.getProperty("file.separator") +
                    ".address_book";

    private List<Contact> entries;

    public SimpleAdressBook() {
        entries = new ArrayList<>();
    }


    public int numberOfEntries(){
        return entries.size();
    }

    public void listEntries(){
        List<Contact> copy = new ArrayList<>(entries);
        Collections.sort(copy);
        for(Contact c : copy){
            System.out.println(c);
        }
    }

    public void addEntry(Contact c){
        entries.add(c);
    }

    public boolean contains(Contact c){
        return entries.contains(c);
    }


    
    private void logException(Exception e){
        try{
            e.printStackTrace
                    (new PrintWriter(new FileWriter(LOG_FILE),true));
        }catch(Exception logErr){
            System.err.print("Could not log exception: ");
            System.err.println(e.getMessage());
            logErr.printStackTrace();
        }
    }


    public void load(){
        try{
            if (!new File(ADDRESS_FILE).exists()){
                System.out.println("INFO: There is no address book file.");
                return;
            }
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream
                            (ADDRESS_FILE));
            Contact c;
            entries =(List<Contact>)in.readObject();
            in.close();
        }catch(Exception e){
            System.err.println("Could not load address book");
            logException(e);
            throw new RuntimeException("Your address book is corrupted.");
        }
    }

    public void save(){
        try{
            System.out.println("Saving in " + ADDRESS_FILE + "...");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ADDRESS_FILE));
            out.writeObject(entries);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
