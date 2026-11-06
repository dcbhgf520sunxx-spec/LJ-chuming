package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ProjectWasteProductMainDTO {
   private Long id;
   private String serialNumber;
   private LocalDateTime createTime;
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "(核算)量", notes = "(核算)量")
   private BigDecimal mete;
   private Long projectId;
   private String projectName;
   private Long useProjectId;
   private String useProjectName;
   private Integer productType;
   private String accountingUnit;
   private BigDecimal totalAmount;
   private Long createUserId;
   private String createUserName;
   private Long auditUserId;
   private String auditUserName;
   private Integer auditStatus;
   private Date auditTime;
   @ApiModelProperty(name = "wasteHandleMethod", value = "废品处理方式 1二次利用 2废品出售 ", notes = "废品处理方式 1二次利用 2废品出售")
   private Integer wasteHandleMethod;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id(出售方)", notes = "分支机构id(出售方)")
   private Long branchCompanyId;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构(出售方)", notes = "分支机构(出售方)")
   private String branchCompanyName;
   @ApiModelProperty(name = "contractWasteId", value = "废料出售合同id", notes = "废料出售合同id")
   private Long contractWasteId;
   @ApiModelProperty(name = "purchaser", value = "购买方", notes = "购买方")
   private String purchaser;
   private String remark;
   private String auditRemark;
   private Integer relationType;
   private List<ProjectWasteProductChildDTO> projectWasteProductChildVOList;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getUseProjectId() {
      return this.useProjectId;
   }

   public String getUseProjectName() {
      return this.useProjectName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
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

   public Date getAuditTime() {
      return this.auditTime;
   }

   public Integer getWasteHandleMethod() {
      return this.wasteHandleMethod;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAuditRemark() {
      return this.auditRemark;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public List<ProjectWasteProductChildDTO> getProjectWasteProductChildVOList() {
      return this.projectWasteProductChildVOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setUseProjectId(final Long useProjectId) {
      this.useProjectId = useProjectId;
   }

   public void setUseProjectName(final String useProjectName) {
      this.useProjectName = useProjectName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setAuditTime(final Date auditTime) {
      this.auditTime = auditTime;
   }

   public void setWasteHandleMethod(final Integer wasteHandleMethod) {
      this.wasteHandleMethod = wasteHandleMethod;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAuditRemark(final String auditRemark) {
      this.auditRemark = auditRemark;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setProjectWasteProductChildVOList(final List<ProjectWasteProductChildDTO> projectWasteProductChildVOList) {
      this.projectWasteProductChildVOList = projectWasteProductChildVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectWasteProductMainDTO)) {
         return false;
      }

      ProjectWasteProductMainDTO other = (ProjectWasteProductMainDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$useProjectId = this.getUseProjectId();
            Object other$useProjectId = other.getUseProjectId();
            if (this$useProjectId == null ? other$useProjectId == null : this$useProjectId.equals(other$useProjectId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$createUserId = this.getCreateUserId();
                  Object other$createUserId = other.getCreateUserId();
                  if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                     Object this$auditUserId = this.getAuditUserId();
                     Object other$auditUserId = other.getAuditUserId();
                     if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
                        Object this$auditStatus = this.getAuditStatus();
                        Object other$auditStatus = other.getAuditStatus();
                        if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                           Object this$wasteHandleMethod = this.getWasteHandleMethod();
                           Object other$wasteHandleMethod = other.getWasteHandleMethod();
                           if (this$wasteHandleMethod == null ? other$wasteHandleMethod == null : this$wasteHandleMethod.equals(other$wasteHandleMethod)) {
                              Object this$branchCompanyId = this.getBranchCompanyId();
                              Object other$branchCompanyId = other.getBranchCompanyId();
                              if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                                 Object this$contractWasteId = this.getContractWasteId();
                                 Object other$contractWasteId = other.getContractWasteId();
                                 if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
                                    Object this$relationType = this.getRelationType();
                                    Object other$relationType = other.getRelationType();
                                    if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$createTime = this.getCreateTime();
                                          Object other$createTime = other.getCreateTime();
                                          if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                             Object this$quantity = this.getQuantity();
                                             Object other$quantity = other.getQuantity();
                                             if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                Object this$mete = this.getMete();
                                                Object other$mete = other.getMete();
                                                if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                   Object this$projectName = this.getProjectName();
                                                   Object other$projectName = other.getProjectName();
                                                   if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                      Object this$useProjectName = this.getUseProjectName();
                                                      Object other$useProjectName = other.getUseProjectName();
                                                      if (this$useProjectName == null
                                                         ? other$useProjectName == null
                                                         : this$useProjectName.equals(other$useProjectName)) {
                                                         Object this$accountingUnit = this.getAccountingUnit();
                                                         Object other$accountingUnit = other.getAccountingUnit();
                                                         if (this$accountingUnit == null
                                                            ? other$accountingUnit == null
                                                            : this$accountingUnit.equals(other$accountingUnit)) {
                                                            Object this$totalAmount = this.getTotalAmount();
                                                            Object other$totalAmount = other.getTotalAmount();
                                                            if (this$totalAmount == null
                                                               ? other$totalAmount == null
                                                               : this$totalAmount.equals(other$totalAmount)) {
                                                               Object this$createUserName = this.getCreateUserName();
                                                               Object other$createUserName = other.getCreateUserName();
                                                               if (this$createUserName == null
                                                                  ? other$createUserName == null
                                                                  : this$createUserName.equals(other$createUserName)) {
                                                                  Object this$auditUserName = this.getAuditUserName();
                                                                  Object other$auditUserName = other.getAuditUserName();
                                                                  if (this$auditUserName == null
                                                                     ? other$auditUserName == null
                                                                     : this$auditUserName.equals(other$auditUserName)) {
                                                                     Object this$auditTime = this.getAuditTime();
                                                                     Object other$auditTime = other.getAuditTime();
                                                                     if (this$auditTime == null
                                                                        ? other$auditTime == null
                                                                        : this$auditTime.equals(other$auditTime)) {
                                                                        Object this$branchCompanyName = this.getBranchCompanyName();
                                                                        Object other$branchCompanyName = other.getBranchCompanyName();
                                                                        if (this$branchCompanyName == null
                                                                           ? other$branchCompanyName == null
                                                                           : this$branchCompanyName.equals(other$branchCompanyName)) {
                                                                           Object this$purchaser = this.getPurchaser();
                                                                           Object other$purchaser = other.getPurchaser();
                                                                           if (this$purchaser == null
                                                                              ? other$purchaser == null
                                                                              : this$purchaser.equals(other$purchaser)) {
                                                                              Object this$remark = this.getRemark();
                                                                              Object other$remark = other.getRemark();
                                                                              if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)
                                                                                 )
                                                                               {
                                                                                 Object this$auditRemark = this.getAuditRemark();
                                                                                 Object other$auditRemark = other.getAuditRemark();
                                                                                 if (this$auditRemark == null
                                                                                    ? other$auditRemark == null
                                                                                    : this$auditRemark.equals(other$auditRemark)) {
                                                                                    Object this$projectWasteProductChildVOList = this.getProjectWasteProductChildVOList();
                                                                                    Object other$projectWasteProductChildVOList = other.getProjectWasteProductChildVOList();
                                                                                    return this$projectWasteProductChildVOList == null
                                                                                       ? other$projectWasteProductChildVOList == null
                                                                                       : this$projectWasteProductChildVOList.equals(
                                                                                          other$projectWasteProductChildVOList
                                                                                       );
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
      return other instanceof ProjectWasteProductMainDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $useProjectId = this.getUseProjectId();
      result = result * 59 + ($useProjectId == null ? 43 : $useProjectId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $wasteHandleMethod = this.getWasteHandleMethod();
      result = result * 59 + ($wasteHandleMethod == null ? 43 : $wasteHandleMethod.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $useProjectName = this.getUseProjectName();
      result = result * 59 + ($useProjectName == null ? 43 : $useProjectName.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $purchaser = this.getPurchaser();
      result = result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $auditRemark = this.getAuditRemark();
      result = result * 59 + ($auditRemark == null ? 43 : $auditRemark.hashCode());
      Object $projectWasteProductChildVOList = this.getProjectWasteProductChildVOList();
      return result * 59 + ($projectWasteProductChildVOList == null ? 43 : $projectWasteProductChildVOList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectWasteProductMainDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", createTime="
         + this.getCreateTime()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", useProjectId="
         + this.getUseProjectId()
         + ", useProjectName="
         + this.getUseProjectName()
         + ", productType="
         + this.getProductType()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditTime="
         + this.getAuditTime()
         + ", wasteHandleMethod="
         + this.getWasteHandleMethod()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", contractWasteId="
         + this.getContractWasteId()
         + ", purchaser="
         + this.getPurchaser()
         + ", remark="
         + this.getRemark()
         + ", auditRemark="
         + this.getAuditRemark()
         + ", relationType="
         + this.getRelationType()
         + ", projectWasteProductChildVOList="
         + this.getProjectWasteProductChildVOList()
         + ")";
   }
}
