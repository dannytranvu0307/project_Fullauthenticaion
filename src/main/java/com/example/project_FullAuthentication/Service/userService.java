package com.example.project_FullAuthentication.Service;

import com.example.project_FullAuthentication.Entity.User;
import com.example.project_FullAuthentication.Exception.CommonException;

public interface userService {
     User getUser() throws CommonException;
     void updateUser() throws CommonException;
     void saveUSer() throws CommonException;
     void activeUSer() throws CommonException;
     void deleteuser() throws CommonException;
     void resetPasswordviaEmail() throws CommonException;

}
