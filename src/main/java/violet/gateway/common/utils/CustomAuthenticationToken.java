package violet.gateway.common.utils;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {

    @Getter
    private final Long userId;
    private final Object principal;

    public CustomAuthenticationToken(Long userId, Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.userId = userId;
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}