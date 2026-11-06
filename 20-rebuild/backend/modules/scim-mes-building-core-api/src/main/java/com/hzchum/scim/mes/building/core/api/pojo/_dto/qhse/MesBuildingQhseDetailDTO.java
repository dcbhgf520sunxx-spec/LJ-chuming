package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingQhseDetailDTO", description = "问题详情")
public class MesBuildingQhseDetailDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "taskId", value = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "productSerialNumber", value = "项目编号")
   @JsonProperty("productSerialNumber")
   @JSONField(name = "productSerialNumber")
   private String productSerialNumber;
   @ApiModelProperty(name = "problemDrawing", notes = "问题上报图片ids")
   @JsonProperty("problemDrawing")
   @JSONField(name = "problemDrawing")
   private String problemDrawing;
   @ApiModelProperty(name = "number", value = "一物一码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private String number;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "inspectUserName", value = "质检人", notes = "质检人")
   @JsonProperty("inspectUserName")
   @JSONField(name = "inspectUserName")
   private String inspectUserName;
   @ApiModelProperty(name = "teamName", value = "班组", notes = "班组")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;
   @ApiModelProperty(name = "lossTime", value = "损耗时间", notes = "损耗时间")
   @JsonProperty("lossTime")
   @JSONField(name = "lossTime")
   private Long lossTime;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "productName", value = "产品名")
   @JsonProperty("productName")
   @JSONField(name = "productName")
   private String productName;
   @ApiModelProperty(name = "type", value = "问题类型 [1质量问题2安全问题4环境问题8特殊质量]")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
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
   @ApiModelProperty(name = "remark", value = "问题描述")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "rectifyDrawing", notes = "问题上报图片ids")
   @JsonProperty("rectifyDrawing")
   @JSONField(name = "rectifyDrawing")
   private String rectifyDrawing;
   @ApiModelProperty(name = "attachmentDTOS", value = "问题报告附件")
   @JsonProperty("attachmentDTOS")
   @JSONField(name = "attachmentDTOS")
   private List<AttachmentDTO> attachmentDTOS;
   @ApiModelProperty(name = "qhseRectifyDTOS", value = "问题整改")
   @JsonProperty("qhseRectifyDTOS")
   @JSONField(name = "qhseRectifyDTOS")
   private List<MesBuildingQhseRectifyDTO> qhseRectifyDTOS;
   @ApiModelProperty(name = "drawingLabel", notes = "图纸标注")
   @JsonProperty("drawingLabel")
   @JSONField(name = "drawingLabel")
   private Long drawingLabel;
   @ApiModelProperty(name = "numbers", value = "图纸序列号")
   @JsonProperty("numbers")
   @JSONField(name = "numbers")
   private List<Integer> numbers;
   @ApiModelProperty(name = "drawingLabelDTO", value = "图纸")
   @JsonProperty("drawingLabelDTO")
   @JSONField(name = "drawingLabelDTO")
   private AttachmentDTO drawingLabelDTO;
   @ApiModelProperty(name = "drawingLabelPath", value = "图纸地址")
   @JsonProperty("drawingLabelPath")
   @JSONField(name = "drawingLabelPath")
   private String drawingLabelPath;
   @ApiModelProperty(name = "customPenalty", value = "自定义罚金", notes = "自定义罚金")
   @JsonProperty("customPenalty")
   @JSONField(name = "customPenalty")
   private BigDecimal customPenalty;

   public static MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder builder() {
      return new MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder();
   }

   public MesBuildingQhseDetailDTO() {
   }

   public MesBuildingQhseDetailDTO(
      final Long id,
      final Long projectId,
      final Long productId,
      final Long monomerId,
      final Long areaId,
      final Long taskId,
      final Integer taskTypeEnum,
      final String productSerialNumber,
      final String problemDrawing,
      final String number,
      final String specification,
      final String inspectUserName,
      final String teamName,
      final Long lossTime,
      final String processName,
      final String productName,
      final Integer type,
      final Integer status,
      final Long levelOneType,
      final String levelOneName,
      final Long levelTwoType,
      final String levelTwoName,
      final Integer behaviorScore,
      final BigDecimal penalty,
      final String remark,
      final String rectifyDrawing,
      final List<AttachmentDTO> attachmentDTOS,
      final List<MesBuildingQhseRectifyDTO> qhseRectifyDTOS,
      final Long drawingLabel,
      final List<Integer> numbers,
      final AttachmentDTO drawingLabelDTO,
      final String drawingLabelPath,
      final BigDecimal customPenalty
   ) {
      this.id = id;
      this.projectId = projectId;
      this.productId = productId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.taskId = taskId;
      this.taskTypeEnum = taskTypeEnum;
      this.productSerialNumber = productSerialNumber;
      this.problemDrawing = problemDrawing;
      this.number = number;
      this.specification = specification;
      this.inspectUserName = inspectUserName;
      this.teamName = teamName;
      this.lossTime = lossTime;
      this.processName = processName;
      this.productName = productName;
      this.type = type;
      this.status = status;
      this.levelOneType = levelOneType;
      this.levelOneName = levelOneName;
      this.levelTwoType = levelTwoType;
      this.levelTwoName = levelTwoName;
      this.behaviorScore = behaviorScore;
      this.penalty = penalty;
      this.remark = remark;
      this.rectifyDrawing = rectifyDrawing;
      this.attachmentDTOS = attachmentDTOS;
      this.qhseRectifyDTOS = qhseRectifyDTOS;
      this.drawingLabel = drawingLabel;
      this.numbers = numbers;
      this.drawingLabelDTO = drawingLabelDTO;
      this.drawingLabelPath = drawingLabelPath;
      this.customPenalty = customPenalty;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getProblemDrawing() {
      return this.problemDrawing;
   }

   public String getNumber() {
      return this.number;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getInspectUserName() {
      return this.inspectUserName;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public Long getLossTime() {
      return this.lossTime;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getProductName() {
      return this.productName;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getStatus() {
      return this.status;
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

   public String getRemark() {
      return this.remark;
   }

   public String getRectifyDrawing() {
      return this.rectifyDrawing;
   }

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public List<MesBuildingQhseRectifyDTO> getQhseRectifyDTOS() {
      return this.qhseRectifyDTOS;
   }

   public Long getDrawingLabel() {
      return this.drawingLabel;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public AttachmentDTO getDrawingLabelDTO() {
      return this.drawingLabelDTO;
   }

   public String getDrawingLabelPath() {
      return this.drawingLabelPath;
   }

   public BigDecimal getCustomPenalty() {
      return this.customPenalty;
   }

   @JsonProperty("id")
   public MesBuildingQhseDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingQhseDetailDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingQhseDetailDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingQhseDetailDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingQhseDetailDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingQhseDetailDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingQhseDetailDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("productSerialNumber")
   public MesBuildingQhseDetailDTO setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
      return this;
   }

   @JsonProperty("problemDrawing")
   public MesBuildingQhseDetailDTO setProblemDrawing(final String problemDrawing) {
      this.problemDrawing = problemDrawing;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingQhseDetailDTO setNumber(final String number) {
      this.number = number;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingQhseDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("inspectUserName")
   public MesBuildingQhseDetailDTO setInspectUserName(final String inspectUserName) {
      this.inspectUserName = inspectUserName;
      return this;
   }

   @JsonProperty("teamName")
   public MesBuildingQhseDetailDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @JsonProperty("lossTime")
   public MesBuildingQhseDetailDTO setLossTime(final Long lossTime) {
      this.lossTime = lossTime;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingQhseDetailDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("productName")
   public MesBuildingQhseDetailDTO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingQhseDetailDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingQhseDetailDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("levelOneType")
   public MesBuildingQhseDetailDTO setLevelOneType(final Long levelOneType) {
      this.levelOneType = levelOneType;
      return this;
   }

   @JsonProperty("levelOneName")
   public MesBuildingQhseDetailDTO setLevelOneName(final String levelOneName) {
      this.levelOneName = levelOneName;
      return this;
   }

   @JsonProperty("levelTwoType")
   public MesBuildingQhseDetailDTO setLevelTwoType(final Long levelTwoType) {
      this.levelTwoType = levelTwoType;
      return this;
   }

   @JsonProperty("levelTwoName")
   public MesBuildingQhseDetailDTO setLevelTwoName(final String levelTwoName) {
      this.levelTwoName = levelTwoName;
      return this;
   }

   @JsonProperty("behaviorScore")
   public MesBuildingQhseDetailDTO setBehaviorScore(final Integer behaviorScore) {
      this.behaviorScore = behaviorScore;
      return this;
   }

   @JsonProperty("penalty")
   public MesBuildingQhseDetailDTO setPenalty(final BigDecimal penalty) {
      this.penalty = penalty;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingQhseDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("rectifyDrawing")
   public MesBuildingQhseDetailDTO setRectifyDrawing(final String rectifyDrawing) {
      this.rectifyDrawing = rectifyDrawing;
      return this;
   }

   @JsonProperty("attachmentDTOS")
   public MesBuildingQhseDetailDTO setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
      return this;
   }

   @JsonProperty("qhseRectifyDTOS")
   public MesBuildingQhseDetailDTO setQhseRectifyDTOS(final List<MesBuildingQhseRectifyDTO> qhseRectifyDTOS) {
      this.qhseRectifyDTOS = qhseRectifyDTOS;
      return this;
   }

   @JsonProperty("drawingLabel")
   public MesBuildingQhseDetailDTO setDrawingLabel(final Long drawingLabel) {
      this.drawingLabel = drawingLabel;
      return this;
   }

   @JsonProperty("numbers")
   public MesBuildingQhseDetailDTO setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
      return this;
   }

   @JsonProperty("drawingLabelDTO")
   public MesBuildingQhseDetailDTO setDrawingLabelDTO(final AttachmentDTO drawingLabelDTO) {
      this.drawingLabelDTO = drawingLabelDTO;
      return this;
   }

   @JsonProperty("drawingLabelPath")
   public MesBuildingQhseDetailDTO setDrawingLabelPath(final String drawingLabelPath) {
      this.drawingLabelPath = drawingLabelPath;
      return this;
   }

   @JsonProperty("customPenalty")
   public MesBuildingQhseDetailDTO setCustomPenalty(final BigDecimal customPenalty) {
      this.customPenalty = customPenalty;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhseDetailDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", productId="
         + this.getProductId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", taskId="
         + this.getTaskId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", problemDrawing="
         + this.getProblemDrawing()
         + ", number="
         + this.getNumber()
         + ", specification="
         + this.getSpecification()
         + ", inspectUserName="
         + this.getInspectUserName()
         + ", teamName="
         + this.getTeamName()
         + ", lossTime="
         + this.getLossTime()
         + ", processName="
         + this.getProcessName()
         + ", productName="
         + this.getProductName()
         + ", type="
         + this.getType()
         + ", status="
         + this.getStatus()
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
         + ", remark="
         + this.getRemark()
         + ", rectifyDrawing="
         + this.getRectifyDrawing()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ", qhseRectifyDTOS="
         + this.getQhseRectifyDTOS()
         + ", drawingLabel="
         + this.getDrawingLabel()
         + ", numbers="
         + this.getNumbers()
         + ", drawingLabelDTO="
         + this.getDrawingLabelDTO()
         + ", drawingLabelPath="
         + this.getDrawingLabelPath()
         + ", customPenalty="
         + this.getCustomPenalty()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseDetailDTO)) {
         return false;
      }

      MesBuildingQhseDetailDTO other = (MesBuildingQhseDetailDTO)o;
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
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$taskId = this.getTaskId();
                     Object other$taskId = other.getTaskId();
                     if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                        Object this$taskTypeEnum = this.getTaskTypeEnum();
                        Object other$taskTypeEnum = other.getTaskTypeEnum();
                        if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                           Object this$lossTime = this.getLossTime();
                           Object other$lossTime = other.getLossTime();
                           if (this$lossTime == null ? other$lossTime == null : this$lossTime.equals(other$lossTime)) {
                              Object this$type = this.getType();
                              Object other$type = other.getType();
                              if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                 Object this$status = this.getStatus();
                                 Object other$status = other.getStatus();
                                 if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                    Object this$levelOneType = this.getLevelOneType();
                                    Object other$levelOneType = other.getLevelOneType();
                                    if (this$levelOneType == null ? other$levelOneType == null : this$levelOneType.equals(other$levelOneType)) {
                                       Object this$levelTwoType = this.getLevelTwoType();
                                       Object other$levelTwoType = other.getLevelTwoType();
                                       if (this$levelTwoType == null ? other$levelTwoType == null : this$levelTwoType.equals(other$levelTwoType)) {
                                          Object this$behaviorScore = this.getBehaviorScore();
                                          Object other$behaviorScore = other.getBehaviorScore();
                                          if (this$behaviorScore == null ? other$behaviorScore == null : this$behaviorScore.equals(other$behaviorScore)) {
                                             Object this$drawingLabel = this.getDrawingLabel();
                                             Object other$drawingLabel = other.getDrawingLabel();
                                             if (this$drawingLabel == null ? other$drawingLabel == null : this$drawingLabel.equals(other$drawingLabel)) {
                                                Object this$productSerialNumber = this.getProductSerialNumber();
                                                Object other$productSerialNumber = other.getProductSerialNumber();
                                                if (this$productSerialNumber == null
                                                   ? other$productSerialNumber == null
                                                   : this$productSerialNumber.equals(other$productSerialNumber)) {
                                                   Object this$problemDrawing = this.getProblemDrawing();
                                                   Object other$problemDrawing = other.getProblemDrawing();
                                                   if (this$problemDrawing == null
                                                      ? other$problemDrawing == null
                                                      : this$problemDrawing.equals(other$problemDrawing)) {
                                                      Object this$number = this.getNumber();
                                                      Object other$number = other.getNumber();
                                                      if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                                         Object this$specification = this.getSpecification();
                                                         Object other$specification = other.getSpecification();
                                                         if (this$specification == null
                                                            ? other$specification == null
                                                            : this$specification.equals(other$specification)) {
                                                            Object this$inspectUserName = this.getInspectUserName();
                                                            Object other$inspectUserName = other.getInspectUserName();
                                                            if (this$inspectUserName == null
                                                               ? other$inspectUserName == null
                                                               : this$inspectUserName.equals(other$inspectUserName)) {
                                                               Object this$teamName = this.getTeamName();
                                                               Object other$teamName = other.getTeamName();
                                                               if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
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
                                                                        Object this$levelOneName = this.getLevelOneName();
                                                                        Object other$levelOneName = other.getLevelOneName();
                                                                        if (this$levelOneName == null
                                                                           ? other$levelOneName == null
                                                                           : this$levelOneName.equals(other$levelOneName)) {
                                                                           Object this$levelTwoName = this.getLevelTwoName();
                                                                           Object other$levelTwoName = other.getLevelTwoName();
                                                                           if (this$levelTwoName == null
                                                                              ? other$levelTwoName == null
                                                                              : this$levelTwoName.equals(other$levelTwoName)) {
                                                                              Object this$penalty = this.getPenalty();
                                                                              Object other$penalty = other.getPenalty();
                                                                              if (this$penalty == null
                                                                                 ? other$penalty == null
                                                                                 : this$penalty.equals(other$penalty)) {
                                                                                 Object this$remark = this.getRemark();
                                                                                 Object other$remark = other.getRemark();
                                                                                 if (this$remark == null
                                                                                    ? other$remark == null
                                                                                    : this$remark.equals(other$remark)) {
                                                                                    Object this$rectifyDrawing = this.getRectifyDrawing();
                                                                                    Object other$rectifyDrawing = other.getRectifyDrawing();
                                                                                    if (this$rectifyDrawing == null
                                                                                       ? other$rectifyDrawing == null
                                                                                       : this$rectifyDrawing.equals(other$rectifyDrawing)) {
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
                                                                                             Object this$numbers = this.getNumbers();
                                                                                             Object other$numbers = other.getNumbers();
                                                                                             if (this$numbers == null
                                                                                                ? other$numbers == null
                                                                                                : this$numbers.equals(other$numbers)) {
                                                                                                Object this$drawingLabelDTO = this.getDrawingLabelDTO();
                                                                                                Object other$drawingLabelDTO = other.getDrawingLabelDTO();
                                                                                                if (this$drawingLabelDTO == null
                                                                                                   ? other$drawingLabelDTO == null
                                                                                                   : this$drawingLabelDTO.equals(other$drawingLabelDTO)) {
                                                                                                   Object this$drawingLabelPath = this.getDrawingLabelPath();
                                                                                                   Object other$drawingLabelPath = other.getDrawingLabelPath();
                                                                                                   if (this$drawingLabelPath == null
                                                                                                      ? other$drawingLabelPath == null
                                                                                                      : this$drawingLabelPath.equals(other$drawingLabelPath)) {
                                                                                                      Object this$customPenalty = this.getCustomPenalty();
                                                                                                      Object other$customPenalty = other.getCustomPenalty();
                                                                                                      return this$customPenalty == null
                                                                                                         ? other$customPenalty == null
                                                                                                         : this$customPenalty.equals(other$customPenalty);
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingQhseDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $lossTime = this.getLossTime();
      result = result * 59 + ($lossTime == null ? 43 : $lossTime.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $levelOneType = this.getLevelOneType();
      result = result * 59 + ($levelOneType == null ? 43 : $levelOneType.hashCode());
      Object $levelTwoType = this.getLevelTwoType();
      result = result * 59 + ($levelTwoType == null ? 43 : $levelTwoType.hashCode());
      Object $behaviorScore = this.getBehaviorScore();
      result = result * 59 + ($behaviorScore == null ? 43 : $behaviorScore.hashCode());
      Object $drawingLabel = this.getDrawingLabel();
      result = result * 59 + ($drawingLabel == null ? 43 : $drawingLabel.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $problemDrawing = this.getProblemDrawing();
      result = result * 59 + ($problemDrawing == null ? 43 : $problemDrawing.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $inspectUserName = this.getInspectUserName();
      result = result * 59 + ($inspectUserName == null ? 43 : $inspectUserName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $levelOneName = this.getLevelOneName();
      result = result * 59 + ($levelOneName == null ? 43 : $levelOneName.hashCode());
      Object $levelTwoName = this.getLevelTwoName();
      result = result * 59 + ($levelTwoName == null ? 43 : $levelTwoName.hashCode());
      Object $penalty = this.getPenalty();
      result = result * 59 + ($penalty == null ? 43 : $penalty.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $rectifyDrawing = this.getRectifyDrawing();
      result = result * 59 + ($rectifyDrawing == null ? 43 : $rectifyDrawing.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      result = result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
      Object $qhseRectifyDTOS = this.getQhseRectifyDTOS();
      result = result * 59 + ($qhseRectifyDTOS == null ? 43 : $qhseRectifyDTOS.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingLabelDTO = this.getDrawingLabelDTO();
      result = result * 59 + ($drawingLabelDTO == null ? 43 : $drawingLabelDTO.hashCode());
      Object $drawingLabelPath = this.getDrawingLabelPath();
      result = result * 59 + ($drawingLabelPath == null ? 43 : $drawingLabelPath.hashCode());
      Object $customPenalty = this.getCustomPenalty();
      return result * 59 + ($customPenalty == null ? 43 : $customPenalty.hashCode());
   }

   public static class MesBuildingQhseDetailDTOBuilder {
      private Long id;
      private Long projectId;
      private Long productId;
      private Long monomerId;
      private Long areaId;
      private Long taskId;
      private Integer taskTypeEnum;
      private String productSerialNumber;
      private String problemDrawing;
      private String number;
      private String specification;
      private String inspectUserName;
      private String teamName;
      private Long lossTime;
      private String processName;
      private String productName;
      private Integer type;
      private Integer status;
      private Long levelOneType;
      private String levelOneName;
      private Long levelTwoType;
      private String levelTwoName;
      private Integer behaviorScore;
      private BigDecimal penalty;
      private String remark;
      private String rectifyDrawing;
      private List<AttachmentDTO> attachmentDTOS;
      private List<MesBuildingQhseRectifyDTO> qhseRectifyDTOS;
      private Long drawingLabel;
      private List<Integer> numbers;
      private AttachmentDTO drawingLabelDTO;
      private String drawingLabelPath;
      private BigDecimal customPenalty;

      MesBuildingQhseDetailDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("productSerialNumber")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      @JsonProperty("problemDrawing")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder problemDrawing(final String problemDrawing) {
         this.problemDrawing = problemDrawing;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder number(final String number) {
         this.number = number;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("inspectUserName")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder inspectUserName(final String inspectUserName) {
         this.inspectUserName = inspectUserName;
         return this;
      }

      @JsonProperty("teamName")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      @JsonProperty("lossTime")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder lossTime(final Long lossTime) {
         this.lossTime = lossTime;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("productName")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("levelOneType")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder levelOneType(final Long levelOneType) {
         this.levelOneType = levelOneType;
         return this;
      }

      @JsonProperty("levelOneName")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder levelOneName(final String levelOneName) {
         this.levelOneName = levelOneName;
         return this;
      }

      @JsonProperty("levelTwoType")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder levelTwoType(final Long levelTwoType) {
         this.levelTwoType = levelTwoType;
         return this;
      }

      @JsonProperty("levelTwoName")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder levelTwoName(final String levelTwoName) {
         this.levelTwoName = levelTwoName;
         return this;
      }

      @JsonProperty("behaviorScore")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder behaviorScore(final Integer behaviorScore) {
         this.behaviorScore = behaviorScore;
         return this;
      }

      @JsonProperty("penalty")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder penalty(final BigDecimal penalty) {
         this.penalty = penalty;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("rectifyDrawing")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder rectifyDrawing(final String rectifyDrawing) {
         this.rectifyDrawing = rectifyDrawing;
         return this;
      }

      @JsonProperty("attachmentDTOS")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder attachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
         this.attachmentDTOS = attachmentDTOS;
         return this;
      }

      @JsonProperty("qhseRectifyDTOS")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder qhseRectifyDTOS(final List<MesBuildingQhseRectifyDTO> qhseRectifyDTOS) {
         this.qhseRectifyDTOS = qhseRectifyDTOS;
         return this;
      }

      @JsonProperty("drawingLabel")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder drawingLabel(final Long drawingLabel) {
         this.drawingLabel = drawingLabel;
         return this;
      }

      @JsonProperty("numbers")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder numbers(final List<Integer> numbers) {
         this.numbers = numbers;
         return this;
      }

      @JsonProperty("drawingLabelDTO")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder drawingLabelDTO(final AttachmentDTO drawingLabelDTO) {
         this.drawingLabelDTO = drawingLabelDTO;
         return this;
      }

      @JsonProperty("drawingLabelPath")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder drawingLabelPath(final String drawingLabelPath) {
         this.drawingLabelPath = drawingLabelPath;
         return this;
      }

      @JsonProperty("customPenalty")
      public MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder customPenalty(final BigDecimal customPenalty) {
         this.customPenalty = customPenalty;
         return this;
      }

      public MesBuildingQhseDetailDTO build() {
         return new MesBuildingQhseDetailDTO(
            this.id,
            this.projectId,
            this.productId,
            this.monomerId,
            this.areaId,
            this.taskId,
            this.taskTypeEnum,
            this.productSerialNumber,
            this.problemDrawing,
            this.number,
            this.specification,
            this.inspectUserName,
            this.teamName,
            this.lossTime,
            this.processName,
            this.productName,
            this.type,
            this.status,
            this.levelOneType,
            this.levelOneName,
            this.levelTwoType,
            this.levelTwoName,
            this.behaviorScore,
            this.penalty,
            this.remark,
            this.rectifyDrawing,
            this.attachmentDTOS,
            this.qhseRectifyDTOS,
            this.drawingLabel,
            this.numbers,
            this.drawingLabelDTO,
            this.drawingLabelPath,
            this.customPenalty
         );
      }

      @Override
      public String toString() {
         return "MesBuildingQhseDetailDTO.MesBuildingQhseDetailDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", productId="
            + this.productId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", taskId="
            + this.taskId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", problemDrawing="
            + this.problemDrawing
            + ", number="
            + this.number
            + ", specification="
            + this.specification
            + ", inspectUserName="
            + this.inspectUserName
            + ", teamName="
            + this.teamName
            + ", lossTime="
            + this.lossTime
            + ", processName="
            + this.processName
            + ", productName="
            + this.productName
            + ", type="
            + this.type
            + ", status="
            + this.status
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
            + ", remark="
            + this.remark
            + ", rectifyDrawing="
            + this.rectifyDrawing
            + ", attachmentDTOS="
            + this.attachmentDTOS
            + ", qhseRectifyDTOS="
            + this.qhseRectifyDTOS
            + ", drawingLabel="
            + this.drawingLabel
            + ", numbers="
            + this.numbers
            + ", drawingLabelDTO="
            + this.drawingLabelDTO
            + ", drawingLabelPath="
            + this.drawingLabelPath
            + ", customPenalty="
            + this.customPenalty
            + ")";
      }
   }
}
