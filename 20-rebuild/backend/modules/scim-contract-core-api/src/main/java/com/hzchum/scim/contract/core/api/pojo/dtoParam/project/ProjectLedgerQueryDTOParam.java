package com.hzchum.scim.contract.core.api.pojo.dtoParam.project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("项目台账列表查询类")
public class ProjectLedgerQueryDTOParam {
   Long userId;
   Long projectId;
   @ApiModelProperty("年份 例如:2022")
   Integer year;
   @ApiModelProperty("项目状态")
   Integer status;
   @ApiModelProperty("结算状态")
   Integer settlementStatus;
   @ApiModelProperty("编号")
   String serialNumber;
   @ApiModelProperty("名称")
   String name;
   @ApiModelProperty("项目管理人员名称")
   String projectManagerName;
   @ApiModelProperty(name = "customerUnit", notes = "客户单位名称")
   private String customerUnit;

   public Long getUserId() {
      return this.userId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLedgerQueryDTOParam)) {
         return false;
      }

      ProjectLedgerQueryDTOParam other = (ProjectLedgerQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$userId = this.getUserId();
      Object other$userId = other.getUserId();
      if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$year = this.getYear();
            Object other$year = other.getYear();
            if (this$year == null ? other$year == null : this$year.equals(other$year)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$settlementStatus = this.getSettlementStatus();
                  Object other$settlementStatus = other.getSettlementStatus();
                  if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$projectManagerName = this.getProjectManagerName();
                           Object other$projectManagerName = other.getProjectManagerName();
                           if (this$projectManagerName == null ? other$projectManagerName == null : this$projectManagerName.equals(other$projectManagerName)) {
                              Object this$customerUnit = this.getCustomerUnit();
                              Object other$customerUnit = other.getCustomerUnit();
                              return this$customerUnit == null ? other$customerUnit == null : this$customerUnit.equals(other$customerUnit);
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
      return other instanceof ProjectLedgerQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      return result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLedgerQueryDTOParam(userId="
         + this.getUserId()
         + ", projectId="
         + this.getProjectId()
         + ", year="
         + this.getYear()
         + ", status="
         + this.getStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ")";
   }
}
