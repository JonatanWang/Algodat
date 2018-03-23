package T2;

import java.util.Objects;

/**
 * Write equals()
 * @author bfelt
 */
public class DirectoryEntry {
    
    public String name;
    public String number;
    
    public DirectoryEntry(String name, String number){
        this.name=name;
        this.number=number;
    }


    @Override
    public boolean equals(Object object) {
          /**
        DirectoryEntry newEntry = (DirectoryEntry) object;  // Can crash if in-data is not DirectoryEntry
        
         * if newEntry.name == null, check if this.name == null. 
         * => if this.name == null, return true;
         * 
         * if newEntry.name != null, check if newEntry.name.equals(this.name) 
         * => if equals, return  ture
         */
        //return (newEntry.name == null ? this.name == null : newEntry.name.equals(this.name));
        
        //NB:s solution without hashCode()
        if(object instanceof DirectoryEntry) {
            return ((DirectoryEntry) object).name.equals(name);
        } else {
            return super.equals(object);
        }
       
    }

    /**
    @Override
    public boolean equals(Object o) {
        if(o.equals(name)) {
            return true;
        }
        return false;
    }
     */

    // Auto-generated hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.number);
        return hash;
    }
}
