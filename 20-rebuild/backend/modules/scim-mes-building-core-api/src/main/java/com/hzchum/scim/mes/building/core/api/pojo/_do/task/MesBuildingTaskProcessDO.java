package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessArtifactNumberDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingTaskProcessDO对象", description = "任务分配工序详情表 ")
public class MesBuildingTaskProcessDO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "factoryId", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "schedulingId", notes = "排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   private Long schedulingId;
   @ApiModelProperty(name = "taskId", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "workshopId", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "needQuantity", notes = "此道工序需要完成的数量")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   private Integer needQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "此道工序已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "inspectionQuantity", notes = "通过质检数量")
   @JsonProperty("inspectionQuantity")
   @JSONField(name = "inspectionQuantity")
   private Integer inspectionQuantity;
   @ApiModelProperty(name = "problemQuantity", notes = "问题上报数量")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   private Integer problemQuantity;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "nextProcessId", notes = "下一道工序id")
   @JsonProperty("nextProcessId")
   @JSONField(name = "nextProcessId")
   private Long nextProcessId;
   @ApiModelProperty(name = "sequence", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "status", notes = "任务状态[0 正常,1暂停(可异常上报),2,暂停(正在处理中,无法上报)]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "technologyStatus", notes = "状态 [0 暂停, 1 正常]")
   @JsonProperty("technologyStatus")
   @JSONField(name = "technologyStatus")
   private Boolean technologyStatus;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "completeTime", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
   @ApiModelProperty(name = "userId", notes = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "productProcessId", notes = "总工序id")
   @JsonProperty("productProcessId")
   @JSONField(name = "productProcessId")
   private Long productProcessId;
   @ApiModelProperty(name = "serialNumber", notes = "产品编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "产品编号")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "productName", notes = "产品名称")
   @JsonProperty("productName")
   @JSONField(name = "productName")
   private String productName;
   @ApiModelProperty(name = "projectName", notes = "项目名")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "monomerName", notes = "单体名")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaName", notes = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "factoryName", notes = "工厂名")
   @JsonProperty("factoryName")
   @JSONField(name = "factoryName")
   private String factoryName;
   @ApiModelProperty(name = "workshopName", notes = "车间名")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "productionLineName", notes = "生产线名")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "shortName", notes = "项目简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "contractNo", notes = "项目编号")
   @JsonProperty("contractNo")
   @JSONField(name = "contractNo")
   private String contractNo;
   @ApiModelProperty(name = "processName", notes = "工序名")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "nextProcessName", notes = "下一道工序名")
   @JsonProperty("nextProcessName")
   @JSONField(name = "nextProcessName")
   private String nextProcessName;
   @ApiModelProperty(name = "reportType", notes = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "inspectType", notes = "质检上报类型")
   @JsonProperty("inspectType")
   @JSONField(name = "inspectType")
   private Integer inspectType;
   @ApiModelProperty(name = "teamId", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "teamLeaderName", notes = "班组组长")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;
   @ApiModelProperty(name = "teamLeaderId", notes = "班组组长id")
   @JsonProperty("teamLeaderId")
   @JSONField(name = "teamLeaderId")
   private Long teamLeaderId;
   @ApiModelProperty(name = "teamCanInspectionQuantity", notes = "此班组可以质检的数量")
   @JsonProperty("teamCanInspectionQuantity")
   @JSONField(name = "teamCanInspectionQuantity")
   private Integer teamCanInspectionQuantity;
   @ApiModelProperty(name = "teamQuantity", notes = "此班组已生产的数量")
   @JsonProperty("teamQuantity")
   @JSONField(name = "teamQuantity")
   private Integer teamQuantity;
   @ApiModelProperty(name = "teamInspectionQuantity", notes = "此班组已质检的数量")
   @JsonProperty("teamInspectionQuantity")
   @JSONField(name = "teamInspectionQuantity")
   private Integer teamInspectionQuantity;
   @ApiModelProperty(name = "length", notes = "围护长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "width", notes = "围护宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", notes = "围护厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "plate", notes = "围护版型")
   @JsonProperty("plate")
   @JSONField(name = "plate")
   private String plate;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "teamProductionLineId", notes = "实际生产线")
   @JsonProperty("teamProductionLineId")
   @JSONField(name = "teamProductionLineId")
   private Long teamProductionLineId;
   @ApiModelProperty(name = "netWeight", notes = "重量")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "oldArtifactId", notes = "原构件id")
   @JsonProperty("oldArtifactId")
   @JSONField(name = "oldArtifactId")
   @JsonInclude(Include.NON_NULL)
   private Long oldArtifactId;
   @ApiModelProperty(name = "oldArtifactSerialNumber", notes = "原构件编号")
   @JsonProperty("oldArtifactSerialNumber")
   @JSONField(name = "oldArtifactSerialNumber")
   @JsonInclude(Include.NON_NULL)
   private String oldArtifactSerialNumber;
   @ApiModelProperty(name = "firstProcess", notes = "是否是第一道工序")
   @JsonProperty("firstProcess")
   @JSONField(name = "firstProcess")
   private Boolean boolFirstProcess;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   private String specPrefix;
   @ApiModelProperty(name = "serialNumberPrefix", value = "编号前缀")
   @JsonProperty("serialNumberPrefix")
   @JSONField(name = "serialNumberPrefix")
   private String serialNumberPrefix;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "codingType", notes = "打码方式")
   @JsonProperty("codingType")
   @JSONField(name = "codingType")
   private Integer codingType;
   @ApiModelProperty(name = "artifactNumberList", notes = "构件一物一码信息")
   @JsonProperty("artifactNumberList")
   @JSONField(name = "artifactNumberList")
   private List<AppTaskProcessArtifactNumberDTO> artifactNumberList;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "orderNumber", notes = "工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "boolTimeRange", notes = "是否在时间范围内")
   @JsonProperty("boolTimeRange")
   @JSONField(name = "boolTimeRange")
   private Boolean boolTimeRange;

   public static MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder builder() {
      return new MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder();
   }

   public MesBuildingTaskProcessDO() {
   }

   public MesBuildingTaskProcessDO(
      final Long id,
      final Long factoryId,
      final Long schedulingId,
      final Long taskId,
      final Long workshopId,
      final Long productionLineId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long productId,
      final Integer productType,
      final Integer taskQuantity,
      final Integer quantity,
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
      final Long productProcessId,
      final String serialNumber,
      final String specification,
      final String productName,
      final String projectName,
      final String monomerName,
      final String areaName,
      final String factoryName,
      final String workshopName,
      final String productionLineName,
      final String shortName,
      final String contractNo,
      final String processName,
      final String nextProcessName,
      final Integer reportType,
      final Integer inspectType,
      final Long teamId,
      final String teamLeaderName,
      final Long teamLeaderId,
      final Integer teamCanInspectionQuantity,
      final Integer teamQuantity,
      final Integer teamInspectionQuantity,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String plate,
      final String material,
      final Long teamProductionLineId,
      final BigDecimal netWeight,
      final Long oldArtifactId,
      final String oldArtifactSerialNumber,
      final Boolean boolFirstProcess,
      final String specPrefix,
      final String serialNumberPrefix,
      final Integer taskTypeEnum,
      final Integer codingType,
      final List<AppTaskProcessArtifactNumberDTO> artifactNumberList,
      final GroupsCurrencyDO groups,
      final String orderNumber,
      final Boolean boolTimeRange
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.schedulingId = schedulingId;
      this.taskId = taskId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productId = productId;
      this.productType = productType;
      this.taskQuantity = taskQuantity;
      this.quantity = quantity;
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
      this.productProcessId = productProcessId;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.productName = productName;
      this.projectName = projectName;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.factoryName = factoryName;
      this.workshopName = workshopName;
      this.productionLineName = productionLineName;
      this.shortName = shortName;
      this.contractNo = contractNo;
      this.processName = processName;
      this.nextProcessName = nextProcessName;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.teamId = teamId;
      this.teamLeaderName = teamLeaderName;
      this.teamLeaderId = teamLeaderId;
      this.teamCanInspectionQuantity = teamCanInspectionQuantity;
      this.teamQuantity = teamQuantity;
      this.teamInspectionQuantity = teamInspectionQuantity;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.plate = plate;
      this.material = material;
      this.teamProductionLineId = teamProductionLineId;
      this.netWeight = netWeight;
      this.oldArtifactId = oldArtifactId;
      this.oldArtifactSerialNumber = oldArtifactSerialNumber;
      this.boolFirstProcess = boolFirstProcess;
      this.specPrefix = specPrefix;
      this.serialNumberPrefix = serialNumberPrefix;
      this.taskTypeEnum = taskTypeEnum;
      this.codingType = codingType;
      this.artifactNumberList = artifactNumberList;
      this.groups = groups;
      this.orderNumber = orderNumber;
      this.boolTimeRange = boolTimeRange;
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

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getQuantity() {
      return this.quantity;
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

   public Long getProductProcessId() {
      return this.productProcessId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
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

   public String getShortName() {
      return this.shortName;
   }

   public String getContractNo() {
      return this.contractNo;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getNextProcessName() {
      return this.nextProcessName;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public Integer getInspectType() {
      return this.inspectType;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public Long getTeamLeaderId() {
      return this.teamLeaderId;
   }

   public Integer getTeamCanInspectionQuantity() {
      return this.teamCanInspectionQuantity;
   }

   public Integer getTeamQuantity() {
      return this.teamQuantity;
   }

   public Integer getTeamInspectionQuantity() {
      return this.teamInspectionQuantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getMaterial() {
      return this.material;
   }

   public Long getTeamProductionLineId() {
      return this.teamProductionLineId;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Long getOldArtifactId() {
      return this.oldArtifactId;
   }

   public String getOldArtifactSerialNumber() {
      return this.oldArtifactSerialNumber;
   }

   public Boolean getBoolFirstProcess() {
      return this.boolFirstProcess;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public List<AppTaskProcessArtifactNumberDTO> getArtifactNumberList() {
      return this.artifactNumberList;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Boolean getBoolTimeRange() {
      return this.boolTimeRange;
   }

   @JsonProperty("id")
   public MesBuildingTaskProcessDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingTaskProcessDO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("schedulingId")
   public MesBuildingTaskProcessDO setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingTaskProcessDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingTaskProcessDO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingTaskProcessDO setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingTaskProcessDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingTaskProcessDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingTaskProcessDO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingTaskProcessDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingTaskProcessDO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingTaskProcessDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskProcessDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("needQuantity")
   public MesBuildingTaskProcessDO setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingTaskProcessDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public MesBuildingTaskProcessDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("problemQuantity")
   public MesBuildingTaskProcessDO setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTaskProcessDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("nextProcessId")
   public MesBuildingTaskProcessDO setNextProcessId(final Long nextProcessId) {
      this.nextProcessId = nextProcessId;
      return this;
   }

   @JsonProperty("sequence")
   public MesBuildingTaskProcessDO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingTaskProcessDO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("technologyStatus")
   public MesBuildingTaskProcessDO setTechnologyStatus(final Boolean technologyStatus) {
      this.technologyStatus = technologyStatus;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingTaskProcessDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingTaskProcessDO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingTaskProcessDO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("productProcessId")
   public MesBuildingTaskProcessDO setProductProcessId(final Long productProcessId) {
      this.productProcessId = productProcessId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingTaskProcessDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingTaskProcessDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("productName")
   public MesBuildingTaskProcessDO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("projectName")
   public MesBuildingTaskProcessDO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("monomerName")
   public MesBuildingTaskProcessDO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaName")
   public MesBuildingTaskProcessDO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("factoryName")
   public MesBuildingTaskProcessDO setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
      return this;
   }

   @JsonProperty("workshopName")
   public MesBuildingTaskProcessDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   @JsonProperty("productionLineName")
   public MesBuildingTaskProcessDO setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
      return this;
   }

   @JsonProperty("shortName")
   public MesBuildingTaskProcessDO setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("contractNo")
   public MesBuildingTaskProcessDO setContractNo(final String contractNo) {
      this.contractNo = contractNo;
      return this;
   }

   @JsonProperty("processName")
   public MesBuildingTaskProcessDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @JsonProperty("nextProcessName")
   public MesBuildingTaskProcessDO setNextProcessName(final String nextProcessName) {
      this.nextProcessName = nextProcessName;
      return this;
   }

   @JsonProperty("reportType")
   public MesBuildingTaskProcessDO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public MesBuildingTaskProcessDO setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingTaskProcessDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("teamLeaderName")
   public MesBuildingTaskProcessDO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @JsonProperty("teamLeaderId")
   public MesBuildingTaskProcessDO setTeamLeaderId(final Long teamLeaderId) {
      this.teamLeaderId = teamLeaderId;
      return this;
   }

   @JsonProperty("teamCanInspectionQuantity")
   public MesBuildingTaskProcessDO setTeamCanInspectionQuantity(final Integer teamCanInspectionQuantity) {
      this.teamCanInspectionQuantity = teamCanInspectionQuantity;
      return this;
   }

   @JsonProperty("teamQuantity")
   public MesBuildingTaskProcessDO setTeamQuantity(final Integer teamQuantity) {
      this.teamQuantity = teamQuantity;
      return this;
   }

   @JsonProperty("teamInspectionQuantity")
   public MesBuildingTaskProcessDO setTeamInspectionQuantity(final Integer teamInspectionQuantity) {
      this.teamInspectionQuantity = teamInspectionQuantity;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingTaskProcessDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public MesBuildingTaskProcessDO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("thickness")
   public MesBuildingTaskProcessDO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("plate")
   public MesBuildingTaskProcessDO setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingTaskProcessDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("teamProductionLineId")
   public MesBuildingTaskProcessDO setTeamProductionLineId(final Long teamProductionLineId) {
      this.teamProductionLineId = teamProductionLineId;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingTaskProcessDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("oldArtifactId")
   public MesBuildingTaskProcessDO setOldArtifactId(final Long oldArtifactId) {
      this.oldArtifactId = oldArtifactId;
      return this;
   }

   @JsonProperty("oldArtifactSerialNumber")
   public MesBuildingTaskProcessDO setOldArtifactSerialNumber(final String oldArtifactSerialNumber) {
      this.oldArtifactSerialNumber = oldArtifactSerialNumber;
      return this;
   }

   @JsonProperty("firstProcess")
   public MesBuildingTaskProcessDO setBoolFirstProcess(final Boolean boolFirstProcess) {
      this.boolFirstProcess = boolFirstProcess;
      return this;
   }

   @JsonProperty("specPrefix")
   public MesBuildingTaskProcessDO setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   @JsonProperty("serialNumberPrefix")
   public MesBuildingTaskProcessDO setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingTaskProcessDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("codingType")
   public MesBuildingTaskProcessDO setCodingType(final Integer codingType) {
      this.codingType = codingType;
      return this;
   }

   @JsonProperty("artifactNumberList")
   public MesBuildingTaskProcessDO setArtifactNumberList(final List<AppTaskProcessArtifactNumberDTO> artifactNumberList) {
      this.artifactNumberList = artifactNumberList;
      return this;
   }

   @JsonProperty("groups")
   public MesBuildingTaskProcessDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingTaskProcessDO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("boolTimeRange")
   public MesBuildingTaskProcessDO setBoolTimeRange(final Boolean boolTimeRange) {
      this.boolTimeRange = boolTimeRange;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskProcessDO(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
         + ", schedulingId="
         + this.getSchedulingId()
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
         + ", areaId="
         + this.getAreaId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", quantity="
         + this.getQuantity()
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
         + ", productProcessId="
         + this.getProductProcessId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", productName="
         + this.getProductName()
         + ", projectName="
         + this.getProjectName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", factoryName="
         + this.getFactoryName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", shortName="
         + this.getShortName()
         + ", contractNo="
         + this.getContractNo()
         + ", processName="
         + this.getProcessName()
         + ", nextProcessName="
         + this.getNextProcessName()
         + ", reportType="
         + this.getReportType()
         + ", inspectType="
         + this.getInspectType()
         + ", teamId="
         + this.getTeamId()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", teamLeaderId="
         + this.getTeamLeaderId()
         + ", teamCanInspectionQuantity="
         + this.getTeamCanInspectionQuantity()
         + ", teamQuantity="
         + this.getTeamQuantity()
         + ", teamInspectionQuantity="
         + this.getTeamInspectionQuantity()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", plate="
         + this.getPlate()
         + ", material="
         + this.getMaterial()
         + ", teamProductionLineId="
         + this.getTeamProductionLineId()
         + ", netWeight="
         + this.getNetWeight()
         + ", oldArtifactId="
         + this.getOldArtifactId()
         + ", oldArtifactSerialNumber="
         + this.getOldArtifactSerialNumber()
         + ", boolFirstProcess="
         + this.getBoolFirstProcess()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", codingType="
         + this.getCodingType()
         + ", artifactNumberList="
         + this.getArtifactNumberList()
         + ", groups="
         + this.getGroups()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", boolTimeRange="
         + this.getBoolTimeRange()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskProcessDO)) {
         return false;
      }

      MesBuildingTaskProcessDO other = (MesBuildingTaskProcessDO)o;
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
                              Object this$areaId = this.getAreaId();
                              Object other$areaId = other.getAreaId();
                              if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                 Object this$productId = this.getProductId();
                                 Object other$productId = other.getProductId();
                                 if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                    Object this$productType = this.getProductType();
                                    Object other$productType = other.getProductType();
                                    if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                       Object this$taskQuantity = this.getTaskQuantity();
                                       Object other$taskQuantity = other.getTaskQuantity();
                                       if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
                                                                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                                                           Object this$productProcessId = this.getProductProcessId();
                                                                           Object other$productProcessId = other.getProductProcessId();
                                                                           if (this$productProcessId == null
                                                                              ? other$productProcessId == null
                                                                              : this$productProcessId.equals(other$productProcessId)) {
                                                                              Object this$reportType = this.getReportType();
                                                                              Object other$reportType = other.getReportType();
                                                                              if (this$reportType == null
                                                                                 ? other$reportType == null
                                                                                 : this$reportType.equals(other$reportType)) {
                                                                                 Object this$inspectType = this.getInspectType();
                                                                                 Object other$inspectType = other.getInspectType();
                                                                                 if (this$inspectType == null
                                                                                    ? other$inspectType == null
                                                                                    : this$inspectType.equals(other$inspectType)) {
                                                                                    Object this$teamId = this.getTeamId();
                                                                                    Object other$teamId = other.getTeamId();
                                                                                    if (this$teamId == null
                                                                                       ? other$teamId == null
                                                                                       : this$teamId.equals(other$teamId)) {
                                                                                       Object this$teamLeaderId = this.getTeamLeaderId();
                                                                                       Object other$teamLeaderId = other.getTeamLeaderId();
                                                                                       if (this$teamLeaderId == null
                                                                                          ? other$teamLeaderId == null
                                                                                          : this$teamLeaderId.equals(other$teamLeaderId)) {
                                                                                          Object this$teamCanInspectionQuantity = this.getTeamCanInspectionQuantity();
                                                                                          Object other$teamCanInspectionQuantity = other.getTeamCanInspectionQuantity();
                                                                                          if (this$teamCanInspectionQuantity == null
                                                                                             ? other$teamCanInspectionQuantity == null
                                                                                             : this$teamCanInspectionQuantity.equals(
                                                                                                other$teamCanInspectionQuantity
                                                                                             )) {
                                                                                             Object this$teamQuantity = this.getTeamQuantity();
                                                                                             Object other$teamQuantity = other.getTeamQuantity();
                                                                                             if (this$teamQuantity == null
                                                                                                ? other$teamQuantity == null
                                                                                                : this$teamQuantity.equals(other$teamQuantity)) {
                                                                                                Object this$teamInspectionQuantity = this.getTeamInspectionQuantity();
                                                                                                Object other$teamInspectionQuantity = other.getTeamInspectionQuantity();
                                                                                                if (this$teamInspectionQuantity == null
                                                                                                   ? other$teamInspectionQuantity == null
                                                                                                   : this$teamInspectionQuantity.equals(
                                                                                                      other$teamInspectionQuantity
                                                                                                   )) {
                                                                                                   Object this$teamProductionLineId = this.getTeamProductionLineId();
                                                                                                   Object other$teamProductionLineId = other.getTeamProductionLineId();
                                                                                                   if (this$teamProductionLineId == null
                                                                                                      ? other$teamProductionLineId == null
                                                                                                      : this$teamProductionLineId.equals(
                                                                                                         other$teamProductionLineId
                                                                                                      )) {
                                                                                                      Object this$oldArtifactId = this.getOldArtifactId();
                                                                                                      Object other$oldArtifactId = other.getOldArtifactId();
                                                                                                      if (this$oldArtifactId == null
                                                                                                         ? other$oldArtifactId == null
                                                                                                         : this$oldArtifactId.equals(other$oldArtifactId)) {
                                                                                                         Object this$boolFirstProcess = this.getBoolFirstProcess();
                                                                                                         Object other$boolFirstProcess = other.getBoolFirstProcess();
                                                                                                         if (this$boolFirstProcess == null
                                                                                                            ? other$boolFirstProcess == null
                                                                                                            : this$boolFirstProcess.equals(
                                                                                                               other$boolFirstProcess
                                                                                                            )) {
                                                                                                            Object this$taskTypeEnum = this.getTaskTypeEnum();
                                                                                                            Object other$taskTypeEnum = other.getTaskTypeEnum();
                                                                                                            if (this$taskTypeEnum == null
                                                                                                               ? other$taskTypeEnum == null
                                                                                                               : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                                                                                                               Object this$codingType = this.getCodingType();
                                                                                                               Object other$codingType = other.getCodingType();
                                                                                                               if (this$codingType == null
                                                                                                                  ? other$codingType == null
                                                                                                                  : this$codingType.equals(other$codingType)) {
                                                                                                                  Object this$boolTimeRange = this.getBoolTimeRange();
                                                                                                                  Object other$boolTimeRange = other.getBoolTimeRange();
                                                                                                                  if (this$boolTimeRange == null
                                                                                                                     ? other$boolTimeRange == null
                                                                                                                     : this$boolTimeRange.equals(
                                                                                                                        other$boolTimeRange
                                                                                                                     )) {
                                                                                                                     Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                                                     Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                                                     if (this$askCompleteTime == null
                                                                                                                        ? other$askCompleteTime == null
                                                                                                                        : this$askCompleteTime.equals(
                                                                                                                           other$askCompleteTime
                                                                                                                        )) {
                                                                                                                        Object this$completeTime = this.getCompleteTime();
                                                                                                                        Object other$completeTime = other.getCompleteTime();
                                                                                                                        if (this$completeTime == null
                                                                                                                           ? other$completeTime == null
                                                                                                                           : this$completeTime.equals(
                                                                                                                              other$completeTime
                                                                                                                           )) {
                                                                                                                           Object this$serialNumber = this.getSerialNumber();
                                                                                                                           Object other$serialNumber = other.getSerialNumber();
                                                                                                                           if (this$serialNumber == null
                                                                                                                              ? other$serialNumber == null
                                                                                                                              : this$serialNumber.equals(
                                                                                                                                 other$serialNumber
                                                                                                                              )) {
                                                                                                                              Object this$specification = this.getSpecification();
                                                                                                                              Object other$specification = other.getSpecification();
                                                                                                                              if (this$specification == null
                                                                                                                                 ? other$specification == null
                                                                                                                                 : this$specification.equals(
                                                                                                                                    other$specification
                                                                                                                                 )) {
                                                                                                                                 Object this$productName = this.getProductName();
                                                                                                                                 Object other$productName = other.getProductName();
                                                                                                                                 if (this$productName == null
                                                                                                                                    ? other$productName == null
                                                                                                                                    : this$productName.equals(
                                                                                                                                       other$productName
                                                                                                                                    )) {
                                                                                                                                    Object this$projectName = this.getProjectName();
                                                                                                                                    Object other$projectName = other.getProjectName();
                                                                                                                                    if (this$projectName
                                                                                                                                          == null
                                                                                                                                       ? other$projectName
                                                                                                                                          == null
                                                                                                                                       : this$projectName.equals(
                                                                                                                                          other$projectName
                                                                                                                                       )) {
                                                                                                                                       Object this$monomerName = this.getMonomerName();
                                                                                                                                       Object other$monomerName = other.getMonomerName();
                                                                                                                                       if (this$monomerName
                                                                                                                                             == null
                                                                                                                                          ? other$monomerName
                                                                                                                                             == null
                                                                                                                                          : this$monomerName.equals(
                                                                                                                                             other$monomerName
                                                                                                                                          )) {
                                                                                                                                          Object this$areaName = this.getAreaName();
                                                                                                                                          Object other$areaName = other.getAreaName();
                                                                                                                                          if (this$areaName
                                                                                                                                                == null
                                                                                                                                             ? other$areaName
                                                                                                                                                == null
                                                                                                                                             : this$areaName.equals(
                                                                                                                                                other$areaName
                                                                                                                                             )) {
                                                                                                                                             Object this$factoryName = this.getFactoryName();
                                                                                                                                             Object other$factoryName = other.getFactoryName();
                                                                                                                                             if (this$factoryName
                                                                                                                                                   == null
                                                                                                                                                ? other$factoryName
                                                                                                                                                   == null
                                                                                                                                                : this$factoryName.equals(
                                                                                                                                                   other$factoryName
                                                                                                                                                )) {
                                                                                                                                                Object this$workshopName = this.getWorkshopName();
                                                                                                                                                Object other$workshopName = other.getWorkshopName();
                                                                                                                                                if (this$workshopName
                                                                                                                                                      == null
                                                                                                                                                   ? other$workshopName
                                                                                                                                                      == null
                                                                                                                                                   : this$workshopName.equals(
                                                                                                                                                      other$workshopName
                                                                                                                                                   )) {
                                                                                                                                                   Object this$productionLineName = this.getProductionLineName();
                                                                                                                                                   Object other$productionLineName = other.getProductionLineName();
                                                                                                                                                   if (this$productionLineName
                                                                                                                                                         == null
                                                                                                                                                      ? other$productionLineName
                                                                                                                                                         == null
                                                                                                                                                      : this$productionLineName.equals(
                                                                                                                                                         other$productionLineName
                                                                                                                                                      )) {
                                                                                                                                                      Object this$shortName = this.getShortName();
                                                                                                                                                      Object other$shortName = other.getShortName();
                                                                                                                                                      if (this$shortName
                                                                                                                                                            == null
                                                                                                                                                         ? other$shortName
                                                                                                                                                            == null
                                                                                                                                                         : this$shortName.equals(
                                                                                                                                                            other$shortName
                                                                                                                                                         )) {
                                                                                                                                                         Object this$contractNo = this.getContractNo();
                                                                                                                                                         Object other$contractNo = other.getContractNo();
                                                                                                                                                         if (this$contractNo
                                                                                                                                                               == null
                                                                                                                                                            ? other$contractNo
                                                                                                                                                               == null
                                                                                                                                                            : this$contractNo.equals(
                                                                                                                                                               other$contractNo
                                                                                                                                                            )) {
                                                                                                                                                            Object this$processName = this.getProcessName();
                                                                                                                                                            Object other$processName = other.getProcessName();
                                                                                                                                                            if (this$processName
                                                                                                                                                                  == null
                                                                                                                                                               ? other$processName
                                                                                                                                                                  == null
                                                                                                                                                               : this$processName.equals(
                                                                                                                                                                  other$processName
                                                                                                                                                               )
                                                                                                                                                               )
                                                                                                                                                             {
                                                                                                                                                               Object this$nextProcessName = this.getNextProcessName();
                                                                                                                                                               Object other$nextProcessName = other.getNextProcessName();
                                                                                                                                                               if (this$nextProcessName
                                                                                                                                                                     == null
                                                                                                                                                                  ? other$nextProcessName
                                                                                                                                                                     == null
                                                                                                                                                                  : this$nextProcessName.equals(
                                                                                                                                                                     other$nextProcessName
                                                                                                                                                                  )
                                                                                                                                                                  )
                                                                                                                                                                {
                                                                                                                                                                  Object this$teamLeaderName = this.getTeamLeaderName();
                                                                                                                                                                  Object other$teamLeaderName = other.getTeamLeaderName();
                                                                                                                                                                  if (this$teamLeaderName
                                                                                                                                                                        == null
                                                                                                                                                                     ? other$teamLeaderName
                                                                                                                                                                        == null
                                                                                                                                                                     : this$teamLeaderName.equals(
                                                                                                                                                                        other$teamLeaderName
                                                                                                                                                                     )
                                                                                                                                                                     )
                                                                                                                                                                   {
                                                                                                                                                                     Object this$length = this.getLength();
                                                                                                                                                                     Object other$length = other.getLength();
                                                                                                                                                                     if (this$length
                                                                                                                                                                           == null
                                                                                                                                                                        ? other$length
                                                                                                                                                                           == null
                                                                                                                                                                        : this$length.equals(
                                                                                                                                                                           other$length
                                                                                                                                                                        )
                                                                                                                                                                        )
                                                                                                                                                                      {
                                                                                                                                                                        Object this$width = this.getWidth();
                                                                                                                                                                        Object other$width = other.getWidth();
                                                                                                                                                                        if (this$width
                                                                                                                                                                              == null
                                                                                                                                                                           ? other$width
                                                                                                                                                                              == null
                                                                                                                                                                           : this$width.equals(
                                                                                                                                                                              other$width
                                                                                                                                                                           )
                                                                                                                                                                           )
                                                                                                                                                                         {
                                                                                                                                                                           Object this$thickness = this.getThickness();
                                                                                                                                                                           Object other$thickness = other.getThickness();
                                                                                                                                                                           if (this$thickness
                                                                                                                                                                                 == null
                                                                                                                                                                              ? other$thickness
                                                                                                                                                                                 == null
                                                                                                                                                                              : this$thickness.equals(
                                                                                                                                                                                 other$thickness
                                                                                                                                                                              )
                                                                                                                                                                              )
                                                                                                                                                                            {
                                                                                                                                                                              Object this$plate = this.getPlate();
                                                                                                                                                                              Object other$plate = other.getPlate();
                                                                                                                                                                              if (this$plate
                                                                                                                                                                                    == null
                                                                                                                                                                                 ? other$plate
                                                                                                                                                                                    == null
                                                                                                                                                                                 : this$plate.equals(
                                                                                                                                                                                    other$plate
                                                                                                                                                                                 )
                                                                                                                                                                                 )
                                                                                                                                                                               {
                                                                                                                                                                                 Object this$material = this.getMaterial();
                                                                                                                                                                                 Object other$material = other.getMaterial();
                                                                                                                                                                                 if (this$material
                                                                                                                                                                                       == null
                                                                                                                                                                                    ? other$material
                                                                                                                                                                                       == null
                                                                                                                                                                                    : this$material.equals(
                                                                                                                                                                                       other$material
                                                                                                                                                                                    )
                                                                                                                                                                                    )
                                                                                                                                                                                  {
                                                                                                                                                                                    Object this$netWeight = this.getNetWeight();
                                                                                                                                                                                    Object other$netWeight = other.getNetWeight();
                                                                                                                                                                                    if (this$netWeight
                                                                                                                                                                                          == null
                                                                                                                                                                                       ? other$netWeight
                                                                                                                                                                                          == null
                                                                                                                                                                                       : this$netWeight.equals(
                                                                                                                                                                                          other$netWeight
                                                                                                                                                                                       )
                                                                                                                                                                                       )
                                                                                                                                                                                     {
                                                                                                                                                                                       Object this$oldArtifactSerialNumber = this.getOldArtifactSerialNumber();
                                                                                                                                                                                       Object other$oldArtifactSerialNumber = other.getOldArtifactSerialNumber();
                                                                                                                                                                                       if (this$oldArtifactSerialNumber
                                                                                                                                                                                             == null
                                                                                                                                                                                          ? other$oldArtifactSerialNumber
                                                                                                                                                                                             == null
                                                                                                                                                                                          : this$oldArtifactSerialNumber.equals(
                                                                                                                                                                                             other$oldArtifactSerialNumber
                                                                                                                                                                                          )
                                                                                                                                                                                          )
                                                                                                                                                                                        {
                                                                                                                                                                                          Object this$specPrefix = this.getSpecPrefix();
                                                                                                                                                                                          Object other$specPrefix = other.getSpecPrefix();
                                                                                                                                                                                          if (this$specPrefix
                                                                                                                                                                                                == null
                                                                                                                                                                                             ? other$specPrefix
                                                                                                                                                                                                == null
                                                                                                                                                                                             : this$specPrefix.equals(
                                                                                                                                                                                                other$specPrefix
                                                                                                                                                                                             )
                                                                                                                                                                                             )
                                                                                                                                                                                           {
                                                                                                                                                                                             Object this$serialNumberPrefix = this.getSerialNumberPrefix();
                                                                                                                                                                                             Object other$serialNumberPrefix = other.getSerialNumberPrefix();
                                                                                                                                                                                             if (this$serialNumberPrefix
                                                                                                                                                                                                   == null
                                                                                                                                                                                                ? other$serialNumberPrefix
                                                                                                                                                                                                   == null
                                                                                                                                                                                                : this$serialNumberPrefix.equals(
                                                                                                                                                                                                   other$serialNumberPrefix
                                                                                                                                                                                                )
                                                                                                                                                                                                )
                                                                                                                                                                                              {
                                                                                                                                                                                                Object this$artifactNumberList = this.getArtifactNumberList();
                                                                                                                                                                                                Object other$artifactNumberList = other.getArtifactNumberList();
                                                                                                                                                                                                if (this$artifactNumberList
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   ? other$artifactNumberList
                                                                                                                                                                                                      == null
                                                                                                                                                                                                   : this$artifactNumberList.equals(
                                                                                                                                                                                                      other$artifactNumberList
                                                                                                                                                                                                   )
                                                                                                                                                                                                   )
                                                                                                                                                                                                 {
                                                                                                                                                                                                   Object this$groups = this.getGroups();
                                                                                                                                                                                                   Object other$groups = other.getGroups();
                                                                                                                                                                                                   if (this$groups
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      ? other$groups
                                                                                                                                                                                                         == null
                                                                                                                                                                                                      : this$groups.equals(
                                                                                                                                                                                                         other$groups
                                                                                                                                                                                                      )
                                                                                                                                                                                                      )
                                                                                                                                                                                                    {
                                                                                                                                                                                                      Object this$orderNumber = this.getOrderNumber();
                                                                                                                                                                                                      Object other$orderNumber = other.getOrderNumber();
                                                                                                                                                                                                      return this$orderNumber
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         ? other$orderNumber
                                                                                                                                                                                                            == null
                                                                                                                                                                                                         : this$orderNumber.equals(
                                                                                                                                                                                                            other$orderNumber
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
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingTaskProcessDO;
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
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
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
      Object $productProcessId = this.getProductProcessId();
      result = result * 59 + ($productProcessId == null ? 43 : $productProcessId.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $inspectType = this.getInspectType();
      result = result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $teamLeaderId = this.getTeamLeaderId();
      result = result * 59 + ($teamLeaderId == null ? 43 : $teamLeaderId.hashCode());
      Object $teamCanInspectionQuantity = this.getTeamCanInspectionQuantity();
      result = result * 59 + ($teamCanInspectionQuantity == null ? 43 : $teamCanInspectionQuantity.hashCode());
      Object $teamQuantity = this.getTeamQuantity();
      result = result * 59 + ($teamQuantity == null ? 43 : $teamQuantity.hashCode());
      Object $teamInspectionQuantity = this.getTeamInspectionQuantity();
      result = result * 59 + ($teamInspectionQuantity == null ? 43 : $teamInspectionQuantity.hashCode());
      Object $teamProductionLineId = this.getTeamProductionLineId();
      result = result * 59 + ($teamProductionLineId == null ? 43 : $teamProductionLineId.hashCode());
      Object $oldArtifactId = this.getOldArtifactId();
      result = result * 59 + ($oldArtifactId == null ? 43 : $oldArtifactId.hashCode());
      Object $boolFirstProcess = this.getBoolFirstProcess();
      result = result * 59 + ($boolFirstProcess == null ? 43 : $boolFirstProcess.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $boolTimeRange = this.getBoolTimeRange();
      result = result * 59 + ($boolTimeRange == null ? 43 : $boolTimeRange.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $contractNo = this.getContractNo();
      result = result * 59 + ($contractNo == null ? 43 : $contractNo.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $nextProcessName = this.getNextProcessName();
      result = result * 59 + ($nextProcessName == null ? 43 : $nextProcessName.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $oldArtifactSerialNumber = this.getOldArtifactSerialNumber();
      result = result * 59 + ($oldArtifactSerialNumber == null ? 43 : $oldArtifactSerialNumber.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      result = result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
      Object $artifactNumberList = this.getArtifactNumberList();
      result = result * 59 + ($artifactNumberList == null ? 43 : $artifactNumberList.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $orderNumber = this.getOrderNumber();
      return result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
   }

   public static class MesBuildingTaskProcessDOBuilder {
      private Long id;
      private Long factoryId;
      private Long schedulingId;
      private Long taskId;
      private Long workshopId;
      private Long productionLineId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long productId;
      private Integer productType;
      private Integer taskQuantity;
      private Integer quantity;
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
      private Long productProcessId;
      private String serialNumber;
      private String specification;
      private String productName;
      private String projectName;
      private String monomerName;
      private String areaName;
      private String factoryName;
      private String workshopName;
      private String productionLineName;
      private String shortName;
      private String contractNo;
      private String processName;
      private String nextProcessName;
      private Integer reportType;
      private Integer inspectType;
      private Long teamId;
      private String teamLeaderName;
      private Long teamLeaderId;
      private Integer teamCanInspectionQuantity;
      private Integer teamQuantity;
      private Integer teamInspectionQuantity;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String plate;
      private String material;
      private Long teamProductionLineId;
      private BigDecimal netWeight;
      private Long oldArtifactId;
      private String oldArtifactSerialNumber;
      private Boolean boolFirstProcess;
      private String specPrefix;
      private String serialNumberPrefix;
      private Integer taskTypeEnum;
      private Integer codingType;
      private List<AppTaskProcessArtifactNumberDTO> artifactNumberList;
      private GroupsCurrencyDO groups;
      private String orderNumber;
      private Boolean boolTimeRange;

      MesBuildingTaskProcessDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("schedulingId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("needQuantity")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("problemQuantity")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("nextProcessId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder nextProcessId(final Long nextProcessId) {
         this.nextProcessId = nextProcessId;
         return this;
      }

      @JsonProperty("sequence")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("technologyStatus")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder technologyStatus(final Boolean technologyStatus) {
         this.technologyStatus = technologyStatus;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("productProcessId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder productProcessId(final Long productProcessId) {
         this.productProcessId = productProcessId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("productName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("projectName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("monomerName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("factoryName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      @JsonProperty("workshopName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("productionLineName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("shortName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("contractNo")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder contractNo(final String contractNo) {
         this.contractNo = contractNo;
         return this;
      }

      @JsonProperty("processName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("nextProcessName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder nextProcessName(final String nextProcessName) {
         this.nextProcessName = nextProcessName;
         return this;
      }

      @JsonProperty("reportType")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("teamLeaderName")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      @JsonProperty("teamLeaderId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder teamLeaderId(final Long teamLeaderId) {
         this.teamLeaderId = teamLeaderId;
         return this;
      }

      @JsonProperty("teamCanInspectionQuantity")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder teamCanInspectionQuantity(final Integer teamCanInspectionQuantity) {
         this.teamCanInspectionQuantity = teamCanInspectionQuantity;
         return this;
      }

      @JsonProperty("teamQuantity")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder teamQuantity(final Integer teamQuantity) {
         this.teamQuantity = teamQuantity;
         return this;
      }

      @JsonProperty("teamInspectionQuantity")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder teamInspectionQuantity(final Integer teamInspectionQuantity) {
         this.teamInspectionQuantity = teamInspectionQuantity;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("thickness")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("plate")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("teamProductionLineId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder teamProductionLineId(final Long teamProductionLineId) {
         this.teamProductionLineId = teamProductionLineId;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("oldArtifactId")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder oldArtifactId(final Long oldArtifactId) {
         this.oldArtifactId = oldArtifactId;
         return this;
      }

      @JsonProperty("oldArtifactSerialNumber")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder oldArtifactSerialNumber(final String oldArtifactSerialNumber) {
         this.oldArtifactSerialNumber = oldArtifactSerialNumber;
         return this;
      }

      @JsonProperty("firstProcess")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder boolFirstProcess(final Boolean boolFirstProcess) {
         this.boolFirstProcess = boolFirstProcess;
         return this;
      }

      @JsonProperty("specPrefix")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      @JsonProperty("serialNumberPrefix")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("codingType")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      @JsonProperty("artifactNumberList")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder artifactNumberList(final List<AppTaskProcessArtifactNumberDTO> artifactNumberList) {
         this.artifactNumberList = artifactNumberList;
         return this;
      }

      @JsonProperty("groups")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("boolTimeRange")
      public MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder boolTimeRange(final Boolean boolTimeRange) {
         this.boolTimeRange = boolTimeRange;
         return this;
      }

      public MesBuildingTaskProcessDO build() {
         return new MesBuildingTaskProcessDO(
            this.id,
            this.factoryId,
            this.schedulingId,
            this.taskId,
            this.workshopId,
            this.productionLineId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.productId,
            this.productType,
            this.taskQuantity,
            this.quantity,
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
            this.productProcessId,
            this.serialNumber,
            this.specification,
            this.productName,
            this.projectName,
            this.monomerName,
            this.areaName,
            this.factoryName,
            this.workshopName,
            this.productionLineName,
            this.shortName,
            this.contractNo,
            this.processName,
            this.nextProcessName,
            this.reportType,
            this.inspectType,
            this.teamId,
            this.teamLeaderName,
            this.teamLeaderId,
            this.teamCanInspectionQuantity,
            this.teamQuantity,
            this.teamInspectionQuantity,
            this.length,
            this.width,
            this.thickness,
            this.plate,
            this.material,
            this.teamProductionLineId,
            this.netWeight,
            this.oldArtifactId,
            this.oldArtifactSerialNumber,
            this.boolFirstProcess,
            this.specPrefix,
            this.serialNumberPrefix,
            this.taskTypeEnum,
            this.codingType,
            this.artifactNumberList,
            this.groups,
            this.orderNumber,
            this.boolTimeRange
         );
      }

      @Override
      public String toString() {
         return "MesBuildingTaskProcessDO.MesBuildingTaskProcessDOBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
            + ", schedulingId="
            + this.schedulingId
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
            + ", areaId="
            + this.areaId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", taskQuantity="
            + this.taskQuantity
            + ", quantity="
            + this.quantity
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
            + ", productProcessId="
            + this.productProcessId
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", productName="
            + this.productName
            + ", projectName="
            + this.projectName
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", factoryName="
            + this.factoryName
            + ", workshopName="
            + this.workshopName
            + ", productionLineName="
            + this.productionLineName
            + ", shortName="
            + this.shortName
            + ", contractNo="
            + this.contractNo
            + ", processName="
            + this.processName
            + ", nextProcessName="
            + this.nextProcessName
            + ", reportType="
            + this.reportType
            + ", inspectType="
            + this.inspectType
            + ", teamId="
            + this.teamId
            + ", teamLeaderName="
            + this.teamLeaderName
            + ", teamLeaderId="
            + this.teamLeaderId
            + ", teamCanInspectionQuantity="
            + this.teamCanInspectionQuantity
            + ", teamQuantity="
            + this.teamQuantity
            + ", teamInspectionQuantity="
            + this.teamInspectionQuantity
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", plate="
            + this.plate
            + ", material="
            + this.material
            + ", teamProductionLineId="
            + this.teamProductionLineId
            + ", netWeight="
            + this.netWeight
            + ", oldArtifactId="
            + this.oldArtifactId
            + ", oldArtifactSerialNumber="
            + this.oldArtifactSerialNumber
            + ", boolFirstProcess="
            + this.boolFirstProcess
            + ", specPrefix="
            + this.specPrefix
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", codingType="
            + this.codingType
            + ", artifactNumberList="
            + this.artifactNumberList
            + ", groups="
            + this.groups
            + ", orderNumber="
            + this.orderNumber
            + ", boolTimeRange="
            + this.boolTimeRange
            + ")";
      }
   }
}
