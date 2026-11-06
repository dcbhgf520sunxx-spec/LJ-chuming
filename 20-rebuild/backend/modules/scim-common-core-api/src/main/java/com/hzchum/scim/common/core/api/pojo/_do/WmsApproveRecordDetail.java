package com.hzchum.scim.common.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "WmsApproveRecordDetail对象", description = "审核日志详情表")
@Entity
@TableName("wms_approve_record_detail")
@Table(name = "wms_approve_record_detail")
@org.hibernate.annotations.Table(appliesTo = "wms_approve_record_detail", comment = "审核日志详情表")
public class WmsApproveRecordDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "dataId", value = "关联数据的ID", notes = "关联数据的ID")
   @TableField("data_id")
   @Column(name = "data_id", columnDefinition = "bigint  COMMENT '关联数据的ID'", nullable = true)
   private Long dataId;
   @ApiModelProperty(name = "moduleType", value = "例:1  枚举ModuleTypeEnum", notes = "例:1  枚举ModuleTypeEnum")
   @TableField("module_type")
   @Column(name = "module_type", columnDefinition = "int  COMMENT '例:1  枚举ModuleTypeEnum'", nullable = true)
   private Integer moduleType;
   @ApiModelProperty(name = "functionType", value = "例:1  枚举FunctionTypeEnum", notes = "例:1  枚举FunctionTypeEnum")
   @TableField("function_type")
   @Column(name = "function_type", columnDefinition = "int  COMMENT '例:1  枚举FunctionTypeEnum'", nullable = true)
   private Integer functionType;
   @ApiModelProperty(name = "approveProcessType", value = "审批流程类型 ApproveProcessTypeEnumV2", notes = "审批流程类型 ApproveProcessTypeEnumV2ApproveProcessTypeEnumV2")
   @TableField("approve_process_type")
   @Column(name = "approve_process_type", columnDefinition = "int  COMMENT '审批流程类型 ApproveProcessTypeEnumV2'", nullable = true)
   private Integer approveProcessType;
   @ApiModelProperty(name = "approveVersionsId", value = "审核模版版本ID", notes = "审核模版版本ID")
   @TableField("approve_versions_id")
   @Column(name = "approve_versions_id", columnDefinition = "bigint  COMMENT '审核模版版本ID'", nullable = true)
   private Long approveVersionsId;
   @ApiModelProperty(name = "approveRecordSerialNumber", value = "审批日志编号", notes = "审批日志编号")
   @TableField("approve_record_serial_number")
   @Column(name = "approve_record_serial_number", columnDefinition = "varchar(30)  COMMENT '审批日志编号'", nullable = true)
   private String approveRecordSerialNumber;
   @ApiModelProperty(name = "flowId", value = "流程ID", notes = "流程ID")
   @TableField("flow_id")
   @Column(name = "flow_id", columnDefinition = "bigint  COMMENT '流程ID'", nullable = true)
   private Long flowId;
   @ApiModelProperty(
      name = "flowType",
      value = "流程类型  1会签 2或签  3单签 4抄送 5发起申请 6质检 ApproveTemplateVersionsFlowEnum",
      notes = "流程类型  1会签 2或签  3单签 4抄送 5发起申请 6质检 ApproveTemplateVersionsFlowEnum"
   )
   @TableField("flow_type")
   @Column(name = "flow_type", columnDefinition = "int  COMMENT '流程类型  1会签 2或签  3单签 4抄送 5发起申请 6质检 ApproveTemplateVersionsFlowEnum'", nullable = true)
   private Integer flowType;
   @ApiModelProperty(name = "checkUserId", value = "审批人ID", notes = "审批人ID")
   @TableField("check_user_id")
   @Column(name = "check_user_id", columnDefinition = "bigint  COMMENT '审批人ID'", nullable = true)
   private Long checkUserId;
   @ApiModelProperty(name = "arrivalTime", value = "到达时间 流转到该节点的时间", notes = "到达时间 流转到该节点的时间")
   @TableField("arrival_time")
   @Column(name = "arrival_time", columnDefinition = "datetime  COMMENT '到达时间 流转到该节点的时间'", nullable = true)
   private LocalDateTime arrivalTime;
   @ApiModelProperty(name = "approveTime", value = "审批时间", notes = "审批时间")
   @TableField("approve_time")
   @Column(name = "approve_time", columnDefinition = "datetime  COMMENT '审批时间'", nullable = true)
   private LocalDateTime approveTime;
   @ApiModelProperty(name = "decision", value = "决策  1待决策  2通过 4 不通过 驳回 8撤销 CheckStatusEnum", notes = "决策  1待决策  2通过 4 不通过 驳回 8撤销 CheckStatusEnum")
   @TableField("decision")
   @Column(name = "decision", columnDefinition = "int default '1' COMMENT '决策  1待决策  2通过 4 不通过 驳回 8撤销 CheckStatusEnum'", nullable = true)
   private Integer decision;
   @ApiModelProperty(name = "opinion", value = "意见", notes = "意见")
   @TableField("opinion")
   @Column(name = "opinion", columnDefinition = "varchar(500)  COMMENT '意见'", nullable = true)
   private String opinion;
   @ApiModelProperty(name = "status", value = "状态 0未开始 1进行中  2结束 默认0 ApproveRecordStatusEnum", notes = "状态 0未开始 1进行中  2结束 默认0 ApproveRecordStatusEnum")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int default '0' COMMENT '状态 0未开始 1进行中  2结束 默认0 ApproveRecordStatusEnum'", nullable = true)
   private Integer status;
   @ApiModelProperty(name = "jsonData", value = "json数据", notes = "json数据")
   @TableField("json_data")
   @Column(name = "json_data", columnDefinition = "mediumtext  COMMENT 'json数据'", nullable = true)
   private String jsonData;
   @ApiModelProperty(name = "approveSource", value = "审批来源 1系统 ApproveSourceEnum", notes = "审批来源 1系统 ApproveSourceEnum")
   @TableField("approve_source")
   @Column(name = "approve_source", columnDefinition = "int default '1' COMMENT '审批来源 1系统 ApproveSourceEnum'", nullable = true)
   private Integer approveSource;
   @ApiModelProperty(name = "sourceDetailId", value = "来源明细ID 当数据来源不为系统的时候记录来源明细ID", notes = "来源明细ID 当数据来源不为系统的时候记录来源明细ID")
   @TableField("source_detail_id")
   @Column(name = "source_detail_id", columnDefinition = "int COMMENT '来源明细ID 当数据来源不为系统的时候记录来源明细ID'", nullable = true)
   private Long sourceDetailId;
   @ApiModelProperty(name = "sourceId", value = "来源ID 来源主表ID", notes = "来源ID 来源主表ID")
   @TableField("source_id")
   @Column(name = "source_id", columnDefinition = "int COMMENT '来源ID 来源主表ID'", nullable = true)
   private Long sourceId;
   @ApiModelProperty(name = "sourceSerialNumber", value = "来源编号 来源主表编号", notes = "来源编号 来源主表编号")
   @TableField("source_serial_number")
   @Column(name = "source_serial_number", columnDefinition = "int COMMENT '来源编号 来源主表编号'", nullable = true)
   private Long sourceSerialNumber;
   @ApiModelProperty(name = "requestId", value = "提交OA审批流成功返回的ID", notes = "提交OA审批流成功返回的ID")
   @TableField("request_id")
   @Column(name = "request_id", columnDefinition = "varchar(20) COMMENT '提交OA审批流成功返回的ID'")
   private String requestId;

   public static WmsApproveRecordDetail.WmsApproveRecordDetailBuilder builder() {
      return new WmsApproveRecordDetail.WmsApproveRecordDetailBuilder();
   }

   public WmsApproveRecordDetail() {
   }

   public WmsApproveRecordDetail(
      final Long id,
      final Long dataId,
      final Integer moduleType,
      final Integer functionType,
      final Integer approveProcessType,
      final Long approveVersionsId,
      final String approveRecordSerialNumber,
      final Long flowId,
      final Integer flowType,
      final Long checkUserId,
      final LocalDateTime arrivalTime,
      final LocalDateTime approveTime,
      final Integer decision,
      final String opinion,
      final Integer status,
      final String jsonData,
      final Integer approveSource,
      final Long sourceDetailId,
      final Long sourceId,
      final Long sourceSerialNumber,
      final String requestId
   ) {
      this.id = id;
      this.dataId = dataId;
      this.moduleType = moduleType;
      this.functionType = functionType;
      this.approveProcessType = approveProcessType;
      this.approveVersionsId = approveVersionsId;
      this.approveRecordSerialNumber = approveRecordSerialNumber;
      this.flowId = flowId;
      this.flowType = flowType;
      this.checkUserId = checkUserId;
      this.arrivalTime = arrivalTime;
      this.approveTime = approveTime;
      this.decision = decision;
      this.opinion = opinion;
      this.status = status;
      this.jsonData = jsonData;
      this.approveSource = approveSource;
      this.sourceDetailId = sourceDetailId;
      this.sourceId = sourceId;
      this.sourceSerialNumber = sourceSerialNumber;
      this.requestId = requestId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public Integer getModuleType() {
      return this.moduleType;
   }

   public Integer getFunctionType() {
      return this.functionType;
   }

   public Integer getApproveProcessType() {
      return this.approveProcessType;
   }

   public Long getApproveVersionsId() {
      return this.approveVersionsId;
   }

   public String getApproveRecordSerialNumber() {
      return this.approveRecordSerialNumber;
   }

   public Long getFlowId() {
      return this.flowId;
   }

   public Integer getFlowType() {
      return this.flowType;
   }

   public Long getCheckUserId() {
      return this.checkUserId;
   }

   public LocalDateTime getArrivalTime() {
      return this.arrivalTime;
   }

   public LocalDateTime getApproveTime() {
      return this.approveTime;
   }

   public Integer getDecision() {
      return this.decision;
   }

   public String getOpinion() {
      return this.opinion;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getJsonData() {
      return this.jsonData;
   }

   public Integer getApproveSource() {
      return this.approveSource;
   }

   public Long getSourceDetailId() {
      return this.sourceDetailId;
   }

   public Long getSourceId() {
      return this.sourceId;
   }

   public Long getSourceSerialNumber() {
      return this.sourceSerialNumber;
   }

   public String getRequestId() {
      return this.requestId;
   }

   public WmsApproveRecordDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsApproveRecordDetail setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   public WmsApproveRecordDetail setModuleType(final Integer moduleType) {
      this.moduleType = moduleType;
      return this;
   }

   public WmsApproveRecordDetail setFunctionType(final Integer functionType) {
      this.functionType = functionType;
      return this;
   }

   public WmsApproveRecordDetail setApproveProcessType(final Integer approveProcessType) {
      this.approveProcessType = approveProcessType;
      return this;
   }

   public WmsApproveRecordDetail setApproveVersionsId(final Long approveVersionsId) {
      this.approveVersionsId = approveVersionsId;
      return this;
   }

   public WmsApproveRecordDetail setApproveRecordSerialNumber(final String approveRecordSerialNumber) {
      this.approveRecordSerialNumber = approveRecordSerialNumber;
      return this;
   }

   public WmsApproveRecordDetail setFlowId(final Long flowId) {
      this.flowId = flowId;
      return this;
   }

   public WmsApproveRecordDetail setFlowType(final Integer flowType) {
      this.flowType = flowType;
      return this;
   }

   public WmsApproveRecordDetail setCheckUserId(final Long checkUserId) {
      this.checkUserId = checkUserId;
      return this;
   }

   public WmsApproveRecordDetail setArrivalTime(final LocalDateTime arrivalTime) {
      this.arrivalTime = arrivalTime;
      return this;
   }

   public WmsApproveRecordDetail setApproveTime(final LocalDateTime approveTime) {
      this.approveTime = approveTime;
      return this;
   }

   public WmsApproveRecordDetail setDecision(final Integer decision) {
      this.decision = decision;
      return this;
   }

   public WmsApproveRecordDetail setOpinion(final String opinion) {
      this.opinion = opinion;
      return this;
   }

   public WmsApproveRecordDetail setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public WmsApproveRecordDetail setJsonData(final String jsonData) {
      this.jsonData = jsonData;
      return this;
   }

   public WmsApproveRecordDetail setApproveSource(final Integer approveSource) {
      this.approveSource = approveSource;
      return this;
   }

   public WmsApproveRecordDetail setSourceDetailId(final Long sourceDetailId) {
      this.sourceDetailId = sourceDetailId;
      return this;
   }

   public WmsApproveRecordDetail setSourceId(final Long sourceId) {
      this.sourceId = sourceId;
      return this;
   }

   public WmsApproveRecordDetail setSourceSerialNumber(final Long sourceSerialNumber) {
      this.sourceSerialNumber = sourceSerialNumber;
      return this;
   }

   public WmsApproveRecordDetail setRequestId(final String requestId) {
      this.requestId = requestId;
      return this;
   }

   @Override
   public String toString() {
      return "WmsApproveRecordDetail(id="
         + this.getId()
         + ", dataId="
         + this.getDataId()
         + ", moduleType="
         + this.getModuleType()
         + ", functionType="
         + this.getFunctionType()
         + ", approveProcessType="
         + this.getApproveProcessType()
         + ", approveVersionsId="
         + this.getApproveVersionsId()
         + ", approveRecordSerialNumber="
         + this.getApproveRecordSerialNumber()
         + ", flowId="
         + this.getFlowId()
         + ", flowType="
         + this.getFlowType()
         + ", checkUserId="
         + this.getCheckUserId()
         + ", arrivalTime="
         + this.getArrivalTime()
         + ", approveTime="
         + this.getApproveTime()
         + ", decision="
         + this.getDecision()
         + ", opinion="
         + this.getOpinion()
         + ", status="
         + this.getStatus()
         + ", jsonData="
         + this.getJsonData()
         + ", approveSource="
         + this.getApproveSource()
         + ", sourceDetailId="
         + this.getSourceDetailId()
         + ", sourceId="
         + this.getSourceId()
         + ", sourceSerialNumber="
         + this.getSourceSerialNumber()
         + ", requestId="
         + this.getRequestId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveRecordDetail)) {
         return false;
      }

      WmsApproveRecordDetail other = (WmsApproveRecordDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$dataId = this.getDataId();
         Object other$dataId = other.getDataId();
         if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
            Object this$moduleType = this.getModuleType();
            Object other$moduleType = other.getModuleType();
            if (this$moduleType == null ? other$moduleType == null : this$moduleType.equals(other$moduleType)) {
               Object this$functionType = this.getFunctionType();
               Object other$functionType = other.getFunctionType();
               if (this$functionType == null ? other$functionType == null : this$functionType.equals(other$functionType)) {
                  Object this$approveProcessType = this.getApproveProcessType();
                  Object other$approveProcessType = other.getApproveProcessType();
                  if (this$approveProcessType == null ? other$approveProcessType == null : this$approveProcessType.equals(other$approveProcessType)) {
                     Object this$approveVersionsId = this.getApproveVersionsId();
                     Object other$approveVersionsId = other.getApproveVersionsId();
                     if (this$approveVersionsId == null ? other$approveVersionsId == null : this$approveVersionsId.equals(other$approveVersionsId)) {
                        Object this$flowId = this.getFlowId();
                        Object other$flowId = other.getFlowId();
                        if (this$flowId == null ? other$flowId == null : this$flowId.equals(other$flowId)) {
                           Object this$flowType = this.getFlowType();
                           Object other$flowType = other.getFlowType();
                           if (this$flowType == null ? other$flowType == null : this$flowType.equals(other$flowType)) {
                              Object this$checkUserId = this.getCheckUserId();
                              Object other$checkUserId = other.getCheckUserId();
                              if (this$checkUserId == null ? other$checkUserId == null : this$checkUserId.equals(other$checkUserId)) {
                                 Object this$decision = this.getDecision();
                                 Object other$decision = other.getDecision();
                                 if (this$decision == null ? other$decision == null : this$decision.equals(other$decision)) {
                                    Object this$status = this.getStatus();
                                    Object other$status = other.getStatus();
                                    if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                       Object this$approveSource = this.getApproveSource();
                                       Object other$approveSource = other.getApproveSource();
                                       if (this$approveSource == null ? other$approveSource == null : this$approveSource.equals(other$approveSource)) {
                                          Object this$sourceDetailId = this.getSourceDetailId();
                                          Object other$sourceDetailId = other.getSourceDetailId();
                                          if (this$sourceDetailId == null ? other$sourceDetailId == null : this$sourceDetailId.equals(other$sourceDetailId)) {
                                             Object this$sourceId = this.getSourceId();
                                             Object other$sourceId = other.getSourceId();
                                             if (this$sourceId == null ? other$sourceId == null : this$sourceId.equals(other$sourceId)) {
                                                Object this$sourceSerialNumber = this.getSourceSerialNumber();
                                                Object other$sourceSerialNumber = other.getSourceSerialNumber();
                                                if (this$sourceSerialNumber == null
                                                   ? other$sourceSerialNumber == null
                                                   : this$sourceSerialNumber.equals(other$sourceSerialNumber)) {
                                                   Object this$approveRecordSerialNumber = this.getApproveRecordSerialNumber();
                                                   Object other$approveRecordSerialNumber = other.getApproveRecordSerialNumber();
                                                   if (this$approveRecordSerialNumber == null
                                                      ? other$approveRecordSerialNumber == null
                                                      : this$approveRecordSerialNumber.equals(other$approveRecordSerialNumber)) {
                                                      Object this$arrivalTime = this.getArrivalTime();
                                                      Object other$arrivalTime = other.getArrivalTime();
                                                      if (this$arrivalTime == null ? other$arrivalTime == null : this$arrivalTime.equals(other$arrivalTime)) {
                                                         Object this$approveTime = this.getApproveTime();
                                                         Object other$approveTime = other.getApproveTime();
                                                         if (this$approveTime == null ? other$approveTime == null : this$approveTime.equals(other$approveTime)) {
                                                            Object this$opinion = this.getOpinion();
                                                            Object other$opinion = other.getOpinion();
                                                            if (this$opinion == null ? other$opinion == null : this$opinion.equals(other$opinion)) {
                                                               Object this$jsonData = this.getJsonData();
                                                               Object other$jsonData = other.getJsonData();
                                                               if (this$jsonData == null ? other$jsonData == null : this$jsonData.equals(other$jsonData)) {
                                                                  Object this$requestId = this.getRequestId();
                                                                  Object other$requestId = other.getRequestId();
                                                                  return this$requestId == null
                                                                     ? other$requestId == null
                                                                     : this$requestId.equals(other$requestId);
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
      return other instanceof WmsApproveRecordDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $moduleType = this.getModuleType();
      result = result * 59 + ($moduleType == null ? 43 : $moduleType.hashCode());
      Object $functionType = this.getFunctionType();
      result = result * 59 + ($functionType == null ? 43 : $functionType.hashCode());
      Object $approveProcessType = this.getApproveProcessType();
      result = result * 59 + ($approveProcessType == null ? 43 : $approveProcessType.hashCode());
      Object $approveVersionsId = this.getApproveVersionsId();
      result = result * 59 + ($approveVersionsId == null ? 43 : $approveVersionsId.hashCode());
      Object $flowId = this.getFlowId();
      result = result * 59 + ($flowId == null ? 43 : $flowId.hashCode());
      Object $flowType = this.getFlowType();
      result = result * 59 + ($flowType == null ? 43 : $flowType.hashCode());
      Object $checkUserId = this.getCheckUserId();
      result = result * 59 + ($checkUserId == null ? 43 : $checkUserId.hashCode());
      Object $decision = this.getDecision();
      result = result * 59 + ($decision == null ? 43 : $decision.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $approveSource = this.getApproveSource();
      result = result * 59 + ($approveSource == null ? 43 : $approveSource.hashCode());
      Object $sourceDetailId = this.getSourceDetailId();
      result = result * 59 + ($sourceDetailId == null ? 43 : $sourceDetailId.hashCode());
      Object $sourceId = this.getSourceId();
      result = result * 59 + ($sourceId == null ? 43 : $sourceId.hashCode());
      Object $sourceSerialNumber = this.getSourceSerialNumber();
      result = result * 59 + ($sourceSerialNumber == null ? 43 : $sourceSerialNumber.hashCode());
      Object $approveRecordSerialNumber = this.getApproveRecordSerialNumber();
      result = result * 59 + ($approveRecordSerialNumber == null ? 43 : $approveRecordSerialNumber.hashCode());
      Object $arrivalTime = this.getArrivalTime();
      result = result * 59 + ($arrivalTime == null ? 43 : $arrivalTime.hashCode());
      Object $approveTime = this.getApproveTime();
      result = result * 59 + ($approveTime == null ? 43 : $approveTime.hashCode());
      Object $opinion = this.getOpinion();
      result = result * 59 + ($opinion == null ? 43 : $opinion.hashCode());
      Object $jsonData = this.getJsonData();
      result = result * 59 + ($jsonData == null ? 43 : $jsonData.hashCode());
      Object $requestId = this.getRequestId();
      return result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
   }

   public static class WmsApproveRecordDetailBuilder {
      private Long id;
      private Long dataId;
      private Integer moduleType;
      private Integer functionType;
      private Integer approveProcessType;
      private Long approveVersionsId;
      private String approveRecordSerialNumber;
      private Long flowId;
      private Integer flowType;
      private Long checkUserId;
      private LocalDateTime arrivalTime;
      private LocalDateTime approveTime;
      private Integer decision;
      private String opinion;
      private Integer status;
      private String jsonData;
      private Integer approveSource;
      private Long sourceDetailId;
      private Long sourceId;
      private Long sourceSerialNumber;
      private String requestId;

      WmsApproveRecordDetailBuilder() {
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder moduleType(final Integer moduleType) {
         this.moduleType = moduleType;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder functionType(final Integer functionType) {
         this.functionType = functionType;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder approveProcessType(final Integer approveProcessType) {
         this.approveProcessType = approveProcessType;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder approveVersionsId(final Long approveVersionsId) {
         this.approveVersionsId = approveVersionsId;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder approveRecordSerialNumber(final String approveRecordSerialNumber) {
         this.approveRecordSerialNumber = approveRecordSerialNumber;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder flowId(final Long flowId) {
         this.flowId = flowId;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder flowType(final Integer flowType) {
         this.flowType = flowType;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder checkUserId(final Long checkUserId) {
         this.checkUserId = checkUserId;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder arrivalTime(final LocalDateTime arrivalTime) {
         this.arrivalTime = arrivalTime;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder approveTime(final LocalDateTime approveTime) {
         this.approveTime = approveTime;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder decision(final Integer decision) {
         this.decision = decision;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder opinion(final String opinion) {
         this.opinion = opinion;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder jsonData(final String jsonData) {
         this.jsonData = jsonData;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder approveSource(final Integer approveSource) {
         this.approveSource = approveSource;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder sourceDetailId(final Long sourceDetailId) {
         this.sourceDetailId = sourceDetailId;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder sourceId(final Long sourceId) {
         this.sourceId = sourceId;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder sourceSerialNumber(final Long sourceSerialNumber) {
         this.sourceSerialNumber = sourceSerialNumber;
         return this;
      }

      public WmsApproveRecordDetail.WmsApproveRecordDetailBuilder requestId(final String requestId) {
         this.requestId = requestId;
         return this;
      }

      public WmsApproveRecordDetail build() {
         return new WmsApproveRecordDetail(
            this.id,
            this.dataId,
            this.moduleType,
            this.functionType,
            this.approveProcessType,
            this.approveVersionsId,
            this.approveRecordSerialNumber,
            this.flowId,
            this.flowType,
            this.checkUserId,
            this.arrivalTime,
            this.approveTime,
            this.decision,
            this.opinion,
            this.status,
            this.jsonData,
            this.approveSource,
            this.sourceDetailId,
            this.sourceId,
            this.sourceSerialNumber,
            this.requestId
         );
      }

      @Override
      public String toString() {
         return "WmsApproveRecordDetail.WmsApproveRecordDetailBuilder(id="
            + this.id
            + ", dataId="
            + this.dataId
            + ", moduleType="
            + this.moduleType
            + ", functionType="
            + this.functionType
            + ", approveProcessType="
            + this.approveProcessType
            + ", approveVersionsId="
            + this.approveVersionsId
            + ", approveRecordSerialNumber="
            + this.approveRecordSerialNumber
            + ", flowId="
            + this.flowId
            + ", flowType="
            + this.flowType
            + ", checkUserId="
            + this.checkUserId
            + ", arrivalTime="
            + this.arrivalTime
            + ", approveTime="
            + this.approveTime
            + ", decision="
            + this.decision
            + ", opinion="
            + this.opinion
            + ", status="
            + this.status
            + ", jsonData="
            + this.jsonData
            + ", approveSource="
            + this.approveSource
            + ", sourceDetailId="
            + this.sourceDetailId
            + ", sourceId="
            + this.sourceId
            + ", sourceSerialNumber="
            + this.sourceSerialNumber
            + ", requestId="
            + this.requestId
            + ")";
      }
   }
}
