package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo._doModel.wmsUse.WmsSurplus;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class WmsSurplusDTO extends WmsSurplus {
   private List<ProjectInfoDTO> projects;
   @ApiModelProperty(name = "detailDTOList", value = "盘盈详情")
   @JsonInclude(Include.NON_NULL)
   List<WmsSurplusDetailDTO> detailDTOList;

   public List<ProjectInfoDTO> getProjects() {
      return this.projects;
   }

   public List<WmsSurplusDetailDTO> getDetailDTOList() {
      return this.detailDTOList;
   }

   public void setProjects(final List<ProjectInfoDTO> projects) {
      this.projects = projects;
   }

   public void setDetailDTOList(final List<WmsSurplusDetailDTO> detailDTOList) {
      this.detailDTOList = detailDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WmsSurplusDTO)) {
         return false;
      } else {
         WmsSurplusDTO other = (WmsSurplusDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projects = this.getProjects();
            Object other$projects = other.getProjects();
            if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
               Object this$detailDTOList = this.getDetailDTOList();
               Object other$detailDTOList = other.getDetailDTOList();
               return this$detailDTOList == null ? other$detailDTOList == null : this$detailDTOList.equals(other$detailDTOList);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WmsSurplusDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $detailDTOList = this.getDetailDTOList();
      return result * 59 + ($detailDTOList == null ? 43 : $detailDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "WmsSurplusDTO(projects=" + this.getProjects() + ", detailDTOList=" + this.getDetailDTOList() + ")";
   }
}
