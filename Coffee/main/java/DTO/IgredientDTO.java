package DTO;

public class IgredientDTO {

    public IgredientDTO(String name, Integer number, Integer ID, Integer price) {
        this.name = name;
        this.number = number;
        this.ID = ID;
        this.price = price;
    }
    private String name;
    private Integer number;
    private Integer  ID;
    private Integer price;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


}
