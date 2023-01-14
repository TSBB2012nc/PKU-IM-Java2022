package Enitiy;

import lombok.Data;

@Data
public class CountryIndex {
    private String COUNTRY;
    private float D11;
    private float D111;
    private float D112;
    private float D12;
    private float D121;
    private float D122;
    private String YEAR;

    public String toJSON() {
        return String.format("{\"国家\": \"%s\", \"D11\":%f, \"D111\":%f, \"D112\":%f, \"D12\":%f, \"D121\":%f, \"D122\":%f, \"YEAR\":\"%s\"}",
                this.getCOUNTRY(), this.getD11(), this.getD111(), this.getD111(), this.getD12(), this.getD121(), this.getD122(), this.getYEAR());
    }

}
