package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesArtifactClass对象", description = "构件类别表")
@Entity
@TableName("mes_artifact_class")
@Table(name = "mes_artifact_class")
public class MesArtifactClass extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1000)  COMMENT '备注'", nullable = true)
   private String remark;

   public static MesArtifactClass.MesArtifactClassBuilder builder() {
      return new MesArtifactClass.MesArtifactClassBuilder();
   }

   public MesArtifactClass() {
   }

   public MesArtifactClass(final Long id, final String name, final String remark) {
      this.id = id;
      this.name = name;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public MesArtifactClass setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesArtifactClass setName(final String name) {
      this.name = name;
      return this;
   }

   public MesArtifactClass setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "MesArtifactClass(id=" + this.getId() + ", name=" + this.getName() + ", remark=" + this.getRemark() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesArtifactClass)) {
         return false;
      }

      MesArtifactClass other = (MesArtifactClass)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesArtifactClass;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class MesArtifactClassBuilder {
      private Long id;
      private String name;
      private String remark;

      MesArtifactClassBuilder() {
      }

      public MesArtifactClass.MesArtifactClassBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesArtifactClass.MesArtifactClassBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesArtifactClass.MesArtifactClassBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MesArtifactClass build() {
         return new MesArtifactClass(this.id, this.name, this.remark);
      }

      @Override
      public String toString() {
         return "MesArtifactClass.MesArtifactClassBuilder(id=" + this.id + ", name=" + this.name + ", remark=" + this.remark + ")";
      }
   }
}
