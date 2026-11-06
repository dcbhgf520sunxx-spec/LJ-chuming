package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import com.hzchum.scim.system.core.api.pojo.dto.UserSimpleResponseVO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Workshop;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "WorkshopDTO对象", description = "车间返回类-配置 ")
public class WorkshopDTO extends Workshop implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "ifExist", value = "是否存在仓库位置", notes = "是否存在仓库位置")
   private Boolean ifExist;
   @ApiModelProperty(name = "UserSimpleResponseVO", value = "仓库负责人集合", notes = "仓库负责人集合")
   private List<UserSimpleResponseVO> userSimpleResponseVO;
   @ApiModelProperty(name = "mesWorkshop", value = "关联mes车间对象集合", notes = "关联mes车间对象集合")
   private List<IdAndNameDTO> mesWorkshop;

   public Boolean getIfExist() {
      return this.ifExist;
   }

   public List<UserSimpleResponseVO> getUserSimpleResponseVO() {
      return this.userSimpleResponseVO;
   }

   public List<IdAndNameDTO> getMesWorkshop() {
      return this.mesWorkshop;
   }

   public void setIfExist(final Boolean ifExist) {
      this.ifExist = ifExist;
   }

   public void setUserSimpleResponseVO(final List<UserSimpleResponseVO> userSimpleResponseVO) {
      this.userSimpleResponseVO = userSimpleResponseVO;
   }

   public void setMesWorkshop(final List<IdAndNameDTO> mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopDTO)) {
         return false;
      }

      WorkshopDTO other = (WorkshopDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$ifExist = this.getIfExist();
      Object other$ifExist = other.getIfExist();
      if (this$ifExist == null ? other$ifExist == null : this$ifExist.equals(other$ifExist)) {
         Object this$userSimpleResponseVO = this.getUserSimpleResponseVO();
         Object other$userSimpleResponseVO = other.getUserSimpleResponseVO();
         if (this$userSimpleResponseVO == null ? other$userSimpleResponseVO == null : this$userSimpleResponseVO.equals(other$userSimpleResponseVO)) {
            Object this$mesWorkshop = this.getMesWorkshop();
            Object other$mesWorkshop = other.getMesWorkshop();
            return this$mesWorkshop == null ? other$mesWorkshop == null : this$mesWorkshop.equals(other$mesWorkshop);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WorkshopDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $ifExist = this.getIfExist();
      result = result * 59 + ($ifExist == null ? 43 : $ifExist.hashCode());
      Object $userSimpleResponseVO = this.getUserSimpleResponseVO();
      result = result * 59 + ($userSimpleResponseVO == null ? 43 : $userSimpleResponseVO.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      return result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
   }

   @Override
   public String toString() {
      return "WorkshopDTO(ifExist="
         + this.getIfExist()
         + ", userSimpleResponseVO="
         + this.getUserSimpleResponseVO()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ")";
   }
}
