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

@ApiModel(description = "钢材分类匹配 ")
@Entity
@Table(name = "sys_steel_classification_match")
public class SysSteelClassificationMatch extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("钢材分类id")
   @Column
   private Long steelId;
   @ApiModelProperty("规格索引")
   @Column
   private Integer specIndex;
   @ApiModelProperty("字母关键字")
   @Column
   private String keyword;
   @ApiModelProperty("零件种类")
   @Column(name = "steel_plate_type_enum", columnDefinition = "int(11) default '1' COMMENT '零件种类 1零件板,2翼腹板 3型材制品'")
   private Integer steelPlateTypeEnum;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static SysSteelClassificationMatch.SysSteelClassificationMatchBuilder builder() {
      return new SysSteelClassificationMatch.SysSteelClassificationMatchBuilder();
   }

   public SysSteelClassificationMatch() {
   }

   public SysSteelClassificationMatch(
      final Long id, final Long steelId, final Integer specIndex, final String keyword, final Integer steelPlateTypeEnum, final Integer mesProductEnum
   ) {
      this.id = id;
      this.steelId = steelId;
      this.specIndex = specIndex;
      this.keyword = keyword;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public Integer getSpecIndex() {
      return this.specIndex;
   }

   public String getKeyword() {
      return this.keyword;
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

   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setSpecIndex(final Integer specIndex) {
      this.specIndex = specIndex;
   }

   public void setKeyword(final String keyword) {
      this.keyword = keyword;
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

      if (!(o instanceof SysSteelClassificationMatch)) {
         return false;
      }

      SysSteelClassificationMatch other = (SysSteelClassificationMatch)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$steelId = this.getSteelId();
         Object other$steelId = other.getSteelId();
         if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
            Object this$specIndex = this.getSpecIndex();
            Object other$specIndex = other.getSpecIndex();
            if (this$specIndex == null ? other$specIndex == null : this$specIndex.equals(other$specIndex)) {
               Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
               Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
               if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                  Object this$mesProductEnum = this.getMesProductEnum();
                  Object other$mesProductEnum = other.getMesProductEnum();
                  if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                     Object this$keyword = this.getKeyword();
                     Object other$keyword = other.getKeyword();
                     return this$keyword == null ? other$keyword == null : this$keyword.equals(other$keyword);
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
      return other instanceof SysSteelClassificationMatch;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $specIndex = this.getSpecIndex();
      result = result * 59 + ($specIndex == null ? 43 : $specIndex.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $keyword = this.getKeyword();
      return result * 59 + ($keyword == null ? 43 : $keyword.hashCode());
   }

   @Override
   public String toString() {
      return "SysSteelClassificationMatch(id="
         + this.getId()
         + ", steelId="
         + this.getSteelId()
         + ", specIndex="
         + this.getSpecIndex()
         + ", keyword="
         + this.getKeyword()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   public static class SysSteelClassificationMatchBuilder {
      private Long id;
      private Long steelId;
      private Integer specIndex;
      private String keyword;
      private Integer steelPlateTypeEnum;
      private Integer mesProductEnum;

      SysSteelClassificationMatchBuilder() {
      }

      public SysSteelClassificationMatch.SysSteelClassificationMatchBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysSteelClassificationMatch.SysSteelClassificationMatchBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      public SysSteelClassificationMatch.SysSteelClassificationMatchBuilder specIndex(final Integer specIndex) {
         this.specIndex = specIndex;
         return this;
      }

      public SysSteelClassificationMatch.SysSteelClassificationMatchBuilder keyword(final String keyword) {
         this.keyword = keyword;
         return this;
      }

      public SysSteelClassificationMatch.SysSteelClassificationMatchBuilder steelPlateTypeEnum(final Integer steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      public SysSteelClassificationMatch.SysSteelClassificationMatchBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysSteelClassificationMatch build() {
         return new SysSteelClassificationMatch(this.id, this.steelId, this.specIndex, this.keyword, this.steelPlateTypeEnum, this.mesProductEnum);
      }

      @Override
      public String toString() {
         return "SysSteelClassificationMatch.SysSteelClassificationMatchBuilder(id="
            + this.id
            + ", steelId="
            + this.steelId
            + ", specIndex="
            + this.specIndex
            + ", keyword="
            + this.keyword
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
