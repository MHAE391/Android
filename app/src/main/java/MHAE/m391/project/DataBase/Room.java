package MHAE.m391.project.DataBase;

public class Room {
    private int Id;
    private String Name;
    private int Price;
    private int TakeOrNot;
    private int NumberOfRaters;
    private long TotalRating;
    private  String Description;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Room(int id, String name, int price, int takeOrNot, int numberOfRaters,
                long totalRating, String description) {
        Id = id;
        Name = name;
        Price = price;
        TakeOrNot = takeOrNot;
        NumberOfRaters = numberOfRaters;
        TotalRating = totalRating;
        Description=description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getTakeOrNot() {
        return TakeOrNot;
    }

    public void setTakeOrNot(int takeOrNot) {
        TakeOrNot = takeOrNot;
    }

    public int getNumberOfRaters() {
        return NumberOfRaters;
    }

    public void setNumberOfRaters(int numberOfRaters) {
        NumberOfRaters = numberOfRaters;
    }

    public long getTotalRating() {
        return TotalRating;
    }

    public void setTotalRating(long totalRating) {
        TotalRating = totalRating;
    }
}
