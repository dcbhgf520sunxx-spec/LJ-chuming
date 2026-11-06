package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MachinePartNestingTeamDTO", description = "返回待排产的具体零件信息")
public class MachinePartNestingDetailDTO {
   @ApiModelProperty("id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty("零件需要排产Ids")
   private String taskNeedMachinePartSchedulingIds;
   @ApiModelProperty("下发到套料软件状态")
   private Integer issuedToNestingSoftwareStatus;
   @ApiModelProperty("项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名称", notes = "单体名称")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   @Excel(name = "单体名称", orderNum = "2")
   private String monomerName;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty("工单id")
   @JsonProperty("orderId")
   @JSONField(name = "orderId")
   private Long orderId;
   @ApiModelProperty("班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty("工单编号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   @Excel(name = "工单编号", orderNum = "3")
   private String orderNumber;
   @ApiModelProperty("零件id")
   @JsonProperty("partId")
   @JSONField(name = "partId")
   private Long partId;
   @ApiModelProperty("零件类型")
   @JsonProperty("partTypeId")
   @JSONField(name = "partTypeId")
   private Long partTypeId;
   @ApiModelProperty("零件类型")
   @JsonProperty("partType")
   @JSONField(name = "partType")
   @Excel(name = "零件类型", orderNum = "3")
   private String partType;
   @ApiModelProperty("零件来源")
   @JsonProperty("partSource")
   @JSONField(name = "partSource")
   private String partSource;
   @ApiModelProperty(name = "picturePath", value = "图片路径(DXF:记录转换后的.sug位置  部件(主部件):记录导入的原构件NC1的图纸位子)")
   @JsonProperty("picturePath")
   @JSONField(name = "picturePath")
   private String picturePath;
   @ApiModelProperty("图纸id")
   @JsonProperty("drwaingId")
   @JSONField(name = "drwaingId")
   private Long drwaingId;
   @ApiModelProperty("编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @Excel(name = "编号", orderNum = "4")
   private String serialNumber;
   @ApiModelProperty("材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @Excel(name = "材质", orderNum = "5")
   private String material;
   @ApiModelProperty("厚度")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @Excel(name = "厚度", orderNum = "6")
   private String thick;
   @ApiModelProperty("宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   @Excel(name = "宽度", orderNum = "7")
   private BigDecimal width;
   @ApiModelProperty("单长度(mm)")
   @JsonProperty("length")
   @JSONField(name = "length")
   @Excel(name = "单长度(mm)", orderNum = "8")
   private BigDecimal length;
   @ApiModelProperty("总长度(mm)")
   private BigDecimal totalLength;
   @ApiModelProperty("数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @Excel(name = "数量", orderNum = "9")
   private Integer quantity;
   @ApiModelProperty("已排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty("需要排产数量")
   @JsonProperty("needQuantity")
   @JSONField(name = "needQuantity")
   private Integer needQuantity;
   @ApiModelProperty("单重量(kg)")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   @Excel(name = "单重量(kg)", orderNum = "10")
   private BigDecimal weight;
   @ApiModelProperty("总重量(kg)")
   private BigDecimal totalWeight;
   @ApiModelProperty("单面积(m²)")
   @JsonProperty("area")
   @JSONField(name = "area")
   private BigDecimal area;
   @ApiModelProperty("总面积(m²)")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "needMachinePartLinkList", value = "每个生产组每月需要排产的数量")
   @JsonProperty("needMachinePartLinkList")
   @JSONField(name = "needMachinePartLinkList")
   private List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList;
   @ApiModelProperty("排产人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty("排产日期")
   @JsonProperty("schedulingDate")
   @JSONField(name = "schedulingDate")
   private String schedulingDate;
   @ApiModelProperty("作业名称")
   @JsonProperty("jobName")
   @JSONField(name = "jobName")
   private String jobName;
   @ApiModelProperty("总排产数量")
   @JsonProperty("totalSchedulingQuantity")
   @JSONField(name = "totalSchedulingQuantity")
   private Integer totalSchedulingQuantity;
   @ApiModelProperty("总排产重量")
   @JsonProperty("totalNeedWeight")
   @JSONField(name = "totalNeedWeight")
   private BigDecimal totalNeedWeight;
   @ApiModelProperty("是否矩形有空")
   @JsonProperty("isRectangle")
   @JSONField(name = "isRectangle")
   private Integer isRectangle;
   @ApiModelProperty("规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty("规格加材质")
   @JsonProperty("specificationAndMaterial")
   @JSONField(name = "specificationAndMaterial")
   private String specificationAndMaterial;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty("是否直发件(0:否,1:是)")
   private Boolean boolSendDirectly;

   public static MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder builder() {
      return new MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getTaskNeedMachinePartSchedulingIds() {
      return this.taskNeedMachinePartSchedulingIds;
   }

   public Integer getIssuedToNestingSoftwareStatus() {
      return this.issuedToNestingSoftwareStatus;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public Long getPartId() {
      return this.partId;
   }

   public Long getPartTypeId() {
      return this.partTypeId;
   }

   public String getPartType() {
      return this.partType;
   }

   public String getPartSource() {
      return this.partSource;
   }

   public String getPicturePath() {
      return this.picturePath;
   }

   public Long getDrwaingId() {
      return this.drwaingId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getThick() {
      return this.thick;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getNeedQuantity() {
      return this.needQuantity;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public List<MesBuildingNeedMachinePartSchedulingLinkDTO> getNeedMachinePartLinkList() {
      return this.needMachinePartLinkList;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getSchedulingDate() {
      return this.schedulingDate;
   }

   public String getJobName() {
      return this.jobName;
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public BigDecimal getTotalNeedWeight() {
      return this.totalNeedWeight;
   }

   public Integer getIsRectangle() {
      return this.isRectangle;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getSpecificationAndMaterial() {
      return this.specificationAndMaterial;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   @JsonProperty("id")
   public MachinePartNestingDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MachinePartNestingDetailDTO setTaskNeedMachinePartSchedulingIds(final String taskNeedMachinePartSchedulingIds) {
      this.taskNeedMachinePartSchedulingIds = taskNeedMachinePartSchedulingIds;
      return this;
   }

   public MachinePartNestingDetailDTO setIssuedToNestingSoftwareStatus(final Integer issuedToNestingSoftwareStatus) {
      this.issuedToNestingSoftwareStatus = issuedToNestingSoftwareStatus;
      return this;
   }

   @JsonProperty("project")
   public MachinePartNestingDetailDTO setProject(final ProjectInfo project) {
      this.project = project;
      return this;
   }

   @JsonProperty("monomerId")
   public MachinePartNestingDetailDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("monomerName")
   public MachinePartNestingDetailDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("productId")
   public MachinePartNestingDetailDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("orderId")
   public MachinePartNestingDetailDTO setOrderId(final Long orderId) {
      this.orderId = orderId;
      return this;
   }

   @JsonProperty("teamId")
   public MachinePartNestingDetailDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("orderNumber")
   public MachinePartNestingDetailDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   @JsonProperty("partId")
   public MachinePartNestingDetailDTO setPartId(final Long partId) {
      this.partId = partId;
      return this;
   }

   @JsonProperty("partTypeId")
   public MachinePartNestingDetailDTO setPartTypeId(final Long partTypeId) {
      this.partTypeId = partTypeId;
      return this;
   }

   @JsonProperty("partType")
   public MachinePartNestingDetailDTO setPartType(final String partType) {
      this.partType = partType;
      return this;
   }

   @JsonProperty("partSource")
   public MachinePartNestingDetailDTO setPartSource(final String partSource) {
      this.partSource = partSource;
      return this;
   }

   @JsonProperty("picturePath")
   public MachinePartNestingDetailDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @JsonProperty("drwaingId")
   public MachinePartNestingDetailDTO setDrwaingId(final Long drwaingId) {
      this.drwaingId = drwaingId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MachinePartNestingDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("material")
   public MachinePartNestingDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("thick")
   public MachinePartNestingDetailDTO setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("width")
   public MachinePartNestingDetailDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("length")
   public MachinePartNestingDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public MachinePartNestingDetailDTO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("quantity")
   public MachinePartNestingDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MachinePartNestingDetailDTO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("needQuantity")
   public MachinePartNestingDetailDTO setNeedQuantity(final Integer needQuantity) {
      this.needQuantity = needQuantity;
      return this;
   }

   @JsonProperty("weight")
   public MachinePartNestingDetailDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   public MachinePartNestingDetailDTO setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   @JsonProperty("area")
   public MachinePartNestingDetailDTO setArea(final BigDecimal area) {
      this.area = area;
      return this;
   }

   public MachinePartNestingDetailDTO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("workshopId")
   public MachinePartNestingDetailDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("needMachinePartLinkList")
   public MachinePartNestingDetailDTO setNeedMachinePartLinkList(final List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList) {
      this.needMachinePartLinkList = needMachinePartLinkList;
      return this;
   }

   @JsonProperty("userName")
   public MachinePartNestingDetailDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("schedulingDate")
   public MachinePartNestingDetailDTO setSchedulingDate(final String schedulingDate) {
      this.schedulingDate = schedulingDate;
      return this;
   }

   @JsonProperty("jobName")
   public MachinePartNestingDetailDTO setJobName(final String jobName) {
      this.jobName = jobName;
      return this;
   }

   @JsonProperty("totalSchedulingQuantity")
   public MachinePartNestingDetailDTO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalNeedWeight")
   public MachinePartNestingDetailDTO setTotalNeedWeight(final BigDecimal totalNeedWeight) {
      this.totalNeedWeight = totalNeedWeight;
      return this;
   }

   @JsonProperty("isRectangle")
   public MachinePartNestingDetailDTO setIsRectangle(final Integer isRectangle) {
      this.isRectangle = isRectangle;
      return this;
   }

   @JsonProperty("specification")
   public MachinePartNestingDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("specificationAndMaterial")
   public MachinePartNestingDetailDTO setSpecificationAndMaterial(final String specificationAndMaterial) {
      this.specificationAndMaterial = specificationAndMaterial;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MachinePartNestingDetailDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   public MachinePartNestingDetailDTO setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartNestingDetailDTO(id="
         + this.getId()
         + ", taskNeedMachinePartSchedulingIds="
         + this.getTaskNeedMachinePartSchedulingIds()
         + ", issuedToNestingSoftwareStatus="
         + this.getIssuedToNestingSoftwareStatus()
         + ", project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", productId="
         + this.getProductId()
         + ", orderId="
         + this.getOrderId()
         + ", teamId="
         + this.getTeamId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", partId="
         + this.getPartId()
         + ", partTypeId="
         + this.getPartTypeId()
         + ", partType="
         + this.getPartType()
         + ", partSource="
         + this.getPartSource()
         + ", picturePath="
         + this.getPicturePath()
         + ", drwaingId="
         + this.getDrwaingId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", material="
         + this.getMaterial()
         + ", thick="
         + this.getThick()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", totalLength="
         + this.getTotalLength()
         + ", quantity="
         + this.getQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", needQuantity="
         + this.getNeedQuantity()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", area="
         + this.getArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", workshopId="
         + this.getWorkshopId()
         + ", needMachinePartLinkList="
         + this.getNeedMachinePartLinkList()
         + ", userName="
         + this.getUserName()
         + ", schedulingDate="
         + this.getSchedulingDate()
         + ", jobName="
         + this.getJobName()
         + ", totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalNeedWeight="
         + this.getTotalNeedWeight()
         + ", isRectangle="
         + this.getIsRectangle()
         + ", specification="
         + this.getSpecification()
         + ", specificationAndMaterial="
         + this.getSpecificationAndMaterial()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ")";
   }

   public MachinePartNestingDetailDTO() {
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingDetailDTO)) {
         return false;
      }

      MachinePartNestingDetailDTO other = (MachinePartNestingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$issuedToNestingSoftwareStatus = this.getIssuedToNestingSoftwareStatus();
         Object other$issuedToNestingSoftwareStatus = other.getIssuedToNestingSoftwareStatus();
         if (this$issuedToNestingSoftwareStatus == null
            ? other$issuedToNestingSoftwareStatus == null
            : this$issuedToNestingSoftwareStatus.equals(other$issuedToNestingSoftwareStatus)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$orderId = this.getOrderId();
                  Object other$orderId = other.getOrderId();
                  if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
                     Object this$teamId = this.getTeamId();
                     Object other$teamId = other.getTeamId();
                     if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                        Object this$partId = this.getPartId();
                        Object other$partId = other.getPartId();
                        if (this$partId == null ? other$partId == null : this$partId.equals(other$partId)) {
                           Object this$partTypeId = this.getPartTypeId();
                           Object other$partTypeId = other.getPartTypeId();
                           if (this$partTypeId == null ? other$partTypeId == null : this$partTypeId.equals(other$partTypeId)) {
                              Object this$drwaingId = this.getDrwaingId();
                              Object other$drwaingId = other.getDrwaingId();
                              if (this$drwaingId == null ? other$drwaingId == null : this$drwaingId.equals(other$drwaingId)) {
                                 Object this$quantity = this.getQuantity();
                                 Object other$quantity = other.getQuantity();
                                 if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                    Object this$schedulingQuantity = this.getSchedulingQuantity();
                                    Object other$schedulingQuantity = other.getSchedulingQuantity();
                                    if (this$schedulingQuantity == null
                                       ? other$schedulingQuantity == null
                                       : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                                       Object this$needQuantity = this.getNeedQuantity();
                                       Object other$needQuantity = other.getNeedQuantity();
                                       if (this$needQuantity == null ? other$needQuantity == null : this$needQuantity.equals(other$needQuantity)) {
                                          Object this$workshopId = this.getWorkshopId();
                                          Object other$workshopId = other.getWorkshopId();
                                          if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                             Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
                                             Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
                                             if (this$totalSchedulingQuantity == null
                                                ? other$totalSchedulingQuantity == null
                                                : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
                                                Object this$isRectangle = this.getIsRectangle();
                                                Object other$isRectangle = other.getIsRectangle();
                                                if (this$isRectangle == null ? other$isRectangle == null : this$isRectangle.equals(other$isRectangle)) {
                                                   Object this$boolSendDirectly = this.getBoolSendDirectly();
                                                   Object other$boolSendDirectly = other.getBoolSendDirectly();
                                                   if (this$boolSendDirectly == null
                                                      ? other$boolSendDirectly == null
                                                      : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                                      Object this$taskNeedMachinePartSchedulingIds = this.getTaskNeedMachinePartSchedulingIds();
                                                      Object other$taskNeedMachinePartSchedulingIds = other.getTaskNeedMachinePartSchedulingIds();
                                                      if (this$taskNeedMachinePartSchedulingIds == null
                                                         ? other$taskNeedMachinePartSchedulingIds == null
                                                         : this$taskNeedMachinePartSchedulingIds.equals(other$taskNeedMachinePartSchedulingIds)) {
                                                         Object this$project = this.getProject();
                                                         Object other$project = other.getProject();
                                                         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                            Object this$monomerName = this.getMonomerName();
                                                            Object other$monomerName = other.getMonomerName();
                                                            if (this$monomerName == null
                                                               ? other$monomerName == null
                                                               : this$monomerName.equals(other$monomerName)) {
                                                               Object this$orderNumber = this.getOrderNumber();
                                                               Object other$orderNumber = other.getOrderNumber();
                                                               if (this$orderNumber == null
                                                                  ? other$orderNumber == null
                                                                  : this$orderNumber.equals(other$orderNumber)) {
                                                                  Object this$partType = this.getPartType();
                                                                  Object other$partType = other.getPartType();
                                                                  if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
                                                                     Object this$partSource = this.getPartSource();
                                                                     Object other$partSource = other.getPartSource();
                                                                     if (this$partSource == null
                                                                        ? other$partSource == null
                                                                        : this$partSource.equals(other$partSource)) {
                                                                        Object this$picturePath = this.getPicturePath();
                                                                        Object other$picturePath = other.getPicturePath();
                                                                        if (this$picturePath == null
                                                                           ? other$picturePath == null
                                                                           : this$picturePath.equals(other$picturePath)) {
                                                                           Object this$serialNumber = this.getSerialNumber();
                                                                           Object other$serialNumber = other.getSerialNumber();
                                                                           if (this$serialNumber == null
                                                                              ? other$serialNumber == null
                                                                              : this$serialNumber.equals(other$serialNumber)) {
                                                                              Object this$material = this.getMaterial();
                                                                              Object other$material = other.getMaterial();
                                                                              if (this$material == null
                                                                                 ? other$material == null
                                                                                 : this$material.equals(other$material)) {
                                                                                 Object this$thick = this.getThick();
                                                                                 Object other$thick = other.getThick();
                                                                                 if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                                                    Object this$width = this.getWidth();
                                                                                    Object other$width = other.getWidth();
                                                                                    if (this$width == null
                                                                                       ? other$width == null
                                                                                       : this$width.equals(other$width)) {
                                                                                       Object this$length = this.getLength();
                                                                                       Object other$length = other.getLength();
                                                                                       if (this$length == null
                                                                                          ? other$length == null
                                                                                          : this$length.equals(other$length)) {
                                                                                          Object this$totalLength = this.getTotalLength();
                                                                                          Object other$totalLength = other.getTotalLength();
                                                                                          if (this$totalLength == null
                                                                                             ? other$totalLength == null
                                                                                             : this$totalLength.equals(other$totalLength)) {
                                                                                             Object this$weight = this.getWeight();
                                                                                             Object other$weight = other.getWeight();
                                                                                             if (this$weight == null
                                                                                                ? other$weight == null
                                                                                                : this$weight.equals(other$weight)) {
                                                                                                Object this$totalWeight = this.getTotalWeight();
                                                                                                Object other$totalWeight = other.getTotalWeight();
                                                                                                if (this$totalWeight == null
                                                                                                   ? other$totalWeight == null
                                                                                                   : this$totalWeight.equals(other$totalWeight)) {
                                                                                                   Object this$area = this.getArea();
                                                                                                   Object other$area = other.getArea();
                                                                                                   if (this$area == null
                                                                                                      ? other$area == null
                                                                                                      : this$area.equals(other$area)) {
                                                                                                      Object this$totalArea = this.getTotalArea();
                                                                                                      Object other$totalArea = other.getTotalArea();
                                                                                                      if (this$totalArea == null
                                                                                                         ? other$totalArea == null
                                                                                                         : this$totalArea.equals(other$totalArea)) {
                                                                                                         Object this$needMachinePartLinkList = this.getNeedMachinePartLinkList();
                                                                                                         Object other$needMachinePartLinkList = other.getNeedMachinePartLinkList();
                                                                                                         if (this$needMachinePartLinkList == null
                                                                                                            ? other$needMachinePartLinkList == null
                                                                                                            : this$needMachinePartLinkList.equals(
                                                                                                               other$needMachinePartLinkList
                                                                                                            )) {
                                                                                                            Object this$userName = this.getUserName();
                                                                                                            Object other$userName = other.getUserName();
                                                                                                            if (this$userName == null
                                                                                                               ? other$userName == null
                                                                                                               : this$userName.equals(other$userName)) {
                                                                                                               Object this$schedulingDate = this.getSchedulingDate();
                                                                                                               Object other$schedulingDate = other.getSchedulingDate();
                                                                                                               if (this$schedulingDate == null
                                                                                                                  ? other$schedulingDate == null
                                                                                                                  : this$schedulingDate.equals(
                                                                                                                     other$schedulingDate
                                                                                                                  )) {
                                                                                                                  Object this$jobName = this.getJobName();
                                                                                                                  Object other$jobName = other.getJobName();
                                                                                                                  if (this$jobName == null
                                                                                                                     ? other$jobName == null
                                                                                                                     : this$jobName.equals(other$jobName)) {
                                                                                                                     Object this$totalNeedWeight = this.getTotalNeedWeight();
                                                                                                                     Object other$totalNeedWeight = other.getTotalNeedWeight();
                                                                                                                     if (this$totalNeedWeight == null
                                                                                                                        ? other$totalNeedWeight == null
                                                                                                                        : this$totalNeedWeight.equals(
                                                                                                                           other$totalNeedWeight
                                                                                                                        )) {
                                                                                                                        Object this$specification = this.getSpecification();
                                                                                                                        Object other$specification = other.getSpecification();
                                                                                                                        if (this$specification == null
                                                                                                                           ? other$specification == null
                                                                                                                           : this$specification.equals(
                                                                                                                              other$specification
                                                                                                                           )) {
                                                                                                                           Object this$specificationAndMaterial = this.getSpecificationAndMaterial();
                                                                                                                           Object other$specificationAndMaterial = other.getSpecificationAndMaterial();
                                                                                                                           if (this$specificationAndMaterial
                                                                                                                                 == null
                                                                                                                              ? other$specificationAndMaterial
                                                                                                                                 == null
                                                                                                                              : this$specificationAndMaterial.equals(
                                                                                                                                 other$specificationAndMaterial
                                                                                                                              )) {
                                                                                                                              Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                                                              Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                                                              return this$askCompleteTime
                                                                                                                                    == null
                                                                                                                                 ? other$askCompleteTime
                                                                                                                                    == null
                                                                                                                                 : this$askCompleteTime.equals(
                                                                                                                                    other$askCompleteTime
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MachinePartNestingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $issuedToNestingSoftwareStatus = this.getIssuedToNestingSoftwareStatus();
      result = result * 59 + ($issuedToNestingSoftwareStatus == null ? 43 : $issuedToNestingSoftwareStatus.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $partId = this.getPartId();
      result = result * 59 + ($partId == null ? 43 : $partId.hashCode());
      Object $partTypeId = this.getPartTypeId();
      result = result * 59 + ($partTypeId == null ? 43 : $partTypeId.hashCode());
      Object $drwaingId = this.getDrwaingId();
      result = result * 59 + ($drwaingId == null ? 43 : $drwaingId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $needQuantity = this.getNeedQuantity();
      result = result * 59 + ($needQuantity == null ? 43 : $needQuantity.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $isRectangle = this.getIsRectangle();
      result = result * 59 + ($isRectangle == null ? 43 : $isRectangle.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $taskNeedMachinePartSchedulingIds = this.getTaskNeedMachinePartSchedulingIds();
      result = result * 59 + ($taskNeedMachinePartSchedulingIds == null ? 43 : $taskNeedMachinePartSchedulingIds.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $partSource = this.getPartSource();
      result = result * 59 + ($partSource == null ? 43 : $partSource.hashCode());
      Object $picturePath = this.getPicturePath();
      result = result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $needMachinePartLinkList = this.getNeedMachinePartLinkList();
      result = result * 59 + ($needMachinePartLinkList == null ? 43 : $needMachinePartLinkList.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $schedulingDate = this.getSchedulingDate();
      result = result * 59 + ($schedulingDate == null ? 43 : $schedulingDate.hashCode());
      Object $jobName = this.getJobName();
      result = result * 59 + ($jobName == null ? 43 : $jobName.hashCode());
      Object $totalNeedWeight = this.getTotalNeedWeight();
      result = result * 59 + ($totalNeedWeight == null ? 43 : $totalNeedWeight.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $specificationAndMaterial = this.getSpecificationAndMaterial();
      result = result * 59 + ($specificationAndMaterial == null ? 43 : $specificationAndMaterial.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   public MachinePartNestingDetailDTO(
      final Long id,
      final String taskNeedMachinePartSchedulingIds,
      final Integer issuedToNestingSoftwareStatus,
      final ProjectInfo project,
      final Long monomerId,
      final String monomerName,
      final Long productId,
      final Long orderId,
      final Long teamId,
      final String orderNumber,
      final Long partId,
      final Long partTypeId,
      final String partType,
      final String partSource,
      final String picturePath,
      final Long drwaingId,
      final String serialNumber,
      final String material,
      final String thick,
      final BigDecimal width,
      final BigDecimal length,
      final BigDecimal totalLength,
      final Integer quantity,
      final Integer schedulingQuantity,
      final Integer needQuantity,
      final BigDecimal weight,
      final BigDecimal totalWeight,
      final BigDecimal area,
      final BigDecimal totalArea,
      final Long workshopId,
      final List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList,
      final String userName,
      final String schedulingDate,
      final String jobName,
      final Integer totalSchedulingQuantity,
      final BigDecimal totalNeedWeight,
      final Integer isRectangle,
      final String specification,
      final String specificationAndMaterial,
      final LocalDateTime askCompleteTime,
      final Boolean boolSendDirectly
   ) {
      this.id = id;
      this.taskNeedMachinePartSchedulingIds = taskNeedMachinePartSchedulingIds;
      this.issuedToNestingSoftwareStatus = issuedToNestingSoftwareStatus;
      this.project = project;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.productId = productId;
      this.orderId = orderId;
      this.teamId = teamId;
      this.orderNumber = orderNumber;
      this.partId = partId;
      this.partTypeId = partTypeId;
      this.partType = partType;
      this.partSource = partSource;
      this.picturePath = picturePath;
      this.drwaingId = drwaingId;
      this.serialNumber = serialNumber;
      this.material = material;
      this.thick = thick;
      this.width = width;
      this.length = length;
      this.totalLength = totalLength;
      this.quantity = quantity;
      this.schedulingQuantity = schedulingQuantity;
      this.needQuantity = needQuantity;
      this.weight = weight;
      this.totalWeight = totalWeight;
      this.area = area;
      this.totalArea = totalArea;
      this.workshopId = workshopId;
      this.needMachinePartLinkList = needMachinePartLinkList;
      this.userName = userName;
      this.schedulingDate = schedulingDate;
      this.jobName = jobName;
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalNeedWeight = totalNeedWeight;
      this.isRectangle = isRectangle;
      this.specification = specification;
      this.specificationAndMaterial = specificationAndMaterial;
      this.askCompleteTime = askCompleteTime;
      this.boolSendDirectly = boolSendDirectly;
   }

   public static class MachinePartNestingDetailDTOBuilder {
      private Long id;
      private String taskNeedMachinePartSchedulingIds;
      private Integer issuedToNestingSoftwareStatus;
      private ProjectInfo project;
      private Long monomerId;
      private String monomerName;
      private Long productId;
      private Long orderId;
      private Long teamId;
      private String orderNumber;
      private Long partId;
      private Long partTypeId;
      private String partType;
      private String partSource;
      private String picturePath;
      private Long drwaingId;
      private String serialNumber;
      private String material;
      private String thick;
      private BigDecimal width;
      private BigDecimal length;
      private BigDecimal totalLength;
      private Integer quantity;
      private Integer schedulingQuantity;
      private Integer needQuantity;
      private BigDecimal weight;
      private BigDecimal totalWeight;
      private BigDecimal area;
      private BigDecimal totalArea;
      private Long workshopId;
      private List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList;
      private String userName;
      private String schedulingDate;
      private String jobName;
      private Integer totalSchedulingQuantity;
      private BigDecimal totalNeedWeight;
      private Integer isRectangle;
      private String specification;
      private String specificationAndMaterial;
      private LocalDateTime askCompleteTime;
      private Boolean boolSendDirectly;

      MachinePartNestingDetailDTOBuilder() {
      }

      @JsonProperty("id")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder taskNeedMachinePartSchedulingIds(final String taskNeedMachinePartSchedulingIds) {
         this.taskNeedMachinePartSchedulingIds = taskNeedMachinePartSchedulingIds;
         return this;
      }

      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder issuedToNestingSoftwareStatus(final Integer issuedToNestingSoftwareStatus) {
         this.issuedToNestingSoftwareStatus = issuedToNestingSoftwareStatus;
         return this;
      }

      @JsonProperty("project")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      @JsonProperty("monomerId")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("monomerName")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("productId")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("orderId")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      @JsonProperty("teamId")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("orderNumber")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("partId")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder partId(final Long partId) {
         this.partId = partId;
         return this;
      }

      @JsonProperty("partTypeId")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder partTypeId(final Long partTypeId) {
         this.partTypeId = partTypeId;
         return this;
      }

      @JsonProperty("partType")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder partType(final String partType) {
         this.partType = partType;
         return this;
      }

      @JsonProperty("partSource")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder partSource(final String partSource) {
         this.partSource = partSource;
         return this;
      }

      @JsonProperty("picturePath")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      @JsonProperty("drwaingId")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder drwaingId(final Long drwaingId) {
         this.drwaingId = drwaingId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("material")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("thick")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("width")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("length")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("quantity")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("needQuantity")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder needQuantity(final Integer needQuantity) {
         this.needQuantity = needQuantity;
         return this;
      }

      @JsonProperty("weight")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("area")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder area(final BigDecimal area) {
         this.area = area;
         return this;
      }

      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("workshopId")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("needMachinePartLinkList")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder needMachinePartLinkList(
         final List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList
      ) {
         this.needMachinePartLinkList = needMachinePartLinkList;
         return this;
      }

      @JsonProperty("userName")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("schedulingDate")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder schedulingDate(final String schedulingDate) {
         this.schedulingDate = schedulingDate;
         return this;
      }

      @JsonProperty("jobName")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder jobName(final String jobName) {
         this.jobName = jobName;
         return this;
      }

      @JsonProperty("totalSchedulingQuantity")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder totalSchedulingQuantity(final Integer totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalNeedWeight")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder totalNeedWeight(final BigDecimal totalNeedWeight) {
         this.totalNeedWeight = totalNeedWeight;
         return this;
      }

      @JsonProperty("isRectangle")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder isRectangle(final Integer isRectangle) {
         this.isRectangle = isRectangle;
         return this;
      }

      @JsonProperty("specification")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("specificationAndMaterial")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder specificationAndMaterial(final String specificationAndMaterial) {
         this.specificationAndMaterial = specificationAndMaterial;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public MachinePartNestingDetailDTO build() {
         return new MachinePartNestingDetailDTO(
            this.id,
            this.taskNeedMachinePartSchedulingIds,
            this.issuedToNestingSoftwareStatus,
            this.project,
            this.monomerId,
            this.monomerName,
            this.productId,
            this.orderId,
            this.teamId,
            this.orderNumber,
            this.partId,
            this.partTypeId,
            this.partType,
            this.partSource,
            this.picturePath,
            this.drwaingId,
            this.serialNumber,
            this.material,
            this.thick,
            this.width,
            this.length,
            this.totalLength,
            this.quantity,
            this.schedulingQuantity,
            this.needQuantity,
            this.weight,
            this.totalWeight,
            this.area,
            this.totalArea,
            this.workshopId,
            this.needMachinePartLinkList,
            this.userName,
            this.schedulingDate,
            this.jobName,
            this.totalSchedulingQuantity,
            this.totalNeedWeight,
            this.isRectangle,
            this.specification,
            this.specificationAndMaterial,
            this.askCompleteTime,
            this.boolSendDirectly
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingDetailDTO.MachinePartNestingDetailDTOBuilder(id="
            + this.id
            + ", taskNeedMachinePartSchedulingIds="
            + this.taskNeedMachinePartSchedulingIds
            + ", issuedToNestingSoftwareStatus="
            + this.issuedToNestingSoftwareStatus
            + ", project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", productId="
            + this.productId
            + ", orderId="
            + this.orderId
            + ", teamId="
            + this.teamId
            + ", orderNumber="
            + this.orderNumber
            + ", partId="
            + this.partId
            + ", partTypeId="
            + this.partTypeId
            + ", partType="
            + this.partType
            + ", partSource="
            + this.partSource
            + ", picturePath="
            + this.picturePath
            + ", drwaingId="
            + this.drwaingId
            + ", serialNumber="
            + this.serialNumber
            + ", material="
            + this.material
            + ", thick="
            + this.thick
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", totalLength="
            + this.totalLength
            + ", quantity="
            + this.quantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", needQuantity="
            + this.needQuantity
            + ", weight="
            + this.weight
            + ", totalWeight="
            + this.totalWeight
            + ", area="
            + this.area
            + ", totalArea="
            + this.totalArea
            + ", workshopId="
            + this.workshopId
            + ", needMachinePartLinkList="
            + this.needMachinePartLinkList
            + ", userName="
            + this.userName
            + ", schedulingDate="
            + this.schedulingDate
            + ", jobName="
            + this.jobName
            + ", totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalNeedWeight="
            + this.totalNeedWeight
            + ", isRectangle="
            + this.isRectangle
            + ", specification="
            + this.specification
            + ", specificationAndMaterial="
            + this.specificationAndMaterial
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ")";
      }
   }
}
