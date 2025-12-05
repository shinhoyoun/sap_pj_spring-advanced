package org.example.expert.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserChangePasswordRequest {

    @NotBlank
    private String oldPassword;

    @NotBlank
    @Size(min = 8, message = "비밀번호는 8자 이상이어야 합니다.")
    @Pattern(regexp = (".*\\d.*"), message = "비밀번호에는 숫자가 포함되어 있어야 합니다.")
    @Pattern(regexp = (".*[A-Z].*"), message = "비밀번호에는 대문자가 포함되어 있어야 합니다.")
    private String newPassword;
}

/**
 *  if (userChangePasswordRequest.getNewPassword().length() < 8 ||
 *                 !userChangePasswordRequest.getNewPassword().matches(".*\\d.*") ||
 *                 !userChangePasswordRequest.getNewPassword().matches(".*[A-Z].*")) {
 *             throw new InvalidRequestException("새 비밀번호는 8자 이상이어야 하고, 숫자와 대문자를 포함해야 합니다.");
 */

/**
 * // null, "", " " 허용 X
 * @NotBlank (message = " ")
 *
 * // 데이터의 사이즈(최소 길이, 최대 길이) 설정
 * @Size(min=, max= ,message="")
 *
 * // 정규식을 이용해서 검사
 * @Pattern(regexp = ,message="")
 */