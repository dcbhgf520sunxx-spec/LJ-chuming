package com.hzchum.pangu.common.pojo;

import java.util.List;

public interface BasePage {
   Integer page = 1;
   Integer size = 10;
   List<String> sort = null;
}
