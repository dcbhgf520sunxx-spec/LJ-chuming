package com.hzchum.scim.project.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProjectReturnProductMainDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "projectCode", value = "项目编号", notes = "项目编号")
   @JsonProperty("projectCode")
   @JSONField(name = "projectCode")
   private String projectCode;
   @ApiModelProperty(name = "productType", value = "制成品类型", notes = "制成品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "relationType", value = "关联类型", notes = "关联类型")
   @JsonProperty("relationType")
   @JSONField(name = "relationType")
   private Integer relationType;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalAmount", value = "金额", notes = "金额")
   @JsonProperty("totalAmount")
   @JSONField(name = "totalAmount")
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "mete", value = "(核算)量", notes = "(核算)量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "createUserId", value = "创建人id", notes = "创建人id")
   @JsonProperty("createUserId")
   @JSONField(name = "createUserId")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   @JsonProperty("createUserName")
   @JSONField(name = "createUserName")
   private String createUserName;
   @ApiModelProperty(name = "createTime", value = "创建时间", notes = "创建时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditUserId", value = "审核人id", notes = "审核人id")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   private Long auditUserId;
   @ApiModelProperty(name = "auditUserName", value = "审核人名称", notes = "审核人名称")
   @JsonProperty("auditUserName")
   @JSONField(name = "auditUserName")
   private String auditUserName;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   private Integer auditStatus;
   @ApiModelProperty(name = "handleMethod", value = "处理方式", notes = "处理方式")
   @JsonProperty("handleMethod")
   @JSONField(name = "handleMethod")
   private Integer handleMethod;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id(购买方)", notes = "分支机构id(购买方)")
   private Long branchCompanyId;
   @ApiModelProperty(name = "branchCompanyName", value = "分支机构(购买方)", notes = "分支机构(购买方)")
   private String branchCompanyName;
   @ApiModelProperty(name = "customerUnit", value = "客户单位(出售方)", notes = "客户单位(出售方)")
   private String customerUnit;
   @ApiModelProperty(name = "warehouse", value = "库位", notes = "库位")
   private NameInfo warehouse;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "attachmentIds", value = "附件id字符串", notes = "附件id字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachmentList", value = "附件对象列表", notes = "附件对象列表")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "auditRemark", value = "审核备注", notes = "审核备注")
   @JsonProperty("auditRemark")
   @JSONField(name = "auditRemark")
   private String auditRemark;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProjectCode() {
      return this.projectCode;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Integer getHandleMethod() {
      return this.handleMethod;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public NameInfo getWarehouse() {
      return this.warehouse;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public String getAuditRemark() {
      return this.auditRemark;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("projectId")
   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   @JsonProperty("projectName")
   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @JsonProperty("projectCode")
   public void setProjectCode(final String projectCode) {
      this.projectCode = projectCode;
   }

   @JsonProperty("productType")
   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   @JsonProperty("relationType")
   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   @JsonProperty("quantity")
   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("totalAmount")
   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   @JsonProperty("createUserId")
   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   @JsonProperty("createUserName")
   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   @JsonProperty("createTime")
   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @JsonProperty("auditTime")
   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   @JsonProperty("auditUserId")
   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   @JsonProperty("auditUserName")
   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   @JsonProperty("auditStatus")
   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @JsonProperty("handleMethod")
   public void setHandleMethod(final Integer handleMethod) {
      this.handleMethod = handleMethod;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
   }

   public void setWarehouse(final NameInfo warehouse) {
      this.warehouse = warehouse;
   }

   @JsonProperty("remark")
   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   @JsonProperty("auditRemark")
   public void setAuditRemark(final String auditRemark) {
      this.auditRemark = auditRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnProductMainDTO)) {
         return false;
      }

      ProjectReturnProductMainDTO other = (ProjectReturnProductMainDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$relationType = this.getRelationType();
               Object other$relationType = other.getRelationType();
               if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$createUserId = this.getCreateUserId();
                     Object other$createUserId = other.getCreateUserId();
                     if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                        Object this$auditUserId = this.getAuditUserId();
                        Object other$auditUserId = other.getAuditUserId();
                        if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                           Object this$auditStatus = this.getAuditStatus();
                           Object other$auditStatus = other.getAuditStatus();
                           if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                              Object this$handleMethod = this.getHandleMethod();
                              Object other$handleMethod = other.getHandleMethod();
                              if (this$handleMethod == null ? other$handleMethod == null : this$handleMethod.equals(other$handleMethod)) {
                                 Object this$branchCompanyId = this.getBranchCompanyId();
                                 Object other$branchCompanyId = other.getBranchCompanyId();
                                 if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$projectName = this.getProjectName();
                                       Object other$projectName = other.getProjectName();
                                       if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                          Object this$projectCode = this.getProjectCode();
                                          Object other$projectCode = other.getProjectCode();
                                          if (this$projectCode == null ? other$projectCode == null : this$projectCode.equals(other$projectCode)) {
                                             Object this$totalAmount = this.getTotalAmount();
                                             Object other$totalAmount = other.getTotalAmount();
                                             if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                                                Object this$mete = this.getMete();
                                                Object other$mete = other.getMete();
                                                if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                   Object this$accountingUnit = this.getAccountingUnit();
                                                   Object other$accountingUnit = other.getAccountingUnit();
                                                   if (this$accountingUnit == null
                                                      ? other$accountingUnit == null
                                                      : this$accountingUnit.equals(other$accountingUnit)) {
                                                      Object this$createUserName = this.getCreateUserName();
                                                      Object other$createUserName = other.getCreateUserName();
                                                      if (this$createUserName == null
                                                         ? other$createUserName == null
                                                         : this$createUserName.equals(other$createUserName)) {
                                                         Object this$createTime = this.getCreateTime();
                                                         Object other$createTime = other.getCreateTime();
                                                         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                            Object this$auditTime = this.getAuditTime();
                                                            Object other$auditTime = other.getAuditTime();
                                                            if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                                               Object this$auditUserName = this.getAuditUserName();
                                                               Object other$auditUserName = other.getAuditUserName();
                                                               if (this$auditUserName == null
                                                                  ? other$auditUserName == null
                                                                  : this$auditUserName.equals(other$auditUserName)) {
                                                                  Object this$branchCompanyName = this.getBranchCompanyName();
                                                                  Object other$branchCompanyName = other.getBranchCompanyName();
                                                                  if (this$branchCompanyName == null
                                                                     ? other$branchCompanyName == null
                                                                     : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                                     Object this$customerUnit = this.getCustomerUnit();
                                                                     Object other$customerUnit = other.getCustomerUnit();
                                                                     if (this$customerUnit == null
                                                                        ? other$customerUnit == null
                                                                        : this$customerUnit.equals(other$customerUnit)) {
                                                                        Object this$warehouse = this.getWarehouse();
                                                                        Object other$warehouse = other.getWarehouse();
                                                                        if (this$warehouse == null
                                                                           ? other$warehouse == null
                                                                           : this$warehouse.equals(other$warehouse)) {
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$attachmentIds = this.getAttachmentIds();
                                                                              Object other$attachmentIds = other.getAttachmentIds();
                                                                              if (this$attachmentIds == null
                                                                                 ? other$attachmentIds == null
                                                                                 : this$attachmentIds.equals(other$attachmentIds)) {
                                                                                 Object this$attachmentList = this.getAttachmentList();
                                                                                 Object other$attachmentList = other.getAttachmentList();
                                                                                 if (this$attachmentList == null
                                                                                    ? other$attachmentList == null
                                                                                    : this$attachmentList.equals(other$attachmentList)) {
                                                                                    Object this$auditRemark = this.getAuditRemark();
                                                                                    Object other$auditRemark = other.getAuditRemark();
                                                                                    return this$auditRemark == null
                                                                                       ? other$auditRemark == null
                                                                                       : this$auditRemark.equals(other$auditRemark);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectReturnProductMainDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $handleMethod = this.getHandleMethod();
      result = result * 59 + ($handleMethod == null ? 43 : $handleMethod.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $projectCode = this.getProjectCode();
      result = result * 59 + ($projectCode == null ? 43 : $projectCode.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $auditRemark = this.getAuditRemark();
      return result * 59 + ($auditRemark == null ? 43 : $auditRemark.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReturnProductMainDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", projectCode="
         + this.getProjectCode()
         + ", productType="
         + this.getProductType()
         + ", relationType="
         + this.getRelationType()
         + ", quantity="
         + this.getQuantity()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", handleMethod="
         + this.getHandleMethod()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", warehouse="
         + this.getWarehouse()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", auditRemark="
         + this.getAuditRemark()
         + ")";
   }
}
