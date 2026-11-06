package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.contract.core.api.enums.finance.StatusEnum;
import com.hzchum.scim.system.core.api.common.enums.DeptAndJobTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentSaveRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentSimpleTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentTree;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentUpdateRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobResponseVO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.mapper.DepartmentMapper;
import com.hzchum.scim.system.core.mapper.JobMapper;
import com.hzchum.scim.system.core.mapper.UserMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
   @Resource
   private JobMapper jobMapper;
   @Resource
   private UserMapper userMapper;

   @Override
   public DepartmentDTO getDepartment(Long id) {
      Department department = this.baseMapper.selectById(id);
      Preconditions.checkArgument(department != null, "部门不存在!");
      return BeanUtil.copy(department, DepartmentDTO.class);
   }

   @Override
   public DepartmentDTO getDepartmentByUserId(Long userId) {
      Department department = this.baseMapper.selectByUserId(userId);
      Preconditions.checkArgument(department != null, "部门信息不存在！");
      return BeanUtil.copy(department, DepartmentDTO.class);
   }

   @Override
   public List<DepartmentTree> getDepartmentTree(String name, String deptCode, Integer enabled, Integer deptType) {
      List<DepartmentTree> trees = this.baseMapper.listAll();
      if (CollectionUtil.isEmpty(trees)) {
         return new ArrayList<>();
      }

      Map<Long, List<DepartmentTree>> deptMap = trees.stream().collect(Collectors.groupingBy(DepartmentTree::getPid));
      List<DepartmentTree> departmentTrees = this.deptBuild(0L, deptMap);
      this.checkTree(trees, name, deptCode, enabled, deptType);
      return departmentTrees;
   }

   @Override
   public ListVO<DepartmentTree> listDepartment(String name, String Code, Integer enabled, Integer deptType) {
      List<DepartmentTree> departmentTree = this.getDepartmentTree(name, Code, enabled, deptType);
      return new ListVO<>(departmentTree);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Long saveDepartment(DepartmentSaveRequestVO requestVO) {
      Preconditions.checkArgument(!"公司".equals(requestVO.getName()), "保存失败，禁止使用系统默认部门名称");
      List<Department> departments = this.baseMapper
         .selectList(Wrappers.lambdaQuery(Department.class).eq(Department::getPid, requestVO.getPid()).eq(Department::getName, requestVO.getName()));
      Preconditions.checkArgument(CollectionUtils.isEmpty(departments), "同一上级部门下,部门名称不能重复!");
      Department department = BeanUtil.copy(requestVO, Department.class);
      department.setDeptType(DeptAndJobTypeEnum.ESTABLISHMENT_OUTER.getType());
      this.baseMapper.insert(department);
      return department.getId();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean updateDepartment(DepartmentUpdateRequestVO requestVO) {
      Department department = this.baseMapper.selectById(requestVO.getId());
      Preconditions.checkArgument(department != null, "更新失败，要更新的部门不存在");
      if (!department.getName().equals(requestVO.getName())) {
         List<Department> departments = this.baseMapper
            .selectList(Wrappers.lambdaQuery(Department.class).eq(Department::getPid, requestVO.getPid()).eq(Department::getName, requestVO.getName()));
         Preconditions.checkArgument(CollectionUtils.isEmpty(departments), "保存失败，属同一上级且同级时部门名称不可以重复！");
      }

      if (requestVO.getPid() != null) {
         Preconditions.checkArgument(!requestVO.getId().equals(requestVO.getPid()), "父部门不能是部门本身!");
      }

      BeanUtil.copy(requestVO, department);
      return this.baseMapper.updateById(department) == 1;
   }

   @Override
   public List<DepartmentSimpleTreeResponseVO> getDepartmentSimpleTree(Boolean hasRoot) {
      List<DepartmentTree> departmentTree = this.baseMapper
         .listAll()
         .stream()
         .filter(department -> department.getStatus() == StatusEnum.ENABLED.getType())
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(departmentTree)) {
         return new ArrayList<>();
      }

      Map<Long, List<DepartmentTree>> subjectMap = departmentTree.stream().collect(Collectors.groupingBy(DepartmentTree::getPid));
      return this.build(0L, subjectMap);
   }

   @Override
   public List<DepartmentSimpleTreeResponseVO> getSHRDepartmentSimpleTree(Boolean hasRoot) {
      List<DepartmentTree> departmentTree = this.baseMapper
         .listAll()
         .stream()
         .filter(departmentTree1 -> departmentTree1.getDeptType() == DeptAndJobTypeEnum.ESTABLISHMENT_OUTER.getType())
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(departmentTree)) {
         return new ArrayList<>();
      }

      Map<Long, List<DepartmentTree>> subjectMap = departmentTree.stream().collect(Collectors.groupingBy(DepartmentTree::getPid));
      return this.build(1L, subjectMap);
   }

   private List<DepartmentSimpleTreeResponseVO> build(Long pid, Map<Long, List<DepartmentTree>> deptMap) {
      List<DepartmentTree> classifications = deptMap.get(pid);
      return CollectionUtils.isEmpty(classifications) ? new ArrayList<>() : classifications.stream().map(classification -> {
         DepartmentSimpleTreeResponseVO tree = BeanUtil.copy(classification, DepartmentSimpleTreeResponseVO.class);
         tree.setChildren(this.build(tree.getId(), deptMap));
         return tree;
      }).collect(Collectors.toList());
   }

   private List<DepartmentTree> deptBuild(Long pid, Map<Long, List<DepartmentTree>> deptMap) {
      List<DepartmentTree> classifications = deptMap.get(pid);
      return CollectionUtils.isEmpty(classifications)
         ? new ArrayList<>()
         : classifications.stream()
            .peek(classification -> classification.setChildren(this.deptBuild(classification.getId(), deptMap)))
            .collect(Collectors.toList());
   }

   @Override
   public String getDeptPath(Long id) {
      Department dept = this.baseMapper.selectById(id);
      if (dept != null) {
         if (dept.getPid() == 0L) {
            return "";
         } else {
            return dept.getPid() == 1L ? dept.getName() : this.getDeptPath(dept.getPid()) + "-" + dept.getName();
         }
      } else {
         return "";
      }
   }

   private DepartmentSimpleTreeResponseVO convertType(DepartmentSimpleTreeResponseVO responseVO, List<DepartmentTree> departmentTree) {
      departmentTree.forEach(parent -> {
         DepartmentSimpleTreeResponseVO children = new DepartmentSimpleTreeResponseVO();
         children.setId(parent.getId());
         children.setName(parent.getName());
         if (responseVO.getChildren() == null) {
            responseVO.setChildren(new ArrayList<>());
         }

         responseVO.getChildren().add(this.convertType(children, parent.getChildren()));
      });
      return responseVO;
   }

   private List<DepartmentTree> checkTree(List<DepartmentTree> tree, String name, String deptCode, Integer enabled, Integer deptType) {
      int size = tree.size();

      for (int i = 0; i < size; i++) {
         DepartmentTree departmentTree = tree.get(i);
         if (!departmentTree.getChildren().isEmpty()) {
            this.checkTree(departmentTree.getChildren(), name, deptCode, enabled, deptType);
         }

         boolean empty = departmentTree.getChildren().isEmpty();
         boolean isEnabled = false;
         boolean isDeptType = false;
         boolean isName = false;
         boolean isDeptCode = false;
         if (StrUtil.isNotBlank(name)) {
            isName = !departmentTree.getName().contains(name);
         }

         if (StrUtil.isNotBlank(deptCode) && StrUtil.isNotBlank(departmentTree.getOrgCode())) {
            isDeptCode = !departmentTree.getOrgCode().contains(deptCode);
         }

         if (enabled != null) {
            isEnabled = !departmentTree.getStatus().equals(enabled);
         }

         if (deptType != null) {
            isDeptType = !departmentTree.getDeptType().equals(deptType);
         }

         if (isEnabled || empty && isName || empty && isDeptCode || isDeptType) {
            tree.remove(i);
            i--;
            size--;
         }
      }

      return tree;
   }

   @Override
   public Department selectByUserId(Long userId) {
      Preconditions.checkArgument(userId != null, "用户id不能为空");
      return this.baseMapper.selectByUserId(userId);
   }

   @Override
   public List<DepartmentDTO> departmentListAll() {
      List<Department> departments = this.baseMapper.selectList(null);
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(departments), "部门不存在!");
      return cn.hutool.core.bean.BeanUtil.copyToList(departments, DepartmentDTO.class);
   }

   @Override
   public List<Long> getDepartIdsById(Long id) {
      List<Long> departmentIds = new ArrayList<>();

      for (Department department = this.baseMapper.selectById(id); department != null; department = this.baseMapper.selectById(department.getPid())) {
         departmentIds.add(department.getId());
      }

      return departmentIds;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean setEnabled(Long id, Integer enabled) {
      Department department = this.baseMapper.selectById(id);
      Preconditions.checkArgument(department != null, "禁用失败，对应的部门不存在");
      if (Objects.equals(EnableEnum.DISABLE.getType(), enabled)) {
         List<JobResponseVO> jobList = this.jobMapper
            .getAll()
            .stream()
            .filter(item -> item.getDeptId() == id && item.getEnabled() == EnableEnum.ENABLE.getType())
            .collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isEmpty(jobList), "禁用失败，" + department.getName() + "部门正在岗位被使用!");
      }

      department.setStatus(enabled);
      this.baseMapper.updateById(department);
      return true;
   }

   @Override
   public List<Department> getAllDepartmentList() {
      return this.baseMapper.getAllDepartmentList();
   }

   @Override
   public Department getDepartmentById(Long id) {
      return this.baseMapper.getDepartmentById(id);
   }
}
