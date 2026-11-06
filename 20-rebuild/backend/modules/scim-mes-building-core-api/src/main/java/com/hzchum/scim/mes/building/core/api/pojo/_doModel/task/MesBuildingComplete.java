package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
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

@ApiModel(value = "MesBuildingComplete对象", description = "生产完成表 ")
@Entity
@TableName("mes_building_complete")
@Table(
   name = "mes_building_complete",
   indexes = {
         @Index(name = "productId_index", columnList = "product_id"),
         @Index(name = "create_time", columnList = "create_time"),
         @Index(name = "in_year_month_day_date", columnList = "in_year_month_day_date"),
         @Index(name = "in_year_month_date", columnList = "in_year_month_date"),
         @Index(name = "task_id_index", columnList = "task_id")
   }
)
public class MesBuildingComplete extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaId;
   @ApiModelProperty(name = "planId", value = "计划id", notes = "计划id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   @TableField("plan_id")
   @Column(name = "plan_id", columnDefinition = "bigint(20)  COMMENT '计划id'")
   private Long planId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'")
   private Long taskId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'")
   private Long teamId;
   @ApiModelProperty(name = "boolAbnormalEnum", value = "上报类型", notes = "上报类型")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   @TableField("bool_abnormal_enum")
   @Column(name = "bool_abnormal_enum", columnDefinition = "tinyint(1)  COMMENT '上报类型'", nullable = false)
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "boolHandleEnum", value = "是否被处理 [0 未处理, 1 已处理]", notes = "是否被处理 [0 未处理, 1 已处理]")
   @JsonProperty("boolHandleEnum")
   @JSONField(name = "boolHandleEnum")
   @TableField("bool_handle_enum")
   @Column(name = "bool_handle_enum", columnDefinition = "tinyint(1) default '0' COMMENT '是否被处理 [0 未处理, 1 已处理]'", nullable = true)
   private Boolean boolHandleEnum;
   @ApiModelProperty(name = "number", value = "构件生产编号", notes = "构件生产编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField(value = "number", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "number", columnDefinition = "int(20)  COMMENT '构件生产编号'")
   private Integer number;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "artifactTaskId", value = "(无工序直发件专属,记录入库所属构件)构件任务id", notes = "(无工序直发件专属,记录入库所属构件)构件任务id")
   @JsonProperty("artifactTaskId")
   @JSONField(name = "artifactTaskId")
   @TableField("artifact_task_id")
   @Column(name = "artifact_task_id", columnDefinition = "bigint(20) default '0' COMMENT '(无工序直发件专属,记录入库所属构件)构件任务id'")
   private Long artifactTaskId;
   @ApiModelProperty(name = "singId", value = "(直发檩条专属,记录完成数据是由哪条数据生成的)可上报表id", notes = "(直发檩条专属,记录完成数据是由哪条数据生成的)可上报表id")
   @JsonProperty("singId")
   @JSONField(name = "singId")
   @TableField("sing_id")
   @Column(name = "sing_id", columnDefinition = "bigint(20)  COMMENT '(直发檩条专属,记录完成数据是由哪条数据生成的)可上报表id'")
   private Long singId;
   @ApiModelProperty(name = "parentType", value = "父类产品类型", notes = "父类产品类型")
   @JsonProperty("parentType")
   @JSONField(name = "parentType")
   @TableField("parent_type")
   @Column(name = "parent_type", columnDefinition = "int(20)  COMMENT '父类产品类型'")
   private Integer parentType;
   @ApiModelProperty(name = "numberLinkId", value = "码号关联表id", notes = "码号关联表id")
   @JsonProperty("numberLinkId")
   @JSONField(name = "numberLinkId")
   @TableField(value = "number_link_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "number_link_id", columnDefinition = "bigint(20)  COMMENT '码号关联表id'")
   private Long numberLinkId;
   @ApiModelProperty(name = "boolSpotCheck", value = "是否抽检", notes = "是否抽检")
   @JsonProperty("boolSpotCheck")
   @JSONField(name = "boolSpotCheck")
   @TableField("bool_spot_check")
   @Column(name = "bool_spot_check", columnDefinition = "tinyint(1) default '0'  COMMENT '是否抽检'", nullable = false)
   private Boolean boolSpotCheck;
   @ApiModelProperty(name = "boolQualified", value = "是否合格", notes = "是否合格")
   @JsonProperty("boolQualified")
   @JSONField(name = "boolQualified")
   @TableField("bool_qualified")
   @Column(name = "bool_qualified", columnDefinition = "tinyint(1)  COMMENT '是否合格'")
   private Boolean boolQualified;
   @ApiModelProperty(name = "qualifiedQuantity", value = "合格数")
   @JsonProperty("qualifiedQuantity")
   @JSONField(name = "qualifiedQuantity")
   @TableField("qualified_quantity")
   @Column(name = "qualified_quantity", columnDefinition = "int(10) default 0 COMMENT '(合格数'")
   private Integer qualifiedQuantity;
   @ApiModelProperty(name = "unQualifiedQuantity", value = "不合格数")
   @JsonProperty("unQualifiedQuantity")
   @JSONField(name = "unQualifiedQuantity")
   @TableField("un_qualified_quantity")
   @Column(name = "un_qualified_quantity", columnDefinition = "int(10) default 0 COMMENT '(不合格数'")
   private Integer unQualifiedQuantity;
   @ApiModelProperty(name = "spotCheckDateTime", value = "抽检时间", notes = "抽检时间")
   @JsonProperty("spotCheckDateTime")
   @JSONField(name = "spotCheckDateTime")
   @TableField("spot_check_date_time")
   @Column(name = "spot_check_date_time", columnDefinition = "datetime(6)  COMMENT '抽检时间'")
   private LocalDateTime spotCheckDateTime;
   @ApiModelProperty(name = "spotCheckDate", value = "抽检时间(年月日)", notes = "年月日")
   @JsonProperty("spotCheckDate")
   @JSONField(name = "spotCheckDate")
   @TableField("spot_check_date")
   @Column(name = "spot_check_date", columnDefinition = "varchar(566)  COMMENT '年月日'")
   private String spotCheckDate;
   @ApiModelProperty(name = "spotCheckUserName", value = "抽检人")
   @JsonProperty("spotCheckUserName")
   @JSONField(name = "spotCheckUserName")
   @TableField("spot_check_user_name")
   @Column(name = "spot_check_user_name", columnDefinition = "varchar(255) COMMENT '抽检人'")
   private String spotCheckUserName;
   @ApiModelProperty(name = "spotCheckRemark", value = "抽检备注")
   @JsonProperty("spotCheckRemark")
   @JSONField(name = "spotCheckRemark")
   @TableField("spot_check_remark")
   @Column(name = "spot_check_remark", columnDefinition = "varchar(255) COMMENT '抽检备注'")
   private String spotCheckRemark;
   @ApiModelProperty(name = "inYearMonthDayDate")
   @JsonProperty("inYearMonthDayDate")
   @JSONField(name = "inYearMonthDayDate")
   @TableField(value = "in_year_month_day_date", fill = FieldFill.INSERT)
   @Column(name = "in_year_month_day_date", columnDefinition = "varchar(564) COMMENT '日期(年-月-日)'")
   private String inYearMonthDayDate;
   @ApiModelProperty(name = "inYearMonthDate")
   @JsonProperty("inYearMonthDate")
   @JSONField(name = "inYearMonthDate")
   @TableField(value = "in_year_month_date", fill = FieldFill.INSERT)
   @Column(name = "in_year_month_date", columnDefinition = "varchar(564) COMMENT '日期(年-月)'")
   private String inYearMonthDate;

   public static MesBuildingComplete.MesBuildingCompleteBuilder builder() {
      return new MesBuildingComplete.MesBuildingCompleteBuilder();
   }

   public MesBuildingComplete() {
   }

   public MesBuildingComplete(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long planId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long taskId,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Long userId,
      final Long teamId,
      final Boolean boolAbnormalEnum,
      final Boolean boolHandleEnum,
      final Integer number,
      final Long groupsId,
      final Long artifactTaskId,
      final Long singId,
      final Integer parentType,
      final Long numberLinkId,
      final Boolean boolSpotCheck,
      final Boolean boolQualified,
      final Integer qualifiedQuantity,
      final Integer unQualifiedQuantity,
      final LocalDateTime spotCheckDateTime,
      final String spotCheckDate,
      final String spotCheckUserName,
      final String spotCheckRemark,
      final String inYearMonthDayDate,
      final String inYearMonthDate
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.planId = planId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.taskId = taskId;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.userId = userId;
      this.teamId = teamId;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.boolHandleEnum = boolHandleEnum;
      this.number = number;
      this.groupsId = groupsId;
      this.artifactTaskId = artifactTaskId;
      this.singId = singId;
      this.parentType = parentType;
      this.numberLinkId = numberLinkId;
      this.boolSpotCheck = boolSpotCheck;
      this.boolQualified = boolQualified;
      this.qualifiedQuantity = qualifiedQuantity;
      this.unQualifiedQuantity = unQualifiedQuantity;
      this.spotCheckDateTime = spotCheckDateTime;
      this.spotCheckDate = spotCheckDate;
      this.spotCheckUserName = spotCheckUserName;
      this.spotCheckRemark = spotCheckRemark;
      this.inYearMonthDayDate = inYearMonthDayDate;
      this.inYearMonthDate = inYearMonthDate;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   public Boolean getBoolHandleEnum() {
      return this.boolHandleEnum;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   public Long getSingId() {
      return this.singId;
   }

   public Integer getParentType() {
      return this.parentType;
   }

   public Long getNumberLinkId() {
      return this.numberLinkId;
   }

   public Boolean getBoolSpotCheck() {
      return this.boolSpotCheck;
   }

   public Boolean getBoolQualified() {
      return this.boolQualified;
   }

   public Integer getQualifiedQuantity() {
      return this.qualifiedQuantity;
   }

   public Integer getUnQualifiedQuantity() {
      return this.unQualifiedQuantity;
   }

   public LocalDateTime getSpotCheckDateTime() {
      return this.spotCheckDateTime;
   }

   public String getSpotCheckDate() {
      return this.spotCheckDate;
   }

   public String getSpotCheckUserName() {
      return this.spotCheckUserName;
   }

   public String getSpotCheckRemark() {
      return this.spotCheckRemark;
   }

   public String getInYearMonthDayDate() {
      return this.inYearMonthDayDate;
   }

   public String getInYearMonthDate() {
      return this.inYearMonthDate;
   }

   @JsonProperty("id")
   public MesBuildingComplete setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingComplete setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingComplete setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingComplete setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingComplete setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("planId")
   public MesBuildingComplete setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingComplete setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingComplete setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingComplete setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingComplete setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingComplete setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingComplete setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingComplete setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingComplete setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingComplete setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public MesBuildingComplete setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @JsonProperty("boolHandleEnum")
   public MesBuildingComplete setBoolHandleEnum(final Boolean boolHandleEnum) {
      this.boolHandleEnum = boolHandleEnum;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingComplete setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingComplete setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("artifactTaskId")
   public MesBuildingComplete setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
      return this;
   }

   @JsonProperty("singId")
   public MesBuildingComplete setSingId(final Long singId) {
      this.singId = singId;
      return this;
   }

   @JsonProperty("parentType")
   public MesBuildingComplete setParentType(final Integer parentType) {
      this.parentType = parentType;
      return this;
   }

   @JsonProperty("numberLinkId")
   public MesBuildingComplete setNumberLinkId(final Long numberLinkId) {
      this.numberLinkId = numberLinkId;
      return this;
   }

   @JsonProperty("boolSpotCheck")
   public MesBuildingComplete setBoolSpotCheck(final Boolean boolSpotCheck) {
      this.boolSpotCheck = boolSpotCheck;
      return this;
   }

   @JsonProperty("boolQualified")
   public MesBuildingComplete setBoolQualified(final Boolean boolQualified) {
      this.boolQualified = boolQualified;
      return this;
   }

   @JsonProperty("qualifiedQuantity")
   public MesBuildingComplete setQualifiedQuantity(final Integer qualifiedQuantity) {
      this.qualifiedQuantity = qualifiedQuantity;
      return this;
   }

   @JsonProperty("unQualifiedQuantity")
   public MesBuildingComplete setUnQualifiedQuantity(final Integer unQualifiedQuantity) {
      this.unQualifiedQuantity = unQualifiedQuantity;
      return this;
   }

   @JsonProperty("spotCheckDateTime")
   public MesBuildingComplete setSpotCheckDateTime(final LocalDateTime spotCheckDateTime) {
      this.spotCheckDateTime = spotCheckDateTime;
      return this;
   }

   @JsonProperty("spotCheckDate")
   public MesBuildingComplete setSpotCheckDate(final String spotCheckDate) {
      this.spotCheckDate = spotCheckDate;
      return this;
   }

   @JsonProperty("spotCheckUserName")
   public MesBuildingComplete setSpotCheckUserName(final String spotCheckUserName) {
      this.spotCheckUserName = spotCheckUserName;
      return this;
   }

   @JsonProperty("spotCheckRemark")
   public MesBuildingComplete setSpotCheckRemark(final String spotCheckRemark) {
      this.spotCheckRemark = spotCheckRemark;
      return this;
   }

   @JsonProperty("inYearMonthDayDate")
   public MesBuildingComplete setInYearMonthDayDate(final String inYearMonthDayDate) {
      this.inYearMonthDayDate = inYearMonthDayDate;
      return this;
   }

   @JsonProperty("inYearMonthDate")
   public MesBuildingComplete setInYearMonthDate(final String inYearMonthDate) {
      this.inYearMonthDate = inYearMonthDate;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingComplete(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
         + ", planId="
         + this.getPlanId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", taskId="
         + this.getTaskId()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", userId="
         + this.getUserId()
         + ", teamId="
         + this.getTeamId()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", boolHandleEnum="
         + this.getBoolHandleEnum()
         + ", number="
         + this.getNumber()
         + ", groupsId="
         + this.getGroupsId()
         + ", artifactTaskId="
         + this.getArtifactTaskId()
         + ", singId="
         + this.getSingId()
         + ", parentType="
         + this.getParentType()
         + ", numberLinkId="
         + this.getNumberLinkId()
         + ", boolSpotCheck="
         + this.getBoolSpotCheck()
         + ", boolQualified="
         + this.getBoolQualified()
         + ", qualifiedQuantity="
         + this.getQualifiedQuantity()
         + ", unQualifiedQuantity="
         + this.getUnQualifiedQuantity()
         + ", spotCheckDateTime="
         + this.getSpotCheckDateTime()
         + ", spotCheckDate="
         + this.getSpotCheckDate()
         + ", spotCheckUserName="
         + this.getSpotCheckUserName()
         + ", spotCheckRemark="
         + this.getSpotCheckRemark()
         + ", inYearMonthDayDate="
         + this.getInYearMonthDayDate()
         + ", inYearMonthDate="
         + this.getInYearMonthDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingComplete)) {
         return false;
      }

      MesBuildingComplete other = (MesBuildingComplete)o;
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
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaBatchId = this.getAreaBatchId();
               Object other$areaBatchId = other.getAreaBatchId();
               if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$planId = this.getPlanId();
                     Object other$planId = other.getPlanId();
                     if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                        Object this$factoryId = this.getFactoryId();
                        Object other$factoryId = other.getFactoryId();
                        if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                           Object this$workshopId = this.getWorkshopId();
                           Object other$workshopId = other.getWorkshopId();
                           if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                              Object this$productionLineId = this.getProductionLineId();
                              Object other$productionLineId = other.getProductionLineId();
                              if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                                 Object this$taskId = this.getTaskId();
                                 Object other$taskId = other.getTaskId();
                                 if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                    Object this$productId = this.getProductId();
                                    Object other$productId = other.getProductId();
                                    if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                       Object this$taskTypeEnum = this.getTaskTypeEnum();
                                       Object other$taskTypeEnum = other.getTaskTypeEnum();
                                       if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$userId = this.getUserId();
                                             Object other$userId = other.getUserId();
                                             if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                Object this$teamId = this.getTeamId();
                                                Object other$teamId = other.getTeamId();
                                                if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                   Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                                                   Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                                                   if (this$boolAbnormalEnum == null
                                                      ? other$boolAbnormalEnum == null
                                                      : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                                                      Object this$boolHandleEnum = this.getBoolHandleEnum();
                                                      Object other$boolHandleEnum = other.getBoolHandleEnum();
                                                      if (this$boolHandleEnum == null
                                                         ? other$boolHandleEnum == null
                                                         : this$boolHandleEnum.equals(other$boolHandleEnum)) {
                                                         Object this$number = this.getNumber();
                                                         Object other$number = other.getNumber();
                                                         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                                            Object this$groupsId = this.getGroupsId();
                                                            Object other$groupsId = other.getGroupsId();
                                                            if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                                                               Object this$artifactTaskId = this.getArtifactTaskId();
                                                               Object other$artifactTaskId = other.getArtifactTaskId();
                                                               if (this$artifactTaskId == null
                                                                  ? other$artifactTaskId == null
                                                                  : this$artifactTaskId.equals(other$artifactTaskId)) {
                                                                  Object this$singId = this.getSingId();
                                                                  Object other$singId = other.getSingId();
                                                                  if (this$singId == null ? other$singId == null : this$singId.equals(other$singId)) {
                                                                     Object this$parentType = this.getParentType();
                                                                     Object other$parentType = other.getParentType();
                                                                     if (this$parentType == null
                                                                        ? other$parentType == null
                                                                        : this$parentType.equals(other$parentType)) {
                                                                        Object this$numberLinkId = this.getNumberLinkId();
                                                                        Object other$numberLinkId = other.getNumberLinkId();
                                                                        if (this$numberLinkId == null
                                                                           ? other$numberLinkId == null
                                                                           : this$numberLinkId.equals(other$numberLinkId)) {
                                                                           Object this$boolSpotCheck = this.getBoolSpotCheck();
                                                                           Object other$boolSpotCheck = other.getBoolSpotCheck();
                                                                           if (this$boolSpotCheck == null
                                                                              ? other$boolSpotCheck == null
                                                                              : this$boolSpotCheck.equals(other$boolSpotCheck)) {
                                                                              Object this$boolQualified = this.getBoolQualified();
                                                                              Object other$boolQualified = other.getBoolQualified();
                                                                              if (this$boolQualified == null
                                                                                 ? other$boolQualified == null
                                                                                 : this$boolQualified.equals(other$boolQualified)) {
                                                                                 Object this$qualifiedQuantity = this.getQualifiedQuantity();
                                                                                 Object other$qualifiedQuantity = other.getQualifiedQuantity();
                                                                                 if (this$qualifiedQuantity == null
                                                                                    ? other$qualifiedQuantity == null
                                                                                    : this$qualifiedQuantity.equals(other$qualifiedQuantity)) {
                                                                                    Object this$unQualifiedQuantity = this.getUnQualifiedQuantity();
                                                                                    Object other$unQualifiedQuantity = other.getUnQualifiedQuantity();
                                                                                    if (this$unQualifiedQuantity == null
                                                                                       ? other$unQualifiedQuantity == null
                                                                                       : this$unQualifiedQuantity.equals(other$unQualifiedQuantity)) {
                                                                                       Object this$spotCheckDateTime = this.getSpotCheckDateTime();
                                                                                       Object other$spotCheckDateTime = other.getSpotCheckDateTime();
                                                                                       if (this$spotCheckDateTime == null
                                                                                          ? other$spotCheckDateTime == null
                                                                                          : this$spotCheckDateTime.equals(other$spotCheckDateTime)) {
                                                                                          Object this$spotCheckDate = this.getSpotCheckDate();
                                                                                          Object other$spotCheckDate = other.getSpotCheckDate();
                                                                                          if (this$spotCheckDate == null
                                                                                             ? other$spotCheckDate == null
                                                                                             : this$spotCheckDate.equals(other$spotCheckDate)) {
                                                                                             Object this$spotCheckUserName = this.getSpotCheckUserName();
                                                                                             Object other$spotCheckUserName = other.getSpotCheckUserName();
                                                                                             if (this$spotCheckUserName == null
                                                                                                ? other$spotCheckUserName == null
                                                                                                : this$spotCheckUserName.equals(other$spotCheckUserName)) {
                                                                                                Object this$spotCheckRemark = this.getSpotCheckRemark();
                                                                                                Object other$spotCheckRemark = other.getSpotCheckRemark();
                                                                                                if (this$spotCheckRemark == null
                                                                                                   ? other$spotCheckRemark == null
                                                                                                   : this$spotCheckRemark.equals(other$spotCheckRemark)) {
                                                                                                   Object this$inYearMonthDayDate = this.getInYearMonthDayDate();
                                                                                                   Object other$inYearMonthDayDate = other.getInYearMonthDayDate();
                                                                                                   if (this$inYearMonthDayDate == null
                                                                                                      ? other$inYearMonthDayDate == null
                                                                                                      : this$inYearMonthDayDate.equals(other$inYearMonthDayDate)
                                                                                                      )
                                                                                                    {
                                                                                                      Object this$inYearMonthDate = this.getInYearMonthDate();
                                                                                                      Object other$inYearMonthDate = other.getInYearMonthDate();
                                                                                                      return this$inYearMonthDate == null
                                                                                                         ? other$inYearMonthDate == null
                                                                                                         : this$inYearMonthDate.equals(other$inYearMonthDate);
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
      return other instanceof MesBuildingComplete;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $boolHandleEnum = this.getBoolHandleEnum();
      result = result * 59 + ($boolHandleEnum == null ? 43 : $boolHandleEnum.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $singId = this.getSingId();
      result = result * 59 + ($singId == null ? 43 : $singId.hashCode());
      Object $parentType = this.getParentType();
      result = result * 59 + ($parentType == null ? 43 : $parentType.hashCode());
      Object $numberLinkId = this.getNumberLinkId();
      result = result * 59 + ($numberLinkId == null ? 43 : $numberLinkId.hashCode());
      Object $boolSpotCheck = this.getBoolSpotCheck();
      result = result * 59 + ($boolSpotCheck == null ? 43 : $boolSpotCheck.hashCode());
      Object $boolQualified = this.getBoolQualified();
      result = result * 59 + ($boolQualified == null ? 43 : $boolQualified.hashCode());
      Object $qualifiedQuantity = this.getQualifiedQuantity();
      result = result * 59 + ($qualifiedQuantity == null ? 43 : $qualifiedQuantity.hashCode());
      Object $unQualifiedQuantity = this.getUnQualifiedQuantity();
      result = result * 59 + ($unQualifiedQuantity == null ? 43 : $unQualifiedQuantity.hashCode());
      Object $spotCheckDateTime = this.getSpotCheckDateTime();
      result = result * 59 + ($spotCheckDateTime == null ? 43 : $spotCheckDateTime.hashCode());
      Object $spotCheckDate = this.getSpotCheckDate();
      result = result * 59 + ($spotCheckDate == null ? 43 : $spotCheckDate.hashCode());
      Object $spotCheckUserName = this.getSpotCheckUserName();
      result = result * 59 + ($spotCheckUserName == null ? 43 : $spotCheckUserName.hashCode());
      Object $spotCheckRemark = this.getSpotCheckRemark();
      result = result * 59 + ($spotCheckRemark == null ? 43 : $spotCheckRemark.hashCode());
      Object $inYearMonthDayDate = this.getInYearMonthDayDate();
      result = result * 59 + ($inYearMonthDayDate == null ? 43 : $inYearMonthDayDate.hashCode());
      Object $inYearMonthDate = this.getInYearMonthDate();
      return result * 59 + ($inYearMonthDate == null ? 43 : $inYearMonthDate.hashCode());
   }

   public static class MesBuildingCompleteBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long planId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long taskId;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Long userId;
      private Long teamId;
      private Boolean boolAbnormalEnum;
      private Boolean boolHandleEnum;
      private Integer number;
      private Long groupsId;
      private Long artifactTaskId;
      private Long singId;
      private Integer parentType;
      private Long numberLinkId;
      private Boolean boolSpotCheck;
      private Boolean boolQualified;
      private Integer qualifiedQuantity;
      private Integer unQualifiedQuantity;
      private LocalDateTime spotCheckDateTime;
      private String spotCheckDate;
      private String spotCheckUserName;
      private String spotCheckRemark;
      private String inYearMonthDayDate;
      private String inYearMonthDate;

      MesBuildingCompleteBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingComplete.MesBuildingCompleteBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingComplete.MesBuildingCompleteBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingComplete.MesBuildingCompleteBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingComplete.MesBuildingCompleteBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingComplete.MesBuildingCompleteBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("planId")
      public MesBuildingComplete.MesBuildingCompleteBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingComplete.MesBuildingCompleteBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingComplete.MesBuildingCompleteBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingComplete.MesBuildingCompleteBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingComplete.MesBuildingCompleteBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingComplete.MesBuildingCompleteBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingComplete.MesBuildingCompleteBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingComplete.MesBuildingCompleteBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingComplete.MesBuildingCompleteBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingComplete.MesBuildingCompleteBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public MesBuildingComplete.MesBuildingCompleteBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      @JsonProperty("boolHandleEnum")
      public MesBuildingComplete.MesBuildingCompleteBuilder boolHandleEnum(final Boolean boolHandleEnum) {
         this.boolHandleEnum = boolHandleEnum;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingComplete.MesBuildingCompleteBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingComplete.MesBuildingCompleteBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("artifactTaskId")
      public MesBuildingComplete.MesBuildingCompleteBuilder artifactTaskId(final Long artifactTaskId) {
         this.artifactTaskId = artifactTaskId;
         return this;
      }

      @JsonProperty("singId")
      public MesBuildingComplete.MesBuildingCompleteBuilder singId(final Long singId) {
         this.singId = singId;
         return this;
      }

      @JsonProperty("parentType")
      public MesBuildingComplete.MesBuildingCompleteBuilder parentType(final Integer parentType) {
         this.parentType = parentType;
         return this;
      }

      @JsonProperty("numberLinkId")
      public MesBuildingComplete.MesBuildingCompleteBuilder numberLinkId(final Long numberLinkId) {
         this.numberLinkId = numberLinkId;
         return this;
      }

      @JsonProperty("boolSpotCheck")
      public MesBuildingComplete.MesBuildingCompleteBuilder boolSpotCheck(final Boolean boolSpotCheck) {
         this.boolSpotCheck = boolSpotCheck;
         return this;
      }

      @JsonProperty("boolQualified")
      public MesBuildingComplete.MesBuildingCompleteBuilder boolQualified(final Boolean boolQualified) {
         this.boolQualified = boolQualified;
         return this;
      }

      @JsonProperty("qualifiedQuantity")
      public MesBuildingComplete.MesBuildingCompleteBuilder qualifiedQuantity(final Integer qualifiedQuantity) {
         this.qualifiedQuantity = qualifiedQuantity;
         return this;
      }

      @JsonProperty("unQualifiedQuantity")
      public MesBuildingComplete.MesBuildingCompleteBuilder unQualifiedQuantity(final Integer unQualifiedQuantity) {
         this.unQualifiedQuantity = unQualifiedQuantity;
         return this;
      }

      @JsonProperty("spotCheckDateTime")
      public MesBuildingComplete.MesBuildingCompleteBuilder spotCheckDateTime(final LocalDateTime spotCheckDateTime) {
         this.spotCheckDateTime = spotCheckDateTime;
         return this;
      }

      @JsonProperty("spotCheckDate")
      public MesBuildingComplete.MesBuildingCompleteBuilder spotCheckDate(final String spotCheckDate) {
         this.spotCheckDate = spotCheckDate;
         return this;
      }

      @JsonProperty("spotCheckUserName")
      public MesBuildingComplete.MesBuildingCompleteBuilder spotCheckUserName(final String spotCheckUserName) {
         this.spotCheckUserName = spotCheckUserName;
         return this;
      }

      @JsonProperty("spotCheckRemark")
      public MesBuildingComplete.MesBuildingCompleteBuilder spotCheckRemark(final String spotCheckRemark) {
         this.spotCheckRemark = spotCheckRemark;
         return this;
      }

      @JsonProperty("inYearMonthDayDate")
      public MesBuildingComplete.MesBuildingCompleteBuilder inYearMonthDayDate(final String inYearMonthDayDate) {
         this.inYearMonthDayDate = inYearMonthDayDate;
         return this;
      }

      @JsonProperty("inYearMonthDate")
      public MesBuildingComplete.MesBuildingCompleteBuilder inYearMonthDate(final String inYearMonthDate) {
         this.inYearMonthDate = inYearMonthDate;
         return this;
      }

      public MesBuildingComplete build() {
         return new MesBuildingComplete(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.planId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.taskId,
            this.productId,
            this.taskTypeEnum,
            this.quantity,
            this.userId,
            this.teamId,
            this.boolAbnormalEnum,
            this.boolHandleEnum,
            this.number,
            this.groupsId,
            this.artifactTaskId,
            this.singId,
            this.parentType,
            this.numberLinkId,
            this.boolSpotCheck,
            this.boolQualified,
            this.qualifiedQuantity,
            this.unQualifiedQuantity,
            this.spotCheckDateTime,
            this.spotCheckDate,
            this.spotCheckUserName,
            this.spotCheckRemark,
            this.inYearMonthDayDate,
            this.inYearMonthDate
         );
      }

      @Override
      public String toString() {
         return "MesBuildingComplete.MesBuildingCompleteBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
            + ", planId="
            + this.planId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", taskId="
            + this.taskId
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", userId="
            + this.userId
            + ", teamId="
            + this.teamId
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", boolHandleEnum="
            + this.boolHandleEnum
            + ", number="
            + this.number
            + ", groupsId="
            + this.groupsId
            + ", artifactTaskId="
            + this.artifactTaskId
            + ", singId="
            + this.singId
            + ", parentType="
            + this.parentType
            + ", numberLinkId="
            + this.numberLinkId
            + ", boolSpotCheck="
            + this.boolSpotCheck
            + ", boolQualified="
            + this.boolQualified
            + ", qualifiedQuantity="
            + this.qualifiedQuantity
            + ", unQualifiedQuantity="
            + this.unQualifiedQuantity
            + ", spotCheckDateTime="
            + this.spotCheckDateTime
            + ", spotCheckDate="
            + this.spotCheckDate
            + ", spotCheckUserName="
            + this.spotCheckUserName
            + ", spotCheckRemark="
            + this.spotCheckRemark
            + ", inYearMonthDayDate="
            + this.inYearMonthDayDate
            + ", inYearMonthDate="
            + this.inYearMonthDate
            + ")";
      }
   }
}
