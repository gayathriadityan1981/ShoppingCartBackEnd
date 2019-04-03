package com.example.demo.entity.session;

//import io.swagger.annotations.*;
import lombok.*;
import java.util.*;
import com.example.demo.entity.response.*;


@Data
@EqualsAndHashCode(callSuper=false)
public class SessionResponse extends OperationResponse{

    //@ApiModelProperty(required=true,value="")
    private SessionItem item;
}
