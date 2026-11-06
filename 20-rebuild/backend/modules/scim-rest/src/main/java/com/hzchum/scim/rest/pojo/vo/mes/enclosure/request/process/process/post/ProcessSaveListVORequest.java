package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.process.process.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.process.MesEnclosureProcessDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProcessSaveVORequest", description = "")
public class ProcessSaveListVORequest {
   @ApiModelProperty(name = "list", notes = "工序列表")
   @JsonProperty("list")
   @JSONField(name = "list")
   @NotNull(message = "名称不能为空")
   private List<MesEnclosureProcessDTOParam> list;

   public static ProcessSaveListVORequest.ProcessSaveListVORequestBuilder builder() {
      return new ProcessSaveListVORequest.ProcessSaveListVORequestBuilder();
   }

   public ProcessSaveListVORequest() {
   }

   public ProcessSaveListVORequest(final List<MesEnclosureProcessDTOParam> list) {
      this.list = list;
   }

   public List<MesEnclosureProcessDTOParam> getList() {
      return this.list;
   }

   @JsonProperty("list")
   public ProcessSaveListVORequest setList(final List<MesEnclosureProcessDTOParam> list) {
      this.list = list;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessSaveListVORequest(list=" + this.getList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessSaveListVORequest)) {
         return false;
      }

      ProcessSaveListVORequest other = (ProcessSaveListVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$list = this.getList();
      Object other$list = other.getList();
      return this$list == null ? other$list == null : this$list.equals(other$list);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessSaveListVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   public static class ProcessSaveListVORequestBuilder {
      private List<MesEnclosureProcessDTOParam> list;

      ProcessSaveListVORequestBuilder() {
      }

      @JsonProperty("list")
      public ProcessSaveListVORequest.ProcessSaveListVORequestBuilder list(final List<MesEnclosureProcessDTOParam> list) {
         this.list = list;
         return this;
      }

      public ProcessSaveListVORequest build() {
         return new ProcessSaveListVORequest(this.list);
      }

      @Override
      public String toString() {
         return "ProcessSaveListVORequest.ProcessSaveListVORequestBuilder(list=" + this.list + ")";
      }
   }
}
