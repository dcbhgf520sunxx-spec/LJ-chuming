package com.hzchum.scim.mes.building.core.api.pojo._do.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingQhseDO对象", description = "问题曝光 ")
public class MesBuildingQhseDO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名称")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名称")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "factoryId", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "taskId", value = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "processId", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "problemQuantity", notes = "问题上报数量")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   private Integer problemQuantity;
   @ApiModelProperty(name = "problemDrawing", notes = "问题上报图片ids")
   @JsonProperty("problemDrawing")
   @JSONField(name = "problemDrawing")
   private String problemDrawing;
   @ApiModelProperty(name = "drawingLabel", notes = "图纸标注")
   @JsonProperty("drawingLabel")
   @JSONField(name = "drawingLabel")
   private Long drawingLabel;
   @ApiModelProperty(name = "userId", value = "申请人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "dutyId", value = "责任人id")
   @JsonProperty("dutyId")
   @JSONField(name = "dutyId")
   private Long dutyId;
   @ApiModelProperty(name = "teamId", value = "责任人班组")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "type", value = "问题类型 [1质量问题2安全问题3环境问题]")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "remark", value = "问题描述")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "qualityType", value = "质量问题类型")
   @JsonProperty("qualityType")
   @JSONField(name = "qualityType")
   private String qualityType;
   @ApiModelProperty(name = "askRectifyTime", value = "要求整改日期")
   @JsonProperty("askRectifyTime")
   @JSONField(name = "askRectifyTime")
   private LocalDateTime askRectifyTime;
   @ApiModelProperty(name = "forfeit", value = "罚金")
   @JsonProperty("forfeit")
   @JSONField(name = "forfeit")
   private BigDecimal forfeit;
   @ApiModelProperty(name = "status", value = "状态 [1待整改2已整改4已关闭]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "powerType", value = "权限 [1 查看 2 整改 4 审核]")
   @JsonProperty("powerType")
   @JSONField(name = "powerType")
   private Integer powerType;
   @ApiModelProperty(name = "userName", value = "申报用户名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "dutyName", value = "负责人用户名")
   @JsonProperty("dutyName")
   @JSONField(name = "dutyName")
   private String dutyName;
   @ApiModelProperty(name = "projectName", value = "项目名")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "factoryName", value = "工厂名")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;
   @ApiModelProperty(name = "workshopName", value = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productionLineName", value = "生产线名")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "processName", value = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "productName", value = "产品名")
   @JsonProperty("productName")
   @JSONField(name = "productName")
   private String productName;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号")
   @JsonProperty("productSerialNumber")
   @JSONField(name = "productSerialNumber")
   private String productSerialNumber;
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "qhseNumber", value = "编号")
   @JsonProperty("qhseNumber")
   @JSONField(name = "qhseNumber")
   private String qhseNumber;
   @ApiModelProperty(name = "levelOneType", value = "一级分类id")
   @JsonProperty("levelOneType")
   @JSONField(name = "levelOneType")
   private Long levelOneType;
   @ApiModelProperty(name = "levelOneName", value = "一级分类id")
   @JsonProperty("levelOneName")
   @JSONField(name = "levelOneName")
   private String levelOneName;
   @ApiModelProperty(name = "levelTwoType", value = "二级分类id")
   @JsonProperty("levelTwoType")
   @JSONField(name = "levelTwoType")
   private Long levelTwoType;
   @ApiModelProperty(name = "levelTwoName", value = "二级分类id")
   @JsonProperty("levelTwoName")
   @JSONField(name = "levelTwoName")
   private String levelTwoName;
   @ApiModelProperty(name = "behaviorScore", notes = "行为分数")
   @JsonProperty("behaviorScore")
   @JSONField(name = "behaviorScore")
   private Integer behaviorScore;
   @ApiModelProperty(name = "penalty", value = "罚金", notes = "罚金")
   @JsonProperty("penalty")
   @JSONField(name = "penalty")
   private BigDecimal penalty;
   @ApiModelProperty(name = "boolNeedReply", value = "是否需要回复[0:无需1:需要]", notes = "是否需要回复[0:无需1:需要]")
   @JsonProperty("boolNeedReply")
   @JSONField(name = "boolNeedReply")
   private Boolean boolNeedReply;
   @ApiModelProperty(name = "number", value = "一物一码号,特殊质量问题专属字段")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "firstRectifyTime", value = "首次整改日期", notes = "首次整改日期")
   @JsonProperty("firstRectifyTime")
   @JSONField(name = "firstRectifyTime")
   private LocalDateTime firstRectifyTime;
   @ApiModelProperty(name = "customPenalty", value = "自定义罚金", notes = "自定义罚金")
   @JsonProperty("customPenalty")
   @JSONField(name = "customPenalty")
   private BigDecimal customPenalty;

   public static MesBuildingQhseDO.MesBuildingQhseDOBuilder builder() {
      return new MesBuildingQhseDO.MesBuildingQhseDOBuilder();
   }

   public MesBuildingQhseDO() {
   }

   public MesBuildingQhseDO(
      final Long id,
      final Long projectId,
      final String serialNumber,
      final Long monomerId,
      final String monomerName,
      final Long areaId,
      final String areaName,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long taskId,
      final Long processId,
      final Long taskProcessId,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer problemQuantity,
      final String problemDrawing,
      final Long drawingLabel,
      final Long userId,
      final Long dutyId,
      final Long teamId,
      final Integer type,
      final String remark,
      final String qualityType,
      final LocalDateTime askRectifyTime,
      final BigDecimal forfeit,
      final Integer status,
      final Integer powerType,
      final String userName,
      final String dutyName,
      final String projectName,
      final String factoryName,
      final String workshopName,
      final String productionLineName,
      final String processName,
      final String productName,
      final String productSerialNumber,
      final ProjectDetailDO project,
      final String qhseNumber,
      final Long levelOneType,
      final String levelOneName,
      final Long levelTwoType,
      final String levelTwoName,
      final Integer behaviorScore,
      final BigDecimal penalty,
      final Boolean boolNeedReply,
      final Integer number,
      final LocalDateTime firstRectifyTime,
      final BigDecimal customPenalty
   ) {
      this.id = id;
      this.projectId = projectId;
      this.serialNumber = serialNumber;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.areaId = areaId;
      this.areaName = areaName;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.taskId = taskId;
      this.processId = processId;
      this.taskProcessId = taskProcessId;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.problemQuantity = problemQuantity;
      this.problemDrawing = problemDrawing;
      this.drawingLabel = drawingLabel;
      this.userId = userId;
      this.dutyId = dutyId;
      this.teamId = teamId;
      this.type = type;
      this.remark = remark;
      this.qualityType = qualityType;
      this.askRectifyTime = askRectifyTime;
      this.forfeit = forfeit;
      this.status = status;
      this.powerType = powerType;
      this.userName = userName;
      this.dutyName = dutyName;
      this.projectName = projectName;
      this.factoryName = factoryName;
      this.workshopName = workshopName;
      this.productionLineName = productionLineName;
      this.processName = processName;
      this.productName = productName;
      this.productSerialNumber = productSerialNumber;
      this.project = project;
      this.qhseNumber = qhseNumber;
      this.levelOneType = levelOneType;
      this.levelOneName = levelOneName;
      this.levelTwoType = levelTwoType;
      this.levelTwoName = levelTwoName;
      this.behaviorScore = behaviorScore;
      this.penalty = penalty;
      this.boolNeedReply = boolNeedReply;
      this.number = number;
      this.firstRectifyTime = firstRectifyTime;
      this.customPenalty = customPenalty;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
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

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProductId() {
      return this.productId;
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

   public Long getUserId() {
      return this.userId;
   }

   public Long getDutyId() {
      return this.dutyId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Integer getType() {
      return this.type;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getQualityType() {
      return this.qualityType;
   }

   public LocalDateTime getAskRectifyTime() {
      return this.askRectifyTime;
   }

   public BigDecimal getForfeit() {
      return this.forfeit;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Integer getPowerType() {
      return this.powerType;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getDutyName() {
      return this.dutyName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public String getQhseNumber() {
      return this.qhseNumber;
   }

   public Long getLevelOneType() {
      return this.levelOneType;
   }

   public String getLevelOneName() {
      return this.levelOneName;
   }

   public Long getLevelTwoType() {
      return this.levelTwoType;
   }

   public String getLevelTwoName() {
      return this.levelTwoName;
   }

   public Integer getBehaviorScore() {
      return this.behaviorScore;
   }

   public BigDecimal getPenalty() {
      return this.penalty;
   }

   public Boolean getBoolNeedReply() {
      return this.boolNeedReply;
   }

   public Integer getNumber() {
      return this.number;
   }

   public LocalDateTime getFirstRectifyTime() {
      return this.firstRectifyTime;
   }

   public BigDecimal getCustomPenalty() {
      return this.customPenalty;
   }

   @JsonProperty("id")
   public MesBuildingQhseDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingQhseDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingQhseDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingQhseDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("monomerName")
   public MesBuildingQhseDO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingQhseDO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("areaName")
   public MesBuildingQhseDO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingQhseDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingQhseDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingQhseDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingQhseDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingQhseDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingQhseDO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingQhseDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingQhseDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesBuildingQhseDO setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("problemDrawing")
   public MesBuildingQhseDO setProblemDrawing(final String problemDrawing) {
      this.problemDrawing = problemDrawing;
      return this;
   }

   @JsonProperty("drawingLabel")
   public MesBuildingQhseDO setDrawingLabel(final Long drawingLabel) {
      this.drawingLabel = drawingLabel;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingQhseDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("dutyId")
   public MesBuildingQhseDO setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingQhseDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingQhseDO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingQhseDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("qualityType")
   public MesBuildingQhseDO setQualityType(final String qualityType) {
      this.qualityType = qualityType;
      return this;
   }

   @JsonProperty("askRectifyTime")
   public MesBuildingQhseDO setAskRectifyTime(final LocalDateTime askRectifyTime) {
      this.askRectifyTime = askRectifyTime;
      return this;
   }

   @JsonProperty("forfeit")
   public MesBuildingQhseDO setForfeit(final BigDecimal forfeit) {
      this.forfeit = forfeit;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingQhseDO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("powerType")
   public MesBuildingQhseDO setPowerType(final Integer powerType) {
      this.powerType = powerType;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingQhseDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("dutyName")
   public MesBuildingQhseDO setDutyName(final String dutyName) {
      this.dutyName = dutyName;
      return this;
   }

   @JsonProperty("projectName")
   public MesBuildingQhseDO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("factoryName")
   public MesBuildingQhseDO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("workshopName")
   public MesBuildingQhseDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesBuildingQhseDO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingQhseDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productName")
   public MesBuildingQhseDO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("productSerialNumber")
   public MesBuildingQhseDO setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingQhseDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("qhseNumber")
   public MesBuildingQhseDO setQhseNumber(final String qhseNumber) {
      this.qhseNumber = qhseNumber;
      return this;
   }

   @JsonProperty("levelOneType")
   public MesBuildingQhseDO setLevelOneType(final Long levelOneType) {
      this.levelOneType = levelOneType;
      return this;
   }

   @JsonProperty("levelOneName")
   public MesBuildingQhseDO setLevelOneName(final String levelOneName) {
      this.levelOneName = levelOneName;
      return this;
   }

   @JsonProperty("levelTwoType")
   public MesBuildingQhseDO setLevelTwoType(final Long levelTwoType) {
      this.levelTwoType = levelTwoType;
      return this;
   }

   @JsonProperty("levelTwoName")
   public MesBuildingQhseDO setLevelTwoName(final String levelTwoName) {
      this.levelTwoName = levelTwoName;
      return this;
   }

   @JsonProperty("behaviorScore")
   public MesBuildingQhseDO setBehaviorScore(final Integer behaviorScore) {
      this.behaviorScore = behaviorScore;
      return this;
   }

   @JsonProperty("penalty")
   public MesBuildingQhseDO setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
      return this;
   }

   @JsonProperty("boolNeedReply")
   public MesBuildingQhseDO setBoolNeedReply(final Boolean boolNeedReply) {
      this.boolNeedReply = boolNeedReply;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingQhseDO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("firstRectifyTime")
   public MesBuildingQhseDO setFirstRectifyTime(final LocalDateTime firstRectifyTime) {
      this.firstRectifyTime = firstRectifyTime;
      return this;
   }

   @JsonProperty("customPenalty")
   public MesBuildingQhseDO setCustomPenalty(final BigDecimal customPenalty) {
      this.customPenalty = customPenalty;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhseDO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", taskId="
         + this.getTaskId()
         + ", processId="
         + this.getProcessId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", problemQuantity="
         + this.getProblemQuantity()
         + ", problemDrawing="
         + this.getProblemDrawing()
         + ", drawingLabel="
         + this.getDrawingLabel()
         + ", userId="
         + this.getUserId()
         + ", dutyId="
         + this.getDutyId()
         + ", teamId="
         + this.getTeamId()
         + ", type="
         + this.getType()
         + ", remark="
         + this.getRemark()
         + ", qualityType="
         + this.getQualityType()
         + ", askRectifyTime="
         + this.getAskRectifyTime()
         + ", forfeit="
         + this.getForfeit()
         + ", status="
         + this.getStatus()
         + ", powerType="
         + this.getPowerType()
         + ", userName="
         + this.getUserName()
         + ", dutyName="
         + this.getDutyName()
         + ", projectName="
         + this.getProjectName()
         + ", factoryName="
         + this.getFactoryName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", processName="
         + this.getProcessName()
         + ", productName="
         + this.getProductName()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", project="
         + this.getProject()
         + ", qhseNumber="
         + this.getQhseNumber()
         + ", levelOneType="
         + this.getLevelOneType()
         + ", levelOneName="
         + this.getLevelOneName()
         + ", levelTwoType="
         + this.getLevelTwoType()
         + ", levelTwoName="
         + this.getLevelTwoName()
         + ", behaviorScore="
         + this.getBehaviorScore()
         + ", penalty="
         + this.getPenalty()
         + ", boolNeedReply="
         + this.getBoolNeedReply()
         + ", number="
         + this.getNumber()
         + ", firstRectifyTime="
         + this.getFirstRectifyTime()
         + ", customPenalty="
         + this.getCustomPenalty()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseDO)) {
         return false;
      }

      MesBuildingQhseDO other = (MesBuildingQhseDO)o;
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
                              Object this$processId = this.getProcessId();
                              Object other$processId = other.getProcessId();
                              if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                 Object this$taskProcessId = this.getTaskProcessId();
                                 Object other$taskProcessId = other.getTaskProcessId();
                                 if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
                                    Object this$productId = this.getProductId();
                                    Object other$productId = other.getProductId();
                                    if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                       Object this$taskTypeEnum = this.getTaskTypeEnum();
                                       Object other$taskTypeEnum = other.getTaskTypeEnum();
                                       if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                                          Object this$problemQuantity = this.getProblemQuantity();
                                          Object other$problemQuantity = other.getProblemQuantity();
                                          if (this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity)
                                             )
                                           {
                                             Object this$drawingLabel = this.getDrawingLabel();
                                             Object other$drawingLabel = other.getDrawingLabel();
                                             if (this$drawingLabel == null ? other$drawingLabel == null : this$drawingLabel.equals(other$drawingLabel)) {
                                                Object this$userId = this.getUserId();
                                                Object other$userId = other.getUserId();
                                                if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                   Object this$dutyId = this.getDutyId();
                                                   Object other$dutyId = other.getDutyId();
                                                   if (this$dutyId == null ? other$dutyId == null : this$dutyId.equals(other$dutyId)) {
                                                      Object this$teamId = this.getTeamId();
                                                      Object other$teamId = other.getTeamId();
                                                      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                                                         Object this$type = this.getType();
                                                         Object other$type = other.getType();
                                                         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                                            Object this$status = this.getStatus();
                                                            Object other$status = other.getStatus();
                                                            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                                               Object this$powerType = this.getPowerType();
                                                               Object other$powerType = other.getPowerType();
                                                               if (this$powerType == null ? other$powerType == null : this$powerType.equals(other$powerType)) {
                                                                  Object this$levelOneType = this.getLevelOneType();
                                                                  Object other$levelOneType = other.getLevelOneType();
                                                                  if (this$levelOneType == null
                                                                     ? other$levelOneType == null
                                                                     : this$levelOneType.equals(other$levelOneType)) {
                                                                     Object this$levelTwoType = this.getLevelTwoType();
                                                                     Object other$levelTwoType = other.getLevelTwoType();
                                                                     if (this$levelTwoType == null
                                                                        ? other$levelTwoType == null
                                                                        : this$levelTwoType.equals(other$levelTwoType)) {
                                                                        Object this$behaviorScore = this.getBehaviorScore();
                                                                        Object other$behaviorScore = other.getBehaviorScore();
                                                                        if (this$behaviorScore == null
                                                                           ? other$behaviorScore == null
                                                                           : this$behaviorScore.equals(other$behaviorScore)) {
                                                                           Object this$boolNeedReply = this.getBoolNeedReply();
                                                                           Object other$boolNeedReply = other.getBoolNeedReply();
                                                                           if (this$boolNeedReply == null
                                                                              ? other$boolNeedReply == null
                                                                              : this$boolNeedReply.equals(other$boolNeedReply)) {
                                                                              Object this$number = this.getNumber();
                                                                              Object other$number = other.getNumber();
                                                                              if (this$number == null ? other$number == null : this$number.equals(other$number)
                                                                                 )
                                                                               {
                                                                                 Object this$serialNumber = this.getSerialNumber();
                                                                                 Object other$serialNumber = other.getSerialNumber();
                                                                                 if (this$serialNumber == null
                                                                                    ? other$serialNumber == null
                                                                                    : this$serialNumber.equals(other$serialNumber)) {
                                                                                    Object this$monomerName = this.getMonomerName();
                                                                                    Object other$monomerName = other.getMonomerName();
                                                                                    if (this$monomerName == null
                                                                                       ? other$monomerName == null
                                                                                       : this$monomerName.equals(other$monomerName)) {
                                                                                       Object this$areaName = this.getAreaName();
                                                                                       Object other$areaName = other.getAreaName();
                                                                                       if (this$areaName == null
                                                                                          ? other$areaName == null
                                                                                          : this$areaName.equals(other$areaName)) {
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
                                                                                                Object this$qualityType = this.getQualityType();
                                                                                                Object other$qualityType = other.getQualityType();
                                                                                                if (this$qualityType == null
                                                                                                   ? other$qualityType == null
                                                                                                   : this$qualityType.equals(other$qualityType)) {
                                                                                                   Object this$askRectifyTime = this.getAskRectifyTime();
                                                                                                   Object other$askRectifyTime = other.getAskRectifyTime();
                                                                                                   if (this$askRectifyTime == null
                                                                                                      ? other$askRectifyTime == null
                                                                                                      : this$askRectifyTime.equals(other$askRectifyTime)) {
                                                                                                      Object this$forfeit = this.getForfeit();
                                                                                                      Object other$forfeit = other.getForfeit();
                                                                                                      if (this$forfeit == null
                                                                                                         ? other$forfeit == null
                                                                                                         : this$forfeit.equals(other$forfeit)) {
                                                                                                         Object this$userName = this.getUserName();
                                                                                                         Object other$userName = other.getUserName();
                                                                                                         if (this$userName == null
                                                                                                            ? other$userName == null
                                                                                                            : this$userName.equals(other$userName)) {
                                                                                                            Object this$dutyName = this.getDutyName();
                                                                                                            Object other$dutyName = other.getDutyName();
                                                                                                            if (this$dutyName == null
                                                                                                               ? other$dutyName == null
                                                                                                               : this$dutyName.equals(other$dutyName)) {
                                                                                                               Object this$projectName = this.getProjectName();
                                                                                                               Object other$projectName = other.getProjectName();
                                                                                                               if (this$projectName == null
                                                                                                                  ? other$projectName == null
                                                                                                                  : this$projectName.equals(other$projectName)) {
                                                                                                                  Object this$factoryName = this.getFactoryName();
                                                                                                                  Object other$factoryName = other.getFactoryName();
                                                                                                                  if (this$factoryName == null
                                                                                                                     ? other$factoryName == null
                                                                                                                     : this$factoryName.equals(
                                                                                                                        other$factoryName
                                                                                                                     )) {
                                                                                                                     Object this$workshopName = this.getWorkshopName();
                                                                                                                     Object other$workshopName = other.getWorkshopName();
                                                                                                                     if (this$workshopName == null
                                                                                                                        ? other$workshopName == null
                                                                                                                        : this$workshopName.equals(
                                                                                                                           other$workshopName
                                                                                                                        )) {
                                                                                                                        Object this$productionLineName = this.getProductionLineName();
                                                                                                                        Object other$productionLineName = other.getProductionLineName();
                                                                                                                        if (this$productionLineName == null
                                                                                                                           ? other$productionLineName == null
                                                                                                                           : this$productionLineName.equals(
                                                                                                                              other$productionLineName
                                                                                                                           )) {
                                                                                                                           Object this$processName = this.getProcessName();
                                                                                                                           Object other$processName = other.getProcessName();
                                                                                                                           if (this$processName == null
                                                                                                                              ? other$processName == null
                                                                                                                              : this$processName.equals(
                                                                                                                                 other$processName
                                                                                                                              )) {
                                                                                                                              Object this$productName = this.getProductName();
                                                                                                                              Object other$productName = other.getProductName();
                                                                                                                              if (this$productName == null
                                                                                                                                 ? other$productName == null
                                                                                                                                 : this$productName.equals(
                                                                                                                                    other$productName
                                                                                                                                 )) {
                                                                                                                                 Object this$productSerialNumber = this.getProductSerialNumber();
                                                                                                                                 Object other$productSerialNumber = other.getProductSerialNumber();
                                                                                                                                 if (this$productSerialNumber
                                                                                                                                       == null
                                                                                                                                    ? other$productSerialNumber
                                                                                                                                       == null
                                                                                                                                    : this$productSerialNumber.equals(
                                                                                                                                       other$productSerialNumber
                                                                                                                                    )) {
                                                                                                                                    Object this$project = this.getProject();
                                                                                                                                    Object other$project = other.getProject();
                                                                                                                                    if (this$project == null
                                                                                                                                       ? other$project == null
                                                                                                                                       : this$project.equals(
                                                                                                                                          other$project
                                                                                                                                       )) {
                                                                                                                                       Object this$qhseNumber = this.getQhseNumber();
                                                                                                                                       Object other$qhseNumber = other.getQhseNumber();
                                                                                                                                       if (this$qhseNumber
                                                                                                                                             == null
                                                                                                                                          ? other$qhseNumber
                                                                                                                                             == null
                                                                                                                                          : this$qhseNumber.equals(
                                                                                                                                             other$qhseNumber
                                                                                                                                          )) {
                                                                                                                                          Object this$levelOneName = this.getLevelOneName();
                                                                                                                                          Object other$levelOneName = other.getLevelOneName();
                                                                                                                                          if (this$levelOneName
                                                                                                                                                == null
                                                                                                                                             ? other$levelOneName
                                                                                                                                                == null
                                                                                                                                             : this$levelOneName.equals(
                                                                                                                                                other$levelOneName
                                                                                                                                             )) {
                                                                                                                                             Object this$levelTwoName = this.getLevelTwoName();
                                                                                                                                             Object other$levelTwoName = other.getLevelTwoName();
                                                                                                                                             if (this$levelTwoName
                                                                                                                                                   == null
                                                                                                                                                ? other$levelTwoName
                                                                                                                                                   == null
                                                                                                                                                : this$levelTwoName.equals(
                                                                                                                                                   other$levelTwoName
                                                                                                                                                )) {
                                                                                                                                                Object this$penalty = this.getPenalty();
                                                                                                                                                Object other$penalty = other.getPenalty();
                                                                                                                                                if (this$penalty
                                                                                                                                                      == null
                                                                                                                                                   ? other$penalty
                                                                                                                                                      == null
                                                                                                                                                   : this$penalty.equals(
                                                                                                                                                      other$penalty
                                                                                                                                                   )) {
                                                                                                                                                   Object this$firstRectifyTime = this.getFirstRectifyTime();
                                                                                                                                                   Object other$firstRectifyTime = other.getFirstRectifyTime();
                                                                                                                                                   if (this$firstRectifyTime
                                                                                                                                                         == null
                                                                                                                                                      ? other$firstRectifyTime
                                                                                                                                                         == null
                                                                                                                                                      : this$firstRectifyTime.equals(
                                                                                                                                                         other$firstRectifyTime
                                                                                                                                                      )) {
                                                                                                                                                      Object this$customPenalty = this.getCustomPenalty();
                                                                                                                                                      Object other$customPenalty = other.getCustomPenalty();
                                                                                                                                                      return this$customPenalty
                                                                                                                                                            == null
                                                                                                                                                         ? other$customPenalty
                                                                                                                                                            == null
                                                                                                                                                         : this$customPenalty.equals(
                                                                                                                                                            other$customPenalty
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
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingQhseDO;
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
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      result = result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
      Object $drawingLabel = this.getDrawingLabel();
      result = result * 59 + ($drawingLabel == null ? 43 : $drawingLabel.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $dutyId = this.getDutyId();
      result = result * 59 + ($dutyId == null ? 43 : $dutyId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $powerType = this.getPowerType();
      result = result * 59 + ($powerType == null ? 43 : $powerType.hashCode());
      Object $levelOneType = this.getLevelOneType();
      result = result * 59 + ($levelOneType == null ? 43 : $levelOneType.hashCode());
      Object $levelTwoType = this.getLevelTwoType();
      result = result * 59 + ($levelTwoType == null ? 43 : $levelTwoType.hashCode());
      Object $behaviorScore = this.getBehaviorScore();
      result = result * 59 + ($behaviorScore == null ? 43 : $behaviorScore.hashCode());
      Object $boolNeedReply = this.getBoolNeedReply();
      result = result * 59 + ($boolNeedReply == null ? 43 : $boolNeedReply.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $problemDrawing = this.getProblemDrawing();
      result = result * 59 + ($problemDrawing == null ? 43 : $problemDrawing.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $qualityType = this.getQualityType();
      result = result * 59 + ($qualityType == null ? 43 : $qualityType.hashCode());
      Object $askRectifyTime = this.getAskRectifyTime();
      result = result * 59 + ($askRectifyTime == null ? 43 : $askRectifyTime.hashCode());
      Object $forfeit = this.getForfeit();
      result = result * 59 + ($forfeit == null ? 43 : $forfeit.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $dutyName = this.getDutyName();
      result = result * 59 + ($dutyName == null ? 43 : $dutyName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $qhseNumber = this.getQhseNumber();
      result = result * 59 + ($qhseNumber == null ? 43 : $qhseNumber.hashCode());
      Object $levelOneName = this.getLevelOneName();
      result = result * 59 + ($levelOneName == null ? 43 : $levelOneName.hashCode());
      Object $levelTwoName = this.getLevelTwoName();
      result = result * 59 + ($levelTwoName == null ? 43 : $levelTwoName.hashCode());
      Object $penalty = this.getPenalty();
      result = result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
      Object $firstRectifyTime = this.getFirstRectifyTime();
      result = result * 59 + ($firstRectifyTime == null ? 43 : $firstRectifyTime.hashCode());
      Object $customPenalty = this.getCustomPenalty();
      return result * 59 + ($customPenalty == null ? 43 : $customPenalty.hashCode());
   }

   public static class MesBuildingQhseDOBuilder {
      private Long id;
      private Long projectId;
      private String serialNumber;
      private Long monomerId;
      private String monomerName;
      private Long areaId;
      private String areaName;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long taskId;
      private Long processId;
      private Long taskProcessId;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer problemQuantity;
      private String problemDrawing;
      private Long drawingLabel;
      private Long userId;
      private Long dutyId;
      private Long teamId;
      private Integer type;
      private String remark;
      private String qualityType;
      private LocalDateTime askRectifyTime;
      private BigDecimal forfeit;
      private Integer status;
      private Integer powerType;
      private String userName;
      private String dutyName;
      private String projectName;
      private String factoryName;
      private String workshopName;
      private String productionLineName;
      private String processName;
      private String productName;
      private String productSerialNumber;
      private ProjectDetailDO project;
      private String qhseNumber;
      private Long levelOneType;
      private String levelOneName;
      private Long levelTwoType;
      private String levelTwoName;
      private Integer behaviorScore;
      private BigDecimal penalty;
      private Boolean boolNeedReply;
      private Integer number;
      private LocalDateTime firstRectifyTime;
      private BigDecimal customPenalty;

      MesBuildingQhseDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("monomerName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("areaName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("problemDrawing")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder problemDrawing(final String problemDrawing) {
         this.problemDrawing = problemDrawing;
         return this;
      }

      @JsonProperty("drawingLabel")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder drawingLabel(final Long drawingLabel) {
         this.drawingLabel = drawingLabel;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("dutyId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("qualityType")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder qualityType(final String qualityType) {
         this.qualityType = qualityType;
         return this;
      }

      @JsonProperty("askRectifyTime")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder askRectifyTime(final LocalDateTime askRectifyTime) {
         this.askRectifyTime = askRectifyTime;
         return this;
      }

      @JsonProperty("forfeit")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder forfeit(final BigDecimal forfeit) {
         this.forfeit = forfeit;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("powerType")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder powerType(final Integer powerType) {
         this.powerType = powerType;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("dutyName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder dutyName(final String dutyName) {
         this.dutyName = dutyName;
         return this;
      }

      @JsonProperty("projectName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("factoryName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("productSerialNumber")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("qhseNumber")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder qhseNumber(final String qhseNumber) {
         this.qhseNumber = qhseNumber;
         return this;
      }

      @JsonProperty("levelOneType")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder levelOneType(final Long levelOneType) {
         this.levelOneType = levelOneType;
         return this;
      }

      @JsonProperty("levelOneName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder levelOneName(final String levelOneName) {
         this.levelOneName = levelOneName;
         return this;
      }

      @JsonProperty("levelTwoType")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder levelTwoType(final Long levelTwoType) {
         this.levelTwoType = levelTwoType;
         return this;
      }

      @JsonProperty("levelTwoName")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder levelTwoName(final String levelTwoName) {
         this.levelTwoName = levelTwoName;
         return this;
      }

      @JsonProperty("behaviorScore")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder behaviorScore(final Integer behaviorScore) {
         this.behaviorScore = behaviorScore;
         return this;
      }

      @JsonProperty("penalty")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      @JsonProperty("boolNeedReply")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder boolNeedReply(final Boolean boolNeedReply) {
         this.boolNeedReply = boolNeedReply;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("firstRectifyTime")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder firstRectifyTime(final LocalDateTime firstRectifyTime) {
         this.firstRectifyTime = firstRectifyTime;
         return this;
      }

      @JsonProperty("customPenalty")
      public MesBuildingQhseDO.MesBuildingQhseDOBuilder customPenalty(final BigDecimal customPenalty) {
         this.customPenalty = customPenalty;
         return this;
      }

      public MesBuildingQhseDO build() {
         return new MesBuildingQhseDO(
            this.id,
            this.projectId,
            this.serialNumber,
            this.monomerId,
            this.monomerName,
            this.areaId,
            this.areaName,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.taskId,
            this.processId,
            this.taskProcessId,
            this.productId,
            this.taskTypeEnum,
            this.problemQuantity,
            this.problemDrawing,
            this.drawingLabel,
            this.userId,
            this.dutyId,
            this.teamId,
            this.type,
            this.remark,
            this.qualityType,
            this.askRectifyTime,
            this.forfeit,
            this.status,
            this.powerType,
            this.userName,
            this.dutyName,
            this.projectName,
            this.factoryName,
            this.workshopName,
            this.productionLineName,
            this.processName,
            this.productName,
            this.productSerialNumber,
            this.project,
            this.qhseNumber,
            this.levelOneType,
            this.levelOneName,
            this.levelTwoType,
            this.levelTwoName,
            this.behaviorScore,
            this.penalty,
            this.boolNeedReply,
            this.number,
            this.firstRectifyTime,
            this.customPenalty
         );
      }

      @Override
      public String toString() {
         return "MesBuildingQhseDO.MesBuildingQhseDOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", serialNumber="
            + this.serialNumber
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", areaId="
            + this.areaId
            + ", areaName="
            + this.areaName
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
            + ", taskId="
            + this.taskId
            + ", processId="
            + this.processId
            + ", taskProcessId="
            + this.taskProcessId
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", problemQuantity="
            + this.problemQuantity
            + ", problemDrawing="
            + this.problemDrawing
            + ", drawingLabel="
            + this.drawingLabel
            + ", userId="
            + this.userId
            + ", dutyId="
            + this.dutyId
            + ", teamId="
            + this.teamId
            + ", type="
            + this.type
            + ", remark="
            + this.remark
            + ", qualityType="
            + this.qualityType
            + ", askRectifyTime="
            + this.askRectifyTime
            + ", forfeit="
            + this.forfeit
            + ", status="
            + this.status
            + ", powerType="
            + this.powerType
            + ", userName="
            + this.userName
            + ", dutyName="
            + this.dutyName
            + ", projectName="
            + this.projectName
            + ", factoryName="
            + this.factoryName
            + ", workshopName="
            + this.workshopName
            + ", productionLineName="
            + this.productionLineName
            + ", processName="
            + this.processName
            + ", productName="
            + this.productName
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", project="
            + this.project
            + ", qhseNumber="
            + this.qhseNumber
            + ", levelOneType="
            + this.levelOneType
            + ", levelOneName="
            + this.levelOneName
            + ", levelTwoType="
            + this.levelTwoType
            + ", levelTwoName="
            + this.levelTwoName
            + ", behaviorScore="
            + this.behaviorScore
            + ", penalty="
            + this.penalty
            + ", boolNeedReply="
            + this.boolNeedReply
            + ", number="
            + this.number
            + ", firstRectifyTime="
            + this.firstRectifyTime
            + ", customPenalty="
            + this.customPenalty
            + ")";
      }
   }
}
