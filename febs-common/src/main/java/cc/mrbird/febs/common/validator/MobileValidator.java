package cc.mrbird.febs.common.validator;

import cc.mrbird.febs.common.annotation.IsMobile;
import cc.mrbird.febs.common.entity.RegexpConstant;
import cc.mrbird.febs.common.utils.FebsUtil;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义参数注解，MobileValidator用于编写具体的校验逻辑
 */
public class MobileValidator implements ConstraintValidator<IsMobile,String> {
    @Override
    public void initialize(IsMobile isMobile) {
    }
    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        try{
            if (StringUtils.isBlank(s)){
                return true;
            }else {
                String regex =  RegexpConstant.MOBILE_REG;
                return FebsUtil.match(regex, s);
            }
        }catch (Exception e){
            return false;
        }

    }
}
