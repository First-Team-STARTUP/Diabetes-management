package org.startup.diabetes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphVO {

    private int emptyData;
    private LocalDate registDate;

}
