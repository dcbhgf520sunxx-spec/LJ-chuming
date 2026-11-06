package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;

@ApiModel(value = "MesEnclosureQhseDTO对象", description = "问题曝光 ")
public class MesEnclosureQhseDTO extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   @TableField("task_process_id ")
   @Column(name = "task_process_id ")
   private Long taskProcessId;
   @ApiModelProperty(name = "processId", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
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
   @ApiModelProperty(name = "qualityTypeList", value = "质量问题类型")
   @JsonProperty("qualityTypeList")
   @JSONField(name = "qualityTypeList")
   private List<String> qualityTypeList;
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
   @ApiModelProperty(name = "attachmentDTOS", value = "问题报告附件")
   @JsonProperty("attachmentDTOS")
   @JSONField(name = "attachmentDTOS")
   private List<AttachmentDTO> attachmentDTOS;
   @ApiModelProperty(name = "qhseRectifyDTOS", value = "问题整改")
   @JsonProperty("qhseRectifyDTOS")
   @JSONField(name = "qhseRectifyDTOS")
   private List<MesEnclosureQhseRectifyDTO> qhseRectifyDTOS;
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
   @ApiModelProperty(name = "numberList", value = "序号列表")
   @JsonProperty("numberList")
   @JSONField(name = "numberList")
   private List<Integer> numberList;

   public static MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder builder() {
      return new MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder();
   }

   public MesEnclosureQhseDTO() {
   }

   public MesEnclosureQhseDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long taskId,
      final Long taskProcessId,
      final Long processId,
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
      final List<String> qualityTypeList,
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
      final List<AttachmentDTO> attachmentDTOS,
      final List<MesEnclosureQhseRectifyDTO> qhseRectifyDTOS,
      final String processName,
      final String productName,
      final String productSerialNumber,
      final ProjectDetailDO project,
      final List<Integer> numberList
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.processId = processId;
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
      this.qualityTypeList = qualityTypeList;
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
      this.attachmentDTOS = attachmentDTOS;
      this.qhseRectifyDTOS = qhseRectifyDTOS;
      this.processName = processName;
      this.productName = productName;
      this.productSerialNumber = productSerialNumber;
      this.project = project;
      this.numberList = numberList;
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

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getProcessId() {
      return this.processId;
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

   public List<String> getQualityTypeList() {
      return this.qualityTypeList;
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

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public List<MesEnclosureQhseRectifyDTO> getQhseRectifyDTOS() {
      return this.qhseRectifyDTOS;
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

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   @JsonProperty("id")
   public MesEnclosureQhseDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesEnclosureQhseDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesEnclosureQhseDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("planId")
   public MesEnclosureQhseDTO setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesEnclosureQhseDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesEnclosureQhseDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesEnclosureQhseDTO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("taskId")
   public MesEnclosureQhseDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesEnclosureQhseDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("processId")
   public MesEnclosureQhseDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureQhseDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesEnclosureQhseDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesEnclosureQhseDTO setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("problemDrawing")
   public MesEnclosureQhseDTO setProblemDrawing(final String problemDrawing) {
      this.problemDrawing = problemDrawing;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureQhseDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("dutyId")
   public MesEnclosureQhseDTO setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureQhseDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("type")
   public MesEnclosureQhseDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("remark")
   public MesEnclosureQhseDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("qualityType")
   public MesEnclosureQhseDTO setQualityType(final String qualityType) {
      this.qualityType = qualityType;
      return this;
   }

   @JsonProperty("qualityTypeList")
   public MesEnclosureQhseDTO setQualityTypeList(final List<String> qualityTypeList) {
      this.qualityTypeList = qualityTypeList;
      return this;
   }

   @JsonProperty("askRectifyTime")
   public MesEnclosureQhseDTO setAskRectifyTime(final LocalDateTime askRectifyTime) {
      this.askRectifyTime = askRectifyTime;
      return this;
   }

   @JsonProperty("forfeit")
   public MesEnclosureQhseDTO setForfeit(final BigDecimal forfeit) {
      this.forfeit = forfeit;
      return this;
   }

   @JsonProperty("status")
   public MesEnclosureQhseDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("powerType")
   public MesEnclosureQhseDTO setPowerType(final Integer powerType) {
      this.powerType = powerType;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureQhseDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("dutyName")
   public MesEnclosureQhseDTO setDutyName(final String dutyName) {
      this.dutyName = dutyName;
      return this;
   }

   @JsonProperty("projectName")
   public MesEnclosureQhseDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("factoryName")
   public MesEnclosureQhseDTO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("workshopName")
   public MesEnclosureQhseDTO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesEnclosureQhseDTO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("attachmentDTOS")
   public MesEnclosureQhseDTO setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
      return this;
   }

   @JsonProperty("qhseRectifyDTOS")
   public MesEnclosureQhseDTO setQhseRectifyDTOS(final List<MesEnclosureQhseRectifyDTO> qhseRectifyDTOS) {
      this.qhseRectifyDTOS = qhseRectifyDTOS;
      return this;
   }

   @JsonProperty("processName")
   public MesEnclosureQhseDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productName")
   public MesEnclosureQhseDTO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("productSerialNumber")
   public MesEnclosureQhseDTO setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   @JsonProperty("project")
   public MesEnclosureQhseDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("numberList")
   public MesEnclosureQhseDTO setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureQhseDTO(id="
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
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", processId="
         + this.getProcessId()
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
         + ", qualityTypeList="
         + this.getQualityTypeList()
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
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ", qhseRectifyDTOS="
         + this.getQhseRectifyDTOS()
         + ", processName="
         + this.getProcessName()
         + ", productName="
         + this.getProductName()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", project="
         + this.getProject()
         + ", numberList="
         + this.getNumberList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureQhseDTO)) {
         return false;
      }

      MesEnclosureQhseDTO other = (MesEnclosureQhseDTO)o;
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
                              Object this$taskProcessId = this.getTaskProcessId();
                              Object other$taskProcessId = other.getTaskProcessId();
                              if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
                                 Object this$processId = this.getProcessId();
                                 Object other$processId = other.getProcessId();
                                 if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
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
                                                                        Object this$qualityTypeList = this.getQualityTypeList();
                                                                        Object other$qualityTypeList = other.getQualityTypeList();
                                                                        if (this$qualityTypeList == null
                                                                           ? other$qualityTypeList == null
                                                                           : this$qualityTypeList.equals(other$qualityTypeList)) {
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
                                                                                                   Object this$attachmentDTOS = this.getAttachmentDTOS();
                                                                                                   Object other$attachmentDTOS = other.getAttachmentDTOS();
                                                                                                   if (this$attachmentDTOS == null
                                                                                                      ? other$attachmentDTOS == null
                                                                                                      : this$attachmentDTOS.equals(other$attachmentDTOS)) {
                                                                                                      Object this$qhseRectifyDTOS = this.getQhseRectifyDTOS();
                                                                                                      Object other$qhseRectifyDTOS = other.getQhseRectifyDTOS();
                                                                                                      if (this$qhseRectifyDTOS == null
                                                                                                         ? other$qhseRectifyDTOS == null
                                                                                                         : this$qhseRectifyDTOS.equals(other$qhseRectifyDTOS)) {
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
                                                                                                                  if (this$project == null
                                                                                                                     ? other$project == null
                                                                                                                     : this$project.equals(other$project)) {
                                                                                                                     Object this$numberList = this.getNumberList();
                                                                                                                     Object other$numberList = other.getNumberList();
                                                                                                                     return this$numberList == null
                                                                                                                        ? other$numberList == null
                                                                                                                        : this$numberList.equals(
                                                                                                                           other$numberList
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureQhseDTO;
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
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
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
      Object $qualityTypeList = this.getQualityTypeList();
      result = result * 59 + ($qualityTypeList == null ? 43 : $qualityTypeList.hashCode());
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
      Object $attachmentDTOS = this.getAttachmentDTOS();
      result = result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
      Object $qhseRectifyDTOS = this.getQhseRectifyDTOS();
      result = result * 59 + ($qhseRectifyDTOS == null ? 43 : $qhseRectifyDTOS.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   public static class MesEnclosureQhseDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long taskId;
      private Long taskProcessId;
      private Long processId;
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
      private List<String> qualityTypeList;
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
      private List<AttachmentDTO> attachmentDTOS;
      private List<MesEnclosureQhseRectifyDTO> qhseRectifyDTOS;
      private String processName;
      private String productName;
      private String productSerialNumber;
      private ProjectDetailDO project;
      private List<Integer> numberList;

      MesEnclosureQhseDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("planId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("taskId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("processId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("problemDrawing")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder problemDrawing(final String problemDrawing) {
         this.problemDrawing = problemDrawing;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("dutyId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("type")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("remark")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("qualityType")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder qualityType(final String qualityType) {
         this.qualityType = qualityType;
         return this;
      }

      @JsonProperty("qualityTypeList")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder qualityTypeList(final List<String> qualityTypeList) {
         this.qualityTypeList = qualityTypeList;
         return this;
      }

      @JsonProperty("askRectifyTime")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder askRectifyTime(final LocalDateTime askRectifyTime) {
         this.askRectifyTime = askRectifyTime;
         return this;
      }

      @JsonProperty("forfeit")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder forfeit(final BigDecimal forfeit) {
         this.forfeit = forfeit;
         return this;
      }

      @JsonProperty("status")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("powerType")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder powerType(final Integer powerType) {
         this.powerType = powerType;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("dutyName")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder dutyName(final String dutyName) {
         this.dutyName = dutyName;
         return this;
      }

      @JsonProperty("projectName")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("factoryName")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("workshopName")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("attachmentDTOS")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder attachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
         this.attachmentDTOS = attachmentDTOS;
         return this;
      }

      @JsonProperty("qhseRectifyDTOS")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder qhseRectifyDTOS(final List<MesEnclosureQhseRectifyDTO> qhseRectifyDTOS) {
         this.qhseRectifyDTOS = qhseRectifyDTOS;
         return this;
      }

      @JsonProperty("processName")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productName")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("productSerialNumber")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      @JsonProperty("project")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("numberList")
      public MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public MesEnclosureQhseDTO build() {
         return new MesEnclosureQhseDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.planId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.taskId,
            this.taskProcessId,
            this.processId,
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
            this.qualityTypeList,
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
            this.attachmentDTOS,
            this.qhseRectifyDTOS,
            this.processName,
            this.productName,
            this.productSerialNumber,
            this.project,
            this.numberList
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureQhseDTO.MesEnclosureQhseDTOBuilder(id="
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
            + ", taskProcessId="
            + this.taskProcessId
            + ", processId="
            + this.processId
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
            + ", qualityTypeList="
            + this.qualityTypeList
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
            + ", attachmentDTOS="
            + this.attachmentDTOS
            + ", qhseRectifyDTOS="
            + this.qhseRectifyDTOS
            + ", processName="
            + this.processName
            + ", productName="
            + this.productName
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", project="
            + this.project
            + ", numberList="
            + this.numberList
            + ")";
      }
   }
}
