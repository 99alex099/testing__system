package by.devincubator.dits.services.general.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {
    private String question;
    public boolean isCorrectly;
    private List<LiteratureDTO> literatureDTO;
}
