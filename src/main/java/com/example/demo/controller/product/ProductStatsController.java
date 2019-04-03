package com.example.demo.controller.product;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.*;
//import static org.springframework.http.MediaType.*;

import java.util.*;
import java.math.BigDecimal;
import com.example.demo.controller.*;
import com.example.demo.dao.*;
import com.example.demo.entity.order.*;
import com.example.demo.entity.response.*;
import com.example.demo.entity.data.*;
import static com.example.demo.entity.response.OperationResponse.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductStatsController {

    @Autowired private JdbcTemplate jdbcTemplate;

    
    @RequestMapping(value = "/product-stats-by-quantity", method = RequestMethod.GET)
    public SingleDataSeriesResponse getProductStatsByQuantity() {

        String sql = "select product_name as name, sum(quantity) as value from order_details group by product_name ";
        String countType = new String();
        long count;
        SingleSeries singleSerise;
        SingleDataSeriesResponse resp = new SingleDataSeriesResponse();
        ArrayList<SingleSeries> dataItemList = new ArrayList<SingleSeries>();


        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        for (Map<String, Object> row : list) {
            singleSerise = new SingleSeries((String)row.get("name"),(BigDecimal)row.get("value") );
            dataItemList.add(singleSerise);
        }
        resp.setItems(dataItemList);
        resp.setOperationStatus(ResponseStatusEnum.SUCCESS);
        resp.setOperationMessage("Orders by Quantity Ordered");
        //resp.setItems(singleSerise);
        return resp;
    }


}