package com.example.ratingsdataservice.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RatingsDataList_Model {

    private List<RatingsData_Model> ratingsData_List;
}
