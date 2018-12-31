package com.gavin.service;
import java.util.List;
import com.gavin.dao.PageDao;
import com.gavin.entity.Page;
import com.gavin.entity.User;
public class PageService {
	private PageDao pageDao = new PageDao();
	public Page findPage(int page,int pageSize) {
		if (pageDao == null) {
			pageDao = new PageDao();
		}
		List<User> list = pageDao.showNotesByPage(page, pageSize);
		int total = pageDao.getNoteCount();
		Page p1 = new Page();
		p1.setUsers(list);
		p1.setCurrentPage(page);
		p1.setCount(pageSize);
		p1.setTotalCount(total);
		int totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize) + 1;
		p1.setTotalPage(totalPage);
		return p1;
	}
}
