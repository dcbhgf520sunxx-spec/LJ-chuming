package com.hzchum.scim.plan.core.api.pojo.dto.stock;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.UpdateBatch;
import com.hzchum.scim.plan.core.api.enums.PreparationRangeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("备料计划配置DTO类")
public class PlanStockConfigureDTO {
   @NotNull(message = "项目id不能为空", groups = UpdateBatch.class)
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("结构备料范围")
   @EnumValidator(value = PreparationRangeEnum.class, message = "结构备料范围错误", groups = UpdateBatch.class)
   private Integer strucPreparationRangeType;
   @ApiModelProperty("围护备料范围")
   @EnumValidator(value = PreparationRangeEnum.class, message = "围护备料范围错误", groups = UpdateBatch.class)
   private Integer enclPreparationRangeType;
   @ApiModelProperty("辅材备料范围")
   @EnumValidator(value = PreparationRangeEnum.class, message = "辅材备料范围错误", groups = UpdateBatch.class)
   private Integer auxPreparationRangeType;
   @ApiModelProperty(name = "strucWithoutList", value = "结构是否无清单备料 1:无清单 0:有清单")
   private Boolean strucWithoutList;
   @ApiModelProperty(name = "enclWithoutList", value = "围护是否无清单备料 1:无清单 0:有清单")
   private Boolean enclWithoutList;
   @ApiModelProperty(name = "auxWithoutList", value = "辅材是否无清单备料 1:无清单 0:有清单")
   private Boolean auxWithoutList;

   public static PlanStockConfigureDTO.PlanStockConfigureDTOBuilder builder() {
      return new PlanStockConfigureDTO.PlanStockConfigureDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getStrucPreparationRangeType() {
      return this.strucPreparationRangeType;
   }

   public Integer getEnclPreparationRangeType() {
      return this.enclPreparationRangeType;
   }

   public Integer getAuxPreparationRangeType() {
      return this.auxPreparationRangeType;
   }

   public Boolean getStrucWithoutList() {
      return this.strucWithoutList;
   }

   public Boolean getEnclWithoutList() {
      return this.enclWithoutList;
   }

   public Boolean getAuxWithoutList() {
      return this.auxWithoutList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStrucPreparationRangeType(final Integer strucPreparationRangeType) {
      this.strucPreparationRangeType = strucPreparationRangeType;
   }

   public void setEnclPreparationRangeType(final Integer enclPreparationRangeType) {
      this.enclPreparationRangeType = enclPreparationRangeType;
   }

   public void setAuxPreparationRangeType(final Integer auxPreparationRangeType) {
      this.auxPreparationRangeType = auxPreparationRangeType;
   }

   public void setStrucWithoutList(final Boolean strucWithoutList) {
      this.strucWithoutList = strucWithoutList;
   }

   public void setEnclWithoutList(final Boolean enclWithoutList) {
      this.enclWithoutList = enclWithoutList;
   }

   public void setAuxWithoutList(final Boolean auxWithoutList) {
      this.auxWithoutList = auxWithoutList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanStockConfigureDTO)) {
         return false;
      }

      PlanStockConfigureDTO other = (PlanStockConfigureDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$strucPreparationRangeType = this.getStrucPreparationRangeType();
         Object other$strucPreparationRangeType = other.getStrucPreparationRangeType();
         if (this$strucPreparationRangeType == null
            ? other$strucPreparationRangeType == null
            : this$strucPreparationRangeType.equals(other$strucPreparationRangeType)) {
            Object this$enclPreparationRangeType = this.getEnclPreparationRangeType();
            Object other$enclPreparationRangeType = other.getEnclPreparationRangeType();
            if (this$enclPreparationRangeType == null
               ? other$enclPreparationRangeType == null
               : this$enclPreparationRangeType.equals(other$enclPreparationRangeType)) {
               Object this$auxPreparationRangeType = this.getAuxPreparationRangeType();
               Object other$auxPreparationRangeType = other.getAuxPreparationRangeType();
               if (this$auxPreparationRangeType == null
                  ? other$auxPreparationRangeType == null
                  : this$auxPreparationRangeType.equals(other$auxPreparationRangeType)) {
                  Object this$strucWithoutList = this.getStrucWithoutList();
                  Object other$strucWithoutList = other.getStrucWithoutList();
                  if (this$strucWithoutList == null ? other$strucWithoutList == null : this$strucWithoutList.equals(other$strucWithoutList)) {
                     Object this$enclWithoutList = this.getEnclWithoutList();
                     Object other$enclWithoutList = other.getEnclWithoutList();
                     if (this$enclWithoutList == null ? other$enclWithoutList == null : this$enclWithoutList.equals(other$enclWithoutList)) {
                        Object this$auxWithoutList = this.getAuxWithoutList();
                        Object other$auxWithoutList = other.getAuxWithoutList();
                        return this$auxWithoutList == null ? other$auxWithoutList == null : this$auxWithoutList.equals(other$auxWithoutList);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlanStockConfigureDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $strucPreparationRangeType = this.getStrucPreparationRangeType();
      result = result * 59 + ($strucPreparationRangeType == null ? 43 : $strucPreparationRangeType.hashCode());
      Object $enclPreparationRangeType = this.getEnclPreparationRangeType();
      result = result * 59 + ($enclPreparationRangeType == null ? 43 : $enclPreparationRangeType.hashCode());
      Object $auxPreparationRangeType = this.getAuxPreparationRangeType();
      result = result * 59 + ($auxPreparationRangeType == null ? 43 : $auxPreparationRangeType.hashCode());
      Object $strucWithoutList = this.getStrucWithoutList();
      result = result * 59 + ($strucWithoutList == null ? 43 : $strucWithoutList.hashCode());
      Object $enclWithoutList = this.getEnclWithoutList();
      result = result * 59 + ($enclWithoutList == null ? 43 : $enclWithoutList.hashCode());
      Object $auxWithoutList = this.getAuxWithoutList();
      return result * 59 + ($auxWithoutList == null ? 43 : $auxWithoutList.hashCode());
   }

   @Override
   public String toString() {
      return "PlanStockConfigureDTO(id="
         + this.getId()
         + ", strucPreparationRangeType="
         + this.getStrucPreparationRangeType()
         + ", enclPreparationRangeType="
         + this.getEnclPreparationRangeType()
         + ", auxPreparationRangeType="
         + this.getAuxPreparationRangeType()
         + ", strucWithoutList="
         + this.getStrucWithoutList()
         + ", enclWithoutList="
         + this.getEnclWithoutList()
         + ", auxWithoutList="
         + this.getAuxWithoutList()
         + ")";
   }

   public PlanStockConfigureDTO() {
   }

   public PlanStockConfigureDTO(
      final Long id,
      final Integer strucPreparationRangeType,
      final Integer enclPreparationRangeType,
      final Integer auxPreparationRangeType,
      final Boolean strucWithoutList,
      final Boolean enclWithoutList,
      final Boolean auxWithoutList
   ) {
      this.id = id;
      this.strucPreparationRangeType = strucPreparationRangeType;
      this.enclPreparationRangeType = enclPreparationRangeType;
      this.auxPreparationRangeType = auxPreparationRangeType;
      this.strucWithoutList = strucWithoutList;
      this.enclWithoutList = enclWithoutList;
      this.auxWithoutList = auxWithoutList;
   }

   public static class PlanStockConfigureDTOBuilder {
      private Long id;
      private Integer strucPreparationRangeType;
      private Integer enclPreparationRangeType;
      private Integer auxPreparationRangeType;
      private Boolean strucWithoutList;
      private Boolean enclWithoutList;
      private Boolean auxWithoutList;

      PlanStockConfigureDTOBuilder() {
      }

      public PlanStockConfigureDTO.PlanStockConfigureDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PlanStockConfigureDTO.PlanStockConfigureDTOBuilder strucPreparationRangeType(final Integer strucPreparationRangeType) {
         this.strucPreparationRangeType = strucPreparationRangeType;
         return this;
      }

      public PlanStockConfigureDTO.PlanStockConfigureDTOBuilder enclPreparationRangeType(final Integer enclPreparationRangeType) {
         this.enclPreparationRangeType = enclPreparationRangeType;
         return this;
      }

      public PlanStockConfigureDTO.PlanStockConfigureDTOBuilder auxPreparationRangeType(final Integer auxPreparationRangeType) {
         this.auxPreparationRangeType = auxPreparationRangeType;
         return this;
      }

      public PlanStockConfigureDTO.PlanStockConfigureDTOBuilder strucWithoutList(final Boolean strucWithoutList) {
         this.strucWithoutList = strucWithoutList;
         return this;
      }

      public PlanStockConfigureDTO.PlanStockConfigureDTOBuilder enclWithoutList(final Boolean enclWithoutList) {
         this.enclWithoutList = enclWithoutList;
         return this;
      }

      public PlanStockConfigureDTO.PlanStockConfigureDTOBuilder auxWithoutList(final Boolean auxWithoutList) {
         this.auxWithoutList = auxWithoutList;
         return this;
      }

      public PlanStockConfigureDTO build() {
         return new PlanStockConfigureDTO(
            this.id,
            this.strucPreparationRangeType,
            this.enclPreparationRangeType,
            this.auxPreparationRangeType,
            this.strucWithoutList,
            this.enclWithoutList,
            this.auxWithoutList
         );
      }

      @Override
      public String toString() {
         return "PlanStockConfigureDTO.PlanStockConfigureDTOBuilder(id="
            + this.id
            + ", strucPreparationRangeType="
            + this.strucPreparationRangeType
            + ", enclPreparationRangeType="
            + this.enclPreparationRangeType
            + ", auxPreparationRangeType="
            + this.auxPreparationRangeType
            + ", strucWithoutList="
            + this.strucWithoutList
            + ", enclWithoutList="
            + this.enclWithoutList
            + ", auxWithoutList="
            + this.auxWithoutList
            + ")";
      }
   }
}
