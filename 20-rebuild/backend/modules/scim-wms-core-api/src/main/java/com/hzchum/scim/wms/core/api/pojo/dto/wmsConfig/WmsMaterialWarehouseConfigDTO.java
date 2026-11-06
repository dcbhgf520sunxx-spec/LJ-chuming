package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.Column;

public class WmsMaterialWarehouseConfigDTO {
   private Long id;
   @ApiModelProperty(name = "basicClass", value = "基础物料类型,针对一级科目", notes = "基础物料类型,针对一级科目")
   @JsonProperty("basicClass")
   @JSONField(name = "basicClass")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int  COMMENT '基础物料类型,针对一级科目'", nullable = true)
   private Integer basicClass;
   @ApiModelProperty(name = "name", value = "仓库名", notes = "仓库名")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '仓库名'", nullable = true)
   private String name;
   private List<Classification> list;

   WmsMaterialWarehouseConfigDTO(final Long id, final Integer basicClass, final String name, final List<Classification> list) {
      this.id = id;
      this.basicClass = basicClass;
      this.name = name;
      this.list = list;
   }

   public static WmsMaterialWarehouseConfigDTO.WmsMaterialWarehouseConfigDTOBuilder builder() {
      return new WmsMaterialWarehouseConfigDTO.WmsMaterialWarehouseConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getName() {
      return this.name;
   }

   public List<Classification> getList() {
      return this.list;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("basicClass")
   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @JsonProperty("name")
   public void setName(final String name) {
      this.name = name;
   }

   public void setList(final List<Classification> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsMaterialWarehouseConfigDTO)) {
         return false;
      }

      WmsMaterialWarehouseConfigDTO other = (WmsMaterialWarehouseConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$list = this.getList();
               Object other$list = other.getList();
               return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof WmsMaterialWarehouseConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "WmsMaterialWarehouseConfigDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", name="
         + this.getName()
         + ", list="
         + this.getList()
         + ")";
   }

   public static class WmsMaterialWarehouseConfigDTOBuilder {
      private Long id;
      private Integer basicClass;
      private String name;
      private List<Classification> list;

      WmsMaterialWarehouseConfigDTOBuilder() {
      }

      public WmsMaterialWarehouseConfigDTO.WmsMaterialWarehouseConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("basicClass")
      public WmsMaterialWarehouseConfigDTO.WmsMaterialWarehouseConfigDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      @JsonProperty("name")
      public WmsMaterialWarehouseConfigDTO.WmsMaterialWarehouseConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public WmsMaterialWarehouseConfigDTO.WmsMaterialWarehouseConfigDTOBuilder list(final List<Classification> list) {
         this.list = list;
         return this;
      }

      public WmsMaterialWarehouseConfigDTO build() {
         return new WmsMaterialWarehouseConfigDTO(this.id, this.basicClass, this.name, this.list);
      }

      @Override
      public String toString() {
         return "WmsMaterialWarehouseConfigDTO.WmsMaterialWarehouseConfigDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", name="
            + this.name
            + ", list="
            + this.list
            + ")";
      }
   }
}
