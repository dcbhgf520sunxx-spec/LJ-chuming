package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "MesBuildingProcessNode对象", description = "")
public class MesBuildingProcessNode {
   private String name;
   private List<MesBuildingProcessNode> children = new ArrayList<>();
   private List<MesBuildingProcessNodeDTO> processNames = new ArrayList<>();

   public MesBuildingProcessNode(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public void addChild(MesBuildingProcessNode child) {
      this.children.add(child);
   }

   public void addProcessName(Long id, String processName) {
      MesBuildingProcessNodeDTO mesBuildingProcessNodeDTO = new MesBuildingProcessNodeDTO();
      mesBuildingProcessNodeDTO.setId(id);
      mesBuildingProcessNodeDTO.setName(processName);
      this.processNames.add(mesBuildingProcessNodeDTO);
   }

   public List<MesBuildingProcessNode> getChildren() {
      return this.children;
   }

   public List<MesBuildingProcessNodeDTO> getProcessNames() {
      return this.processNames;
   }

   public static MesBuildingProcessNode.MesBuildingProcessNodeBuilder builder() {
      return new MesBuildingProcessNode.MesBuildingProcessNodeBuilder();
   }

   public MesBuildingProcessNode() {
   }

   public MesBuildingProcessNode(final String name, final List<MesBuildingProcessNode> children, final List<MesBuildingProcessNodeDTO> processNames) {
      this.name = name;
      this.children = children;
      this.processNames = processNames;
   }

   public MesBuildingProcessNode setName(final String name) {
      this.name = name;
      return this;
   }

   public MesBuildingProcessNode setChildren(final List<MesBuildingProcessNode> children) {
      this.children = children;
      return this;
   }

   public MesBuildingProcessNode setProcessNames(final List<MesBuildingProcessNodeDTO> processNames) {
      this.processNames = processNames;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProcessNode(name=" + this.getName() + ", children=" + this.getChildren() + ", processNames=" + this.getProcessNames() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProcessNode)) {
         return false;
      }

      MesBuildingProcessNode other = (MesBuildingProcessNode)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$children = this.getChildren();
         Object other$children = other.getChildren();
         if (this$children == null ? other$children == null : this$children.equals(other$children)) {
            Object this$processNames = this.getProcessNames();
            Object other$processNames = other.getProcessNames();
            return this$processNames == null ? other$processNames == null : this$processNames.equals(other$processNames);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProcessNode;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $children = this.getChildren();
      result = result * 59 + ($children == null ? 43 : $children.hashCode());
      Object $processNames = this.getProcessNames();
      return result * 59 + ($processNames == null ? 43 : $processNames.hashCode());
   }

   public static class MesBuildingProcessNodeBuilder {
      private String name;
      private List<MesBuildingProcessNode> children;
      private List<MesBuildingProcessNodeDTO> processNames;

      MesBuildingProcessNodeBuilder() {
      }

      public MesBuildingProcessNode.MesBuildingProcessNodeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingProcessNode.MesBuildingProcessNodeBuilder children(final List<MesBuildingProcessNode> children) {
         this.children = children;
         return this;
      }

      public MesBuildingProcessNode.MesBuildingProcessNodeBuilder processNames(final List<MesBuildingProcessNodeDTO> processNames) {
         this.processNames = processNames;
         return this;
      }

      public MesBuildingProcessNode build() {
         return new MesBuildingProcessNode(this.name, this.children, this.processNames);
      }

      @Override
      public String toString() {
         return "MesBuildingProcessNode.MesBuildingProcessNodeBuilder(name="
            + this.name
            + ", children="
            + this.children
            + ", processNames="
            + this.processNames
            + ")";
      }
   }
}
