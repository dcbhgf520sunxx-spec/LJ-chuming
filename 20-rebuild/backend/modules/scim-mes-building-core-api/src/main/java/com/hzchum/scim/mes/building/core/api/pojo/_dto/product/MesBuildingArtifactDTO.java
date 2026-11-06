package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingSchedulingProductionLineDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "MesBuildingArtifactDTO对象", description = "构件  ")
public class MesBuildingArtifactDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
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
   @ApiModelProperty(name = "boolStatusEnum", notes = "状态 0暂停1进行中")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "serialNumber", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", notes = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", notes = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", notes = "面积（㎡）")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "drawingNumber", notes = "图号")
   @JsonProperty("drawingNumber")
   @JSONField(name = "drawingNumber")
   private String drawingNumber;
   @ApiModelProperty(name = "remark", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "businessId", notes = "商务id")
   @JsonProperty("businessId")
   @JSONField(name = "businessId")
   private Long businessId;
   @ApiModelProperty(name = "assembleId", notes = "组立id")
   @JsonProperty("assembleId")
   @JSONField(name = "assembleId")
   private Long assembleId;
   @ApiModelProperty(name = "assembleSerialNumber", notes = "组立号")
   @JsonProperty("assembleSerialNumber")
   @JSONField(name = "assembleSerialNumber")
   private String assembleSerialNumber;
   @ApiModelProperty(name = "producedQuantity", notes = "已生产")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   private Integer producedQuantity;
   @ApiModelProperty(name = "totalSchedulingQuantity", notes = "排产总数量")
   @JsonProperty("totalSchedulingQuantity")
   @JSONField(name = "totalSchedulingQuantity")
   private Integer totalSchedulingQuantity;
   @ApiModelProperty(name = "totalTaskQuantity", notes = "已下发总数量")
   @JsonProperty("totalTaskQuantity")
   @JSONField(name = "totalTaskQuantity")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "schedulingProductionLineDTOS", notes = "分配的生产线详情")
   @JsonProperty("schedulingProductionLineDTOS")
   @JSONField(name = "schedulingProductionLineDTOS")
   private List<MesBuildingSchedulingProductionLineDO> schedulingProductionLineDTOS;
   @ApiModelProperty(name = "projectName", value = "项目名")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "monomerName", value = "单体名")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   private String monomerName;
   @ApiModelProperty(name = "areaName", value = "区域名")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   private String areaName;
   @ApiModelProperty(name = "packageQuantity", value = "打包数量")
   @JsonProperty("packageQuantity")
   @JSONField(name = "packageQuantity")
   private Integer packageQuantity;
   @ApiModelProperty(name = "unPackageQuantity", value = "未打包数量")
   @JsonProperty("unPackageQuantity")
   @JSONField(name = "unPackageQuantity")
   private Integer unPackageQuantity;
   @ApiModelProperty(name = "boolAbnormalEnum", notes = "是否异常")
   @JsonProperty("boolAbnormalEnum")
   @JSONField(name = "boolAbnormalEnum")
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "numbers", notes = "构件序列号")
   @JsonProperty("numbers")
   @JSONField(name = "numbers")
   private List<Integer> numbers;
   @ApiModelProperty("构件产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;

   public static MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder builder() {
      return new MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder();
   }

   public MesBuildingArtifactDTO() {
   }

   public MesBuildingArtifactDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Boolean boolStatusEnum,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final String drawingNumber,
      final String remark,
      final Long businessId,
      final Long assembleId,
      final String assembleSerialNumber,
      final Integer producedQuantity,
      final Integer totalSchedulingQuantity,
      final Integer totalTaskQuantity,
      final List<MesBuildingSchedulingProductionLineDO> schedulingProductionLineDTOS,
      final String projectName,
      final String monomerName,
      final String areaName,
      final Integer packageQuantity,
      final Integer unPackageQuantity,
      final Boolean boolAbnormalEnum,
      final List<Integer> numbers,
      final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.boolStatusEnum = boolStatusEnum;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.drawingNumber = drawingNumber;
      this.remark = remark;
      this.businessId = businessId;
      this.assembleId = assembleId;
      this.assembleSerialNumber = assembleSerialNumber;
      this.producedQuantity = producedQuantity;
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalTaskQuantity = totalTaskQuantity;
      this.schedulingProductionLineDTOS = schedulingProductionLineDTOS;
      this.projectName = projectName;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.packageQuantity = packageQuantity;
      this.unPackageQuantity = unPackageQuantity;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.numbers = numbers;
      this.drawingAndSerialNumber = drawingAndSerialNumber;
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

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public String getName() {
      return this.name;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Long getAssembleId() {
      return this.assembleId;
   }

   public String getAssembleSerialNumber() {
      return this.assembleSerialNumber;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public List<MesBuildingSchedulingProductionLineDO> getSchedulingProductionLineDTOS() {
      return this.schedulingProductionLineDTOS;
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

   public Integer getPackageQuantity() {
      return this.packageQuantity;
   }

   public Integer getUnPackageQuantity() {
      return this.unPackageQuantity;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   @JsonProperty("id")
   public MesBuildingArtifactDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingArtifactDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingArtifactDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingArtifactDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public MesBuildingArtifactDTO setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingArtifactDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingArtifactDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingArtifactDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingArtifactDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingArtifactDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingArtifactDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingArtifactDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingArtifactDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesBuildingArtifactDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesBuildingArtifactDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("surfaceArea")
   public MesBuildingArtifactDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("drawingNumber")
   public MesBuildingArtifactDTO setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("remark")
   public MesBuildingArtifactDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("businessId")
   public MesBuildingArtifactDTO setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   @JsonProperty("assembleId")
   public MesBuildingArtifactDTO setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
      return this;
   }

   @JsonProperty("assembleSerialNumber")
   public MesBuildingArtifactDTO setAssembleSerialNumber(final String assembleSerialNumber) {
      this.assembleSerialNumber = assembleSerialNumber;
      return this;
   }

   @JsonProperty("producedQuantity")
   public MesBuildingArtifactDTO setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("totalSchedulingQuantity")
   public MesBuildingArtifactDTO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalTaskQuantity")
   public MesBuildingArtifactDTO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @JsonProperty("schedulingProductionLineDTOS")
   public MesBuildingArtifactDTO setSchedulingProductionLineDTOS(final List<MesBuildingSchedulingProductionLineDO> schedulingProductionLineDTOS) {
      this.schedulingProductionLineDTOS = schedulingProductionLineDTOS;
      return this;
   }

   @JsonProperty("projectName")
   public MesBuildingArtifactDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   @JsonProperty("monomerName")
   public MesBuildingArtifactDTO setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @JsonProperty("areaName")
   public MesBuildingArtifactDTO setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("packageQuantity")
   public MesBuildingArtifactDTO setPackageQuantity(final Integer packageQuantity) {
      this.packageQuantity = packageQuantity;
      return this;
   }

   @JsonProperty("unPackageQuantity")
   public MesBuildingArtifactDTO setUnPackageQuantity(final Integer unPackageQuantity) {
      this.unPackageQuantity = unPackageQuantity;
      return this;
   }

   @JsonProperty("boolAbnormalEnum")
   public MesBuildingArtifactDTO setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   @JsonProperty("numbers")
   public MesBuildingArtifactDTO setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
      return this;
   }

   public MesBuildingArtifactDTO setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", name="
         + this.getName()
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
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", remark="
         + this.getRemark()
         + ", businessId="
         + this.getBusinessId()
         + ", assembleId="
         + this.getAssembleId()
         + ", assembleSerialNumber="
         + this.getAssembleSerialNumber()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", schedulingProductionLineDTOS="
         + this.getSchedulingProductionLineDTOS()
         + ", projectName="
         + this.getProjectName()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", packageQuantity="
         + this.getPackageQuantity()
         + ", unPackageQuantity="
         + this.getUnPackageQuantity()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", numbers="
         + this.getNumbers()
         + ", drawingAndSerialNumber="
         + this.getDrawingAndSerialNumber()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactDTO)) {
         return false;
      }

      MesBuildingArtifactDTO other = (MesBuildingArtifactDTO)o;
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
                  Object this$boolStatusEnum = this.getBoolStatusEnum();
                  Object other$boolStatusEnum = other.getBoolStatusEnum();
                  if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                     Object this$quantity = this.getQuantity();
                     Object other$quantity = other.getQuantity();
                     if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                        Object this$businessId = this.getBusinessId();
                        Object other$businessId = other.getBusinessId();
                        if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                           Object this$assembleId = this.getAssembleId();
                           Object other$assembleId = other.getAssembleId();
                           if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
                              Object this$producedQuantity = this.getProducedQuantity();
                              Object other$producedQuantity = other.getProducedQuantity();
                              if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                                 Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
                                 Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
                                 if (this$totalSchedulingQuantity == null
                                    ? other$totalSchedulingQuantity == null
                                    : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
                                    Object this$totalTaskQuantity = this.getTotalTaskQuantity();
                                    Object other$totalTaskQuantity = other.getTotalTaskQuantity();
                                    if (this$totalTaskQuantity == null
                                       ? other$totalTaskQuantity == null
                                       : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
                                       Object this$packageQuantity = this.getPackageQuantity();
                                       Object other$packageQuantity = other.getPackageQuantity();
                                       if (this$packageQuantity == null ? other$packageQuantity == null : this$packageQuantity.equals(other$packageQuantity)) {
                                          Object this$unPackageQuantity = this.getUnPackageQuantity();
                                          Object other$unPackageQuantity = other.getUnPackageQuantity();
                                          if (this$unPackageQuantity == null
                                             ? other$unPackageQuantity == null
                                             : this$unPackageQuantity.equals(other$unPackageQuantity)) {
                                             Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                                             Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                                             if (this$boolAbnormalEnum == null
                                                ? other$boolAbnormalEnum == null
                                                : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                                                Object this$name = this.getName();
                                                Object other$name = other.getName();
                                                if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                                               Object this$netWeight = this.getNetWeight();
                                                               Object other$netWeight = other.getNetWeight();
                                                               if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                                  Object this$totalNetWeight = this.getTotalNetWeight();
                                                                  Object other$totalNetWeight = other.getTotalNetWeight();
                                                                  if (this$totalNetWeight == null
                                                                     ? other$totalNetWeight == null
                                                                     : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                     Object this$grossWeight = this.getGrossWeight();
                                                                     Object other$grossWeight = other.getGrossWeight();
                                                                     if (this$grossWeight == null
                                                                        ? other$grossWeight == null
                                                                        : this$grossWeight.equals(other$grossWeight)) {
                                                                        Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                        Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                        if (this$totalGrossWeight == null
                                                                           ? other$totalGrossWeight == null
                                                                           : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                           Object this$surfaceArea = this.getSurfaceArea();
                                                                           Object other$surfaceArea = other.getSurfaceArea();
                                                                           if (this$surfaceArea == null
                                                                              ? other$surfaceArea == null
                                                                              : this$surfaceArea.equals(other$surfaceArea)) {
                                                                              Object this$drawingNumber = this.getDrawingNumber();
                                                                              Object other$drawingNumber = other.getDrawingNumber();
                                                                              if (this$drawingNumber == null
                                                                                 ? other$drawingNumber == null
                                                                                 : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                 Object this$remark = this.getRemark();
                                                                                 Object other$remark = other.getRemark();
                                                                                 if (this$remark == null
                                                                                    ? other$remark == null
                                                                                    : this$remark.equals(other$remark)) {
                                                                                    Object this$assembleSerialNumber = this.getAssembleSerialNumber();
                                                                                    Object other$assembleSerialNumber = other.getAssembleSerialNumber();
                                                                                    if (this$assembleSerialNumber == null
                                                                                       ? other$assembleSerialNumber == null
                                                                                       : this$assembleSerialNumber.equals(other$assembleSerialNumber)) {
                                                                                       Object this$schedulingProductionLineDTOS = this.getSchedulingProductionLineDTOS();
                                                                                       Object other$schedulingProductionLineDTOS = other.getSchedulingProductionLineDTOS();
                                                                                       if (this$schedulingProductionLineDTOS == null
                                                                                          ? other$schedulingProductionLineDTOS == null
                                                                                          : this$schedulingProductionLineDTOS.equals(
                                                                                             other$schedulingProductionLineDTOS
                                                                                          )) {
                                                                                          Object this$projectName = this.getProjectName();
                                                                                          Object other$projectName = other.getProjectName();
                                                                                          if (this$projectName == null
                                                                                             ? other$projectName == null
                                                                                             : this$projectName.equals(other$projectName)) {
                                                                                             Object this$monomerName = this.getMonomerName();
                                                                                             Object other$monomerName = other.getMonomerName();
                                                                                             if (this$monomerName == null
                                                                                                ? other$monomerName == null
                                                                                                : this$monomerName.equals(other$monomerName)) {
                                                                                                Object this$areaName = this.getAreaName();
                                                                                                Object other$areaName = other.getAreaName();
                                                                                                if (this$areaName == null
                                                                                                   ? other$areaName == null
                                                                                                   : this$areaName.equals(other$areaName)) {
                                                                                                   Object this$numbers = this.getNumbers();
                                                                                                   Object other$numbers = other.getNumbers();
                                                                                                   if (this$numbers == null
                                                                                                      ? other$numbers == null
                                                                                                      : this$numbers.equals(other$numbers)) {
                                                                                                      Object this$drawingAndSerialNumber = this.getDrawingAndSerialNumber();
                                                                                                      Object other$drawingAndSerialNumber = other.getDrawingAndSerialNumber();
                                                                                                      return this$drawingAndSerialNumber == null
                                                                                                         ? other$drawingAndSerialNumber == null
                                                                                                         : this$drawingAndSerialNumber.equals(
                                                                                                            other$drawingAndSerialNumber
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactDTO;
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
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $packageQuantity = this.getPackageQuantity();
      result = result * 59 + ($packageQuantity == null ? 43 : $packageQuantity.hashCode());
      Object $unPackageQuantity = this.getUnPackageQuantity();
      result = result * 59 + ($unPackageQuantity == null ? 43 : $unPackageQuantity.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $assembleSerialNumber = this.getAssembleSerialNumber();
      result = result * 59 + ($assembleSerialNumber == null ? 43 : $assembleSerialNumber.hashCode());
      Object $schedulingProductionLineDTOS = this.getSchedulingProductionLineDTOS();
      result = result * 59 + ($schedulingProductionLineDTOS == null ? 43 : $schedulingProductionLineDTOS.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      return result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
   }

   public static class MesBuildingArtifactDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Boolean boolStatusEnum;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private String drawingNumber;
      private String remark;
      private Long businessId;
      private Long assembleId;
      private String assembleSerialNumber;
      private Integer producedQuantity;
      private Integer totalSchedulingQuantity;
      private Integer totalTaskQuantity;
      private List<MesBuildingSchedulingProductionLineDO> schedulingProductionLineDTOS;
      private String projectName;
      private String monomerName;
      private String areaName;
      private Integer packageQuantity;
      private Integer unPackageQuantity;
      private Boolean boolAbnormalEnum;
      private List<Integer> numbers;
      private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;

      MesBuildingArtifactDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("surfaceArea")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("drawingNumber")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("remark")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("businessId")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      @JsonProperty("assembleId")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder assembleId(final Long assembleId) {
         this.assembleId = assembleId;
         return this;
      }

      @JsonProperty("assembleSerialNumber")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder assembleSerialNumber(final String assembleSerialNumber) {
         this.assembleSerialNumber = assembleSerialNumber;
         return this;
      }

      @JsonProperty("producedQuantity")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("totalSchedulingQuantity")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder totalSchedulingQuantity(final Integer totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalTaskQuantity")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("schedulingProductionLineDTOS")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder schedulingProductionLineDTOS(
         final List<MesBuildingSchedulingProductionLineDO> schedulingProductionLineDTOS
      ) {
         this.schedulingProductionLineDTOS = schedulingProductionLineDTOS;
         return this;
      }

      @JsonProperty("projectName")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("monomerName")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      @JsonProperty("areaName")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("packageQuantity")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder packageQuantity(final Integer packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      @JsonProperty("unPackageQuantity")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder unPackageQuantity(final Integer unPackageQuantity) {
         this.unPackageQuantity = unPackageQuantity;
         return this;
      }

      @JsonProperty("boolAbnormalEnum")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      @JsonProperty("numbers")
      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder numbers(final List<Integer> numbers) {
         this.numbers = numbers;
         return this;
      }

      public MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder drawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
         this.drawingAndSerialNumber = drawingAndSerialNumber;
         return this;
      }

      public MesBuildingArtifactDTO build() {
         return new MesBuildingArtifactDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.boolStatusEnum,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.drawingNumber,
            this.remark,
            this.businessId,
            this.assembleId,
            this.assembleSerialNumber,
            this.producedQuantity,
            this.totalSchedulingQuantity,
            this.totalTaskQuantity,
            this.schedulingProductionLineDTOS,
            this.projectName,
            this.monomerName,
            this.areaName,
            this.packageQuantity,
            this.unPackageQuantity,
            this.boolAbnormalEnum,
            this.numbers,
            this.drawingAndSerialNumber
         );
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactDTO.MesBuildingArtifactDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", name="
            + this.name
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
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", drawingNumber="
            + this.drawingNumber
            + ", remark="
            + this.remark
            + ", businessId="
            + this.businessId
            + ", assembleId="
            + this.assembleId
            + ", assembleSerialNumber="
            + this.assembleSerialNumber
            + ", producedQuantity="
            + this.producedQuantity
            + ", totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", schedulingProductionLineDTOS="
            + this.schedulingProductionLineDTOS
            + ", projectName="
            + this.projectName
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", packageQuantity="
            + this.packageQuantity
            + ", unPackageQuantity="
            + this.unPackageQuantity
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", numbers="
            + this.numbers
            + ", drawingAndSerialNumber="
            + this.drawingAndSerialNumber
            + ")";
      }
   }
}
