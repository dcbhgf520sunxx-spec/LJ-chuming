package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.InspectionReportSavedDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingQhseDTOParam", description = "抽检 ")
public class MesBuildingCheckQhseDTOParam extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
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
   private Integer productType;
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
   @NotNull(message = "问题类型不能为空")
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
   @ApiModelProperty(name = "userLink", value = "抄送人")
   @JsonProperty("userLink")
   @JSONField(name = "userLink")
   private List<Long> userLink;
   @ApiModelProperty(name = "drawingIds", value = "问题上报图片ids")
   @JsonProperty("drawingIds")
   @JSONField(name = "drawingIds")
   private List<Long> drawingIds;
   @ApiModelProperty(name = "qualityTypeValues", value = "问题类型")
   @JsonProperty("qualityTypeValues")
   @JSONField(name = "qualityTypeValues")
   private List<String> qualityTypeValues;
   @ApiModelProperty(name = "levelOneType", value = "一级分类id")
   @JsonProperty("levelOneType")
   @JSONField(name = "levelOneType")
   private Long levelOneType;
   @ApiModelProperty(name = "levelTwoType", value = "二级分类id")
   @JsonProperty("levelTwoType")
   @JSONField(name = "levelTwoType")
   private Long levelTwoType;
   @ApiModelProperty(name = "numberList", notes = "上报编号列表", value = "上报编号列表")
   @JsonProperty("numberList")
   @JSONField(name = "numberList")
   private List<Integer> numberList;
   @ApiModelProperty(name = "reportList", value = "问题上报关联的上报记录")
   @JsonProperty("reportList")
   @JSONField(name = "reportList")
   List<InspectionReportSavedDTO> reportList;
   @ApiModelProperty(name = "boolNeedReply", value = "是否需要回复[0:无需1:需要]", notes = "是否需要回复[0:无需1:需要]")
   @JsonProperty("boolNeedReply")
   @JSONField(name = "boolNeedReply")
   private Boolean boolNeedReply;
   @ApiModelProperty(name = "submitRemark", value = "让步接收理由")
   @JsonProperty("submitRemark")
   @JSONField(name = "submitRemark")
   private String submitRemark;
   @ApiModelProperty(name = "boolConcessionAcceptance", value = "是否让步接收")
   @JsonProperty("boolConcessionAcceptance")
   @JSONField(name = "boolConcessionAcceptance")
   private Boolean boolConcessionAcceptance;
   @ApiModelProperty(name = "numberQualifiedList", value = "码号合格列表")
   @JsonProperty("numberQualifiedList")
   @JSONField(name = "numberQualifiedList")
   private List<ArtifactNumberQualifiedQuantityDTOParam> numberQualifiedList;
   @ApiModelProperty(name = "qualifiedQuantity", value = "合格数")
   @JsonProperty("qualifiedQuantity")
   @JSONField(name = "qualifiedQuantity")
   private Integer qualifiedQuantity;
   @ApiModelProperty(name = "unQualifiedQuantity", value = "不合格数")
   @JsonProperty("unQualifiedQuantity")
   @JSONField(name = "unQualifiedQuantity")
   private Integer unQualifiedQuantity;

   public static MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder builder() {
      return new MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder();
   }

   public MesBuildingCheckQhseDTOParam() {
   }

   public MesBuildingCheckQhseDTOParam(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long taskId,
      final Long processId,
      final Long taskProcessId,
      final Long productId,
      final Integer productType,
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
      final List<Long> userLink,
      final List<Long> drawingIds,
      final List<String> qualityTypeValues,
      final Long levelOneType,
      final Long levelTwoType,
      final List<Integer> numberList,
      final List<InspectionReportSavedDTO> reportList,
      final Boolean boolNeedReply,
      final String submitRemark,
      final Boolean boolConcessionAcceptance,
      final List<ArtifactNumberQualifiedQuantityDTOParam> numberQualifiedList,
      final Integer qualifiedQuantity,
      final Integer unQualifiedQuantity
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.taskId = taskId;
      this.processId = processId;
      this.taskProcessId = taskProcessId;
      this.productId = productId;
      this.productType = productType;
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
      this.userLink = userLink;
      this.drawingIds = drawingIds;
      this.qualityTypeValues = qualityTypeValues;
      this.levelOneType = levelOneType;
      this.levelTwoType = levelTwoType;
      this.numberList = numberList;
      this.reportList = reportList;
      this.boolNeedReply = boolNeedReply;
      this.submitRemark = submitRemark;
      this.boolConcessionAcceptance = boolConcessionAcceptance;
      this.numberQualifiedList = numberQualifiedList;
      this.qualifiedQuantity = qualifiedQuantity;
      this.unQualifiedQuantity = unQualifiedQuantity;
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

   public Integer getProductType() {
      return this.productType;
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

   public List<Long> getUserLink() {
      return this.userLink;
   }

   public List<Long> getDrawingIds() {
      return this.drawingIds;
   }

   public List<String> getQualityTypeValues() {
      return this.qualityTypeValues;
   }

   public Long getLevelOneType() {
      return this.levelOneType;
   }

   public Long getLevelTwoType() {
      return this.levelTwoType;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public List<InspectionReportSavedDTO> getReportList() {
      return this.reportList;
   }

   public Boolean getBoolNeedReply() {
      return this.boolNeedReply;
   }

   public String getSubmitRemark() {
      return this.submitRemark;
   }

   public Boolean getBoolConcessionAcceptance() {
      return this.boolConcessionAcceptance;
   }

   public List<ArtifactNumberQualifiedQuantityDTOParam> getNumberQualifiedList() {
      return this.numberQualifiedList;
   }

   public Integer getQualifiedQuantity() {
      return this.qualifiedQuantity;
   }

   public Integer getUnQualifiedQuantity() {
      return this.unQualifiedQuantity;
   }

   @JsonProperty("id")
   public MesBuildingCheckQhseDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingCheckQhseDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingCheckQhseDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingCheckQhseDTOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingCheckQhseDTOParam setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingCheckQhseDTOParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingCheckQhseDTOParam setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingCheckQhseDTOParam setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingCheckQhseDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public MesBuildingCheckQhseDTOParam setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingCheckQhseDTOParam setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingCheckQhseDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesBuildingCheckQhseDTOParam setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("problemDrawing")
   public MesBuildingCheckQhseDTOParam setProblemDrawing(final String problemDrawing) {
      this.problemDrawing = problemDrawing;
      return this;
   }

   @JsonProperty("drawingLabel")
   public MesBuildingCheckQhseDTOParam setDrawingLabel(final Long drawingLabel) {
      this.drawingLabel = drawingLabel;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingCheckQhseDTOParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("dutyId")
   public MesBuildingCheckQhseDTOParam setDutyId(final Long dutyId) {
      this.dutyId = dutyId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingCheckQhseDTOParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingCheckQhseDTOParam setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingCheckQhseDTOParam setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("qualityType")
   public MesBuildingCheckQhseDTOParam setQualityType(final String qualityType) {
      this.qualityType = qualityType;
      return this;
   }

   @JsonProperty("askRectifyTime")
   public MesBuildingCheckQhseDTOParam setAskRectifyTime(final LocalDateTime askRectifyTime) {
      this.askRectifyTime = askRectifyTime;
      return this;
   }

   @JsonProperty("forfeit")
   public MesBuildingCheckQhseDTOParam setForfeit(final BigDecimal forfeit) {
      this.forfeit = forfeit;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingCheckQhseDTOParam setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userLink")
   public MesBuildingCheckQhseDTOParam setUserLink(final List<Long> userLink) {
      this.userLink = userLink;
      return this;
   }

   @JsonProperty("drawingIds")
   public MesBuildingCheckQhseDTOParam setDrawingIds(final List<Long> drawingIds) {
      this.drawingIds = drawingIds;
      return this;
   }

   @JsonProperty("qualityTypeValues")
   public MesBuildingCheckQhseDTOParam setQualityTypeValues(final List<String> qualityTypeValues) {
      this.qualityTypeValues = qualityTypeValues;
      return this;
   }

   @JsonProperty("levelOneType")
   public MesBuildingCheckQhseDTOParam setLevelOneType(final Long levelOneType) {
      this.levelOneType = levelOneType;
      return this;
   }

   @JsonProperty("levelTwoType")
   public MesBuildingCheckQhseDTOParam setLevelTwoType(final Long levelTwoType) {
      this.levelTwoType = levelTwoType;
      return this;
   }

   @JsonProperty("numberList")
   public MesBuildingCheckQhseDTOParam setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @JsonProperty("reportList")
   public MesBuildingCheckQhseDTOParam setReportList(final List<InspectionReportSavedDTO> reportList) {
      this.reportList = reportList;
      return this;
   }

   @JsonProperty("boolNeedReply")
   public MesBuildingCheckQhseDTOParam setBoolNeedReply(final Boolean boolNeedReply) {
      this.boolNeedReply = boolNeedReply;
      return this;
   }

   @JsonProperty("submitRemark")
   public MesBuildingCheckQhseDTOParam setSubmitRemark(final String submitRemark) {
      this.submitRemark = submitRemark;
      return this;
   }

   @JsonProperty("boolConcessionAcceptance")
   public MesBuildingCheckQhseDTOParam setBoolConcessionAcceptance(final Boolean boolConcessionAcceptance) {
      this.boolConcessionAcceptance = boolConcessionAcceptance;
      return this;
   }

   @JsonProperty("numberQualifiedList")
   public MesBuildingCheckQhseDTOParam setNumberQualifiedList(final List<ArtifactNumberQualifiedQuantityDTOParam> numberQualifiedList) {
      this.numberQualifiedList = numberQualifiedList;
      return this;
   }

   @JsonProperty("qualifiedQuantity")
   public MesBuildingCheckQhseDTOParam setQualifiedQuantity(final Integer qualifiedQuantity) {
      this.qualifiedQuantity = qualifiedQuantity;
      return this;
   }

   @JsonProperty("unQualifiedQuantity")
   public MesBuildingCheckQhseDTOParam setUnQualifiedQuantity(final Integer unQualifiedQuantity) {
      this.unQualifiedQuantity = unQualifiedQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCheckQhseDTOParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
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
         + ", productType="
         + this.getProductType()
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
         + ", userLink="
         + this.getUserLink()
         + ", drawingIds="
         + this.getDrawingIds()
         + ", qualityTypeValues="
         + this.getQualityTypeValues()
         + ", levelOneType="
         + this.getLevelOneType()
         + ", levelTwoType="
         + this.getLevelTwoType()
         + ", numberList="
         + this.getNumberList()
         + ", reportList="
         + this.getReportList()
         + ", boolNeedReply="
         + this.getBoolNeedReply()
         + ", submitRemark="
         + this.getSubmitRemark()
         + ", boolConcessionAcceptance="
         + this.getBoolConcessionAcceptance()
         + ", numberQualifiedList="
         + this.getNumberQualifiedList()
         + ", qualifiedQuantity="
         + this.getQualifiedQuantity()
         + ", unQualifiedQuantity="
         + this.getUnQualifiedQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCheckQhseDTOParam)) {
         return false;
      }

      MesBuildingCheckQhseDTOParam other = (MesBuildingCheckQhseDTOParam)o;
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
                                       Object this$productType = this.getProductType();
                                       Object other$productType = other.getProductType();
                                       if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
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
                                                                     Object this$boolNeedReply = this.getBoolNeedReply();
                                                                     Object other$boolNeedReply = other.getBoolNeedReply();
                                                                     if (this$boolNeedReply == null
                                                                        ? other$boolNeedReply == null
                                                                        : this$boolNeedReply.equals(other$boolNeedReply)) {
                                                                        Object this$boolConcessionAcceptance = this.getBoolConcessionAcceptance();
                                                                        Object other$boolConcessionAcceptance = other.getBoolConcessionAcceptance();
                                                                        if (this$boolConcessionAcceptance == null
                                                                           ? other$boolConcessionAcceptance == null
                                                                           : this$boolConcessionAcceptance.equals(other$boolConcessionAcceptance)) {
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
                                                                                                Object this$userLink = this.getUserLink();
                                                                                                Object other$userLink = other.getUserLink();
                                                                                                if (this$userLink == null
                                                                                                   ? other$userLink == null
                                                                                                   : this$userLink.equals(other$userLink)) {
                                                                                                   Object this$drawingIds = this.getDrawingIds();
                                                                                                   Object other$drawingIds = other.getDrawingIds();
                                                                                                   if (this$drawingIds == null
                                                                                                      ? other$drawingIds == null
                                                                                                      : this$drawingIds.equals(other$drawingIds)) {
                                                                                                      Object this$qualityTypeValues = this.getQualityTypeValues();
                                                                                                      Object other$qualityTypeValues = other.getQualityTypeValues();
                                                                                                      if (this$qualityTypeValues == null
                                                                                                         ? other$qualityTypeValues == null
                                                                                                         : this$qualityTypeValues.equals(
                                                                                                            other$qualityTypeValues
                                                                                                         )) {
                                                                                                         Object this$numberList = this.getNumberList();
                                                                                                         Object other$numberList = other.getNumberList();
                                                                                                         if (this$numberList == null
                                                                                                            ? other$numberList == null
                                                                                                            : this$numberList.equals(other$numberList)) {
                                                                                                            Object this$reportList = this.getReportList();
                                                                                                            Object other$reportList = other.getReportList();
                                                                                                            if (this$reportList == null
                                                                                                               ? other$reportList == null
                                                                                                               : this$reportList.equals(other$reportList)) {
                                                                                                               Object this$submitRemark = this.getSubmitRemark();
                                                                                                               Object other$submitRemark = other.getSubmitRemark();
                                                                                                               if (this$submitRemark == null
                                                                                                                  ? other$submitRemark == null
                                                                                                                  : this$submitRemark.equals(other$submitRemark)
                                                                                                                  )
                                                                                                                {
                                                                                                                  Object this$numberQualifiedList = this.getNumberQualifiedList();
                                                                                                                  Object other$numberQualifiedList = other.getNumberQualifiedList();
                                                                                                                  return this$numberQualifiedList == null
                                                                                                                     ? other$numberQualifiedList == null
                                                                                                                     : this$numberQualifiedList.equals(
                                                                                                                        other$numberQualifiedList
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingCheckQhseDTOParam;
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
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
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
      Object $levelOneType = this.getLevelOneType();
      result = result * 59 + ($levelOneType == null ? 43 : $levelOneType.hashCode());
      Object $levelTwoType = this.getLevelTwoType();
      result = result * 59 + ($levelTwoType == null ? 43 : $levelTwoType.hashCode());
      Object $boolNeedReply = this.getBoolNeedReply();
      result = result * 59 + ($boolNeedReply == null ? 43 : $boolNeedReply.hashCode());
      Object $boolConcessionAcceptance = this.getBoolConcessionAcceptance();
      result = result * 59 + ($boolConcessionAcceptance == null ? 43 : $boolConcessionAcceptance.hashCode());
      Object $qualifiedQuantity = this.getQualifiedQuantity();
      result = result * 59 + ($qualifiedQuantity == null ? 43 : $qualifiedQuantity.hashCode());
      Object $unQualifiedQuantity = this.getUnQualifiedQuantity();
      result = result * 59 + ($unQualifiedQuantity == null ? 43 : $unQualifiedQuantity.hashCode());
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
      Object $userLink = this.getUserLink();
      result = result * 59 + ($userLink == null ? 43 : $userLink.hashCode());
      Object $drawingIds = this.getDrawingIds();
      result = result * 59 + ($drawingIds == null ? 43 : $drawingIds.hashCode());
      Object $qualityTypeValues = this.getQualityTypeValues();
      result = result * 59 + ($qualityTypeValues == null ? 43 : $qualityTypeValues.hashCode());
      Object $numberList = this.getNumberList();
      result = result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
      Object $reportList = this.getReportList();
      result = result * 59 + ($reportList == null ? 43 : $reportList.hashCode());
      Object $submitRemark = this.getSubmitRemark();
      result = result * 59 + ($submitRemark == null ? 43 : $submitRemark.hashCode());
      Object $numberQualifiedList = this.getNumberQualifiedList();
      return result * 59 + ($numberQualifiedList == null ? 43 : $numberQualifiedList.hashCode());
   }

   public static class MesBuildingCheckQhseDTOParamBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long taskId;
      private Long processId;
      private Long taskProcessId;
      private Long productId;
      private Integer productType;
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
      private List<Long> userLink;
      private List<Long> drawingIds;
      private List<String> qualityTypeValues;
      private Long levelOneType;
      private Long levelTwoType;
      private List<Integer> numberList;
      private List<InspectionReportSavedDTO> reportList;
      private Boolean boolNeedReply;
      private String submitRemark;
      private Boolean boolConcessionAcceptance;
      private List<ArtifactNumberQualifiedQuantityDTOParam> numberQualifiedList;
      private Integer qualifiedQuantity;
      private Integer unQualifiedQuantity;

      MesBuildingCheckQhseDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("problemDrawing")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder problemDrawing(final String problemDrawing) {
         this.problemDrawing = problemDrawing;
         return this;
      }

      @JsonProperty("drawingLabel")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder drawingLabel(final Long drawingLabel) {
         this.drawingLabel = drawingLabel;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("dutyId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder dutyId(final Long dutyId) {
         this.dutyId = dutyId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("qualityType")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder qualityType(final String qualityType) {
         this.qualityType = qualityType;
         return this;
      }

      @JsonProperty("askRectifyTime")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder askRectifyTime(final LocalDateTime askRectifyTime) {
         this.askRectifyTime = askRectifyTime;
         return this;
      }

      @JsonProperty("forfeit")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder forfeit(final BigDecimal forfeit) {
         this.forfeit = forfeit;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userLink")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder userLink(final List<Long> userLink) {
         this.userLink = userLink;
         return this;
      }

      @JsonProperty("drawingIds")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder drawingIds(final List<Long> drawingIds) {
         this.drawingIds = drawingIds;
         return this;
      }

      @JsonProperty("qualityTypeValues")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder qualityTypeValues(final List<String> qualityTypeValues) {
         this.qualityTypeValues = qualityTypeValues;
         return this;
      }

      @JsonProperty("levelOneType")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder levelOneType(final Long levelOneType) {
         this.levelOneType = levelOneType;
         return this;
      }

      @JsonProperty("levelTwoType")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder levelTwoType(final Long levelTwoType) {
         this.levelTwoType = levelTwoType;
         return this;
      }

      @JsonProperty("numberList")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      @JsonProperty("reportList")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder reportList(final List<InspectionReportSavedDTO> reportList) {
         this.reportList = reportList;
         return this;
      }

      @JsonProperty("boolNeedReply")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder boolNeedReply(final Boolean boolNeedReply) {
         this.boolNeedReply = boolNeedReply;
         return this;
      }

      @JsonProperty("submitRemark")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder submitRemark(final String submitRemark) {
         this.submitRemark = submitRemark;
         return this;
      }

      @JsonProperty("boolConcessionAcceptance")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder boolConcessionAcceptance(final Boolean boolConcessionAcceptance) {
         this.boolConcessionAcceptance = boolConcessionAcceptance;
         return this;
      }

      @JsonProperty("numberQualifiedList")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder numberQualifiedList(
         final List<ArtifactNumberQualifiedQuantityDTOParam> numberQualifiedList
      ) {
         this.numberQualifiedList = numberQualifiedList;
         return this;
      }

      @JsonProperty("qualifiedQuantity")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder qualifiedQuantity(final Integer qualifiedQuantity) {
         this.qualifiedQuantity = qualifiedQuantity;
         return this;
      }

      @JsonProperty("unQualifiedQuantity")
      public MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder unQualifiedQuantity(final Integer unQualifiedQuantity) {
         this.unQualifiedQuantity = unQualifiedQuantity;
         return this;
      }

      public MesBuildingCheckQhseDTOParam build() {
         return new MesBuildingCheckQhseDTOParam(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.taskId,
            this.processId,
            this.taskProcessId,
            this.productId,
            this.productType,
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
            this.userLink,
            this.drawingIds,
            this.qualityTypeValues,
            this.levelOneType,
            this.levelTwoType,
            this.numberList,
            this.reportList,
            this.boolNeedReply,
            this.submitRemark,
            this.boolConcessionAcceptance,
            this.numberQualifiedList,
            this.qualifiedQuantity,
            this.unQualifiedQuantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingCheckQhseDTOParam.MesBuildingCheckQhseDTOParamBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
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
            + ", productType="
            + this.productType
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
            + ", userLink="
            + this.userLink
            + ", drawingIds="
            + this.drawingIds
            + ", qualityTypeValues="
            + this.qualityTypeValues
            + ", levelOneType="
            + this.levelOneType
            + ", levelTwoType="
            + this.levelTwoType
            + ", numberList="
            + this.numberList
            + ", reportList="
            + this.reportList
            + ", boolNeedReply="
            + this.boolNeedReply
            + ", submitRemark="
            + this.submitRemark
            + ", boolConcessionAcceptance="
            + this.boolConcessionAcceptance
            + ", numberQualifiedList="
            + this.numberQualifiedList
            + ", qualifiedQuantity="
            + this.qualifiedQuantity
            + ", unQualifiedQuantity="
            + this.unQualifiedQuantity
            + ")";
      }
   }
}
