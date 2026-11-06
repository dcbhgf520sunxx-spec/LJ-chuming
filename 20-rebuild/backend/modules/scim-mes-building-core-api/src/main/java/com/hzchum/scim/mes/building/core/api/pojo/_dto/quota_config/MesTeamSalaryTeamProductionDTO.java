package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.common.core.api.pojo.common.ProductInfo;
import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel("班组工资-班组产量DTO")
public class MesTeamSalaryTeamProductionDTO {
   private ShowInfo project;
   private ProductInfo product;
   private ShowInfo process;
   @ApiModelProperty("定额配置id")
   private Long quotaConfigId;
   @ApiModelProperty("定额配置编号")
   private String quotaConfigSerialNumber;
   @ApiModelProperty("核算单位")
   private String measureUnit;
   @ApiModelProperty("核算量")
   private BigDecimal measurementQuantity;
   @ApiModelProperty("单价(元)")
   private BigDecimal price;
   @ApiModelProperty("金额(元)")
   private BigDecimal amount;
   @ApiModelProperty("报工日期")
   private LocalDate reportDate;
   private ShowInfo approver;
   @ApiModelProperty("审核日期")
   private LocalDate approvalDate;
   @ApiModelProperty("上报人")
   private ShowInfo reportPerson;
   @ApiModelProperty("批次")
   private ShowInfo areaBatch;

   public ShowInfo getProject() {
      return this.project;
   }

   public ProductInfo getProduct() {
      return this.product;
   }

   public ShowInfo getProcess() {
      return this.process;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaConfigSerialNumber() {
      return this.quotaConfigSerialNumber;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMeasurementQuantity() {
      return this.measurementQuantity;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public LocalDate getReportDate() {
      return this.reportDate;
   }

   public ShowInfo getApprover() {
      return this.approver;
   }

   public LocalDate getApprovalDate() {
      return this.approvalDate;
   }

   public ShowInfo getReportPerson() {
      return this.reportPerson;
   }

   public ShowInfo getAreaBatch() {
      return this.areaBatch;
   }

   public void setProject(final ShowInfo project) {
      this.project = project;
   }

   public void setProduct(final ProductInfo product) {
      this.product = product;
   }

   public void setProcess(final ShowInfo process) {
      this.process = process;
   }

   public void setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
   }

   public void setQuotaConfigSerialNumber(final String quotaConfigSerialNumber) {
      this.quotaConfigSerialNumber = quotaConfigSerialNumber;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurementQuantity(final BigDecimal measurementQuantity) {
      this.measurementQuantity = measurementQuantity;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setReportDate(final LocalDate reportDate) {
      this.reportDate = reportDate;
   }

   public void setApprover(final ShowInfo approver) {
      this.approver = approver;
   }

   public void setApprovalDate(final LocalDate approvalDate) {
      this.approvalDate = approvalDate;
   }

   public void setReportPerson(final ShowInfo reportPerson) {
      this.reportPerson = reportPerson;
   }

   public void setAreaBatch(final ShowInfo areaBatch) {
      this.areaBatch = areaBatch;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTeamSalaryTeamProductionDTO)) {
         return false;
      }

      MesTeamSalaryTeamProductionDTO other = (MesTeamSalaryTeamProductionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quotaConfigId = this.getQuotaConfigId();
      Object other$quotaConfigId = other.getQuotaConfigId();
      if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$product = this.getProduct();
            Object other$product = other.getProduct();
            if (this$product == null ? other$product == null : this$product.equals(other$product)) {
               Object this$process = this.getProcess();
               Object other$process = other.getProcess();
               if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                  Object this$quotaConfigSerialNumber = this.getQuotaConfigSerialNumber();
                  Object other$quotaConfigSerialNumber = other.getQuotaConfigSerialNumber();
                  if (this$quotaConfigSerialNumber == null
                     ? other$quotaConfigSerialNumber == null
                     : this$quotaConfigSerialNumber.equals(other$quotaConfigSerialNumber)) {
                     Object this$measureUnit = this.getMeasureUnit();
                     Object other$measureUnit = other.getMeasureUnit();
                     if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                        Object this$measurementQuantity = this.getMeasurementQuantity();
                        Object other$measurementQuantity = other.getMeasurementQuantity();
                        if (this$measurementQuantity == null ? other$measurementQuantity == null : this$measurementQuantity.equals(other$measurementQuantity)) {
                           Object this$price = this.getPrice();
                           Object other$price = other.getPrice();
                           if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                              Object this$amount = this.getAmount();
                              Object other$amount = other.getAmount();
                              if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                 Object this$reportDate = this.getReportDate();
                                 Object other$reportDate = other.getReportDate();
                                 if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                                    Object this$approver = this.getApprover();
                                    Object other$approver = other.getApprover();
                                    if (this$approver == null ? other$approver == null : this$approver.equals(other$approver)) {
                                       Object this$approvalDate = this.getApprovalDate();
                                       Object other$approvalDate = other.getApprovalDate();
                                       if (this$approvalDate == null ? other$approvalDate == null : this$approvalDate.equals(other$approvalDate)) {
                                          Object this$reportPerson = this.getReportPerson();
                                          Object other$reportPerson = other.getReportPerson();
                                          if (this$reportPerson == null ? other$reportPerson == null : this$reportPerson.equals(other$reportPerson)) {
                                             Object this$areaBatch = this.getAreaBatch();
                                             Object other$areaBatch = other.getAreaBatch();
                                             return this$areaBatch == null ? other$areaBatch == null : this$areaBatch.equals(other$areaBatch);
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
      return other instanceof MesTeamSalaryTeamProductionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $product = this.getProduct();
      result = result * 59 + ($product == null ? 43 : $product.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $quotaConfigSerialNumber = this.getQuotaConfigSerialNumber();
      result = result * 59 + ($quotaConfigSerialNumber == null ? 43 : $quotaConfigSerialNumber.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $measurementQuantity = this.getMeasurementQuantity();
      result = result * 59 + ($measurementQuantity == null ? 43 : $measurementQuantity.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $approver = this.getApprover();
      result = result * 59 + ($approver == null ? 43 : $approver.hashCode());
      Object $approvalDate = this.getApprovalDate();
      result = result * 59 + ($approvalDate == null ? 43 : $approvalDate.hashCode());
      Object $reportPerson = this.getReportPerson();
      result = result * 59 + ($reportPerson == null ? 43 : $reportPerson.hashCode());
      Object $areaBatch = this.getAreaBatch();
      return result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
   }

   @Override
   public String toString() {
      return "MesTeamSalaryTeamProductionDTO(project="
         + this.getProject()
         + ", product="
         + this.getProduct()
         + ", process="
         + this.getProcess()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaConfigSerialNumber="
         + this.getQuotaConfigSerialNumber()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurementQuantity="
         + this.getMeasurementQuantity()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", reportDate="
         + this.getReportDate()
         + ", approver="
         + this.getApprover()
         + ", approvalDate="
         + this.getApprovalDate()
         + ", reportPerson="
         + this.getReportPerson()
         + ", areaBatch="
         + this.getAreaBatch()
         + ")";
   }
}
