package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "QhseReportDetailDTO", description = "问题详情")
public class QhseReportDetailDTO extends QhseReportListDTO {
   @ApiModelProperty(name = "problemDrawing", notes = "问题上报图片ids")
   @JsonProperty("problemDrawing")
   @JSONField(name = "problemDrawing")
   private String problemDrawing;
   @ApiModelProperty(name = "drawingLabel", notes = "图纸标注")
   @JsonProperty("drawingLabel")
   @JSONField(name = "drawingLabel")
   private Long drawingLabel;
   @ApiModelProperty(name = "attachmentDTOS", value = "问题报告附件")
   @JsonProperty("attachmentDTOS")
   @JSONField(name = "attachmentDTOS")
   private List<AttachmentDTO> attachmentDTOS;
   @ApiModelProperty(name = "qhseRectifyDTOS", value = "问题整改")
   @JsonProperty("qhseRectifyDTOS")
   @JSONField(name = "qhseRectifyDTOS")
   private List<MesBuildingQhseRectifyDTO> qhseRectifyDTOS;

   public QhseReportDetailDTO() {
   }

   public QhseReportDetailDTO(
      final String problemDrawing, final Long drawingLabel, final List<AttachmentDTO> attachmentDTOS, final List<MesBuildingQhseRectifyDTO> qhseRectifyDTOS
   ) {
      this.problemDrawing = problemDrawing;
      this.drawingLabel = drawingLabel;
      this.attachmentDTOS = attachmentDTOS;
      this.qhseRectifyDTOS = qhseRectifyDTOS;
   }

   public String getProblemDrawing() {
      return this.problemDrawing;
   }

   public Long getDrawingLabel() {
      return this.drawingLabel;
   }

   public List<AttachmentDTO> getAttachmentDTOS() {
      return this.attachmentDTOS;
   }

   public List<MesBuildingQhseRectifyDTO> getQhseRectifyDTOS() {
      return this.qhseRectifyDTOS;
   }

   @JsonProperty("problemDrawing")
   public void setProblemDrawing(final String problemDrawing) {
      this.problemDrawing = problemDrawing;
   }

   @JsonProperty("drawingLabel")
   public void setDrawingLabel(final Long drawingLabel) {
      this.drawingLabel = drawingLabel;
   }

   @JsonProperty("attachmentDTOS")
   public void setAttachmentDTOS(final List<AttachmentDTO> attachmentDTOS) {
      this.attachmentDTOS = attachmentDTOS;
   }

   @JsonProperty("qhseRectifyDTOS")
   public void setQhseRectifyDTOS(final List<MesBuildingQhseRectifyDTO> qhseRectifyDTOS) {
      this.qhseRectifyDTOS = qhseRectifyDTOS;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseReportDetailDTO)) {
         return false;
      }

      QhseReportDetailDTO other = (QhseReportDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$drawingLabel = this.getDrawingLabel();
      Object other$drawingLabel = other.getDrawingLabel();
      if (this$drawingLabel == null ? other$drawingLabel == null : this$drawingLabel.equals(other$drawingLabel)) {
         Object this$problemDrawing = this.getProblemDrawing();
         Object other$problemDrawing = other.getProblemDrawing();
         if (this$problemDrawing == null ? other$problemDrawing == null : this$problemDrawing.equals(other$problemDrawing)) {
            Object this$attachmentDTOS = this.getAttachmentDTOS();
            Object other$attachmentDTOS = other.getAttachmentDTOS();
            if (this$attachmentDTOS == null ? other$attachmentDTOS == null : this$attachmentDTOS.equals(other$attachmentDTOS)) {
               Object this$qhseRectifyDTOS = this.getQhseRectifyDTOS();
               Object other$qhseRectifyDTOS = other.getQhseRectifyDTOS();
               return this$qhseRectifyDTOS == null ? other$qhseRectifyDTOS == null : this$qhseRectifyDTOS.equals(other$qhseRectifyDTOS);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof QhseReportDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $drawingLabel = this.getDrawingLabel();
      result = result * 59 + ($drawingLabel == null ? 43 : $drawingLabel.hashCode());
      Object $problemDrawing = this.getProblemDrawing();
      result = result * 59 + ($problemDrawing == null ? 43 : $problemDrawing.hashCode());
      Object $attachmentDTOS = this.getAttachmentDTOS();
      result = result * 59 + ($attachmentDTOS == null ? 43 : $attachmentDTOS.hashCode());
      Object $qhseRectifyDTOS = this.getQhseRectifyDTOS();
      return result * 59 + ($qhseRectifyDTOS == null ? 43 : $qhseRectifyDTOS.hashCode());
   }

   @Override
   public String toString() {
      return "QhseReportDetailDTO(problemDrawing="
         + this.getProblemDrawing()
         + ", drawingLabel="
         + this.getDrawingLabel()
         + ", attachmentDTOS="
         + this.getAttachmentDTOS()
         + ", qhseRectifyDTOS="
         + this.getQhseRectifyDTOS()
         + ")";
   }
}
