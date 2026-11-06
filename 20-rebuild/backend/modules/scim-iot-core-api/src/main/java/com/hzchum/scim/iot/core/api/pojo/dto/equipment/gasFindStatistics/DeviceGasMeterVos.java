package com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics;

import java.util.List;

public class DeviceGasMeterVos {
   private List<GasContents> contents;
   private Integer pageNumber;
   private Integer pageSize;
   private Integer totalElements;
   private Integer totalPages;

   public static DeviceGasMeterVos.DeviceGasMeterVosBuilder builder() {
      return new DeviceGasMeterVos.DeviceGasMeterVosBuilder();
   }

   public List<GasContents> getContents() {
      return this.contents;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public Integer getTotalElements() {
      return this.totalElements;
   }

   public Integer getTotalPages() {
      return this.totalPages;
   }

   public void setContents(final List<GasContents> contents) {
      this.contents = contents;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   public void setTotalElements(final Integer totalElements) {
      this.totalElements = totalElements;
   }

   public void setTotalPages(final Integer totalPages) {
      this.totalPages = totalPages;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeviceGasMeterVos)) {
         return false;
      }

      DeviceGasMeterVos other = (DeviceGasMeterVos)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pageNumber = this.getPageNumber();
      Object other$pageNumber = other.getPageNumber();
      if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
         Object this$pageSize = this.getPageSize();
         Object other$pageSize = other.getPageSize();
         if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
            Object this$totalElements = this.getTotalElements();
            Object other$totalElements = other.getTotalElements();
            if (this$totalElements == null ? other$totalElements == null : this$totalElements.equals(other$totalElements)) {
               Object this$totalPages = this.getTotalPages();
               Object other$totalPages = other.getTotalPages();
               if (this$totalPages == null ? other$totalPages == null : this$totalPages.equals(other$totalPages)) {
                  Object this$contents = this.getContents();
                  Object other$contents = other.getContents();
                  return this$contents == null ? other$contents == null : this$contents.equals(other$contents);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DeviceGasMeterVos;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $totalElements = this.getTotalElements();
      result = result * 59 + ($totalElements == null ? 43 : $totalElements.hashCode());
      Object $totalPages = this.getTotalPages();
      result = result * 59 + ($totalPages == null ? 43 : $totalPages.hashCode());
      Object $contents = this.getContents();
      return result * 59 + ($contents == null ? 43 : $contents.hashCode());
   }

   @Override
   public String toString() {
      return "DeviceGasMeterVos(contents="
         + this.getContents()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", totalElements="
         + this.getTotalElements()
         + ", totalPages="
         + this.getTotalPages()
         + ")";
   }

   public DeviceGasMeterVos(
      final List<GasContents> contents, final Integer pageNumber, final Integer pageSize, final Integer totalElements, final Integer totalPages
   ) {
      this.contents = contents;
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
      this.totalElements = totalElements;
      this.totalPages = totalPages;
   }

   public DeviceGasMeterVos() {
   }

   public static class DeviceGasMeterVosBuilder {
      private List<GasContents> contents;
      private Integer pageNumber;
      private Integer pageSize;
      private Integer totalElements;
      private Integer totalPages;

      DeviceGasMeterVosBuilder() {
      }

      public DeviceGasMeterVos.DeviceGasMeterVosBuilder contents(final List<GasContents> contents) {
         this.contents = contents;
         return this;
      }

      public DeviceGasMeterVos.DeviceGasMeterVosBuilder pageNumber(final Integer pageNumber) {
         this.pageNumber = pageNumber;
         return this;
      }

      public DeviceGasMeterVos.DeviceGasMeterVosBuilder pageSize(final Integer pageSize) {
         this.pageSize = pageSize;
         return this;
      }

      public DeviceGasMeterVos.DeviceGasMeterVosBuilder totalElements(final Integer totalElements) {
         this.totalElements = totalElements;
         return this;
      }

      public DeviceGasMeterVos.DeviceGasMeterVosBuilder totalPages(final Integer totalPages) {
         this.totalPages = totalPages;
         return this;
      }

      public DeviceGasMeterVos build() {
         return new DeviceGasMeterVos(this.contents, this.pageNumber, this.pageSize, this.totalElements, this.totalPages);
      }

      @Override
      public String toString() {
         return "DeviceGasMeterVos.DeviceGasMeterVosBuilder(contents="
            + this.contents
            + ", pageNumber="
            + this.pageNumber
            + ", pageSize="
            + this.pageSize
            + ", totalElements="
            + this.totalElements
            + ", totalPages="
            + this.totalPages
            + ")";
      }
   }
}
