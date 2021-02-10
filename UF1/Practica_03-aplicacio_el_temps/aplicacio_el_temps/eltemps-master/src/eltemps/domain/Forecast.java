
package eltemps.domain;

import java.util.ArrayList;

public class Forecast {

    private String cod;
    private Double message;
    private City city;
    private Integer cnt;
    private java.util.List<Weather> list = new ArrayList<>();

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<Weather> getList() {
        return list;
    }

    public void setList(java.util.List<Weather> list) {
        this.list = list;
    }
}
