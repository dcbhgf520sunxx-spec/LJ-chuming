package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationMatchDTOParam;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.persistence.Column;

public class SteelClassificationProcessDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("零件类型")
   private Integer productClassificationEnum;
   @ApiModelProperty("钢材种类")
   private String name;
   @ApiModelProperty("排序")
   private Integer sort;
   @ApiModelProperty("物料基础分类")
   @Column
   private Integer basicClass;
   @ApiModelProperty("关键字符")
   private List<SteelClassificationMatchDTOParam> links;
   @ApiModelProperty("科目关联")
   private List<com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassifyLinkDTO> classifyLinks;
   @ApiModelProperty("科目关联")
   private List<Long> boundFinalClassifyIds;
   @ApiModelProperty("是否配置工序")
   private Boolean hasProcess;
   @ApiModelProperty(name = "productProcessLinkList", notes = "工序详情")
   @JsonProperty("productProcessLinkList")
   @JSONField(name = "productProcessLinkList")
   @JsonInclude(Include.NON_NULL)
   private List<MesBuildingProductProcessLinkDTO> productProcessLinkList;

   public Long getId() {
      return this.id;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public List<SteelClassificationMatchDTOParam> getLinks() {
      return this.links;
   }

   public List<com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassifyLinkDTO> getClassifyLinks() {
      return this.classifyLinks;
   }

   public List<Long> getBoundFinalClassifyIds() {
      return this.boundFinalClassifyIds;
   }

   public Boolean getHasProcess() {
      return this.hasProcess;
   }

   public List<MesBuildingProductProcessLinkDTO> getProductProcessLinkList() {
      return this.productProcessLinkList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setLinks(final List<SteelClassificationMatchDTOParam> links) {
      this.links = links;
   }

   public void setClassifyLinks(final List<com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassifyLinkDTO> classifyLinks) {
      this.classifyLinks = classifyLinks;
   }

   public void setBoundFinalClassifyIds(final List<Long> boundFinalClassifyIds) {
      this.boundFinalClassifyIds = boundFinalClassifyIds;
   }

   public void setHasProcess(final Boolean hasProcess) {
      this.hasProcess = hasProcess;
   }

   @JsonProperty("productProcessLinkList")
   public void setProductProcessLinkList(final List<MesBuildingProductProcessLinkDTO> productProcessLinkList) {
      this.productProcessLinkList = productProcessLinkList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelClassificationProcessDTO)) {
         return false;
      }

      SteelClassificationProcessDTO other = (SteelClassificationProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productClassificationEnum = this.getProductClassificationEnum();
         Object other$productClassificationEnum = other.getProductClassificationEnum();
         if (this$productClassificationEnum == null
            ? other$productClassificationEnum == null
            : this$productClassificationEnum.equals(other$productClassificationEnum)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$hasProcess = this.getHasProcess();
                  Object other$hasProcess = other.getHasProcess();
                  if (this$hasProcess == null ? other$hasProcess == null : this$hasProcess.equals(other$hasProcess)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$links = this.getLinks();
                        Object other$links = other.getLinks();
                        if (this$links == null ? other$links == null : this$links.equals(other$links)) {
                           Object this$classifyLinks = this.getClassifyLinks();
                           Object other$classifyLinks = other.getClassifyLinks();
                           if (this$classifyLinks == null ? other$classifyLinks == null : this$classifyLinks.equals(other$classifyLinks)) {
                              Object this$boundFinalClassifyIds = this.getBoundFinalClassifyIds();
                              Object other$boundFinalClassifyIds = other.getBoundFinalClassifyIds();
                              if (this$boundFinalClassifyIds == null
                                 ? other$boundFinalClassifyIds == null
                                 : this$boundFinalClassifyIds.equals(other$boundFinalClassifyIds)) {
                                 Object this$productProcessLinkList = this.getProductProcessLinkList();
                                 Object other$productProcessLinkList = other.getProductProcessLinkList();
                                 return this$productProcessLinkList == null
                                    ? other$productProcessLinkList == null
                                    : this$productProcessLinkList.equals(other$productProcessLinkList);
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
      return other instanceof SteelClassificationProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $hasProcess = this.getHasProcess();
      result = result * 59 + ($hasProcess == null ? 43 : $hasProcess.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $links = this.getLinks();
      result = result * 59 + ($links == null ? 43 : $links.hashCode());
      Object $classifyLinks = this.getClassifyLinks();
      result = result * 59 + ($classifyLinks == null ? 43 : $classifyLinks.hashCode());
      Object $boundFinalClassifyIds = this.getBoundFinalClassifyIds();
      result = result * 59 + ($boundFinalClassifyIds == null ? 43 : $boundFinalClassifyIds.hashCode());
      Object $productProcessLinkList = this.getProductProcessLinkList();
      return result * 59 + ($productProcessLinkList == null ? 43 : $productProcessLinkList.hashCode());
   }

   @Override
   public String toString() {
      return "SteelClassificationProcessDTO(id="
         + this.getId()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", basicClass="
         + this.getBasicClass()
         + ", links="
         + this.getLinks()
         + ", classifyLinks="
         + this.getClassifyLinks()
         + ", boundFinalClassifyIds="
         + this.getBoundFinalClassifyIds()
         + ", hasProcess="
         + this.getHasProcess()
         + ", productProcessLinkList="
         + this.getProductProcessLinkList()
         + ")";
   }
}
