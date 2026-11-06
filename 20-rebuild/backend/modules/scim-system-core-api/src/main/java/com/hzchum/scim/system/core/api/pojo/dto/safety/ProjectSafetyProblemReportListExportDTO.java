package com.hzchum.scim.system.core.api.pojo.dto.safety;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ExcelTarget("ProjectSafetyProblemReportListExportDTO")
public class ProjectSafetyProblemReportListExportDTO {
   @Excel(name = "序号", width = 10.0)
   private Long orderNo;
   @ApiModelProperty(name = "projectName", value = "部门名称")
   @Excel(name = "部门名称", width = 25.0)
   private String projectName;
   @ApiModelProperty(name = "supplierName", value = "供应商名称")
   @Excel(name = "供应商名称", width = 25.0)
   private String supplierName;
   @ApiModelProperty(name = "qualityOrSafetyEnum", value = "问题类型")
   @Excel(name = "问题类型", width = 15.0, replace = {"质量问题_1", "安全问题_2"})
   private Integer qualityOrSafetyEnum;
   @ApiModelProperty(name = "createTime", value = "发起时间")
   @Excel(name = "发起时间", width = 15.0)
   private LocalDate createTime;
   @ApiModelProperty(name = "siteName", value = "问题名称")
   @Excel(name = "问题名称", width = 20.0)
   private String siteName;
   @ApiModelProperty(name = "remark", value = "问题描述")
   @Excel(name = "问题描述", width = 20.0)
   private String remark;
   @ApiModelProperty(name = "dutyName", value = "责任人")
   @Excel(name = "责任人", width = 15.0)
   private String dutyName;
   @ApiModelProperty(name = "problemStatus", value = "问题状态")
   @Excel(name = "问题状态", width = 15.0, replace = {"逾期未整改_1", "申诉中_2", "需复检_4", "未整改_8", "警告_16", "已整改_32", "已撤销_64"})
   private Integer problemStatus;

   public Long getOrderNo() {
      return this.orderNo;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getQualityOrSafetyEnum() {
      return this.qualityOrSafetyEnum;
   }

   public LocalDate getCreateTime() {
      return this.createTime;
   }

   public String getSiteName() {
      return this.siteName;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getDutyName() {
      return this.dutyName;
   }

   public Integer getProblemStatus() {
      return this.problemStatus;
   }

   public void setOrderNo(final Long orderNo) {
      this.orderNo = orderNo;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setQualityOrSafetyEnum(final Integer qualityOrSafetyEnum) {
      this.qualityOrSafetyEnum = qualityOrSafetyEnum;
   }

   public void setCreateTime(final LocalDate createTime) {
      this.createTime = createTime;
   }

   public void setSiteName(final String siteName) {
      this.siteName = siteName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setDutyName(final String dutyName) {
      this.dutyName = dutyName;
   }

   public void setProblemStatus(final Integer problemStatus) {
      this.problemStatus = problemStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSafetyProblemReportListExportDTO)) {
         return false;
      }

      ProjectSafetyProblemReportListExportDTO other = (ProjectSafetyProblemReportListExportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$qualityOrSafetyEnum = this.getQualityOrSafetyEnum();
         Object other$qualityOrSafetyEnum = other.getQualityOrSafetyEnum();
         if (this$qualityOrSafetyEnum == null ? other$qualityOrSafetyEnum == null : this$qualityOrSafetyEnum.equals(other$qualityOrSafetyEnum)) {
            Object this$problemStatus = this.getProblemStatus();
            Object other$problemStatus = other.getProblemStatus();
            if (this$problemStatus == null ? other$problemStatus == null : this$problemStatus.equals(other$problemStatus)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$supplierName = this.getSupplierName();
                  Object other$supplierName = other.getSupplierName();
                  if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                        Object this$siteName = this.getSiteName();
                        Object other$siteName = other.getSiteName();
                        if (this$siteName == null ? other$siteName == null : this$siteName.equals(other$siteName)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                              Object this$dutyName = this.getDutyName();
                              Object other$dutyName = other.getDutyName();
                              return this$dutyName == null ? other$dutyName == null : this$dutyName.equals(other$dutyName);
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
      return other instanceof ProjectSafetyProblemReportListExportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $qualityOrSafetyEnum = this.getQualityOrSafetyEnum();
      result = result * 59 + ($qualityOrSafetyEnum == null ? 43 : $qualityOrSafetyEnum.hashCode());
      Object $problemStatus = this.getProblemStatus();
      result = result * 59 + ($problemStatus == null ? 43 : $problemStatus.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $siteName = this.getSiteName();
      result = result * 59 + ($siteName == null ? 43 : $siteName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $dutyName = this.getDutyName();
      return result * 59 + ($dutyName == null ? 43 : $dutyName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSafetyProblemReportListExportDTO(orderNo="
         + this.getOrderNo()
         + ", projectName="
         + this.getProjectName()
         + ", supplierName="
         + this.getSupplierName()
         + ", qualityOrSafetyEnum="
         + this.getQualityOrSafetyEnum()
         + ", createTime="
         + this.getCreateTime()
         + ", siteName="
         + this.getSiteName()
         + ", remark="
         + this.getRemark()
         + ", dutyName="
         + this.getDutyName()
         + ", problemStatus="
         + this.getProblemStatus()
         + ")";
   }
}
