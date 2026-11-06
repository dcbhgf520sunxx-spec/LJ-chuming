package com.hzchum.pangu.common.util;

import com.github.pagehelper.Page;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import java.util.List;

public class PageUtil {
   public static <T> PageVO<T> listPage(Integer pageNum, Integer pageSize, List<T> collect) {
      Page<T> pages = new Page<>(pageNum, pageSize);
      int total = collect.size();
      pages.setTotal(total);
      int startIndex = (pageNum - 1) * pageSize;
      int endIndex = Math.min(startIndex + pageSize, total);
      pages.addAll(collect.subList(startIndex, endIndex));
      return new PageVO<>(pages);
   }
}
