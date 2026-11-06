package com.hzchum.scim.mes.enclosure.core.api.pojo._do.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "MesEnclosureQhseDO对象", description = "问题曝光 ")
public class MesEnclosureQhseDO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "planId", value = "区域id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   private Long planId;
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

   public static MesEnclosureQhseDO.MesEnclosureQhseDOBuilder builder() {
      return new MesEnclosureQhseDO.MesEnclosureQhseDOBuilder();
   }

   public MesEnclosureQhseDO() {
   }

   public MesEnclosureQhseDO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long planId,
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
      final ProjectDetailDO project
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
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

   @JsonProperty("id")
   public MesEnclosureQhseDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureQhseDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureQhseDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureQhseDO setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureQhseDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureQhseDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureQhseDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("taskId")
   public MesEnclosureQhseDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureQhseDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesEnclosureQhseDO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureQhseDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureQhseDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesEnclosureQhseDO setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("problemDrawing")
   public MesEnclosureQhseDO setProblemDrawing(final String problemDrawing) {
      this.problemDrawing = problemDrawing;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureQhseDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("dutyId")
   public MesEnclosureQhseDO setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureQhseDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("type")
   public MesEnclosureQhseDO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureQhseDO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("qualityType")
   public MesEnclosureQhseDO setQualityType(final String qualityType) {
      this.qualityType = qualityType;
      return this;
   }

   @JsonProperty("askRectifyTime")
   public MesEnclosureQhseDO setAskRectifyTime(final LocalDateTime askRectifyTime) {
      this.askRectifyTime = askRectifyTime;
      return this;
   }

   @JsonProperty("forfeit")
   public MesEnclosureQhseDO setForfeit(final BigDecimal forfeit) {
      this.forfeit = forfeit;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureQhseDO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("powerType")
   public MesEnclosureQhseDO setPowerType(final Integer powerType) {
      this.powerType = powerType;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureQhseDO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("dutyName")
   public MesEnclosureQhseDO setDutyName(final String dutyName) {
      this.dutyName = dutyName;
      return this;
   }

   @JsonProperty("projectName")
   public MesEnclosureQhseDO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("factoryName")
   public MesEnclosureQhseDO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("workshopName")
   public MesEnclosureQhseDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesEnclosureQhseDO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("processName")
   public MesEnclosureQhseDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productName")
   public MesEnclosureQhseDO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("productSerialNumber")
   public MesEnclosureQhseDO setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   @JsonProperty("project")
   public MesEnclosureQhseDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureQhseDO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureQhseDO)) {
         return false;
      }

      MesEnclosureQhseDO other = (MesEnclosureQhseDO)o;
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
                                                               Object this$problemDrawing = this.getProblemDrawing();
                                                               Object other$problemDrawing = other.getProblemDrawing();
                                                               if (this$problemDrawing == null
                                                                  ? other$problemDrawing == null
                                                                  : this$problemDrawing.equals(other$problemDrawing)) {
                                                                  Object this$remark = this.getRemark();
                                                                  Object other$remark = other.getRemark();
                                                                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
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
                                                                                          : this$factoryName.equals(other$factoryName)) {
                                                                                          Object this$workshopName = this.getWorkshopName();
                                                                                          Object other$workshopName = other.getWorkshopName();
                                                                                          if (this$workshopName == null
                                                                                             ? other$workshopName == null
                                                                                             : this$workshopName.equals(other$workshopName)) {
                                                                                             Object this$productionLineName = this.getProductionLineName();
                                                                                             Object other$productionLineName = other.getProductionLineName();
                                                                                             if (this$productionLineName == null
                                                                                                ? other$productionLineName == null
                                                                                                : this$productionLineName.equals(other$productionLineName)) {
                                                                                                Object this$processName = this.getProcessName();
                                                                                                Object other$processName = other.getProcessName();
                                                                                                if (this$processName == null
                                                                                                   ? other$processName == null
                                                                                                   : this$processName.equals(other$processName)) {
                                                                                                   Object this$productName = this.getProductName();
                                                                                                   Object other$productName = other.getProductName();
                                                                                                   if (this$productName == null
                                                                                                      ? other$productName == null
                                                                                                      : this$productName.equals(other$productName)) {
                                                                                                      Object this$productSerialNumber = this.getProductSerialNumber();
                                                                                                      Object other$productSerialNumber = other.getProductSerialNumber();
                                                                                                      if (this$productSerialNumber == null
                                                                                                         ? other$productSerialNumber == null
                                                                                                         : this$productSerialNumber.equals(
                                                                                                            other$productSerialNumber
                                                                                                         )) {
                                                                                                         Object this$project = this.getProject();
                                                                                                         Object other$project = other.getProject();
                                                                                                         return this$project == null
                                                                                                            ? other$project == null
                                                                                                            : this$project.equals(other$project);
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesEnclosureQhseDO;
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
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   public static class MesEnclosureQhseDOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long planId;
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

      MesEnclosureQhseDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("taskId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("problemDrawing")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder problemDrawing(final String problemDrawing) {
         this.problemDrawing = problemDrawing;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("dutyId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("type")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("qualityType")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder qualityType(final String qualityType) {
         this.qualityType = qualityType;
         return this;
      }

      @JsonProperty("askRectifyTime")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder askRectifyTime(final LocalDateTime askRectifyTime) {
         this.askRectifyTime = askRectifyTime;
         return this;
      }

      @JsonProperty("forfeit")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder forfeit(final BigDecimal forfeit) {
         this.forfeit = forfeit;
         return this;
      }

      @JsonProperty("status")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("powerType")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder powerType(final Integer powerType) {
         this.powerType = powerType;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("dutyName")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder dutyName(final String dutyName) {
         this.dutyName = dutyName;
         return this;
      }

      @JsonProperty("projectName")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("factoryName")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("workshopName")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("processName")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productName")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("productSerialNumber")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      @JsonProperty("project")
      public MesEnclosureQhseDO.MesEnclosureQhseDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      public MesEnclosureQhseDO build() {
         return new MesEnclosureQhseDO(
            this.id,
            this.projectId,
            this.monomerId,
            this.planId,
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
            this.project
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureQhseDO.MesEnclosureQhseDOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
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
            + ")";
      }
   }
}
