package com.hzchum.scim.mes.building.core.api.pojo._dto.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.GroupsCurrencyDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.IdAndNameDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "ProcessPriceDetailsDTO", description = "")
public class ProcessPriceDetailsDTO {
   @ApiModelProperty(name = "workshop", notes = "车间", value = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", notes = "产线", value = "产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groups", notes = "生产组", value = "生产组")
   @JsonProperty("groups")
   @JSONField(name = "groups")
   private GroupsCurrencyDO groups;
   @ApiModelProperty(name = "team", notes = "班组", value = "班组")
   @JsonProperty("team")
   @JSONField(name = "team")
   private IdAndNameDO team;
   @ApiModelProperty(name = "process", notes = "工序", value = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "totalPrice", notes = "总工价", value = "总工价")
   @JsonProperty("totalPrice")
   @JSONField(name = "totalPrice")
   private BigDecimal totalPrice;
   @ApiModelProperty(name = "priceList", notes = "每日价格", value = "每日价格")
   @JsonProperty("priceList")
   @JSONField(name = "priceList")
   private List<ProcessPriceDateDetailsDTO> priceList;

   public static ProcessPriceDetailsDTO.ProcessPriceDetailsDTOBuilder builder() {
      return new ProcessPriceDetailsDTO.ProcessPriceDetailsDTOBuilder();
   }

   public ProcessPriceDetailsDTO(
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final GroupsCurrencyDO groups,
      final IdAndNameDO team,
      final IdAndNameDO process,
      final BigDecimal totalPrice,
      final List<ProcessPriceDateDetailsDTO> priceList
   ) {
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.groups = groups;
      this.team = team;
      this.process = process;
      this.totalPrice = totalPrice;
      this.priceList = priceList;
   }

   public ProcessPriceDetailsDTO() {
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

   public IdAndNameDO getTeam() {
      return this.team;
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public List<ProcessPriceDateDetailsDTO> getPriceList() {
      return this.priceList;
   }

   @JsonProperty("workshop")
   public ProcessPriceDetailsDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public ProcessPriceDetailsDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groups")
   public ProcessPriceDetailsDTO setGroups(final GroupsCurrencyDO groups) {
      this.groups = groups;
      return this;
   }

   @JsonProperty("team")
   public ProcessPriceDetailsDTO setTeam(final IdAndNameDO team) {
      this.team = team;
      return this;
   }

   @JsonProperty("process")
   public ProcessPriceDetailsDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("totalPrice")
   public ProcessPriceDetailsDTO setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
      return this;
   }

   @JsonProperty("priceList")
   public ProcessPriceDetailsDTO setPriceList(final List<ProcessPriceDateDetailsDTO> priceList) {
      this.priceList = priceList;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessPriceDetailsDTO(workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", groups="
         + this.getGroups()
         + ", team="
         + this.getTeam()
         + ", process="
         + this.getProcess()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", priceList="
         + this.getPriceList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessPriceDetailsDTO)) {
         return false;
      }

      ProcessPriceDetailsDTO other = (ProcessPriceDetailsDTO)o;
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
            if (this$groups == null ? other$groups == null : this$groups.equals(other$groups)) {
               Object this$team = this.getTeam();
               Object other$team = other.getTeam();
               if (this$team == null ? other$team == null : this$team.equals(other$team)) {
                  Object this$process = this.getProcess();
                  Object other$process = other.getProcess();
                  if (this$process == null ? other$process == null : this$process.equals(other$process)) {
                     Object this$totalPrice = this.getTotalPrice();
                     Object other$totalPrice = other.getTotalPrice();
                     if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                        Object this$priceList = this.getPriceList();
                        Object other$priceList = other.getPriceList();
                        return this$priceList == null ? other$priceList == null : this$priceList.equals(other$priceList);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessPriceDetailsDTO;
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
      result = result * 59 + ($groups == null ? 43 : $groups.hashCode());
      Object $team = this.getTeam();
      result = result * 59 + ($team == null ? 43 : $team.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $priceList = this.getPriceList();
      return result * 59 + ($priceList == null ? 43 : $priceList.hashCode());
   }

   public static class ProcessPriceDetailsDTOBuilder {
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private GroupsCurrencyDO groups;
      private IdAndNameDO team;
      private IdAndNameDO process;
      private BigDecimal totalPrice;
      private List<ProcessPriceDateDetailsDTO> priceList;

      ProcessPriceDetailsDTOBuilder() {
      }

      @JsonProperty("workshop")
      public ProcessPriceDetailsDTO.ProcessPriceDetailsDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public ProcessPriceDetailsDTO.ProcessPriceDetailsDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groups")
      public ProcessPriceDetailsDTO.ProcessPriceDetailsDTOBuilder groups(final GroupsCurrencyDO groups) {
         this.groups = groups;
         return this;
      }

      @JsonProperty("team")
      public ProcessPriceDetailsDTO.ProcessPriceDetailsDTOBuilder team(final IdAndNameDO team) {
         this.team = team;
         return this;
      }

      @JsonProperty("process")
      public ProcessPriceDetailsDTO.ProcessPriceDetailsDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("totalPrice")
      public ProcessPriceDetailsDTO.ProcessPriceDetailsDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      @JsonProperty("priceList")
      public ProcessPriceDetailsDTO.ProcessPriceDetailsDTOBuilder priceList(final List<ProcessPriceDateDetailsDTO> priceList) {
         this.priceList = priceList;
         return this;
      }

      public ProcessPriceDetailsDTO build() {
         return new ProcessPriceDetailsDTO(this.workshop, this.productionLine, this.groups, this.team, this.process, this.totalPrice, this.priceList);
      }

      @Override
      public String toString() {
         return "ProcessPriceDetailsDTO.ProcessPriceDetailsDTOBuilder(workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", groups="
            + this.groups
            + ", team="
            + this.team
            + ", process="
            + this.process
            + ", totalPrice="
            + this.totalPrice
            + ", priceList="
            + this.priceList
            + ")";
      }
   }
}
