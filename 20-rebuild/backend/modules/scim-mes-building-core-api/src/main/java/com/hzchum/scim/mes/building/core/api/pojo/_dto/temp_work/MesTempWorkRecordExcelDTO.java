package com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("点工记录ExcelDTO")
public class MesTempWorkRecordExcelDTO {
   @Excel(name = "序号", width = 5.0)
   @ApiModelProperty("序号")
   private Integer serialNumber;
   @Excel(name = "上报日期", width = 15.0, exportFormat = "yyyy-MM-dd")
   @ApiModelProperty("上报日期")
   private LocalDateTime reportDate;
   @Excel(name = "上报人", width = 10.0)
   @ApiModelProperty("上报人名称")
   private String reporterName;
   @Excel(name = "创建日期", width = 20.0, exportFormat = "yyyy-MM-dd HH:mm:ss")
   @ApiModelProperty("创建日期")
   private LocalDateTime createTime;
   @Excel(name = "所属班组", width = 10.0)
   @ApiModelProperty("班组名称")
   private String teamName;
   @Excel(name = "点工类型", width = 10.0)
   @ApiModelProperty("点工类型名称")
   private String tempWorkQuotaConfigName;
   @Excel(name = "点工原因", width = 10.0)
   @ApiModelProperty("点工原因名称")
   private String reasonName;
   @Excel(name = "项目", width = 35.0)
   @ApiModelProperty("项目展示(编号-简称)")
   private String projectShow;
   @Excel(name = "工时(h)", width = 10.0)
   @ApiModelProperty("工时(h)")
   private BigDecimal workHour;
   @Excel(name = "描述", width = 30.0)
   @ApiModelProperty("描述")
   private String description;
   @Excel(name = "工时单价(元/时)", width = 10.0)
   @ApiModelProperty("工时单价(元/时)")
   private BigDecimal price;
   @Excel(name = "点工金额(元)", width = 10.0)
   @ApiModelProperty("点工金额(元)")
   private BigDecimal amount;
   @Excel(name = "核算金额(元)", width = 10.0)
   @ApiModelProperty("核算金额(元)")
   private BigDecimal calculateAmount;
   @Excel(name = "审批状态", width = 10.0)
   @ApiModelProperty("审批状态名称")
   private String approvalStatusName;
   @Excel(name = "审核备注", width = 30.0)
   @ApiModelProperty("审核备注")
   private String approvalRemark;
   @Excel(name = "审批通过日期", width = 20.0, exportFormat = "yyyy-MM-dd HH:mm:ss")
   @ApiModelProperty("审批日期")
   private LocalDateTime approvalTime;

   public Integer getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDateTime getReportDate() {
      return this.reportDate;
   }

   public String getReporterName() {
      return this.reporterName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getTempWorkQuotaConfigName() {
      return this.tempWorkQuotaConfigName;
   }

   public String getReasonName() {
      return this.reasonName;
   }

   public String getProjectShow() {
      return this.projectShow;
   }

   public BigDecimal getWorkHour() {
      return this.workHour;
   }

   public String getDescription() {
      return this.description;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getCalculateAmount() {
      return this.calculateAmount;
   }

   public String getApprovalStatusName() {
      return this.approvalStatusName;
   }

   public String getApprovalRemark() {
      return this.approvalRemark;
   }

   public LocalDateTime getApprovalTime() {
      return this.approvalTime;
   }

   public void setSerialNumber(final Integer serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setReportDate(final LocalDateTime reportDate) {
      this.reportDate = reportDate;
   }

   public void setReporterName(final String reporterName) {
      this.reporterName = reporterName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   public void setTempWorkQuotaConfigName(final String tempWorkQuotaConfigName) {
      this.tempWorkQuotaConfigName = tempWorkQuotaConfigName;
   }

   public void setReasonName(final String reasonName) {
      this.reasonName = reasonName;
   }

   public void setProjectShow(final String projectShow) {
      this.projectShow = projectShow;
   }

   public void setWorkHour(final BigDecimal workHour) {
      this.workHour = workHour;
   }

   public void setDescription(final String description) {
      this.description = description;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setCalculateAmount(final BigDecimal calculateAmount) {
      this.calculateAmount = calculateAmount;
   }

   public void setApprovalStatusName(final String approvalStatusName) {
      this.approvalStatusName = approvalStatusName;
   }

   public void setApprovalRemark(final String approvalRemark) {
      this.approvalRemark = approvalRemark;
   }

   public void setApprovalTime(final LocalDateTime approvalTime) {
      this.approvalTime = approvalTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWorkRecordExcelDTO)) {
         return false;
      }

      MesTempWorkRecordExcelDTO other = (MesTempWorkRecordExcelDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$serialNumber = this.getSerialNumber();
      Object other$serialNumber = other.getSerialNumber();
      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
         Object this$reportDate = this.getReportDate();
         Object other$reportDate = other.getReportDate();
         if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
            Object this$reporterName = this.getReporterName();
            Object other$reporterName = other.getReporterName();
            if (this$reporterName == null ? other$reporterName == null : this$reporterName.equals(other$reporterName)) {
               Object this$createTime = this.getCreateTime();
               Object other$createTime = other.getCreateTime();
               if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                  Object this$teamName = this.getTeamName();
                  Object other$teamName = other.getTeamName();
                  if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                     Object this$tempWorkQuotaConfigName = this.getTempWorkQuotaConfigName();
                     Object other$tempWorkQuotaConfigName = other.getTempWorkQuotaConfigName();
                     if (this$tempWorkQuotaConfigName == null
                        ? other$tempWorkQuotaConfigName == null
                        : this$tempWorkQuotaConfigName.equals(other$tempWorkQuotaConfigName)) {
                        Object this$reasonName = this.getReasonName();
                        Object other$reasonName = other.getReasonName();
                        if (this$reasonName == null ? other$reasonName == null : this$reasonName.equals(other$reasonName)) {
                           Object this$projectShow = this.getProjectShow();
                           Object other$projectShow = other.getProjectShow();
                           if (this$projectShow == null ? other$projectShow == null : this$projectShow.equals(other$projectShow)) {
                              Object this$workHour = this.getWorkHour();
                              Object other$workHour = other.getWorkHour();
                              if (this$workHour == null ? other$workHour == null : this$workHour.equals(other$workHour)) {
                                 Object this$description = this.getDescription();
                                 Object other$description = other.getDescription();
                                 if (this$description == null ? other$description == null : this$description.equals(other$description)) {
                                    Object this$price = this.getPrice();
                                    Object other$price = other.getPrice();
                                    if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                       Object this$amount = this.getAmount();
                                       Object other$amount = other.getAmount();
                                       if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                          Object this$calculateAmount = this.getCalculateAmount();
                                          Object other$calculateAmount = other.getCalculateAmount();
                                          if (this$calculateAmount == null ? other$calculateAmount == null : this$calculateAmount.equals(other$calculateAmount)
                                             )
                                           {
                                             Object this$approvalStatusName = this.getApprovalStatusName();
                                             Object other$approvalStatusName = other.getApprovalStatusName();
                                             if (this$approvalStatusName == null
                                                ? other$approvalStatusName == null
                                                : this$approvalStatusName.equals(other$approvalStatusName)) {
                                                Object this$approvalRemark = this.getApprovalRemark();
                                                Object other$approvalRemark = other.getApprovalRemark();
                                                if (this$approvalRemark == null
                                                   ? other$approvalRemark == null
                                                   : this$approvalRemark.equals(other$approvalRemark)) {
                                                   Object this$approvalTime = this.getApprovalTime();
                                                   Object other$approvalTime = other.getApprovalTime();
                                                   return this$approvalTime == null ? other$approvalTime == null : this$approvalTime.equals(other$approvalTime);
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
      return other instanceof MesTempWorkRecordExcelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $reporterName = this.getReporterName();
      result = result * 59 + ($reporterName == null ? 43 : $reporterName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $tempWorkQuotaConfigName = this.getTempWorkQuotaConfigName();
      result = result * 59 + ($tempWorkQuotaConfigName == null ? 43 : $tempWorkQuotaConfigName.hashCode());
      Object $reasonName = this.getReasonName();
      result = result * 59 + ($reasonName == null ? 43 : $reasonName.hashCode());
      Object $projectShow = this.getProjectShow();
      result = result * 59 + ($projectShow == null ? 43 : $projectShow.hashCode());
      Object $workHour = this.getWorkHour();
      result = result * 59 + ($workHour == null ? 43 : $workHour.hashCode());
      Object $description = this.getDescription();
      result = result * 59 + ($description == null ? 43 : $description.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $calculateAmount = this.getCalculateAmount();
      result = result * 59 + ($calculateAmount == null ? 43 : $calculateAmount.hashCode());
      Object $approvalStatusName = this.getApprovalStatusName();
      result = result * 59 + ($approvalStatusName == null ? 43 : $approvalStatusName.hashCode());
      Object $approvalRemark = this.getApprovalRemark();
      result = result * 59 + ($approvalRemark == null ? 43 : $approvalRemark.hashCode());
      Object $approvalTime = this.getApprovalTime();
      return result * 59 + ($approvalTime == null ? 43 : $approvalTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesTempWorkRecordExcelDTO(serialNumber="
         + this.getSerialNumber()
         + ", reportDate="
         + this.getReportDate()
         + ", reporterName="
         + this.getReporterName()
         + ", createTime="
         + this.getCreateTime()
         + ", teamName="
         + this.getTeamName()
         + ", tempWorkQuotaConfigName="
         + this.getTempWorkQuotaConfigName()
         + ", reasonName="
         + this.getReasonName()
         + ", projectShow="
         + this.getProjectShow()
         + ", workHour="
         + this.getWorkHour()
         + ", description="
         + this.getDescription()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", calculateAmount="
         + this.getCalculateAmount()
         + ", approvalStatusName="
         + this.getApprovalStatusName()
         + ", approvalRemark="
         + this.getApprovalRemark()
         + ", approvalTime="
         + this.getApprovalTime()
         + ")";
   }
}
