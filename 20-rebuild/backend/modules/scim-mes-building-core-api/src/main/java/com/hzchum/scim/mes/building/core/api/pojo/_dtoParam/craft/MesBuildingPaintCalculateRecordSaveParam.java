package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MesBuildingPaintCalculateRecordSaveParam {
   @ApiModelProperty(name = "id", value = "计算记录id", notes = "计算记录id")
   private Long id;
   @NotNull(message = "涂装工艺id未创建")
   @ApiModelProperty(name = "paintTechnologyId", value = "涂装工艺id", notes = "涂装工艺id")
   private Long paintTechnologyId;
   @NotEmpty(message = "构件类型不能为空!")
   @ApiModelProperty(name = "structureClassIdList", value = "构件种类id列表", notes = "构件种类id列表")
   private Set<Long> structureClassIdList;
   @Valid
   @NotEmpty(message = "油漆用量不能为空!")
   @ApiModelProperty(name = "paintCalculateConsumptionList", value = "油漆用量列表", notes = "油漆用量列表")
   private List<MesBuildingPaintCalculateConsumptionSaveParam> paintCalculateConsumptionList;

   public Long getId() {
      return this.id;
   }

   public Long getPaintTechnologyId() {
      return this.paintTechnologyId;
   }

   public Set<Long> getStructureClassIdList() {
      return this.structureClassIdList;
   }

   public List<MesBuildingPaintCalculateConsumptionSaveParam> getPaintCalculateConsumptionList() {
      return this.paintCalculateConsumptionList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPaintTechnologyId(final Long paintTechnologyId) {
      this.paintTechnologyId = paintTechnologyId;
   }

   public void setStructureClassIdList(final Set<Long> structureClassIdList) {
      this.structureClassIdList = structureClassIdList;
   }

   public void setPaintCalculateConsumptionList(final List<MesBuildingPaintCalculateConsumptionSaveParam> paintCalculateConsumptionList) {
      this.paintCalculateConsumptionList = paintCalculateConsumptionList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPaintCalculateRecordSaveParam)) {
         return false;
      }

      MesBuildingPaintCalculateRecordSaveParam other = (MesBuildingPaintCalculateRecordSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paintTechnologyId = this.getPaintTechnologyId();
         Object other$paintTechnologyId = other.getPaintTechnologyId();
         if (this$paintTechnologyId == null ? other$paintTechnologyId == null : this$paintTechnologyId.equals(other$paintTechnologyId)) {
            Object this$structureClassIdList = this.getStructureClassIdList();
            Object other$structureClassIdList = other.getStructureClassIdList();
            if (this$structureClassIdList == null ? other$structureClassIdList == null : this$structureClassIdList.equals(other$structureClassIdList)) {
               Object this$paintCalculateConsumptionList = this.getPaintCalculateConsumptionList();
               Object other$paintCalculateConsumptionList = other.getPaintCalculateConsumptionList();
               return this$paintCalculateConsumptionList == null
                  ? other$paintCalculateConsumptionList == null
                  : this$paintCalculateConsumptionList.equals(other$paintCalculateConsumptionList);
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
      return other instanceof MesBuildingPaintCalculateRecordSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paintTechnologyId = this.getPaintTechnologyId();
      result = result * 59 + ($paintTechnologyId == null ? 43 : $paintTechnologyId.hashCode());
      Object $structureClassIdList = this.getStructureClassIdList();
      result = result * 59 + ($structureClassIdList == null ? 43 : $structureClassIdList.hashCode());
      Object $paintCalculateConsumptionList = this.getPaintCalculateConsumptionList();
      return result * 59 + ($paintCalculateConsumptionList == null ? 43 : $paintCalculateConsumptionList.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingPaintCalculateRecordSaveParam(id="
         + this.getId()
         + ", paintTechnologyId="
         + this.getPaintTechnologyId()
         + ", structureClassIdList="
         + this.getStructureClassIdList()
         + ", paintCalculateConsumptionList="
         + this.getPaintCalculateConsumptionList()
         + ")";
   }
}
