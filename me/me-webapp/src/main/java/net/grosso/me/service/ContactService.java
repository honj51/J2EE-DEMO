package net.grosso.me.service;

import java.util.List;

import net.grosso.me.domain.Contact;
import net.grosso.me.domain.Group;
import net.grosso.me.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface ContactService {

	public List<Group> findAllGroups(String username);
	
	public User findUserById(Integer id);
	
	@Transactional
	public void saveGroup(Group group);

	public boolean isGroupOwner(int groupId, String username);
	
	public boolean isContactOwner(int contactId, String username);
	
	public boolean isGroupEmpty(String username, int groupId);
	
	public Group findGroupById(Integer groupId);

	@Transactional
	public void deleteGroup(int groupId);

	public Page<Contact> findContacts(String username, Pageable pageable);

	@Transactional
	public void deleteContact(int contactId);
	
	@Transactional
	public void saveContact(Contact contact);
}
