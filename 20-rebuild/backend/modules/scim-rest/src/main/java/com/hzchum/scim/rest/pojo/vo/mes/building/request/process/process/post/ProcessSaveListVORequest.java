package com.hzchum.scim.rest.pojo.vo.mes.building.request.process.process.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProcessDTOParam;
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
   private List<MesBuildingProcessDTOParam> list;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @NotNull(message = "productType不能为空")
   private Integer productType;

   public static ProcessSaveListVORequest.ProcessSaveListVORequestBuilder builder() {
      return new ProcessSaveListVORequest.ProcessSaveListVORequestBuilder();
   }

   public ProcessSaveListVORequest() {
   }

   public ProcessSaveListVORequest(final List<MesBuildingProcessDTOParam> list, final Integer productType) {
      this.list = list;
      this.productType = productType;
   }

   public List<MesBuildingProcessDTOParam> getList() {
      return this.list;
   }

   public Integer getProductType() {
      return this.productType;
   }

   @JsonProperty("list")
   public ProcessSaveListVORequest setList(final List<MesBuildingProcessDTOParam> list) {
      this.list = list;
      return this;
   }

   @JsonProperty("productType")
   public ProcessSaveListVORequest setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessSaveListVORequest(list=" + this.getList() + ", productType=" + this.getProductType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProcessSaveListVORequest)) {
         return false;
      } else {
         ProcessSaveListVORequest other = (ProcessSaveListVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$list = this.getList();
               Object other$list = other.getList();
               return this$list == null ? other$list == null : this$list.equals(other$list);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessSaveListVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   public static class ProcessSaveListVORequestBuilder {
      private List<MesBuildingProcessDTOParam> list;
      private Integer productType;

      ProcessSaveListVORequestBuilder() {
      }

      @JsonProperty("list")
      public ProcessSaveListVORequest.ProcessSaveListVORequestBuilder list(final List<MesBuildingProcessDTOParam> list) {
         this.list = list;
         return this;
      }

      @JsonProperty("productType")
      public ProcessSaveListVORequest.ProcessSaveListVORequestBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProcessSaveListVORequest build() {
         return new ProcessSaveListVORequest(this.list, this.productType);
      }

      @Override
      public String toString() {
         return "ProcessSaveListVORequest.ProcessSaveListVORequestBuilder(list=" + this.list + ", productType=" + this.productType + ")";
      }
   }
}
