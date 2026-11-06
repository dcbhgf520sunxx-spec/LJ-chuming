package com.hzchum.scim.crm.core.api.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class CrmSetTenderHeadParamV2 {
   @ApiModelProperty(name = "isNeedFill", notes = "是否需要填报")
   private Boolean isNeedFill;
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "technologyBidManagerJobDescriptionId", value = "技术投标工作内容", notes = "技术投标工作内容")
   private Long technologyBidManagerJobDescriptionId;
   @ApiModelProperty(name = "technologyBidManagerRenderings", value = "技术投标效果图", notes = "技术投标效果图")
   private String technologyBidManagerRenderings;
   @ApiModelProperty(name = "technologyBidManagerStructureName", value = "技术投标结构名称", notes = "技术投标结构名称")
   private String technologyBidManagerStructureName;
   @ApiModelProperty(name = "technologyBidManagerCompletion", value = "技术投标完成情况", notes = "技术投标完成情况")
   private String technologyBidManagerCompletion;
   @ApiModelProperty(name = "technologyBidManagerBusinessTrip", value = "技术投标出差", notes = "技术投标出差")
   private String technologyBidManagerBusinessTrip;
   @ApiModelProperty(name = "technologyBidManagerCustomerReception", value = "技术投标客户接待", notes = "技术投标客户接待")
   private String technologyBidManagerCustomerReception;
   @ApiModelProperty(name = "technologyBidManagerRemarks", value = "技术投标备注", notes = "技术投标备注")
   private String technologyBidManagerRemarks;
   @ApiModelProperty(name = "crmTenderRequirementTypeEnum", notes = "标类型")
   private Integer crmTenderRequirementTypeEnum;
   @ApiModelProperty(name = "projectBidManagerUserId", notes = "投标负责人")
   private Long projectBidManagerUserId;
   @ApiModelProperty(name = "projectBidManagerUserIdList", notes = "投标负责人id集合")
   private List<Long> projectBidManagerUserIdList;
   @ApiModelProperty(name = "projectBidManagerFinishDate", notes = "投标完成日期")
   private LocalDateTime projectBidManagerFinishDate;
   @ApiModelProperty(name = "difficultyFactorId", notes = "难度系数")
   private Long difficultyFactorId;
   @ApiModelProperty(name = "crmSpecialBubmissionStatusEnum", notes = "提报类型")
   private Integer crmSpecialBubmissionStatusEnum;
   private Long crmApplyTechnologyBiddingRecordId;
   @ApiModelProperty(name = "crmProjectBidStatus", notes = "投标状态")
   private Integer crmProjectBidStatus;
   @ApiModelProperty(name = "visualizationQuantity", value = "可视化数量", notes = "可视化数量")
   private Integer visualizationQuantity;
   @ApiModelProperty(name = "contactPerson", value = "对接人", notes = "对接人")
   private String contactPerson;

   public CrmSetTenderHeadParamV2(
      final Boolean isNeedFill,
      final Long crmProjectInformationWarehousingId,
      final Long technologyBidManagerJobDescriptionId,
      final String technologyBidManagerRenderings,
      final String technologyBidManagerStructureName,
      final String technologyBidManagerCompletion,
      final String technologyBidManagerBusinessTrip,
      final String technologyBidManagerCustomerReception,
      final String technologyBidManagerRemarks,
      final Integer crmTenderRequirementTypeEnum,
      final Long projectBidManagerUserId,
      final List<Long> projectBidManagerUserIdList,
      final LocalDateTime projectBidManagerFinishDate,
      final Long difficultyFactorId,
      final Integer crmSpecialBubmissionStatusEnum,
      final Long crmApplyTechnologyBiddingRecordId,
      final Integer crmProjectBidStatus,
      final Integer visualizationQuantity,
      final String contactPerson
   ) {
      this.isNeedFill = isNeedFill;
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
      this.technologyBidManagerRenderings = technologyBidManagerRenderings;
      this.technologyBidManagerStructureName = technologyBidManagerStructureName;
      this.technologyBidManagerCompletion = technologyBidManagerCompletion;
      this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
      this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
      this.technologyBidManagerRemarks = technologyBidManagerRemarks;
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
      this.projectBidManagerUserId = projectBidManagerUserId;
      this.projectBidManagerUserIdList = projectBidManagerUserIdList;
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
      this.difficultyFactorId = difficultyFactorId;
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      this.crmApplyTechnologyBiddingRecordId = crmApplyTechnologyBiddingRecordId;
      this.crmProjectBidStatus = crmProjectBidStatus;
      this.visualizationQuantity = visualizationQuantity;
      this.contactPerson = contactPerson;
   }

   public CrmSetTenderHeadParamV2() {
   }

   public Boolean getIsNeedFill() {
      return this.isNeedFill;
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public Long getTechnologyBidManagerJobDescriptionId() {
      return this.technologyBidManagerJobDescriptionId;
   }

   public String getTechnologyBidManagerRenderings() {
      return this.technologyBidManagerRenderings;
   }

   public String getTechnologyBidManagerStructureName() {
      return this.technologyBidManagerStructureName;
   }

   public String getTechnologyBidManagerCompletion() {
      return this.technologyBidManagerCompletion;
   }

   public String getTechnologyBidManagerBusinessTrip() {
      return this.technologyBidManagerBusinessTrip;
   }

   public String getTechnologyBidManagerCustomerReception() {
      return this.technologyBidManagerCustomerReception;
   }

   public String getTechnologyBidManagerRemarks() {
      return this.technologyBidManagerRemarks;
   }

   public Integer getCrmTenderRequirementTypeEnum() {
      return this.crmTenderRequirementTypeEnum;
   }

   public Long getProjectBidManagerUserId() {
      return this.projectBidManagerUserId;
   }

   public List<Long> getProjectBidManagerUserIdList() {
      return this.projectBidManagerUserIdList;
   }

   public LocalDateTime getProjectBidManagerFinishDate() {
      return this.projectBidManagerFinishDate;
   }

   public Long getDifficultyFactorId() {
      return this.difficultyFactorId;
   }

   public Integer getCrmSpecialBubmissionStatusEnum() {
      return this.crmSpecialBubmissionStatusEnum;
   }

   public Long getCrmApplyTechnologyBiddingRecordId() {
      return this.crmApplyTechnologyBiddingRecordId;
   }

   public Integer getCrmProjectBidStatus() {
      return this.crmProjectBidStatus;
   }

   public Integer getVisualizationQuantity() {
      return this.visualizationQuantity;
   }

   public String getContactPerson() {
      return this.contactPerson;
   }

   public void setIsNeedFill(final Boolean isNeedFill) {
      this.isNeedFill = isNeedFill;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setTechnologyBidManagerJobDescriptionId(final Long technologyBidManagerJobDescriptionId) {
      this.technologyBidManagerJobDescriptionId = technologyBidManagerJobDescriptionId;
   }

   public void setTechnologyBidManagerRenderings(final String technologyBidManagerRenderings) {
      this.technologyBidManagerRenderings = technologyBidManagerRenderings;
   }

   public void setTechnologyBidManagerStructureName(final String technologyBidManagerStructureName) {
      this.technologyBidManagerStructureName = technologyBidManagerStructureName;
   }

   public void setTechnologyBidManagerCompletion(final String technologyBidManagerCompletion) {
      this.technologyBidManagerCompletion = technologyBidManagerCompletion;
   }

   public void setTechnologyBidManagerBusinessTrip(final String technologyBidManagerBusinessTrip) {
      this.technologyBidManagerBusinessTrip = technologyBidManagerBusinessTrip;
   }

   public void setTechnologyBidManagerCustomerReception(final String technologyBidManagerCustomerReception) {
      this.technologyBidManagerCustomerReception = technologyBidManagerCustomerReception;
   }

   public void setTechnologyBidManagerRemarks(final String technologyBidManagerRemarks) {
      this.technologyBidManagerRemarks = technologyBidManagerRemarks;
   }

   public void setCrmTenderRequirementTypeEnum(final Integer crmTenderRequirementTypeEnum) {
      this.crmTenderRequirementTypeEnum = crmTenderRequirementTypeEnum;
   }

   public void setProjectBidManagerUserId(final Long projectBidManagerUserId) {
      this.projectBidManagerUserId = projectBidManagerUserId;
   }

   public void setProjectBidManagerUserIdList(final List<Long> projectBidManagerUserIdList) {
      this.projectBidManagerUserIdList = projectBidManagerUserIdList;
   }

   public void setProjectBidManagerFinishDate(final LocalDateTime projectBidManagerFinishDate) {
      this.projectBidManagerFinishDate = projectBidManagerFinishDate;
   }

   public void setDifficultyFactorId(final Long difficultyFactorId) {
      this.difficultyFactorId = difficultyFactorId;
   }

   public void setCrmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
   }

   public void setCrmApplyTechnologyBiddingRecordId(final Long crmApplyTechnologyBiddingRecordId) {
      this.crmApplyTechnologyBiddingRecordId = crmApplyTechnologyBiddingRecordId;
   }

   public void setCrmProjectBidStatus(final Integer crmProjectBidStatus) {
      this.crmProjectBidStatus = crmProjectBidStatus;
   }

   public void setVisualizationQuantity(final Integer visualizationQuantity) {
      this.visualizationQuantity = visualizationQuantity;
   }

   public void setContactPerson(final String contactPerson) {
      this.contactPerson = contactPerson;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmSetTenderHeadParamV2)) {
         return false;
      }

      CrmSetTenderHeadParamV2 other = (CrmSetTenderHeadParamV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$isNeedFill = this.getIsNeedFill();
      Object other$isNeedFill = other.getIsNeedFill();
      if (this$isNeedFill == null ? other$isNeedFill == null : this$isNeedFill.equals(other$isNeedFill)) {
         Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
         Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
         if (this$crmProjectInformationWarehousingId == null
            ? other$crmProjectInformationWarehousingId == null
            : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
            Object this$technologyBidManagerJobDescriptionId = this.getTechnologyBidManagerJobDescriptionId();
            Object other$technologyBidManagerJobDescriptionId = other.getTechnologyBidManagerJobDescriptionId();
            if (this$technologyBidManagerJobDescriptionId == null
               ? other$technologyBidManagerJobDescriptionId == null
               : this$technologyBidManagerJobDescriptionId.equals(other$technologyBidManagerJobDescriptionId)) {
               Object this$crmTenderRequirementTypeEnum = this.getCrmTenderRequirementTypeEnum();
               Object other$crmTenderRequirementTypeEnum = other.getCrmTenderRequirementTypeEnum();
               if (this$crmTenderRequirementTypeEnum == null
                  ? other$crmTenderRequirementTypeEnum == null
                  : this$crmTenderRequirementTypeEnum.equals(other$crmTenderRequirementTypeEnum)) {
                  Object this$projectBidManagerUserId = this.getProjectBidManagerUserId();
                  Object other$projectBidManagerUserId = other.getProjectBidManagerUserId();
                  if (this$projectBidManagerUserId == null
                     ? other$projectBidManagerUserId == null
                     : this$projectBidManagerUserId.equals(other$projectBidManagerUserId)) {
                     Object this$difficultyFactorId = this.getDifficultyFactorId();
                     Object other$difficultyFactorId = other.getDifficultyFactorId();
                     if (this$difficultyFactorId == null ? other$difficultyFactorId == null : this$difficultyFactorId.equals(other$difficultyFactorId)) {
                        Object this$crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
                        Object other$crmSpecialBubmissionStatusEnum = other.getCrmSpecialBubmissionStatusEnum();
                        if (this$crmSpecialBubmissionStatusEnum == null
                           ? other$crmSpecialBubmissionStatusEnum == null
                           : this$crmSpecialBubmissionStatusEnum.equals(other$crmSpecialBubmissionStatusEnum)) {
                           Object this$crmApplyTechnologyBiddingRecordId = this.getCrmApplyTechnologyBiddingRecordId();
                           Object other$crmApplyTechnologyBiddingRecordId = other.getCrmApplyTechnologyBiddingRecordId();
                           if (this$crmApplyTechnologyBiddingRecordId == null
                              ? other$crmApplyTechnologyBiddingRecordId == null
                              : this$crmApplyTechnologyBiddingRecordId.equals(other$crmApplyTechnologyBiddingRecordId)) {
                              Object this$crmProjectBidStatus = this.getCrmProjectBidStatus();
                              Object other$crmProjectBidStatus = other.getCrmProjectBidStatus();
                              if (this$crmProjectBidStatus == null
                                 ? other$crmProjectBidStatus == null
                                 : this$crmProjectBidStatus.equals(other$crmProjectBidStatus)) {
                                 Object this$visualizationQuantity = this.getVisualizationQuantity();
                                 Object other$visualizationQuantity = other.getVisualizationQuantity();
                                 if (this$visualizationQuantity == null
                                    ? other$visualizationQuantity == null
                                    : this$visualizationQuantity.equals(other$visualizationQuantity)) {
                                    Object this$technologyBidManagerRenderings = this.getTechnologyBidManagerRenderings();
                                    Object other$technologyBidManagerRenderings = other.getTechnologyBidManagerRenderings();
                                    if (this$technologyBidManagerRenderings == null
                                       ? other$technologyBidManagerRenderings == null
                                       : this$technologyBidManagerRenderings.equals(other$technologyBidManagerRenderings)) {
                                       Object this$technologyBidManagerStructureName = this.getTechnologyBidManagerStructureName();
                                       Object other$technologyBidManagerStructureName = other.getTechnologyBidManagerStructureName();
                                       if (this$technologyBidManagerStructureName == null
                                          ? other$technologyBidManagerStructureName == null
                                          : this$technologyBidManagerStructureName.equals(other$technologyBidManagerStructureName)) {
                                          Object this$technologyBidManagerCompletion = this.getTechnologyBidManagerCompletion();
                                          Object other$technologyBidManagerCompletion = other.getTechnologyBidManagerCompletion();
                                          if (this$technologyBidManagerCompletion == null
                                             ? other$technologyBidManagerCompletion == null
                                             : this$technologyBidManagerCompletion.equals(other$technologyBidManagerCompletion)) {
                                             Object this$technologyBidManagerBusinessTrip = this.getTechnologyBidManagerBusinessTrip();
                                             Object other$technologyBidManagerBusinessTrip = other.getTechnologyBidManagerBusinessTrip();
                                             if (this$technologyBidManagerBusinessTrip == null
                                                ? other$technologyBidManagerBusinessTrip == null
                                                : this$technologyBidManagerBusinessTrip.equals(other$technologyBidManagerBusinessTrip)) {
                                                Object this$technologyBidManagerCustomerReception = this.getTechnologyBidManagerCustomerReception();
                                                Object other$technologyBidManagerCustomerReception = other.getTechnologyBidManagerCustomerReception();
                                                if (this$technologyBidManagerCustomerReception == null
                                                   ? other$technologyBidManagerCustomerReception == null
                                                   : this$technologyBidManagerCustomerReception.equals(other$technologyBidManagerCustomerReception)) {
                                                   Object this$technologyBidManagerRemarks = this.getTechnologyBidManagerRemarks();
                                                   Object other$technologyBidManagerRemarks = other.getTechnologyBidManagerRemarks();
                                                   if (this$technologyBidManagerRemarks == null
                                                      ? other$technologyBidManagerRemarks == null
                                                      : this$technologyBidManagerRemarks.equals(other$technologyBidManagerRemarks)) {
                                                      Object this$projectBidManagerUserIdList = this.getProjectBidManagerUserIdList();
                                                      Object other$projectBidManagerUserIdList = other.getProjectBidManagerUserIdList();
                                                      if (this$projectBidManagerUserIdList == null
                                                         ? other$projectBidManagerUserIdList == null
                                                         : this$projectBidManagerUserIdList.equals(other$projectBidManagerUserIdList)) {
                                                         Object this$projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
                                                         Object other$projectBidManagerFinishDate = other.getProjectBidManagerFinishDate();
                                                         if (this$projectBidManagerFinishDate == null
                                                            ? other$projectBidManagerFinishDate == null
                                                            : this$projectBidManagerFinishDate.equals(other$projectBidManagerFinishDate)) {
                                                            Object this$contactPerson = this.getContactPerson();
                                                            Object other$contactPerson = other.getContactPerson();
                                                            return this$contactPerson == null
                                                               ? other$contactPerson == null
                                                               : this$contactPerson.equals(other$contactPerson);
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
      return other instanceof CrmSetTenderHeadParamV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $isNeedFill = this.getIsNeedFill();
      result = result * 59 + ($isNeedFill == null ? 43 : $isNeedFill.hashCode());
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $technologyBidManagerJobDescriptionId = this.getTechnologyBidManagerJobDescriptionId();
      result = result * 59 + ($technologyBidManagerJobDescriptionId == null ? 43 : $technologyBidManagerJobDescriptionId.hashCode());
      Object $crmTenderRequirementTypeEnum = this.getCrmTenderRequirementTypeEnum();
      result = result * 59 + ($crmTenderRequirementTypeEnum == null ? 43 : $crmTenderRequirementTypeEnum.hashCode());
      Object $projectBidManagerUserId = this.getProjectBidManagerUserId();
      result = result * 59 + ($projectBidManagerUserId == null ? 43 : $projectBidManagerUserId.hashCode());
      Object $difficultyFactorId = this.getDifficultyFactorId();
      result = result * 59 + ($difficultyFactorId == null ? 43 : $difficultyFactorId.hashCode());
      Object $crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      result = result * 59 + ($crmSpecialBubmissionStatusEnum == null ? 43 : $crmSpecialBubmissionStatusEnum.hashCode());
      Object $crmApplyTechnologyBiddingRecordId = this.getCrmApplyTechnologyBiddingRecordId();
      result = result * 59 + ($crmApplyTechnologyBiddingRecordId == null ? 43 : $crmApplyTechnologyBiddingRecordId.hashCode());
      Object $crmProjectBidStatus = this.getCrmProjectBidStatus();
      result = result * 59 + ($crmProjectBidStatus == null ? 43 : $crmProjectBidStatus.hashCode());
      Object $visualizationQuantity = this.getVisualizationQuantity();
      result = result * 59 + ($visualizationQuantity == null ? 43 : $visualizationQuantity.hashCode());
      Object $technologyBidManagerRenderings = this.getTechnologyBidManagerRenderings();
      result = result * 59 + ($technologyBidManagerRenderings == null ? 43 : $technologyBidManagerRenderings.hashCode());
      Object $technologyBidManagerStructureName = this.getTechnologyBidManagerStructureName();
      result = result * 59 + ($technologyBidManagerStructureName == null ? 43 : $technologyBidManagerStructureName.hashCode());
      Object $technologyBidManagerCompletion = this.getTechnologyBidManagerCompletion();
      result = result * 59 + ($technologyBidManagerCompletion == null ? 43 : $technologyBidManagerCompletion.hashCode());
      Object $technologyBidManagerBusinessTrip = this.getTechnologyBidManagerBusinessTrip();
      result = result * 59 + ($technologyBidManagerBusinessTrip == null ? 43 : $technologyBidManagerBusinessTrip.hashCode());
      Object $technologyBidManagerCustomerReception = this.getTechnologyBidManagerCustomerReception();
      result = result * 59 + ($technologyBidManagerCustomerReception == null ? 43 : $technologyBidManagerCustomerReception.hashCode());
      Object $technologyBidManagerRemarks = this.getTechnologyBidManagerRemarks();
      result = result * 59 + ($technologyBidManagerRemarks == null ? 43 : $technologyBidManagerRemarks.hashCode());
      Object $projectBidManagerUserIdList = this.getProjectBidManagerUserIdList();
      result = result * 59 + ($projectBidManagerUserIdList == null ? 43 : $projectBidManagerUserIdList.hashCode());
      Object $projectBidManagerFinishDate = this.getProjectBidManagerFinishDate();
      result = result * 59 + ($projectBidManagerFinishDate == null ? 43 : $projectBidManagerFinishDate.hashCode());
      Object $contactPerson = this.getContactPerson();
      return result * 59 + ($contactPerson == null ? 43 : $contactPerson.hashCode());
   }

   @Override
   public String toString() {
      return "CrmSetTenderHeadParamV2(isNeedFill="
         + this.getIsNeedFill()
         + ", crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", technologyBidManagerJobDescriptionId="
         + this.getTechnologyBidManagerJobDescriptionId()
         + ", technologyBidManagerRenderings="
         + this.getTechnologyBidManagerRenderings()
         + ", technologyBidManagerStructureName="
         + this.getTechnologyBidManagerStructureName()
         + ", technologyBidManagerCompletion="
         + this.getTechnologyBidManagerCompletion()
         + ", technologyBidManagerBusinessTrip="
         + this.getTechnologyBidManagerBusinessTrip()
         + ", technologyBidManagerCustomerReception="
         + this.getTechnologyBidManagerCustomerReception()
         + ", technologyBidManagerRemarks="
         + this.getTechnologyBidManagerRemarks()
         + ", crmTenderRequirementTypeEnum="
         + this.getCrmTenderRequirementTypeEnum()
         + ", projectBidManagerUserId="
         + this.getProjectBidManagerUserId()
         + ", projectBidManagerUserIdList="
         + this.getProjectBidManagerUserIdList()
         + ", projectBidManagerFinishDate="
         + this.getProjectBidManagerFinishDate()
         + ", difficultyFactorId="
         + this.getDifficultyFactorId()
         + ", crmSpecialBubmissionStatusEnum="
         + this.getCrmSpecialBubmissionStatusEnum()
         + ", crmApplyTechnologyBiddingRecordId="
         + this.getCrmApplyTechnologyBiddingRecordId()
         + ", crmProjectBidStatus="
         + this.getCrmProjectBidStatus()
         + ", visualizationQuantity="
         + this.getVisualizationQuantity()
         + ", contactPerson="
         + this.getContactPerson()
         + ")";
   }
}
