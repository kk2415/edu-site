package com.onoffmix.yonsei.domain.entity.user.role;

import lombok.Getter;

import java.util.List;

@Getter
public enum Role {

	STUDENT("ROLE_STUDENT", Authority.READ_COURSE,
			Authority.READ_PLAYLIST, Authority.WRITE_PLAYLIST,
			Authority.WRITE_COMMENT, Authority.READ_COMMENT),

	PROFESSOR("ROLE_PROFESSOR", Authority.READ_COURSE, Authority.WRITE_COURSE,
			Authority.READ_PLAYLIST, Authority.WRITE_PLAYLIST,
			Authority.WRITE_COMMENT, Authority.READ_COMMENT),

	INSIDER("ROLE_INSIDER", Authority.READ_COURSE,
			Authority.READ_PLAYLIST, Authority.WRITE_PLAYLIST,
			Authority.WRITE_COMMENT, Authority.READ_COMMENT),

	DISPATCH_OUTSIDER("ROLE_DISPATCH_OUTSIDER", Authority.READ_COURSE,
			Authority.READ_PLAYLIST, Authority.WRITE_PLAYLIST,
			Authority.WRITE_COMMENT, Authority.READ_COMMENT),

	OUTSIDER("ROLE_OUTSIDER", Authority.READ_COURSE,
			Authority.READ_PLAYLIST, Authority.WRITE_PLAYLIST,
			Authority.WRITE_COMMENT, Authority.READ_COMMENT),

	ADMIN("ROLE_ADMIN", Authority.READ_COURSE, Authority.WRITE_COURSE,
			Authority.READ_PLAYLIST, Authority.WRITE_PLAYLIST,
			Authority.WRITE_COMMENT, Authority.READ_COMMENT),
	;

	private final String name;
	private final List<Authority> authorities;

	Role(String name, Authority... defaultAuthorities) {
		this.name = name;
		this.authorities = List.of(defaultAuthorities);
	}
}
