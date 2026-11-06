package com.hzchum.scim.contract.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractProjectContent对象", description = "项目内容表 ")
@Entity
@TableName("contract_project_content")
@Table(name = "contract_project_content")
public class ContractProjectContent extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "categoryType", value = "分类 2结构 4围护 8配套件 16箱体")
   @JsonProperty("categoryType")
   @JSONField(name = "categoryType")
   @TableField("category_type")
   @Column(name = "category_type")
   private Integer categoryType;
   @ApiModelProperty(name = "no", value = "标识")
   @JsonProperty("no")
   @JSONField(name = "no")
   @TableField("no")
   @Column(name = "no")
   private Integer no;

   public static ContractProjectContent.ContractProjectContentBuilder builder() {
      return new ContractProjectContent.ContractProjectContentBuilder();
   }

   public ContractProjectContent() {
   }

   public ContractProjectContent(final Long id, final String name, final Integer categoryType, final Integer no) {
      this.id = id;
      this.name = name;
      this.categoryType = categoryType;
      this.no = no;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getCategoryType() {
      return this.categoryType;
   }

   public Integer getNo() {
      return this.no;
   }

   @JsonProperty("id")
   public ContractProjectContent setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public ContractProjectContent setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("categoryType")
   public ContractProjectContent setCategoryType(final Integer categoryType) {
      this.categoryType = categoryType;
      return this;
   }

   @JsonProperty("no")
   public ContractProjectContent setNo(final Integer no) {
      this.no = no;
      return this;
   }

   @Override
   public String toString() {
      return "ContractProjectContent(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", categoryType="
         + this.getCategoryType()
         + ", no="
         + this.getNo()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectContent)) {
         return false;
      }

      ContractProjectContent other = (ContractProjectContent)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$categoryType = this.getCategoryType();
         Object other$categoryType = other.getCategoryType();
         if (this$categoryType == null ? other$categoryType == null : this$categoryType.equals(other$categoryType)) {
            Object this$no = this.getNo();
            Object other$no = other.getNo();
            if (this$no == null ? other$no == null : this$no.equals(other$no)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractProjectContent;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $categoryType = this.getCategoryType();
      result = result * 59 + ($categoryType == null ? 43 : $categoryType.hashCode());
      Object $no = this.getNo();
      result = result * 59 + ($no == null ? 43 : $no.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class ContractProjectContentBuilder {
      private Long id;
      private String name;
      private Integer categoryType;
      private Integer no;

      ContractProjectContentBuilder() {
      }

      @JsonProperty("id")
      public ContractProjectContent.ContractProjectContentBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public ContractProjectContent.ContractProjectContentBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("categoryType")
      public ContractProjectContent.ContractProjectContentBuilder categoryType(final Integer categoryType) {
         this.categoryType = categoryType;
         return this;
      }

      @JsonProperty("no")
      public ContractProjectContent.ContractProjectContentBuilder no(final Integer no) {
         this.no = no;
         return this;
      }

      public ContractProjectContent build() {
         return new ContractProjectContent(this.id, this.name, this.categoryType, this.no);
      }

      @Override
      public String toString() {
         return "ContractProjectContent.ContractProjectContentBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", categoryType="
            + this.categoryType
            + ", no="
            + this.no
            + ")";
      }
   }
}
