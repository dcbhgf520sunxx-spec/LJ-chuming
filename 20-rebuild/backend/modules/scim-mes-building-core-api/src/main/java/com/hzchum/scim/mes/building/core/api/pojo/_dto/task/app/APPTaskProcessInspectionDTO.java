package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "APPTaskProcessInspectionDTO", description = "任务质检详情 ")
public class APPTaskProcessInspectionDTO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "taskId", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "workshop", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "project", notes = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "monomer", notes = "单体")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "area", notes = "区域")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "areaBatch", notes = "批次")
   @JsonProperty("areaBatch")
   @JSONField(name = "areaBatch")
   private NameInfo areaBatch;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
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
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "nextProcess", notes = "下一道工序")
   @JsonProperty("nextProcess")
   @JSONField(name = "nextProcess")
   private IdAndNameDO nextProcess;
   @ApiModelProperty(name = "reportType", notes = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "inspectType", notes = "质检上报类型")
   @JsonProperty("inspectType")
   @JSONField(name = "inspectType")
   private Integer inspectType;
   @ApiModelProperty(name = "team", notes = "班组id,和班组长名称")
   @JsonProperty("team")
   @JSONField(name = "team")
   private IdAndNameDO team;
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
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "taskType", notes = "任务类型（正常任务 1 ,协同任务 2 ）")
   @JsonProperty("taskType")
   @JSONField(name = "taskType")
   private Integer taskType;
   @ApiModelProperty(name = "boolOneCode", notes = "是否一物一码（是 1 ,否 0 ）")
   @JsonProperty("boolOneCode")
   @JSONField(name = "boolOneCode")
   private Boolean boolOneCode;
   @ApiModelProperty(name = "number", notes = "码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;

   public static APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder builder() {
      return new APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder();
   }

   public APPTaskProcessInspectionDTO() {
   }

   public APPTaskProcessInspectionDTO(
      final Long id,
      final Long taskId,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final NameInfo areaBatch,
      final GroupsCurrencyDO groups,
      final Long productId,
      final Integer taskQuantity,
      final Integer quantity,
      final Integer needQuantity,
      final Integer completeQuantity,
      final Integer inspectionQuantity,
      final Integer problemQuantity,
      final Long processId,
      final Long nextProcessId,
      final Integer status,
      final Boolean technologyStatus,
      final LocalDateTime askCompleteTime,
      final String serialNumber,
      final String specification,
      final String productName,
      final IdAndNameDO process,
      final IdAndNameDO nextProcess,
      final Integer reportType,
      final Integer inspectType,
      final IdAndNameDO team,
      final Integer teamCanInspectionQuantity,
      final Integer teamQuantity,
      final Integer teamInspectionQuantity,
      final String material,
      final Long teamProductionLineId,
      final BigDecimal netWeight,
      final Integer taskTypeEnum,
      final Integer taskType,
      final Boolean boolOneCode,
      final Integer number
   ) {
      this.id = id;
      this.taskId = taskId;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.areaBatch = areaBatch;
      this.groups = groups;
      this.productId = productId;
      this.taskQuantity = taskQuantity;
      this.quantity = quantity;
      this.needQuantity = needQuantity;
      this.completeQuantity = completeQuantity;
      this.inspectionQuantity = inspectionQuantity;
      this.problemQuantity = problemQuantity;
      this.processId = processId;
      this.nextProcessId = nextProcessId;
      this.status = status;
      this.technologyStatus = technologyStatus;
      this.askCompleteTime = askCompleteTime;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.productName = productName;
      this.process = process;
      this.nextProcess = nextProcess;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.team = team;
      this.teamCanInspectionQuantity = teamCanInspectionQuantity;
      this.teamQuantity = teamQuantity;
      this.teamInspectionQuantity = teamInspectionQuantity;
      this.material = material;
      this.teamProductionLineId = teamProductionLineId;
      this.netWeight = netWeight;
      this.taskTypeEnum = taskTypeEnum;
      this.taskType = taskType;
      this.boolOneCode = boolOneCode;
      this.number = number;
   }

   public Long getId() {
      return this.id;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public NameInfo getAreaBatch() {
      return this.areaBatch;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   public Long getProductId() {
      return this.productId;
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

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getTechnologyStatus() {
      return this.technologyStatus;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
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

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public IdAndNameDO getNextProcess() {
      return this.nextProcess;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public Integer getInspectType() {
      return this.inspectType;
   }

   public IdAndNameDO getTeam() {
      return this.team;
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

   public String getMaterial() {
      return this.material;
   }

   public Long getTeamProductionLineId() {
      return this.teamProductionLineId;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public Boolean getBoolOneCode() {
      return this.boolOneCode;
   }

   public Integer getNumber() {
      return this.number;
   }

   @JsonProperty("id")
   public APPTaskProcessInspectionDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public APPTaskProcessInspectionDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("workshop")
   public APPTaskProcessInspectionDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public APPTaskProcessInspectionDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("project")
   public APPTaskProcessInspectionDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public APPTaskProcessInspectionDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public APPTaskProcessInspectionDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("areaBatch")
   public APPTaskProcessInspectionDTO setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
      return this;
   }

   @JsonProperty("groups")
   public APPTaskProcessInspectionDTO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("productId")
   public APPTaskProcessInspectionDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskQuantity")
   public APPTaskProcessInspectionDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public APPTaskProcessInspectionDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("needQuantity")
   public APPTaskProcessInspectionDTO setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public APPTaskProcessInspectionDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public APPTaskProcessInspectionDTO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("problemQuantity")
   public APPTaskProcessInspectionDTO setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("processId")
   public APPTaskProcessInspectionDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("nextProcessId")
   public APPTaskProcessInspectionDTO setNextProcessId(final Long nextProcessId) {
      this.nextProcessId = nextProcessId;
      return this;
   }

   @JsonProperty("status")
   public APPTaskProcessInspectionDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("technologyStatus")
   public APPTaskProcessInspectionDTO setTechnologyStatus(final Boolean technologyStatus) {
      this.technologyStatus = technologyStatus;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public APPTaskProcessInspectionDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("serialNumber")
   public APPTaskProcessInspectionDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public APPTaskProcessInspectionDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("productName")
   public APPTaskProcessInspectionDTO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("process")
   public APPTaskProcessInspectionDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("nextProcess")
   public APPTaskProcessInspectionDTO setNextProcess(final IdAndNameDO nextProcess) {
      this.nextProcess = nextProcess;
      return this;
   }

   @JsonProperty("reportType")
   public APPTaskProcessInspectionDTO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public APPTaskProcessInspectionDTO setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("team")
   public APPTaskProcessInspectionDTO setTeam(final IdAndNameDO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("teamCanInspectionQuantity")
   public APPTaskProcessInspectionDTO setTeamCanInspectionQuantity(final Integer teamCanInspectionQuantity) {
      this.teamCanInspectionQuantity = teamCanInspectionQuantity;
      return this;
   }

   @JsonProperty("teamQuantity")
   public APPTaskProcessInspectionDTO setTeamQuantity(final Integer teamQuantity) {
      this.teamQuantity = teamQuantity;
      return this;
   }

   @JsonProperty("teamInspectionQuantity")
   public APPTaskProcessInspectionDTO setTeamInspectionQuantity(final Integer teamInspectionQuantity) {
      this.teamInspectionQuantity = teamInspectionQuantity;
      return this;
   }

   @JsonProperty("material")
   public APPTaskProcessInspectionDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("teamProductionLineId")
   public APPTaskProcessInspectionDTO setTeamProductionLineId(final Long teamProductionLineId) {
      this.teamProductionLineId = teamProductionLineId;
      return this;
   }

   @JsonProperty("netWeight")
   public APPTaskProcessInspectionDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public APPTaskProcessInspectionDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("taskType")
   public APPTaskProcessInspectionDTO setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   @JsonProperty("boolOneCode")
   public APPTaskProcessInspectionDTO setBoolOneCode(final Boolean boolOneCode) {
      this.boolOneCode = boolOneCode;
      return this;
   }

   @JsonProperty("number")
   public APPTaskProcessInspectionDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "APPTaskProcessInspectionDTO(id="
         + this.getId()
         + ", taskId="
         + this.getTaskId()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", groups="
         + this.getGroups()
         + ", productId="
         + this.getProductId()
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
         + ", status="
         + this.getStatus()
         + ", technologyStatus="
         + this.getTechnologyStatus()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", productName="
         + this.getProductName()
         + ", process="
         + this.getProcess()
         + ", nextProcess="
         + this.getNextProcess()
         + ", reportType="
         + this.getReportType()
         + ", inspectType="
         + this.getInspectType()
         + ", team="
         + this.getTeam()
         + ", teamCanInspectionQuantity="
         + this.getTeamCanInspectionQuantity()
         + ", teamQuantity="
         + this.getTeamQuantity()
         + ", teamInspectionQuantity="
         + this.getTeamInspectionQuantity()
         + ", material="
         + this.getMaterial()
         + ", teamProductionLineId="
         + this.getTeamProductionLineId()
         + ", netWeight="
         + this.getNetWeight()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", taskType="
         + this.getTaskType()
         + ", boolOneCode="
         + this.getBoolOneCode()
         + ", number="
         + this.getNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPTaskProcessInspectionDTO)) {
         return false;
      }

      APPTaskProcessInspectionDTO other = (APPTaskProcessInspectionDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
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
                        if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                           Object this$inspectionQuantity = this.getInspectionQuantity();
                           Object other$inspectionQuantity = other.getInspectionQuantity();
                           if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
                              Object this$problemQuantity = this.getProblemQuantity();
                              Object other$problemQuantity = other.getProblemQuantity();
                              if (this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity)) {
                                 Object this$processId = this.getProcessId();
                                 Object other$processId = other.getProcessId();
                                 if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                                    Object this$nextProcessId = this.getNextProcessId();
                                    Object other$nextProcessId = other.getNextProcessId();
                                    if (this$nextProcessId == null ? other$nextProcessId == null : this$nextProcessId.equals(other$nextProcessId)) {
                                       Object this$status = this.getStatus();
                                       Object other$status = other.getStatus();
                                       if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                          Object this$technologyStatus = this.getTechnologyStatus();
                                          Object other$technologyStatus = other.getTechnologyStatus();
                                          if (this$technologyStatus == null
                                             ? other$technologyStatus == null
                                             : this$technologyStatus.equals(other$technologyStatus)) {
                                             Object this$reportType = this.getReportType();
                                             Object other$reportType = other.getReportType();
                                             if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                                                Object this$inspectType = this.getInspectType();
                                                Object other$inspectType = other.getInspectType();
                                                if (this$inspectType == null ? other$inspectType == null : this$inspectType.equals(other$inspectType)) {
                                                   Object this$teamCanInspectionQuantity = this.getTeamCanInspectionQuantity();
                                                   Object other$teamCanInspectionQuantity = other.getTeamCanInspectionQuantity();
                                                   if (this$teamCanInspectionQuantity == null
                                                      ? other$teamCanInspectionQuantity == null
                                                      : this$teamCanInspectionQuantity.equals(other$teamCanInspectionQuantity)) {
                                                      Object this$teamQuantity = this.getTeamQuantity();
                                                      Object other$teamQuantity = other.getTeamQuantity();
                                                      if (this$teamQuantity == null ? other$teamQuantity == null : this$teamQuantity.equals(other$teamQuantity)
                                                         )
                                                       {
                                                         Object this$teamInspectionQuantity = this.getTeamInspectionQuantity();
                                                         Object other$teamInspectionQuantity = other.getTeamInspectionQuantity();
                                                         if (this$teamInspectionQuantity == null
                                                            ? other$teamInspectionQuantity == null
                                                            : this$teamInspectionQuantity.equals(other$teamInspectionQuantity)) {
                                                            Object this$teamProductionLineId = this.getTeamProductionLineId();
                                                            Object other$teamProductionLineId = other.getTeamProductionLineId();
                                                            if (this$teamProductionLineId == null
                                                               ? other$teamProductionLineId == null
                                                               : this$teamProductionLineId.equals(other$teamProductionLineId)) {
                                                               Object this$taskTypeEnum = this.getTaskTypeEnum();
                                                               Object other$taskTypeEnum = other.getTaskTypeEnum();
                                                               if (this$taskTypeEnum == null
                                                                  ? other$taskTypeEnum == null
                                                                  : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                                                                  Object this$taskType = this.getTaskType();
                                                                  Object other$taskType = other.getTaskType();
                                                                  if (this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType)) {
                                                                     Object this$boolOneCode = this.getBoolOneCode();
                                                                     Object other$boolOneCode = other.getBoolOneCode();
                                                                     if (this$boolOneCode == null
                                                                        ? other$boolOneCode == null
                                                                        : this$boolOneCode.equals(other$boolOneCode)) {
                                                                        Object this$number = this.getNumber();
                                                                        Object other$number = other.getNumber();
                                                                        if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                                                           Object this$workshop = this.getWorkshop();
                                                                           Object other$workshop = other.getWorkshop();
                                                                           if (this$workshop == null
                                                                              ? other$workshop == null
                                                                              : this$workshop.equals(other$workshop)) {
                                                                              Object this$productionLine = this.getProductionLine();
                                                                              Object other$productionLine = other.getProductionLine();
                                                                              if (this$productionLine == null
                                                                                 ? other$productionLine == null
                                                                                 : this$productionLine.equals(other$productionLine)) {
                                                                                 Object this$project = this.getProject();
                                                                                 Object other$project = other.getProject();
                                                                                 if (this$project == null
                                                                                    ? other$project == null
                                                                                    : this$project.equals(other$project)) {
                                                                                    Object this$monomer = this.getMonomer();
                                                                                    Object other$monomer = other.getMonomer();
                                                                                    if (this$monomer == null
                                                                                       ? other$monomer == null
                                                                                       : this$monomer.equals(other$monomer)) {
                                                                                       Object this$area = this.getArea();
                                                                                       Object other$area = other.getArea();
                                                                                       if (this$area == null
                                                                                          ? other$area == null
                                                                                          : this$area.equals(other$area)) {
                                                                                          Object this$areaBatch = this.getAreaBatch();
                                                                                          Object other$areaBatch = other.getAreaBatch();
                                                                                          if (this$areaBatch == null
                                                                                             ? other$areaBatch == null
                                                                                             : this$areaBatch.equals(other$areaBatch)) {
                                                                                             Object this$groups = this.getGroups();
                                                                                             Object other$groups = other.getGroups();
                                                                                             if (this$groups == null
                                                                                                ? other$groups == null
                                                                                                : this$groups.equals(other$groups)) {
                                                                                                Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                                Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                                if (this$askCompleteTime == null
                                                                                                   ? other$askCompleteTime == null
                                                                                                   : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                                                   Object this$serialNumber = this.getSerialNumber();
                                                                                                   Object other$serialNumber = other.getSerialNumber();
                                                                                                   if (this$serialNumber == null
                                                                                                      ? other$serialNumber == null
                                                                                                      : this$serialNumber.equals(other$serialNumber)) {
                                                                                                      Object this$specification = this.getSpecification();
                                                                                                      Object other$specification = other.getSpecification();
                                                                                                      if (this$specification == null
                                                                                                         ? other$specification == null
                                                                                                         : this$specification.equals(other$specification)) {
                                                                                                         Object this$productName = this.getProductName();
                                                                                                         Object other$productName = other.getProductName();
                                                                                                         if (this$productName == null
                                                                                                            ? other$productName == null
                                                                                                            : this$productName.equals(other$productName)) {
                                                                                                            Object this$process = this.getProcess();
                                                                                                            Object other$process = other.getProcess();
                                                                                                            if (this$process == null
                                                                                                               ? other$process == null
                                                                                                               : this$process.equals(other$process)) {
                                                                                                               Object this$nextProcess = this.getNextProcess();
                                                                                                               Object other$nextProcess = other.getNextProcess();
                                                                                                               if (this$nextProcess == null
                                                                                                                  ? other$nextProcess == null
                                                                                                                  : this$nextProcess.equals(other$nextProcess)) {
                                                                                                                  Object this$team = this.getTeam();
                                                                                                                  Object other$team = other.getTeam();
                                                                                                                  if (this$team == null
                                                                                                                     ? other$team == null
                                                                                                                     : this$team.equals(other$team)) {
                                                                                                                     Object this$material = this.getMaterial();
                                                                                                                     Object other$material = other.getMaterial();
                                                                                                                     if (this$material == null
                                                                                                                        ? other$material == null
                                                                                                                        : this$material.equals(other$material)) {
                                                                                                                        Object this$netWeight = this.getNetWeight();
                                                                                                                        Object other$netWeight = other.getNetWeight();
                                                                                                                        return this$netWeight == null
                                                                                                                           ? other$netWeight == null
                                                                                                                           : this$netWeight.equals(
                                                                                                                              other$netWeight
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof APPTaskProcessInspectionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
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
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $technologyStatus = this.getTechnologyStatus();
      result = result * 59 + ($technologyStatus == null ? 43 : $technologyStatus.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $inspectType = this.getInspectType();
      result = result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
      Object $teamCanInspectionQuantity = this.getTeamCanInspectionQuantity();
      result = result * 59 + ($teamCanInspectionQuantity == null ? 43 : $teamCanInspectionQuantity.hashCode());
      Object $teamQuantity = this.getTeamQuantity();
      result = result * 59 + ($teamQuantity == null ? 43 : $teamQuantity.hashCode());
      Object $teamInspectionQuantity = this.getTeamInspectionQuantity();
      result = result * 59 + ($teamInspectionQuantity == null ? 43 : $teamInspectionQuantity.hashCode());
      Object $teamProductionLineId = this.getTeamProductionLineId();
      result = result * 59 + ($teamProductionLineId == null ? 43 : $teamProductionLineId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $boolOneCode = this.getBoolOneCode();
      result = result * 59 + ($boolOneCode == null ? 43 : $boolOneCode.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $nextProcess = this.getNextProcess();
      result = result * 59 + ($nextProcess == null ? 43 : $nextProcess.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class APPTaskProcessInspectionDTOBuilder {
      private Long id;
      private Long taskId;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private NameInfo areaBatch;
      private GroupsCurrencyDO groups;
      private Long productId;
      private Integer taskQuantity;
      private Integer quantity;
      private Integer needQuantity;
      private Integer completeQuantity;
      private Integer inspectionQuantity;
      private Integer problemQuantity;
      private Long processId;
      private Long nextProcessId;
      private Integer status;
      private Boolean technologyStatus;
      private LocalDateTime askCompleteTime;
      private String serialNumber;
      private String specification;
      private String productName;
      private IdAndNameDO process;
      private IdAndNameDO nextProcess;
      private Integer reportType;
      private Integer inspectType;
      private IdAndNameDO team;
      private Integer teamCanInspectionQuantity;
      private Integer teamQuantity;
      private Integer teamInspectionQuantity;
      private String material;
      private Long teamProductionLineId;
      private BigDecimal netWeight;
      private Integer taskTypeEnum;
      private Integer taskType;
      private Boolean boolOneCode;
      private Integer number;

      APPTaskProcessInspectionDTOBuilder() {
      }

      @JsonProperty("id")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("workshop")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("project")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("areaBatch")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder areaBatch(final NameInfo areaBatch) {
         this.areaBatch = areaBatch;
         return this;
      }

      @JsonProperty("groups")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("productId")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskQuantity")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("quantity")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("needQuantity")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("problemQuantity")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("processId")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("nextProcessId")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder nextProcessId(final Long nextProcessId) {
         this.nextProcessId = nextProcessId;
         return this;
      }

      @JsonProperty("status")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("technologyStatus")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder technologyStatus(final Boolean technologyStatus) {
         this.technologyStatus = technologyStatus;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("serialNumber")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("productName")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("process")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("nextProcess")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder nextProcess(final IdAndNameDO nextProcess) {
         this.nextProcess = nextProcess;
         return this;
      }

      @JsonProperty("reportType")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("team")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder team(final IdAndNameDO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("teamCanInspectionQuantity")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder teamCanInspectionQuantity(final Integer teamCanInspectionQuantity) {
         this.teamCanInspectionQuantity = teamCanInspectionQuantity;
         return this;
      }

      @JsonProperty("teamQuantity")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder teamQuantity(final Integer teamQuantity) {
         this.teamQuantity = teamQuantity;
         return this;
      }

      @JsonProperty("teamInspectionQuantity")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder teamInspectionQuantity(final Integer teamInspectionQuantity) {
         this.teamInspectionQuantity = teamInspectionQuantity;
         return this;
      }

      @JsonProperty("material")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("teamProductionLineId")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder teamProductionLineId(final Long teamProductionLineId) {
         this.teamProductionLineId = teamProductionLineId;
         return this;
      }

      @JsonProperty("netWeight")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("taskType")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      @JsonProperty("boolOneCode")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder boolOneCode(final Boolean boolOneCode) {
         this.boolOneCode = boolOneCode;
         return this;
      }

      @JsonProperty("number")
      public APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public APPTaskProcessInspectionDTO build() {
         return new APPTaskProcessInspectionDTO(
            this.id,
            this.taskId,
            this.workshop,
            this.productionLine,
            this.project,
            this.monomer,
            this.area,
            this.areaBatch,
            this.groups,
            this.productId,
            this.taskQuantity,
            this.quantity,
            this.needQuantity,
            this.completeQuantity,
            this.inspectionQuantity,
            this.problemQuantity,
            this.processId,
            this.nextProcessId,
            this.status,
            this.technologyStatus,
            this.askCompleteTime,
            this.serialNumber,
            this.specification,
            this.productName,
            this.process,
            this.nextProcess,
            this.reportType,
            this.inspectType,
            this.team,
            this.teamCanInspectionQuantity,
            this.teamQuantity,
            this.teamInspectionQuantity,
            this.material,
            this.teamProductionLineId,
            this.netWeight,
            this.taskTypeEnum,
            this.taskType,
            this.boolOneCode,
            this.number
         );
      }

      @Override
      public String toString() {
         return "APPTaskProcessInspectionDTO.APPTaskProcessInspectionDTOBuilder(id="
            + this.id
            + ", taskId="
            + this.taskId
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", areaBatch="
            + this.areaBatch
            + ", groups="
            + this.groups
            + ", productId="
            + this.productId
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
            + ", status="
            + this.status
            + ", technologyStatus="
            + this.technologyStatus
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", productName="
            + this.productName
            + ", process="
            + this.process
            + ", nextProcess="
            + this.nextProcess
            + ", reportType="
            + this.reportType
            + ", inspectType="
            + this.inspectType
            + ", team="
            + this.team
            + ", teamCanInspectionQuantity="
            + this.teamCanInspectionQuantity
            + ", teamQuantity="
            + this.teamQuantity
            + ", teamInspectionQuantity="
            + this.teamInspectionQuantity
            + ", material="
            + this.material
            + ", teamProductionLineId="
            + this.teamProductionLineId
            + ", netWeight="
            + this.netWeight
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", taskType="
            + this.taskType
            + ", boolOneCode="
            + this.boolOneCode
            + ", number="
            + this.number
            + ")";
      }
   }
}
