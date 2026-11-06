package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("报工审核通过Query")
public class MesProductionReportingApprovalPassedQuery {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("产品类型")
   private Integer productTypeEnum;
   @ApiModelProperty("产品编号")
   private String productSerialNumber;
   @ApiModelProperty("产品编号List")
   private List<String> productSerialNumberList;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public List<String> getProductSerialNumberList() {
      return this.productSerialNumberList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setProductSerialNumberList(final List<String> productSerialNumberList) {
      this.productSerialNumberList = productSerialNumberList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalPassedQuery)) {
         return false;
      }

      MesProductionReportingApprovalPassedQuery other = (MesProductionReportingApprovalPassedQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$productTypeEnum = this.getProductTypeEnum();
            Object other$productTypeEnum = other.getProductTypeEnum();
            if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
               Object this$productSerialNumber = this.getProductSerialNumber();
               Object other$productSerialNumber = other.getProductSerialNumber();
               if (this$productSerialNumber == null ? other$productSerialNumber == null : this$productSerialNumber.equals(other$productSerialNumber)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesProductionReportingApprovalPassedQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $productSerialNumberList = this.getProductSerialNumberList();
      return result * 59 + ($productSerialNumberList == null ? 43 : $productSerialNumberList.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalPassedQuery(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productSerialNumberList="
         + this.getProductSerialNumberList()
         + ")";
   }
}
