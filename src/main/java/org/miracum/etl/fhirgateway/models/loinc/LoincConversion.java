package org.miracum.etl.fhirgateway.models.loinc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "loinc",
        "unit",
        "value",
        "id"
})
public class LoincConversion {

    @JsonProperty("loinc")
    private String loinc;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("value")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal value;
    @JsonProperty("id")
    private String id;

    @JsonProperty("loinc")
    public String getLoinc() {
        return loinc;
    }

    @JsonProperty("loinc")
    public void setLoinc(String loinc) {
        this.loinc = loinc;
    }

    @JsonProperty("unit")
    public String getUnit() {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @JsonProperty("value")
    public BigDecimal getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LoincConversion{" +
                "loinc='" + loinc + '\'' +
                ", unit='" + unit + '\'' +
                ", value=" + value +
                ", id='" + id + '\'' +
                '}';
    }
}