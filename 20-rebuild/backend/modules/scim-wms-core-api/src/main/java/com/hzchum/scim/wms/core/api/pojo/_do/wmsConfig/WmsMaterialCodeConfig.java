package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

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

@ApiModel(value = "WmsMaterialCodeConfig对象", description = "")
@Entity
@TableName("wms_material_code_config")
@Table(name = "wms_material_code_config")
@org.hibernate.annotations.Table(appliesTo = "wms_material_code_config")
public class WmsMaterialCodeConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
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
   @ApiModelProperty(name = "thickness", value = "物料厚度", notes = "物料厚度")
   @JsonProperty("thickness")
   @JSONField(name = "thickness")
   @TableField("thickness")
   @Column(name = "thickness", columnDefinition = "decimal(32,8)  COMMENT '物料厚度'", nullable = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "specification", value = "沒拼接的规格", notes = "沒拼接的规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   @TableField("specification")
   @Column(name = "specification", columnDefinition = "varchar(128)  COMMENT '沒拼接的规格'", nullable = true)
   private String specification;
   @ApiModelProperty(name = "specificationNew", value = "拼接的规格", notes = "拼接的规格")
   @JsonProperty("specificationNew")
   @JSONField(name = "specificationNew")
   @TableField("specification_new")
   @Column(name = "specification_new", columnDefinition = "varchar(128)  COMMENT '拼接的规格'", nullable = true)
   private String specificationNew;
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
   @ApiModelProperty(name = "editorId", value = "最后编辑人", notes = "最后编辑人")
   @JsonProperty("editorId")
   @JSONField(name = "editorId")
   @TableField("editor_id")
   @Column(name = "editor_id", columnDefinition = "bigint  COMMENT '最后编辑人'", nullable = true)
   private Long editorId;
   @ApiModelProperty(name = "editorName", value = "最后编辑人名称", notes = "最后编辑人名称")
   @JsonProperty("editorName")
   @JSONField(name = "editorName")
   @TableField("editor_name")
   @Column(name = "editor_name", columnDefinition = "varchar(255)  COMMENT '最后编辑人名称'", nullable = true)
   private String editorName;
   @ApiModelProperty(name = "applicantId", value = "申请人ID", notes = "申请人ID")
   @JsonProperty("applicantId")
   @JSONField(name = "applicantId")
   @TableField("applicant_id")
   @Column(name = "applicant_id", columnDefinition = "bigint  COMMENT '申请人ID'", nullable = true)
   private Long applicantId;
   @ApiModelProperty(name = "applicantName", value = "申请人名称", notes = "申请人名称")
   @JsonProperty("applicantName")
   @JSONField(name = "applicantName")
   @TableField("applicant_name")
   @Column(name = "applicant_name", columnDefinition = "varchar(128)  COMMENT '申请人名称'", nullable = true)
   private String applicantName;

   public static WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder builder() {
      return new WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder();
   }

   public WmsMaterialCodeConfig() {
   }

   public WmsMaterialCodeConfig(
      final Long id,
      final Long classifyId,
      final Integer basicClass,
      final String classifyName,
      final BigDecimal thickness,
      final String specification,
      final String specificationNew,
      final String materialSn,
      final String materialSnNew,
      final Long editorId,
      final String editorName,
      final Long applicantId,
      final String applicantName
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.classifyName = classifyName;
      this.thickness = thickness;
      this.specification = specification;
      this.specificationNew = specificationNew;
      this.materialSn = materialSn;
      this.materialSnNew = materialSnNew;
      this.editorId = editorId;
      this.editorName = editorName;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
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

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getSpecificationNew() {
      return this.specificationNew;
   }

   public String getMaterialSn() {
      return this.materialSn;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public Long getEditorId() {
      return this.editorId;
   }

   public String getEditorName() {
      return this.editorName;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public WmsMaterialCodeConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("classifyId")
   public WmsMaterialCodeConfig setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   @JsonProperty("basicClass")
   public WmsMaterialCodeConfig setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   @JsonProperty("classifyName")
   public WmsMaterialCodeConfig setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
      return this;
   }

   @JsonProperty("thickness")
   public WmsMaterialCodeConfig setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
      return this;
   }

   @JsonProperty("specification")
   public WmsMaterialCodeConfig setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("specificationNew")
   public WmsMaterialCodeConfig setSpecificationNew(final String specificationNew) {
      this.specificationNew = specificationNew;
      return this;
   }

   @JsonProperty("materialSn")
   public WmsMaterialCodeConfig setMaterialSn(final String materialSn) {
      this.materialSn = materialSn;
      return this;
   }

   @JsonProperty("materialSnNew")
   public WmsMaterialCodeConfig setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
      return this;
   }

   @JsonProperty("editorId")
   public WmsMaterialCodeConfig setEditorId(final Long editorId) {
      this.editorId = editorId;
      return this;
   }

   @JsonProperty("editorName")
   public WmsMaterialCodeConfig setEditorName(final String editorName) {
      this.editorName = editorName;
      return this;
   }

   @JsonProperty("applicantId")
   public WmsMaterialCodeConfig setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
      return this;
   }

   @JsonProperty("applicantName")
   public WmsMaterialCodeConfig setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
      return this;
   }

   @Override
   public String toString() {
      return "WmsMaterialCodeConfig(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyName="
         + this.getClassifyName()
         + ", thickness="
         + this.getThickness()
         + ", specification="
         + this.getSpecification()
         + ", specificationNew="
         + this.getSpecificationNew()
         + ", materialSn="
         + this.getMaterialSn()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", editorId="
         + this.getEditorId()
         + ", editorName="
         + this.getEditorName()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsMaterialCodeConfig)) {
         return false;
      }

      WmsMaterialCodeConfig other = (WmsMaterialCodeConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
               Object this$editorId = this.getEditorId();
               Object other$editorId = other.getEditorId();
               if (this$editorId == null ? other$editorId == null : this$editorId.equals(other$editorId)) {
                  Object this$applicantId = this.getApplicantId();
                  Object other$applicantId = other.getApplicantId();
                  if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
                     Object this$classifyName = this.getClassifyName();
                     Object other$classifyName = other.getClassifyName();
                     if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                        Object this$thickness = this.getThickness();
                        Object other$thickness = other.getThickness();
                        if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$specificationNew = this.getSpecificationNew();
                              Object other$specificationNew = other.getSpecificationNew();
                              if (this$specificationNew == null ? other$specificationNew == null : this$specificationNew.equals(other$specificationNew)) {
                                 Object this$materialSn = this.getMaterialSn();
                                 Object other$materialSn = other.getMaterialSn();
                                 if (this$materialSn == null ? other$materialSn == null : this$materialSn.equals(other$materialSn)) {
                                    Object this$materialSnNew = this.getMaterialSnNew();
                                    Object other$materialSnNew = other.getMaterialSnNew();
                                    if (this$materialSnNew == null ? other$materialSnNew == null : this$materialSnNew.equals(other$materialSnNew)) {
                                       Object this$editorName = this.getEditorName();
                                       Object other$editorName = other.getEditorName();
                                       if (this$editorName == null ? other$editorName == null : this$editorName.equals(other$editorName)) {
                                          Object this$applicantName = this.getApplicantName();
                                          Object other$applicantName = other.getApplicantName();
                                          return this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName);
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
      return other instanceof WmsMaterialCodeConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $editorId = this.getEditorId();
      result = result * 59 + ($editorId == null ? 43 : $editorId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $specificationNew = this.getSpecificationNew();
      result = result * 59 + ($specificationNew == null ? 43 : $specificationNew.hashCode());
      Object $materialSn = this.getMaterialSn();
      result = result * 59 + ($materialSn == null ? 43 : $materialSn.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      result = result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
      Object $editorName = this.getEditorName();
      result = result * 59 + ($editorName == null ? 43 : $editorName.hashCode());
      Object $applicantName = this.getApplicantName();
      return result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
   }

   public static class WmsMaterialCodeConfigBuilder {
      private Long id;
      private Long classifyId;
      private Integer basicClass;
      private String classifyName;
      private BigDecimal thickness;
      private String specification;
      private String specificationNew;
      private String materialSn;
      private String materialSnNew;
      private Long editorId;
      private String editorName;
      private Long applicantId;
      private String applicantName;

      WmsMaterialCodeConfigBuilder() {
      }

      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("classifyId")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      @JsonProperty("basicClass")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("classifyName")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      @JsonProperty("thickness")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      @JsonProperty("specification")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("specificationNew")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder specificationNew(final String specificationNew) {
         this.specificationNew = specificationNew;
         return this;
      }

      @JsonProperty("materialSn")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder materialSn(final String materialSn) {
         this.materialSn = materialSn;
         return this;
      }

      @JsonProperty("materialSnNew")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      @JsonProperty("editorId")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder editorId(final Long editorId) {
         this.editorId = editorId;
         return this;
      }

      @JsonProperty("editorName")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder editorName(final String editorName) {
         this.editorName = editorName;
         return this;
      }

      @JsonProperty("applicantId")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      @JsonProperty("applicantName")
      public WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public WmsMaterialCodeConfig build() {
         return new WmsMaterialCodeConfig(
            this.id,
            this.classifyId,
            this.basicClass,
            this.classifyName,
            this.thickness,
            this.specification,
            this.specificationNew,
            this.materialSn,
            this.materialSnNew,
            this.editorId,
            this.editorName,
            this.applicantId,
            this.applicantName
         );
      }

      @Override
      public String toString() {
         return "WmsMaterialCodeConfig.WmsMaterialCodeConfigBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", classifyName="
            + this.classifyName
            + ", thickness="
            + this.thickness
            + ", specification="
            + this.specification
            + ", specificationNew="
            + this.specificationNew
            + ", materialSn="
            + this.materialSn
            + ", materialSnNew="
            + this.materialSnNew
            + ", editorId="
            + this.editorId
            + ", editorName="
            + this.editorName
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ")";
      }
   }
}
