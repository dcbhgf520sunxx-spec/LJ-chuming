package com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work;

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

@ApiModel(value = "MesReportWorkApproved对象", description = "报工审核通过表")
@Entity
@TableName("mes_report_work_approved")
@Table(name = "mes_report_work_approved")
@org.hibernate.annotations.Table(appliesTo = "mes_report_work_approved", comment = "报工审核通过表")
public class MesReportWorkApproved extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("产品类型")
   @TableField("product_type_enum")
   @Column(name = "product_type_enum", columnDefinition = "int(11) COMMENT '产品类型'", nullable = true)
   private Integer productTypeEnum;
   @ApiModelProperty("班组生产上报记录ID")
   @TableField("produce_team_report_id")
   @Column(name = "produce_team_report_id", columnDefinition = "bigint(20) COMMENT '班组生产上报记录ID'", nullable = true)
   private Long produceTeamReportId;
   @ApiModelProperty("报工日期")
   @TableField("report_time")
   @Column(name = "report_time", columnDefinition = "datetime COMMENT '报工日期'", nullable = true)
   private LocalDateTime reportTime;
   @ApiModelProperty("车间ID")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20) COMMENT '车间ID'", nullable = true)
   private Long workshopId;
   @ApiModelProperty("项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty("单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty("工序id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20) COMMENT '工序id'", nullable = true)
   private Long processId;
   @ApiModelProperty("班组ID")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20) COMMENT '班组ID'", nullable = true)
   private Long teamId;
   @ApiModelProperty("产品ID")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20) COMMENT '产品ID'", nullable = true)
   private Long productId;
   @ApiModelProperty("产品编号")
   @TableField("product_serial_number")
   @Column(name = "product_serial_number", columnDefinition = "varchar(255) COMMENT '产品编号'", nullable = true)
   private String productSerialNumber;
   @ApiModelProperty("单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255) COMMENT '单位'", nullable = true)
   private String unit;
   @ApiModelProperty("核算量")
   @TableField("accounting_quantity")
   @Column(name = "accounting_quantity", columnDefinition = "decimal(32,8) COMMENT '核算量'", nullable = true)
   private BigDecimal accountingQuantity;
   @ApiModelProperty("定额配置ID")
   @TableField("quota_config_id")
   @Column(name = "quota_config_id", columnDefinition = "bigint(20) COMMENT '定额配置ID'", nullable = true)
   private Long quotaConfigId;
   @ApiModelProperty("定额配置编号")
   @TableField("quota_config_number")
   @Column(name = "quota_config_number", columnDefinition = "varchar(255) COMMENT '定额配置编号'", nullable = true)
   private String quotaConfigNumber;
   @ApiModelProperty("单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty("总价(元)")
   @TableField("total_price")
   @Column(name = "total_price", columnDefinition = "decimal(32,8) COMMENT '总价(元)'", nullable = true)
   private BigDecimal totalPrice;
   @ApiModelProperty("总重(kg)")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(32,8) COMMENT '总重(kg)'", nullable = true)
   private BigDecimal totalWeight;
   @ApiModelProperty("定义类型")
   @TableField("define_type")
   @Column(name = "define_type", columnDefinition = "varchar(255) COMMENT '定义类型'", nullable = true)
   private String defineType;
   @ApiModelProperty("审批日期")
   @TableField("approval_time")
   @Column(name = "approval_time", columnDefinition = "datetime COMMENT '审批日期'", nullable = true)
   private LocalDateTime approvalTime;
   @ApiModelProperty("审批人id")
   @TableField("approval_user_id")
   @Column(name = "approval_user_id", columnDefinition = "bigint(20) COMMENT '审批人id'", nullable = true)
   private Long approvalUserId;

   public static MesReportWorkApproved.MesReportWorkApprovedBuilder builder() {
      return new MesReportWorkApproved.MesReportWorkApprovedBuilder();
   }

   public MesReportWorkApproved() {
   }

   public MesReportWorkApproved(
      final Long id,
      final Integer productTypeEnum,
      final Long produceTeamReportId,
      final LocalDateTime reportTime,
      final Long workshopId,
      final Long projectId,
      final Long monomerId,
      final Long processId,
      final Long teamId,
      final Long productId,
      final String productSerialNumber,
      final String unit,
      final BigDecimal accountingQuantity,
      final Long quotaConfigId,
      final String quotaConfigNumber,
      final BigDecimal price,
      final BigDecimal totalPrice,
      final BigDecimal totalWeight,
      final String defineType,
      final LocalDateTime approvalTime,
      final Long approvalUserId
   ) {
      this.id = id;
      this.productTypeEnum = productTypeEnum;
      this.produceTeamReportId = produceTeamReportId;
      this.reportTime = reportTime;
      this.workshopId = workshopId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.processId = processId;
      this.teamId = teamId;
      this.productId = productId;
      this.productSerialNumber = productSerialNumber;
      this.unit = unit;
      this.accountingQuantity = accountingQuantity;
      this.quotaConfigId = quotaConfigId;
      this.quotaConfigNumber = quotaConfigNumber;
      this.price = price;
      this.totalPrice = totalPrice;
      this.totalWeight = totalWeight;
      this.defineType = defineType;
      this.approvalTime = approvalTime;
      this.approvalUserId = approvalUserId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Long getProduceTeamReportId() {
      return this.produceTeamReportId;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getAccountingQuantity() {
      return this.accountingQuantity;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaConfigNumber() {
      return this.quotaConfigNumber;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public String getDefineType() {
      return this.defineType;
   }

   public LocalDateTime getApprovalTime() {
      return this.approvalTime;
   }

   public Long getApprovalUserId() {
      return this.approvalUserId;
   }

   public MesReportWorkApproved setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesReportWorkApproved setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
      return this;
   }

   public MesReportWorkApproved setProduceTeamReportId(final Long produceTeamReportId) {
      this.produceTeamReportId = produceTeamReportId;
      return this;
   }

   public MesReportWorkApproved setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
      return this;
   }

   public MesReportWorkApproved setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesReportWorkApproved setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesReportWorkApproved setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesReportWorkApproved setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesReportWorkApproved setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesReportWorkApproved setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesReportWorkApproved setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   public MesReportWorkApproved setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public MesReportWorkApproved setAccountingQuantity(final BigDecimal accountingQuantity) {
      this.accountingQuantity = accountingQuantity;
      return this;
   }

   public MesReportWorkApproved setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
      return this;
   }

   public MesReportWorkApproved setQuotaConfigNumber(final String quotaConfigNumber) {
      this.quotaConfigNumber = quotaConfigNumber;
      return this;
   }

   public MesReportWorkApproved setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesReportWorkApproved setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   public MesReportWorkApproved setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   public MesReportWorkApproved setDefineType(final String defineType) {
      this.defineType = defineType;
      return this;
   }

   public MesReportWorkApproved setApprovalTime(final LocalDateTime approvalTime) {
      this.approvalTime = approvalTime;
      return this;
   }

   public MesReportWorkApproved setApprovalUserId(final Long approvalUserId) {
      this.approvalUserId = approvalUserId;
      return this;
   }

   @Override
   public String toString() {
      return "MesReportWorkApproved(id="
         + this.getId()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", produceTeamReportId="
         + this.getProduceTeamReportId()
         + ", reportTime="
         + this.getReportTime()
         + ", workshopId="
         + this.getWorkshopId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", productId="
         + this.getProductId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", unit="
         + this.getUnit()
         + ", accountingQuantity="
         + this.getAccountingQuantity()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaConfigNumber="
         + this.getQuotaConfigNumber()
         + ", price="
         + this.getPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", defineType="
         + this.getDefineType()
         + ", approvalTime="
         + this.getApprovalTime()
         + ", approvalUserId="
         + this.getApprovalUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesReportWorkApproved)) {
         return false;
      }

      MesReportWorkApproved other = (MesReportWorkApproved)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productTypeEnum = this.getProductTypeEnum();
         Object other$productTypeEnum = other.getProductTypeEnum();
         if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
            Object this$produceTeamReportId = this.getProduceTeamReportId();
            Object other$produceTeamReportId = other.getProduceTeamReportId();
            if (this$produceTeamReportId == null ? other$produceTeamReportId == null : this$produceTeamReportId.equals(other$produceTeamReportId)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$monomerId = this.getMonomerId();
                     Object other$monomerId = other.getMonomerId();
                     if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                        Object this$processId = this.getProcessId();
                        Object other$processId = other.getProcessId();
                        if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                           Object this$teamId = this.getTeamId();
                           Object other$teamId = other.getTeamId();
                           if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                 Object this$quotaConfigId = this.getQuotaConfigId();
                                 Object other$quotaConfigId = other.getQuotaConfigId();
                                 if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
                                    Object this$approvalUserId = this.getApprovalUserId();
                                    Object other$approvalUserId = other.getApprovalUserId();
                                    if (this$approvalUserId == null ? other$approvalUserId == null : this$approvalUserId.equals(other$approvalUserId)) {
                                       Object this$reportTime = this.getReportTime();
                                       Object other$reportTime = other.getReportTime();
                                       if (this$reportTime == null ? other$reportTime == null : this$reportTime.equals(other$reportTime)) {
                                          Object this$productSerialNumber = this.getProductSerialNumber();
                                          Object other$productSerialNumber = other.getProductSerialNumber();
                                          if (this$productSerialNumber == null
                                             ? other$productSerialNumber == null
                                             : this$productSerialNumber.equals(other$productSerialNumber)) {
                                             Object this$unit = this.getUnit();
                                             Object other$unit = other.getUnit();
                                             if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                                Object this$accountingQuantity = this.getAccountingQuantity();
                                                Object other$accountingQuantity = other.getAccountingQuantity();
                                                if (this$accountingQuantity == null
                                                   ? other$accountingQuantity == null
                                                   : this$accountingQuantity.equals(other$accountingQuantity)) {
                                                   Object this$quotaConfigNumber = this.getQuotaConfigNumber();
                                                   Object other$quotaConfigNumber = other.getQuotaConfigNumber();
                                                   if (this$quotaConfigNumber == null
                                                      ? other$quotaConfigNumber == null
                                                      : this$quotaConfigNumber.equals(other$quotaConfigNumber)) {
                                                      Object this$price = this.getPrice();
                                                      Object other$price = other.getPrice();
                                                      if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                         Object this$totalPrice = this.getTotalPrice();
                                                         Object other$totalPrice = other.getTotalPrice();
                                                         if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                                                            Object this$totalWeight = this.getTotalWeight();
                                                            Object other$totalWeight = other.getTotalWeight();
                                                            if (this$totalWeight == null
                                                               ? other$totalWeight == null
                                                               : this$totalWeight.equals(other$totalWeight)) {
                                                               Object this$defineType = this.getDefineType();
                                                               Object other$defineType = other.getDefineType();
                                                               if (this$defineType == null
                                                                  ? other$defineType == null
                                                                  : this$defineType.equals(other$defineType)) {
                                                                  Object this$approvalTime = this.getApprovalTime();
                                                                  Object other$approvalTime = other.getApprovalTime();
                                                                  return this$approvalTime == null
                                                                     ? other$approvalTime == null
                                                                     : this$approvalTime.equals(other$approvalTime);
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
      return other instanceof MesReportWorkApproved;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $produceTeamReportId = this.getProduceTeamReportId();
      result = result * 59 + ($produceTeamReportId == null ? 43 : $produceTeamReportId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $approvalUserId = this.getApprovalUserId();
      result = result * 59 + ($approvalUserId == null ? 43 : $approvalUserId.hashCode());
      Object $reportTime = this.getReportTime();
      result = result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $accountingQuantity = this.getAccountingQuantity();
      result = result * 59 + ($accountingQuantity == null ? 43 : $accountingQuantity.hashCode());
      Object $quotaConfigNumber = this.getQuotaConfigNumber();
      result = result * 59 + ($quotaConfigNumber == null ? 43 : $quotaConfigNumber.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $defineType = this.getDefineType();
      result = result * 59 + ($defineType == null ? 43 : $defineType.hashCode());
      Object $approvalTime = this.getApprovalTime();
      return result * 59 + ($approvalTime == null ? 43 : $approvalTime.hashCode());
   }

   public static class MesReportWorkApprovedBuilder {
      private Long id;
      private Integer productTypeEnum;
      private Long produceTeamReportId;
      private LocalDateTime reportTime;
      private Long workshopId;
      private Long projectId;
      private Long monomerId;
      private Long processId;
      private Long teamId;
      private Long productId;
      private String productSerialNumber;
      private String unit;
      private BigDecimal accountingQuantity;
      private Long quotaConfigId;
      private String quotaConfigNumber;
      private BigDecimal price;
      private BigDecimal totalPrice;
      private BigDecimal totalWeight;
      private String defineType;
      private LocalDateTime approvalTime;
      private Long approvalUserId;

      MesReportWorkApprovedBuilder() {
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder productTypeEnum(final Integer productTypeEnum) {
         this.productTypeEnum = productTypeEnum;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder produceTeamReportId(final Long produceTeamReportId) {
         this.produceTeamReportId = produceTeamReportId;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder reportTime(final LocalDateTime reportTime) {
         this.reportTime = reportTime;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder accountingQuantity(final BigDecimal accountingQuantity) {
         this.accountingQuantity = accountingQuantity;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder quotaConfigId(final Long quotaConfigId) {
         this.quotaConfigId = quotaConfigId;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder quotaConfigNumber(final String quotaConfigNumber) {
         this.quotaConfigNumber = quotaConfigNumber;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder defineType(final String defineType) {
         this.defineType = defineType;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder approvalTime(final LocalDateTime approvalTime) {
         this.approvalTime = approvalTime;
         return this;
      }

      public MesReportWorkApproved.MesReportWorkApprovedBuilder approvalUserId(final Long approvalUserId) {
         this.approvalUserId = approvalUserId;
         return this;
      }

      public MesReportWorkApproved build() {
         return new MesReportWorkApproved(
            this.id,
            this.productTypeEnum,
            this.produceTeamReportId,
            this.reportTime,
            this.workshopId,
            this.projectId,
            this.monomerId,
            this.processId,
            this.teamId,
            this.productId,
            this.productSerialNumber,
            this.unit,
            this.accountingQuantity,
            this.quotaConfigId,
            this.quotaConfigNumber,
            this.price,
            this.totalPrice,
            this.totalWeight,
            this.defineType,
            this.approvalTime,
            this.approvalUserId
         );
      }

      @Override
      public String toString() {
         return "MesReportWorkApproved.MesReportWorkApprovedBuilder(id="
            + this.id
            + ", productTypeEnum="
            + this.productTypeEnum
            + ", produceTeamReportId="
            + this.produceTeamReportId
            + ", reportTime="
            + this.reportTime
            + ", workshopId="
            + this.workshopId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", processId="
            + this.processId
            + ", teamId="
            + this.teamId
            + ", productId="
            + this.productId
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", unit="
            + this.unit
            + ", accountingQuantity="
            + this.accountingQuantity
            + ", quotaConfigId="
            + this.quotaConfigId
            + ", quotaConfigNumber="
            + this.quotaConfigNumber
            + ", price="
            + this.price
            + ", totalPrice="
            + this.totalPrice
            + ", totalWeight="
            + this.totalWeight
            + ", defineType="
            + this.defineType
            + ", approvalTime="
            + this.approvalTime
            + ", approvalUserId="
            + this.approvalUserId
            + ")";
      }
   }
}
