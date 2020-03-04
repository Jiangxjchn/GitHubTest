package Data.DAO;

import java.util.List;

import org.hibernate.query.Query;

import Data.po.User.Customer;
import Data.po.goods.Comment;

public class CommentDAO extends BaseDAO implements InterfaceDAO<Comment>{
	public CommentDAO(){
		
	}
	
	 public List<Comment> findByID(Integer id){
	        try {
	            String HQL="FROM dbo.comment where id="+id;
	            Query query=getSession().createQuery(HQL);
	            List results=query.list();
	            return results;
	        } catch (RuntimeException e){
	            e.printStackTrace();
	            return null;
	        }
	    }
	 public List<Comment> findByHQL(String HQL) {
		 	//System.out.println(HQL);
	        try{
	            Query query=getSession().createQuery(HQL);
	            List<Comment> results=query.list();
	            return results;
	        }catch (RuntimeException e){
	            e.printStackTrace();
	            return null;
	        }
	    }
	@Override
	 public boolean update(Comment comment){
        try{
            getSession().update(comment);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

	@Override
	 public boolean delete(Comment comment){
        try{
            getSession().delete(comment);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }

	@Override
	 public boolean save(Comment comment){
        try{
            getSession().save(comment);
            getSession().flush();
            return true;
        }catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
	
	
}
