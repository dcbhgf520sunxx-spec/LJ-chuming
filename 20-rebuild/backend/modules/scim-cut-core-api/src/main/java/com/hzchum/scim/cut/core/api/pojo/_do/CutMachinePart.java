package com.hzchum.scim.cut.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "CutMachinePart对象", description = "零件 ")
@Entity
@TableName("cut_machine_part")
@Table(name = "cut_machine_part")
public class CutMachinePart extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "零件名称", notes = "零件名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '零件名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint  COMMENT '区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停1进行中", notes = "状态 0暂停1进行中")
   @JsonProperty("boolStatusEnum")
   @JSONField(name = "boolStatusEnum")
   @TableField("bool_status_enum")
   @Column(name = "bool_status_enum", columnDefinition = "tinyint(1) default '1' COMMENT '状态 0暂停1进行中'", nullable = true)
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "relationType", value = "关联产品类型 2 关联构件 16关联组立", notes = "关联产品类型 2 关联构件 16关联组立")
   @JsonProperty("relationType")
   @JSONField(name = "relationType")
   @TableField("relation_type")
   @Column(name = "relation_type", columnDefinition = "int  COMMENT '关联产品类型 2 关联构件 16关联组立'", nullable = true)
   private Integer relationType;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '编号'", nullable = true)
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(64)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）", notes = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,2)  COMMENT '长度（mm）'", nullable = true)
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(64) default '' COMMENT '材质'", nullable = true)
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int default '0' COMMENT '数量'", nullable = true)
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）", notes = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,8)  COMMENT '单净重（kg）'", nullable = true)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）", notes = "总净重（kg）")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight", columnDefinition = "decimal(32,8)  COMMENT '总净重（kg）'", nullable = true)
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）", notes = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   @TableField("gross_weight")
   @Column(name = "gross_weight", columnDefinition = "decimal(32,8)  COMMENT '单毛重（kg）'", nullable = true)
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）", notes = "总毛重（kg）")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   @TableField("total_gross_weight")
   @Column(name = "total_gross_weight", columnDefinition = "decimal(32,8)  COMMENT '总毛重（kg）'", nullable = true)
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "type", value = "类型 1剪板2数控", notes = "类型 1剪板2数控")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int default '4' COMMENT '类型 1剪板2数控'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "userId", value = "上传人id", notes = "上传人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint  COMMENT '上传人id'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "usedQuantity", value = "已使用量", notes = "已使用量")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   @TableField("used_quantity")
   @Column(name = "used_quantity", columnDefinition = "int default '0' COMMENT '已使用量'", nullable = true)
   private Integer usedQuantity;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量", notes = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   @TableField("produced_quantity")
   @Column(name = "produced_quantity", columnDefinition = "int default '0' COMMENT '已生产量'", nullable = true)
   private Integer producedQuantity;
   @ApiModelProperty(name = "drawingNumber", value = "图号", notes = "图号")
   @JsonProperty("drawingNumber")
   @JSONField(name = "drawingNumber")
   @TableField("drawing_number")
   @Column(name = "drawing_number", columnDefinition = "varchar(255)  COMMENT '图号'", nullable = true)
   private String drawingNumber;
   @ApiModelProperty(name = "thick", value = "厚度", notes = "厚度")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   @TableField("thick")
   @Column(name = "thick", columnDefinition = "varchar(255)  COMMENT '厚度'", nullable = true)
   private String thick;
   @ApiModelProperty(name = "path", value = "路径", notes = "路径")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField("path")
   @Column(name = "path", columnDefinition = "varchar(255)  COMMENT '路径'", nullable = true)
   private String path;
   @ApiModelProperty(name = "nestingState", value = "排套状态", notes = "排套状态")
   @JsonProperty("nestingState")
   @JSONField(name = "nestingState")
   @TableField("nesting_state")
   @Column(name = "nesting_state", columnDefinition = "int default '0' COMMENT '排套状态'", nullable = true)
   private Integer nestingState;
   @ApiModelProperty(name = "steelId")
   @JsonProperty("steelId")
   @JSONField(name = "steelId")
   @TableField("steel_id")
   @Column(name = "steel_id", columnDefinition = "bigint  COMMENT ''", nullable = true)
   private Long steelId;
   @ApiModelProperty(name = "steelSpec")
   @JsonProperty("steelSpec")
   @JSONField(name = "steelSpec")
   @TableField("steel_spec")
   @Column(name = "steel_spec", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String steelSpec;
   @ApiModelProperty(name = "areaType")
   @JsonProperty("areaType")
   @JSONField(name = "areaType")
   @TableField("area_type")
   @Column(name = "area_type", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer areaType;
   @ApiModelProperty(name = "areaName")
   @JsonProperty("areaName")
   @JSONField(name = "areaName")
   @TableField("area_name")
   @Column(name = "area_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String areaName;
   @ApiModelProperty(name = "monomerName")
   @JsonProperty("monomerName")
   @JSONField(name = "monomerName")
   @TableField("monomer_name")
   @Column(name = "monomer_name", columnDefinition = "varchar(255)  COMMENT ''", nullable = true)
   private String monomerName;

   public static CutMachinePart.CutMachinePartBuilder builder() {
      return new CutMachinePart.CutMachinePartBuilder();
   }

   public CutMachinePart() {
   }

   public CutMachinePart(
      final Long id,
      final String name,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Boolean boolStatusEnum,
      final Integer relationType,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final Integer type,
      final Long userId,
      final String remark,
      final Integer usedQuantity,
      final Integer producedQuantity,
      final String drawingNumber,
      final String thick,
      final String path,
      final Integer nestingState,
      final Long steelId,
      final String steelSpec,
      final Integer areaType,
      final String areaName,
      final String monomerName
   ) {
      this.id = id;
      this.name = name;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.boolStatusEnum = boolStatusEnum;
      this.relationType = relationType;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.type = type;
      this.userId = userId;
      this.remark = remark;
      this.usedQuantity = usedQuantity;
      this.producedQuantity = producedQuantity;
      this.drawingNumber = drawingNumber;
      this.thick = thick;
      this.path = path;
      this.nestingState = nestingState;
      this.steelId = steelId;
      this.steelSpec = steelSpec;
      this.areaType = areaType;
      this.areaName = areaName;
      this.monomerName = monomerName;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
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

   public Integer getRelationType() {
      return this.relationType;
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

   public Integer getType() {
      return this.type;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getUsedQuantity() {
      return this.usedQuantity;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public String getDrawingNumber() {
      return this.drawingNumber;
   }

   public String getThick() {
      return this.thick;
   }

   public String getPath() {
      return this.path;
   }

   public Integer getNestingState() {
      return this.nestingState;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   @JsonProperty("id")
   public CutMachinePart setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public CutMachinePart setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("projectId")
   public CutMachinePart setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public CutMachinePart setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public CutMachinePart setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("boolStatusEnum")
   public CutMachinePart setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   @JsonProperty("relationType")
   public CutMachinePart setRelationType(final Integer relationType) {
      this.relationType = relationType;
      return this;
   }

   @JsonProperty("serialNumber")
   public CutMachinePart setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public CutMachinePart setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public CutMachinePart setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("material")
   public CutMachinePart setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public CutMachinePart setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("netWeight")
   public CutMachinePart setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public CutMachinePart setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public CutMachinePart setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public CutMachinePart setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("type")
   public CutMachinePart setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("userId")
   public CutMachinePart setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("remark")
   public CutMachinePart setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("usedQuantity")
   public CutMachinePart setUsedQuantity(final Integer usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("producedQuantity")
   public CutMachinePart setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("drawingNumber")
   public CutMachinePart setDrawingNumber(final String drawingNumber) {
      this.drawingNumber = drawingNumber;
      return this;
   }

   @JsonProperty("thick")
   public CutMachinePart setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("path")
   public CutMachinePart setPath(final String path) {
      this.path = path;
      return this;
   }

   @JsonProperty("nestingState")
   public CutMachinePart setNestingState(final Integer nestingState) {
      this.nestingState = nestingState;
      return this;
   }

   @JsonProperty("steelId")
   public CutMachinePart setSteelId(final Long steelId) {
      this.steelId = steelId;
      return this;
   }

   @JsonProperty("steelSpec")
   public CutMachinePart setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @JsonProperty("areaType")
   public CutMachinePart setAreaType(final Integer areaType) {
      this.areaType = areaType;
      return this;
   }

   @JsonProperty("areaName")
   public CutMachinePart setAreaName(final String areaName) {
      this.areaName = areaName;
      return this;
   }

   @JsonProperty("monomerName")
   public CutMachinePart setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
      return this;
   }

   @Override
   public String toString() {
      return "CutMachinePart(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", relationType="
         + this.getRelationType()
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
         + ", type="
         + this.getType()
         + ", userId="
         + this.getUserId()
         + ", remark="
         + this.getRemark()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", drawingNumber="
         + this.getDrawingNumber()
         + ", thick="
         + this.getThick()
         + ", path="
         + this.getPath()
         + ", nestingState="
         + this.getNestingState()
         + ", steelId="
         + this.getSteelId()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", areaType="
         + this.getAreaType()
         + ", areaName="
         + this.getAreaName()
         + ", monomerName="
         + this.getMonomerName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CutMachinePart)) {
         return false;
      }

      CutMachinePart other = (CutMachinePart)o;
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
                     Object this$relationType = this.getRelationType();
                     Object other$relationType = other.getRelationType();
                     if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                              Object this$userId = this.getUserId();
                              Object other$userId = other.getUserId();
                              if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                 Object this$usedQuantity = this.getUsedQuantity();
                                 Object other$usedQuantity = other.getUsedQuantity();
                                 if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                                    Object this$producedQuantity = this.getProducedQuantity();
                                    Object other$producedQuantity = other.getProducedQuantity();
                                    if (this$producedQuantity == null ? other$producedQuantity == null : this$producedQuantity.equals(other$producedQuantity)) {
                                       Object this$nestingState = this.getNestingState();
                                       Object other$nestingState = other.getNestingState();
                                       if (this$nestingState == null ? other$nestingState == null : this$nestingState.equals(other$nestingState)) {
                                          Object this$steelId = this.getSteelId();
                                          Object other$steelId = other.getSteelId();
                                          if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
                                             Object this$areaType = this.getAreaType();
                                             Object other$areaType = other.getAreaType();
                                             if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
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
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$drawingNumber = this.getDrawingNumber();
                                                                              Object other$drawingNumber = other.getDrawingNumber();
                                                                              if (this$drawingNumber == null
                                                                                 ? other$drawingNumber == null
                                                                                 : this$drawingNumber.equals(other$drawingNumber)) {
                                                                                 Object this$thick = this.getThick();
                                                                                 Object other$thick = other.getThick();
                                                                                 if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                                                    Object this$path = this.getPath();
                                                                                    Object other$path = other.getPath();
                                                                                    if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                                                                                       Object this$steelSpec = this.getSteelSpec();
                                                                                       Object other$steelSpec = other.getSteelSpec();
                                                                                       if (this$steelSpec == null
                                                                                          ? other$steelSpec == null
                                                                                          : this$steelSpec.equals(other$steelSpec)) {
                                                                                          Object this$areaName = this.getAreaName();
                                                                                          Object other$areaName = other.getAreaName();
                                                                                          if (this$areaName == null
                                                                                             ? other$areaName == null
                                                                                             : this$areaName.equals(other$areaName)) {
                                                                                             Object this$monomerName = this.getMonomerName();
                                                                                             Object other$monomerName = other.getMonomerName();
                                                                                             return this$monomerName == null
                                                                                                ? other$monomerName == null
                                                                                                : this$monomerName.equals(other$monomerName);
                                                                                          } else {
                                                                                             return false;
                                                                                          }
                                                                                       } else {
                                                                                          return false;
                                                                                       }
                                                                                    } else {
                                                                                       return false;
                                                                                    }
                                                                                 } else {
                                                                                    return false;
                                                                                 }
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof CutMachinePart;
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
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $nestingState = this.getNestingState();
      result = result * 59 + ($nestingState == null ? 43 : $nestingState.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
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
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $drawingNumber = this.getDrawingNumber();
      result = result * 59 + ($drawingNumber == null ? 43 : $drawingNumber.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $steelSpec = this.getSteelSpec();
      result = result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $monomerName = this.getMonomerName();
      return result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
   }

   public static class CutMachinePartBuilder {
      private Long id;
      private String name;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Boolean boolStatusEnum;
      private Integer relationType;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private Integer type;
      private Long userId;
      private String remark;
      private Integer usedQuantity;
      private Integer producedQuantity;
      private String drawingNumber;
      private String thick;
      private String path;
      private Integer nestingState;
      private Long steelId;
      private String steelSpec;
      private Integer areaType;
      private String areaName;
      private String monomerName;

      CutMachinePartBuilder() {
      }

      @JsonProperty("id")
      public CutMachinePart.CutMachinePartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public CutMachinePart.CutMachinePartBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("projectId")
      public CutMachinePart.CutMachinePartBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public CutMachinePart.CutMachinePartBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public CutMachinePart.CutMachinePartBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("boolStatusEnum")
      public CutMachinePart.CutMachinePartBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      @JsonProperty("relationType")
      public CutMachinePart.CutMachinePartBuilder relationType(final Integer relationType) {
         this.relationType = relationType;
         return this;
      }

      @JsonProperty("serialNumber")
      public CutMachinePart.CutMachinePartBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public CutMachinePart.CutMachinePartBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public CutMachinePart.CutMachinePartBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("material")
      public CutMachinePart.CutMachinePartBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public CutMachinePart.CutMachinePartBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("netWeight")
      public CutMachinePart.CutMachinePartBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public CutMachinePart.CutMachinePartBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public CutMachinePart.CutMachinePartBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public CutMachinePart.CutMachinePartBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("type")
      public CutMachinePart.CutMachinePartBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("userId")
      public CutMachinePart.CutMachinePartBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("remark")
      public CutMachinePart.CutMachinePartBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("usedQuantity")
      public CutMachinePart.CutMachinePartBuilder usedQuantity(final Integer usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("producedQuantity")
      public CutMachinePart.CutMachinePartBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("drawingNumber")
      public CutMachinePart.CutMachinePartBuilder drawingNumber(final String drawingNumber) {
         this.drawingNumber = drawingNumber;
         return this;
      }

      @JsonProperty("thick")
      public CutMachinePart.CutMachinePartBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("path")
      public CutMachinePart.CutMachinePartBuilder path(final String path) {
         this.path = path;
         return this;
      }

      @JsonProperty("nestingState")
      public CutMachinePart.CutMachinePartBuilder nestingState(final Integer nestingState) {
         this.nestingState = nestingState;
         return this;
      }

      @JsonProperty("steelId")
      public CutMachinePart.CutMachinePartBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      @JsonProperty("steelSpec")
      public CutMachinePart.CutMachinePartBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      @JsonProperty("areaType")
      public CutMachinePart.CutMachinePartBuilder areaType(final Integer areaType) {
         this.areaType = areaType;
         return this;
      }

      @JsonProperty("areaName")
      public CutMachinePart.CutMachinePartBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      @JsonProperty("monomerName")
      public CutMachinePart.CutMachinePartBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public CutMachinePart build() {
         return new CutMachinePart(
            this.id,
            this.name,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.boolStatusEnum,
            this.relationType,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.type,
            this.userId,
            this.remark,
            this.usedQuantity,
            this.producedQuantity,
            this.drawingNumber,
            this.thick,
            this.path,
            this.nestingState,
            this.steelId,
            this.steelSpec,
            this.areaType,
            this.areaName,
            this.monomerName
         );
      }

      @Override
      public String toString() {
         return "CutMachinePart.CutMachinePartBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", relationType="
            + this.relationType
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
            + ", type="
            + this.type
            + ", userId="
            + this.userId
            + ", remark="
            + this.remark
            + ", usedQuantity="
            + this.usedQuantity
            + ", producedQuantity="
            + this.producedQuantity
            + ", drawingNumber="
            + this.drawingNumber
            + ", thick="
            + this.thick
            + ", path="
            + this.path
            + ", nestingState="
            + this.nestingState
            + ", steelId="
            + this.steelId
            + ", steelSpec="
            + this.steelSpec
            + ", areaType="
            + this.areaType
            + ", areaName="
            + this.areaName
            + ", monomerName="
            + this.monomerName
            + ")";
      }
   }
}
