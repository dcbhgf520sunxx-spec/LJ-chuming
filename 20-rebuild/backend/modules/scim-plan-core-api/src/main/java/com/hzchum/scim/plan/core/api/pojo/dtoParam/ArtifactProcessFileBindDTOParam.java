package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("构件绑定工艺文件类")
public class ArtifactProcessFileBindDTOParam {
   @ApiModelProperty("工艺文件id")
   @NotNull(message = "工艺文件id不能为空")
   private Long processFileId;
   @Valid
   @ApiModelProperty("构件编号列表")
   @NotEmpty(message = "构件编号列表不能为空")
   private List<MonomerArtifactSnDTOParam> details;

   public Long getProcessFileId() {
      return this.processFileId;
   }

   public List<MonomerArtifactSnDTOParam> getDetails() {
      return this.details;
   }

   public void setProcessFileId(final Long processFileId) {
      this.processFileId = processFileId;
   }

   public void setDetails(final List<MonomerArtifactSnDTOParam> details) {
      this.details = details;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtifactProcessFileBindDTOParam)) {
         return false;
      } else {
         ArtifactProcessFileBindDTOParam other = (ArtifactProcessFileBindDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$processFileId = this.getProcessFileId();
            Object other$processFileId = other.getProcessFileId();
            if (this$processFileId == null ? other$processFileId == null : this$processFileId.equals(other$processFileId)) {
               Object this$details = this.getDetails();
               Object other$details = other.getDetails();
               return this$details == null ? other$details == null : this$details.equals(other$details);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactProcessFileBindDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processFileId = this.getProcessFileId();
      result = result * 59 + ($processFileId == null ? 43 : $processFileId.hashCode());
      Object $details = this.getDetails();
      return result * 59 + ($details == null ? 43 : $details.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactProcessFileBindDTOParam(processFileId=" + this.getProcessFileId() + ", details=" + this.getDetails() + ")";
   }
}
