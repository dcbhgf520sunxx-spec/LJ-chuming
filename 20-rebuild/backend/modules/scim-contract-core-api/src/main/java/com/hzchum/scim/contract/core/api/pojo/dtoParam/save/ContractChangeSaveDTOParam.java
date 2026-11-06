package com.hzchum.scim.contract.core.api.pojo.dtoParam.save;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.ProjectChangeTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectChangeDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel("项目变更 请求类")
public class ContractChangeSaveDTOParam {
   @NotNull(message = "项目id不能为空")
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @NotNull(message = "变更类型 不能为空")
   @ApiModelProperty(name = "type", value = " 变更类型 1.变更合同信息  2.变更合同金额")
   @EnumValidator(value = ProjectChangeTypeEnum.class, message = "变更类型有误!")
   private Integer type;
   @ApiModelProperty(name = "contractAmount", value = "合同原金额")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "changeAmount", value = "合同变更后金额")
   private BigDecimal changeAmount;
   @ApiModelProperty(name = "changeContent", value = "变更内容")
   private String changeContent;
   @ApiModelProperty(name = "changeDesc", value = "变更描述")
   private String changeDesc;
   @ApiModelProperty(name = "attachmentIds", value = "变更项目-附件id数组")
   private List<Long> attachmentIds;
   @ApiModelProperty(name = "userList", value = "负责人用户列表")
   private List<Long> userList;
   @ApiModelProperty(name = "changeDate", value = "变更日期")
   private LocalDate changeDate;
   @ApiModelProperty(name = "userId", value = "操作人ID")
   private Long userId;
   @ApiModelProperty(name = "projectUpdateDTOParam", value = "项目变更信息")
   @Valid
   private ProjectChangeDTOParam projectUpdateDTOParam;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getChangeAmount() {
      return this.changeAmount;
   }

   public String getChangeContent() {
      return this.changeContent;
   }

   public String getChangeDesc() {
      return this.changeDesc;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<Long> getUserList() {
      return this.userList;
   }

   public LocalDate getChangeDate() {
      return this.changeDate;
   }

   public Long getUserId() {
      return this.userId;
   }

   public ProjectChangeDTOParam getProjectUpdateDTOParam() {
      return this.projectUpdateDTOParam;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setChangeAmount(final BigDecimal changeAmount) {
      this.changeAmount = changeAmount;
   }

   public void setChangeContent(final String changeContent) {
      this.changeContent = changeContent;
   }

   public void setChangeDesc(final String changeDesc) {
      this.changeDesc = changeDesc;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setUserList(final List<Long> userList) {
      this.userList = userList;
   }

   public void setChangeDate(final LocalDate changeDate) {
      this.changeDate = changeDate;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setProjectUpdateDTOParam(final ProjectChangeDTOParam projectUpdateDTOParam) {
      this.projectUpdateDTOParam = projectUpdateDTOParam;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractChangeSaveDTOParam)) {
         return false;
      }

      ContractChangeSaveDTOParam other = (ContractChangeSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$contractAmount = this.getContractAmount();
               Object other$contractAmount = other.getContractAmount();
               if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                  Object this$changeAmount = this.getChangeAmount();
                  Object other$changeAmount = other.getChangeAmount();
                  if (this$changeAmount == null ? other$changeAmount == null : this$changeAmount.equals(other$changeAmount)) {
                     Object this$changeContent = this.getChangeContent();
                     Object other$changeContent = other.getChangeContent();
                     if (this$changeContent == null ? other$changeContent == null : this$changeContent.equals(other$changeContent)) {
                        Object this$changeDesc = this.getChangeDesc();
                        Object other$changeDesc = other.getChangeDesc();
                        if (this$changeDesc == null ? other$changeDesc == null : this$changeDesc.equals(other$changeDesc)) {
                           Object this$attachmentIds = this.getAttachmentIds();
                           Object other$attachmentIds = other.getAttachmentIds();
                           if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                              Object this$userList = this.getUserList();
                              Object other$userList = other.getUserList();
                              if (this$userList == null ? other$userList == null : this$userList.equals(other$userList)) {
                                 Object this$changeDate = this.getChangeDate();
                                 Object other$changeDate = other.getChangeDate();
                                 if (this$changeDate == null ? other$changeDate == null : this$changeDate.equals(other$changeDate)) {
                                    Object this$projectUpdateDTOParam = this.getProjectUpdateDTOParam();
                                    Object other$projectUpdateDTOParam = other.getProjectUpdateDTOParam();
                                    return this$projectUpdateDTOParam == null
                                       ? other$projectUpdateDTOParam == null
                                       : this$projectUpdateDTOParam.equals(other$projectUpdateDTOParam);
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
      return other instanceof ContractChangeSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $changeAmount = this.getChangeAmount();
      result = result * 59 + ($changeAmount == null ? 43 : $changeAmount.hashCode());
      Object $changeContent = this.getChangeContent();
      result = result * 59 + ($changeContent == null ? 43 : $changeContent.hashCode());
      Object $changeDesc = this.getChangeDesc();
      result = result * 59 + ($changeDesc == null ? 43 : $changeDesc.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $userList = this.getUserList();
      result = result * 59 + ($userList == null ? 43 : $userList.hashCode());
      Object $changeDate = this.getChangeDate();
      result = result * 59 + ($changeDate == null ? 43 : $changeDate.hashCode());
      Object $projectUpdateDTOParam = this.getProjectUpdateDTOParam();
      return result * 59 + ($projectUpdateDTOParam == null ? 43 : $projectUpdateDTOParam.hashCode());
   }

   @Override
   public String toString() {
      return "ContractChangeSaveDTOParam(projectId="
         + this.getProjectId()
         + ", type="
         + this.getType()
         + ", contractAmount="
         + this.getContractAmount()
         + ", changeAmount="
         + this.getChangeAmount()
         + ", changeContent="
         + this.getChangeContent()
         + ", changeDesc="
         + this.getChangeDesc()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", userList="
         + this.getUserList()
         + ", changeDate="
         + this.getChangeDate()
         + ", userId="
         + this.getUserId()
         + ", projectUpdateDTOParam="
         + this.getProjectUpdateDTOParam()
         + ")";
   }
}
