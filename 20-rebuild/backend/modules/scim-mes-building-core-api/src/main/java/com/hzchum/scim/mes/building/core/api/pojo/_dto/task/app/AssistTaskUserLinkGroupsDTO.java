package com.hzchum.scim.mes.building.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssistTaskUserLinkGroupsDTO", description = "工序协同用户获取相关生产组信息")
public class AssistTaskUserLinkGroupsDTO {
   @ApiModelProperty(name = "workshop", notes = "工厂")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", notes = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;

   public static AssistTaskUserLinkGroupsDTO.AssistTaskUserLinkGroupsDTOBuilder builder() {
      return new AssistTaskUserLinkGroupsDTO.AssistTaskUserLinkGroupsDTOBuilder();
   }

   public AssistTaskUserLinkGroupsDTO() {
   }

   public AssistTaskUserLinkGroupsDTO(final WorkshopDetailDO workshop, final ProductionLineDetailDO productionLine, final GroupsCurrencyDO groups) {
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public GroupsCurrencyDO getGroups() {
      return this.groups;
   }

   @JsonProperty("workshop")
   public AssistTaskUserLinkGroupsDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public AssistTaskUserLinkGroupsDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public AssistTaskUserLinkGroupsDTO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @Override
   public String toString() {
      return "AssistTaskUserLinkGroupsDTO(workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssistTaskUserLinkGroupsDTO)) {
         return false;
      }

      AssistTaskUserLinkGroupsDTO other = (AssistTaskUserLinkGroupsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshop = this.getWorkshop();
      Object other$workshop = other.getWorkshop();
      if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
         Object this$productionLine = this.getProductionLine();
         Object other$productionLine = other.getProductionLine();
         if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
            Object this$groups = this.getGroups();
            Object other$groups = other.getGroups();
            return this$groups == null ? other$groups == null : this$groups.equals(other$groups);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssistTaskUserLinkGroupsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groups = this.getGroups();
      return result * 59 + ($groups == null ? 43 : $groups.hashCode());
   }

   public static class AssistTaskUserLinkGroupsDTOBuilder {
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;

      AssistTaskUserLinkGroupsDTOBuilder() {
      }

      @JsonProperty("workshop")
      public AssistTaskUserLinkGroupsDTO.AssistTaskUserLinkGroupsDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public AssistTaskUserLinkGroupsDTO.AssistTaskUserLinkGroupsDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public AssistTaskUserLinkGroupsDTO.AssistTaskUserLinkGroupsDTOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      public AssistTaskUserLinkGroupsDTO build() {
         return new AssistTaskUserLinkGroupsDTO(this.workshop, this.productionLine, this.groups);
      }

      @Override
      public String toString() {
         return "AssistTaskUserLinkGroupsDTO.AssistTaskUserLinkGroupsDTOBuilder(workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ")";
      }
   }
}
