package cc.mrbird.febs.auth.mapper;

import cc.mrbird.febs.common.entity.system.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;


public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}