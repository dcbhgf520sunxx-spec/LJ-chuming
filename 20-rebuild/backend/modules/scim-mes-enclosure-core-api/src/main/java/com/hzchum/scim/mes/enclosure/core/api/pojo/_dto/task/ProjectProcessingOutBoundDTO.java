package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "ProjectProcessingOutBoundDTO", description = " ")
public class ProjectProcessingOutBoundDTO {
   @ApiModelProperty(name = "classifyId", notes = "科目id")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", notes = "科目名")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   private String classifyName;
   @ApiModelProperty(name = "specification", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private BigDecimal quantity;
   @ApiModelProperty(name = "outboundTime", notes = "出库时间")
   @JsonProperty("outboundTime")
   @JSONField(name = "outboundTime")
   private LocalDateTime outboundTime;
   @ApiModelProperty(name = "measureUnit", notes = "计量单位")
   @JsonProperty("measureUnit")
   @JSONField(name = "measureUnit")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", notes = "核算单位")
   @JsonProperty("accountingUnit")
   @JSONField(name = "accountingUnit")
   private String accountingUnit;
   @ApiModelProperty(name = "mete", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "thickness", notes = "厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   private BigDecimal thickness;
   @ApiModelProperty(name = "length", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "width", notes = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   private BigDecimal width;
   @ApiModelProperty(name = "basicClass", notes = "科目基础规格")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   private Integer basicClass;

   public static ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder builder() {
      return new ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder();
   }

   public ProjectProcessingOutBoundDTO() {
   }

   public ProjectProcessingOutBoundDTO(
      final Long classifyId,
      final String classifyName,
      final String specification,
      final BigDecimal quantity,
      final LocalDateTime outboundTime,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal mete,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final Integer basicClass
   ) {
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.specification = specification;
      this.quantity = quantity;
      this.outboundTime = outboundTime;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.basicClass = basicClass;
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

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   @JsonProperty("classifyId")
   public ProjectProcessingOutBoundDTO setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("classifyName")
   public ProjectProcessingOutBoundDTO setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("specification")
   public ProjectProcessingOutBoundDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public ProjectProcessingOutBoundDTO setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("outboundTime")
   public ProjectProcessingOutBoundDTO setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
      return this;
   }

   @JsonProperty("measureUnit")
   public ProjectProcessingOutBoundDTO setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
      return this;
   }

   @JsonProperty("accountingUnit")
   public ProjectProcessingOutBoundDTO setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
      return this;
   }

   @JsonProperty("mete")
   public ProjectProcessingOutBoundDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("thickness")
   public ProjectProcessingOutBoundDTO setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("length")
   public ProjectProcessingOutBoundDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("width")
   public ProjectProcessingOutBoundDTO setWidth(final BigDecimal width) {
      this.width = width;
      return this;
   }

   @JsonProperty("basicClass")
   public ProjectProcessingOutBoundDTO setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectProcessingOutBoundDTO(classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", basicClass="
         + this.getBasicClass()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProcessingOutBoundDTO)) {
         return false;
      }

      ProjectProcessingOutBoundDTO other = (ProjectProcessingOutBoundDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyName = this.getClassifyName();
            Object other$classifyName = other.getClassifyName();
            if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$outboundTime = this.getOutboundTime();
                     Object other$outboundTime = other.getOutboundTime();
                     if (this$outboundTime == null ? other$outboundTime == null : this$outboundTime.equals(other$outboundTime)) {
                        Object this$measureUnit = this.getMeasureUnit();
                        Object other$measureUnit = other.getMeasureUnit();
                        if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                           Object this$accountingUnit = this.getAccountingUnit();
                           Object other$accountingUnit = other.getAccountingUnit();
                           if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                              Object this$mete = this.getMete();
                              Object other$mete = other.getMete();
                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                 Object this$thickness = this.getThickness();
                                 Object other$thickness = other.getThickness();
                                 if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                    Object this$length = this.getLength();
                                    Object other$length = other.getLength();
                                    if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                       Object this$width = this.getWidth();
                                       Object other$width = other.getWidth();
                                       return this$width == null ? other$width == null : this$width.equals(other$width);
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
      return other instanceof ProjectProcessingOutBoundDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      return result * 59 + ($width == null ? 43 : $width.hashCode());
   }

   public static class ProjectProcessingOutBoundDTOBuilder {
      private Long classifyId;
      private String classifyName;
      private String specification;
      private BigDecimal quantity;
      private LocalDateTime outboundTime;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal mete;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private Integer basicClass;

      ProjectProcessingOutBoundDTOBuilder() {
      }

      @JsonProperty("classifyId")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("classifyName")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specification")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("outboundTime")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      @JsonProperty("measureUnit")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("accountingUnit")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      @JsonProperty("mete")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("thickness")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("length")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("width")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      @JsonProperty("basicClass")
      public ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ProjectProcessingOutBoundDTO build() {
         return new ProjectProcessingOutBoundDTO(
            this.classifyId,
            this.classifyName,
            this.specification,
            this.quantity,
            this.outboundTime,
            this.measureUnit,
            this.accountingUnit,
            this.mete,
            this.thickness,
            this.length,
            this.width,
            this.basicClass
         );
      }

      @Override
      public String toString() {
         return "ProjectProcessingOutBoundDTO.ProjectProcessingOutBoundDTOBuilder(classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", outboundTime="
            + this.outboundTime
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", basicClass="
            + this.basicClass
            + ")";
      }
   }
}
