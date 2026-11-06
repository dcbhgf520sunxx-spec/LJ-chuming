package com.hzchum.scim.common.core.api.pojo._do;

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

@ApiModel(description = "应用信息")
@Entity
@Table(name = "common_app")
public class CommonApp extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("名称")
   @Column
   private String name;
   @ApiModelProperty("备注")
   @Column
   private String remark;

   public static CommonApp.CommonAppBuilder builder() {
      return new CommonApp.CommonAppBuilder();
   }

   public CommonApp() {
   }

   public CommonApp(final Long id, final String name, final String remark) {
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommonApp)) {
         return false;
      }

      CommonApp other = (CommonApp)o;
      if (!other.canEqual(this)) {
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
      return other instanceof CommonApp;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CommonApp(id=" + this.getId() + ", name=" + this.getName() + ", remark=" + this.getRemark() + ")";
   }

   public static class CommonAppBuilder {
      private Long id;
      private String name;
      private String remark;

      CommonAppBuilder() {
      }

      public CommonApp.CommonAppBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CommonApp.CommonAppBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CommonApp.CommonAppBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CommonApp build() {
         return new CommonApp(this.id, this.name, this.remark);
      }

      @Override
      public String toString() {
         return "CommonApp.CommonAppBuilder(id=" + this.id + ", name=" + this.name + ", remark=" + this.remark + ")";
      }
   }
}
