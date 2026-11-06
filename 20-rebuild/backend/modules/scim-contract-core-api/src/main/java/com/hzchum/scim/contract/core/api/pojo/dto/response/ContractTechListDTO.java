package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.contract.core.api.pojo.dto.StructureTypeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.PressureBearingPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProfiledPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.SandwichBoardDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.TrussFloorPlateDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("技术交底列表")
public class ContractTechListDTO {
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty("结构列表")
   private List<StructureTypeDTO> structureList;
   @ApiModelProperty("压型彩板列表")
   @JsonInclude(Include.NON_NULL)
   private List<ProfiledPlateDTOParam> profiledPlateList;
   @ApiModelProperty("桁架楼承板列表")
   @JsonInclude(Include.NON_NULL)
   private List<TrussFloorPlateDTOParam> trussFloorPlateList;
   @ApiModelProperty("压型楼承板列表")
   @JsonInclude(Include.NON_NULL)
   private List<PressureBearingPlateDTOParam> pressureBearingPlateList;
   @ApiModelProperty("夹芯板列表")
   @JsonInclude(Include.NON_NULL)
   private List<SandwichBoardDTOParam> sandwichBoardList;

   public List<StructureTypeDTO> getStructureList() {
      return this.structureList;
   }

   public List<ProfiledPlateDTOParam> getProfiledPlateList() {
      return this.profiledPlateList;
   }

   public List<TrussFloorPlateDTOParam> getTrussFloorPlateList() {
      return this.trussFloorPlateList;
   }

   public List<PressureBearingPlateDTOParam> getPressureBearingPlateList() {
      return this.pressureBearingPlateList;
   }

   public List<SandwichBoardDTOParam> getSandwichBoardList() {
      return this.sandwichBoardList;
   }

   public void setStructureList(final List<StructureTypeDTO> structureList) {
      this.structureList = structureList;
   }

   public void setProfiledPlateList(final List<ProfiledPlateDTOParam> profiledPlateList) {
      this.profiledPlateList = profiledPlateList;
   }

   public void setTrussFloorPlateList(final List<TrussFloorPlateDTOParam> trussFloorPlateList) {
      this.trussFloorPlateList = trussFloorPlateList;
   }

   public void setPressureBearingPlateList(final List<PressureBearingPlateDTOParam> pressureBearingPlateList) {
      this.pressureBearingPlateList = pressureBearingPlateList;
   }

   public void setSandwichBoardList(final List<SandwichBoardDTOParam> sandwichBoardList) {
      this.sandwichBoardList = sandwichBoardList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractTechListDTO)) {
         return false;
      }

      ContractTechListDTO other = (ContractTechListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureList = this.getStructureList();
      Object other$structureList = other.getStructureList();
      if (this$structureList == null ? other$structureList == null : this$structureList.equals(other$structureList)) {
         Object this$profiledPlateList = this.getProfiledPlateList();
         Object other$profiledPlateList = other.getProfiledPlateList();
         if (this$profiledPlateList == null ? other$profiledPlateList == null : this$profiledPlateList.equals(other$profiledPlateList)) {
            Object this$trussFloorPlateList = this.getTrussFloorPlateList();
            Object other$trussFloorPlateList = other.getTrussFloorPlateList();
            if (this$trussFloorPlateList == null ? other$trussFloorPlateList == null : this$trussFloorPlateList.equals(other$trussFloorPlateList)) {
               Object this$pressureBearingPlateList = this.getPressureBearingPlateList();
               Object other$pressureBearingPlateList = other.getPressureBearingPlateList();
               if (this$pressureBearingPlateList == null
                  ? other$pressureBearingPlateList == null
                  : this$pressureBearingPlateList.equals(other$pressureBearingPlateList)) {
                  Object this$sandwichBoardList = this.getSandwichBoardList();
                  Object other$sandwichBoardList = other.getSandwichBoardList();
                  return this$sandwichBoardList == null ? other$sandwichBoardList == null : this$sandwichBoardList.equals(other$sandwichBoardList);
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
      return other instanceof ContractTechListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureList = this.getStructureList();
      result = result * 59 + ($structureList == null ? 43 : $structureList.hashCode());
      Object $profiledPlateList = this.getProfiledPlateList();
      result = result * 59 + ($profiledPlateList == null ? 43 : $profiledPlateList.hashCode());
      Object $trussFloorPlateList = this.getTrussFloorPlateList();
      result = result * 59 + ($trussFloorPlateList == null ? 43 : $trussFloorPlateList.hashCode());
      Object $pressureBearingPlateList = this.getPressureBearingPlateList();
      result = result * 59 + ($pressureBearingPlateList == null ? 43 : $pressureBearingPlateList.hashCode());
      Object $sandwichBoardList = this.getSandwichBoardList();
      return result * 59 + ($sandwichBoardList == null ? 43 : $sandwichBoardList.hashCode());
   }

   @Override
   public String toString() {
      return "ContractTechListDTO(structureList="
         + this.getStructureList()
         + ", profiledPlateList="
         + this.getProfiledPlateList()
         + ", trussFloorPlateList="
         + this.getTrussFloorPlateList()
         + ", pressureBearingPlateList="
         + this.getPressureBearingPlateList()
         + ", sandwichBoardList="
         + this.getSandwichBoardList()
         + ")";
   }
}
