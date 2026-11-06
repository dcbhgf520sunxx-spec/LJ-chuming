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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractChange对象", description = "合同变更表 ")
@Entity
@TableName("contract_change")
@Table(name = "contract_change")
public class ContractChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "type", value = "变更类型 1信息修改 2 合同金额变更 ")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;
   @ApiModelProperty(name = "contractAmount", value = "合同原金额")
   @JsonProperty("contractAmount")
   @JSONField(name = "contractAmount")
   @TableField("contract_amount")
   @Column(name = "contract_amount")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "changeAmount", value = "合同变更金额")
   @JsonProperty("changeAmount")
   @JSONField(name = "changeAmount")
   @TableField("change_amount")
   @Column(name = "change_amount")
   private BigDecimal changeAmount;
   @ApiModelProperty(name = "changeContent", value = "变更内容")
   @JsonProperty("changeContent")
   @JSONField(name = "changeContent")
   @TableField("change_content")
   @Column(name = "change_content")
   private String changeContent;
   @ApiModelProperty(name = "userId", value = "变更用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "变更用户名字")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name")
   private String userName;
   @ApiModelProperty(name = "changeDate", value = "变更日期(结算日期)")
   @JsonProperty("changeDate")
   @JSONField(name = "changeDate")
   @TableField("change_date")
   @Column(name = "change_date")
   private LocalDate changeDate;
   @ApiModelProperty(name = "auditorId", value = "审核人id")
   @JsonProperty("auditorId")
   @JSONField(name = "auditorId")
   @TableField("auditor_id")
   @Column(name = "auditor_id")
   private Long auditorId;
   @ApiModelProperty(name = "auditorName", value = "审核人姓名")
   @JsonProperty("auditorName")
   @JSONField(name = "auditorName")
   @TableField("auditor_name")
   @Column(name = "auditor_name")
   private String auditorName;
   @ApiModelProperty(name = "auditTime", value = "审核时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   @TableField("audit_time")
   @Column(name = "audit_time")
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "auditStatus", value = "审核状态  1审核中 2审核通过 4已驳回")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   @TableField("audit_status")
   @Column(name = "audit_status")
   private Integer auditStatus;
   @ApiModelProperty(name = "changeDesc", value = "变更描述")
   @JsonProperty("changeDesc")
   @JSONField(name = "changeDesc")
   @TableField("change_desc")
   @Column(name = "change_desc")
   private String changeDesc;
   @ApiModelProperty(name = "source", value = "变更来源 1本系统 2钉钉")
   @JsonProperty("source")
   @JSONField(name = "source")
   @TableField("source")
   @Column(name = "source")
   private Integer source;
   @ApiModelProperty(name = "remark", value = "审核备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "attachmentIds", value = "附件id字符串")
   @JsonProperty("attachmentIds")
   @JSONField(name = "attachmentIds")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids")
   private String attachmentIds;
   @ApiModelProperty(name = "changeLeaderIds", value = "变更负责人id字符串")
   @JsonProperty("changeLeaderIds")
   @JSONField(name = "changeLeaderIds")
   @TableField("change_leader_ids")
   @Column(name = "change_leader_ids")
   private String changeLeaderIds;
   @ApiModelProperty(name = "isArchive", value = "是否归档 1.是 0.否")
   @JsonProperty("isArchive")
   @JSONField(name = "isArchive")
   @TableField("is_archive")
   @Column(name = "is_archive")
   private Integer isArchive;

   public static ContractChange.ContractChangeBuilder builder() {
      return new ContractChange.ContractChangeBuilder();
   }

   public ContractChange() {
   }

   public ContractChange(
      final Long id,
      final Long projectId,
      final Integer type,
      final BigDecimal contractAmount,
      final BigDecimal changeAmount,
      final String changeContent,
      final Long userId,
      final String userName,
      final LocalDate changeDate,
      final Long auditorId,
      final String auditorName,
      final LocalDateTime auditTime,
      final Integer auditStatus,
      final String changeDesc,
      final Integer source,
      final String remark,
      final String attachmentIds,
      final String changeLeaderIds,
      final Integer isArchive
   ) {
      this.id = id;
      this.projectId = projectId;
      this.type = type;
      this.contractAmount = contractAmount;
      this.changeAmount = changeAmount;
      this.changeContent = changeContent;
      this.userId = userId;
      this.userName = userName;
      this.changeDate = changeDate;
      this.auditorId = auditorId;
      this.auditorName = auditorName;
      this.auditTime = auditTime;
      this.auditStatus = auditStatus;
      this.changeDesc = changeDesc;
      this.source = source;
      this.remark = remark;
      this.attachmentIds = attachmentIds;
      this.changeLeaderIds = changeLeaderIds;
      this.isArchive = isArchive;
   }

   public Long getId() {
      return this.id;
   }

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

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDate getChangeDate() {
      return this.changeDate;
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

   public String getChangeDesc() {
      return this.changeDesc;
   }

   public Integer getSource() {
      return this.source;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public String getChangeLeaderIds() {
      return this.changeLeaderIds;
   }

   public Integer getIsArchive() {
      return this.isArchive;
   }

   @JsonProperty("id")
   public ContractChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public ContractChange setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("type")
   public ContractChange setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("contractAmount")
   public ContractChange setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   @JsonProperty("changeAmount")
   public ContractChange setChangeAmount(final BigDecimal changeAmount) {
      this.changeAmount = changeAmount;
      return this;
   }

   @JsonProperty("changeContent")
   public ContractChange setChangeContent(final String changeContent) {
      this.changeContent = changeContent;
      return this;
   }

   @JsonProperty("userId")
   public ContractChange setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public ContractChange setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("changeDate")
   public ContractChange setChangeDate(final LocalDate changeDate) {
      this.changeDate = changeDate;
      return this;
   }

   @JsonProperty("auditorId")
   public ContractChange setAuditorId(final Long auditorId) {
      this.auditorId = auditorId;
      return this;
   }

   @JsonProperty("auditorName")
   public ContractChange setAuditorName(final String auditorName) {
      this.auditorName = auditorName;
      return this;
   }

   @JsonProperty("auditTime")
   public ContractChange setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("auditStatus")
   public ContractChange setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @JsonProperty("changeDesc")
   public ContractChange setChangeDesc(final String changeDesc) {
      this.changeDesc = changeDesc;
      return this;
   }

   @JsonProperty("source")
   public ContractChange setSource(final Integer source) {
      this.source = source;
      return this;
   }

   @JsonProperty("remark")
   public ContractChange setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("attachmentIds")
   public ContractChange setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @JsonProperty("changeLeaderIds")
   public ContractChange setChangeLeaderIds(final String changeLeaderIds) {
      this.changeLeaderIds = changeLeaderIds;
      return this;
   }

   @JsonProperty("isArchive")
   public ContractChange setIsArchive(final Integer isArchive) {
      this.isArchive = isArchive;
      return this;
   }

   @Override
   public String toString() {
      return "ContractChange(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", type="
         + this.getType()
         + ", contractAmount="
         + this.getContractAmount()
         + ", changeAmount="
         + this.getChangeAmount()
         + ", changeContent="
         + this.getChangeContent()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", changeDate="
         + this.getChangeDate()
         + ", auditorId="
         + this.getAuditorId()
         + ", auditorName="
         + this.getAuditorName()
         + ", auditTime="
         + this.getAuditTime()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", changeDesc="
         + this.getChangeDesc()
         + ", source="
         + this.getSource()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", changeLeaderIds="
         + this.getChangeLeaderIds()
         + ", isArchive="
         + this.getIsArchive()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractChange)) {
         return false;
      }

      ContractChange other = (ContractChange)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$auditorId = this.getAuditorId();
                  Object other$auditorId = other.getAuditorId();
                  if (this$auditorId == null ? other$auditorId == null : this$auditorId.equals(other$auditorId)) {
                     Object this$auditStatus = this.getAuditStatus();
                     Object other$auditStatus = other.getAuditStatus();
                     if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                        Object this$source = this.getSource();
                        Object other$source = other.getSource();
                        if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                           Object this$isArchive = this.getIsArchive();
                           Object other$isArchive = other.getIsArchive();
                           if (this$isArchive == null ? other$isArchive == null : this$isArchive.equals(other$isArchive)) {
                              Object this$contractAmount = this.getContractAmount();
                              Object other$contractAmount = other.getContractAmount();
                              if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                                 Object this$changeAmount = this.getChangeAmount();
                                 Object other$changeAmount = other.getChangeAmount();
                                 if (this$changeAmount == null ? other$changeAmount == null : this$changeAmount.equals(other$changeAmount)) {
                                    Object this$changeContent = this.getChangeContent();
                                    Object other$changeContent = other.getChangeContent();
                                    if (this$changeContent == null ? other$changeContent == null : this$changeContent.equals(other$changeContent)) {
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
                                                   Object this$changeDesc = this.getChangeDesc();
                                                   Object other$changeDesc = other.getChangeDesc();
                                                   if (this$changeDesc == null ? other$changeDesc == null : this$changeDesc.equals(other$changeDesc)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                         Object this$attachmentIds = this.getAttachmentIds();
                                                         Object other$attachmentIds = other.getAttachmentIds();
                                                         if (this$attachmentIds == null
                                                            ? other$attachmentIds == null
                                                            : this$attachmentIds.equals(other$attachmentIds)) {
                                                            Object this$changeLeaderIds = this.getChangeLeaderIds();
                                                            Object other$changeLeaderIds = other.getChangeLeaderIds();
                                                            return this$changeLeaderIds == null
                                                               ? other$changeLeaderIds == null
                                                               : this$changeLeaderIds.equals(other$changeLeaderIds);
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
      return other instanceof ContractChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $auditorId = this.getAuditorId();
      result = result * 59 + ($auditorId == null ? 43 : $auditorId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $isArchive = this.getIsArchive();
      result = result * 59 + ($isArchive == null ? 43 : $isArchive.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $changeAmount = this.getChangeAmount();
      result = result * 59 + ($changeAmount == null ? 43 : $changeAmount.hashCode());
      Object $changeContent = this.getChangeContent();
      result = result * 59 + ($changeContent == null ? 43 : $changeContent.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $changeDate = this.getChangeDate();
      result = result * 59 + ($changeDate == null ? 43 : $changeDate.hashCode());
      Object $auditorName = this.getAuditorName();
      result = result * 59 + ($auditorName == null ? 43 : $auditorName.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $changeDesc = this.getChangeDesc();
      result = result * 59 + ($changeDesc == null ? 43 : $changeDesc.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $changeLeaderIds = this.getChangeLeaderIds();
      return result * 59 + ($changeLeaderIds == null ? 43 : $changeLeaderIds.hashCode());
   }

   public static class ContractChangeBuilder {
      private Long id;
      private Long projectId;
      private Integer type;
      private BigDecimal contractAmount;
      private BigDecimal changeAmount;
      private String changeContent;
      private Long userId;
      private String userName;
      private LocalDate changeDate;
      private Long auditorId;
      private String auditorName;
      private LocalDateTime auditTime;
      private Integer auditStatus;
      private String changeDesc;
      private Integer source;
      private String remark;
      private String attachmentIds;
      private String changeLeaderIds;
      private Integer isArchive;

      ContractChangeBuilder() {
      }

      @JsonProperty("id")
      public ContractChange.ContractChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public ContractChange.ContractChangeBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("type")
      public ContractChange.ContractChangeBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("contractAmount")
      public ContractChange.ContractChangeBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      @JsonProperty("changeAmount")
      public ContractChange.ContractChangeBuilder changeAmount(final BigDecimal changeAmount) {
         this.changeAmount = changeAmount;
         return this;
      }

      @JsonProperty("changeContent")
      public ContractChange.ContractChangeBuilder changeContent(final String changeContent) {
         this.changeContent = changeContent;
         return this;
      }

      @JsonProperty("userId")
      public ContractChange.ContractChangeBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public ContractChange.ContractChangeBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("changeDate")
      public ContractChange.ContractChangeBuilder changeDate(final LocalDate changeDate) {
         this.changeDate = changeDate;
         return this;
      }

      @JsonProperty("auditorId")
      public ContractChange.ContractChangeBuilder auditorId(final Long auditorId) {
         this.auditorId = auditorId;
         return this;
      }

      @JsonProperty("auditorName")
      public ContractChange.ContractChangeBuilder auditorName(final String auditorName) {
         this.auditorName = auditorName;
         return this;
      }

      @JsonProperty("auditTime")
      public ContractChange.ContractChangeBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("auditStatus")
      public ContractChange.ContractChangeBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      @JsonProperty("changeDesc")
      public ContractChange.ContractChangeBuilder changeDesc(final String changeDesc) {
         this.changeDesc = changeDesc;
         return this;
      }

      @JsonProperty("source")
      public ContractChange.ContractChangeBuilder source(final Integer source) {
         this.source = source;
         return this;
      }

      @JsonProperty("remark")
      public ContractChange.ContractChangeBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("attachmentIds")
      public ContractChange.ContractChangeBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      @JsonProperty("changeLeaderIds")
      public ContractChange.ContractChangeBuilder changeLeaderIds(final String changeLeaderIds) {
         this.changeLeaderIds = changeLeaderIds;
         return this;
      }

      @JsonProperty("isArchive")
      public ContractChange.ContractChangeBuilder isArchive(final Integer isArchive) {
         this.isArchive = isArchive;
         return this;
      }

      public ContractChange build() {
         return new ContractChange(
            this.id,
            this.projectId,
            this.type,
            this.contractAmount,
            this.changeAmount,
            this.changeContent,
            this.userId,
            this.userName,
            this.changeDate,
            this.auditorId,
            this.auditorName,
            this.auditTime,
            this.auditStatus,
            this.changeDesc,
            this.source,
            this.remark,
            this.attachmentIds,
            this.changeLeaderIds,
            this.isArchive
         );
      }

      @Override
      public String toString() {
         return "ContractChange.ContractChangeBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", type="
            + this.type
            + ", contractAmount="
            + this.contractAmount
            + ", changeAmount="
            + this.changeAmount
            + ", changeContent="
            + this.changeContent
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", changeDate="
            + this.changeDate
            + ", auditorId="
            + this.auditorId
            + ", auditorName="
            + this.auditorName
            + ", auditTime="
            + this.auditTime
            + ", auditStatus="
            + this.auditStatus
            + ", changeDesc="
            + this.changeDesc
            + ", source="
            + this.source
            + ", remark="
            + this.remark
            + ", attachmentIds="
            + this.attachmentIds
            + ", changeLeaderIds="
            + this.changeLeaderIds
            + ", isArchive="
            + this.isArchive
            + ")";
      }
   }
}
