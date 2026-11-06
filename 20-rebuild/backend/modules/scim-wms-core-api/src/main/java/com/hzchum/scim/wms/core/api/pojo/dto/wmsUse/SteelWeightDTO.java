package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class SteelWeightDTO {
   @ApiModelProperty(name = "id", value = "数据ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "数据名称")
   private String name;
   @ApiModelProperty(name = "weight", value = "总重量")
   private BigDecimal sumWeight;
   @ApiModelProperty(name = "workshop", value = "仓库重量信息")
   private List<SteelWeightDTO> workshop;
   @ApiModelProperty(name = "warehouse", value = "存储位置重量信息")
   private List<SteelWeightDTO> warehouse;
   @ApiModelProperty(name = "project", value = "项目重量信息")
   private List<SteelWeightDTO> project;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getSumWeight() {
      return this.sumWeight;
   }

   public List<SteelWeightDTO> getWorkshop() {
      return this.workshop;
   }

   public List<SteelWeightDTO> getWarehouse() {
      return this.warehouse;
   }

   public List<SteelWeightDTO> getProject() {
      return this.project;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSumWeight(final BigDecimal sumWeight) {
      this.sumWeight = sumWeight;
   }

   public void setWorkshop(final List<SteelWeightDTO> workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final List<SteelWeightDTO> warehouse) {
      this.warehouse = warehouse;
   }

   public void setProject(final List<SteelWeightDTO> project) {
      this.project = project;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelWeightDTO)) {
         return false;
      }

      SteelWeightDTO other = (SteelWeightDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$sumWeight = this.getSumWeight();
            Object other$sumWeight = other.getSumWeight();
            if (this$sumWeight == null ? other$sumWeight == null : this$sumWeight.equals(other$sumWeight)) {
               Object this$workshop = this.getWorkshop();
               Object other$workshop = other.getWorkshop();
               if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                  Object this$warehouse = this.getWarehouse();
                  Object other$warehouse = other.getWarehouse();
                  if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     return this$project == null ? other$project == null : this$project.equals(other$project);
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
      return other instanceof SteelWeightDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $sumWeight = this.getSumWeight();
      result = result * 59 + ($sumWeight == null ? 43 : $sumWeight.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   @Override
   public String toString() {
      return "SteelWeightDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sumWeight="
         + this.getSumWeight()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", project="
         + this.getProject()
         + ")";
   }
}
