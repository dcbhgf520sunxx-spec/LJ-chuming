package com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse;

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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingQhse对象", description = "问题曝光 ")
@Entity
@TableName("mes_building_qhse")
@Table(name = "mes_building_qhse")
public class MesBuildingQhse extends BaseEntity<Long> {
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
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = true)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = true)
   private Long productionLineId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "qhseNumber", value = "编号")
   @JsonProperty("qhseNumber")
   @JSONField(name = "qhseNumber")
   @TableField("qhse_number")
   @Column(name = "qhse_number", columnDefinition = "varchar(255) COMMENT '编号'", nullable = false)
   private String qhseNumber;
   @ApiModelProperty(name = "type", value = "问题大类型 [1质量问题2安全问题4环境问题8特殊质量问题]", notes = "问题大类型 [1质量问题2安全问题4环境问题8特殊质量问题]")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '1' COMMENT '问题大类型 [1质量问题2安全问题4环境问题8特殊质量问题]'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'", nullable = true)
   private Long areaBatchId;
   @ApiModelProperty(name = "qualityType", value = "问题类型", notes = "问题类型")
   @JsonProperty("qualityType")
   @JSONField(name = "qualityType")
   @TableField("quality_type")
   @Column(name = "quality_type", columnDefinition = "varchar(255)  COMMENT '问题类型'", nullable = true)
   private String qualityType;
   @ApiModelProperty(name = "levelOneType", value = "问题一级分类")
   @JsonProperty("levelOneType")
   @JSONField(name = "levelOneType")
   @TableField("level_one_type")
   @Column(name = "level_one_type", columnDefinition = "bigint(20)  COMMENT '问题一级分类'", nullable = true)
   private Long levelOneType;
   @ApiModelProperty(name = "levelTwoType", value = "问题二级分类", notes = "问题二级分类")
   @JsonProperty("levelTwoType")
   @JSONField(name = "levelTwoType")
   @TableField("level_two_type")
   @Column(name = "level_two_type", columnDefinition = "bigint(20)  COMMENT '问题二级分类'", nullable = true)
   private Long levelTwoType;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务id'", nullable = true)
   private Long taskId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   @TableField("task_process_id")
   @Column(name = "task_process_id", columnDefinition = "bigint(20)  COMMENT '任务工序id'", nullable = true)
   private Long taskProcessId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = true)
   private Long productId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @TableField("process_id")
   @Column(name = "process_id", columnDefinition = "bigint(20)  COMMENT '工序id'", nullable = true)
   private Long processId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "problemQuantity", value = "问题数量", notes = "问题数量")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   @TableField("problem_quantity")
   @Column(name = "problem_quantity", columnDefinition = "int(11)  COMMENT '问题数量'", nullable = true)
   private Integer problemQuantity;
   @ApiModelProperty(name = "problemDrawing", value = "问题图片id", notes = "问题图片id")
   @JsonProperty("problemDrawing")
   @JSONField(name = "problemDrawing")
   @TableField("problem_drawing")
   @Column(name = "problem_drawing", columnDefinition = "varchar(1024)  COMMENT '问题图片id'", nullable = false)
   private String problemDrawing;
   @ApiModelProperty(name = "drawing_label", notes = "图纸标注")
   @JsonProperty("drawing_label")
   @JSONField(name = "drawing_label")
   @TableField("drawing_label")
   @Column(name = "drawing_label", columnDefinition = "bigint(20)  COMMENT '图纸标注id'", nullable = true)
   private Long drawingLabel;
   @ApiModelProperty(name = "remark", value = "问题描述", notes = "问题描述")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '问题描述'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "status", value = "处理状态 [1待整改2已整改4已关闭]", notes = "处理状态 [1待整改2已整改4已关闭]")
   @JsonProperty("status")
   @JSONField(name = "status")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default '1' COMMENT '处理状态 [1未回复2已回复待确认4让步接收8已通过]'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "boolNeedReply", value = "是否需要回复[0:无需1:需要]", notes = "是否需要回复[0:无需1:需要]")
   @JsonProperty("boolNeedReply")
   @JSONField(name = "boolNeedReply")
   @TableField("bool_need_reply")
   @Column(name = "bool_need_reply", columnDefinition = "tinyint(1) default '1'  COMMENT '是否需要回复[0:无需1:需要]'", nullable = true)
   private Boolean boolNeedReply;
   @ApiModelProperty(name = "firstRectifyTime", value = "首次整改日期", notes = "首次整改日期")
   @JsonProperty("firstRectifyTime")
   @JSONField(name = "firstRectifyTime")
   @TableField("first_rectify_time")
   @Column(name = "first_rectify_time", columnDefinition = "datetime  COMMENT '首次整改日期'")
   private LocalDateTime firstRectifyTime;
   @ApiModelProperty(name = "askRectifyTime", value = "要求整改日期", notes = "要求整改日期")
   @JsonProperty("askRectifyTime")
   @JSONField(name = "askRectifyTime")
   @TableField("ask_rectify_time")
   @Column(name = "ask_rectify_time", columnDefinition = "datetime  COMMENT '要求整改日期'", nullable = true)
   private LocalDateTime askRectifyTime;
   @ApiModelProperty(name = "number", value = "特殊质量问题,一物一码产品需记录码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '特殊质量问题,一物一码产品需记录码号'")
   private Integer number;
   @ApiModelProperty(name = "teamId", value = "生产班组id", notes = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '生产班组id'", nullable = true)
   private Long teamId;
   @ApiModelProperty(name = "dutyId", value = "责任人id", notes = "责任人id")
   @JsonProperty("dutyId")
   @JSONField(name = "dutyId")
   @TableField("duty_id")
   @Column(name = "duty_id", columnDefinition = "bigint(20)  COMMENT '责任人id'", nullable = false)
   private Long dutyId;
   @ApiModelProperty(name = "userId", value = "申请人id", notes = "申请人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '申请人id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "customPenalty", value = "自定义罚金", notes = "自定义罚金")
   @JsonProperty("customPenalty")
   @JSONField(name = "customPenalty")
   @TableField("custom_penalty")
   @Column(name = "custom_penalty", columnDefinition = "decimal(32,8) default null COMMENT '自定义罚金'")
   private BigDecimal customPenalty;
   @ApiModelProperty(name = "behaviorScore", value = "行为分", notes = "行为分")
   @JsonProperty("behaviorScore")
   @JSONField(name = "behaviorScore")
   @TableField("behavior_score")
   @Column(name = "behavior_score", columnDefinition = "decimal(32,8) default null COMMENT '行为分'")
   private BigDecimal behaviorScore;
   @ApiModelProperty(name = "penalty", value = "罚金", notes = "罚金")
   @JsonProperty("penalty")
   @JSONField(name = "penalty")
   @TableField("penalty")
   @Column(name = "penalty", columnDefinition = "decimal(32,8) default null COMMENT '罚金'")
   private BigDecimal penalty;

   public static MesBuildingQhse.MesBuildingQhseBuilder builder() {
      return new MesBuildingQhse.MesBuildingQhseBuilder();
   }

   public MesBuildingQhse() {
   }

   public MesBuildingQhse(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final String qhseNumber,
      final Integer type,
      final Long areaBatchId,
      final String qualityType,
      final Long levelOneType,
      final Long levelTwoType,
      final Long taskId,
      final Long taskProcessId,
      final Long productId,
      final Long processId,
      final Integer taskTypeEnum,
      final Integer problemQuantity,
      final String problemDrawing,
      final Long drawingLabel,
      final String remark,
      final Integer status,
      final Boolean boolNeedReply,
      final LocalDateTime firstRectifyTime,
      final LocalDateTime askRectifyTime,
      final Integer number,
      final Long teamId,
      final Long dutyId,
      final Long userId,
      final BigDecimal customPenalty,
      final BigDecimal behaviorScore,
      final BigDecimal penalty
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.qhseNumber = qhseNumber;
      this.type = type;
      this.areaBatchId = areaBatchId;
      this.qualityType = qualityType;
      this.levelOneType = levelOneType;
      this.levelTwoType = levelTwoType;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.productId = productId;
      this.processId = processId;
      this.taskTypeEnum = taskTypeEnum;
      this.problemQuantity = problemQuantity;
      this.problemDrawing = problemDrawing;
      this.drawingLabel = drawingLabel;
      this.remark = remark;
      this.status = status;
      this.boolNeedReply = boolNeedReply;
      this.firstRectifyTime = firstRectifyTime;
      this.askRectifyTime = askRectifyTime;
      this.number = number;
      this.teamId = teamId;
      this.dutyId = dutyId;
      this.userId = userId;
      this.customPenalty = customPenalty;
      this.behaviorScore = behaviorScore;
      this.penalty = penalty;
   }

   public Long getId() {
      return this.id;
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getQhseNumber() {
      return this.qhseNumber;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public String getQualityType() {
      return this.qualityType;
   }

   public Long getLevelOneType() {
      return this.levelOneType;
   }

   public Long getLevelTwoType() {
      return this.levelTwoType;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   public String getProblemDrawing() {
      return this.problemDrawing;
   }

   public Long getDrawingLabel() {
      return this.drawingLabel;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getBoolNeedReply() {
      return this.boolNeedReply;
   }

   public LocalDateTime getFirstRectifyTime() {
      return this.firstRectifyTime;
   }

   public LocalDateTime getAskRectifyTime() {
      return this.askRectifyTime;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getDutyId() {
      return this.dutyId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getCustomPenalty() {
      return this.customPenalty;
   }

   public BigDecimal getBehaviorScore() {
      return this.behaviorScore;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   @JsonProperty("id")
   public MesBuildingQhse setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingQhse setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingQhse setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingQhse setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingQhse setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingQhse setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingQhse setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("qhseNumber")
   public MesBuildingQhse setQhseNumber(final String qhseNumber) {
      this.qhseNumber = qhseNumber;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingQhse setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingQhse setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("qualityType")
   public MesBuildingQhse setQualityType(final String qualityType) {
      this.qualityType = qualityType;
      return this;
   }

   @JsonProperty("levelOneType")
   public MesBuildingQhse setLevelOneType(final Long levelOneType) {
      this.levelOneType = levelOneType;
      return this;
   }

   @JsonProperty("levelTwoType")
   public MesBuildingQhse setLevelTwoType(final Long levelTwoType) {
      this.levelTwoType = levelTwoType;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingQhse setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingQhse setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingQhse setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingQhse setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingQhse setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesBuildingQhse setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("problemDrawing")
   public MesBuildingQhse setProblemDrawing(final String problemDrawing) {
      this.problemDrawing = problemDrawing;
      return this;
   }

   @JsonProperty("drawing_label")
   public MesBuildingQhse setDrawingLabel(final Long drawingLabel) {
      this.drawingLabel = drawingLabel;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingQhse setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingQhse setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("boolNeedReply")
   public MesBuildingQhse setBoolNeedReply(final Boolean boolNeedReply) {
      this.boolNeedReply = boolNeedReply;
      return this;
   }

   @JsonProperty("firstRectifyTime")
   public MesBuildingQhse setFirstRectifyTime(final LocalDateTime firstRectifyTime) {
      this.firstRectifyTime = firstRectifyTime;
      return this;
   }

   @JsonProperty("askRectifyTime")
   public MesBuildingQhse setAskRectifyTime(final LocalDateTime askRectifyTime) {
      this.askRectifyTime = askRectifyTime;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingQhse setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingQhse setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("dutyId")
   public MesBuildingQhse setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingQhse setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("customPenalty")
   public MesBuildingQhse setCustomPenalty(final BigDecimal customPenalty) {
      this.customPenalty = customPenalty;
      return this;
   }

   @JsonProperty("behaviorScore")
   public MesBuildingQhse setBehaviorScore(final BigDecimal behaviorScore) {
      this.behaviorScore = behaviorScore;
      return this;
   }

   @JsonProperty("penalty")
   public MesBuildingQhse setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhse(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", qhseNumber="
         + this.getQhseNumber()
         + ", type="
         + this.getType()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", qualityType="
         + this.getQualityType()
         + ", levelOneType="
         + this.getLevelOneType()
         + ", levelTwoType="
         + this.getLevelTwoType()
         + ", taskId="
         + this.getTaskId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", productId="
         + this.getProductId()
         + ", processId="
         + this.getProcessId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", problemDrawing="
         + this.getProblemDrawing()
         + ", drawingLabel="
         + this.getDrawingLabel()
         + ", remark="
         + this.getRemark()
         + ", status="
         + this.getStatus()
         + ", boolNeedReply="
         + this.getBoolNeedReply()
         + ", firstRectifyTime="
         + this.getFirstRectifyTime()
         + ", askRectifyTime="
         + this.getAskRectifyTime()
         + ", number="
         + this.getNumber()
         + ", teamId="
         + this.getTeamId()
         + ", dutyId="
         + this.getDutyId()
         + ", userId="
         + this.getUserId()
         + ", customPenalty="
         + this.getCustomPenalty()
         + ", behaviorScore="
         + this.getBehaviorScore()
         + ", penalty="
         + this.getPenalty()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhse)) {
         return false;
      }

      MesBuildingQhse other = (MesBuildingQhse)o;
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
                        Object this$areaId = this.getAreaId();
                        Object other$areaId = other.getAreaId();
                        if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                              Object this$areaBatchId = this.getAreaBatchId();
                              Object other$areaBatchId = other.getAreaBatchId();
                              if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                                 Object this$levelOneType = this.getLevelOneType();
                                 Object other$levelOneType = other.getLevelOneType();
                                 if (this$levelOneType == null ? other$levelOneType == null : this$levelOneType.equals(other$levelOneType)) {
                                    Object this$levelTwoType = this.getLevelTwoType();
                                    Object other$levelTwoType = other.getLevelTwoType();
                                    if (this$levelTwoType == null ? other$levelTwoType == null : this$levelTwoType.equals(other$levelTwoType)) {
                                       Object this$taskId = this.getTaskId();
                                       Object other$taskId = other.getTaskId();
                                       if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                          Object this$taskProcessId = this.getTaskProcessId();
                                          Object other$taskProcessId = other.getTaskProcessId();
                                          if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
                                             Object this$productId = this.getProductId();
                                             Object other$productId = other.getProductId();
                                             if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                                Object this$processId = this.getProcessId();
                                                Object other$processId = other.getProcessId();
                                                if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                                   Object this$taskTypeEnum = this.getTaskTypeEnum();
                                                   Object other$taskTypeEnum = other.getTaskTypeEnum();
                                                   if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                                                      Object this$problemQuantity = this.getProblemQuantity();
                                                      Object other$problemQuantity = other.getProblemQuantity();
                                                      if (this$problemQuantity == null
                                                         ? other$problemQuantity == null
                                                         : this$problemQuantity.equals(other$problemQuantity)) {
                                                         Object this$drawingLabel = this.getDrawingLabel();
                                                         Object other$drawingLabel = other.getDrawingLabel();
                                                         if (this$drawingLabel == null
                                                            ? other$drawingLabel == null
                                                            : this$drawingLabel.equals(other$drawingLabel)) {
                                                            Object this$status = this.getStatus();
                                                            Object other$status = other.getStatus();
                                                            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                                               Object this$boolNeedReply = this.getBoolNeedReply();
                                                               Object other$boolNeedReply = other.getBoolNeedReply();
                                                               if (this$boolNeedReply == null
                                                                  ? other$boolNeedReply == null
                                                                  : this$boolNeedReply.equals(other$boolNeedReply)) {
                                                                  Object this$number = this.getNumber();
                                                                  Object other$number = other.getNumber();
                                                                  if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                                                     Object this$teamId = this.getTeamId();
                                                                     Object other$teamId = other.getTeamId();
                                                                     if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                                        Object this$dutyId = this.getDutyId();
                                                                        Object other$dutyId = other.getDutyId();
                                                                        if (this$dutyId == null ? other$dutyId == null : this$dutyId.equals(other$dutyId)) {
                                                                           Object this$userId = this.getUserId();
                                                                           Object other$userId = other.getUserId();
                                                                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                                              Object this$qhseNumber = this.getQhseNumber();
                                                                              Object other$qhseNumber = other.getQhseNumber();
                                                                              if (this$qhseNumber == null
                                                                                 ? other$qhseNumber == null
                                                                                 : this$qhseNumber.equals(other$qhseNumber)) {
                                                                                 Object this$qualityType = this.getQualityType();
                                                                                 Object other$qualityType = other.getQualityType();
                                                                                 if (this$qualityType == null
                                                                                    ? other$qualityType == null
                                                                                    : this$qualityType.equals(other$qualityType)) {
                                                                                    Object this$problemDrawing = this.getProblemDrawing();
                                                                                    Object other$problemDrawing = other.getProblemDrawing();
                                                                                    if (this$problemDrawing == null
                                                                                       ? other$problemDrawing == null
                                                                                       : this$problemDrawing.equals(other$problemDrawing)) {
                                                                                       Object this$remark = this.getRemark();
                                                                                       Object other$remark = other.getRemark();
                                                                                       if (this$remark == null
                                                                                          ? other$remark == null
                                                                                          : this$remark.equals(other$remark)) {
                                                                                          Object this$firstRectifyTime = this.getFirstRectifyTime();
                                                                                          Object other$firstRectifyTime = other.getFirstRectifyTime();
                                                                                          if (this$firstRectifyTime == null
                                                                                             ? other$firstRectifyTime == null
                                                                                             : this$firstRectifyTime.equals(other$firstRectifyTime)) {
                                                                                             Object this$askRectifyTime = this.getAskRectifyTime();
                                                                                             Object other$askRectifyTime = other.getAskRectifyTime();
                                                                                             if (this$askRectifyTime == null
                                                                                                ? other$askRectifyTime == null
                                                                                                : this$askRectifyTime.equals(other$askRectifyTime)) {
                                                                                                Object this$customPenalty = this.getCustomPenalty();
                                                                                                Object other$customPenalty = other.getCustomPenalty();
                                                                                                if (this$customPenalty == null
                                                                                                   ? other$customPenalty == null
                                                                                                   : this$customPenalty.equals(other$customPenalty)) {
                                                                                                   Object this$behaviorScore = this.getBehaviorScore();
                                                                                                   Object other$behaviorScore = other.getBehaviorScore();
                                                                                                   if (this$behaviorScore == null
                                                                                                      ? other$behaviorScore == null
                                                                                                      : this$behaviorScore.equals(other$behaviorScore)) {
                                                                                                      Object this$penalty = this.getPenalty();
                                                                                                      Object other$penalty = other.getPenalty();
                                                                                                      return this$penalty == null
                                                                                                         ? other$penalty == null
                                                                                                         : this$penalty.equals(other$penalty);
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingQhse;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $levelOneType = this.getLevelOneType();
      result = result * 59 + ($levelOneType == null ? 43 : $levelOneType.hashCode());
      Object $levelTwoType = this.getLevelTwoType();
      result = result * 59 + ($levelTwoType == null ? 43 : $levelTwoType.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $drawingLabel = this.getDrawingLabel();
      result = result * 59 + ($drawingLabel == null ? 43 : $drawingLabel.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $boolNeedReply = this.getBoolNeedReply();
      result = result * 59 + ($boolNeedReply == null ? 43 : $boolNeedReply.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $dutyId = this.getDutyId();
      result = result * 59 + ($dutyId == null ? 43 : $dutyId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $qhseNumber = this.getQhseNumber();
      result = result * 59 + ($qhseNumber == null ? 43 : $qhseNumber.hashCode());
      Object $qualityType = this.getQualityType();
      result = result * 59 + ($qualityType == null ? 43 : $qualityType.hashCode());
      Object $problemDrawing = this.getProblemDrawing();
      result = result * 59 + ($problemDrawing == null ? 43 : $problemDrawing.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $firstRectifyTime = this.getFirstRectifyTime();
      result = result * 59 + ($firstRectifyTime == null ? 43 : $firstRectifyTime.hashCode());
      Object $askRectifyTime = this.getAskRectifyTime();
      result = result * 59 + ($askRectifyTime == null ? 43 : $askRectifyTime.hashCode());
      Object $customPenalty = this.getCustomPenalty();
      result = result * 59 + ($customPenalty == null ? 43 : $customPenalty.hashCode());
      Object $behaviorScore = this.getBehaviorScore();
      result = result * 59 + ($behaviorScore == null ? 43 : $behaviorScore.hashCode());
      Object $penalty = this.getPenalty();
      return result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
   }

   public static class MesBuildingQhseBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String qhseNumber;
      private Integer type;
      private Long areaBatchId;
      private String qualityType;
      private Long levelOneType;
      private Long levelTwoType;
      private Long taskId;
      private Long taskProcessId;
      private Long productId;
      private Long processId;
      private Integer taskTypeEnum;
      private Integer problemQuantity;
      private String problemDrawing;
      private Long drawingLabel;
      private String remark;
      private Integer status;
      private Boolean boolNeedReply;
      private LocalDateTime firstRectifyTime;
      private LocalDateTime askRectifyTime;
      private Integer number;
      private Long teamId;
      private Long dutyId;
      private Long userId;
      private BigDecimal customPenalty;
      private BigDecimal behaviorScore;
      private BigDecimal penalty;

      MesBuildingQhseBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhse.MesBuildingQhseBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingQhse.MesBuildingQhseBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingQhse.MesBuildingQhseBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingQhse.MesBuildingQhseBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingQhse.MesBuildingQhseBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingQhse.MesBuildingQhseBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingQhse.MesBuildingQhseBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("qhseNumber")
      public MesBuildingQhse.MesBuildingQhseBuilder qhseNumber(final String qhseNumber) {
         this.qhseNumber = qhseNumber;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingQhse.MesBuildingQhseBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingQhse.MesBuildingQhseBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("qualityType")
      public MesBuildingQhse.MesBuildingQhseBuilder qualityType(final String qualityType) {
         this.qualityType = qualityType;
         return this;
      }

      @JsonProperty("levelOneType")
      public MesBuildingQhse.MesBuildingQhseBuilder levelOneType(final Long levelOneType) {
         this.levelOneType = levelOneType;
         return this;
      }

      @JsonProperty("levelTwoType")
      public MesBuildingQhse.MesBuildingQhseBuilder levelTwoType(final Long levelTwoType) {
         this.levelTwoType = levelTwoType;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingQhse.MesBuildingQhseBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingQhse.MesBuildingQhseBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingQhse.MesBuildingQhseBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingQhse.MesBuildingQhseBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingQhse.MesBuildingQhseBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesBuildingQhse.MesBuildingQhseBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("problemDrawing")
      public MesBuildingQhse.MesBuildingQhseBuilder problemDrawing(final String problemDrawing) {
         this.problemDrawing = problemDrawing;
         return this;
      }

      @JsonProperty("drawing_label")
      public MesBuildingQhse.MesBuildingQhseBuilder drawingLabel(final Long drawingLabel) {
         this.drawingLabel = drawingLabel;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingQhse.MesBuildingQhseBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingQhse.MesBuildingQhseBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("boolNeedReply")
      public MesBuildingQhse.MesBuildingQhseBuilder boolNeedReply(final Boolean boolNeedReply) {
         this.boolNeedReply = boolNeedReply;
         return this;
      }

      @JsonProperty("firstRectifyTime")
      public MesBuildingQhse.MesBuildingQhseBuilder firstRectifyTime(final LocalDateTime firstRectifyTime) {
         this.firstRectifyTime = firstRectifyTime;
         return this;
      }

      @JsonProperty("askRectifyTime")
      public MesBuildingQhse.MesBuildingQhseBuilder askRectifyTime(final LocalDateTime askRectifyTime) {
         this.askRectifyTime = askRectifyTime;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingQhse.MesBuildingQhseBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingQhse.MesBuildingQhseBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("dutyId")
      public MesBuildingQhse.MesBuildingQhseBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingQhse.MesBuildingQhseBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("customPenalty")
      public MesBuildingQhse.MesBuildingQhseBuilder customPenalty(final BigDecimal customPenalty) {
         this.customPenalty = customPenalty;
         return this;
      }

      @JsonProperty("behaviorScore")
      public MesBuildingQhse.MesBuildingQhseBuilder behaviorScore(final BigDecimal behaviorScore) {
         this.behaviorScore = behaviorScore;
         return this;
      }

      @JsonProperty("penalty")
      public MesBuildingQhse.MesBuildingQhseBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      public MesBuildingQhse build() {
         return new MesBuildingQhse(
            this.id,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.qhseNumber,
            this.type,
            this.areaBatchId,
            this.qualityType,
            this.levelOneType,
            this.levelTwoType,
            this.taskId,
            this.taskProcessId,
            this.productId,
            this.processId,
            this.taskTypeEnum,
            this.problemQuantity,
            this.problemDrawing,
            this.drawingLabel,
            this.remark,
            this.status,
            this.boolNeedReply,
            this.firstRectifyTime,
            this.askRectifyTime,
            this.number,
            this.teamId,
            this.dutyId,
            this.userId,
            this.customPenalty,
            this.behaviorScore,
            this.penalty
         );
      }

      @Override
      public String toString() {
         return "MesBuildingQhse.MesBuildingQhseBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", qhseNumber="
            + this.qhseNumber
            + ", type="
            + this.type
            + ", areaBatchId="
            + this.areaBatchId
            + ", qualityType="
            + this.qualityType
            + ", levelOneType="
            + this.levelOneType
            + ", levelTwoType="
            + this.levelTwoType
            + ", taskId="
            + this.taskId
            + ", taskProcessId="
            + this.taskProcessId
            + ", productId="
            + this.productId
            + ", processId="
            + this.processId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", problemQuantity="
            + this.problemQuantity
            + ", problemDrawing="
            + this.problemDrawing
            + ", drawingLabel="
            + this.drawingLabel
            + ", remark="
            + this.remark
            + ", status="
            + this.status
            + ", boolNeedReply="
            + this.boolNeedReply
            + ", firstRectifyTime="
            + this.firstRectifyTime
            + ", askRectifyTime="
            + this.askRectifyTime
            + ", number="
            + this.number
            + ", teamId="
            + this.teamId
            + ", dutyId="
            + this.dutyId
            + ", userId="
            + this.userId
            + ", customPenalty="
            + this.customPenalty
            + ", behaviorScore="
            + this.behaviorScore
            + ", penalty="
            + this.penalty
            + ")";
      }
   }
}
