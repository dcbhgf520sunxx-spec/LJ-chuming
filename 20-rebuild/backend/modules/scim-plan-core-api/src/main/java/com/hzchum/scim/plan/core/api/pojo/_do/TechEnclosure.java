package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(value = "TechEnclosure对象", description = "围护")
@Entity
@TableName("tech_enclosure")
@Table(name = "tech_enclosure")
public class TechEnclosure extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20) comment '项目id'", nullable = false)
   private Long projectId;
   @Deprecated
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划表id")
   @TableField("enclosure_plan_id")
   @Column(name = "enclosure_plan_id", columnDefinition = "bigint  COMMENT '围护计划表id'", nullable = true)
   private Long enclosurePlanId;
   @Deprecated
   @ApiModelProperty(name = "category", value = "品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @TableField("category")
   @Column(name = "category", columnDefinition = "bigint  COMMENT '品类'", nullable = true)
   private Integer category;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "dictionaryId", value = "字典类型")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint(11) comment '字典类型'", nullable = true)
   private Long dictionaryId;
   @ApiModelProperty(name = "name", value = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) comment '编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 false暂停 true进行中")
   @TableField("bool_status_enum")
   @Column(name = "bool_status_enum", columnDefinition = "tinyint(1) default 1 comment '状态 0暂停 1进行中'", nullable = false)
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "boolAbnormalEnum", value = "是否异常状态 0否(正常状态) 1是(异常状态)")
   @TableField("bool_abnormal_enum")
   @Column(name = "bool_abnormal_enum", columnDefinition = "tinyint(1) default 0 comment '是否异常状态 0否(正常状态) 1是(异常状态)'", nullable = false)
   private Boolean boolAbnormalEnum;
   @ApiModelProperty(name = "plate", value = "版型")
   @TableField("plate")
   @Column(name = "plate", columnDefinition = "varchar(255) comment '版型'", nullable = false)
   private String plate;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   @TableField("unfolded_width")
   @Column(name = "unfolded_width", columnDefinition = "decimal(32,4) comment '展宽(mm)'", nullable = false)
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   @TableField("width")
   @Column(name = "width", columnDefinition = "decimal(32,4) comment '有效宽度(mm)'", nullable = false)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度(mm)")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,4) comment '板厚(mm)'")
   private BigDecimal thickness;
   @ApiModelProperty(name = "length", value = "单长度(mm)")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,4) default 0.0 comment '单长度(mm)'", nullable = false)
   private BigDecimal length;
   @ApiModelProperty(name = "unit", value = "计量单位")
   @TableField("unit")
   @Column(name = "unit", columnDefinition = "varchar(255) comment '计量单位'", nullable = false)
   private String unit;
   @ApiModelProperty(name = "quantity", value = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11) comment '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "accountingVolume", value = "核算量(mm)")
   @TableField("accounting_volume")
   @Column(name = "accounting_volume", columnDefinition = "decimal(32,4) default 0.0 comment '核算量(mm)'", nullable = false)
   private BigDecimal accountingVolume;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(mm²)")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) default 0.0 comment '单面积(mm²)'", nullable = false)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "weight", value = "单重量(kg)")
   @TableField("weight")
   @Column(name = "weight", columnDefinition = "decimal(32,8) default 0.0 comment '重量(kg)'", nullable = false)
   private BigDecimal weight;
   @ApiModelProperty(name = "remark", value = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255) comment '备注'")
   private String remark;
   @ApiModelProperty(name = "userId", value = "创建人(导入人)id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) comment '创建人(导入人)id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "totalLength", value = "总长度(mm)")
   @TableField("total_length")
   @Column(name = "total_length", columnDefinition = "decimal(32,4) default 0.0 comment '总长度(mm)'", nullable = false)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积(mm²)")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(32,8) default 0.0 comment '总面积(mm²)'", nullable = false)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "totalWeight", value = "总重量(kg)")
   @TableField("total_weight")
   @Column(name = "total_weight", columnDefinition = "decimal(32,8) default 0.0 comment '重量(kg)'", nullable = false)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "brand", value = "品牌")
   @TableField("brand")
   @Column(name = "brand", columnDefinition = "varchar(255) comment '品牌'")
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255) comment '品牌'")
   private String color;
   @ApiModelProperty(name = "material", value = "材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255) comment '材质'")
   private String material;
   @ApiModelProperty(name = "coating", value = "涂层")
   @TableField("coating")
   @Column(name = "coating", columnDefinition = "varchar(255) comment '涂层'")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   @TableField("plating")
   @Column(name = "plating", columnDefinition = "varchar(255) comment '镀层'")
   private String plating;
   @ApiModelProperty(name = "businessId", value = "商务id")
   @TableField("business_id")
   @Column(name = "business_id", columnDefinition = "bigint(20) comment '商务id'", nullable = false)
   private Long businessId;
   @ApiModelProperty(name = "attachmentId", value = "折边件附件id")
   @TableField("attachment_id")
   @Column(name = "attachment_id", columnDefinition = "bigint(20) comment '折边件附件id'")
   private Long attachmentId;
   @ApiModelProperty(name = "bendTimes", value = "弯折次数")
   @TableField("bend_times")
   @Column(name = "bend_times", columnDefinition = "int(11) default 0 comment '弯折次数'", nullable = false)
   private Integer bendTimes;
   @ApiModelProperty(name = "weightMeter", value = "(桁架楼承板)米重(kg/m)")
   @TableField("weight_meter")
   @Column(name = "weightMeter", columnDefinition = "decimal(18,4) comment '(桁架楼承板)米重(kg/m)'")
   private BigDecimal weightMeter;
   @ApiModelProperty(name = "producedQuantity", value = "已生产量")
   @JsonProperty("producedQuantity")
   @JSONField(name = "producedQuantity")
   @TableField("produced_quantity")
   @Column(name = "produced_quantity", columnDefinition = "int(11) DEFAULT 0 COMMENT '已生产数量'", nullable = false)
   private Integer producedQuantity;
   @ApiModelProperty(name = "schedulingQuantity", value = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   @TableField("scheduling_quantity")
   @Column(name = "scheduling_quantity", columnDefinition = "int(11) DEFAULT 0 COMMENT '排产数量'", nullable = false)
   private Integer schedulingQuantity;
   @ApiModelProperty(name = "subscribeQuantity", value = "已申购数量")
   @TableField("subscribe_quantity")
   @Column(name = "subscribe_quantity", columnDefinition = "int(11) DEFAULT 0 COMMENT '已申购数量'", nullable = false)
   private Integer subscribeQuantity;
   @ApiModelProperty(name = "storeSubscriptionQuantity", value = "申购入库数量 ")
   @TableField("store_subscription_quantity")
   @Column(name = "store_subscription_quantity", columnDefinition = "int(11) DEFAULT 0 COMMENT '申购入库数量'", nullable = false)
   private Integer storeSubscriptionQuantity;

   public static TechEnclosure.TechEnclosureBuilder builder() {
      return new TechEnclosure.TechEnclosureBuilder();
   }

   public TechEnclosure() {
   }

   public TechEnclosure(
      final Long id,
      final Long projectId,
      final Long enclosurePlanId,
      final Integer category,
      final Long monomerId,
      final Long areaId,
      final Long dictionaryId,
      final String name,
      final String serialNumber,
      final Boolean boolStatusEnum,
      final Boolean boolAbnormalEnum,
      final String plate,
      final BigDecimal unfoldedWidth,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal length,
      final String unit,
      final Integer quantity,
      final BigDecimal accountingVolume,
      final BigDecimal surfaceArea,
      final BigDecimal weight,
      final String remark,
      final Long userId,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final BigDecimal totalWeight,
      final String brand,
      final String color,
      final String material,
      final String coating,
      final String plating,
      final Long businessId,
      final Long attachmentId,
      final Integer bendTimes,
      final BigDecimal weightMeter,
      final Integer producedQuantity,
      final Integer schedulingQuantity,
      final Integer subscribeQuantity,
      final Integer storeSubscriptionQuantity
   ) {
      this.id = id;
      this.projectId = projectId;
      this.enclosurePlanId = enclosurePlanId;
      this.category = category;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.dictionaryId = dictionaryId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.boolStatusEnum = boolStatusEnum;
      this.boolAbnormalEnum = boolAbnormalEnum;
      this.plate = plate;
      this.unfoldedWidth = unfoldedWidth;
      this.width = width;
      this.thickness = thickness;
      this.length = length;
      this.unit = unit;
      this.quantity = quantity;
      this.accountingVolume = accountingVolume;
      this.surfaceArea = surfaceArea;
      this.weight = weight;
      this.remark = remark;
      this.userId = userId;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.totalWeight = totalWeight;
      this.brand = brand;
      this.color = color;
      this.material = material;
      this.coating = coating;
      this.plating = plating;
      this.businessId = businessId;
      this.attachmentId = attachmentId;
      this.bendTimes = bendTimes;
      this.weightMeter = weightMeter;
      this.producedQuantity = producedQuantity;
      this.schedulingQuantity = schedulingQuantity;
      this.subscribeQuantity = subscribeQuantity;
      this.storeSubscriptionQuantity = storeSubscriptionQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   @Deprecated
   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   @Deprecated
   public Integer getCategory() {
      return this.category;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Boolean getBoolAbnormalEnum() {
      return this.boolAbnormalEnum;
   }

   public String getPlate() {
      return this.plate;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getUnit() {
      return this.unit;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getAccountingVolume() {
      return this.accountingVolume;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public BigDecimal getWeightMeter() {
      return this.weightMeter;
   }

   public Integer getProducedQuantity() {
      return this.producedQuantity;
   }

   public Integer getSchedulingQuantity() {
      return this.schedulingQuantity;
   }

   public Integer getSubscribeQuantity() {
      return this.subscribeQuantity;
   }

   public Integer getStoreSubscriptionQuantity() {
      return this.storeSubscriptionQuantity;
   }

   public TechEnclosure setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechEnclosure setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @Deprecated
   public TechEnclosure setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
      return this;
   }

   @Deprecated
   public TechEnclosure setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public TechEnclosure setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public TechEnclosure setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechEnclosure setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   public TechEnclosure setName(final String name) {
      this.name = name;
      return this;
   }

   public TechEnclosure setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechEnclosure setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   public TechEnclosure setBoolAbnormalEnum(final Boolean boolAbnormalEnum) {
      this.boolAbnormalEnum = boolAbnormalEnum;
      return this;
   }

   public TechEnclosure setPlate(final String plate) {
      this.plate = plate;
      return this;
   }

   public TechEnclosure setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   public TechEnclosure setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public TechEnclosure setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public TechEnclosure setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public TechEnclosure setUnit(final String unit) {
      this.unit = unit;
      return this;
   }

   public TechEnclosure setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechEnclosure setAccountingVolume(final BigDecimal accountingVolume) {
      this.accountingVolume = accountingVolume;
      return this;
   }

   public TechEnclosure setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public TechEnclosure setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   public TechEnclosure setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechEnclosure setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechEnclosure setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   public TechEnclosure setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public TechEnclosure setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
      return this;
   }

   public TechEnclosure setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   public TechEnclosure setColor(final String color) {
      this.color = color;
      return this;
   }

   public TechEnclosure setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TechEnclosure setCoating(final String coating) {
      this.coating = coating;
      return this;
   }

   public TechEnclosure setPlating(final String plating) {
      this.plating = plating;
      return this;
   }

   public TechEnclosure setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   public TechEnclosure setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   public TechEnclosure setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
      return this;
   }

   public TechEnclosure setWeightMeter(final BigDecimal weightMeter) {
      this.weightMeter = weightMeter;
      return this;
   }

   @JsonProperty("producedQuantity")
   public TechEnclosure setProducedQuantity(final Integer producedQuantity) {
      this.producedQuantity = producedQuantity;
      return this;
   }

   @JsonProperty("schedulingQuantity")
   public TechEnclosure setSchedulingQuantity(final Integer schedulingQuantity) {
      this.schedulingQuantity = schedulingQuantity;
      return this;
   }

   public TechEnclosure setSubscribeQuantity(final Integer subscribeQuantity) {
      this.subscribeQuantity = subscribeQuantity;
      return this;
   }

   public TechEnclosure setStoreSubscriptionQuantity(final Integer storeSubscriptionQuantity) {
      this.storeSubscriptionQuantity = storeSubscriptionQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "TechEnclosure(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", category="
         + this.getCategory()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", boolAbnormalEnum="
         + this.getBoolAbnormalEnum()
         + ", plate="
         + this.getPlate()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", unit="
         + this.getUnit()
         + ", quantity="
         + this.getQuantity()
         + ", accountingVolume="
         + this.getAccountingVolume()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", weight="
         + this.getWeight()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", businessId="
         + this.getBusinessId()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", bendTimes="
         + this.getBendTimes()
         + ", weightMeter="
         + this.getWeightMeter()
         + ", producedQuantity="
         + this.getProducedQuantity()
         + ", schedulingQuantity="
         + this.getSchedulingQuantity()
         + ", subscribeQuantity="
         + this.getSubscribeQuantity()
         + ", storeSubscriptionQuantity="
         + this.getStoreSubscriptionQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosure)) {
         return false;
      }

      TechEnclosure other = (TechEnclosure)o;
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
            Object this$enclosurePlanId = this.getEnclosurePlanId();
            Object other$enclosurePlanId = other.getEnclosurePlanId();
            if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$dictionaryId = this.getDictionaryId();
                        Object other$dictionaryId = other.getDictionaryId();
                        if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                           Object this$boolStatusEnum = this.getBoolStatusEnum();
                           Object other$boolStatusEnum = other.getBoolStatusEnum();
                           if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                              Object this$boolAbnormalEnum = this.getBoolAbnormalEnum();
                              Object other$boolAbnormalEnum = other.getBoolAbnormalEnum();
                              if (this$boolAbnormalEnum == null ? other$boolAbnormalEnum == null : this$boolAbnormalEnum.equals(other$boolAbnormalEnum)) {
                                 Object this$quantity = this.getQuantity();
                                 Object other$quantity = other.getQuantity();
                                 if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                    Object this$userId = this.getUserId();
                                    Object other$userId = other.getUserId();
                                    if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                                       Object this$businessId = this.getBusinessId();
                                       Object other$businessId = other.getBusinessId();
                                       if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                                          Object this$attachmentId = this.getAttachmentId();
                                          Object other$attachmentId = other.getAttachmentId();
                                          if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                                             Object this$bendTimes = this.getBendTimes();
                                             Object other$bendTimes = other.getBendTimes();
                                             if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
                                                Object this$producedQuantity = this.getProducedQuantity();
                                                Object other$producedQuantity = other.getProducedQuantity();
                                                if (this$producedQuantity == null
                                                   ? other$producedQuantity == null
                                                   : this$producedQuantity.equals(other$producedQuantity)) {
                                                   Object this$schedulingQuantity = this.getSchedulingQuantity();
                                                   Object other$schedulingQuantity = other.getSchedulingQuantity();
                                                   if (this$schedulingQuantity == null
                                                      ? other$schedulingQuantity == null
                                                      : this$schedulingQuantity.equals(other$schedulingQuantity)) {
                                                      Object this$subscribeQuantity = this.getSubscribeQuantity();
                                                      Object other$subscribeQuantity = other.getSubscribeQuantity();
                                                      if (this$subscribeQuantity == null
                                                         ? other$subscribeQuantity == null
                                                         : this$subscribeQuantity.equals(other$subscribeQuantity)) {
                                                         Object this$storeSubscriptionQuantity = this.getStoreSubscriptionQuantity();
                                                         Object other$storeSubscriptionQuantity = other.getStoreSubscriptionQuantity();
                                                         if (this$storeSubscriptionQuantity == null
                                                            ? other$storeSubscriptionQuantity == null
                                                            : this$storeSubscriptionQuantity.equals(other$storeSubscriptionQuantity)) {
                                                            Object this$name = this.getName();
                                                            Object other$name = other.getName();
                                                            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                               Object this$serialNumber = this.getSerialNumber();
                                                               Object other$serialNumber = other.getSerialNumber();
                                                               if (this$serialNumber == null
                                                                  ? other$serialNumber == null
                                                                  : this$serialNumber.equals(other$serialNumber)) {
                                                                  Object this$plate = this.getPlate();
                                                                  Object other$plate = other.getPlate();
                                                                  if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                                     Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                                     Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                                     if (this$unfoldedWidth == null
                                                                        ? other$unfoldedWidth == null
                                                                        : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                                        Object this$width = this.getWidth();
                                                                        Object other$width = other.getWidth();
                                                                        if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                           Object this$thickness = this.getThickness();
                                                                           Object other$thickness = other.getThickness();
                                                                           if (this$thickness == null
                                                                              ? other$thickness == null
                                                                              : this$thickness.equals(other$thickness)) {
                                                                              Object this$length = this.getLength();
                                                                              Object other$length = other.getLength();
                                                                              if (this$length == null ? other$length == null : this$length.equals(other$length)
                                                                                 )
                                                                               {
                                                                                 Object this$unit = this.getUnit();
                                                                                 Object other$unit = other.getUnit();
                                                                                 if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                                                                    Object this$accountingVolume = this.getAccountingVolume();
                                                                                    Object other$accountingVolume = other.getAccountingVolume();
                                                                                    if (this$accountingVolume == null
                                                                                       ? other$accountingVolume == null
                                                                                       : this$accountingVolume.equals(other$accountingVolume)) {
                                                                                       Object this$surfaceArea = this.getSurfaceArea();
                                                                                       Object other$surfaceArea = other.getSurfaceArea();
                                                                                       if (this$surfaceArea == null
                                                                                          ? other$surfaceArea == null
                                                                                          : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                          Object this$weight = this.getWeight();
                                                                                          Object other$weight = other.getWeight();
                                                                                          if (this$weight == null
                                                                                             ? other$weight == null
                                                                                             : this$weight.equals(other$weight)) {
                                                                                             Object this$remark = this.getRemark();
                                                                                             Object other$remark = other.getRemark();
                                                                                             if (this$remark == null
                                                                                                ? other$remark == null
                                                                                                : this$remark.equals(other$remark)) {
                                                                                                Object this$totalLength = this.getTotalLength();
                                                                                                Object other$totalLength = other.getTotalLength();
                                                                                                if (this$totalLength == null
                                                                                                   ? other$totalLength == null
                                                                                                   : this$totalLength.equals(other$totalLength)) {
                                                                                                   Object this$totalArea = this.getTotalArea();
                                                                                                   Object other$totalArea = other.getTotalArea();
                                                                                                   if (this$totalArea == null
                                                                                                      ? other$totalArea == null
                                                                                                      : this$totalArea.equals(other$totalArea)) {
                                                                                                      Object this$totalWeight = this.getTotalWeight();
                                                                                                      Object other$totalWeight = other.getTotalWeight();
                                                                                                      if (this$totalWeight == null
                                                                                                         ? other$totalWeight == null
                                                                                                         : this$totalWeight.equals(other$totalWeight)) {
                                                                                                         Object this$brand = this.getBrand();
                                                                                                         Object other$brand = other.getBrand();
                                                                                                         if (this$brand == null
                                                                                                            ? other$brand == null
                                                                                                            : this$brand.equals(other$brand)) {
                                                                                                            Object this$color = this.getColor();
                                                                                                            Object other$color = other.getColor();
                                                                                                            if (this$color == null
                                                                                                               ? other$color == null
                                                                                                               : this$color.equals(other$color)) {
                                                                                                               Object this$material = this.getMaterial();
                                                                                                               Object other$material = other.getMaterial();
                                                                                                               if (this$material == null
                                                                                                                  ? other$material == null
                                                                                                                  : this$material.equals(other$material)) {
                                                                                                                  Object this$coating = this.getCoating();
                                                                                                                  Object other$coating = other.getCoating();
                                                                                                                  if (this$coating == null
                                                                                                                     ? other$coating == null
                                                                                                                     : this$coating.equals(other$coating)) {
                                                                                                                     Object this$plating = this.getPlating();
                                                                                                                     Object other$plating = other.getPlating();
                                                                                                                     if (this$plating == null
                                                                                                                        ? other$plating == null
                                                                                                                        : this$plating.equals(other$plating)) {
                                                                                                                        Object this$weightMeter = this.getWeightMeter();
                                                                                                                        Object other$weightMeter = other.getWeightMeter();
                                                                                                                        return this$weightMeter == null
                                                                                                                           ? other$weightMeter == null
                                                                                                                           : this$weightMeter.equals(
                                                                                                                              other$weightMeter
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechEnclosure;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $boolAbnormalEnum = this.getBoolAbnormalEnum();
      result = result * 59 + ($boolAbnormalEnum == null ? 43 : $boolAbnormalEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $producedQuantity = this.getProducedQuantity();
      result = result * 59 + ($producedQuantity == null ? 43 : $producedQuantity.hashCode());
      Object $schedulingQuantity = this.getSchedulingQuantity();
      result = result * 59 + ($schedulingQuantity == null ? 43 : $schedulingQuantity.hashCode());
      Object $subscribeQuantity = this.getSubscribeQuantity();
      result = result * 59 + ($subscribeQuantity == null ? 43 : $subscribeQuantity.hashCode());
      Object $storeSubscriptionQuantity = this.getStoreSubscriptionQuantity();
      result = result * 59 + ($storeSubscriptionQuantity == null ? 43 : $storeSubscriptionQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $accountingVolume = this.getAccountingVolume();
      result = result * 59 + ($accountingVolume == null ? 43 : $accountingVolume.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $weightMeter = this.getWeightMeter();
      return result * 59 + ($weightMeter == null ? 43 : $weightMeter.hashCode());
   }

   public static class TechEnclosureBuilder {
      private Long id;
      private Long projectId;
      private Long enclosurePlanId;
      private Integer category;
      private Long monomerId;
      private Long areaId;
      private Long dictionaryId;
      private String name;
      private String serialNumber;
      private Boolean boolStatusEnum;
      private Boolean boolAbnormalEnum;
      private String plate;
      private BigDecimal unfoldedWidth;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal length;
      private String unit;
      private Integer quantity;
      private BigDecimal accountingVolume;
      private BigDecimal surfaceArea;
      private BigDecimal weight;
      private String remark;
      private Long userId;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private BigDecimal totalWeight;
      private String brand;
      private String color;
      private String material;
      private String coating;
      private String plating;
      private Long businessId;
      private Long attachmentId;
      private Integer bendTimes;
      private BigDecimal weightMeter;
      private Integer producedQuantity;
      private Integer schedulingQuantity;
      private Integer subscribeQuantity;
      private Integer storeSubscriptionQuantity;

      TechEnclosureBuilder() {
      }

      public TechEnclosure.TechEnclosureBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @Deprecated
      public TechEnclosure.TechEnclosureBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      @Deprecated
      public TechEnclosure.TechEnclosureBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public TechEnclosure.TechEnclosureBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder boolAbnormalEnum(final Boolean boolAbnormalEnum) {
         this.boolAbnormalEnum = boolAbnormalEnum;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder accountingVolume(final BigDecimal accountingVolume) {
         this.accountingVolume = accountingVolume;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder coating(final String coating) {
         this.coating = coating;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder plating(final String plating) {
         this.plating = plating;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder bendTimes(final Integer bendTimes) {
         this.bendTimes = bendTimes;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder weightMeter(final BigDecimal weightMeter) {
         this.weightMeter = weightMeter;
         return this;
      }

      @JsonProperty("producedQuantity")
      public TechEnclosure.TechEnclosureBuilder producedQuantity(final Integer producedQuantity) {
         this.producedQuantity = producedQuantity;
         return this;
      }

      @JsonProperty("schedulingQuantity")
      public TechEnclosure.TechEnclosureBuilder schedulingQuantity(final Integer schedulingQuantity) {
         this.schedulingQuantity = schedulingQuantity;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder subscribeQuantity(final Integer subscribeQuantity) {
         this.subscribeQuantity = subscribeQuantity;
         return this;
      }

      public TechEnclosure.TechEnclosureBuilder storeSubscriptionQuantity(final Integer storeSubscriptionQuantity) {
         this.storeSubscriptionQuantity = storeSubscriptionQuantity;
         return this;
      }

      public TechEnclosure build() {
         return new TechEnclosure(
            this.id,
            this.projectId,
            this.enclosurePlanId,
            this.category,
            this.monomerId,
            this.areaId,
            this.dictionaryId,
            this.name,
            this.serialNumber,
            this.boolStatusEnum,
            this.boolAbnormalEnum,
            this.plate,
            this.unfoldedWidth,
            this.width,
            this.thickness,
            this.length,
            this.unit,
            this.quantity,
            this.accountingVolume,
            this.surfaceArea,
            this.weight,
            this.remark,
            this.userId,
            this.totalLength,
            this.totalArea,
            this.totalWeight,
            this.brand,
            this.color,
            this.material,
            this.coating,
            this.plating,
            this.businessId,
            this.attachmentId,
            this.bendTimes,
            this.weightMeter,
            this.producedQuantity,
            this.schedulingQuantity,
            this.subscribeQuantity,
            this.storeSubscriptionQuantity
         );
      }

      @Override
      public String toString() {
         return "TechEnclosure.TechEnclosureBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", category="
            + this.category
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", dictionaryId="
            + this.dictionaryId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", boolAbnormalEnum="
            + this.boolAbnormalEnum
            + ", plate="
            + this.plate
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", unit="
            + this.unit
            + ", quantity="
            + this.quantity
            + ", accountingVolume="
            + this.accountingVolume
            + ", surfaceArea="
            + this.surfaceArea
            + ", weight="
            + this.weight
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", totalWeight="
            + this.totalWeight
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", material="
            + this.material
            + ", coating="
            + this.coating
            + ", plating="
            + this.plating
            + ", businessId="
            + this.businessId
            + ", attachmentId="
            + this.attachmentId
            + ", bendTimes="
            + this.bendTimes
            + ", weightMeter="
            + this.weightMeter
            + ", producedQuantity="
            + this.producedQuantity
            + ", schedulingQuantity="
            + this.schedulingQuantity
            + ", subscribeQuantity="
            + this.subscribeQuantity
            + ", storeSubscriptionQuantity="
            + this.storeSubscriptionQuantity
            + ")";
      }
   }
}
