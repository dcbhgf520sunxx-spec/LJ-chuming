package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;

@ApiModel("OatAllWorkflowRequestListDTOParam")
public class OaAllWorkflowRequestListDTOParam {
   @ApiModelProperty(name = "conditions", value = "高级搜索条件 可以把多个条件放入这个map中")
   private Map<String, String> conditions;
   @ApiModelProperty(name = "pageNo", value = "要查询的为第几页的数据")
   private String pageNo;
   @ApiModelProperty(name = "pageSize", value = "分页时一页多少数据")
   private String pageSize;
   @ApiModelProperty(name = "userId", value = "要查询的用户id,不传取当前登录用户")
   private String userId;

   public static OaAllWorkflowRequestListDTOParam.OaAllWorkflowRequestListDTOParamBuilder builder() {
      return new OaAllWorkflowRequestListDTOParam.OaAllWorkflowRequestListDTOParamBuilder();
   }

   public OaAllWorkflowRequestListDTOParam(final Map<String, String> conditions, final String pageNo, final String pageSize, final String userId) {
      this.conditions = conditions;
      this.pageNo = pageNo;
      this.pageSize = pageSize;
      this.userId = userId;
   }

   public OaAllWorkflowRequestListDTOParam() {
   }

   public Map<String, String> getConditions() {
      return this.conditions;
   }

   public String getPageNo() {
      return this.pageNo;
   }

   public String getPageSize() {
      return this.pageSize;
   }

   public String getUserId() {
      return this.userId;
   }

   public OaAllWorkflowRequestListDTOParam setConditions(final Map<String, String> conditions) {
      this.conditions = conditions;
      return this;
   }

   public OaAllWorkflowRequestListDTOParam setPageNo(final String pageNo) {
      this.pageNo = pageNo;
      return this;
   }

   public OaAllWorkflowRequestListDTOParam setPageSize(final String pageSize) {
      this.pageSize = pageSize;
      return this;
   }

   public OaAllWorkflowRequestListDTOParam setUserId(final String userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "OaAllWorkflowRequestListDTOParam(conditions="
         + this.getConditions()
         + ", pageNo="
         + this.getPageNo()
         + ", pageSize="
         + this.getPageSize()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaAllWorkflowRequestListDTOParam)) {
         return false;
      }

      OaAllWorkflowRequestListDTOParam other = (OaAllWorkflowRequestListDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$conditions = this.getConditions();
      Object other$conditions = other.getConditions();
      if (this$conditions == null ? other$conditions == null : this$conditions.equals(other$conditions)) {
         Object this$pageNo = this.getPageNo();
         Object other$pageNo = other.getPageNo();
         if (this$pageNo == null ? other$pageNo == null : this$pageNo.equals(other$pageNo)) {
            Object this$pageSize = this.getPageSize();
            Object other$pageSize = other.getPageSize();
            if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
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
      return other instanceof OaAllWorkflowRequestListDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $conditions = this.getConditions();
      result = result * 59 + ($conditions == null ? 43 : $conditions.hashCode());
      Object $pageNo = this.getPageNo();
      result = result * 59 + ($pageNo == null ? 43 : $pageNo.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class OaAllWorkflowRequestListDTOParamBuilder {
      private Map<String, String> conditions;
      private String pageNo;
      private String pageSize;
      private String userId;

      OaAllWorkflowRequestListDTOParamBuilder() {
      }

      public OaAllWorkflowRequestListDTOParam.OaAllWorkflowRequestListDTOParamBuilder conditions(final Map<String, String> conditions) {
         this.conditions = conditions;
         return this;
      }

      public OaAllWorkflowRequestListDTOParam.OaAllWorkflowRequestListDTOParamBuilder pageNo(final String pageNo) {
         this.pageNo = pageNo;
         return this;
      }

      public OaAllWorkflowRequestListDTOParam.OaAllWorkflowRequestListDTOParamBuilder pageSize(final String pageSize) {
         this.pageSize = pageSize;
         return this;
      }

      public OaAllWorkflowRequestListDTOParam.OaAllWorkflowRequestListDTOParamBuilder userId(final String userId) {
         this.userId = userId;
         return this;
      }

      public OaAllWorkflowRequestListDTOParam build() {
         return new OaAllWorkflowRequestListDTOParam(this.conditions, this.pageNo, this.pageSize, this.userId);
      }

      @Override
      public String toString() {
         return "OaAllWorkflowRequestListDTOParam.OaAllWorkflowRequestListDTOParamBuilder(conditions="
            + this.conditions
            + ", pageNo="
            + this.pageNo
            + ", pageSize="
            + this.pageSize
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
