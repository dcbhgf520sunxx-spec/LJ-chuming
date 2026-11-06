package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class ApplyPurchaseDTOParam {
   private Long id;
   private String serialNumber;
   private String serialNumberParent;
   private Integer type;
   private Integer materialType;
   private Long projectId;
   private String projectIds;
   private String remark;
   private Long approveProcessId;
   @ApiModelProperty(name = "finishedProductType", value = "成品类型[1 构件,围护]")
   private Integer finishedProductType;
   @ApiModelProperty(name = "list", value = "申购明细集合")
   private List<ApplyPurchaseDetailDTOParam> list;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 1审批中 2审核通过  4审核退回  8撤销  16审核中 32暂存")
   private Integer reviewStatus;
   @ApiModelProperty(name = "approveId", value = "审批主模板ID")
   private Long approveId;
   @ApiModelProperty(name = "level ", value = "目的地 工地、工厂  1工地 2工厂")
   private Integer level;
   @ApiModelProperty(name = "tsData ", value = "暂存json数据 当暂存转为待审核的时候进行清空 每次暂存保存时 就进行覆盖")
   private String tsData;
   @ApiModelProperty(name = "boolTemporaryStorage ", value = "是否为暂存订单  0不是暂存 1是暂存 默认0")
   private Boolean boolTemporaryStorage;
   @ApiModelProperty(name = "boolIsProjectDetail ", value = "是否存在无项目的明细 0不存在 1存在")
   private Boolean boolIsProjectDetail;
   @ApiModelProperty(name = "parentId ", value = "父级ID  订单来源ID")
   private Long parentId;
   @ApiModelProperty(name = "cause ", value = "发起原因")
   private String cause;
   @ApiModelProperty(name = "dataStatus ", value = "订单状态")
   private Integer dataStatus;
   @ApiModelProperty(name = "projectAttribute ", value = "项目属性 ProjectAttributeEnum")
   private String projectAttribute;
   @ApiModelProperty(name = "branchCompanyId ", value = "签订主体公司ID")
   private Long branchCompanyId;
   @ApiModelProperty(name = "classifyIds ", value = "科目ID集")
   private String classifyIds;
   private LocalDateTime clickTime;
   private Integer delButtonType;
   private List<Long> attachmentIds;
   private Integer purchaseCreationState;
   private boolean boolUsed;
   private Boolean boolSysgen;

   public static ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder builder() {
      return new ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSerialNumberParent() {
      return this.serialNumberParent;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getApproveProcessId() {
      return this.approveProcessId;
   }

   public Integer getFinishedProductType() {
      return this.finishedProductType;
   }

   public List<ApplyPurchaseDetailDTOParam> getList() {
      return this.list;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getApproveId() {
      return this.approveId;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getTsData() {
      return this.tsData;
   }

   public Boolean getBoolTemporaryStorage() {
      return this.boolTemporaryStorage;
   }

   public Boolean getBoolIsProjectDetail() {
      return this.boolIsProjectDetail;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public String getCause() {
      return this.cause;
   }

   public Integer getDataStatus() {
      return this.dataStatus;
   }

   public String getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getClassifyIds() {
      return this.classifyIds;
   }

   public LocalDateTime getClickTime() {
      return this.clickTime;
   }

   public Integer getDelButtonType() {
      return this.delButtonType;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public Integer getPurchaseCreationState() {
      return this.purchaseCreationState;
   }

   public boolean isBoolUsed() {
      return this.boolUsed;
   }

   public Boolean getBoolSysgen() {
      return this.boolSysgen;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSerialNumberParent(final String serialNumberParent) {
      this.serialNumberParent = serialNumberParent;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setApproveProcessId(final Long approveProcessId) {
      this.approveProcessId = approveProcessId;
   }

   public void setFinishedProductType(final Integer finishedProductType) {
      this.finishedProductType = finishedProductType;
   }

   public void setList(final List<ApplyPurchaseDetailDTOParam> list) {
      this.list = list;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setApproveId(final Long approveId) {
      this.approveId = approveId;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setTsData(final String tsData) {
      this.tsData = tsData;
   }

   public void setBoolTemporaryStorage(final Boolean boolTemporaryStorage) {
      this.boolTemporaryStorage = boolTemporaryStorage;
   }

   public void setBoolIsProjectDetail(final Boolean boolIsProjectDetail) {
      this.boolIsProjectDetail = boolIsProjectDetail;
   }

   public void setParentId(final Long parentId) {
      this.parentId = parentId;
   }

   public void setCause(final String cause) {
      this.cause = cause;
   }

   public void setDataStatus(final Integer dataStatus) {
      this.dataStatus = dataStatus;
   }

   public void setProjectAttribute(final String projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setClassifyIds(final String classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setClickTime(final LocalDateTime clickTime) {
      this.clickTime = clickTime;
   }

   public void setDelButtonType(final Integer delButtonType) {
      this.delButtonType = delButtonType;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setPurchaseCreationState(final Integer purchaseCreationState) {
      this.purchaseCreationState = purchaseCreationState;
   }

   public void setBoolUsed(final boolean boolUsed) {
      this.boolUsed = boolUsed;
   }

   public void setBoolSysgen(final Boolean boolSysgen) {
      this.boolSysgen = boolSysgen;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApplyPurchaseDTOParam)) {
         return false;
      }

      ApplyPurchaseDTOParam other = (ApplyPurchaseDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.isBoolUsed() != other.isBoolUsed()) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$materialType = this.getMaterialType();
            Object other$materialType = other.getMaterialType();
            if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$approveProcessId = this.getApproveProcessId();
                  Object other$approveProcessId = other.getApproveProcessId();
                  if (this$approveProcessId == null ? other$approveProcessId == null : this$approveProcessId.equals(other$approveProcessId)) {
                     Object this$finishedProductType = this.getFinishedProductType();
                     Object other$finishedProductType = other.getFinishedProductType();
                     if (this$finishedProductType == null ? other$finishedProductType == null : this$finishedProductType.equals(other$finishedProductType)) {
                        Object this$reviewStatus = this.getReviewStatus();
                        Object other$reviewStatus = other.getReviewStatus();
                        if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                           Object this$approveId = this.getApproveId();
                           Object other$approveId = other.getApproveId();
                           if (this$approveId == null ? other$approveId == null : this$approveId.equals(other$approveId)) {
                              Object this$level = this.getLevel();
                              Object other$level = other.getLevel();
                              if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                 Object this$boolTemporaryStorage = this.getBoolTemporaryStorage();
                                 Object other$boolTemporaryStorage = other.getBoolTemporaryStorage();
                                 if (this$boolTemporaryStorage == null
                                    ? other$boolTemporaryStorage == null
                                    : this$boolTemporaryStorage.equals(other$boolTemporaryStorage)) {
                                    Object this$boolIsProjectDetail = this.getBoolIsProjectDetail();
                                    Object other$boolIsProjectDetail = other.getBoolIsProjectDetail();
                                    if (this$boolIsProjectDetail == null
                                       ? other$boolIsProjectDetail == null
                                       : this$boolIsProjectDetail.equals(other$boolIsProjectDetail)) {
                                       Object this$parentId = this.getParentId();
                                       Object other$parentId = other.getParentId();
                                       if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
                                          Object this$dataStatus = this.getDataStatus();
                                          Object other$dataStatus = other.getDataStatus();
                                          if (this$dataStatus == null ? other$dataStatus == null : this$dataStatus.equals(other$dataStatus)) {
                                             Object this$branchCompanyId = this.getBranchCompanyId();
                                             Object other$branchCompanyId = other.getBranchCompanyId();
                                             if (this$branchCompanyId == null
                                                ? other$branchCompanyId == null
                                                : this$branchCompanyId.equals(other$branchCompanyId)) {
                                                Object this$delButtonType = this.getDelButtonType();
                                                Object other$delButtonType = other.getDelButtonType();
                                                if (this$delButtonType == null ? other$delButtonType == null : this$delButtonType.equals(other$delButtonType)) {
                                                   Object this$purchaseCreationState = this.getPurchaseCreationState();
                                                   Object other$purchaseCreationState = other.getPurchaseCreationState();
                                                   if (this$purchaseCreationState == null
                                                      ? other$purchaseCreationState == null
                                                      : this$purchaseCreationState.equals(other$purchaseCreationState)) {
                                                      Object this$boolSysgen = this.getBoolSysgen();
                                                      Object other$boolSysgen = other.getBoolSysgen();
                                                      if (this$boolSysgen == null ? other$boolSysgen == null : this$boolSysgen.equals(other$boolSysgen)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$serialNumberParent = this.getSerialNumberParent();
                                                            Object other$serialNumberParent = other.getSerialNumberParent();
                                                            if (this$serialNumberParent == null
                                                               ? other$serialNumberParent == null
                                                               : this$serialNumberParent.equals(other$serialNumberParent)) {
                                                               Object this$projectIds = this.getProjectIds();
                                                               Object other$projectIds = other.getProjectIds();
                                                               if (this$projectIds == null
                                                                  ? other$projectIds == null
                                                                  : this$projectIds.equals(other$projectIds)) {
                                                                  Object this$remark = this.getRemark();
                                                                  Object other$remark = other.getRemark();
                                                                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                     Object this$list = this.getList();
                                                                     Object other$list = other.getList();
                                                                     if (this$list == null ? other$list == null : this$list.equals(other$list)) {
                                                                        Object this$tsData = this.getTsData();
                                                                        Object other$tsData = other.getTsData();
                                                                        if (this$tsData == null ? other$tsData == null : this$tsData.equals(other$tsData)) {
                                                                           Object this$cause = this.getCause();
                                                                           Object other$cause = other.getCause();
                                                                           if (this$cause == null ? other$cause == null : this$cause.equals(other$cause)) {
                                                                              Object this$projectAttribute = this.getProjectAttribute();
                                                                              Object other$projectAttribute = other.getProjectAttribute();
                                                                              if (this$projectAttribute == null
                                                                                 ? other$projectAttribute == null
                                                                                 : this$projectAttribute.equals(other$projectAttribute)) {
                                                                                 Object this$classifyIds = this.getClassifyIds();
                                                                                 Object other$classifyIds = other.getClassifyIds();
                                                                                 if (this$classifyIds == null
                                                                                    ? other$classifyIds == null
                                                                                    : this$classifyIds.equals(other$classifyIds)) {
                                                                                    Object this$clickTime = this.getClickTime();
                                                                                    Object other$clickTime = other.getClickTime();
                                                                                    if (this$clickTime == null
                                                                                       ? other$clickTime == null
                                                                                       : this$clickTime.equals(other$clickTime)) {
                                                                                       Object this$attachmentIds = this.getAttachmentIds();
                                                                                       Object other$attachmentIds = other.getAttachmentIds();
                                                                                       return this$attachmentIds == null
                                                                                          ? other$attachmentIds == null
                                                                                          : this$attachmentIds.equals(other$attachmentIds);
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

   protected boolean canEqual(final Object other) {
      return other instanceof ApplyPurchaseDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + (this.isBoolUsed() ? 79 : 97);
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $approveProcessId = this.getApproveProcessId();
      result = result * 59 + ($approveProcessId == null ? 43 : $approveProcessId.hashCode());
      Object $finishedProductType = this.getFinishedProductType();
      result = result * 59 + ($finishedProductType == null ? 43 : $finishedProductType.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $approveId = this.getApproveId();
      result = result * 59 + ($approveId == null ? 43 : $approveId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $boolTemporaryStorage = this.getBoolTemporaryStorage();
      result = result * 59 + ($boolTemporaryStorage == null ? 43 : $boolTemporaryStorage.hashCode());
      Object $boolIsProjectDetail = this.getBoolIsProjectDetail();
      result = result * 59 + ($boolIsProjectDetail == null ? 43 : $boolIsProjectDetail.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $delButtonType = this.getDelButtonType();
      result = result * 59 + ($delButtonType == null ? 43 : $delButtonType.hashCode());
      Object $purchaseCreationState = this.getPurchaseCreationState();
      result = result * 59 + ($purchaseCreationState == null ? 43 : $purchaseCreationState.hashCode());
      Object $boolSysgen = this.getBoolSysgen();
      result = result * 59 + ($boolSysgen == null ? 43 : $boolSysgen.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $serialNumberParent = this.getSerialNumberParent();
      result = result * 59 + ($serialNumberParent == null ? 43 : $serialNumberParent.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $tsData = this.getTsData();
      result = result * 59 + ($tsData == null ? 43 : $tsData.hashCode());
      Object $cause = this.getCause();
      result = result * 59 + ($cause == null ? 43 : $cause.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $clickTime = this.getClickTime();
      result = result * 59 + ($clickTime == null ? 43 : $clickTime.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "ApplyPurchaseDTOParam(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", serialNumberParent="
         + this.getSerialNumberParent()
         + ", type="
         + this.getType()
         + ", materialType="
         + this.getMaterialType()
         + ", projectId="
         + this.getProjectId()
         + ", projectIds="
         + this.getProjectIds()
         + ", remark="
         + this.getRemark()
         + ", approveProcessId="
         + this.getApproveProcessId()
         + ", finishedProductType="
         + this.getFinishedProductType()
         + ", list="
         + this.getList()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", approveId="
         + this.getApproveId()
         + ", level="
         + this.getLevel()
         + ", tsData="
         + this.getTsData()
         + ", boolTemporaryStorage="
         + this.getBoolTemporaryStorage()
         + ", boolIsProjectDetail="
         + this.getBoolIsProjectDetail()
         + ", parentId="
         + this.getParentId()
         + ", cause="
         + this.getCause()
         + ", dataStatus="
         + this.getDataStatus()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", clickTime="
         + this.getClickTime()
         + ", delButtonType="
         + this.getDelButtonType()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", purchaseCreationState="
         + this.getPurchaseCreationState()
         + ", boolUsed="
         + this.isBoolUsed()
         + ", boolSysgen="
         + this.getBoolSysgen()
         + ")";
   }

   public ApplyPurchaseDTOParam(
      final Long id,
      final String serialNumber,
      final String serialNumberParent,
      final Integer type,
      final Integer materialType,
      final Long projectId,
      final String projectIds,
      final String remark,
      final Long approveProcessId,
      final Integer finishedProductType,
      final List<ApplyPurchaseDetailDTOParam> list,
      final Integer reviewStatus,
      final Long approveId,
      final Integer level,
      final String tsData,
      final Boolean boolTemporaryStorage,
      final Boolean boolIsProjectDetail,
      final Long parentId,
      final String cause,
      final Integer dataStatus,
      final String projectAttribute,
      final Long branchCompanyId,
      final String classifyIds,
      final LocalDateTime clickTime,
      final Integer delButtonType,
      final List<Long> attachmentIds,
      final Integer purchaseCreationState,
      final boolean boolUsed,
      final Boolean boolSysgen
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.serialNumberParent = serialNumberParent;
      this.type = type;
      this.materialType = materialType;
      this.projectId = projectId;
      this.projectIds = projectIds;
      this.remark = remark;
      this.approveProcessId = approveProcessId;
      this.finishedProductType = finishedProductType;
      this.list = list;
      this.reviewStatus = reviewStatus;
      this.approveId = approveId;
      this.level = level;
      this.tsData = tsData;
      this.boolTemporaryStorage = boolTemporaryStorage;
      this.boolIsProjectDetail = boolIsProjectDetail;
      this.parentId = parentId;
      this.cause = cause;
      this.dataStatus = dataStatus;
      this.projectAttribute = projectAttribute;
      this.branchCompanyId = branchCompanyId;
      this.classifyIds = classifyIds;
      this.clickTime = clickTime;
      this.delButtonType = delButtonType;
      this.attachmentIds = attachmentIds;
      this.purchaseCreationState = purchaseCreationState;
      this.boolUsed = boolUsed;
      this.boolSysgen = boolSysgen;
   }

   public ApplyPurchaseDTOParam() {
   }

   public static class ApplyPurchaseDTOParamBuilder {
      private Long id;
      private String serialNumber;
      private String serialNumberParent;
      private Integer type;
      private Integer materialType;
      private Long projectId;
      private String projectIds;
      private String remark;
      private Long approveProcessId;
      private Integer finishedProductType;
      private List<ApplyPurchaseDetailDTOParam> list;
      private Integer reviewStatus;
      private Long approveId;
      private Integer level;
      private String tsData;
      private Boolean boolTemporaryStorage;
      private Boolean boolIsProjectDetail;
      private Long parentId;
      private String cause;
      private Integer dataStatus;
      private String projectAttribute;
      private Long branchCompanyId;
      private String classifyIds;
      private LocalDateTime clickTime;
      private Integer delButtonType;
      private List<Long> attachmentIds;
      private Integer purchaseCreationState;
      private boolean boolUsed;
      private Boolean boolSysgen;

      ApplyPurchaseDTOParamBuilder() {
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder serialNumberParent(final String serialNumberParent) {
         this.serialNumberParent = serialNumberParent;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder approveProcessId(final Long approveProcessId) {
         this.approveProcessId = approveProcessId;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder finishedProductType(final Integer finishedProductType) {
         this.finishedProductType = finishedProductType;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder list(final List<ApplyPurchaseDetailDTOParam> list) {
         this.list = list;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder approveId(final Long approveId) {
         this.approveId = approveId;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder tsData(final String tsData) {
         this.tsData = tsData;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder boolTemporaryStorage(final Boolean boolTemporaryStorage) {
         this.boolTemporaryStorage = boolTemporaryStorage;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder boolIsProjectDetail(final Boolean boolIsProjectDetail) {
         this.boolIsProjectDetail = boolIsProjectDetail;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder cause(final String cause) {
         this.cause = cause;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder dataStatus(final Integer dataStatus) {
         this.dataStatus = dataStatus;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder projectAttribute(final String projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder classifyIds(final String classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder clickTime(final LocalDateTime clickTime) {
         this.clickTime = clickTime;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder delButtonType(final Integer delButtonType) {
         this.delButtonType = delButtonType;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder purchaseCreationState(final Integer purchaseCreationState) {
         this.purchaseCreationState = purchaseCreationState;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder boolUsed(final boolean boolUsed) {
         this.boolUsed = boolUsed;
         return this;
      }

      public ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder boolSysgen(final Boolean boolSysgen) {
         this.boolSysgen = boolSysgen;
         return this;
      }

      public ApplyPurchaseDTOParam build() {
         return new ApplyPurchaseDTOParam(
            this.id,
            this.serialNumber,
            this.serialNumberParent,
            this.type,
            this.materialType,
            this.projectId,
            this.projectIds,
            this.remark,
            this.approveProcessId,
            this.finishedProductType,
            this.list,
            this.reviewStatus,
            this.approveId,
            this.level,
            this.tsData,
            this.boolTemporaryStorage,
            this.boolIsProjectDetail,
            this.parentId,
            this.cause,
            this.dataStatus,
            this.projectAttribute,
            this.branchCompanyId,
            this.classifyIds,
            this.clickTime,
            this.delButtonType,
            this.attachmentIds,
            this.purchaseCreationState,
            this.boolUsed,
            this.boolSysgen
         );
      }

      @Override
      public String toString() {
         return "ApplyPurchaseDTOParam.ApplyPurchaseDTOParamBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", serialNumberParent="
            + this.serialNumberParent
            + ", type="
            + this.type
            + ", materialType="
            + this.materialType
            + ", projectId="
            + this.projectId
            + ", projectIds="
            + this.projectIds
            + ", remark="
            + this.remark
            + ", approveProcessId="
            + this.approveProcessId
            + ", finishedProductType="
            + this.finishedProductType
            + ", list="
            + this.list
            + ", reviewStatus="
            + this.reviewStatus
            + ", approveId="
            + this.approveId
            + ", level="
            + this.level
            + ", tsData="
            + this.tsData
            + ", boolTemporaryStorage="
            + this.boolTemporaryStorage
            + ", boolIsProjectDetail="
            + this.boolIsProjectDetail
            + ", parentId="
            + this.parentId
            + ", cause="
            + this.cause
            + ", dataStatus="
            + this.dataStatus
            + ", projectAttribute="
            + this.projectAttribute
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", classifyIds="
            + this.classifyIds
            + ", clickTime="
            + this.clickTime
            + ", delButtonType="
            + this.delButtonType
            + ", attachmentIds="
            + this.attachmentIds
            + ", purchaseCreationState="
            + this.purchaseCreationState
            + ", boolUsed="
            + this.boolUsed
            + ", boolSysgen="
            + this.boolSysgen
            + ")";
      }
   }
}
