package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import io.swagger.annotations.ApiModelProperty;

public class WmsOutboundRemindDTO {
   private Long id;
   @ApiModelProperty(name = "content", value = "内容", notes = "内容")
   private String content;
   @ApiModelProperty(name = "project", value = "出库项目", notes = "出库项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "receipt", value = "出库单", notes = "出库单")
   private BriefIdAndSNDTO receipt;

   public static WmsOutboundRemindDTO.WmsOutboundRemindDTOBuilder builder() {
      return new WmsOutboundRemindDTO.WmsOutboundRemindDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getContent() {
      return this.content;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BriefIdAndSNDTO getReceipt() {
      return this.receipt;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setContent(final String content) {
      this.content = content;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setReceipt(final BriefIdAndSNDTO receipt) {
      this.receipt = receipt;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsOutboundRemindDTO)) {
         return false;
      }

      WmsOutboundRemindDTO other = (WmsOutboundRemindDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$content = this.getContent();
         Object other$content = other.getContent();
         if (this$content == null ? other$content == null : this$content.equals(other$content)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$receipt = this.getReceipt();
               Object other$receipt = other.getReceipt();
               return this$receipt == null ? other$receipt == null : this$receipt.equals(other$receipt);
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
      return other instanceof WmsOutboundRemindDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $content = this.getContent();
      result = result * 59 + ($content == null ? 43 : $content.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $receipt = this.getReceipt();
      return result * 59 + ($receipt == null ? 43 : $receipt.hashCode());
   }

   @Override
   public String toString() {
      return "WmsOutboundRemindDTO(id="
         + this.getId()
         + ", content="
         + this.getContent()
         + ", project="
         + this.getProject()
         + ", receipt="
         + this.getReceipt()
         + ")";
   }

   public WmsOutboundRemindDTO(final Long id, final String content, final ProjectInfo project, final BriefIdAndSNDTO receipt) {
      this.id = id;
      this.content = content;
      this.project = project;
      this.receipt = receipt;
   }

   public WmsOutboundRemindDTO() {
   }

   public static class WmsOutboundRemindDTOBuilder {
      private Long id;
      private String content;
      private ProjectInfo project;
      private BriefIdAndSNDTO receipt;

      WmsOutboundRemindDTOBuilder() {
      }

      public WmsOutboundRemindDTO.WmsOutboundRemindDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsOutboundRemindDTO.WmsOutboundRemindDTOBuilder content(final String content) {
         this.content = content;
         return this;
      }

      public WmsOutboundRemindDTO.WmsOutboundRemindDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public WmsOutboundRemindDTO.WmsOutboundRemindDTOBuilder receipt(final BriefIdAndSNDTO receipt) {
         this.receipt = receipt;
         return this;
      }

      public WmsOutboundRemindDTO build() {
         return new WmsOutboundRemindDTO(this.id, this.content, this.project, this.receipt);
      }

      @Override
      public String toString() {
         return "WmsOutboundRemindDTO.WmsOutboundRemindDTOBuilder(id="
            + this.id
            + ", content="
            + this.content
            + ", project="
            + this.project
            + ", receipt="
            + this.receipt
            + ")";
      }
   }
}
