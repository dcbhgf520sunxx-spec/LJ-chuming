package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassifyLinkDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(description = "组立配置dto类 ")
public class AssembleConfigDTO {
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("组立名称")
   private String name;
   @ApiModelProperty("组立名称（新）")
   private String newName;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [0 否, 1 是]", notes = "是否成品型材 [0 否, 1 是]")
   private Boolean boolSectionSteel;
   @ApiModelProperty(name = "newBoolSectionSteel", value = "是否成品型材 [0 否, 1 是]（新）", notes = "是否成品型材 [0 否, 1 是]（新）")
   private Boolean newBoolSectionSteel;
   @ApiModelProperty("排序")
   private Integer sort;
   @ApiModelProperty("排序（新）")
   private Integer newSort;
   @ApiModelProperty(name = "lastChangeId", value = "最新变更记录id", notes = "最新变更记录id")
   private Long lastChangeId;
   @ApiModelProperty("组立规格前缀列表")
   private List<AssembleSpecDTOParam> assembleSpecList;
   @ApiModelProperty("组立规格前缀列表（新）")
   private List<AssembleSpecDTOParam> newAssembleSpecList;
   @ApiModelProperty("科目关联")
   private List<SteelClassifyLinkDTO> classifyLinks;
   @ApiModelProperty("科目关联（新）")
   private List<SteelClassifyLinkDTO> newClassifyLinks;
   @ApiModelProperty("审核状态 1审核中 2同意 3拒绝")
   private Integer auditStatus;
   @ApiModelProperty("审核人名称")
   private String auditName;
   @ApiModelProperty(name = "auditTime", value = "审批时间", notes = "审批时间")
   private LocalDateTime auditTime;

   public static AssembleConfigDTO.AssembleConfigDTOBuilder builder() {
      return new AssembleConfigDTO.AssembleConfigDTOBuilder();
   }

   public AssembleConfigDTO() {
   }

   public AssembleConfigDTO(
      final Long id,
      final String name,
      final String newName,
      final Boolean boolSectionSteel,
      final Boolean newBoolSectionSteel,
      final Integer sort,
      final Integer newSort,
      final Long lastChangeId,
      final List<AssembleSpecDTOParam> assembleSpecList,
      final List<AssembleSpecDTOParam> newAssembleSpecList,
      final List<SteelClassifyLinkDTO> classifyLinks,
      final List<SteelClassifyLinkDTO> newClassifyLinks,
      final Integer auditStatus,
      final String auditName,
      final LocalDateTime auditTime
   ) {
      this.id = id;
      this.name = name;
      this.newName = newName;
      this.boolSectionSteel = boolSectionSteel;
      this.newBoolSectionSteel = newBoolSectionSteel;
      this.sort = sort;
      this.newSort = newSort;
      this.lastChangeId = lastChangeId;
      this.assembleSpecList = assembleSpecList;
      this.newAssembleSpecList = newAssembleSpecList;
      this.classifyLinks = classifyLinks;
      this.newClassifyLinks = newClassifyLinks;
      this.auditStatus = auditStatus;
      this.auditName = auditName;
      this.auditTime = auditTime;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getNewName() {
      return this.newName;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public Boolean getNewBoolSectionSteel() {
      return this.newBoolSectionSteel;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getNewSort() {
      return this.newSort;
   }

   public Long getLastChangeId() {
      return this.lastChangeId;
   }

   public List<AssembleSpecDTOParam> getAssembleSpecList() {
      return this.assembleSpecList;
   }

   public List<AssembleSpecDTOParam> getNewAssembleSpecList() {
      return this.newAssembleSpecList;
   }

   public List<SteelClassifyLinkDTO> getClassifyLinks() {
      return this.classifyLinks;
   }

   public List<SteelClassifyLinkDTO> getNewClassifyLinks() {
      return this.newClassifyLinks;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public String getAuditName() {
      return this.auditName;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setNewName(final String newName) {
      this.newName = newName;
   }

   public void setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
   }

   public void setNewBoolSectionSteel(final Boolean newBoolSectionSteel) {
      this.newBoolSectionSteel = newBoolSectionSteel;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setNewSort(final Integer newSort) {
      this.newSort = newSort;
   }

   public void setLastChangeId(final Long lastChangeId) {
      this.lastChangeId = lastChangeId;
   }

   public void setAssembleSpecList(final List<AssembleSpecDTOParam> assembleSpecList) {
      this.assembleSpecList = assembleSpecList;
   }

   public void setNewAssembleSpecList(final List<AssembleSpecDTOParam> newAssembleSpecList) {
      this.newAssembleSpecList = newAssembleSpecList;
   }

   public void setClassifyLinks(final List<SteelClassifyLinkDTO> classifyLinks) {
      this.classifyLinks = classifyLinks;
   }

   public void setNewClassifyLinks(final List<SteelClassifyLinkDTO> newClassifyLinks) {
      this.newClassifyLinks = newClassifyLinks;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setAuditName(final String auditName) {
      this.auditName = auditName;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleConfigDTO)) {
         return false;
      }

      AssembleConfigDTO other = (AssembleConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolSectionSteel = this.getBoolSectionSteel();
         Object other$boolSectionSteel = other.getBoolSectionSteel();
         if (this$boolSectionSteel == null ? other$boolSectionSteel == null : this$boolSectionSteel.equals(other$boolSectionSteel)) {
            Object this$newBoolSectionSteel = this.getNewBoolSectionSteel();
            Object other$newBoolSectionSteel = other.getNewBoolSectionSteel();
            if (this$newBoolSectionSteel == null ? other$newBoolSectionSteel == null : this$newBoolSectionSteel.equals(other$newBoolSectionSteel)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$newSort = this.getNewSort();
                  Object other$newSort = other.getNewSort();
                  if (this$newSort == null ? other$newSort == null : this$newSort.equals(other$newSort)) {
                     Object this$lastChangeId = this.getLastChangeId();
                     Object other$lastChangeId = other.getLastChangeId();
                     if (this$lastChangeId == null ? other$lastChangeId == null : this$lastChangeId.equals(other$lastChangeId)) {
                        Object this$auditStatus = this.getAuditStatus();
                        Object other$auditStatus = other.getAuditStatus();
                        if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$newName = this.getNewName();
                              Object other$newName = other.getNewName();
                              if (this$newName == null ? other$newName == null : this$newName.equals(other$newName)) {
                                 Object this$assembleSpecList = this.getAssembleSpecList();
                                 Object other$assembleSpecList = other.getAssembleSpecList();
                                 if (this$assembleSpecList == null ? other$assembleSpecList == null : this$assembleSpecList.equals(other$assembleSpecList)) {
                                    Object this$newAssembleSpecList = this.getNewAssembleSpecList();
                                    Object other$newAssembleSpecList = other.getNewAssembleSpecList();
                                    if (this$newAssembleSpecList == null
                                       ? other$newAssembleSpecList == null
                                       : this$newAssembleSpecList.equals(other$newAssembleSpecList)) {
                                       Object this$classifyLinks = this.getClassifyLinks();
                                       Object other$classifyLinks = other.getClassifyLinks();
                                       if (this$classifyLinks == null ? other$classifyLinks == null : this$classifyLinks.equals(other$classifyLinks)) {
                                          Object this$newClassifyLinks = this.getNewClassifyLinks();
                                          Object other$newClassifyLinks = other.getNewClassifyLinks();
                                          if (this$newClassifyLinks == null
                                             ? other$newClassifyLinks == null
                                             : this$newClassifyLinks.equals(other$newClassifyLinks)) {
                                             Object this$auditName = this.getAuditName();
                                             Object other$auditName = other.getAuditName();
                                             if (this$auditName == null ? other$auditName == null : this$auditName.equals(other$auditName)) {
                                                Object this$auditTime = this.getAuditTime();
                                                Object other$auditTime = other.getAuditTime();
                                                return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $newBoolSectionSteel = this.getNewBoolSectionSteel();
      result = result * 59 + ($newBoolSectionSteel == null ? 43 : $newBoolSectionSteel.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $newSort = this.getNewSort();
      result = result * 59 + ($newSort == null ? 43 : $newSort.hashCode());
      Object $lastChangeId = this.getLastChangeId();
      result = result * 59 + ($lastChangeId == null ? 43 : $lastChangeId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $newName = this.getNewName();
      result = result * 59 + ($newName == null ? 43 : $newName.hashCode());
      Object $assembleSpecList = this.getAssembleSpecList();
      result = result * 59 + ($assembleSpecList == null ? 43 : $assembleSpecList.hashCode());
      Object $newAssembleSpecList = this.getNewAssembleSpecList();
      result = result * 59 + ($newAssembleSpecList == null ? 43 : $newAssembleSpecList.hashCode());
      Object $classifyLinks = this.getClassifyLinks();
      result = result * 59 + ($classifyLinks == null ? 43 : $classifyLinks.hashCode());
      Object $newClassifyLinks = this.getNewClassifyLinks();
      result = result * 59 + ($newClassifyLinks == null ? 43 : $newClassifyLinks.hashCode());
      Object $auditName = this.getAuditName();
      result = result * 59 + ($auditName == null ? 43 : $auditName.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleConfigDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", newName="
         + this.getNewName()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", newBoolSectionSteel="
         + this.getNewBoolSectionSteel()
         + ", sort="
         + this.getSort()
         + ", newSort="
         + this.getNewSort()
         + ", lastChangeId="
         + this.getLastChangeId()
         + ", assembleSpecList="
         + this.getAssembleSpecList()
         + ", newAssembleSpecList="
         + this.getNewAssembleSpecList()
         + ", classifyLinks="
         + this.getClassifyLinks()
         + ", newClassifyLinks="
         + this.getNewClassifyLinks()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditName="
         + this.getAuditName()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }

   public static class AssembleConfigDTOBuilder {
      private Long id;
      private String name;
      private String newName;
      private Boolean boolSectionSteel;
      private Boolean newBoolSectionSteel;
      private Integer sort;
      private Integer newSort;
      private Long lastChangeId;
      private List<AssembleSpecDTOParam> assembleSpecList;
      private List<AssembleSpecDTOParam> newAssembleSpecList;
      private List<SteelClassifyLinkDTO> classifyLinks;
      private List<SteelClassifyLinkDTO> newClassifyLinks;
      private Integer auditStatus;
      private String auditName;
      private LocalDateTime auditTime;

      AssembleConfigDTOBuilder() {
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder newName(final String newName) {
         this.newName = newName;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder newBoolSectionSteel(final Boolean newBoolSectionSteel) {
         this.newBoolSectionSteel = newBoolSectionSteel;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder newSort(final Integer newSort) {
         this.newSort = newSort;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder lastChangeId(final Long lastChangeId) {
         this.lastChangeId = lastChangeId;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder assembleSpecList(final List<AssembleSpecDTOParam> assembleSpecList) {
         this.assembleSpecList = assembleSpecList;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder newAssembleSpecList(final List<AssembleSpecDTOParam> newAssembleSpecList) {
         this.newAssembleSpecList = newAssembleSpecList;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder classifyLinks(final List<SteelClassifyLinkDTO> classifyLinks) {
         this.classifyLinks = classifyLinks;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder newClassifyLinks(final List<SteelClassifyLinkDTO> newClassifyLinks) {
         this.newClassifyLinks = newClassifyLinks;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder auditName(final String auditName) {
         this.auditName = auditName;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public AssembleConfigDTO build() {
         return new AssembleConfigDTO(
            this.id,
            this.name,
            this.newName,
            this.boolSectionSteel,
            this.newBoolSectionSteel,
            this.sort,
            this.newSort,
            this.lastChangeId,
            this.assembleSpecList,
            this.newAssembleSpecList,
            this.classifyLinks,
            this.newClassifyLinks,
            this.auditStatus,
            this.auditName,
            this.auditTime
         );
      }

      @Override
      public String toString() {
         return "AssembleConfigDTO.AssembleConfigDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", newName="
            + this.newName
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", newBoolSectionSteel="
            + this.newBoolSectionSteel
            + ", sort="
            + this.sort
            + ", newSort="
            + this.newSort
            + ", lastChangeId="
            + this.lastChangeId
            + ", assembleSpecList="
            + this.assembleSpecList
            + ", newAssembleSpecList="
            + this.newAssembleSpecList
            + ", classifyLinks="
            + this.classifyLinks
            + ", newClassifyLinks="
            + this.newClassifyLinks
            + ", auditStatus="
            + this.auditStatus
            + ", auditName="
            + this.auditName
            + ", auditTime="
            + this.auditTime
            + ")";
      }
   }
}
