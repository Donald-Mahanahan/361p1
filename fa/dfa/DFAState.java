package fa.dfa;

import fa.State;

/**
 * Represents a DFAState and holds various properties associated with said
 * state.
 * 
 * @author Aidan Leuck, Zach Sherwood
 */
public class DFAState extends State {
    /**
     * Constructor for the DFAState
     * 
     * @param name - The name of the DFA state
     */
    public DFAState(String name) {
        this.name = name;
    }

    /**
     * gets the name of the state
     * 
     * @return : Name of the state
     */
    public String getName() {
        return this.name;
    }

    /**
     * Override of the equals method, checks for equality of name
     * 
     * @param obj: Object to compare equality to this
     * @return true if object is equal false if not
     */
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

    /**
     * Override hashcode
     * 
     * @return the value of the name's hashcode
     */
    public int hashCode() {
        return this.name.hashCode();
    }
}
