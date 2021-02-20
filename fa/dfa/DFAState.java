package fa.dfa;

import fa.State;

public class DFAState extends State {

    public DFAState(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object obj) {
        // If object reference is null
        if (obj == null) {
            return false;
        }
        // If the object references the same hashcode.
        if (this == obj) {
            return true;
        }
        // Checks for the equality of the name rather than object
        if ((obj instanceof DFAState) && (((DFAState) obj).getName().equals(this.name))) {
            return true;
        } else {
            return false;
        }
    }

    // Overrides hashcode to return the name of the string's hashcode.
    public int hashCode() {
        return this.name.hashCode();
    }
}
