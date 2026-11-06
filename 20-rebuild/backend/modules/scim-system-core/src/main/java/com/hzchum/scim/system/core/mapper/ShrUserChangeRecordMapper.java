package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.ShrUserChangeRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShrUserChangeRecordMapper extends BaseMapper<ShrUserChangeRecord> {
   List<ShrUserChangeRecord> getAll(
      @Param("deptName") String deptName,
      @Param("jobName") String jobName,
      @Param("name") String name,
      @Param("phone") String phone,
      @Param("userType") Integer userType,
      @Param("crudType") Integer crudType
   );
}
