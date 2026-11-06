package com.hzchum.scim.common.core.api.pojo._do;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "WmsApproveRecord对象", description = "审批日志主表")
@Entity
@TableName("wms_approve_record")
@Table(name = "wms_approve_record", indexes = {@Index(name = "serial_number", columnList = "serial_number"), @Index(name = "data_id", columnList = "data_id")})
@org.hibernate.annotations.Table(appliesTo = "wms_approve_record", comment = "审批日志主表")
public class WmsApproveRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "approveVersionsId", value = "审批主模板版本ID", notes = "审批主模板版本ID")
   @TableField("approve_versions_id")
   @Column(name = "approve_versions_id", columnDefinition = "bigint  COMMENT '审批主模板版本ID'", nullable = true)
   private Long approveVersionsId;
   @ApiModelProperty(name = "moduleType", value = "例:1  枚举ModuleTypeEnum", notes = "例:1  枚举ModuleTypeEnum")
   @TableField("module_type")
   @Column(name = "module_type", columnDefinition = "int  COMMENT '例:1  枚举ModuleTypeEnum'", nullable = true)
   private Integer moduleType;
   @ApiModelProperty(name = "functionType", value = "枚举 FunctionTypeEnum", notes = "枚举 FunctionTypeEnum")
   @TableField("function_type")
   @Column(name = "function_type", columnDefinition = "int  COMMENT '枚举 FunctionTypeEnum'", nullable = true)
   private Integer functionType;
   @ApiModelProperty(name = "approveProcessType", value = "审批流程类型 ApproveProcessTypeEnumV2", notes = "审批流程类型 ApproveProcessTypeEnumV2ApproveProcessTypeEnumV2")
   @TableField("approve_process_type")
   @Column(name = "approve_process_type", columnDefinition = "int  COMMENT '审批流程类型 ApproveProcessTypeEnumV2'", nullable = true)
   private Integer approveProcessType;
   @ApiModelProperty(name = "dataId", value = "数据ID", notes = "数据ID")
   @TableField("data_id")
   @Column(name = "data_id", columnDefinition = "bigint  COMMENT '数据ID'", nullable = true)
   private Long dataId;
   @ApiModelProperty(name = "dataSerialNumber", value = "数据编号", notes = "数据编号")
   @TableField("data_serial_number")
   @Column(name = "data_serial_number", columnDefinition = "varchar(100)  COMMENT '数据编号'", nullable = true)
   private String dataSerialNumber;
   @ApiModelProperty(name = "serialNumber", value = "审批日志编号", notes = "审批日志编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(30)  COMMENT '审批日志编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "startTime", value = "发起时间", notes = "发起时间")
   @TableField("start_time")
   @Column(name = "start_time", columnDefinition = "datetime  COMMENT '发起时间'", nullable = true)
   private LocalDateTime startTime;
   @ApiModelProperty(name = "endTime", value = "结束时间", notes = "结束时间")
   @TableField("end_time")
   @Column(name = "end_time", columnDefinition = "datetime  COMMENT '结束时间'", nullable = true)
   private LocalDateTime endTime;
   @ApiModelProperty(name = "applicantId", value = "发起人id", notes = "发起人id")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '发起人id'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "departmentId", value = "发起人部门", notes = "发起人部门")
   @TableField("department_id")
   @Column(name = "department_id", columnDefinition = "bigint  COMMENT '发起人部门'", nullable = true)
   private Long departmentId;
   @ApiModelProperty(name = "cause", value = "发起原因", notes = "发起原因")
   @TableField("cause")
   @Column(name = "cause", columnDefinition = "varchar(500)  COMMENT '发起原因'", nullable = true)
   private String cause;
   @ApiModelProperty(name = "status", value = "发起状态 1开始  2结束 ApproveRecordStatusEnum", notes = "发起状态 1开始  2结束 ApproveRecordStatusEnum")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint  COMMENT '发起状态 1开始  2结束 ApproveRecordStatusEnum'", nullable = true)
   private Integer status;
   @ApiModelProperty(
      name = "reviewStatus",
      value = "2审核通过  4审核退回 8撤销 16审核中 32意外中断 ReviewStatusEnum 默认16 审核中",
      notes = "2审核通过  4审核退回 8撤销 16审核中 ReviewStatusEnum 默认16 审核中"
   )
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int default '16' COMMENT '2审核通过  4审核退回 8撤销 16审核中 ReviewStatusEnum 默认16 审核中'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "lastDetailId", value = "最后操作的明细ID", notes = "最后操作的明细ID")
   @TableField("last_detail_id")
   @Column(name = "last_detail_id", columnDefinition = "bigint  COMMENT '最后操作的明细ID'", nullable = true)
   private Long lastDetailId;
   @ApiModelProperty(name = "lastApproverId", value = "最后审批人的ID 每次有人审批都进行更新", notes = "最后审批人的ID 每次有人审批都进行更新")
   @TableField("last_approver_id")
   @Column(name = "last_approver_id", columnDefinition = "bigint  COMMENT '最后审批人的ID 每次有人审批都进行更新'", nullable = true)
   private Long lastApproverId;
   @ApiModelProperty(name = "lastApprovalTime", value = "最后审批时间", notes = "最后审批时间")
   @TableField("last_approval_time")
   @Column(name = "last_approval_time", columnDefinition = "datetime  COMMENT '最后审批时间'", nullable = true)
   private LocalDateTime lastApprovalTime;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(500)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "jsonData", value = "json数据", notes = "json数据")
   @TableField("json_data")
   @Column(name = "json_data", columnDefinition = "mediumtext  COMMENT 'json数据'", nullable = true)
   private String jsonData;
   @ApiModelProperty(name = "boolRewrite", value = "是否可以重写 默认不可以重写", notes = "是否可以重写 默认不可以重写")
   @TableField("bool_rewrite")
   @Column(name = "bool_rewrite", columnDefinition = "tinyint(1) default '0' COMMENT '是否可以重写 默认不可以重写'", nullable = true)
   private Boolean boolRewrite;
   @ApiModelProperty(name = "componentName", value = "跳转路径名称", notes = "跳转路径名称")
   @TableField("component_name")
   @Column(name = "component_name", columnDefinition = "varchar(255) COMMENT '跳转路径名称'", nullable = true)
   private String componentName;
   @ApiModelProperty(name = "subjoinMsg", value = "附加信息", notes = "附加信息")
   @TableField("subjoin_msg")
   @Column(name = "subjoin_msg", columnDefinition = "varchar(500) COMMENT '附加信息'", nullable = true)
   private String subjoinMsg;
   @ApiModelProperty(name = "classifyOne", value = "分类一", notes = "分类一")
   @TableField("classify_one")
   @Column(name = "classify_one", columnDefinition = "varchar(255) COMMENT '分类一'", nullable = true)
   private String classifyOne;
   @ApiModelProperty(name = "approveSource", value = "审批来源 1系统 ApproveSourceEnum", notes = "审批来源 1系统 ApproveSourceEnum")
   @TableField("approve_source")
   @Column(name = "approve_source", columnDefinition = "int default '1' COMMENT '审批来源 1系统 ApproveSourceEnum'", nullable = true)
   private Integer approveSource;
   @ApiModelProperty(name = "sourceId", value = "来源ID 当数据来源不为系统的时候记录来源的数据ID", notes = "来源ID 当数据来源不为系统的时候记录来源的数据ID")
   @TableField("source_id")
   @Column(name = "source_id", columnDefinition = "int COMMENT '来源ID 当数据来源不为系统的时候记录来源的数据ID'", nullable = true)
   private Long sourceId;
   @ApiModelProperty(name = "sourceSerialNumber", value = "来源编号 当数据来源不为系统的时候记录来源的数据编号", notes = "来源编号 当数据来源不为系统的时候记录来源的数据编号")
   @TableField("source_serial_number")
   @Column(name = "source_serial_number", columnDefinition = "int COMMENT '来源编号 当数据来源不为系统的时候记录来源的数据编号'", nullable = true)
   private Long sourceSerialNumber;
   @ApiModelProperty(name = "requestId", value = "提交OA审批流成功返回的ID", notes = "提交OA审批流成功返回的ID")
   @JsonProperty("requestId")
   @JSONField(name = "requestId")
   @TableField("request_id")
   @Column(name = "request_id", columnDefinition = "varchar(20) COMMENT '提交OA审批流成功返回的ID'")
   private String requestId;

   public static WmsApproveRecord.WmsApproveRecordBuilder builder() {
      return new WmsApproveRecord.WmsApproveRecordBuilder();
   }

   public WmsApproveRecord() {
   }

   public WmsApproveRecord(
      final Long id,
      final Long approveVersionsId,
      final Integer moduleType,
      final Integer functionType,
      final Integer approveProcessType,
      final Long dataId,
      final String dataSerialNumber,
      final String serialNumber,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final Long applicantId,
      final Long departmentId,
      final String cause,
      final Integer status,
      final Integer reviewStatus,
      final Long lastDetailId,
      final Long lastApproverId,
      final LocalDateTime lastApprovalTime,
      final String remark,
      final String jsonData,
      final Boolean boolRewrite,
      final String componentName,
      final String subjoinMsg,
      final String classifyOne,
      final Integer approveSource,
      final Long sourceId,
      final Long sourceSerialNumber,
      final String requestId
   ) {
      this.id = id;
      this.approveVersionsId = approveVersionsId;
      this.moduleType = moduleType;
      this.functionType = functionType;
      this.approveProcessType = approveProcessType;
      this.dataId = dataId;
      this.dataSerialNumber = dataSerialNumber;
      this.serialNumber = serialNumber;
      this.startTime = startTime;
      this.endTime = endTime;
      this.applicantId = applicantId;
      this.departmentId = departmentId;
      this.cause = cause;
      this.status = status;
      this.reviewStatus = reviewStatus;
      this.lastDetailId = lastDetailId;
      this.lastApproverId = lastApproverId;
      this.lastApprovalTime = lastApprovalTime;
      this.remark = remark;
      this.jsonData = jsonData;
      this.boolRewrite = boolRewrite;
      this.componentName = componentName;
      this.subjoinMsg = subjoinMsg;
      this.classifyOne = classifyOne;
      this.approveSource = approveSource;
      this.sourceId = sourceId;
      this.sourceSerialNumber = sourceSerialNumber;
      this.requestId = requestId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getApproveVersionsId() {
      return this.approveVersionsId;
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

   public Long getDataId() {
      return this.dataId;
   }

   public String getDataSerialNumber() {
      return this.dataSerialNumber;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getCause() {
      return this.cause;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Long getLastDetailId() {
      return this.lastDetailId;
   }

   public Long getLastApproverId() {
      return this.lastApproverId;
   }

   public LocalDateTime getLastApprovalTime() {
      return this.lastApprovalTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getJsonData() {
      return this.jsonData;
   }

   public Boolean getBoolRewrite() {
      return this.boolRewrite;
   }

   public String getComponentName() {
      return this.componentName;
   }

   public String getSubjoinMsg() {
      return this.subjoinMsg;
   }

   public String getClassifyOne() {
      return this.classifyOne;
   }

   public Integer getApproveSource() {
      return this.approveSource;
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

   public WmsApproveRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public WmsApproveRecord setApproveVersionsId(final Long approveVersionsId) {
      this.approveVersionsId = approveVersionsId;
      return this;
   }

   public WmsApproveRecord setModuleType(final Integer moduleType) {
      this.moduleType = moduleType;
      return this;
   }

   public WmsApproveRecord setFunctionType(final Integer functionType) {
      this.functionType = functionType;
      return this;
   }

   public WmsApproveRecord setApproveProcessType(final Integer approveProcessType) {
      this.approveProcessType = approveProcessType;
      return this;
   }

   public WmsApproveRecord setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   public WmsApproveRecord setDataSerialNumber(final String dataSerialNumber) {
      this.dataSerialNumber = dataSerialNumber;
      return this;
   }

   public WmsApproveRecord setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public WmsApproveRecord setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
      return this;
   }

   public WmsApproveRecord setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
      return this;
   }

   public WmsApproveRecord setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   public WmsApproveRecord setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   public WmsApproveRecord setCause(final String cause) {
      this.cause = cause;
      return this;
   }

   public WmsApproveRecord setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public WmsApproveRecord setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   public WmsApproveRecord setLastDetailId(final Long lastDetailId) {
      this.lastDetailId = lastDetailId;
      return this;
   }

   public WmsApproveRecord setLastApproverId(final Long lastApproverId) {
      this.lastApproverId = lastApproverId;
      return this;
   }

   public WmsApproveRecord setLastApprovalTime(final LocalDateTime lastApprovalTime) {
      this.lastApprovalTime = lastApprovalTime;
      return this;
   }

   public WmsApproveRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public WmsApproveRecord setJsonData(final String jsonData) {
      this.jsonData = jsonData;
      return this;
   }

   public WmsApproveRecord setBoolRewrite(final Boolean boolRewrite) {
      this.boolRewrite = boolRewrite;
      return this;
   }

   public WmsApproveRecord setComponentName(final String componentName) {
      this.componentName = componentName;
      return this;
   }

   public WmsApproveRecord setSubjoinMsg(final String subjoinMsg) {
      this.subjoinMsg = subjoinMsg;
      return this;
   }

   public WmsApproveRecord setClassifyOne(final String classifyOne) {
      this.classifyOne = classifyOne;
      return this;
   }

   public WmsApproveRecord setApproveSource(final Integer approveSource) {
      this.approveSource = approveSource;
      return this;
   }

   public WmsApproveRecord setSourceId(final Long sourceId) {
      this.sourceId = sourceId;
      return this;
   }

   public WmsApproveRecord setSourceSerialNumber(final Long sourceSerialNumber) {
      this.sourceSerialNumber = sourceSerialNumber;
      return this;
   }

   @JsonProperty("requestId")
   public WmsApproveRecord setRequestId(final String requestId) {
      this.requestId = requestId;
      return this;
   }

   @Override
   public String toString() {
      return "WmsApproveRecord(id="
         + this.getId()
         + ", approveVersionsId="
         + this.getApproveVersionsId()
         + ", moduleType="
         + this.getModuleType()
         + ", functionType="
         + this.getFunctionType()
         + ", approveProcessType="
         + this.getApproveProcessType()
         + ", dataId="
         + this.getDataId()
         + ", dataSerialNumber="
         + this.getDataSerialNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", applicantId="
         + this.getApplicantId()
         + ", departmentId="
         + this.getDepartmentId()
         + ", cause="
         + this.getCause()
         + ", status="
         + this.getStatus()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", lastDetailId="
         + this.getLastDetailId()
         + ", lastApproverId="
         + this.getLastApproverId()
         + ", lastApprovalTime="
         + this.getLastApprovalTime()
         + ", remark="
         + this.getRemark()
         + ", jsonData="
         + this.getJsonData()
         + ", boolRewrite="
         + this.getBoolRewrite()
         + ", componentName="
         + this.getComponentName()
         + ", subjoinMsg="
         + this.getSubjoinMsg()
         + ", classifyOne="
         + this.getClassifyOne()
         + ", approveSource="
         + this.getApproveSource()
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

      if (!(o instanceof WmsApproveRecord)) {
         return false;
      }

      WmsApproveRecord other = (WmsApproveRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$approveVersionsId = this.getApproveVersionsId();
         Object other$approveVersionsId = other.getApproveVersionsId();
         if (this$approveVersionsId == null ? other$approveVersionsId == null : this$approveVersionsId.equals(other$approveVersionsId)) {
            Object this$moduleType = this.getModuleType();
            Object other$moduleType = other.getModuleType();
            if (this$moduleType == null ? other$moduleType == null : this$moduleType.equals(other$moduleType)) {
               Object this$functionType = this.getFunctionType();
               Object other$functionType = other.getFunctionType();
               if (this$functionType == null ? other$functionType == null : this$functionType.equals(other$functionType)) {
                  Object this$approveProcessType = this.getApproveProcessType();
                  Object other$approveProcessType = other.getApproveProcessType();
                  if (this$approveProcessType == null ? other$approveProcessType == null : this$approveProcessType.equals(other$approveProcessType)) {
                     Object this$dataId = this.getDataId();
                     Object other$dataId = other.getDataId();
                     if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
                        Object this$applicantId = this.getApplicantId();
                        Object other$applicantId = other.getApplicantId();
                        if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                           Object this$departmentId = this.getDepartmentId();
                           Object other$departmentId = other.getDepartmentId();
                           if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
                              Object this$status = this.getStatus();
                              Object other$status = other.getStatus();
                              if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                 Object this$reviewStatus = this.getReviewStatus();
                                 Object other$reviewStatus = other.getReviewStatus();
                                 if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                                    Object this$lastDetailId = this.getLastDetailId();
                                    Object other$lastDetailId = other.getLastDetailId();
                                    if (this$lastDetailId == null ? other$lastDetailId == null : this$lastDetailId.equals(other$lastDetailId)) {
                                       Object this$lastApproverId = this.getLastApproverId();
                                       Object other$lastApproverId = other.getLastApproverId();
                                       if (this$lastApproverId == null ? other$lastApproverId == null : this$lastApproverId.equals(other$lastApproverId)) {
                                          Object this$boolRewrite = this.getBoolRewrite();
                                          Object other$boolRewrite = other.getBoolRewrite();
                                          if (this$boolRewrite == null ? other$boolRewrite == null : this$boolRewrite.equals(other$boolRewrite)) {
                                             Object this$approveSource = this.getApproveSource();
                                             Object other$approveSource = other.getApproveSource();
                                             if (this$approveSource == null ? other$approveSource == null : this$approveSource.equals(other$approveSource)) {
                                                Object this$sourceId = this.getSourceId();
                                                Object other$sourceId = other.getSourceId();
                                                if (this$sourceId == null ? other$sourceId == null : this$sourceId.equals(other$sourceId)) {
                                                   Object this$sourceSerialNumber = this.getSourceSerialNumber();
                                                   Object other$sourceSerialNumber = other.getSourceSerialNumber();
                                                   if (this$sourceSerialNumber == null
                                                      ? other$sourceSerialNumber == null
                                                      : this$sourceSerialNumber.equals(other$sourceSerialNumber)) {
                                                      Object this$dataSerialNumber = this.getDataSerialNumber();
                                                      Object other$dataSerialNumber = other.getDataSerialNumber();
                                                      if (this$dataSerialNumber == null
                                                         ? other$dataSerialNumber == null
                                                         : this$dataSerialNumber.equals(other$dataSerialNumber)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$startTime = this.getStartTime();
                                                            Object other$startTime = other.getStartTime();
                                                            if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                                                               Object this$endTime = this.getEndTime();
                                                               Object other$endTime = other.getEndTime();
                                                               if (this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime)) {
                                                                  Object this$cause = this.getCause();
                                                                  Object other$cause = other.getCause();
                                                                  if (this$cause == null ? other$cause == null : this$cause.equals(other$cause)) {
                                                                     Object this$lastApprovalTime = this.getLastApprovalTime();
                                                                     Object other$lastApprovalTime = other.getLastApprovalTime();
                                                                     if (this$lastApprovalTime == null
                                                                        ? other$lastApprovalTime == null
                                                                        : this$lastApprovalTime.equals(other$lastApprovalTime)) {
                                                                        Object this$remark = this.getRemark();
                                                                        Object other$remark = other.getRemark();
                                                                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                           Object this$jsonData = this.getJsonData();
                                                                           Object other$jsonData = other.getJsonData();
                                                                           if (this$jsonData == null
                                                                              ? other$jsonData == null
                                                                              : this$jsonData.equals(other$jsonData)) {
                                                                              Object this$componentName = this.getComponentName();
                                                                              Object other$componentName = other.getComponentName();
                                                                              if (this$componentName == null
                                                                                 ? other$componentName == null
                                                                                 : this$componentName.equals(other$componentName)) {
                                                                                 Object this$subjoinMsg = this.getSubjoinMsg();
                                                                                 Object other$subjoinMsg = other.getSubjoinMsg();
                                                                                 if (this$subjoinMsg == null
                                                                                    ? other$subjoinMsg == null
                                                                                    : this$subjoinMsg.equals(other$subjoinMsg)) {
                                                                                    Object this$classifyOne = this.getClassifyOne();
                                                                                    Object other$classifyOne = other.getClassifyOne();
                                                                                    if (this$classifyOne == null
                                                                                       ? other$classifyOne == null
                                                                                       : this$classifyOne.equals(other$classifyOne)) {
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
      return other instanceof WmsApproveRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $approveVersionsId = this.getApproveVersionsId();
      result = result * 59 + ($approveVersionsId == null ? 43 : $approveVersionsId.hashCode());
      Object $moduleType = this.getModuleType();
      result = result * 59 + ($moduleType == null ? 43 : $moduleType.hashCode());
      Object $functionType = this.getFunctionType();
      result = result * 59 + ($functionType == null ? 43 : $functionType.hashCode());
      Object $approveProcessType = this.getApproveProcessType();
      result = result * 59 + ($approveProcessType == null ? 43 : $approveProcessType.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $lastDetailId = this.getLastDetailId();
      result = result * 59 + ($lastDetailId == null ? 43 : $lastDetailId.hashCode());
      Object $lastApproverId = this.getLastApproverId();
      result = result * 59 + ($lastApproverId == null ? 43 : $lastApproverId.hashCode());
      Object $boolRewrite = this.getBoolRewrite();
      result = result * 59 + ($boolRewrite == null ? 43 : $boolRewrite.hashCode());
      Object $approveSource = this.getApproveSource();
      result = result * 59 + ($approveSource == null ? 43 : $approveSource.hashCode());
      Object $sourceId = this.getSourceId();
      result = result * 59 + ($sourceId == null ? 43 : $sourceId.hashCode());
      Object $sourceSerialNumber = this.getSourceSerialNumber();
      result = result * 59 + ($sourceSerialNumber == null ? 43 : $sourceSerialNumber.hashCode());
      Object $dataSerialNumber = this.getDataSerialNumber();
      result = result * 59 + ($dataSerialNumber == null ? 43 : $dataSerialNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $cause = this.getCause();
      result = result * 59 + ($cause == null ? 43 : $cause.hashCode());
      Object $lastApprovalTime = this.getLastApprovalTime();
      result = result * 59 + ($lastApprovalTime == null ? 43 : $lastApprovalTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $jsonData = this.getJsonData();
      result = result * 59 + ($jsonData == null ? 43 : $jsonData.hashCode());
      Object $componentName = this.getComponentName();
      result = result * 59 + ($componentName == null ? 43 : $componentName.hashCode());
      Object $subjoinMsg = this.getSubjoinMsg();
      result = result * 59 + ($subjoinMsg == null ? 43 : $subjoinMsg.hashCode());
      Object $classifyOne = this.getClassifyOne();
      result = result * 59 + ($classifyOne == null ? 43 : $classifyOne.hashCode());
      Object $requestId = this.getRequestId();
      return result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
   }

   public static class WmsApproveRecordBuilder {
      private Long id;
      private Long approveVersionsId;
      private Integer moduleType;
      private Integer functionType;
      private Integer approveProcessType;
      private Long dataId;
      private String dataSerialNumber;
      private String serialNumber;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private Long applicantId;
      private Long departmentId;
      private String cause;
      private Integer status;
      private Integer reviewStatus;
      private Long lastDetailId;
      private Long lastApproverId;
      private LocalDateTime lastApprovalTime;
      private String remark;
      private String jsonData;
      private Boolean boolRewrite;
      private String componentName;
      private String subjoinMsg;
      private String classifyOne;
      private Integer approveSource;
      private Long sourceId;
      private Long sourceSerialNumber;
      private String requestId;

      WmsApproveRecordBuilder() {
      }

      public WmsApproveRecord.WmsApproveRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder approveVersionsId(final Long approveVersionsId) {
         this.approveVersionsId = approveVersionsId;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder moduleType(final Integer moduleType) {
         this.moduleType = moduleType;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder functionType(final Integer functionType) {
         this.functionType = functionType;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder approveProcessType(final Integer approveProcessType) {
         this.approveProcessType = approveProcessType;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder dataSerialNumber(final String dataSerialNumber) {
         this.dataSerialNumber = dataSerialNumber;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder cause(final String cause) {
         this.cause = cause;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder lastDetailId(final Long lastDetailId) {
         this.lastDetailId = lastDetailId;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder lastApproverId(final Long lastApproverId) {
         this.lastApproverId = lastApproverId;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder lastApprovalTime(final LocalDateTime lastApprovalTime) {
         this.lastApprovalTime = lastApprovalTime;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder jsonData(final String jsonData) {
         this.jsonData = jsonData;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder boolRewrite(final Boolean boolRewrite) {
         this.boolRewrite = boolRewrite;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder componentName(final String componentName) {
         this.componentName = componentName;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder subjoinMsg(final String subjoinMsg) {
         this.subjoinMsg = subjoinMsg;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder classifyOne(final String classifyOne) {
         this.classifyOne = classifyOne;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder approveSource(final Integer approveSource) {
         this.approveSource = approveSource;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder sourceId(final Long sourceId) {
         this.sourceId = sourceId;
         return this;
      }

      public WmsApproveRecord.WmsApproveRecordBuilder sourceSerialNumber(final Long sourceSerialNumber) {
         this.sourceSerialNumber = sourceSerialNumber;
         return this;
      }

      @JsonProperty("requestId")
      public WmsApproveRecord.WmsApproveRecordBuilder requestId(final String requestId) {
         this.requestId = requestId;
         return this;
      }

      public WmsApproveRecord build() {
         return new WmsApproveRecord(
            this.id,
            this.approveVersionsId,
            this.moduleType,
            this.functionType,
            this.approveProcessType,
            this.dataId,
            this.dataSerialNumber,
            this.serialNumber,
            this.startTime,
            this.endTime,
            this.applicantId,
            this.departmentId,
            this.cause,
            this.status,
            this.reviewStatus,
            this.lastDetailId,
            this.lastApproverId,
            this.lastApprovalTime,
            this.remark,
            this.jsonData,
            this.boolRewrite,
            this.componentName,
            this.subjoinMsg,
            this.classifyOne,
            this.approveSource,
            this.sourceId,
            this.sourceSerialNumber,
            this.requestId
         );
      }

      @Override
      public String toString() {
         return "WmsApproveRecord.WmsApproveRecordBuilder(id="
            + this.id
            + ", approveVersionsId="
            + this.approveVersionsId
            + ", moduleType="
            + this.moduleType
            + ", functionType="
            + this.functionType
            + ", approveProcessType="
            + this.approveProcessType
            + ", dataId="
            + this.dataId
            + ", dataSerialNumber="
            + this.dataSerialNumber
            + ", serialNumber="
            + this.serialNumber
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", applicantId="
            + this.applicantId
            + ", departmentId="
            + this.departmentId
            + ", cause="
            + this.cause
            + ", status="
            + this.status
            + ", reviewStatus="
            + this.reviewStatus
            + ", lastDetailId="
            + this.lastDetailId
            + ", lastApproverId="
            + this.lastApproverId
            + ", lastApprovalTime="
            + this.lastApprovalTime
            + ", remark="
            + this.remark
            + ", jsonData="
            + this.jsonData
            + ", boolRewrite="
            + this.boolRewrite
            + ", componentName="
            + this.componentName
            + ", subjoinMsg="
            + this.subjoinMsg
            + ", classifyOne="
            + this.classifyOne
            + ", approveSource="
            + this.approveSource
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
