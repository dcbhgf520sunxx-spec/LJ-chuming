package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("工价调整产品Query")
public class MesWageAdjustProductQuery {
   @ApiModelProperty("产品类型")
   private Integer productTypeEnum;
   @ApiModelProperty("审批状态")
   private Integer approvalStatus;
   @ApiModelProperty("产品编号列表")
   private List<String> productSerialNumberList;

   MesWageAdjustProductQuery(final Integer productTypeEnum, final Integer approvalStatus, final List<String> productSerialNumberList) {
      this.productTypeEnum = productTypeEnum;
      this.approvalStatus = approvalStatus;
      this.productSerialNumberList = productSerialNumberList;
   }

   public static MesWageAdjustProductQuery.MesWageAdjustProductQueryBuilder builder() {
      return new MesWageAdjustProductQuery.MesWageAdjustProductQueryBuilder();
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Integer getApprovalStatus() {
      return this.approvalStatus;
   }

   public List<String> getProductSerialNumberList() {
      return this.productSerialNumberList;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setApprovalStatus(final Integer approvalStatus) {
      this.approvalStatus = approvalStatus;
   }

   public void setProductSerialNumberList(final List<String> productSerialNumberList) {
      this.productSerialNumberList = productSerialNumberList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageAdjustProductQuery)) {
         return false;
      }

      MesWageAdjustProductQuery other = (MesWageAdjustProductQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productTypeEnum = this.getProductTypeEnum();
      Object other$productTypeEnum = other.getProductTypeEnum();
      if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
         Object this$approvalStatus = this.getApprovalStatus();
         Object other$approvalStatus = other.getApprovalStatus();
         if (this$approvalStatus == null ? other$approvalStatus == null : this$approvalStatus.equals(other$approvalStatus)) {
            Object this$productSerialNumberList = this.getProductSerialNumberList();
            Object other$productSerialNumberList = other.getProductSerialNumberList();
            return this$productSerialNumberList == null
               ? other$productSerialNumberList == null
               : this$productSerialNumberList.equals(other$productSerialNumberList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesWageAdjustProductQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $approvalStatus = this.getApprovalStatus();
      result = result * 59 + ($approvalStatus == null ? 43 : $approvalStatus.hashCode());
      Object $productSerialNumberList = this.getProductSerialNumberList();
      return result * 59 + ($productSerialNumberList == null ? 43 : $productSerialNumberList.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageAdjustProductQuery(productTypeEnum="
         + this.getProductTypeEnum()
         + ", approvalStatus="
         + this.getApprovalStatus()
         + ", productSerialNumberList="
         + this.getProductSerialNumberList()
         + ")";
   }

   public static class MesWageAdjustProductQueryBuilder {
      private Integer productTypeEnum;
      private Integer approvalStatus;
      private List<String> productSerialNumberList;

      MesWageAdjustProductQueryBuilder() {
      }

      public MesWageAdjustProductQuery.MesWageAdjustProductQueryBuilder productTypeEnum(final Integer productTypeEnum) {
         this.productTypeEnum = productTypeEnum;
         return this;
      }

      public MesWageAdjustProductQuery.MesWageAdjustProductQueryBuilder approvalStatus(final Integer approvalStatus) {
         this.approvalStatus = approvalStatus;
         return this;
      }

      public MesWageAdjustProductQuery.MesWageAdjustProductQueryBuilder productSerialNumberList(final List<String> productSerialNumberList) {
         this.productSerialNumberList = productSerialNumberList;
         return this;
      }

      public MesWageAdjustProductQuery build() {
         return new MesWageAdjustProductQuery(this.productTypeEnum, this.approvalStatus, this.productSerialNumberList);
      }

      @Override
      public String toString() {
         return "MesWageAdjustProductQuery.MesWageAdjustProductQueryBuilder(productTypeEnum="
            + this.productTypeEnum
            + ", approvalStatus="
            + this.approvalStatus
            + ", productSerialNumberList="
            + this.productSerialNumberList
            + ")";
      }
   }
}
