package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.AuthOperation;
import com.cloud.common.base.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 功能操作 provider
 */
@Slf4j
@RestController
@RequestMapping(value = "/cloud/authOperation")
public class AuthOperationProvider extends BaseController<AuthOperation> {

}
