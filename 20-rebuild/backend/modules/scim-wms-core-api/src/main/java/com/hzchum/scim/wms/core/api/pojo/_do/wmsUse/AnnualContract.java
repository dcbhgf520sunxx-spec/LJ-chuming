package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "WmsAnnualContract对象", description = "")
@Entity
@TableName("wms_annual_contract")
@Table(name = "wms_annual_contract")
@org.hibernate.annotations.Table(appliesTo = "wms_annual_contract")
public class AnnualContract extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "合同编号", notes = "合同编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '合同编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "supplierId", value = "供应商id", notes = "供应商id")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint(20)  COMMENT '供应商id'", nullable = true)
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "供应商名", notes = "供应商名")
   @TableField("supplier_name")
   @Column(name = "supplier_name", columnDefinition = "varchar(255)  COMMENT '供应商名'", nullable = true)
   private String supplierName;
   @ApiModelProperty(name = "basicClass", value = "物料分类", notes = "物料分类")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(20)  COMMENT '物料分类'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "timeStart", value = "有效期开始", notes = "有效期开始")
   @TableField("time_start")
   @Column(name = "time_start", columnDefinition = "datetime(6)  COMMENT '有效期开始'", nullable = true)
   private LocalDateTime timeStart;
   @ApiModelProperty(name = "timeEnd", value = "有效期结束", notes = "有效期结束")
   @TableField("time_end")
   @Column(name = "time_end", columnDefinition = "datetime(6)  COMMENT '有效期结束'", nullable = true)
   private LocalDateTime timeEnd;
   @ApiModelProperty(name = "attachments", value = "附件ids", notes = "附件ids")
   @TableField("attachments")
   @Column(name = "attachments", columnDefinition = "varchar(255)  COMMENT '附件ids'", nullable = true)
   private String attachments;
   @ApiModelProperty(name = "amount", value = "累计交易额度", notes = "累计交易额度")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,12)  COMMENT '累计交易额度'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty(name = "yearAmount", value = "年度交易额", notes = "年度交易额")
   @TableField("year_amount")
   @Column(name = "year_amount", columnDefinition = "decimal(32,12)  COMMENT '年度交易额'", nullable = true)
   private BigDecimal yearAmount;
   @ApiModelProperty(name = "applicantName", value = "申请人名", notes = "申请人名")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '申请人名'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "applicantId", value = "申请人id", notes = "申请人id")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint(20)  COMMENT '申请人id'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "status", value = "结算未结算 0未结算  1结算", notes = "结算未结算 0未结算  1结算")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '0' COMMENT '结算未结算 0未结算  1结算'", nullable = true)
   private Boolean status;

   public static AnnualContract.AnnualContractBuilder builder() {
      return new AnnualContract.AnnualContractBuilder();
   }

   public AnnualContract() {
   }

   public AnnualContract(
      final Long id,
      final String serialNumber,
      final Long supplierId,
      final String supplierName,
      final Integer basicClass,
      final LocalDateTime timeStart,
      final LocalDateTime timeEnd,
      final String attachments,
      final BigDecimal amount,
      final BigDecimal yearAmount,
      final String applicantName,
      final Long applicantId,
      final Boolean status
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

   public String getAttachments() {
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

   public AnnualContract setId(final Long id) {
      this.id = id;
      return this;
   }

   public AnnualContract setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public AnnualContract setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
      return this;
   }

   public AnnualContract setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
      return this;
   }

   public AnnualContract setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public AnnualContract setTimeStart(final LocalDateTime timeStart) {
      this.timeStart = timeStart;
      return this;
   }

   public AnnualContract setTimeEnd(final LocalDateTime timeEnd) {
      this.timeEnd = timeEnd;
      return this;
   }

   public AnnualContract setAttachments(final String attachments) {
      this.attachments = attachments;
      return this;
   }

   public AnnualContract setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public AnnualContract setYearAmount(final BigDecimal yearAmount) {
      this.yearAmount = yearAmount;
      return this;
   }

   public AnnualContract setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   public AnnualContract setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   public AnnualContract setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "AnnualContract(id="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AnnualContract)) {
         return false;
      }

      AnnualContract other = (AnnualContract)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                                          return this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof AnnualContract;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      return result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
   }

   public static class AnnualContractBuilder {
      private Long id;
      private String serialNumber;
      private Long supplierId;
      private String supplierName;
      private Integer basicClass;
      private LocalDateTime timeStart;
      private LocalDateTime timeEnd;
      private String attachments;
      private BigDecimal amount;
      private BigDecimal yearAmount;
      private String applicantName;
      private Long applicantId;
      private Boolean status;

      AnnualContractBuilder() {
      }

      public AnnualContract.AnnualContractBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AnnualContract.AnnualContractBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AnnualContract.AnnualContractBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public AnnualContract.AnnualContractBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public AnnualContract.AnnualContractBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public AnnualContract.AnnualContractBuilder timeStart(final LocalDateTime timeStart) {
         this.timeStart = timeStart;
         return this;
      }

      public AnnualContract.AnnualContractBuilder timeEnd(final LocalDateTime timeEnd) {
         this.timeEnd = timeEnd;
         return this;
      }

      public AnnualContract.AnnualContractBuilder attachments(final String attachments) {
         this.attachments = attachments;
         return this;
      }

      public AnnualContract.AnnualContractBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public AnnualContract.AnnualContractBuilder yearAmount(final BigDecimal yearAmount) {
         this.yearAmount = yearAmount;
         return this;
      }

      public AnnualContract.AnnualContractBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public AnnualContract.AnnualContractBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public AnnualContract.AnnualContractBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public AnnualContract build() {
         return new AnnualContract(
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
            this.status
         );
      }

      @Override
      public String toString() {
         return "AnnualContract.AnnualContractBuilder(id="
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
            + ")";
      }
   }
}
