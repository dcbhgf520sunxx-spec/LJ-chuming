package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectOrderDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "OrderAnalysisDTO", description = "订单分析")
public class OrderAnalysisDTO {
   @ApiModelProperty(name = "orders", value = "订单", notes = "订单")
   @JsonProperty("orders")
   @JSONField(name = "orders")
   private List<ContractProjectOrderDTO> orders;

   public static OrderAnalysisDTO.OrderAnalysisDTOBuilder builder() {
      return new OrderAnalysisDTO.OrderAnalysisDTOBuilder();
   }

   public OrderAnalysisDTO(final List<ContractProjectOrderDTO> orders) {
      this.orders = orders;
   }

   public OrderAnalysisDTO() {
   }

   public List<ContractProjectOrderDTO> getOrders() {
      return this.orders;
   }

   @JsonProperty("orders")
   public OrderAnalysisDTO setOrders(final List<ContractProjectOrderDTO> orders) {
      this.orders = orders;
      return this;
   }

   @Override
   public String toString() {
      return "OrderAnalysisDTO(orders=" + this.getOrders() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OrderAnalysisDTO)) {
         return false;
      }

      OrderAnalysisDTO other = (OrderAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orders = this.getOrders();
      Object other$orders = other.getOrders();
      return this$orders == null ? other$orders == null : this$orders.equals(other$orders);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OrderAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orders = this.getOrders();
      return result * 59 + ($orders == null ? 43 : $orders.hashCode());
   }

   public static class OrderAnalysisDTOBuilder {
      private List<ContractProjectOrderDTO> orders;

      OrderAnalysisDTOBuilder() {
      }

      @JsonProperty("orders")
      public OrderAnalysisDTO.OrderAnalysisDTOBuilder orders(final List<ContractProjectOrderDTO> orders) {
         this.orders = orders;
         return this;
      }

      public OrderAnalysisDTO build() {
         return new OrderAnalysisDTO(this.orders);
      }

      @Override
      public String toString() {
         return "OrderAnalysisDTO.OrderAnalysisDTOBuilder(orders=" + this.orders + ")";
      }
   }
}
