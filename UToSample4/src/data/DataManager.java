package data;

public abstract class DataManager {
	protected abstract void insert(String text);
	protected abstract void update(String text);
	protected abstract void delete();
	protected abstract void sortInsert();
	protected abstract void sortIndex();
	protected abstract void out();
}
