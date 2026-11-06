package com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesProductionReportingApprovalPassed对象", description = "报工审核通过表")
@Entity
@TableName("mes_production_reporting_approval_passed")
@Table(name = "mes_production_reporting_approval_passed")
@org.hibernate.annotations.Table(appliesTo = "mes_production_reporting_approval_passed", comment = "报工审核通过表")
public class MesProductionReportingApprovalPassed extends BaseEntity<Long> {
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("车间id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20) COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty("项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty("单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty("区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) COMMENT '区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty("产品类型")
   @TableField("product_type_enum")
   @Column(name = "product_type_enum", columnDefinition = "int(11) COMMENT '产品类型'", nullable = true)
   private Integer productTypeEnum;
   @ApiModelProperty("产品分类")
   @TableField("product_classification_enum")
   @Column(name = "product_classification_enum", columnDefinition = "int(11) COMMENT '产品分类'", nullable = true)
   private Integer productClassificationEnum;
   @ApiModelProperty("产品类型id")
   @TableField("product_class_id")
   @Column(name = "product_class_id", columnDefinition = "bigint(20) COMMENT '产品类型id'", nullable = true)
   private Long productClassId;
   @ApiModelProperty("产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20) COMMENT '产品id'", nullable = true)
   private Long productId;
   @ApiModelProperty("工序id")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20) COMMENT '工序id'", nullable = true)
   private Long processId;
   @ApiModelProperty("班组id")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20) COMMENT '班组id'", nullable = true)
   private Long teamId;
   @ApiModelProperty("上报数量")
   @TableField("report_quantity")
   @Column(name = "report_quantity", columnDefinition = "decimal(32,8) COMMENT '上报数量'", nullable = true)
   private BigDecimal reportQuantity;
   @ApiModelProperty("上报日期")
   @TableField("report_date")
   @Column(name = "report_date", columnDefinition = "datetime COMMENT '上报日期'", nullable = true)
   private LocalDate reportDate;
   @ApiModelProperty("审批人id")
   @TableField("approver_id")
   @Column(name = "approver_id", columnDefinition = "bigint(20) COMMENT '审批人id'", nullable = true)
   private Long approverId;
   @ApiModelProperty("审批日期")
   @TableField("approval_date")
   @Column(name = "approval_date", columnDefinition = "datetime COMMENT '审批日期'", nullable = true)
   private LocalDate approvalDate;
   @ApiModelProperty("定额配置id")
   @TableField("quota_config_id")
   @Column(name = "quota_config_id", columnDefinition = "bigint(20) COMMENT '定额配置id'", nullable = true)
   private Long quotaConfigId;
   @ApiModelProperty("定额配置编号")
   @TableField("quota_config_serial_number")
   @Column(name = "quota_config_serial_number", columnDefinition = "varchar(255) COMMENT '定额配置编号'", nullable = true)
   private String quotaConfigSerialNumber;
   @ApiModelProperty("定额匹配条件")
   @TableField("quota_matching_condition")
   @Column(name = "quota_matching_condition", columnDefinition = "varchar(1000) COMMENT '定额匹配条件'", nullable = true)
   private String quotaMatchingCondition;
   @ApiModelProperty("计量单位")
   @TableField("measure_unit")
   @Column(name = "measure_unit", columnDefinition = "varchar(255) COMMENT '计量单位'", nullable = true)
   private String measureUnit;
   @ApiModelProperty("计量量")
   @TableField("measurement_quantity")
   @Column(name = "measurement_quantity", columnDefinition = "decimal(32,8) COMMENT '计量量'", nullable = true)
   private BigDecimal measurementQuantity;
   @ApiModelProperty("单价(元)")
   @TableField("price")
   @Column(name = "price", columnDefinition = "decimal(32,8) COMMENT '单价(元)'", nullable = true)
   private BigDecimal price;
   @ApiModelProperty("金额(元)")
   @TableField("amount")
   @Column(name = "amount", columnDefinition = "decimal(32,8) COMMENT '金额(元)'", nullable = true)
   private BigDecimal amount;
   @ApiModelProperty("围护类型字典id")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint(20) COMMENT '围护类型字典id'", nullable = true)
   private Long dictionaryId;
   @ApiModelProperty("是否自动审批(1:是, 0:否)")
   @TableField("bool_automatic_approval")
   @Column(name = "bool_automatic_approval", columnDefinition = "tinyint(1) default 0 COMMENT '是否自动审批(1:是, 0:否)'", nullable = true)
   private Boolean boolAutomaticApproval;
   @ApiModelProperty("上报人id")
   @TableField("report_person_id")
   @Column(name = "report_person_id", columnDefinition = "bigint(20) COMMENT '上报人id'", nullable = true)
   private Long reportPersonId;

   public static MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder builder() {
      return new MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder();
   }

   public MesProductionReportingApprovalPassed() {
   }

   public MesProductionReportingApprovalPassed(
      final Long id,
      final Long workshopId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer productTypeEnum,
      final Integer productClassificationEnum,
      final Long productClassId,
      final Long productId,
      final Long processId,
      final Long teamId,
      final BigDecimal reportQuantity,
      final LocalDate reportDate,
      final Long approverId,
      final LocalDate approvalDate,
      final Long quotaConfigId,
      final String quotaConfigSerialNumber,
      final String quotaMatchingCondition,
      final String measureUnit,
      final BigDecimal measurementQuantity,
      final BigDecimal price,
      final BigDecimal amount,
      final Long dictionaryId,
      final Boolean boolAutomaticApproval,
      final Long reportPersonId
   ) {
      this.id = id;
      this.workshopId = workshopId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productTypeEnum = productTypeEnum;
      this.productClassificationEnum = productClassificationEnum;
      this.productClassId = productClassId;
      this.productId = productId;
      this.processId = processId;
      this.teamId = teamId;
      this.reportQuantity = reportQuantity;
      this.reportDate = reportDate;
      this.approverId = approverId;
      this.approvalDate = approvalDate;
      this.quotaConfigId = quotaConfigId;
      this.quotaConfigSerialNumber = quotaConfigSerialNumber;
      this.quotaMatchingCondition = quotaMatchingCondition;
      this.measureUnit = measureUnit;
      this.measurementQuantity = measurementQuantity;
      this.price = price;
      this.amount = amount;
      this.dictionaryId = dictionaryId;
      this.boolAutomaticApproval = boolAutomaticApproval;
      this.reportPersonId = reportPersonId;
   }

   public Long getId() {
      return this.id;
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

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Long getProductClassId() {
      return this.productClassId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public BigDecimal getReportQuantity() {
      return this.reportQuantity;
   }

   public LocalDate getReportDate() {
      return this.reportDate;
   }

   public Long getApproverId() {
      return this.approverId;
   }

   public LocalDate getApprovalDate() {
      return this.approvalDate;
   }

   public Long getQuotaConfigId() {
      return this.quotaConfigId;
   }

   public String getQuotaConfigSerialNumber() {
      return this.quotaConfigSerialNumber;
   }

   public String getQuotaMatchingCondition() {
      return this.quotaMatchingCondition;
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

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Boolean getBoolAutomaticApproval() {
      return this.boolAutomaticApproval;
   }

   public Long getReportPersonId() {
      return this.reportPersonId;
   }

   public MesProductionReportingApprovalPassed setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesProductionReportingApprovalPassed setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesProductionReportingApprovalPassed setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesProductionReportingApprovalPassed setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesProductionReportingApprovalPassed setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesProductionReportingApprovalPassed setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
      return this;
   }

   public MesProductionReportingApprovalPassed setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   public MesProductionReportingApprovalPassed setProductClassId(final Long productClassId) {
      this.productClassId = productClassId;
      return this;
   }

   public MesProductionReportingApprovalPassed setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesProductionReportingApprovalPassed setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesProductionReportingApprovalPassed setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesProductionReportingApprovalPassed setReportQuantity(final BigDecimal reportQuantity) {
      this.reportQuantity = reportQuantity;
      return this;
   }

   public MesProductionReportingApprovalPassed setReportDate(final LocalDate reportDate) {
      this.reportDate = reportDate;
      return this;
   }

   public MesProductionReportingApprovalPassed setApproverId(final Long approverId) {
      this.approverId = approverId;
      return this;
   }

   public MesProductionReportingApprovalPassed setApprovalDate(final LocalDate approvalDate) {
      this.approvalDate = approvalDate;
      return this;
   }

   public MesProductionReportingApprovalPassed setQuotaConfigId(final Long quotaConfigId) {
      this.quotaConfigId = quotaConfigId;
      return this;
   }

   public MesProductionReportingApprovalPassed setQuotaConfigSerialNumber(final String quotaConfigSerialNumber) {
      this.quotaConfigSerialNumber = quotaConfigSerialNumber;
      return this;
   }

   public MesProductionReportingApprovalPassed setQuotaMatchingCondition(final String quotaMatchingCondition) {
      this.quotaMatchingCondition = quotaMatchingCondition;
      return this;
   }

   public MesProductionReportingApprovalPassed setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   public MesProductionReportingApprovalPassed setMeasurementQuantity(final BigDecimal measurementQuantity) {
      this.measurementQuantity = measurementQuantity;
      return this;
   }

   public MesProductionReportingApprovalPassed setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   public MesProductionReportingApprovalPassed setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public MesProductionReportingApprovalPassed setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   public MesProductionReportingApprovalPassed setBoolAutomaticApproval(final Boolean boolAutomaticApproval) {
      this.boolAutomaticApproval = boolAutomaticApproval;
      return this;
   }

   public MesProductionReportingApprovalPassed setReportPersonId(final Long reportPersonId) {
      this.reportPersonId = reportPersonId;
      return this;
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalPassed(id="
         + this.getId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", productClassId="
         + this.getProductClassId()
         + ", productId="
         + this.getProductId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportDate="
         + this.getReportDate()
         + ", approverId="
         + this.getApproverId()
         + ", approvalDate="
         + this.getApprovalDate()
         + ", quotaConfigId="
         + this.getQuotaConfigId()
         + ", quotaConfigSerialNumber="
         + this.getQuotaConfigSerialNumber()
         + ", quotaMatchingCondition="
         + this.getQuotaMatchingCondition()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurementQuantity="
         + this.getMeasurementQuantity()
         + ", price="
         + this.getPrice()
         + ", amount="
         + this.getAmount()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", boolAutomaticApproval="
         + this.getBoolAutomaticApproval()
         + ", reportPersonId="
         + this.getReportPersonId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalPassed)) {
         return false;
      }

      MesProductionReportingApprovalPassed other = (MesProductionReportingApprovalPassed)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$productTypeEnum = this.getProductTypeEnum();
                     Object other$productTypeEnum = other.getProductTypeEnum();
                     if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
                        Object this$productClassificationEnum = this.getProductClassificationEnum();
                        Object other$productClassificationEnum = other.getProductClassificationEnum();
                        if (this$productClassificationEnum == null
                           ? other$productClassificationEnum == null
                           : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                           Object this$productClassId = this.getProductClassId();
                           Object other$productClassId = other.getProductClassId();
                           if (this$productClassId == null ? other$productClassId == null : this$productClassId.equals(other$productClassId)) {
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                 Object this$processId = this.getProcessId();
                                 Object other$processId = other.getProcessId();
                                 if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                    Object this$teamId = this.getTeamId();
                                    Object other$teamId = other.getTeamId();
                                    if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                       Object this$approverId = this.getApproverId();
                                       Object other$approverId = other.getApproverId();
                                       if (this$approverId == null ? other$approverId == null : this$approverId.equals(other$approverId)) {
                                          Object this$quotaConfigId = this.getQuotaConfigId();
                                          Object other$quotaConfigId = other.getQuotaConfigId();
                                          if (this$quotaConfigId == null ? other$quotaConfigId == null : this$quotaConfigId.equals(other$quotaConfigId)) {
                                             Object this$dictionaryId = this.getDictionaryId();
                                             Object other$dictionaryId = other.getDictionaryId();
                                             if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                                                Object this$boolAutomaticApproval = this.getBoolAutomaticApproval();
                                                Object other$boolAutomaticApproval = other.getBoolAutomaticApproval();
                                                if (this$boolAutomaticApproval == null
                                                   ? other$boolAutomaticApproval == null
                                                   : this$boolAutomaticApproval.equals(other$boolAutomaticApproval)) {
                                                   Object this$reportPersonId = this.getReportPersonId();
                                                   Object other$reportPersonId = other.getReportPersonId();
                                                   if (this$reportPersonId == null
                                                      ? other$reportPersonId == null
                                                      : this$reportPersonId.equals(other$reportPersonId)) {
                                                      Object this$reportQuantity = this.getReportQuantity();
                                                      Object other$reportQuantity = other.getReportQuantity();
                                                      if (this$reportQuantity == null
                                                         ? other$reportQuantity == null
                                                         : this$reportQuantity.equals(other$reportQuantity)) {
                                                         Object this$reportDate = this.getReportDate();
                                                         Object other$reportDate = other.getReportDate();
                                                         if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                                                            Object this$approvalDate = this.getApprovalDate();
                                                            Object other$approvalDate = other.getApprovalDate();
                                                            if (this$approvalDate == null
                                                               ? other$approvalDate == null
                                                               : this$approvalDate.equals(other$approvalDate)) {
                                                               Object this$quotaConfigSerialNumber = this.getQuotaConfigSerialNumber();
                                                               Object other$quotaConfigSerialNumber = other.getQuotaConfigSerialNumber();
                                                               if (this$quotaConfigSerialNumber == null
                                                                  ? other$quotaConfigSerialNumber == null
                                                                  : this$quotaConfigSerialNumber.equals(other$quotaConfigSerialNumber)) {
                                                                  Object this$quotaMatchingCondition = this.getQuotaMatchingCondition();
                                                                  Object other$quotaMatchingCondition = other.getQuotaMatchingCondition();
                                                                  if (this$quotaMatchingCondition == null
                                                                     ? other$quotaMatchingCondition == null
                                                                     : this$quotaMatchingCondition.equals(other$quotaMatchingCondition)) {
                                                                     Object this$measureUnit = this.getMeasureUnit();
                                                                     Object other$measureUnit = other.getMeasureUnit();
                                                                     if (this$measureUnit == null
                                                                        ? other$measureUnit == null
                                                                        : this$measureUnit.equals(other$measureUnit)) {
                                                                        Object this$measurementQuantity = this.getMeasurementQuantity();
                                                                        Object other$measurementQuantity = other.getMeasurementQuantity();
                                                                        if (this$measurementQuantity == null
                                                                           ? other$measurementQuantity == null
                                                                           : this$measurementQuantity.equals(other$measurementQuantity)) {
                                                                           Object this$price = this.getPrice();
                                                                           Object other$price = other.getPrice();
                                                                           if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                                              Object this$amount = this.getAmount();
                                                                              Object other$amount = other.getAmount();
                                                                              return this$amount == null
                                                                                 ? other$amount == null
                                                                                 : this$amount.equals(other$amount);
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
      return other instanceof MesProductionReportingApprovalPassed;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $productClassId = this.getProductClassId();
      result = result * 59 + ($productClassId == null ? 43 : $productClassId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $approverId = this.getApproverId();
      result = result * 59 + ($approverId == null ? 43 : $approverId.hashCode());
      Object $quotaConfigId = this.getQuotaConfigId();
      result = result * 59 + ($quotaConfigId == null ? 43 : $quotaConfigId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $boolAutomaticApproval = this.getBoolAutomaticApproval();
      result = result * 59 + ($boolAutomaticApproval == null ? 43 : $boolAutomaticApproval.hashCode());
      Object $reportPersonId = this.getReportPersonId();
      result = result * 59 + ($reportPersonId == null ? 43 : $reportPersonId.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $approvalDate = this.getApprovalDate();
      result = result * 59 + ($approvalDate == null ? 43 : $approvalDate.hashCode());
      Object $quotaConfigSerialNumber = this.getQuotaConfigSerialNumber();
      result = result * 59 + ($quotaConfigSerialNumber == null ? 43 : $quotaConfigSerialNumber.hashCode());
      Object $quotaMatchingCondition = this.getQuotaMatchingCondition();
      result = result * 59 + ($quotaMatchingCondition == null ? 43 : $quotaMatchingCondition.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $measurementQuantity = this.getMeasurementQuantity();
      result = result * 59 + ($measurementQuantity == null ? 43 : $measurementQuantity.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   public static class MesProductionReportingApprovalPassedBuilder {
      private Long id;
      private Long workshopId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer productTypeEnum;
      private Integer productClassificationEnum;
      private Long productClassId;
      private Long productId;
      private Long processId;
      private Long teamId;
      private BigDecimal reportQuantity;
      private LocalDate reportDate;
      private Long approverId;
      private LocalDate approvalDate;
      private Long quotaConfigId;
      private String quotaConfigSerialNumber;
      private String quotaMatchingCondition;
      private String measureUnit;
      private BigDecimal measurementQuantity;
      private BigDecimal price;
      private BigDecimal amount;
      private Long dictionaryId;
      private Boolean boolAutomaticApproval;
      private Long reportPersonId;

      MesProductionReportingApprovalPassedBuilder() {
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder productTypeEnum(final Integer productTypeEnum) {
         this.productTypeEnum = productTypeEnum;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder productClassId(final Long productClassId) {
         this.productClassId = productClassId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder reportQuantity(final BigDecimal reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder reportDate(final LocalDate reportDate) {
         this.reportDate = reportDate;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder approverId(final Long approverId) {
         this.approverId = approverId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder approvalDate(final LocalDate approvalDate) {
         this.approvalDate = approvalDate;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder quotaConfigId(final Long quotaConfigId) {
         this.quotaConfigId = quotaConfigId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder quotaConfigSerialNumber(final String quotaConfigSerialNumber) {
         this.quotaConfigSerialNumber = quotaConfigSerialNumber;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder quotaMatchingCondition(final String quotaMatchingCondition) {
         this.quotaMatchingCondition = quotaMatchingCondition;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder measurementQuantity(final BigDecimal measurementQuantity) {
         this.measurementQuantity = measurementQuantity;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder boolAutomaticApproval(final Boolean boolAutomaticApproval) {
         this.boolAutomaticApproval = boolAutomaticApproval;
         return this;
      }

      public MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder reportPersonId(final Long reportPersonId) {
         this.reportPersonId = reportPersonId;
         return this;
      }

      public MesProductionReportingApprovalPassed build() {
         return new MesProductionReportingApprovalPassed(
            this.id,
            this.workshopId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.productTypeEnum,
            this.productClassificationEnum,
            this.productClassId,
            this.productId,
            this.processId,
            this.teamId,
            this.reportQuantity,
            this.reportDate,
            this.approverId,
            this.approvalDate,
            this.quotaConfigId,
            this.quotaConfigSerialNumber,
            this.quotaMatchingCondition,
            this.measureUnit,
            this.measurementQuantity,
            this.price,
            this.amount,
            this.dictionaryId,
            this.boolAutomaticApproval,
            this.reportPersonId
         );
      }

      @Override
      public String toString() {
         return "MesProductionReportingApprovalPassed.MesProductionReportingApprovalPassedBuilder(id="
            + this.id
            + ", workshopId="
            + this.workshopId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productTypeEnum="
            + this.productTypeEnum
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", productClassId="
            + this.productClassId
            + ", productId="
            + this.productId
            + ", processId="
            + this.processId
            + ", teamId="
            + this.teamId
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportDate="
            + this.reportDate
            + ", approverId="
            + this.approverId
            + ", approvalDate="
            + this.approvalDate
            + ", quotaConfigId="
            + this.quotaConfigId
            + ", quotaConfigSerialNumber="
            + this.quotaConfigSerialNumber
            + ", quotaMatchingCondition="
            + this.quotaMatchingCondition
            + ", measureUnit="
            + this.measureUnit
            + ", measurementQuantity="
            + this.measurementQuantity
            + ", price="
            + this.price
            + ", amount="
            + this.amount
            + ", dictionaryId="
            + this.dictionaryId
            + ", boolAutomaticApproval="
            + this.boolAutomaticApproval
            + ", reportPersonId="
            + this.reportPersonId
            + ")";
      }
   }
}
