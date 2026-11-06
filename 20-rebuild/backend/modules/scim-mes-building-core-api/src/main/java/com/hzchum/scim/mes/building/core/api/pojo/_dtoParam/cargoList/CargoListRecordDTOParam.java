package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("发运收货列表查询类")
public class CargoListRecordDTOParam {
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty(name = "serialNumber", value = "车次编号", notes = "车次编号")
   private String serialNumber;
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "driverName", value = "司机姓名", notes = "司机姓名")
   private String driverName;
   @ApiModelProperty(name = "userName", value = "装车人名称", notes = "装车人名称")
   private String userName;
   @ApiModelProperty(name = "auditUserName", value = "发运审核人名称", notes = "发运审核人名称")
   private String auditUserName;
   @ApiModelProperty(name = "receiptName", value = "接收人", notes = "接收人")
   private String receiptName;
   @ApiModelProperty(name = "status", value = "发运状态 [1 装车, 2 过磅，4发运，8收货]", notes = "发运状态 [1 装车, 2 过磅，4发运，8收货]")
   private Integer status;

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getDriverName() {
      return this.driverName;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public String getReceiptName() {
      return this.receiptName;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setDriverName(final String driverName) {
      this.driverName = driverName;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setReceiptName(final String receiptName) {
      this.receiptName = receiptName;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListRecordDTOParam)) {
         return false;
      }

      CargoListRecordDTOParam other = (CargoListRecordDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$startDate = this.getStartDate();
            Object other$startDate = other.getStartDate();
            if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
               Object this$endDate = this.getEndDate();
               Object other$endDate = other.getEndDate();
               if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$licensePlate = this.getLicensePlate();
                     Object other$licensePlate = other.getLicensePlate();
                     if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                        Object this$driverName = this.getDriverName();
                        Object other$driverName = other.getDriverName();
                        if (this$driverName == null ? other$driverName == null : this$driverName.equals(other$driverName)) {
                           Object this$userName = this.getUserName();
                           Object other$userName = other.getUserName();
                           if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                              Object this$auditUserName = this.getAuditUserName();
                              Object other$auditUserName = other.getAuditUserName();
                              if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                                 Object this$receiptName = this.getReceiptName();
                                 Object other$receiptName = other.getReceiptName();
                                 return this$receiptName == null ? other$receiptName == null : this$receiptName.equals(other$receiptName);
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
      return other instanceof CargoListRecordDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $receiptName = this.getReceiptName();
      return result * 59 + ($receiptName == null ? 43 : $receiptName.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListRecordDTOParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", driverName="
         + this.getDriverName()
         + ", userName="
         + this.getUserName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", receiptName="
         + this.getReceiptName()
         + ", status="
         + this.getStatus()
         + ")";
   }
}
