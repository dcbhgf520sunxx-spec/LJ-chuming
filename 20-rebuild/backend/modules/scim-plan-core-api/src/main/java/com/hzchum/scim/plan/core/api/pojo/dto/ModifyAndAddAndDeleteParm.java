package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel("单体区域 修改 增加 删除 请求类")
public class ModifyAndAddAndDeleteParm {
   List<PlanMonomerSaveDTOParam> saveVO;
   List<PlanMonomerSaveDTOParam> updateMonomerVO;
   List<PlanMonomerSaveDTOParam> deleteMonomerVO;
   List<AreaSaveDTOParam> updateAreaVO;
   List<AreaSaveDTOParam> deleteAreaVO;

   public List<PlanMonomerSaveDTOParam> getSaveVO() {
      return this.saveVO;
   }

   public List<PlanMonomerSaveDTOParam> getUpdateMonomerVO() {
      return this.updateMonomerVO;
   }

   public List<PlanMonomerSaveDTOParam> getDeleteMonomerVO() {
      return this.deleteMonomerVO;
   }

   public List<AreaSaveDTOParam> getUpdateAreaVO() {
      return this.updateAreaVO;
   }

   public List<AreaSaveDTOParam> getDeleteAreaVO() {
      return this.deleteAreaVO;
   }

   public void setSaveVO(final List<PlanMonomerSaveDTOParam> saveVO) {
      this.saveVO = saveVO;
   }

   public void setUpdateMonomerVO(final List<PlanMonomerSaveDTOParam> updateMonomerVO) {
      this.updateMonomerVO = updateMonomerVO;
   }

   public void setDeleteMonomerVO(final List<PlanMonomerSaveDTOParam> deleteMonomerVO) {
      this.deleteMonomerVO = deleteMonomerVO;
   }

   public void setUpdateAreaVO(final List<AreaSaveDTOParam> updateAreaVO) {
      this.updateAreaVO = updateAreaVO;
   }

   public void setDeleteAreaVO(final List<AreaSaveDTOParam> deleteAreaVO) {
      this.deleteAreaVO = deleteAreaVO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ModifyAndAddAndDeleteParm)) {
         return false;
      }

      ModifyAndAddAndDeleteParm other = (ModifyAndAddAndDeleteParm)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$saveVO = this.getSaveVO();
      Object other$saveVO = other.getSaveVO();
      if (this$saveVO == null ? other$saveVO == null : this$saveVO.equals(other$saveVO)) {
         Object this$updateMonomerVO = this.getUpdateMonomerVO();
         Object other$updateMonomerVO = other.getUpdateMonomerVO();
         if (this$updateMonomerVO == null ? other$updateMonomerVO == null : this$updateMonomerVO.equals(other$updateMonomerVO)) {
            Object this$deleteMonomerVO = this.getDeleteMonomerVO();
            Object other$deleteMonomerVO = other.getDeleteMonomerVO();
            if (this$deleteMonomerVO == null ? other$deleteMonomerVO == null : this$deleteMonomerVO.equals(other$deleteMonomerVO)) {
               Object this$updateAreaVO = this.getUpdateAreaVO();
               Object other$updateAreaVO = other.getUpdateAreaVO();
               if (this$updateAreaVO == null ? other$updateAreaVO == null : this$updateAreaVO.equals(other$updateAreaVO)) {
                  Object this$deleteAreaVO = this.getDeleteAreaVO();
                  Object other$deleteAreaVO = other.getDeleteAreaVO();
                  return this$deleteAreaVO == null ? other$deleteAreaVO == null : this$deleteAreaVO.equals(other$deleteAreaVO);
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
      return other instanceof ModifyAndAddAndDeleteParm;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $saveVO = this.getSaveVO();
      result = result * 59 + ($saveVO == null ? 43 : $saveVO.hashCode());
      Object $updateMonomerVO = this.getUpdateMonomerVO();
      result = result * 59 + ($updateMonomerVO == null ? 43 : $updateMonomerVO.hashCode());
      Object $deleteMonomerVO = this.getDeleteMonomerVO();
      result = result * 59 + ($deleteMonomerVO == null ? 43 : $deleteMonomerVO.hashCode());
      Object $updateAreaVO = this.getUpdateAreaVO();
      result = result * 59 + ($updateAreaVO == null ? 43 : $updateAreaVO.hashCode());
      Object $deleteAreaVO = this.getDeleteAreaVO();
      return result * 59 + ($deleteAreaVO == null ? 43 : $deleteAreaVO.hashCode());
   }

   @Override
   public String toString() {
      return "ModifyAndAddAndDeleteParm(saveVO="
         + this.getSaveVO()
         + ", updateMonomerVO="
         + this.getUpdateMonomerVO()
         + ", deleteMonomerVO="
         + this.getDeleteMonomerVO()
         + ", updateAreaVO="
         + this.getUpdateAreaVO()
         + ", deleteAreaVO="
         + this.getDeleteAreaVO()
         + ")";
   }
}
