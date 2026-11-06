package com.hzchum.pangu.common.pojo.vo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.List;

public class PageVO<T> {
   protected boolean hasPreviousPage;
   protected boolean hasNextPage;
   protected long totalElements;
   protected List<T> content;

   public PageVO() {
      this(new PageInfo<>(new ArrayList<>()));
   }

   public PageVO(Page page, List<T> list) {
      this.totalElements = page.getTotal();
      this.content = list;
      this.hasPreviousPage = page.toPageInfo().isHasPreviousPage();
      this.hasNextPage = page.toPageInfo().isHasNextPage();
   }

   public PageVO(List<T> pageInfo) {
      this(new PageInfo<>(pageInfo));
   }

   public PageVO(PageInfo<T> pageInfo) {
      this.hasPreviousPage = pageInfo.isHasPreviousPage();
      this.hasNextPage = pageInfo.isHasNextPage();
      this.totalElements = pageInfo.getTotal();
      this.content = pageInfo.getList();
   }

   public PageVO(PageInfo pageInfo, List<T> list) {
      this.hasPreviousPage = pageInfo.isHasPreviousPage();
      this.hasNextPage = pageInfo.isHasNextPage();
      this.totalElements = pageInfo.getTotal();
      this.content = list;
   }

   public boolean isHasPreviousPage() {
      return this.hasPreviousPage;
   }

   public boolean isHasNextPage() {
      return this.hasNextPage;
   }

   public long getTotalElements() {
      return this.totalElements;
   }

   public List<T> getContent() {
      return this.content;
   }

   public void setHasPreviousPage(final boolean hasPreviousPage) {
      this.hasPreviousPage = hasPreviousPage;
   }

   public void setHasNextPage(final boolean hasNextPage) {
      this.hasNextPage = hasNextPage;
   }

   public void setTotalElements(final long totalElements) {
      this.totalElements = totalElements;
   }

   public void setContent(final List<T> content) {
      this.content = content;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PageVO)) {
         return false;
      }

      PageVO<?> other = (PageVO<?>)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isHasPreviousPage() != other.isHasPreviousPage()) {
         return false;
      }

      if (this.isHasNextPage() != other.isHasNextPage()) {
         return false;
      }

      if (this.getTotalElements() != other.getTotalElements()) {
         return false;
      }

      Object this$content = this.getContent();
      Object other$content = other.getContent();
      return this$content == null ? other$content == null : this$content.equals(other$content);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PageVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isHasPreviousPage() ? 79 : 97);
      result = result * 59 + (this.isHasNextPage() ? 79 : 97);
      long $totalElements = this.getTotalElements();
      result = result * 59 + (int)($totalElements >>> 32 ^ $totalElements);
      Object $content = this.getContent();
      return result * 59 + ($content == null ? 43 : $content.hashCode());
   }

   @Override
   public String toString() {
      return "PageVO(hasPreviousPage="
         + this.isHasPreviousPage()
         + ", hasNextPage="
         + this.isHasNextPage()
         + ", totalElements="
         + this.getTotalElements()
         + ", content="
         + this.getContent()
         + ")";
   }
}
