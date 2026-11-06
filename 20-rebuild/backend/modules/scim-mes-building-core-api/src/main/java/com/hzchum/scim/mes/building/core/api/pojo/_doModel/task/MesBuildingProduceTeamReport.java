package com.hzchum.scim.mes.building.core.api.pojo._doModel.task;

import cn.hutool.core.date.DatePattern;
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingProduceTeamReport对象", description = "班组生产上报记录表 ")
@Entity
@TableName("mes_building_produce_team_report")
@Table(
   name = "mes_building_produce_team_report",
   indexes = {
         @Index(name = "task_process_id", columnList = "task_process_id, team_id, user_id, groups_id, report_number"),
         @Index(name = "report_number", columnList = "report_number"),
         @Index(name = "task_process_id", columnList = "bool_delete_enum, product_id, task_type_enum, number"),
         @Index(name = "project_id", columnList = "project_id"),
         @Index(name = "monomer_id", columnList = "monomer_id"),
         @Index(name = "area_id", columnList = "area_id"),
         @Index(name = "workshop_id", columnList = "workshop_id"),
         @Index(name = "production_line_id", columnList = "production_line_id"),
         @Index(name = "in_year_month_day_date", columnList = "in_year_month_day_date"),
         @Index(name = "in_year_month_date", columnList = "in_year_month_date"),
         @Index(name = "task_id", columnList = "task_id,number"),
         @Index(name = "inspection_in_year_month_date", columnList = "inspection_in_year_month_date"),
         @Index(name = "inspection_in_year_month_day_date", columnList = "inspection_in_year_month_day_date"),
         @Index(name = "processAndLineIndex", columnList = "process_id, production_line_id"),
         @Index(name = "groupKey", columnList = "product_id,number,task_type_enum,process_id")
   }
)
public class MesBuildingProduceTeamReport extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
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
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目ID'")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) comment '单体ID'")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) comment '区域Id'")
   private Long areaId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'")
   private Long productionLineId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   @TableField("task_process_id")
   @Column(name = "task_process_id", columnDefinition = "bigint(20)  COMMENT '任务工序id'", nullable = false)
   private Long taskProcessId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = false)
   private Long processId;
   @ApiModelProperty(name = "schedulingId", value = "排产id", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @TableField("scheduling_id")
   @Column(name = "scheduling_id", columnDefinition = "bigint(20)  COMMENT '排产id'")
   private Long schedulingId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "isReversible", value = "是否被处理 [0 不可撤回, 1 可撤回]", notes = "是否被处理 [0 不可撤回, 1 可撤回]")
   @JsonProperty("isReversible")
   @JSONField(name = "isReversible")
   @TableField("is_reversible")
   @Column(name = "is_reversible", columnDefinition = "tinyint(1) COMMENT '是否被处理 [0 不可撤回, 1 可撤回]'")
   private Boolean isReversible;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", value = "生产数量", notes = "生产数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) default '0' COMMENT '生产数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "problemQuantity", value = "问题数量", notes = "问题数量")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   @TableField("problem_quantity")
   @Column(name = "problem_quantity", columnDefinition = "int(11) default '0' COMMENT '问题数量'", nullable = false)
   private Integer problemQuantity;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检通过数量", notes = "质检通过数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   @TableField("inspection_quantity")
   @Column(name = "inspection_quantity", columnDefinition = "int(11) default '0' COMMENT '质检通过数量'", nullable = false)
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "userId", value = "操作人", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '操作人'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人名称", notes = "操作人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(256)  COMMENT '操作人名称'")
   private String userName;
   @ApiModelProperty(name = "reportType", value = "上报类型 [0 正常上报, 1 异常上报]", notes = "上报类型 [0 正常上报, 1 异常上报]")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   @TableField("report_type")
   @Column(name = "report_type", columnDefinition = "int(11) default '0' COMMENT '上报类型 [0 正常上报, 1 异常上报]'", nullable = false)
   private Integer reportType;
   @ApiModelProperty(name = "boolHandleEnum", value = "是否被处理 [0 未处理, 1 已处理]", notes = "是否被处理 [0 未处理, 1 已处理]")
   @JsonProperty("boolHandleEnum")
   @JSONField(name = "boolHandleEnum")
   @TableField("bool_handle_enum")
   @Column(name = "bool_handle_enum", columnDefinition = "tinyint(1) default '0' COMMENT '是否被处理 [0 未处理, 1 已处理]'", nullable = true)
   private Boolean boolHandleEnum;
   @ApiModelProperty(name = "number", value = "构件生产编号", notes = "构件生产编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(20)  COMMENT '构件生产编号'")
   private Integer number;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20)  COMMENT '生产组id'")
   private Long groupsId;
   @ApiModelProperty(name = "assistId", value = "协同任务id", notes = "协同任务id")
   @JsonProperty("assistId")
   @JSONField(name = "assistId")
   @TableField(value = "assist_id", updateStrategy = FieldStrategy.IGNORED)
   @Column(name = "assist_id", columnDefinition = "bigint(20)  COMMENT '协同任务id'")
   private Long assistId;
   @ApiModelProperty(name = "reportTime", value = "上报时间", notes = "上报时间")
   @JsonProperty("reportTime")
   @JSONField(name = "reportTime")
   @TableField("report_time")
   @Column(name = "report_time", columnDefinition = "datetime(6)  COMMENT '上报时间'")
   private LocalDateTime reportTime;
   @ApiModelProperty(name = "reportNumber", value = "上报的次数", notes = "上报的次数")
   @JsonProperty("reportNumber")
   @JSONField(name = "reportNumber")
   @TableField("report_number")
   @Column(name = "report_number", columnDefinition = "bigint(20)  COMMENT '上报的次数'", nullable = false)
   private Long reportNumber;
   @ApiModelProperty(name = "useById", value = "二次利用原本质检报工记录", notes = "二次利用原本质检报工记录")
   @JsonProperty("useById")
   @JSONField(name = "useById")
   @TableField("use_by_id")
   @Column(name = "use_by_id", columnDefinition = "bigint(20)  COMMENT '二次利用原本质检报工记录'")
   private Long useById;
   @ApiModelProperty(name = "sequence", value = "工序顺序", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   @TableField("sequence")
   @Column(name = "sequence", columnDefinition = "int(11)  COMMENT '工序顺序'")
   private Integer sequence;
   @ApiModelProperty(name = "taskOrderId", value = "任务工单id", notes = "任务工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   @TableField("task_order_id")
   @Column(name = "task_order_id", columnDefinition = "bigint(20)  COMMENT '任务工单id'")
   private Long taskOrderId;
   @ApiModelProperty(name = "nestTask", value = "任务工单id", notes = "是否是套料任务")
   @JsonProperty("nestTask")
   @JSONField(name = "nestTask")
   @TableField("nest_task")
   @Column(name = "nest_task", columnDefinition = "tinyint(1)  COMMENT '是否是套料任务'")
   private Boolean nestTask;
   @ApiModelProperty(name = "boolWageElimination", value = "工价剔除(1: 已剔除, 0: 未剔除)")
   @TableField("bool_wage_elimination")
   @Column(name = "bool_wage_elimination", columnDefinition = "tinyint(1) default 0 COMMENT '工价剔除(1: 已剔除, 0: 未剔除)'", nullable = false)
   private Boolean boolWageElimination;
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
   @ApiModelProperty(name = "inspectionTime", value = "质检通过时间", notes = "质检通过时间")
   @JsonProperty("inspectionTime")
   @JSONField(name = "inspectionTime")
   @TableField("inspection_time")
   @Column(name = "inspection_time", columnDefinition = "datetime(6)  COMMENT '质检通过时间'")
   private LocalDateTime inspectionTime;
   @ApiModelProperty(name = "inspectionInYearMonthDayDate")
   @JsonProperty("inspectionInYearMonthDayDate")
   @JSONField(name = "inspectionInYearMonthDayDate")
   @TableField("inspection_in_year_month_day_date")
   @Column(name = "inspection_in_year_month_day_date", columnDefinition = "varchar(564) COMMENT '质检日期(年-月-日)'")
   private String inspectionInYearMonthDayDate;
   @ApiModelProperty(name = "inspectionInYearMonthDate")
   @JsonProperty("inspectionInYearMonthDate")
   @JSONField(name = "inspectionInYearMonthDate")
   @TableField("inspection_in_year_month_date")
   @Column(name = "inspection_in_year_month_date", columnDefinition = "varchar(564) COMMENT '质检日期日期(年-月)'")
   private String inspectionInYearMonthDate;
   @ApiModelProperty("是否固定工序(1:固定工序,0:灵活工序)")
   @TableField("bool_fixed_process")
   @Column(name = "bool_fixed_process", columnDefinition = "tinyint(1) default 1 COMMENT '是否固定工序(1:固定工序,0:灵活工序)'")
   private Boolean boolFixedProcess;
   @ApiModelProperty("打孔数")
   @TableField("perforate_quantity")
   @Column(name = "perforate_quantity", columnDefinition = "decimal(32,8) COMMENT '打孔数'")
   private BigDecimal perforateQuantity;
   @ApiModelProperty(name = "markingTime", value = "打标时间", notes = "打标时间")
   @JsonProperty("markingTime")
   @JSONField(name = "markingTime")
   @TableField("marking_time")
   @Column(name = "marking_time", columnDefinition = "datetime(6)  COMMENT '打标时间'")
   private LocalDateTime markingTime;
   @ApiModelProperty(name = "markedQuantity", value = "打标数量", notes = "打标数量")
   @JsonProperty("markedQuantity")
   @JSONField(name = "markedQuantity")
   @TableField("marked_quantity")
   @Column(name = "marked_quantity", columnDefinition = "int(11) default '0' COMMENT '生产数量'")
   private Integer markedQuantity;
   @ApiModelProperty(name = "boolMarked", value = "是否打标", notes = "是否打标")
   @JsonProperty("boolMarked")
   @JSONField(name = "boolMarked")
   @TableField("bool_marked")
   @Column(name = "bool_marked", columnDefinition = "tinyint(1) default '0' COMMENT '是否打标'")
   private Boolean boolMarked;

   public LocalDateTime getInspectionTime() {
      return this.inspectionTime == null && this.getInspectionQuantity() != 0 ? LocalDateTime.now() : this.inspectionTime;
   }

   public String getInspectionInYearMonthDayDate() {
      return this.inspectionInYearMonthDayDate == null && this.getInspectionQuantity() != 0
         ? LocalDate.now().format(DatePattern.NORM_DATE_FORMATTER)
         : this.inspectionInYearMonthDayDate;
   }

   public String getInspectionInYearMonthDate() {
      return this.inspectionInYearMonthDate == null && this.getInspectionQuantity() != 0
         ? LocalDate.now().format(DatePattern.NORM_MONTH_FORMATTER)
         : this.inspectionInYearMonthDate;
   }

   public static MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder builder() {
      return new MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder();
   }

   public MesBuildingProduceTeamReport() {
   }

   public MesBuildingProduceTeamReport(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long workshopId,
      final Long productionLineId,
      final Long taskId,
      final Long taskProcessId,
      final Long processId,
      final Long schedulingId,
      final Long productId,
      final Boolean isReversible,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Integer problemQuantity,
      final Integer inspectionQuantity,
      final Long teamId,
      final Long userId,
      final String userName,
      final Integer reportType,
      final Boolean boolHandleEnum,
      final Integer number,
      final Long groupsId,
      final Long assistId,
      final LocalDateTime reportTime,
      final Long reportNumber,
      final Long useById,
      final Integer sequence,
      final Long taskOrderId,
      final Boolean nestTask,
      final Boolean boolWageElimination,
      final String inYearMonthDayDate,
      final String inYearMonthDate,
      final LocalDateTime inspectionTime,
      final String inspectionInYearMonthDayDate,
      final String inspectionInYearMonthDate,
      final Boolean boolFixedProcess,
      final BigDecimal perforateQuantity,
      final LocalDateTime markingTime,
      final Integer markedQuantity,
      final Boolean boolMarked
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.isReversible = isReversible;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.problemQuantity = problemQuantity;
      this.inspectionQuantity = inspectionQuantity;
      this.teamId = teamId;
      this.userId = userId;
      this.userName = userName;
      this.reportType = reportType;
      this.boolHandleEnum = boolHandleEnum;
      this.number = number;
      this.groupsId = groupsId;
      this.assistId = assistId;
      this.reportTime = reportTime;
      this.reportNumber = reportNumber;
      this.useById = useById;
      this.sequence = sequence;
      this.taskOrderId = taskOrderId;
      this.nestTask = nestTask;
      this.boolWageElimination = boolWageElimination;
      this.inYearMonthDayDate = inYearMonthDayDate;
      this.inYearMonthDate = inYearMonthDate;
      this.inspectionTime = inspectionTime;
      this.inspectionInYearMonthDayDate = inspectionInYearMonthDayDate;
      this.inspectionInYearMonthDate = inspectionInYearMonthDate;
      this.boolFixedProcess = boolFixedProcess;
      this.perforateQuantity = perforateQuantity;
      this.markingTime = markingTime;
      this.markedQuantity = markedQuantity;
      this.boolMarked = boolMarked;
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

   public Long getAreaId() {
      return this.areaId;
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

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Boolean getIsReversible() {
      return this.isReversible;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Integer getReportType() {
      return this.reportType;
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

   public Long getAssistId() {
      return this.assistId;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public Long getReportNumber() {
      return this.reportNumber;
   }

   public Long getUseById() {
      return this.useById;
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Boolean getNestTask() {
      return this.nestTask;
   }

   public Boolean getBoolWageElimination() {
      return this.boolWageElimination;
   }

   public String getInYearMonthDayDate() {
      return this.inYearMonthDayDate;
   }

   public String getInYearMonthDate() {
      return this.inYearMonthDate;
   }

   public Boolean getBoolFixedProcess() {
      return this.boolFixedProcess;
   }

   public BigDecimal getPerforateQuantity() {
      return this.perforateQuantity;
   }

   public LocalDateTime getMarkingTime() {
      return this.markingTime;
   }

   public Integer getMarkedQuantity() {
      return this.markedQuantity;
   }

   public Boolean getBoolMarked() {
      return this.boolMarked;
   }

   @JsonProperty("id")
   public MesBuildingProduceTeamReport setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingProduceTeamReport setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingProduceTeamReport setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingProduceTeamReport setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingProduceTeamReport setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingProduceTeamReport setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingProduceTeamReport setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingProduceTeamReport setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProduceTeamReport setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingProduceTeamReport setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingProduceTeamReport setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("isReversible")
   public MesBuildingProduceTeamReport setIsReversible(final Boolean isReversible) {
      this.isReversible = isReversible;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingProduceTeamReport setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingProduceTeamReport setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesBuildingProduceTeamReport setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesBuildingProduceTeamReport setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingProduceTeamReport setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProduceTeamReport setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingProduceTeamReport setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("reportType")
   public MesBuildingProduceTeamReport setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("boolHandleEnum")
   public MesBuildingProduceTeamReport setBoolHandleEnum(final Boolean boolHandleEnum) {
      this.boolHandleEnum = boolHandleEnum;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingProduceTeamReport setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingProduceTeamReport setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("assistId")
   public MesBuildingProduceTeamReport setAssistId(final Long assistId) {
      this.assistId = assistId;
      return this;
   }

   @JsonProperty("reportTime")
   public MesBuildingProduceTeamReport setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
      return this;
   }

   @JsonProperty("reportNumber")
   public MesBuildingProduceTeamReport setReportNumber(final Long reportNumber) {
      this.reportNumber = reportNumber;
      return this;
   }

   @JsonProperty("useById")
   public MesBuildingProduceTeamReport setUseById(final Long useById) {
      this.useById = useById;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingProduceTeamReport setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MesBuildingProduceTeamReport setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("nestTask")
   public MesBuildingProduceTeamReport setNestTask(final Boolean nestTask) {
      this.nestTask = nestTask;
      return this;
   }

   public MesBuildingProduceTeamReport setBoolWageElimination(final Boolean boolWageElimination) {
      this.boolWageElimination = boolWageElimination;
      return this;
   }

   @JsonProperty("inYearMonthDayDate")
   public MesBuildingProduceTeamReport setInYearMonthDayDate(final String inYearMonthDayDate) {
      this.inYearMonthDayDate = inYearMonthDayDate;
      return this;
   }

   @JsonProperty("inYearMonthDate")
   public MesBuildingProduceTeamReport setInYearMonthDate(final String inYearMonthDate) {
      this.inYearMonthDate = inYearMonthDate;
      return this;
   }

   @JsonProperty("inspectionTime")
   public MesBuildingProduceTeamReport setInspectionTime(final LocalDateTime inspectionTime) {
      this.inspectionTime = inspectionTime;
      return this;
   }

   @JsonProperty("inspectionInYearMonthDayDate")
   public MesBuildingProduceTeamReport setInspectionInYearMonthDayDate(final String inspectionInYearMonthDayDate) {
      this.inspectionInYearMonthDayDate = inspectionInYearMonthDayDate;
      return this;
   }

   @JsonProperty("inspectionInYearMonthDate")
   public MesBuildingProduceTeamReport setInspectionInYearMonthDate(final String inspectionInYearMonthDate) {
      this.inspectionInYearMonthDate = inspectionInYearMonthDate;
      return this;
   }

   public MesBuildingProduceTeamReport setBoolFixedProcess(final Boolean boolFixedProcess) {
      this.boolFixedProcess = boolFixedProcess;
      return this;
   }

   public MesBuildingProduceTeamReport setPerforateQuantity(final BigDecimal perforateQuantity) {
      this.perforateQuantity = perforateQuantity;
      return this;
   }

   @JsonProperty("markingTime")
   public MesBuildingProduceTeamReport setMarkingTime(final LocalDateTime markingTime) {
      this.markingTime = markingTime;
      return this;
   }

   @JsonProperty("markedQuantity")
   public MesBuildingProduceTeamReport setMarkedQuantity(final Integer markedQuantity) {
      this.markedQuantity = markedQuantity;
      return this;
   }

   @JsonProperty("boolMarked")
   public MesBuildingProduceTeamReport setBoolMarked(final Boolean boolMarked) {
      this.boolMarked = boolMarked;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProduceTeamReport(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", taskId="
         + this.getTaskId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", processId="
         + this.getProcessId()
         + ", schedulingId="
         + this.getSchedulingId()
         + ", productId="
         + this.getProductId()
         + ", isReversible="
         + this.getIsReversible()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", teamId="
         + this.getTeamId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", reportType="
         + this.getReportType()
         + ", boolHandleEnum="
         + this.getBoolHandleEnum()
         + ", number="
         + this.getNumber()
         + ", groupsId="
         + this.getGroupsId()
         + ", assistId="
         + this.getAssistId()
         + ", reportTime="
         + this.getReportTime()
         + ", reportNumber="
         + this.getReportNumber()
         + ", useById="
         + this.getUseById()
         + ", sequence="
         + this.getSequence()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", nestTask="
         + this.getNestTask()
         + ", boolWageElimination="
         + this.getBoolWageElimination()
         + ", inYearMonthDayDate="
         + this.getInYearMonthDayDate()
         + ", inYearMonthDate="
         + this.getInYearMonthDate()
         + ", inspectionTime="
         + this.getInspectionTime()
         + ", inspectionInYearMonthDayDate="
         + this.getInspectionInYearMonthDayDate()
         + ", inspectionInYearMonthDate="
         + this.getInspectionInYearMonthDate()
         + ", boolFixedProcess="
         + this.getBoolFixedProcess()
         + ", perforateQuantity="
         + this.getPerforateQuantity()
         + ", markingTime="
         + this.getMarkingTime()
         + ", markedQuantity="
         + this.getMarkedQuantity()
         + ", boolMarked="
         + this.getBoolMarked()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProduceTeamReport)) {
         return false;
      }

      MesBuildingProduceTeamReport other = (MesBuildingProduceTeamReport)o;
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
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$productionLineId = this.getProductionLineId();
                     Object other$productionLineId = other.getProductionLineId();
                     if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                        Object this$taskId = this.getTaskId();
                        Object other$taskId = other.getTaskId();
                        if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                           Object this$taskProcessId = this.getTaskProcessId();
                           Object other$taskProcessId = other.getTaskProcessId();
                           if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
                              Object this$processId = this.getProcessId();
                              Object other$processId = other.getProcessId();
                              if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                 Object this$schedulingId = this.getSchedulingId();
                                 Object other$schedulingId = other.getSchedulingId();
                                 if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
                                    Object this$productId = this.getProductId();
                                    Object other$productId = other.getProductId();
                                    if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                       Object this$isReversible = this.getIsReversible();
                                       Object other$isReversible = other.getIsReversible();
                                       if (this$isReversible == null ? other$isReversible == null : this$isReversible.equals(other$isReversible)) {
                                          Object this$taskTypeEnum = this.getTaskTypeEnum();
                                          Object other$taskTypeEnum = other.getTaskTypeEnum();
                                          if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                                             Object this$quantity = this.getQuantity();
                                             Object other$quantity = other.getQuantity();
                                             if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                Object this$problemQuantity = this.getProblemQuantity();
                                                Object other$problemQuantity = other.getProblemQuantity();
                                                if (this$problemQuantity == null
                                                   ? other$problemQuantity == null
                                                   : this$problemQuantity.equals(other$problemQuantity)) {
                                                   Object this$inspectionQuantity = this.getInspectionQuantity();
                                                   Object other$inspectionQuantity = other.getInspectionQuantity();
                                                   if (this$inspectionQuantity == null
                                                      ? other$inspectionQuantity == null
                                                      : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                                                      Object this$teamId = this.getTeamId();
                                                      Object other$teamId = other.getTeamId();
                                                      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                         Object this$userId = this.getUserId();
                                                         Object other$userId = other.getUserId();
                                                         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                            Object this$reportType = this.getReportType();
                                                            Object other$reportType = other.getReportType();
                                                            if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
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
                                                                        Object this$assistId = this.getAssistId();
                                                                        Object other$assistId = other.getAssistId();
                                                                        if (this$assistId == null
                                                                           ? other$assistId == null
                                                                           : this$assistId.equals(other$assistId)) {
                                                                           Object this$reportNumber = this.getReportNumber();
                                                                           Object other$reportNumber = other.getReportNumber();
                                                                           if (this$reportNumber == null
                                                                              ? other$reportNumber == null
                                                                              : this$reportNumber.equals(other$reportNumber)) {
                                                                              Object this$useById = this.getUseById();
                                                                              Object other$useById = other.getUseById();
                                                                              if (this$useById == null
                                                                                 ? other$useById == null
                                                                                 : this$useById.equals(other$useById)) {
                                                                                 Object this$sequence = this.getSequence();
                                                                                 Object other$sequence = other.getSequence();
                                                                                 if (this$sequence == null
                                                                                    ? other$sequence == null
                                                                                    : this$sequence.equals(other$sequence)) {
                                                                                    Object this$taskOrderId = this.getTaskOrderId();
                                                                                    Object other$taskOrderId = other.getTaskOrderId();
                                                                                    if (this$taskOrderId == null
                                                                                       ? other$taskOrderId == null
                                                                                       : this$taskOrderId.equals(other$taskOrderId)) {
                                                                                       Object this$nestTask = this.getNestTask();
                                                                                       Object other$nestTask = other.getNestTask();
                                                                                       if (this$nestTask == null
                                                                                          ? other$nestTask == null
                                                                                          : this$nestTask.equals(other$nestTask)) {
                                                                                          Object this$boolWageElimination = this.getBoolWageElimination();
                                                                                          Object other$boolWageElimination = other.getBoolWageElimination();
                                                                                          if (this$boolWageElimination == null
                                                                                             ? other$boolWageElimination == null
                                                                                             : this$boolWageElimination.equals(other$boolWageElimination)) {
                                                                                             Object this$boolFixedProcess = this.getBoolFixedProcess();
                                                                                             Object other$boolFixedProcess = other.getBoolFixedProcess();
                                                                                             if (this$boolFixedProcess == null
                                                                                                ? other$boolFixedProcess == null
                                                                                                : this$boolFixedProcess.equals(other$boolFixedProcess)) {
                                                                                                Object this$markedQuantity = this.getMarkedQuantity();
                                                                                                Object other$markedQuantity = other.getMarkedQuantity();
                                                                                                if (this$markedQuantity == null
                                                                                                   ? other$markedQuantity == null
                                                                                                   : this$markedQuantity.equals(other$markedQuantity)) {
                                                                                                   Object this$boolMarked = this.getBoolMarked();
                                                                                                   Object other$boolMarked = other.getBoolMarked();
                                                                                                   if (this$boolMarked == null
                                                                                                      ? other$boolMarked == null
                                                                                                      : this$boolMarked.equals(other$boolMarked)) {
                                                                                                      Object this$userName = this.getUserName();
                                                                                                      Object other$userName = other.getUserName();
                                                                                                      if (this$userName == null
                                                                                                         ? other$userName == null
                                                                                                         : this$userName.equals(other$userName)) {
                                                                                                         Object this$reportTime = this.getReportTime();
                                                                                                         Object other$reportTime = other.getReportTime();
                                                                                                         if (this$reportTime == null
                                                                                                            ? other$reportTime == null
                                                                                                            : this$reportTime.equals(other$reportTime)) {
                                                                                                            Object this$inYearMonthDayDate = this.getInYearMonthDayDate();
                                                                                                            Object other$inYearMonthDayDate = other.getInYearMonthDayDate();
                                                                                                            if (this$inYearMonthDayDate == null
                                                                                                               ? other$inYearMonthDayDate == null
                                                                                                               : this$inYearMonthDayDate.equals(
                                                                                                                  other$inYearMonthDayDate
                                                                                                               )) {
                                                                                                               Object this$inYearMonthDate = this.getInYearMonthDate();
                                                                                                               Object other$inYearMonthDate = other.getInYearMonthDate();
                                                                                                               if (this$inYearMonthDate == null
                                                                                                                  ? other$inYearMonthDate == null
                                                                                                                  : this$inYearMonthDate.equals(
                                                                                                                     other$inYearMonthDate
                                                                                                                  )) {
                                                                                                                  Object this$inspectionTime = this.getInspectionTime();
                                                                                                                  Object other$inspectionTime = other.getInspectionTime();
                                                                                                                  if (this$inspectionTime == null
                                                                                                                     ? other$inspectionTime == null
                                                                                                                     : this$inspectionTime.equals(
                                                                                                                        other$inspectionTime
                                                                                                                     )) {
                                                                                                                     Object this$inspectionInYearMonthDayDate = this.getInspectionInYearMonthDayDate();
                                                                                                                     Object other$inspectionInYearMonthDayDate = other.getInspectionInYearMonthDayDate();
                                                                                                                     if (this$inspectionInYearMonthDayDate
                                                                                                                           == null
                                                                                                                        ? other$inspectionInYearMonthDayDate
                                                                                                                           == null
                                                                                                                        : this$inspectionInYearMonthDayDate.equals(
                                                                                                                           other$inspectionInYearMonthDayDate
                                                                                                                        )) {
                                                                                                                        Object this$inspectionInYearMonthDate = this.getInspectionInYearMonthDate();
                                                                                                                        Object other$inspectionInYearMonthDate = other.getInspectionInYearMonthDate();
                                                                                                                        if (this$inspectionInYearMonthDate
                                                                                                                              == null
                                                                                                                           ? other$inspectionInYearMonthDate
                                                                                                                              == null
                                                                                                                           : this$inspectionInYearMonthDate.equals(
                                                                                                                              other$inspectionInYearMonthDate
                                                                                                                           )) {
                                                                                                                           Object this$perforateQuantity = this.getPerforateQuantity();
                                                                                                                           Object other$perforateQuantity = other.getPerforateQuantity();
                                                                                                                           if (this$perforateQuantity == null
                                                                                                                              ? other$perforateQuantity == null
                                                                                                                              : this$perforateQuantity.equals(
                                                                                                                                 other$perforateQuantity
                                                                                                                              )) {
                                                                                                                              Object this$markingTime = this.getMarkingTime();
                                                                                                                              Object other$markingTime = other.getMarkingTime();
                                                                                                                              return this$markingTime == null
                                                                                                                                 ? other$markingTime == null
                                                                                                                                 : this$markingTime.equals(
                                                                                                                                    other$markingTime
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProduceTeamReport;
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
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $isReversible = this.getIsReversible();
      result = result * 59 + ($isReversible == null ? 43 : $isReversible.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $boolHandleEnum = this.getBoolHandleEnum();
      result = result * 59 + ($boolHandleEnum == null ? 43 : $boolHandleEnum.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $assistId = this.getAssistId();
      result = result * 59 + ($assistId == null ? 43 : $assistId.hashCode());
      Object $reportNumber = this.getReportNumber();
      result = result * 59 + ($reportNumber == null ? 43 : $reportNumber.hashCode());
      Object $useById = this.getUseById();
      result = result * 59 + ($useById == null ? 43 : $useById.hashCode());
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $nestTask = this.getNestTask();
      result = result * 59 + ($nestTask == null ? 43 : $nestTask.hashCode());
      Object $boolWageElimination = this.getBoolWageElimination();
      result = result * 59 + ($boolWageElimination == null ? 43 : $boolWageElimination.hashCode());
      Object $boolFixedProcess = this.getBoolFixedProcess();
      result = result * 59 + ($boolFixedProcess == null ? 43 : $boolFixedProcess.hashCode());
      Object $markedQuantity = this.getMarkedQuantity();
      result = result * 59 + ($markedQuantity == null ? 43 : $markedQuantity.hashCode());
      Object $boolMarked = this.getBoolMarked();
      result = result * 59 + ($boolMarked == null ? 43 : $boolMarked.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $reportTime = this.getReportTime();
      result = result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
      Object $inYearMonthDayDate = this.getInYearMonthDayDate();
      result = result * 59 + ($inYearMonthDayDate == null ? 43 : $inYearMonthDayDate.hashCode());
      Object $inYearMonthDate = this.getInYearMonthDate();
      result = result * 59 + ($inYearMonthDate == null ? 43 : $inYearMonthDate.hashCode());
      Object $inspectionTime = this.getInspectionTime();
      result = result * 59 + ($inspectionTime == null ? 43 : $inspectionTime.hashCode());
      Object $inspectionInYearMonthDayDate = this.getInspectionInYearMonthDayDate();
      result = result * 59 + ($inspectionInYearMonthDayDate == null ? 43 : $inspectionInYearMonthDayDate.hashCode());
      Object $inspectionInYearMonthDate = this.getInspectionInYearMonthDate();
      result = result * 59 + ($inspectionInYearMonthDate == null ? 43 : $inspectionInYearMonthDate.hashCode());
      Object $perforateQuantity = this.getPerforateQuantity();
      result = result * 59 + ($perforateQuantity == null ? 43 : $perforateQuantity.hashCode());
      Object $markingTime = this.getMarkingTime();
      return result * 59 + ($markingTime == null ? 43 : $markingTime.hashCode());
   }

   public static class MesBuildingProduceTeamReportBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long workshopId;
      private Long productionLineId;
      private Long taskId;
      private Long taskProcessId;
      private Long processId;
      private Long schedulingId;
      private Long productId;
      private Boolean isReversible;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Integer problemQuantity;
      private Integer inspectionQuantity;
      private Long teamId;
      private Long userId;
      private String userName;
      private Integer reportType;
      private Boolean boolHandleEnum;
      private Integer number;
      private Long groupsId;
      private Long assistId;
      private LocalDateTime reportTime;
      private Long reportNumber;
      private Long useById;
      private Integer sequence;
      private Long taskOrderId;
      private Boolean nestTask;
      private Boolean boolWageElimination;
      private String inYearMonthDayDate;
      private String inYearMonthDate;
      private LocalDateTime inspectionTime;
      private String inspectionInYearMonthDayDate;
      private String inspectionInYearMonthDate;
      private Boolean boolFixedProcess;
      private BigDecimal perforateQuantity;
      private LocalDateTime markingTime;
      private Integer markedQuantity;
      private Boolean boolMarked;

      MesBuildingProduceTeamReportBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("isReversible")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder isReversible(final Boolean isReversible) {
         this.isReversible = isReversible;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("reportType")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("boolHandleEnum")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder boolHandleEnum(final Boolean boolHandleEnum) {
         this.boolHandleEnum = boolHandleEnum;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("assistId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder assistId(final Long assistId) {
         this.assistId = assistId;
         return this;
      }

      @JsonProperty("reportTime")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder reportTime(final LocalDateTime reportTime) {
         this.reportTime = reportTime;
         return this;
      }

      @JsonProperty("reportNumber")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder reportNumber(final Long reportNumber) {
         this.reportNumber = reportNumber;
         return this;
      }

      @JsonProperty("useById")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder useById(final Long useById) {
         this.useById = useById;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("nestTask")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder nestTask(final Boolean nestTask) {
         this.nestTask = nestTask;
         return this;
      }

      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder boolWageElimination(final Boolean boolWageElimination) {
         this.boolWageElimination = boolWageElimination;
         return this;
      }

      @JsonProperty("inYearMonthDayDate")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder inYearMonthDayDate(final String inYearMonthDayDate) {
         this.inYearMonthDayDate = inYearMonthDayDate;
         return this;
      }

      @JsonProperty("inYearMonthDate")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder inYearMonthDate(final String inYearMonthDate) {
         this.inYearMonthDate = inYearMonthDate;
         return this;
      }

      @JsonProperty("inspectionTime")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder inspectionTime(final LocalDateTime inspectionTime) {
         this.inspectionTime = inspectionTime;
         return this;
      }

      @JsonProperty("inspectionInYearMonthDayDate")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder inspectionInYearMonthDayDate(final String inspectionInYearMonthDayDate) {
         this.inspectionInYearMonthDayDate = inspectionInYearMonthDayDate;
         return this;
      }

      @JsonProperty("inspectionInYearMonthDate")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder inspectionInYearMonthDate(final String inspectionInYearMonthDate) {
         this.inspectionInYearMonthDate = inspectionInYearMonthDate;
         return this;
      }

      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder boolFixedProcess(final Boolean boolFixedProcess) {
         this.boolFixedProcess = boolFixedProcess;
         return this;
      }

      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder perforateQuantity(final BigDecimal perforateQuantity) {
         this.perforateQuantity = perforateQuantity;
         return this;
      }

      @JsonProperty("markingTime")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder markingTime(final LocalDateTime markingTime) {
         this.markingTime = markingTime;
         return this;
      }

      @JsonProperty("markedQuantity")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder markedQuantity(final Integer markedQuantity) {
         this.markedQuantity = markedQuantity;
         return this;
      }

      @JsonProperty("boolMarked")
      public MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder boolMarked(final Boolean boolMarked) {
         this.boolMarked = boolMarked;
         return this;
      }

      public MesBuildingProduceTeamReport build() {
         return new MesBuildingProduceTeamReport(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.workshopId,
            this.productionLineId,
            this.taskId,
            this.taskProcessId,
            this.processId,
            this.schedulingId,
            this.productId,
            this.isReversible,
            this.taskTypeEnum,
            this.quantity,
            this.problemQuantity,
            this.inspectionQuantity,
            this.teamId,
            this.userId,
            this.userName,
            this.reportType,
            this.boolHandleEnum,
            this.number,
            this.groupsId,
            this.assistId,
            this.reportTime,
            this.reportNumber,
            this.useById,
            this.sequence,
            this.taskOrderId,
            this.nestTask,
            this.boolWageElimination,
            this.inYearMonthDayDate,
            this.inYearMonthDate,
            this.inspectionTime,
            this.inspectionInYearMonthDayDate,
            this.inspectionInYearMonthDate,
            this.boolFixedProcess,
            this.perforateQuantity,
            this.markingTime,
            this.markedQuantity,
            this.boolMarked
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProduceTeamReport.MesBuildingProduceTeamReportBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", taskId="
            + this.taskId
            + ", taskProcessId="
            + this.taskProcessId
            + ", processId="
            + this.processId
            + ", schedulingId="
            + this.schedulingId
            + ", productId="
            + this.productId
            + ", isReversible="
            + this.isReversible
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", problemQuantity="
            + this.problemQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", teamId="
            + this.teamId
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", reportType="
            + this.reportType
            + ", boolHandleEnum="
            + this.boolHandleEnum
            + ", number="
            + this.number
            + ", groupsId="
            + this.groupsId
            + ", assistId="
            + this.assistId
            + ", reportTime="
            + this.reportTime
            + ", reportNumber="
            + this.reportNumber
            + ", useById="
            + this.useById
            + ", sequence="
            + this.sequence
            + ", taskOrderId="
            + this.taskOrderId
            + ", nestTask="
            + this.nestTask
            + ", boolWageElimination="
            + this.boolWageElimination
            + ", inYearMonthDayDate="
            + this.inYearMonthDayDate
            + ", inYearMonthDate="
            + this.inYearMonthDate
            + ", inspectionTime="
            + this.inspectionTime
            + ", inspectionInYearMonthDayDate="
            + this.inspectionInYearMonthDayDate
            + ", inspectionInYearMonthDate="
            + this.inspectionInYearMonthDate
            + ", boolFixedProcess="
            + this.boolFixedProcess
            + ", perforateQuantity="
            + this.perforateQuantity
            + ", markingTime="
            + this.markingTime
            + ", markedQuantity="
            + this.markedQuantity
            + ", boolMarked="
            + this.boolMarked
            + ")";
      }
   }
}
