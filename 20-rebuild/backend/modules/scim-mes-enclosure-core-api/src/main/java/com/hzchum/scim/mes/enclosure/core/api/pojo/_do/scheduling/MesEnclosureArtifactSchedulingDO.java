package com.hzchum.scim.mes.enclosure.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.AreaDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.MonomerDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.WorkshopDetailDO;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "MesEnclosureArtifactSchedulingDO", description = "构件信息")
public class MesEnclosureArtifactSchedulingDO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productId", value = "构件id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   private Long productId;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "area", value = "区域信息")
   @JsonProperty("area")
   @JSONField(name = "area")
   private AreaDetailDO area;
   @ApiModelProperty(name = "monomer", value = "单体信息")
   @JsonProperty("monomer")
   @JSONField(name = "monomer")
   private MonomerDetailDO monomer;
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "workshop", value = "车间信息")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线信息")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", value = "生产组信息")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "schedulingQuantity", value = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "schedulingTotalGrossWeight", value = "排产总毛重（kg）")
   @JsonProperty("schedulingTotalGrossWeight")
   @JSONField(name = "schedulingTotalGrossWeight")
   private BigDecimal schedulingTotalGrossWeight;
   @ApiModelProperty(name = "schedulingTotalNetWeight", value = "排产总净重（kg）")
   @JsonProperty("schedulingTotalNetWeight")
   @JSONField(name = "schedulingTotalNetWeight")
   private BigDecimal schedulingTotalNetWeight;
   @ApiModelProperty(name = "unSchedulingQuantity", value = "未排产数量")
   @JsonProperty("unSchedulingQuantity")
   @JSONField(name = "unSchedulingQuantity")
   private Integer unSchedulingQuantity;
   @ApiModelProperty(name = "unSchedulingTotalGrossWeight", value = "未排产总毛重（kg）")
   @JsonProperty("unSchedulingTotalGrossWeight")
   @JSONField(name = "unSchedulingTotalGrossWeight")
   private BigDecimal unSchedulingTotalGrossWeight;
   @ApiModelProperty(name = "unSchedulingTotalNetWeight", value = "未排产总净重（kg）")
   @JsonProperty("unSchedulingTotalNetWeight")
   @JSONField(name = "unSchedulingTotalNetWeight")
   private BigDecimal unSchedulingTotalNetWeight;
   @ApiModelProperty(name = "smartLineMarkWord", value = "智能生产线标记词")
   @JsonProperty("smartLineMarkWord")
   @JSONField(name = "smartLineMarkWord")
   private String smartLineMarkWord;
   @ApiModelProperty(name = "artifactType", value = "构件类型 1普通构件 2次构件")
   @JsonProperty("artifactType")
   @JSONField(name = "artifactType")
   private Integer artifactType;
   @ApiModelProperty(name = "structureClassId", value = "构件种类表id")
   @JsonProperty("structureClassId")
   @JSONField(name = "structureClassId")
   private Long structureClassId;
   @ApiModelProperty(name = "structureClass", value = "构件种类表")
   @JsonProperty("structureClass")
   @JSONField(name = "structureClass")
   private IdAndNameDO structureClass;
   @ApiModelProperty(name = "askCompleteTime", value = "要求完成日期", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty("构件产品序列号集合")
   private List<Integer> numbers;
   @ApiModelProperty("构件产品序列号和图号")
   private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;

   public static MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder builder() {
      return new MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder();
   }

   public MesEnclosureArtifactSchedulingDO(
      final Long id,
      final Long productId,
      final String name,
      final AreaDetailDO area,
      final MonomerDetailDO monomer,
      final ProjectDetailDO project,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final Integer schedulingQuantity,
      final BigDecimal schedulingTotalGrossWeight,
      final BigDecimal schedulingTotalNetWeight,
      final Integer unSchedulingQuantity,
      final BigDecimal unSchedulingTotalGrossWeight,
      final BigDecimal unSchedulingTotalNetWeight,
      final String smartLineMarkWord,
      final Integer artifactType,
      final Long structureClassId,
      final IdAndNameDO structureClass,
      final LocalDateTime askCompleteTime,
      final List<Integer> numbers,
      final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber
   ) {
      this.id = id;
      this.productId = productId;
      this.name = name;
      this.area = area;
      this.monomer = monomer;
      this.project = project;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.schedulingQuantity = schedulingQuantity;
      this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      this.unSchedulingQuantity = unSchedulingQuantity;
      this.unSchedulingTotalGrossWeight = unSchedulingTotalGrossWeight;
      this.unSchedulingTotalNetWeight = unSchedulingTotalNetWeight;
      this.smartLineMarkWord = smartLineMarkWord;
      this.artifactType = artifactType;
      this.structureClassId = structureClassId;
      this.structureClass = structureClass;
      this.askCompleteTime = askCompleteTime;
      this.numbers = numbers;
      this.drawingAndSerialNumber = drawingAndSerialNumber;
   }

   public MesEnclosureArtifactSchedulingDO() {
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getName() {
      return this.name;
   }

   public AreaDetailDO getArea() {
      return this.area;
   }

   public MonomerDetailDO getMonomer() {
      return this.monomer;
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
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

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public BigDecimal getSchedulingTotalGrossWeight() {
      return this.schedulingTotalGrossWeight;
   }

   public BigDecimal getSchedulingTotalNetWeight() {
      return this.schedulingTotalNetWeight;
   }

   public Integer getUnSchedulingQuantity() {
      return this.unSchedulingQuantity;
   }

   public BigDecimal getUnSchedulingTotalGrossWeight() {
      return this.unSchedulingTotalGrossWeight;
   }

   public BigDecimal getUnSchedulingTotalNetWeight() {
      return this.unSchedulingTotalNetWeight;
   }

   public String getSmartLineMarkWord() {
      return this.smartLineMarkWord;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public IdAndNameDO getStructureClass() {
      return this.structureClass;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public List<Integer> getNumbers() {
      return this.numbers;
   }

   public List<DrawingAndSerialNumberDTO> getDrawingAndSerialNumber() {
      return this.drawingAndSerialNumber;
   }

   @JsonProperty("id")
   public MesEnclosureArtifactSchedulingDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productId")
   public MesEnclosureArtifactSchedulingDO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureArtifactSchedulingDO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("area")
   public MesEnclosureArtifactSchedulingDO setArea(final AreaDetailDO area) {
      this.area = area;
      return this;
   }

   @JsonProperty("monomer")
   public MesEnclosureArtifactSchedulingDO setMonomer(final MonomerDetailDO monomer) {
      this.monomer = monomer;
      return this;
   }

   @JsonProperty("project")
   public MesEnclosureArtifactSchedulingDO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("workshop")
   public MesEnclosureArtifactSchedulingDO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesEnclosureArtifactSchedulingDO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public MesEnclosureArtifactSchedulingDO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureArtifactSchedulingDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesEnclosureArtifactSchedulingDO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesEnclosureArtifactSchedulingDO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public MesEnclosureArtifactSchedulingDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosureArtifactSchedulingDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public MesEnclosureArtifactSchedulingDO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesEnclosureArtifactSchedulingDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesEnclosureArtifactSchedulingDO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesEnclosureArtifactSchedulingDO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public MesEnclosureArtifactSchedulingDO setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   @JsonProperty("schedulingTotalGrossWeight")
   public MesEnclosureArtifactSchedulingDO setSchedulingTotalGrossWeight(final BigDecimal schedulingTotalGrossWeight) {
      this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
      return this;
   }

   @JsonProperty("schedulingTotalNetWeight")
   public MesEnclosureArtifactSchedulingDO setSchedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      return this;
   }

   @JsonProperty("unSchedulingQuantity")
   public MesEnclosureArtifactSchedulingDO setUnSchedulingQuantity(final Integer unSchedulingQuantity) {
      this.unSchedulingQuantity = unSchedulingQuantity;
      return this;
   }

   @JsonProperty("unSchedulingTotalGrossWeight")
   public MesEnclosureArtifactSchedulingDO setUnSchedulingTotalGrossWeight(final BigDecimal unSchedulingTotalGrossWeight) {
      this.unSchedulingTotalGrossWeight = unSchedulingTotalGrossWeight;
      return this;
   }

   @JsonProperty("unSchedulingTotalNetWeight")
   public MesEnclosureArtifactSchedulingDO setUnSchedulingTotalNetWeight(final BigDecimal unSchedulingTotalNetWeight) {
      this.unSchedulingTotalNetWeight = unSchedulingTotalNetWeight;
      return this;
   }

   @JsonProperty("smartLineMarkWord")
   public MesEnclosureArtifactSchedulingDO setSmartLineMarkWord(final String smartLineMarkWord) {
      this.smartLineMarkWord = smartLineMarkWord;
      return this;
   }

   @JsonProperty("artifactType")
   public MesEnclosureArtifactSchedulingDO setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   @JsonProperty("structureClassId")
   public MesEnclosureArtifactSchedulingDO setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   @JsonProperty("structureClass")
   public MesEnclosureArtifactSchedulingDO setStructureClass(final IdAndNameDO structureClass) {
      this.structureClass = structureClass;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureArtifactSchedulingDO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   public MesEnclosureArtifactSchedulingDO setNumbers(final List<Integer> numbers) {
      this.numbers = numbers;
      return this;
   }

   public MesEnclosureArtifactSchedulingDO setDrawingAndSerialNumber(final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber) {
      this.drawingAndSerialNumber = drawingAndSerialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureArtifactSchedulingDO(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", name="
         + this.getName()
         + ", area="
         + this.getArea()
         + ", monomer="
         + this.getMonomer()
         + ", project="
         + this.getProject()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
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
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", schedulingTotalGrossWeight="
         + this.getSchedulingTotalGrossWeight()
         + ", schedulingTotalNetWeight="
         + this.getSchedulingTotalNetWeight()
         + ", unSchedulingQuantity="
         + this.getUnSchedulingQuantity()
         + ", unSchedulingTotalGrossWeight="
         + this.getUnSchedulingTotalGrossWeight()
         + ", unSchedulingTotalNetWeight="
         + this.getUnSchedulingTotalNetWeight()
         + ", smartLineMarkWord="
         + this.getSmartLineMarkWord()
         + ", artifactType="
         + this.getArtifactType()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", structureClass="
         + this.getStructureClass()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
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

      if (!(o instanceof MesEnclosureArtifactSchedulingDO)) {
         return false;
      }

      MesEnclosureArtifactSchedulingDO other = (MesEnclosureArtifactSchedulingDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$schedulingQuantity = this.getSchedulingQuantity();
               Object other$schedulingQuantity = other.getSchedulingQuantity();
               if (this$schedulingQuantity == null ? other$schedulingQuantity == null : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                  Object this$unSchedulingQuantity = this.getUnSchedulingQuantity();
                  Object other$unSchedulingQuantity = other.getUnSchedulingQuantity();
                  if (this$unSchedulingQuantity == null ? other$unSchedulingQuantity == null : this$unSchedulingQuantity.equals(other$unSchedulingQuantity)) {
                     Object this$artifactType = this.getArtifactType();
                     Object other$artifactType = other.getArtifactType();
                     if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                        Object this$structureClassId = this.getStructureClassId();
                        Object other$structureClassId = other.getStructureClassId();
                        if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$area = this.getArea();
                              Object other$area = other.getArea();
                              if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                 Object this$monomer = this.getMonomer();
                                 Object other$monomer = other.getMonomer();
                                 if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                    Object this$project = this.getProject();
                                    Object other$project = other.getProject();
                                    if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                       Object this$workshop = this.getWorkshop();
                                       Object other$workshop = other.getWorkshop();
                                       if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                          Object this$productionLine = this.getProductionLine();
                                          Object other$productionLine = other.getProductionLine();
                                          if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                             Object this$groups = this.getGroups();
                                             Object other$groups = other.getGroups();
                                             if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
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
                                                                        Object this$schedulingTotalGrossWeight = this.getSchedulingTotalGrossWeight();
                                                                        Object other$schedulingTotalGrossWeight = other.getSchedulingTotalGrossWeight();
                                                                        if (this$schedulingTotalGrossWeight == null
                                                                           ? other$schedulingTotalGrossWeight == null
                                                                           : this$schedulingTotalGrossWeight.equals(other$schedulingTotalGrossWeight)) {
                                                                           Object this$schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
                                                                           Object other$schedulingTotalNetWeight = other.getSchedulingTotalNetWeight();
                                                                           if (this$schedulingTotalNetWeight == null
                                                                              ? other$schedulingTotalNetWeight == null
                                                                              : this$schedulingTotalNetWeight.equals(other$schedulingTotalNetWeight)) {
                                                                              Object this$unSchedulingTotalGrossWeight = this.getUnSchedulingTotalGrossWeight();
                                                                              Object other$unSchedulingTotalGrossWeight = other.getUnSchedulingTotalGrossWeight();
                                                                              if (this$unSchedulingTotalGrossWeight == null
                                                                                 ? other$unSchedulingTotalGrossWeight == null
                                                                                 : this$unSchedulingTotalGrossWeight.equals(other$unSchedulingTotalGrossWeight)
                                                                                 )
                                                                               {
                                                                                 Object this$unSchedulingTotalNetWeight = this.getUnSchedulingTotalNetWeight();
                                                                                 Object other$unSchedulingTotalNetWeight = other.getUnSchedulingTotalNetWeight();
                                                                                 if (this$unSchedulingTotalNetWeight == null
                                                                                    ? other$unSchedulingTotalNetWeight == null
                                                                                    : this$unSchedulingTotalNetWeight.equals(other$unSchedulingTotalNetWeight)) {
                                                                                    Object this$smartLineMarkWord = this.getSmartLineMarkWord();
                                                                                    Object other$smartLineMarkWord = other.getSmartLineMarkWord();
                                                                                    if (this$smartLineMarkWord == null
                                                                                       ? other$smartLineMarkWord == null
                                                                                       : this$smartLineMarkWord.equals(other$smartLineMarkWord)) {
                                                                                       Object this$structureClass = this.getStructureClass();
                                                                                       Object other$structureClass = other.getStructureClass();
                                                                                       if (this$structureClass == null
                                                                                          ? other$structureClass == null
                                                                                          : this$structureClass.equals(other$structureClass)) {
                                                                                          Object this$askCompleteTime = this.getAskCompleteTime();
                                                                                          Object other$askCompleteTime = other.getAskCompleteTime();
                                                                                          if (this$askCompleteTime == null
                                                                                             ? other$askCompleteTime == null
                                                                                             : this$askCompleteTime.equals(other$askCompleteTime)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureArtifactSchedulingDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $unSchedulingQuantity = this.getUnSchedulingQuantity();
      result = result * 59 + ($unSchedulingQuantity == null ? 43 : $unSchedulingQuantity.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
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
      Object $schedulingTotalGrossWeight = this.getSchedulingTotalGrossWeight();
      result = result * 59 + ($schedulingTotalGrossWeight == null ? 43 : $schedulingTotalGrossWeight.hashCode());
      Object $schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
      result = result * 59 + ($schedulingTotalNetWeight == null ? 43 : $schedulingTotalNetWeight.hashCode());
      Object $unSchedulingTotalGrossWeight = this.getUnSchedulingTotalGrossWeight();
      result = result * 59 + ($unSchedulingTotalGrossWeight == null ? 43 : $unSchedulingTotalGrossWeight.hashCode());
      Object $unSchedulingTotalNetWeight = this.getUnSchedulingTotalNetWeight();
      result = result * 59 + ($unSchedulingTotalNetWeight == null ? 43 : $unSchedulingTotalNetWeight.hashCode());
      Object $smartLineMarkWord = this.getSmartLineMarkWord();
      result = result * 59 + ($smartLineMarkWord == null ? 43 : $smartLineMarkWord.hashCode());
      Object $structureClass = this.getStructureClass();
      result = result * 59 + ($structureClass == null ? 43 : $structureClass.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $drawingAndSerialNumber = this.getDrawingAndSerialNumber();
      return result * 59 + ($drawingAndSerialNumber == null ? 43 : $drawingAndSerialNumber.hashCode());
   }

   public static class MesEnclosureArtifactSchedulingDOBuilder {
      private Long id;
      private Long productId;
      private String name;
      private AreaDetailDO area;
      private MonomerDetailDO monomer;
      private ProjectDetailDO project;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private Integer schedulingQuantity;
      private BigDecimal schedulingTotalGrossWeight;
      private BigDecimal schedulingTotalNetWeight;
      private Integer unSchedulingQuantity;
      private BigDecimal unSchedulingTotalGrossWeight;
      private BigDecimal unSchedulingTotalNetWeight;
      private String smartLineMarkWord;
      private Integer artifactType;
      private Long structureClassId;
      private IdAndNameDO structureClass;
      private LocalDateTime askCompleteTime;
      private List<Integer> numbers;
      private List<DrawingAndSerialNumberDTO> drawingAndSerialNumber;

      MesEnclosureArtifactSchedulingDOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productId")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("area")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder area(final AreaDetailDO area) {
         this.area = area;
         return this;
      }

      @JsonProperty("monomer")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder monomer(final MonomerDetailDO monomer) {
         this.monomer = monomer;
         return this;
      }

      @JsonProperty("project")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("workshop")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      @JsonProperty("schedulingTotalGrossWeight")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder schedulingTotalGrossWeight(final BigDecimal schedulingTotalGrossWeight) {
         this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
         return this;
      }

      @JsonProperty("schedulingTotalNetWeight")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder schedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
         this.schedulingTotalNetWeight = schedulingTotalNetWeight;
         return this;
      }

      @JsonProperty("unSchedulingQuantity")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder unSchedulingQuantity(final Integer unSchedulingQuantity) {
         this.unSchedulingQuantity = unSchedulingQuantity;
         return this;
      }

      @JsonProperty("unSchedulingTotalGrossWeight")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder unSchedulingTotalGrossWeight(
         final BigDecimal unSchedulingTotalGrossWeight
      ) {
         this.unSchedulingTotalGrossWeight = unSchedulingTotalGrossWeight;
         return this;
      }

      @JsonProperty("unSchedulingTotalNetWeight")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder unSchedulingTotalNetWeight(final BigDecimal unSchedulingTotalNetWeight) {
         this.unSchedulingTotalNetWeight = unSchedulingTotalNetWeight;
         return this;
      }

      @JsonProperty("smartLineMarkWord")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder smartLineMarkWord(final String smartLineMarkWord) {
         this.smartLineMarkWord = smartLineMarkWord;
         return this;
      }

      @JsonProperty("artifactType")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      @JsonProperty("structureClassId")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      @JsonProperty("structureClass")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder structureClass(final IdAndNameDO structureClass) {
         this.structureClass = structureClass;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder numbers(final List<Integer> numbers) {
         this.numbers = numbers;
         return this;
      }

      public MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder drawingAndSerialNumber(
         final List<DrawingAndSerialNumberDTO> drawingAndSerialNumber
      ) {
         this.drawingAndSerialNumber = drawingAndSerialNumber;
         return this;
      }

      public MesEnclosureArtifactSchedulingDO build() {
         return new MesEnclosureArtifactSchedulingDO(
            this.id,
            this.productId,
            this.name,
            this.area,
            this.monomer,
            this.project,
            this.workshop,
            this.productionLine,
            this.groups,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.schedulingQuantity,
            this.schedulingTotalGrossWeight,
            this.schedulingTotalNetWeight,
            this.unSchedulingQuantity,
            this.unSchedulingTotalGrossWeight,
            this.unSchedulingTotalNetWeight,
            this.smartLineMarkWord,
            this.artifactType,
            this.structureClassId,
            this.structureClass,
            this.askCompleteTime,
            this.numbers,
            this.drawingAndSerialNumber
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureArtifactSchedulingDO.MesEnclosureArtifactSchedulingDOBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", name="
            + this.name
            + ", area="
            + this.area
            + ", monomer="
            + this.monomer
            + ", project="
            + this.project
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
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
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", schedulingTotalGrossWeight="
            + this.schedulingTotalGrossWeight
            + ", schedulingTotalNetWeight="
            + this.schedulingTotalNetWeight
            + ", unSchedulingQuantity="
            + this.unSchedulingQuantity
            + ", unSchedulingTotalGrossWeight="
            + this.unSchedulingTotalGrossWeight
            + ", unSchedulingTotalNetWeight="
            + this.unSchedulingTotalNetWeight
            + ", smartLineMarkWord="
            + this.smartLineMarkWord
            + ", artifactType="
            + this.artifactType
            + ", structureClassId="
            + this.structureClassId
            + ", structureClass="
            + this.structureClass
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", numbers="
            + this.numbers
            + ", drawingAndSerialNumber="
            + this.drawingAndSerialNumber
            + ")";
      }
   }
}
