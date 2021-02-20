package fa.dfa;

import fa.State;

public class DFAState extends State {

    public DFAState(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
