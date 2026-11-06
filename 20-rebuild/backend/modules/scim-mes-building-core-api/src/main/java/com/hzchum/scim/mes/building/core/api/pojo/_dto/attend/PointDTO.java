package com.hzchum.scim.mes.building.core.api.pojo._dto.attend;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ExcelTarget("PointDTO")
@ApiModel("点位DTO")
public class PointDTO {
   @ApiModelProperty(name = "lng", value = "经度", notes = "经度")
   private String lng;
   @ApiModelProperty(name = "lat", value = "纬度", notes = "纬度")
   private String lat;
   @ApiModelProperty(name = "sort", value = "序号", notes = "序号")
   private Integer sort;

   public static PointDTO.PointDTOBuilder builder() {
      return new PointDTO.PointDTOBuilder();
   }

   public String getLng() {
      return this.lng;
   }

   public String getLat() {
      return this.lat;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setLng(final String lng) {
      this.lng = lng;
   }

   public void setLat(final String lat) {
      this.lat = lat;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PointDTO)) {
         return false;
      }

      PointDTO other = (PointDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$lng = this.getLng();
         Object other$lng = other.getLng();
         if (this$lng == null ? other$lng == null : this$lng.equals(other$lng)) {
            Object this$lat = this.getLat();
            Object other$lat = other.getLat();
            return this$lat == null ? other$lat == null : this$lat.equals(other$lat);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PointDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $lng = this.getLng();
      result = result * 59 + ($lng == null ? 43 : $lng.hashCode());
      Object $lat = this.getLat();
      return result * 59 + ($lat == null ? 43 : $lat.hashCode());
   }

   @Override
   public String toString() {
      return "PointDTO(lng=" + this.getLng() + ", lat=" + this.getLat() + ", sort=" + this.getSort() + ")";
   }

   public PointDTO() {
   }

   public PointDTO(final String lng, final String lat, final Integer sort) {
      this.lng = lng;
      this.lat = lat;
      this.sort = sort;
   }

   public static class PointDTOBuilder {
      private String lng;
      private String lat;
      private Integer sort;

      PointDTOBuilder() {
      }

      public PointDTO.PointDTOBuilder lng(final String lng) {
         this.lng = lng;
         return this;
      }

      public PointDTO.PointDTOBuilder lat(final String lat) {
         this.lat = lat;
         return this;
      }

      public PointDTO.PointDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public PointDTO build() {
         return new PointDTO(this.lng, this.lat, this.sort);
      }

      @Override
      public String toString() {
         return "PointDTO.PointDTOBuilder(lng=" + this.lng + ", lat=" + this.lat + ", sort=" + this.sort + ")";
      }
   }
}
