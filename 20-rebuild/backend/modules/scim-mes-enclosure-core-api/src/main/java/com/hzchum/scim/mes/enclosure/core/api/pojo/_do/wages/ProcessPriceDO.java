package com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.IdAndNameDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProcessPriceDO", description = "")
public class ProcessPriceDO {
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

   public static ProcessPriceDO.ProcessPriceDOBuilder builder() {
      return new ProcessPriceDO.ProcessPriceDOBuilder();
   }

   public ProcessPriceDO(final IdAndNameDO process, final Integer taskTypeEnum, final BigDecimal mete, final BigDecimal price) {
      this.process = process;
      this.taskTypeEnum = taskTypeEnum;
      this.mete = mete;
      this.price = price;
   }

   public ProcessPriceDO() {
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
   public ProcessPriceDO setProcess(final IdAndNameDO process) {
      this.process = process;
      return this;
   }

   @JsonProperty("taskTypeEnum")
   public ProcessPriceDO setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @JsonProperty("mete")
   public ProcessPriceDO setMete(final BigDecimal mete) {
      this.mete = mete;
      return this;
   }

   @JsonProperty("price")
   public ProcessPriceDO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessPriceDO(process="
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

      if (!(o instanceof ProcessPriceDO)) {
         return false;
      }

      ProcessPriceDO other = (ProcessPriceDO)o;
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
      return other instanceof ProcessPriceDO;
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

   public static class ProcessPriceDOBuilder {
      private IdAndNameDO process;
      private Integer taskTypeEnum;
      private BigDecimal mete;
      private BigDecimal price;

      ProcessPriceDOBuilder() {
      }

      @JsonProperty("process")
      public ProcessPriceDO.ProcessPriceDOBuilder process(final IdAndNameDO process) {
         this.process = process;
         return this;
      }

      @JsonProperty("taskTypeEnum")
      public ProcessPriceDO.ProcessPriceDOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      @JsonProperty("mete")
      public ProcessPriceDO.ProcessPriceDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("price")
      public ProcessPriceDO.ProcessPriceDOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public ProcessPriceDO build() {
         return new ProcessPriceDO(this.process, this.taskTypeEnum, this.mete, this.price);
      }

      @Override
      public String toString() {
         return "ProcessPriceDO.ProcessPriceDOBuilder(process="
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
