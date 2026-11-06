package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesBuildingMachinePartSchedulingDTO", description = "零件信息")
public class MesBuildingMachinePartSchedulingDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @JsonInclude(Include.NON_NULL)
   private Long id;
   @ApiModelProperty(name = "userId", value = "操作人id", notes = "操作人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @JsonInclude(Include.NON_NULL)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "操作人名称", notes = "操作人名称")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @JsonInclude(Include.NON_NULL)
   private String userName;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @JsonInclude(Include.NON_NULL)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @JsonInclude(Include.NON_NULL)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @JsonInclude(Include.NON_NULL)
   private Long areaId;
   @ApiModelProperty(name = "project", value = "项目")
   @JsonProperty("project")
   @JSONField(name = "project")
   @JsonInclude(Include.NON_NULL)
   private ProjectDetailDO project;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @JsonInclude(Include.NON_NULL)
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @JsonInclude(Include.NON_NULL)
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty(name = "cutConfigId", value = "切割配置id", notes = "切割配置id")
   @JsonProperty("cutConfigId")
   @JSONField(name = "cutConfigId")
   @JsonInclude(Include.NON_NULL)
   private Long cutConfigId;
   @ApiModelProperty(name = "cutConfigName", value = "切割配置名称", notes = "切割配置名称")
   @JsonProperty("cutConfigName")
   @JSONField(name = "cutConfigName")
   @JsonInclude(Include.NON_NULL)
   private String cutConfigName;
   @ApiModelProperty(name = "name", value = "下料方式名称", notes = "下料方式名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @JsonInclude(Include.NON_NULL)
   private String name;
   @ApiModelProperty(name = "date", value = "排产日期", notes = "排产日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   @JsonInclude(Include.NON_NULL)
   private String date;
   @ApiModelProperty(name = "thick", value = "厚度", notes = "厚度")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @JsonInclude(Include.NON_NULL)
   private String thick;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "createTime", value = "排产时间", notes = "排产时间")
   @JsonProperty("createTime")
   @JSONField(name = "createTime")
   @JsonInclude(Include.NON_NULL)
   private LocalDateTime createTime;
   @ApiModelProperty(name = "netWeight", value = "单净重", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "orderNumber", value = "任务单号", notes = "任务单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   @JsonInclude(Include.NON_NULL)
   private String orderNumber;
   @ApiModelProperty(name = "issueStatusEnum", value = "任务状态 [1 未套料 2 套料中 4 套料完成 8 已下发]", notes = "任务状态 [1 未套料 2 套料中 4 套料完成 8 已下发]")
   @JsonProperty("issueStatusEnum")
   @JSONField(name = "issueStatusEnum")
   @JsonInclude(Include.NON_NULL)
   private Integer issueStatusEnum;
   @ApiModelProperty(name = "picturePath", value = "图片路径(DXF:记录转换后的.sug位置  部件(主部件):记录导入的原构件NC1的图纸位子)")
   @JsonInclude(Include.NON_NULL)
   private String picturePath;
   @ApiModelProperty(name = "taskStatusEnum", value = "排产状态 [1 未排产 2 部分排产 4 已排产]", notes = "排产状态 [1 未排产 2 部分排产 4 已排产]")
   @JsonProperty("taskStatusEnum")
   @JSONField(name = "taskStatusEnum")
   @JsonInclude(Include.NON_NULL)
   private Integer taskStatusEnum;
   @ApiModelProperty(name = "boolNestCutEnum", value = "是否是套料", notes = "是否是套料")
   @JsonProperty("boolNestCutEnum")
   @JSONField(name = "boolNestCutEnum")
   @JsonInclude(Include.NON_NULL)
   private Boolean boolNestCutEnum;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2关联构件 16关联组立 18组立 枚举:MachinePartRelationTypeEnum")
   @JsonProperty("relationType")
   @JSONField(name = "relationType")
   private Integer relationType;
   @ApiModelProperty(name = "needMachinePartLinkList", value = "每个生产组每月需要排产的数量")
   @JsonProperty("needMachinePartLinkList")
   @JSONField(name = "needMachinePartLinkList")
   private List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList;
   @ApiModelProperty(name = "bool_drawing", value = "是否是有图纸下发", notes = "是否是有图纸下发")
   private Integer boolDrawing;
   @ApiModelProperty(name = "bool_off_line", value = "是否是线下套料0:否 1:是", notes = "是否是线下套料0:否 1:是")
   private Boolean boolOffLine;

   public static MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder builder() {
      return new MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder();
   }

   public MesBuildingMachinePartSchedulingDTO(
      final Long id,
      final Long userId,
      final String userName,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final ProjectDetailDO project,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final Long cutConfigId,
      final String cutConfigName,
      final String name,
      final String date,
      final String thick,
      final LocalDateTime askCompleteTime,
      final LocalDateTime createTime,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final String orderNumber,
      final Integer issueStatusEnum,
      final String picturePath,
      final Integer taskStatusEnum,
      final Boolean boolNestCutEnum,
      final Integer relationType,
      final List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList,
      final Integer boolDrawing,
      final Boolean boolOffLine
   ) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.project = project;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.cutConfigId = cutConfigId;
      this.cutConfigName = cutConfigName;
      this.name = name;
      this.date = date;
      this.thick = thick;
      this.askCompleteTime = askCompleteTime;
      this.createTime = createTime;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.orderNumber = orderNumber;
      this.issueStatusEnum = issueStatusEnum;
      this.picturePath = picturePath;
      this.taskStatusEnum = taskStatusEnum;
      this.boolNestCutEnum = boolNestCutEnum;
      this.relationType = relationType;
      this.needMachinePartLinkList = needMachinePartLinkList;
      this.boolDrawing = boolDrawing;
      this.boolOffLine = boolOffLine;
   }

   public MesBuildingMachinePartSchedulingDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
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

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getCutConfigId() {
      return this.cutConfigId;
   }

   public String getCutConfigName() {
      return this.cutConfigName;
   }

   public String getName() {
      return this.name;
   }

   public String getDate() {
      return this.date;
   }

   public String getThick() {
      return this.thick;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Integer getIssueStatusEnum() {
      return this.issueStatusEnum;
   }

   public String getPicturePath() {
      return this.picturePath;
   }

   public Integer getTaskStatusEnum() {
      return this.taskStatusEnum;
   }

   public Boolean getBoolNestCutEnum() {
      return this.boolNestCutEnum;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public List<MesBuildingNeedMachinePartSchedulingLinkDTO> getNeedMachinePartLinkList() {
      return this.needMachinePartLinkList;
   }

   public Integer getBoolDrawing() {
      return this.boolDrawing;
   }

   public Boolean getBoolOffLine() {
      return this.boolOffLine;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartSchedulingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingMachinePartSchedulingDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingMachinePartSchedulingDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingMachinePartSchedulingDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingMachinePartSchedulingDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingMachinePartSchedulingDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("project")
   public MesBuildingMachinePartSchedulingDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingMachinePartSchedulingDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingMachinePartSchedulingDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingMachinePartSchedulingDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingMachinePartSchedulingDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSchedulingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("cutConfigId")
   public MesBuildingMachinePartSchedulingDTO setCutConfigId(final Long cutConfigId) {
      this.cutConfigId = cutConfigId;
      return this;
   }

   @JsonProperty("cutConfigName")
   public MesBuildingMachinePartSchedulingDTO setCutConfigName(final String cutConfigName) {
      this.cutConfigName = cutConfigName;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingMachinePartSchedulingDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("date")
   public MesBuildingMachinePartSchedulingDTO setDate(final String date) {
      this.date = date;
      return this;
   }

   @JsonProperty("thick")
   public MesBuildingMachinePartSchedulingDTO setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingMachinePartSchedulingDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("createTime")
   public MesBuildingMachinePartSchedulingDTO setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingMachinePartSchedulingDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingMachinePartSchedulingDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("orderNumber")
   public MesBuildingMachinePartSchedulingDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("issueStatusEnum")
   public MesBuildingMachinePartSchedulingDTO setIssueStatusEnum(final Integer issueStatusEnum) {
      this.issueStatusEnum = issueStatusEnum;
      return this;
   }

   public MesBuildingMachinePartSchedulingDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @JsonProperty("taskStatusEnum")
   public MesBuildingMachinePartSchedulingDTO setTaskStatusEnum(final Integer taskStatusEnum) {
      this.taskStatusEnum = taskStatusEnum;
      return this;
   }

   @JsonProperty("boolNestCutEnum")
   public MesBuildingMachinePartSchedulingDTO setBoolNestCutEnum(final Boolean boolNestCutEnum) {
      this.boolNestCutEnum = boolNestCutEnum;
      return this;
   }

   @JsonProperty("relationType")
   public MesBuildingMachinePartSchedulingDTO setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   @JsonProperty("needMachinePartLinkList")
   public MesBuildingMachinePartSchedulingDTO setNeedMachinePartLinkList(final List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList) {
      this.needMachinePartLinkList = needMachinePartLinkList;
      return this;
   }

   public MesBuildingMachinePartSchedulingDTO setBoolDrawing(final Integer boolDrawing) {
      this.boolDrawing = boolDrawing;
      return this;
   }

   public MesBuildingMachinePartSchedulingDTO setBoolOffLine(final Boolean boolOffLine) {
      this.boolOffLine = boolOffLine;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingDTO(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", project="
         + this.getProject()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", cutConfigId="
         + this.getCutConfigId()
         + ", cutConfigName="
         + this.getCutConfigName()
         + ", name="
         + this.getName()
         + ", date="
         + this.getDate()
         + ", thick="
         + this.getThick()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", createTime="
         + this.getCreateTime()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", issueStatusEnum="
         + this.getIssueStatusEnum()
         + ", picturePath="
         + this.getPicturePath()
         + ", taskStatusEnum="
         + this.getTaskStatusEnum()
         + ", boolNestCutEnum="
         + this.getBoolNestCutEnum()
         + ", relationType="
         + this.getRelationType()
         + ", needMachinePartLinkList="
         + this.getNeedMachinePartLinkList()
         + ", boolDrawing="
         + this.getBoolDrawing()
         + ", boolOffLine="
         + this.getBoolOffLine()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingDTO)) {
         return false;
      }

      MesBuildingMachinePartSchedulingDTO other = (MesBuildingMachinePartSchedulingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$cutConfigId = this.getCutConfigId();
                        Object other$cutConfigId = other.getCutConfigId();
                        if (this$cutConfigId == null ? other$cutConfigId == null : this$cutConfigId.equals(other$cutConfigId)) {
                           Object this$issueStatusEnum = this.getIssueStatusEnum();
                           Object other$issueStatusEnum = other.getIssueStatusEnum();
                           if (this$issueStatusEnum == null ? other$issueStatusEnum == null : this$issueStatusEnum.equals(other$issueStatusEnum)) {
                              Object this$taskStatusEnum = this.getTaskStatusEnum();
                              Object other$taskStatusEnum = other.getTaskStatusEnum();
                              if (this$taskStatusEnum == null ? other$taskStatusEnum == null : this$taskStatusEnum.equals(other$taskStatusEnum)) {
                                 Object this$boolNestCutEnum = this.getBoolNestCutEnum();
                                 Object other$boolNestCutEnum = other.getBoolNestCutEnum();
                                 if (this$boolNestCutEnum == null ? other$boolNestCutEnum == null : this$boolNestCutEnum.equals(other$boolNestCutEnum)) {
                                    Object this$relationType = this.getRelationType();
                                    Object other$relationType = other.getRelationType();
                                    if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                                       Object this$boolDrawing = this.getBoolDrawing();
                                       Object other$boolDrawing = other.getBoolDrawing();
                                       if (this$boolDrawing == null ? other$boolDrawing == null : this$boolDrawing.equals(other$boolDrawing)) {
                                          Object this$boolOffLine = this.getBoolOffLine();
                                          Object other$boolOffLine = other.getBoolOffLine();
                                          if (this$boolOffLine == null ? other$boolOffLine == null : this$boolOffLine.equals(other$boolOffLine)) {
                                             Object this$userName = this.getUserName();
                                             Object other$userName = other.getUserName();
                                             if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                Object this$project = this.getProject();
                                                Object other$project = other.getProject();
                                                if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                   Object this$serialNumber = this.getSerialNumber();
                                                   Object other$serialNumber = other.getSerialNumber();
                                                   if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
                                                            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                               Object this$cutConfigName = this.getCutConfigName();
                                                               Object other$cutConfigName = other.getCutConfigName();
                                                               if (this$cutConfigName == null
                                                                  ? other$cutConfigName == null
                                                                  : this$cutConfigName.equals(other$cutConfigName)) {
                                                                  Object this$name = this.getName();
                                                                  Object other$name = other.getName();
                                                                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                                     Object this$date = this.getDate();
                                                                     Object other$date = other.getDate();
                                                                     if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                                                                        Object this$thick = this.getThick();
                                                                        Object other$thick = other.getThick();
                                                                        if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                                           Object this$askCompleteTime = this.getAskCompleteTime();
                                                                           Object other$askCompleteTime = other.getAskCompleteTime();
                                                                           if (this$askCompleteTime == null
                                                                              ? other$askCompleteTime == null
                                                                              : this$askCompleteTime.equals(other$askCompleteTime)) {
                                                                              Object this$createTime = this.getCreateTime();
                                                                              Object other$createTime = other.getCreateTime();
                                                                              if (this$createTime == null
                                                                                 ? other$createTime == null
                                                                                 : this$createTime.equals(other$createTime)) {
                                                                                 Object this$netWeight = this.getNetWeight();
                                                                                 Object other$netWeight = other.getNetWeight();
                                                                                 if (this$netWeight == null
                                                                                    ? other$netWeight == null
                                                                                    : this$netWeight.equals(other$netWeight)) {
                                                                                    Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                    Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                    if (this$totalNetWeight == null
                                                                                       ? other$totalNetWeight == null
                                                                                       : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                                       Object this$orderNumber = this.getOrderNumber();
                                                                                       Object other$orderNumber = other.getOrderNumber();
                                                                                       if (this$orderNumber == null
                                                                                          ? other$orderNumber == null
                                                                                          : this$orderNumber.equals(other$orderNumber)) {
                                                                                          Object this$picturePath = this.getPicturePath();
                                                                                          Object other$picturePath = other.getPicturePath();
                                                                                          if (this$picturePath == null
                                                                                             ? other$picturePath == null
                                                                                             : this$picturePath.equals(other$picturePath)) {
                                                                                             Object this$needMachinePartLinkList = this.getNeedMachinePartLinkList();
                                                                                             Object other$needMachinePartLinkList = other.getNeedMachinePartLinkList();
                                                                                             return this$needMachinePartLinkList == null
                                                                                                ? other$needMachinePartLinkList == null
                                                                                                : this$needMachinePartLinkList.equals(
                                                                                                   other$needMachinePartLinkList
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $cutConfigId = this.getCutConfigId();
      result = result * 59 + ($cutConfigId == null ? 43 : $cutConfigId.hashCode());
      Object $issueStatusEnum = this.getIssueStatusEnum();
      result = result * 59 + ($issueStatusEnum == null ? 43 : $issueStatusEnum.hashCode());
      Object $taskStatusEnum = this.getTaskStatusEnum();
      result = result * 59 + ($taskStatusEnum == null ? 43 : $taskStatusEnum.hashCode());
      Object $boolNestCutEnum = this.getBoolNestCutEnum();
      result = result * 59 + ($boolNestCutEnum == null ? 43 : $boolNestCutEnum.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $boolDrawing = this.getBoolDrawing();
      result = result * 59 + ($boolDrawing == null ? 43 : $boolDrawing.hashCode());
      Object $boolOffLine = this.getBoolOffLine();
      result = result * 59 + ($boolOffLine == null ? 43 : $boolOffLine.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $cutConfigName = this.getCutConfigName();
      result = result * 59 + ($cutConfigName == null ? 43 : $cutConfigName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $picturePath = this.getPicturePath();
      result = result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
      Object $needMachinePartLinkList = this.getNeedMachinePartLinkList();
      return result * 59 + ($needMachinePartLinkList == null ? 43 : $needMachinePartLinkList.hashCode());
   }

   public static class MesBuildingMachinePartSchedulingDTOBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private ProjectDetailDO project;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private Long cutConfigId;
      private String cutConfigName;
      private String name;
      private String date;
      private String thick;
      private LocalDateTime askCompleteTime;
      private LocalDateTime createTime;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private String orderNumber;
      private Integer issueStatusEnum;
      private String picturePath;
      private Integer taskStatusEnum;
      private Boolean boolNestCutEnum;
      private Integer relationType;
      private List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList;
      private Integer boolDrawing;
      private Boolean boolOffLine;

      MesBuildingMachinePartSchedulingDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("project")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("cutConfigId")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder cutConfigId(final Long cutConfigId) {
         this.cutConfigId = cutConfigId;
         return this;
      }

      @JsonProperty("cutConfigName")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder cutConfigName(final String cutConfigName) {
         this.cutConfigName = cutConfigName;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("date")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      @JsonProperty("thick")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("createTime")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("orderNumber")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("issueStatusEnum")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder issueStatusEnum(final Integer issueStatusEnum) {
         this.issueStatusEnum = issueStatusEnum;
         return this;
      }

      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      @JsonProperty("taskStatusEnum")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder taskStatusEnum(final Integer taskStatusEnum) {
         this.taskStatusEnum = taskStatusEnum;
         return this;
      }

      @JsonProperty("boolNestCutEnum")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder boolNestCutEnum(final Boolean boolNestCutEnum) {
         this.boolNestCutEnum = boolNestCutEnum;
         return this;
      }

      @JsonProperty("relationType")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      @JsonProperty("needMachinePartLinkList")
      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder needMachinePartLinkList(
         final List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList
      ) {
         this.needMachinePartLinkList = needMachinePartLinkList;
         return this;
      }

      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder boolDrawing(final Integer boolDrawing) {
         this.boolDrawing = boolDrawing;
         return this;
      }

      public MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder boolOffLine(final Boolean boolOffLine) {
         this.boolOffLine = boolOffLine;
         return this;
      }

      public MesBuildingMachinePartSchedulingDTO build() {
         return new MesBuildingMachinePartSchedulingDTO(
            this.id,
            this.userId,
            this.userName,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.project,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.cutConfigId,
            this.cutConfigName,
            this.name,
            this.date,
            this.thick,
            this.askCompleteTime,
            this.createTime,
            this.netWeight,
            this.totalNetWeight,
            this.orderNumber,
            this.issueStatusEnum,
            this.picturePath,
            this.taskStatusEnum,
            this.boolNestCutEnum,
            this.relationType,
            this.needMachinePartLinkList,
            this.boolDrawing,
            this.boolOffLine
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSchedulingDTO.MesBuildingMachinePartSchedulingDTOBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", project="
            + this.project
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", cutConfigId="
            + this.cutConfigId
            + ", cutConfigName="
            + this.cutConfigName
            + ", name="
            + this.name
            + ", date="
            + this.date
            + ", thick="
            + this.thick
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", createTime="
            + this.createTime
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", orderNumber="
            + this.orderNumber
            + ", issueStatusEnum="
            + this.issueStatusEnum
            + ", picturePath="
            + this.picturePath
            + ", taskStatusEnum="
            + this.taskStatusEnum
            + ", boolNestCutEnum="
            + this.boolNestCutEnum
            + ", relationType="
            + this.relationType
            + ", needMachinePartLinkList="
            + this.needMachinePartLinkList
            + ", boolDrawing="
            + this.boolDrawing
            + ", boolOffLine="
            + this.boolOffLine
            + ")";
      }
   }
}
