package com.hzchum.scim.rest.handler;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.exception.ParameterExpireException;
import com.hzchum.pangu.common.exception.ServerExpireException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import java.util.stream.Collectors;
import javax.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
   private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

   @ExceptionHandler(IllegalArgumentException.class)
   @ResponseStatus(HttpStatus.OK)
   @ResponseBody
   public ResultVO handleIllegalArgumentException(Exception e) {
      log.error("业务异常处理-------------------->", e);
      return ResultBuilder.failed(e.getMessage(), ResultCodeEnum.ERROR);
   }

   @ExceptionHandler(MethodArgumentNotValidException.class)
   @ResponseStatus(HttpStatus.OK)
   @ResponseBody
   public ResultVO methodArgumentNotValidException(Exception e) {
      log.error("方法参数校验失败异常处理-------------------->", e);
      return ResultBuilder.failed(((MethodArgumentNotValidException)e).getBindingResult().getFieldError().getDefaultMessage(), ResultCodeEnum.ERROR);
   }

   @ExceptionHandler({BindException.class, MissingServletRequestParameterException.class})
   @ResponseBody
   public ResultVO handleBindException(BindException e) {
      StringBuilder sb = new StringBuilder("参数错误：[");
      sb.append(e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining()));
      sb.append(']');
      return ResultBuilder.failed(sb.toString(), ResultCodeEnum.PARAMETER_MISSING);
   }

   @ExceptionHandler(BusinessException.class)
   @ResponseStatus(HttpStatus.OK)
   @ResponseBody
   public ResultVO handleBusinessException(BusinessException e) {
      log.error("初鸣业务异常处理-------------------->", e);
      return e.getResult();
   }

   @ExceptionHandler(Exception.class)
   @ResponseStatus(HttpStatus.OK)
   @ResponseBody
   public ResultVO handleException(Exception e) {
      if (e instanceof AccessDeniedException) {
         return ResultBuilder.failed("无权限访问", ResultCodeEnum.ERROR);
      }

      log.error("通用异常处理-------------------->", e);
      return ResultBuilder.failed(ResultCodeEnum.INTERNAL_SERVER_ERROR);
   }

   @ExceptionHandler(DuplicateKeyException.class)
   @ResponseStatus(HttpStatus.OK)
   @ResponseBody
   public ResultVO handleDuplicateKeyException(DuplicateKeyException e) {
      log.error("通用异常处理-------------------->", e);
      return ResultBuilder.failed(ResultCodeEnum.ABNORMAL_DATA_DUPLICATION);
   }

   @ExceptionHandler(ValidationException.class)
   @ResponseBody
   public ResultVO methodArgumentNotValidException2(ValidationException e) {
      log.error("方法参数校验失败异常处理-------------------->", e);
      String message = null;
      if (StringUtils.isNotBlank(e.getMessage())) {
         String s = StringUtils.split(e.getMessage(), ",")[0];
         message = StringUtils.split(s, ":")[1];
      }

      return ResultBuilder.failed(StringUtils.isNotBlank(e.getMessage()) ? message : ResultCodeEnum.INTERNAL_SERVER_ERROR.getMessage(), ResultCodeEnum.ERROR);
   }

   @ExceptionHandler(ServerExpireException.class)
   @ResponseBody
   public ResultVO handleDuplicateKeyException(Exception e) {
      log.error("通用异常处理-------------------->", e);
      return ResultBuilder.failed(ResultCodeEnum.SERVER_EXPIRE_ERROR);
   }

   @ExceptionHandler(ParameterExpireException.class)
   @ResponseBody
   public ResultVO handleParameterExpireException(ParameterExpireException e) {
      log.error("参数过期异常处理-------------------->", e);
      return e.getResult();
   }
}
