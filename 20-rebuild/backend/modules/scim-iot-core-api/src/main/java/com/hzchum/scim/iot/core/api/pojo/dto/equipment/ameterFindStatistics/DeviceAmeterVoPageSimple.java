package com.hzchum.scim.iot.core.api.pojo.dto.equipment.ameterFindStatistics;

import java.util.List;

public class DeviceAmeterVoPageSimple {
   private int pageNumber;
   private int pageSize;
   private int totalElements;
   private int totalPages;
   private List<AmContents> contents;

   public static DeviceAmeterVoPageSimple.DeviceAmeterVoPageSimpleBuilder builder() {
      return new DeviceAmeterVoPageSimple.DeviceAmeterVoPageSimpleBuilder();
   }

   public int getPageNumber() {
      return this.pageNumber;
   }

   public int getPageSize() {
      return this.pageSize;
   }

   public int getTotalElements() {
      return this.totalElements;
   }

   public int getTotalPages() {
      return this.totalPages;
   }

   public List<AmContents> getContents() {
      return this.contents;
   }

   public void setPageNumber(final int pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final int pageSize) {
      this.pageSize = pageSize;
   }

   public void setTotalElements(final int totalElements) {
      this.totalElements = totalElements;
   }

   public void setTotalPages(final int totalPages) {
      this.totalPages = totalPages;
   }

   public void setContents(final List<AmContents> contents) {
      this.contents = contents;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeviceAmeterVoPageSimple)) {
         return false;
      }

      DeviceAmeterVoPageSimple other = (DeviceAmeterVoPageSimple)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getPageNumber() != other.getPageNumber()) {
         return false;
      }

      if (this.getPageSize() != other.getPageSize()) {
         return false;
      }

      if (this.getTotalElements() != other.getTotalElements()) {
         return false;
      }

      if (this.getTotalPages() != other.getTotalPages()) {
         return false;
      }

      Object this$contents = this.getContents();
      Object other$contents = other.getContents();
      return this$contents == null ? other$contents == null : this$contents.equals(other$contents);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DeviceAmeterVoPageSimple;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getPageNumber();
      result = result * 59 + this.getPageSize();
      result = result * 59 + this.getTotalElements();
      result = result * 59 + this.getTotalPages();
      Object $contents = this.getContents();
      return result * 59 + ($contents == null ? 43 : $contents.hashCode());
   }

   @Override
   public String toString() {
      return "DeviceAmeterVoPageSimple(pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ", totalElements="
         + this.getTotalElements()
         + ", totalPages="
         + this.getTotalPages()
         + ", contents="
         + this.getContents()
         + ")";
   }

   public DeviceAmeterVoPageSimple(final int pageNumber, final int pageSize, final int totalElements, final int totalPages, final List<AmContents> contents) {
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
      this.totalElements = totalElements;
      this.totalPages = totalPages;
      this.contents = contents;
   }

   public DeviceAmeterVoPageSimple() {
   }

   public static class DeviceAmeterVoPageSimpleBuilder {
      private int pageNumber;
      private int pageSize;
      private int totalElements;
      private int totalPages;
      private List<AmContents> contents;

      DeviceAmeterVoPageSimpleBuilder() {
      }

      public DeviceAmeterVoPageSimple.DeviceAmeterVoPageSimpleBuilder pageNumber(final int pageNumber) {
         this.pageNumber = pageNumber;
         return this;
      }

      public DeviceAmeterVoPageSimple.DeviceAmeterVoPageSimpleBuilder pageSize(final int pageSize) {
         this.pageSize = pageSize;
         return this;
      }

      public DeviceAmeterVoPageSimple.DeviceAmeterVoPageSimpleBuilder totalElements(final int totalElements) {
         this.totalElements = totalElements;
         return this;
      }

      public DeviceAmeterVoPageSimple.DeviceAmeterVoPageSimpleBuilder totalPages(final int totalPages) {
         this.totalPages = totalPages;
         return this;
      }

      public DeviceAmeterVoPageSimple.DeviceAmeterVoPageSimpleBuilder contents(final List<AmContents> contents) {
         this.contents = contents;
         return this;
      }

      public DeviceAmeterVoPageSimple build() {
         return new DeviceAmeterVoPageSimple(this.pageNumber, this.pageSize, this.totalElements, this.totalPages, this.contents);
      }

      @Override
      public String toString() {
         return "DeviceAmeterVoPageSimple.DeviceAmeterVoPageSimpleBuilder(pageNumber="
            + this.pageNumber
            + ", pageSize="
            + this.pageSize
            + ", totalElements="
            + this.totalElements
            + ", totalPages="
            + this.totalPages
            + ", contents="
            + this.contents
            + ")";
      }
   }
}
