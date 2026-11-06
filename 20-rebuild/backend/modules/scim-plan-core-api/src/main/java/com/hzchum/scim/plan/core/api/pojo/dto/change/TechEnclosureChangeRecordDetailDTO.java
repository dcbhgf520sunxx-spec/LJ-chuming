package com.hzchum.scim.plan.core.api.pojo.dto.change;

import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "TechEnclosureChangeRecordDetailDTO对象", description = "")
public class TechEnclosureChangeRecordDetailDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "changeRecordId", value = "变更记录表ID", notes = "变更记录表ID")
   private Long changeRecordId;
   @ApiModelProperty(name = "type", value = "构件变更类型 1修改 2删除 4变更(基础信息)", notes = "构件变更类型 1修改 2删除 4变更(基础信息)")
   private Integer type;
   @ApiModelProperty(name = "enclosureId", value = "围护ID", notes = "围护ID")
   private Long enclosureId;
   @ApiModelProperty(name = "name", value = "原构件名称", notes = "原构件名称")
   private String name;
   @ApiModelProperty(name = "changeName", value = "变更后产品名称", notes = "变更后产品名称")
   private String changeName;
   @ApiModelProperty(name = "quantity", value = "原数量", notes = "原数量")
   private Integer quantity;
   @ApiModelProperty(name = "changeQuantity", value = "变更后数量", notes = "变更后数量")
   private Integer changeQuantity;
   @ApiModelProperty(name = "serialNumber", value = "原编号", notes = "原编号")
   private String serialNumber;
   @ApiModelProperty(name = "changeSerialNumber", value = "变更后的编号", notes = "变更后的编号")
   private String changeSerialNumber;
   @ApiModelProperty(name = "specification", value = "原规格", notes = "原规格")
   private String specification;
   @ApiModelProperty(name = "changeSpecification", value = "变更规格", notes = "变更规格")
   private String changeSpecification;
   @ApiModelProperty(name = "width", value = "有效宽度(mm)", notes = "有效宽度(mm)")
   private BigDecimal width;
   @ApiModelProperty(name = "changeWidth", value = "有效宽度(mm)", notes = "有效宽度(mm)")
   private BigDecimal changeWidth;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)", notes = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "changeUnfoldedWidth", value = "变更后展宽(mm)", notes = "变更后展宽(mm)")
   private BigDecimal changeUnfoldedWidth;
   @ApiModelProperty(name = "thickness", value = "板厚(mm)", notes = "板厚(mm)")
   private BigDecimal thickness;
   @ApiModelProperty(name = "changeThickness", value = "变更后板厚(mm)", notes = "变更后板厚(mm)")
   private BigDecimal changeThickness;
   @ApiModelProperty(name = "length", value = "原长度(mm)", notes = "原长度(mm)")
   private BigDecimal length;
   @ApiModelProperty(name = "changeLength", value = "变更后长度（mm）", notes = "变更后长度（mm）")
   private BigDecimal changeLength;
   @ApiModelProperty(name = "weight", value = "重量(kg)", notes = "重量(kg)")
   private BigDecimal weight;
   @ApiModelProperty(name = "changeWeight", value = "变更后单重量（kg）", notes = "变更后单重量（kg）")
   private BigDecimal changeWeight;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "changeRemark", value = "变更后备注", notes = "变更后备注")
   private String changeRemark;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(mm²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "changeSurfaceArea", value = "变更后单面积(mm²)")
   private BigDecimal changeSurfaceArea;

   public static TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder builder() {
      return new TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder();
   }

   public TechEnclosureChangeRecordDetailDTO() {
   }

   public TechEnclosureChangeRecordDetailDTO(
      final Long id,
      final Long changeRecordId,
      final Integer type,
      final Long enclosureId,
      final String name,
      final String changeName,
      final Integer quantity,
      final Integer changeQuantity,
      final String serialNumber,
      final String changeSerialNumber,
      final String specification,
      final String changeSpecification,
      final BigDecimal width,
      final BigDecimal changeWidth,
      final BigDecimal unfoldedWidth,
      final BigDecimal changeUnfoldedWidth,
      final BigDecimal thickness,
      final BigDecimal changeThickness,
      final BigDecimal length,
      final BigDecimal changeLength,
      final BigDecimal weight,
      final BigDecimal changeWeight,
      final String remark,
      final String changeRemark,
      final BigDecimal surfaceArea,
      final BigDecimal changeSurfaceArea
   ) {
      this.id = id;
      this.changeRecordId = changeRecordId;
      this.type = type;
      this.enclosureId = enclosureId;
      this.name = name;
      this.changeName = changeName;
      this.quantity = quantity;
      this.changeQuantity = changeQuantity;
      this.serialNumber = serialNumber;
      this.changeSerialNumber = changeSerialNumber;
      this.specification = specification;
      this.changeSpecification = changeSpecification;
      this.width = width;
      this.changeWidth = changeWidth;
      this.unfoldedWidth = unfoldedWidth;
      this.changeUnfoldedWidth = changeUnfoldedWidth;
      this.thickness = thickness;
      this.changeThickness = changeThickness;
      this.length = length;
      this.changeLength = changeLength;
      this.weight = weight;
      this.changeWeight = changeWeight;
      this.remark = remark;
      this.changeRemark = changeRemark;
      this.surfaceArea = surfaceArea;
      this.changeSurfaceArea = changeSurfaceArea;
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

   public Long getEnclosureId() {
      return this.enclosureId;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getChangeSerialNumber() {
      return this.changeSerialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getChangeSpecification() {
      return this.changeSpecification;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getChangeWidth() {
      return this.changeWidth;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getChangeUnfoldedWidth() {
      return this.changeUnfoldedWidth;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getChangeThickness() {
      return this.changeThickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getChangeLength() {
      return this.changeLength;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getChangeWeight() {
      return this.changeWeight;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getChangeRemark() {
      return this.changeRemark;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getChangeSurfaceArea() {
      return this.changeSurfaceArea;
   }

   public TechEnclosureChangeRecordDetailDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeRecordId(final Long changeRecordId) {
      this.changeRecordId = changeRecordId;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setEnclosureId(final Long enclosureId) {
      this.enclosureId = enclosureId;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setName(final String name) {
      this.name = name;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeName(final String changeName) {
      this.changeName = changeName;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeQuantity(final Integer changeQuantity) {
      this.changeQuantity = changeQuantity;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeSerialNumber(final String changeSerialNumber) {
      this.changeSerialNumber = changeSerialNumber;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeSpecification(final String changeSpecification) {
      this.changeSpecification = changeSpecification;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeWidth(final BigDecimal changeWidth) {
      this.changeWidth = changeWidth;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeUnfoldedWidth(final BigDecimal changeUnfoldedWidth) {
      this.changeUnfoldedWidth = changeUnfoldedWidth;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeThickness(final BigDecimal changeThickness) {
      this.changeThickness = changeThickness;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeLength(final BigDecimal changeLength) {
      this.changeLength = changeLength;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setWeight(final BigDecimal weight) {
      this.weight = weight;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeWeight(final BigDecimal changeWeight) {
      this.changeWeight = changeWeight;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeRemark(final String changeRemark) {
      this.changeRemark = changeRemark;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
      return this;
   }

   public TechEnclosureChangeRecordDetailDTO setChangeSurfaceArea(final BigDecimal changeSurfaceArea) {
      this.changeSurfaceArea = changeSurfaceArea;
      return this;
   }

   @Override
   public String toString() {
      return "TechEnclosureChangeRecordDetailDTO(id="
         + this.getId()
         + ", changeRecordId="
         + this.getChangeRecordId()
         + ", type="
         + this.getType()
         + ", enclosureId="
         + this.getEnclosureId()
         + ", name="
         + this.getName()
         + ", changeName="
         + this.getChangeName()
         + ", quantity="
         + this.getQuantity()
         + ", changeQuantity="
         + this.getChangeQuantity()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", changeSerialNumber="
         + this.getChangeSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", changeSpecification="
         + this.getChangeSpecification()
         + ", width="
         + this.getWidth()
         + ", changeWidth="
         + this.getChangeWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", changeUnfoldedWidth="
         + this.getChangeUnfoldedWidth()
         + ", thickness="
         + this.getThickness()
         + ", changeThickness="
         + this.getChangeThickness()
         + ", length="
         + this.getLength()
         + ", changeLength="
         + this.getChangeLength()
         + ", weight="
         + this.getWeight()
         + ", changeWeight="
         + this.getChangeWeight()
         + ", remark="
         + this.getRemark()
         + ", changeRemark="
         + this.getChangeRemark()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", changeSurfaceArea="
         + this.getChangeSurfaceArea()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosureChangeRecordDetailDTO)) {
         return false;
      }

      TechEnclosureChangeRecordDetailDTO other = (TechEnclosureChangeRecordDetailDTO)o;
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
               Object this$enclosureId = this.getEnclosureId();
               Object other$enclosureId = other.getEnclosureId();
               if (this$enclosureId == null ? other$enclosureId == null : this$enclosureId.equals(other$enclosureId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$changeQuantity = this.getChangeQuantity();
                     Object other$changeQuantity = other.getChangeQuantity();
                     if (this$changeQuantity == null ? other$changeQuantity == null : this$changeQuantity.equals(other$changeQuantity)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$changeName = this.getChangeName();
                           Object other$changeName = other.getChangeName();
                           if (this$changeName == null ? other$changeName == null : this$changeName.equals(other$changeName)) {
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
                                       Object this$changeSpecification = this.getChangeSpecification();
                                       Object other$changeSpecification = other.getChangeSpecification();
                                       if (this$changeSpecification == null
                                          ? other$changeSpecification == null
                                          : this$changeSpecification.equals(other$changeSpecification)) {
                                          Object this$width = this.getWidth();
                                          Object other$width = other.getWidth();
                                          if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                             Object this$changeWidth = this.getChangeWidth();
                                             Object other$changeWidth = other.getChangeWidth();
                                             if (this$changeWidth == null ? other$changeWidth == null : this$changeWidth.equals(other$changeWidth)) {
                                                Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                if (this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                   Object this$changeUnfoldedWidth = this.getChangeUnfoldedWidth();
                                                   Object other$changeUnfoldedWidth = other.getChangeUnfoldedWidth();
                                                   if (this$changeUnfoldedWidth == null
                                                      ? other$changeUnfoldedWidth == null
                                                      : this$changeUnfoldedWidth.equals(other$changeUnfoldedWidth)) {
                                                      Object this$thickness = this.getThickness();
                                                      Object other$thickness = other.getThickness();
                                                      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                         Object this$changeThickness = this.getChangeThickness();
                                                         Object other$changeThickness = other.getChangeThickness();
                                                         if (this$changeThickness == null
                                                            ? other$changeThickness == null
                                                            : this$changeThickness.equals(other$changeThickness)) {
                                                            Object this$length = this.getLength();
                                                            Object other$length = other.getLength();
                                                            if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                               Object this$changeLength = this.getChangeLength();
                                                               Object other$changeLength = other.getChangeLength();
                                                               if (this$changeLength == null
                                                                  ? other$changeLength == null
                                                                  : this$changeLength.equals(other$changeLength)) {
                                                                  Object this$weight = this.getWeight();
                                                                  Object other$weight = other.getWeight();
                                                                  if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                     Object this$changeWeight = this.getChangeWeight();
                                                                     Object other$changeWeight = other.getChangeWeight();
                                                                     if (this$changeWeight == null
                                                                        ? other$changeWeight == null
                                                                        : this$changeWeight.equals(other$changeWeight)) {
                                                                        Object this$remark = this.getRemark();
                                                                        Object other$remark = other.getRemark();
                                                                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                                           Object this$changeRemark = this.getChangeRemark();
                                                                           Object other$changeRemark = other.getChangeRemark();
                                                                           if (this$changeRemark == null
                                                                              ? other$changeRemark == null
                                                                              : this$changeRemark.equals(other$changeRemark)) {
                                                                              Object this$surfaceArea = this.getSurfaceArea();
                                                                              Object other$surfaceArea = other.getSurfaceArea();
                                                                              if (this$surfaceArea == null
                                                                                 ? other$surfaceArea == null
                                                                                 : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                 Object this$changeSurfaceArea = this.getChangeSurfaceArea();
                                                                                 Object other$changeSurfaceArea = other.getChangeSurfaceArea();
                                                                                 return this$changeSurfaceArea == null
                                                                                    ? other$changeSurfaceArea == null
                                                                                    : this$changeSurfaceArea.equals(other$changeSurfaceArea);
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
      return other instanceof TechEnclosureChangeRecordDetailDTO;
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
      Object $enclosureId = this.getEnclosureId();
      result = result * 59 + ($enclosureId == null ? 43 : $enclosureId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $changeQuantity = this.getChangeQuantity();
      result = result * 59 + ($changeQuantity == null ? 43 : $changeQuantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $changeName = this.getChangeName();
      result = result * 59 + ($changeName == null ? 43 : $changeName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $changeSerialNumber = this.getChangeSerialNumber();
      result = result * 59 + ($changeSerialNumber == null ? 43 : $changeSerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $changeSpecification = this.getChangeSpecification();
      result = result * 59 + ($changeSpecification == null ? 43 : $changeSpecification.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $changeWidth = this.getChangeWidth();
      result = result * 59 + ($changeWidth == null ? 43 : $changeWidth.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $changeUnfoldedWidth = this.getChangeUnfoldedWidth();
      result = result * 59 + ($changeUnfoldedWidth == null ? 43 : $changeUnfoldedWidth.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $changeThickness = this.getChangeThickness();
      result = result * 59 + ($changeThickness == null ? 43 : $changeThickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $changeLength = this.getChangeLength();
      result = result * 59 + ($changeLength == null ? 43 : $changeLength.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $changeWeight = this.getChangeWeight();
      result = result * 59 + ($changeWeight == null ? 43 : $changeWeight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $changeRemark = this.getChangeRemark();
      result = result * 59 + ($changeRemark == null ? 43 : $changeRemark.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $changeSurfaceArea = this.getChangeSurfaceArea();
      return result * 59 + ($changeSurfaceArea == null ? 43 : $changeSurfaceArea.hashCode());
   }

   public static class TechEnclosureChangeRecordDetailDTOBuilder {
      private Long id;
      private Long changeRecordId;
      private Integer type;
      private Long enclosureId;
      private String name;
      private String changeName;
      private Integer quantity;
      private Integer changeQuantity;
      private String serialNumber;
      private String changeSerialNumber;
      private String specification;
      private String changeSpecification;
      private BigDecimal width;
      private BigDecimal changeWidth;
      private BigDecimal unfoldedWidth;
      private BigDecimal changeUnfoldedWidth;
      private BigDecimal thickness;
      private BigDecimal changeThickness;
      private BigDecimal length;
      private BigDecimal changeLength;
      private BigDecimal weight;
      private BigDecimal changeWeight;
      private String remark;
      private String changeRemark;
      private BigDecimal surfaceArea;
      private BigDecimal changeSurfaceArea;

      TechEnclosureChangeRecordDetailDTOBuilder() {
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeRecordId(final Long changeRecordId) {
         this.changeRecordId = changeRecordId;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder enclosureId(final Long enclosureId) {
         this.enclosureId = enclosureId;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeName(final String changeName) {
         this.changeName = changeName;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeQuantity(final Integer changeQuantity) {
         this.changeQuantity = changeQuantity;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeSerialNumber(final String changeSerialNumber) {
         this.changeSerialNumber = changeSerialNumber;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeSpecification(final String changeSpecification) {
         this.changeSpecification = changeSpecification;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeWidth(final BigDecimal changeWidth) {
         this.changeWidth = changeWidth;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeUnfoldedWidth(final BigDecimal changeUnfoldedWidth) {
         this.changeUnfoldedWidth = changeUnfoldedWidth;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeThickness(final BigDecimal changeThickness) {
         this.changeThickness = changeThickness;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeLength(final BigDecimal changeLength) {
         this.changeLength = changeLength;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeWeight(final BigDecimal changeWeight) {
         this.changeWeight = changeWeight;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeRemark(final String changeRemark) {
         this.changeRemark = changeRemark;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder changeSurfaceArea(final BigDecimal changeSurfaceArea) {
         this.changeSurfaceArea = changeSurfaceArea;
         return this;
      }

      public TechEnclosureChangeRecordDetailDTO build() {
         return new TechEnclosureChangeRecordDetailDTO(
            this.id,
            this.changeRecordId,
            this.type,
            this.enclosureId,
            this.name,
            this.changeName,
            this.quantity,
            this.changeQuantity,
            this.serialNumber,
            this.changeSerialNumber,
            this.specification,
            this.changeSpecification,
            this.width,
            this.changeWidth,
            this.unfoldedWidth,
            this.changeUnfoldedWidth,
            this.thickness,
            this.changeThickness,
            this.length,
            this.changeLength,
            this.weight,
            this.changeWeight,
            this.remark,
            this.changeRemark,
            this.surfaceArea,
            this.changeSurfaceArea
         );
      }

      @Override
      public String toString() {
         return "TechEnclosureChangeRecordDetailDTO.TechEnclosureChangeRecordDetailDTOBuilder(id="
            + this.id
            + ", changeRecordId="
            + this.changeRecordId
            + ", type="
            + this.type
            + ", enclosureId="
            + this.enclosureId
            + ", name="
            + this.name
            + ", changeName="
            + this.changeName
            + ", quantity="
            + this.quantity
            + ", changeQuantity="
            + this.changeQuantity
            + ", serialNumber="
            + this.serialNumber
            + ", changeSerialNumber="
            + this.changeSerialNumber
            + ", specification="
            + this.specification
            + ", changeSpecification="
            + this.changeSpecification
            + ", width="
            + this.width
            + ", changeWidth="
            + this.changeWidth
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", changeUnfoldedWidth="
            + this.changeUnfoldedWidth
            + ", thickness="
            + this.thickness
            + ", changeThickness="
            + this.changeThickness
            + ", length="
            + this.length
            + ", changeLength="
            + this.changeLength
            + ", weight="
            + this.weight
            + ", changeWeight="
            + this.changeWeight
            + ", remark="
            + this.remark
            + ", changeRemark="
            + this.changeRemark
            + ", surfaceArea="
            + this.surfaceArea
            + ", changeSurfaceArea="
            + this.changeSurfaceArea
            + ")";
      }
   }
}
