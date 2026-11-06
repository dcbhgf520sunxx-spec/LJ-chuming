package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "WasteSale对象", description = "废料出售记录表 ")
@Entity
@TableName("wms_waste_sale")
@Table(name = "wms_waste_sale")
@org.hibernate.annotations.Table(appliesTo = "wms_waste_sale", comment = "废料出售记录表 ")
public class WasteSale extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "saleDate", value = "出售日期", notes = "出售日期")
   @TableField("sale_date")
   @Column(name = "sale_date", columnDefinition = "date  COMMENT '出售日期'", nullable = false)
   private LocalDate saleDate;
   @ApiModelProperty(name = "branchCompanyId", value = "出售单位id (分支机构id)", notes = "出售单位id (分支机构id)")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '出售单位id (分支机构id)'", nullable = false)
   private Long branchCompanyId;
   @ApiModelProperty(name = "contractWasteId", value = "废料合同表id", notes = "废料合同表id")
   @TableField("contract_waste_id")
   @Column(name = "contract_waste_id", columnDefinition = "bigint(20)  COMMENT '废料合同表id'", nullable = false)
   private Long contractWasteId;
   @ApiModelProperty(name = "plateNumber", value = "车牌号", notes = "车牌号")
   @TableField("plate_number")
   @Column(name = "plate_number", columnDefinition = "varchar(32)  COMMENT '车牌号'", nullable = false)
   private String plateNumber;
   @ApiModelProperty(name = "totalAmount", value = "总金额(元)", notes = "总金额(元)")
   @TableField("total_amount")
   @Column(name = "total_amount", columnDefinition = "decimal(32,4)  COMMENT '总金额(元)'", nullable = true)
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "creatorRemark", value = "创建人备注", notes = "创建人备注")
   @TableField("creator_remark")
   @Column(name = "creator_remark", columnDefinition = "varchar(1024)  COMMENT '创建人备注'", nullable = true)
   private String creatorRemark;
   @ApiModelProperty(name = "auditStatusEnum", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   @TableField("audit_status_enum")
   @Column(name = "audit_status_enum", columnDefinition = "int(11) default '1' COMMENT '审核状态 1未审核 2审核通过 4驳回'", nullable = false)
   private Integer auditStatusEnum;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审核人id'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime(6)  COMMENT '审核时间'", nullable = true)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditorRemark", value = "审核人备注", notes = "审核人备注")
   @TableField("auditor_remark")
   @Column(name = "auditor_remark", columnDefinition = "varchar(1024)  COMMENT '审核人备注'", nullable = true)
   private String auditorRemark;

   public static WasteSale.WasteSaleBuilder builder() {
      return new WasteSale.WasteSaleBuilder();
   }

   public WasteSale() {
   }

   public WasteSale(
      final Long id,
      final LocalDate saleDate,
      final Long branchCompanyId,
      final Long contractWasteId,
      final String plateNumber,
      final BigDecimal totalAmount,
      final Long createUserId,
      final String creatorRemark,
      final Integer auditStatusEnum,
      final Long auditUserId,
      final LocalDateTime auditTime,
      final String auditorRemark
   ) {
      this.id = id;
      this.saleDate = saleDate;
      this.branchCompanyId = branchCompanyId;
      this.contractWasteId = contractWasteId;
      this.plateNumber = plateNumber;
      this.totalAmount = totalAmount;
      this.createUserId = createUserId;
      this.creatorRemark = creatorRemark;
      this.auditStatusEnum = auditStatusEnum;
      this.auditUserId = auditUserId;
      this.auditTime = auditTime;
      this.auditorRemark = auditorRemark;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getSaleDate() {
      return this.saleDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public String getPlateNumber() {
      return this.plateNumber;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreatorRemark() {
      return this.creatorRemark;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public String getAuditorRemark() {
      return this.auditorRemark;
   }

   public WasteSale setId(final Long id) {
      this.id = id;
      return this;
   }

   public WasteSale setSaleDate(final LocalDate saleDate) {
      this.saleDate = saleDate;
      return this;
   }

   public WasteSale setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public WasteSale setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
      return this;
   }

   public WasteSale setPlateNumber(final String plateNumber) {
      this.plateNumber = plateNumber;
      return this;
   }

   public WasteSale setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
      return this;
   }

   public WasteSale setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public WasteSale setCreatorRemark(final String creatorRemark) {
      this.creatorRemark = creatorRemark;
      return this;
   }

   public WasteSale setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
      return this;
   }

   public WasteSale setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   public WasteSale setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public WasteSale setAuditorRemark(final String auditorRemark) {
      this.auditorRemark = auditorRemark;
      return this;
   }

   @Override
   public String toString() {
      return "WasteSale(id="
         + this.getId()
         + ", saleDate="
         + this.getSaleDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", plateNumber="
         + this.getPlateNumber()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", createUserId="
         + this.getCreateUserId()
         + ", creatorRemark="
         + this.getCreatorRemark()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditorRemark="
         + this.getAuditorRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WasteSale)) {
         return false;
      }

      WasteSale other = (WasteSale)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$contractWasteId = this.getContractWasteId();
            Object other$contractWasteId = other.getContractWasteId();
            if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$auditStatusEnum = this.getAuditStatusEnum();
                  Object other$auditStatusEnum = other.getAuditStatusEnum();
                  if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
                     Object this$auditUserId = this.getAuditUserId();
                     Object other$auditUserId = other.getAuditUserId();
                     if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                        Object this$saleDate = this.getSaleDate();
                        Object other$saleDate = other.getSaleDate();
                        if (this$saleDate == null ? other$saleDate == null : this$saleDate.equals(other$saleDate)) {
                           Object this$plateNumber = this.getPlateNumber();
                           Object other$plateNumber = other.getPlateNumber();
                           if (this$plateNumber == null ? other$plateNumber == null : this$plateNumber.equals(other$plateNumber)) {
                              Object this$totalAmount = this.getTotalAmount();
                              Object other$totalAmount = other.getTotalAmount();
                              if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                                 Object this$creatorRemark = this.getCreatorRemark();
                                 Object other$creatorRemark = other.getCreatorRemark();
                                 if (this$creatorRemark == null ? other$creatorRemark == null : this$creatorRemark.equals(other$creatorRemark)) {
                                    Object this$auditTime = this.getAuditTime();
                                    Object other$auditTime = other.getAuditTime();
                                    if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                       Object this$auditorRemark = this.getAuditorRemark();
                                       Object other$auditorRemark = other.getAuditorRemark();
                                       return this$auditorRemark == null ? other$auditorRemark == null : this$auditorRemark.equals(other$auditorRemark);
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
      return other instanceof WasteSale;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $saleDate = this.getSaleDate();
      result = result * 59 + ($saleDate == null ? 43 : $saleDate.hashCode());
      Object $plateNumber = this.getPlateNumber();
      result = result * 59 + ($plateNumber == null ? 43 : $plateNumber.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $creatorRemark = this.getCreatorRemark();
      result = result * 59 + ($creatorRemark == null ? 43 : $creatorRemark.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $auditorRemark = this.getAuditorRemark();
      return result * 59 + ($auditorRemark == null ? 43 : $auditorRemark.hashCode());
   }

   public static class WasteSaleBuilder {
      private Long id;
      private LocalDate saleDate;
      private Long branchCompanyId;
      private Long contractWasteId;
      private String plateNumber;
      private BigDecimal totalAmount;
      private Long createUserId;
      private String creatorRemark;
      private Integer auditStatusEnum;
      private Long auditUserId;
      private LocalDateTime auditTime;
      private String auditorRemark;

      WasteSaleBuilder() {
      }

      public WasteSale.WasteSaleBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WasteSale.WasteSaleBuilder saleDate(final LocalDate saleDate) {
         this.saleDate = saleDate;
         return this;
      }

      public WasteSale.WasteSaleBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public WasteSale.WasteSaleBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public WasteSale.WasteSaleBuilder plateNumber(final String plateNumber) {
         this.plateNumber = plateNumber;
         return this;
      }

      public WasteSale.WasteSaleBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public WasteSale.WasteSaleBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public WasteSale.WasteSaleBuilder creatorRemark(final String creatorRemark) {
         this.creatorRemark = creatorRemark;
         return this;
      }

      public WasteSale.WasteSaleBuilder auditStatusEnum(final Integer auditStatusEnum) {
         this.auditStatusEnum = auditStatusEnum;
         return this;
      }

      public WasteSale.WasteSaleBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public WasteSale.WasteSaleBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public WasteSale.WasteSaleBuilder auditorRemark(final String auditorRemark) {
         this.auditorRemark = auditorRemark;
         return this;
      }

      public WasteSale build() {
         return new WasteSale(
            this.id,
            this.saleDate,
            this.branchCompanyId,
            this.contractWasteId,
            this.plateNumber,
            this.totalAmount,
            this.createUserId,
            this.creatorRemark,
            this.auditStatusEnum,
            this.auditUserId,
            this.auditTime,
            this.auditorRemark
         );
      }

      @Override
      public String toString() {
         return "WasteSale.WasteSaleBuilder(id="
            + this.id
            + ", saleDate="
            + this.saleDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", contractWasteId="
            + this.contractWasteId
            + ", plateNumber="
            + this.plateNumber
            + ", totalAmount="
            + this.totalAmount
            + ", createUserId="
            + this.createUserId
            + ", creatorRemark="
            + this.creatorRemark
            + ", auditStatusEnum="
            + this.auditStatusEnum
            + ", auditUserId="
            + this.auditUserId
            + ", auditTime="
            + this.auditTime
            + ", auditorRemark="
            + this.auditorRemark
            + ")";
      }
   }
}
