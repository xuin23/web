package com.cloud.auth.core.cloud;

import com.cloud.auth.entity.AuthOperation;
import com.cloud.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 功能操作 provider
 */
@RestController
@RequestMapping(value = "/cloud/authOperation")
public class AuthOperationProvider extends BaseController<AuthOperation> {

}
