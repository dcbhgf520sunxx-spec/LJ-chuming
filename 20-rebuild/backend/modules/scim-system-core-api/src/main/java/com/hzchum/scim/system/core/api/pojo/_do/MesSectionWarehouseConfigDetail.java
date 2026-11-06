package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "类型截面库配置详情对象", description = "")
@Entity
@TableName("mes_section_warehouse_config_detail")
@Table(name = "mes_section_warehouse_config_detail")
public class MesSectionWarehouseConfigDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "configId", value = "截面类型库Id")
   @JSONField(name = "configId")
   @TableField("config_id")
   @Column(name = "config_id", columnDefinition = "bigint(20) COMMENT '截面类型库Id'", nullable = false)
   private Long configId;
   @ApiModelProperty(name = "name", value = "产品截面类型名称(产品名称/产品截面名称/截面类型名称)")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(1024)  COMMENT '产品截面类型名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "productType", value = "产品类型 1.零件 2.构件 16.组立")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) COMMENT '构件类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "ProductSectionNameEnum", value = "产品截面类型名称枚举 1.产品名称 2.产品类型名称 4.截面类型名称")
   @JsonProperty("ProductSectionNameEnum")
   @JSONField(name = "ProductSectionNameEnum")
   @TableField("product_section_name_enum")
   @Column(name = "product_section_name_enum", columnDefinition = "int(11) COMMENT '构件类型'", nullable = false)
   private Integer productSectionNameEnum;
   @ApiModelProperty(name = "productClassificationEnum", value = "产品分类 1.普通构件 2.次构件 4.成品型材(制品/截面) 8.钢板(制品/截面) 16.焊接部件(截面) 32.标准件(配套件)")
   @JsonProperty("productClassificationEnum")
   @JSONField(name = "productClassificationEnum")
   @TableField("product_classification_enum")
   @Column(name = "product_classification_enum", columnDefinition = "int(11) COMMENT '产品分类'", nullable = false)
   private Integer productClassificationEnum;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "钢板类型 1.零件板 2.翼腹板")
   @JsonProperty("steelPlateTypeEnum")
   @JSONField(name = "steelPlateTypeEnum")
   @TableField("steel_plate_type_enum")
   @Column(name = "steel_plate_type_enum", columnDefinition = "int(11) COMMENT '钢板类型 1.零件板 2.翼腹板'")
   private Integer steelPlateTypeEnum;
   @ApiModelProperty(name = "source", value = "数据来源 1.用户新增 2.系统自定义")
   @JsonProperty("source")
   @JSONField(name = "source")
   @TableField("source")
   @Column(name = "source", columnDefinition = "int(11)  default 1 COMMENT '数据来源'", nullable = false)
   private Integer source;
   @ApiModelProperty("次构件分类(其他为null): 1其他 2板材类 4型材类 8檩条类")
   @TableField("small_artifact_class_enum")
   @Column(name = "small_artifact_class_enum", columnDefinition = "int(11) DEFAULT NULL COMMENT '次构件分类(其他为null): 1其他 2板材类 4型材类 8檩条类'")
   private Integer smallArtifactClassEnum;
   @ApiModelProperty("PL构件是否组合部件")
   @TableField("bool_compose_assemble")
   @Column(name = "bool_compose_assemble", columnDefinition = "tinyint(1) default 1  COMMENT 'PL构件是否组合部件'")
   private Boolean boolComposeAssemble;

   public static MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder builder() {
      return new MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder();
   }

   public MesSectionWarehouseConfigDetail() {
   }

   public MesSectionWarehouseConfigDetail(
      final Long id,
      final Long configId,
      final String name,
      final Integer productType,
      final Integer productSectionNameEnum,
      final Integer productClassificationEnum,
      final Integer steelPlateTypeEnum,
      final Integer source,
      final Integer smallArtifactClassEnum,
      final Boolean boolComposeAssemble
   ) {
      this.id = id;
      this.configId = configId;
      this.name = name;
      this.productType = productType;
      this.productSectionNameEnum = productSectionNameEnum;
      this.productClassificationEnum = productClassificationEnum;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      this.source = source;
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      this.boolComposeAssemble = boolComposeAssemble;
   }

   public Long getId() {
      return this.id;
   }

   public Long getConfigId() {
      return this.configId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getProductSectionNameEnum() {
      return this.productSectionNameEnum;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public Integer getSource() {
      return this.source;
   }

   public Integer getSmallArtifactClassEnum() {
      return this.smallArtifactClassEnum;
   }

   public Boolean getBoolComposeAssemble() {
      return this.boolComposeAssemble;
   }

   @JsonProperty("id")
   public MesSectionWarehouseConfigDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesSectionWarehouseConfigDetail setConfigId(final Long configId) {
      this.configId = configId;
      return this;
   }

   @JsonProperty("name")
   public MesSectionWarehouseConfigDetail setName(final String name) {
      this.name = name;
      return this;
   }

   public MesSectionWarehouseConfigDetail setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("ProductSectionNameEnum")
   public MesSectionWarehouseConfigDetail setProductSectionNameEnum(final Integer productSectionNameEnum) {
      this.productSectionNameEnum = productSectionNameEnum;
      return this;
   }

   @JsonProperty("productClassificationEnum")
   public MesSectionWarehouseConfigDetail setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
      return this;
   }

   @JsonProperty("steelPlateTypeEnum")
   public MesSectionWarehouseConfigDetail setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   @JsonProperty("source")
   public MesSectionWarehouseConfigDetail setSource(final Integer source) {
      this.source = source;
      return this;
   }

   public MesSectionWarehouseConfigDetail setSmallArtifactClassEnum(final Integer smallArtifactClassEnum) {
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      return this;
   }

   public MesSectionWarehouseConfigDetail setBoolComposeAssemble(final Boolean boolComposeAssemble) {
      this.boolComposeAssemble = boolComposeAssemble;
      return this;
   }

   @Override
   public String toString() {
      return "MesSectionWarehouseConfigDetail(id="
         + this.getId()
         + ", configId="
         + this.getConfigId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", productSectionNameEnum="
         + this.getProductSectionNameEnum()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", source="
         + this.getSource()
         + ", smallArtifactClassEnum="
         + this.getSmallArtifactClassEnum()
         + ", boolComposeAssemble="
         + this.getBoolComposeAssemble()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSectionWarehouseConfigDetail)) {
         return false;
      }

      MesSectionWarehouseConfigDetail other = (MesSectionWarehouseConfigDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$configId = this.getConfigId();
         Object other$configId = other.getConfigId();
         if (this$configId == null ? other$configId == null : this$configId.equals(other$configId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productSectionNameEnum = this.getProductSectionNameEnum();
               Object other$productSectionNameEnum = other.getProductSectionNameEnum();
               if (this$productSectionNameEnum == null
                  ? other$productSectionNameEnum == null
                  : this$productSectionNameEnum.equals(other$productSectionNameEnum)) {
                  Object this$productClassificationEnum = this.getProductClassificationEnum();
                  Object other$productClassificationEnum = other.getProductClassificationEnum();
                  if (this$productClassificationEnum == null
                     ? other$productClassificationEnum == null
                     : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                     Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                     Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                     if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                        Object this$source = this.getSource();
                        Object other$source = other.getSource();
                        if (this$source == null ? other$source == null : this$source.equals(other$source)) {
                           Object this$smallArtifactClassEnum = this.getSmallArtifactClassEnum();
                           Object other$smallArtifactClassEnum = other.getSmallArtifactClassEnum();
                           if (this$smallArtifactClassEnum == null
                              ? other$smallArtifactClassEnum == null
                              : this$smallArtifactClassEnum.equals(other$smallArtifactClassEnum)) {
                              Object this$boolComposeAssemble = this.getBoolComposeAssemble();
                              Object other$boolComposeAssemble = other.getBoolComposeAssemble();
                              if (this$boolComposeAssemble == null
                                 ? other$boolComposeAssemble == null
                                 : this$boolComposeAssemble.equals(other$boolComposeAssemble)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof MesSectionWarehouseConfigDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $configId = this.getConfigId();
      result = result * 59 + ($configId == null ? 43 : $configId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productSectionNameEnum = this.getProductSectionNameEnum();
      result = result * 59 + ($productSectionNameEnum == null ? 43 : $productSectionNameEnum.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $source = this.getSource();
      result = result * 59 + ($source == null ? 43 : $source.hashCode());
      Object $smallArtifactClassEnum = this.getSmallArtifactClassEnum();
      result = result * 59 + ($smallArtifactClassEnum == null ? 43 : $smallArtifactClassEnum.hashCode());
      Object $boolComposeAssemble = this.getBoolComposeAssemble();
      result = result * 59 + ($boolComposeAssemble == null ? 43 : $boolComposeAssemble.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesSectionWarehouseConfigDetailBuilder {
      private Long id;
      private Long configId;
      private String name;
      private Integer productType;
      private Integer productSectionNameEnum;
      private Integer productClassificationEnum;
      private Integer steelPlateTypeEnum;
      private Integer source;
      private Integer smallArtifactClassEnum;
      private Boolean boolComposeAssemble;

      MesSectionWarehouseConfigDetailBuilder() {
      }

      @JsonProperty("id")
      public MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder configId(final Long configId) {
         this.configId = configId;
         return this;
      }

      @JsonProperty("name")
      public MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("ProductSectionNameEnum")
      public MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder productSectionNameEnum(final Integer productSectionNameEnum) {
         this.productSectionNameEnum = productSectionNameEnum;
         return this;
      }

      @JsonProperty("productClassificationEnum")
      public MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      @JsonProperty("steelPlateTypeEnum")
      public MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder steelPlateTypeEnum(final Integer steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      @JsonProperty("source")
      public MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder source(final Integer source) {
         this.source = source;
         return this;
      }

      public MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder smallArtifactClassEnum(final Integer smallArtifactClassEnum) {
         this.smallArtifactClassEnum = smallArtifactClassEnum;
         return this;
      }

      public MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder boolComposeAssemble(final Boolean boolComposeAssemble) {
         this.boolComposeAssemble = boolComposeAssemble;
         return this;
      }

      public MesSectionWarehouseConfigDetail build() {
         return new MesSectionWarehouseConfigDetail(
            this.id,
            this.configId,
            this.name,
            this.productType,
            this.productSectionNameEnum,
            this.productClassificationEnum,
            this.steelPlateTypeEnum,
            this.source,
            this.smallArtifactClassEnum,
            this.boolComposeAssemble
         );
      }

      @Override
      public String toString() {
         return "MesSectionWarehouseConfigDetail.MesSectionWarehouseConfigDetailBuilder(id="
            + this.id
            + ", configId="
            + this.configId
            + ", name="
            + this.name
            + ", productType="
            + this.productType
            + ", productSectionNameEnum="
            + this.productSectionNameEnum
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ", source="
            + this.source
            + ", smallArtifactClassEnum="
            + this.smallArtifactClassEnum
            + ", boolComposeAssemble="
            + this.boolComposeAssemble
            + ")";
      }
   }
}
