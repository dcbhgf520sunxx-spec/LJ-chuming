package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class SysPushFlowConfigDetailDTO {
   @ApiModelProperty(name = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "status", notes = "流程状态")
   private Boolean status;
   @ApiModelProperty(name = "name", notes = "流程名称")
   private String name;
   @ApiModelProperty(name = "finalEditor", notes = "最后编辑人")
   private String finalEditor;
   @ApiModelProperty(name = "finalEditTime", notes = "最后编辑时间")
   private LocalDateTime finalEditTime;
   @ApiModelProperty(name = "relatedProcessList", notes = "流程")
   private SysPushFlowConfigLinkDTO sysPushFlowConfigLinkDTOS;

   public static SysPushFlowConfigDetailDTO.SysPushFlowConfigDetailDTOBuilder builder() {
      return new SysPushFlowConfigDetailDTO.SysPushFlowConfigDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public String getName() {
      return this.name;
   }

   public String getFinalEditor() {
      return this.finalEditor;
   }

   public LocalDateTime getFinalEditTime() {
      return this.finalEditTime;
   }

   public SysPushFlowConfigLinkDTO getSysPushFlowConfigLinkDTOS() {
      return this.sysPushFlowConfigLinkDTOS;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setFinalEditor(final String finalEditor) {
      this.finalEditor = finalEditor;
   }

   public void setFinalEditTime(final LocalDateTime finalEditTime) {
      this.finalEditTime = finalEditTime;
   }

   public void setSysPushFlowConfigLinkDTOS(final SysPushFlowConfigLinkDTO sysPushFlowConfigLinkDTOS) {
      this.sysPushFlowConfigLinkDTOS = sysPushFlowConfigLinkDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushFlowConfigDetailDTO)) {
         return false;
      }

      SysPushFlowConfigDetailDTO other = (SysPushFlowConfigDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$finalEditor = this.getFinalEditor();
               Object other$finalEditor = other.getFinalEditor();
               if (this$finalEditor == null ? other$finalEditor == null : this$finalEditor.equals(other$finalEditor)) {
                  Object this$finalEditTime = this.getFinalEditTime();
                  Object other$finalEditTime = other.getFinalEditTime();
                  if (this$finalEditTime == null ? other$finalEditTime == null : this$finalEditTime.equals(other$finalEditTime)) {
                     Object this$sysPushFlowConfigLinkDTOS = this.getSysPushFlowConfigLinkDTOS();
                     Object other$sysPushFlowConfigLinkDTOS = other.getSysPushFlowConfigLinkDTOS();
                     return this$sysPushFlowConfigLinkDTOS == null
                        ? other$sysPushFlowConfigLinkDTOS == null
                        : this$sysPushFlowConfigLinkDTOS.equals(other$sysPushFlowConfigLinkDTOS);
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
      return other instanceof SysPushFlowConfigDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $finalEditor = this.getFinalEditor();
      result = result * 59 + ($finalEditor == null ? 43 : $finalEditor.hashCode());
      Object $finalEditTime = this.getFinalEditTime();
      result = result * 59 + ($finalEditTime == null ? 43 : $finalEditTime.hashCode());
      Object $sysPushFlowConfigLinkDTOS = this.getSysPushFlowConfigLinkDTOS();
      return result * 59 + ($sysPushFlowConfigLinkDTOS == null ? 43 : $sysPushFlowConfigLinkDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushFlowConfigDetailDTO(id="
         + this.getId()
         + ", status="
         + this.getStatus()
         + ", name="
         + this.getName()
         + ", finalEditor="
         + this.getFinalEditor()
         + ", finalEditTime="
         + this.getFinalEditTime()
         + ", sysPushFlowConfigLinkDTOS="
         + this.getSysPushFlowConfigLinkDTOS()
         + ")";
   }

   public SysPushFlowConfigDetailDTO(
      final Long id,
      final Boolean status,
      final String name,
      final String finalEditor,
      final LocalDateTime finalEditTime,
      final SysPushFlowConfigLinkDTO sysPushFlowConfigLinkDTOS
   ) {
      this.id = id;
      this.status = status;
      this.name = name;
      this.finalEditor = finalEditor;
      this.finalEditTime = finalEditTime;
      this.sysPushFlowConfigLinkDTOS = sysPushFlowConfigLinkDTOS;
   }

   public SysPushFlowConfigDetailDTO() {
   }

   public static class SysPushFlowConfigDetailDTOBuilder {
      private Long id;
      private Boolean status;
      private String name;
      private String finalEditor;
      private LocalDateTime finalEditTime;
      private SysPushFlowConfigLinkDTO sysPushFlowConfigLinkDTOS;

      SysPushFlowConfigDetailDTOBuilder() {
      }

      public SysPushFlowConfigDetailDTO.SysPushFlowConfigDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushFlowConfigDetailDTO.SysPushFlowConfigDetailDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public SysPushFlowConfigDetailDTO.SysPushFlowConfigDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysPushFlowConfigDetailDTO.SysPushFlowConfigDetailDTOBuilder finalEditor(final String finalEditor) {
         this.finalEditor = finalEditor;
         return this;
      }

      public SysPushFlowConfigDetailDTO.SysPushFlowConfigDetailDTOBuilder finalEditTime(final LocalDateTime finalEditTime) {
         this.finalEditTime = finalEditTime;
         return this;
      }

      public SysPushFlowConfigDetailDTO.SysPushFlowConfigDetailDTOBuilder sysPushFlowConfigLinkDTOS(final SysPushFlowConfigLinkDTO sysPushFlowConfigLinkDTOS) {
         this.sysPushFlowConfigLinkDTOS = sysPushFlowConfigLinkDTOS;
         return this;
      }

      public SysPushFlowConfigDetailDTO build() {
         return new SysPushFlowConfigDetailDTO(this.id, this.status, this.name, this.finalEditor, this.finalEditTime, this.sysPushFlowConfigLinkDTOS);
      }

      @Override
      public String toString() {
         return "SysPushFlowConfigDetailDTO.SysPushFlowConfigDetailDTOBuilder(id="
            + this.id
            + ", status="
            + this.status
            + ", name="
            + this.name
            + ", finalEditor="
            + this.finalEditor
            + ", finalEditTime="
            + this.finalEditTime
            + ", sysPushFlowConfigLinkDTOS="
            + this.sysPushFlowConfigLinkDTOS
            + ")";
      }
   }
}
