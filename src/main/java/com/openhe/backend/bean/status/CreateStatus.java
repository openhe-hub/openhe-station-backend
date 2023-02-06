package com.openhe.backend.bean.status;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateStatus {
    String target;
    boolean isSuccess;
}
