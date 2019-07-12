package by.training.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Time;
import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class Session extends Entity {
    private long idClient;
    private long idService;
    private Date date;
    private Time time;
}
