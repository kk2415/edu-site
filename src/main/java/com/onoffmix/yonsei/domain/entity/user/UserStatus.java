package com.onoffmix.yonsei.domain.entity.user;

public enum UserStatus {
	WAIT, ACCEPTED, DENIED;

	public boolean isOk() {
		return this == ACCEPTED;
	}
}
