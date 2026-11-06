package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProcessPriceDTO", description = "")
public class ProcessPriceDTO {
   @ApiModelProperty(name = "process", notes = "工序", value = "工序")
   @JsonProperty("process")
   @JSONField(name = "process")
   private IdAndNameDO process;
   @ApiModelProperty(name = "taskTypeEnum", notes = "任务类型", value = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;
   @ApiModelProperty(name = "mete", notes = "产量", value = "产量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "price", notes = "价格", value = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public static ProcessPriceDTO.ProcessPriceDTOBuilder builder() {
      return new ProcessPriceDTO.ProcessPriceDTOBuilder();
   }

   public ProcessPriceDTO(final IdAndNameDO process, final Integer taskTypeEnum, final BigDecimal mete, final BigDecimal price) {
      this.process = process;
      this.taskTypeEnum = taskTypeEnum;
      this.mete = mete;
      this.price = price;
   }

   public ProcessPriceDTO() {
   }

   public IdAndNameDO getProcess() {
      return this.process;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("process")
   public ProcessPriceDTO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProcessPriceDTO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("mete")
   public ProcessPriceDTO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("price")
   public ProcessPriceDTO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessPriceDTO(process="
         + this.getProcess()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", mete="
         + this.getMete()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessPriceDTO)) {
         return false;
      }

      ProcessPriceDTO other = (ProcessPriceDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskTypeEnum = this.getTaskTypeEnum();
      Object other$taskTypeEnum = other.getTaskTypeEnum();
      if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
         Object this$process = this.getProcess();
         Object other$process = other.getProcess();
         if (this$process == null ? other$process == null : this$process.equals(other$process)) {
            Object this$mete = this.getMete();
            Object other$mete = other.getMete();
            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
               Object this$price = this.getPrice();
               Object other$price = other.getPrice();
               return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof ProcessPriceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class ProcessPriceDTOBuilder {
      private IdAndNameDO process;
      private Integer taskTypeEnum;
      private BigDecimal mete;
      private BigDecimal price;

      ProcessPriceDTOBuilder() {
      }

      @JsonProperty("process")
      public ProcessPriceDTO.ProcessPriceDTOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProcessPriceDTO.ProcessPriceDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("mete")
      public ProcessPriceDTO.ProcessPriceDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("price")
      public ProcessPriceDTO.ProcessPriceDTOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ProcessPriceDTO build() {
         return new ProcessPriceDTO(this.process, this.taskTypeEnum, this.mete, this.price);
      }

      @Override
      public String toString() {
         return "ProcessPriceDTO.ProcessPriceDTOBuilder(process="
            + this.process
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", mete="
            + this.mete
            + ", price="
            + this.price
            + ")";
      }
   }
}
