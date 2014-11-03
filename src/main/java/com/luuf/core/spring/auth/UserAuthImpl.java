package com.luuf.core.spring.auth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.zip.CRC32;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class UserAuthImpl extends JdbcDaoImpl {

	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		List<UserDetails> list = null;
		
		try {
			CRC32 crc = new CRC32();
			crc.update(username.getBytes());
			Long crcVal = crc.getValue();
			
			list = getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] {crcVal.toString(), username}, new RowMapper<UserDetails>() {
	
				@Override
				public UserDetails mapRow(ResultSet rs, int rownum)
						throws SQLException {
					String username= rs.getString(1);
					String password = rs.getString(2);
					boolean enabled = rs.getString(3).equals("1") ? true : false;

					return new User(username, password, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES);
				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}

