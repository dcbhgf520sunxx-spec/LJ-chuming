package com.hzchum.scim.plan.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

@ApiModel(value = "TechAuxiliaryPart对象", description = "新配套件表 ")
@Entity
@TableName("tech_auxiliary_part")
@Table(name = "tech_auxiliary_part")
@org.hibernate.annotations.Table(appliesTo = "tech_auxiliary_part", comment = "新配套件表 ")
public class TechAuxiliaryPart extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停1进行中", notes = "状态 0暂停1进行中")
   @TableField("bool_status_enum")
   @Column(name = "bool_status_enum", columnDefinition = "tinyint(1) default '1' COMMENT '状态 0暂停1进行中'", nullable = false)
   private Boolean boolStatusEnum;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(64)  COMMENT '编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(64)  COMMENT '规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）", notes = "长度（mm）")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,8)  COMMENT '长度（mm）'", nullable = false)
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(64)  COMMENT '材质'", nullable = false)
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）", notes = "单净重（kg）")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单净重（kg）'", nullable = false)
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）", notes = "总净重（kg）")
   @TableField("total_net_weight")
   @Column(name = "total_net_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总净重（kg）'", nullable = false)
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）", notes = "单毛重（kg）")
   @TableField("gross_weight")
   @Column(name = "gross_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单毛重（kg）'", nullable = false)
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）", notes = "总毛重（kg）")
   @TableField("total_gross_weight")
   @Column(name = "total_gross_weight", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '总毛重（kg）'", nullable = false)
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(mm2)", notes = "单面积(mm2)")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) default '0.00000000' COMMENT '单面积(mm2)'", nullable = false)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂4未标记")
   @TableField("use_property")
   @Column(name = "use_property", columnDefinition = "int(11)  COMMENT '使用属性 1工地 2工厂 4未标记'", nullable = false)
   private Integer useProperty;
   @ApiModelProperty(name = "auxiliaryClassId", value = "配套件类型ID", notes = "配套件类型ID")
   @TableField("auxiliary_class_id")
   @Column(name = "auxiliary_class_id", columnDefinition = "bigint(20)  COMMENT '配套件类型ID'", nullable = false)
   private Long auxiliaryClassId;
   @ApiModelProperty(name = "machinePartId", value = "对应零件表ID", notes = "对应零件表ID")
   @TableField("machine_part_id")
   @Column(name = "machine_part_id", columnDefinition = "bigint(20)  COMMENT '对应零件表ID'", nullable = false)
   private Long machinePartId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "boolSendDirectly", value = "是否直发件 true 是 false 否")
   @TableField("bool_send_directly")
   @Column(name = "bool_send_directly", nullable = false, columnDefinition = "tinyint(1) default 0 comment '是否直发件 1是 0否'")
   private Boolean boolSendDirectly;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否构件全部零件都是直发件 true 是 false 否")
   @TableField("bool_all_part_send_directly")
   @Column(name = "bool_all_part_send_directly", columnDefinition = "tinyint(1) default 0 comment '是否构件全部零件都是直发件 1是 0否'", nullable = false)
   private Boolean boolAllPartSendDirectly;
   @ApiModelProperty(name = "businessId", value = "商务直发零件表ID")
   @TableField("business_id")
   @Column(name = "business_id", columnDefinition = "bigint(20) DEFAULT NULL COMMENT '商务直发零件表ID'")
   private Long businessId;

   public static TechAuxiliaryPart.TechAuxiliaryPartBuilder builder() {
      return new TechAuxiliaryPart.TechAuxiliaryPartBuilder();
   }

   public TechAuxiliaryPart() {
   }

   public TechAuxiliaryPart(
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
      final Integer useProperty,
      final Long auxiliaryClassId,
      final Long machinePartId,
      final String remark,
      final Boolean boolSendDirectly,
      final Boolean boolAllPartSendDirectly,
      final Long businessId
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
      this.useProperty = useProperty;
      this.auxiliaryClassId = auxiliaryClassId;
      this.machinePartId = machinePartId;
      this.remark = remark;
      this.boolSendDirectly = boolSendDirectly;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      this.businessId = businessId;
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

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public Long getAuxiliaryClassId() {
      return this.auxiliaryClassId;
   }

   public Long getMachinePartId() {
      return this.machinePartId;
   }

   public String getRemark() {
      return this.remark;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public TechAuxiliaryPart setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechAuxiliaryPart setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechAuxiliaryPart setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechAuxiliaryPart setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechAuxiliaryPart setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
      return this;
   }

   public TechAuxiliaryPart setName(final String name) {
      this.name = name;
      return this;
   }

   public TechAuxiliaryPart setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechAuxiliaryPart setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechAuxiliaryPart setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public TechAuxiliaryPart setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TechAuxiliaryPart setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechAuxiliaryPart setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public TechAuxiliaryPart setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public TechAuxiliaryPart setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public TechAuxiliaryPart setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   public TechAuxiliaryPart setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public TechAuxiliaryPart setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
      return this;
   }

   public TechAuxiliaryPart setAuxiliaryClassId(final Long auxiliaryClassId) {
      this.auxiliaryClassId = auxiliaryClassId;
      return this;
   }

   public TechAuxiliaryPart setMachinePartId(final Long machinePartId) {
      this.machinePartId = machinePartId;
      return this;
   }

   public TechAuxiliaryPart setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechAuxiliaryPart setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   public TechAuxiliaryPart setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
      return this;
   }

   public TechAuxiliaryPart setBusinessId(final Long businessId) {
      this.businessId = businessId;
      return this;
   }

   @Override
   public String toString() {
      return "TechAuxiliaryPart(id="
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
         + ", useProperty="
         + this.getUseProperty()
         + ", auxiliaryClassId="
         + this.getAuxiliaryClassId()
         + ", machinePartId="
         + this.getMachinePartId()
         + ", remark="
         + this.getRemark()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ", businessId="
         + this.getBusinessId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechAuxiliaryPart)) {
         return false;
      }

      TechAuxiliaryPart other = (TechAuxiliaryPart)o;
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
                        Object this$useProperty = this.getUseProperty();
                        Object other$useProperty = other.getUseProperty();
                        if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                           Object this$auxiliaryClassId = this.getAuxiliaryClassId();
                           Object other$auxiliaryClassId = other.getAuxiliaryClassId();
                           if (this$auxiliaryClassId == null ? other$auxiliaryClassId == null : this$auxiliaryClassId.equals(other$auxiliaryClassId)) {
                              Object this$machinePartId = this.getMachinePartId();
                              Object other$machinePartId = other.getMachinePartId();
                              if (this$machinePartId == null ? other$machinePartId == null : this$machinePartId.equals(other$machinePartId)) {
                                 Object this$boolSendDirectly = this.getBoolSendDirectly();
                                 Object other$boolSendDirectly = other.getBoolSendDirectly();
                                 if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                    Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                                    Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                                    if (this$boolAllPartSendDirectly == null
                                       ? other$boolAllPartSendDirectly == null
                                       : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                                       Object this$businessId = this.getBusinessId();
                                       Object other$businessId = other.getBusinessId();
                                       if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
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
                                                                        Object this$remark = this.getRemark();
                                                                        Object other$remark = other.getRemark();
                                                                        return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof TechAuxiliaryPart;
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
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $auxiliaryClassId = this.getAuxiliaryClassId();
      result = result * 59 + ($auxiliaryClassId == null ? 43 : $auxiliaryClassId.hashCode());
      Object $machinePartId = this.getMachinePartId();
      result = result * 59 + ($machinePartId == null ? 43 : $machinePartId.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
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
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TechAuxiliaryPartBuilder {
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
      private Integer useProperty;
      private Long auxiliaryClassId;
      private Long machinePartId;
      private String remark;
      private Boolean boolSendDirectly;
      private Boolean boolAllPartSendDirectly;
      private Long businessId;

      TechAuxiliaryPartBuilder() {
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder auxiliaryClassId(final Long auxiliaryClassId) {
         this.auxiliaryClassId = auxiliaryClassId;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder machinePartId(final Long machinePartId) {
         this.machinePartId = machinePartId;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public TechAuxiliaryPart.TechAuxiliaryPartBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public TechAuxiliaryPart build() {
         return new TechAuxiliaryPart(
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
            this.useProperty,
            this.auxiliaryClassId,
            this.machinePartId,
            this.remark,
            this.boolSendDirectly,
            this.boolAllPartSendDirectly,
            this.businessId
         );
      }

      @Override
      public String toString() {
         return "TechAuxiliaryPart.TechAuxiliaryPartBuilder(id="
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
            + ", useProperty="
            + this.useProperty
            + ", auxiliaryClassId="
            + this.auxiliaryClassId
            + ", machinePartId="
            + this.machinePartId
            + ", remark="
            + this.remark
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ", businessId="
            + this.businessId
            + ")";
      }
   }
}
