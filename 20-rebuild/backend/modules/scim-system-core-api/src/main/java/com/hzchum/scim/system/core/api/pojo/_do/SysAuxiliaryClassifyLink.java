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

@ApiModel(description = "配套件分类匹配 ")
@Entity
@Table(name = "sys_auxiliary_classify_link")
public class SysAuxiliaryClassifyLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("配套件分类id")
   @Column
   private Long auxiliaryId;
   @ApiModelProperty("物料分类id")
   @Column
   private Long classifyId;
   @ApiModelProperty("物料分类名称")
   @Column
   private String classifyName;
   @ApiModelProperty("路径")
   @Column
   private String path;

   public static SysAuxiliaryClassifyLink.SysAuxiliaryClassifyLinkBuilder builder() {
      return new SysAuxiliaryClassifyLink.SysAuxiliaryClassifyLinkBuilder();
   }

   public SysAuxiliaryClassifyLink() {
   }

   public SysAuxiliaryClassifyLink(final Long id, final Long auxiliaryId, final Long classifyId, final String classifyName, final String path) {
      this.id = id;
      this.auxiliaryId = auxiliaryId;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.path = path;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAuxiliaryId() {
      return this.auxiliaryId;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuxiliaryId(final Long auxiliaryId) {
      this.auxiliaryId = auxiliaryId;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAuxiliaryClassifyLink)) {
         return false;
      }

      SysAuxiliaryClassifyLink other = (SysAuxiliaryClassifyLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auxiliaryId = this.getAuxiliaryId();
         Object other$auxiliaryId = other.getAuxiliaryId();
         if (this$auxiliaryId == null ? other$auxiliaryId == null : this$auxiliaryId.equals(other$auxiliaryId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysAuxiliaryClassifyLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auxiliaryId = this.getAuxiliaryId();
      result = result * 59 + ($auxiliaryId == null ? 43 : $auxiliaryId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $path = this.getPath();
      return result * 59 + ($path == null ? 43 : $path.hashCode());
   }

   @Override
   public String toString() {
      return "SysAuxiliaryClassifyLink(id="
         + this.getId()
         + ", auxiliaryId="
         + this.getAuxiliaryId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", path="
         + this.getPath()
         + ")";
   }

   public static class SysAuxiliaryClassifyLinkBuilder {
      private Long id;
      private Long auxiliaryId;
      private Long classifyId;
      private String classifyName;
      private String path;

      SysAuxiliaryClassifyLinkBuilder() {
      }

      public SysAuxiliaryClassifyLink.SysAuxiliaryClassifyLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysAuxiliaryClassifyLink.SysAuxiliaryClassifyLinkBuilder auxiliaryId(final Long auxiliaryId) {
         this.auxiliaryId = auxiliaryId;
         return this;
      }

      public SysAuxiliaryClassifyLink.SysAuxiliaryClassifyLinkBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public SysAuxiliaryClassifyLink.SysAuxiliaryClassifyLinkBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public SysAuxiliaryClassifyLink.SysAuxiliaryClassifyLinkBuilder path(final String path) {
         this.path = path;
         return this;
      }

      public SysAuxiliaryClassifyLink build() {
         return new SysAuxiliaryClassifyLink(this.id, this.auxiliaryId, this.classifyId, this.classifyName, this.path);
      }

      @Override
      public String toString() {
         return "SysAuxiliaryClassifyLink.SysAuxiliaryClassifyLinkBuilder(id="
            + this.id
            + ", auxiliaryId="
            + this.auxiliaryId
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", path="
            + this.path
            + ")";
      }
   }
}
