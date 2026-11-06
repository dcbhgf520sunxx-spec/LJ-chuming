package com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling;

import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "MesBuildingCloudcutJobVO", description = "云切作业")
public class MesBuildingCloudcutJobVO {
   private Long id;
   private String cloudcutName;
   private Long workshopId;
   private String workshopName;
   private Long parentId;
   private Integer jobType;
   private List<MesBuildingCloudcutJobVO> children = new ArrayList<>();

   public void addChild(MesBuildingCloudcutJobVO child) {
      if (this.children == null) {
         this.children = new ArrayList<>();
      }

      this.children.add(child);
   }

   public Long getId() {
      return this.id;
   }

   public String getCloudcutName() {
      return this.cloudcutName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getParentId() {
      return this.parentId;
   }

   public Integer getJobType() {
      return this.jobType;
   }

   public List<MesBuildingCloudcutJobVO> getChildren() {
      return this.children;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCloudcutName(final String cloudcutName) {
      this.cloudcutName = cloudcutName;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setParentId(final Long parentId) {
      this.parentId = parentId;
   }

   public void setJobType(final Integer jobType) {
      this.jobType = jobType;
   }

   public void setChildren(final List<MesBuildingCloudcutJobVO> children) {
      this.children = children;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingCloudcutJobVO)) {
         return false;
      }

      MesBuildingCloudcutJobVO other = (MesBuildingCloudcutJobVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$parentId = this.getParentId();
            Object other$parentId = other.getParentId();
            if (this$parentId == null ? other$parentId == null : this$parentId.equals(other$parentId)) {
               Object this$jobType = this.getJobType();
               Object other$jobType = other.getJobType();
               if (this$jobType == null ? other$jobType == null : this$jobType.equals(other$jobType)) {
                  Object this$cloudcutName = this.getCloudcutName();
                  Object other$cloudcutName = other.getCloudcutName();
                  if (this$cloudcutName == null ? other$cloudcutName == null : this$cloudcutName.equals(other$cloudcutName)) {
                     Object this$workshopName = this.getWorkshopName();
                     Object other$workshopName = other.getWorkshopName();
                     if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                        Object this$children = this.getChildren();
                        Object other$children = other.getChildren();
                        return this$children == null ? other$children == null : this$children.equals(other$children);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingCloudcutJobVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $parentId = this.getParentId();
      result = result * 59 + ($parentId == null ? 43 : $parentId.hashCode());
      Object $jobType = this.getJobType();
      result = result * 59 + ($jobType == null ? 43 : $jobType.hashCode());
      Object $cloudcutName = this.getCloudcutName();
      result = result * 59 + ($cloudcutName == null ? 43 : $cloudcutName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $children = this.getChildren();
      return result * 59 + ($children == null ? 43 : $children.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingCloudcutJobVO(id="
         + this.getId()
         + ", cloudcutName="
         + this.getCloudcutName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", parentId="
         + this.getParentId()
         + ", jobType="
         + this.getJobType()
         + ", children="
         + this.getChildren()
         + ")";
   }
}
