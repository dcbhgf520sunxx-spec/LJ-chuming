package com.hzchum.scim.system.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Arrays;

@ApiModel(description = "工序折合完工率返回数据")
public class MesProcessConversionRateVO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("折合完工率")
   private BigDecimal conversionRate;
   @ApiModelProperty("工序ids")
   private String processIds;
   @ApiModelProperty("工序ids集合")
   private String[] processIdArray;
   @ApiModelProperty("工序类型")
   private String processType;
   @ApiModelProperty("工序类型")
   private String processTypeName;
   @ApiModelProperty("工序名称")
   private String processNames;

   public static MesProcessConversionRateVO.MesProcessConversionRateVOBuilder builder() {
      return new MesProcessConversionRateVO.MesProcessConversionRateVOBuilder();
   }

   public MesProcessConversionRateVO() {
   }

   public MesProcessConversionRateVO(
      final Long id,
      final BigDecimal conversionRate,
      final String processIds,
      final String[] processIdArray,
      final String processType,
      final String processTypeName,
      final String processNames
   ) {
      this.id = id;
      this.conversionRate = conversionRate;
      this.processIds = processIds;
      this.processIdArray = processIdArray;
      this.processType = processType;
      this.processTypeName = processTypeName;
      this.processNames = processNames;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getConversionRate() {
      return this.conversionRate;
   }

   public String getProcessIds() {
      return this.processIds;
   }

   public String[] getProcessIdArray() {
      return this.processIdArray;
   }

   public String getProcessType() {
      return this.processType;
   }

   public String getProcessTypeName() {
      return this.processTypeName;
   }

   public String getProcessNames() {
      return this.processNames;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setConversionRate(final BigDecimal conversionRate) {
      this.conversionRate = conversionRate;
   }

   public void setProcessIds(final String processIds) {
      this.processIds = processIds;
   }

   public void setProcessIdArray(final String[] processIdArray) {
      this.processIdArray = processIdArray;
   }

   public void setProcessType(final String processType) {
      this.processType = processType;
   }

   public void setProcessTypeName(final String processTypeName) {
      this.processTypeName = processTypeName;
   }

   public void setProcessNames(final String processNames) {
      this.processNames = processNames;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProcessConversionRateVO)) {
         return false;
      }

      MesProcessConversionRateVO other = (MesProcessConversionRateVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$conversionRate = this.getConversionRate();
         Object other$conversionRate = other.getConversionRate();
         if (this$conversionRate == null ? other$conversionRate == null : this$conversionRate.equals(other$conversionRate)) {
            Object this$processIds = this.getProcessIds();
            Object other$processIds = other.getProcessIds();
            if (this$processIds == null ? other$processIds == null : this$processIds.equals(other$processIds)) {
               if (!Arrays.deepEquals(this.getProcessIdArray(), other.getProcessIdArray())) {
                  return false;
               }

               Object this$processType = this.getProcessType();
               Object other$processType = other.getProcessType();
               if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
                  Object this$processTypeName = this.getProcessTypeName();
                  Object other$processTypeName = other.getProcessTypeName();
                  if (this$processTypeName == null ? other$processTypeName == null : this$processTypeName.equals(other$processTypeName)) {
                     Object this$processNames = this.getProcessNames();
                     Object other$processNames = other.getProcessNames();
                     return this$processNames == null ? other$processNames == null : this$processNames.equals(other$processNames);
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
      return other instanceof MesProcessConversionRateVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $conversionRate = this.getConversionRate();
      result = result * 59 + ($conversionRate == null ? 43 : $conversionRate.hashCode());
      Object $processIds = this.getProcessIds();
      result = result * 59 + ($processIds == null ? 43 : $processIds.hashCode());
      result = result * 59 + Arrays.deepHashCode(this.getProcessIdArray());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $processTypeName = this.getProcessTypeName();
      result = result * 59 + ($processTypeName == null ? 43 : $processTypeName.hashCode());
      Object $processNames = this.getProcessNames();
      return result * 59 + ($processNames == null ? 43 : $processNames.hashCode());
   }

   @Override
   public String toString() {
      return "MesProcessConversionRateVO(id="
         + this.getId()
         + ", conversionRate="
         + this.getConversionRate()
         + ", processIds="
         + this.getProcessIds()
         + ", processIdArray="
         + Arrays.deepToString(this.getProcessIdArray())
         + ", processType="
         + this.getProcessType()
         + ", processTypeName="
         + this.getProcessTypeName()
         + ", processNames="
         + this.getProcessNames()
         + ")";
   }

   public static class MesProcessConversionRateVOBuilder {
      private Long id;
      private BigDecimal conversionRate;
      private String processIds;
      private String[] processIdArray;
      private String processType;
      private String processTypeName;
      private String processNames;

      MesProcessConversionRateVOBuilder() {
      }

      public MesProcessConversionRateVO.MesProcessConversionRateVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesProcessConversionRateVO.MesProcessConversionRateVOBuilder conversionRate(final BigDecimal conversionRate) {
         this.conversionRate = conversionRate;
         return this;
      }

      public MesProcessConversionRateVO.MesProcessConversionRateVOBuilder processIds(final String processIds) {
         this.processIds = processIds;
         return this;
      }

      public MesProcessConversionRateVO.MesProcessConversionRateVOBuilder processIdArray(final String[] processIdArray) {
         this.processIdArray = processIdArray;
         return this;
      }

      public MesProcessConversionRateVO.MesProcessConversionRateVOBuilder processType(final String processType) {
         this.processType = processType;
         return this;
      }

      public MesProcessConversionRateVO.MesProcessConversionRateVOBuilder processTypeName(final String processTypeName) {
         this.processTypeName = processTypeName;
         return this;
      }

      public MesProcessConversionRateVO.MesProcessConversionRateVOBuilder processNames(final String processNames) {
         this.processNames = processNames;
         return this;
      }

      public MesProcessConversionRateVO build() {
         return new MesProcessConversionRateVO(
            this.id, this.conversionRate, this.processIds, this.processIdArray, this.processType, this.processTypeName, this.processNames
         );
      }

      @Override
      public String toString() {
         return "MesProcessConversionRateVO.MesProcessConversionRateVOBuilder(id="
            + this.id
            + ", conversionRate="
            + this.conversionRate
            + ", processIds="
            + this.processIds
            + ", processIdArray="
            + Arrays.deepToString(this.processIdArray)
            + ", processType="
            + this.processType
            + ", processTypeName="
            + this.processTypeName
            + ", processNames="
            + this.processNames
            + ")";
      }
   }
}
