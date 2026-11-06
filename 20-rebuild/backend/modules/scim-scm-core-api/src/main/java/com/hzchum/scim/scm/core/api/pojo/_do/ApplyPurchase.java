package com.hzchum.scim.scm.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ApplyPurchase对象", description = "申购单 ")
@Entity
@TableName("scm_apply_purchase")
@Table(name = "scm_apply_purchase")
public class ApplyPurchase extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "申购单编号", notes = "申购单编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '申购单编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "boolSysgen", value = "采购单编号是否为系统自动生成 默认为true", notes = "采购单编号是否为系统自动生成 默认为true")
   @JsonProperty("boolSysgen")
   @JSONField(name = "boolSysgen")
   @TableField("bool_sysgen")
   @Column(name = "bool_sysgen", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '采购单编号是否为系统自动生成 默认为true'", nullable = true)
   private Boolean boolSysgen;
   @ApiModelProperty(name = "serialNumberParent", value = "申购单父级编号 存储申购单父级编号 本身是父级时就存储本身编号", notes = "申购单父级编号 存储申购单父级编号 本身是父级时就存储本身编号")
   @JsonProperty("serialNumberParent")
   @JSONField(name = "serialNumberParent")
   @TableField("serial_number_parent")
   @Column(name = "serial_number_parent", columnDefinition = "varchar(255)  COMMENT '申购单父级编号 存储申购单父级编号 本身是父级时就存储本身编号'", nullable = true)
   private String serialNumberParent;
   @ApiModelProperty(name = "type", value = "申购类型 ApplyPurchaseTypeEnum", notes = "申购类型 ApplyPurchaseTypeEnum")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '申购类型 ApplyPurchaseTypeEnum'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "materialType", value = "材料类型 ApplyPurchaseMaterialTypeEnum", notes = "材料类型 ApplyPurchaseMaterialTypeEnum")
   @JsonProperty("materialType")
   @JSONField(name = "materialType")
   @TableField("material_type")
   @Column(name = "material_type", columnDefinition = "int(11)  COMMENT '材料类型 ApplyPurchaseMaterialTypeEnum'", nullable = true)
   private Integer materialType;
   @ApiModelProperty(name = "finishedProductType", value = "成品类型[1 结构制品,2 围护制品]", notes = "成品类型[1 结构制品,2 围护制品]")
   @JsonProperty("finishedProductType")
   @JSONField(name = "finishedProductType")
   @TableField("finished_product_type")
   @Column(name = "finished_product_type", columnDefinition = "int(11)  COMMENT '成品类型[1 结构制品,2 围护制品]'", nullable = true)
   private Integer finishedProductType;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "varchar(255)  COMMENT '项目ID'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "projectIds", value = "项目ID集合", notes = "项目ID集合")
   @JsonProperty("projectIds")
   @JSONField(name = "projectIds")
   @TableField("project_ids")
   @Column(name = "project_ids", columnDefinition = "varchar(255)  COMMENT '项目ID集合'", nullable = true)
   private String projectIds;
   @ApiModelProperty(name = "applicantName", value = "创建人名称", notes = "创建人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(255)  COMMENT '创建人名称'", nullable = true)
   private String applicantName;
   @ApiModelProperty(name = "applicantId", value = "创建人ID", notes = "创建人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint(20)  COMMENT '创建人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "departmentId", value = "创建人部门ID", notes = "创建人部门ID")
   @JsonProperty("departmentId")
   @JSONField(name = "departmentId")
   @TableField("department_id")
   @Column(name = "department_id", columnDefinition = "bigint   COMMENT '创建人部门ID'", nullable = true)
   private Long departmentId;
   @ApiModelProperty(name = "departmentName", value = "部门名称", notes = "部门名称")
   @JsonProperty("departmentName")
   @JSONField(name = "departmentName")
   @TableField("department_name")
   @Column(name = "department_name", columnDefinition = "varchar(100)  COMMENT '部门名称'", nullable = true)
   private String departmentName;
   @ApiModelProperty(name = "reviewStatus", value = "审核状态 ReviewStatusEnum", notes = "审核状态 ReviewStatusEnum")
   @JsonProperty("reviewStatus")
   @JSONField(name = "reviewStatus")
   @TableField("review_status")
   @Column(name = "review_status", columnDefinition = "int(11)  COMMENT '审核状态 1待审核 2审核通过  4审核退回  8撤销 16审核中 32作废 ReviewStatusEnum'", nullable = true)
   private Integer reviewStatus;
   @ApiModelProperty(name = "reviewTime", value = "审核时间", notes = "审核时间")
   @JsonProperty("reviewTime")
   @JSONField(name = "reviewTime")
   @TableField("review_time")
   @Column(name = "review_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime reviewTime;
   @ApiModelProperty(name = "reviewerIds", value = "审核人ID集", notes = "审核人ID集")
   @JsonProperty("reviewerIds")
   @JSONField(name = "reviewerIds")
   @TableField("reviewer_ids")
   @Column(name = "reviewer_ids", columnDefinition = "varchar(255)  COMMENT '审核人ID集'", nullable = true)
   private String reviewerIds;
   @ApiModelProperty(name = "userUpdateTime", value = "用户编辑时间", notes = "用户编辑时间")
   @JsonProperty("userUpdateTime")
   @JSONField(name = "userUpdateTime")
   @TableField("user_update_time")
   @Column(name = "user_update_time", columnDefinition = "datetime  COMMENT '用户编辑时间'", nullable = true)
   private LocalDateTime userUpdateTime;
   @ApiModelProperty(name = "editorId", value = "编辑人", notes = "编辑人")
   @JsonProperty("editorId")
   @JSONField(name = "editorId")
   @TableField("editor_id")
   @Column(name = "editor_id", columnDefinition = "bigint(20)  COMMENT '编辑人'", nullable = true)
   private Long editorId;
   @ApiModelProperty(name = "approveProcessId", value = "审批流程ID", notes = "审批流程ID")
   @JsonProperty("approveProcessId")
   @JSONField(name = "approveProcessId")
   @TableField("approve_process_id")
   @Column(name = "approve_process_id", columnDefinition = "bigint(20)  COMMENT '审批流程ID'", nullable = true)
   private Long approveProcessId;
   @ApiModelProperty(name = "editorName", value = "编辑人名称", notes = "编辑人名称")
   @JsonProperty("editorName")
   @JSONField(name = "editorName")
   @TableField("editor_name")
   @Column(name = "editor_name", columnDefinition = "varchar(255)  COMMENT '编辑人名称'", nullable = true)
   private String editorName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "enabled", value = "使用状态", notes = "使用状态")
   @JsonProperty("enabled")
   @JSONField(name = "enabled")
   @TableField("enabled")
   @Column(name = "enabled", columnDefinition = "tinyint(1) DEFAULT '1'  COMMENT '使用状态'", nullable = true)
   private Boolean enabled;
   @ApiModelProperty(name = "boolInitiateApprove", value = "是否发起审批", notes = "是否发起审批")
   @JsonProperty("boolInitiateApprove")
   @JSONField(name = "boolInitiateApprove")
   @TableField("bool_initiate_approve")
   @Column(name = "bool_initiate_approve", columnDefinition = "tinyint(1) DEFAULT '1'  COMMENT '是否发起审批'", nullable = true)
   private Boolean boolInitiateApprove;
   @ApiModelProperty(name = "purchaseCreationState", value = "采购创建状态 ApplyPurchaseStateEnum", notes = "采购创建状态 ApplyPurchaseStateEnum")
   @JsonProperty("purchaseCreationState")
   @JSONField(name = "purchaseCreationState")
   @TableField("purchase_creation_state")
   @Column(name = "purchase_creation_state", columnDefinition = "int(11)  COMMENT '采购创建状态 ApplyPurchaseStateEnum'", nullable = true)
   private Integer purchaseCreationState;
   @ApiModelProperty(name = "inboundMete", value = "入库核算量 ", notes = "入库核算量")
   @JsonProperty("inboundMete")
   @JSONField(name = "inboundMete")
   @TableField("inbound_mete")
   @Column(name = "inbound_mete", columnDefinition = "decimal(32,8) DEFAULT '0.00000000' COMMENT '入库核算量'", nullable = true)
   private BigDecimal inboundMete;
   @ApiModelProperty(name = "level", value = "目的地 工地、工厂 1工地 2工厂 PlaceEnum", notes = "目的地 工地、工厂 1工地 2工厂 PlaceEnum")
   @JsonProperty("level")
   @JSONField(name = "level")
   @TableField("level")
   @Column(name = "level", columnDefinition = "int(11) COMMENT '目的地 工地、工厂 1工地 2工厂 PlaceEnum'", nullable = true)
   private Integer level;
   @ApiModelProperty(name = "tsData", value = "暂存json数据 当暂存转为待审核的时候进行清空 每次暂存保存时 就进行覆盖 ", notes = "暂存json数据 当暂存转为待审核的时候进行清空 每次暂存保存时 就进行覆盖")
   @JsonProperty("tsData")
   @JSONField(name = "tsData")
   @TableField("ts_data")
   @Column(name = "ts_data", columnDefinition = "mediumtext COMMENT '暂存json数据 当暂存转为待审核的时候进行清空 每次暂存保存时 就进行覆盖'", nullable = true)
   private String tsData;
   @ApiModelProperty(name = "boolIsProjectDetail", value = "是否存在无项目的明细")
   @JsonProperty("boolIsProjectDetail")
   @JSONField(name = "boolIsProjectDetail")
   @TableField("bool_is_project_detail")
   @Column(name = "bool_is_project_detail", columnDefinition = "tinyint(1) DEFAULT '1' COMMENT '是否存在无项目的明细 0不存在 1存在'", nullable = true)
   private Boolean boolIsProjectDetail;
   @ApiModelProperty(name = "boolTemporaryStorage", value = "是否为暂存订单  0不是暂存 1是暂存 默认0")
   @JsonProperty("boolTemporaryStorage")
   @JSONField(name = "boolTemporaryStorage")
   @TableField("bool_temporary_storage")
   @Column(name = "bool_temporary_storage", columnDefinition = "tinyint(1) DEFAULT '0'  COMMENT ' 是否为暂存订单  0不是暂存 1是暂存 默认0'", nullable = true)
   private Boolean boolTemporaryStorage;
   @ApiModelProperty(name = "parentId", value = "父级ID  订单来源ID")
   @JsonProperty("parentId")
   @JSONField(name = "parentId")
   @TableField("parent_id")
   @Column(name = "parent_id", columnDefinition = "bigint(20) COMMENT '父级ID  订单来源ID'", nullable = true)
   private Long parentId;
   @ApiModelProperty(name = "approveRecordIds", value = "审批日志ID集合")
   @JsonProperty("approveRecordIds")
   @JSONField(name = "approveRecordIds")
   @TableField("approve_record_ids")
   @Column(name = "approve_record_ids", columnDefinition = "varchar(255) COMMENT '审批日志ID集合'", nullable = true)
   private String approveRecordIds;
   @ApiModelProperty(name = "approveRecordIdNow", value = "当前审批日志ID")
   @JsonProperty("approveRecordIdNow")
   @JSONField(name = "approveRecordIdNow")
   @TableField("approve_record_id_now")
   @Column(name = "approve_record_id_now", columnDefinition = "bigint COMMENT '当前审批日志ID'", nullable = true)
   private Long approveRecordIdNow;
   @ApiModelProperty(name = "dataStatus", value = "数据当前状态 0失效(未创建成功撤销) 1创建中 2创建成功 3作废中 4作废成功  DataStatusEnum")
   @JsonProperty("dataStatus")
   @JSONField(name = "dataStatus")
   @TableField("data_status")
   @Column(name = "data_status", columnDefinition = "int(11)  COMMENT '数据当前状态 0失效(未创建成功撤销) 1创建中 2创建成功 3作废中 4作废成功 DataStatusEnum'", nullable = true)
   private Integer dataStatus;
   @ApiModelProperty(name = "projectAttribute", value = "项目属性 1自营 2合营 ProjectAttributeEnum")
   @JsonProperty("projectAttribute")
   @JSONField(name = "projectAttribute")
   @TableField("project_attribute")
   @Column(name = "project_attribute", columnDefinition = "char(255)  COMMENT '项目属性 1自营 2合营 ProjectAttributeEnum'", nullable = true)
   private String projectAttribute;
   @ApiModelProperty(name = "branchCompanyId", value = "签订主体公司ID")
   @JsonProperty("branchCompanyId")
   @JSONField(name = "branchCompanyId")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint COMMENT '签订主体公司ID'", nullable = true)
   private Long branchCompanyId;
   @ApiModelProperty(name = "classifyIds", value = "科目ID集")
   @JsonProperty("classifyIds")
   @JSONField(name = "classifyIds")
   @TableField("classify_ids")
   @Column(name = "classify_ids", columnDefinition = "varchar(5000) COMMENT '科目ID集'", nullable = true)
   private String classifyIds;
   @ApiModelProperty(name = "passParentId", value = "通过的采购单父级ID", notes = "通过的采购单父级ID")
   @JsonProperty("passParentId")
   @JSONField(name = "passParentId")
   @TableField("pass_parent_id")
   @Column(name = "pass_parent_id", columnDefinition = "bigint COMMENT '通过的采购单父级ID'", nullable = true)
   private Long passParentId;
   @ApiModelProperty(name = "attachmentsStr", value = "附件ID集", notes = "附件ID集")
   @JsonProperty("attachmentsStr")
   @JSONField(name = "attachmentsStr")
   @TableField(value = "attachments_str", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "attachments_str", columnDefinition = "varchar(1000) COMMENT '附件ID集'", nullable = true)
   private String attachmentsStr;
   @ApiModelProperty(name = "branchAttributeEnum", value = "分支机构-属性 1安装 2加工 4其他")
   @TableField("branch_attribute_enum")
   @Column(name = "branch_attribute_enum", columnDefinition = "int(11) default 0 COMMENT '分支机构-属性 1安装 2加工 4其他'", nullable = false)
   private Integer branchAttributeEnum;

   public static ApplyPurchase.ApplyPurchaseBuilder builder() {
      return new ApplyPurchase.ApplyPurchaseBuilder();
   }

   public ApplyPurchase() {
   }

   public ApplyPurchase(
      final Long id,
      final String serialNumber,
      final Boolean boolSysgen,
      final String serialNumberParent,
      final Integer type,
      final Integer materialType,
      final Integer finishedProductType,
      final Long projectId,
      final String projectIds,
      final String applicantName,
      final Long applicantId,
      final Long departmentId,
      final String departmentName,
      final Integer reviewStatus,
      final LocalDateTime reviewTime,
      final String reviewerIds,
      final LocalDateTime userUpdateTime,
      final Long editorId,
      final Long approveProcessId,
      final String editorName,
      final String remark,
      final Boolean enabled,
      final Boolean boolInitiateApprove,
      final Integer purchaseCreationState,
      final BigDecimal inboundMete,
      final Integer level,
      final String tsData,
      final Boolean boolIsProjectDetail,
      final Boolean boolTemporaryStorage,
      final Long parentId,
      final String approveRecordIds,
      final Long approveRecordIdNow,
      final Integer dataStatus,
      final String projectAttribute,
      final Long branchCompanyId,
      final String classifyIds,
      final Long passParentId,
      final String attachmentsStr,
      final Integer branchAttributeEnum
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.boolSysgen = boolSysgen;
      this.serialNumberParent = serialNumberParent;
      this.type = type;
      this.materialType = materialType;
      this.finishedProductType = finishedProductType;
      this.projectId = projectId;
      this.projectIds = projectIds;
      this.applicantName = applicantName;
      this.applicantId = applicantId;
      this.departmentId = departmentId;
      this.departmentName = departmentName;
      this.reviewStatus = reviewStatus;
      this.reviewTime = reviewTime;
      this.reviewerIds = reviewerIds;
      this.userUpdateTime = userUpdateTime;
      this.editorId = editorId;
      this.approveProcessId = approveProcessId;
      this.editorName = editorName;
      this.remark = remark;
      this.enabled = enabled;
      this.boolInitiateApprove = boolInitiateApprove;
      this.purchaseCreationState = purchaseCreationState;
      this.inboundMete = inboundMete;
      this.level = level;
      this.tsData = tsData;
      this.boolIsProjectDetail = boolIsProjectDetail;
      this.boolTemporaryStorage = boolTemporaryStorage;
      this.parentId = parentId;
      this.approveRecordIds = approveRecordIds;
      this.approveRecordIdNow = approveRecordIdNow;
      this.dataStatus = dataStatus;
      this.projectAttribute = projectAttribute;
      this.branchCompanyId = branchCompanyId;
      this.classifyIds = classifyIds;
      this.passParentId = passParentId;
      this.attachmentsStr = attachmentsStr;
      this.branchAttributeEnum = branchAttributeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Boolean getBoolSysgen() {
      return this.boolSysgen;
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

   public Integer getFinishedProductType() {
      return this.finishedProductType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public Long getDepartmentId() {
      return this.departmentId;
   }

   public String getDepartmentName() {
      return this.departmentName;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public String getReviewerIds() {
      return this.reviewerIds;
   }

   public LocalDateTime getUserUpdateTime() {
      return this.userUpdateTime;
   }

   public Long getEditorId() {
      return this.editorId;
   }

   public Long getApproveProcessId() {
      return this.approveProcessId;
   }

   public String getEditorName() {
      return this.editorName;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public Boolean getBoolInitiateApprove() {
      return this.boolInitiateApprove;
   }

   public Integer getPurchaseCreationState() {
      return this.purchaseCreationState;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getTsData() {
      return this.tsData;
   }

   public Boolean getBoolIsProjectDetail() {
      return this.boolIsProjectDetail;
   }

   public Boolean getBoolTemporaryStorage() {
      return this.boolTemporaryStorage;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public String getApproveRecordIds() {
      return this.approveRecordIds;
   }

   public Long getApproveRecordIdNow() {
      return this.approveRecordIdNow;
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

   public Long getPassParentId() {
      return this.passParentId;
   }

   public String getAttachmentsStr() {
      return this.attachmentsStr;
   }

   public Integer getBranchAttributeEnum() {
      return this.branchAttributeEnum;
   }

   @JsonProperty("id")
   public ApplyPurchase setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public ApplyPurchase setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("boolSysgen")
   public ApplyPurchase setBoolSysgen(final Boolean boolSysgen) {
      this.boolSysgen = boolSysgen;
      return this;
   }

   @JsonProperty("serialNumberParent")
   public ApplyPurchase setSerialNumberParent(final String serialNumberParent) {
      this.serialNumberParent = serialNumberParent;
      return this;
   }

   @JsonProperty("type")
   public ApplyPurchase setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("materialType")
   public ApplyPurchase setMaterialType(final Integer materialType) {
      this.materialType = materialType;
      return this;
   }

   @JsonProperty("finishedProductType")
   public ApplyPurchase setFinishedProductType(final Integer finishedProductType) {
      this.finishedProductType = finishedProductType;
      return this;
   }

   @JsonProperty("projectId")
   public ApplyPurchase setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("projectIds")
   public ApplyPurchase setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
      return this;
   }

   @JsonProperty("applicantName")
   public ApplyPurchase setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @JsonProperty("applicantId")
   public ApplyPurchase setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("departmentId")
   public ApplyPurchase setDepartmentId(final Long departmentId) {
      this.departmentId = departmentId;
      return this;
   }

   @JsonProperty("departmentName")
   public ApplyPurchase setDepartmentName(final String departmentName) {
      this.departmentName = departmentName;
      return this;
   }

   @JsonProperty("reviewStatus")
   public ApplyPurchase setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
      return this;
   }

   @JsonProperty("reviewTime")
   public ApplyPurchase setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
      return this;
   }

   @JsonProperty("reviewerIds")
   public ApplyPurchase setReviewerIds(final String reviewerIds) {
      this.reviewerIds = reviewerIds;
      return this;
   }

   @JsonProperty("userUpdateTime")
   public ApplyPurchase setUserUpdateTime(final LocalDateTime userUpdateTime) {
      this.userUpdateTime = userUpdateTime;
      return this;
   }

   @JsonProperty("editorId")
   public ApplyPurchase setEditorId(final Long editorId) {
      this.editorId = editorId;
      return this;
   }

   @JsonProperty("approveProcessId")
   public ApplyPurchase setApproveProcessId(final Long approveProcessId) {
      this.approveProcessId = approveProcessId;
      return this;
   }

   @JsonProperty("editorName")
   public ApplyPurchase setEditorName(final String editorName) {
      this.editorName = editorName;
      return this;
   }

   @JsonProperty("remark")
   public ApplyPurchase setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("enabled")
   public ApplyPurchase setEnabled(final Boolean enabled) {
      this.enabled = enabled;
      return this;
   }

   @JsonProperty("boolInitiateApprove")
   public ApplyPurchase setBoolInitiateApprove(final Boolean boolInitiateApprove) {
      this.boolInitiateApprove = boolInitiateApprove;
      return this;
   }

   @JsonProperty("purchaseCreationState")
   public ApplyPurchase setPurchaseCreationState(final Integer purchaseCreationState) {
      this.purchaseCreationState = purchaseCreationState;
      return this;
   }

   @JsonProperty("inboundMete")
   public ApplyPurchase setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
      return this;
   }

   @JsonProperty("level")
   public ApplyPurchase setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   @JsonProperty("tsData")
   public ApplyPurchase setTsData(final String tsData) {
      this.tsData = tsData;
      return this;
   }

   @JsonProperty("boolIsProjectDetail")
   public ApplyPurchase setBoolIsProjectDetail(final Boolean boolIsProjectDetail) {
      this.boolIsProjectDetail = boolIsProjectDetail;
      return this;
   }

   @JsonProperty("boolTemporaryStorage")
   public ApplyPurchase setBoolTemporaryStorage(final Boolean boolTemporaryStorage) {
      this.boolTemporaryStorage = boolTemporaryStorage;
      return this;
   }

   @JsonProperty("parentId")
   public ApplyPurchase setParentId(final Long parentId) {
      this.parentId = parentId;
      return this;
   }

   @JsonProperty("approveRecordIds")
   public ApplyPurchase setApproveRecordIds(final String approveRecordIds) {
      this.approveRecordIds = approveRecordIds;
      return this;
   }

   @JsonProperty("approveRecordIdNow")
   public ApplyPurchase setApproveRecordIdNow(final Long approveRecordIdNow) {
      this.approveRecordIdNow = approveRecordIdNow;
      return this;
   }

   @JsonProperty("dataStatus")
   public ApplyPurchase setDataStatus(final Integer dataStatus) {
      this.dataStatus = dataStatus;
      return this;
   }

   @JsonProperty("projectAttribute")
   public ApplyPurchase setProjectAttribute(final String projectAttribute) {
      this.projectAttribute = projectAttribute;
      return this;
   }

   @JsonProperty("branchCompanyId")
   public ApplyPurchase setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   @JsonProperty("classifyIds")
   public ApplyPurchase setClassifyIds(final String classifyIds) {
      this.classifyIds = classifyIds;
      return this;
   }

   @JsonProperty("passParentId")
   public ApplyPurchase setPassParentId(final Long passParentId) {
      this.passParentId = passParentId;
      return this;
   }

   @JsonProperty("attachmentsStr")
   public ApplyPurchase setAttachmentsStr(final String attachmentsStr) {
      this.attachmentsStr = attachmentsStr;
      return this;
   }

   public ApplyPurchase setBranchAttributeEnum(final Integer branchAttributeEnum) {
      this.branchAttributeEnum = branchAttributeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "ApplyPurchase(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", boolSysgen="
         + this.getBoolSysgen()
         + ", serialNumberParent="
         + this.getSerialNumberParent()
         + ", type="
         + this.getType()
         + ", materialType="
         + this.getMaterialType()
         + ", finishedProductType="
         + this.getFinishedProductType()
         + ", projectId="
         + this.getProjectId()
         + ", projectIds="
         + this.getProjectIds()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicantId="
         + this.getApplicantId()
         + ", departmentId="
         + this.getDepartmentId()
         + ", departmentName="
         + this.getDepartmentName()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", reviewTime="
         + this.getReviewTime()
         + ", reviewerIds="
         + this.getReviewerIds()
         + ", userUpdateTime="
         + this.getUserUpdateTime()
         + ", editorId="
         + this.getEditorId()
         + ", approveProcessId="
         + this.getApproveProcessId()
         + ", editorName="
         + this.getEditorName()
         + ", remark="
         + this.getRemark()
         + ", enabled="
         + this.getEnabled()
         + ", boolInitiateApprove="
         + this.getBoolInitiateApprove()
         + ", purchaseCreationState="
         + this.getPurchaseCreationState()
         + ", inboundMete="
         + this.getInboundMete()
         + ", level="
         + this.getLevel()
         + ", tsData="
         + this.getTsData()
         + ", boolIsProjectDetail="
         + this.getBoolIsProjectDetail()
         + ", boolTemporaryStorage="
         + this.getBoolTemporaryStorage()
         + ", parentId="
         + this.getParentId()
         + ", approveRecordIds="
         + this.getApproveRecordIds()
         + ", approveRecordIdNow="
         + this.getApproveRecordIdNow()
         + ", dataStatus="
         + this.getDataStatus()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", passParentId="
         + this.getPassParentId()
         + ", attachmentsStr="
         + this.getAttachmentsStr()
         + ", branchAttributeEnum="
         + this.getBranchAttributeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ApplyPurchase)) {
         return false;
      }

      ApplyPurchase other = (ApplyPurchase)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolSysgen = this.getBoolSysgen();
         Object other$boolSysgen = other.getBoolSysgen();
         if (this$boolSysgen == null ? other$boolSysgen == null : this$boolSysgen.equals(other$boolSysgen)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$materialType = this.getMaterialType();
               Object other$materialType = other.getMaterialType();
               if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                  Object this$finishedProductType = this.getFinishedProductType();
                  Object other$finishedProductType = other.getFinishedProductType();
                  if (this$finishedProductType == null ? other$finishedProductType == null : this$finishedProductType.equals(other$finishedProductType)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$applicantId = this.getApplicantId();
                        Object other$applicantId = other.getApplicantId();
                        if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                           Object this$departmentId = this.getDepartmentId();
                           Object other$departmentId = other.getDepartmentId();
                           if (this$departmentId == null ? other$departmentId == null : this$departmentId.equals(other$departmentId)) {
                              Object this$reviewStatus = this.getReviewStatus();
                              Object other$reviewStatus = other.getReviewStatus();
                              if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                                 Object this$editorId = this.getEditorId();
                                 Object other$editorId = other.getEditorId();
                                 if (this$editorId == null ? other$editorId == null : this$editorId.equals(other$editorId)) {
                                    Object this$approveProcessId = this.getApproveProcessId();
                                    Object other$approveProcessId = other.getApproveProcessId();
                                    if (this$approveProcessId == null ? other$approveProcessId == null : this$approveProcessId.equals(other$approveProcessId)) {
                                       Object this$enabled = this.getEnabled();
                                       Object other$enabled = other.getEnabled();
                                       if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
                                          Object this$boolInitiateApprove = this.getBoolInitiateApprove();
                                          Object other$boolInitiateApprove = other.getBoolInitiateApprove();
                                          if (this$boolInitiateApprove == null
                                             ? other$boolInitiateApprove == null
                                             : this$boolInitiateApprove.equals(other$boolInitiateApprove)) {
                                             Object this$purchaseCreationState = this.getPurchaseCreationState();
                                             Object other$purchaseCreationState = other.getPurchaseCreationState();
                                             if (this$purchaseCreationState == null
                                                ? other$purchaseCreationState == null
                                                : this$purchaseCreationState.equals(other$purchaseCreationState)) {
                                                Object this$level = this.getLevel();
                                                Object other$level = other.getLevel();
                                                if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                                   Object this$boolIsProjectDetail = this.getBoolIsProjectDetail();
                                                   Object other$boolIsProjectDetail = other.getBoolIsProjectDetail();
                                                   if (this$boolIsProjectDetail == null
                                                      ? other$boolIsProjectDetail == null
                                                      : this$boolIsProjectDetail.equals(other$boolIsProjectDetail)) {
                                                      Object this$boolTemporaryStorage = this.getBoolTemporaryStorage();
                                                      Object other$boolTemporaryStorage = other.getBoolTemporaryStorage();
                                                      if (this$boolTemporaryStorage == null
                                                         ? other$boolTemporaryStorage == null
                                                         : this$boolTemporaryStorage.equals(other$boolTemporaryStorage)) {
                                                         Object this$parentId = this.getParentId();
                                                         Object other$parentId = other.getParentId();
                                                         if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
                                                            Object this$approveRecordIdNow = this.getApproveRecordIdNow();
                                                            Object other$approveRecordIdNow = other.getApproveRecordIdNow();
                                                            if (this$approveRecordIdNow == null
                                                               ? other$approveRecordIdNow == null
                                                               : this$approveRecordIdNow.equals(other$approveRecordIdNow)) {
                                                               Object this$dataStatus = this.getDataStatus();
                                                               Object other$dataStatus = other.getDataStatus();
                                                               if (this$dataStatus == null
                                                                  ? other$dataStatus == null
                                                                  : this$dataStatus.equals(other$dataStatus)) {
                                                                  Object this$branchCompanyId = this.getBranchCompanyId();
                                                                  Object other$branchCompanyId = other.getBranchCompanyId();
                                                                  if (this$branchCompanyId == null
                                                                     ? other$branchCompanyId == null
                                                                     : this$branchCompanyId.equals(other$branchCompanyId)) {
                                                                     Object this$passParentId = this.getPassParentId();
                                                                     Object other$passParentId = other.getPassParentId();
                                                                     if (this$passParentId == null
                                                                        ? other$passParentId == null
                                                                        : this$passParentId.equals(other$passParentId)) {
                                                                        Object this$branchAttributeEnum = this.getBranchAttributeEnum();
                                                                        Object other$branchAttributeEnum = other.getBranchAttributeEnum();
                                                                        if (this$branchAttributeEnum == null
                                                                           ? other$branchAttributeEnum == null
                                                                           : this$branchAttributeEnum.equals(other$branchAttributeEnum)) {
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
                                                                                    Object this$applicantName = this.getApplicantName();
                                                                                    Object other$applicantName = other.getApplicantName();
                                                                                    if (this$applicantName == null
                                                                                       ? other$applicantName == null
                                                                                       : this$applicantName.equals(other$applicantName)) {
                                                                                       Object this$departmentName = this.getDepartmentName();
                                                                                       Object other$departmentName = other.getDepartmentName();
                                                                                       if (this$departmentName == null
                                                                                          ? other$departmentName == null
                                                                                          : this$departmentName.equals(other$departmentName)) {
                                                                                          Object this$reviewTime = this.getReviewTime();
                                                                                          Object other$reviewTime = other.getReviewTime();
                                                                                          if (this$reviewTime == null
                                                                                             ? other$reviewTime == null
                                                                                             : this$reviewTime.equals(other$reviewTime)) {
                                                                                             Object this$reviewerIds = this.getReviewerIds();
                                                                                             Object other$reviewerIds = other.getReviewerIds();
                                                                                             if (this$reviewerIds == null
                                                                                                ? other$reviewerIds == null
                                                                                                : this$reviewerIds.equals(other$reviewerIds)) {
                                                                                                Object this$userUpdateTime = this.getUserUpdateTime();
                                                                                                Object other$userUpdateTime = other.getUserUpdateTime();
                                                                                                if (this$userUpdateTime == null
                                                                                                   ? other$userUpdateTime == null
                                                                                                   : this$userUpdateTime.equals(other$userUpdateTime)) {
                                                                                                   Object this$editorName = this.getEditorName();
                                                                                                   Object other$editorName = other.getEditorName();
                                                                                                   if (this$editorName == null
                                                                                                      ? other$editorName == null
                                                                                                      : this$editorName.equals(other$editorName)) {
                                                                                                      Object this$remark = this.getRemark();
                                                                                                      Object other$remark = other.getRemark();
                                                                                                      if (this$remark == null
                                                                                                         ? other$remark == null
                                                                                                         : this$remark.equals(other$remark)) {
                                                                                                         Object this$inboundMete = this.getInboundMete();
                                                                                                         Object other$inboundMete = other.getInboundMete();
                                                                                                         if (this$inboundMete == null
                                                                                                            ? other$inboundMete == null
                                                                                                            : this$inboundMete.equals(other$inboundMete)) {
                                                                                                            Object this$tsData = this.getTsData();
                                                                                                            Object other$tsData = other.getTsData();
                                                                                                            if (this$tsData == null
                                                                                                               ? other$tsData == null
                                                                                                               : this$tsData.equals(other$tsData)) {
                                                                                                               Object this$approveRecordIds = this.getApproveRecordIds();
                                                                                                               Object other$approveRecordIds = other.getApproveRecordIds();
                                                                                                               if (this$approveRecordIds == null
                                                                                                                  ? other$approveRecordIds == null
                                                                                                                  : this$approveRecordIds.equals(
                                                                                                                     other$approveRecordIds
                                                                                                                  )) {
                                                                                                                  Object this$projectAttribute = this.getProjectAttribute();
                                                                                                                  Object other$projectAttribute = other.getProjectAttribute();
                                                                                                                  if (this$projectAttribute == null
                                                                                                                     ? other$projectAttribute == null
                                                                                                                     : this$projectAttribute.equals(
                                                                                                                        other$projectAttribute
                                                                                                                     )) {
                                                                                                                     Object this$classifyIds = this.getClassifyIds();
                                                                                                                     Object other$classifyIds = other.getClassifyIds();
                                                                                                                     if (this$classifyIds == null
                                                                                                                        ? other$classifyIds == null
                                                                                                                        : this$classifyIds.equals(
                                                                                                                           other$classifyIds
                                                                                                                        )) {
                                                                                                                        Object this$attachmentsStr = this.getAttachmentsStr();
                                                                                                                        Object other$attachmentsStr = other.getAttachmentsStr();
                                                                                                                        return this$attachmentsStr == null
                                                                                                                           ? other$attachmentsStr == null
                                                                                                                           : this$attachmentsStr.equals(
                                                                                                                              other$attachmentsStr
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
      return other instanceof ApplyPurchase;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolSysgen = this.getBoolSysgen();
      result = result * 59 + ($boolSysgen == null ? 43 : $boolSysgen.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $finishedProductType = this.getFinishedProductType();
      result = result * 59 + ($finishedProductType == null ? 43 : $finishedProductType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $departmentId = this.getDepartmentId();
      result = result * 59 + ($departmentId == null ? 43 : $departmentId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $editorId = this.getEditorId();
      result = result * 59 + ($editorId == null ? 43 : $editorId.hashCode());
      Object $approveProcessId = this.getApproveProcessId();
      result = result * 59 + ($approveProcessId == null ? 43 : $approveProcessId.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $boolInitiateApprove = this.getBoolInitiateApprove();
      result = result * 59 + ($boolInitiateApprove == null ? 43 : $boolInitiateApprove.hashCode());
      Object $purchaseCreationState = this.getPurchaseCreationState();
      result = result * 59 + ($purchaseCreationState == null ? 43 : $purchaseCreationState.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $boolIsProjectDetail = this.getBoolIsProjectDetail();
      result = result * 59 + ($boolIsProjectDetail == null ? 43 : $boolIsProjectDetail.hashCode());
      Object $boolTemporaryStorage = this.getBoolTemporaryStorage();
      result = result * 59 + ($boolTemporaryStorage == null ? 43 : $boolTemporaryStorage.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $approveRecordIdNow = this.getApproveRecordIdNow();
      result = result * 59 + ($approveRecordIdNow == null ? 43 : $approveRecordIdNow.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $passParentId = this.getPassParentId();
      result = result * 59 + ($passParentId == null ? 43 : $passParentId.hashCode());
      Object $branchAttributeEnum = this.getBranchAttributeEnum();
      result = result * 59 + ($branchAttributeEnum == null ? 43 : $branchAttributeEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $serialNumberParent = this.getSerialNumberParent();
      result = result * 59 + ($serialNumberParent == null ? 43 : $serialNumberParent.hashCode());
      Object $projectIds = this.getProjectIds();
      result = result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $departmentName = this.getDepartmentName();
      result = result * 59 + ($departmentName == null ? 43 : $departmentName.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $reviewerIds = this.getReviewerIds();
      result = result * 59 + ($reviewerIds == null ? 43 : $reviewerIds.hashCode());
      Object $userUpdateTime = this.getUserUpdateTime();
      result = result * 59 + ($userUpdateTime == null ? 43 : $userUpdateTime.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $tsData = this.getTsData();
      result = result * 59 + ($tsData == null ? 43 : $tsData.hashCode());
      Object $approveRecordIds = this.getApproveRecordIds();
      result = result * 59 + ($approveRecordIds == null ? 43 : $approveRecordIds.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $attachmentsStr = this.getAttachmentsStr();
      return result * 59 + ($attachmentsStr == null ? 43 : $attachmentsStr.hashCode());
   }

   public static class ApplyPurchaseBuilder {
      private Long id;
      private String serialNumber;
      private Boolean boolSysgen;
      private String serialNumberParent;
      private Integer type;
      private Integer materialType;
      private Integer finishedProductType;
      private Long projectId;
      private String projectIds;
      private String applicantName;
      private Long applicantId;
      private Long departmentId;
      private String departmentName;
      private Integer reviewStatus;
      private LocalDateTime reviewTime;
      private String reviewerIds;
      private LocalDateTime userUpdateTime;
      private Long editorId;
      private Long approveProcessId;
      private String editorName;
      private String remark;
      private Boolean enabled;
      private Boolean boolInitiateApprove;
      private Integer purchaseCreationState;
      private BigDecimal inboundMete;
      private Integer level;
      private String tsData;
      private Boolean boolIsProjectDetail;
      private Boolean boolTemporaryStorage;
      private Long parentId;
      private String approveRecordIds;
      private Long approveRecordIdNow;
      private Integer dataStatus;
      private String projectAttribute;
      private Long branchCompanyId;
      private String classifyIds;
      private Long passParentId;
      private String attachmentsStr;
      private Integer branchAttributeEnum;

      ApplyPurchaseBuilder() {
      }

      @JsonProperty("id")
      public ApplyPurchase.ApplyPurchaseBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public ApplyPurchase.ApplyPurchaseBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("boolSysgen")
      public ApplyPurchase.ApplyPurchaseBuilder boolSysgen(final Boolean boolSysgen) {
         this.boolSysgen = boolSysgen;
         return this;
      }

      @JsonProperty("serialNumberParent")
      public ApplyPurchase.ApplyPurchaseBuilder serialNumberParent(final String serialNumberParent) {
         this.serialNumberParent = serialNumberParent;
         return this;
      }

      @JsonProperty("type")
      public ApplyPurchase.ApplyPurchaseBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("materialType")
      public ApplyPurchase.ApplyPurchaseBuilder materialType(final Integer materialType) {
         this.materialType = materialType;
         return this;
      }

      @JsonProperty("finishedProductType")
      public ApplyPurchase.ApplyPurchaseBuilder finishedProductType(final Integer finishedProductType) {
         this.finishedProductType = finishedProductType;
         return this;
      }

      @JsonProperty("projectId")
      public ApplyPurchase.ApplyPurchaseBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("projectIds")
      public ApplyPurchase.ApplyPurchaseBuilder projectIds(final String projectIds) {
         this.projectIds = projectIds;
         return this;
      }

      @JsonProperty("applicantName")
      public ApplyPurchase.ApplyPurchaseBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      @JsonProperty("applicantId")
      public ApplyPurchase.ApplyPurchaseBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("departmentId")
      public ApplyPurchase.ApplyPurchaseBuilder departmentId(final Long departmentId) {
         this.departmentId = departmentId;
         return this;
      }

      @JsonProperty("departmentName")
      public ApplyPurchase.ApplyPurchaseBuilder departmentName(final String departmentName) {
         this.departmentName = departmentName;
         return this;
      }

      @JsonProperty("reviewStatus")
      public ApplyPurchase.ApplyPurchaseBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      @JsonProperty("reviewTime")
      public ApplyPurchase.ApplyPurchaseBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      @JsonProperty("reviewerIds")
      public ApplyPurchase.ApplyPurchaseBuilder reviewerIds(final String reviewerIds) {
         this.reviewerIds = reviewerIds;
         return this;
      }

      @JsonProperty("userUpdateTime")
      public ApplyPurchase.ApplyPurchaseBuilder userUpdateTime(final LocalDateTime userUpdateTime) {
         this.userUpdateTime = userUpdateTime;
         return this;
      }

      @JsonProperty("editorId")
      public ApplyPurchase.ApplyPurchaseBuilder editorId(final Long editorId) {
         this.editorId = editorId;
         return this;
      }

      @JsonProperty("approveProcessId")
      public ApplyPurchase.ApplyPurchaseBuilder approveProcessId(final Long approveProcessId) {
         this.approveProcessId = approveProcessId;
         return this;
      }

      @JsonProperty("editorName")
      public ApplyPurchase.ApplyPurchaseBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      @JsonProperty("remark")
      public ApplyPurchase.ApplyPurchaseBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("enabled")
      public ApplyPurchase.ApplyPurchaseBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      @JsonProperty("boolInitiateApprove")
      public ApplyPurchase.ApplyPurchaseBuilder boolInitiateApprove(final Boolean boolInitiateApprove) {
         this.boolInitiateApprove = boolInitiateApprove;
         return this;
      }

      @JsonProperty("purchaseCreationState")
      public ApplyPurchase.ApplyPurchaseBuilder purchaseCreationState(final Integer purchaseCreationState) {
         this.purchaseCreationState = purchaseCreationState;
         return this;
      }

      @JsonProperty("inboundMete")
      public ApplyPurchase.ApplyPurchaseBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      @JsonProperty("level")
      public ApplyPurchase.ApplyPurchaseBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      @JsonProperty("tsData")
      public ApplyPurchase.ApplyPurchaseBuilder tsData(final String tsData) {
         this.tsData = tsData;
         return this;
      }

      @JsonProperty("boolIsProjectDetail")
      public ApplyPurchase.ApplyPurchaseBuilder boolIsProjectDetail(final Boolean boolIsProjectDetail) {
         this.boolIsProjectDetail = boolIsProjectDetail;
         return this;
      }

      @JsonProperty("boolTemporaryStorage")
      public ApplyPurchase.ApplyPurchaseBuilder boolTemporaryStorage(final Boolean boolTemporaryStorage) {
         this.boolTemporaryStorage = boolTemporaryStorage;
         return this;
      }

      @JsonProperty("parentId")
      public ApplyPurchase.ApplyPurchaseBuilder parentId(final Long parentId) {
         this.parentId = parentId;
         return this;
      }

      @JsonProperty("approveRecordIds")
      public ApplyPurchase.ApplyPurchaseBuilder approveRecordIds(final String approveRecordIds) {
         this.approveRecordIds = approveRecordIds;
         return this;
      }

      @JsonProperty("approveRecordIdNow")
      public ApplyPurchase.ApplyPurchaseBuilder approveRecordIdNow(final Long approveRecordIdNow) {
         this.approveRecordIdNow = approveRecordIdNow;
         return this;
      }

      @JsonProperty("dataStatus")
      public ApplyPurchase.ApplyPurchaseBuilder dataStatus(final Integer dataStatus) {
         this.dataStatus = dataStatus;
         return this;
      }

      @JsonProperty("projectAttribute")
      public ApplyPurchase.ApplyPurchaseBuilder projectAttribute(final String projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      @JsonProperty("branchCompanyId")
      public ApplyPurchase.ApplyPurchaseBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      @JsonProperty("classifyIds")
      public ApplyPurchase.ApplyPurchaseBuilder classifyIds(final String classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      @JsonProperty("passParentId")
      public ApplyPurchase.ApplyPurchaseBuilder passParentId(final Long passParentId) {
         this.passParentId = passParentId;
         return this;
      }

      @JsonProperty("attachmentsStr")
      public ApplyPurchase.ApplyPurchaseBuilder attachmentsStr(final String attachmentsStr) {
         this.attachmentsStr = attachmentsStr;
         return this;
      }

      public ApplyPurchase.ApplyPurchaseBuilder branchAttributeEnum(final Integer branchAttributeEnum) {
         this.branchAttributeEnum = branchAttributeEnum;
         return this;
      }

      public ApplyPurchase build() {
         return new ApplyPurchase(
            this.id,
            this.serialNumber,
            this.boolSysgen,
            this.serialNumberParent,
            this.type,
            this.materialType,
            this.finishedProductType,
            this.projectId,
            this.projectIds,
            this.applicantName,
            this.applicantId,
            this.departmentId,
            this.departmentName,
            this.reviewStatus,
            this.reviewTime,
            this.reviewerIds,
            this.userUpdateTime,
            this.editorId,
            this.approveProcessId,
            this.editorName,
            this.remark,
            this.enabled,
            this.boolInitiateApprove,
            this.purchaseCreationState,
            this.inboundMete,
            this.level,
            this.tsData,
            this.boolIsProjectDetail,
            this.boolTemporaryStorage,
            this.parentId,
            this.approveRecordIds,
            this.approveRecordIdNow,
            this.dataStatus,
            this.projectAttribute,
            this.branchCompanyId,
            this.classifyIds,
            this.passParentId,
            this.attachmentsStr,
            this.branchAttributeEnum
         );
      }

      @Override
      public String toString() {
         return "ApplyPurchase.ApplyPurchaseBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", boolSysgen="
            + this.boolSysgen
            + ", serialNumberParent="
            + this.serialNumberParent
            + ", type="
            + this.type
            + ", materialType="
            + this.materialType
            + ", finishedProductType="
            + this.finishedProductType
            + ", projectId="
            + this.projectId
            + ", projectIds="
            + this.projectIds
            + ", applicantName="
            + this.applicantName
            + ", applicantId="
            + this.applicantId
            + ", departmentId="
            + this.departmentId
            + ", departmentName="
            + this.departmentName
            + ", reviewStatus="
            + this.reviewStatus
            + ", reviewTime="
            + this.reviewTime
            + ", reviewerIds="
            + this.reviewerIds
            + ", userUpdateTime="
            + this.userUpdateTime
            + ", editorId="
            + this.editorId
            + ", approveProcessId="
            + this.approveProcessId
            + ", editorName="
            + this.editorName
            + ", remark="
            + this.remark
            + ", enabled="
            + this.enabled
            + ", boolInitiateApprove="
            + this.boolInitiateApprove
            + ", purchaseCreationState="
            + this.purchaseCreationState
            + ", inboundMete="
            + this.inboundMete
            + ", level="
            + this.level
            + ", tsData="
            + this.tsData
            + ", boolIsProjectDetail="
            + this.boolIsProjectDetail
            + ", boolTemporaryStorage="
            + this.boolTemporaryStorage
            + ", parentId="
            + this.parentId
            + ", approveRecordIds="
            + this.approveRecordIds
            + ", approveRecordIdNow="
            + this.approveRecordIdNow
            + ", dataStatus="
            + this.dataStatus
            + ", projectAttribute="
            + this.projectAttribute
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", classifyIds="
            + this.classifyIds
            + ", passParentId="
            + this.passParentId
            + ", attachmentsStr="
            + this.attachmentsStr
            + ", branchAttributeEnum="
            + this.branchAttributeEnum
            + ")";
      }
   }
}
