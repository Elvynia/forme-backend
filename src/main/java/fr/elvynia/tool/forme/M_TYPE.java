package fr.elvynia.tool.forme;

public enum M_TYPE {

	DEV(0, "Analyse et développements"), TRAINING(1, "Formation");

	public static M_TYPE byId(final int id) {
		M_TYPE result = null;
		for (M_TYPE type : M_TYPE.values()) {
			if (type.id == id) {
				result = type;
				break;
			}
		}
		return result;
	}

	private final int id;
	private final String title;

	private M_TYPE(final int id, final String title) {
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

}
