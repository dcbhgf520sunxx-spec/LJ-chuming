package com.hzchum.pangu.common.pojo.vo;

import java.util.ArrayList;
import java.util.List;

public class ListVO<T> {
   private Integer totalElements;
   private List<T> content;

   public ListVO() {
      this.content = new ArrayList<>();
      this.totalElements = 0;
   }

   public ListVO(List<T> content) {
      if (content == null) {
         this.content = new ArrayList<>();
         this.totalElements = 0;
      } else {
         this.content = content;
         this.totalElements = content.size();
      }
   }

   public Integer getTotalElements() {
      return this.totalElements;
   }

   public List<T> getContent() {
      return this.content;
   }

   public void setTotalElements(final Integer totalElements) {
      this.totalElements = totalElements;
   }

   public void setContent(final List<T> content) {
      this.content = content;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ListVO)) {
         return false;
      } else {
         ListVO<?> other = (ListVO<?>)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$totalElements = this.getTotalElements();
            Object other$totalElements = other.getTotalElements();
            if (this$totalElements == null ? other$totalElements == null : this$totalElements.equals(other$totalElements)) {
               Object this$content = this.getContent();
               Object other$content = other.getContent();
               return this$content == null ? other$content == null : this$content.equals(other$content);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ListVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalElements = this.getTotalElements();
      result = result * 59 + ($totalElements == null ? 43 : $totalElements.hashCode());
      Object $content = this.getContent();
      return result * 59 + ($content == null ? 43 : $content.hashCode());
   }

   @Override
   public String toString() {
      return "ListVO(totalElements=" + this.getTotalElements() + ", content=" + this.getContent() + ")";
   }
}
