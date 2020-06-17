package by.devincubator.services.admin.admindto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsDTO {

    private String name;
    private int totalPassed;
    private double percentageOfCorrectAnswers;

}