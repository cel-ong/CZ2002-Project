import java.io.Serializable;
import java.util.ArrayList;
public class SetItem implements Serializable {

	private String name;
	private double price;
	private ArrayList<AlaCarteItem> alaCarteMenuList  ;
	private int setID;
	private String description;
	private boolean availability;
	
	/**
	 * 
	 * @param setID
	 * @param name
	 * @param price
	 * @param description
	 */
	public SetItem(int setID, String name, double price, String description) {
		this.setID = setID;
		this.name = name;
		this.price = price;
		this.description = description;
		this.alaCarteMenuList = new ArrayList<AlaCarteItem>();
		this.availability = true;

	}

	/**
	 * 
	 * @param alacarteID
	 */
	public void addItem(AlaCarteItem alacarteID) {
		alaCarteMenuList.add(alacarteID);
	}

	/**
	 * 
	 * @param alacarteID
	 */
	public void deleteItem(AlaCarteItem alacarteID) {
		alaCarteMenuList.remove(alacarteID);
		
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public ArrayList<AlaCarteItem> getAlaCarteMenuList() {
		return this.alaCarteMenuList;
	}

	/**
	 * 
	 * @param alaCarteMenuList
	 */
	public void setAlaCarteMenuList(ArrayList<AlaCarteItem> alaCarteMenuList) {
		this.alaCarteMenuList = alaCarteMenuList;
	}

	public int getSetID() {
		return this.setID;
	}

	/**
	 * 
	 * @param setID
	 */
	public void setSetID(int setID) {
		this.setID = setID;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getAvailability() {
		return this.availability;
	}

	/**
	 * 
	 * @param availability
	 */
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

}