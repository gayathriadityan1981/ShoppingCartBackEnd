package com.example.demo.entity.Product;

import lombok.*;
import java.util.*;
import com.example.demo.entity.response.*;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProductResponse extends PageResponse {
  //@ApiModelProperty(required = true, value = "")
  //private List<Product> items;
}