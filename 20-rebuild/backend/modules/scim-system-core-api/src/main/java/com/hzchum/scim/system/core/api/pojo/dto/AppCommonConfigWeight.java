package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("是否显示重量")
public class AppCommonConfigWeight {
   @ApiModelProperty("(任务上报)是否显示重量 true显示 false不显示)")
   @NotNull(message = "参数不能为空")
   private Boolean boolShowWeightInManufacture;
   @ApiModelProperty("(任务上报记录)是否显示重量 true显示 false不显示)")
   @NotNull(message = "参数不能为空")
   private Boolean boolShowWeightInRecord;

   public static AppCommonConfigWeight.AppCommonConfigWeightBuilder builder() {
      return new AppCommonConfigWeight.AppCommonConfigWeightBuilder();
   }

   public Boolean getBoolShowWeightInManufacture() {
      return this.boolShowWeightInManufacture;
   }

   public Boolean getBoolShowWeightInRecord() {
      return this.boolShowWeightInRecord;
   }

   public void setBoolShowWeightInManufacture(final Boolean boolShowWeightInManufacture) {
      this.boolShowWeightInManufacture = boolShowWeightInManufacture;
   }

   public void setBoolShowWeightInRecord(final Boolean boolShowWeightInRecord) {
      this.boolShowWeightInRecord = boolShowWeightInRecord;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppCommonConfigWeight)) {
         return false;
      } else {
         AppCommonConfigWeight other = (AppCommonConfigWeight)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$boolShowWeightInManufacture = this.getBoolShowWeightInManufacture();
            Object other$boolShowWeightInManufacture = other.getBoolShowWeightInManufacture();
            if (this$boolShowWeightInManufacture == null
               ? other$boolShowWeightInManufacture == null
               : this$boolShowWeightInManufacture.equals(other$boolShowWeightInManufacture)) {
               Object this$boolShowWeightInRecord = this.getBoolShowWeightInRecord();
               Object other$boolShowWeightInRecord = other.getBoolShowWeightInRecord();
               return this$boolShowWeightInRecord == null
                  ? other$boolShowWeightInRecord == null
                  : this$boolShowWeightInRecord.equals(other$boolShowWeightInRecord);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppCommonConfigWeight;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolShowWeightInManufacture = this.getBoolShowWeightInManufacture();
      result = result * 59 + ($boolShowWeightInManufacture == null ? 43 : $boolShowWeightInManufacture.hashCode());
      Object $boolShowWeightInRecord = this.getBoolShowWeightInRecord();
      return result * 59 + ($boolShowWeightInRecord == null ? 43 : $boolShowWeightInRecord.hashCode());
   }

   @Override
   public String toString() {
      return "AppCommonConfigWeight(boolShowWeightInManufacture="
         + this.getBoolShowWeightInManufacture()
         + ", boolShowWeightInRecord="
         + this.getBoolShowWeightInRecord()
         + ")";
   }

   public AppCommonConfigWeight() {
   }

   public AppCommonConfigWeight(final Boolean boolShowWeightInManufacture, final Boolean boolShowWeightInRecord) {
      this.boolShowWeightInManufacture = boolShowWeightInManufacture;
      this.boolShowWeightInRecord = boolShowWeightInRecord;
   }

   public static class AppCommonConfigWeightBuilder {
      private Boolean boolShowWeightInManufacture;
      private Boolean boolShowWeightInRecord;

      AppCommonConfigWeightBuilder() {
      }

      public AppCommonConfigWeight.AppCommonConfigWeightBuilder boolShowWeightInManufacture(final Boolean boolShowWeightInManufacture) {
         this.boolShowWeightInManufacture = boolShowWeightInManufacture;
         return this;
      }

      public AppCommonConfigWeight.AppCommonConfigWeightBuilder boolShowWeightInRecord(final Boolean boolShowWeightInRecord) {
         this.boolShowWeightInRecord = boolShowWeightInRecord;
         return this;
      }

      public AppCommonConfigWeight build() {
         return new AppCommonConfigWeight(this.boolShowWeightInManufacture, this.boolShowWeightInRecord);
      }

      @Override
      public String toString() {
         return "AppCommonConfigWeight.AppCommonConfigWeightBuilder(boolShowWeightInManufacture="
            + this.boolShowWeightInManufacture
            + ", boolShowWeightInRecord="
            + this.boolShowWeightInRecord
            + ")";
      }
   }
}
