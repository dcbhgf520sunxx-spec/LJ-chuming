package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
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

@ApiModel(value = "MesBuildingTaskProcess对象", description = "任务分配工序详情表 ")
@Entity
@TableName("mes_building_task_process")
@Table(
   name = "mes_building_task_process",
   indexes = {
         @Index(name = "productId_index", columnList = "product_id"),
         @Index(name = "projectId_index", columnList = "project_id"),
         @Index(name = "taskTypeEnum_index", columnList = "task_type_enum"),
         @Index(name = "in_year_month_day_date", columnList = "in_year_month_day_date"),
         @Index(name = "in_year_month_date", columnList = "in_year_month_date")
   }
)
public class MesBuildingTaskProcess extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
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
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
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
   @ApiModelProperty(name = "needQuantity", value = "本工序需要生产的数量", notes = "本工序需要生产的数量")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   @TableField("need_quantity")
   @Column(name = "need_quantity", columnDefinition = "int(11) default '0' COMMENT '本工序需要生产的数量'", nullable = false)
   private Integer needQuantity;
   @ApiModelProperty(name = "completeQuantity", value = "此道工序已完成数量", notes = "此道工序已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   @TableField("complete_quantity")
   @Column(name = "complete_quantity", columnDefinition = "int(11) default '0' COMMENT '此道工序已完成数量'", nullable = false)
   private Integer completeQuantity;
   @ApiModelProperty(name = "inspectionQuantity", value = "通过质检数量", notes = "通过质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   @TableField("inspection_quantity")
   @Column(name = "inspection_quantity", columnDefinition = "int(11) default '0' COMMENT '通过质检数量'", nullable = false)
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "problemQuantity", value = "问题上报数量", notes = "问题上报数量")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   @TableField("problem_quantity")
   @Column(name = "problem_quantity", columnDefinition = "int(11) default '0' COMMENT '问题上报数量'", nullable = false)
   private Integer problemQuantity;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "nextProcessId", value = "下一道工序id", notes = "下一道工序id")
   @JsonProperty("nextProcessId")
   @JSONField(name = "nextProcessId")
   @TableField("next_process_id")
   @Column(name = "next_process_id", columnDefinition = "bigint(20)  COMMENT '下一道工序id'", nullable = true)
   private Long nextProcessId;
   @ApiModelProperty(name = "sequence", value = "工序顺序", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   @TableField("sequence")
   @Column(name = "sequence", columnDefinition = "int(11) default '0' COMMENT '工序顺序'", nullable = false)
   private Integer sequence;
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
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "teamId", value = "生产班组", notes = "生产班组")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20) default '0' COMMENT '生产组id'")
   private Long teamId;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20) default '0' COMMENT '任务工单id'")
   private Long taskOrderId;
   @ApiModelProperty(name = "nestCutPlateId", value = "切割指令id", notes = "切割指令id")
   @JsonProperty("nestCutPlateId")
   @JSONField(name = "nestCutPlateId")
   @TableField("nest_cut_plate_id")
   @Column(name = "nest_cut_plate_id", columnDefinition = "bigint(20) default '0' COMMENT '切割指令id'")
   private Long nestCutPlateId;
   @ApiModelProperty(name = "boolParallelProcess", value = "是否为并行工序[0 单工序 1 并行工序 ]", notes = "是否为并行工序[0 单工序 1 并行工序 ]")
   @JsonProperty("boolParallelProcess")
   @JSONField(name = "boolParallelProcess")
   @Column(name = "bool_parallel_process", columnDefinition = "tinyint(1) default '0' COMMENT '是否为并行工序[0 单工序 1 并行工序 ]'", nullable = false)
   private Boolean boolParallelProcess;
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

   public static MesBuildingTaskProcess.MesBuildingTaskProcessBuilder builder() {
      return new MesBuildingTaskProcess.MesBuildingTaskProcessBuilder();
   }

   public MesBuildingTaskProcess() {
   }

   public MesBuildingTaskProcess(
      final Long id,
      final Long factoryId,
      final Long schedulingId,
      final Long machinePartSchedulingId,
      final Long taskId,
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
      final Integer needQuantity,
      final Integer completeQuantity,
      final Integer inspectionQuantity,
      final Integer problemQuantity,
      final Long processId,
      final Long nextProcessId,
      final Integer sequence,
      final Integer status,
      final Boolean technologyStatus,
      final LocalDateTime askCompleteTime,
      final LocalDateTime completeTime,
      final Long userId,
      final Long groupsId,
      final Long teamId,
      final Long taskOrderId,
      final Long nestCutPlateId,
      final Boolean boolParallelProcess,
      final String inYearMonthDayDate,
      final String inYearMonthDate
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.schedulingId = schedulingId;
      this.machinePartSchedulingId = machinePartSchedulingId;
      this.taskId = taskId;
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
      this.needQuantity = needQuantity;
      this.completeQuantity = completeQuantity;
      this.inspectionQuantity = inspectionQuantity;
      this.problemQuantity = problemQuantity;
      this.processId = processId;
      this.nextProcessId = nextProcessId;
      this.sequence = sequence;
      this.status = status;
      this.technologyStatus = technologyStatus;
      this.askCompleteTime = askCompleteTime;
      this.completeTime = completeTime;
      this.userId = userId;
      this.groupsId = groupsId;
      this.teamId = teamId;
      this.taskOrderId = taskOrderId;
      this.nestCutPlateId = nestCutPlateId;
      this.boolParallelProcess = boolParallelProcess;
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

   public Long getTaskId() {
      return this.taskId;
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

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getNextProcessId() {
      return this.nextProcessId;
   }

   public Integer getSequence() {
      return this.sequence;
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

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getNestCutPlateId() {
      return this.nestCutPlateId;
   }

   public Boolean getBoolParallelProcess() {
      return this.boolParallelProcess;
   }

   public String getInYearMonthDayDate() {
      return this.inYearMonthDayDate;
   }

   public String getInYearMonthDate() {
      return this.inYearMonthDate;
   }

   @JsonProperty("id")
   public MesBuildingTaskProcess setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingTaskProcess setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingTaskProcess setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("machinePartSchedulingId")
   public MesBuildingTaskProcess setMachinePartSchedulingId(final Long machinePartSchedulingId) {
      this.machinePartSchedulingId = machinePartSchedulingId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingTaskProcess setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTaskProcess setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTaskProcess setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingTaskProcess setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingTaskProcess setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingTaskProcess setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingTaskProcess setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTaskProcess setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingTaskProcess setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesBuildingTaskProcess setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingTaskProcess setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("needQuantity")
   public MesBuildingTaskProcess setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingTaskProcess setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesBuildingTaskProcess setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesBuildingTaskProcess setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTaskProcess setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("nextProcessId")
   public MesBuildingTaskProcess setNextProcessId(final Long nextProcessId) {
      this.nextProcessId = nextProcessId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingTaskProcess setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingTaskProcess setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("technologyStatus")
   public MesBuildingTaskProcess setTechnologyStatus(final Boolean technologyStatus) {
      this.technologyStatus = technologyStatus;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskProcess setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingTaskProcess setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTaskProcess setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingTaskProcess setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingTaskProcess setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingTaskProcess setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("nestCutPlateId")
   public MesBuildingTaskProcess setNestCutPlateId(final Long nestCutPlateId) {
      this.nestCutPlateId = nestCutPlateId;
      return this;
   }

   @JsonProperty("boolParallelProcess")
   public MesBuildingTaskProcess setBoolParallelProcess(final Boolean boolParallelProcess) {
      this.boolParallelProcess = boolParallelProcess;
      return this;
   }

   @JsonProperty("inYearMonthDayDate")
   public MesBuildingTaskProcess setInYearMonthDayDate(final String inYearMonthDayDate) {
      this.inYearMonthDayDate = inYearMonthDayDate;
      return this;
   }

   @JsonProperty("inYearMonthDate")
   public MesBuildingTaskProcess setInYearMonthDate(final String inYearMonthDate) {
      this.inYearMonthDate = inYearMonthDate;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskProcess(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", machinePartSchedulingId="
         + this.getMachinePartSchedulingId()
         + ", taskId="
         + this.getTaskId()
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
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", processId="
         + this.getProcessId()
         + ", nextProcessId="
         + this.getNextProcessId()
         + ", sequence="
         + this.getSequence()
         + ", status="
         + this.getStatus()
         + ", technologyStatus="
         + this.getTechnologyStatus()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", completeTime="
         + this.getCompleteTime()
         + ", userId="
         + this.getUserId()
         + ", groupsId="
         + this.getGroupsId()
         + ", teamId="
         + this.getTeamId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", nestCutPlateId="
         + this.getNestCutPlateId()
         + ", boolParallelProcess="
         + this.getBoolParallelProcess()
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

      if (!(o instanceof MesBuildingTaskProcess)) {
         return false;
      }

      MesBuildingTaskProcess other = (MesBuildingTaskProcess)o;
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
                  Object this$taskId = this.getTaskId();
                  Object other$taskId = other.getTaskId();
                  if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
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
                                                   Object this$needQuantity = this.getNeedQuantity();
                                                   Object other$needQuantity = other.getNeedQuantity();
                                                   if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
                                                      Object this$completeQuantity = this.getCompleteQuantity();
                                                      Object other$completeQuantity = other.getCompleteQuantity();
                                                      if (this$completeQuantity == null
                                                         ? other$completeQuantity == null
                                                         : this$completeQuantity.equals(other$completeQuantity)) {
                                                         Object this$inspectionQuantity = this.getInspectionQuantity();
                                                         Object other$inspectionQuantity = other.getInspectionQuantity();
                                                         if (this$inspectionQuantity == null
                                                            ? other$inspectionQuantity == null
                                                            : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                                                            Object this$problemQuantity = this.getProblemQuantity();
                                                            Object other$problemQuantity = other.getProblemQuantity();
                                                            if (this$problemQuantity == null
                                                               ? other$problemQuantity == null
                                                               : this$problemQuantity.equals(other$problemQuantity)) {
                                                               Object this$processId = this.getProcessId();
                                                               Object other$processId = other.getProcessId();
                                                               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                                                  Object this$nextProcessId = this.getNextProcessId();
                                                                  Object other$nextProcessId = other.getNextProcessId();
                                                                  if (this$nextProcessId == null
                                                                     ? other$nextProcessId == null
                                                                     : this$nextProcessId.equals(other$nextProcessId)) {
                                                                     Object this$sequence = this.getSequence();
                                                                     Object other$sequence = other.getSequence();
                                                                     if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
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
                                                                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)
                                                                                 )
                                                                               {
                                                                                 Object this$groupsId = this.getGroupsId();
                                                                                 Object other$groupsId = other.getGroupsId();
                                                                                 if (this$groupsId == null
                                                                                    ? other$groupsId == null
                                                                                    : this$groupsId.equals(other$groupsId)) {
                                                                                    Object this$teamId = this.getTeamId();
                                                                                    Object other$teamId = other.getTeamId();
                                                                                    if (this$teamId == null
                                                                                       ? other$teamId == null
                                                                                       : this$teamId.equals(other$teamId)) {
                                                                                       Object this$taskOrderId = this.getTaskOrderId();
                                                                                       Object other$taskOrderId = other.getTaskOrderId();
                                                                                       if (this$taskOrderId == null
                                                                                          ? other$taskOrderId == null
                                                                                          : this$taskOrderId.equals(other$taskOrderId)) {
                                                                                          Object this$nestCutPlateId = this.getNestCutPlateId();
                                                                                          Object other$nestCutPlateId = other.getNestCutPlateId();
                                                                                          if (this$nestCutPlateId == null
                                                                                             ? other$nestCutPlateId == null
                                                                                             : this$nestCutPlateId.equals(other$nestCutPlateId)) {
                                                                                             Object this$boolParallelProcess = this.getBoolParallelProcess();
                                                                                             Object other$boolParallelProcess = other.getBoolParallelProcess();
                                                                                             if (this$boolParallelProcess == null
                                                                                                ? other$boolParallelProcess == null
                                                                                                : this$boolParallelProcess.equals(other$boolParallelProcess)) {
                                                                                                Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                                Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                                if (this$askCompleteTime == null
                                                                                                   ? other$askCompleteTime == null
                                                                                                   : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                                                   Object this$completeTime = this.getCompleteTime();
                                                                                                   Object other$completeTime = other.getCompleteTime();
                                                                                                   if (this$completeTime == null
                                                                                                      ? other$completeTime == null
                                                                                                      : this$completeTime.equals(other$completeTime)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskProcess;
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
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
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
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $nextProcessId = this.getNextProcessId();
      result = result * 59 + ($nextProcessId == null ? 43 : $nextProcessId.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $technologyStatus = this.getTechnologyStatus();
      result = result * 59 + ($technologyStatus == null ? 43 : $technologyStatus.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $nestCutPlateId = this.getNestCutPlateId();
      result = result * 59 + ($nestCutPlateId == null ? 43 : $nestCutPlateId.hashCode());
      Object $boolParallelProcess = this.getBoolParallelProcess();
      result = result * 59 + ($boolParallelProcess == null ? 43 : $boolParallelProcess.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $inYearMonthDayDate = this.getInYearMonthDayDate();
      result = result * 59 + ($inYearMonthDayDate == null ? 43 : $inYearMonthDayDate.hashCode());
      Object $inYearMonthDate = this.getInYearMonthDate();
      return result * 59 + ($inYearMonthDate == null ? 43 : $inYearMonthDate.hashCode());
   }

   public static class MesBuildingTaskProcessBuilder {
      private Long id;
      private Long factoryId;
      private Long schedulingId;
      private Long machinePartSchedulingId;
      private Long taskId;
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
      private Integer needQuantity;
      private Integer completeQuantity;
      private Integer inspectionQuantity;
      private Integer problemQuantity;
      private Long processId;
      private Long nextProcessId;
      private Integer sequence;
      private Integer status;
      private Boolean technologyStatus;
      private LocalDateTime askCompleteTime;
      private LocalDateTime completeTime;
      private Long userId;
      private Long groupsId;
      private Long teamId;
      private Long taskOrderId;
      private Long nestCutPlateId;
      private Boolean boolParallelProcess;
      private String inYearMonthDayDate;
      private String inYearMonthDate;

      MesBuildingTaskProcessBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("machinePartSchedulingId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder machinePartSchedulingId(final Long machinePartSchedulingId) {
         this.machinePartSchedulingId = machinePartSchedulingId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("needQuantity")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("nextProcessId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder nextProcessId(final Long nextProcessId) {
         this.nextProcessId = nextProcessId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("technologyStatus")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder technologyStatus(final Boolean technologyStatus) {
         this.technologyStatus = technologyStatus;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("nestCutPlateId")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder nestCutPlateId(final Long nestCutPlateId) {
         this.nestCutPlateId = nestCutPlateId;
         return this;
      }

      @JsonProperty("boolParallelProcess")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder boolParallelProcess(final Boolean boolParallelProcess) {
         this.boolParallelProcess = boolParallelProcess;
         return this;
      }

      @JsonProperty("inYearMonthDayDate")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder inYearMonthDayDate(final String inYearMonthDayDate) {
         this.inYearMonthDayDate = inYearMonthDayDate;
         return this;
      }

      @JsonProperty("inYearMonthDate")
      public MesBuildingTaskProcess.MesBuildingTaskProcessBuilder inYearMonthDate(final String inYearMonthDate) {
         this.inYearMonthDate = inYearMonthDate;
         return this;
      }

      public MesBuildingTaskProcess build() {
         return new MesBuildingTaskProcess(
            this.id,
            this.factoryId,
            this.schedulingId,
            this.machinePartSchedulingId,
            this.taskId,
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
            this.needQuantity,
            this.completeQuantity,
            this.inspectionQuantity,
            this.problemQuantity,
            this.processId,
            this.nextProcessId,
            this.sequence,
            this.status,
            this.technologyStatus,
            this.askCompleteTime,
            this.completeTime,
            this.userId,
            this.groupsId,
            this.teamId,
            this.taskOrderId,
            this.nestCutPlateId,
            this.boolParallelProcess,
            this.inYearMonthDayDate,
            this.inYearMonthDate
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskProcess.MesBuildingTaskProcessBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", schedulingId="
            + this.schedulingId
            + ", machinePartSchedulingId="
            + this.machinePartSchedulingId
            + ", taskId="
            + this.taskId
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
            + ", needQuantity="
            + this.needQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", problemQuantity="
            + this.problemQuantity
            + ", processId="
            + this.processId
            + ", nextProcessId="
            + this.nextProcessId
            + ", sequence="
            + this.sequence
            + ", status="
            + this.status
            + ", technologyStatus="
            + this.technologyStatus
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", completeTime="
            + this.completeTime
            + ", userId="
            + this.userId
            + ", groupsId="
            + this.groupsId
            + ", teamId="
            + this.teamId
            + ", taskOrderId="
            + this.taskOrderId
            + ", nestCutPlateId="
            + this.nestCutPlateId
            + ", boolParallelProcess="
            + this.boolParallelProcess
            + ", inYearMonthDayDate="
            + this.inYearMonthDayDate
            + ", inYearMonthDate="
            + this.inYearMonthDate
            + ")";
      }
   }
}
