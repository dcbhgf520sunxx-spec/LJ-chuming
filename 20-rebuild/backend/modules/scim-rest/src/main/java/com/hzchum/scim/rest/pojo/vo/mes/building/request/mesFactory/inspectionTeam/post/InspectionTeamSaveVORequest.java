package com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.inspectionTeam.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingInspectionTeamUserLinkDTOParam;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "InspectionTeamSaveVORequest", description = "")
public class InspectionTeamSaveVORequest {
   @ApiModelProperty(name = "factoryId", notes = "工厂id", value = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @NotNull(message = "工厂id不能为空")
   private Long factoryId;
   @ApiModelProperty(name = "processId", notes = "工序id", value = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @NotNull(message = "生产线类型不能为空")
   @EnumValidator(value = ProductionLineTypeEnum.class, message = "生产线类型错误")
   private Integer productionLineTypeEnum;
   @ApiModelProperty(name = "userLinks", notes = "质检人员", value = "质检人员")
   @JsonProperty("userLinks")
   @JSONField(name = "userLinks")
   private List<MesBuildingInspectionTeamUserLinkDTOParam> userLinks;

   public static InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder builder() {
      return new InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder();
   }

   public InspectionTeamSaveVORequest() {
   }

   public InspectionTeamSaveVORequest(
      final Long factoryId, final Long processId, final Integer productionLineTypeEnum, final List<MesBuildingInspectionTeamUserLinkDTOParam> userLinks
   ) {
      this.factoryId = factoryId;
      this.processId = processId;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.userLinks = userLinks;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public List<MesBuildingInspectionTeamUserLinkDTOParam> getUserLinks() {
      return this.userLinks;
   }

   @JsonProperty("factoryId")
   public InspectionTeamSaveVORequest setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("processId")
   public InspectionTeamSaveVORequest setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public InspectionTeamSaveVORequest setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @JsonProperty("userLinks")
   public InspectionTeamSaveVORequest setUserLinks(final List<MesBuildingInspectionTeamUserLinkDTOParam> userLinks) {
      this.userLinks = userLinks;
      return this;
   }

   @Override
   public String toString() {
      return "InspectionTeamSaveVORequest(factoryId="
         + this.getFactoryId()
         + ", processId="
         + this.getProcessId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", userLinks="
         + this.getUserLinks()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionTeamSaveVORequest)) {
         return false;
      }

      InspectionTeamSaveVORequest other = (InspectionTeamSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factoryId = this.getFactoryId();
      Object other$factoryId = other.getFactoryId();
      if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
            Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
            if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
               Object this$userLinks = this.getUserLinks();
               Object other$userLinks = other.getUserLinks();
               return this$userLinks == null ? other$userLinks == null : this$userLinks.equals(other$userLinks);
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
      return other instanceof InspectionTeamSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $userLinks = this.getUserLinks();
      return result * 59 + ($userLinks == null ? 43 : $userLinks.hashCode());
   }

   public static class InspectionTeamSaveVORequestBuilder {
      private Long factoryId;
      private Long processId;
      private Integer productionLineTypeEnum;
      private List<MesBuildingInspectionTeamUserLinkDTOParam> userLinks;

      InspectionTeamSaveVORequestBuilder() {
      }

      @JsonProperty("factoryId")
      public InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("processId")
      public InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      @JsonProperty("userLinks")
      public InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder userLinks(final List<MesBuildingInspectionTeamUserLinkDTOParam> userLinks) {
         this.userLinks = userLinks;
         return this;
      }

      public InspectionTeamSaveVORequest build() {
         return new InspectionTeamSaveVORequest(this.factoryId, this.processId, this.productionLineTypeEnum, this.userLinks);
      }

      @Override
      public String toString() {
         return "InspectionTeamSaveVORequest.InspectionTeamSaveVORequestBuilder(factoryId="
            + this.factoryId
            + ", processId="
            + this.processId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", userLinks="
            + this.userLinks
            + ")";
      }
   }
}
