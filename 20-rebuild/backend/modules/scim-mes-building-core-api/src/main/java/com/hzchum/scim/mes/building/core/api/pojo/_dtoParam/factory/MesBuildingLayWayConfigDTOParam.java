package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingLayWayConfig对象", description = "下料方式配置DTOParam ")
public class MesBuildingLayWayConfigDTOParam {
   @ApiModelProperty(name = "id", value = "下料配置id", notes = "下料配置id")
   @NotNull(message = "下料配置id不能为空", groups = Update.class)
   private Long id;
   @ApiModelProperty(name = "name", value = "下料方式名称", notes = "下料方式名称")
   @NotBlank(message = "下料方式名称不能为空", groups = Add.class)
   private String name;

   public static MesBuildingLayWayConfigDTOParam.MesBuildingLayWayConfigDTOParamBuilder builder() {
      return new MesBuildingLayWayConfigDTOParam.MesBuildingLayWayConfigDTOParamBuilder();
   }

   public MesBuildingLayWayConfigDTOParam() {
   }

   public MesBuildingLayWayConfigDTOParam(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public MesBuildingLayWayConfigDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingLayWayConfigDTOParam setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingLayWayConfigDTOParam)) {
         return false;
      } else {
         MesBuildingLayWayConfigDTOParam other = (MesBuildingLayWayConfigDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingLayWayConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingLayWayConfigDTOParam(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class MesBuildingLayWayConfigDTOParamBuilder {
      private Long id;
      private String name;

      MesBuildingLayWayConfigDTOParamBuilder() {
      }

      public MesBuildingLayWayConfigDTOParam.MesBuildingLayWayConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingLayWayConfigDTOParam.MesBuildingLayWayConfigDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingLayWayConfigDTOParam build() {
         return new MesBuildingLayWayConfigDTOParam(this.id, this.name);
      }

      @Override
      public String toString() {
         return "MesBuildingLayWayConfigDTOParam.MesBuildingLayWayConfigDTOParamBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
