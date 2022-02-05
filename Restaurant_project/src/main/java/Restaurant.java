import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        LocalTime time = LocalTime.now();
        int isRestuarantStillOpen = time.compareTo(closingTime);
        int isRestaurantOpen = time.compareTo(openingTime);
        if(isRestuarantStillOpen <0 && isRestaurantOpen >=0){
            return true;
        }
        return false;                     

    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public LocalTime getOpeningTime() { return openingTime; }

    public void setOpeningTime(LocalTime openingTime){this.openingTime = openingTime;}

    public LocalTime getclosingTime() { return closingTime; }

    public void setclosingTime(LocalTime closingTime){this.closingTime = closingTime;}





    public List<Item> getMenu() {
        return this.menu;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

    public int getOrderCost(List<Item> item) {
        int totalOrderCost = 0;
        for (Item myItem : item) {
            totalOrderCost += myItem.getPrice();
        }
        return totalOrderCost;
    }

	

}
