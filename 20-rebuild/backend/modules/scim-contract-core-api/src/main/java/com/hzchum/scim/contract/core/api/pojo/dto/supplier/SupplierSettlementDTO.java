package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;

@ApiModel("SupplierSettlement对象DTO")
public class SupplierSettlementDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty("订单id")
   @Column
   private Long orderId;
   @ApiModelProperty("订单编号")
   private String orderSerialNumber;
   @ApiModelProperty("购方单位id(签订主体id)")
   private Long branchCompanyId;
   @ApiModelProperty("购方单位(签订主体名称)")
   private String branchCompanyName;
   @ApiModelProperty("销售单位(供应商id)")
   private Long supplierId;
   @ApiModelProperty("销售单位(供应商名称)")
   private String supplierName;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("订单类别 1原材料订单 2制成品订单 4分包订单")
   private Integer orderClass;
   @ApiModelProperty("结算金额")
   private BigDecimal amount;
   @ApiModelProperty("是否预结算")
   private Boolean boolPreSettlement;
   @ApiModelProperty("是否扣除违约金 true 扣除 false 不扣除")
   private Boolean boolDeduct;
   @ApiModelProperty("申请人id")
   @Column
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   @Column
   private String applyUserName;
   @ApiModelProperty("附件id字符串")
   @Column
   private String attachmentIds;
   @ApiModelProperty("附件对象列表")
   private List<AttachmentDTO> attachments;
   @ApiModelProperty("备注")
   @Column
   private String remark;
   @ApiModelProperty("审核人id")
   @Column
   private Long auditUserId;
   @ApiModelProperty("审核人名字")
   @Column
   private String auditUserName;
   @ApiModelProperty("审核时间")
   @Column
   private LocalDateTime auditTime;
   @ApiModelProperty("审核状态 1未审核(审核中、待审核) 2审核通过 4驳回")
   @Column
   private Integer auditStatus;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;

   public static SupplierSettlementDTO.SupplierSettlementDTOBuilder builder() {
      return new SupplierSettlementDTO.SupplierSettlementDTOBuilder();
   }

   public SupplierSettlementDTO() {
   }

   public SupplierSettlementDTO(
      final Long id,
      final Long orderId,
      final String orderSerialNumber,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long supplierId,
      final String supplierName,
      final String projectName,
      final Integer orderClass,
      final BigDecimal amount,
      final Boolean boolPreSettlement,
      final Boolean boolDeduct,
      final Long applyUserId,
      final String applyUserName,
      final String attachmentIds,
      final List<AttachmentDTO> attachments,
      final String remark,
      final Long auditUserId,
      final String auditUserName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.orderId = orderId;
      this.orderSerialNumber = orderSerialNumber;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.projectName = projectName;
      this.orderClass = orderClass;
      this.amount = amount;
      this.boolPreSettlement = boolPreSettlement;
      this.boolDeduct = boolDeduct;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.attachmentIds = attachmentIds;
      this.attachments = attachments;
      this.remark = remark;
      this.auditUserId = auditUserId;
      this.auditUserName = auditUserName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.createTime = createTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public String getOrderSerialNumber() {
      return this.orderSerialNumber;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Integer getOrderClass() {
      return this.orderClass;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Boolean getBoolPreSettlement() {
      return this.boolPreSettlement;
   }

   public Boolean getBoolDeduct() {
      return this.boolDeduct;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setOrderSerialNumber(final String orderSerialNumber) {
      this.orderSerialNumber = orderSerialNumber;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setOrderClass(final Integer orderClass) {
      this.orderClass = orderClass;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setBoolPreSettlement(final Boolean boolPreSettlement) {
      this.boolPreSettlement = boolPreSettlement;
   }

   public void setBoolDeduct(final Boolean boolDeduct) {
      this.boolDeduct = boolDeduct;
   }

   public void setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
   }

   public void setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierSettlementDTO)) {
         return false;
      }

      SupplierSettlementDTO other = (SupplierSettlementDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$orderId = this.getOrderId();
         Object other$orderId = other.getOrderId();
         if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
            Object this$branchCompanyId = this.getBranchCompanyId();
            Object other$branchCompanyId = other.getBranchCompanyId();
            if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                  Object this$orderClass = this.getOrderClass();
                  Object other$orderClass = other.getOrderClass();
                  if (this$orderClass == null ? other$orderClass == null : this$orderClass.equals(other$orderClass)) {
                     Object this$boolPreSettlement = this.getBoolPreSettlement();
                     Object other$boolPreSettlement = other.getBoolPreSettlement();
                     if (this$boolPreSettlement == null ? other$boolPreSettlement == null : this$boolPreSettlement.equals(other$boolPreSettlement)) {
                        Object this$boolDeduct = this.getBoolDeduct();
                        Object other$boolDeduct = other.getBoolDeduct();
                        if (this$boolDeduct == null ? other$boolDeduct == null : this$boolDeduct.equals(other$boolDeduct)) {
                           Object this$applyUserId = this.getApplyUserId();
                           Object other$applyUserId = other.getApplyUserId();
                           if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                              Object this$auditUserId = this.getAuditUserId();
                              Object other$auditUserId = other.getAuditUserId();
                              if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                                 Object this$auditStatus = this.getAuditStatus();
                                 Object other$auditStatus = other.getAuditStatus();
                                 if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                    Object this$orderSerialNumber = this.getOrderSerialNumber();
                                    Object other$orderSerialNumber = other.getOrderSerialNumber();
                                    if (this$orderSerialNumber == null
                                       ? other$orderSerialNumber == null
                                       : this$orderSerialNumber.equals(other$orderSerialNumber)) {
                                       Object this$branchCompanyName = this.getBranchCompanyName();
                                       Object other$branchCompanyName = other.getBranchCompanyName();
                                       if (this$branchCompanyName == null
                                          ? other$branchCompanyName == null
                                          : this$branchCompanyName.equals(other$branchCompanyName)) {
                                          Object this$supplierName = this.getSupplierName();
                                          Object other$supplierName = other.getSupplierName();
                                          if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                             Object this$projectName = this.getProjectName();
                                             Object other$projectName = other.getProjectName();
                                             if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                Object this$amount = this.getAmount();
                                                Object other$amount = other.getAmount();
                                                if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                   Object this$applyUserName = this.getApplyUserName();
                                                   Object other$applyUserName = other.getApplyUserName();
                                                   if (this$applyUserName == null
                                                      ? other$applyUserName == null
                                                      : this$applyUserName.equals(other$applyUserName)) {
                                                      Object this$attachmentIds = this.getAttachmentIds();
                                                      Object other$attachmentIds = other.getAttachmentIds();
                                                      if (this$attachmentIds == null
                                                         ? other$attachmentIds == null
                                                         : this$attachmentIds.equals(other$attachmentIds)) {
                                                         Object this$attachments = this.getAttachments();
                                                         Object other$attachments = other.getAttachments();
                                                         if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                               Object this$auditUserName = this.getAuditUserName();
                                                               Object other$auditUserName = other.getAuditUserName();
                                                               if (this$auditUserName == null
                                                                  ? other$auditUserName == null
                                                                  : this$auditUserName.equals(other$auditUserName)) {
                                                                  Object this$auditTime = this.getAuditTime();
                                                                  Object other$auditTime = other.getAuditTime();
                                                                  if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)
                                                                     )
                                                                   {
                                                                     Object this$createTime = this.getCreateTime();
                                                                     Object other$createTime = other.getCreateTime();
                                                                     return this$createTime == null
                                                                        ? other$createTime == null
                                                                        : this$createTime.equals(other$createTime);
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

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierSettlementDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $orderClass = this.getOrderClass();
      result = result * 59 + ($orderClass == null ? 43 : $orderClass.hashCode());
      Object $boolPreSettlement = this.getBoolPreSettlement();
      result = result * 59 + ($boolPreSettlement == null ? 43 : $boolPreSettlement.hashCode());
      Object $boolDeduct = this.getBoolDeduct();
      result = result * 59 + ($boolDeduct == null ? 43 : $boolDeduct.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $orderSerialNumber = this.getOrderSerialNumber();
      result = result * 59 + ($orderSerialNumber == null ? 43 : $orderSerialNumber.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierSettlementDTO(id="
         + this.getId()
         + ", orderId="
         + this.getOrderId()
         + ", orderSerialNumber="
         + this.getOrderSerialNumber()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectName="
         + this.getProjectName()
         + ", orderClass="
         + this.getOrderClass()
         + ", amount="
         + this.getAmount()
         + ", boolPreSettlement="
         + this.getBoolPreSettlement()
         + ", boolDeduct="
         + this.getBoolDeduct()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachments="
         + this.getAttachments()
         + ", remark="
         + this.getRemark()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class SupplierSettlementDTOBuilder {
      private Long id;
      private Long orderId;
      private String orderSerialNumber;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long supplierId;
      private String supplierName;
      private String projectName;
      private Integer orderClass;
      private BigDecimal amount;
      private Boolean boolPreSettlement;
      private Boolean boolDeduct;
      private Long applyUserId;
      private String applyUserName;
      private String attachmentIds;
      private List<AttachmentDTO> attachments;
      private String remark;
      private Long auditUserId;
      private String auditUserName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private LocalDateTime createTime;

      SupplierSettlementDTOBuilder() {
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder orderSerialNumber(final String orderSerialNumber) {
         this.orderSerialNumber = orderSerialNumber;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder orderClass(final Integer orderClass) {
         this.orderClass = orderClass;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder boolPreSettlement(final Boolean boolPreSettlement) {
         this.boolPreSettlement = boolPreSettlement;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder boolDeduct(final Boolean boolDeduct) {
         this.boolDeduct = boolDeduct;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public SupplierSettlementDTO.SupplierSettlementDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SupplierSettlementDTO build() {
         return new SupplierSettlementDTO(
            this.id,
            this.orderId,
            this.orderSerialNumber,
            this.branchCompanyId,
            this.branchCompanyName,
            this.supplierId,
            this.supplierName,
            this.projectName,
            this.orderClass,
            this.amount,
            this.boolPreSettlement,
            this.boolDeduct,
            this.applyUserId,
            this.applyUserName,
            this.attachmentIds,
            this.attachments,
            this.remark,
            this.auditUserId,
            this.auditUserName,
            this.auditTime,
            this.auditStatus,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "SupplierSettlementDTO.SupplierSettlementDTOBuilder(id="
            + this.id
            + ", orderId="
            + this.orderId
            + ", orderSerialNumber="
            + this.orderSerialNumber
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", projectName="
            + this.projectName
            + ", orderClass="
            + this.orderClass
            + ", amount="
            + this.amount
            + ", boolPreSettlement="
            + this.boolPreSettlement
            + ", boolDeduct="
            + this.boolDeduct
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachments="
            + this.attachments
            + ", remark="
            + this.remark
            + ", auditUserId="
            + this.auditUserId
            + ", auditUserName="
            + this.auditUserName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
