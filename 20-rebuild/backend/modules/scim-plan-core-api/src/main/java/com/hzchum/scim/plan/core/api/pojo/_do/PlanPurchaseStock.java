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

@ApiModel(description = "备料采购单 ")
@Entity
@TableName("plan_purchase_stock")
@Table(name = "plan_purchase_stock")
public class PlanPurchaseStock implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "stockId", value = "备料单id")
   @JsonProperty("stockId")
   @JSONField(name = "stockId")
   @TableField("stock_id")
   @Column(name = "stock_id")
   private Long stockId;
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
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   @TableField("length")
   @Column(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "thickness", value = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "theoryThickness", value = "理论厚度(厚度四舍五入)")
   @JsonProperty("theoryThickness")
   @JSONField(name = "theoryThickness")
   @TableField("theory_thickness")
   @Column(name = "theory_thickness")
   private BigDecimal theoryThickness;
   @ApiModelProperty(name = "width", notes = "宽度（mm）")
   @JsonProperty("width")
   @JSONField(name = "width")
   @TableField("width")
   @Column(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private BigDecimal quantity;
   @ApiModelProperty(name = "theoryWeight", value = "理论重量")
   @JsonProperty("theoryWeight")
   @JSONField(name = "theoryWeight")
   @TableField("theory_weight")
   @Column(name = "theory_weight")
   private BigDecimal theoryWeight;
   @ApiModelProperty(name = "oneTheoryWeight", value = "单件理论重量")
   @JsonProperty("oneTheoryWeight")
   @JSONField(name = "oneTheoryWeight")
   @TableField("one_theory_weight")
   @Column(name = "one_theory_weight")
   private BigDecimal oneTheoryWeight;
   @ApiModelProperty(name = "mete", value = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete")
   private BigDecimal mete;
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
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   @JsonProperty("accountingPrecision")
   @JSONField(name = "accountingPrecision")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit")
   private String accountingUnit;
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
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "standardId", value = "型材执行国标ID")
   @JsonProperty("standardId")
   @JSONField(name = "standardId")
   @TableField("standard_id")
   @Column(name = "standard_id")
   private Long standardId;
   @ApiModelProperty(name = "nationalStandard", value = "型材执行国标名称")
   @JsonProperty("nationalStandard")
   @JSONField(name = "nationalStandard")
   @TableField("national_standard")
   @Column(name = "national_standard")
   private String nationalStandard;
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

   public static PlanPurchaseStock.PlanPurchaseStockBuilder builder() {
      return new PlanPurchaseStock.PlanPurchaseStockBuilder();
   }

   public PlanPurchaseStock() {
   }

   public PlanPurchaseStock(
      final Long id,
      final Long stockId,
      final Long classifyId,
      final Integer basicClass,
      final String classifyName,
      final String specification,
      final String serialNumber,
      final BigDecimal length,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal width,
      final BigDecimal quantity,
      final BigDecimal theoryWeight,
      final BigDecimal oneTheoryWeight,
      final BigDecimal mete,
      final String measureUnit,
      final Integer measurePrecision,
      final Integer accountingPrecision,
      final String accountingUnit,
      final BigDecimal unitNet,
      final String brand,
      final String remark,
      final Long standardId,
      final String nationalStandard,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final Integer version
   ) {
      this.id = id;
      this.stockId = stockId;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.classifyName = classifyName;
      this.specification = specification;
      this.serialNumber = serialNumber;
      this.length = length;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.width = width;
      this.quantity = quantity;
      this.theoryWeight = theoryWeight;
      this.oneTheoryWeight = oneTheoryWeight;
      this.mete = mete;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.accountingPrecision = accountingPrecision;
      this.accountingUnit = accountingUnit;
      this.unitNet = unitNet;
      this.brand = brand;
      this.remark = remark;
      this.standardId = standardId;
      this.nationalStandard = nationalStandard;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.version = version;
   }

   public Long getId() {
      return this.id;
   }

   public Long getStockId() {
      return this.stockId;
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

   public String getSpecification() {
      return this.specification;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTheoryWeight() {
      return this.theoryWeight;
   }

   public BigDecimal getOneTheoryWeight() {
      return this.oneTheoryWeight;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
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
   public PlanPurchaseStock setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("stockId")
   public PlanPurchaseStock setStockId(final Long stockId) {
      this.stockId = stockId;
      return this;
   }

   @JsonProperty("classifyId")
   public PlanPurchaseStock setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("basicClass")
   public PlanPurchaseStock setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyName")
   public PlanPurchaseStock setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("specification")
   public PlanPurchaseStock setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("serialNumber")
   public PlanPurchaseStock setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("length")
   public PlanPurchaseStock setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("thickness")
   public PlanPurchaseStock setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("theoryThickness")
   public PlanPurchaseStock setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
      return this;
   }

   @JsonProperty("width")
   public PlanPurchaseStock setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("quantity")
   public PlanPurchaseStock setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("theoryWeight")
   public PlanPurchaseStock setTheoryWeight(final BigDecimal theoryWeight) {
      this.theoryWeight = theoryWeight;
      return this;
   }

   @JsonProperty("oneTheoryWeight")
   public PlanPurchaseStock setOneTheoryWeight(final BigDecimal oneTheoryWeight) {
      this.oneTheoryWeight = oneTheoryWeight;
      return this;
   }

   @JsonProperty("mete")
   public PlanPurchaseStock setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("measureUnit")
   public PlanPurchaseStock setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("measurePrecision")
   public PlanPurchaseStock setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
      return this;
   }

   @JsonProperty("accountingPrecision")
   public PlanPurchaseStock setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   @JsonProperty("accountingUnit")
   public PlanPurchaseStock setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("unitNet")
   public PlanPurchaseStock setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("brand")
   public PlanPurchaseStock setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("remark")
   public PlanPurchaseStock setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("standardId")
   public PlanPurchaseStock setStandardId(final Long standardId) {
      this.standardId = standardId;
      return this;
   }

   @JsonProperty("nationalStandard")
   public PlanPurchaseStock setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
      return this;
   }

   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public PlanPurchaseStock setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public PlanPurchaseStock setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   @JsonIgnore
   public PlanPurchaseStock setVersion(final Integer version) {
      this.version = version;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanPurchaseStock)) {
         return false;
      }

      PlanPurchaseStock other = (PlanPurchaseStock)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$stockId = this.getStockId();
         Object other$stockId = other.getStockId();
         if (this$stockId == null ? other$stockId == null : this$stockId.equals(other$stockId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$measurePrecision = this.getMeasurePrecision();
                  Object other$measurePrecision = other.getMeasurePrecision();
                  if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                     Object this$accountingPrecision = this.getAccountingPrecision();
                     Object other$accountingPrecision = other.getAccountingPrecision();
                     if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                        Object this$standardId = this.getStandardId();
                        Object other$standardId = other.getStandardId();
                        if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                           Object this$version = this.getVersion();
                           Object other$version = other.getVersion();
                           if (this$version == null ? other$version == null : this$version.equals(other$version)) {
                              Object this$classifyName = this.getClassifyName();
                              Object other$classifyName = other.getClassifyName();
                              if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$length = this.getLength();
                                       Object other$length = other.getLength();
                                       if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                          Object this$thickness = this.getThickness();
                                          Object other$thickness = other.getThickness();
                                          if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                             Object this$theoryThickness = this.getTheoryThickness();
                                             Object other$theoryThickness = other.getTheoryThickness();
                                             if (this$theoryThickness == null
                                                ? other$theoryThickness == null
                                                : this$theoryThickness.equals(other$theoryThickness)) {
                                                Object this$width = this.getWidth();
                                                Object other$width = other.getWidth();
                                                if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                   Object this$quantity = this.getQuantity();
                                                   Object other$quantity = other.getQuantity();
                                                   if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                      Object this$theoryWeight = this.getTheoryWeight();
                                                      Object other$theoryWeight = other.getTheoryWeight();
                                                      if (this$theoryWeight == null ? other$theoryWeight == null : this$theoryWeight.equals(other$theoryWeight)
                                                         )
                                                       {
                                                         Object this$oneTheoryWeight = this.getOneTheoryWeight();
                                                         Object other$oneTheoryWeight = other.getOneTheoryWeight();
                                                         if (this$oneTheoryWeight == null
                                                            ? other$oneTheoryWeight == null
                                                            : this$oneTheoryWeight.equals(other$oneTheoryWeight)) {
                                                            Object this$mete = this.getMete();
                                                            Object other$mete = other.getMete();
                                                            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                               Object this$measureUnit = this.getMeasureUnit();
                                                               Object other$measureUnit = other.getMeasureUnit();
                                                               if (this$measureUnit == null
                                                                  ? other$measureUnit == null
                                                                  : this$measureUnit.equals(other$measureUnit)) {
                                                                  Object this$accountingUnit = this.getAccountingUnit();
                                                                  Object other$accountingUnit = other.getAccountingUnit();
                                                                  if (this$accountingUnit == null
                                                                     ? other$accountingUnit == null
                                                                     : this$accountingUnit.equals(other$accountingUnit)) {
                                                                     Object this$unitNet = this.getUnitNet();
                                                                     Object other$unitNet = other.getUnitNet();
                                                                     if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                                        Object this$brand = this.getBrand();
                                                                        Object other$brand = other.getBrand();
                                                                        if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                           Object this$remark = this.getRemark();
                                                                           Object other$remark = other.getRemark();
                                                                           if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                              Object this$nationalStandard = this.getNationalStandard();
                                                                              Object other$nationalStandard = other.getNationalStandard();
                                                                              if (this$nationalStandard == null
                                                                                 ? other$nationalStandard == null
                                                                                 : this$nationalStandard.equals(other$nationalStandard)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanPurchaseStock;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $stockId = this.getStockId();
      result = result * 59 + ($stockId == null ? 43 : $stockId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $theoryWeight = this.getTheoryWeight();
      result = result * 59 + ($theoryWeight == null ? 43 : $theoryWeight.hashCode());
      Object $oneTheoryWeight = this.getOneTheoryWeight();
      result = result * 59 + ($oneTheoryWeight == null ? 43 : $oneTheoryWeight.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "PlanPurchaseStock(id="
         + this.getId()
         + ", stockId="
         + this.getStockId()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", length="
         + this.getLength()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", width="
         + this.getWidth()
         + ", quantity="
         + this.getQuantity()
         + ", theoryWeight="
         + this.getTheoryWeight()
         + ", oneTheoryWeight="
         + this.getOneTheoryWeight()
         + ", mete="
         + this.getMete()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", unitNet="
         + this.getUnitNet()
         + ", brand="
         + this.getBrand()
         + ", remark="
         + this.getRemark()
         + ", standardId="
         + this.getStandardId()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", version="
         + this.getVersion()
         + ")";
   }

   public static class PlanPurchaseStockBuilder {
      private Long id;
      private Long stockId;
      private Long classifyId;
      private Integer basicClass;
      private String classifyName;
      private String specification;
      private String serialNumber;
      private BigDecimal length;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal width;
      private BigDecimal quantity;
      private BigDecimal theoryWeight;
      private BigDecimal oneTheoryWeight;
      private BigDecimal mete;
      private String measureUnit;
      private Integer measurePrecision;
      private Integer accountingPrecision;
      private String accountingUnit;
      private BigDecimal unitNet;
      private String brand;
      private String remark;
      private Long standardId;
      private String nationalStandard;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private Integer version;

      PlanPurchaseStockBuilder() {
      }

      @JsonProperty("id")
      public PlanPurchaseStock.PlanPurchaseStockBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("stockId")
      public PlanPurchaseStock.PlanPurchaseStockBuilder stockId(final Long stockId) {
         this.stockId = stockId;
         return this;
      }

      @JsonProperty("classifyId")
      public PlanPurchaseStock.PlanPurchaseStockBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("basicClass")
      public PlanPurchaseStock.PlanPurchaseStockBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyName")
      public PlanPurchaseStock.PlanPurchaseStockBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public PlanPurchaseStock.PlanPurchaseStockBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("serialNumber")
      public PlanPurchaseStock.PlanPurchaseStockBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("length")
      public PlanPurchaseStock.PlanPurchaseStockBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("thickness")
      public PlanPurchaseStock.PlanPurchaseStockBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("theoryThickness")
      public PlanPurchaseStock.PlanPurchaseStockBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      @JsonProperty("width")
      public PlanPurchaseStock.PlanPurchaseStockBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("quantity")
      public PlanPurchaseStock.PlanPurchaseStockBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("theoryWeight")
      public PlanPurchaseStock.PlanPurchaseStockBuilder theoryWeight(final BigDecimal theoryWeight) {
         this.theoryWeight = theoryWeight;
         return this;
      }

      @JsonProperty("oneTheoryWeight")
      public PlanPurchaseStock.PlanPurchaseStockBuilder oneTheoryWeight(final BigDecimal oneTheoryWeight) {
         this.oneTheoryWeight = oneTheoryWeight;
         return this;
      }

      @JsonProperty("mete")
      public PlanPurchaseStock.PlanPurchaseStockBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("measureUnit")
      public PlanPurchaseStock.PlanPurchaseStockBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("measurePrecision")
      public PlanPurchaseStock.PlanPurchaseStockBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      @JsonProperty("accountingPrecision")
      public PlanPurchaseStock.PlanPurchaseStockBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      @JsonProperty("accountingUnit")
      public PlanPurchaseStock.PlanPurchaseStockBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("unitNet")
      public PlanPurchaseStock.PlanPurchaseStockBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("brand")
      public PlanPurchaseStock.PlanPurchaseStockBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("remark")
      public PlanPurchaseStock.PlanPurchaseStockBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("standardId")
      public PlanPurchaseStock.PlanPurchaseStockBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      @JsonProperty("nationalStandard")
      public PlanPurchaseStock.PlanPurchaseStockBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public PlanPurchaseStock.PlanPurchaseStockBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonIgnore
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public PlanPurchaseStock.PlanPurchaseStockBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      @JsonIgnore
      public PlanPurchaseStock.PlanPurchaseStockBuilder version(final Integer version) {
         this.version = version;
         return this;
      }

      public PlanPurchaseStock build() {
         return new PlanPurchaseStock(
            this.id,
            this.stockId,
            this.classifyId,
            this.basicClass,
            this.classifyName,
            this.specification,
            this.serialNumber,
            this.length,
            this.thickness,
            this.theoryThickness,
            this.width,
            this.quantity,
            this.theoryWeight,
            this.oneTheoryWeight,
            this.mete,
            this.measureUnit,
            this.measurePrecision,
            this.accountingPrecision,
            this.accountingUnit,
            this.unitNet,
            this.brand,
            this.remark,
            this.standardId,
            this.nationalStandard,
            this.createTime,
            this.updateTime,
            this.version
         );
      }

      @Override
      public String toString() {
         return "PlanPurchaseStock.PlanPurchaseStockBuilder(id="
            + this.id
            + ", stockId="
            + this.stockId
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", serialNumber="
            + this.serialNumber
            + ", length="
            + this.length
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", width="
            + this.width
            + ", quantity="
            + this.quantity
            + ", theoryWeight="
            + this.theoryWeight
            + ", oneTheoryWeight="
            + this.oneTheoryWeight
            + ", mete="
            + this.mete
            + ", measureUnit="
            + this.measureUnit
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", unitNet="
            + this.unitNet
            + ", brand="
            + this.brand
            + ", remark="
            + this.remark
            + ", standardId="
            + this.standardId
            + ", nationalStandard="
            + this.nationalStandard
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
