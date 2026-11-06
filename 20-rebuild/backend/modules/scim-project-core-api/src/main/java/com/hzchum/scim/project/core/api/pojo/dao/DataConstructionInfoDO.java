package com.hzchum.scim.project.core.api.pojo.dao;

import io.swagger.annotations.ApiModelProperty;

public class DataConstructionInfoDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "format", value = "文件格式")
   private Integer format;
   @ApiModelProperty(name = "stage", value = "开工阶段 1开工前2施工中3玩工后")
   private Integer stage;
   @ApiModelProperty(name = "quantity", value = "文件数量")
   private Integer quantity;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getFormat() {
      return this.format;
   }

   public Integer getStage() {
      return this.stage;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setFormat(final Integer format) {
      this.format = format;
   }

   public void setStage(final Integer stage) {
      this.stage = stage;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DataConstructionInfoDO)) {
         return false;
      }

      DataConstructionInfoDO other = (DataConstructionInfoDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$format = this.getFormat();
         Object other$format = other.getFormat();
         if (this$format == null ? other$format == null : this$format.equals(other$format)) {
            Object this$stage = this.getStage();
            Object other$stage = other.getStage();
            if (this$stage == null ? other$stage == null : this$stage.equals(other$stage)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DataConstructionInfoDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $format = this.getFormat();
      result = result * 59 + ($format == null ? 43 : $format.hashCode());
      Object $stage = this.getStage();
      result = result * 59 + ($stage == null ? 43 : $stage.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "DataConstructionInfoDO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", format="
         + this.getFormat()
         + ", stage="
         + this.getStage()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }
}
