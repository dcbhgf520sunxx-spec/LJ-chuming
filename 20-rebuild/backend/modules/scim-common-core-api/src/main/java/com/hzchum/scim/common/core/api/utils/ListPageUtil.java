package com.hzchum.scim.common.core.api.utils;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import java.util.ArrayList;
import java.util.List;

public class ListPageUtil {
   public static PageVO getPages(Integer pageNumber, Integer pageSize, List list) {
      PageVO page = new PageVO();
      if (list == null) {
         return null;
      }

      int size = list.size();
      if (pageSize > size) {
         pageSize = size;
      }

      if (pageSize != 0) {
         int maxPage = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
         if (pageNumber > maxPage) {
            pageNumber = maxPage;
         }

         page.setHasNextPage(pageNumber < maxPage);
      }

      int curIdx = pageNumber > 1 ? (pageNumber - 1) * pageSize : 0;
      List pageList = new ArrayList();

      for (int i = 0; i < pageSize && curIdx + i < size; i++) {
         pageList.add(list.get(curIdx + i));
      }

      page.setHasPreviousPage(pageNumber > 1);
      page.setContent(pageList);
      page.setTotalElements(list.size());
      return page;
   }
}
