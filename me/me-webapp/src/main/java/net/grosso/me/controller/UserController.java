package net.grosso.me.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import net.grosso.me.domain.User;
import net.grosso.me.domain.UserRole;
import net.grosso.me.form.ChangePasswordForm;
import net.grosso.me.form.UserInformationForm;
import net.grosso.me.pageable.SimplePageableImpl;
import net.grosso.me.security.CurrentUserHolder;
import net.grosso.me.service.UserRoleService;
import net.grosso.me.service.UserService;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@Resource
	private UserRoleService userRoleService;
	
	@Resource
	private MessageSource messageSource;

	@RequestMapping("/my-information")
	public String myInformation(ModelMap modelMap) {
		Integer id = CurrentUserHolder.get().getId();
		modelMap.addAttribute("currentUser", userService.findUserById(id));

		return "#my-information";
	}

	@RequestMapping(value = "/edit-information", method = { RequestMethod.GET })
	public String editInformation(ModelMap modelMap) {
		Integer id = CurrentUserHolder.get().getId();
		User current = userService.findUserById(id);
		UserInformationForm form = new UserInformationForm();
		form.setEmails(current.getEmails());
		form.setLastName(current.getLastName());
		form.setFirstName(current.getFirstName());
		form.setGender(current.getGender() == User.Gender.MALE ? "男" : "女");

		modelMap.addAttribute("userInformationForm", form);

		return "#edit-information";
	}

	@RequestMapping(value = "/edit-information", method = { RequestMethod.POST })
	public String editInformation(
			@ModelAttribute("userInformationForm") @Valid UserInformationForm form,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "#edit-information";
		}
		User user = form.toUser();
		user.setId(CurrentUserHolder.get().getId());

		userService.changeInfomations(user);

		return "redirect:/user/my-information";
	}

	@RequestMapping(value = "/change-password", method = { RequestMethod.GET })
	public String changePassword(ModelMap modelMap) {
		modelMap.addAttribute("changePasswordForm", new ChangePasswordForm());
		return "#change-password";
	}

	@RequestMapping(value = "/change-password", method = { RequestMethod.POST })
	public String changePassword(
			@Valid @ModelAttribute("changePasswordForm") ChangePasswordForm form,
			BindingResult bindingResult, ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("hasErrors", true);
			return "#change-password";
		}

		if (!form.getPassword1().equals(form.getPassword2())) {
			bindingResult.reject("jsr303.changepassword.fail");
		}

		if (!userService.exists(CurrentUserHolder.getId(),
				form.getOldPassword())) {
			bindingResult.reject("jsr303.changepassword.oldpwd");
		}

		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("hasErrors", true);
			return "#change-password";
		} else {
			userService.changePassword(CurrentUserHolder.getId(),
					form.getPassword1());
		}

		return "redirect:/user/my-information";
	}

	@RequestMapping(value = "/list-users/{pageNumber}", method = { RequestMethod.GET })
	public ModelAndView listUsers(@PathVariable("pageNumber") Integer pageNumber) {
		Page<User> page = userService.findAll(SimplePageableImpl
				.getInstance(pageNumber));
		ModelAndView mav = new ModelAndView("#list-users");
		mav.addObject("page", page);
		return mav;
	}

	@RequestMapping(value = "/lock/{userId}/current-page/{currentPageNumber}")
	public String lock(@PathVariable("userId") int userId,
			@PathVariable("currentPageNumber") int currentPageNumber,
			Locale locale) {

		if (userService.hasRole(userId, "ROLE_ADMIN")) {
			String msg = messageSource.getMessage("jsr303.lockuser.fail", null,
					locale);
			throw new AccessDeniedException(msg);
		}

		userService.lock(userId);
		return "redirect:/user/list-users/" + currentPageNumber;
	}

	@RequestMapping(value = "/unlock/{userId}/current-page/{currentPageNumber}")
	public String unlock(@PathVariable("userId") int userId,
			@PathVariable("currentPageNumber") int currentPageNumber,
			Locale locale) {

		if (userService.hasRole(userId, "ROLE_ADMIN")) {
			String msg = messageSource.getMessage("jsr303.lockuser.fail", null,
					locale);
			throw new AccessDeniedException(msg);
		}

		userService.unlock(userId);
		return "redirect:/user/list-users/" + currentPageNumber;
	}

	@RequestMapping(value = "/add-user", method = { RequestMethod.GET })
	public String AddUser(@ModelAttribute("addUserForm") User user) {
		return "#add-user";
	}

	@RequestMapping(value = "/add-user", method = { RequestMethod.POST })
	public String AddUser(@ModelAttribute("addUserForm") User user,
			BindingResult bindingResult) {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		userService.save(user);
		return "redirect:/user/list-users/1";
	}

	@RequestMapping(value = "/edit-user/{userId}", method = { RequestMethod.GET })
	public ModelAndView EditUser(@PathVariable("userId") int userId,
			@ModelAttribute("editUser") User editUser) {
		User user = userService.findUserById(userId);
		ModelAndView mav = new ModelAndView("#edit-user");
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping(value = "/edit-user", method = { RequestMethod.POST })
	public String EditUser(@ModelAttribute("editUser") User user,
			BindingResult bindingResult) {
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		try {
			userService.update(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/user/list-users/1";
	}

	@RequestMapping(value = "/delete-user/{userId}", method = { RequestMethod.GET })
	public String DeleteUser(@PathVariable("userId") int userId) {
		userService.deleteUserAndRole(userId);
		return "redirect:/user/list-users/1";
	}

	@RequestMapping(value = "/list-roles", method = { RequestMethod.GET })
	public ModelAndView listRoles() {
		List<UserRole> userRoleList=null;
		try {
			userRoleList=userRoleService.getAllUserRoles();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("#list-roles");
		mav.addObject("userRoleList",userRoleList);
		return mav;
	}
}
