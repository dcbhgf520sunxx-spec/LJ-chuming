package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "APPTaskProcessInspectionDO", description = "任务质检详情 ")
public class APPTaskProcessInspectionDO {
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

   public static APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder builder() {
      return new APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder();
   }

   public APPTaskProcessInspectionDO() {
   }

   public APPTaskProcessInspectionDO(
      final Long id,
      final Long taskId,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
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
      final Integer taskTypeEnum
   ) {
      this.id = id;
      this.taskId = taskId;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
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

   @JsonProperty("id")
   public APPTaskProcessInspectionDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("taskId")
   public APPTaskProcessInspectionDO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("workshop")
   public APPTaskProcessInspectionDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public APPTaskProcessInspectionDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("project")
   public APPTaskProcessInspectionDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public APPTaskProcessInspectionDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public APPTaskProcessInspectionDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("groups")
   public APPTaskProcessInspectionDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("productId")
   public APPTaskProcessInspectionDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskQuantity")
   public APPTaskProcessInspectionDO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public APPTaskProcessInspectionDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("needQuantity")
   public APPTaskProcessInspectionDO setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public APPTaskProcessInspectionDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("inspectionQuantity")
   public APPTaskProcessInspectionDO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @JsonProperty("problemQuantity")
   public APPTaskProcessInspectionDO setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @JsonProperty("processId")
   public APPTaskProcessInspectionDO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("nextProcessId")
   public APPTaskProcessInspectionDO setNextProcessId(final Long nextProcessId) {
      this.nextProcessId = nextProcessId;
      return this;
   }

   @JsonProperty("status")
   public APPTaskProcessInspectionDO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("technologyStatus")
   public APPTaskProcessInspectionDO setTechnologyStatus(final Boolean technologyStatus) {
      this.technologyStatus = technologyStatus;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public APPTaskProcessInspectionDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("serialNumber")
   public APPTaskProcessInspectionDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public APPTaskProcessInspectionDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("productName")
   public APPTaskProcessInspectionDO setProductName(final String productName) {
      this.productName = productName;
      return this;
   }

   @JsonProperty("process")
   public APPTaskProcessInspectionDO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("nextProcess")
   public APPTaskProcessInspectionDO setNextProcess(final IdAndNameDO nextProcess) {
      this.nextProcess = nextProcess;
      return this;
   }

   @JsonProperty("reportType")
   public APPTaskProcessInspectionDO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public APPTaskProcessInspectionDO setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("team")
   public APPTaskProcessInspectionDO setTeam(final IdAndNameDO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("teamCanInspectionQuantity")
   public APPTaskProcessInspectionDO setTeamCanInspectionQuantity(final Integer teamCanInspectionQuantity) {
      this.teamCanInspectionQuantity = teamCanInspectionQuantity;
      return this;
   }

   @JsonProperty("teamQuantity")
   public APPTaskProcessInspectionDO setTeamQuantity(final Integer teamQuantity) {
      this.teamQuantity = teamQuantity;
      return this;
   }

   @JsonProperty("teamInspectionQuantity")
   public APPTaskProcessInspectionDO setTeamInspectionQuantity(final Integer teamInspectionQuantity) {
      this.teamInspectionQuantity = teamInspectionQuantity;
      return this;
   }

   @JsonProperty("material")
   public APPTaskProcessInspectionDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("teamProductionLineId")
   public APPTaskProcessInspectionDO setTeamProductionLineId(final Long teamProductionLineId) {
      this.teamProductionLineId = teamProductionLineId;
      return this;
   }

   @JsonProperty("netWeight")
   public APPTaskProcessInspectionDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public APPTaskProcessInspectionDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "APPTaskProcessInspectionDO(id="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof APPTaskProcessInspectionDO)) {
         return false;
      }

      APPTaskProcessInspectionDO other = (APPTaskProcessInspectionDO)o;
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
                                                                  Object this$workshop = this.getWorkshop();
                                                                  Object other$workshop = other.getWorkshop();
                                                                  if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                                     Object this$productionLine = this.getProductionLine();
                                                                     Object other$productionLine = other.getProductionLine();
                                                                     if (this$productionLine == null
                                                                        ? other$productionLine == null
                                                                        : this$productionLine.equals(other$productionLine)) {
                                                                        Object this$project = this.getProject();
                                                                        Object other$project = other.getProject();
                                                                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                           Object this$monomer = this.getMonomer();
                                                                           Object other$monomer = other.getMonomer();
                                                                           if (this$monomer == null
                                                                              ? other$monomer == null
                                                                              : this$monomer.equals(other$monomer)) {
                                                                              Object this$area = this.getArea();
                                                                              Object other$area = other.getArea();
                                                                              if (this$area == null ? other$area == null : this$area.equals(other$area)) {
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
                                                                                                               : this$netWeight.equals(other$netWeight);
                                                                                                         } else {
                                                                                                            return false;
                                                                                                         }
                                                                                                      } else {
                                                                                                         return false;
                                                                                                      }
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof APPTaskProcessInspectionDO;
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

   public static class APPTaskProcessInspectionDOBuilder {
      private Long id;
      private Long taskId;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
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

      APPTaskProcessInspectionDOBuilder() {
      }

      @JsonProperty("id")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("taskId")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("workshop")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("project")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("groups")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("productId")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskQuantity")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("quantity")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("needQuantity")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("inspectionQuantity")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      @JsonProperty("problemQuantity")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      @JsonProperty("processId")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("nextProcessId")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder nextProcessId(final Long nextProcessId) {
         this.nextProcessId = nextProcessId;
         return this;
      }

      @JsonProperty("status")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("technologyStatus")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder technologyStatus(final Boolean technologyStatus) {
         this.technologyStatus = technologyStatus;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("serialNumber")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("productName")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder productName(final String productName) {
         this.productName = productName;
         return this;
      }

      @JsonProperty("process")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("nextProcess")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder nextProcess(final IdAndNameDO nextProcess) {
         this.nextProcess = nextProcess;
         return this;
      }

      @JsonProperty("reportType")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("team")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder team(final IdAndNameDO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("teamCanInspectionQuantity")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder teamCanInspectionQuantity(final Integer teamCanInspectionQuantity) {
         this.teamCanInspectionQuantity = teamCanInspectionQuantity;
         return this;
      }

      @JsonProperty("teamQuantity")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder teamQuantity(final Integer teamQuantity) {
         this.teamQuantity = teamQuantity;
         return this;
      }

      @JsonProperty("teamInspectionQuantity")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder teamInspectionQuantity(final Integer teamInspectionQuantity) {
         this.teamInspectionQuantity = teamInspectionQuantity;
         return this;
      }

      @JsonProperty("material")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("teamProductionLineId")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder teamProductionLineId(final Long teamProductionLineId) {
         this.teamProductionLineId = teamProductionLineId;
         return this;
      }

      @JsonProperty("netWeight")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public APPTaskProcessInspectionDO build() {
         return new APPTaskProcessInspectionDO(
            this.id,
            this.taskId,
            this.workshop,
            this.productionLine,
            this.project,
            this.monomer,
            this.area,
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
            this.taskTypeEnum
         );
      }

      @Override
      public String toString() {
         return "APPTaskProcessInspectionDO.APPTaskProcessInspectionDOBuilder(id="
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
            + ")";
      }
   }
}
