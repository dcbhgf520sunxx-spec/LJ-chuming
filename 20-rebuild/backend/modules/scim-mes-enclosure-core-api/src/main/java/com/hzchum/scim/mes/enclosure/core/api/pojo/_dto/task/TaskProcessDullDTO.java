package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.ProductionLineDetailDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process.ProcessListDetailDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "TaskProcessDullDTO", description = "工序呆滞")
public class TaskProcessDullDTO {
   @ApiModelProperty(name = "process", notes = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private ProcessListDetailDTO process;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "productionLine", notes = "生产线")
   @JsonProperty("productionLine")
   @JSONField(name = "productionLine")
   private ProductionLineDetailDO productionLine;
   @ApiModelProperty(name = "groupList", notes = "生产组")
   @JsonProperty("groupList")
   @JSONField(name = "groupList")
   private List<NameInfo> groupList;
   @ApiModelProperty(name = "quantity", notes = "总数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;

   public static TaskProcessDullDTO.TaskProcessDullDTOBuilder builder() {
      return new TaskProcessDullDTO.TaskProcessDullDTOBuilder();
   }

   public TaskProcessDullDTO() {
   }

   public TaskProcessDullDTO(
      final ProcessListDetailDTO process,
      final Integer productType,
      final ProductionLineDetailDO productionLine,
      final List<NameInfo> groupList,
      final Integer quantity,
      final BigDecimal totalNetWeight,
      final BigDecimal totalGrossWeight
   ) {
      this.process = process;
      this.productType = productType;
      this.productionLine = productionLine;
      this.groupList = groupList;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
   }

   public ProcessListDetailDTO getProcess() {
      return this.process;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public ProductionLineDetailDO getProductionLine() {
      return this.productionLine;
   }

   public List<NameInfo> getGroupList() {
      return this.groupList;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   @JsonProperty("process")
   public TaskProcessDullDTO setProcess(final ProcessListDetailDTO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("productType")
   public TaskProcessDullDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("productionLine")
   public TaskProcessDullDTO setProductionLine(final ProductionLineDetailDO productionLine) {
      this.productionLine = productionLine;
      return this;
   }

   @JsonProperty("groupList")
   public TaskProcessDullDTO setGroupList(final List<NameInfo> groupList) {
      this.groupList = groupList;
      return this;
   }

   @JsonProperty("quantity")
   public TaskProcessDullDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public TaskProcessDullDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public TaskProcessDullDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "TaskProcessDullDTO(process="
         + this.getProcess()
         + ", productType="
         + this.getProductType()
         + ", productionLine="
         + this.getProductionLine()
         + ", groupList="
         + this.getGroupList()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskProcessDullDTO)) {
         return false;
      }

      TaskProcessDullDTO other = (TaskProcessDullDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$process = this.getProcess();
            Object other$process = other.getProcess();
            if (this$process == null ? other$process == null : this$process.equals(other$process)) {
               Object this$productionLine = this.getProductionLine();
               Object other$productionLine = other.getProductionLine();
               if (this$productionLine == null ? other$productionLine == null : this$productionLine.equals(other$productionLine)) {
                  Object this$groupList = this.getGroupList();
                  Object other$groupList = other.getGroupList();
                  if (this$groupList == null ? other$groupList == null : this$groupList.equals(other$groupList)) {
                     Object this$totalNetWeight = this.getTotalNetWeight();
                     Object other$totalNetWeight = other.getTotalNetWeight();
                     if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                        Object this$totalGrossWeight = this.getTotalGrossWeight();
                        Object other$totalGrossWeight = other.getTotalGrossWeight();
                        return this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight);
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
      return other instanceof TaskProcessDullDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $productionLine = this.getProductionLine();
      result = result * 59 + ($productionLine == null ? 43 : $productionLine.hashCode());
      Object $groupList = this.getGroupList();
      result = result * 59 + ($groupList == null ? 43 : $groupList.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      return result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
   }

   public static class TaskProcessDullDTOBuilder {
      private ProcessListDetailDTO process;
      private Integer productType;
      private ProductionLineDetailDO productionLine;
      private List<NameInfo> groupList;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;

      TaskProcessDullDTOBuilder() {
      }

      @JsonProperty("process")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder process(final ProcessListDetailDTO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("productType")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("productionLine")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder productionLine(final ProductionLineDetailDO productionLine) {
         this.productionLine = productionLine;
         return this;
      }

      @JsonProperty("groupList")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder groupList(final List<NameInfo> groupList) {
         this.groupList = groupList;
         return this;
      }

      @JsonProperty("quantity")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public TaskProcessDullDTO.TaskProcessDullDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TaskProcessDullDTO build() {
         return new TaskProcessDullDTO(
            this.process, this.productType, this.productionLine, this.groupList, this.quantity, this.totalNetWeight, this.totalGrossWeight
         );
      }

      @Override
      public String toString() {
         return "TaskProcessDullDTO.TaskProcessDullDTOBuilder(process="
            + this.process
            + ", productType="
            + this.productType
            + ", productionLine="
            + this.productionLine
            + ", groupList="
            + this.groupList
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ")";
      }
   }
}
