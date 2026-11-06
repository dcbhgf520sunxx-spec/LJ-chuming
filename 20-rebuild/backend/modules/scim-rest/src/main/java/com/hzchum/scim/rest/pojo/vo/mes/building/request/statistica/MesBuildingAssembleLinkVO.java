package com.hzchum.scim.rest.pojo.vo.mes.building.request.statistica;

import com.hzchum.pangu.common.valid.AddBatch;
import com.hzchum.pangu.common.valid.Delete;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingAssembleLinkVO", description = "MES组立-组铆焊配置VO ")
public class MesBuildingAssembleLinkVO {
   @ApiModelProperty(name = "id", value = "主键id")
   @NotNull(message = "id不能为空", groups = {Update.class, Delete.class})
   private Long id;
   @ApiModelProperty(name = "classificationId", value = "构件类型id")
   @NotNull(message = "部件类型id不能为空", groups = AddBatch.class)
   private Long sysAssembleId;
   @ApiModelProperty(name = "minNumerical", value = "最小数值范围")
   @NotNull(message = "最小数值范围不能为空", groups = AddBatch.class)
   @Min(0L)
   private BigDecimal minNumerical;
   @ApiModelProperty(name = "maxNumerical", value = "最大数值范围")
   @NotNull(message = "最大数值范围不能为空", groups = AddBatch.class)
   @Min(0L)
   private BigDecimal maxNumerical;
   @ApiModelProperty(name = "structureProcessPriceList", value = "组铆焊单价关联表VO")
   @Valid
   private List<MesBuildingStructureProcessPriceVO> structureProcessPriceList;

   public static MesBuildingAssembleLinkVO.MesBuildingAssembleLinkVOBuilder builder() {
      return new MesBuildingAssembleLinkVO.MesBuildingAssembleLinkVOBuilder();
   }

   public MesBuildingAssembleLinkVO() {
   }

   public MesBuildingAssembleLinkVO(
      final Long id,
      final Long sysAssembleId,
      final BigDecimal minNumerical,
      final BigDecimal maxNumerical,
      final List<MesBuildingStructureProcessPriceVO> structureProcessPriceList
   ) {
      this.id = id;
      this.sysAssembleId = sysAssembleId;
      this.minNumerical = minNumerical;
      this.maxNumerical = maxNumerical;
      this.structureProcessPriceList = structureProcessPriceList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSysAssembleId() {
      return this.sysAssembleId;
   }

   public BigDecimal getMinNumerical() {
      return this.minNumerical;
   }

   public BigDecimal getMaxNumerical() {
      return this.maxNumerical;
   }

   public List<MesBuildingStructureProcessPriceVO> getStructureProcessPriceList() {
      return this.structureProcessPriceList;
   }

   public MesBuildingAssembleLinkVO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingAssembleLinkVO setSysAssembleId(final Long sysAssembleId) {
      this.sysAssembleId = sysAssembleId;
      return this;
   }

   public MesBuildingAssembleLinkVO setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
      return this;
   }

   public MesBuildingAssembleLinkVO setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
      return this;
   }

   public MesBuildingAssembleLinkVO setStructureProcessPriceList(final List<MesBuildingStructureProcessPriceVO> structureProcessPriceList) {
      this.structureProcessPriceList = structureProcessPriceList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleLinkVO(id="
         + this.getId()
         + ", sysAssembleId="
         + this.getSysAssembleId()
         + ", minNumerical="
         + this.getMinNumerical()
         + ", maxNumerical="
         + this.getMaxNumerical()
         + ", structureProcessPriceList="
         + this.getStructureProcessPriceList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleLinkVO)) {
         return false;
      }

      MesBuildingAssembleLinkVO other = (MesBuildingAssembleLinkVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sysAssembleId = this.getSysAssembleId();
         Object other$sysAssembleId = other.getSysAssembleId();
         if (this$sysAssembleId == null ? other$sysAssembleId == null : this$sysAssembleId.equals(other$sysAssembleId)) {
            Object this$minNumerical = this.getMinNumerical();
            Object other$minNumerical = other.getMinNumerical();
            if (this$minNumerical == null ? other$minNumerical == null : this$minNumerical.equals(other$minNumerical)) {
               Object this$maxNumerical = this.getMaxNumerical();
               Object other$maxNumerical = other.getMaxNumerical();
               if (this$maxNumerical == null ? other$maxNumerical == null : this$maxNumerical.equals(other$maxNumerical)) {
                  Object this$structureProcessPriceList = this.getStructureProcessPriceList();
                  Object other$structureProcessPriceList = other.getStructureProcessPriceList();
                  return this$structureProcessPriceList == null
                     ? other$structureProcessPriceList == null
                     : this$structureProcessPriceList.equals(other$structureProcessPriceList);
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
      return other instanceof MesBuildingAssembleLinkVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sysAssembleId = this.getSysAssembleId();
      result = result * 59 + ($sysAssembleId == null ? 43 : $sysAssembleId.hashCode());
      Object $minNumerical = this.getMinNumerical();
      result = result * 59 + ($minNumerical == null ? 43 : $minNumerical.hashCode());
      Object $maxNumerical = this.getMaxNumerical();
      result = result * 59 + ($maxNumerical == null ? 43 : $maxNumerical.hashCode());
      Object $structureProcessPriceList = this.getStructureProcessPriceList();
      return result * 59 + ($structureProcessPriceList == null ? 43 : $structureProcessPriceList.hashCode());
   }

   public static class MesBuildingAssembleLinkVOBuilder {
      private Long id;
      private Long sysAssembleId;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;
      private List<MesBuildingStructureProcessPriceVO> structureProcessPriceList;

      MesBuildingAssembleLinkVOBuilder() {
      }

      public MesBuildingAssembleLinkVO.MesBuildingAssembleLinkVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingAssembleLinkVO.MesBuildingAssembleLinkVOBuilder sysAssembleId(final Long sysAssembleId) {
         this.sysAssembleId = sysAssembleId;
         return this;
      }

      public MesBuildingAssembleLinkVO.MesBuildingAssembleLinkVOBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      public MesBuildingAssembleLinkVO.MesBuildingAssembleLinkVOBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      public MesBuildingAssembleLinkVO.MesBuildingAssembleLinkVOBuilder structureProcessPriceList(
         final List<MesBuildingStructureProcessPriceVO> structureProcessPriceList
      ) {
         this.structureProcessPriceList = structureProcessPriceList;
         return this;
      }

      public MesBuildingAssembleLinkVO build() {
         return new MesBuildingAssembleLinkVO(this.id, this.sysAssembleId, this.minNumerical, this.maxNumerical, this.structureProcessPriceList);
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleLinkVO.MesBuildingAssembleLinkVOBuilder(id="
            + this.id
            + ", sysAssembleId="
            + this.sysAssembleId
            + ", minNumerical="
            + this.minNumerical
            + ", maxNumerical="
            + this.maxNumerical
            + ", structureProcessPriceList="
            + this.structureProcessPriceList
            + ")";
      }
   }
}
