package by.training.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.Duration;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class Service extends Entity{
    private long idSpecialization;
    private String serviceName;
    private BigDecimal cost;
    private Duration duration;
}
