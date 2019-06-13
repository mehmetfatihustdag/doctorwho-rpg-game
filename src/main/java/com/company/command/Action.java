package com.company.command;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author fustdag <br>
 *         <b>Action command enum for application</b>
 *
 */
public enum Action {

	//Actions
	SAVE(1,TypeAction.SAVE_AND_QUIT),
	EXPLORE(2,TypeAction.EXPLORE),
	INVALID_ACTION(3,TypeAction.INVALID_ACTION);

	private Integer value;
	private TypeAction typeAction;

	// Reverse-lookup map for getting a day from an abbreviation
	private static final Map<Integer, TypeAction> lookup = new HashMap<>();

	static {
		for (Action d : Action.values()) {
			lookup.put(d.getValue(), d.typeAction);
		}
	}

	Action(Integer value, TypeAction typeAction) {
		this.value = value;
		this.typeAction = typeAction;
	}



	public Integer getValue() {
		return value;
	}

	public TypeAction getTypeAction() {
		return typeAction;
	}

	public static TypeAction get(Integer value) {
		if(lookup.get(value) ==null){
			return TypeAction.INVALID_ACTION;
		}
		return lookup.get(value);
	}
}
