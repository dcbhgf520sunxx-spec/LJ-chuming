package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "钢材分类 ")
@Entity
@Table(name = "sys_steel_classification")
public class SysSteelClassification extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("名称")
   @Column
   private String name;
   @ApiModelProperty("排序")
   @Column
   private Integer sort;
   @ApiModelProperty("物料基础分类")
   @Column
   private Integer basicClass;
   @ApiModelProperty("零件类型")
   @Column(name = "product_classification_enum", columnDefinition = "int(11) default '1' COMMENT '零件类型 4成品型材 8钢板制品'")
   private Integer productClassificationEnum;
   @ApiModelProperty("零件种类")
   @Column(name = "steel_plate_type_enum", columnDefinition = "int(11) default '1' COMMENT '零件种类 1零件板,2翼腹板 3型材制品'")
   private Integer steelPlateTypeEnum;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static SysSteelClassification.SysSteelClassificationBuilder builder() {
      return new SysSteelClassification.SysSteelClassificationBuilder();
   }

   public SysSteelClassification() {
   }

   public SysSteelClassification(
      final Long id,
      final String name,
      final Integer sort,
      final Integer basicClass,
      final Integer productClassificationEnum,
      final Integer steelPlateTypeEnum,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.basicClass = basicClass;
      this.productClassificationEnum = productClassificationEnum;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysSteelClassification)) {
         return false;
      }

      SysSteelClassification other = (SysSteelClassification)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$productClassificationEnum = this.getProductClassificationEnum();
               Object other$productClassificationEnum = other.getProductClassificationEnum();
               if (this$productClassificationEnum == null
                  ? other$productClassificationEnum == null
                  : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                  Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                  Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                  if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                     Object this$mesProductEnum = this.getMesProductEnum();
                     Object other$mesProductEnum = other.getMesProductEnum();
                     if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysSteelClassification;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SysSteelClassification(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", basicClass="
         + this.getBasicClass()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   public static class SysSteelClassificationBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Integer basicClass;
      private Integer productClassificationEnum;
      private Integer steelPlateTypeEnum;
      private Integer mesProductEnum;

      SysSteelClassificationBuilder() {
      }

      public SysSteelClassification.SysSteelClassificationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysSteelClassification.SysSteelClassificationBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysSteelClassification.SysSteelClassificationBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysSteelClassification.SysSteelClassificationBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SysSteelClassification.SysSteelClassificationBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      public SysSteelClassification.SysSteelClassificationBuilder steelPlateTypeEnum(final Integer steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      public SysSteelClassification.SysSteelClassificationBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysSteelClassification build() {
         return new SysSteelClassification(
            this.id, this.name, this.sort, this.basicClass, this.productClassificationEnum, this.steelPlateTypeEnum, this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "SysSteelClassification.SysSteelClassificationBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", basicClass="
            + this.basicClass
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
