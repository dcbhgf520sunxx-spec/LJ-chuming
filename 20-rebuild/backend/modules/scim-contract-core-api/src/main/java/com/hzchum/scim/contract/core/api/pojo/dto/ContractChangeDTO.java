package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("项目变更响应类 ")
public class ContractChangeDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "type", value = "变更类型 1信息修改 2合同金额变更")
   private Integer type;
   @ApiModelProperty(name = "contract_amount", value = "(变更前)合同金额（元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "amount", value = "修改后的合同金额")
   private BigDecimal amount;
   @ApiModelProperty(name = "changeAmount", value = "变更后金额")
   private BigDecimal changeAmount;
   @ApiModelProperty(name = "userId", value = "变更用户id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "变更用户名字")
   private String userName;
   @ApiModelProperty(name = "changeDate", value = "变更日期")
   private LocalDate changeDate;
   @ApiModelProperty(name = "payType", value = "付款方式")
   private Integer payType;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人姓名")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditStatus", value = "审核状态  1审核中 2审核通过 4已驳回")
   private Integer auditStatus;
   @ApiModelProperty(name = "source", value = "变更来源 1本系统 2钉钉")
   private Integer source;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "changeContent", value = "变更内容")
   private String changeContent;
   @ApiModelProperty(name = "changeDesc", value = "变更描述")
   private String changeDesc;
   @ApiModelProperty(name = "attachmentIds", value = "附件id字符串")
   private String attachmentIds;
   @ApiModelProperty(name = "attachmentList", value = "附件列表")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "changeLeaderIds", value = "变更负责人id字符串")
   private String changeLeaderIds;
   @ApiModelProperty(name = "leaderList", value = "负责人列表")
   private List<NameInfo> leaderList;

   public static ContractChangeDTO.ContractChangeDTOBuilder builder() {
      return new ContractChangeDTO.ContractChangeDTOBuilder();
   }

   public ContractChangeDTO() {
   }

   public ContractChangeDTO(
      final Long id,
      final ProjectInfo project,
      final Integer type,
      final BigDecimal contractAmount,
      final BigDecimal amount,
      final BigDecimal changeAmount,
      final Long userId,
      final String userName,
      final LocalDate changeDate,
      final Integer payType,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final Integer source,
      final LocalDateTime createTime,
      final String changeContent,
      final String changeDesc,
      final String attachmentIds,
      final List<AttachmentDTO> attachmentList,
      final String changeLeaderIds,
      final List<NameInfo> leaderList
   ) {
      this.id = id;
      this.project = project;
      this.type = type;
      this.contractAmount = contractAmount;
      this.amount = amount;
      this.changeAmount = changeAmount;
      this.userId = userId;
      this.userName = userName;
      this.changeDate = changeDate;
      this.payType = payType;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.source = source;
      this.createTime = createTime;
      this.changeContent = changeContent;
      this.changeDesc = changeDesc;
      this.attachmentIds = attachmentIds;
      this.attachmentList = attachmentList;
      this.changeLeaderIds = changeLeaderIds;
      this.leaderList = leaderList;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getChangeAmount() {
      return this.changeAmount;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDate getChangeDate() {
      return this.changeDate;
   }

   public Integer getPayType() {
      return this.payType;
   }

   public Long getAuditorId() {
      return this.auditorId;
   }

   public String getAuditorName() {
      return this.auditorName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Integer getSource() {
      return this.source;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getChangeContent() {
      return this.changeContent;
   }

   public String getChangeDesc() {
      return this.changeDesc;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public String getChangeLeaderIds() {
      return this.changeLeaderIds;
   }

   public List<NameInfo> getLeaderList() {
      return this.leaderList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setChangeAmount(final BigDecimal changeAmount) {
      this.changeAmount = changeAmount;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setChangeDate(final LocalDate changeDate) {
      this.changeDate = changeDate;
   }

   public void setPayType(final Integer payType) {
      this.payType = payType;
   }

   public void setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
   }

   public void setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setSource(final Integer source) {
      this.source = source;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setChangeContent(final String changeContent) {
      this.changeContent = changeContent;
   }

   public void setChangeDesc(final String changeDesc) {
      this.changeDesc = changeDesc;
   }

   public void setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   public void setChangeLeaderIds(final String changeLeaderIds) {
      this.changeLeaderIds = changeLeaderIds;
   }

   public void setLeaderList(final List<NameInfo> leaderList) {
      this.leaderList = leaderList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractChangeDTO)) {
         return false;
      }

      ContractChangeDTO other = (ContractChangeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$payType = this.getPayType();
               Object other$payType = other.getPayType();
               if (this$payType == null ? other$payType == null : this$payType.equals(other$payType)) {
                  Object this$auditorId = this.getAuditorId();
                  Object other$auditorId = other.getAuditorId();
                  if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                     Object this$auditStatus = this.getAuditStatus();
                     Object other$auditStatus = other.getAuditStatus();
                     if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                        Object this$source = this.getSource();
                        Object other$source = other.getSource();
                        if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$contractAmount = this.getContractAmount();
                              Object other$contractAmount = other.getContractAmount();
                              if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                                 Object this$amount = this.getAmount();
                                 Object other$amount = other.getAmount();
                                 if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                    Object this$changeAmount = this.getChangeAmount();
                                    Object other$changeAmount = other.getChangeAmount();
                                    if (this$changeAmount == null ? other$changeAmount == null : this$changeAmount.equals(other$changeAmount)) {
                                       Object this$userName = this.getUserName();
                                       Object other$userName = other.getUserName();
                                       if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                          Object this$changeDate = this.getChangeDate();
                                          Object other$changeDate = other.getChangeDate();
                                          if (this$changeDate == null ? other$changeDate == null : this$changeDate.equals(other$changeDate)) {
                                             Object this$auditorName = this.getAuditorName();
                                             Object other$auditorName = other.getAuditorName();
                                             if (this$auditorName == null ? other$auditorName == null : this$auditorName.equals(other$auditorName)) {
                                                Object this$auditTime = this.getAuditTime();
                                                Object other$auditTime = other.getAuditTime();
                                                if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                                   Object this$createTime = this.getCreateTime();
                                                   Object other$createTime = other.getCreateTime();
                                                   if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                      Object this$changeContent = this.getChangeContent();
                                                      Object other$changeContent = other.getChangeContent();
                                                      if (this$changeContent == null
                                                         ? other$changeContent == null
                                                         : this$changeContent.equals(other$changeContent)) {
                                                         Object this$changeDesc = this.getChangeDesc();
                                                         Object other$changeDesc = other.getChangeDesc();
                                                         if (this$changeDesc == null ? other$changeDesc == null : this$changeDesc.equals(other$changeDesc)) {
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
                                                                  Object this$changeLeaderIds = this.getChangeLeaderIds();
                                                                  Object other$changeLeaderIds = other.getChangeLeaderIds();
                                                                  if (this$changeLeaderIds == null
                                                                     ? other$changeLeaderIds == null
                                                                     : this$changeLeaderIds.equals(other$changeLeaderIds)) {
                                                                     Object this$leaderList = this.getLeaderList();
                                                                     Object other$leaderList = other.getLeaderList();
                                                                     return this$leaderList == null
                                                                        ? other$leaderList == null
                                                                        : this$leaderList.equals(other$leaderList);
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
      return other instanceof ContractChangeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $payType = this.getPayType();
      result = result * 59 + ($payType == null ? 43 : $payType.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $changeAmount = this.getChangeAmount();
      result = result * 59 + ($changeAmount == null ? 43 : $changeAmount.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $changeDate = this.getChangeDate();
      result = result * 59 + ($changeDate == null ? 43 : $changeDate.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $changeContent = this.getChangeContent();
      result = result * 59 + ($changeContent == null ? 43 : $changeContent.hashCode());
      Object $changeDesc = this.getChangeDesc();
      result = result * 59 + ($changeDesc == null ? 43 : $changeDesc.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $changeLeaderIds = this.getChangeLeaderIds();
      result = result * 59 + ($changeLeaderIds == null ? 43 : $changeLeaderIds.hashCode());
      Object $leaderList = this.getLeaderList();
      return result * 59 + ($leaderList == null ? 43 : $leaderList.hashCode());
   }

   @Override
   public String toString() {
      return "ContractChangeDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", type="
         + this.getType()
         + ", contractAmount="
         + this.getContractAmount()
         + ", amount="
         + this.getAmount()
         + ", changeAmount="
         + this.getChangeAmount()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", changeDate="
         + this.getChangeDate()
         + ", payType="
         + this.getPayType()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", source="
         + this.getSource()
         + ", createTime="
         + this.getCreateTime()
         + ", changeContent="
         + this.getChangeContent()
         + ", changeDesc="
         + this.getChangeDesc()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", changeLeaderIds="
         + this.getChangeLeaderIds()
         + ", leaderList="
         + this.getLeaderList()
         + ")";
   }

   public static class ContractChangeDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private Integer type;
      private BigDecimal contractAmount;
      private BigDecimal amount;
      private BigDecimal changeAmount;
      private Long userId;
      private String userName;
      private LocalDate changeDate;
      private Integer payType;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private Integer source;
      private LocalDateTime createTime;
      private String changeContent;
      private String changeDesc;
      private String attachmentIds;
      private List<AttachmentDTO> attachmentList;
      private String changeLeaderIds;
      private List<NameInfo> leaderList;

      ContractChangeDTOBuilder() {
      }

      public ContractChangeDTO.ContractChangeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder changeAmount(final BigDecimal changeAmount) {
         this.changeAmount = changeAmount;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder changeDate(final LocalDate changeDate) {
         this.changeDate = changeDate;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder payType(final Integer payType) {
         this.payType = payType;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder source(final Integer source) {
         this.source = source;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder changeContent(final String changeContent) {
         this.changeContent = changeContent;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder changeDesc(final String changeDesc) {
         this.changeDesc = changeDesc;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder changeLeaderIds(final String changeLeaderIds) {
         this.changeLeaderIds = changeLeaderIds;
         return this;
      }

      public ContractChangeDTO.ContractChangeDTOBuilder leaderList(final List<NameInfo> leaderList) {
         this.leaderList = leaderList;
         return this;
      }

      public ContractChangeDTO build() {
         return new ContractChangeDTO(
            this.id,
            this.project,
            this.type,
            this.contractAmount,
            this.amount,
            this.changeAmount,
            this.userId,
            this.userName,
            this.changeDate,
            this.payType,
            this.auditorId,
            this.auditorName,
            this.auditTime,
            this.auditStatus,
            this.source,
            this.createTime,
            this.changeContent,
            this.changeDesc,
            this.attachmentIds,
            this.attachmentList,
            this.changeLeaderIds,
            this.leaderList
         );
      }

      @Override
      public String toString() {
         return "ContractChangeDTO.ContractChangeDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", type="
            + this.type
            + ", contractAmount="
            + this.contractAmount
            + ", amount="
            + this.amount
            + ", changeAmount="
            + this.changeAmount
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", changeDate="
            + this.changeDate
            + ", payType="
            + this.payType
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", source="
            + this.source
            + ", createTime="
            + this.createTime
            + ", changeContent="
            + this.changeContent
            + ", changeDesc="
            + this.changeDesc
            + ", attachmentIds="
            + this.attachmentIds
            + ", attachmentList="
            + this.attachmentList
            + ", changeLeaderIds="
            + this.changeLeaderIds
            + ", leaderList="
            + this.leaderList
            + ")";
      }
   }
}
