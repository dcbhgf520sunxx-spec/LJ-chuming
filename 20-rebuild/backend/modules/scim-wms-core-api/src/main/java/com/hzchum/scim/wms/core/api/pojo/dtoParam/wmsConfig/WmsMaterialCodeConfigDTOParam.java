package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;

public class WmsMaterialCodeConfigDTOParam {
   private Long id;
   @ApiModelProperty(name = "classifyId", value = "科目ID", notes = "科目ID")
   @JsonProperty("classifyId")
   @JSONField(name = "classifyId")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '科目ID'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '物料基础类型'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   @JsonProperty("classifyName")
   @JSONField(name = "classifyName")
   @TableField("classify_name")
   @Column(name = "classify_name", columnDefinition = "varchar(255)  COMMENT '科目名称'", nullable = true)
   private String classifyName;
   @ApiModelProperty(name = "specificationNew", value = "规格", notes = "规格")
   @JsonProperty("specificationNew")
   @JSONField(name = "specificationNew")
   @TableField("specification_new")
   @Column(name = "specification_new", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specificationNew;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "thickness", value = "厚", notes = "厚")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,3)  COMMENT '厚'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "materialSn")
   @JsonProperty("materialSn")
   @JSONField(name = "materialSn")
   @TableField("material_sn")
   @Column(name = "material_sn", columnDefinition = "varchar(255)  COMMENT '物料编码（初鸣）'", nullable = true)
   private String materialSn;
   @ApiModelProperty(name = "materialSnNew")
   @JsonProperty("materialSnNew")
   @JSONField(name = "materialSnNew")
   @TableField("material_sn_new")
   @Column(name = "material_sn_new", columnDefinition = "varchar(255)  COMMENT '物料编码（中南）'", nullable = true)
   private String materialSnNew;

   public static WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder builder() {
      return new WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
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

   public String getSpecificationNew() {
      return this.specificationNew;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("classifyId")
   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   @JsonProperty("basicClass")
   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @JsonProperty("classifyName")
   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   @JsonProperty("specificationNew")
   public void setSpecificationNew(final String specificationNew) {
      this.specificationNew = specificationNew;
   }

   @JsonProperty("specification")
   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @JsonProperty("thickness")
   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @JsonProperty("materialSn")
   public void setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
   }

   @JsonProperty("materialSnNew")
   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsMaterialCodeConfigDTOParam)) {
         return false;
      }

      WmsMaterialCodeConfigDTOParam other = (WmsMaterialCodeConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$classifyName = this.getClassifyName();
               Object other$classifyName = other.getClassifyName();
               if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                  Object this$specificationNew = this.getSpecificationNew();
                  Object other$specificationNew = other.getSpecificationNew();
                  if (this$specificationNew == null ? other$specificationNew == null : this$specificationNew.equals(other$specificationNew)) {
                     Object this$specification = this.getSpecification();
                     Object other$specification = other.getSpecification();
                     if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                        Object this$thickness = this.getThickness();
                        Object other$thickness = other.getThickness();
                        if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                           Object this$materialSn = this.getMaterialSn();
                           Object other$materialSn = other.getMaterialSn();
                           if (this$materialSn == null ? other$materialSn == null : this$materialSn.equals(other$materialSn)) {
                              Object this$materialSnNew = this.getMaterialSnNew();
                              Object other$materialSnNew = other.getMaterialSnNew();
                              return this$materialSnNew == null ? other$materialSnNew == null : this$materialSnNew.equals(other$materialSnNew);
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
      return other instanceof WmsMaterialCodeConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specificationNew = this.getSpecificationNew();
      result = result * 59 + ($specificationNew == null ? 43 : $specificationNew.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      return result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
   }

   @Override
   public String toString() {
      return "WmsMaterialCodeConfigDTOParam(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyName="
         + this.getClassifyName()
         + ", specificationNew="
         + this.getSpecificationNew()
         + ", specification="
         + this.getSpecification()
         + ", thickness="
         + this.getThickness()
         + ", materialSn="
         + this.getMaterialSn()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ")";
   }

   public WmsMaterialCodeConfigDTOParam(
      final Long id,
      final Long classifyId,
      final Integer basicClass,
      final String classifyName,
      final String specificationNew,
      final String specification,
      final BigDecimal thickness,
      final String materialSn,
      final String materialSnNew
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.classifyName = classifyName;
      this.specificationNew = specificationNew;
      this.specification = specification;
      this.thickness = thickness;
      this.materialSn = materialSn;
      this.materialSnNew = materialSnNew;
   }

   public WmsMaterialCodeConfigDTOParam() {
   }

   public static class WmsMaterialCodeConfigDTOParamBuilder {
      private Long id;
      private Long classifyId;
      private Integer basicClass;
      private String classifyName;
      private String specificationNew;
      private String specification;
      private BigDecimal thickness;
      private String materialSn;
      private String materialSnNew;

      WmsMaterialCodeConfigDTOParamBuilder() {
      }

      public WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classifyId")
      public WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("basicClass")
      public WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyName")
      public WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("specificationNew")
      public WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder specificationNew(final String specificationNew) {
         this.specificationNew = specificationNew;
         return this;
      }

      @JsonProperty("specification")
      public WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("thickness")
      public WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("materialSn")
      public WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("materialSnNew")
      public WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public WmsMaterialCodeConfigDTOParam build() {
         return new WmsMaterialCodeConfigDTOParam(
            this.id,
            this.classifyId,
            this.basicClass,
            this.classifyName,
            this.specificationNew,
            this.specification,
            this.thickness,
            this.materialSn,
            this.materialSnNew
         );
      }

      @Override
      public String toString() {
         return "WmsMaterialCodeConfigDTOParam.WmsMaterialCodeConfigDTOParamBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", classifyName="
            + this.classifyName
            + ", specificationNew="
            + this.specificationNew
            + ", specification="
            + this.specification
            + ", thickness="
            + this.thickness
            + ", materialSn="
            + this.materialSn
            + ", materialSnNew="
            + this.materialSnNew
            + ")";
      }
   }
}
