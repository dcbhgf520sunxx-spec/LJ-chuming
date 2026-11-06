package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentSaveRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentSimpleTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentTree;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentUpdateRequestVO;
import java.util.List;

public interface DepartmentService extends IService<Department> {
   DepartmentDTO getDepartment(Long id);

   DepartmentDTO getDepartmentByUserId(Long userId);

   List<DepartmentTree> getDepartmentTree(String name, String deptCode, Integer enabled, Integer deptType);

   ListVO<DepartmentTree> listDepartment(String name, String deptCode, Integer enabled, Integer deptType);

   Long saveDepartment(DepartmentSaveRequestVO requestVO);

   boolean updateDepartment(DepartmentUpdateRequestVO requestVO);

   List<DepartmentSimpleTreeResponseVO> getDepartmentSimpleTree(Boolean hasRoot);

   List<DepartmentSimpleTreeResponseVO> getSHRDepartmentSimpleTree(Boolean hasRoot);

   String getDeptPath(Long id);

   Department selectByUserId(Long userId);

   List<DepartmentDTO> departmentListAll();

   boolean setEnabled(Long id, Integer enabled);

   List<Department> getAllDepartmentList();

   Department getDepartmentById(Long id);

   List<Long> getDepartIdsById(Long userId);
}
