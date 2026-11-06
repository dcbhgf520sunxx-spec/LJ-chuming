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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingProduceInspectionTeamReport对象", description = "质检上报记录表 ")
@Entity
@TableName("mes_building_produce_inspection_team_report")
@Table(
   name = "mes_building_produce_inspection_team_report",
   indexes = {
         @Index(name = "task_id", columnList = "task_id"),
         @Index(name = "groupKry", columnList = "create_time,task_type_enum,user_id"),
         @Index(name = "inspect_report_number", columnList = "inspect_report_number"),
         @Index(name = "in_year_month_day_date", columnList = "in_year_month_day_date"),
         @Index(name = "in_year_month_date", columnList = "in_year_month_date"),
         @Index(name = "task_process_id", columnList = "task_process_id"),
         @Index(name = "processAndProductIdIndex", columnList = "process_id,product_id"),
         @Index(name = "groupKey", columnList = "product_id,number,task_type_enum,process_id")
   }
)
@org.hibernate.annotations.Table(appliesTo = "mes_building_produce_inspection_team_report", comment = "质检上报记录表 ")
public class MesBuildingProduceInspectionTeamReport extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
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
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检数量", notes = "质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   @TableField("inspection_quantity")
   @Column(name = "inspection_quantity", columnDefinition = "int(11) default '0' COMMENT '质检数量'")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "teamId", value = "生产班组id", notes = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '生产班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "inspectionTeamId", value = "质检班组id", notes = "质检班组id")
   @JsonProperty("inspectionTeamId")
   @JSONField(name = "inspectionTeamId")
   @TableField("inspection_team_id")
   @Column(name = "inspection_team_id", columnDefinition = "bigint(20)  COMMENT '质检班组id'")
   private Long inspectionTeamId;
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
   @ApiModelProperty(name = "boolAdoptEnum", value = "是否通过质检 [0 未通过, 1 已通过]", notes = "是否通过质检 [0 未通过, 1 已通过]")
   @JsonProperty("boolAdoptEnum")
   @JSONField(name = "boolAdoptEnum")
   @TableField("bool_adopt_enum")
   @Column(name = "bool_adopt_enum", columnDefinition = "tinyint(1) default '1' COMMENT '是否通过质检 [0 未通过, 1 已通过]'", nullable = false)
   private Boolean boolAdoptEnum;
   @ApiModelProperty(name = "number", value = "构件生产编号", notes = "构件生产编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(20)  COMMENT '构件生产编号'")
   private Integer number;
   @ApiModelProperty(name = "groupId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupId")
   @JSONField(name = "groupId")
   @TableField("group_id")
   @Column(name = "group_id", columnDefinition = "bigint(20)  COMMENT '生产组id'")
   private Long groupId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "inspectReportNumber", value = "质检上报的次数", notes = "质检上报的次数")
   @JsonProperty("inspectReportNumber")
   @JSONField(name = "inspectReportNumber")
   @TableField("inspect_report_number")
   @Column(name = "inspect_report_number", columnDefinition = "bigint(20)  COMMENT '质检上报的次数'", nullable = false)
   private Long inspectReportNumber;
   @ApiModelProperty(name = "useById", value = "二次利用原本质检报工记录", notes = "二次利用原本质检报工记录")
   @JsonProperty("useById")
   @JSONField(name = "useById")
   @TableField("use_by_id")
   @Column(name = "use_by_id", columnDefinition = "bigint(20)  COMMENT '二次利用原本质检报工记录'")
   private Long useById;
   @ApiModelProperty(name = "reportTime", value = "质检上报时间", notes = "质检上报时间")
   @JsonProperty("reportTime")
   @JSONField(name = "reportTime")
   @TableField("report_time")
   @Column(name = "report_time", columnDefinition = "datetime(6)  COMMENT '质检上报时间'")
   private LocalDateTime reportTime;
   @ApiModelProperty(name = "inspectReportTime", value = "质检通过时间", notes = "质检通过时间")
   @JsonProperty("inspectReportTime")
   @JSONField(name = "inspectReportTime")
   @TableField("inspect_report_time")
   @Column(name = "inspect_report_time", columnDefinition = "datetime(6)  COMMENT '质检通过时间'")
   private LocalDateTime inspectReportTime;
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
   @ApiModelProperty(name = "boolPaintThicknessAdoptEnum", value = "是否通过漆膜厚度检测 [0 未通过, 1 已通过]", notes = "是否通过漆膜厚度检测 [0 未通过, 1 已通过]")
   @JsonProperty("boolPaintThicknessAdoptEnum")
   @JSONField(name = "boolPaintThicknessAdoptEnum")
   @TableField("bool_paint_thickness_adopt_enum")
   @Column(name = "bool_paint_thickness_adopt_enum", columnDefinition = "tinyint(1)  COMMENT '是否通过漆膜厚度检测 [0 未通过, 1 已通过]'", nullable = true)
   private Boolean boolPaintThicknessAdoptEnum;
   @ApiModelProperty(name = "minThickness", value = "本次漆膜检测最小限制厚度", notes = "本次漆膜检测最小限制厚度")
   @JsonProperty("minThickness")
   @JSONField(name = "minThickness")
   @TableField("min_thickness")
   @Column(name = "min_thickness", columnDefinition = "decimal(16,8)  COMMENT '本次漆膜检测最小限制厚度'", nullable = true)
   private BigDecimal minThickness;
   @ApiModelProperty(name = "maxThickness", value = "本次漆膜检测最大限制厚度", notes = "本次漆膜检测最大限制厚度")
   @JsonProperty("maxThickness")
   @JSONField(name = "maxThickness")
   @TableField("max_thickness")
   @Column(name = "max_thickness", columnDefinition = "decimal(16,8)  COMMENT '本次漆膜检测最大限制厚度'", nullable = true)
   private BigDecimal maxThickness;
   @ApiModelProperty(name = "avgThickness", value = "本次漆膜检测记录平均值", notes = "本次漆膜检测记录平均值")
   @JsonProperty("avgThickness")
   @JSONField(name = "avgThickness")
   @TableField("avg_thickness")
   @Column(name = "avg_thickness", columnDefinition = "decimal(16,8)  COMMENT '本次漆膜检测记录平均值'", nullable = true)
   private BigDecimal avgThickness;

   public static MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder builder() {
      return new MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder();
   }

   public MesBuildingProduceInspectionTeamReport() {
   }

   public MesBuildingProduceInspectionTeamReport(
      final Long id,
      final Long taskId,
      final Long taskProcessId,
      final Long processId,
      final Long schedulingId,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer inspectionQuantity,
      final Long teamId,
      final Long inspectionTeamId,
      final Long userId,
      final String userName,
      final Boolean boolAdoptEnum,
      final Integer number,
      final Long groupId,
      final Long productionLineId,
      final Long inspectReportNumber,
      final Long useById,
      final LocalDateTime reportTime,
      final LocalDateTime inspectReportTime,
      final String inYearMonthDayDate,
      final String inYearMonthDate,
      final Boolean boolPaintThicknessAdoptEnum,
      final BigDecimal minThickness,
      final BigDecimal maxThickness,
      final BigDecimal avgThickness
   ) {
      this.id = id;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
      this.schedulingId = schedulingId;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.inspectionQuantity = inspectionQuantity;
      this.teamId = teamId;
      this.inspectionTeamId = inspectionTeamId;
      this.userId = userId;
      this.userName = userName;
      this.boolAdoptEnum = boolAdoptEnum;
      this.number = number;
      this.groupId = groupId;
      this.productionLineId = productionLineId;
      this.inspectReportNumber = inspectReportNumber;
      this.useById = useById;
      this.reportTime = reportTime;
      this.inspectReportTime = inspectReportTime;
      this.inYearMonthDayDate = inYearMonthDayDate;
      this.inYearMonthDate = inYearMonthDate;
      this.boolPaintThicknessAdoptEnum = boolPaintThicknessAdoptEnum;
      this.minThickness = minThickness;
      this.maxThickness = maxThickness;
      this.avgThickness = avgThickness;
   }

   public Long getId() {
      return this.id;
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

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getInspectionTeamId() {
      return this.inspectionTeamId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Boolean getBoolAdoptEnum() {
      return this.boolAdoptEnum;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getGroupId() {
      return this.groupId;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getInspectReportNumber() {
      return this.inspectReportNumber;
   }

   public Long getUseById() {
      return this.useById;
   }

   public LocalDateTime getReportTime() {
      return this.reportTime;
   }

   public LocalDateTime getInspectReportTime() {
      return this.inspectReportTime;
   }

   public String getInYearMonthDayDate() {
      return this.inYearMonthDayDate;
   }

   public String getInYearMonthDate() {
      return this.inYearMonthDate;
   }

   public Boolean getBoolPaintThicknessAdoptEnum() {
      return this.boolPaintThicknessAdoptEnum;
   }

   public BigDecimal getMinThickness() {
      return this.minThickness;
   }

   public BigDecimal getMaxThickness() {
      return this.maxThickness;
   }

   public BigDecimal getAvgThickness() {
      return this.avgThickness;
   }

   @JsonProperty("id")
   public MesBuildingProduceInspectionTeamReport setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingProduceInspectionTeamReport setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingProduceInspectionTeamReport setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingProduceInspectionTeamReport setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingProduceInspectionTeamReport setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingProduceInspectionTeamReport setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingProduceInspectionTeamReport setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesBuildingProduceInspectionTeamReport setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingProduceInspectionTeamReport setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("inspectionTeamId")
   public MesBuildingProduceInspectionTeamReport setInspectionTeamId(final Long inspectionTeamId) {
      this.inspectionTeamId = inspectionTeamId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingProduceInspectionTeamReport setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingProduceInspectionTeamReport setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("boolAdoptEnum")
   public MesBuildingProduceInspectionTeamReport setBoolAdoptEnum(final Boolean boolAdoptEnum) {
      this.boolAdoptEnum = boolAdoptEnum;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingProduceInspectionTeamReport setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("groupId")
   public MesBuildingProduceInspectionTeamReport setGroupId(final Long groupId) {
      this.groupId = groupId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingProduceInspectionTeamReport setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("inspectReportNumber")
   public MesBuildingProduceInspectionTeamReport setInspectReportNumber(final Long inspectReportNumber) {
      this.inspectReportNumber = inspectReportNumber;
      return this;
   }

   @JsonProperty("useById")
   public MesBuildingProduceInspectionTeamReport setUseById(final Long useById) {
      this.useById = useById;
      return this;
   }

   @JsonProperty("reportTime")
   public MesBuildingProduceInspectionTeamReport setReportTime(final LocalDateTime reportTime) {
      this.reportTime = reportTime;
      return this;
   }

   @JsonProperty("inspectReportTime")
   public MesBuildingProduceInspectionTeamReport setInspectReportTime(final LocalDateTime inspectReportTime) {
      this.inspectReportTime = inspectReportTime;
      return this;
   }

   @JsonProperty("inYearMonthDayDate")
   public MesBuildingProduceInspectionTeamReport setInYearMonthDayDate(final String inYearMonthDayDate) {
      this.inYearMonthDayDate = inYearMonthDayDate;
      return this;
   }

   @JsonProperty("inYearMonthDate")
   public MesBuildingProduceInspectionTeamReport setInYearMonthDate(final String inYearMonthDate) {
      this.inYearMonthDate = inYearMonthDate;
      return this;
   }

   @JsonProperty("boolPaintThicknessAdoptEnum")
   public MesBuildingProduceInspectionTeamReport setBoolPaintThicknessAdoptEnum(final Boolean boolPaintThicknessAdoptEnum) {
      this.boolPaintThicknessAdoptEnum = boolPaintThicknessAdoptEnum;
      return this;
   }

   @JsonProperty("minThickness")
   public MesBuildingProduceInspectionTeamReport setMinThickness(final BigDecimal minThickness) {
      this.minThickness = minThickness;
      return this;
   }

   @JsonProperty("maxThickness")
   public MesBuildingProduceInspectionTeamReport setMaxThickness(final BigDecimal maxThickness) {
      this.maxThickness = maxThickness;
      return this;
   }

   @JsonProperty("avgThickness")
   public MesBuildingProduceInspectionTeamReport setAvgThickness(final BigDecimal avgThickness) {
      this.avgThickness = avgThickness;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProduceInspectionTeamReport(id="
         + this.getId()
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
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", teamId="
         + this.getTeamId()
         + ", inspectionTeamId="
         + this.getInspectionTeamId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", boolAdoptEnum="
         + this.getBoolAdoptEnum()
         + ", number="
         + this.getNumber()
         + ", groupId="
         + this.getGroupId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", inspectReportNumber="
         + this.getInspectReportNumber()
         + ", useById="
         + this.getUseById()
         + ", reportTime="
         + this.getReportTime()
         + ", inspectReportTime="
         + this.getInspectReportTime()
         + ", inYearMonthDayDate="
         + this.getInYearMonthDayDate()
         + ", inYearMonthDate="
         + this.getInYearMonthDate()
         + ", boolPaintThicknessAdoptEnum="
         + this.getBoolPaintThicknessAdoptEnum()
         + ", minThickness="
         + this.getMinThickness()
         + ", maxThickness="
         + this.getMaxThickness()
         + ", avgThickness="
         + this.getAvgThickness()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProduceInspectionTeamReport)) {
         return false;
      }

      MesBuildingProduceInspectionTeamReport other = (MesBuildingProduceInspectionTeamReport)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                        Object this$taskTypeEnum = this.getTaskTypeEnum();
                        Object other$taskTypeEnum = other.getTaskTypeEnum();
                        if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                           Object this$inspectionQuantity = this.getInspectionQuantity();
                           Object other$inspectionQuantity = other.getInspectionQuantity();
                           if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                              Object this$teamId = this.getTeamId();
                              Object other$teamId = other.getTeamId();
                              if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                 Object this$inspectionTeamId = this.getInspectionTeamId();
                                 Object other$inspectionTeamId = other.getInspectionTeamId();
                                 if (this$inspectionTeamId == null ? other$inspectionTeamId == null : this$inspectionTeamId.equals(other$inspectionTeamId)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$boolAdoptEnum = this.getBoolAdoptEnum();
                                       Object other$boolAdoptEnum = other.getBoolAdoptEnum();
                                       if (this$boolAdoptEnum == null ? other$boolAdoptEnum == null : this$boolAdoptEnum.equals(other$boolAdoptEnum)) {
                                          Object this$number = this.getNumber();
                                          Object other$number = other.getNumber();
                                          if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                             Object this$groupId = this.getGroupId();
                                             Object other$groupId = other.getGroupId();
                                             if (this$groupId == null ? other$groupId == null : this$groupId.equals(other$groupId)) {
                                                Object this$productionLineId = this.getProductionLineId();
                                                Object other$productionLineId = other.getProductionLineId();
                                                if (this$productionLineId == null
                                                   ? other$productionLineId == null
                                                   : this$productionLineId.equals(other$productionLineId)) {
                                                   Object this$inspectReportNumber = this.getInspectReportNumber();
                                                   Object other$inspectReportNumber = other.getInspectReportNumber();
                                                   if (this$inspectReportNumber == null
                                                      ? other$inspectReportNumber == null
                                                      : this$inspectReportNumber.equals(other$inspectReportNumber)) {
                                                      Object this$useById = this.getUseById();
                                                      Object other$useById = other.getUseById();
                                                      if (this$useById == null ? other$useById == null : this$useById.equals(other$useById)) {
                                                         Object this$boolPaintThicknessAdoptEnum = this.getBoolPaintThicknessAdoptEnum();
                                                         Object other$boolPaintThicknessAdoptEnum = other.getBoolPaintThicknessAdoptEnum();
                                                         if (this$boolPaintThicknessAdoptEnum == null
                                                            ? other$boolPaintThicknessAdoptEnum == null
                                                            : this$boolPaintThicknessAdoptEnum.equals(other$boolPaintThicknessAdoptEnum)) {
                                                            Object this$userName = this.getUserName();
                                                            Object other$userName = other.getUserName();
                                                            if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                               Object this$reportTime = this.getReportTime();
                                                               Object other$reportTime = other.getReportTime();
                                                               if (this$reportTime == null
                                                                  ? other$reportTime == null
                                                                  : this$reportTime.equals(other$reportTime)) {
                                                                  Object this$inspectReportTime = this.getInspectReportTime();
                                                                  Object other$inspectReportTime = other.getInspectReportTime();
                                                                  if (this$inspectReportTime == null
                                                                     ? other$inspectReportTime == null
                                                                     : this$inspectReportTime.equals(other$inspectReportTime)) {
                                                                     Object this$inYearMonthDayDate = this.getInYearMonthDayDate();
                                                                     Object other$inYearMonthDayDate = other.getInYearMonthDayDate();
                                                                     if (this$inYearMonthDayDate == null
                                                                        ? other$inYearMonthDayDate == null
                                                                        : this$inYearMonthDayDate.equals(other$inYearMonthDayDate)) {
                                                                        Object this$inYearMonthDate = this.getInYearMonthDate();
                                                                        Object other$inYearMonthDate = other.getInYearMonthDate();
                                                                        if (this$inYearMonthDate == null
                                                                           ? other$inYearMonthDate == null
                                                                           : this$inYearMonthDate.equals(other$inYearMonthDate)) {
                                                                           Object this$minThickness = this.getMinThickness();
                                                                           Object other$minThickness = other.getMinThickness();
                                                                           if (this$minThickness == null
                                                                              ? other$minThickness == null
                                                                              : this$minThickness.equals(other$minThickness)) {
                                                                              Object this$maxThickness = this.getMaxThickness();
                                                                              Object other$maxThickness = other.getMaxThickness();
                                                                              if (this$maxThickness == null
                                                                                 ? other$maxThickness == null
                                                                                 : this$maxThickness.equals(other$maxThickness)) {
                                                                                 Object this$avgThickness = this.getAvgThickness();
                                                                                 Object other$avgThickness = other.getAvgThickness();
                                                                                 return this$avgThickness == null
                                                                                    ? other$avgThickness == null
                                                                                    : this$avgThickness.equals(other$avgThickness);
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingProduceInspectionTeamReport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
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
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $inspectionTeamId = this.getInspectionTeamId();
      result = result * 59 + ($inspectionTeamId == null ? 43 : $inspectionTeamId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolAdoptEnum = this.getBoolAdoptEnum();
      result = result * 59 + ($boolAdoptEnum == null ? 43 : $boolAdoptEnum.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $groupId = this.getGroupId();
      result = result * 59 + ($groupId == null ? 43 : $groupId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $inspectReportNumber = this.getInspectReportNumber();
      result = result * 59 + ($inspectReportNumber == null ? 43 : $inspectReportNumber.hashCode());
      Object $useById = this.getUseById();
      result = result * 59 + ($useById == null ? 43 : $useById.hashCode());
      Object $boolPaintThicknessAdoptEnum = this.getBoolPaintThicknessAdoptEnum();
      result = result * 59 + ($boolPaintThicknessAdoptEnum == null ? 43 : $boolPaintThicknessAdoptEnum.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $reportTime = this.getReportTime();
      result = result * 59 + ($reportTime == null ? 43 : $reportTime.hashCode());
      Object $inspectReportTime = this.getInspectReportTime();
      result = result * 59 + ($inspectReportTime == null ? 43 : $inspectReportTime.hashCode());
      Object $inYearMonthDayDate = this.getInYearMonthDayDate();
      result = result * 59 + ($inYearMonthDayDate == null ? 43 : $inYearMonthDayDate.hashCode());
      Object $inYearMonthDate = this.getInYearMonthDate();
      result = result * 59 + ($inYearMonthDate == null ? 43 : $inYearMonthDate.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $maxThickness = this.getMaxThickness();
      result = result * 59 + ($maxThickness == null ? 43 : $maxThickness.hashCode());
      Object $avgThickness = this.getAvgThickness();
      return result * 59 + ($avgThickness == null ? 43 : $avgThickness.hashCode());
   }

   public static class MesBuildingProduceInspectionTeamReportBuilder {
      private Long id;
      private Long taskId;
      private Long taskProcessId;
      private Long processId;
      private Long schedulingId;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer inspectionQuantity;
      private Long teamId;
      private Long inspectionTeamId;
      private Long userId;
      private String userName;
      private Boolean boolAdoptEnum;
      private Integer number;
      private Long groupId;
      private Long productionLineId;
      private Long inspectReportNumber;
      private Long useById;
      private LocalDateTime reportTime;
      private LocalDateTime inspectReportTime;
      private String inYearMonthDayDate;
      private String inYearMonthDate;
      private Boolean boolPaintThicknessAdoptEnum;
      private BigDecimal minThickness;
      private BigDecimal maxThickness;
      private BigDecimal avgThickness;

      MesBuildingProduceInspectionTeamReportBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("inspectionTeamId")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder inspectionTeamId(final Long inspectionTeamId) {
         this.inspectionTeamId = inspectionTeamId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("boolAdoptEnum")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder boolAdoptEnum(final Boolean boolAdoptEnum) {
         this.boolAdoptEnum = boolAdoptEnum;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("groupId")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder groupId(final Long groupId) {
         this.groupId = groupId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("inspectReportNumber")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder inspectReportNumber(final Long inspectReportNumber) {
         this.inspectReportNumber = inspectReportNumber;
         return this;
      }

      @JsonProperty("useById")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder useById(final Long useById) {
         this.useById = useById;
         return this;
      }

      @JsonProperty("reportTime")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder reportTime(final LocalDateTime reportTime) {
         this.reportTime = reportTime;
         return this;
      }

      @JsonProperty("inspectReportTime")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder inspectReportTime(final LocalDateTime inspectReportTime) {
         this.inspectReportTime = inspectReportTime;
         return this;
      }

      @JsonProperty("inYearMonthDayDate")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder inYearMonthDayDate(final String inYearMonthDayDate) {
         this.inYearMonthDayDate = inYearMonthDayDate;
         return this;
      }

      @JsonProperty("inYearMonthDate")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder inYearMonthDate(final String inYearMonthDate) {
         this.inYearMonthDate = inYearMonthDate;
         return this;
      }

      @JsonProperty("boolPaintThicknessAdoptEnum")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder boolPaintThicknessAdoptEnum(
         final Boolean boolPaintThicknessAdoptEnum
      ) {
         this.boolPaintThicknessAdoptEnum = boolPaintThicknessAdoptEnum;
         return this;
      }

      @JsonProperty("minThickness")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder minThickness(final BigDecimal minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      @JsonProperty("maxThickness")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder maxThickness(final BigDecimal maxThickness) {
         this.maxThickness = maxThickness;
         return this;
      }

      @JsonProperty("avgThickness")
      public MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder avgThickness(final BigDecimal avgThickness) {
         this.avgThickness = avgThickness;
         return this;
      }

      public MesBuildingProduceInspectionTeamReport build() {
         return new MesBuildingProduceInspectionTeamReport(
            this.id,
            this.taskId,
            this.taskProcessId,
            this.processId,
            this.schedulingId,
            this.productId,
            this.taskTypeEnum,
            this.inspectionQuantity,
            this.teamId,
            this.inspectionTeamId,
            this.userId,
            this.userName,
            this.boolAdoptEnum,
            this.number,
            this.groupId,
            this.productionLineId,
            this.inspectReportNumber,
            this.useById,
            this.reportTime,
            this.inspectReportTime,
            this.inYearMonthDayDate,
            this.inYearMonthDate,
            this.boolPaintThicknessAdoptEnum,
            this.minThickness,
            this.maxThickness,
            this.avgThickness
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProduceInspectionTeamReport.MesBuildingProduceInspectionTeamReportBuilder(id="
            + this.id
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
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", teamId="
            + this.teamId
            + ", inspectionTeamId="
            + this.inspectionTeamId
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", boolAdoptEnum="
            + this.boolAdoptEnum
            + ", number="
            + this.number
            + ", groupId="
            + this.groupId
            + ", productionLineId="
            + this.productionLineId
            + ", inspectReportNumber="
            + this.inspectReportNumber
            + ", useById="
            + this.useById
            + ", reportTime="
            + this.reportTime
            + ", inspectReportTime="
            + this.inspectReportTime
            + ", inYearMonthDayDate="
            + this.inYearMonthDayDate
            + ", inYearMonthDate="
            + this.inYearMonthDate
            + ", boolPaintThicknessAdoptEnum="
            + this.boolPaintThicknessAdoptEnum
            + ", minThickness="
            + this.minThickness
            + ", maxThickness="
            + this.maxThickness
            + ", avgThickness="
            + this.avgThickness
            + ")";
      }
   }
}
