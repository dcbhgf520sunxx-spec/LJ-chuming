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

@ApiModel(value = "MesBuildingTask对象", description = "任务分配表 ")
@Entity
@TableName("mes_building_task")
@Table(
   name = "mes_building_task",
   indexes = {
         @Index(name = "productId_index", columnList = "product_id"),
         @Index(name = "projectId_index", columnList = "project_id"),
         @Index(name = "taskTypeEnum_index", columnList = "task_type_enum"),
         @Index(name = "machinePartSchedulingIdIndex", columnList = "machine_part_scheduling_id"),
         @Index(name = "in_year_month_day_date", columnList = "in_year_month_day_date"),
         @Index(name = "in_year_month_date", columnList = "in_year_month_date")
   }
)
public class MesBuildingTask extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'")
   private Long factoryId;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'")
   private Long schedulingId;
   @ApiModelProperty(name = "machinePartSchedulingId", value = "零件排产id", notes = "零件排产id")
   @JsonProperty("machinePartSchedulingId")
   @JSONField(name = "machinePartSchedulingId")
   @TableField("machine_part_scheduling_id")
   @Column(name = "machine_part_scheduling_id", columnDefinition = "bigint(20)  COMMENT '零件排产id'")
   private Long machinePartSchedulingId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'")
   private Long productionLineId;
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
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '区域Id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域Id'")
   private Long areaId;
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
   @ApiModelProperty(name = "productProcessId", value = "总工序id", notes = "总工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   @TableField("product_process_id")
   @Column(name = "product_process_id", columnDefinition = "bigint(20)  COMMENT '总工序id'", nullable = false)
   private Long productProcessId;
   @ApiModelProperty(name = "taskQuantity", value = "任务数量", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   @TableField("task_quantity")
   @Column(name = "task_quantity", columnDefinition = "int(11) default '0' COMMENT '任务数量'", nullable = false)
   private Integer taskQuantity;
   @ApiModelProperty(name = "inProductionQuantity", value = "进入生产数量", notes = "进入生产数量")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   @TableField("in_production_quantity")
   @Column(name = "in_production_quantity", columnDefinition = "int(11) default '0' COMMENT '进入生产数量'", nullable = false)
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "completeQuantity", value = "已完成数量", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   @TableField("complete_quantity")
   @Column(name = "complete_quantity", columnDefinition = "int(11) default '0' COMMENT '已完成数量'", nullable = false)
   private Integer completeQuantity;
   @ApiModelProperty(name = "useQuantity", value = "檩条齐套专用字段本零件任务使用数", notes = "檩条齐套专用字段本零件任务使用数")
   @JsonProperty("useQuantity")
   @JSONField(name = "useQuantity")
   @TableField("use_quantity")
   @Column(name = "use_quantity", columnDefinition = "int(11) default '0' COMMENT '檩条齐套专用字段本零件任务使用数'", nullable = false)
   private Integer useQuantity;
   @ApiModelProperty(name = "status", value = "状态 [0 正常,1暂停(可异常上报),2,暂停(正在处理中,无法上报)]", notes = "状态 [0 正常,1暂停(可异常上报),2,暂停(正在处理中,无法上报)]")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '0' COMMENT '状态 [0 正常,1暂停(可异常上报),2,暂停(正在处理中,无法上报)]'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "technologyStatus", value = "技术状态 [0 暂停, 1 正常]", notes = "技术状态 [0 暂停, 1 正常]")
   @JsonProperty("technologyStatus")
   @JSONField(name = "technologyStatus")
   @TableField("technology_status")
   @Column(name = "technology_status", columnDefinition = "tinyint(1) default '1' COMMENT '技术状态 [0 暂停, 1 正常]'", nullable = false)
   private Boolean technologyStatus;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @TableField("ask_complete_time")
   @Column(name = "ask_complete_time", columnDefinition = "datetime  COMMENT '要求完成日期'", nullable = true)
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "inProductionTime", value = "进入生产日期", notes = "进入生产日期")
   @JsonProperty("inProductionTime")
   @JSONField(name = "inProductionTime")
   @TableField("in_production_time")
   @Column(name = "in_production_time", columnDefinition = "datetime  COMMENT '进入生产日期'", nullable = true)
   private LocalDateTime inProductionTime;
   @ApiModelProperty(name = "completeTime", value = "完成日期", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   @TableField("complete_time")
   @Column(name = "complete_time", columnDefinition = "datetime  COMMENT '完成日期'", nullable = true)
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "printQuantity")
   @JsonProperty("printQuantity")
   @JSONField(name = "printQuantity")
   @TableField("print_quantity")
   @Column(name = "print_quantity", columnDefinition = "int(11) default '0' COMMENT ''", nullable = true)
   private Integer printQuantity;
   @ApiModelProperty(name = "printTime")
   @JsonProperty("printTime")
   @JSONField(name = "printTime")
   @TableField("print_time")
   @Column(name = "print_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private LocalDateTime printTime;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField(value = "groups_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField(value = "task_order_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "task_order_id", columnDefinition = "bigint(20) default '0' COMMENT '任务工单id'")
   private Long taskOrderId;
   @ApiModelProperty(name = "topTaskOrderId", value = "顶级任务工单id", notes = "顶级任务工单id")
   @JsonProperty("topTaskOrderId")
   @JSONField(name = "topTaskOrderId")
   @TableField(value = "top_task_order_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "top_task_order_id", columnDefinition = "bigint(20) default '0' COMMENT '顶级任务工单id'")
   private Long topTaskOrderId;
   @ApiModelProperty(name = "classificationId", value = "分类id", notes = "分类id")
   @JsonProperty("classificationId")
   @JSONField(name = "classificationId")
   @TableField("classification_id")
   @Column(name = "classification_id", columnDefinition = "bigint(20) default '0' COMMENT '分类id'")
   private Long classificationId;
   @ApiModelProperty(name = "boolCompleteEnum", value = "是否完成", notes = "是否完成")
   @JsonProperty("boolCompleteEnum")
   @JSONField(name = "boolCompleteEnum")
   @TableField("bool_complete_enum")
   @Column(name = "bool_complete_enum", columnDefinition = "tinyint(1) default '0' COMMENT '是否完成'")
   private Long boolCompleteEnum;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default 1 COMMENT '生产线类型 1传统线 2智能线'", nullable = false)
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "nestCutPlateId", value = "切割指令id", notes = "切割指令id")
   @JsonProperty("nestCutPlateId")
   @JSONField(name = "nestCutPlateId")
   @TableField("nest_cut_plate_id")
   @Column(name = "nest_cut_plate_id", columnDefinition = "bigint(20) default '0' COMMENT '切割指令id'")
   private Long nestCutPlateId;
   @ApiModelProperty(name = "boolOneCode", value = "是否一物一码", notes = "是否一物一码")
   @JsonProperty("boolOneCode")
   @JSONField(name = "boolOneCode")
   @TableField("bool_one_code")
   @Column(name = "bool_one_code", columnDefinition = "tinyint(1) default '1' COMMENT '是否一物一码'")
   private Boolean boolOneCode;
   @ApiModelProperty(name = "boolPrint", value = "是否打印过", notes = "是否打印过")
   @JsonProperty("boolPrint")
   @JSONField(name = "boolPrint")
   @TableField("bool_print")
   @Column(name = "bool_print", columnDefinition = "tinyint(1) default '0' COMMENT '是否打印过'")
   private Boolean boolPrint;
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

   public static MesBuildingTask.MesBuildingTaskBuilder builder() {
      return new MesBuildingTask.MesBuildingTaskBuilder();
   }

   public MesBuildingTask() {
   }

   public MesBuildingTask(
      final Long id,
      final Long factoryId,
      final Long schedulingId,
      final Long machinePartSchedulingId,
      final Long workshopId,
      final Long productionLineId,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long productId,
      final Integer taskTypeEnum,
      final Long productProcessId,
      final Integer taskQuantity,
      final Integer inProductionQuantity,
      final Integer completeQuantity,
      final Integer useQuantity,
      final Integer status,
      final Boolean technologyStatus,
      final LocalDateTime askCompleteTime,
      final LocalDateTime inProductionTime,
      final LocalDateTime completeTime,
      final Long userId,
      final Integer printQuantity,
      final LocalDateTime printTime,
      final Long groupsId,
      final Long taskOrderId,
      final Long topTaskOrderId,
      final Long classificationId,
      final Long boolCompleteEnum,
      final Integer productionLineTypeEnum,
      final Long nestCutPlateId,
      final Boolean boolOneCode,
      final Boolean boolPrint,
      final String inYearMonthDayDate,
      final String inYearMonthDate
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.schedulingId = schedulingId;
      this.machinePartSchedulingId = machinePartSchedulingId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.productProcessId = productProcessId;
      this.taskQuantity = taskQuantity;
      this.inProductionQuantity = inProductionQuantity;
      this.completeQuantity = completeQuantity;
      this.useQuantity = useQuantity;
      this.status = status;
      this.technologyStatus = technologyStatus;
      this.askCompleteTime = askCompleteTime;
      this.inProductionTime = inProductionTime;
      this.completeTime = completeTime;
      this.userId = userId;
      this.printQuantity = printQuantity;
      this.printTime = printTime;
      this.groupsId = groupsId;
      this.taskOrderId = taskOrderId;
      this.topTaskOrderId = topTaskOrderId;
      this.classificationId = classificationId;
      this.boolCompleteEnum = boolCompleteEnum;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.nestCutPlateId = nestCutPlateId;
      this.boolOneCode = boolOneCode;
      this.boolPrint = boolPrint;
      this.inYearMonthDayDate = inYearMonthDayDate;
      this.inYearMonthDate = inYearMonthDate;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getMachinePartSchedulingId() {
      return this.machinePartSchedulingId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
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

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getUseQuantity() {
      return this.useQuantity;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getTechnologyStatus() {
      return this.technologyStatus;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getInProductionTime() {
      return this.inProductionTime;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getTopTaskOrderId() {
      return this.topTaskOrderId;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public Long getBoolCompleteEnum() {
      return this.boolCompleteEnum;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Long getNestCutPlateId() {
      return this.nestCutPlateId;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public Boolean getBoolPrint() {
      return this.boolPrint;
   }

   public String getInYearMonthDayDate() {
      return this.inYearMonthDayDate;
   }

   public String getInYearMonthDate() {
      return this.inYearMonthDate;
   }

   @JsonProperty("id")
   public MesBuildingTask setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingTask setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingTask setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("machinePartSchedulingId")
   public MesBuildingTask setMachinePartSchedulingId(final Long machinePartSchedulingId) {
      this.machinePartSchedulingId = machinePartSchedulingId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTask setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTask setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingTask setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingTask setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingTask setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingTask setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTask setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingTask setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesBuildingTask setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingTask setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public MesBuildingTask setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingTask setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("useQuantity")
   public MesBuildingTask setUseQuantity(final Integer useQuantity) {
      this.useQuantity = useQuantity;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingTask setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("technologyStatus")
   public MesBuildingTask setTechnologyStatus(final Boolean technologyStatus) {
      this.technologyStatus = technologyStatus;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTask setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("inProductionTime")
   public MesBuildingTask setInProductionTime(final LocalDateTime inProductionTime) {
      this.inProductionTime = inProductionTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingTask setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTask setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesBuildingTask setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("printTime")
   public MesBuildingTask setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTask setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingTask setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("topTaskOrderId")
   public MesBuildingTask setTopTaskOrderId(final Long topTaskOrderId) {
      this.topTaskOrderId = topTaskOrderId;
      return this;
   }

   @JsonProperty("classificationId")
   public MesBuildingTask setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   @JsonProperty("boolCompleteEnum")
   public MesBuildingTask setBoolCompleteEnum(final Long boolCompleteEnum) {
      this.boolCompleteEnum = boolCompleteEnum;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public MesBuildingTask setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("nestCutPlateId")
   public MesBuildingTask setNestCutPlateId(final Long nestCutPlateId) {
      this.nestCutPlateId = nestCutPlateId;
      return this;
   }

   @JsonProperty("boolOneCode")
   public MesBuildingTask setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   @JsonProperty("boolPrint")
   public MesBuildingTask setBoolPrint(final Boolean boolPrint) {
      this.boolPrint = boolPrint;
      return this;
   }

   @JsonProperty("inYearMonthDayDate")
   public MesBuildingTask setInYearMonthDayDate(final String inYearMonthDayDate) {
      this.inYearMonthDayDate = inYearMonthDayDate;
      return this;
   }

   @JsonProperty("inYearMonthDate")
   public MesBuildingTask setInYearMonthDate(final String inYearMonthDate) {
      this.inYearMonthDate = inYearMonthDate;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTask(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", machinePartSchedulingId="
         + this.getMachinePartSchedulingId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", productProcessId="
         + this.getProductProcessId()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", useQuantity="
         + this.getUseQuantity()
         + ", status="
         + this.getStatus()
         + ", technologyStatus="
         + this.getTechnologyStatus()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", inProductionTime="
         + this.getInProductionTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", userId="
         + this.getUserId()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", printTime="
         + this.getPrintTime()
         + ", groupsId="
         + this.getGroupsId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", topTaskOrderId="
         + this.getTopTaskOrderId()
         + ", classificationId="
         + this.getClassificationId()
         + ", boolCompleteEnum="
         + this.getBoolCompleteEnum()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", nestCutPlateId="
         + this.getNestCutPlateId()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", boolPrint="
         + this.getBoolPrint()
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

      if (!(o instanceof MesBuildingTask)) {
         return false;
      }

      MesBuildingTask other = (MesBuildingTask)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$schedulingId = this.getSchedulingId();
            Object other$schedulingId = other.getSchedulingId();
            if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
               Object this$machinePartSchedulingId = this.getMachinePartSchedulingId();
               Object other$machinePartSchedulingId = other.getMachinePartSchedulingId();
               if (this$machinePartSchedulingId == null
                  ? other$machinePartSchedulingId == null
                  : this$machinePartSchedulingId.equals(other$machinePartSchedulingId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
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
                                    Object this$productId = this.getProductId();
                                    Object other$productId = other.getProductId();
                                    if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                       Object this$taskTypeEnum = this.getTaskTypeEnum();
                                       Object other$taskTypeEnum = other.getTaskTypeEnum();
                                       if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                                          Object this$productProcessId = this.getProductProcessId();
                                          Object other$productProcessId = other.getProductProcessId();
                                          if (this$productProcessId == null
                                             ? other$productProcessId == null
                                             : this$productProcessId.equals(other$productProcessId)) {
                                             Object this$taskQuantity = this.getTaskQuantity();
                                             Object other$taskQuantity = other.getTaskQuantity();
                                             if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                                                Object this$inProductionQuantity = this.getInProductionQuantity();
                                                Object other$inProductionQuantity = other.getInProductionQuantity();
                                                if (this$inProductionQuantity == null
                                                   ? other$inProductionQuantity == null
                                                   : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                                                   Object this$completeQuantity = this.getCompleteQuantity();
                                                   Object other$completeQuantity = other.getCompleteQuantity();
                                                   if (this$completeQuantity == null
                                                      ? other$completeQuantity == null
                                                      : this$completeQuantity.equals(other$completeQuantity)) {
                                                      Object this$useQuantity = this.getUseQuantity();
                                                      Object other$useQuantity = other.getUseQuantity();
                                                      if (this$useQuantity == null ? other$useQuantity == null : this$useQuantity.equals(other$useQuantity)) {
                                                         Object this$status = this.getStatus();
                                                         Object other$status = other.getStatus();
                                                         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                                            Object this$technologyStatus = this.getTechnologyStatus();
                                                            Object other$technologyStatus = other.getTechnologyStatus();
                                                            if (this$technologyStatus == null
                                                               ? other$technologyStatus == null
                                                               : this$technologyStatus.equals(other$technologyStatus)) {
                                                               Object this$userId = this.getUserId();
                                                               Object other$userId = other.getUserId();
                                                               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                                  Object this$printQuantity = this.getPrintQuantity();
                                                                  Object other$printQuantity = other.getPrintQuantity();
                                                                  if (this$printQuantity == null
                                                                     ? other$printQuantity == null
                                                                     : this$printQuantity.equals(other$printQuantity)) {
                                                                     Object this$groupsId = this.getGroupsId();
                                                                     Object other$groupsId = other.getGroupsId();
                                                                     if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                                                                        Object this$taskOrderId = this.getTaskOrderId();
                                                                        Object other$taskOrderId = other.getTaskOrderId();
                                                                        if (this$taskOrderId == null
                                                                           ? other$taskOrderId == null
                                                                           : this$taskOrderId.equals(other$taskOrderId)) {
                                                                           Object this$topTaskOrderId = this.getTopTaskOrderId();
                                                                           Object other$topTaskOrderId = other.getTopTaskOrderId();
                                                                           if (this$topTaskOrderId == null
                                                                              ? other$topTaskOrderId == null
                                                                              : this$topTaskOrderId.equals(other$topTaskOrderId)) {
                                                                              Object this$classificationId = this.getClassificationId();
                                                                              Object other$classificationId = other.getClassificationId();
                                                                              if (this$classificationId == null
                                                                                 ? other$classificationId == null
                                                                                 : this$classificationId.equals(other$classificationId)) {
                                                                                 Object this$boolCompleteEnum = this.getBoolCompleteEnum();
                                                                                 Object other$boolCompleteEnum = other.getBoolCompleteEnum();
                                                                                 if (this$boolCompleteEnum == null
                                                                                    ? other$boolCompleteEnum == null
                                                                                    : this$boolCompleteEnum.equals(other$boolCompleteEnum)) {
                                                                                    Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                                                                                    Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                                                                                    if (this$productionLineTypeEnum == null
                                                                                       ? other$productionLineTypeEnum == null
                                                                                       : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                                                                                       Object this$nestCutPlateId = this.getNestCutPlateId();
                                                                                       Object other$nestCutPlateId = other.getNestCutPlateId();
                                                                                       if (this$nestCutPlateId == null
                                                                                          ? other$nestCutPlateId == null
                                                                                          : this$nestCutPlateId.equals(other$nestCutPlateId)) {
                                                                                          Object this$boolOneCode = this.getBoolOneCode();
                                                                                          Object other$boolOneCode = other.getBoolOneCode();
                                                                                          if (this$boolOneCode == null
                                                                                             ? other$boolOneCode == null
                                                                                             : this$boolOneCode.equals(other$boolOneCode)) {
                                                                                             Object this$boolPrint = this.getBoolPrint();
                                                                                             Object other$boolPrint = other.getBoolPrint();
                                                                                             if (this$boolPrint == null
                                                                                                ? other$boolPrint == null
                                                                                                : this$boolPrint.equals(other$boolPrint)) {
                                                                                                Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                                Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                                if (this$askCompleteTime == null
                                                                                                   ? other$askCompleteTime == null
                                                                                                   : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                                                   Object this$inProductionTime = this.getInProductionTime();
                                                                                                   Object other$inProductionTime = other.getInProductionTime();
                                                                                                   if (this$inProductionTime == null
                                                                                                      ? other$inProductionTime == null
                                                                                                      : this$inProductionTime.equals(other$inProductionTime)) {
                                                                                                      Object this$completeTime = this.getCompleteTime();
                                                                                                      Object other$completeTime = other.getCompleteTime();
                                                                                                      if (this$completeTime == null
                                                                                                         ? other$completeTime == null
                                                                                                         : this$completeTime.equals(other$completeTime)) {
                                                                                                         Object this$printTime = this.getPrintTime();
                                                                                                         Object other$printTime = other.getPrintTime();
                                                                                                         if (this$printTime == null
                                                                                                            ? other$printTime == null
                                                                                                            : this$printTime.equals(other$printTime)) {
                                                                                                            Object this$inYearMonthDayDate = this.getInYearMonthDayDate();
                                                                                                            Object other$inYearMonthDayDate = other.getInYearMonthDayDate();
                                                                                                            if (this$inYearMonthDayDate == null
                                                                                                               ? other$inYearMonthDayDate == null
                                                                                                               : this$inYearMonthDayDate.equals(
                                                                                                                  other$inYearMonthDayDate
                                                                                                               )) {
                                                                                                               Object this$inYearMonthDate = this.getInYearMonthDate();
                                                                                                               Object other$inYearMonthDate = other.getInYearMonthDate();
                                                                                                               return this$inYearMonthDate == null
                                                                                                                  ? other$inYearMonthDate == null
                                                                                                                  : this$inYearMonthDate.equals(
                                                                                                                     other$inYearMonthDate
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTask;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $machinePartSchedulingId = this.getMachinePartSchedulingId();
      result = result * 59 + ($machinePartSchedulingId == null ? 43 : $machinePartSchedulingId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $useQuantity = this.getUseQuantity();
      result = result * 59 + ($useQuantity == null ? 43 : $useQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $technologyStatus = this.getTechnologyStatus();
      result = result * 59 + ($technologyStatus == null ? 43 : $technologyStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $topTaskOrderId = this.getTopTaskOrderId();
      result = result * 59 + ($topTaskOrderId == null ? 43 : $topTaskOrderId.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $boolCompleteEnum = this.getBoolCompleteEnum();
      result = result * 59 + ($boolCompleteEnum == null ? 43 : $boolCompleteEnum.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $nestCutPlateId = this.getNestCutPlateId();
      result = result * 59 + ($nestCutPlateId == null ? 43 : $nestCutPlateId.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $boolPrint = this.getBoolPrint();
      result = result * 59 + ($boolPrint == null ? 43 : $boolPrint.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $inProductionTime = this.getInProductionTime();
      result = result * 59 + ($inProductionTime == null ? 43 : $inProductionTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $printTime = this.getPrintTime();
      result = result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
      Object $inYearMonthDayDate = this.getInYearMonthDayDate();
      result = result * 59 + ($inYearMonthDayDate == null ? 43 : $inYearMonthDayDate.hashCode());
      Object $inYearMonthDate = this.getInYearMonthDate();
      return result * 59 + ($inYearMonthDate == null ? 43 : $inYearMonthDate.hashCode());
   }

   public static class MesBuildingTaskBuilder {
      private Long id;
      private Long factoryId;
      private Long schedulingId;
      private Long machinePartSchedulingId;
      private Long workshopId;
      private Long productionLineId;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long productId;
      private Integer taskTypeEnum;
      private Long productProcessId;
      private Integer taskQuantity;
      private Integer inProductionQuantity;
      private Integer completeQuantity;
      private Integer useQuantity;
      private Integer status;
      private Boolean technologyStatus;
      private LocalDateTime askCompleteTime;
      private LocalDateTime inProductionTime;
      private LocalDateTime completeTime;
      private Long userId;
      private Integer printQuantity;
      private LocalDateTime printTime;
      private Long groupsId;
      private Long taskOrderId;
      private Long topTaskOrderId;
      private Long classificationId;
      private Long boolCompleteEnum;
      private Integer productionLineTypeEnum;
      private Long nestCutPlateId;
      private Boolean boolOneCode;
      private Boolean boolPrint;
      private String inYearMonthDayDate;
      private String inYearMonthDate;

      MesBuildingTaskBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTask.MesBuildingTaskBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingTask.MesBuildingTaskBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingTask.MesBuildingTaskBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("machinePartSchedulingId")
      public MesBuildingTask.MesBuildingTaskBuilder machinePartSchedulingId(final Long machinePartSchedulingId) {
         this.machinePartSchedulingId = machinePartSchedulingId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTask.MesBuildingTaskBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTask.MesBuildingTaskBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingTask.MesBuildingTaskBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingTask.MesBuildingTaskBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingTask.MesBuildingTaskBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingTask.MesBuildingTaskBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTask.MesBuildingTaskBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingTask.MesBuildingTaskBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesBuildingTask.MesBuildingTaskBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingTask.MesBuildingTaskBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public MesBuildingTask.MesBuildingTaskBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingTask.MesBuildingTaskBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("useQuantity")
      public MesBuildingTask.MesBuildingTaskBuilder useQuantity(final Integer useQuantity) {
         this.useQuantity = useQuantity;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingTask.MesBuildingTaskBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("technologyStatus")
      public MesBuildingTask.MesBuildingTaskBuilder technologyStatus(final Boolean technologyStatus) {
         this.technologyStatus = technologyStatus;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTask.MesBuildingTaskBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("inProductionTime")
      public MesBuildingTask.MesBuildingTaskBuilder inProductionTime(final LocalDateTime inProductionTime) {
         this.inProductionTime = inProductionTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingTask.MesBuildingTaskBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTask.MesBuildingTaskBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesBuildingTask.MesBuildingTaskBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("printTime")
      public MesBuildingTask.MesBuildingTaskBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTask.MesBuildingTaskBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingTask.MesBuildingTaskBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("topTaskOrderId")
      public MesBuildingTask.MesBuildingTaskBuilder topTaskOrderId(final Long topTaskOrderId) {
         this.topTaskOrderId = topTaskOrderId;
         return this;
      }

      @JsonProperty("classificationId")
      public MesBuildingTask.MesBuildingTaskBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      @JsonProperty("boolCompleteEnum")
      public MesBuildingTask.MesBuildingTaskBuilder boolCompleteEnum(final Long boolCompleteEnum) {
         this.boolCompleteEnum = boolCompleteEnum;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public MesBuildingTask.MesBuildingTaskBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("nestCutPlateId")
      public MesBuildingTask.MesBuildingTaskBuilder nestCutPlateId(final Long nestCutPlateId) {
         this.nestCutPlateId = nestCutPlateId;
         return this;
      }

      @JsonProperty("boolOneCode")
      public MesBuildingTask.MesBuildingTaskBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      @JsonProperty("boolPrint")
      public MesBuildingTask.MesBuildingTaskBuilder boolPrint(final Boolean boolPrint) {
         this.boolPrint = boolPrint;
         return this;
      }

      @JsonProperty("inYearMonthDayDate")
      public MesBuildingTask.MesBuildingTaskBuilder inYearMonthDayDate(final String inYearMonthDayDate) {
         this.inYearMonthDayDate = inYearMonthDayDate;
         return this;
      }

      @JsonProperty("inYearMonthDate")
      public MesBuildingTask.MesBuildingTaskBuilder inYearMonthDate(final String inYearMonthDate) {
         this.inYearMonthDate = inYearMonthDate;
         return this;
      }

      public MesBuildingTask build() {
         return new MesBuildingTask(
            this.id,
            this.factoryId,
            this.schedulingId,
            this.machinePartSchedulingId,
            this.workshopId,
            this.productionLineId,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
            this.productId,
            this.taskTypeEnum,
            this.productProcessId,
            this.taskQuantity,
            this.inProductionQuantity,
            this.completeQuantity,
            this.useQuantity,
            this.status,
            this.technologyStatus,
            this.askCompleteTime,
            this.inProductionTime,
            this.completeTime,
            this.userId,
            this.printQuantity,
            this.printTime,
            this.groupsId,
            this.taskOrderId,
            this.topTaskOrderId,
            this.classificationId,
            this.boolCompleteEnum,
            this.productionLineTypeEnum,
            this.nestCutPlateId,
            this.boolOneCode,
            this.boolPrint,
            this.inYearMonthDayDate,
            this.inYearMonthDate
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTask.MesBuildingTaskBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", schedulingId="
            + this.schedulingId
            + ", machinePartSchedulingId="
            + this.machinePartSchedulingId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", productProcessId="
            + this.productProcessId
            + ", taskQuantity="
            + this.taskQuantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", useQuantity="
            + this.useQuantity
            + ", status="
            + this.status
            + ", technologyStatus="
            + this.technologyStatus
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", inProductionTime="
            + this.inProductionTime
            + ", completeTime="
            + this.completeTime
            + ", userId="
            + this.userId
            + ", printQuantity="
            + this.printQuantity
            + ", printTime="
            + this.printTime
            + ", groupsId="
            + this.groupsId
            + ", taskOrderId="
            + this.taskOrderId
            + ", topTaskOrderId="
            + this.topTaskOrderId
            + ", classificationId="
            + this.classificationId
            + ", boolCompleteEnum="
            + this.boolCompleteEnum
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", nestCutPlateId="
            + this.nestCutPlateId
            + ", boolOneCode="
            + this.boolOneCode
            + ", boolPrint="
            + this.boolPrint
            + ", inYearMonthDayDate="
            + this.inYearMonthDayDate
            + ", inYearMonthDate="
            + this.inYearMonthDate
            + ")";
      }
   }
}
