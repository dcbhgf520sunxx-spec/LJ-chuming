package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo._do.MesBoltSleeve;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("栓钉套筒DTO类")
public class MesBoltSleeveDTO extends MesBoltSleeve {
   @ApiModelProperty(name = "typeNameList", value = "类型名称", notes = "类型名称")
   private List<String> typeNameList;
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   private String processName;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBoltSleeveDTO)) {
         return false;
      } else {
         MesBoltSleeveDTO other = (MesBoltSleeveDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$typeNameList = this.getTypeNameList();
            Object other$typeNameList = other.getTypeNameList();
            if (this$typeNameList == null ? other$typeNameList == null : this$typeNameList.equals(other$typeNameList)) {
               Object this$processName = this.getProcessName();
               Object other$processName = other.getProcessName();
               return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBoltSleeveDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $typeNameList = this.getTypeNameList();
      result = result * 59 + ($typeNameList == null ? 43 : $typeNameList.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   public List<String> getTypeNameList() {
      return this.typeNameList;
   }

   public String getProcessName() {
      return this.processName;
   }

   public void setTypeNameList(final List<String> typeNameList) {
      this.typeNameList = typeNameList;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @Override
   public String toString() {
      return "MesBoltSleeveDTO(super=" + super.toString() + ", typeNameList=" + this.getTypeNameList() + ", processName=" + this.getProcessName() + ")";
   }
}
