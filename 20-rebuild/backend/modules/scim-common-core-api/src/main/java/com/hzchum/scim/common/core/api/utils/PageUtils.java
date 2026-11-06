package com.hzchum.scim.common.core.api.utils;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.List;

public class PageUtils {
   public static <T, E> PageInfo<T> getPageInfo(List<T> list, Page<E> page) {
      PageInfo<T> pageInfo = new PageInfo<>();
      pageInfo.setTotal(page.getTotal());
      pageInfo.setList(list);
      pageInfo.setHasNextPage(page.getPages() > page.getCurrent());
      pageInfo.setHasPreviousPage(page.getCurrent() > 1L);
      return pageInfo;
   }

   public static <T, E> PageInfo<T> getPageInfo(List<T> list, List<E> sourceList) {
      PageInfo<E> sourcePageInfo = new PageInfo<>(sourceList);
      PageInfo<T> pageInfo = new PageInfo<>();
      pageInfo.setHasNextPage(sourcePageInfo.isHasNextPage());
      pageInfo.setHasPreviousPage(sourcePageInfo.isHasPreviousPage());
      pageInfo.setTotal(sourcePageInfo.getTotal());
      pageInfo.setList(list);
      return pageInfo;
   }

   public static <T> com.github.pagehelper.Page<T> getPageVO(List<T> list, Integer pageNumber, Integer pageSize) {
      if (CollectionUtils.isNotEmpty(list)) {
         com.github.pagehelper.Page<T> pages = new com.github.pagehelper.Page<>(pageNumber, pageSize);
         int total = list.size();
         pages.setTotal(total);
         int startIndex = (pageNumber - 1) * pageSize;
         if (startIndex > list.size()) {
            startIndex = 0;
         }

         int endIndex = Math.min(startIndex + pageSize, total);
         pages.addAll(list.subList(startIndex, endIndex));
         return pages;
      } else {
         return new com.github.pagehelper.Page<>();
      }
   }

   public static <T> List<T> getPage(List<T> list, int pageNum, int pageSize) {
      if (list != null && !list.isEmpty() && pageSize > 0 && pageNum > 0) {
         int totalItems = list.size();
         int fromIndex = (pageNum - 1) * pageSize;
         if (fromIndex < totalItems && fromIndex >= 0) {
            int toIndex = Math.min(fromIndex + pageSize, totalItems);
            return list.subList(fromIndex, toIndex);
         } else {
            return new ArrayList<>();
         }
      } else {
         return new ArrayList<>();
      }
   }
}
