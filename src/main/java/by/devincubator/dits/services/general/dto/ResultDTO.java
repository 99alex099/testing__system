package by.devincubator.dits.services.general.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class ResultDTO {
    private long correctAnswers;
    private long allAnswers;
    private List<LiteratureDTO> literatureDTO;

    public ResultDTO(long correctAnswers, long allAnswers, List<LiteratureDTO> literatureDTO) {
        this.correctAnswers = correctAnswers;
        this.allAnswers = allAnswers;
        this.literatureDTO = literatureDTO;
    }

    public double getCorrectPercent() {
        return correctAnswers / allAnswers * 100;
    }
}
