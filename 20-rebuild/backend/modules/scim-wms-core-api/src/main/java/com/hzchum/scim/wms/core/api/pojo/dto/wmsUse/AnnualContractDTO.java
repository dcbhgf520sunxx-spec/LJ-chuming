package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class AnnualContractDTO {
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
   private List<AttachmentDTO> attachments;
   @ApiModelProperty(name = "amount", value = "累计交易额度", notes = "累计交易额度")
   private BigDecimal amount;
   @ApiModelProperty(name = "lastYearAmount", value = "上年度交易额", notes = "上年度交易额")
   private BigDecimal lastYearAmount;
   @ApiModelProperty(name = "thisYearAmount", value = "本年度交易额", notes = "本年度交易额")
   private BigDecimal thisYearAmount;
   @ApiModelProperty(name = "applicantName", value = "申请人名", notes = "申请人名")
   private String applicantName;
   @ApiModelProperty(name = "applicantId", value = "申请人id", notes = "申请人id")
   private Long applicantId;
   @ApiModelProperty(name = "status", value = "是否开启 0 关闭  1开启", notes = "是否开启 0 关闭  1开启")
   private Boolean status;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   private LocalDateTime createTime;

   public static AnnualContractDTO.AnnualContractDTOBuilder builder() {
      return new AnnualContractDTO.AnnualContractDTOBuilder();
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

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getLastYearAmount() {
      return this.lastYearAmount;
   }

   public BigDecimal getThisYearAmount() {
      return this.thisYearAmount;
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

   public LocalDateTime getCreateTime() {
      return this.createTime;
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

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setLastYearAmount(final BigDecimal lastYearAmount) {
      this.lastYearAmount = lastYearAmount;
   }

   public void setThisYearAmount(final BigDecimal thisYearAmount) {
      this.thisYearAmount = thisYearAmount;
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

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AnnualContractDTO)) {
         return false;
      }

      AnnualContractDTO other = (AnnualContractDTO)o;
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
                                       Object this$lastYearAmount = this.getLastYearAmount();
                                       Object other$lastYearAmount = other.getLastYearAmount();
                                       if (this$lastYearAmount == null ? other$lastYearAmount == null : this$lastYearAmount.equals(other$lastYearAmount)) {
                                          Object this$thisYearAmount = this.getThisYearAmount();
                                          Object other$thisYearAmount = other.getThisYearAmount();
                                          if (this$thisYearAmount == null ? other$thisYearAmount == null : this$thisYearAmount.equals(other$thisYearAmount)) {
                                             Object this$applicantName = this.getApplicantName();
                                             Object other$applicantName = other.getApplicantName();
                                             if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                                Object this$createTime = this.getCreateTime();
                                                Object other$createTime = other.getCreateTime();
                                                return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof AnnualContractDTO;
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
      Object $lastYearAmount = this.getLastYearAmount();
      result = result * 59 + ($lastYearAmount == null ? 43 : $lastYearAmount.hashCode());
      Object $thisYearAmount = this.getThisYearAmount();
      result = result * 59 + ($thisYearAmount == null ? 43 : $thisYearAmount.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "AnnualContractDTO(id="
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
         + ", lastYearAmount="
         + this.getLastYearAmount()
         + ", thisYearAmount="
         + this.getThisYearAmount()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicantId="
         + this.getApplicantId()
         + ", status="
         + this.getStatus()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public AnnualContractDTO(
      final Long id,
      final String serialNumber,
      final Long supplierId,
      final String supplierName,
      final Integer basicClass,
      final LocalDateTime timeStart,
      final LocalDateTime timeEnd,
      final List<AttachmentDTO> attachments,
      final BigDecimal amount,
      final BigDecimal lastYearAmount,
      final BigDecimal thisYearAmount,
      final String applicantName,
      final Long applicantId,
      final Boolean status,
      final LocalDateTime createTime
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
      this.lastYearAmount = lastYearAmount;
      this.thisYearAmount = thisYearAmount;
      this.applicantName = applicantName;
      this.applicantId = applicantId;
      this.status = status;
      this.createTime = createTime;
   }

   public AnnualContractDTO() {
   }

   public static class AnnualContractDTOBuilder {
      private Long id;
      private String serialNumber;
      private Long supplierId;
      private String supplierName;
      private Integer basicClass;
      private LocalDateTime timeStart;
      private LocalDateTime timeEnd;
      private List<AttachmentDTO> attachments;
      private BigDecimal amount;
      private BigDecimal lastYearAmount;
      private BigDecimal thisYearAmount;
      private String applicantName;
      private Long applicantId;
      private Boolean status;
      private LocalDateTime createTime;

      AnnualContractDTOBuilder() {
      }

      public AnnualContractDTO.AnnualContractDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder timeStart(final LocalDateTime timeStart) {
         this.timeStart = timeStart;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder timeEnd(final LocalDateTime timeEnd) {
         this.timeEnd = timeEnd;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder lastYearAmount(final BigDecimal lastYearAmount) {
         this.lastYearAmount = lastYearAmount;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder thisYearAmount(final BigDecimal thisYearAmount) {
         this.thisYearAmount = thisYearAmount;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public AnnualContractDTO.AnnualContractDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public AnnualContractDTO build() {
         return new AnnualContractDTO(
            this.id,
            this.serialNumber,
            this.supplierId,
            this.supplierName,
            this.basicClass,
            this.timeStart,
            this.timeEnd,
            this.attachments,
            this.amount,
            this.lastYearAmount,
            this.thisYearAmount,
            this.applicantName,
            this.applicantId,
            this.status,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "AnnualContractDTO.AnnualContractDTOBuilder(id="
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
            + ", lastYearAmount="
            + this.lastYearAmount
            + ", thisYearAmount="
            + this.thisYearAmount
            + ", applicantName="
            + this.applicantName
            + ", applicantId="
            + this.applicantId
            + ", status="
            + this.status
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
