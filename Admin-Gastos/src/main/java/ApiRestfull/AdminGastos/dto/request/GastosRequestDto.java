package ApiRestfull.AdminGastos.dto.request;

public class GastosRequestDto {
    private Double amount;
    private String category;
    private String date;

    public GastosRequestDto() {
    }

    public GastosRequestDto(Double amount, String category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
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

    @Override
    public String toString() {
        return "GastosRequestDto{" +
                "amount=" + amount +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
