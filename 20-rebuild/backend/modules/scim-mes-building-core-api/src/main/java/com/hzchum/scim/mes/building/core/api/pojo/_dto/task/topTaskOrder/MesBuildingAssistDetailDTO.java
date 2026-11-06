package com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.WorkshopDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingAssistDetailDTO", description = "协同历史记录")
public class MesBuildingAssistDetailDTO {
   @ApiModelProperty(name = "协同记录id", value = "协同记录id", notes = "协同记录id")
   @JsonProperty("assistId")
   @JSONField(name = "assistId")
   private Long assistId;
   @ApiModelProperty(name = "任务id", value = "任务id", notes = "任务id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   private Long factoryId;
   @ApiModelProperty(name = "workshop", value = "车间", notes = "车间")
   @JsonProperty("workshop")
   @JSONField(name = "workshop")
   private WorkshopDetailDO workshop;
   @ApiModelProperty(name = "productionLine", value = "生产线", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "numbers", value = "一物一码号", notes = "一物一码号")
   @JsonProperty("numbers")
   @JSONField(name = "numbers")
   private List<MesBuildingNumberReplaceDTO> numbers;
   @ApiModelProperty(name = "quantity", value = "协同数", notes = "协同数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "produceQuantity", value = "协同完成数", notes = "协同完成数")
   @JsonProperty("produceQuantity")
   @JSONField(name = "produceQuantity")
   private Integer produceQuantity;
   @ApiModelProperty(name = "boolUpdateGroup", value = "是否可以修改班组", notes = "是否可以修改班组")
   @JsonProperty("boolUpdateGroup")
   @JSONField(name = "boolUpdateGroup")
   private Boolean boolUpdateGroup;
   @ApiModelProperty(name = "boolCanDelete", value = "是否可以删除本条数据", notes = "是否可以删除本条数据")
   @JsonProperty("boolCanDelete")
   @JSONField(name = "boolCanDelete")
   private Boolean boolCanDelete;

   public static MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder builder() {
      return new MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder();
   }

   public MesBuildingAssistDetailDTO() {
   }

   public MesBuildingAssistDetailDTO(
      final Long assistId,
      final Long processId,
      final Long factoryId,
      final WorkshopDetailDO workshop,
      final ProductionLineDetailDO productionLine,
      final List<MesBuildingNumberReplaceDTO> numbers,
      final Integer quantity,
      final Integer produceQuantity,
      final Boolean boolUpdateGroup,
      final Boolean boolCanDelete
   ) {
      this.assistId = assistId;
      this.processId = processId;
      this.factoryId = factoryId;
      this.workshop = workshop;
      this.productionLine = productionLine;
      this.numbers = numbers;
      this.quantity = quantity;
      this.produceQuantity = produceQuantity;
      this.boolUpdateGroup = boolUpdateGroup;
      this.boolCanDelete = boolCanDelete;
   }

   public Long getAssistId() {
      return this.assistId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public WorkshopDetailDO getWorkshop() {
      return this.workshop;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public List<MesBuildingNumberReplaceDTO> getNumbers() {
      return this.numbers;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProduceQuantity() {
      return this.produceQuantity;
   }

   public Boolean getBoolUpdateGroup() {
      return this.boolUpdateGroup;
   }

   public Boolean getBoolCanDelete() {
      return this.boolCanDelete;
   }

   @JsonProperty("assistId")
   public MesBuildingAssistDetailDTO setAssistId(final Long assistId) {
      this.assistId = assistId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingAssistDetailDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingAssistDetailDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshop")
   public MesBuildingAssistDetailDTO setWorkshop(final WorkshopDetailDO workshop) {
      this.workshop = workshop;
      return this;
   }

   @JsonProperty("productionLine")
   public MesBuildingAssistDetailDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("numbers")
   public MesBuildingAssistDetailDTO setNumbers(final List<MesBuildingNumberReplaceDTO> numbers) {
      this.numbers = numbers;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingAssistDetailDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("produceQuantity")
   public MesBuildingAssistDetailDTO setProduceQuantity(final Integer produceQuantity) {
      this.produceQuantity = produceQuantity;
      return this;
   }

   @JsonProperty("boolUpdateGroup")
   public MesBuildingAssistDetailDTO setBoolUpdateGroup(final Boolean boolUpdateGroup) {
      this.boolUpdateGroup = boolUpdateGroup;
      return this;
   }

   @JsonProperty("boolCanDelete")
   public MesBuildingAssistDetailDTO setBoolCanDelete(final Boolean boolCanDelete) {
      this.boolCanDelete = boolCanDelete;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssistDetailDTO(assistId="
         + this.getAssistId()
         + ", processId="
         + this.getProcessId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshop="
         + this.getWorkshop()
         + ", productionLine="
         + this.getProductionLine()
         + ", numbers="
         + this.getNumbers()
         + ", quantity="
         + this.getQuantity()
         + ", produceQuantity="
         + this.getProduceQuantity()
         + ", boolUpdateGroup="
         + this.getBoolUpdateGroup()
         + ", boolCanDelete="
         + this.getBoolCanDelete()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssistDetailDTO)) {
         return false;
      }

      MesBuildingAssistDetailDTO other = (MesBuildingAssistDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$assistId = this.getAssistId();
      Object other$assistId = other.getAssistId();
      if (this$assistId == null ? other$assistId == null : this$assistId.equals(other$assistId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$produceQuantity = this.getProduceQuantity();
                  Object other$produceQuantity = other.getProduceQuantity();
                  if (this$produceQuantity == null ? other$produceQuantity == null : this$produceQuantity.equals(other$produceQuantity)) {
                     Object this$boolUpdateGroup = this.getBoolUpdateGroup();
                     Object other$boolUpdateGroup = other.getBoolUpdateGroup();
                     if (this$boolUpdateGroup == null ? other$boolUpdateGroup == null : this$boolUpdateGroup.equals(other$boolUpdateGroup)) {
                        Object this$boolCanDelete = this.getBoolCanDelete();
                        Object other$boolCanDelete = other.getBoolCanDelete();
                        if (this$boolCanDelete == null ? other$boolCanDelete == null : this$boolCanDelete.equals(other$boolCanDelete)) {
                           Object this$workshop = this.getWorkshop();
                           Object other$workshop = other.getWorkshop();
                           if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                              Object this$productionLine = this.getProductionLine();
                              Object other$productionLine = other.getProductionLine();
                              if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                                 Object this$numbers = this.getNumbers();
                                 Object other$numbers = other.getNumbers();
                                 return this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers);
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
      return other instanceof MesBuildingAssistDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $assistId = this.getAssistId();
      result = result * 59 + ($assistId == null ? 43 : $assistId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $produceQuantity = this.getProduceQuantity();
      result = result * 59 + ($produceQuantity == null ? 43 : $produceQuantity.hashCode());
      Object $boolUpdateGroup = this.getBoolUpdateGroup();
      result = result * 59 + ($boolUpdateGroup == null ? 43 : $boolUpdateGroup.hashCode());
      Object $boolCanDelete = this.getBoolCanDelete();
      result = result * 59 + ($boolCanDelete == null ? 43 : $boolCanDelete.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $numbers = this.getNumbers();
      return result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
   }

   public static class MesBuildingAssistDetailDTOBuilder {
      private Long assistId;
      private Long processId;
      private Long factoryId;
      private WorkshopDetailDO workshop;
      private ProductionLineDetailDO productionLine;
      private List<MesBuildingNumberReplaceDTO> numbers;
      private Integer quantity;
      private Integer produceQuantity;
      private Boolean boolUpdateGroup;
      private Boolean boolCanDelete;

      MesBuildingAssistDetailDTOBuilder() {
      }

      @JsonProperty("assistId")
      public MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder assistId(final Long assistId) {
         this.assistId = assistId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshop")
      public MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder workshop(final WorkshopDetailDO workshop) {
         this.workshop = workshop;
         return this;
      }

      @JsonProperty("productionLine")
      public MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("numbers")
      public MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder numbers(final List<MesBuildingNumberReplaceDTO> numbers) {
         this.numbers = numbers;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("produceQuantity")
      public MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder produceQuantity(final Integer produceQuantity) {
         this.produceQuantity = produceQuantity;
         return this;
      }

      @JsonProperty("boolUpdateGroup")
      public MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder boolUpdateGroup(final Boolean boolUpdateGroup) {
         this.boolUpdateGroup = boolUpdateGroup;
         return this;
      }

      @JsonProperty("boolCanDelete")
      public MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder boolCanDelete(final Boolean boolCanDelete) {
         this.boolCanDelete = boolCanDelete;
         return this;
      }

      public MesBuildingAssistDetailDTO build() {
         return new MesBuildingAssistDetailDTO(
            this.assistId,
            this.processId,
            this.factoryId,
            this.workshop,
            this.productionLine,
            this.numbers,
            this.quantity,
            this.produceQuantity,
            this.boolUpdateGroup,
            this.boolCanDelete
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssistDetailDTO.MesBuildingAssistDetailDTOBuilder(assistId="
            + this.assistId
            + ", processId="
            + this.processId
            + ", factoryId="
            + this.factoryId
            + ", workshop="
            + this.workshop
            + ", productionLine="
            + this.productionLine
            + ", numbers="
            + this.numbers
            + ", quantity="
            + this.quantity
            + ", produceQuantity="
            + this.produceQuantity
            + ", boolUpdateGroup="
            + this.boolUpdateGroup
            + ", boolCanDelete="
            + this.boolCanDelete
            + ")";
      }
   }
}
