package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo.dto.DeptUserResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobSaveRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobUpdateRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.JobUserUpdateDTO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface JobService extends IService<Job> {
   ListVO<JobResponseVO> listByDeptId(Long deptId, Integer enabled);

   PageVO<JobResponseVO> pageByNameAndDeptId(String name, Integer enabled, Integer jobType, String code, Integer pageNumber, Integer pageSize);

   boolean deleteJobs(List<Long> ids);

   boolean updateJob(JobUpdateRequestVO requestVO);

   Long saveJob(JobSaveRequestVO requestVO);

   boolean setEnabled(Long id, Integer enabled);

   Boolean saveJobUser(JobUserUpdateDTO jobUserUpdateDTO);

   DeptUserResponseVO getJobUser(Long jobId);

   void jobExport(Integer enabled, HttpServletResponse response);

   List<JobResponseVO> getAll();
}
