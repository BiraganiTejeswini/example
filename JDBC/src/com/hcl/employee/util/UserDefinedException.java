package com.hcl.employee.util;

import java.util.*;
public class UserDefinedException extends Exception
{private static final long serialVersionUID = 1L;
private String msg;
public UserDefinedException(String msg) {
 this.msg=msg;
}
public String getMessage() {
 return msg;
}

}
