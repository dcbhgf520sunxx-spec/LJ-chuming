package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;

public class StuffTypeConf {
   private Long id;
   @ApiModelProperty(name = "name", value = "名", notes = "名")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名'", nullable = true)
   private String name;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型[位运算]", notes = "物料基础类型[位运算]")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(11)  COMMENT '物料基础类型[位运算]'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "classIds", value = "末级科目集合", notes = "末级科目集合")
   @TableField("class_ids")
   @Column(name = "class_ids", columnDefinition = "varchar(1024)  COMMENT '末级科目集合'", nullable = true)
   private String classIds;
   @ApiModelProperty(name = "status", value = "是否启用 0 关闭 1启用 （根据是否包含末级科目判断）", notes = "是否启用 0 关闭 1启用 （根据是否包含末级科目判断）")
   @TableField("status")
   @Column(name = "status", columnDefinition = "bigint(1)  COMMENT '是否启用 0 关闭 1启用 （根据是否包含末级科目判断）'", nullable = true)
   private Boolean status;

   public static StuffTypeConf.StuffTypeConfBuilder builder() {
      return new StuffTypeConf.StuffTypeConfBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getClassIds() {
      return this.classIds;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassIds(final String classIds) {
      this.classIds = classIds;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StuffTypeConf)) {
         return false;
      }

      StuffTypeConf other = (StuffTypeConf)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$classIds = this.getClassIds();
                  Object other$classIds = other.getClassIds();
                  return this$classIds == null ? other$classIds == null : this$classIds.equals(other$classIds);
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
      return other instanceof StuffTypeConf;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $classIds = this.getClassIds();
      return result * 59 + ($classIds == null ? 43 : $classIds.hashCode());
   }

   @Override
   public String toString() {
      return "StuffTypeConf(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", basicClass="
         + this.getBasicClass()
         + ", classIds="
         + this.getClassIds()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public StuffTypeConf(final Long id, final String name, final Integer basicClass, final String classIds, final Boolean status) {
      this.id = id;
      this.name = name;
      this.basicClass = basicClass;
      this.classIds = classIds;
      this.status = status;
   }

   public StuffTypeConf() {
   }

   public static class StuffTypeConfBuilder {
      private Long id;
      private String name;
      private Integer basicClass;
      private String classIds;
      private Boolean status;

      StuffTypeConfBuilder() {
      }

      public StuffTypeConf.StuffTypeConfBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StuffTypeConf.StuffTypeConfBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public StuffTypeConf.StuffTypeConfBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public StuffTypeConf.StuffTypeConfBuilder classIds(final String classIds) {
         this.classIds = classIds;
         return this;
      }

      public StuffTypeConf.StuffTypeConfBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public StuffTypeConf build() {
         return new StuffTypeConf(this.id, this.name, this.basicClass, this.classIds, this.status);
      }

      @Override
      public String toString() {
         return "StuffTypeConf.StuffTypeConfBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", basicClass="
            + this.basicClass
            + ", classIds="
            + this.classIds
            + ", status="
            + this.status
            + ")";
      }
   }
}
