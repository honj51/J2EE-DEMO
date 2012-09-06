package net.yingzhuo.me.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.yingzhuo.me.dao.ContactDao;
import net.yingzhuo.me.dao.GroupDao;
import net.yingzhuo.me.dao.UserDao;
import net.yingzhuo.me.domain.Contact;
import net.yingzhuo.me.domain.Group;
import net.yingzhuo.me.domain.User;
import net.yingzhuo.me.service.ContactService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Resource private GroupDao groupDao;
	@Resource private UserDao userDao;
	@Resource private ContactDao contactDao;

	@Override
	public List<Group> findAllGroups(String username) {
		return groupDao.findByOwnerUsername(username);
	}

	@Override
	public User findUserById(Integer id) {
		return userDao.findOne(id);
	}

	@Override
	public void saveGroup(Group group) {
		groupDao.save(group);
	}

	@Override
	public boolean isGroupOwner(int groupId, String username) {
		List<Group> groups = groupDao.findByOwnerUsername(username);
		for (Group g : groups) {
			if (g.getId() == groupId) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteGroup(int groupId) {
		groupDao.delete(groupId);
	}

	@Override
	public Page<Contact> findContacts(String username, Pageable pageable) {
		return contactDao.findByOwnerUsername(username, pageable);
	}

	@Override
	public boolean isContactOwner(int contactId, String username) {
		List<Contact> list = contactDao.findByOwnerUsername(username);
		for (Contact c : list) {
			if (c.getId() == contactId) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isGroupEmpty(String username, int groupId) {
		return contactDao.countByOwnerUsernameAndGroupId(username, groupId) == 0L;
	}

	@Override
	public void deleteContact(int contactId) {
		contactDao.delete(contactId);
	}

	@Override
	public void saveContact(Contact contact) {
		contactDao.save(contact);
	}

	@Override
	public Group findGroupById(Integer groupId) {
		return groupDao.findOne(groupId);
	}
}
