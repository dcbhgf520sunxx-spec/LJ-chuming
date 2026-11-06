package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "AssistTeamDTO", description = "添加任务协同详情类")
public class AssistTaskDTO {
   @ApiModelProperty(name = "id", notes = "任务id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "productionLineList", notes = "生产线信息")
   @JsonProperty("productionLineList")
   @JSONField(name = "productionLineList")
   private List<AssistProductionLineDTO> productionLineList;

   public static AssistTaskDTO.AssistTaskDTOBuilder builder() {
      return new AssistTaskDTO.AssistTaskDTOBuilder();
   }

   public AssistTaskDTO() {
   }

   public AssistTaskDTO(final Long id, final List<AssistProductionLineDTO> productionLineList) {
      this.id = id;
      this.productionLineList = productionLineList;
   }

   public Long getId() {
      return this.id;
   }

   public List<AssistProductionLineDTO> getProductionLineList() {
      return this.productionLineList;
   }

   @JsonProperty("id")
   public AssistTaskDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("productionLineList")
   public AssistTaskDTO setProductionLineList(final List<AssistProductionLineDTO> productionLineList) {
      this.productionLineList = productionLineList;
      return this;
   }

   @Override
   public String toString() {
      return "AssistTaskDTO(id=" + this.getId() + ", productionLineList=" + this.getProductionLineList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AssistTaskDTO)) {
         return false;
      } else {
         AssistTaskDTO other = (AssistTaskDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$productionLineList = this.getProductionLineList();
               Object other$productionLineList = other.getProductionLineList();
               return this$productionLineList == null ? other$productionLineList == null : this$productionLineList.equals(other$productionLineList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssistTaskDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineList = this.getProductionLineList();
      return result * 59 + ($productionLineList == null ? 43 : $productionLineList.hashCode());
   }

   public static class AssistTaskDTOBuilder {
      private Long id;
      private List<AssistProductionLineDTO> productionLineList;

      AssistTaskDTOBuilder() {
      }

      @JsonProperty("id")
      public AssistTaskDTO.AssistTaskDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("productionLineList")
      public AssistTaskDTO.AssistTaskDTOBuilder productionLineList(final List<AssistProductionLineDTO> productionLineList) {
         this.productionLineList = productionLineList;
         return this;
      }

      public AssistTaskDTO build() {
         return new AssistTaskDTO(this.id, this.productionLineList);
      }

      @Override
      public String toString() {
         return "AssistTaskDTO.AssistTaskDTOBuilder(id=" + this.id + ", productionLineList=" + this.productionLineList + ")";
      }
   }
}
