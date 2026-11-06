package com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica;

import com.hzchum.pangu.common.valid.AddBatch;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.WageQuotaTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;

@ApiModel(value = "MesBuildingStructureProcessPriceDTO", description = "组铆焊单价关联表VO")
public class MesBuildingStructureProcessPriceVO {
   @ApiModelProperty(name = "processLinkId", value = "工序关联id", notes = "工序关联id")
   private Long processLinkId;
   @ApiModelProperty(name = "processLinkId", value = "工序id", notes = "工序id")
   private Long processId;
   @ApiModelProperty(name = "wageQuotaType", value = "计价方式", notes = "计价方式 [1 重量, 2 长度]")
   @EnumValidator(value = WageQuotaTypeEnum.class, message = "计价方式类型错误", groups = AddBatch.class)
   private Integer wageQuotaType;
   @ApiModelProperty(name = "price", value = "价格/元", notes = "价格/元")
   @Min(0L)
   private BigDecimal price;

   public static MesBuildingStructureProcessPriceVO.MesBuildingStructureProcessPriceVOBuilder builder() {
      return new MesBuildingStructureProcessPriceVO.MesBuildingStructureProcessPriceVOBuilder();
   }

   public MesBuildingStructureProcessPriceVO() {
   }

   public MesBuildingStructureProcessPriceVO(final Long processLinkId, final Long processId, final Integer wageQuotaType, final BigDecimal price) {
      this.processLinkId = processLinkId;
      this.processId = processId;
      this.wageQuotaType = wageQuotaType;
      this.price = price;
   }

   public Long getProcessLinkId() {
      return this.processLinkId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public MesBuildingStructureProcessPriceVO setProcessLinkId(final Long processLinkId) {
      this.processLinkId = processLinkId;
      return this;
   }

   public MesBuildingStructureProcessPriceVO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBuildingStructureProcessPriceVO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   public MesBuildingStructureProcessPriceVO setPrice(final BigDecimal price) {
      this.price = price;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingStructureProcessPriceVO(processLinkId="
         + this.getProcessLinkId()
         + ", processId="
         + this.getProcessId()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", price="
         + this.getPrice()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingStructureProcessPriceVO)) {
         return false;
      }

      MesBuildingStructureProcessPriceVO other = (MesBuildingStructureProcessPriceVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processLinkId = this.getProcessLinkId();
      Object other$processLinkId = other.getProcessLinkId();
      if (this$processLinkId == null ? other$processLinkId == null : this$processLinkId.equals(other$processLinkId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$wageQuotaType = this.getWageQuotaType();
            Object other$wageQuotaType = other.getWageQuotaType();
            if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
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
      return other instanceof MesBuildingStructureProcessPriceVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processLinkId = this.getProcessLinkId();
      result = result * 59 + ($processLinkId == null ? 43 : $processLinkId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   public static class MesBuildingStructureProcessPriceVOBuilder {
      private Long processLinkId;
      private Long processId;
      private Integer wageQuotaType;
      private BigDecimal price;

      MesBuildingStructureProcessPriceVOBuilder() {
      }

      public MesBuildingStructureProcessPriceVO.MesBuildingStructureProcessPriceVOBuilder processLinkId(final Long processLinkId) {
         this.processLinkId = processLinkId;
         return this;
      }

      public MesBuildingStructureProcessPriceVO.MesBuildingStructureProcessPriceVOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingStructureProcessPriceVO.MesBuildingStructureProcessPriceVOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public MesBuildingStructureProcessPriceVO.MesBuildingStructureProcessPriceVOBuilder price(final BigDecimal price) {
         this.price = price;
         return this;
      }

      public MesBuildingStructureProcessPriceVO build() {
         return new MesBuildingStructureProcessPriceVO(this.processLinkId, this.processId, this.wageQuotaType, this.price);
      }

      @Override
      public String toString() {
         return "MesBuildingStructureProcessPriceVO.MesBuildingStructureProcessPriceVOBuilder(processLinkId="
            + this.processLinkId
            + ", processId="
            + this.processId
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", price="
            + this.price
            + ")";
      }
   }
}
