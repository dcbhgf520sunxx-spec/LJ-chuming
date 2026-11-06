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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "TechAuxiliaryMaterial对象", description = "配套件辅材表")
@Entity
@TableName("tech_auxiliary_material")
@Table(name = "tech_auxiliary_material")
public class TechAuxiliaryMaterial extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
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
   @ApiModelProperty(name = "monomerId", value = "单体id ")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id")
   private Long monomerId;
   @ApiModelProperty(name = "classifyFullName", value = "分类全称 ")
   @JsonProperty("classifyFullName")
   @JSONField(name = "classifyFullName")
   @TableField("classify_full_name")
   @Column(name = "classify_full_name")
   private String classifyFullName;
   @ApiModelProperty(name = "classifyId", value = "科目id")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name")
   private String classifyName;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   @TableField("serial_number")
   @Column(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification")
   private String specification;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private Integer quantity;
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
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   @TableField("accounting_unit")
   @Column(name = "accounting_unit")
   private String accountingUnit;
   @ApiModelProperty(name = "mete", value = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   @JsonProperty("accountingPrecision")
   @JSONField(name = "accountingPrecision")
   @TableField("accounting_precision")
   @Column(name = "accounting_precision")
   private Integer accountingPrecision;
   @ApiModelProperty(name = "unitNet", value = "单位净量")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   @TableField("unit_net")
   @Column(name = "unit_net")
   private BigDecimal unitNet;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonProperty("color")
   @JSONField(name = "color")
   @TableField("color")
   @Column(name = "color")
   private String color;
   @ApiModelProperty(name = "brand", value = "品牌")
   @JsonProperty("brand")
   @JSONField(name = "brand")
   @TableField("brand")
   @Column(name = "brand")
   private String brand;
   @ApiModelProperty(name = "remark")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "userId", value = "创建人id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id")
   private Long userId;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地使用 2工厂使用")
   @JsonProperty("useProperty")
   @JSONField(name = "useProperty")
   @TableField("use_property")
   @Column(name = "use_property")
   private Integer useProperty;
   @ApiModelProperty("商务id")
   @Column
   private Long businessId;
   @ApiModelProperty("打印数量")
   @Column
   private Integer printQuantity;
   @ApiModelProperty("打印时间")
   @Column
   private LocalDateTime printTime;

   public static TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder builder() {
      return new TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder();
   }

   public TechAuxiliaryMaterial() {
   }

   public TechAuxiliaryMaterial(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final String classifyFullName,
      final Long classifyId,
      final String classifyName,
      final String serialNumber,
      final String specification,
      final Integer quantity,
      final String measureUnit,
      final Integer measurePrecision,
      final String accountingUnit,
      final BigDecimal mete,
      final Integer accountingPrecision,
      final BigDecimal unitNet,
      final String color,
      final String brand,
      final String remark,
      final Long userId,
      final Integer useProperty,
      final Long businessId,
      final Integer printQuantity,
      final LocalDateTime printTime
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.classifyFullName = classifyFullName;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.accountingPrecision = accountingPrecision;
      this.unitNet = unitNet;
      this.color = color;
      this.brand = brand;
      this.remark = remark;
      this.userId = userId;
      this.useProperty = useProperty;
      this.businessId = businessId;
      this.printQuantity = printQuantity;
      this.printTime = printTime;
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

   public String getClassifyFullName() {
      return this.classifyFullName;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   @JsonProperty("id")
   public TechAuxiliaryMaterial setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public TechAuxiliaryMaterial setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public TechAuxiliaryMaterial setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("classifyFullName")
   public TechAuxiliaryMaterial setClassifyFullName(final String classifyFullName) {
      this.classifyFullName = classifyFullName;
      return this;
   }

   @JsonProperty("classifyId")
   public TechAuxiliaryMaterial setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public TechAuxiliaryMaterial setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("serialNumber")
   public TechAuxiliaryMaterial setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public TechAuxiliaryMaterial setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public TechAuxiliaryMaterial setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("measureUnit")
   public TechAuxiliaryMaterial setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("measurePrecision")
   public TechAuxiliaryMaterial setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
      return this;
   }

   @JsonProperty("accountingUnit")
   public TechAuxiliaryMaterial setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("mete")
   public TechAuxiliaryMaterial setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("accountingPrecision")
   public TechAuxiliaryMaterial setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
      return this;
   }

   @JsonProperty("unitNet")
   public TechAuxiliaryMaterial setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
      return this;
   }

   @JsonProperty("color")
   public TechAuxiliaryMaterial setColor(final String color) {
      this.color = color;
      return this;
   }

   @JsonProperty("brand")
   public TechAuxiliaryMaterial setBrand(final String brand) {
      this.brand = brand;
      return this;
   }

   @JsonProperty("remark")
   public TechAuxiliaryMaterial setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("userId")
   public TechAuxiliaryMaterial setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("useProperty")
   public TechAuxiliaryMaterial setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
      return this;
   }

   public TechAuxiliaryMaterial setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   public TechAuxiliaryMaterial setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   public TechAuxiliaryMaterial setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
      return this;
   }

   @Override
   public String toString() {
      return "TechAuxiliaryMaterial(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", classifyFullName="
         + this.getClassifyFullName()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", unitNet="
         + this.getUnitNet()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", remark="
         + this.getRemark()
         + ", userId="
         + this.getUserId()
         + ", useProperty="
         + this.getUseProperty()
         + ", businessId="
         + this.getBusinessId()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", printTime="
         + this.getPrintTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAuxiliaryMaterial)) {
         return false;
      }

      TechAuxiliaryMaterial other = (TechAuxiliaryMaterial)o;
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
               Object this$classifyId = this.getClassifyId();
               Object other$classifyId = other.getClassifyId();
               if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$measurePrecision = this.getMeasurePrecision();
                     Object other$measurePrecision = other.getMeasurePrecision();
                     if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                        Object this$accountingPrecision = this.getAccountingPrecision();
                        Object other$accountingPrecision = other.getAccountingPrecision();
                        if (this$accountingPrecision == null ? other$accountingPrecision == null : this$accountingPrecision.equals(other$accountingPrecision)) {
                           Object this$userId = this.getUserId();
                           Object other$userId = other.getUserId();
                           if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                              Object this$useProperty = this.getUseProperty();
                              Object other$useProperty = other.getUseProperty();
                              if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                                 Object this$businessId = this.getBusinessId();
                                 Object other$businessId = other.getBusinessId();
                                 if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                                    Object this$printQuantity = this.getPrintQuantity();
                                    Object other$printQuantity = other.getPrintQuantity();
                                    if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
                                       Object this$classifyFullName = this.getClassifyFullName();
                                       Object other$classifyFullName = other.getClassifyFullName();
                                       if (this$classifyFullName == null
                                          ? other$classifyFullName == null
                                          : this$classifyFullName.equals(other$classifyFullName)) {
                                          Object this$classifyName = this.getClassifyName();
                                          Object other$classifyName = other.getClassifyName();
                                          if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                   Object this$measureUnit = this.getMeasureUnit();
                                                   Object other$measureUnit = other.getMeasureUnit();
                                                   if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                      Object this$accountingUnit = this.getAccountingUnit();
                                                      Object other$accountingUnit = other.getAccountingUnit();
                                                      if (this$accountingUnit == null
                                                         ? other$accountingUnit == null
                                                         : this$accountingUnit.equals(other$accountingUnit)) {
                                                         Object this$mete = this.getMete();
                                                         Object other$mete = other.getMete();
                                                         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                            Object this$unitNet = this.getUnitNet();
                                                            Object other$unitNet = other.getUnitNet();
                                                            if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                               Object this$color = this.getColor();
                                                               Object other$color = other.getColor();
                                                               if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                  Object this$brand = this.getBrand();
                                                                  Object other$brand = other.getBrand();
                                                                  if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                     Object this$remark = this.getRemark();
                                                                     Object other$remark = other.getRemark();
                                                                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                        Object this$printTime = this.getPrintTime();
                                                                        Object other$printTime = other.getPrintTime();
                                                                        return this$printTime == null
                                                                           ? other$printTime == null
                                                                           : this$printTime.equals(other$printTime);
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof TechAuxiliaryMaterial;
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
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $classifyFullName = this.getClassifyFullName();
      result = result * 59 + ($classifyFullName == null ? 43 : $classifyFullName.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $printTime = this.getPrintTime();
      return result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
   }

   public static class TechAuxiliaryMaterialBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private String classifyFullName;
      private Long classifyId;
      private String classifyName;
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private String measureUnit;
      private Integer measurePrecision;
      private String accountingUnit;
      private BigDecimal mete;
      private Integer accountingPrecision;
      private BigDecimal unitNet;
      private String color;
      private String brand;
      private String remark;
      private Long userId;
      private Integer useProperty;
      private Long businessId;
      private Integer printQuantity;
      private LocalDateTime printTime;

      TechAuxiliaryMaterialBuilder() {
      }

      @JsonProperty("id")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("classifyFullName")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder classifyFullName(final String classifyFullName) {
         this.classifyFullName = classifyFullName;
         return this;
      }

      @JsonProperty("classifyId")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("serialNumber")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("measureUnit")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("measurePrecision")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      @JsonProperty("accountingUnit")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("mete")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("accountingPrecision")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      @JsonProperty("unitNet")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      @JsonProperty("color")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder color(final String color) {
         this.color = color;
         return this;
      }

      @JsonProperty("brand")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      @JsonProperty("remark")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("userId")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("useProperty")
      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      public TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      public TechAuxiliaryMaterial build() {
         return new TechAuxiliaryMaterial(
            this.id,
            this.projectId,
            this.monomerId,
            this.classifyFullName,
            this.classifyId,
            this.classifyName,
            this.serialNumber,
            this.specification,
            this.quantity,
            this.measureUnit,
            this.measurePrecision,
            this.accountingUnit,
            this.mete,
            this.accountingPrecision,
            this.unitNet,
            this.color,
            this.brand,
            this.remark,
            this.userId,
            this.useProperty,
            this.businessId,
            this.printQuantity,
            this.printTime
         );
      }

      @Override
      public String toString() {
         return "TechAuxiliaryMaterial.TechAuxiliaryMaterialBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", classifyFullName="
            + this.classifyFullName
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", measureUnit="
            + this.measureUnit
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", unitNet="
            + this.unitNet
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", remark="
            + this.remark
            + ", userId="
            + this.userId
            + ", useProperty="
            + this.useProperty
            + ", businessId="
            + this.businessId
            + ", printQuantity="
            + this.printQuantity
            + ", printTime="
            + this.printTime
            + ")";
      }
   }
}
