package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("SubcontractOrderDTO对象列表查询类")
public class SubcontractOrderQueryDTOParam {
   @ApiModelProperty(name = "year", value = "年份", notes = "年份")
   private Integer year;
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "serialNumber", value = "订单编号", notes = "订单编号")
   private String serialNumber;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "supplierName", value = "分包单位(供应商)", notes = "分包单位(供应商)")
   private String supplierName;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   private Long subcontractClassId;
   @ApiModelProperty(name = "boolSettlementStatus", value = "结算状态 1已结算0未结算", notes = "结算状态 1已结算0未结算")
   private Boolean boolSettlementStatus;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   private String userName;

   public static SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder builder() {
      return new SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder();
   }

   public SubcontractOrderQueryDTOParam() {
   }

   public SubcontractOrderQueryDTOParam(
      final Integer year,
      final LocalDate startDate,
      final LocalDate endDate,
      final String serialNumber,
      final Long projectId,
      final String projectName,
      final String supplierName,
      final Long subcontractClassId,
      final Boolean boolSettlementStatus,
      final String userName
   ) {
      this.year = year;
      this.startDate = startDate;
      this.endDate = endDate;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.projectName = projectName;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.boolSettlementStatus = boolSettlementStatus;
      this.userName = userName;
   }

   public Integer getYear() {
      return this.year;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public Boolean getBoolSettlementStatus() {
      return this.boolSettlementStatus;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
   }

   public void setBoolSettlementStatus(final Boolean boolSettlementStatus) {
      this.boolSettlementStatus = boolSettlementStatus;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractOrderQueryDTOParam)) {
         return false;
      }

      SubcontractOrderQueryDTOParam other = (SubcontractOrderQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$year = this.getYear();
      Object other$year = other.getYear();
      if (this$year == null ? other$year == null : this$year.equals(other$year)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$subcontractClassId = this.getSubcontractClassId();
            Object other$subcontractClassId = other.getSubcontractClassId();
            if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
               Object this$boolSettlementStatus = this.getBoolSettlementStatus();
               Object other$boolSettlementStatus = other.getBoolSettlementStatus();
               if (this$boolSettlementStatus == null ? other$boolSettlementStatus == null : this$boolSettlementStatus.equals(other$boolSettlementStatus)) {
                  Object this$startDate = this.getStartDate();
                  Object other$startDate = other.getStartDate();
                  if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                     Object this$endDate = this.getEndDate();
                     Object other$endDate = other.getEndDate();
                     if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$projectName = this.getProjectName();
                           Object other$projectName = other.getProjectName();
                           if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                              Object this$supplierName = this.getSupplierName();
                              Object other$supplierName = other.getSupplierName();
                              if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                 Object this$userName = this.getUserName();
                                 Object other$userName = other.getUserName();
                                 return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof SubcontractOrderQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $boolSettlementStatus = this.getBoolSettlementStatus();
      result = result * 59 + ($boolSettlementStatus == null ? 43 : $boolSettlementStatus.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "SubcontractOrderQueryDTOParam(year="
         + this.getYear()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", supplierName="
         + this.getSupplierName()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", boolSettlementStatus="
         + this.getBoolSettlementStatus()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public static class SubcontractOrderQueryDTOParamBuilder {
      private Integer year;
      private LocalDate startDate;
      private LocalDate endDate;
      private String serialNumber;
      private Long projectId;
      private String projectName;
      private String supplierName;
      private Long subcontractClassId;
      private Boolean boolSettlementStatus;
      private String userName;

      SubcontractOrderQueryDTOParamBuilder() {
      }

      public SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder boolSettlementStatus(final Boolean boolSettlementStatus) {
         this.boolSettlementStatus = boolSettlementStatus;
         return this;
      }

      public SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public SubcontractOrderQueryDTOParam build() {
         return new SubcontractOrderQueryDTOParam(
            this.year,
            this.startDate,
            this.endDate,
            this.serialNumber,
            this.projectId,
            this.projectName,
            this.supplierName,
            this.subcontractClassId,
            this.boolSettlementStatus,
            this.userName
         );
      }

      @Override
      public String toString() {
         return "SubcontractOrderQueryDTOParam.SubcontractOrderQueryDTOParamBuilder(year="
            + this.year
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", supplierName="
            + this.supplierName
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", boolSettlementStatus="
            + this.boolSettlementStatus
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
