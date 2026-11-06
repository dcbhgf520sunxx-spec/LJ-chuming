package com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesDailyProductionArtifactSumDowloadDTO", description = "当日产量统计下载")
public class MesDailyProductionArtifactSumDowloadDTO {
   @ApiModelProperty(name = "orderNumber", value = "序号")
   private String orderNumber;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "dayTotalQuantityAndMete", value = "当日焊接新增数量/重量", notes = "当日焊接新增数量/重量")
   private String dayTotalQuantityAndMete;
   @ApiModelProperty(name = "totalQuantityAndMete", value = "焊接总数量/总量", notes = "焊接总数量/总量")
   private String totalQuantityAndMete;
   @ApiModelProperty(name = "dayTotalPackMete", value = "当日打包实际新增量", notes = "当日打包实际新增量")
   private String dayTotalPackMete;
   @ApiModelProperty(name = "totalPackMete", value = "打包总重量", notes = "打包总重量")
   private String totalPackMete;

   public static MesDailyProductionArtifactSumDowloadDTO.MesDailyProductionArtifactSumDowloadDTOBuilder builder() {
      return new MesDailyProductionArtifactSumDowloadDTO.MesDailyProductionArtifactSumDowloadDTOBuilder();
   }

   public MesDailyProductionArtifactSumDowloadDTO() {
   }

   public MesDailyProductionArtifactSumDowloadDTO(
      final String orderNumber,
      final String name,
      final String dayTotalQuantityAndMete,
      final String totalQuantityAndMete,
      final String dayTotalPackMete,
      final String totalPackMete
   ) {
      this.orderNumber = orderNumber;
      this.name = name;
      this.dayTotalQuantityAndMete = dayTotalQuantityAndMete;
      this.totalQuantityAndMete = totalQuantityAndMete;
      this.dayTotalPackMete = dayTotalPackMete;
      this.totalPackMete = totalPackMete;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getDayTotalQuantityAndMete() {
      return this.dayTotalQuantityAndMete;
   }

   public String getTotalQuantityAndMete() {
      return this.totalQuantityAndMete;
   }

   public String getDayTotalPackMete() {
      return this.dayTotalPackMete;
   }

   public String getTotalPackMete() {
      return this.totalPackMete;
   }

   public MesDailyProductionArtifactSumDowloadDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public MesDailyProductionArtifactSumDowloadDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public MesDailyProductionArtifactSumDowloadDTO setDayTotalQuantityAndMete(final String dayTotalQuantityAndMete) {
      this.dayTotalQuantityAndMete = dayTotalQuantityAndMete;
      return this;
   }

   public MesDailyProductionArtifactSumDowloadDTO setTotalQuantityAndMete(final String totalQuantityAndMete) {
      this.totalQuantityAndMete = totalQuantityAndMete;
      return this;
   }

   public MesDailyProductionArtifactSumDowloadDTO setDayTotalPackMete(final String dayTotalPackMete) {
      this.dayTotalPackMete = dayTotalPackMete;
      return this;
   }

   public MesDailyProductionArtifactSumDowloadDTO setTotalPackMete(final String totalPackMete) {
      this.totalPackMete = totalPackMete;
      return this;
   }

   @Override
   public String toString() {
      return "MesDailyProductionArtifactSumDowloadDTO(orderNumber="
         + this.getOrderNumber()
         + ", name="
         + this.getName()
         + ", dayTotalQuantityAndMete="
         + this.getDayTotalQuantityAndMete()
         + ", totalQuantityAndMete="
         + this.getTotalQuantityAndMete()
         + ", dayTotalPackMete="
         + this.getDayTotalPackMete()
         + ", totalPackMete="
         + this.getTotalPackMete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesDailyProductionArtifactSumDowloadDTO)) {
         return false;
      }

      MesDailyProductionArtifactSumDowloadDTO other = (MesDailyProductionArtifactSumDowloadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNumber = this.getOrderNumber();
      Object other$orderNumber = other.getOrderNumber();
      if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$dayTotalQuantityAndMete = this.getDayTotalQuantityAndMete();
            Object other$dayTotalQuantityAndMete = other.getDayTotalQuantityAndMete();
            if (this$dayTotalQuantityAndMete == null
               ? other$dayTotalQuantityAndMete == null
               : this$dayTotalQuantityAndMete.equals(other$dayTotalQuantityAndMete)) {
               Object this$totalQuantityAndMete = this.getTotalQuantityAndMete();
               Object other$totalQuantityAndMete = other.getTotalQuantityAndMete();
               if (this$totalQuantityAndMete == null ? other$totalQuantityAndMete == null : this$totalQuantityAndMete.equals(other$totalQuantityAndMete)) {
                  Object this$dayTotalPackMete = this.getDayTotalPackMete();
                  Object other$dayTotalPackMete = other.getDayTotalPackMete();
                  if (this$dayTotalPackMete == null ? other$dayTotalPackMete == null : this$dayTotalPackMete.equals(other$dayTotalPackMete)) {
                     Object this$totalPackMete = this.getTotalPackMete();
                     Object other$totalPackMete = other.getTotalPackMete();
                     return this$totalPackMete == null ? other$totalPackMete == null : this$totalPackMete.equals(other$totalPackMete);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesDailyProductionArtifactSumDowloadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $dayTotalQuantityAndMete = this.getDayTotalQuantityAndMete();
      result = result * 59 + ($dayTotalQuantityAndMete == null ? 43 : $dayTotalQuantityAndMete.hashCode());
      Object $totalQuantityAndMete = this.getTotalQuantityAndMete();
      result = result * 59 + ($totalQuantityAndMete == null ? 43 : $totalQuantityAndMete.hashCode());
      Object $dayTotalPackMete = this.getDayTotalPackMete();
      result = result * 59 + ($dayTotalPackMete == null ? 43 : $dayTotalPackMete.hashCode());
      Object $totalPackMete = this.getTotalPackMete();
      return result * 59 + ($totalPackMete == null ? 43 : $totalPackMete.hashCode());
   }

   public static class MesDailyProductionArtifactSumDowloadDTOBuilder {
      private String orderNumber;
      private String name;
      private String dayTotalQuantityAndMete;
      private String totalQuantityAndMete;
      private String dayTotalPackMete;
      private String totalPackMete;

      MesDailyProductionArtifactSumDowloadDTOBuilder() {
      }

      public MesDailyProductionArtifactSumDowloadDTO.MesDailyProductionArtifactSumDowloadDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public MesDailyProductionArtifactSumDowloadDTO.MesDailyProductionArtifactSumDowloadDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesDailyProductionArtifactSumDowloadDTO.MesDailyProductionArtifactSumDowloadDTOBuilder dayTotalQuantityAndMete(
         final String dayTotalQuantityAndMete
      ) {
         this.dayTotalQuantityAndMete = dayTotalQuantityAndMete;
         return this;
      }

      public MesDailyProductionArtifactSumDowloadDTO.MesDailyProductionArtifactSumDowloadDTOBuilder totalQuantityAndMete(final String totalQuantityAndMete) {
         this.totalQuantityAndMete = totalQuantityAndMete;
         return this;
      }

      public MesDailyProductionArtifactSumDowloadDTO.MesDailyProductionArtifactSumDowloadDTOBuilder dayTotalPackMete(final String dayTotalPackMete) {
         this.dayTotalPackMete = dayTotalPackMete;
         return this;
      }

      public MesDailyProductionArtifactSumDowloadDTO.MesDailyProductionArtifactSumDowloadDTOBuilder totalPackMete(final String totalPackMete) {
         this.totalPackMete = totalPackMete;
         return this;
      }

      public MesDailyProductionArtifactSumDowloadDTO build() {
         return new MesDailyProductionArtifactSumDowloadDTO(
            this.orderNumber, this.name, this.dayTotalQuantityAndMete, this.totalQuantityAndMete, this.dayTotalPackMete, this.totalPackMete
         );
      }

      @Override
      public String toString() {
         return "MesDailyProductionArtifactSumDowloadDTO.MesDailyProductionArtifactSumDowloadDTOBuilder(orderNumber="
            + this.orderNumber
            + ", name="
            + this.name
            + ", dayTotalQuantityAndMete="
            + this.dayTotalQuantityAndMete
            + ", totalQuantityAndMete="
            + this.totalQuantityAndMete
            + ", dayTotalPackMete="
            + this.dayTotalPackMete
            + ", totalPackMete="
            + this.totalPackMete
            + ")";
      }
   }
}
