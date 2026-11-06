package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import java.time.LocalDateTime;
import java.util.List;

public class AreaDTOParam {
   private Long id;
   private LocalDateTime date;
   private Integer modelType;
   List<ArtifactAndAssembleDTOParam> detailList;

   public static AreaDTOParam.AreaDTOParamBuilder builder() {
      return new AreaDTOParam.AreaDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public Integer getModelType() {
      return this.modelType;
   }

   public List<ArtifactAndAssembleDTOParam> getDetailList() {
      return this.detailList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setDate(final LocalDateTime date) {
      this.date = date;
   }

   public void setModelType(final Integer modelType) {
      this.modelType = modelType;
   }

   public void setDetailList(final List<ArtifactAndAssembleDTOParam> detailList) {
      this.detailList = detailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaDTOParam)) {
         return false;
      }

      AreaDTOParam other = (AreaDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$modelType = this.getModelType();
         Object other$modelType = other.getModelType();
         if (this$modelType == null ? other$modelType == null : this$modelType.equals(other$modelType)) {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            if (this$date == null ? other$date == null : this$date.equals(other$date)) {
               Object this$detailList = this.getDetailList();
               Object other$detailList = other.getDetailList();
               return this$detailList == null ? other$detailList == null : this$detailList.equals(other$detailList);
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
      return other instanceof AreaDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $modelType = this.getModelType();
      result = result * 59 + ($modelType == null ? 43 : $modelType.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $detailList = this.getDetailList();
      return result * 59 + ($detailList == null ? 43 : $detailList.hashCode());
   }

   @Override
   public String toString() {
      return "AreaDTOParam(id="
         + this.getId()
         + ", date="
         + this.getDate()
         + ", modelType="
         + this.getModelType()
         + ", detailList="
         + this.getDetailList()
         + ")";
   }

   public AreaDTOParam(final Long id, final LocalDateTime date, final Integer modelType, final List<ArtifactAndAssembleDTOParam> detailList) {
      this.id = id;
      this.date = date;
      this.modelType = modelType;
      this.detailList = detailList;
   }

   public AreaDTOParam() {
   }

   public static class AreaDTOParamBuilder {
      private Long id;
      private LocalDateTime date;
      private Integer modelType;
      private List<ArtifactAndAssembleDTOParam> detailList;

      AreaDTOParamBuilder() {
      }

      public AreaDTOParam.AreaDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AreaDTOParam.AreaDTOParamBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public AreaDTOParam.AreaDTOParamBuilder modelType(final Integer modelType) {
         this.modelType = modelType;
         return this;
      }

      public AreaDTOParam.AreaDTOParamBuilder detailList(final List<ArtifactAndAssembleDTOParam> detailList) {
         this.detailList = detailList;
         return this;
      }

      public AreaDTOParam build() {
         return new AreaDTOParam(this.id, this.date, this.modelType, this.detailList);
      }

      @Override
      public String toString() {
         return "AreaDTOParam.AreaDTOParamBuilder(id="
            + this.id
            + ", date="
            + this.date
            + ", modelType="
            + this.modelType
            + ", detailList="
            + this.detailList
            + ")";
      }
   }
}
