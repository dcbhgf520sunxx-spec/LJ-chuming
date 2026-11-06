package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class MesBuildingProjectWorkshopDTO {
   @ApiModelProperty(name = "id", notes = "车间Id")
   private Long id;
   @ApiModelProperty(name = "name", value = "车间名", notes = "车间名")
   private String name;
   @ApiModelProperty(name = "shortName", value = "车间简名", notes = "车间简名")
   private String shortName;
   @ApiModelProperty(name = "boolEnabledEnum", value = "禁用状态 启用状态 [0 禁用, 1 启用]", notes = "禁用状态 启用状态 [0 禁用, 1 启用]")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "type", value = "车间类型 1:建钢车间 2:桥梁车间 4:围护车间", notes = "车间类型  1:建钢车间 2:桥梁车间 4:围护车间")
   private Integer type;
   @ApiModelProperty(name = "projectProductionLineDTOS", value = "产线列表", notes = "产线列表")
   private List<MesBuildingProjectProductionLineDTO> projectProductionLineDTOS;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
   }

   public Integer getType() {
      return this.type;
   }

   public List<MesBuildingProjectProductionLineDTO> getProjectProductionLineDTOS() {
      return this.projectProductionLineDTOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setProjectProductionLineDTOS(final List<MesBuildingProjectProductionLineDTO> projectProductionLineDTOS) {
      this.projectProductionLineDTOS = projectProductionLineDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProjectWorkshopDTO)) {
         return false;
      }

      MesBuildingProjectWorkshopDTO other = (MesBuildingProjectWorkshopDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolEnabledEnum = this.getBoolEnabledEnum();
         Object other$boolEnabledEnum = other.getBoolEnabledEnum();
         if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$projectProductionLineDTOS = this.getProjectProductionLineDTOS();
                     Object other$projectProductionLineDTOS = other.getProjectProductionLineDTOS();
                     return this$projectProductionLineDTOS == null
                        ? other$projectProductionLineDTOS == null
                        : this$projectProductionLineDTOS.equals(other$projectProductionLineDTOS);
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

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProjectWorkshopDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $projectProductionLineDTOS = this.getProjectProductionLineDTOS();
      return result * 59 + ($projectProductionLineDTOS == null ? 43 : $projectProductionLineDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingProjectWorkshopDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
         + ", type="
         + this.getType()
         + ", projectProductionLineDTOS="
         + this.getProjectProductionLineDTOS()
         + ")";
   }
}
