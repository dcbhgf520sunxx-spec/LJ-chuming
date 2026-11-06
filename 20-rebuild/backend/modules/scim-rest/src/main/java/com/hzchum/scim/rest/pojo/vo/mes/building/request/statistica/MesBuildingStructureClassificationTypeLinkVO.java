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

@ApiModel(value = "MesBuildingStructureClassificationTypeLinkVO", description = "MES构件-组铆焊配置VO ")
public class MesBuildingStructureClassificationTypeLinkVO {
   @ApiModelProperty(name = "id", value = "主键id")
   @NotNull(message = "id不能为空", groups = {Update.class, Delete.class})
   private Long id;
   @ApiModelProperty(name = "artifactTypeId", value = "构件种类id")
   @NotNull(message = "构件种类id不能为空", groups = AddBatch.class)
   private Long artifactTypeId;
   @ApiModelProperty(name = "classificationId", value = "构件类型id")
   @NotNull(message = "构件类型id不能为空", groups = AddBatch.class)
   private Long classificationId;
   @ApiModelProperty(name = "minNumerical", value = "最小数值范围")
   @NotNull(message = "最小数值范围不能为空", groups = AddBatch.class)
   @Min(0L)
   private BigDecimal minNumerical;
   @ApiModelProperty(name = "maxNumerical", value = "最大数值范围")
   @NotNull(message = "最大数值范围不能为空", groups = AddBatch.class)
   @Min(0L)
   private BigDecimal maxNumerical;
   @ApiModelProperty(name = "structureProcessPriceDTOS", value = "构件类型与工序单价关联表DTO")
   @Valid
   private List<MesBuildingStructureProcessPriceVO> structureProcessPriceList;

   public static MesBuildingStructureClassificationTypeLinkVO.MesBuildingStructureClassificationTypeLinkVOBuilder builder() {
      return new MesBuildingStructureClassificationTypeLinkVO.MesBuildingStructureClassificationTypeLinkVOBuilder();
   }

   public MesBuildingStructureClassificationTypeLinkVO() {
   }

   public MesBuildingStructureClassificationTypeLinkVO(
      final Long id,
      final Long artifactTypeId,
      final Long classificationId,
      final BigDecimal minNumerical,
      final BigDecimal maxNumerical,
      final List<MesBuildingStructureProcessPriceVO> structureProcessPriceList
   ) {
      this.id = id;
      this.artifactTypeId = artifactTypeId;
      this.classificationId = classificationId;
      this.minNumerical = minNumerical;
      this.maxNumerical = maxNumerical;
      this.structureProcessPriceList = structureProcessPriceList;
   }

   public Long getId() {
      return this.id;
   }

   public Long getArtifactTypeId() {
      return this.artifactTypeId;
   }

   public Long getClassificationId() {
      return this.classificationId;
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

   public MesBuildingStructureClassificationTypeLinkVO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkVO setArtifactTypeId(final Long artifactTypeId) {
      this.artifactTypeId = artifactTypeId;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkVO setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkVO setMinNumerical(final BigDecimal minNumerical) {
      this.minNumerical = minNumerical;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkVO setMaxNumerical(final BigDecimal maxNumerical) {
      this.maxNumerical = maxNumerical;
      return this;
   }

   public MesBuildingStructureClassificationTypeLinkVO setStructureProcessPriceList(final List<MesBuildingStructureProcessPriceVO> structureProcessPriceList) {
      this.structureProcessPriceList = structureProcessPriceList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingStructureClassificationTypeLinkVO(id="
         + this.getId()
         + ", artifactTypeId="
         + this.getArtifactTypeId()
         + ", classificationId="
         + this.getClassificationId()
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

      if (!(o instanceof MesBuildingStructureClassificationTypeLinkVO)) {
         return false;
      }

      MesBuildingStructureClassificationTypeLinkVO other = (MesBuildingStructureClassificationTypeLinkVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactTypeId = this.getArtifactTypeId();
         Object other$artifactTypeId = other.getArtifactTypeId();
         if (this$artifactTypeId == null ? other$artifactTypeId == null : this$artifactTypeId.equals(other$artifactTypeId)) {
            Object this$classificationId = this.getClassificationId();
            Object other$classificationId = other.getClassificationId();
            if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingStructureClassificationTypeLinkVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactTypeId = this.getArtifactTypeId();
      result = result * 59 + ($artifactTypeId == null ? 43 : $artifactTypeId.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $minNumerical = this.getMinNumerical();
      result = result * 59 + ($minNumerical == null ? 43 : $minNumerical.hashCode());
      Object $maxNumerical = this.getMaxNumerical();
      result = result * 59 + ($maxNumerical == null ? 43 : $maxNumerical.hashCode());
      Object $structureProcessPriceList = this.getStructureProcessPriceList();
      return result * 59 + ($structureProcessPriceList == null ? 43 : $structureProcessPriceList.hashCode());
   }

   public static class MesBuildingStructureClassificationTypeLinkVOBuilder {
      private Long id;
      private Long artifactTypeId;
      private Long classificationId;
      private BigDecimal minNumerical;
      private BigDecimal maxNumerical;
      private List<MesBuildingStructureProcessPriceVO> structureProcessPriceList;

      MesBuildingStructureClassificationTypeLinkVOBuilder() {
      }

      public MesBuildingStructureClassificationTypeLinkVO.MesBuildingStructureClassificationTypeLinkVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkVO.MesBuildingStructureClassificationTypeLinkVOBuilder artifactTypeId(final Long artifactTypeId) {
         this.artifactTypeId = artifactTypeId;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkVO.MesBuildingStructureClassificationTypeLinkVOBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkVO.MesBuildingStructureClassificationTypeLinkVOBuilder minNumerical(final BigDecimal minNumerical) {
         this.minNumerical = minNumerical;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkVO.MesBuildingStructureClassificationTypeLinkVOBuilder maxNumerical(final BigDecimal maxNumerical) {
         this.maxNumerical = maxNumerical;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkVO.MesBuildingStructureClassificationTypeLinkVOBuilder structureProcessPriceList(
         final List<MesBuildingStructureProcessPriceVO> structureProcessPriceList
      ) {
         this.structureProcessPriceList = structureProcessPriceList;
         return this;
      }

      public MesBuildingStructureClassificationTypeLinkVO build() {
         return new MesBuildingStructureClassificationTypeLinkVO(
            this.id, this.artifactTypeId, this.classificationId, this.minNumerical, this.maxNumerical, this.structureProcessPriceList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingStructureClassificationTypeLinkVO.MesBuildingStructureClassificationTypeLinkVOBuilder(id="
            + this.id
            + ", artifactTypeId="
            + this.artifactTypeId
            + ", classificationId="
            + this.classificationId
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
