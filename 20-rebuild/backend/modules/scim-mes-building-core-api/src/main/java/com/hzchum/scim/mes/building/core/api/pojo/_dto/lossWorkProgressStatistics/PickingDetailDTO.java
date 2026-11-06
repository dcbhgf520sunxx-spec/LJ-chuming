package com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PickingDetailDTO {
   @ApiModelProperty(name = "basicClass", value = "出库/退库")
   private Integer lossWorkProgressStatisticsEnum;
   @ApiModelProperty(name = "basicClass", value = "物料基础分类")
   private Integer basicClass;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("出/退库日期")
   private LocalDateTime reviewPassTime;
   @ApiModelProperty("出/退库单编号")
   private String serialNumber;
   @ApiModelProperty("领用车间")
   private String useWorkshop;
   @ApiModelProperty("领料人")
   private String receivePerson;
   @ApiModelProperty("科目id")
   private Long classifyId;
   @ApiModelProperty("物料名称")
   private String classifyName;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("规格拼接")
   private String spec;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("数量")
   private BigDecimal quantity;
   @ApiModelProperty("核算量")
   private BigDecimal mete;
   @ApiModelProperty("计量单位")
   private String measureUnit;
   @ApiModelProperty("核算单位")
   private String accountingUnit;
   @ApiModelProperty("厚")
   private BigDecimal thickness;
   @ApiModelProperty("宽")
   private String width;
   @ApiModelProperty("长")
   private BigDecimal length;
   @ApiModelProperty("颜色")
   private String color;

   public static PickingDetailDTO.PickingDetailDTOBuilder builder() {
      return new PickingDetailDTO.PickingDetailDTOBuilder();
   }

   public Integer getLossWorkProgressStatisticsEnum() {
      return this.lossWorkProgressStatisticsEnum;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getUseWorkshop() {
      return this.useWorkshop;
   }

   public String getReceivePerson() {
      return this.receivePerson;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getSpec() {
      return this.spec;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getColor() {
      return this.color;
   }

   public void setLossWorkProgressStatisticsEnum(final Integer lossWorkProgressStatisticsEnum) {
      this.lossWorkProgressStatisticsEnum = lossWorkProgressStatisticsEnum;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setUseWorkshop(final String useWorkshop) {
      this.useWorkshop = useWorkshop;
   }

   public void setReceivePerson(final String receivePerson) {
      this.receivePerson = receivePerson;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setSpec(final String spec) {
      this.spec = spec;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final String width) {
      this.width = width;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PickingDetailDTO)) {
         return false;
      }

      PickingDetailDTO other = (PickingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$lossWorkProgressStatisticsEnum = this.getLossWorkProgressStatisticsEnum();
      Object other$lossWorkProgressStatisticsEnum = other.getLossWorkProgressStatisticsEnum();
      if (this$lossWorkProgressStatisticsEnum == null
         ? other$lossWorkProgressStatisticsEnum == null
         : this$lossWorkProgressStatisticsEnum.equals(other$lossWorkProgressStatisticsEnum)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$reviewPassTime = this.getReviewPassTime();
                  Object other$reviewPassTime = other.getReviewPassTime();
                  if (this$reviewPassTime == null ? other$reviewPassTime == null : this$reviewPassTime.equals(other$reviewPassTime)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$useWorkshop = this.getUseWorkshop();
                        Object other$useWorkshop = other.getUseWorkshop();
                        if (this$useWorkshop == null ? other$useWorkshop == null : this$useWorkshop.equals(other$useWorkshop)) {
                           Object this$receivePerson = this.getReceivePerson();
                           Object other$receivePerson = other.getReceivePerson();
                           if (this$receivePerson == null ? other$receivePerson == null : this$receivePerson.equals(other$receivePerson)) {
                              Object this$classifyName = this.getClassifyName();
                              Object other$classifyName = other.getClassifyName();
                              if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$spec = this.getSpec();
                                    Object other$spec = other.getSpec();
                                    if (this$spec == null ? other$spec == null : this$spec.equals(other$spec)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$mete = this.getMete();
                                             Object other$mete = other.getMete();
                                             if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                Object this$measureUnit = this.getMeasureUnit();
                                                Object other$measureUnit = other.getMeasureUnit();
                                                if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                   Object this$accountingUnit = this.getAccountingUnit();
                                                   Object other$accountingUnit = other.getAccountingUnit();
                                                   if (this$accountingUnit == null
                                                      ? other$accountingUnit == null
                                                      : this$accountingUnit.equals(other$accountingUnit)) {
                                                      Object this$thickness = this.getThickness();
                                                      Object other$thickness = other.getThickness();
                                                      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                         Object this$width = this.getWidth();
                                                         Object other$width = other.getWidth();
                                                         if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                            Object this$length = this.getLength();
                                                            Object other$length = other.getLength();
                                                            if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                               Object this$color = this.getColor();
                                                               Object other$color = other.getColor();
                                                               return this$color == null ? other$color == null : this$color.equals(other$color);
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
      return other instanceof PickingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $lossWorkProgressStatisticsEnum = this.getLossWorkProgressStatisticsEnum();
      result = result * 59 + ($lossWorkProgressStatisticsEnum == null ? 43 : $lossWorkProgressStatisticsEnum.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $useWorkshop = this.getUseWorkshop();
      result = result * 59 + ($useWorkshop == null ? 43 : $useWorkshop.hashCode());
      Object $receivePerson = this.getReceivePerson();
      result = result * 59 + ($receivePerson == null ? 43 : $receivePerson.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $spec = this.getSpec();
      result = result * 59 + ($spec == null ? 43 : $spec.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $color = this.getColor();
      return result * 59 + ($color == null ? 43 : $color.hashCode());
   }

   @Override
   public String toString() {
      return "PickingDetailDTO(lossWorkProgressStatisticsEnum="
         + this.getLossWorkProgressStatisticsEnum()
         + ", basicClass="
         + this.getBasicClass()
         + ", projectName="
         + this.getProjectName()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", useWorkshop="
         + this.getUseWorkshop()
         + ", receivePerson="
         + this.getReceivePerson()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", spec="
         + this.getSpec()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", color="
         + this.getColor()
         + ")";
   }

   public PickingDetailDTO(
      final Integer lossWorkProgressStatisticsEnum,
      final Integer basicClass,
      final String projectName,
      final LocalDateTime reviewPassTime,
      final String serialNumber,
      final String useWorkshop,
      final String receivePerson,
      final Long classifyId,
      final String classifyName,
      final String specification,
      final String spec,
      final String material,
      final BigDecimal quantity,
      final BigDecimal mete,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal thickness,
      final String width,
      final BigDecimal length,
      final String color
   ) {
      this.lossWorkProgressStatisticsEnum = lossWorkProgressStatisticsEnum;
      this.basicClass = basicClass;
      this.projectName = projectName;
      this.reviewPassTime = reviewPassTime;
      this.serialNumber = serialNumber;
      this.useWorkshop = useWorkshop;
      this.receivePerson = receivePerson;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.spec = spec;
      this.material = material;
      this.quantity = quantity;
      this.mete = mete;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.thickness = thickness;
      this.width = width;
      this.length = length;
      this.color = color;
   }

   public PickingDetailDTO() {
   }

   public static class PickingDetailDTOBuilder {
      private Integer lossWorkProgressStatisticsEnum;
      private Integer basicClass;
      private String projectName;
      private LocalDateTime reviewPassTime;
      private String serialNumber;
      private String useWorkshop;
      private String receivePerson;
      private Long classifyId;
      private String classifyName;
      private String specification;
      private String spec;
      private String material;
      private BigDecimal quantity;
      private BigDecimal mete;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal thickness;
      private String width;
      private BigDecimal length;
      private String color;

      PickingDetailDTOBuilder() {
      }

      public PickingDetailDTO.PickingDetailDTOBuilder lossWorkProgressStatisticsEnum(final Integer lossWorkProgressStatisticsEnum) {
         this.lossWorkProgressStatisticsEnum = lossWorkProgressStatisticsEnum;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder useWorkshop(final String useWorkshop) {
         this.useWorkshop = useWorkshop;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder receivePerson(final String receivePerson) {
         this.receivePerson = receivePerson;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder spec(final String spec) {
         this.spec = spec;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder width(final String width) {
         this.width = width;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public PickingDetailDTO.PickingDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public PickingDetailDTO build() {
         return new PickingDetailDTO(
            this.lossWorkProgressStatisticsEnum,
            this.basicClass,
            this.projectName,
            this.reviewPassTime,
            this.serialNumber,
            this.useWorkshop,
            this.receivePerson,
            this.classifyId,
            this.classifyName,
            this.specification,
            this.spec,
            this.material,
            this.quantity,
            this.mete,
            this.measureUnit,
            this.accountingUnit,
            this.thickness,
            this.width,
            this.length,
            this.color
         );
      }

      @Override
      public String toString() {
         return "PickingDetailDTO.PickingDetailDTOBuilder(lossWorkProgressStatisticsEnum="
            + this.lossWorkProgressStatisticsEnum
            + ", basicClass="
            + this.basicClass
            + ", projectName="
            + this.projectName
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", serialNumber="
            + this.serialNumber
            + ", useWorkshop="
            + this.useWorkshop
            + ", receivePerson="
            + this.receivePerson
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", spec="
            + this.spec
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", color="
            + this.color
            + ")";
      }
   }
}
