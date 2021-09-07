package cc.mrbird.febs.auth.service;



import cc.mrbird.febs.auth.manager.UserManager;
import cc.mrbird.febs.common.entity.FebsAuthUser;
import cc.mrbird.febs.common.entity.system.SystemUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class FebsUserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    //loadUserByUsername方法返回一个UserDetails对象，该对象也是一个接口，包含一些用于描述用户信息的方法，源码如下：
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        FebsAuthUser user = new FebsAuthUser();
//        user.setUsername(username);
//        user.setPassword(this.passwordEncoder.encode("123456"));
//
//        return new User(username, user.getPassword(), user.isEnabled(),
//                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
//                user.isAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList("user:add"));
//}
    @Autowired
    private UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = userManager.findByName(username);
        System.out.println(systemUser);
        if (systemUser != null) {
            String permissions = userManager.findUserPermissions(systemUser.getUsername());
            boolean notLocked = false;
            if (StringUtils.equals(SystemUser.STATUS_VALID, systemUser.getStatus()))
                notLocked = true;
            FebsAuthUser authUser = new FebsAuthUser(systemUser.getUsername(), systemUser.getPassword(), true, true, true, notLocked,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
            System.out.println(authUser);
            BeanUtils.copyProperties(systemUser,authUser);
            return authUser;
            //return transSystemUserToAuthUser(authUser,systemUser);
        } else {
            throw new UsernameNotFoundException("");
        }
    }

    /**
     *
     * @param authUser
     * @param systemUser
     * @return
     *简化代码
     */
//    private FebsAuthUser transSystemUserToAuthUser(FebsAuthUser authUser, SystemUser systemUser) {
//        authUser.setAvatar(systemUser.getAvatar());
//        authUser.setDeptId(systemUser.getDeptId());
//        authUser.setDeptName(systemUser.getDeptName());
//        authUser.setEmail(systemUser.getEmail());
//        authUser.setMobile(systemUser.getMobile());
//        authUser.setRoleId(systemUser.getRoleId());
//        authUser.setRoleName(systemUser.getRoleName());
//        authUser.setSex(systemUser.getSex());
//        authUser.setUserId(systemUser.getUserId());
//        authUser.setLastLoginTime(systemUser.getLastLoginTime());
//        authUser.setDescription(systemUser.getDescription());
//        authUser.setStatus(systemUser.getStatus());
//        return authUser;
//    }

}
