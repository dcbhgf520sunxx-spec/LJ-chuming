package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class AnnualContractDTOParam {
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "合同编号", notes = "合同编号")
   private String serialNumber;
   @ApiModelProperty(name = "supplierId", value = "供应商id", notes = "供应商id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "供应商名", notes = "供应商名")
   private String supplierName;
   @ApiModelProperty(name = "basicClass", value = "物料分类", notes = "物料分类")
   private Integer basicClass;
   @ApiModelProperty(name = "timeStart", value = "有效期开始", notes = "有效期开始")
   private LocalDateTime timeStart;
   @ApiModelProperty(name = "timeEnd", value = "有效期结束", notes = "有效期结束")
   private LocalDateTime timeEnd;
   @ApiModelProperty(name = "attachments", value = "附件ids", notes = "附件ids")
   private List<Long> attachments;
   @ApiModelProperty(name = "amount", value = "累计交易额度", notes = "累计交易额度")
   private BigDecimal amount;
   @ApiModelProperty(name = "yearAmount", value = "年度交易额", notes = "年度交易额")
   private BigDecimal yearAmount;
   @ApiModelProperty(name = "applicantName", value = "申请人名", notes = "申请人名")
   private String applicantName;
   @ApiModelProperty(name = "applicantId", value = "申请人id", notes = "申请人id")
   private Long applicantId;
   @ApiModelProperty(name = "status", value = "是否开启 0 关闭  1开启", notes = "是否开启 0 关闭  1开启")
   private Boolean status;
   @ApiModelProperty(name = "delBasicClassList", value = "删除的材料类型", notes = "删除的材料类型")
   private List<Integer> delBasicClassList;

   public static AnnualContractDTOParam.AnnualContractDTOParamBuilder builder() {
      return new AnnualContractDTOParam.AnnualContractDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public LocalDateTime getTimeStart() {
      return this.timeStart;
   }

   public LocalDateTime getTimeEnd() {
      return this.timeEnd;
   }

   public List<Long> getAttachments() {
      return this.attachments;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getYearAmount() {
      return this.yearAmount;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public List<Integer> getDelBasicClassList() {
      return this.delBasicClassList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setTimeStart(final LocalDateTime timeStart) {
      this.timeStart = timeStart;
   }

   public void setTimeEnd(final LocalDateTime timeEnd) {
      this.timeEnd = timeEnd;
   }

   public void setAttachments(final List<Long> attachments) {
      this.attachments = attachments;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setYearAmount(final BigDecimal yearAmount) {
      this.yearAmount = yearAmount;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   public void setDelBasicClassList(final List<Integer> delBasicClassList) {
      this.delBasicClassList = delBasicClassList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AnnualContractDTOParam)) {
         return false;
      }

      AnnualContractDTOParam other = (AnnualContractDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$applicantId = this.getApplicantId();
               Object other$applicantId = other.getApplicantId();
               if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$supplierName = this.getSupplierName();
                        Object other$supplierName = other.getSupplierName();
                        if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                           Object this$timeStart = this.getTimeStart();
                           Object other$timeStart = other.getTimeStart();
                           if (this$timeStart == null ? other$timeStart == null : this$timeStart.equals(other$timeStart)) {
                              Object this$timeEnd = this.getTimeEnd();
                              Object other$timeEnd = other.getTimeEnd();
                              if (this$timeEnd == null ? other$timeEnd == null : this$timeEnd.equals(other$timeEnd)) {
                                 Object this$attachments = this.getAttachments();
                                 Object other$attachments = other.getAttachments();
                                 if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
                                    Object this$amount = this.getAmount();
                                    Object other$amount = other.getAmount();
                                    if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                       Object this$yearAmount = this.getYearAmount();
                                       Object other$yearAmount = other.getYearAmount();
                                       if (this$yearAmount == null ? other$yearAmount == null : this$yearAmount.equals(other$yearAmount)) {
                                          Object this$applicantName = this.getApplicantName();
                                          Object other$applicantName = other.getApplicantName();
                                          if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                             Object this$delBasicClassList = this.getDelBasicClassList();
                                             Object other$delBasicClassList = other.getDelBasicClassList();
                                             return this$delBasicClassList == null
                                                ? other$delBasicClassList == null
                                                : this$delBasicClassList.equals(other$delBasicClassList);
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
      return other instanceof AnnualContractDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $timeStart = this.getTimeStart();
      result = result * 59 + ($timeStart == null ? 43 : $timeStart.hashCode());
      Object $timeEnd = this.getTimeEnd();
      result = result * 59 + ($timeEnd == null ? 43 : $timeEnd.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $yearAmount = this.getYearAmount();
      result = result * 59 + ($yearAmount == null ? 43 : $yearAmount.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $delBasicClassList = this.getDelBasicClassList();
      return result * 59 + ($delBasicClassList == null ? 43 : $delBasicClassList.hashCode());
   }

   @Override
   public String toString() {
      return "AnnualContractDTOParam(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", basicClass="
         + this.getBasicClass()
         + ", timeStart="
         + this.getTimeStart()
         + ", timeEnd="
         + this.getTimeEnd()
         + ", attachments="
         + this.getAttachments()
         + ", amount="
         + this.getAmount()
         + ", yearAmount="
         + this.getYearAmount()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicantId="
         + this.getApplicantId()
         + ", status="
         + this.getStatus()
         + ", delBasicClassList="
         + this.getDelBasicClassList()
         + ")";
   }

   public AnnualContractDTOParam(
      final Long id,
      final String serialNumber,
      final Long supplierId,
      final String supplierName,
      final Integer basicClass,
      final LocalDateTime timeStart,
      final LocalDateTime timeEnd,
      final List<Long> attachments,
      final BigDecimal amount,
      final BigDecimal yearAmount,
      final String applicantName,
      final Long applicantId,
      final Boolean status,
      final List<Integer> delBasicClassList
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.basicClass = basicClass;
      this.timeStart = timeStart;
      this.timeEnd = timeEnd;
      this.attachments = attachments;
      this.amount = amount;
      this.yearAmount = yearAmount;
      this.applicantName = applicantName;
      this.applicantId = applicantId;
      this.status = status;
      this.delBasicClassList = delBasicClassList;
   }

   public AnnualContractDTOParam() {
   }

   public static class AnnualContractDTOParamBuilder {
      private Long id;
      private String serialNumber;
      private Long supplierId;
      private String supplierName;
      private Integer basicClass;
      private LocalDateTime timeStart;
      private LocalDateTime timeEnd;
      private List<Long> attachments;
      private BigDecimal amount;
      private BigDecimal yearAmount;
      private String applicantName;
      private Long applicantId;
      private Boolean status;
      private List<Integer> delBasicClassList;

      AnnualContractDTOParamBuilder() {
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder timeStart(final LocalDateTime timeStart) {
         this.timeStart = timeStart;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder timeEnd(final LocalDateTime timeEnd) {
         this.timeEnd = timeEnd;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder attachments(final List<Long> attachments) {
         this.attachments = attachments;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder yearAmount(final BigDecimal yearAmount) {
         this.yearAmount = yearAmount;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public AnnualContractDTOParam.AnnualContractDTOParamBuilder delBasicClassList(final List<Integer> delBasicClassList) {
         this.delBasicClassList = delBasicClassList;
         return this;
      }

      public AnnualContractDTOParam build() {
         return new AnnualContractDTOParam(
            this.id,
            this.serialNumber,
            this.supplierId,
            this.supplierName,
            this.basicClass,
            this.timeStart,
            this.timeEnd,
            this.attachments,
            this.amount,
            this.yearAmount,
            this.applicantName,
            this.applicantId,
            this.status,
            this.delBasicClassList
         );
      }

      @Override
      public String toString() {
         return "AnnualContractDTOParam.AnnualContractDTOParamBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", basicClass="
            + this.basicClass
            + ", timeStart="
            + this.timeStart
            + ", timeEnd="
            + this.timeEnd
            + ", attachments="
            + this.attachments
            + ", amount="
            + this.amount
            + ", yearAmount="
            + this.yearAmount
            + ", applicantName="
            + this.applicantName
            + ", applicantId="
            + this.applicantId
            + ", status="
            + this.status
            + ", delBasicClassList="
            + this.delBasicClassList
            + ")";
      }
   }
}
