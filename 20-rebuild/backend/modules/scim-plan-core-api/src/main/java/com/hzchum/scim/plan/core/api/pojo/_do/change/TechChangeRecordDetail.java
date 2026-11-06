package com.hzchum.scim.plan.core.api.pojo._do.change;

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

@ApiModel(value = "TechChangeRecordDetail对象", description = "变更记录详情表 ")
@Entity
@TableName("tech_change_record_detail")
@Table(name = "tech_change_record_detail")
@org.hibernate.annotations.Table(appliesTo = "tech_change_record_detail", comment = "变更记录详情表 ")
public class TechChangeRecordDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "changeRecordId", value = "变更记录表ID", notes = "变更记录表ID")
   @TableField("change_record_id")
   @Column(name = "change_record_id", columnDefinition = "bigint(20)  COMMENT '变更记录表ID'", nullable = false)
   private Long changeRecordId;
   @ApiModelProperty(name = "type", value = "构件变更类型 1修改(二次利用) 2删除  4变更(基础信息)", notes = "构件变更类型 1修改 2删除 4变更(基础信息)")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11)  COMMENT '构件变更类型 1修改 2删除 4变更(基础信息)'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "artifactId", value = "原构件ID", notes = "原构件ID")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '原构件ID'", nullable = false)
   private Long artifactId;
   @ApiModelProperty(name = "name", value = "原构件名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) DEFAULT NULL COMMENT '原构件名称'")
   private String name;
   @ApiModelProperty(name = "changeName", value = "变更后产品名称")
   @TableField("change_name")
   @Column(name = "change_name", columnDefinition = "varchar(565)  COMMENT '' COMMENT '变更后产品名称'")
   private String changeName;
   @ApiModelProperty(name = "quantity", value = "原数量", notes = "原数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '原数量'")
   private Integer quantity;
   @ApiModelProperty(name = "changeQuantity", value = "变更后数量", notes = "变更后数量")
   @TableField("change_quantity")
   @Column(name = "change_quantity", columnDefinition = "int(11)  COMMENT '变更后数量'")
   private Integer changeQuantity;
   @ApiModelProperty(name = "sortNumber", value = "原序号", notes = "原序号")
   @TableField("sort_number")
   @Column(name = "sort_number", columnDefinition = "int(11)  COMMENT '原序号'")
   private Integer sortNumber;
   @ApiModelProperty(name = "changeSortNumber", value = "变更后的序号", notes = "变更后的序号")
   @TableField("change_sort_number")
   @Column(name = "change_sort_number", columnDefinition = "varchar(255)  COMMENT '变更后的序号'")
   private String changeSortNumber;
   @ApiModelProperty(name = "serialNumber", value = "原编号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255) COMMENT '原编号'", nullable = false)
   private String serialNumber;
   @ApiModelProperty(name = "changeSerialNumber", value = "变更后的编号", notes = "变更后的编号")
   @TableField("change_serial_number")
   @Column(name = "change_serial_number", columnDefinition = "varchar(255)  COMMENT '变更后的编号'")
   private String changeSerialNumber;
   @ApiModelProperty(name = "specification", value = "原规格")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(255) COMMENT '原规格'", nullable = false)
   private String specification;
   @ApiModelProperty(name = "material", value = "原材质")
   @TableField("material")
   @Column(name = "material", columnDefinition = "varchar(255) COMMENT '原材质'")
   private String material;
   @ApiModelProperty(name = "length", value = "原长度（mm）")
   @TableField("length")
   @Column(name = "length", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '原长度(mm)'")
   private BigDecimal length;
   @ApiModelProperty(name = "changeLength", value = "变更后长度（mm）")
   @TableField("change_length")
   @Column(name = "change_length", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '变更后长度（mm）'")
   private BigDecimal changeLength;
   @ApiModelProperty(name = "netWeight", value = "原单净重（kg）")
   @TableField("net_weight")
   @Column(name = "net_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '原单净重(kg)'")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "changeNetWeight", value = "变更后单净重（kg）")
   @TableField("change_net_weight")
   @Column(name = "change_net_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '变更后单净重（kg）'")
   private BigDecimal changeNetWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @TableField("gross_weight")
   @Column(name = "gross_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '单毛重(kg)'")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "changeGrossWeight", value = "变更后单毛重（kg）")
   @TableField("change_gross_weight")
   @Column(name = "change_gross_weight", columnDefinition = "decimal(32,4) DEFAULT 0.0 COMMENT '变更后单毛重(kg)'")
   private BigDecimal changeGrossWeight;
   @ApiModelProperty(name = "surfaceArea", value = "原单面积（mm²）")
   @TableField("surface_area")
   @Column(name = "surface_area", columnDefinition = "decimal(32,8) DEFAULT 0.0 COMMENT '原单面积(mm²)'")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "changeSurfaceArea", value = "变更后单面积（mm²）")
   @TableField("change_surface_area")
   @Column(name = "change_surface_area", columnDefinition = "decimal(32,8) DEFAULT 0.0 COMMENT '变更后单面积(mm²)'")
   private BigDecimal changeSurfaceArea;
   @ApiModelProperty(name = "boolSameNumber", value = "是否存在相同编号构件(已存在的构件数量为1)")
   @TableField("bool_same_number")
   @Column(name = "bool_same_number", columnDefinition = "tinyint(1)  default 0 comment '是否存在相同编号构件(已存在的构件数量为1)'")
   private Boolean boolSameNumber;
   @ApiModelProperty(name = "printedCode", value = "原喷印编码")
   @JsonProperty("printedCode")
   @JSONField(name = "printedCode")
   @TableField("printed_code")
   @Column(name = "printed_code", columnDefinition = "varchar(255) COMMENT '原喷印编码'")
   private String printedCode;
   @ApiModelProperty(name = "changePrintedCode", value = "修改后喷印编码")
   @JsonProperty("changePrintedCode")
   @JSONField(name = "changePrintedCode")
   @TableField("change_printed_code")
   @Column(name = "change_printed_code", columnDefinition = "varchar(255) COMMENT '修改后喷印编码'")
   private String changePrintedCode;

   public static TechChangeRecordDetail.TechChangeRecordDetailBuilder builder() {
      return new TechChangeRecordDetail.TechChangeRecordDetailBuilder();
   }

   public TechChangeRecordDetail() {
   }

   public TechChangeRecordDetail(
      final Long id,
      final Long changeRecordId,
      final Integer type,
      final Long artifactId,
      final String name,
      final String changeName,
      final Integer quantity,
      final Integer changeQuantity,
      final Integer sortNumber,
      final String changeSortNumber,
      final String serialNumber,
      final String changeSerialNumber,
      final String specification,
      final String material,
      final BigDecimal length,
      final BigDecimal changeLength,
      final BigDecimal netWeight,
      final BigDecimal changeNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal changeGrossWeight,
      final BigDecimal surfaceArea,
      final BigDecimal changeSurfaceArea,
      final Boolean boolSameNumber,
      final String printedCode,
      final String changePrintedCode
   ) {
      this.id = id;
      this.changeRecordId = changeRecordId;
      this.type = type;
      this.artifactId = artifactId;
      this.name = name;
      this.changeName = changeName;
      this.quantity = quantity;
      this.changeQuantity = changeQuantity;
      this.sortNumber = sortNumber;
      this.changeSortNumber = changeSortNumber;
      this.serialNumber = serialNumber;
      this.changeSerialNumber = changeSerialNumber;
      this.specification = specification;
      this.material = material;
      this.length = length;
      this.changeLength = changeLength;
      this.netWeight = netWeight;
      this.changeNetWeight = changeNetWeight;
      this.grossWeight = grossWeight;
      this.changeGrossWeight = changeGrossWeight;
      this.surfaceArea = surfaceArea;
      this.changeSurfaceArea = changeSurfaceArea;
      this.boolSameNumber = boolSameNumber;
      this.printedCode = printedCode;
      this.changePrintedCode = changePrintedCode;
   }

   public Long getId() {
      return this.id;
   }

   public Long getChangeRecordId() {
      return this.changeRecordId;
   }

   public Integer getType() {
      return this.type;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public String getName() {
      return this.name;
   }

   public String getChangeName() {
      return this.changeName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getChangeQuantity() {
      return this.changeQuantity;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public String getChangeSortNumber() {
      return this.changeSortNumber;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getChangeSerialNumber() {
      return this.changeSerialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getChangeLength() {
      return this.changeLength;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getChangeNetWeight() {
      return this.changeNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getChangeGrossWeight() {
      return this.changeGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getChangeSurfaceArea() {
      return this.changeSurfaceArea;
   }

   public Boolean getBoolSameNumber() {
      return this.boolSameNumber;
   }

   public String getPrintedCode() {
      return this.printedCode;
   }

   public String getChangePrintedCode() {
      return this.changePrintedCode;
   }

   public TechChangeRecordDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechChangeRecordDetail setChangeRecordId(final Long changeRecordId) {
      this.changeRecordId = changeRecordId;
      return this;
   }

   public TechChangeRecordDetail setType(final Integer type) {
      this.type = type;
      return this;
   }

   public TechChangeRecordDetail setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   public TechChangeRecordDetail setName(final String name) {
      this.name = name;
      return this;
   }

   public TechChangeRecordDetail setChangeName(final String changeName) {
      this.changeName = changeName;
      return this;
   }

   public TechChangeRecordDetail setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechChangeRecordDetail setChangeQuantity(final Integer changeQuantity) {
      this.changeQuantity = changeQuantity;
      return this;
   }

   public TechChangeRecordDetail setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
      return this;
   }

   public TechChangeRecordDetail setChangeSortNumber(final String changeSortNumber) {
      this.changeSortNumber = changeSortNumber;
      return this;
   }

   public TechChangeRecordDetail setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechChangeRecordDetail setChangeSerialNumber(final String changeSerialNumber) {
      this.changeSerialNumber = changeSerialNumber;
      return this;
   }

   public TechChangeRecordDetail setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechChangeRecordDetail setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public TechChangeRecordDetail setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public TechChangeRecordDetail setChangeLength(final BigDecimal changeLength) {
      this.changeLength = changeLength;
      return this;
   }

   public TechChangeRecordDetail setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   public TechChangeRecordDetail setChangeNetWeight(final BigDecimal changeNetWeight) {
      this.changeNetWeight = changeNetWeight;
      return this;
   }

   public TechChangeRecordDetail setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   public TechChangeRecordDetail setChangeGrossWeight(final BigDecimal changeGrossWeight) {
      this.changeGrossWeight = changeGrossWeight;
      return this;
   }

   public TechChangeRecordDetail setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public TechChangeRecordDetail setChangeSurfaceArea(final BigDecimal changeSurfaceArea) {
      this.changeSurfaceArea = changeSurfaceArea;
      return this;
   }

   public TechChangeRecordDetail setBoolSameNumber(final Boolean boolSameNumber) {
      this.boolSameNumber = boolSameNumber;
      return this;
   }

   @JsonProperty("printedCode")
   public TechChangeRecordDetail setPrintedCode(final String printedCode) {
      this.printedCode = printedCode;
      return this;
   }

   @JsonProperty("changePrintedCode")
   public TechChangeRecordDetail setChangePrintedCode(final String changePrintedCode) {
      this.changePrintedCode = changePrintedCode;
      return this;
   }

   @Override
   public String toString() {
      return "TechChangeRecordDetail(id="
         + this.getId()
         + ", changeRecordId="
         + this.getChangeRecordId()
         + ", type="
         + this.getType()
         + ", artifactId="
         + this.getArtifactId()
         + ", name="
         + this.getName()
         + ", changeName="
         + this.getChangeName()
         + ", quantity="
         + this.getQuantity()
         + ", changeQuantity="
         + this.getChangeQuantity()
         + ", sortNumber="
         + this.getSortNumber()
         + ", changeSortNumber="
         + this.getChangeSortNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", changeSerialNumber="
         + this.getChangeSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", length="
         + this.getLength()
         + ", changeLength="
         + this.getChangeLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", changeNetWeight="
         + this.getChangeNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", changeGrossWeight="
         + this.getChangeGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", changeSurfaceArea="
         + this.getChangeSurfaceArea()
         + ", boolSameNumber="
         + this.getBoolSameNumber()
         + ", printedCode="
         + this.getPrintedCode()
         + ", changePrintedCode="
         + this.getChangePrintedCode()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeRecordDetail)) {
         return false;
      }

      TechChangeRecordDetail other = (TechChangeRecordDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$changeRecordId = this.getChangeRecordId();
         Object other$changeRecordId = other.getChangeRecordId();
         if (this$changeRecordId == null ? other$changeRecordId == null : this$changeRecordId.equals(other$changeRecordId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$artifactId = this.getArtifactId();
               Object other$artifactId = other.getArtifactId();
               if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$changeQuantity = this.getChangeQuantity();
                     Object other$changeQuantity = other.getChangeQuantity();
                     if (this$changeQuantity == null ? other$changeQuantity == null : this$changeQuantity.equals(other$changeQuantity)) {
                        Object this$sortNumber = this.getSortNumber();
                        Object other$sortNumber = other.getSortNumber();
                        if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
                           Object this$boolSameNumber = this.getBoolSameNumber();
                           Object other$boolSameNumber = other.getBoolSameNumber();
                           if (this$boolSameNumber == null ? other$boolSameNumber == null : this$boolSameNumber.equals(other$boolSameNumber)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$changeName = this.getChangeName();
                                 Object other$changeName = other.getChangeName();
                                 if (this$changeName == null ? other$changeName == null : this$changeName.equals(other$changeName)) {
                                    Object this$changeSortNumber = this.getChangeSortNumber();
                                    Object other$changeSortNumber = other.getChangeSortNumber();
                                    if (this$changeSortNumber == null ? other$changeSortNumber == null : this$changeSortNumber.equals(other$changeSortNumber)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$changeSerialNumber = this.getChangeSerialNumber();
                                          Object other$changeSerialNumber = other.getChangeSerialNumber();
                                          if (this$changeSerialNumber == null
                                             ? other$changeSerialNumber == null
                                             : this$changeSerialNumber.equals(other$changeSerialNumber)) {
                                             Object this$specification = this.getSpecification();
                                             Object other$specification = other.getSpecification();
                                             if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                                Object this$material = this.getMaterial();
                                                Object other$material = other.getMaterial();
                                                if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                   Object this$length = this.getLength();
                                                   Object other$length = other.getLength();
                                                   if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                      Object this$changeLength = this.getChangeLength();
                                                      Object other$changeLength = other.getChangeLength();
                                                      if (this$changeLength == null ? other$changeLength == null : this$changeLength.equals(other$changeLength)
                                                         )
                                                       {
                                                         Object this$netWeight = this.getNetWeight();
                                                         Object other$netWeight = other.getNetWeight();
                                                         if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                            Object this$changeNetWeight = this.getChangeNetWeight();
                                                            Object other$changeNetWeight = other.getChangeNetWeight();
                                                            if (this$changeNetWeight == null
                                                               ? other$changeNetWeight == null
                                                               : this$changeNetWeight.equals(other$changeNetWeight)) {
                                                               Object this$grossWeight = this.getGrossWeight();
                                                               Object other$grossWeight = other.getGrossWeight();
                                                               if (this$grossWeight == null
                                                                  ? other$grossWeight == null
                                                                  : this$grossWeight.equals(other$grossWeight)) {
                                                                  Object this$changeGrossWeight = this.getChangeGrossWeight();
                                                                  Object other$changeGrossWeight = other.getChangeGrossWeight();
                                                                  if (this$changeGrossWeight == null
                                                                     ? other$changeGrossWeight == null
                                                                     : this$changeGrossWeight.equals(other$changeGrossWeight)) {
                                                                     Object this$surfaceArea = this.getSurfaceArea();
                                                                     Object other$surfaceArea = other.getSurfaceArea();
                                                                     if (this$surfaceArea == null
                                                                        ? other$surfaceArea == null
                                                                        : this$surfaceArea.equals(other$surfaceArea)) {
                                                                        Object this$changeSurfaceArea = this.getChangeSurfaceArea();
                                                                        Object other$changeSurfaceArea = other.getChangeSurfaceArea();
                                                                        if (this$changeSurfaceArea == null
                                                                           ? other$changeSurfaceArea == null
                                                                           : this$changeSurfaceArea.equals(other$changeSurfaceArea)) {
                                                                           Object this$printedCode = this.getPrintedCode();
                                                                           Object other$printedCode = other.getPrintedCode();
                                                                           if (this$printedCode == null
                                                                              ? other$printedCode == null
                                                                              : this$printedCode.equals(other$printedCode)) {
                                                                              Object this$changePrintedCode = this.getChangePrintedCode();
                                                                              Object other$changePrintedCode = other.getChangePrintedCode();
                                                                              return this$changePrintedCode == null
                                                                                 ? other$changePrintedCode == null
                                                                                 : this$changePrintedCode.equals(other$changePrintedCode);
                                                                           } else {
                                                                              return false;
                                                                           }
                                                                        } else {
                                                                           return false;
                                                                        }
                                                                     } else {
                                                                        return false;
                                                                     }
                                                                  } else {
                                                                     return false;
                                                                  }
                                                               } else {
                                                                  return false;
                                                               }
                                                            } else {
                                                               return false;
                                                            }
                                                         } else {
                                                            return false;
                                                         }
                                                      } else {
                                                         return false;
                                                      }
                                                   } else {
                                                      return false;
                                                   }
                                                } else {
                                                   return false;
                                                }
                                             } else {
                                                return false;
                                             }
                                          } else {
                                             return false;
                                          }
                                       } else {
                                          return false;
                                       }
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof TechChangeRecordDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeRecordId = this.getChangeRecordId();
      result = result * 59 + ($changeRecordId == null ? 43 : $changeRecordId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $changeQuantity = this.getChangeQuantity();
      result = result * 59 + ($changeQuantity == null ? 43 : $changeQuantity.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $boolSameNumber = this.getBoolSameNumber();
      result = result * 59 + ($boolSameNumber == null ? 43 : $boolSameNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $changeName = this.getChangeName();
      result = result * 59 + ($changeName == null ? 43 : $changeName.hashCode());
      Object $changeSortNumber = this.getChangeSortNumber();
      result = result * 59 + ($changeSortNumber == null ? 43 : $changeSortNumber.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $changeSerialNumber = this.getChangeSerialNumber();
      result = result * 59 + ($changeSerialNumber == null ? 43 : $changeSerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $changeLength = this.getChangeLength();
      result = result * 59 + ($changeLength == null ? 43 : $changeLength.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $changeNetWeight = this.getChangeNetWeight();
      result = result * 59 + ($changeNetWeight == null ? 43 : $changeNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $changeGrossWeight = this.getChangeGrossWeight();
      result = result * 59 + ($changeGrossWeight == null ? 43 : $changeGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $changeSurfaceArea = this.getChangeSurfaceArea();
      result = result * 59 + ($changeSurfaceArea == null ? 43 : $changeSurfaceArea.hashCode());
      Object $printedCode = this.getPrintedCode();
      result = result * 59 + ($printedCode == null ? 43 : $printedCode.hashCode());
      Object $changePrintedCode = this.getChangePrintedCode();
      return result * 59 + ($changePrintedCode == null ? 43 : $changePrintedCode.hashCode());
   }

   public static class TechChangeRecordDetailBuilder {
      private Long id;
      private Long changeRecordId;
      private Integer type;
      private Long artifactId;
      private String name;
      private String changeName;
      private Integer quantity;
      private Integer changeQuantity;
      private Integer sortNumber;
      private String changeSortNumber;
      private String serialNumber;
      private String changeSerialNumber;
      private String specification;
      private String material;
      private BigDecimal length;
      private BigDecimal changeLength;
      private BigDecimal netWeight;
      private BigDecimal changeNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal changeGrossWeight;
      private BigDecimal surfaceArea;
      private BigDecimal changeSurfaceArea;
      private Boolean boolSameNumber;
      private String printedCode;
      private String changePrintedCode;

      TechChangeRecordDetailBuilder() {
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder changeRecordId(final Long changeRecordId) {
         this.changeRecordId = changeRecordId;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder changeName(final String changeName) {
         this.changeName = changeName;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder changeQuantity(final Integer changeQuantity) {
         this.changeQuantity = changeQuantity;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder changeSortNumber(final String changeSortNumber) {
         this.changeSortNumber = changeSortNumber;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder changeSerialNumber(final String changeSerialNumber) {
         this.changeSerialNumber = changeSerialNumber;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder changeLength(final BigDecimal changeLength) {
         this.changeLength = changeLength;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder changeNetWeight(final BigDecimal changeNetWeight) {
         this.changeNetWeight = changeNetWeight;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder changeGrossWeight(final BigDecimal changeGrossWeight) {
         this.changeGrossWeight = changeGrossWeight;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder changeSurfaceArea(final BigDecimal changeSurfaceArea) {
         this.changeSurfaceArea = changeSurfaceArea;
         return this;
      }

      public TechChangeRecordDetail.TechChangeRecordDetailBuilder boolSameNumber(final Boolean boolSameNumber) {
         this.boolSameNumber = boolSameNumber;
         return this;
      }

      @JsonProperty("printedCode")
      public TechChangeRecordDetail.TechChangeRecordDetailBuilder printedCode(final String printedCode) {
         this.printedCode = printedCode;
         return this;
      }

      @JsonProperty("changePrintedCode")
      public TechChangeRecordDetail.TechChangeRecordDetailBuilder changePrintedCode(final String changePrintedCode) {
         this.changePrintedCode = changePrintedCode;
         return this;
      }

      public TechChangeRecordDetail build() {
         return new TechChangeRecordDetail(
            this.id,
            this.changeRecordId,
            this.type,
            this.artifactId,
            this.name,
            this.changeName,
            this.quantity,
            this.changeQuantity,
            this.sortNumber,
            this.changeSortNumber,
            this.serialNumber,
            this.changeSerialNumber,
            this.specification,
            this.material,
            this.length,
            this.changeLength,
            this.netWeight,
            this.changeNetWeight,
            this.grossWeight,
            this.changeGrossWeight,
            this.surfaceArea,
            this.changeSurfaceArea,
            this.boolSameNumber,
            this.printedCode,
            this.changePrintedCode
         );
      }

      @Override
      public String toString() {
         return "TechChangeRecordDetail.TechChangeRecordDetailBuilder(id="
            + this.id
            + ", changeRecordId="
            + this.changeRecordId
            + ", type="
            + this.type
            + ", artifactId="
            + this.artifactId
            + ", name="
            + this.name
            + ", changeName="
            + this.changeName
            + ", quantity="
            + this.quantity
            + ", changeQuantity="
            + this.changeQuantity
            + ", sortNumber="
            + this.sortNumber
            + ", changeSortNumber="
            + this.changeSortNumber
            + ", serialNumber="
            + this.serialNumber
            + ", changeSerialNumber="
            + this.changeSerialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", length="
            + this.length
            + ", changeLength="
            + this.changeLength
            + ", netWeight="
            + this.netWeight
            + ", changeNetWeight="
            + this.changeNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", changeGrossWeight="
            + this.changeGrossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", changeSurfaceArea="
            + this.changeSurfaceArea
            + ", boolSameNumber="
            + this.boolSameNumber
            + ", printedCode="
            + this.printedCode
            + ", changePrintedCode="
            + this.changePrintedCode
            + ")";
      }
   }
}
