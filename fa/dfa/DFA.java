package fa.dfa;

import java.util.Set;
import java.util.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import fa.State;
import java.util.LinkedHashSet; 

public class DFA implements DFAInterface {

	// store start state
	private DFAState startState;
	// store final
	private Set<DFAState> finalState;
	// store alpha
	private Set<Character> alphabet;
	// store states
	private Set<DFAState> states;
	// store transitions
	private HashMap<DFAState, HashMap<Character, DFAState>> transitions;
	// store currentState
	private DFAState currentState;

	public DFA() {
		// Instanitate all private variables at runtime
		transitions = new HashMap<DFAState, HashMap<Character, DFAState>>();
		finalState = new LinkedHashSet<DFAState>();
		alphabet = new LinkedHashSet<Character>();
		states = new LinkedHashSet<DFAState>();
		currentState = startState;

	}

	public String toString() {

		String definition = "Q = { ";
		for (DFAState q : states) {
			definition += q.getName() + " ";
		}

		definition += "}\n";
		definition += "Sigma = { ";

		for (char sigma : alphabet) {
			definition += sigma + " ";
		}

		definition += "}\n";
		definition += "delta = \n\t";

		for (char sigma : alphabet) {
			definition += "\t";
			definition += sigma ;
		}

		definition += "\n";

		for(DFAState q: states) {

			definition += "\t";

			HashMap<Character, DFAState> map = transitions.get(q);
			
			definition += q.getName() + "\t";

			Set set = map.entrySet();
			Iterator iterator = set.iterator();

			while(iterator.hasNext()) {
				Map.Entry mentry = (Map.Entry)iterator.next();
				definition += mentry.getValue() + "\t";
			}

			definition += "\n";
		
		}

		definition += "q0 = " + startState + "\n";
		definition += "F = { " + getFinalStateString(finalState) + "}";

		return definition;
	}
	
	/**
	 * To String helper method
	 * 
	 * @return a string with the names of final states
	 */
	public String getFinalStateString(Set<DFAState> finalStates) {
		
		String finalStatesString = "";
		
		for(DFAState s: finalStates) {
			finalStatesString += s.getName() + " ";
		}

		return finalStatesString;

	}

	public boolean accepts(String s) {
		currentState = startState;
		// Empty string
		if (s.equals("e")) {
			for (DFAState b : finalState) {
				if (currentState.equals(b)) {
					return true;
				}
			}
			return false;

		} else

		{
			DFAState transitionState;
			// Goes character by character through the given string
			for (int i = 0; i < s.length(); i++) {
				transitionState = (DFAState) getToState(currentState, s.charAt(i));
				currentState = transitionState;
			}

			// If our final state set contains the string s return true, otherwise false
			for (DFAState b : finalState) {
				if (currentState.equals(b)) {
					return true;
				}
			}
			return false;
		}
	}

	public State getToState(DFAState from, char onSymb) {
		// get the value of the innermap <Character, DFAState>
		HashMap<Character, DFAState> innerMap = new HashMap<Character, DFAState>();
		innerMap = transitions.get(from);
		// return DFAState from innermap and cast to type State
		return (State) innerMap.get(onSymb);

	}

	public void addStartState(String name) {
		// startStates = new HashSet<DFAState>();
		// Create new start state
		startState = new DFAState(name);
		// add to states set
		states.add(startState);

		currentState = startState;

	}

	public void addState(String name) {

		// Adds the DFA state to state set
		states.add(new DFAState(name));

	}


	public void addFinalState(String name) {

		finalState.add(new DFAState(name));
		states.add(new DFAState(name));
	}

	public void addTransition(String fromState, char onSymb, String toState) {
		alphabet.add(onSymb);
		// Put inner map and to state into the transition map
		HashMap<Character, DFAState> innerMap = new HashMap<Character, DFAState>();
		if (transitions.containsKey(new DFAState(fromState))) {
			innerMap = transitions.get(new DFAState(fromState));
			innerMap.put(onSymb, new DFAState(toState));

		} else {
			// Put state and sybmol inside inner map
			innerMap.put(onSymb, new DFAState(toState));
			// Add the onSymb to the alphabet if not already added

		}
		transitions.put(new DFAState(fromState), innerMap);

	}

	/**
	 * Getter for Q
	 * 
	 * @return a set of states that FA has
	 */
	public Set<? extends State> getStates() {

		return states;

	}

	/**
	 * Getter for F
	 * 
	 * @return a set of final states that FA has
	 */
	public Set<? extends State> getFinalStates() {
		return finalState;

	}

	/**
	 * Getter for q0
	 * 
	 * @return the start state of FA
	 */
	public State getStartState() {
		return startState;

	}

	/**
	 * Getter for Sigma
	 * 
	 * @return the alphabet of FA
	 */
	public Set<Character> getABC() {
		return alphabet;

	}

}
