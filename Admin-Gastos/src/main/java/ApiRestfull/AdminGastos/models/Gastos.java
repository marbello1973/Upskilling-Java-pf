package ApiRestfull.AdminGastos.models;



public class Gastos {

    private Long id;
    private Double amount;
    private String category;
    private String date;
    private Boolean isActive;

    public Gastos(Long id, Double amount, String category, String date, Boolean isActive) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.isActive = isActive;
    }

    public Gastos() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
    }

    @Override
    public String toString() {
        return "Gastos{" +
                "id=" + id +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", isActive=" + isActive +
                '}';
    }
}
