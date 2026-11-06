package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "Return对象", description = "退库表 ")
@Entity
@TableName("wms_return")
@Table(name = "wms_return")
public class Return extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "物料基础科目", notes = "物料基础科目")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础科目'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "serialNumber", value = "退库单号", notes = "退库单号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '退库单号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "projectIds", value = "项目ID集", notes = "项目ID集")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '项目ID集'", nullable = true)
   private String projectIds;
   @ApiModelProperty(name = "outboundIds", value = "出库单ID集", notes = "出库单ID集")
   @JsonProperty("outboundIds")
   @JSONField(name = "outboundIds")
   @TableField("outbound_ids")
   @Column(name = "outbound_ids", columnDefinition = "varchar(255)  COMMENT '出库单ID集'", nullable = true)
   private String outboundIds;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态", notes = "审核状态")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int  COMMENT '审核状态'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "editable", value = "是否可修改", notes = "是否可修改")
   @JsonProperty("editable")
   @JSONField(name = "editable")
   @TableField("editable")
   @Column(name = "editable", columnDefinition = "tinyint(1)  COMMENT '是否可修改'", nullable = true)
   private Boolean editable;
   @ApiModelProperty(name = "applicantId", value = "创建人ID", notes = "创建人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '创建人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "创建人名称", notes = "创建人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '创建人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "editorId", value = "最后编辑人ID", notes = "最后编辑人ID")
   @JsonProperty("editorId")
   @JSONField(name = "editorId")
   @TableField("editor_id")
   @Column(name = "editor_id", columnDefinition = "bigint  COMMENT '最后编辑人ID'", nullable = true)
   private Long editorId;
   @ApiModelProperty(name = "editorName", value = "最后编辑人名称", notes = "最后编辑人名称")
   @JsonProperty("editorName")
   @JSONField(name = "editorName")
   @TableField("editor_name")
   @Column(name = "editor_name", columnDefinition = "varchar(255)  COMMENT '最后编辑人名称'", nullable = true)
   private String editorName;
   @ApiModelProperty(name = "reviewerId", value = "审核人ID", notes = "审核人ID")
   @JsonProperty("reviewerId")
   @JSONField(name = "reviewerId")
   @TableField("reviewer_id")
   @Column(name = "reviewer_id", columnDefinition = "bigint  COMMENT '审核人ID'", nullable = true)
   private Long reviewerId;
   @ApiModelProperty(name = "reviewerName", value = "审核人名称", notes = "审核人名称")
   @JsonProperty("reviewerName")
   @JSONField(name = "reviewerName")
   @TableField("reviewer_name")
   @Column(name = "reviewer_name", columnDefinition = "varchar(255)  COMMENT '审核人名称'", nullable = true)
   private String reviewerName;
   @ApiModelProperty(name = "userUpdateTime", value = "用户修改时间", notes = "用户修改时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time", columnDefinition = "datetime  COMMENT '用户修改时间'", nullable = true)
   private LocalDateTime userUpdateTime;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "returnTime", value = "退库时间", notes = "退库时间")
   @JsonProperty("returnTime")
   @JSONField(name = "returnTime")
   @TableField("return_time")
   @Column(name = "return_time", columnDefinition = "datetime  COMMENT '退库时间'", nullable = true)
   private LocalDateTime returnTime;
   @ApiModelProperty(name = "originalId", value = "原来的退库单ID", notes = "原来的退库单ID")
   @JsonProperty("originalId")
   @JSONField(name = "originalId")
   @TableField("original_id")
   @Column(name = "original_id", columnDefinition = "bigint  COMMENT '原来的退库单ID'", nullable = true)
   private Long originalId;
   @ApiModelProperty(name = "rebuildingNumber", value = "退库单重建数", notes = "退库单重建数")
   @JsonProperty("rebuildingNumber")
   @JSONField(name = "rebuildingNumber")
   @TableField("rebuilding_number")
   @Column(name = "rebuilding_number", columnDefinition = "int  COMMENT '退库单重建数'", nullable = true)
   private Integer rebuildingNumber;
   @ApiModelProperty(name = "approvalComments")
   @JsonProperty("approvalComments")
   @JSONField(name = "approvalComments")
   @TableField("approval_comments")
   @Column(name = "approval_comments", columnDefinition = "text  COMMENT ''", nullable = true)
   private String approvalComments;
   @ApiModelProperty(name = "boolRealReturn", value = "是否真实退库", notes = "是否真实退库")
   @JsonProperty("boolRealReturn")
   @JSONField(name = "boolRealReturn")
   @TableField("bool_real_return")
   @Column(name = "bool_real_return", columnDefinition = "tinyint(1)  COMMENT '是否真实退库'", nullable = true)
   private Boolean boolRealReturn;
   @ApiModelProperty(
      name = "returnDestination",
      value = "退库目的地 1、按出库原路返回 2、直接退库到公共库 默认按出库原路退回 ReturnDestinationEnum",
      notes = "退库目的地 1、按出库原路返回 2、直接退库到公共库 默认按出库原路退回 ReturnDestinationEnum"
   )
   @JsonProperty("returnDestination")
   @JSONField(name = "returnDestination")
   @TableField("return_destination")
   @Column(
      name = "return_destination",
      columnDefinition = "tinyint(1) default '1'  COMMENT '退库目的地 1、按出库原路返回 2、直接退库到公共库 默认按出库原路退回 ReturnDestinationEnum'",
      nullable = true
   )
   private Integer returnDestination;
   @ApiModelProperty(name = "outboundTypeSelection")
   @JsonProperty("outboundTypeSelection")
   @JSONField(name = "outboundTypeSelection")
   @TableField("outbound_type_selection")
   @Column(name = "outbound_type_selection", columnDefinition = "int default '1' COMMENT '出库类型 枚举类[OutboundTypeEnum]'", nullable = false)
   private Integer outboundTypeSelection;
   @ApiModelProperty(name = "approveRecordId", value = "审批日志ID", notes = "审批日志ID")
   @JsonProperty("approveRecordId")
   @JSONField(name = "approveRecordId")
   @TableField("approve_record_id")
   @Column(name = "approve_record_id", columnDefinition = "bigint  COMMENT '审批日志ID'", nullable = true)
   private Long approveRecordId;
   @ApiModelProperty(name = "boolPrinted", value = "是否打印")
   @JsonProperty("boolPrinted")
   @JSONField(name = "boolPrinted")
   @TableField("bool_printed")
   @Column(name = "bool_printed", nullable = false, columnDefinition = "tinyint(1) default 0 COMMENT '是否打印: 0 未打印,1 打印'")
   private Boolean boolPrinted;

   public static Return.ReturnBuilder builder() {
      return new Return.ReturnBuilder();
   }

   public Return() {
   }

   public Return(
      final Long id,
      final Integer basicClass,
      final String serialNumber,
      final String projectIds,
      final String outboundIds,
      final Integer reviewStatus,
      final Boolean editable,
      final Long applicantId,
      final String applicantName,
      final Long editorId,
      final String editorName,
      final Long reviewerId,
      final String reviewerName,
      final LocalDateTime userUpdateTime,
      final LocalDateTime reviewTime,
      final LocalDateTime returnTime,
      final Long originalId,
      final Integer rebuildingNumber,
      final String approvalComments,
      final Boolean boolRealReturn,
      final Integer returnDestination,
      final Integer outboundTypeSelection,
      final Long approveRecordId,
      final Boolean boolPrinted
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.projectIds = projectIds;
      this.outboundIds = outboundIds;
      this.reviewStatus = reviewStatus;
      this.editable = editable;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.editorId = editorId;
      this.editorName = editorName;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.userUpdateTime = userUpdateTime;
      this.reviewTime = reviewTime;
      this.returnTime = returnTime;
      this.originalId = originalId;
      this.rebuildingNumber = rebuildingNumber;
      this.approvalComments = approvalComments;
      this.boolRealReturn = boolRealReturn;
      this.returnDestination = returnDestination;
      this.outboundTypeSelection = outboundTypeSelection;
      this.approveRecordId = approveRecordId;
      this.boolPrinted = boolPrinted;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public String getOutboundIds() {
      return this.outboundIds;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Boolean getEditable() {
      return this.editable;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getEditorId() {
      return this.editorId;
   }

   public String getEditorName() {
      return this.editorName;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public LocalDateTime getReturnTime() {
      return this.returnTime;
   }

   public Long getOriginalId() {
      return this.originalId;
   }

   public Integer getRebuildingNumber() {
      return this.rebuildingNumber;
   }

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public Boolean getBoolRealReturn() {
      return this.boolRealReturn;
   }

   public Integer getReturnDestination() {
      return this.returnDestination;
   }

   public Integer getOutboundTypeSelection() {
      return this.outboundTypeSelection;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   @JsonProperty("id")
   public Return setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("basicClass")
   public Return setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("serialNumber")
   public Return setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("projectIds")
   public Return setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("outboundIds")
   public Return setOutboundIds(final String outboundIds) {
      this.outboundIds = outboundIds;
      return this;
   }

   @JsonProperty("reviewStatus")
   public Return setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("editable")
   public Return setEditable(final Boolean editable) {
      this.editable = editable;
      return this;
   }

   @JsonProperty("applicantId")
   public Return setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public Return setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("editorId")
   public Return setEditorId(final Long editorId) {
      this.editorId = editorId;
      return this;
   }

   @JsonProperty("editorName")
   public Return setEditorName(final String editorName) {
      this.editorName = editorName;
      return this;
   }

   @JsonProperty("reviewerId")
   public Return setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
      return this;
   }

   @JsonProperty("reviewerName")
   public Return setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public Return setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @JsonProperty("reviewTime")
   public Return setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("returnTime")
   public Return setReturnTime(final LocalDateTime returnTime) {
      this.returnTime = returnTime;
      return this;
   }

   @JsonProperty("originalId")
   public Return setOriginalId(final Long originalId) {
      this.originalId = originalId;
      return this;
   }

   @JsonProperty("rebuildingNumber")
   public Return setRebuildingNumber(final Integer rebuildingNumber) {
      this.rebuildingNumber = rebuildingNumber;
      return this;
   }

   @JsonProperty("approvalComments")
   public Return setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
      return this;
   }

   @JsonProperty("boolRealReturn")
   public Return setBoolRealReturn(final Boolean boolRealReturn) {
      this.boolRealReturn = boolRealReturn;
      return this;
   }

   @JsonProperty("returnDestination")
   public Return setReturnDestination(final Integer returnDestination) {
      this.returnDestination = returnDestination;
      return this;
   }

   @JsonProperty("outboundTypeSelection")
   public Return setOutboundTypeSelection(final Integer outboundTypeSelection) {
      this.outboundTypeSelection = outboundTypeSelection;
      return this;
   }

   @JsonProperty("approveRecordId")
   public Return setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   @JsonProperty("boolPrinted")
   public Return setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
      return this;
   }

   @Override
   public String toString() {
      return "Return(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectIds="
         + this.getProjectIds()
         + ", outboundIds="
         + this.getOutboundIds()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", editable="
         + this.getEditable()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", editorId="
         + this.getEditorId()
         + ", editorName="
         + this.getEditorName()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", reviewTime="
         + this.getReviewTime()
         + ", returnTime="
         + this.getReturnTime()
         + ", originalId="
         + this.getOriginalId()
         + ", rebuildingNumber="
         + this.getRebuildingNumber()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", boolRealReturn="
         + this.getBoolRealReturn()
         + ", returnDestination="
         + this.getReturnDestination()
         + ", outboundTypeSelection="
         + this.getOutboundTypeSelection()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Return)) {
         return false;
      }

      Return other = (Return)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$reviewStatus = this.getReviewStatus();
            Object other$reviewStatus = other.getReviewStatus();
            if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
               Object this$editable = this.getEditable();
               Object other$editable = other.getEditable();
               if (this$editable == null ? other$editable == null : this$editable.equals(other$editable)) {
                  Object this$applicantId = this.getApplicantId();
                  Object other$applicantId = other.getApplicantId();
                  if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                     Object this$editorId = this.getEditorId();
                     Object other$editorId = other.getEditorId();
                     if (this$editorId == null ? other$editorId == null : this$editorId.equals(other$editorId)) {
                        Object this$reviewerId = this.getReviewerId();
                        Object other$reviewerId = other.getReviewerId();
                        if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                           Object this$originalId = this.getOriginalId();
                           Object other$originalId = other.getOriginalId();
                           if (this$originalId == null ? other$originalId == null : this$originalId.equals(other$originalId)) {
                              Object this$rebuildingNumber = this.getRebuildingNumber();
                              Object other$rebuildingNumber = other.getRebuildingNumber();
                              if (this$rebuildingNumber == null ? other$rebuildingNumber == null : this$rebuildingNumber.equals(other$rebuildingNumber)) {
                                 Object this$boolRealReturn = this.getBoolRealReturn();
                                 Object other$boolRealReturn = other.getBoolRealReturn();
                                 if (this$boolRealReturn == null ? other$boolRealReturn == null : this$boolRealReturn.equals(other$boolRealReturn)) {
                                    Object this$returnDestination = this.getReturnDestination();
                                    Object other$returnDestination = other.getReturnDestination();
                                    if (this$returnDestination == null
                                       ? other$returnDestination == null
                                       : this$returnDestination.equals(other$returnDestination)) {
                                       Object this$outboundTypeSelection = this.getOutboundTypeSelection();
                                       Object other$outboundTypeSelection = other.getOutboundTypeSelection();
                                       if (this$outboundTypeSelection == null
                                          ? other$outboundTypeSelection == null
                                          : this$outboundTypeSelection.equals(other$outboundTypeSelection)) {
                                          Object this$approveRecordId = this.getApproveRecordId();
                                          Object other$approveRecordId = other.getApproveRecordId();
                                          if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)
                                             )
                                           {
                                             Object this$boolPrinted = this.getBoolPrinted();
                                             Object other$boolPrinted = other.getBoolPrinted();
                                             if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$projectIds = this.getProjectIds();
                                                   Object other$projectIds = other.getProjectIds();
                                                   if (this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds)) {
                                                      Object this$outboundIds = this.getOutboundIds();
                                                      Object other$outboundIds = other.getOutboundIds();
                                                      if (this$outboundIds == null ? other$outboundIds == null : this$outboundIds.equals(other$outboundIds)) {
                                                         Object this$applicantName = this.getApplicantName();
                                                         Object other$applicantName = other.getApplicantName();
                                                         if (this$applicantName == null
                                                            ? other$applicantName == null
                                                            : this$applicantName.equals(other$applicantName)) {
                                                            Object this$editorName = this.getEditorName();
                                                            Object other$editorName = other.getEditorName();
                                                            if (this$editorName == null ? other$editorName == null : this$editorName.equals(other$editorName)) {
                                                               Object this$reviewerName = this.getReviewerName();
                                                               Object other$reviewerName = other.getReviewerName();
                                                               if (this$reviewerName == null
                                                                  ? other$reviewerName == null
                                                                  : this$reviewerName.equals(other$reviewerName)) {
                                                                  Object this$userUpdateTime = this.getUserUpdateTime();
                                                                  Object other$userUpdateTime = other.getUserUpdateTime();
                                                                  if (this$userUpdateTime == null
                                                                     ? other$userUpdateTime == null
                                                                     : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                     Object this$reviewTime = this.getReviewTime();
                                                                     Object other$reviewTime = other.getReviewTime();
                                                                     if (this$reviewTime == null
                                                                        ? other$reviewTime == null
                                                                        : this$reviewTime.equals(other$reviewTime)) {
                                                                        Object this$returnTime = this.getReturnTime();
                                                                        Object other$returnTime = other.getReturnTime();
                                                                        if (this$returnTime == null
                                                                           ? other$returnTime == null
                                                                           : this$returnTime.equals(other$returnTime)) {
                                                                           Object this$approvalComments = this.getApprovalComments();
                                                                           Object other$approvalComments = other.getApprovalComments();
                                                                           return this$approvalComments == null
                                                                              ? other$approvalComments == null
                                                                              : this$approvalComments.equals(other$approvalComments);
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
      return other instanceof Return;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $editable = this.getEditable();
      result = result * 59 + ($editable == null ? 43 : $editable.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $editorId = this.getEditorId();
      result = result * 59 + ($editorId == null ? 43 : $editorId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $originalId = this.getOriginalId();
      result = result * 59 + ($originalId == null ? 43 : $originalId.hashCode());
      Object $rebuildingNumber = this.getRebuildingNumber();
      result = result * 59 + ($rebuildingNumber == null ? 43 : $rebuildingNumber.hashCode());
      Object $boolRealReturn = this.getBoolRealReturn();
      result = result * 59 + ($boolRealReturn == null ? 43 : $boolRealReturn.hashCode());
      Object $returnDestination = this.getReturnDestination();
      result = result * 59 + ($returnDestination == null ? 43 : $returnDestination.hashCode());
      Object $outboundTypeSelection = this.getOutboundTypeSelection();
      result = result * 59 + ($outboundTypeSelection == null ? 43 : $outboundTypeSelection.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $outboundIds = this.getOutboundIds();
      result = result * 59 + ($outboundIds == null ? 43 : $outboundIds.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $returnTime = this.getReturnTime();
      result = result * 59 + ($returnTime == null ? 43 : $returnTime.hashCode());
      Object $approvalComments = this.getApprovalComments();
      return result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
   }

   public static class ReturnBuilder {
      private Long id;
      private Integer basicClass;
      private String serialNumber;
      private String projectIds;
      private String outboundIds;
      private Integer reviewStatus;
      private Boolean editable;
      private Long applicantId;
      private String applicantName;
      private Long editorId;
      private String editorName;
      private Long reviewerId;
      private String reviewerName;
      private LocalDateTime userUpdateTime;
      private LocalDateTime reviewTime;
      private LocalDateTime returnTime;
      private Long originalId;
      private Integer rebuildingNumber;
      private String approvalComments;
      private Boolean boolRealReturn;
      private Integer returnDestination;
      private Integer outboundTypeSelection;
      private Long approveRecordId;
      private Boolean boolPrinted;

      ReturnBuilder() {
      }

      @JsonProperty("id")
      public Return.ReturnBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public Return.ReturnBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("serialNumber")
      public Return.ReturnBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("projectIds")
      public Return.ReturnBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("outboundIds")
      public Return.ReturnBuilder outboundIds(final String outboundIds) {
         this.outboundIds = outboundIds;
         return this;
      }

      @JsonProperty("reviewStatus")
      public Return.ReturnBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("editable")
      public Return.ReturnBuilder editable(final Boolean editable) {
         this.editable = editable;
         return this;
      }

      @JsonProperty("applicantId")
      public Return.ReturnBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public Return.ReturnBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("editorId")
      public Return.ReturnBuilder editorId(final Long editorId) {
         this.editorId = editorId;
         return this;
      }

      @JsonProperty("editorName")
      public Return.ReturnBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      @JsonProperty("reviewerId")
      public Return.ReturnBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      @JsonProperty("reviewerName")
      public Return.ReturnBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public Return.ReturnBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      @JsonProperty("reviewTime")
      public Return.ReturnBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("returnTime")
      public Return.ReturnBuilder returnTime(final LocalDateTime returnTime) {
         this.returnTime = returnTime;
         return this;
      }

      @JsonProperty("originalId")
      public Return.ReturnBuilder originalId(final Long originalId) {
         this.originalId = originalId;
         return this;
      }

      @JsonProperty("rebuildingNumber")
      public Return.ReturnBuilder rebuildingNumber(final Integer rebuildingNumber) {
         this.rebuildingNumber = rebuildingNumber;
         return this;
      }

      @JsonProperty("approvalComments")
      public Return.ReturnBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      @JsonProperty("boolRealReturn")
      public Return.ReturnBuilder boolRealReturn(final Boolean boolRealReturn) {
         this.boolRealReturn = boolRealReturn;
         return this;
      }

      @JsonProperty("returnDestination")
      public Return.ReturnBuilder returnDestination(final Integer returnDestination) {
         this.returnDestination = returnDestination;
         return this;
      }

      @JsonProperty("outboundTypeSelection")
      public Return.ReturnBuilder outboundTypeSelection(final Integer outboundTypeSelection) {
         this.outboundTypeSelection = outboundTypeSelection;
         return this;
      }

      @JsonProperty("approveRecordId")
      public Return.ReturnBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      @JsonProperty("boolPrinted")
      public Return.ReturnBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      public Return build() {
         return new Return(
            this.id,
            this.basicClass,
            this.serialNumber,
            this.projectIds,
            this.outboundIds,
            this.reviewStatus,
            this.editable,
            this.applicantId,
            this.applicantName,
            this.editorId,
            this.editorName,
            this.reviewerId,
            this.reviewerName,
            this.userUpdateTime,
            this.reviewTime,
            this.returnTime,
            this.originalId,
            this.rebuildingNumber,
            this.approvalComments,
            this.boolRealReturn,
            this.returnDestination,
            this.outboundTypeSelection,
            this.approveRecordId,
            this.boolPrinted
         );
      }

      @Override
      public String toString() {
         return "Return.ReturnBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", projectIds="
            + this.projectIds
            + ", outboundIds="
            + this.outboundIds
            + ", reviewStatus="
            + this.reviewStatus
            + ", editable="
            + this.editable
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", editorId="
            + this.editorId
            + ", editorName="
            + this.editorName
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", reviewTime="
            + this.reviewTime
            + ", returnTime="
            + this.returnTime
            + ", originalId="
            + this.originalId
            + ", rebuildingNumber="
            + this.rebuildingNumber
            + ", approvalComments="
            + this.approvalComments
            + ", boolRealReturn="
            + this.boolRealReturn
            + ", returnDestination="
            + this.returnDestination
            + ", outboundTypeSelection="
            + this.outboundTypeSelection
            + ", approveRecordId="
            + this.approveRecordId
            + ", boolPrinted="
            + this.boolPrinted
            + ")";
      }
   }
}
