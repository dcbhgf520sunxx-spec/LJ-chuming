package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
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
@Table(name = "sys_steel_classify_link")
public class SysSteelClassifyLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("钢材分类id")
   @Column
   private Long steelId;
   @ApiModelProperty("物料分类id")
   @Column
   private Long classifyId;
   @ApiModelProperty("物料分类名称")
   @Column
   private String classifyName;
   @ApiModelProperty("路径")
   @Column
   private String path;
   @ApiModelProperty("零件类型")
   @Column
   private Integer productClassificationEnum;

   public static SysSteelClassifyLink.SysSteelClassifyLinkBuilder builder() {
      return new SysSteelClassifyLink.SysSteelClassifyLinkBuilder();
   }

   public SysSteelClassifyLink() {
   }

   public SysSteelClassifyLink(
      final Long id, final Long steelId, final Long classifyId, final String classifyName, final String path, final Integer productClassificationEnum
   ) {
      this.id = id;
      this.steelId = steelId;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.path = path;
      this.productClassificationEnum = productClassificationEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSteelId() {
      return this.steelId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getPath() {
      return this.path;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSteelId(final Long steelId) {
      this.steelId = steelId;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysSteelClassifyLink)) {
         return false;
      }

      SysSteelClassifyLink other = (SysSteelClassifyLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$steelId = this.getSteelId();
         Object other$steelId = other.getSteelId();
         if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$productClassificationEnum = this.getProductClassificationEnum();
               Object other$productClassificationEnum = other.getProductClassificationEnum();
               if (this$productClassificationEnum == null
                  ? other$productClassificationEnum == null
                  : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                  Object this$classifyName = this.getClassifyName();
                  Object other$classifyName = other.getClassifyName();
                  if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                     Object this$path = this.getPath();
                     Object other$path = other.getPath();
                     return this$path == null ? other$path == null : this$path.equals(other$path);
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
      return other instanceof SysSteelClassifyLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $path = this.getPath();
      return result * 59 + ($path == null ? 43 : $path.hashCode());
   }

   @Override
   public String toString() {
      return "SysSteelClassifyLink(id="
         + this.getId()
         + ", steelId="
         + this.getSteelId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", path="
         + this.getPath()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ")";
   }

   public static class SysSteelClassifyLinkBuilder {
      private Long id;
      private Long steelId;
      private Long classifyId;
      private String classifyName;
      private String path;
      private Integer productClassificationEnum;

      SysSteelClassifyLinkBuilder() {
      }

      public SysSteelClassifyLink.SysSteelClassifyLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysSteelClassifyLink.SysSteelClassifyLinkBuilder steelId(final Long steelId) {
         this.steelId = steelId;
         return this;
      }

      public SysSteelClassifyLink.SysSteelClassifyLinkBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public SysSteelClassifyLink.SysSteelClassifyLinkBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public SysSteelClassifyLink.SysSteelClassifyLinkBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public SysSteelClassifyLink.SysSteelClassifyLinkBuilder productClassificationEnum(final Integer productClassificationEnum) {
         this.productClassificationEnum = productClassificationEnum;
         return this;
      }

      public SysSteelClassifyLink build() {
         return new SysSteelClassifyLink(this.id, this.steelId, this.classifyId, this.classifyName, this.path, this.productClassificationEnum);
      }

      @Override
      public String toString() {
         return "SysSteelClassifyLink.SysSteelClassifyLinkBuilder(id="
            + this.id
            + ", steelId="
            + this.steelId
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", path="
            + this.path
            + ", productClassificationEnum="
            + this.productClassificationEnum
            + ")";
      }
   }
}
