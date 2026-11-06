package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingInspectCountInfoDTO", description = "质检统计 ")
public class MesBuildingInspectCountInfoDTO {
   @ApiModelProperty(name = "totalCount", notes = "总数量", value = "总数量")
   @JsonProperty("totalCount")
   @JSONField(name = "totalCount")
   private Integer totalCount;
   @ApiModelProperty(name = "inspectCountDTOS", notes = "质检统计列表", value = "质检统计列表")
   @JsonProperty("inspectCountDTOS")
   @JSONField(name = "inspectCountDTOS")
   private List<MesBuildingInspectCountDTO> inspectCountDTOS;

   public static MesBuildingInspectCountInfoDTO.MesBuildingInspectCountInfoDTOBuilder builder() {
      return new MesBuildingInspectCountInfoDTO.MesBuildingInspectCountInfoDTOBuilder();
   }

   public MesBuildingInspectCountInfoDTO() {
   }

   public MesBuildingInspectCountInfoDTO(final Integer totalCount, final List<MesBuildingInspectCountDTO> inspectCountDTOS) {
      this.totalCount = totalCount;
      this.inspectCountDTOS = inspectCountDTOS;
   }

   public Integer getTotalCount() {
      return this.totalCount;
   }

   public List<MesBuildingInspectCountDTO> getInspectCountDTOS() {
      return this.inspectCountDTOS;
   }

   @JsonProperty("totalCount")
   public MesBuildingInspectCountInfoDTO setTotalCount(final Integer totalCount) {
      this.totalCount = totalCount;
      return this;
   }

   @JsonProperty("inspectCountDTOS")
   public MesBuildingInspectCountInfoDTO setInspectCountDTOS(final List<MesBuildingInspectCountDTO> inspectCountDTOS) {
      this.inspectCountDTOS = inspectCountDTOS;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingInspectCountInfoDTO)) {
         return false;
      } else {
         MesBuildingInspectCountInfoDTO other = (MesBuildingInspectCountInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$totalCount = this.getTotalCount();
            Object other$totalCount = other.getTotalCount();
            if (this$totalCount == null ? other$totalCount == null : this$totalCount.equals(other$totalCount)) {
               Object this$inspectCountDTOS = this.getInspectCountDTOS();
               Object other$inspectCountDTOS = other.getInspectCountDTOS();
               return this$inspectCountDTOS == null ? other$inspectCountDTOS == null : this$inspectCountDTOS.equals(other$inspectCountDTOS);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingInspectCountInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalCount = this.getTotalCount();
      result = result * 59 + ($totalCount == null ? 43 : $totalCount.hashCode());
      Object $inspectCountDTOS = this.getInspectCountDTOS();
      return result * 59 + ($inspectCountDTOS == null ? 43 : $inspectCountDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingInspectCountInfoDTO(totalCount=" + this.getTotalCount() + ", inspectCountDTOS=" + this.getInspectCountDTOS() + ")";
   }

   public static class MesBuildingInspectCountInfoDTOBuilder {
      private Integer totalCount;
      private List<MesBuildingInspectCountDTO> inspectCountDTOS;

      MesBuildingInspectCountInfoDTOBuilder() {
      }

      @JsonProperty("totalCount")
      public MesBuildingInspectCountInfoDTO.MesBuildingInspectCountInfoDTOBuilder totalCount(final Integer totalCount) {
         this.totalCount = totalCount;
         return this;
      }

      @JsonProperty("inspectCountDTOS")
      public MesBuildingInspectCountInfoDTO.MesBuildingInspectCountInfoDTOBuilder inspectCountDTOS(final List<MesBuildingInspectCountDTO> inspectCountDTOS) {
         this.inspectCountDTOS = inspectCountDTOS;
         return this;
      }

      public MesBuildingInspectCountInfoDTO build() {
         return new MesBuildingInspectCountInfoDTO(this.totalCount, this.inspectCountDTOS);
      }

      @Override
      public String toString() {
         return "MesBuildingInspectCountInfoDTO.MesBuildingInspectCountInfoDTOBuilder(totalCount="
            + this.totalCount
            + ", inspectCountDTOS="
            + this.inspectCountDTOS
            + ")";
      }
   }
}
