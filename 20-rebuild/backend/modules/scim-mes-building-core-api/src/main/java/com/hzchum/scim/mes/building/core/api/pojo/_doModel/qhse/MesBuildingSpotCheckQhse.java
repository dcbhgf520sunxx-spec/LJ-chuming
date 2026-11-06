package com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse;

import cn.hutool.core.date.DatePattern;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingSpotCheckQhse对象", description = "抽检记录")
@Entity
@TableName("mes_building_spot_check_qhse")
@Table(name = "mes_building_spot_check_qhse")
public class MesBuildingSpotCheckQhse extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = true)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = true)
   private Long productionLineId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "taskId", value = "任务Id", notes = "任务Id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   @TableField("task_id")
   @Column(name = "task_id", columnDefinition = "bigint(20)  COMMENT '任务Id'", nullable = false)
   private Long taskId;
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   @TableField("task_type_enum")
   @Column(name = "task_type_enum", columnDefinition = "int(11)  COMMENT '任务类型'", nullable = false)
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "spotCheckQuantity", value = "抽检数量", notes = "抽检数量")
   @JsonProperty("spotCheckQuantity")
   @JSONField(name = "spotCheckQuantity")
   @TableField("spot_check_quantity")
   @Column(name = "spot_check_quantity", columnDefinition = "int(11) default '0' COMMENT '抽检数量'", nullable = false)
   private Integer spotCheckQuantity;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '名称'")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) COMMENT '编号'")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(64)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '长度(mm)'")
   private BigDecimal length;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '单净重(kg)'")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   @TableField("gross_weight")
   @Column(name = "gross_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '单毛重(kg)'")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积（mm²）")
   @JsonProperty("surfaceArea")
   @JSONField(name = "surfaceArea")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) DEFAULT 0.0 COMMENT '单面积(mm²)'")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255) COMMENT '材质'")
   private String material;
   @ApiModelProperty(name = "qualifiedQuantity", value = "合格数")
   @JsonProperty("qualifiedQuantity")
   @JSONField(name = "qualifiedQuantity")
   @TableField("qualified_quantity")
   @Column(name = "qualified_quantity", columnDefinition = "int(10) default 0 COMMENT '(合格数'")
   private Integer qualifiedQuantity;
   @ApiModelProperty(name = "unQualifiedQuantity", value = "不合格数")
   @JsonProperty("unQualifiedQuantity")
   @JSONField(name = "unQualifiedQuantity")
   @TableField("un_qualified_quantity")
   @Column(name = "un_qualified_quantity", columnDefinition = "int(10) default 0 COMMENT '(不合格数'")
   private Integer unQualifiedQuantity;
   @ApiModelProperty(name = "spotCheckDateTime", value = "抽检时间", notes = "抽检时间")
   @JsonProperty("spotCheckDateTime")
   @JSONField(name = "spotCheckDateTime")
   @TableField("spot_check_date_time")
   @Column(name = "spot_check_date_time", columnDefinition = "datetime(6)  COMMENT '抽检时间'")
   private LocalDateTime spotCheckDateTime;
   @ApiModelProperty(name = "spotCheckDayDate", value = "抽检时间(年月日)", notes = "年月日")
   @JsonProperty("spotCheckDayDate")
   @JSONField(name = "spotCheckDayDate")
   @TableField("spot_check_day_date")
   @Column(name = "spot_check_day_date", columnDefinition = "varchar(128)  COMMENT '年月日'")
   private String spotCheckDayDate;
   @ApiModelProperty(name = "spotCheckDate", value = "抽检时间(年月)", notes = "年月")
   @JsonProperty("spotCheckDate")
   @JSONField(name = "spotCheckDate")
   @TableField("spot_check_date")
   @Column(name = "spot_check_date", columnDefinition = "varchar(128)  COMMENT '年月'")
   private String spotCheckDate;
   @ApiModelProperty(name = "spotCheckUserName", value = "抽检人")
   @JsonProperty("spotCheckUserName")
   @JSONField(name = "spotCheckUserName")
   @TableField("spot_check_user_name")
   @Column(name = "spot_check_user_name", columnDefinition = "varchar(255) COMMENT '抽检人'")
   private String spotCheckUserName;
   @ApiModelProperty(name = "spotCheckRemark", value = "抽检备注")
   @JsonProperty("spotCheckRemark")
   @JSONField(name = "spotCheckRemark")
   @TableField("spot_check_remark")
   @Column(name = "spot_check_remark", columnDefinition = "varchar(255) COMMENT '抽检备注'")
   private String spotCheckRemark;

   public String getSpotCheckDate() {
      return this.spotCheckDate == null ? LocalDate.now().format(DatePattern.NORM_MONTH_FORMATTER) : this.spotCheckDate;
   }

   public String getSpotCheckDayDate() {
      return this.spotCheckDayDate == null ? LocalDate.now().format(DatePattern.NORM_DATE_FORMATTER) : this.spotCheckDayDate;
   }

   public static MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder builder() {
      return new MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder();
   }

   public MesBuildingSpotCheckQhse() {
   }

   public MesBuildingSpotCheckQhse(
      final Long id,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long productId,
      final Long taskId,
      final Integer taskTypeEnum,
      final Integer spotCheckQuantity,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final BigDecimal surfaceArea,
      final String material,
      final Integer qualifiedQuantity,
      final Integer unQualifiedQuantity,
      final LocalDateTime spotCheckDateTime,
      final String spotCheckDayDate,
      final String spotCheckDate,
      final String spotCheckUserName,
      final String spotCheckRemark
   ) {
      this.id = id;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productId = productId;
      this.taskId = taskId;
      this.taskTypeEnum = taskTypeEnum;
      this.spotCheckQuantity = spotCheckQuantity;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.surfaceArea = surfaceArea;
      this.material = material;
      this.qualifiedQuantity = qualifiedQuantity;
      this.unQualifiedQuantity = unQualifiedQuantity;
      this.spotCheckDateTime = spotCheckDateTime;
      this.spotCheckDayDate = spotCheckDayDate;
      this.spotCheckDate = spotCheckDate;
      this.spotCheckUserName = spotCheckUserName;
      this.spotCheckRemark = spotCheckRemark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getFactoryId() {
      return this.factoryId;
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

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getSpotCheckQuantity() {
      return this.spotCheckQuantity;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQualifiedQuantity() {
      return this.qualifiedQuantity;
   }

   public Integer getUnQualifiedQuantity() {
      return this.unQualifiedQuantity;
   }

   public LocalDateTime getSpotCheckDateTime() {
      return this.spotCheckDateTime;
   }

   public String getSpotCheckUserName() {
      return this.spotCheckUserName;
   }

   public String getSpotCheckRemark() {
      return this.spotCheckRemark;
   }

   @JsonProperty("id")
   public MesBuildingSpotCheckQhse setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingSpotCheckQhse setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingSpotCheckQhse setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productionLineId")
   public MesBuildingSpotCheckQhse setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingSpotCheckQhse setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingSpotCheckQhse setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingSpotCheckQhse setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingSpotCheckQhse setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingSpotCheckQhse setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingSpotCheckQhse setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("spotCheckQuantity")
   public MesBuildingSpotCheckQhse setSpotCheckQuantity(final Integer spotCheckQuantity) {
      this.spotCheckQuantity = spotCheckQuantity;
      return this;
   }

   @JsonProperty("name")
   public MesBuildingSpotCheckQhse setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingSpotCheckQhse setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MesBuildingSpotCheckQhse setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("length")
   public MesBuildingSpotCheckQhse setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("netWeight")
   public MesBuildingSpotCheckQhse setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MesBuildingSpotCheckQhse setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("surfaceArea")
   public MesBuildingSpotCheckQhse setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   @JsonProperty("material")
   public MesBuildingSpotCheckQhse setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("qualifiedQuantity")
   public MesBuildingSpotCheckQhse setQualifiedQuantity(final Integer qualifiedQuantity) {
      this.qualifiedQuantity = qualifiedQuantity;
      return this;
   }

   @JsonProperty("unQualifiedQuantity")
   public MesBuildingSpotCheckQhse setUnQualifiedQuantity(final Integer unQualifiedQuantity) {
      this.unQualifiedQuantity = unQualifiedQuantity;
      return this;
   }

   @JsonProperty("spotCheckDateTime")
   public MesBuildingSpotCheckQhse setSpotCheckDateTime(final LocalDateTime spotCheckDateTime) {
      this.spotCheckDateTime = spotCheckDateTime;
      return this;
   }

   @JsonProperty("spotCheckDayDate")
   public MesBuildingSpotCheckQhse setSpotCheckDayDate(final String spotCheckDayDate) {
      this.spotCheckDayDate = spotCheckDayDate;
      return this;
   }

   @JsonProperty("spotCheckDate")
   public MesBuildingSpotCheckQhse setSpotCheckDate(final String spotCheckDate) {
      this.spotCheckDate = spotCheckDate;
      return this;
   }

   @JsonProperty("spotCheckUserName")
   public MesBuildingSpotCheckQhse setSpotCheckUserName(final String spotCheckUserName) {
      this.spotCheckUserName = spotCheckUserName;
      return this;
   }

   @JsonProperty("spotCheckRemark")
   public MesBuildingSpotCheckQhse setSpotCheckRemark(final String spotCheckRemark) {
      this.spotCheckRemark = spotCheckRemark;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSpotCheckQhse(id="
         + this.getId()
         + ", factoryId="
         + this.getFactoryId()
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
         + ", taskId="
         + this.getTaskId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", spotCheckQuantity="
         + this.getSpotCheckQuantity()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", material="
         + this.getMaterial()
         + ", qualifiedQuantity="
         + this.getQualifiedQuantity()
         + ", unQualifiedQuantity="
         + this.getUnQualifiedQuantity()
         + ", spotCheckDateTime="
         + this.getSpotCheckDateTime()
         + ", spotCheckDayDate="
         + this.getSpotCheckDayDate()
         + ", spotCheckDate="
         + this.getSpotCheckDate()
         + ", spotCheckUserName="
         + this.getSpotCheckUserName()
         + ", spotCheckRemark="
         + this.getSpotCheckRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSpotCheckQhse)) {
         return false;
      }

      MesBuildingSpotCheckQhse other = (MesBuildingSpotCheckQhse)o;
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
                              Object this$taskId = this.getTaskId();
                              Object other$taskId = other.getTaskId();
                              if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                                 Object this$taskTypeEnum = this.getTaskTypeEnum();
                                 Object other$taskTypeEnum = other.getTaskTypeEnum();
                                 if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                                    Object this$spotCheckQuantity = this.getSpotCheckQuantity();
                                    Object other$spotCheckQuantity = other.getSpotCheckQuantity();
                                    if (this$spotCheckQuantity == null
                                       ? other$spotCheckQuantity == null
                                       : this$spotCheckQuantity.equals(other$spotCheckQuantity)) {
                                       Object this$qualifiedQuantity = this.getQualifiedQuantity();
                                       Object other$qualifiedQuantity = other.getQualifiedQuantity();
                                       if (this$qualifiedQuantity == null
                                          ? other$qualifiedQuantity == null
                                          : this$qualifiedQuantity.equals(other$qualifiedQuantity)) {
                                          Object this$unQualifiedQuantity = this.getUnQualifiedQuantity();
                                          Object other$unQualifiedQuantity = other.getUnQualifiedQuantity();
                                          if (this$unQualifiedQuantity == null
                                             ? other$unQualifiedQuantity == null
                                             : this$unQualifiedQuantity.equals(other$unQualifiedQuantity)) {
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
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                            Object this$grossWeight = this.getGrossWeight();
                                                            Object other$grossWeight = other.getGrossWeight();
                                                            if (this$grossWeight == null
                                                               ? other$grossWeight == null
                                                               : this$grossWeight.equals(other$grossWeight)) {
                                                               Object this$surfaceArea = this.getSurfaceArea();
                                                               Object other$surfaceArea = other.getSurfaceArea();
                                                               if (this$surfaceArea == null
                                                                  ? other$surfaceArea == null
                                                                  : this$surfaceArea.equals(other$surfaceArea)) {
                                                                  Object this$material = this.getMaterial();
                                                                  Object other$material = other.getMaterial();
                                                                  if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                                     Object this$spotCheckDateTime = this.getSpotCheckDateTime();
                                                                     Object other$spotCheckDateTime = other.getSpotCheckDateTime();
                                                                     if (this$spotCheckDateTime == null
                                                                        ? other$spotCheckDateTime == null
                                                                        : this$spotCheckDateTime.equals(other$spotCheckDateTime)) {
                                                                        Object this$spotCheckDayDate = this.getSpotCheckDayDate();
                                                                        Object other$spotCheckDayDate = other.getSpotCheckDayDate();
                                                                        if (this$spotCheckDayDate == null
                                                                           ? other$spotCheckDayDate == null
                                                                           : this$spotCheckDayDate.equals(other$spotCheckDayDate)) {
                                                                           Object this$spotCheckDate = this.getSpotCheckDate();
                                                                           Object other$spotCheckDate = other.getSpotCheckDate();
                                                                           if (this$spotCheckDate == null
                                                                              ? other$spotCheckDate == null
                                                                              : this$spotCheckDate.equals(other$spotCheckDate)) {
                                                                              Object this$spotCheckUserName = this.getSpotCheckUserName();
                                                                              Object other$spotCheckUserName = other.getSpotCheckUserName();
                                                                              if (this$spotCheckUserName == null
                                                                                 ? other$spotCheckUserName == null
                                                                                 : this$spotCheckUserName.equals(other$spotCheckUserName)) {
                                                                                 Object this$spotCheckRemark = this.getSpotCheckRemark();
                                                                                 Object other$spotCheckRemark = other.getSpotCheckRemark();
                                                                                 return this$spotCheckRemark == null
                                                                                    ? other$spotCheckRemark == null
                                                                                    : this$spotCheckRemark.equals(other$spotCheckRemark);
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof MesBuildingSpotCheckQhse;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
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
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $spotCheckQuantity = this.getSpotCheckQuantity();
      result = result * 59 + ($spotCheckQuantity == null ? 43 : $spotCheckQuantity.hashCode());
      Object $qualifiedQuantity = this.getQualifiedQuantity();
      result = result * 59 + ($qualifiedQuantity == null ? 43 : $qualifiedQuantity.hashCode());
      Object $unQualifiedQuantity = this.getUnQualifiedQuantity();
      result = result * 59 + ($unQualifiedQuantity == null ? 43 : $unQualifiedQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $spotCheckDateTime = this.getSpotCheckDateTime();
      result = result * 59 + ($spotCheckDateTime == null ? 43 : $spotCheckDateTime.hashCode());
      Object $spotCheckDayDate = this.getSpotCheckDayDate();
      result = result * 59 + ($spotCheckDayDate == null ? 43 : $spotCheckDayDate.hashCode());
      Object $spotCheckDate = this.getSpotCheckDate();
      result = result * 59 + ($spotCheckDate == null ? 43 : $spotCheckDate.hashCode());
      Object $spotCheckUserName = this.getSpotCheckUserName();
      result = result * 59 + ($spotCheckUserName == null ? 43 : $spotCheckUserName.hashCode());
      Object $spotCheckRemark = this.getSpotCheckRemark();
      return result * 59 + ($spotCheckRemark == null ? 43 : $spotCheckRemark.hashCode());
   }

   public static class MesBuildingSpotCheckQhseBuilder {
      private Long id;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long productId;
      private Long taskId;
      private Integer taskTypeEnum;
      private Integer spotCheckQuantity;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private BigDecimal surfaceArea;
      private String material;
      private Integer qualifiedQuantity;
      private Integer unQualifiedQuantity;
      private LocalDateTime spotCheckDateTime;
      private String spotCheckDayDate;
      private String spotCheckDate;
      private String spotCheckUserName;
      private String spotCheckRemark;

      MesBuildingSpotCheckQhseBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productionLineId")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("spotCheckQuantity")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder spotCheckQuantity(final Integer spotCheckQuantity) {
         this.spotCheckQuantity = spotCheckQuantity;
         return this;
      }

      @JsonProperty("name")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("length")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("netWeight")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("surfaceArea")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      @JsonProperty("material")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("qualifiedQuantity")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder qualifiedQuantity(final Integer qualifiedQuantity) {
         this.qualifiedQuantity = qualifiedQuantity;
         return this;
      }

      @JsonProperty("unQualifiedQuantity")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder unQualifiedQuantity(final Integer unQualifiedQuantity) {
         this.unQualifiedQuantity = unQualifiedQuantity;
         return this;
      }

      @JsonProperty("spotCheckDateTime")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder spotCheckDateTime(final LocalDateTime spotCheckDateTime) {
         this.spotCheckDateTime = spotCheckDateTime;
         return this;
      }

      @JsonProperty("spotCheckDayDate")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder spotCheckDayDate(final String spotCheckDayDate) {
         this.spotCheckDayDate = spotCheckDayDate;
         return this;
      }

      @JsonProperty("spotCheckDate")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder spotCheckDate(final String spotCheckDate) {
         this.spotCheckDate = spotCheckDate;
         return this;
      }

      @JsonProperty("spotCheckUserName")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder spotCheckUserName(final String spotCheckUserName) {
         this.spotCheckUserName = spotCheckUserName;
         return this;
      }

      @JsonProperty("spotCheckRemark")
      public MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder spotCheckRemark(final String spotCheckRemark) {
         this.spotCheckRemark = spotCheckRemark;
         return this;
      }

      public MesBuildingSpotCheckQhse build() {
         return new MesBuildingSpotCheckQhse(
            this.id,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.productId,
            this.taskId,
            this.taskTypeEnum,
            this.spotCheckQuantity,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.netWeight,
            this.grossWeight,
            this.surfaceArea,
            this.material,
            this.qualifiedQuantity,
            this.unQualifiedQuantity,
            this.spotCheckDateTime,
            this.spotCheckDayDate,
            this.spotCheckDate,
            this.spotCheckUserName,
            this.spotCheckRemark
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSpotCheckQhse.MesBuildingSpotCheckQhseBuilder(id="
            + this.id
            + ", factoryId="
            + this.factoryId
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
            + ", taskId="
            + this.taskId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", spotCheckQuantity="
            + this.spotCheckQuantity
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", material="
            + this.material
            + ", qualifiedQuantity="
            + this.qualifiedQuantity
            + ", unQualifiedQuantity="
            + this.unQualifiedQuantity
            + ", spotCheckDateTime="
            + this.spotCheckDateTime
            + ", spotCheckDayDate="
            + this.spotCheckDayDate
            + ", spotCheckDate="
            + this.spotCheckDate
            + ", spotCheckUserName="
            + this.spotCheckUserName
            + ", spotCheckRemark="
            + this.spotCheckRemark
            + ")";
      }
   }
}
