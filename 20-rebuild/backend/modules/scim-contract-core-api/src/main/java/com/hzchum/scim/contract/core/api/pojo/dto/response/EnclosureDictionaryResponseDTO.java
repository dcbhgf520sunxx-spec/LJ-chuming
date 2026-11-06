package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

public class EnclosureDictionaryResponseDTO {
   private String name;
   private String remark;
   private List<String> labels;
   @JsonInclude(Include.NON_NULL)
   private List<EnclosureDictionaryDetailDTO> plateTypeList;

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<String> getLabels() {
      return this.labels;
   }

   public List<EnclosureDictionaryDetailDTO> getPlateTypeList() {
      return this.plateTypeList;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setLabels(final List<String> labels) {
      this.labels = labels;
   }

   public void setPlateTypeList(final List<EnclosureDictionaryDetailDTO> plateTypeList) {
      this.plateTypeList = plateTypeList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureDictionaryResponseDTO)) {
         return false;
      }

      EnclosureDictionaryResponseDTO other = (EnclosureDictionaryResponseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$remark = this.getRemark();
         Object other$remark = other.getRemark();
         if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
            Object this$labels = this.getLabels();
            Object other$labels = other.getLabels();
            if (this$labels == null ? other$labels == null : this$labels.equals(other$labels)) {
               Object this$plateTypeList = this.getPlateTypeList();
               Object other$plateTypeList = other.getPlateTypeList();
               return this$plateTypeList == null ? other$plateTypeList == null : this$plateTypeList.equals(other$plateTypeList);
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
      return other instanceof EnclosureDictionaryResponseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $labels = this.getLabels();
      result = result * 59 + ($labels == null ? 43 : $labels.hashCode());
      Object $plateTypeList = this.getPlateTypeList();
      return result * 59 + ($plateTypeList == null ? 43 : $plateTypeList.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureDictionaryResponseDTO(name="
         + this.getName()
         + ", remark="
         + this.getRemark()
         + ", labels="
         + this.getLabels()
         + ", plateTypeList="
         + this.getPlateTypeList()
         + ")";
   }
}
