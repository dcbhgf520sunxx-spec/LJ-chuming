package com.hzchum.scim.plan.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzchum.pangu.common.config.JacksonCustomizerConfig.LocalDateTimeDeserializer;
import com.hzchum.pangu.common.config.JacksonCustomizerConfig.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "备料库存利用表 ")
@Entity
@TableName("plan_wms_inventory_stock")
@Table(name = "plan_wms_inventory_stock")
public class PlanWmsInventoryStock implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id")
   private Long projectId;
   @ApiModelProperty(name = "stockId", value = "备料单id")
   @JsonProperty("stockId")
   @JSONField(name = "stockId")
   @TableField("stock_id")
   @Column(name = "stock_id")
   private Long stockId;
   @ApiModelProperty(name = "materialPoolId", value = "物料仓id")
   @JsonProperty("materialPoolId")
   @JSONField(name = "materialPoolId")
   @TableField("material_pool_id")
   @Column(name = "material_pool_id")
   private Long materialPoolId;
   @ApiModelProperty(name = "classifyId", value = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id")
   private Long classifyId;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class")
   private Integer basicClass;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name")
   private String classifyName;
   @ApiModelProperty(name = "serialNumber", value = "科目编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "usedQuantity", value = "利用数量")
   @JsonProperty("usedQuantity")
   @JSONField(name = "usedQuantity")
   @TableField("used_quantity")
   @Column(name = "used_quantity")
   private BigDecimal usedQuantity;
   @ApiModelProperty(name = "usedMete", value = "利用量")
   @JsonProperty("usedMete")
   @JSONField(name = "usedMete")
   @TableField("used_mete")
   @Column(name = "used_mete")
   private BigDecimal usedMete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit")
   private String accountingUnit;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   @JsonProperty("accountingPrecision")
   @JSONField(name = "accountingPrecision")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   @TableField("measure_unit")
   @Column(name = "measure_unit")
   private String measureUnit;
   @ApiModelProperty(name = "measurePrecision", value = "计量精度")
   @JsonProperty("measurePrecision")
   @JSONField(name = "measurePrecision")
   @TableField("measure_precision")
   @Column(name = "measure_precision")
   private Integer measurePrecision;
   @ApiModelProperty(name = "unitNet", value = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net")
   private BigDecimal unitNet;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand")
   private String brand;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "thickness", value = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness")
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "length", value = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "heatNoAndBatchNo", value = "炉批号")
   @JsonProperty("heatNoAndBatchNo")
   @JSONField(name = "heatNoAndBatchNo")
   @TableField("heat_no_and_batch_no")
   @Column(name = "heat_no_and_batch_no")
   private String heatNoAndBatchNo;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(hidden = true)
   @TableField(fill = FieldFill.INSERT)
   @Column
   @JsonInclude(Include.NON_NULL)
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime createTime;
   @ApiModelProperty(hidden = true)
   @TableField(fill = FieldFill.INSERT_UPDATE)
   @Column
   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime updateTime;
   @ApiModelProperty(hidden = true)
   @Version
   @Column
   @JsonIgnore
   private Integer version;

   public static PlanWmsInventoryStock.PlanWmsInventoryStockBuilder builder() {
      return new PlanWmsInventoryStock.PlanWmsInventoryStockBuilder();
   }

   public PlanWmsInventoryStock() {
   }

   public PlanWmsInventoryStock(
      final Long id,
      final Long projectId,
      final Long stockId,
      final Long materialPoolId,
      final Long classifyId,
      final Integer basicClass,
      final String classifyName,
      final String serialNumber,
      final BigDecimal usedQuantity,
      final BigDecimal usedMete,
      final String accountingUnit,
      final Integer accountingPrecision,
      final String measureUnit,
      final Integer measurePrecision,
      final BigDecimal unitNet,
      final String brand,
      final String specification,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal length,
      final BigDecimal width,
      final String heatNoAndBatchNo,
      final String remark,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final Integer version
   ) {
      this.id = id;
      this.projectId = projectId;
      this.stockId = stockId;
      this.materialPoolId = materialPoolId;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.classifyName = classifyName;
      this.serialNumber = serialNumber;
      this.usedQuantity = usedQuantity;
      this.usedMete = usedMete;
      this.accountingUnit = accountingUnit;
      this.accountingPrecision = accountingPrecision;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.unitNet = unitNet;
      this.brand = brand;
      this.specification = specification;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.length = length;
      this.width = width;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.remark = remark;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.version = version;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getStockId() {
      return this.stockId;
   }

   public Long getMaterialPoolId() {
      return this.materialPoolId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getUsedQuantity() {
      return this.usedQuantity;
   }

   public BigDecimal getUsedMete() {
      return this.usedMete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public Integer getVersion() {
      return this.version;
   }

   @JsonProperty("id")
   public PlanWmsInventoryStock setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public PlanWmsInventoryStock setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("stockId")
   public PlanWmsInventoryStock setStockId(final Long stockId) {
      this.stockId = stockId;
      return this;
   }

   @JsonProperty("materialPoolId")
   public PlanWmsInventoryStock setMaterialPoolId(final Long materialPoolId) {
      this.materialPoolId = materialPoolId;
      return this;
   }

   @JsonProperty("classifyId")
   public PlanWmsInventoryStock setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("basicClass")
   public PlanWmsInventoryStock setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyName")
   public PlanWmsInventoryStock setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("serialNumber")
   public PlanWmsInventoryStock setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("usedQuantity")
   public PlanWmsInventoryStock setUsedQuantity(final BigDecimal usedQuantity) {
      this.usedQuantity = usedQuantity;
      return this;
   }

   @JsonProperty("usedMete")
   public PlanWmsInventoryStock setUsedMete(final BigDecimal usedMete) {
      this.usedMete = usedMete;
      return this;
   }

   @JsonProperty("accountingUnit")
   public PlanWmsInventoryStock setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("accountingPrecision")
   public PlanWmsInventoryStock setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   @JsonProperty("measureUnit")
   public PlanWmsInventoryStock setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("measurePrecision")
   public PlanWmsInventoryStock setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
      return this;
   }

   @JsonProperty("unitNet")
   public PlanWmsInventoryStock setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("brand")
   public PlanWmsInventoryStock setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("specification")
   public PlanWmsInventoryStock setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("thickness")
   public PlanWmsInventoryStock setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public PlanWmsInventoryStock setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("length")
   public PlanWmsInventoryStock setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public PlanWmsInventoryStock setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("heatNoAndBatchNo")
   public PlanWmsInventoryStock setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      return this;
   }

   @JsonProperty("remark")
   public PlanWmsInventoryStock setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public PlanWmsInventoryStock setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public PlanWmsInventoryStock setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   @JsonIgnore
   public PlanWmsInventoryStock setVersion(final Integer version) {
      this.version = version;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanWmsInventoryStock)) {
         return false;
      }

      PlanWmsInventoryStock other = (PlanWmsInventoryStock)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$stockId = this.getStockId();
            Object other$stockId = other.getStockId();
            if (this$stockId == null ? other$stockId == null : this$stockId.equals(other$stockId)) {
               Object this$materialPoolId = this.getMaterialPoolId();
               Object other$materialPoolId = other.getMaterialPoolId();
               if (this$materialPoolId == null ? other$materialPoolId == null : this$materialPoolId.equals(other$materialPoolId)) {
                  Object this$classifyId = this.getClassifyId();
                  Object other$classifyId = other.getClassifyId();
                  if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                        Object this$accountingPrecision = this.getAccountingPrecision();
                        Object other$accountingPrecision = other.getAccountingPrecision();
                        if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                           Object this$measurePrecision = this.getMeasurePrecision();
                           Object other$measurePrecision = other.getMeasurePrecision();
                           if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                              Object this$version = this.getVersion();
                              Object other$version = other.getVersion();
                              if (this$version == null ? other$version == null : this$version.equals(other$version)) {
                                 Object this$classifyName = this.getClassifyName();
                                 Object other$classifyName = other.getClassifyName();
                                 if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$usedQuantity = this.getUsedQuantity();
                                       Object other$usedQuantity = other.getUsedQuantity();
                                       if (this$usedQuantity == null ? other$usedQuantity == null : this$usedQuantity.equals(other$usedQuantity)) {
                                          Object this$usedMete = this.getUsedMete();
                                          Object other$usedMete = other.getUsedMete();
                                          if (this$usedMete == null ? other$usedMete == null : this$usedMete.equals(other$usedMete)) {
                                             Object this$accountingUnit = this.getAccountingUnit();
                                             Object other$accountingUnit = other.getAccountingUnit();
                                             if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                                Object this$measureUnit = this.getMeasureUnit();
                                                Object other$measureUnit = other.getMeasureUnit();
                                                if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                   Object this$unitNet = this.getUnitNet();
                                                   Object other$unitNet = other.getUnitNet();
                                                   if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                      Object this$brand = this.getBrand();
                                                      Object other$brand = other.getBrand();
                                                      if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                         Object this$specification = this.getSpecification();
                                                         Object other$specification = other.getSpecification();
                                                         if (this$specification == null
                                                            ? other$specification == null
                                                            : this$specification.equals(other$specification)) {
                                                            Object this$thickness = this.getThickness();
                                                            Object other$thickness = other.getThickness();
                                                            if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                               Object this$theoryThickness = this.getTheoryThickness();
                                                               Object other$theoryThickness = other.getTheoryThickness();
                                                               if (this$theoryThickness == null
                                                                  ? other$theoryThickness == null
                                                                  : this$theoryThickness.equals(other$theoryThickness)) {
                                                                  Object this$length = this.getLength();
                                                                  Object other$length = other.getLength();
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                     Object this$width = this.getWidth();
                                                                     Object other$width = other.getWidth();
                                                                     if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                        Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                        Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                        if (this$heatNoAndBatchNo == null
                                                                           ? other$heatNoAndBatchNo == null
                                                                           : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$createTime = this.getCreateTime();
                                                                              Object other$createTime = other.getCreateTime();
                                                                              if (this$createTime == null
                                                                                 ? other$createTime == null
                                                                                 : this$createTime.equals(other$createTime)) {
                                                                                 Object this$updateTime = this.getUpdateTime();
                                                                                 Object other$updateTime = other.getUpdateTime();
                                                                                 return this$updateTime == null
                                                                                    ? other$updateTime == null
                                                                                    : this$updateTime.equals(other$updateTime);
                                                                              } else {
                                                                                 return false;
                                                                              }
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof PlanWmsInventoryStock;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $stockId = this.getStockId();
      result = result * 59 + ($stockId == null ? 43 : $stockId.hashCode());
      Object $materialPoolId = this.getMaterialPoolId();
      result = result * 59 + ($materialPoolId == null ? 43 : $materialPoolId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $usedQuantity = this.getUsedQuantity();
      result = result * 59 + ($usedQuantity == null ? 43 : $usedQuantity.hashCode());
      Object $usedMete = this.getUsedMete();
      result = result * 59 + ($usedMete == null ? 43 : $usedMete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "PlanWmsInventoryStock(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", stockId="
         + this.getStockId()
         + ", materialPoolId="
         + this.getMaterialPoolId()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyName="
         + this.getClassifyName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", usedQuantity="
         + this.getUsedQuantity()
         + ", usedMete="
         + this.getUsedMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", unitNet="
         + this.getUnitNet()
         + ", brand="
         + this.getBrand()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", remark="
         + this.getRemark()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", version="
         + this.getVersion()
         + ")";
   }

   public static class PlanWmsInventoryStockBuilder {
      private Long id;
      private Long projectId;
      private Long stockId;
      private Long materialPoolId;
      private Long classifyId;
      private Integer basicClass;
      private String classifyName;
      private String serialNumber;
      private BigDecimal usedQuantity;
      private BigDecimal usedMete;
      private String accountingUnit;
      private Integer accountingPrecision;
      private String measureUnit;
      private Integer measurePrecision;
      private BigDecimal unitNet;
      private String brand;
      private String specification;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal length;
      private BigDecimal width;
      private String heatNoAndBatchNo;
      private String remark;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private Integer version;

      PlanWmsInventoryStockBuilder() {
      }

      @JsonProperty("id")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("stockId")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder stockId(final Long stockId) {
         this.stockId = stockId;
         return this;
      }

      @JsonProperty("materialPoolId")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder materialPoolId(final Long materialPoolId) {
         this.materialPoolId = materialPoolId;
         return this;
      }

      @JsonProperty("classifyId")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("basicClass")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyName")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("serialNumber")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("usedQuantity")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder usedQuantity(final BigDecimal usedQuantity) {
         this.usedQuantity = usedQuantity;
         return this;
      }

      @JsonProperty("usedMete")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder usedMete(final BigDecimal usedMete) {
         this.usedMete = usedMete;
         return this;
      }

      @JsonProperty("accountingUnit")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("accountingPrecision")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      @JsonProperty("measureUnit")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("measurePrecision")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      @JsonProperty("unitNet")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("brand")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("specification")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("thickness")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("length")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("heatNoAndBatchNo")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      @JsonProperty("remark")
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonIgnore
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      @JsonIgnore
      public PlanWmsInventoryStock.PlanWmsInventoryStockBuilder version(final Integer version) {
         this.version = version;
         return this;
      }

      public PlanWmsInventoryStock build() {
         return new PlanWmsInventoryStock(
            this.id,
            this.projectId,
            this.stockId,
            this.materialPoolId,
            this.classifyId,
            this.basicClass,
            this.classifyName,
            this.serialNumber,
            this.usedQuantity,
            this.usedMete,
            this.accountingUnit,
            this.accountingPrecision,
            this.measureUnit,
            this.measurePrecision,
            this.unitNet,
            this.brand,
            this.specification,
            this.thickness,
            this.theoryThickness,
            this.length,
            this.width,
            this.heatNoAndBatchNo,
            this.remark,
            this.createTime,
            this.updateTime,
            this.version
         );
      }

      @Override
      public String toString() {
         return "PlanWmsInventoryStock.PlanWmsInventoryStockBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", stockId="
            + this.stockId
            + ", materialPoolId="
            + this.materialPoolId
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", classifyName="
            + this.classifyName
            + ", serialNumber="
            + this.serialNumber
            + ", usedQuantity="
            + this.usedQuantity
            + ", usedMete="
            + this.usedMete
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", measureUnit="
            + this.measureUnit
            + ", measurePrecision="
            + this.measurePrecision
            + ", unitNet="
            + this.unitNet
            + ", brand="
            + this.brand
            + ", specification="
            + this.specification
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", remark="
            + this.remark
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", version="
            + this.version
            + ")";
      }
   }
}
