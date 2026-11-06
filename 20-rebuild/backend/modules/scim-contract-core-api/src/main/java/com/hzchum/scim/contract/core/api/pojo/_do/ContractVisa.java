package com.hzchum.scim.contract.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@ApiModel(description = "签证 ")
@Entity
@TableName("contract_visa")
@Table(name = "contract_visa")
public class ContractVisa extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("签证类型 1签证 2结算")
   @Column
   private Integer type;
   @ApiModelProperty("签证模式 1对内 2对外")
   @Column
   private Integer mode;
   @ApiModelProperty("项目id")
   @Column
   private Long projectId;
   @ApiModelProperty(notes = "业务类型 1.加工承揽  2.项目承包")
   @Column
   private Integer businessType;
   @ApiModelProperty("编号")
   @Column
   private String serialNumber;
   @ApiModelProperty("签证日期")
   @Column
   private LocalDate visaDate;
   @ApiModelProperty("签证人(申请人)id")
   @Column
   private Long userId;
   @ApiModelProperty("签证人(申请人)名称")
   @Column
   private String userName;
   @ApiModelProperty("签证原因id")
   @Column
   private String reasonId;
   @ApiModelProperty("签证原因名称")
   @Column
   private String reasonName;
   @ApiModelProperty("签证额")
   @Column
   private BigDecimal visaAmount;
   @ApiModelProperty("违约额")
   @Column
   private BigDecimal breachAmount;
   @ApiModelProperty("结算日期")
   @Column
   private LocalDate settlementDate;
   @ApiModelProperty("加工结算额")
   @Column
   private BigDecimal processingSettlementAmount;
   @ApiModelProperty("最终结算额")
   @Column
   private BigDecimal settlementAmount;
   @ApiModelProperty("创建人id")
   @Column
   private Long createUserId;
   @ApiModelProperty("创建人名称")
   @Column
   private String createUserName;
   @ApiModelProperty("审核人id")
   @Column
   private Long checkUserId;
   @ApiModelProperty("审核人名称")
   @Column
   private String checkUserName;
   @ApiModelProperty("审核状态 1未审核 2通过 4驳回")
   @Column(name = "status", columnDefinition = "int(11) default 1 comment '状态 1审核中 2通过 4驳回'", nullable = false)
   private Integer status;
   @ApiModelProperty("监理单位")
   @Column
   private String supervisionUnit;
   @ApiModelProperty("设计单位")
   @Column
   private String designUnit;
   @ApiModelProperty("政府监管")
   @Column
   private String governmentRegulation;
   @ApiModelProperty("备注")
   @Column
   private String remark;
   @ApiModelProperty("附件")
   @Column
   private String attachmentIds;
   @ApiModelProperty("附件备注")
   @Column
   private String attachmentRemark;
   @ApiModelProperty(name = "approveRecordIds", value = "审批日志ID集合")
   @JsonProperty("approveRecordIds")
   @JSONField(name = "approveRecordIds")
   @TableField("approve_record_ids")
   @Column(name = "approve_record_ids", columnDefinition = "varchar(255) COMMENT '审批日志ID集合'", nullable = true)
   private String approveRecordIds;
   @ApiModelProperty(name = "approveRecordIdNow", value = "当前审批日志ID")
   @JsonProperty("approveRecordIdNow")
   @JSONField(name = "approveRecordIdNow")
   @TableField("approve_record_id_now")
   @Column(name = "approve_record_id_now", columnDefinition = "bigint COMMENT '当前审批日志ID'", nullable = true)
   private Long approveRecordIdNow;
   @ApiModelProperty("签证对象名称(对内/对外)")
   @Column
   private String recipients;
   @ApiModelProperty("签证对象(对内：分包id)")
   @TableField("supplier_id")
   @Column(name = "supplier_id", columnDefinition = "bigint COMMENT '签证对象(对内)'", nullable = true)
   private Long supplierId;

   public static ContractVisa.ContractVisaBuilder builder() {
      return new ContractVisa.ContractVisaBuilder();
   }

   public ContractVisa() {
   }

   public ContractVisa(
      final Long id,
      final Integer type,
      final Integer mode,
      final Long projectId,
      final Integer businessType,
      final String serialNumber,
      final LocalDate visaDate,
      final Long userId,
      final String userName,
      final String reasonId,
      final String reasonName,
      final BigDecimal visaAmount,
      final BigDecimal breachAmount,
      final LocalDate settlementDate,
      final BigDecimal processingSettlementAmount,
      final BigDecimal settlementAmount,
      final Long createUserId,
      final String createUserName,
      final Long checkUserId,
      final String checkUserName,
      final Integer status,
      final String supervisionUnit,
      final String designUnit,
      final String governmentRegulation,
      final String remark,
      final String attachmentIds,
      final String attachmentRemark,
      final String approveRecordIds,
      final Long approveRecordIdNow,
      final String recipients,
      final Long supplierId
   ) {
      this.id = id;
      this.type = type;
      this.mode = mode;
      this.projectId = projectId;
      this.businessType = businessType;
      this.serialNumber = serialNumber;
      this.visaDate = visaDate;
      this.userId = userId;
      this.userName = userName;
      this.reasonId = reasonId;
      this.reasonName = reasonName;
      this.visaAmount = visaAmount;
      this.breachAmount = breachAmount;
      this.settlementDate = settlementDate;
      this.processingSettlementAmount = processingSettlementAmount;
      this.settlementAmount = settlementAmount;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.checkUserId = checkUserId;
      this.checkUserName = checkUserName;
      this.status = status;
      this.supervisionUnit = supervisionUnit;
      this.designUnit = designUnit;
      this.governmentRegulation = governmentRegulation;
      this.remark = remark;
      this.attachmentIds = attachmentIds;
      this.attachmentRemark = attachmentRemark;
      this.approveRecordIds = approveRecordIds;
      this.approveRecordIdNow = approveRecordIdNow;
      this.recipients = recipients;
      this.supplierId = supplierId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getMode() {
      return this.mode;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDate getVisaDate() {
      return this.visaDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getReasonId() {
      return this.reasonId;
   }

   public String getReasonName() {
      return this.reasonName;
   }

   public BigDecimal getVisaAmount() {
      return this.visaAmount;
   }

   public BigDecimal getBreachAmount() {
      return this.breachAmount;
   }

   public LocalDate getSettlementDate() {
      return this.settlementDate;
   }

   public BigDecimal getProcessingSettlementAmount() {
      return this.processingSettlementAmount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Long getCheckUserId() {
      return this.checkUserId;
   }

   public String getCheckUserName() {
      return this.checkUserName;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getSupervisionUnit() {
      return this.supervisionUnit;
   }

   public String getDesignUnit() {
      return this.designUnit;
   }

   public String getGovernmentRegulation() {
      return this.governmentRegulation;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getAttachmentRemark() {
      return this.attachmentRemark;
   }

   public String getApproveRecordIds() {
      return this.approveRecordIds;
   }

   public Long getApproveRecordIdNow() {
      return this.approveRecordIdNow;
   }

   public String getRecipients() {
      return this.recipients;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setMode(final Integer mode) {
      this.mode = mode;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setVisaDate(final LocalDate visaDate) {
      this.visaDate = visaDate;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setReasonId(final String reasonId) {
      this.reasonId = reasonId;
   }

   public void setReasonName(final String reasonName) {
      this.reasonName = reasonName;
   }

   public void setVisaAmount(final BigDecimal visaAmount) {
      this.visaAmount = visaAmount;
   }

   public void setBreachAmount(final BigDecimal breachAmount) {
      this.breachAmount = breachAmount;
   }

   public void setSettlementDate(final LocalDate settlementDate) {
      this.settlementDate = settlementDate;
   }

   public void setProcessingSettlementAmount(final BigDecimal processingSettlementAmount) {
      this.processingSettlementAmount = processingSettlementAmount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCheckUserId(final Long checkUserId) {
      this.checkUserId = checkUserId;
   }

   public void setCheckUserName(final String checkUserName) {
      this.checkUserName = checkUserName;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setSupervisionUnit(final String supervisionUnit) {
      this.supervisionUnit = supervisionUnit;
   }

   public void setDesignUnit(final String designUnit) {
      this.designUnit = designUnit;
   }

   public void setGovernmentRegulation(final String governmentRegulation) {
      this.governmentRegulation = governmentRegulation;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachmentRemark(final String attachmentRemark) {
      this.attachmentRemark = attachmentRemark;
   }

   @JsonProperty("approveRecordIds")
   public void setApproveRecordIds(final String approveRecordIds) {
      this.approveRecordIds = approveRecordIds;
   }

   @JsonProperty("approveRecordIdNow")
   public void setApproveRecordIdNow(final Long approveRecordIdNow) {
      this.approveRecordIdNow = approveRecordIdNow;
   }

   public void setRecipients(final String recipients) {
      this.recipients = recipients;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractVisa)) {
         return false;
      }

      ContractVisa other = (ContractVisa)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$mode = this.getMode();
            Object other$mode = other.getMode();
            if (this$mode == null ? other$mode == null : this$mode.equals(other$mode)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$businessType = this.getBusinessType();
                  Object other$businessType = other.getBusinessType();
                  if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$createUserId = this.getCreateUserId();
                        Object other$createUserId = other.getCreateUserId();
                        if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                           Object this$checkUserId = this.getCheckUserId();
                           Object other$checkUserId = other.getCheckUserId();
                           if (this$checkUserId == null ? other$checkUserId == null : this$checkUserId.equals(other$checkUserId)) {
                              Object this$status = this.getStatus();
                              Object other$status = other.getStatus();
                              if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                 Object this$approveRecordIdNow = this.getApproveRecordIdNow();
                                 Object other$approveRecordIdNow = other.getApproveRecordIdNow();
                                 if (this$approveRecordIdNow == null
                                    ? other$approveRecordIdNow == null
                                    : this$approveRecordIdNow.equals(other$approveRecordIdNow)) {
                                    Object this$supplierId = this.getSupplierId();
                                    Object other$supplierId = other.getSupplierId();
                                    if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$visaDate = this.getVisaDate();
                                          Object other$visaDate = other.getVisaDate();
                                          if (this$visaDate == null ? other$visaDate == null : this$visaDate.equals(other$visaDate)) {
                                             Object this$userName = this.getUserName();
                                             Object other$userName = other.getUserName();
                                             if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                Object this$reasonId = this.getReasonId();
                                                Object other$reasonId = other.getReasonId();
                                                if (this$reasonId == null ? other$reasonId == null : this$reasonId.equals(other$reasonId)) {
                                                   Object this$reasonName = this.getReasonName();
                                                   Object other$reasonName = other.getReasonName();
                                                   if (this$reasonName == null ? other$reasonName == null : this$reasonName.equals(other$reasonName)) {
                                                      Object this$visaAmount = this.getVisaAmount();
                                                      Object other$visaAmount = other.getVisaAmount();
                                                      if (this$visaAmount == null ? other$visaAmount == null : this$visaAmount.equals(other$visaAmount)) {
                                                         Object this$breachAmount = this.getBreachAmount();
                                                         Object other$breachAmount = other.getBreachAmount();
                                                         if (this$breachAmount == null
                                                            ? other$breachAmount == null
                                                            : this$breachAmount.equals(other$breachAmount)) {
                                                            Object this$settlementDate = this.getSettlementDate();
                                                            Object other$settlementDate = other.getSettlementDate();
                                                            if (this$settlementDate == null
                                                               ? other$settlementDate == null
                                                               : this$settlementDate.equals(other$settlementDate)) {
                                                               Object this$processingSettlementAmount = this.getProcessingSettlementAmount();
                                                               Object other$processingSettlementAmount = other.getProcessingSettlementAmount();
                                                               if (this$processingSettlementAmount == null
                                                                  ? other$processingSettlementAmount == null
                                                                  : this$processingSettlementAmount.equals(other$processingSettlementAmount)) {
                                                                  Object this$settlementAmount = this.getSettlementAmount();
                                                                  Object other$settlementAmount = other.getSettlementAmount();
                                                                  if (this$settlementAmount == null
                                                                     ? other$settlementAmount == null
                                                                     : this$settlementAmount.equals(other$settlementAmount)) {
                                                                     Object this$createUserName = this.getCreateUserName();
                                                                     Object other$createUserName = other.getCreateUserName();
                                                                     if (this$createUserName == null
                                                                        ? other$createUserName == null
                                                                        : this$createUserName.equals(other$createUserName)) {
                                                                        Object this$checkUserName = this.getCheckUserName();
                                                                        Object other$checkUserName = other.getCheckUserName();
                                                                        if (this$checkUserName == null
                                                                           ? other$checkUserName == null
                                                                           : this$checkUserName.equals(other$checkUserName)) {
                                                                           Object this$supervisionUnit = this.getSupervisionUnit();
                                                                           Object other$supervisionUnit = other.getSupervisionUnit();
                                                                           if (this$supervisionUnit == null
                                                                              ? other$supervisionUnit == null
                                                                              : this$supervisionUnit.equals(other$supervisionUnit)) {
                                                                              Object this$designUnit = this.getDesignUnit();
                                                                              Object other$designUnit = other.getDesignUnit();
                                                                              if (this$designUnit == null
                                                                                 ? other$designUnit == null
                                                                                 : this$designUnit.equals(other$designUnit)) {
                                                                                 Object this$governmentRegulation = this.getGovernmentRegulation();
                                                                                 Object other$governmentRegulation = other.getGovernmentRegulation();
                                                                                 if (this$governmentRegulation == null
                                                                                    ? other$governmentRegulation == null
                                                                                    : this$governmentRegulation.equals(other$governmentRegulation)) {
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    if (this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark)) {
                                                                                       Object this$attachmentIds = this.getAttachmentIds();
                                                                                       Object other$attachmentIds = other.getAttachmentIds();
                                                                                       if (this$attachmentIds == null
                                                                                          ? other$attachmentIds == null
                                                                                          : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                          Object this$attachmentRemark = this.getAttachmentRemark();
                                                                                          Object other$attachmentRemark = other.getAttachmentRemark();
                                                                                          if (this$attachmentRemark == null
                                                                                             ? other$attachmentRemark == null
                                                                                             : this$attachmentRemark.equals(other$attachmentRemark)) {
                                                                                             Object this$approveRecordIds = this.getApproveRecordIds();
                                                                                             Object other$approveRecordIds = other.getApproveRecordIds();
                                                                                             if (this$approveRecordIds == null
                                                                                                ? other$approveRecordIds == null
                                                                                                : this$approveRecordIds.equals(other$approveRecordIds)) {
                                                                                                Object this$recipients = this.getRecipients();
                                                                                                Object other$recipients = other.getRecipients();
                                                                                                return this$recipients == null
                                                                                                   ? other$recipients == null
                                                                                                   : this$recipients.equals(other$recipients);
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
      return other instanceof ContractVisa;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $mode = this.getMode();
      result = result * 59 + ($mode == null ? 43 : $mode.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $checkUserId = this.getCheckUserId();
      result = result * 59 + ($checkUserId == null ? 43 : $checkUserId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $visaDate = this.getVisaDate();
      result = result * 59 + ($visaDate == null ? 43 : $visaDate.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $reasonId = this.getReasonId();
      result = result * 59 + ($reasonId == null ? 43 : $reasonId.hashCode());
      Object $reasonName = this.getReasonName();
      result = result * 59 + ($reasonName == null ? 43 : $reasonName.hashCode());
      Object $visaAmount = this.getVisaAmount();
      result = result * 59 + ($visaAmount == null ? 43 : $visaAmount.hashCode());
      Object $breachAmount = this.getBreachAmount();
      result = result * 59 + ($breachAmount == null ? 43 : $breachAmount.hashCode());
      Object $settlementDate = this.getSettlementDate();
      result = result * 59 + ($settlementDate == null ? 43 : $settlementDate.hashCode());
      Object $processingSettlementAmount = this.getProcessingSettlementAmount();
      result = result * 59 + ($processingSettlementAmount == null ? 43 : $processingSettlementAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $supervisionUnit = this.getSupervisionUnit();
      result = result * 59 + ($supervisionUnit == null ? 43 : $supervisionUnit.hashCode());
      Object $designUnit = this.getDesignUnit();
      result = result * 59 + ($designUnit == null ? 43 : $designUnit.hashCode());
      Object $governmentRegulation = this.getGovernmentRegulation();
      result = result * 59 + ($governmentRegulation == null ? 43 : $governmentRegulation.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentRemark = this.getAttachmentRemark();
      result = result * 59 + ($attachmentRemark == null ? 43 : $attachmentRemark.hashCode());
      Object $approveRecordIds = this.getApproveRecordIds();
      result = result * 59 + ($approveRecordIds == null ? 43 : $approveRecordIds.hashCode());
      Object $recipients = this.getRecipients();
      return result * 59 + ($recipients == null ? 43 : $recipients.hashCode());
   }

   @Override
   public String toString() {
      return "ContractVisa(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", mode="
         + this.getMode()
         + ", projectId="
         + this.getProjectId()
         + ", businessType="
         + this.getBusinessType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", visaDate="
         + this.getVisaDate()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", reasonId="
         + this.getReasonId()
         + ", reasonName="
         + this.getReasonName()
         + ", visaAmount="
         + this.getVisaAmount()
         + ", breachAmount="
         + this.getBreachAmount()
         + ", settlementDate="
         + this.getSettlementDate()
         + ", processingSettlementAmount="
         + this.getProcessingSettlementAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", checkUserId="
         + this.getCheckUserId()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", status="
         + this.getStatus()
         + ", supervisionUnit="
         + this.getSupervisionUnit()
         + ", designUnit="
         + this.getDesignUnit()
         + ", governmentRegulation="
         + this.getGovernmentRegulation()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentRemark="
         + this.getAttachmentRemark()
         + ", approveRecordIds="
         + this.getApproveRecordIds()
         + ", approveRecordIdNow="
         + this.getApproveRecordIdNow()
         + ", recipients="
         + this.getRecipients()
         + ", supplierId="
         + this.getSupplierId()
         + ")";
   }

   public static class ContractVisaBuilder {
      private Long id;
      private Integer type;
      private Integer mode;
      private Long projectId;
      private Integer businessType;
      private String serialNumber;
      private LocalDate visaDate;
      private Long userId;
      private String userName;
      private String reasonId;
      private String reasonName;
      private BigDecimal visaAmount;
      private BigDecimal breachAmount;
      private LocalDate settlementDate;
      private BigDecimal processingSettlementAmount;
      private BigDecimal settlementAmount;
      private Long createUserId;
      private String createUserName;
      private Long checkUserId;
      private String checkUserName;
      private Integer status;
      private String supervisionUnit;
      private String designUnit;
      private String governmentRegulation;
      private String remark;
      private String attachmentIds;
      private String attachmentRemark;
      private String approveRecordIds;
      private Long approveRecordIdNow;
      private String recipients;
      private Long supplierId;

      ContractVisaBuilder() {
      }

      public ContractVisa.ContractVisaBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractVisa.ContractVisaBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractVisa.ContractVisaBuilder mode(final Integer mode) {
         this.mode = mode;
         return this;
      }

      public ContractVisa.ContractVisaBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractVisa.ContractVisaBuilder businessType(final Integer businessType) {
         this.businessType = businessType;
         return this;
      }

      public ContractVisa.ContractVisaBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ContractVisa.ContractVisaBuilder visaDate(final LocalDate visaDate) {
         this.visaDate = visaDate;
         return this;
      }

      public ContractVisa.ContractVisaBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractVisa.ContractVisaBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ContractVisa.ContractVisaBuilder reasonId(final String reasonId) {
         this.reasonId = reasonId;
         return this;
      }

      public ContractVisa.ContractVisaBuilder reasonName(final String reasonName) {
         this.reasonName = reasonName;
         return this;
      }

      public ContractVisa.ContractVisaBuilder visaAmount(final BigDecimal visaAmount) {
         this.visaAmount = visaAmount;
         return this;
      }

      public ContractVisa.ContractVisaBuilder breachAmount(final BigDecimal breachAmount) {
         this.breachAmount = breachAmount;
         return this;
      }

      public ContractVisa.ContractVisaBuilder settlementDate(final LocalDate settlementDate) {
         this.settlementDate = settlementDate;
         return this;
      }

      public ContractVisa.ContractVisaBuilder processingSettlementAmount(final BigDecimal processingSettlementAmount) {
         this.processingSettlementAmount = processingSettlementAmount;
         return this;
      }

      public ContractVisa.ContractVisaBuilder settlementAmount(final BigDecimal settlementAmount) {
         this.settlementAmount = settlementAmount;
         return this;
      }

      public ContractVisa.ContractVisaBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public ContractVisa.ContractVisaBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public ContractVisa.ContractVisaBuilder checkUserId(final Long checkUserId) {
         this.checkUserId = checkUserId;
         return this;
      }

      public ContractVisa.ContractVisaBuilder checkUserName(final String checkUserName) {
         this.checkUserName = checkUserName;
         return this;
      }

      public ContractVisa.ContractVisaBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ContractVisa.ContractVisaBuilder supervisionUnit(final String supervisionUnit) {
         this.supervisionUnit = supervisionUnit;
         return this;
      }

      public ContractVisa.ContractVisaBuilder designUnit(final String designUnit) {
         this.designUnit = designUnit;
         return this;
      }

      public ContractVisa.ContractVisaBuilder governmentRegulation(final String governmentRegulation) {
         this.governmentRegulation = governmentRegulation;
         return this;
      }

      public ContractVisa.ContractVisaBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractVisa.ContractVisaBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractVisa.ContractVisaBuilder attachmentRemark(final String attachmentRemark) {
         this.attachmentRemark = attachmentRemark;
         return this;
      }

      @JsonProperty("approveRecordIds")
      public ContractVisa.ContractVisaBuilder approveRecordIds(final String approveRecordIds) {
         this.approveRecordIds = approveRecordIds;
         return this;
      }

      @JsonProperty("approveRecordIdNow")
      public ContractVisa.ContractVisaBuilder approveRecordIdNow(final Long approveRecordIdNow) {
         this.approveRecordIdNow = approveRecordIdNow;
         return this;
      }

      public ContractVisa.ContractVisaBuilder recipients(final String recipients) {
         this.recipients = recipients;
         return this;
      }

      public ContractVisa.ContractVisaBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ContractVisa build() {
         return new ContractVisa(
            this.id,
            this.type,
            this.mode,
            this.projectId,
            this.businessType,
            this.serialNumber,
            this.visaDate,
            this.userId,
            this.userName,
            this.reasonId,
            this.reasonName,
            this.visaAmount,
            this.breachAmount,
            this.settlementDate,
            this.processingSettlementAmount,
            this.settlementAmount,
            this.createUserId,
            this.createUserName,
            this.checkUserId,
            this.checkUserName,
            this.status,
            this.supervisionUnit,
            this.designUnit,
            this.governmentRegulation,
            this.remark,
            this.attachmentIds,
            this.attachmentRemark,
            this.approveRecordIds,
            this.approveRecordIdNow,
            this.recipients,
            this.supplierId
         );
      }

      @Override
      public String toString() {
         return "ContractVisa.ContractVisaBuilder(id="
            + this.id
            + ", type="
            + this.type
            + ", mode="
            + this.mode
            + ", projectId="
            + this.projectId
            + ", businessType="
            + this.businessType
            + ", serialNumber="
            + this.serialNumber
            + ", visaDate="
            + this.visaDate
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", reasonId="
            + this.reasonId
            + ", reasonName="
            + this.reasonName
            + ", visaAmount="
            + this.visaAmount
            + ", breachAmount="
            + this.breachAmount
            + ", settlementDate="
            + this.settlementDate
            + ", processingSettlementAmount="
            + this.processingSettlementAmount
            + ", settlementAmount="
            + this.settlementAmount
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", checkUserId="
            + this.checkUserId
            + ", checkUserName="
            + this.checkUserName
            + ", status="
            + this.status
            + ", supervisionUnit="
            + this.supervisionUnit
            + ", designUnit="
            + this.designUnit
            + ", governmentRegulation="
            + this.governmentRegulation
            + ", remark="
            + this.remark
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentRemark="
            + this.attachmentRemark
            + ", approveRecordIds="
            + this.approveRecordIds
            + ", approveRecordIdNow="
            + this.approveRecordIdNow
            + ", recipients="
            + this.recipients
            + ", supplierId="
            + this.supplierId
            + ")";
      }
   }
}
