package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureProductProcessDTOParam", description = "")
public class MesEnclosureProductProcessDTOParam {
   @ApiModelProperty(name = "type", notes = "类型id")
   @JsonProperty("type")
   @JSONField(name = "type")
   @NotNull(message = "钢板类型")
   private Long type;
   @ApiModelProperty(name = "processLinkList", notes = "工序")
   @JsonProperty("processLinkList")
   @JSONField(name = "processLinkList")
   private List<MesEnclosureProductProcessLinkDTOParam> processLinkList;

   public static MesEnclosureProductProcessDTOParam.MesEnclosureProductProcessDTOParamBuilder builder() {
      return new MesEnclosureProductProcessDTOParam.MesEnclosureProductProcessDTOParamBuilder();
   }

   public MesEnclosureProductProcessDTOParam() {
   }

   public MesEnclosureProductProcessDTOParam(final Long type, final List<MesEnclosureProductProcessLinkDTOParam> processLinkList) {
      this.type = type;
      this.processLinkList = processLinkList;
   }

   public Long getType() {
      return this.type;
   }

   public List<MesEnclosureProductProcessLinkDTOParam> getProcessLinkList() {
      return this.processLinkList;
   }

   @JsonProperty("type")
   public MesEnclosureProductProcessDTOParam setType(final Long type) {
      this.type = type;
      return this;
   }

   @JsonProperty("processLinkList")
   public MesEnclosureProductProcessDTOParam setProcessLinkList(final List<MesEnclosureProductProcessLinkDTOParam> processLinkList) {
      this.processLinkList = processLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductProcessDTOParam(type=" + this.getType() + ", processLinkList=" + this.getProcessLinkList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesEnclosureProductProcessDTOParam)) {
         return false;
      } else {
         MesEnclosureProductProcessDTOParam other = (MesEnclosureProductProcessDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$processLinkList = this.getProcessLinkList();
               Object other$processLinkList = other.getProcessLinkList();
               return this$processLinkList == null ? other$processLinkList == null : this$processLinkList.equals(other$processLinkList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProductProcessDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $processLinkList = this.getProcessLinkList();
      return result * 59 + ($processLinkList == null ? 43 : $processLinkList.hashCode());
   }

   public static class MesEnclosureProductProcessDTOParamBuilder {
      private Long type;
      private List<MesEnclosureProductProcessLinkDTOParam> processLinkList;

      MesEnclosureProductProcessDTOParamBuilder() {
      }

      @JsonProperty("type")
      public MesEnclosureProductProcessDTOParam.MesEnclosureProductProcessDTOParamBuilder type(final Long type) {
         this.type = type;
         return this;
      }

      @JsonProperty("processLinkList")
      public MesEnclosureProductProcessDTOParam.MesEnclosureProductProcessDTOParamBuilder processLinkList(
         final List<MesEnclosureProductProcessLinkDTOParam> processLinkList
      ) {
         this.processLinkList = processLinkList;
         return this;
      }

      public MesEnclosureProductProcessDTOParam build() {
         return new MesEnclosureProductProcessDTOParam(this.type, this.processLinkList);
      }

      @Override
      public String toString() {
         return "MesEnclosureProductProcessDTOParam.MesEnclosureProductProcessDTOParamBuilder(type="
            + this.type
            + ", processLinkList="
            + this.processLinkList
            + ")";
      }
   }
}
