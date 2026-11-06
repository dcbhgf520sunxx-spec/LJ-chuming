package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "AppTaskProcessDetailsDTO", description = "用户可上报的工序详情 ")
public class AppTaskProcessDetailsDTO {
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
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
   @ApiModelProperty(name = "productId", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "quantity", notes = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "producibleQuantity", notes = "可生产数量")
   @JsonProperty("producibleQuantity")
   @JSONField(name = "producibleQuantity")
   @JsonInclude(Include.NON_NULL)
   private Integer producibleQuantity;
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "nextProcess", notes = "下一道工序")
   @JsonProperty("nextProcess")
   @JSONField(name = "nextProcess")
   private IdAndNameDO nextProcess;
   @ApiModelProperty(name = "nextProcesses", notes = "下一道工序列表")
   @JsonProperty("nextProcesses")
   @JSONField(name = "nextProcesses")
   private List<IdAndNameDO> nextProcesses;
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
   @ApiModelProperty(name = "reportType", notes = "上报类型")
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(name = "firstProcess", notes = "是否是第一道工序")
   @JsonProperty("firstProcess")
   @JSONField(name = "firstProcess")
   private Boolean boolFirstProcess;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "围护长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "artifactNumberList", notes = "构件一物一码信息")
   @JsonProperty("artifactNumberList")
   @JSONField(name = "artifactNumberList")
   @JsonInclude(Include.NON_NULL)
   private List<AppTaskProcessArtifactNumberDTO> artifactNumberList;
   @ApiModelProperty(name = "factory", value = "工厂", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private IdAndNameDO factory;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private IdAndNameDO workshop;
   @ApiModelProperty(name = "productionLine", value = "产线", notes = "产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private IdAndNameDO productionLine;
   @ApiModelProperty(name = "groups", value = "生产组", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private IdAndNameDO groups;
   @ApiModelProperty(name = "assistGroup", value = "协同生产组", notes = "生产组")
   @JsonProperty("assistGroup")
   @JSONField(name = "assistGroup")
   private IdAndNameDO assistGroup;
   @ApiModelProperty(name = "assistProductionLine", value = "协同生产线", notes = "协同生产线")
   @JsonProperty("assistProductionLine")
   @JSONField(name = "assistProductionLine")
   private IdAndNameDO assistProductionLine;
   @ApiModelProperty("扫码方式 1:一物一码  2:一码多物(批量) 枚举: CodingTypeEnum")
   @JsonProperty("codingType")
   @JSONField(name = "codingType")
   @JsonInclude(Include.NON_NULL)
   private Integer codingType;
   @ApiModelProperty(name = "team", value = "生产组长", notes = "生产组长")
   @JsonProperty("team")
   @JSONField(name = "team")
   private IdAndNameDO team;
   @ApiModelProperty(name = "lastTeam", value = "上一道工序生产组长", notes = "上一道工序生产组长")
   @JsonProperty("lastTeam")
   @JSONField(name = "lastTeam")
   private IdAndNameDO lastTeam;
   @ApiModelProperty(name = "lastReportTime", notes = "上一道工序上报时间")
   @JsonProperty("lastReportTime")
   @JSONField(name = "lastReportTime")
   private LocalDateTime lastReportTime;

   public static AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder builder() {
      return new AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder();
   }

   public AppTaskProcessDetailsDTO() {
   }

   public AppTaskProcessDetailsDTO(
      final Long taskId,
      final Long id,
      final ProjectDetailDO project,
      final MonomerDetailDO monomer,
      final AreaDetailDO area,
      final NameInfo areaBatch,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Integer producibleQuantity,
      final IdAndNameDO process,
      final IdAndNameDO nextProcess,
      final List<IdAndNameDO> nextProcesses,
      final Integer status,
      final Boolean technologyStatus,
      final LocalDateTime askCompleteTime,
      final String serialNumber,
      final Integer reportType,
      final Boolean boolFirstProcess,
      final String specification,
      final BigDecimal length,
      final String material,
      final List<AppTaskProcessArtifactNumberDTO> artifactNumberList,
      final IdAndNameDO factory,
      final IdAndNameDO workshop,
      final IdAndNameDO productionLine,
      final IdAndNameDO groups,
      final IdAndNameDO assistGroup,
      final IdAndNameDO assistProductionLine,
      final Integer codingType,
      final IdAndNameDO team,
      final IdAndNameDO lastTeam,
      final LocalDateTime lastReportTime
   ) {
      this.taskId = taskId;
      this.id = id;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.areaBatch = areaBatch;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.producibleQuantity = producibleQuantity;
      this.process = process;
      this.nextProcess = nextProcess;
      this.nextProcesses = nextProcesses;
      this.status = status;
      this.technologyStatus = technologyStatus;
      this.askCompleteTime = askCompleteTime;
      this.serialNumber = serialNumber;
      this.reportType = reportType;
      this.boolFirstProcess = boolFirstProcess;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.artifactNumberList = artifactNumberList;
      this.factory = factory;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.assistGroup = assistGroup;
      this.assistProductionLine = assistProductionLine;
      this.codingType = codingType;
      this.team = team;
      this.lastTeam = lastTeam;
      this.lastReportTime = lastReportTime;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getId() {
      return this.id;
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

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProducibleQuantity() {
      return this.producibleQuantity;
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public IdAndNameDO getNextProcess() {
      return this.nextProcess;
   }

   public List<IdAndNameDO> getNextProcesses() {
      return this.nextProcesses;
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

   public Integer getReportType() {
      return this.reportType;
   }

   public Boolean getBoolFirstProcess() {
      return this.boolFirstProcess;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public List<AppTaskProcessArtifactNumberDTO> getArtifactNumberList() {
      return this.artifactNumberList;
   }

   public IdAndNameDO getFactory() {
      return this.factory;
   }

   public IdAndNameDO getWorkshop() {
      return this.workshop;
   }

   public IdAndNameDO getProductionLine() {
      return this.productionLine;
   }

   public IdAndNameDO getGroups() {
      return this.groups;
   }

   public IdAndNameDO getAssistGroup() {
      return this.assistGroup;
   }

   public IdAndNameDO getAssistProductionLine() {
      return this.assistProductionLine;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public IdAndNameDO getTeam() {
      return this.team;
   }

   public IdAndNameDO getLastTeam() {
      return this.lastTeam;
   }

   public LocalDateTime getLastReportTime() {
      return this.lastReportTime;
   }

   @JsonProperty("taskId")
   public AppTaskProcessDetailsDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("id")
   public AppTaskProcessDetailsDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("project")
   public AppTaskProcessDetailsDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomer")
   public AppTaskProcessDetailsDTO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("area")
   public AppTaskProcessDetailsDTO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("areaBatch")
   public AppTaskProcessDetailsDTO setAreaBatch(final NameInfo areaBatch) {
      this.areaBatch = areaBatch;
      return this;
   }

   @JsonProperty("productId")
   public AppTaskProcessDetailsDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public AppTaskProcessDetailsDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("quantity")
   public AppTaskProcessDetailsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("producibleQuantity")
   public AppTaskProcessDetailsDTO setProducibleQuantity(final Integer producibleQuantity) {
      this.producibleQuantity = producibleQuantity;
      return this;
   }

   @JsonProperty("process")
   public AppTaskProcessDetailsDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("nextProcess")
   public AppTaskProcessDetailsDTO setNextProcess(final IdAndNameDO nextProcess) {
      this.nextProcess = nextProcess;
      return this;
   }

   @JsonProperty("nextProcesses")
   public AppTaskProcessDetailsDTO setNextProcesses(final List<IdAndNameDO> nextProcesses) {
      this.nextProcesses = nextProcesses;
      return this;
   }

   @JsonProperty("status")
   public AppTaskProcessDetailsDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("technologyStatus")
   public AppTaskProcessDetailsDTO setTechnologyStatus(final Boolean technologyStatus) {
      this.technologyStatus = technologyStatus;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public AppTaskProcessDetailsDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("serialNumber")
   public AppTaskProcessDetailsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("reportType")
   public AppTaskProcessDetailsDTO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("firstProcess")
   public AppTaskProcessDetailsDTO setBoolFirstProcess(final Boolean boolFirstProcess) {
      this.boolFirstProcess = boolFirstProcess;
      return this;
   }

   @JsonProperty("specification")
   public AppTaskProcessDetailsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public AppTaskProcessDetailsDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public AppTaskProcessDetailsDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("artifactNumberList")
   public AppTaskProcessDetailsDTO setArtifactNumberList(final List<AppTaskProcessArtifactNumberDTO> artifactNumberList) {
      this.artifactNumberList = artifactNumberList;
      return this;
   }

   @JsonProperty("factory")
   public AppTaskProcessDetailsDTO setFactory(final IdAndNameDO factory) {
      this.factory = factory;
      return this;
   }

   @JsonProperty("workshop")
   public AppTaskProcessDetailsDTO setWorkshop(final IdAndNameDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AppTaskProcessDetailsDTO setProductionLine(final IdAndNameDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public AppTaskProcessDetailsDTO setGroups(final IdAndNameDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("assistGroup")
   public AppTaskProcessDetailsDTO setAssistGroup(final IdAndNameDO assistGroup) {
      this.assistGroup = assistGroup;
      return this;
   }

   @JsonProperty("assistProductionLine")
   public AppTaskProcessDetailsDTO setAssistProductionLine(final IdAndNameDO assistProductionLine) {
      this.assistProductionLine = assistProductionLine;
      return this;
   }

   @JsonProperty("codingType")
   public AppTaskProcessDetailsDTO setCodingType(final Integer codingType) {
      this.codingType = codingType;
      return this;
   }

   @JsonProperty("team")
   public AppTaskProcessDetailsDTO setTeam(final IdAndNameDO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("lastTeam")
   public AppTaskProcessDetailsDTO setLastTeam(final IdAndNameDO lastTeam) {
      this.lastTeam = lastTeam;
      return this;
   }

   @JsonProperty("lastReportTime")
   public AppTaskProcessDetailsDTO setLastReportTime(final LocalDateTime lastReportTime) {
      this.lastReportTime = lastReportTime;
      return this;
   }

   @Override
   public String toString() {
      return "AppTaskProcessDetailsDTO(taskId="
         + this.getTaskId()
         + ", id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", areaBatch="
         + this.getAreaBatch()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", producibleQuantity="
         + this.getProducibleQuantity()
         + ", process="
         + this.getProcess()
         + ", nextProcess="
         + this.getNextProcess()
         + ", nextProcesses="
         + this.getNextProcesses()
         + ", status="
         + this.getStatus()
         + ", technologyStatus="
         + this.getTechnologyStatus()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", reportType="
         + this.getReportType()
         + ", boolFirstProcess="
         + this.getBoolFirstProcess()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", artifactNumberList="
         + this.getArtifactNumberList()
         + ", factory="
         + this.getFactory()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", assistGroup="
         + this.getAssistGroup()
         + ", assistProductionLine="
         + this.getAssistProductionLine()
         + ", codingType="
         + this.getCodingType()
         + ", team="
         + this.getTeam()
         + ", lastTeam="
         + this.getLastTeam()
         + ", lastReportTime="
         + this.getLastReportTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppTaskProcessDetailsDTO)) {
         return false;
      }

      AppTaskProcessDetailsDTO other = (AppTaskProcessDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$producibleQuantity = this.getProducibleQuantity();
                     Object other$producibleQuantity = other.getProducibleQuantity();
                     if (this$producibleQuantity == null ? other$producibleQuantity == null : this$producibleQuantity.equals(other$producibleQuantity)) {
                        Object this$status = this.getStatus();
                        Object other$status = other.getStatus();
                        if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                           Object this$technologyStatus = this.getTechnologyStatus();
                           Object other$technologyStatus = other.getTechnologyStatus();
                           if (this$technologyStatus == null ? other$technologyStatus == null : this$technologyStatus.equals(other$technologyStatus)) {
                              Object this$reportType = this.getReportType();
                              Object other$reportType = other.getReportType();
                              if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
                                 Object this$boolFirstProcess = this.getBoolFirstProcess();
                                 Object other$boolFirstProcess = other.getBoolFirstProcess();
                                 if (this$boolFirstProcess == null ? other$boolFirstProcess == null : this$boolFirstProcess.equals(other$boolFirstProcess)) {
                                    Object this$codingType = this.getCodingType();
                                    Object other$codingType = other.getCodingType();
                                    if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                                       Object this$project = this.getProject();
                                       Object other$project = other.getProject();
                                       if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                          Object this$monomer = this.getMonomer();
                                          Object other$monomer = other.getMonomer();
                                          if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                             Object this$area = this.getArea();
                                             Object other$area = other.getArea();
                                             if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                Object this$areaBatch = this.getAreaBatch();
                                                Object other$areaBatch = other.getAreaBatch();
                                                if (this$areaBatch == null ? other$areaBatch == null : this$areaBatch.equals(other$areaBatch)) {
                                                   Object this$process = this.getProcess();
                                                   Object other$process = other.getProcess();
                                                   if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                                                      Object this$nextProcess = this.getNextProcess();
                                                      Object other$nextProcess = other.getNextProcess();
                                                      if (this$nextProcess == null ? other$nextProcess == null : this$nextProcess.equals(other$nextProcess)) {
                                                         Object this$nextProcesses = this.getNextProcesses();
                                                         Object other$nextProcesses = other.getNextProcesses();
                                                         if (this$nextProcesses == null
                                                            ? other$nextProcesses == null
                                                            : this$nextProcesses.equals(other$nextProcesses)) {
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
                                                                     Object this$length = this.getLength();
                                                                     Object other$length = other.getLength();
                                                                     if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                        Object this$material = this.getMaterial();
                                                                        Object other$material = other.getMaterial();
                                                                        if (this$material == null
                                                                           ? other$material == null
                                                                           : this$material.equals(other$material)) {
                                                                           Object this$artifactNumberList = this.getArtifactNumberList();
                                                                           Object other$artifactNumberList = other.getArtifactNumberList();
                                                                           if (this$artifactNumberList == null
                                                                              ? other$artifactNumberList == null
                                                                              : this$artifactNumberList.equals(other$artifactNumberList)) {
                                                                              Object this$factory = this.getFactory();
                                                                              Object other$factory = other.getFactory();
                                                                              if (this$factory == null
                                                                                 ? other$factory == null
                                                                                 : this$factory.equals(other$factory)) {
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
                                                                                       Object this$groups = this.getGroups();
                                                                                       Object other$groups = other.getGroups();
                                                                                       if (this$groups == null
                                                                                          ? other$groups == null
                                                                                          : this$groups.equals(other$groups)) {
                                                                                          Object this$assistGroup = this.getAssistGroup();
                                                                                          Object other$assistGroup = other.getAssistGroup();
                                                                                          if (this$assistGroup == null
                                                                                             ? other$assistGroup == null
                                                                                             : this$assistGroup.equals(other$assistGroup)) {
                                                                                             Object this$assistProductionLine = this.getAssistProductionLine();
                                                                                             Object other$assistProductionLine = other.getAssistProductionLine();
                                                                                             if (this$assistProductionLine == null
                                                                                                ? other$assistProductionLine == null
                                                                                                : this$assistProductionLine.equals(other$assistProductionLine)) {
                                                                                                Object this$team = this.getTeam();
                                                                                                Object other$team = other.getTeam();
                                                                                                if (this$team == null
                                                                                                   ? other$team == null
                                                                                                   : this$team.equals(other$team)) {
                                                                                                   Object this$lastTeam = this.getLastTeam();
                                                                                                   Object other$lastTeam = other.getLastTeam();
                                                                                                   if (this$lastTeam == null
                                                                                                      ? other$lastTeam == null
                                                                                                      : this$lastTeam.equals(other$lastTeam)) {
                                                                                                      Object this$lastReportTime = this.getLastReportTime();
                                                                                                      Object other$lastReportTime = other.getLastReportTime();
                                                                                                      return this$lastReportTime == null
                                                                                                         ? other$lastReportTime == null
                                                                                                         : this$lastReportTime.equals(other$lastReportTime);
                                                                                                   } else {
                                                                                                      return false;
                                                                                                   }
                                                                                                } else {
                                                                                                   return false;
                                                                                                }
                                                                                             } else {
                                                                                                return false;
                                                                                             }
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof AppTaskProcessDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $producibleQuantity = this.getProducibleQuantity();
      result = result * 59 + ($producibleQuantity == null ? 43 : $producibleQuantity.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $technologyStatus = this.getTechnologyStatus();
      result = result * 59 + ($technologyStatus == null ? 43 : $technologyStatus.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $boolFirstProcess = this.getBoolFirstProcess();
      result = result * 59 + ($boolFirstProcess == null ? 43 : $boolFirstProcess.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $areaBatch = this.getAreaBatch();
      result = result * 59 + ($areaBatch == null ? 43 : $areaBatch.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $nextProcess = this.getNextProcess();
      result = result * 59 + ($nextProcess == null ? 43 : $nextProcess.hashCode());
      Object $nextProcesses = this.getNextProcesses();
      result = result * 59 + ($nextProcesses == null ? 43 : $nextProcesses.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $artifactNumberList = this.getArtifactNumberList();
      result = result * 59 + ($artifactNumberList == null ? 43 : $artifactNumberList.hashCode());
      Object $factory = this.getFactory();
      result = result * 59 + ($factory == null ? 43 : $factory.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $assistGroup = this.getAssistGroup();
      result = result * 59 + ($assistGroup == null ? 43 : $assistGroup.hashCode());
      Object $assistProductionLine = this.getAssistProductionLine();
      result = result * 59 + ($assistProductionLine == null ? 43 : $assistProductionLine.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $lastTeam = this.getLastTeam();
      result = result * 59 + ($lastTeam == null ? 43 : $lastTeam.hashCode());
      Object $lastReportTime = this.getLastReportTime();
      return result * 59 + ($lastReportTime == null ? 43 : $lastReportTime.hashCode());
   }

   public static class AppTaskProcessDetailsDTOBuilder {
      private Long taskId;
      private Long id;
      private ProjectDetailDO project;
      private MonomerDetailDO monomer;
      private AreaDetailDO area;
      private NameInfo areaBatch;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Integer producibleQuantity;
      private IdAndNameDO process;
      private IdAndNameDO nextProcess;
      private List<IdAndNameDO> nextProcesses;
      private Integer status;
      private Boolean technologyStatus;
      private LocalDateTime askCompleteTime;
      private String serialNumber;
      private Integer reportType;
      private Boolean boolFirstProcess;
      private String specification;
      private BigDecimal length;
      private String material;
      private List<AppTaskProcessArtifactNumberDTO> artifactNumberList;
      private IdAndNameDO factory;
      private IdAndNameDO workshop;
      private IdAndNameDO productionLine;
      private IdAndNameDO groups;
      private IdAndNameDO assistGroup;
      private IdAndNameDO assistProductionLine;
      private Integer codingType;
      private IdAndNameDO team;
      private IdAndNameDO lastTeam;
      private LocalDateTime lastReportTime;

      AppTaskProcessDetailsDTOBuilder() {
      }

      @JsonProperty("taskId")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("id")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("project")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomer")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("area")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("areaBatch")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder areaBatch(final NameInfo areaBatch) {
         this.areaBatch = areaBatch;
         return this;
      }

      @JsonProperty("productId")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("quantity")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("producibleQuantity")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder producibleQuantity(final Integer producibleQuantity) {
         this.producibleQuantity = producibleQuantity;
         return this;
      }

      @JsonProperty("process")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("nextProcess")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder nextProcess(final IdAndNameDO nextProcess) {
         this.nextProcess = nextProcess;
         return this;
      }

      @JsonProperty("nextProcesses")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder nextProcesses(final List<IdAndNameDO> nextProcesses) {
         this.nextProcesses = nextProcesses;
         return this;
      }

      @JsonProperty("status")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("technologyStatus")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder technologyStatus(final Boolean technologyStatus) {
         this.technologyStatus = technologyStatus;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("serialNumber")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("reportType")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("firstProcess")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder boolFirstProcess(final Boolean boolFirstProcess) {
         this.boolFirstProcess = boolFirstProcess;
         return this;
      }

      @JsonProperty("specification")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("artifactNumberList")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder artifactNumberList(final List<AppTaskProcessArtifactNumberDTO> artifactNumberList) {
         this.artifactNumberList = artifactNumberList;
         return this;
      }

      @JsonProperty("factory")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder factory(final IdAndNameDO factory) {
         this.factory = factory;
         return this;
      }

      @JsonProperty("workshop")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder workshop(final IdAndNameDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder productionLine(final IdAndNameDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder groups(final IdAndNameDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("assistGroup")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder assistGroup(final IdAndNameDO assistGroup) {
         this.assistGroup = assistGroup;
         return this;
      }

      @JsonProperty("assistProductionLine")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder assistProductionLine(final IdAndNameDO assistProductionLine) {
         this.assistProductionLine = assistProductionLine;
         return this;
      }

      @JsonProperty("codingType")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      @JsonProperty("team")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder team(final IdAndNameDO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("lastTeam")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder lastTeam(final IdAndNameDO lastTeam) {
         this.lastTeam = lastTeam;
         return this;
      }

      @JsonProperty("lastReportTime")
      public AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder lastReportTime(final LocalDateTime lastReportTime) {
         this.lastReportTime = lastReportTime;
         return this;
      }

      public AppTaskProcessDetailsDTO build() {
         return new AppTaskProcessDetailsDTO(
            this.taskId,
            this.id,
            this.project,
            this.monomer,
            this.area,
            this.areaBatch,
            this.productId,
            this.taskTypeEnum,
            this.quantity,
            this.producibleQuantity,
            this.process,
            this.nextProcess,
            this.nextProcesses,
            this.status,
            this.technologyStatus,
            this.askCompleteTime,
            this.serialNumber,
            this.reportType,
            this.boolFirstProcess,
            this.specification,
            this.length,
            this.material,
            this.artifactNumberList,
            this.factory,
            this.workshop,
            this.productionLine,
            this.groups,
            this.assistGroup,
            this.assistProductionLine,
            this.codingType,
            this.team,
            this.lastTeam,
            this.lastReportTime
         );
      }

      @Override
      public String toString() {
         return "AppTaskProcessDetailsDTO.AppTaskProcessDetailsDTOBuilder(taskId="
            + this.taskId
            + ", id="
            + this.id
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", areaBatch="
            + this.areaBatch
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", producibleQuantity="
            + this.producibleQuantity
            + ", process="
            + this.process
            + ", nextProcess="
            + this.nextProcess
            + ", nextProcesses="
            + this.nextProcesses
            + ", status="
            + this.status
            + ", technologyStatus="
            + this.technologyStatus
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", serialNumber="
            + this.serialNumber
            + ", reportType="
            + this.reportType
            + ", boolFirstProcess="
            + this.boolFirstProcess
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", artifactNumberList="
            + this.artifactNumberList
            + ", factory="
            + this.factory
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", assistGroup="
            + this.assistGroup
            + ", assistProductionLine="
            + this.assistProductionLine
            + ", codingType="
            + this.codingType
            + ", team="
            + this.team
            + ", lastTeam="
            + this.lastTeam
            + ", lastReportTime="
            + this.lastReportTime
            + ")";
      }
   }
}
