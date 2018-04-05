package com.lankheet.iot.datatypes;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import com.lankheet.iot.datatypes.entities.Role;

public class RoleTest {

    @Test
    public void test() {
        Role role = new Role("admin");
        assertThat(role.getPermissionFlags(), is(0x0000));
        assertThat(role.isControlPermissionSet(), is(false));
        role.setControlPermission(true);
        assertThat(role.getPermissionFlags(), is(Role.ROLE_PERMISSION_CONTROL_FLAG));
        assertThat(role.isDeletePermissionSet(), is(false));
        assertThat(role.isControlPermissionSet(), is(true));
        assertThat(role.isModifyPermissionSet(), is(false));
        assertThat(role.isReadPermissionSet(), is(false));
        assertThat(role.isWritePermissionSet(), is(false));
        role.setControlPermission(false);
        assertThat(role.getPermissionFlags(), is(0x0000));
        role.setDeletePermission(true);
        role.setWritePermission(true);
        assertThat(role.isDeletePermissionSet(), is(true));
        assertThat(role.isControlPermissionSet(), is(false));
        assertThat(role.isModifyPermissionSet(), is(false));
        assertThat(role.isReadPermissionSet(), is(false));
        assertThat(role.isWritePermissionSet(), is(true));
        assertThat(role.getPermissionFlags(), is(Role.ROLE_PERMISSION_DELETE_FLAG | Role.ROLE_PERMISSION_WRITE_FLAG));
    }

}
