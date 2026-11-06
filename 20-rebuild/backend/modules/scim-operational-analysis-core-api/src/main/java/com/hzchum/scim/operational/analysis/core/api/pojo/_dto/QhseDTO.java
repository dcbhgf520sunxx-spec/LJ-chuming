package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "QhseDTO", description = "问题上报汇总")
public class QhseDTO {
   @ApiModelProperty(name = "qhseDetailsList", value = "月份", notes = "月份")
   @JsonProperty("qhseDetailsList")
   @JSONField(name = "qhseDetailsList")
   private List<QhseDetailsDTO> qhseDetailsList;
   @ApiModelProperty(name = "type", value = "问题类型", notes = "问题类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;

   public static QhseDTO.QhseDTOBuilder builder() {
      return new QhseDTO.QhseDTOBuilder();
   }

   public QhseDTO(final List<QhseDetailsDTO> qhseDetailsList, final Integer type) {
      this.qhseDetailsList = qhseDetailsList;
      this.type = type;
   }

   public QhseDTO() {
   }

   public List<QhseDetailsDTO> getQhseDetailsList() {
      return this.qhseDetailsList;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("qhseDetailsList")
   public QhseDTO setQhseDetailsList(final List<QhseDetailsDTO> qhseDetailsList) {
      this.qhseDetailsList = qhseDetailsList;
      return this;
   }

   @JsonProperty("type")
   public QhseDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "QhseDTO(qhseDetailsList=" + this.getQhseDetailsList() + ", type=" + this.getType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof QhseDTO)) {
         return false;
      } else {
         QhseDTO other = (QhseDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$qhseDetailsList = this.getQhseDetailsList();
               Object other$qhseDetailsList = other.getQhseDetailsList();
               return this$qhseDetailsList == null ? other$qhseDetailsList == null : this$qhseDetailsList.equals(other$qhseDetailsList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QhseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $qhseDetailsList = this.getQhseDetailsList();
      return result * 59 + ($qhseDetailsList == null ? 43 : $qhseDetailsList.hashCode());
   }

   public static class QhseDTOBuilder {
      private List<QhseDetailsDTO> qhseDetailsList;
      private Integer type;

      QhseDTOBuilder() {
      }

      @JsonProperty("qhseDetailsList")
      public QhseDTO.QhseDTOBuilder qhseDetailsList(final List<QhseDetailsDTO> qhseDetailsList) {
         this.qhseDetailsList = qhseDetailsList;
         return this;
      }

      @JsonProperty("type")
      public QhseDTO.QhseDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public QhseDTO build() {
         return new QhseDTO(this.qhseDetailsList, this.type);
      }

      @Override
      public String toString() {
         return "QhseDTO.QhseDTOBuilder(qhseDetailsList=" + this.qhseDetailsList + ", type=" + this.type + ")";
      }
   }
}
