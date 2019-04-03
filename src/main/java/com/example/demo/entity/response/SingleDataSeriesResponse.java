//This is a common http response model for providing data series

package com.example.demo.entity.response;

import lombok.*;
import java.util.*;
//import io.swagger.annotations.*;
import com.example.demo.entity.data.*;

@Data
@EqualsAndHashCode(callSuper=false)
public class SingleDataSeriesResponse extends OperationResponse {
    private List<SingleSeries> items;
}