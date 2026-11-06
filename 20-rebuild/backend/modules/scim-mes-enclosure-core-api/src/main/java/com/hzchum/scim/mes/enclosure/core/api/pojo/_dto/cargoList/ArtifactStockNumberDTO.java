package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.util.FactoryDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ArtifactStockNumberDTO", description = "构件库存一物一码序号 ")
public class ArtifactStockNumberDTO {
   @ApiModelProperty(name = "number", notes = "一物一码编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "factory", notes = "工厂")
   @JsonProperty("factory")
   @JSONField(name = "factory")
   private FactoryDetailDO factory;

   public static ArtifactStockNumberDTO.ArtifactStockNumberDTOBuilder builder() {
      return new ArtifactStockNumberDTO.ArtifactStockNumberDTOBuilder();
   }

   public ArtifactStockNumberDTO() {
   }

   public ArtifactStockNumberDTO(final Integer number, final FactoryDetailDO factory) {
      this.number = number;
      this.factory = factory;
   }

   public Integer getNumber() {
      return this.number;
   }

   public FactoryDetailDO getFactory() {
      return this.factory;
   }

   @JsonProperty("number")
   public ArtifactStockNumberDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("factory")
   public ArtifactStockNumberDTO setFactory(final FactoryDetailDO factory) {
      this.factory = factory;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactStockNumberDTO(number=" + this.getNumber() + ", factory=" + this.getFactory() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactStockNumberDTO)) {
         return false;
      } else {
         ArtifactStockNumberDTO other = (ArtifactStockNumberDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$factory = this.getFactory();
               Object other$factory = other.getFactory();
               return this$factory == null ? other$factory == null : this$factory.equals(other$factory);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactStockNumberDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $factory = this.getFactory();
      return result * 59 + ($factory == null ? 43 : $factory.hashCode());
   }

   public static class ArtifactStockNumberDTOBuilder {
      private Integer number;
      private FactoryDetailDO factory;

      ArtifactStockNumberDTOBuilder() {
      }

      @JsonProperty("number")
      public ArtifactStockNumberDTO.ArtifactStockNumberDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("factory")
      public ArtifactStockNumberDTO.ArtifactStockNumberDTOBuilder factory(final FactoryDetailDO factory) {
         this.factory = factory;
         return this;
      }

      public ArtifactStockNumberDTO build() {
         return new ArtifactStockNumberDTO(this.number, this.factory);
      }

      @Override
      public String toString() {
         return "ArtifactStockNumberDTO.ArtifactStockNumberDTOBuilder(number=" + this.number + ", factory=" + this.factory + ")";
      }
   }
}
