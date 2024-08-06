package com.example.project_FullAuthentication.Service;

import com.example.project_FullAuthentication.Entity.userEntity;
import com.example.project_FullAuthentication.Exception.CommonException;

public interface userService {
     userEntity getUser() throw CommonException;
     void updateUser() throw CommonException;
     void saveUSer() throw CommonException;
     void activeUSer() throw CommonException;
     void deleteuser() throw CommonException;
     void resetPasswordviaEmail() throw CommonException;

}
