package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo.dto.JobResponseVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobMapper extends BaseMapper<Job> {
   Job getByDeptIdAndName(@Param("deptId") Long deptId, @Param("name") String name);

   List<JobResponseVO> listByDeptIdAndNameAndEnabled(
      @Param("deptId") Long deptId,
      @Param("name") String name,
      @Param("enabled") Integer enabled,
      @Param("jobType") Integer jobType,
      @Param("code") String code
   );

   Integer checkJobIsUsed(@Param("jobId") Long jobId);

   List<JobResponseVO> getAll();
}
