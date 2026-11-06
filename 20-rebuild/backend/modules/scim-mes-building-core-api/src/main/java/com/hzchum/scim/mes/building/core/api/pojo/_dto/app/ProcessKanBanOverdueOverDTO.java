package com.hzchum.scim.mes.building.core.api.pojo._dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "app工序看板-逾期工单")
public class ProcessKanBanOverdueOverDTO {
   @ApiModelProperty("逾期工单数")
   private Integer overdueCount;
   private List<OverdueOverInfoDTO> orders;

   public static ProcessKanBanOverdueOverDTO.ProcessKanBanOverdueOverDTOBuilder builder() {
      return new ProcessKanBanOverdueOverDTO.ProcessKanBanOverdueOverDTOBuilder();
   }

   public ProcessKanBanOverdueOverDTO(final Integer overdueCount, final List<OverdueOverInfoDTO> orders) {
      this.overdueCount = overdueCount;
      this.orders = orders;
   }

   public ProcessKanBanOverdueOverDTO() {
   }

   public Integer getOverdueCount() {
      return this.overdueCount;
   }

   public List<OverdueOverInfoDTO> getOrders() {
      return this.orders;
   }

   public ProcessKanBanOverdueOverDTO setOverdueCount(final Integer overdueCount) {
      this.overdueCount = overdueCount;
      return this;
   }

   public ProcessKanBanOverdueOverDTO setOrders(final List<OverdueOverInfoDTO> orders) {
      this.orders = orders;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessKanBanOverdueOverDTO(overdueCount=" + this.getOverdueCount() + ", orders=" + this.getOrders() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProcessKanBanOverdueOverDTO)) {
         return false;
      } else {
         ProcessKanBanOverdueOverDTO other = (ProcessKanBanOverdueOverDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$overdueCount = this.getOverdueCount();
            Object other$overdueCount = other.getOverdueCount();
            if (this$overdueCount == null ? other$overdueCount == null : this$overdueCount.equals(other$overdueCount)) {
               Object this$orders = this.getOrders();
               Object other$orders = other.getOrders();
               return this$orders == null ? other$orders == null : this$orders.equals(other$orders);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessKanBanOverdueOverDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $overdueCount = this.getOverdueCount();
      result = result * 59 + ($overdueCount == null ? 43 : $overdueCount.hashCode());
      Object $orders = this.getOrders();
      return result * 59 + ($orders == null ? 43 : $orders.hashCode());
   }

   public static class ProcessKanBanOverdueOverDTOBuilder {
      private Integer overdueCount;
      private List<OverdueOverInfoDTO> orders;

      ProcessKanBanOverdueOverDTOBuilder() {
      }

      public ProcessKanBanOverdueOverDTO.ProcessKanBanOverdueOverDTOBuilder overdueCount(final Integer overdueCount) {
         this.overdueCount = overdueCount;
         return this;
      }

      public ProcessKanBanOverdueOverDTO.ProcessKanBanOverdueOverDTOBuilder orders(final List<OverdueOverInfoDTO> orders) {
         this.orders = orders;
         return this;
      }

      public ProcessKanBanOverdueOverDTO build() {
         return new ProcessKanBanOverdueOverDTO(this.overdueCount, this.orders);
      }

      @Override
      public String toString() {
         return "ProcessKanBanOverdueOverDTO.ProcessKanBanOverdueOverDTOBuilder(overdueCount=" + this.overdueCount + ", orders=" + this.orders + ")";
      }
   }
}
